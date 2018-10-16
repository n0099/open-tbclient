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
    private static a fke = null;
    private Address Cj;
    private C0228a fkh;
    private LocationClient fki;
    private LocationClientOption fkj;
    private Context mContext;
    private boolean mIsOpen = true;
    private String fkf = "";
    private a.b fkg = null;
    private long Cd = 0;
    private boolean fkk = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.f.a.uf() || ab.bA(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.iX().a(a.aYi());
                        } else {
                            com.baidu.adp.lib.d.a.iX().b(a.aYi());
                        }
                    }
                }
            }
        });
    }

    public static a aYi() {
        if (fke == null) {
            synchronized (a.class) {
                if (fke == null) {
                    fke = new a();
                }
            }
        }
        return fke;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.fkg = bVar;
        this.fkf = "baidu";
        if (this.mIsOpen) {
            try {
                this.fki = new LocationClient(this.mContext);
                this.fkj = new LocationClientOption();
                this.fkj.setOpenGps(true);
                this.fkj.setIgnoreKillProcess(true);
                this.fkj.setProdName(this.fkf);
                this.fkj.setAddrType("all");
                this.fkj.setCoorType("bd09ll");
                this.fkh = new C0228a();
                this.fki.registerLocationListener(this.fkh);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void T(boolean z) {
        if ((!com.baidu.f.a.uf() || ab.bA(TbadkCoreApplication.getInst())) && this.mIsOpen && this.fki != null) {
            try {
                this.fkk = z;
                if (z) {
                    this.fkj.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.fki.setLocOption(this.fkj);
                if (!this.fki.isStarted()) {
                    this.fki.start();
                }
                this.fki.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                ja();
                if (this.fkg != null) {
                    this.fkg.a(5, "", this.Cj, this.Cd, this.fkk);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        ja();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0228a implements BDLocationListener {
        private C0228a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.f.a.uf() || ab.bA(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.ja();
                a.this.Cj = new Address(Locale.getDefault());
                a.this.Cj.setLatitude(bDLocation.getLatitude());
                a.this.Cj.setLongitude(bDLocation.getLongitude());
                a.this.Cj.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                a.this.Cj.setExtras(bundle);
                a.this.Cd = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.Cj.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.fkg != null) {
                    a.this.fkg.a(0, "", a.this.Cj, a.this.Cd, a.this.fkk);
                    com.baidu.tieba.recapp.d.a.bua().pc(String.valueOf(a.this.Cj.getLatitude()));
                    com.baidu.tieba.recapp.d.a.bua().pb(String.valueOf(a.this.Cj.getLongitude()));
                    com.baidu.tieba.recapp.d.a.bua().cZ(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void ja() {
        if (this.fki != null && this.fki.isStarted()) {
            try {
                this.fki.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
