package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile e hUl;
    private HashSet<String> hUm = new HashSet<>();
    private HashSet<String> hUn = new HashSet<>();
    private HashSet<String> hUo = new HashSet<>();
    private HashSet<String> hUp = new HashSet<>();
    private HashMap<String, String> hUq = new HashMap<>();
    private HashMap<String, String> hUr = new HashMap<>();
    private HashMap<String, i> hUs = new HashMap<>();
    private HashSet<String> hUt = new HashSet<>();
    private int hUu;
    private int hUv;
    private int hUw;
    private Context mContext;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e bOK() {
        if (hUl == null) {
            synchronized (e.class) {
                if (hUl == null) {
                    hUl = new e();
                }
            }
        }
        return hUl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.hUu = 360000;
        s bPp = s.bPp();
        this.hUv = bPp.getInt("ubc_data_expire_time", 259200000);
        this.hUw = bPp.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.bOH().a(this.hUm, this.hUp, this.hUn, this.hUo, this.hUq, this.hUr, this.hUs, this.hUt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void el(List<h> list) {
        for (h hVar : list) {
            if ("0".equals(hVar.bOO())) {
                this.hUm.add(hVar.getId());
            } else {
                this.hUm.remove(hVar.getId());
            }
            if ("1".equals(hVar.bOP())) {
                this.hUn.add(hVar.getId());
            } else {
                this.hUn.remove(hVar.getId());
            }
            if ("1".equals(hVar.bOQ())) {
                this.hUo.add(hVar.getId());
            } else {
                this.hUo.remove(hVar.getId());
            }
            if (hVar.bOR() >= 1 && hVar.bOR() <= 100) {
                this.hUq.put(hVar.getId(), String.valueOf(hVar.bOR()));
            } else {
                this.hUq.remove(hVar.getId());
            }
            if (!TextUtils.isEmpty(hVar.getCategory())) {
                this.hUr.put(hVar.getId(), hVar.getCategory());
            } else {
                this.hUr.remove(hVar.getId());
            }
            if (hVar.bOT() != 0 && hVar.bOS() != 0) {
                i iVar = new i(hVar.getId(), hVar.bOT(), hVar.bOS());
                this.hUs.put(iVar.getId(), iVar);
            }
            if (TextUtils.equals(hVar.getIdType(), "1")) {
                this.hUt.add(hVar.getId());
            } else {
                this.hUt.remove(hVar.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bd(String str, int i) {
        if (this.hUm.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.hUp.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xv(String str) {
        if (o.bPm().Ya()) {
            return true;
        }
        return this.hUn.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xw(String str) {
        return this.hUo.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xx(String str) {
        return this.hUr.containsKey(str) ? this.hUr.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bOL() {
        return this.hUu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xc(int i) {
        if (i * 60000 >= this.hUu) {
            this.hUu = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bOM() {
        return this.hUv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xd(int i) {
        if (i >= this.hUv) {
            this.hUv = i;
            s.bPp().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bON() {
        return this.hUw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xe(int i) {
        if (i >= this.hUw) {
            this.hUw = i;
            s.bPp().putInt("ubc_database_limit", i);
        }
    }

    public int xy(String str) {
        if (TextUtils.isEmpty(str) || !this.hUq.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.hUq.get(str));
    }

    public boolean xz(String str) {
        if (this.hUs == null || !this.hUs.containsKey(str)) {
            return false;
        }
        return this.hUs.get(str).bOU();
    }

    public boolean xA(String str) {
        if (this.hUs == null || !this.hUs.containsKey(str)) {
            return false;
        }
        return this.hUs.get(str).bOV();
    }

    public String xB(String str) {
        return (TextUtils.isEmpty(str) || !this.hUt.contains(str)) ? "0" : "1";
    }
}
