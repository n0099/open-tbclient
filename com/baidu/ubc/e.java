package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e jwk;
    private HashSet<String> bpb = new HashSet<>();
    private HashSet<String> bpc = new HashSet<>();
    private HashSet<String> bpd = new HashSet<>();
    private HashSet<String> bpe = new HashSet<>();
    private HashMap<String, String> bpf = new HashMap<>();
    private HashMap<String, String> bpg = new HashMap<>();
    private HashMap<String, i> bph = new HashMap<>();
    private HashSet<String> bpi = new HashSet<>();
    private int bpj;
    private int bpk;
    private int bpl;
    private Context mContext;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e crY() {
        if (jwk == null) {
            synchronized (e.class) {
                if (jwk == null) {
                    jwk = new e();
                }
            }
        }
        return jwk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bpj = 360000;
        r csj = r.csj();
        this.bpk = csj.getInt("ubc_data_expire_time", 259200000);
        this.bpl = csj.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.crW().a(this.bpb, this.bpe, this.bpc, this.bpd, this.bpf, this.bpg, this.bph, this.bpi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ev(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.crZ())) {
                this.bpb.add(hVar.getId());
            } else {
                this.bpb.remove(hVar.getId());
            }
            if ("1".equals(hVar.csa())) {
                this.bpc.add(hVar.getId());
            } else {
                this.bpc.remove(hVar.getId());
            }
            if ("1".equals(hVar.csb())) {
                this.bpd.add(hVar.getId());
            } else {
                this.bpd.remove(hVar.getId());
            }
            if (hVar.csc() >= 1 && hVar.csc() <= 100) {
                this.bpf.put(hVar.getId(), String.valueOf(hVar.csc()));
            } else {
                this.bpf.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.bpg.put(hVar.getId(), hVar.getCategory());
            } else {
                this.bpg.remove(hVar.getId());
            }
            if (hVar.cse() != 0 && hVar.csd() != 0) {
                i iVar = new i(hVar.getId(), hVar.cse(), hVar.csd());
                this.bph.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.getIdType(), "1")) {
                this.bpi.add(hVar.getId());
            } else {
                this.bpi.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(String str, int i) {
        if (this.bpb.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bpe.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jH(String str) {
        if (UBC.getUBCContext().Fq()) {
            return true;
        }
        return this.bpc.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jI(String str) {
        return this.bpd.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String jJ(String str) {
        return this.bpg.containsKey(str) ? this.bpg.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SX() {
        return this.bpj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fo(int i) {
        if (i * 60000 >= this.bpj) {
            this.bpj = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SY() {
        return this.bpk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BE(int i) {
        if (i >= this.bpk) {
            this.bpk = i;
            r.csj().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SZ() {
        return this.bpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BF(int i) {
        if (i >= this.bpl) {
            this.bpl = i;
            r.csj().putInt("ubc_database_limit", i);
        }
    }

    public int jK(String str) {
        if (TextUtils.isEmpty(str) || !this.bpf.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bpf.get(str));
    }

    public boolean jL(String str) {
        if (this.bph == null || !this.bph.containsKey(str)) {
            return false;
        }
        return this.bph.get(str).Ta();
    }

    public boolean jM(String str) {
        if (this.bph == null || !this.bph.containsKey(str)) {
            return false;
        }
        return this.bph.get(str).Tb();
    }

    public String jN(String str) {
        return (TextUtils.isEmpty(str) || !this.bpi.contains(str)) ? "0" : "1";
    }
}
