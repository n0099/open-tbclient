package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e hSA;
    private HashSet<String> hSB = new HashSet<>();
    private HashSet<String> hSC = new HashSet<>();
    private HashSet<String> hSD = new HashSet<>();
    private HashSet<String> hSE = new HashSet<>();
    private HashMap<String, String> hSF = new HashMap<>();
    private HashMap<String, String> hSG = new HashMap<>();
    private HashMap<String, i> hSH = new HashMap<>();
    private HashSet<String> hSI = new HashSet<>();
    private int hSJ;
    private int hSK;
    private int hSL;
    private Context mContext;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e bPl() {
        if (hSA == null) {
            synchronized (e.class) {
                if (hSA == null) {
                    hSA = new e();
                }
            }
        }
        return hSA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.hSJ = 360000;
        s bPQ = s.bPQ();
        this.hSK = bPQ.getInt("ubc_data_expire_time", 259200000);
        this.hSL = bPQ.getInt("ubc_database_limit", 4000);
        cVar.bPi().a(this.hSB, this.hSE, this.hSC, this.hSD, this.hSF, this.hSG, this.hSH, this.hSI);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void en(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.bPp())) {
                this.hSB.add(hVar.getId());
            } else {
                this.hSB.remove(hVar.getId());
            }
            if ("1".equals(hVar.bPq())) {
                this.hSC.add(hVar.getId());
            } else {
                this.hSC.remove(hVar.getId());
            }
            if ("1".equals(hVar.bPr())) {
                this.hSD.add(hVar.getId());
            } else {
                this.hSD.remove(hVar.getId());
            }
            if (hVar.bPs() >= 1 && hVar.bPs() <= 100) {
                this.hSF.put(hVar.getId(), String.valueOf(hVar.bPs()));
            } else {
                this.hSF.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.hSG.put(hVar.getId(), hVar.getCategory());
            } else {
                this.hSG.remove(hVar.getId());
            }
            if (hVar.bPu() != 0 && hVar.bPt() != 0) {
                i iVar = new i(hVar.getId(), hVar.bPu(), hVar.bPt());
                this.hSH.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.getIdType(), "1")) {
                this.hSI.add(hVar.getId());
            } else {
                this.hSI.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bd(String str, int i) {
        if (this.hSB.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.hSE.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xq(String str) {
        if (o.bPN().XP()) {
            return true;
        }
        return this.hSC.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xr(String str) {
        return this.hSD.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xs(String str) {
        return this.hSG.containsKey(str) ? this.hSG.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bPm() {
        return this.hSJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wJ(int i) {
        if (i * 60000 >= this.hSJ) {
            this.hSJ = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bPn() {
        return this.hSK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wK(int i) {
        if (i >= this.hSK) {
            this.hSK = i;
            s.bPQ().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bPo() {
        return this.hSL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wL(int i) {
        if (i >= this.hSL) {
            this.hSL = i;
            s.bPQ().putInt("ubc_database_limit", i);
        }
    }

    public int xt(String str) {
        if (TextUtils.isEmpty(str) || !this.hSF.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.hSF.get(str));
    }

    public boolean xu(String str) {
        if (this.hSH == null || !this.hSH.containsKey(str)) {
            return false;
        }
        return this.hSH.get(str).bPv();
    }

    public boolean xv(String str) {
        if (this.hSH == null || !this.hSH.containsKey(str)) {
            return false;
        }
        return this.hSH.get(str).bPw();
    }

    public String xw(String str) {
        return (TextUtils.isEmpty(str) || !this.hSI.contains(str)) ? "0" : "1";
    }
}
