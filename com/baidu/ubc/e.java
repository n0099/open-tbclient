package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e ieI;
    private HashSet<String> ieJ = new HashSet<>();
    private HashSet<String> ieK = new HashSet<>();
    private HashSet<String> ieL = new HashSet<>();
    private HashSet<String> ieM = new HashSet<>();
    private HashMap<String, String> ieN = new HashMap<>();
    private HashMap<String, String> ieO = new HashMap<>();
    private HashMap<String, i> ieP = new HashMap<>();
    private HashSet<String> ieQ = new HashSet<>();
    private int ieR;
    private int ieS;
    private int ieT;
    private Context mContext;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e bRG() {
        if (ieI == null) {
            synchronized (e.class) {
                if (ieI == null) {
                    ieI = new e();
                }
            }
        }
        return ieI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.ieR = 360000;
        s bSl = s.bSl();
        this.ieS = bSl.getInt("ubc_data_expire_time", 259200000);
        this.ieT = bSl.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.bRD().a(this.ieJ, this.ieM, this.ieK, this.ieL, this.ieN, this.ieO, this.ieP, this.ieQ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eq(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.bRK())) {
                this.ieJ.add(hVar.getId());
            } else {
                this.ieJ.remove(hVar.getId());
            }
            if ("1".equals(hVar.bRL())) {
                this.ieK.add(hVar.getId());
            } else {
                this.ieK.remove(hVar.getId());
            }
            if ("1".equals(hVar.bRM())) {
                this.ieL.add(hVar.getId());
            } else {
                this.ieL.remove(hVar.getId());
            }
            if (hVar.bRN() >= 1 && hVar.bRN() <= 100) {
                this.ieN.put(hVar.getId(), String.valueOf(hVar.bRN()));
            } else {
                this.ieN.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.ieO.put(hVar.getId(), hVar.getCategory());
            } else {
                this.ieO.remove(hVar.getId());
            }
            if (hVar.bRP() != 0 && hVar.bRO() != 0) {
                i iVar = new i(hVar.getId(), hVar.bRP(), hVar.bRO());
                this.ieP.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.getIdType(), "1")) {
                this.ieQ.add(hVar.getId());
            } else {
                this.ieQ.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bf(String str, int i) {
        if (this.ieJ.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.ieM.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yb(String str) {
        if (o.bSi().Zg()) {
            return true;
        }
        return this.ieK.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yc(String str) {
        return this.ieL.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yd(String str) {
        return this.ieO.containsKey(str) ? this.ieO.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bRH() {
        return this.ieR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xM(int i) {
        if (i * 60000 >= this.ieR) {
            this.ieR = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bRI() {
        return this.ieS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xN(int i) {
        if (i >= this.ieS) {
            this.ieS = i;
            s.bSl().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bRJ() {
        return this.ieT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xO(int i) {
        if (i >= this.ieT) {
            this.ieT = i;
            s.bSl().putInt("ubc_database_limit", i);
        }
    }

    public int ye(String str) {
        if (TextUtils.isEmpty(str) || !this.ieN.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.ieN.get(str));
    }

    public boolean yf(String str) {
        if (this.ieP == null || !this.ieP.containsKey(str)) {
            return false;
        }
        return this.ieP.get(str).bRQ();
    }

    public boolean yg(String str) {
        if (this.ieP == null || !this.ieP.containsKey(str)) {
            return false;
        }
        return this.ieP.get(str).bRR();
    }

    public String yh(String str) {
        return (TextUtils.isEmpty(str) || !this.ieQ.contains(str)) ? "0" : "1";
    }
}
