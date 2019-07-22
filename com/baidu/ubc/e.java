package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e jWe;
    private HashSet<String> bvZ = new HashSet<>();
    private HashSet<String> bwa = new HashSet<>();
    private HashSet<String> bwb = new HashSet<>();
    private HashSet<String> bwc = new HashSet<>();
    private HashMap<String, String> bwd = new HashMap<>();
    private HashMap<String, String> bwe = new HashMap<>();
    private HashMap<String, i> bwf = new HashMap<>();
    private HashSet<String> bwg = new HashSet<>();
    private int bwh;
    private int bwi;
    private int bwj;
    private Context mContext;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e cDc() {
        if (jWe == null) {
            synchronized (e.class) {
                if (jWe == null) {
                    jWe = new e();
                }
            }
        }
        return jWe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bwh = 360000;
        r cDd = r.cDd();
        this.bwi = cDd.getInt("ubc_data_expire_time", 259200000);
        this.bwj = cDd.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.cDa().a(this.bvZ, this.bwc, this.bwa, this.bwb, this.bwd, this.bwe, this.bwf, this.bwg);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.XG())) {
                this.bvZ.add(hVar.getId());
            } else {
                this.bvZ.remove(hVar.getId());
            }
            if ("1".equals(hVar.XH())) {
                this.bwa.add(hVar.getId());
            } else {
                this.bwa.remove(hVar.getId());
            }
            if ("1".equals(hVar.XI())) {
                this.bwb.add(hVar.getId());
            } else {
                this.bwb.remove(hVar.getId());
            }
            if (hVar.XJ() >= 1 && hVar.XJ() <= 100) {
                this.bwd.put(hVar.getId(), String.valueOf(hVar.XJ()));
            } else {
                this.bwd.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.bwe.put(hVar.getId(), hVar.getCategory());
            } else {
                this.bwe.remove(hVar.getId());
            }
            if (hVar.XL() != 0 && hVar.XK() != 0) {
                i iVar = new i(hVar.getId(), hVar.XL(), hVar.XK());
                this.bwf.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.XM(), "1")) {
                this.bwg.add(hVar.getId());
            } else {
                this.bwg.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J(String str, int i) {
        if (this.bvZ.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bwc.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kN(String str) {
        if (UBC.getUBCContext().If()) {
            return true;
        }
        return this.bwa.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kO(String str) {
        return this.bwb.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String kP(String str) {
        return this.bwe.containsKey(str) ? this.bwe.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int XD() {
        return this.bwh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fV(int i) {
        if (i * 60000 >= this.bwh) {
            this.bwh = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int XE() {
        return this.bwi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fW(int i) {
        if (i >= this.bwi) {
            this.bwi = i;
            r.cDd().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int XF() {
        return this.bwj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fX(int i) {
        if (i >= this.bwj) {
            this.bwj = i;
            r.cDd().putInt("ubc_database_limit", i);
        }
    }

    public int kQ(String str) {
        if (TextUtils.isEmpty(str) || !this.bwd.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bwd.get(str));
    }

    public boolean kR(String str) {
        if (this.bwf == null || !this.bwf.containsKey(str)) {
            return false;
        }
        return this.bwf.get(str).XN();
    }

    public boolean kS(String str) {
        if (this.bwf == null || !this.bwf.containsKey(str)) {
            return false;
        }
        return this.bwf.get(str).XO();
    }

    public String kT(String str) {
        return (TextUtils.isEmpty(str) || !this.bwg.contains(str)) ? "0" : "1";
    }
}
