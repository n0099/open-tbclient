package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
import java.util.Random;
/* loaded from: classes19.dex */
public class g {
    private static volatile g nET;
    private int dXA;
    private int dXB;
    private int dXz;
    private Context mContext;
    private f nEU = new f();
    private ad nEh = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g dTF() {
        if (nET == null) {
            synchronized (e.class) {
                if (nET == null) {
                    nET = new g();
                }
            }
        }
        return nET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dXz = 360000;
        ag dTV = ag.dTV();
        this.dXA = dTV.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.dXB = dTV.getInt("ubc_database_limit", 10000);
        cVar.dTC().a(this.nEU);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aI(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.aZb())) {
                    this.nEU.nEH.add(id);
                    this.nEU.nEK.remove(id);
                } else {
                    this.nEU.nEH.remove(id);
                    this.nEU.nEK.add(id);
                }
                if ("1".equals(kVar.aZc())) {
                    this.nEU.nEI.add(id);
                } else {
                    this.nEU.nEI.remove(id);
                }
                if ("1".equals(kVar.aZd())) {
                    this.nEU.nEJ.add(id);
                } else {
                    this.nEU.nEJ.remove(id);
                }
                if ("1".equals(kVar.dTH())) {
                    this.nEU.nEL.add(id);
                } else {
                    this.nEU.nEL.remove(id);
                }
                if (kVar.aZe() >= 1 && kVar.aZe() <= 100) {
                    this.nEU.nEM.put(id, String.valueOf(kVar.aZe()));
                } else {
                    this.nEU.nEM.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.nEU.nEN.put(id, kVar.getCategory());
                } else {
                    this.nEU.nEN.remove(id);
                }
                if (kVar.aZg() != 0 && kVar.aZf() != 0) {
                    m mVar = new m(id, kVar.aZg(), kVar.aZf());
                    this.nEU.nEO.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.aZh(), "1")) {
                    this.nEU.nEP.add(id);
                } else {
                    this.nEU.nEP.remove(id);
                }
                if (TextUtils.equals(kVar.dTJ(), "1")) {
                    this.nEU.nEQ.add(id);
                } else {
                    this.nEU.nEQ.remove(id);
                }
                String dTK = kVar.dTK();
                if (!TextUtils.isEmpty(dTK) && !TextUtils.equals(dTK, "0")) {
                    this.nEU.nER.put(id, dTK);
                } else {
                    this.nEU.nER.remove(id);
                }
                String dTL = kVar.dTL();
                if (!TextUtils.isEmpty(dTL)) {
                    this.nEU.nES.put(id, dTL);
                } else {
                    this.nEU.nES.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ae(String str, int i) {
        if (this.nEU.nEH.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.nEU.nEK.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yg(String str) {
        if (this.nEh.dTT()) {
            return true;
        }
        return this.nEU.nEI.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean UL(String str) {
        if (!isBeta() && this.nEh.dTS() && yj(str) > 0) {
            return new Random().nextInt(100) >= yj(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yh(String str) {
        return this.nEU.nEJ.contains(str);
    }

    boolean UM(String str) {
        return this.nEU.nEL.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yi(String str) {
        return this.nEU.nEN.containsKey(str) ? this.nEU.nEN.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aYW() {
        return this.dXz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mL(int i) {
        if (i * 60000 >= this.dXz) {
            this.dXz = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aYX() {
        return this.dXA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mM(int i) {
        if (i >= this.dXA) {
            this.dXA = i;
            ag.dTV().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aYY() {
        return this.dXB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mN(int i) {
        if (i >= this.dXB) {
            this.dXB = i;
            ag.dTV().putInt("ubc_database_limit", i);
        }
    }

    int yj(String str) {
        if (TextUtils.isEmpty(str) || !this.nEU.nEM.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.nEU.nEM.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yk(String str) {
        if (this.nEU.nEO == null || !this.nEU.nEO.containsKey(str)) {
            return false;
        }
        return this.nEU.nEO.get(str).aZi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yl(String str) {
        if (this.nEU.nEO == null || !this.nEU.nEO.containsKey(str)) {
            return false;
        }
        return this.nEU.nEO.get(str).aZj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ym(String str) {
        return (TextUtils.isEmpty(str) || !this.nEU.nEP.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean UN(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !UM(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean UO(String str) {
        return this.nEU.nEQ.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean UP(String str) {
        return this.nEU.nEI.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String UQ(String str) {
        return this.nEU.nER.containsKey(str) ? this.nEU.nER.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.nEU.nES.containsKey(str) ? this.nEU.nES.get(str) : "";
    }

    public boolean UR(String str) {
        return TextUtils.equals("0", getUploadType(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBeta() {
        q uBCContext = UBC.getUBCContext();
        if (uBCContext != null) {
            return uBCContext.isBeta();
        }
        return false;
    }
}
