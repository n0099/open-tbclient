package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
/* loaded from: classes13.dex */
public class g {
    private static volatile g mEe;
    private int dus;
    private int dut;
    private int duu;
    private Context mContext;
    private f mEf = new f();
    private ad mDr = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g dwM() {
        if (mEe == null) {
            synchronized (e.class) {
                if (mEe == null) {
                    mEe = new g();
                }
            }
        }
        return mEe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dus = 360000;
        ag dxc = ag.dxc();
        this.dut = dxc.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.duu = dxc.getInt("ubc_database_limit", 10000);
        cVar.dwJ().a(this.mEf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void av(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.aJp())) {
                    this.mEf.mDT.add(id);
                    this.mEf.mDW.remove(id);
                } else {
                    this.mEf.mDT.remove(id);
                    this.mEf.mDW.add(id);
                }
                if ("1".equals(kVar.aJq())) {
                    this.mEf.mDU.add(id);
                } else {
                    this.mEf.mDU.remove(id);
                }
                if ("1".equals(kVar.aJr())) {
                    this.mEf.mDV.add(id);
                } else {
                    this.mEf.mDV.remove(id);
                }
                if ("1".equals(kVar.dwO())) {
                    this.mEf.mDX.add(id);
                } else {
                    this.mEf.mDX.remove(id);
                }
                if (kVar.aJs() >= 1 && kVar.aJs() <= 100) {
                    this.mEf.mDY.put(id, String.valueOf(kVar.aJs()));
                } else {
                    this.mEf.mDY.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.mEf.mDZ.put(id, kVar.getCategory());
                } else {
                    this.mEf.mDZ.remove(id);
                }
                if (kVar.aJu() != 0 && kVar.aJt() != 0) {
                    m mVar = new m(id, kVar.aJu(), kVar.aJt());
                    this.mEf.mEa.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.aJv(), "1")) {
                    this.mEf.mEb.add(id);
                } else {
                    this.mEf.mEb.remove(id);
                }
                if (TextUtils.equals(kVar.dwQ(), "1")) {
                    this.mEf.mEc.add(id);
                } else {
                    this.mEf.mEc.remove(id);
                }
                String dwR = kVar.dwR();
                if (!TextUtils.isEmpty(dwR) && !TextUtils.equals(dwR, "0")) {
                    this.mEf.mEd.put(id, dwR);
                } else {
                    this.mEf.mEd.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aa(String str, int i) {
        if (this.mEf.mDT.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.mEf.mDW.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tM(String str) {
        if (this.mDr.dxa()) {
            return true;
        }
        return this.mEf.mDU.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tN(String str) {
        return this.mEf.mDV.contains(str);
    }

    boolean PO(String str) {
        return this.mEf.mDX.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String tO(String str) {
        return this.mEf.mDZ.containsKey(str) ? this.mEf.mDZ.get(str) : "";
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
            ag.dxc().putInt("ubc_data_expire_time", i);
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
            ag.dxc().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int tP(String str) {
        if (TextUtils.isEmpty(str) || !this.mEf.mDY.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.mEf.mDY.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tQ(String str) {
        if (this.mEf.mEa == null || !this.mEf.mEa.containsKey(str)) {
            return false;
        }
        return this.mEf.mEa.get(str).aJw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tR(String str) {
        if (this.mEf.mEa == null || !this.mEf.mEa.containsKey(str)) {
            return false;
        }
        return this.mEf.mEa.get(str).aJx();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String tS(String str) {
        return (TextUtils.isEmpty(str) || !this.mEf.mEb.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean PP(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !PO(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean PQ(String str) {
        return this.mEf.mEc.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean PR(String str) {
        return this.mEf.mDU.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String PS(String str) {
        return this.mEf.mEd.containsKey(str) ? this.mEf.mEd.get(str) : "";
    }
}
