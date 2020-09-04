package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
/* loaded from: classes18.dex */
public class g {
    private static volatile g nfy;
    private int dJu;
    private int dJv;
    private int dJw;
    private Context mContext;
    private f nfz = new f();
    private ad neN = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g dLW() {
        if (nfy == null) {
            synchronized (e.class) {
                if (nfy == null) {
                    nfy = new g();
                }
            }
        }
        return nfy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dJu = 360000;
        ag dMm = ag.dMm();
        this.dJv = dMm.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.dJw = dMm.getInt("ubc_database_limit", 10000);
        cVar.dLT().a(this.nfz);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aB(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.aVH())) {
                    this.nfz.nfn.add(id);
                    this.nfz.nfq.remove(id);
                } else {
                    this.nfz.nfn.remove(id);
                    this.nfz.nfq.add(id);
                }
                if ("1".equals(kVar.aVI())) {
                    this.nfz.nfo.add(id);
                } else {
                    this.nfz.nfo.remove(id);
                }
                if ("1".equals(kVar.aVJ())) {
                    this.nfz.nfp.add(id);
                } else {
                    this.nfz.nfp.remove(id);
                }
                if ("1".equals(kVar.dLY())) {
                    this.nfz.nfr.add(id);
                } else {
                    this.nfz.nfr.remove(id);
                }
                if (kVar.aVK() >= 1 && kVar.aVK() <= 100) {
                    this.nfz.nfs.put(id, String.valueOf(kVar.aVK()));
                } else {
                    this.nfz.nfs.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.nfz.nft.put(id, kVar.getCategory());
                } else {
                    this.nfz.nft.remove(id);
                }
                if (kVar.aVM() != 0 && kVar.aVL() != 0) {
                    m mVar = new m(id, kVar.aVM(), kVar.aVL());
                    this.nfz.nfu.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.aVN(), "1")) {
                    this.nfz.nfv.add(id);
                } else {
                    this.nfz.nfv.remove(id);
                }
                if (TextUtils.equals(kVar.dMa(), "1")) {
                    this.nfz.nfw.add(id);
                } else {
                    this.nfz.nfw.remove(id);
                }
                String dMb = kVar.dMb();
                if (!TextUtils.isEmpty(dMb) && !TextUtils.equals(dMb, "0")) {
                    this.nfz.nfx.put(id, dMb);
                } else {
                    this.nfz.nfx.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ad(String str, int i) {
        if (this.nfz.nfn.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.nfz.nfq.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xb(String str) {
        if (this.neN.dMk()) {
            return true;
        }
        return this.nfz.nfo.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xc(String str) {
        return this.nfz.nfp.contains(str);
    }

    boolean Ty(String str) {
        return this.nfz.nfr.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xd(String str) {
        return this.nfz.nft.containsKey(str) ? this.nfz.nft.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aVC() {
        return this.dJu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void md(int i) {
        if (i * 60000 >= this.dJu) {
            this.dJu = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aVD() {
        return this.dJv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void me(int i) {
        if (i >= this.dJv) {
            this.dJv = i;
            ag.dMm().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aVE() {
        return this.dJw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mf(int i) {
        if (i >= this.dJw) {
            this.dJw = i;
            ag.dMm().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int xe(String str) {
        if (TextUtils.isEmpty(str) || !this.nfz.nfs.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.nfz.nfs.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xf(String str) {
        if (this.nfz.nfu == null || !this.nfz.nfu.containsKey(str)) {
            return false;
        }
        return this.nfz.nfu.get(str).aVO();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xg(String str) {
        if (this.nfz.nfu == null || !this.nfz.nfu.containsKey(str)) {
            return false;
        }
        return this.nfz.nfu.get(str).aVP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xh(String str) {
        return (TextUtils.isEmpty(str) || !this.nfz.nfv.contains(str)) ? "0" : "1";
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
        return this.nfz.nfw.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean TB(String str) {
        return this.nfz.nfo.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String TC(String str) {
        return this.nfz.nfx.containsKey(str) ? this.nfz.nfx.get(str) : "";
    }
}
