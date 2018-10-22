package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e hSB;
    private HashSet<String> hSC = new HashSet<>();
    private HashSet<String> hSD = new HashSet<>();
    private HashSet<String> hSE = new HashSet<>();
    private HashSet<String> hSF = new HashSet<>();
    private HashMap<String, String> hSG = new HashMap<>();
    private HashMap<String, String> hSH = new HashMap<>();
    private HashMap<String, i> hSI = new HashMap<>();
    private HashSet<String> hSJ = new HashSet<>();
    private int hSK;
    private int hSL;
    private int hSM;
    private Context mContext;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e bPl() {
        if (hSB == null) {
            synchronized (e.class) {
                if (hSB == null) {
                    hSB = new e();
                }
            }
        }
        return hSB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.hSK = 360000;
        s bPQ = s.bPQ();
        this.hSL = bPQ.getInt("ubc_data_expire_time", 259200000);
        this.hSM = bPQ.getInt("ubc_database_limit", 4000);
        cVar.bPi().a(this.hSC, this.hSF, this.hSD, this.hSE, this.hSG, this.hSH, this.hSI, this.hSJ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void en(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.bPp())) {
                this.hSC.add(hVar.getId());
            } else {
                this.hSC.remove(hVar.getId());
            }
            if ("1".equals(hVar.bPq())) {
                this.hSD.add(hVar.getId());
            } else {
                this.hSD.remove(hVar.getId());
            }
            if ("1".equals(hVar.bPr())) {
                this.hSE.add(hVar.getId());
            } else {
                this.hSE.remove(hVar.getId());
            }
            if (hVar.bPs() >= 1 && hVar.bPs() <= 100) {
                this.hSG.put(hVar.getId(), String.valueOf(hVar.bPs()));
            } else {
                this.hSG.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.hSH.put(hVar.getId(), hVar.getCategory());
            } else {
                this.hSH.remove(hVar.getId());
            }
            if (hVar.bPu() != 0 && hVar.bPt() != 0) {
                i iVar = new i(hVar.getId(), hVar.bPu(), hVar.bPt());
                this.hSI.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.getIdType(), "1")) {
                this.hSJ.add(hVar.getId());
            } else {
                this.hSJ.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bd(String str, int i) {
        if (this.hSC.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.hSF.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xq(String str) {
        if (o.bPN().XQ()) {
            return true;
        }
        return this.hSD.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xr(String str) {
        return this.hSE.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xs(String str) {
        return this.hSH.containsKey(str) ? this.hSH.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bPm() {
        return this.hSK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wJ(int i) {
        if (i * 60000 >= this.hSK) {
            this.hSK = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bPn() {
        return this.hSL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wK(int i) {
        if (i >= this.hSL) {
            this.hSL = i;
            s.bPQ().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bPo() {
        return this.hSM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wL(int i) {
        if (i >= this.hSM) {
            this.hSM = i;
            s.bPQ().putInt("ubc_database_limit", i);
        }
    }

    public int xt(String str) {
        if (TextUtils.isEmpty(str) || !this.hSG.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.hSG.get(str));
    }

    public boolean xu(String str) {
        if (this.hSI == null || !this.hSI.containsKey(str)) {
            return false;
        }
        return this.hSI.get(str).bPv();
    }

    public boolean xv(String str) {
        if (this.hSI == null || !this.hSI.containsKey(str)) {
            return false;
        }
        return this.hSI.get(str).bPw();
    }

    public String xw(String str) {
        return (TextUtils.isEmpty(str) || !this.hSJ.contains(str)) ? "0" : "1";
    }
}
