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
import com.baidu.tbadk.core.util.ac;
import java.util.Locale;
/* loaded from: classes3.dex */
public class a implements com.baidu.adp.lib.d.b {
    private static a eVa = null;
    private C0192a eVd;
    private LocationClient eVe;
    private LocationClientOption eVf;
    private Context mContext;
    private Address zg;
    private boolean EE = true;
    private String eVb = "";
    private a.b eVc = null;
    private long za = 0;
    private boolean eVg = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.e.a.rg() || ac.aL(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.hB().a(a.aSH());
                        } else {
                            com.baidu.adp.lib.d.a.hB().b(a.aSH());
                        }
                    }
                }
            }
        });
    }

    public static a aSH() {
        if (eVa == null) {
            synchronized (a.class) {
                if (eVa == null) {
                    eVa = new a();
                }
            }
        }
        return eVa;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.eVc = bVar;
        this.eVb = "baidu";
        if (this.EE) {
            try {
                this.eVe = new LocationClient(this.mContext);
                this.eVf = new LocationClientOption();
                this.eVf.setOpenGps(true);
                this.eVf.setIgnoreKillProcess(true);
                this.eVf.setProdName(this.eVb);
                this.eVf.setAddrType("all");
                this.eVf.setCoorType(BDLocation.BDLOCATION_GCJ02_TO_BD09LL);
                this.eVd = new C0192a();
                this.eVe.registerLocationListener(this.eVd);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void J(boolean z) {
        if ((!com.baidu.e.a.rg() || ac.aL(TbadkCoreApplication.getInst())) && this.EE && this.eVe != null) {
            try {
                this.eVg = z;
                if (z) {
                    this.eVf.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.eVe.setLocOption(this.eVf);
                if (!this.eVe.isStarted()) {
                    this.eVe.start();
                }
                this.eVe.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                hF();
                if (this.eVc != null) {
                    this.eVc.a(5, "", this.zg, this.za, this.eVg);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        hF();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0192a implements BDLocationListener {
        private C0192a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.e.a.rg() || ac.aL(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.hF();
                a.this.zg = new Address(Locale.getDefault());
                a.this.zg.setLatitude(bDLocation.getLatitude());
                a.this.zg.setLongitude(bDLocation.getLongitude());
                a.this.zg.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                a.this.zg.setExtras(bundle);
                a.this.za = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.zg.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.eVc != null) {
                    a.this.eVc.a(0, "", a.this.zg, a.this.za, a.this.eVg);
                    com.baidu.tieba.recapp.d.a.boe().nT(String.valueOf(a.this.zg.getLatitude()));
                    com.baidu.tieba.recapp.d.a.boe().nS(String.valueOf(a.this.zg.getLongitude()));
                    com.baidu.tieba.recapp.d.a.boe().cO(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void hF() {
        if (this.eVe != null && this.eVe.isStarted()) {
            try {
                this.eVe.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
