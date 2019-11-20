package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e jWP;
    private HashSet<String> bOn = new HashSet<>();
    private HashSet<String> bOo = new HashSet<>();
    private HashSet<String> bOp = new HashSet<>();
    private HashSet<String> bOq = new HashSet<>();
    private HashMap<String, String> bOr = new HashMap<>();
    private HashMap<String, String> bOs = new HashMap<>();
    private HashMap<String, i> bOt = new HashMap<>();
    private HashSet<String> bOu = new HashSet<>();
    private int bOv;
    private int bOw;
    private int bOx;
    private Context mContext;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e cAT() {
        if (jWP == null) {
            synchronized (e.class) {
                if (jWP == null) {
                    jWP = new e();
                }
            }
        }
        return jWP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bOv = 360000;
        r cAU = r.cAU();
        this.bOw = cAU.getInt("ubc_data_expire_time", 259200000);
        this.bOx = cAU.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.cAR().a(this.bOn, this.bOq, this.bOo, this.bOp, this.bOr, this.bOs, this.bOt, this.bOu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ai(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.acx())) {
                this.bOn.add(hVar.getId());
            } else {
                this.bOn.remove(hVar.getId());
            }
            if ("1".equals(hVar.acy())) {
                this.bOo.add(hVar.getId());
            } else {
                this.bOo.remove(hVar.getId());
            }
            if ("1".equals(hVar.acz())) {
                this.bOp.add(hVar.getId());
            } else {
                this.bOp.remove(hVar.getId());
            }
            if (hVar.acA() >= 1 && hVar.acA() <= 100) {
                this.bOr.put(hVar.getId(), String.valueOf(hVar.acA()));
            } else {
                this.bOr.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.bOs.put(hVar.getId(), hVar.getCategory());
            } else {
                this.bOs.remove(hVar.getId());
            }
            if (hVar.acC() != 0 && hVar.acB() != 0) {
                i iVar = new i(hVar.getId(), hVar.acC(), hVar.acB());
                this.bOt.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.acD(), "1")) {
                this.bOu.add(hVar.getId());
            } else {
                this.bOu.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J(String str, int i) {
        if (this.bOn.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bOq.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean lr(String str) {
        if (UBC.getUBCContext().Ne()) {
            return true;
        }
        return this.bOo.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ls(String str) {
        return this.bOp.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String lt(String str) {
        return this.bOs.containsKey(str) ? this.bOs.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int acu() {
        return this.bOv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gQ(int i) {
        if (i * 60000 >= this.bOv) {
            this.bOv = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int acv() {
        return this.bOw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gR(int i) {
        if (i >= this.bOw) {
            this.bOw = i;
            r.cAU().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int acw() {
        return this.bOx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gS(int i) {
        if (i >= this.bOx) {
            this.bOx = i;
            r.cAU().putInt("ubc_database_limit", i);
        }
    }

    public int lu(String str) {
        if (TextUtils.isEmpty(str) || !this.bOr.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bOr.get(str));
    }

    public boolean lv(String str) {
        if (this.bOt == null || !this.bOt.containsKey(str)) {
            return false;
        }
        return this.bOt.get(str).acE();
    }

    public boolean lw(String str) {
        if (this.bOt == null || !this.bOt.containsKey(str)) {
            return false;
        }
        return this.bOt.get(str).acF();
    }

    public String lx(String str) {
        return (TextUtils.isEmpty(str) || !this.bOu.contains(str)) ? "0" : "1";
    }
}
