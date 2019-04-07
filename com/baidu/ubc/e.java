package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e jwa;
    private HashSet<String> bpe = new HashSet<>();
    private HashSet<String> bpf = new HashSet<>();
    private HashSet<String> bpg = new HashSet<>();
    private HashSet<String> bph = new HashSet<>();
    private HashMap<String, String> bpi = new HashMap<>();
    private HashMap<String, String> bpj = new HashMap<>();
    private HashMap<String, i> bpk = new HashMap<>();
    private HashSet<String> bpl = new HashSet<>();
    private int bpm;
    private int bpn;
    private int bpo;
    private Context mContext;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e crW() {
        if (jwa == null) {
            synchronized (e.class) {
                if (jwa == null) {
                    jwa = new e();
                }
            }
        }
        return jwa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bpm = 360000;
        r csh = r.csh();
        this.bpn = csh.getInt("ubc_data_expire_time", 259200000);
        this.bpo = csh.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.crU().a(this.bpe, this.bph, this.bpf, this.bpg, this.bpi, this.bpj, this.bpk, this.bpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void es(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.crX())) {
                this.bpe.add(hVar.getId());
            } else {
                this.bpe.remove(hVar.getId());
            }
            if ("1".equals(hVar.crY())) {
                this.bpf.add(hVar.getId());
            } else {
                this.bpf.remove(hVar.getId());
            }
            if ("1".equals(hVar.crZ())) {
                this.bpg.add(hVar.getId());
            } else {
                this.bpg.remove(hVar.getId());
            }
            if (hVar.csa() >= 1 && hVar.csa() <= 100) {
                this.bpi.put(hVar.getId(), String.valueOf(hVar.csa()));
            } else {
                this.bpi.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.bpj.put(hVar.getId(), hVar.getCategory());
            } else {
                this.bpj.remove(hVar.getId());
            }
            if (hVar.csc() != 0 && hVar.csb() != 0) {
                i iVar = new i(hVar.getId(), hVar.csc(), hVar.csb());
                this.bpk.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.getIdType(), "1")) {
                this.bpl.add(hVar.getId());
            } else {
                this.bpl.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(String str, int i) {
        if (this.bpe.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bph.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jI(String str) {
        if (UBC.getUBCContext().Fo()) {
            return true;
        }
        return this.bpf.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jJ(String str) {
        return this.bpg.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String jK(String str) {
        return this.bpj.containsKey(str) ? this.bpj.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SV() {
        return this.bpm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fn(int i) {
        if (i * 60000 >= this.bpm) {
            this.bpm = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SW() {
        return this.bpn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BA(int i) {
        if (i >= this.bpn) {
            this.bpn = i;
            r.csh().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SX() {
        return this.bpo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BB(int i) {
        if (i >= this.bpo) {
            this.bpo = i;
            r.csh().putInt("ubc_database_limit", i);
        }
    }

    public int jL(String str) {
        if (TextUtils.isEmpty(str) || !this.bpi.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bpi.get(str));
    }

    public boolean jM(String str) {
        if (this.bpk == null || !this.bpk.containsKey(str)) {
            return false;
        }
        return this.bpk.get(str).SY();
    }

    public boolean jN(String str) {
        if (this.bpk == null || !this.bpk.containsKey(str)) {
            return false;
        }
        return this.bpk.get(str).SZ();
    }

    public String jO(String str) {
        return (TextUtils.isEmpty(str) || !this.bpl.contains(str)) ? "0" : "1";
    }
}
