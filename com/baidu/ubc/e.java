package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e jPc;
    private HashSet<String> bvj = new HashSet<>();
    private HashSet<String> bvk = new HashSet<>();
    private HashSet<String> bvl = new HashSet<>();
    private HashSet<String> bvm = new HashSet<>();
    private HashMap<String, String> bvn = new HashMap<>();
    private HashMap<String, String> bvo = new HashMap<>();
    private HashMap<String, i> bvp = new HashMap<>();
    private HashSet<String> bvq = new HashSet<>();
    private int bvr;
    private int bvs;
    private int bvt;
    private Context mContext;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e cAf() {
        if (jPc == null) {
            synchronized (e.class) {
                if (jPc == null) {
                    jPc = new e();
                }
            }
        }
        return jPc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bvr = 360000;
        r cAg = r.cAg();
        this.bvs = cAg.getInt("ubc_data_expire_time", 259200000);
        this.bvt = cAg.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.cAd().a(this.bvj, this.bvm, this.bvk, this.bvl, this.bvn, this.bvo, this.bvp, this.bvq);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.WM())) {
                this.bvj.add(hVar.getId());
            } else {
                this.bvj.remove(hVar.getId());
            }
            if ("1".equals(hVar.WN())) {
                this.bvk.add(hVar.getId());
            } else {
                this.bvk.remove(hVar.getId());
            }
            if ("1".equals(hVar.WO())) {
                this.bvl.add(hVar.getId());
            } else {
                this.bvl.remove(hVar.getId());
            }
            if (hVar.WP() >= 1 && hVar.WP() <= 100) {
                this.bvn.put(hVar.getId(), String.valueOf(hVar.WP()));
            } else {
                this.bvn.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.bvo.put(hVar.getId(), hVar.getCategory());
            } else {
                this.bvo.remove(hVar.getId());
            }
            if (hVar.WR() != 0 && hVar.WQ() != 0) {
                i iVar = new i(hVar.getId(), hVar.WR(), hVar.WQ());
                this.bvp.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.getIdType(), "1")) {
                this.bvq.add(hVar.getId());
            } else {
                this.bvq.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J(String str, int i) {
        if (this.bvj.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bvm.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kG(String str) {
        if (UBC.getUBCContext().Ht()) {
            return true;
        }
        return this.bvk.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kH(String str) {
        return this.bvl.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String kI(String str) {
        return this.bvo.containsKey(str) ? this.bvo.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int WJ() {
        return this.bvr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fR(int i) {
        if (i * 60000 >= this.bvr) {
            this.bvr = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int WK() {
        return this.bvs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fS(int i) {
        if (i >= this.bvs) {
            this.bvs = i;
            r.cAg().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int WL() {
        return this.bvt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fT(int i) {
        if (i >= this.bvt) {
            this.bvt = i;
            r.cAg().putInt("ubc_database_limit", i);
        }
    }

    public int kJ(String str) {
        if (TextUtils.isEmpty(str) || !this.bvn.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bvn.get(str));
    }

    public boolean kK(String str) {
        if (this.bvp == null || !this.bvp.containsKey(str)) {
            return false;
        }
        return this.bvp.get(str).WS();
    }

    public boolean kL(String str) {
        if (this.bvp == null || !this.bvp.containsKey(str)) {
            return false;
        }
        return this.bvp.get(str).WT();
    }

    public String kM(String str) {
        return (TextUtils.isEmpty(str) || !this.bvq.contains(str)) ? "0" : "1";
    }
}
