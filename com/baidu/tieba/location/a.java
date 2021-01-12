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
import com.baidu.tbadk.core.util.ad;
import java.util.Locale;
/* loaded from: classes7.dex */
public class a implements com.baidu.adp.lib.c.b {
    private static a kZD = null;
    private LocationClient emh;
    private C0782a kZG;
    private LocationClientOption kZH;
    private Address lastAddress;
    private Context mContext;
    private boolean Rv = true;
    private String kZE = "";
    private a.b kZF = null;
    private long lastLocationTime = 0;
    private boolean kZI = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.l.a.abt() || ad.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.lI().a(a.dbE());
                        } else {
                            com.baidu.adp.lib.c.a.lI().b(a.dbE());
                        }
                    }
                }
            }
        });
    }

    public static a dbE() {
        if (kZD == null) {
            synchronized (a.class) {
                if (kZD == null) {
                    kZD = new a();
                }
            }
        }
        return kZD;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.kZF = bVar;
        this.kZE = "baidu";
        if (this.Rv) {
            try {
                this.emh = new LocationClient(this.mContext);
                this.kZH = new LocationClientOption();
                this.kZH.setOpenGps(true);
                this.kZH.setIgnoreKillProcess(true);
                this.kZH.setProdName(this.kZE);
                this.kZH.setAddrType("all");
                this.kZH.setCoorType("bd09ll");
                this.kZG = new C0782a();
                this.emh.registerLocationListener(this.kZG);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.l.a.abt() || ad.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.Rv && this.emh != null) {
            try {
                this.kZI = z;
                if (z) {
                    this.kZH.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.emh.setLocOption(this.kZH);
                if (!this.emh.isStarted()) {
                    this.emh.start();
                }
                this.emh.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.kZF != null) {
                    this.kZF.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.kZI);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void destroy() {
        stopLocation();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0782a implements BDLocationListener {
        private C0782a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.l.a.abt() || ad.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.stopLocation();
                a.this.lastAddress = new Address(Locale.getDefault());
                a.this.lastAddress.setLatitude(bDLocation.getLatitude());
                a.this.lastAddress.setLongitude(bDLocation.getLongitude());
                com.baidu.tbadk.core.sharedPref.b.brx().putString("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
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
                if (a.this.kZF != null) {
                    a.this.kZF.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.kZI);
                    com.baidu.tieba.recapp.c.a.dBW().QI(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.c.a.dBW().QH(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.c.a.dBW().hw(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.emh != null && this.emh.isStarted()) {
            try {
                this.emh.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
