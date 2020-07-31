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
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ad;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes17.dex */
public class a implements com.baidu.adp.lib.c.b {
    private static a jFq = null;
    private LocationClient dqe;
    private C0687a jFt;
    private LocationClientOption jFu;
    private Address lastAddress;
    private Context mContext;
    private boolean Pg = true;
    private String jFr = "";
    private a.b jFs = null;
    private long lastLocationTime = 0;
    private boolean jFv = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.i.a.NX() || ad.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.kG().a(a.cDi());
                        } else {
                            com.baidu.adp.lib.c.a.kG().b(a.cDi());
                        }
                    }
                }
            }
        });
    }

    public static a cDi() {
        if (jFq == null) {
            synchronized (a.class) {
                if (jFq == null) {
                    jFq = new a();
                }
            }
        }
        return jFq;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.jFs = bVar;
        this.jFr = "baidu";
        if (this.Pg) {
            try {
                this.dqe = new LocationClient(this.mContext);
                this.jFu = new LocationClientOption();
                this.jFu.setOpenGps(true);
                this.jFu.setIgnoreKillProcess(true);
                this.jFu.setProdName(this.jFr);
                this.jFu.setAddrType(SchemeCollecter.CLASSIFY_ALL);
                this.jFu.setCoorType("bd09ll");
                this.jFt = new C0687a();
                this.dqe.registerLocationListener(this.jFt);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.i.a.NX() || ad.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.Pg && this.dqe != null) {
            try {
                this.jFv = z;
                if (z) {
                    this.jFu.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.dqe.setLocOption(this.jFu);
                if (!this.dqe.isStarted()) {
                    this.dqe.start();
                }
                this.dqe.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.jFs != null) {
                    this.jFs.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.jFv);
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
    private class C0687a implements BDLocationListener {
        private C0687a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.i.a.NX() || ad.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.stopLocation();
                a.this.lastAddress = new Address(Locale.getDefault());
                a.this.lastAddress.setLatitude(bDLocation.getLatitude());
                a.this.lastAddress.setLongitude(bDLocation.getLongitude());
                com.baidu.tbadk.core.sharedPref.b.aZP().putString("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + Constants.ACCEPT_TIME_SEPARATOR_SP + bDLocation.getLongitude());
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
                if (a.this.jFs != null) {
                    a.this.jFs.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.jFv);
                    com.baidu.tieba.recapp.d.a.dcN().Hp(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.d.a.dcN().Ho(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.d.a.dcN().fC(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.dqe != null && this.dqe.isStarted()) {
            try {
                this.dqe.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
