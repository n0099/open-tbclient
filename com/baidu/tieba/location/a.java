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
    private static a eAR = null;
    private C0175a eAU;
    private LocationClient eAV;
    private LocationClientOption eAW;
    private Context mContext;
    private Address te;
    private boolean yy = true;
    private String eAS = "";
    private a.b eAT = null;
    private long sX = 0;
    private boolean eAX = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.d.a.on() || ab.aB(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.eK().a(a.aMg());
                        } else {
                            com.baidu.adp.lib.d.a.eK().b(a.aMg());
                        }
                    }
                }
            }
        });
    }

    public static a aMg() {
        if (eAR == null) {
            synchronized (a.class) {
                if (eAR == null) {
                    eAR = new a();
                }
            }
        }
        return eAR;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.eAT = bVar;
        this.eAS = "baidu";
        if (this.yy) {
            try {
                this.eAV = new LocationClient(this.mContext);
                this.eAW = new LocationClientOption();
                this.eAW.setOpenGps(true);
                this.eAW.setIgnoreKillProcess(true);
                this.eAW.setProdName(this.eAS);
                this.eAW.setAddrType("all");
                this.eAW.setCoorType(BDLocation.BDLOCATION_GCJ02_TO_BD09LL);
                this.eAU = new C0175a();
                this.eAV.registerLocationListener(this.eAU);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void I(boolean z) {
        if ((!com.baidu.d.a.on() || ab.aB(TbadkCoreApplication.getInst())) && this.yy && this.eAV != null) {
            try {
                this.eAX = z;
                if (z) {
                    this.eAW.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.eAV.setLocOption(this.eAW);
                if (!this.eAV.isStarted()) {
                    this.eAV.start();
                }
                this.eAV.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                eO();
                if (this.eAT != null) {
                    this.eAT.a(5, "", this.te, this.sX, this.eAX);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        eO();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0175a implements BDLocationListener {
        private C0175a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.d.a.on() || ab.aB(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.eO();
                a.this.te = new Address(Locale.getDefault());
                a.this.te.setLatitude(bDLocation.getLatitude());
                a.this.te.setLongitude(bDLocation.getLongitude());
                a.this.te.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                a.this.te.setExtras(bundle);
                a.this.sX = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.te.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.eAT != null) {
                    a.this.eAT.a(0, "", a.this.te, a.this.sX, a.this.eAX);
                    com.baidu.tieba.recapp.d.a.bjZ().mZ(String.valueOf(a.this.te.getLatitude()));
                    com.baidu.tieba.recapp.d.a.bjZ().mY(String.valueOf(a.this.te.getLongitude()));
                    com.baidu.tieba.recapp.d.a.bjZ().cQ(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void eO() {
        if (this.eAV != null && this.eAV.isStarted()) {
            try {
                this.eAV.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
