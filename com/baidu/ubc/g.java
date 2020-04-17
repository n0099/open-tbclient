package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
/* loaded from: classes13.dex */
public class g {
    private static volatile g lND;
    private int ddN;
    private int ddO;
    private int ddP;
    private Context mContext;
    private f lNE = new f();
    private ad lMS = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g dkB() {
        if (lND == null) {
            synchronized (e.class) {
                if (lND == null) {
                    lND = new g();
                }
            }
        }
        return lND;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.ddN = 360000;
        ag dkR = ag.dkR();
        this.ddO = dkR.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.ddP = dkR.getInt("ubc_database_limit", 10000);
        cVar.dky().a(this.lNE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aw(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.aDA())) {
                    this.lNE.lNs.add(id);
                    this.lNE.lNv.remove(id);
                } else {
                    this.lNE.lNs.remove(id);
                    this.lNE.lNv.add(id);
                }
                if ("1".equals(kVar.aDB())) {
                    this.lNE.lNt.add(id);
                } else {
                    this.lNE.lNt.remove(id);
                }
                if ("1".equals(kVar.aDC())) {
                    this.lNE.lNu.add(id);
                } else {
                    this.lNE.lNu.remove(id);
                }
                if ("1".equals(kVar.dkD())) {
                    this.lNE.lNw.add(id);
                } else {
                    this.lNE.lNw.remove(id);
                }
                if (kVar.aDD() >= 1 && kVar.aDD() <= 100) {
                    this.lNE.lNx.put(id, String.valueOf(kVar.aDD()));
                } else {
                    this.lNE.lNx.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.lNE.lNy.put(id, kVar.getCategory());
                } else {
                    this.lNE.lNy.remove(id);
                }
                if (kVar.aDF() != 0 && kVar.aDE() != 0) {
                    m mVar = new m(id, kVar.aDF(), kVar.aDE());
                    this.lNE.lNz.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.aDG(), "1")) {
                    this.lNE.lNA.add(id);
                } else {
                    this.lNE.lNA.remove(id);
                }
                if (TextUtils.equals(kVar.dkF(), "1")) {
                    this.lNE.lNB.add(id);
                } else {
                    this.lNE.lNB.remove(id);
                }
                String dkG = kVar.dkG();
                if (!TextUtils.isEmpty(dkG) && !TextUtils.equals(dkG, "0")) {
                    this.lNE.lNC.put(id, dkG);
                } else {
                    this.lNE.lNC.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Z(String str, int i) {
        if (this.lNE.lNs.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.lNE.lNv.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sb(String str) {
        if (this.lMS.dkP()) {
            return true;
        }
        return this.lNE.lNt.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sc(String str) {
        return this.lNE.lNu.contains(str);
    }

    boolean Nk(String str) {
        return this.lNE.lNw.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String sd(String str) {
        return this.lNE.lNy.containsKey(str) ? this.lNE.lNy.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aDx() {
        return this.ddN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iY(int i) {
        if (i * 60000 >= this.ddN) {
            this.ddN = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aDy() {
        return this.ddO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iZ(int i) {
        if (i >= this.ddO) {
            this.ddO = i;
            ag.dkR().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aDz() {
        return this.ddP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ja(int i) {
        if (i >= this.ddP) {
            this.ddP = i;
            ag.dkR().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int se(String str) {
        if (TextUtils.isEmpty(str) || !this.lNE.lNx.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.lNE.lNx.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sf(String str) {
        if (this.lNE.lNz == null || !this.lNE.lNz.containsKey(str)) {
            return false;
        }
        return this.lNE.lNz.get(str).aDH();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sg(String str) {
        if (this.lNE.lNz == null || !this.lNE.lNz.containsKey(str)) {
            return false;
        }
        return this.lNE.lNz.get(str).aDI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String sh(String str) {
        return (TextUtils.isEmpty(str) || !this.lNE.lNA.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Nl(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !Nk(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Nm(String str) {
        return this.lNE.lNB.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Nn(String str) {
        return this.lNE.lNt.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String No(String str) {
        return this.lNE.lNC.containsKey(str) ? this.lNE.lNC.get(str) : "";
    }
}
