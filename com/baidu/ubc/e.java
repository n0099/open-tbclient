package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e jXG;
    private HashSet<String> bPe = new HashSet<>();
    private HashSet<String> bPf = new HashSet<>();
    private HashSet<String> bPg = new HashSet<>();
    private HashSet<String> bPh = new HashSet<>();
    private HashMap<String, String> bPi = new HashMap<>();
    private HashMap<String, String> bPj = new HashMap<>();
    private HashMap<String, i> bPk = new HashMap<>();
    private HashSet<String> bPl = new HashSet<>();
    private int bPm;
    private int bPn;
    private int bPo;
    private Context mContext;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e cAV() {
        if (jXG == null) {
            synchronized (e.class) {
                if (jXG == null) {
                    jXG = new e();
                }
            }
        }
        return jXG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bPm = 360000;
        r cAW = r.cAW();
        this.bPn = cAW.getInt("ubc_data_expire_time", 259200000);
        this.bPo = cAW.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.cAT().a(this.bPe, this.bPh, this.bPf, this.bPg, this.bPi, this.bPj, this.bPk, this.bPl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ai(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.acz())) {
                this.bPe.add(hVar.getId());
            } else {
                this.bPe.remove(hVar.getId());
            }
            if ("1".equals(hVar.acA())) {
                this.bPf.add(hVar.getId());
            } else {
                this.bPf.remove(hVar.getId());
            }
            if ("1".equals(hVar.acB())) {
                this.bPg.add(hVar.getId());
            } else {
                this.bPg.remove(hVar.getId());
            }
            if (hVar.acC() >= 1 && hVar.acC() <= 100) {
                this.bPi.put(hVar.getId(), String.valueOf(hVar.acC()));
            } else {
                this.bPi.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.bPj.put(hVar.getId(), hVar.getCategory());
            } else {
                this.bPj.remove(hVar.getId());
            }
            if (hVar.acE() != 0 && hVar.acD() != 0) {
                i iVar = new i(hVar.getId(), hVar.acE(), hVar.acD());
                this.bPk.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.acF(), "1")) {
                this.bPl.add(hVar.getId());
            } else {
                this.bPl.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J(String str, int i) {
        if (this.bPe.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bPh.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean lr(String str) {
        if (UBC.getUBCContext().Nd()) {
            return true;
        }
        return this.bPf.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ls(String str) {
        return this.bPg.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String lt(String str) {
        return this.bPj.containsKey(str) ? this.bPj.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int acw() {
        return this.bPm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gR(int i) {
        if (i * 60000 >= this.bPm) {
            this.bPm = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int acx() {
        return this.bPn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gS(int i) {
        if (i >= this.bPn) {
            this.bPn = i;
            r.cAW().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int acy() {
        return this.bPo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gT(int i) {
        if (i >= this.bPo) {
            this.bPo = i;
            r.cAW().putInt("ubc_database_limit", i);
        }
    }

    public int lu(String str) {
        if (TextUtils.isEmpty(str) || !this.bPi.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bPi.get(str));
    }

    public boolean lv(String str) {
        if (this.bPk == null || !this.bPk.containsKey(str)) {
            return false;
        }
        return this.bPk.get(str).acG();
    }

    public boolean lw(String str) {
        if (this.bPk == null || !this.bPk.containsKey(str)) {
            return false;
        }
        return this.bPk.get(str).acH();
    }

    public String lx(String str) {
        return (TextUtils.isEmpty(str) || !this.bPl.contains(str)) ? "0" : "1";
    }
}
