package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ae;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes23.dex */
public class a implements com.baidu.adp.lib.c.b {
    private static a ksF = null;
    private LocationClient dOm;
    private C0753a ksI;
    private LocationClientOption ksJ;
    private Address lastAddress;
    private Context mContext;
    private boolean Qy = true;
    private String ksG = "";
    private a.b ksH = null;
    private long lastLocationTime = 0;
    private boolean ksK = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.m.a.Wx() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.mk().a(a.cVp());
                        } else {
                            com.baidu.adp.lib.c.a.mk().b(a.cVp());
                        }
                    }
                }
            }
        });
    }

    public static a cVp() {
        if (ksF == null) {
            synchronized (a.class) {
                if (ksF == null) {
                    ksF = new a();
                }
            }
        }
        return ksF;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.ksH = bVar;
        this.ksG = "baidu";
        if (this.Qy) {
            try {
                this.dOm = new LocationClient(this.mContext);
                this.ksJ = new LocationClientOption();
                this.ksJ.setOpenGps(true);
                this.ksJ.setIgnoreKillProcess(true);
                this.ksJ.setProdName(this.ksG);
                this.ksJ.setAddrType("all");
                this.ksJ.setCoorType("bd09ll");
                this.ksI = new C0753a();
                this.dOm.registerLocationListener(this.ksI);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.m.a.Wx() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.Qy && this.dOm != null) {
            try {
                this.ksK = z;
                if (z) {
                    this.ksJ.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.dOm.setLocOption(this.ksJ);
                if (!this.dOm.isStarted()) {
                    this.dOm.start();
                }
                this.dOm.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.ksH != null) {
                    this.ksH.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.ksK);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void destroy() {
        stopLocation();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private class C0753a implements BDLocationListener {
        private C0753a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.m.a.Wx() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.stopLocation();
                a.this.lastAddress = new Address(Locale.getDefault());
                a.this.lastAddress.setLatitude(bDLocation.getLatitude());
                a.this.lastAddress.setLongitude(bDLocation.getLongitude());
                com.baidu.tbadk.core.sharedPref.b.blO().putString("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + Constants.ACCEPT_TIME_SEPARATOR_SP + bDLocation.getLongitude());
                a.this.lastAddress.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                a.this.lastAddress.setExtras(bundle);
                a.this.lastLocationTime = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.lastAddress.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.ksH != null) {
                    a.this.ksH.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.ksK);
                    com.baidu.tieba.recapp.d.a.dvt().Lz(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.d.a.dvt().Ly(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.d.a.dvt().gw(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.dOm != null && this.dOm.isStarted()) {
            try {
                this.dOm.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
