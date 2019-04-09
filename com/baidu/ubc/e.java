package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e jwb;
    private HashSet<String> bpf = new HashSet<>();
    private HashSet<String> bpg = new HashSet<>();
    private HashSet<String> bph = new HashSet<>();
    private HashSet<String> bpi = new HashSet<>();
    private HashMap<String, String> bpj = new HashMap<>();
    private HashMap<String, String> bpk = new HashMap<>();
    private HashMap<String, i> bpl = new HashMap<>();
    private HashSet<String> bpm = new HashSet<>();
    private int bpn;
    private int bpo;
    private int bpp;
    private Context mContext;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e crW() {
        if (jwb == null) {
            synchronized (e.class) {
                if (jwb == null) {
                    jwb = new e();
                }
            }
        }
        return jwb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bpn = 360000;
        r csh = r.csh();
        this.bpo = csh.getInt("ubc_data_expire_time", 259200000);
        this.bpp = csh.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.crU().a(this.bpf, this.bpi, this.bpg, this.bph, this.bpj, this.bpk, this.bpl, this.bpm);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void es(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.crX())) {
                this.bpf.add(hVar.getId());
            } else {
                this.bpf.remove(hVar.getId());
            }
            if ("1".equals(hVar.crY())) {
                this.bpg.add(hVar.getId());
            } else {
                this.bpg.remove(hVar.getId());
            }
            if ("1".equals(hVar.crZ())) {
                this.bph.add(hVar.getId());
            } else {
                this.bph.remove(hVar.getId());
            }
            if (hVar.csa() >= 1 && hVar.csa() <= 100) {
                this.bpj.put(hVar.getId(), String.valueOf(hVar.csa()));
            } else {
                this.bpj.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.bpk.put(hVar.getId(), hVar.getCategory());
            } else {
                this.bpk.remove(hVar.getId());
            }
            if (hVar.csc() != 0 && hVar.csb() != 0) {
                i iVar = new i(hVar.getId(), hVar.csc(), hVar.csb());
                this.bpl.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.getIdType(), "1")) {
                this.bpm.add(hVar.getId());
            } else {
                this.bpm.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(String str, int i) {
        if (this.bpf.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bpi.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jI(String str) {
        if (UBC.getUBCContext().Fo()) {
            return true;
        }
        return this.bpg.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jJ(String str) {
        return this.bph.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String jK(String str) {
        return this.bpk.containsKey(str) ? this.bpk.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SV() {
        return this.bpn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fn(int i) {
        if (i * 60000 >= this.bpn) {
            this.bpn = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SW() {
        return this.bpo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BA(int i) {
        if (i >= this.bpo) {
            this.bpo = i;
            r.csh().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SX() {
        return this.bpp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BB(int i) {
        if (i >= this.bpp) {
            this.bpp = i;
            r.csh().putInt("ubc_database_limit", i);
        }
    }

    public int jL(String str) {
        if (TextUtils.isEmpty(str) || !this.bpj.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bpj.get(str));
    }

    public boolean jM(String str) {
        if (this.bpl == null || !this.bpl.containsKey(str)) {
            return false;
        }
        return this.bpl.get(str).SY();
    }

    public boolean jN(String str) {
        if (this.bpl == null || !this.bpl.containsKey(str)) {
            return false;
        }
        return this.bpl.get(str).SZ();
    }

    public String jO(String str) {
        return (TextUtils.isEmpty(str) || !this.bpm.contains(str)) ? "0" : "1";
    }
}
