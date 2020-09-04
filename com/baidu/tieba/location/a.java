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
/* loaded from: classes17.dex */
public class a implements com.baidu.adp.lib.c.b {
    private static a jUP = null;
    private LocationClient dAk;
    private C0738a jUS;
    private LocationClientOption jUT;
    private Address lastAddress;
    private Context mContext;
    private boolean PO = true;
    private String jUQ = "";
    private a.b jUR = null;
    private long lastLocationTime = 0;
    private boolean jUU = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.m.a.TR() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.mf().a(a.cOa());
                        } else {
                            com.baidu.adp.lib.c.a.mf().b(a.cOa());
                        }
                    }
                }
            }
        });
    }

    public static a cOa() {
        if (jUP == null) {
            synchronized (a.class) {
                if (jUP == null) {
                    jUP = new a();
                }
            }
        }
        return jUP;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.jUR = bVar;
        this.jUQ = "baidu";
        if (this.PO) {
            try {
                this.dAk = new LocationClient(this.mContext);
                this.jUT = new LocationClientOption();
                this.jUT.setOpenGps(true);
                this.jUT.setIgnoreKillProcess(true);
                this.jUT.setProdName(this.jUQ);
                this.jUT.setAddrType("all");
                this.jUT.setCoorType("bd09ll");
                this.jUS = new C0738a();
                this.dAk.registerLocationListener(this.jUS);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.m.a.TR() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.PO && this.dAk != null) {
            try {
                this.jUU = z;
                if (z) {
                    this.jUT.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.dAk.setLocOption(this.jUT);
                if (!this.dAk.isStarted()) {
                    this.dAk.start();
                }
                this.dAk.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.jUR != null) {
                    this.jUR.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.jUU);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void destroy() {
        stopLocation();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    private class C0738a implements BDLocationListener {
        private C0738a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.m.a.TR() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.stopLocation();
                a.this.lastAddress = new Address(Locale.getDefault());
                a.this.lastAddress.setLatitude(bDLocation.getLatitude());
                a.this.lastAddress.setLongitude(bDLocation.getLongitude());
                com.baidu.tbadk.core.sharedPref.b.bik().putString("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + Constants.ACCEPT_TIME_SEPARATOR_SP + bDLocation.getLongitude());
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
                if (a.this.jUR != null) {
                    a.this.jUR.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.jUU);
                    com.baidu.tieba.recapp.d.a.dnZ().Ki(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.d.a.dnZ().Kh(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.d.a.dnZ().fQ(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.dAk != null && this.dAk.isStarted()) {
            try {
                this.dAk.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
