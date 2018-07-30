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
    private static a eVf = null;
    private C0192a eVi;
    private LocationClient eVj;
    private LocationClientOption eVk;
    private Context mContext;
    private Address zf;
    private boolean EE = true;
    private String eVg = "";
    private a.b eVh = null;
    private long yZ = 0;
    private boolean eVl = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.e.a.rj() || ac.aM(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.hB().a(a.aSK());
                        } else {
                            com.baidu.adp.lib.d.a.hB().b(a.aSK());
                        }
                    }
                }
            }
        });
    }

    public static a aSK() {
        if (eVf == null) {
            synchronized (a.class) {
                if (eVf == null) {
                    eVf = new a();
                }
            }
        }
        return eVf;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.eVh = bVar;
        this.eVg = "baidu";
        if (this.EE) {
            try {
                this.eVj = new LocationClient(this.mContext);
                this.eVk = new LocationClientOption();
                this.eVk.setOpenGps(true);
                this.eVk.setIgnoreKillProcess(true);
                this.eVk.setProdName(this.eVg);
                this.eVk.setAddrType("all");
                this.eVk.setCoorType(BDLocation.BDLOCATION_GCJ02_TO_BD09LL);
                this.eVi = new C0192a();
                this.eVj.registerLocationListener(this.eVi);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void J(boolean z) {
        if ((!com.baidu.e.a.rj() || ac.aM(TbadkCoreApplication.getInst())) && this.EE && this.eVj != null) {
            try {
                this.eVl = z;
                if (z) {
                    this.eVk.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.eVj.setLocOption(this.eVk);
                if (!this.eVj.isStarted()) {
                    this.eVj.start();
                }
                this.eVj.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                hF();
                if (this.eVh != null) {
                    this.eVh.a(5, "", this.zf, this.yZ, this.eVl);
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
            if ((!com.baidu.e.a.rj() || ac.aM(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.hF();
                a.this.zf = new Address(Locale.getDefault());
                a.this.zf.setLatitude(bDLocation.getLatitude());
                a.this.zf.setLongitude(bDLocation.getLongitude());
                a.this.zf.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                a.this.zf.setExtras(bundle);
                a.this.yZ = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.zf.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.eVh != null) {
                    a.this.eVh.a(0, "", a.this.zf, a.this.yZ, a.this.eVl);
                    com.baidu.tieba.recapp.d.a.bod().nR(String.valueOf(a.this.zf.getLatitude()));
                    com.baidu.tieba.recapp.d.a.bod().nQ(String.valueOf(a.this.zf.getLongitude()));
                    com.baidu.tieba.recapp.d.a.bod().cO(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void hF() {
        if (this.eVj != null && this.eVj.isStarted()) {
            try {
                this.eVj.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
