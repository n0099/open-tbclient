package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
import java.util.Random;
/* loaded from: classes6.dex */
public class g {
    private static volatile g oNq;
    private int eAT;
    private int eAU;
    private int eAV;
    private Context mContext;
    private int oNr = 614400;
    private int oNs = 153600;
    private f oNt = new f();
    private af oMy = new af();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g eiX() {
        if (oNq == null) {
            synchronized (e.class) {
                if (oNq == null) {
                    oNq = new g();
                }
            }
        }
        return oNq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.eAT = 360000;
        ai ejt = ai.ejt();
        this.eAU = ejt.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.eAV = ejt.getInt("ubc_database_limit", 10000);
        cVar.eiS().a(this.oNt);
        this.oNr = ejt.getInt("ubc_launch_upload_max_limit", 614400);
        this.oNs = ejt.getInt("ubc_single_log_max_limit", 153600);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bj(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.biq())) {
                    this.oNt.oNd.add(id);
                    this.oNt.oNg.remove(id);
                } else {
                    this.oNt.oNd.remove(id);
                    this.oNt.oNg.add(id);
                }
                if ("1".equals(kVar.bir())) {
                    this.oNt.oNe.add(id);
                } else {
                    this.oNt.oNe.remove(id);
                }
                if ("1".equals(kVar.bis())) {
                    this.oNt.oNf.add(id);
                } else {
                    this.oNt.oNf.remove(id);
                }
                if ("1".equals(kVar.ejb())) {
                    this.oNt.oNh.add(id);
                } else {
                    this.oNt.oNh.remove(id);
                }
                if (kVar.bit() >= 1 && kVar.bit() <= 100) {
                    this.oNt.oNi.put(id, String.valueOf(kVar.bit()));
                } else {
                    this.oNt.oNi.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.oNt.oNj.put(id, kVar.getCategory());
                } else {
                    this.oNt.oNj.remove(id);
                }
                if (kVar.biv() != 0 && kVar.biu() != 0) {
                    m mVar = new m(id, kVar.biu(), kVar.biv());
                    this.oNt.oNk.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.biw(), "1")) {
                    this.oNt.oNl.add(id);
                } else {
                    this.oNt.oNl.remove(id);
                }
                if (TextUtils.equals(kVar.ejd(), "1")) {
                    this.oNt.oNm.add(id);
                } else {
                    this.oNt.oNm.remove(id);
                }
                String eje = kVar.eje();
                if (!TextUtils.isEmpty(eje) && !TextUtils.equals(eje, "0")) {
                    this.oNt.oNn.put(id, eje);
                } else {
                    this.oNt.oNn.remove(id);
                }
                String ejf = kVar.ejf();
                if (!TextUtils.isEmpty(ejf)) {
                    this.oNt.oNo.put(id, ejf);
                } else {
                    this.oNt.oNo.remove(id);
                }
                int ejg = kVar.ejg();
                if (ejg != 2) {
                    this.oNt.oNp.put(id, Integer.valueOf(ejg));
                } else {
                    this.oNt.oNp.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aj(String str, int i) {
        if (this.oNt.oNd.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.oNt.oNg.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zo(String str) {
        if (this.oMy.ejo()) {
            return true;
        }
        return this.oNt.oNe.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xk(String str) {
        if (!isBeta() && this.oMy.ejr() && zr(str) > 0) {
            return new Random().nextInt(100) >= zr(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zp(String str) {
        return this.oNt.oNf.contains(str);
    }

    boolean Xl(String str) {
        return this.oNt.oNh.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zq(String str) {
        return this.oNt.oNj.containsKey(str) ? this.oNt.oNj.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bil() {
        return this.eAT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nJ(int i) {
        if (i * 60000 >= this.eAT) {
            this.eAT = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bim() {
        return this.eAU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nK(int i) {
        if (i >= this.eAU) {
            this.eAU = i;
            ai.ejt().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bin() {
        return this.eAV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nL(int i) {
        if (i >= this.eAV) {
            this.eAV = i;
            ai.ejt().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eiY() {
        return this.oNr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Or(int i) {
        if (i >= 307200) {
            this.oNr = i;
            ai.ejt().putInt("ubc_launch_upload_max_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eiZ() {
        return this.oNs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Os(int i) {
        if (i >= 30720) {
            this.oNs = i;
            ai.ejt().putInt("ubc_single_log_max_limit", i);
        }
    }

    int zr(String str) {
        if (TextUtils.isEmpty(str) || !this.oNt.oNi.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.oNt.oNi.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zs(String str) {
        if (this.oNt.oNk == null || !this.oNt.oNk.containsKey(str)) {
            return false;
        }
        return this.oNt.oNk.get(str).bix();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zt(String str) {
        if (this.oNt.oNk == null || !this.oNt.oNk.containsKey(str)) {
            return false;
        }
        return this.oNt.oNk.get(str).biy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zu(String str) {
        return (TextUtils.isEmpty(str) || !this.oNt.oNl.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xm(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !Xl(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xn(String str) {
        return this.oNt.oNm.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xo(String str) {
        return this.oNt.oNe.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Xp(String str) {
        return this.oNt.oNn.containsKey(str) ? this.oNt.oNn.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oNt.oNo.containsKey(str) ? this.oNt.oNo.get(str) : "";
    }

    public boolean Xq(String str) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Xr(String str) {
        Integer num;
        if (!this.oNt.oNp.containsKey(str) || (num = this.oNt.oNp.get(str)) == null) {
            return 2;
        }
        return num.intValue();
    }
}
