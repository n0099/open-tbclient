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
    private static volatile g oHf;
    private int eri;
    private int erj;
    private int erk;
    private Context mContext;
    private int oHg = 614400;
    private int oHh = 153600;
    private f oHi = new f();
    private af oGn = new af();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g eiL() {
        if (oHf == null) {
            synchronized (e.class) {
                if (oHf == null) {
                    oHf = new g();
                }
            }
        }
        return oHf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.eri = 360000;
        ai ejh = ai.ejh();
        this.erj = ejh.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.erk = ejh.getInt("ubc_database_limit", 10000);
        cVar.eiG().a(this.oHi);
        this.oHg = ejh.getInt("ubc_launch_upload_max_limit", 614400);
        this.oHh = ejh.getInt("ubc_single_log_max_limit", 153600);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bc(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.bfS())) {
                    this.oHi.oGS.add(id);
                    this.oHi.oGV.remove(id);
                } else {
                    this.oHi.oGS.remove(id);
                    this.oHi.oGV.add(id);
                }
                if ("1".equals(kVar.bfT())) {
                    this.oHi.oGT.add(id);
                } else {
                    this.oHi.oGT.remove(id);
                }
                if ("1".equals(kVar.bfU())) {
                    this.oHi.oGU.add(id);
                } else {
                    this.oHi.oGU.remove(id);
                }
                if ("1".equals(kVar.eiP())) {
                    this.oHi.oGW.add(id);
                } else {
                    this.oHi.oGW.remove(id);
                }
                if (kVar.bfV() >= 1 && kVar.bfV() <= 100) {
                    this.oHi.oGX.put(id, String.valueOf(kVar.bfV()));
                } else {
                    this.oHi.oGX.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.oHi.oGY.put(id, kVar.getCategory());
                } else {
                    this.oHi.oGY.remove(id);
                }
                if (kVar.bfX() != 0 && kVar.bfW() != 0) {
                    m mVar = new m(id, kVar.bfW(), kVar.bfX());
                    this.oHi.oGZ.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.bfY(), "1")) {
                    this.oHi.oHa.add(id);
                } else {
                    this.oHi.oHa.remove(id);
                }
                if (TextUtils.equals(kVar.eiR(), "1")) {
                    this.oHi.oHb.add(id);
                } else {
                    this.oHi.oHb.remove(id);
                }
                String eiS = kVar.eiS();
                if (!TextUtils.isEmpty(eiS) && !TextUtils.equals(eiS, "0")) {
                    this.oHi.oHc.put(id, eiS);
                } else {
                    this.oHi.oHc.remove(id);
                }
                String eiT = kVar.eiT();
                if (!TextUtils.isEmpty(eiT)) {
                    this.oHi.oHd.put(id, eiT);
                } else {
                    this.oHi.oHd.remove(id);
                }
                int eiU = kVar.eiU();
                if (eiU != 2) {
                    this.oHi.oHe.put(id, Integer.valueOf(eiU));
                } else {
                    this.oHi.oHe.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ah(String str, int i) {
        if (this.oHi.oGS.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.oHi.oGV.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zp(String str) {
        if (this.oGn.ejc()) {
            return true;
        }
        return this.oHi.oGT.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean XC(String str) {
        if (!isBeta() && this.oGn.ejf() && zs(str) > 0) {
            return new Random().nextInt(100) >= zs(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zq(String str) {
        return this.oHi.oGU.contains(str);
    }

    boolean XD(String str) {
        return this.oHi.oGW.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zr(String str) {
        return this.oHi.oGY.containsKey(str) ? this.oHi.oGY.get(str) : "";
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
            ai.ejh().putInt("ubc_data_expire_time", i);
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
            ai.ejh().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eiM() {
        return this.oHg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void OC(int i) {
        if (i >= 307200) {
            this.oHg = i;
            ai.ejh().putInt("ubc_launch_upload_max_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eiN() {
        return this.oHh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void OD(int i) {
        if (i >= 30720) {
            this.oHh = i;
            ai.ejh().putInt("ubc_single_log_max_limit", i);
        }
    }

    int zs(String str) {
        if (TextUtils.isEmpty(str) || !this.oHi.oGX.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.oHi.oGX.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zt(String str) {
        if (this.oHi.oGZ == null || !this.oHi.oGZ.containsKey(str)) {
            return false;
        }
        return this.oHi.oGZ.get(str).bfZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zu(String str) {
        if (this.oHi.oGZ == null || !this.oHi.oGZ.containsKey(str)) {
            return false;
        }
        return this.oHi.oGZ.get(str).bga();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zv(String str) {
        return (TextUtils.isEmpty(str) || !this.oHi.oHa.contains(str)) ? "0" : "1";
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
        return this.oHi.oHb.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean XG(String str) {
        return this.oHi.oGT.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String XH(String str) {
        return this.oHi.oHc.containsKey(str) ? this.oHi.oHc.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oHi.oHd.containsKey(str) ? this.oHi.oHd.get(str) : "";
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
        if (!this.oHi.oHe.containsKey(str) || (num = this.oHi.oHe.get(str)) == null) {
            return 2;
        }
        return num.intValue();
    }
}
