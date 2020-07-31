package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
/* loaded from: classes9.dex */
public class g {
    private static volatile g mMi;
    private int dAh;
    private int dAi;
    private int dAj;
    private Context mContext;
    private f mMj = new f();
    private ad mLx = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g dzZ() {
        if (mMi == null) {
            synchronized (e.class) {
                if (mMi == null) {
                    mMi = new g();
                }
            }
        }
        return mMi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dAh = 360000;
        ag dAp = ag.dAp();
        this.dAi = dAp.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.dAj = dAp.getInt("ubc_database_limit", 10000);
        cVar.dzW().a(this.mMj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aB(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.aNh())) {
                    this.mMj.mLX.add(id);
                    this.mMj.mMa.remove(id);
                } else {
                    this.mMj.mLX.remove(id);
                    this.mMj.mMa.add(id);
                }
                if ("1".equals(kVar.aNi())) {
                    this.mMj.mLY.add(id);
                } else {
                    this.mMj.mLY.remove(id);
                }
                if ("1".equals(kVar.aNj())) {
                    this.mMj.mLZ.add(id);
                } else {
                    this.mMj.mLZ.remove(id);
                }
                if ("1".equals(kVar.dAb())) {
                    this.mMj.mMb.add(id);
                } else {
                    this.mMj.mMb.remove(id);
                }
                if (kVar.aNk() >= 1 && kVar.aNk() <= 100) {
                    this.mMj.mMc.put(id, String.valueOf(kVar.aNk()));
                } else {
                    this.mMj.mMc.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.mMj.mMd.put(id, kVar.getCategory());
                } else {
                    this.mMj.mMd.remove(id);
                }
                if (kVar.aNm() != 0 && kVar.aNl() != 0) {
                    m mVar = new m(id, kVar.aNm(), kVar.aNl());
                    this.mMj.mMe.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.aNn(), "1")) {
                    this.mMj.mMf.add(id);
                } else {
                    this.mMj.mMf.remove(id);
                }
                if (TextUtils.equals(kVar.dAd(), "1")) {
                    this.mMj.mMg.add(id);
                } else {
                    this.mMj.mMg.remove(id);
                }
                String dAe = kVar.dAe();
                if (!TextUtils.isEmpty(dAe) && !TextUtils.equals(dAe, "0")) {
                    this.mMj.mMh.put(id, dAe);
                } else {
                    this.mMj.mMh.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ab(String str, int i) {
        if (this.mMj.mLX.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.mMj.mMa.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean uP(String str) {
        if (this.mLx.dAn()) {
            return true;
        }
        return this.mMj.mLY.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean uQ(String str) {
        return this.mMj.mLZ.contains(str);
    }

    boolean Qz(String str) {
        return this.mMj.mMb.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String uR(String str) {
        return this.mMj.mMd.containsKey(str) ? this.mMj.mMd.get(str) : "";
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
            ag.dAp().putInt("ubc_data_expire_time", i);
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
            ag.dAp().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int uS(String str) {
        if (TextUtils.isEmpty(str) || !this.mMj.mMc.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.mMj.mMc.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean uT(String str) {
        if (this.mMj.mMe == null || !this.mMj.mMe.containsKey(str)) {
            return false;
        }
        return this.mMj.mMe.get(str).aNo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean uU(String str) {
        if (this.mMj.mMe == null || !this.mMj.mMe.containsKey(str)) {
            return false;
        }
        return this.mMj.mMe.get(str).aNp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String uV(String str) {
        return (TextUtils.isEmpty(str) || !this.mMj.mMf.contains(str)) ? "0" : "1";
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
        return this.mMj.mMg.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean QC(String str) {
        return this.mMj.mLY.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String QD(String str) {
        return this.mMj.mMh.containsKey(str) ? this.mMj.mMh.get(str) : "";
    }
}
