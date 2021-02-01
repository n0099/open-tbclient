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
    private static volatile g oSU;
    private int eyn;
    private int eyo;
    private int eyp;
    private Context mContext;
    private int oSV = 614400;
    private int oSW = 153600;
    private f oSX = new f();
    private af oSc = new af();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g ehx() {
        if (oSU == null) {
            synchronized (e.class) {
                if (oSU == null) {
                    oSU = new g();
                }
            }
        }
        return oSU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.eyn = 360000;
        ai ehT = ai.ehT();
        this.eyo = ehT.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.eyp = ehT.getInt("ubc_database_limit", 10000);
        cVar.ehs().a(this.oSX);
        this.oSV = ehT.getInt("ubc_launch_upload_max_limit", 614400);
        this.oSW = ehT.getInt("ubc_single_log_max_limit", 153600);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void be(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.beJ())) {
                    this.oSX.oSH.add(id);
                    this.oSX.oSK.remove(id);
                } else {
                    this.oSX.oSH.remove(id);
                    this.oSX.oSK.add(id);
                }
                if ("1".equals(kVar.beK())) {
                    this.oSX.oSI.add(id);
                } else {
                    this.oSX.oSI.remove(id);
                }
                if ("1".equals(kVar.beL())) {
                    this.oSX.oSJ.add(id);
                } else {
                    this.oSX.oSJ.remove(id);
                }
                if ("1".equals(kVar.ehB())) {
                    this.oSX.oSL.add(id);
                } else {
                    this.oSX.oSL.remove(id);
                }
                if (kVar.beM() >= 1 && kVar.beM() <= 100) {
                    this.oSX.oSM.put(id, String.valueOf(kVar.beM()));
                } else {
                    this.oSX.oSM.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.oSX.oSN.put(id, kVar.getCategory());
                } else {
                    this.oSX.oSN.remove(id);
                }
                if (kVar.beO() != 0 && kVar.beN() != 0) {
                    m mVar = new m(id, kVar.beN(), kVar.beO());
                    this.oSX.oSO.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.beP(), "1")) {
                    this.oSX.oSP.add(id);
                } else {
                    this.oSX.oSP.remove(id);
                }
                if (TextUtils.equals(kVar.ehD(), "1")) {
                    this.oSX.oSQ.add(id);
                } else {
                    this.oSX.oSQ.remove(id);
                }
                String ehE = kVar.ehE();
                if (!TextUtils.isEmpty(ehE) && !TextUtils.equals(ehE, "0")) {
                    this.oSX.oSR.put(id, ehE);
                } else {
                    this.oSX.oSR.remove(id);
                }
                String ehF = kVar.ehF();
                if (!TextUtils.isEmpty(ehF)) {
                    this.oSX.oSS.put(id, ehF);
                } else {
                    this.oSX.oSS.remove(id);
                }
                int ehG = kVar.ehG();
                if (ehG != 2) {
                    this.oSX.oST.put(id, Integer.valueOf(ehG));
                } else {
                    this.oSX.oST.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean al(String str, int i) {
        if (this.oSX.oSH.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.oSX.oSK.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yw(String str) {
        if (this.oSc.ehO()) {
            return true;
        }
        return this.oSX.oSI.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xc(String str) {
        if (!isBeta() && this.oSc.ehR() && yz(str) > 0) {
            return new Random().nextInt(100) >= yz(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yx(String str) {
        return this.oSX.oSJ.contains(str);
    }

    boolean Xd(String str) {
        return this.oSX.oSL.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yy(String str) {
        return this.oSX.oSN.containsKey(str) ? this.oSX.oSN.get(str) : "";
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
            ai.ehT().putInt("ubc_data_expire_time", i);
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
            ai.ehT().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ehy() {
        return this.oSV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ng(int i) {
        if (i >= 307200) {
            this.oSV = i;
            ai.ehT().putInt("ubc_launch_upload_max_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ehz() {
        return this.oSW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nh(int i) {
        if (i >= 30720) {
            this.oSW = i;
            ai.ehT().putInt("ubc_single_log_max_limit", i);
        }
    }

    int yz(String str) {
        if (TextUtils.isEmpty(str) || !this.oSX.oSM.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.oSX.oSM.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yA(String str) {
        if (this.oSX.oSO == null || !this.oSX.oSO.containsKey(str)) {
            return false;
        }
        return this.oSX.oSO.get(str).beQ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yB(String str) {
        if (this.oSX.oSO == null || !this.oSX.oSO.containsKey(str)) {
            return false;
        }
        return this.oSX.oSO.get(str).beR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yC(String str) {
        return (TextUtils.isEmpty(str) || !this.oSX.oSP.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xe(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !Xd(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xf(String str) {
        return this.oSX.oSQ.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Xg(String str) {
        return this.oSX.oSI.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Xh(String str) {
        return this.oSX.oSR.containsKey(str) ? this.oSX.oSR.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oSX.oSS.containsKey(str) ? this.oSX.oSS.get(str) : "";
    }

    public boolean Xi(String str) {
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
    public int Xj(String str) {
        Integer num;
        if (!this.oSX.oST.containsKey(str) || (num = this.oSX.oST.get(str)) == null) {
            return 2;
        }
        return num.intValue();
    }
}
