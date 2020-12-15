package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
import java.util.Random;
/* loaded from: classes15.dex */
public class g {
    private static volatile g oHh;
    private int eri;
    private int erj;
    private int erk;
    private Context mContext;
    private int oHi = 614400;
    private int oHj = 153600;
    private f oHk = new f();
    private af oGp = new af();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g eiM() {
        if (oHh == null) {
            synchronized (e.class) {
                if (oHh == null) {
                    oHh = new g();
                }
            }
        }
        return oHh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.eri = 360000;
        ai eji = ai.eji();
        this.erj = eji.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.erk = eji.getInt("ubc_database_limit", 10000);
        cVar.eiH().a(this.oHk);
        this.oHi = eji.getInt("ubc_launch_upload_max_limit", 614400);
        this.oHj = eji.getInt("ubc_single_log_max_limit", 153600);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bc(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.bfS())) {
                    this.oHk.oGU.add(id);
                    this.oHk.oGX.remove(id);
                } else {
                    this.oHk.oGU.remove(id);
                    this.oHk.oGX.add(id);
                }
                if ("1".equals(kVar.bfT())) {
                    this.oHk.oGV.add(id);
                } else {
                    this.oHk.oGV.remove(id);
                }
                if ("1".equals(kVar.bfU())) {
                    this.oHk.oGW.add(id);
                } else {
                    this.oHk.oGW.remove(id);
                }
                if ("1".equals(kVar.eiQ())) {
                    this.oHk.oGY.add(id);
                } else {
                    this.oHk.oGY.remove(id);
                }
                if (kVar.bfV() >= 1 && kVar.bfV() <= 100) {
                    this.oHk.oGZ.put(id, String.valueOf(kVar.bfV()));
                } else {
                    this.oHk.oGZ.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.oHk.oHa.put(id, kVar.getCategory());
                } else {
                    this.oHk.oHa.remove(id);
                }
                if (kVar.bfX() != 0 && kVar.bfW() != 0) {
                    m mVar = new m(id, kVar.bfW(), kVar.bfX());
                    this.oHk.oHb.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.bfY(), "1")) {
                    this.oHk.oHc.add(id);
                } else {
                    this.oHk.oHc.remove(id);
                }
                if (TextUtils.equals(kVar.eiS(), "1")) {
                    this.oHk.oHd.add(id);
                } else {
                    this.oHk.oHd.remove(id);
                }
                String eiT = kVar.eiT();
                if (!TextUtils.isEmpty(eiT) && !TextUtils.equals(eiT, "0")) {
                    this.oHk.oHe.put(id, eiT);
                } else {
                    this.oHk.oHe.remove(id);
                }
                String eiU = kVar.eiU();
                if (!TextUtils.isEmpty(eiU)) {
                    this.oHk.oHf.put(id, eiU);
                } else {
                    this.oHk.oHf.remove(id);
                }
                int eiV = kVar.eiV();
                if (eiV != 2) {
                    this.oHk.oHg.put(id, Integer.valueOf(eiV));
                } else {
                    this.oHk.oHg.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ah(String str, int i) {
        if (this.oHk.oGU.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.oHk.oGX.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zp(String str) {
        if (this.oGp.ejd()) {
            return true;
        }
        return this.oHk.oGV.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean XC(String str) {
        if (!isBeta() && this.oGp.ejg() && zs(str) > 0) {
            return new Random().nextInt(100) >= zs(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zq(String str) {
        return this.oHk.oGW.contains(str);
    }

    boolean XD(String str) {
        return this.oHk.oGY.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zr(String str) {
        return this.oHk.oHa.containsKey(str) ? this.oHk.oHa.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bfN() {
        return this.eri;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nA(int i) {
        if (i * 60000 >= this.eri) {
            this.eri = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bfO() {
        return this.erj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nB(int i) {
        if (i >= this.erj) {
            this.erj = i;
            ai.eji().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bfP() {
        return this.erk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nC(int i) {
        if (i >= this.erk) {
            this.erk = i;
            ai.eji().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eiN() {
        return this.oHi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void OC(int i) {
        if (i >= 307200) {
            this.oHi = i;
            ai.eji().putInt("ubc_launch_upload_max_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eiO() {
        return this.oHj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void OD(int i) {
        if (i >= 30720) {
            this.oHj = i;
            ai.eji().putInt("ubc_single_log_max_limit", i);
        }
    }

    int zs(String str) {
        if (TextUtils.isEmpty(str) || !this.oHk.oGZ.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.oHk.oGZ.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zt(String str) {
        if (this.oHk.oHb == null || !this.oHk.oHb.containsKey(str)) {
            return false;
        }
        return this.oHk.oHb.get(str).bfZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zu(String str) {
        if (this.oHk.oHb == null || !this.oHk.oHb.containsKey(str)) {
            return false;
        }
        return this.oHk.oHb.get(str).bga();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zv(String str) {
        return (TextUtils.isEmpty(str) || !this.oHk.oHc.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean XE(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !XD(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean XF(String str) {
        return this.oHk.oHd.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean XG(String str) {
        return this.oHk.oGV.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String XH(String str) {
        return this.oHk.oHe.containsKey(str) ? this.oHk.oHe.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oHk.oHf.containsKey(str) ? this.oHk.oHf.get(str) : "";
    }

    public boolean XI(String str) {
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
    public int XJ(String str) {
        Integer num;
        if (!this.oHk.oHg.containsKey(str) || (num = this.oHk.oHg.get(str)) == null) {
            return 2;
        }
        return num.intValue();
    }
}
