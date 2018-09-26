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
    private static a fcv = null;
    private Address BB;
    private LocationClientOption fcA;
    private C0194a fcy;
    private LocationClient fcz;
    private Context mContext;
    private boolean Ha = true;
    private String fcw = "";
    private a.b fcx = null;
    private long Bv = 0;
    private boolean fcB = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.e.a.sl() || ab.br(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.iH().a(a.aUV());
                        } else {
                            com.baidu.adp.lib.d.a.iH().b(a.aUV());
                        }
                    }
                }
            }
        });
    }

    public static a aUV() {
        if (fcv == null) {
            synchronized (a.class) {
                if (fcv == null) {
                    fcv = new a();
                }
            }
        }
        return fcv;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.fcx = bVar;
        this.fcw = "baidu";
        if (this.Ha) {
            try {
                this.fcz = new LocationClient(this.mContext);
                this.fcA = new LocationClientOption();
                this.fcA.setOpenGps(true);
                this.fcA.setIgnoreKillProcess(true);
                this.fcA.setProdName(this.fcw);
                this.fcA.setAddrType("all");
                this.fcA.setCoorType(BDLocation.BDLOCATION_GCJ02_TO_BD09LL);
                this.fcy = new C0194a();
                this.fcz.registerLocationListener(this.fcy);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void T(boolean z) {
        if ((!com.baidu.e.a.sl() || ab.br(TbadkCoreApplication.getInst())) && this.Ha && this.fcz != null) {
            try {
                this.fcB = z;
                if (z) {
                    this.fcA.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.fcz.setLocOption(this.fcA);
                if (!this.fcz.isStarted()) {
                    this.fcz.start();
                }
                this.fcz.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                iL();
                if (this.fcx != null) {
                    this.fcx.a(5, "", this.BB, this.Bv, this.fcB);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        iL();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0194a implements BDLocationListener {
        private C0194a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.e.a.sl() || ab.br(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.iL();
                a.this.BB = new Address(Locale.getDefault());
                a.this.BB.setLatitude(bDLocation.getLatitude());
                a.this.BB.setLongitude(bDLocation.getLongitude());
                a.this.BB.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                a.this.BB.setExtras(bundle);
                a.this.Bv = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.BB.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.fcx != null) {
                    a.this.fcx.a(0, "", a.this.BB, a.this.Bv, a.this.fcB);
                    com.baidu.tieba.recapp.d.a.bqL().oA(String.valueOf(a.this.BB.getLatitude()));
                    com.baidu.tieba.recapp.d.a.bqL().oz(String.valueOf(a.this.BB.getLongitude()));
                    com.baidu.tieba.recapp.d.a.bqL().cS(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void iL() {
        if (this.fcz != null && this.fcz.isStarted()) {
            try {
                this.fcz.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
