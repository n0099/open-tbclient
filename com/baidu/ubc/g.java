package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
/* loaded from: classes13.dex */
public class g {
    private static volatile g mih;
    private int dpG;
    private int dpH;
    private int dpI;
    private Context mContext;
    private f mii = new f();
    private ad mhv = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g dsd() {
        if (mih == null) {
            synchronized (e.class) {
                if (mih == null) {
                    mih = new g();
                }
            }
        }
        return mih;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dpG = 360000;
        ag dst = ag.dst();
        this.dpH = dst.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.dpI = dst.getInt("ubc_database_limit", 10000);
        cVar.dsa().a(this.mii);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ar(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.aIj())) {
                    this.mii.mhV.add(id);
                    this.mii.mhY.remove(id);
                } else {
                    this.mii.mhV.remove(id);
                    this.mii.mhY.add(id);
                }
                if ("1".equals(kVar.aIk())) {
                    this.mii.mhW.add(id);
                } else {
                    this.mii.mhW.remove(id);
                }
                if ("1".equals(kVar.aIl())) {
                    this.mii.mhX.add(id);
                } else {
                    this.mii.mhX.remove(id);
                }
                if ("1".equals(kVar.dsf())) {
                    this.mii.mhZ.add(id);
                } else {
                    this.mii.mhZ.remove(id);
                }
                if (kVar.aIm() >= 1 && kVar.aIm() <= 100) {
                    this.mii.mia.put(id, String.valueOf(kVar.aIm()));
                } else {
                    this.mii.mia.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.mii.mib.put(id, kVar.getCategory());
                } else {
                    this.mii.mib.remove(id);
                }
                if (kVar.aIo() != 0 && kVar.aIn() != 0) {
                    m mVar = new m(id, kVar.aIo(), kVar.aIn());
                    this.mii.mic.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.aIp(), "1")) {
                    this.mii.mie.add(id);
                } else {
                    this.mii.mie.remove(id);
                }
                if (TextUtils.equals(kVar.dsh(), "1")) {
                    this.mii.mif.add(id);
                } else {
                    this.mii.mif.remove(id);
                }
                String dsi = kVar.dsi();
                if (!TextUtils.isEmpty(dsi) && !TextUtils.equals(dsi, "0")) {
                    this.mii.mig.put(id, dsi);
                } else {
                    this.mii.mig.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aa(String str, int i) {
        if (this.mii.mhV.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.mii.mhY.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tE(String str) {
        if (this.mhv.dsr()) {
            return true;
        }
        return this.mii.mhW.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tF(String str) {
        return this.mii.mhX.contains(str);
    }

    boolean Pb(String str) {
        return this.mii.mhZ.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String tG(String str) {
        return this.mii.mib.containsKey(str) ? this.mii.mib.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aIe() {
        return this.dpG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jt(int i) {
        if (i * 60000 >= this.dpG) {
            this.dpG = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aIf() {
        return this.dpH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ju(int i) {
        if (i >= this.dpH) {
            this.dpH = i;
            ag.dst().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aIg() {
        return this.dpI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jv(int i) {
        if (i >= this.dpI) {
            this.dpI = i;
            ag.dst().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int tH(String str) {
        if (TextUtils.isEmpty(str) || !this.mii.mia.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.mii.mia.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tI(String str) {
        if (this.mii.mic == null || !this.mii.mic.containsKey(str)) {
            return false;
        }
        return this.mii.mic.get(str).aIq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tJ(String str) {
        if (this.mii.mic == null || !this.mii.mic.containsKey(str)) {
            return false;
        }
        return this.mii.mic.get(str).aIr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String tK(String str) {
        return (TextUtils.isEmpty(str) || !this.mii.mie.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Pc(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !Pb(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Pd(String str) {
        return this.mii.mif.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Pe(String str) {
        return this.mii.mhW.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Pf(String str) {
        return this.mii.mig.containsKey(str) ? this.mii.mig.get(str) : "";
    }
}
