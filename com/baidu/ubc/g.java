package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
/* loaded from: classes9.dex */
public class g {
    private static volatile g mMk;
    private int dAh;
    private int dAi;
    private int dAj;
    private Context mContext;
    private f mMl = new f();
    private ad mLz = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g dAa() {
        if (mMk == null) {
            synchronized (e.class) {
                if (mMk == null) {
                    mMk = new g();
                }
            }
        }
        return mMk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dAh = 360000;
        ag dAq = ag.dAq();
        this.dAi = dAq.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.dAj = dAq.getInt("ubc_database_limit", 10000);
        cVar.dzX().a(this.mMl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aB(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.aNh())) {
                    this.mMl.mLZ.add(id);
                    this.mMl.mMc.remove(id);
                } else {
                    this.mMl.mLZ.remove(id);
                    this.mMl.mMc.add(id);
                }
                if ("1".equals(kVar.aNi())) {
                    this.mMl.mMa.add(id);
                } else {
                    this.mMl.mMa.remove(id);
                }
                if ("1".equals(kVar.aNj())) {
                    this.mMl.mMb.add(id);
                } else {
                    this.mMl.mMb.remove(id);
                }
                if ("1".equals(kVar.dAc())) {
                    this.mMl.mMd.add(id);
                } else {
                    this.mMl.mMd.remove(id);
                }
                if (kVar.aNk() >= 1 && kVar.aNk() <= 100) {
                    this.mMl.mMe.put(id, String.valueOf(kVar.aNk()));
                } else {
                    this.mMl.mMe.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.mMl.mMf.put(id, kVar.getCategory());
                } else {
                    this.mMl.mMf.remove(id);
                }
                if (kVar.aNm() != 0 && kVar.aNl() != 0) {
                    m mVar = new m(id, kVar.aNm(), kVar.aNl());
                    this.mMl.mMg.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.aNn(), "1")) {
                    this.mMl.mMh.add(id);
                } else {
                    this.mMl.mMh.remove(id);
                }
                if (TextUtils.equals(kVar.dAe(), "1")) {
                    this.mMl.mMi.add(id);
                } else {
                    this.mMl.mMi.remove(id);
                }
                String dAf = kVar.dAf();
                if (!TextUtils.isEmpty(dAf) && !TextUtils.equals(dAf, "0")) {
                    this.mMl.mMj.put(id, dAf);
                } else {
                    this.mMl.mMj.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ab(String str, int i) {
        if (this.mMl.mLZ.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.mMl.mMc.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean uP(String str) {
        if (this.mLz.dAo()) {
            return true;
        }
        return this.mMl.mMa.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean uQ(String str) {
        return this.mMl.mMb.contains(str);
    }

    boolean Qz(String str) {
        return this.mMl.mMd.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String uR(String str) {
        return this.mMl.mMf.containsKey(str) ? this.mMl.mMf.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aNc() {
        return this.dAh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jX(int i) {
        if (i * 60000 >= this.dAh) {
            this.dAh = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aNd() {
        return this.dAi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jY(int i) {
        if (i >= this.dAi) {
            this.dAi = i;
            ag.dAq().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aNe() {
        return this.dAj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jZ(int i) {
        if (i >= this.dAj) {
            this.dAj = i;
            ag.dAq().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int uS(String str) {
        if (TextUtils.isEmpty(str) || !this.mMl.mMe.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.mMl.mMe.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean uT(String str) {
        if (this.mMl.mMg == null || !this.mMl.mMg.containsKey(str)) {
            return false;
        }
        return this.mMl.mMg.get(str).aNo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean uU(String str) {
        if (this.mMl.mMg == null || !this.mMl.mMg.containsKey(str)) {
            return false;
        }
        return this.mMl.mMg.get(str).aNp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String uV(String str) {
        return (TextUtils.isEmpty(str) || !this.mMl.mMh.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean QA(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !Qz(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean QB(String str) {
        return this.mMl.mMi.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean QC(String str) {
        return this.mMl.mMa.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String QD(String str) {
        return this.mMl.mMj.containsKey(str) ? this.mMl.mMj.get(str) : "";
    }
}
