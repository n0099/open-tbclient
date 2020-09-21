package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
import java.util.Random;
/* loaded from: classes11.dex */
public class g {
    private static volatile g npz;
    private int dLA;
    private int dLy;
    private int dLz;
    private Context mContext;
    private f npA = new f();
    private ad noN = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g dPU() {
        if (npz == null) {
            synchronized (e.class) {
                if (npz == null) {
                    npz = new g();
                }
            }
        }
        return npz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dLy = 360000;
        ag dQk = ag.dQk();
        this.dLz = dQk.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.dLA = dQk.getInt("ubc_database_limit", 10000);
        cVar.dPR().a(this.npA);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aF(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.aWt())) {
                    this.npA.npn.add(id);
                    this.npA.npq.remove(id);
                } else {
                    this.npA.npn.remove(id);
                    this.npA.npq.add(id);
                }
                if ("1".equals(kVar.aWu())) {
                    this.npA.npo.add(id);
                } else {
                    this.npA.npo.remove(id);
                }
                if ("1".equals(kVar.aWv())) {
                    this.npA.npp.add(id);
                } else {
                    this.npA.npp.remove(id);
                }
                if ("1".equals(kVar.dPW())) {
                    this.npA.npr.add(id);
                } else {
                    this.npA.npr.remove(id);
                }
                if (kVar.aWw() >= 1 && kVar.aWw() <= 100) {
                    this.npA.nps.put(id, String.valueOf(kVar.aWw()));
                } else {
                    this.npA.nps.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.npA.npt.put(id, kVar.getCategory());
                } else {
                    this.npA.npt.remove(id);
                }
                if (kVar.aWy() != 0 && kVar.aWx() != 0) {
                    m mVar = new m(id, kVar.aWy(), kVar.aWx());
                    this.npA.npu.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.aWz(), "1")) {
                    this.npA.npv.add(id);
                } else {
                    this.npA.npv.remove(id);
                }
                if (TextUtils.equals(kVar.dPY(), "1")) {
                    this.npA.npw.add(id);
                } else {
                    this.npA.npw.remove(id);
                }
                String dPZ = kVar.dPZ();
                if (!TextUtils.isEmpty(dPZ) && !TextUtils.equals(dPZ, "0")) {
                    this.npA.npx.put(id, dPZ);
                } else {
                    this.npA.npx.remove(id);
                }
                String dQa = kVar.dQa();
                if (!TextUtils.isEmpty(dQa)) {
                    this.npA.npy.put(id, dQa);
                } else {
                    this.npA.npy.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ad(String str, int i) {
        if (this.npA.npn.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.npA.npq.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xu(String str) {
        if (this.noN.dQi()) {
            return true;
        }
        return this.npA.npo.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean TX(String str) {
        if (!isBeta() && this.noN.dQh() && xx(str) > 0) {
            return new Random().nextInt(100) >= xx(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xv(String str) {
        return this.npA.npp.contains(str);
    }

    boolean TY(String str) {
        return this.npA.npr.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xw(String str) {
        return this.npA.npt.containsKey(str) ? this.npA.npt.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aWo() {
        return this.dLy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mo(int i) {
        if (i * 60000 >= this.dLy) {
            this.dLy = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aWp() {
        return this.dLz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mp(int i) {
        if (i >= this.dLz) {
            this.dLz = i;
            ag.dQk().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aWq() {
        return this.dLA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mq(int i) {
        if (i >= this.dLA) {
            this.dLA = i;
            ag.dQk().putInt("ubc_database_limit", i);
        }
    }

    int xx(String str) {
        if (TextUtils.isEmpty(str) || !this.npA.nps.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.npA.nps.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xy(String str) {
        if (this.npA.npu == null || !this.npA.npu.containsKey(str)) {
            return false;
        }
        return this.npA.npu.get(str).aWA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xz(String str) {
        if (this.npA.npu == null || !this.npA.npu.containsKey(str)) {
            return false;
        }
        return this.npA.npu.get(str).aWB();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xA(String str) {
        return (TextUtils.isEmpty(str) || !this.npA.npv.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean TZ(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !TY(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Ua(String str) {
        return this.npA.npw.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Ub(String str) {
        return this.npA.npo.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Uc(String str) {
        return this.npA.npx.containsKey(str) ? this.npA.npx.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.npA.npy.containsKey(str) ? this.npA.npy.get(str) : "";
    }

    public boolean Ud(String str) {
        return TextUtils.equals("0", getUploadType(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBeta() {
        q uBCContext = UBC.getUBCContext();
        if (uBCContext != null) {
            return uBCContext.isBeta();
        }
        return false;
    }
}
