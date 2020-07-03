package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
/* loaded from: classes13.dex */
public class g {
    private static volatile g mEb;
    private int dus;
    private int dut;
    private int duu;
    private Context mContext;
    private f mEc = new f();
    private ad mDo = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g dwI() {
        if (mEb == null) {
            synchronized (e.class) {
                if (mEb == null) {
                    mEb = new g();
                }
            }
        }
        return mEb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dus = 360000;
        ag dwY = ag.dwY();
        this.dut = dwY.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.duu = dwY.getInt("ubc_database_limit", 10000);
        cVar.dwF().a(this.mEc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void av(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.aJp())) {
                    this.mEc.mDQ.add(id);
                    this.mEc.mDT.remove(id);
                } else {
                    this.mEc.mDQ.remove(id);
                    this.mEc.mDT.add(id);
                }
                if ("1".equals(kVar.aJq())) {
                    this.mEc.mDR.add(id);
                } else {
                    this.mEc.mDR.remove(id);
                }
                if ("1".equals(kVar.aJr())) {
                    this.mEc.mDS.add(id);
                } else {
                    this.mEc.mDS.remove(id);
                }
                if ("1".equals(kVar.dwK())) {
                    this.mEc.mDU.add(id);
                } else {
                    this.mEc.mDU.remove(id);
                }
                if (kVar.aJs() >= 1 && kVar.aJs() <= 100) {
                    this.mEc.mDV.put(id, String.valueOf(kVar.aJs()));
                } else {
                    this.mEc.mDV.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.mEc.mDW.put(id, kVar.getCategory());
                } else {
                    this.mEc.mDW.remove(id);
                }
                if (kVar.aJu() != 0 && kVar.aJt() != 0) {
                    m mVar = new m(id, kVar.aJu(), kVar.aJt());
                    this.mEc.mDX.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.aJv(), "1")) {
                    this.mEc.mDY.add(id);
                } else {
                    this.mEc.mDY.remove(id);
                }
                if (TextUtils.equals(kVar.dwM(), "1")) {
                    this.mEc.mDZ.add(id);
                } else {
                    this.mEc.mDZ.remove(id);
                }
                String dwN = kVar.dwN();
                if (!TextUtils.isEmpty(dwN) && !TextUtils.equals(dwN, "0")) {
                    this.mEc.mEa.put(id, dwN);
                } else {
                    this.mEc.mEa.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aa(String str, int i) {
        if (this.mEc.mDQ.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.mEc.mDT.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tM(String str) {
        if (this.mDo.dwW()) {
            return true;
        }
        return this.mEc.mDR.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tN(String str) {
        return this.mEc.mDS.contains(str);
    }

    boolean PN(String str) {
        return this.mEc.mDU.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String tO(String str) {
        return this.mEc.mDW.containsKey(str) ? this.mEc.mDW.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aJk() {
        return this.dus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jE(int i) {
        if (i * 60000 >= this.dus) {
            this.dus = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aJl() {
        return this.dut;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jF(int i) {
        if (i >= this.dut) {
            this.dut = i;
            ag.dwY().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aJm() {
        return this.duu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jG(int i) {
        if (i >= this.duu) {
            this.duu = i;
            ag.dwY().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int tP(String str) {
        if (TextUtils.isEmpty(str) || !this.mEc.mDV.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.mEc.mDV.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tQ(String str) {
        if (this.mEc.mDX == null || !this.mEc.mDX.containsKey(str)) {
            return false;
        }
        return this.mEc.mDX.get(str).aJw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tR(String str) {
        if (this.mEc.mDX == null || !this.mEc.mDX.containsKey(str)) {
            return false;
        }
        return this.mEc.mDX.get(str).aJx();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String tS(String str) {
        return (TextUtils.isEmpty(str) || !this.mEc.mDY.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean PO(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !PN(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean PP(String str) {
        return this.mEc.mDZ.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean PQ(String str) {
        return this.mEc.mDR.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String PR(String str) {
        return this.mEc.mEa.containsKey(str) ? this.mEc.mEa.get(str) : "";
    }
}
