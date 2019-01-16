package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e ifP;
    private HashSet<String> ifQ = new HashSet<>();
    private HashSet<String> ifR = new HashSet<>();
    private HashSet<String> ifS = new HashSet<>();
    private HashSet<String> ifT = new HashSet<>();
    private HashMap<String, String> ifU = new HashMap<>();
    private HashMap<String, String> ifV = new HashMap<>();
    private HashMap<String, i> ifW = new HashMap<>();
    private HashSet<String> ifX = new HashSet<>();
    private int ifY;
    private int ifZ;
    private int iga;
    private Context mContext;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e bSo() {
        if (ifP == null) {
            synchronized (e.class) {
                if (ifP == null) {
                    ifP = new e();
                }
            }
        }
        return ifP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.ifY = 360000;
        s bST = s.bST();
        this.ifZ = bST.getInt("ubc_data_expire_time", 259200000);
        this.iga = bST.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.bSl().a(this.ifQ, this.ifT, this.ifR, this.ifS, this.ifU, this.ifV, this.ifW, this.ifX);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void er(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.bSs())) {
                this.ifQ.add(hVar.getId());
            } else {
                this.ifQ.remove(hVar.getId());
            }
            if ("1".equals(hVar.bSt())) {
                this.ifR.add(hVar.getId());
            } else {
                this.ifR.remove(hVar.getId());
            }
            if ("1".equals(hVar.bSu())) {
                this.ifS.add(hVar.getId());
            } else {
                this.ifS.remove(hVar.getId());
            }
            if (hVar.bSv() >= 1 && hVar.bSv() <= 100) {
                this.ifU.put(hVar.getId(), String.valueOf(hVar.bSv()));
            } else {
                this.ifU.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.ifV.put(hVar.getId(), hVar.getCategory());
            } else {
                this.ifV.remove(hVar.getId());
            }
            if (hVar.bSx() != 0 && hVar.bSw() != 0) {
                i iVar = new i(hVar.getId(), hVar.bSx(), hVar.bSw());
                this.ifW.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.getIdType(), "1")) {
                this.ifX.add(hVar.getId());
            } else {
                this.ifX.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bf(String str, int i) {
        if (this.ifQ.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.ifT.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yr(String str) {
        if (o.bSQ().ZD()) {
            return true;
        }
        return this.ifR.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ys(String str) {
        return this.ifS.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yt(String str) {
        return this.ifV.containsKey(str) ? this.ifV.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bSp() {
        return this.ifY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xO(int i) {
        if (i * 60000 >= this.ifY) {
            this.ifY = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bSq() {
        return this.ifZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xP(int i) {
        if (i >= this.ifZ) {
            this.ifZ = i;
            s.bST().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bSr() {
        return this.iga;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xQ(int i) {
        if (i >= this.iga) {
            this.iga = i;
            s.bST().putInt("ubc_database_limit", i);
        }
    }

    public int yu(String str) {
        if (TextUtils.isEmpty(str) || !this.ifU.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.ifU.get(str));
    }

    public boolean yv(String str) {
        if (this.ifW == null || !this.ifW.containsKey(str)) {
            return false;
        }
        return this.ifW.get(str).bSy();
    }

    public boolean yw(String str) {
        if (this.ifW == null || !this.ifW.containsKey(str)) {
            return false;
        }
        return this.ifW.get(str).bSz();
    }

    public String yx(String str) {
        return (TextUtils.isEmpty(str) || !this.ifX.contains(str)) ? "0" : "1";
    }
}
