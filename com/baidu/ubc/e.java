package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e jZH;
    private int bwF;
    private int bwG;
    private int bwH;
    private Context mContext;
    private HashSet<String> bwx = new HashSet<>();
    private HashSet<String> bwy = new HashSet<>();
    private HashSet<String> bwz = new HashSet<>();
    private HashSet<String> bwA = new HashSet<>();
    private HashMap<String, String> bwB = new HashMap<>();
    private HashMap<String, String> bwC = new HashMap<>();
    private HashMap<String, i> bwD = new HashMap<>();
    private HashSet<String> bwE = new HashSet<>();

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e cEl() {
        if (jZH == null) {
            synchronized (e.class) {
                if (jZH == null) {
                    jZH = new e();
                }
            }
        }
        return jZH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bwF = 360000;
        r cEm = r.cEm();
        this.bwG = cEm.getInt("ubc_data_expire_time", 259200000);
        this.bwH = cEm.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.cEj().a(this.bwx, this.bwA, this.bwy, this.bwz, this.bwB, this.bwC, this.bwD, this.bwE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.XK())) {
                this.bwx.add(hVar.getId());
            } else {
                this.bwx.remove(hVar.getId());
            }
            if ("1".equals(hVar.XL())) {
                this.bwy.add(hVar.getId());
            } else {
                this.bwy.remove(hVar.getId());
            }
            if ("1".equals(hVar.XM())) {
                this.bwz.add(hVar.getId());
            } else {
                this.bwz.remove(hVar.getId());
            }
            if (hVar.XN() >= 1 && hVar.XN() <= 100) {
                this.bwB.put(hVar.getId(), String.valueOf(hVar.XN()));
            } else {
                this.bwB.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.bwC.put(hVar.getId(), hVar.getCategory());
            } else {
                this.bwC.remove(hVar.getId());
            }
            if (hVar.XP() != 0 && hVar.XO() != 0) {
                i iVar = new i(hVar.getId(), hVar.XP(), hVar.XO());
                this.bwD.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.XQ(), "1")) {
                this.bwE.add(hVar.getId());
            } else {
                this.bwE.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J(String str, int i) {
        if (this.bwx.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bwA.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kP(String str) {
        if (UBC.getUBCContext().Ij()) {
            return true;
        }
        return this.bwy.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kQ(String str) {
        return this.bwz.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String kR(String str) {
        return this.bwC.containsKey(str) ? this.bwC.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int XH() {
        return this.bwF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fW(int i) {
        if (i * 60000 >= this.bwF) {
            this.bwF = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int XI() {
        return this.bwG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fX(int i) {
        if (i >= this.bwG) {
            this.bwG = i;
            r.cEm().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int XJ() {
        return this.bwH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fY(int i) {
        if (i >= this.bwH) {
            this.bwH = i;
            r.cEm().putInt("ubc_database_limit", i);
        }
    }

    public int kS(String str) {
        if (TextUtils.isEmpty(str) || !this.bwB.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bwB.get(str));
    }

    public boolean kT(String str) {
        if (this.bwD == null || !this.bwD.containsKey(str)) {
            return false;
        }
        return this.bwD.get(str).XR();
    }

    public boolean kU(String str) {
        if (this.bwD == null || !this.bwD.containsKey(str)) {
            return false;
        }
        return this.bwD.get(str).XS();
    }

    public String kV(String str) {
        return (TextUtils.isEmpty(str) || !this.bwE.contains(str)) ? "0" : "1";
    }
}
