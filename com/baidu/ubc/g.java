package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
import java.util.Random;
/* loaded from: classes5.dex */
public class g {
    private static volatile g oVz;
    private int ezO;
    private int ezP;
    private int ezQ;
    private Context mContext;
    private int oVA = 614400;
    private int oVB = 153600;
    private f oVC = new f();
    private af oUH = new af();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g ehN() {
        if (oVz == null) {
            synchronized (e.class) {
                if (oVz == null) {
                    oVz = new g();
                }
            }
        }
        return oVz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.ezO = 360000;
        ai eij = ai.eij();
        this.ezP = eij.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.ezQ = eij.getInt("ubc_database_limit", 10000);
        cVar.ehI().a(this.oVC);
        this.oVA = eij.getInt("ubc_launch_upload_max_limit", 614400);
        this.oVB = eij.getInt("ubc_single_log_max_limit", 153600);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void be(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.beL())) {
                    this.oVC.oVm.add(id);
                    this.oVC.oVp.remove(id);
                } else {
                    this.oVC.oVm.remove(id);
                    this.oVC.oVp.add(id);
                }
                if ("1".equals(kVar.beM())) {
                    this.oVC.oVn.add(id);
                } else {
                    this.oVC.oVn.remove(id);
                }
                if ("1".equals(kVar.beN())) {
                    this.oVC.oVo.add(id);
                } else {
                    this.oVC.oVo.remove(id);
                }
                if ("1".equals(kVar.ehR())) {
                    this.oVC.oVq.add(id);
                } else {
                    this.oVC.oVq.remove(id);
                }
                if (kVar.beO() >= 1 && kVar.beO() <= 100) {
                    this.oVC.oVr.put(id, String.valueOf(kVar.beO()));
                } else {
                    this.oVC.oVr.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.oVC.oVs.put(id, kVar.getCategory());
                } else {
                    this.oVC.oVs.remove(id);
                }
                if (kVar.beQ() != 0 && kVar.beP() != 0) {
                    m mVar = new m(id, kVar.beP(), kVar.beQ());
                    this.oVC.oVt.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.beR(), "1")) {
                    this.oVC.oVu.add(id);
                } else {
                    this.oVC.oVu.remove(id);
                }
                if (TextUtils.equals(kVar.ehT(), "1")) {
                    this.oVC.oVv.add(id);
                } else {
                    this.oVC.oVv.remove(id);
                }
                String ehU = kVar.ehU();
                if (!TextUtils.isEmpty(ehU) && !TextUtils.equals(ehU, "0")) {
                    this.oVC.oVw.put(id, ehU);
                } else {
                    this.oVC.oVw.remove(id);
                }
                String ehV = kVar.ehV();
                if (!TextUtils.isEmpty(ehV)) {
                    this.oVC.oVx.put(id, ehV);
                } else {
                    this.oVC.oVx.remove(id);
                }
                int ehW = kVar.ehW();
                if (ehW != 2) {
                    this.oVC.oVy.put(id, Integer.valueOf(ehW));
                } else {
                    this.oVC.oVy.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean am(String str, int i) {
        if (this.oVC.oVm.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.oVC.oVp.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yD(String str) {
        if (this.oUH.eie()) {
            return true;
        }
        return this.oVC.oVn.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xv(String str) {
        if (!isBeta() && this.oUH.eih() && yG(str) > 0) {
            return new Random().nextInt(100) >= yG(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yE(String str) {
        return this.oVC.oVo.contains(str);
    }

    boolean Xw(String str) {
        return this.oVC.oVq.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yF(String str) {
        return this.oVC.oVs.containsKey(str) ? this.oVC.oVs.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int beG() {
        return this.ezO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mh(int i) {
        if (i * 60000 >= this.ezO) {
            this.ezO = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int beH() {
        return this.ezP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mi(int i) {
        if (i >= this.ezP) {
            this.ezP = i;
            ai.eij().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int beI() {
        return this.ezQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mj(int i) {
        if (i >= this.ezQ) {
            this.ezQ = i;
            ai.eij().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ehO() {
        return this.oVA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nl(int i) {
        if (i >= 307200) {
            this.oVA = i;
            ai.eij().putInt("ubc_launch_upload_max_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ehP() {
        return this.oVB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nm(int i) {
        if (i >= 30720) {
            this.oVB = i;
            ai.eij().putInt("ubc_single_log_max_limit", i);
        }
    }

    int yG(String str) {
        if (TextUtils.isEmpty(str) || !this.oVC.oVr.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.oVC.oVr.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yH(String str) {
        if (this.oVC.oVt == null || !this.oVC.oVt.containsKey(str)) {
            return false;
        }
        return this.oVC.oVt.get(str).beS();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yI(String str) {
        if (this.oVC.oVt == null || !this.oVC.oVt.containsKey(str)) {
            return false;
        }
        return this.oVC.oVt.get(str).beT();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yJ(String str) {
        return (TextUtils.isEmpty(str) || !this.oVC.oVu.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xx(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !Xw(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xy(String str) {
        return this.oVC.oVv.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xz(String str) {
        return this.oVC.oVn.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String XA(String str) {
        return this.oVC.oVw.containsKey(str) ? this.oVC.oVw.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oVC.oVx.containsKey(str) ? this.oVC.oVx.get(str) : "";
    }

    public boolean XB(String str) {
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
    public int XC(String str) {
        Integer num;
        if (!this.oVC.oVy.containsKey(str) || (num = this.oVC.oVy.get(str)) == null) {
            return 2;
        }
        return num.intValue();
    }
}
