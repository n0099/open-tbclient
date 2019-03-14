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
    private static a gMg = null;
    private Address Cm;
    private LocationClient bgA;
    private C0333a gMj;
    private LocationClientOption gMk;
    private Context mContext;
    private boolean HK = true;
    private String gMh = "";
    private a.b gMi = null;
    private long Cg = 0;
    private boolean gMl = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.e.a.tt() || ab.cQ(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.iW().a(a.bBn());
                        } else {
                            com.baidu.adp.lib.d.a.iW().b(a.bBn());
                        }
                    }
                }
            }
        });
    }

    public static a bBn() {
        if (gMg == null) {
            synchronized (a.class) {
                if (gMg == null) {
                    gMg = new a();
                }
            }
        }
        return gMg;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.gMi = bVar;
        this.gMh = "baidu";
        if (this.HK) {
            try {
                this.bgA = new LocationClient(this.mContext);
                this.gMk = new LocationClientOption();
                this.gMk.setOpenGps(true);
                this.gMk.setIgnoreKillProcess(true);
                this.gMk.setProdName(this.gMh);
                this.gMk.setAddrType("all");
                this.gMk.setCoorType("bd09ll");
                this.gMj = new C0333a();
                this.bgA.registerLocationListener(this.gMj);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void ah(boolean z) {
        if ((!com.baidu.e.a.tt() || ab.cQ(TbadkCoreApplication.getInst())) && this.HK && this.bgA != null) {
            try {
                this.gMl = z;
                if (z) {
                    this.gMk.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.bgA.setLocOption(this.gMk);
                if (!this.bgA.isStarted()) {
                    this.bgA.start();
                }
                this.bgA.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                ja();
                if (this.gMi != null) {
                    this.gMi.a(5, "", this.Cm, this.Cg, this.gMl);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        ja();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0333a implements BDLocationListener {
        private C0333a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.e.a.tt() || ab.cQ(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.ja();
                a.this.Cm = new Address(Locale.getDefault());
                a.this.Cm.setLatitude(bDLocation.getLatitude());
                a.this.Cm.setLongitude(bDLocation.getLongitude());
                a.this.Cm.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                a.this.Cm.setExtras(bundle);
                a.this.Cg = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.Cm.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.gMi != null) {
                    a.this.gMi.a(0, "", a.this.Cm, a.this.Cg, a.this.gMl);
                    com.baidu.tieba.recapp.d.a.bXz().wC(String.valueOf(a.this.Cm.getLatitude()));
                    com.baidu.tieba.recapp.d.a.bXz().wB(String.valueOf(a.this.Cm.getLongitude()));
                    com.baidu.tieba.recapp.d.a.bXz().dL(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void ja() {
        if (this.bgA != null && this.bgA.isStarted()) {
            try {
                this.bgA.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
