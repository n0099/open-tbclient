package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
/* loaded from: classes18.dex */
public class g {
    private static volatile g nfg;
    private int dJq;
    private int dJr;
    private int dJs;
    private Context mContext;
    private f nfh = new f();
    private ad nev = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g dLN() {
        if (nfg == null) {
            synchronized (e.class) {
                if (nfg == null) {
                    nfg = new g();
                }
            }
        }
        return nfg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dJq = 360000;
        ag dMd = ag.dMd();
        this.dJr = dMd.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.dJs = dMd.getInt("ubc_database_limit", 10000);
        cVar.dLK().a(this.nfh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aB(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.aVH())) {
                    this.nfh.neV.add(id);
                    this.nfh.neY.remove(id);
                } else {
                    this.nfh.neV.remove(id);
                    this.nfh.neY.add(id);
                }
                if ("1".equals(kVar.aVI())) {
                    this.nfh.neW.add(id);
                } else {
                    this.nfh.neW.remove(id);
                }
                if ("1".equals(kVar.aVJ())) {
                    this.nfh.neX.add(id);
                } else {
                    this.nfh.neX.remove(id);
                }
                if ("1".equals(kVar.dLP())) {
                    this.nfh.neZ.add(id);
                } else {
                    this.nfh.neZ.remove(id);
                }
                if (kVar.aVK() >= 1 && kVar.aVK() <= 100) {
                    this.nfh.nfa.put(id, String.valueOf(kVar.aVK()));
                } else {
                    this.nfh.nfa.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.nfh.nfb.put(id, kVar.getCategory());
                } else {
                    this.nfh.nfb.remove(id);
                }
                if (kVar.aVM() != 0 && kVar.aVL() != 0) {
                    m mVar = new m(id, kVar.aVM(), kVar.aVL());
                    this.nfh.nfc.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.aVN(), "1")) {
                    this.nfh.nfd.add(id);
                } else {
                    this.nfh.nfd.remove(id);
                }
                if (TextUtils.equals(kVar.dLR(), "1")) {
                    this.nfh.nfe.add(id);
                } else {
                    this.nfh.nfe.remove(id);
                }
                String dLS = kVar.dLS();
                if (!TextUtils.isEmpty(dLS) && !TextUtils.equals(dLS, "0")) {
                    this.nfh.nff.put(id, dLS);
                } else {
                    this.nfh.nff.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ad(String str, int i) {
        if (this.nfh.neV.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.nfh.neY.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xa(String str) {
        if (this.nev.dMb()) {
            return true;
        }
        return this.nfh.neW.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xb(String str) {
        return this.nfh.neX.contains(str);
    }

    boolean Ty(String str) {
        return this.nfh.neZ.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xc(String str) {
        return this.nfh.nfb.containsKey(str) ? this.nfh.nfb.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aVC() {
        return this.dJq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void md(int i) {
        if (i * 60000 >= this.dJq) {
            this.dJq = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aVD() {
        return this.dJr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void me(int i) {
        if (i >= this.dJr) {
            this.dJr = i;
            ag.dMd().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aVE() {
        return this.dJs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mf(int i) {
        if (i >= this.dJs) {
            this.dJs = i;
            ag.dMd().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int xd(String str) {
        if (TextUtils.isEmpty(str) || !this.nfh.nfa.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.nfh.nfa.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xe(String str) {
        if (this.nfh.nfc == null || !this.nfh.nfc.containsKey(str)) {
            return false;
        }
        return this.nfh.nfc.get(str).aVO();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xf(String str) {
        if (this.nfh.nfc == null || !this.nfh.nfc.containsKey(str)) {
            return false;
        }
        return this.nfh.nfc.get(str).aVP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xg(String str) {
        return (TextUtils.isEmpty(str) || !this.nfh.nfd.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Tz(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !Ty(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean TA(String str) {
        return this.nfh.nfe.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean TB(String str) {
        return this.nfh.neW.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String TC(String str) {
        return this.nfh.nff.containsKey(str) ? this.nfh.nff.get(str) : "";
    }
}
