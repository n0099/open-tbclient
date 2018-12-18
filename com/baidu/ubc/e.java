package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e ibv;
    private int ibE;
    private int ibF;
    private int ibG;
    private Context mContext;
    private HashSet<String> ibw = new HashSet<>();
    private HashSet<String> ibx = new HashSet<>();
    private HashSet<String> iby = new HashSet<>();
    private HashSet<String> ibz = new HashSet<>();
    private HashMap<String, String> ibA = new HashMap<>();
    private HashMap<String, String> ibB = new HashMap<>();
    private HashMap<String, i> ibC = new HashMap<>();
    private HashSet<String> ibD = new HashSet<>();

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e bQP() {
        if (ibv == null) {
            synchronized (e.class) {
                if (ibv == null) {
                    ibv = new e();
                }
            }
        }
        return ibv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.ibE = 360000;
        s bRu = s.bRu();
        this.ibF = bRu.getInt("ubc_data_expire_time", 259200000);
        this.ibG = bRu.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.bQM().a(this.ibw, this.ibz, this.ibx, this.iby, this.ibA, this.ibB, this.ibC, this.ibD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ep(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.bQT())) {
                this.ibw.add(hVar.getId());
            } else {
                this.ibw.remove(hVar.getId());
            }
            if ("1".equals(hVar.bQU())) {
                this.ibx.add(hVar.getId());
            } else {
                this.ibx.remove(hVar.getId());
            }
            if ("1".equals(hVar.bQV())) {
                this.iby.add(hVar.getId());
            } else {
                this.iby.remove(hVar.getId());
            }
            if (hVar.bQW() >= 1 && hVar.bQW() <= 100) {
                this.ibA.put(hVar.getId(), String.valueOf(hVar.bQW()));
            } else {
                this.ibA.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.ibB.put(hVar.getId(), hVar.getCategory());
            } else {
                this.ibB.remove(hVar.getId());
            }
            if (hVar.bQY() != 0 && hVar.bQX() != 0) {
                i iVar = new i(hVar.getId(), hVar.bQY(), hVar.bQX());
                this.ibC.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.getIdType(), "1")) {
                this.ibD.add(hVar.getId());
            } else {
                this.ibD.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean be(String str, int i) {
        if (this.ibw.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.ibz.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xY(String str) {
        if (o.bRr().Ze()) {
            return true;
        }
        return this.ibx.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xZ(String str) {
        return this.iby.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ya(String str) {
        return this.ibB.containsKey(str) ? this.ibB.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bQQ() {
        return this.ibE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xz(int i) {
        if (i * 60000 >= this.ibE) {
            this.ibE = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bQR() {
        return this.ibF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xA(int i) {
        if (i >= this.ibF) {
            this.ibF = i;
            s.bRu().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bQS() {
        return this.ibG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xB(int i) {
        if (i >= this.ibG) {
            this.ibG = i;
            s.bRu().putInt("ubc_database_limit", i);
        }
    }

    public int yb(String str) {
        if (TextUtils.isEmpty(str) || !this.ibA.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.ibA.get(str));
    }

    public boolean yc(String str) {
        if (this.ibC == null || !this.ibC.containsKey(str)) {
            return false;
        }
        return this.ibC.get(str).bQZ();
    }

    public boolean yd(String str) {
        if (this.ibC == null || !this.ibC.containsKey(str)) {
            return false;
        }
        return this.ibC.get(str).bRa();
    }

    public String ye(String str) {
        return (TextUtils.isEmpty(str) || !this.ibD.contains(str)) ? "0" : "1";
    }
}
