package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import java.util.Locale;
/* loaded from: classes5.dex */
public class a implements com.baidu.adp.lib.d.b {
    private static a hkw = null;
    private LocationClient bnw;
    private LocationClientOption hkA;
    private C0356a hkz;
    private Context mContext;
    private Address zZ;
    private boolean FB = true;
    private String hkx = "";
    private a.b hky = null;
    private long zT = 0;
    private boolean hkB = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.e.a.uD() || ab.cw(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.hY().a(a.bLT());
                        } else {
                            com.baidu.adp.lib.d.a.hY().b(a.bLT());
                        }
                    }
                }
            }
        });
    }

    public static a bLT() {
        if (hkw == null) {
            synchronized (a.class) {
                if (hkw == null) {
                    hkw = new a();
                }
            }
        }
        return hkw;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.hky = bVar;
        this.hkx = "baidu";
        if (this.FB) {
            try {
                this.bnw = new LocationClient(this.mContext);
                this.hkA = new LocationClientOption();
                this.hkA.setOpenGps(true);
                this.hkA.setIgnoreKillProcess(true);
                this.hkA.setProdName(this.hkx);
                this.hkA.setAddrType("all");
                this.hkA.setCoorType("bd09ll");
                this.hkz = new C0356a();
                this.bnw.registerLocationListener(this.hkz);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void Z(boolean z) {
        if ((!com.baidu.e.a.uD() || ab.cw(TbadkCoreApplication.getInst())) && this.FB && this.bnw != null) {
            try {
                this.hkB = z;
                if (z) {
                    this.hkA.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.bnw.setLocOption(this.hkA);
                if (!this.bnw.isStarted()) {
                    this.bnw.start();
                }
                this.bnw.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                ic();
                if (this.hky != null) {
                    this.hky.a(5, "", this.zZ, this.zT, this.hkB);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        ic();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0356a implements BDLocationListener {
        private C0356a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.e.a.uD() || ab.cw(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.ic();
                a.this.zZ = new Address(Locale.getDefault());
                a.this.zZ.setLatitude(bDLocation.getLatitude());
                a.this.zZ.setLongitude(bDLocation.getLongitude());
                a.this.zZ.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                a.this.zZ.setExtras(bundle);
                a.this.zT = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.zZ.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.hky != null) {
                    a.this.hky.a(0, "", a.this.zZ, a.this.zT, a.this.hkB);
                    com.baidu.tieba.recapp.d.a.ciL().yD(String.valueOf(a.this.zZ.getLatitude()));
                    com.baidu.tieba.recapp.d.a.ciL().yC(String.valueOf(a.this.zZ.getLongitude()));
                    com.baidu.tieba.recapp.d.a.ciL().et(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void ic() {
        if (this.bnw != null && this.bnw.isStarted()) {
            try {
                this.bnw.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
