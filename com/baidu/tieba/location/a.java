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
    private static a eAU = null;
    private C0175a eAX;
    private LocationClient eAY;
    private LocationClientOption eAZ;
    private Context mContext;
    private Address te;
    private boolean yy = true;
    private String eAV = "";
    private a.b eAW = null;
    private long sX = 0;
    private boolean eBa = false;

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
        if (eAU == null) {
            synchronized (a.class) {
                if (eAU == null) {
                    eAU = new a();
                }
            }
        }
        return eAU;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.eAW = bVar;
        this.eAV = "baidu";
        if (this.yy) {
            try {
                this.eAY = new LocationClient(this.mContext);
                this.eAZ = new LocationClientOption();
                this.eAZ.setOpenGps(true);
                this.eAZ.setIgnoreKillProcess(true);
                this.eAZ.setProdName(this.eAV);
                this.eAZ.setAddrType("all");
                this.eAZ.setCoorType(BDLocation.BDLOCATION_GCJ02_TO_BD09LL);
                this.eAX = new C0175a();
                this.eAY.registerLocationListener(this.eAX);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void I(boolean z) {
        if ((!com.baidu.d.a.on() || ab.aB(TbadkCoreApplication.getInst())) && this.yy && this.eAY != null) {
            try {
                this.eBa = z;
                if (z) {
                    this.eAZ.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.eAY.setLocOption(this.eAZ);
                if (!this.eAY.isStarted()) {
                    this.eAY.start();
                }
                this.eAY.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                eO();
                if (this.eAW != null) {
                    this.eAW.a(5, "", this.te, this.sX, this.eBa);
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
                if (a.this.eAW != null) {
                    a.this.eAW.a(0, "", a.this.te, a.this.sX, a.this.eBa);
                    com.baidu.tieba.recapp.d.a.bjZ().mZ(String.valueOf(a.this.te.getLatitude()));
                    com.baidu.tieba.recapp.d.a.bjZ().mY(String.valueOf(a.this.te.getLongitude()));
                    com.baidu.tieba.recapp.d.a.bjZ().cQ(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void eO() {
        if (this.eAY != null && this.eAY.isStarted()) {
            try {
                this.eAY.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
