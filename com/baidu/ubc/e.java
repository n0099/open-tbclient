package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e jvZ;
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
    public static e crL() {
        if (jvZ == null) {
            synchronized (e.class) {
                if (jvZ == null) {
                    jvZ = new e();
                }
            }
        }
        return jvZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bpi = 360000;
        r crW = r.crW();
        this.bpj = crW.getInt("ubc_data_expire_time", 259200000);
        this.bpk = crW.getInt("ubc_database_limit", 4000);
        cVar.crJ().a(this.bpa, this.bpd, this.bpb, this.bpc, this.bpe, this.bpf, this.bpg, this.bph);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ev(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.crM())) {
                this.bpa.add(hVar.getId());
            } else {
                this.bpa.remove(hVar.getId());
            }
            if ("1".equals(hVar.crN())) {
                this.bpb.add(hVar.getId());
            } else {
                this.bpb.remove(hVar.getId());
            }
            if ("1".equals(hVar.crO())) {
                this.bpc.add(hVar.getId());
            } else {
                this.bpc.remove(hVar.getId());
            }
            if (hVar.crP() >= 1 && hVar.crP() <= 100) {
                this.bpe.put(hVar.getId(), String.valueOf(hVar.crP()));
            } else {
                this.bpe.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.bpf.put(hVar.getId(), hVar.getCategory());
            } else {
                this.bpf.remove(hVar.getId());
            }
            if (hVar.crR() != 0 && hVar.crQ() != 0) {
                i iVar = new i(hVar.getId(), hVar.crR(), hVar.crQ());
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
    public void BD(int i) {
        if (i >= this.bpj) {
            this.bpj = i;
            r.crW().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SZ() {
        return this.bpk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BE(int i) {
        if (i >= this.bpk) {
            this.bpk = i;
            r.crW().putInt("ubc_database_limit", i);
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
