package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e jws;
    private HashSet<String> bpa = new HashSet<>();
    private HashSet<String> bpb = new HashSet<>();
    private HashSet<String> bpc = new HashSet<>();
    private HashSet<String> bpd = new HashSet<>();
    private HashMap<String, String> bpe = new HashMap<>();
    private HashMap<String, String> bpf = new HashMap<>();
    private HashMap<String, i> bpg = new HashMap<>();
    private HashSet<String> bph = new HashSet<>();
    private int bpi;
    private int bpj;
    private int bpk;
    private Context mContext;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e crV() {
        if (jws == null) {
            synchronized (e.class) {
                if (jws == null) {
                    jws = new e();
                }
            }
        }
        return jws;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bpi = 360000;
        r csg = r.csg();
        this.bpj = csg.getInt("ubc_data_expire_time", 259200000);
        this.bpk = csg.getInt("ubc_database_limit", 4000);
        cVar.crT().a(this.bpa, this.bpd, this.bpb, this.bpc, this.bpe, this.bpf, this.bpg, this.bph);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ev(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.crW())) {
                this.bpa.add(hVar.getId());
            } else {
                this.bpa.remove(hVar.getId());
            }
            if ("1".equals(hVar.crX())) {
                this.bpb.add(hVar.getId());
            } else {
                this.bpb.remove(hVar.getId());
            }
            if ("1".equals(hVar.crY())) {
                this.bpc.add(hVar.getId());
            } else {
                this.bpc.remove(hVar.getId());
            }
            if (hVar.crZ() >= 1 && hVar.crZ() <= 100) {
                this.bpe.put(hVar.getId(), String.valueOf(hVar.crZ()));
            } else {
                this.bpe.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.bpf.put(hVar.getId(), hVar.getCategory());
            } else {
                this.bpf.remove(hVar.getId());
            }
            if (hVar.csb() != 0 && hVar.csa() != 0) {
                i iVar = new i(hVar.getId(), hVar.csb(), hVar.csa());
                this.bpg.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.getIdType(), "1")) {
                this.bph.add(hVar.getId());
            } else {
                this.bph.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(String str, int i) {
        if (this.bpa.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bpd.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jH(String str) {
        if (UBC.getUBCContext().Fq()) {
            return true;
        }
        return this.bpb.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jI(String str) {
        return this.bpc.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String jJ(String str) {
        return this.bpf.containsKey(str) ? this.bpf.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SX() {
        return this.bpi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fo(int i) {
        if (i * 60000 >= this.bpi) {
            this.bpi = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SY() {
        return this.bpj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BE(int i) {
        if (i >= this.bpj) {
            this.bpj = i;
            r.csg().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SZ() {
        return this.bpk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BF(int i) {
        if (i >= this.bpk) {
            this.bpk = i;
            r.csg().putInt("ubc_database_limit", i);
        }
    }

    public int jK(String str) {
        if (TextUtils.isEmpty(str) || !this.bpe.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bpe.get(str));
    }

    public boolean jL(String str) {
        if (this.bpg == null || !this.bpg.containsKey(str)) {
            return false;
        }
        return this.bpg.get(str).Ta();
    }

    public boolean jM(String str) {
        if (this.bpg == null || !this.bpg.containsKey(str)) {
            return false;
        }
        return this.bpg.get(str).Tb();
    }

    public String jN(String str) {
        return (TextUtils.isEmpty(str) || !this.bph.contains(str)) ? "0" : "1";
    }
}
