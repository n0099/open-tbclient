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
/* loaded from: classes3.dex */
public class a implements com.baidu.adp.lib.d.b {
    private static a fgp = null;
    private Address aiH;
    private C0192a fgs;
    private LocationClient fgt;
    private LocationClientOption fgu;
    private Context mContext;
    private boolean anV = true;
    private String fgq = "";
    private a.b fgr = null;
    private long aiB = 0;
    private boolean fgv = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.d.a.vB() || ab.aR(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.mG().a(a.aRk());
                        } else {
                            com.baidu.adp.lib.d.a.mG().b(a.aRk());
                        }
                    }
                }
            }
        });
    }

    public static a aRk() {
        if (fgp == null) {
            synchronized (a.class) {
                if (fgp == null) {
                    fgp = new a();
                }
            }
        }
        return fgp;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.fgr = bVar;
        this.fgq = "baidu";
        if (this.anV) {
            try {
                this.fgt = new LocationClient(this.mContext);
                this.fgu = new LocationClientOption();
                this.fgu.setOpenGps(true);
                this.fgu.setIgnoreKillProcess(true);
                this.fgu.setProdName(this.fgq);
                this.fgu.setAddrType("all");
                this.fgu.setCoorType(BDLocation.BDLOCATION_GCJ02_TO_BD09LL);
                this.fgs = new C0192a();
                this.fgt.registerLocationListener(this.fgs);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void ap(boolean z) {
        if ((!com.baidu.d.a.vB() || ab.aR(TbadkCoreApplication.getInst())) && this.anV && this.fgt != null) {
            try {
                this.fgv = z;
                if (z) {
                    this.fgu.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.fgt.setLocOption(this.fgu);
                if (!this.fgt.isStarted()) {
                    this.fgt.start();
                }
                this.fgt.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                mK();
                if (this.fgr != null) {
                    this.fgr.a(5, "", this.aiH, this.aiB, this.fgv);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        mK();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0192a implements BDLocationListener {
        private C0192a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.d.a.vB() || ab.aR(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.mK();
                a.this.aiH = new Address(Locale.getDefault());
                a.this.aiH.setLatitude(bDLocation.getLatitude());
                a.this.aiH.setLongitude(bDLocation.getLongitude());
                a.this.aiH.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                a.this.aiH.setExtras(bundle);
                a.this.aiB = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.aiH.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.fgr != null) {
                    a.this.fgr.a(0, "", a.this.aiH, a.this.aiB, a.this.fgv);
                    com.baidu.tieba.recapp.d.a.boS().mV(String.valueOf(a.this.aiH.getLatitude()));
                    com.baidu.tieba.recapp.d.a.boS().mU(String.valueOf(a.this.aiH.getLongitude()));
                    com.baidu.tieba.recapp.d.a.boS().cM(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void mK() {
        if (this.fgt != null && this.fgt.isStarted()) {
            try {
                this.fgt.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
