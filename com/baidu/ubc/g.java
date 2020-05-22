package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
/* loaded from: classes13.dex */
public class g {
    private static volatile g mgW;
    private int dpG;
    private int dpH;
    private int dpI;
    private Context mContext;
    private f mgX = new f();
    private ad mgl = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g drP() {
        if (mgW == null) {
            synchronized (e.class) {
                if (mgW == null) {
                    mgW = new g();
                }
            }
        }
        return mgW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.dpG = 360000;
        ag dsf = ag.dsf();
        this.dpH = dsf.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.dpI = dsf.getInt("ubc_database_limit", 10000);
        cVar.drM().a(this.mgX);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ar(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.aIj())) {
                    this.mgX.mgL.add(id);
                    this.mgX.mgO.remove(id);
                } else {
                    this.mgX.mgL.remove(id);
                    this.mgX.mgO.add(id);
                }
                if ("1".equals(kVar.aIk())) {
                    this.mgX.mgM.add(id);
                } else {
                    this.mgX.mgM.remove(id);
                }
                if ("1".equals(kVar.aIl())) {
                    this.mgX.mgN.add(id);
                } else {
                    this.mgX.mgN.remove(id);
                }
                if ("1".equals(kVar.drR())) {
                    this.mgX.mgP.add(id);
                } else {
                    this.mgX.mgP.remove(id);
                }
                if (kVar.aIm() >= 1 && kVar.aIm() <= 100) {
                    this.mgX.mgQ.put(id, String.valueOf(kVar.aIm()));
                } else {
                    this.mgX.mgQ.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.mgX.mgR.put(id, kVar.getCategory());
                } else {
                    this.mgX.mgR.remove(id);
                }
                if (kVar.aIo() != 0 && kVar.aIn() != 0) {
                    m mVar = new m(id, kVar.aIo(), kVar.aIn());
                    this.mgX.mgS.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.aIp(), "1")) {
                    this.mgX.mgT.add(id);
                } else {
                    this.mgX.mgT.remove(id);
                }
                if (TextUtils.equals(kVar.drT(), "1")) {
                    this.mgX.mgU.add(id);
                } else {
                    this.mgX.mgU.remove(id);
                }
                String drU = kVar.drU();
                if (!TextUtils.isEmpty(drU) && !TextUtils.equals(drU, "0")) {
                    this.mgX.mgV.put(id, drU);
                } else {
                    this.mgX.mgV.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aa(String str, int i) {
        if (this.mgX.mgL.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.mgX.mgO.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tE(String str) {
        if (this.mgl.dsd()) {
            return true;
        }
        return this.mgX.mgM.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tF(String str) {
        return this.mgX.mgN.contains(str);
    }

    boolean Pa(String str) {
        return this.mgX.mgP.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String tG(String str) {
        return this.mgX.mgR.containsKey(str) ? this.mgX.mgR.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aIe() {
        return this.dpG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jr(int i) {
        if (i * 60000 >= this.dpG) {
            this.dpG = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aIf() {
        return this.dpH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void js(int i) {
        if (i >= this.dpH) {
            this.dpH = i;
            ag.dsf().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aIg() {
        return this.dpI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jt(int i) {
        if (i >= this.dpI) {
            this.dpI = i;
            ag.dsf().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int tH(String str) {
        if (TextUtils.isEmpty(str) || !this.mgX.mgQ.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.mgX.mgQ.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tI(String str) {
        if (this.mgX.mgS == null || !this.mgX.mgS.containsKey(str)) {
            return false;
        }
        return this.mgX.mgS.get(str).aIq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tJ(String str) {
        if (this.mgX.mgS == null || !this.mgX.mgS.containsKey(str)) {
            return false;
        }
        return this.mgX.mgS.get(str).aIr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String tK(String str) {
        return (TextUtils.isEmpty(str) || !this.mgX.mgT.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Pb(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !Pa(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Pc(String str) {
        return this.mgX.mgU.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Pd(String str) {
        return this.mgX.mgM.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Pe(String str) {
        return this.mgX.mgV.containsKey(str) ? this.mgX.mgV.get(str) : "";
    }
}
