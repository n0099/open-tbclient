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
    private static a kFc = null;
    private LocationClient dWJ;
    private C0768a kFf;
    private LocationClientOption kFg;
    private Address lastAddress;
    private Context mContext;
    private boolean Qz = true;
    private String kFd = "";
    private a.b kFe = null;
    private long lastLocationTime = 0;
    private boolean kFh = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.m.a.Yr() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.mk().a(a.cYx());
                        } else {
                            com.baidu.adp.lib.c.a.mk().b(a.cYx());
                        }
                    }
                }
            }
        });
    }

    public static a cYx() {
        if (kFc == null) {
            synchronized (a.class) {
                if (kFc == null) {
                    kFc = new a();
                }
            }
        }
        return kFc;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.kFe = bVar;
        this.kFd = "baidu";
        if (this.Qz) {
            try {
                this.dWJ = new LocationClient(this.mContext);
                this.kFg = new LocationClientOption();
                this.kFg.setOpenGps(true);
                this.kFg.setIgnoreKillProcess(true);
                this.kFg.setProdName(this.kFd);
                this.kFg.setAddrType("all");
                this.kFg.setCoorType("bd09ll");
                this.kFf = new C0768a();
                this.dWJ.registerLocationListener(this.kFf);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.m.a.Yr() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.Qz && this.dWJ != null) {
            try {
                this.kFh = z;
                if (z) {
                    this.kFg.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.dWJ.setLocOption(this.kFg);
                if (!this.dWJ.isStarted()) {
                    this.dWJ.start();
                }
                this.dWJ.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.kFe != null) {
                    this.kFe.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.kFh);
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
    private class C0768a implements BDLocationListener {
        private C0768a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.m.a.Yr() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.stopLocation();
                a.this.lastAddress = new Address(Locale.getDefault());
                a.this.lastAddress.setLatitude(bDLocation.getLatitude());
                a.this.lastAddress.setLongitude(bDLocation.getLongitude());
                com.baidu.tbadk.core.sharedPref.b.bnH().putString("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + Constants.ACCEPT_TIME_SEPARATOR_SP + bDLocation.getLongitude());
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
                if (a.this.kFe != null) {
                    a.this.kFe.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.kFh);
                    com.baidu.tieba.recapp.d.a.dyA().LX(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.d.a.dyA().LW(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.d.a.dyA().gx(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.dWJ != null && this.dWJ.isStarted()) {
            try {
                this.dWJ.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
