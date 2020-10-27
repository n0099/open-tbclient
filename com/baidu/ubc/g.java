package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.List;
import java.util.Random;
/* loaded from: classes19.dex */
public class g {
    private static volatile g ohv;
    private int efV;
    private int efW;
    private int efX;
    private Context mContext;
    private f ohw = new f();
    private ad ogJ = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g dZx() {
        if (ohv == null) {
            synchronized (e.class) {
                if (ohv == null) {
                    ohv = new g();
                }
            }
        }
        return ohv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.efV = 360000;
        ag dZN = ag.dZN();
        this.efW = dZN.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.efX = dZN.getInt("ubc_database_limit", 10000);
        cVar.dZu().a(this.ohw);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aS(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.baU())) {
                    this.ohw.ohj.add(id);
                    this.ohw.ohm.remove(id);
                } else {
                    this.ohw.ohj.remove(id);
                    this.ohw.ohm.add(id);
                }
                if ("1".equals(kVar.baV())) {
                    this.ohw.ohk.add(id);
                } else {
                    this.ohw.ohk.remove(id);
                }
                if ("1".equals(kVar.baW())) {
                    this.ohw.ohl.add(id);
                } else {
                    this.ohw.ohl.remove(id);
                }
                if ("1".equals(kVar.dZz())) {
                    this.ohw.ohn.add(id);
                } else {
                    this.ohw.ohn.remove(id);
                }
                if (kVar.baX() >= 1 && kVar.baX() <= 100) {
                    this.ohw.oho.put(id, String.valueOf(kVar.baX()));
                } else {
                    this.ohw.oho.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.ohw.ohp.put(id, kVar.getCategory());
                } else {
                    this.ohw.ohp.remove(id);
                }
                if (kVar.baZ() != 0 && kVar.baY() != 0) {
                    m mVar = new m(id, kVar.baZ(), kVar.baY());
                    this.ohw.ohq.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.bba(), "1")) {
                    this.ohw.ohr.add(id);
                } else {
                    this.ohw.ohr.remove(id);
                }
                if (TextUtils.equals(kVar.dZB(), "1")) {
                    this.ohw.ohs.add(id);
                } else {
                    this.ohw.ohs.remove(id);
                }
                String dZC = kVar.dZC();
                if (!TextUtils.isEmpty(dZC) && !TextUtils.equals(dZC, "0")) {
                    this.ohw.oht.put(id, dZC);
                } else {
                    this.ohw.oht.remove(id);
                }
                String dZD = kVar.dZD();
                if (!TextUtils.isEmpty(dZD)) {
                    this.ohw.ohu.put(id, dZD);
                } else {
                    this.ohw.ohu.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ae(String str, int i) {
        if (this.ohw.ohj.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.ohw.ohm.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yz(String str) {
        if (this.ogJ.dZL()) {
            return true;
        }
        return this.ohw.ohk.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean VZ(String str) {
        if (!isBeta() && this.ogJ.dZK() && yC(str) > 0) {
            return new Random().nextInt(100) >= yC(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yA(String str) {
        return this.ohw.ohl.contains(str);
    }

    boolean Wa(String str) {
        return this.ohw.ohn.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yB(String str) {
        return this.ohw.ohp.containsKey(str) ? this.ohw.ohp.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int baP() {
        return this.efV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mW(int i) {
        if (i * 60000 >= this.efV) {
            this.efV = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int baQ() {
        return this.efW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mX(int i) {
        if (i >= this.efW) {
            this.efW = i;
            ag.dZN().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int baR() {
        return this.efX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mY(int i) {
        if (i >= this.efX) {
            this.efX = i;
            ag.dZN().putInt("ubc_database_limit", i);
        }
    }

    int yC(String str) {
        if (TextUtils.isEmpty(str) || !this.ohw.oho.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.ohw.oho.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yD(String str) {
        if (this.ohw.ohq == null || !this.ohw.ohq.containsKey(str)) {
            return false;
        }
        return this.ohw.ohq.get(str).bbb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yE(String str) {
        if (this.ohw.ohq == null || !this.ohw.ohq.containsKey(str)) {
            return false;
        }
        return this.ohw.ohq.get(str).bbc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yF(String str) {
        return (TextUtils.isEmpty(str) || !this.ohw.ohr.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Wb(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !Wa(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Wc(String str) {
        return this.ohw.ohs.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Wd(String str) {
        return this.ohw.ohk.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String We(String str) {
        return this.ohw.oht.containsKey(str) ? this.ohw.oht.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.ohw.ohu.containsKey(str) ? this.ohw.ohu.get(str) : "";
    }

    public boolean Wf(String str) {
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
