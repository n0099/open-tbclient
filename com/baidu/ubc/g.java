package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
/* loaded from: classes13.dex */
public class g {
    private static volatile g lNH;
    private int ddS;
    private int ddT;
    private int ddU;
    private Context mContext;
    private f lNI = new f();
    private ad lMW = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g dky() {
        if (lNH == null) {
            synchronized (e.class) {
                if (lNH == null) {
                    lNH = new g();
                }
            }
        }
        return lNH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.ddS = 360000;
        ag dkO = ag.dkO();
        this.ddT = dkO.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.ddU = dkO.getInt("ubc_database_limit", 10000);
        cVar.dkv().a(this.lNI);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aw(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.aDA())) {
                    this.lNI.lNw.add(id);
                    this.lNI.lNz.remove(id);
                } else {
                    this.lNI.lNw.remove(id);
                    this.lNI.lNz.add(id);
                }
                if ("1".equals(kVar.aDB())) {
                    this.lNI.lNx.add(id);
                } else {
                    this.lNI.lNx.remove(id);
                }
                if ("1".equals(kVar.aDC())) {
                    this.lNI.lNy.add(id);
                } else {
                    this.lNI.lNy.remove(id);
                }
                if ("1".equals(kVar.dkA())) {
                    this.lNI.lNA.add(id);
                } else {
                    this.lNI.lNA.remove(id);
                }
                if (kVar.aDD() >= 1 && kVar.aDD() <= 100) {
                    this.lNI.lNB.put(id, String.valueOf(kVar.aDD()));
                } else {
                    this.lNI.lNB.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.lNI.lNC.put(id, kVar.getCategory());
                } else {
                    this.lNI.lNC.remove(id);
                }
                if (kVar.aDF() != 0 && kVar.aDE() != 0) {
                    m mVar = new m(id, kVar.aDF(), kVar.aDE());
                    this.lNI.lND.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.aDG(), "1")) {
                    this.lNI.lNE.add(id);
                } else {
                    this.lNI.lNE.remove(id);
                }
                if (TextUtils.equals(kVar.dkC(), "1")) {
                    this.lNI.lNF.add(id);
                } else {
                    this.lNI.lNF.remove(id);
                }
                String dkD = kVar.dkD();
                if (!TextUtils.isEmpty(dkD) && !TextUtils.equals(dkD, "0")) {
                    this.lNI.lNG.put(id, dkD);
                } else {
                    this.lNI.lNG.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Z(String str, int i) {
        if (this.lNI.lNw.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.lNI.lNz.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sb(String str) {
        if (this.lMW.dkM()) {
            return true;
        }
        return this.lNI.lNx.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sc(String str) {
        return this.lNI.lNy.contains(str);
    }

    boolean Nn(String str) {
        return this.lNI.lNA.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String sd(String str) {
        return this.lNI.lNC.containsKey(str) ? this.lNI.lNC.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aDx() {
        return this.ddS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iY(int i) {
        if (i * 60000 >= this.ddS) {
            this.ddS = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aDy() {
        return this.ddT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iZ(int i) {
        if (i >= this.ddT) {
            this.ddT = i;
            ag.dkO().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aDz() {
        return this.ddU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ja(int i) {
        if (i >= this.ddU) {
            this.ddU = i;
            ag.dkO().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int se(String str) {
        if (TextUtils.isEmpty(str) || !this.lNI.lNB.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.lNI.lNB.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sf(String str) {
        if (this.lNI.lND == null || !this.lNI.lND.containsKey(str)) {
            return false;
        }
        return this.lNI.lND.get(str).aDH();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sg(String str) {
        if (this.lNI.lND == null || !this.lNI.lND.containsKey(str)) {
            return false;
        }
        return this.lNI.lND.get(str).aDI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String sh(String str) {
        return (TextUtils.isEmpty(str) || !this.lNI.lNE.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean No(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !Nn(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Np(String str) {
        return this.lNI.lNF.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Nq(String str) {
        return this.lNI.lNx.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Nr(String str) {
        return this.lNI.lNG.containsKey(str) ? this.lNI.lNG.get(str) : "";
    }
}
