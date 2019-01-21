package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e ifQ;
    private HashSet<String> ifR = new HashSet<>();
    private HashSet<String> ifS = new HashSet<>();
    private HashSet<String> ifT = new HashSet<>();
    private HashSet<String> ifU = new HashSet<>();
    private HashMap<String, String> ifV = new HashMap<>();
    private HashMap<String, String> ifW = new HashMap<>();
    private HashMap<String, i> ifX = new HashMap<>();
    private HashSet<String> ifY = new HashSet<>();
    private int ifZ;
    private int iga;
    private int igb;
    private Context mContext;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e bSo() {
        if (ifQ == null) {
            synchronized (e.class) {
                if (ifQ == null) {
                    ifQ = new e();
                }
            }
        }
        return ifQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.ifZ = 360000;
        s bST = s.bST();
        this.iga = bST.getInt("ubc_data_expire_time", 259200000);
        this.igb = bST.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.bSl().a(this.ifR, this.ifU, this.ifS, this.ifT, this.ifV, this.ifW, this.ifX, this.ifY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void er(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.bSs())) {
                this.ifR.add(hVar.getId());
            } else {
                this.ifR.remove(hVar.getId());
            }
            if ("1".equals(hVar.bSt())) {
                this.ifS.add(hVar.getId());
            } else {
                this.ifS.remove(hVar.getId());
            }
            if ("1".equals(hVar.bSu())) {
                this.ifT.add(hVar.getId());
            } else {
                this.ifT.remove(hVar.getId());
            }
            if (hVar.bSv() >= 1 && hVar.bSv() <= 100) {
                this.ifV.put(hVar.getId(), String.valueOf(hVar.bSv()));
            } else {
                this.ifV.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.ifW.put(hVar.getId(), hVar.getCategory());
            } else {
                this.ifW.remove(hVar.getId());
            }
            if (hVar.bSx() != 0 && hVar.bSw() != 0) {
                i iVar = new i(hVar.getId(), hVar.bSx(), hVar.bSw());
                this.ifX.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.getIdType(), "1")) {
                this.ifY.add(hVar.getId());
            } else {
                this.ifY.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bf(String str, int i) {
        if (this.ifR.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.ifU.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yr(String str) {
        if (o.bSQ().ZD()) {
            return true;
        }
        return this.ifS.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ys(String str) {
        return this.ifT.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yt(String str) {
        return this.ifW.containsKey(str) ? this.ifW.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bSp() {
        return this.ifZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xO(int i) {
        if (i * 60000 >= this.ifZ) {
            this.ifZ = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bSq() {
        return this.iga;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xP(int i) {
        if (i >= this.iga) {
            this.iga = i;
            s.bST().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bSr() {
        return this.igb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xQ(int i) {
        if (i >= this.igb) {
            this.igb = i;
            s.bST().putInt("ubc_database_limit", i);
        }
    }

    public int yu(String str) {
        if (TextUtils.isEmpty(str) || !this.ifV.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.ifV.get(str));
    }

    public boolean yv(String str) {
        if (this.ifX == null || !this.ifX.containsKey(str)) {
            return false;
        }
        return this.ifX.get(str).bSy();
    }

    public boolean yw(String str) {
        if (this.ifX == null || !this.ifX.containsKey(str)) {
            return false;
        }
        return this.ifX.get(str).bSz();
    }

    public String yx(String str) {
        return (TextUtils.isEmpty(str) || !this.ifY.contains(str)) ? "0" : "1";
    }
}
