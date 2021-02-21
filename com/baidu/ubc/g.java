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
    private static volatile g oTu;
    private int eyn;
    private int eyo;
    private int eyp;
    private Context mContext;
    private int oTv = 614400;
    private int oTw = 153600;
    private f oTx = new f();
    private af oSC = new af();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g ehF() {
        if (oTu == null) {
            synchronized (e.class) {
                if (oTu == null) {
                    oTu = new g();
                }
            }
        }
        return oTu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.eyn = 360000;
        ai eib = ai.eib();
        this.eyo = eib.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.eyp = eib.getInt("ubc_database_limit", 10000);
        cVar.ehA().a(this.oTx);
        this.oTv = eib.getInt("ubc_launch_upload_max_limit", 614400);
        this.oTw = eib.getInt("ubc_single_log_max_limit", 153600);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void be(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.beJ())) {
                    this.oTx.oTh.add(id);
                    this.oTx.oTk.remove(id);
                } else {
                    this.oTx.oTh.remove(id);
                    this.oTx.oTk.add(id);
                }
                if ("1".equals(kVar.beK())) {
                    this.oTx.oTi.add(id);
                } else {
                    this.oTx.oTi.remove(id);
                }
                if ("1".equals(kVar.beL())) {
                    this.oTx.oTj.add(id);
                } else {
                    this.oTx.oTj.remove(id);
                }
                if ("1".equals(kVar.ehJ())) {
                    this.oTx.oTl.add(id);
                } else {
                    this.oTx.oTl.remove(id);
                }
                if (kVar.beM() >= 1 && kVar.beM() <= 100) {
                    this.oTx.oTm.put(id, String.valueOf(kVar.beM()));
                } else {
                    this.oTx.oTm.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.oTx.oTn.put(id, kVar.getCategory());
                } else {
                    this.oTx.oTn.remove(id);
                }
                if (kVar.beO() != 0 && kVar.beN() != 0) {
                    m mVar = new m(id, kVar.beN(), kVar.beO());
                    this.oTx.oTo.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.beP(), "1")) {
                    this.oTx.oTp.add(id);
                } else {
                    this.oTx.oTp.remove(id);
                }
                if (TextUtils.equals(kVar.ehL(), "1")) {
                    this.oTx.oTq.add(id);
                } else {
                    this.oTx.oTq.remove(id);
                }
                String ehM = kVar.ehM();
                if (!TextUtils.isEmpty(ehM) && !TextUtils.equals(ehM, "0")) {
                    this.oTx.oTr.put(id, ehM);
                } else {
                    this.oTx.oTr.remove(id);
                }
                String ehN = kVar.ehN();
                if (!TextUtils.isEmpty(ehN)) {
                    this.oTx.oTs.put(id, ehN);
                } else {
                    this.oTx.oTs.remove(id);
                }
                int ehO = kVar.ehO();
                if (ehO != 2) {
                    this.oTx.oTt.put(id, Integer.valueOf(ehO));
                } else {
                    this.oTx.oTt.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean al(String str, int i) {
        if (this.oTx.oTh.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.oTx.oTk.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yw(String str) {
        if (this.oSC.ehW()) {
            return true;
        }
        return this.oTx.oTi.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xo(String str) {
        if (!isBeta() && this.oSC.ehZ() && yz(str) > 0) {
            return new Random().nextInt(100) >= yz(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yx(String str) {
        return this.oTx.oTj.contains(str);
    }

    boolean Xp(String str) {
        return this.oTx.oTl.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yy(String str) {
        return this.oTx.oTn.containsKey(str) ? this.oTx.oTn.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int beE() {
        return this.eyn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mg(int i) {
        if (i * 60000 >= this.eyn) {
            this.eyn = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int beF() {
        return this.eyo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mh(int i) {
        if (i >= this.eyo) {
            this.eyo = i;
            ai.eib().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int beG() {
        return this.eyp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mi(int i) {
        if (i >= this.eyp) {
            this.eyp = i;
            ai.eib().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ehG() {
        return this.oTv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nh(int i) {
        if (i >= 307200) {
            this.oTv = i;
            ai.eib().putInt("ubc_launch_upload_max_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ehH() {
        return this.oTw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ni(int i) {
        if (i >= 30720) {
            this.oTw = i;
            ai.eib().putInt("ubc_single_log_max_limit", i);
        }
    }

    int yz(String str) {
        if (TextUtils.isEmpty(str) || !this.oTx.oTm.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.oTx.oTm.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yA(String str) {
        if (this.oTx.oTo == null || !this.oTx.oTo.containsKey(str)) {
            return false;
        }
        return this.oTx.oTo.get(str).beQ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yB(String str) {
        if (this.oTx.oTo == null || !this.oTx.oTo.containsKey(str)) {
            return false;
        }
        return this.oTx.oTo.get(str).beR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yC(String str) {
        return (TextUtils.isEmpty(str) || !this.oTx.oTp.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xq(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !Xp(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xr(String str) {
        return this.oTx.oTq.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xs(String str) {
        return this.oTx.oTi.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Xt(String str) {
        return this.oTx.oTr.containsKey(str) ? this.oTx.oTr.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oTx.oTs.containsKey(str) ? this.oTx.oTs.get(str) : "";
    }

    public boolean Xu(String str) {
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
    public int Xv(String str) {
        Integer num;
        if (!this.oTx.oTt.containsKey(str) || (num = this.oTx.oTt.get(str)) == null) {
            return 2;
        }
        return num.intValue();
    }
}
