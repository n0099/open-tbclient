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
    private static volatile g oqA;
    private int elN;
    private int elO;
    private int elP;
    private Context mContext;
    private f oqB = new f();
    private ad opO = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g edf() {
        if (oqA == null) {
            synchronized (e.class) {
                if (oqA == null) {
                    oqA = new g();
                }
            }
        }
        return oqA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.elN = 360000;
        ag edv = ag.edv();
        this.elO = edv.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.elP = edv.getInt("ubc_database_limit", 10000);
        cVar.edc().a(this.oqB);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aZ(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.bdu())) {
                    this.oqB.oqo.add(id);
                    this.oqB.oqr.remove(id);
                } else {
                    this.oqB.oqo.remove(id);
                    this.oqB.oqr.add(id);
                }
                if ("1".equals(kVar.bdv())) {
                    this.oqB.oqp.add(id);
                } else {
                    this.oqB.oqp.remove(id);
                }
                if ("1".equals(kVar.bdw())) {
                    this.oqB.oqq.add(id);
                } else {
                    this.oqB.oqq.remove(id);
                }
                if ("1".equals(kVar.edh())) {
                    this.oqB.oqs.add(id);
                } else {
                    this.oqB.oqs.remove(id);
                }
                if (kVar.bdx() >= 1 && kVar.bdx() <= 100) {
                    this.oqB.oqt.put(id, String.valueOf(kVar.bdx()));
                } else {
                    this.oqB.oqt.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.oqB.oqu.put(id, kVar.getCategory());
                } else {
                    this.oqB.oqu.remove(id);
                }
                if (kVar.bdz() != 0 && kVar.bdy() != 0) {
                    m mVar = new m(id, kVar.bdz(), kVar.bdy());
                    this.oqB.oqv.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.bdA(), "1")) {
                    this.oqB.oqw.add(id);
                } else {
                    this.oqB.oqw.remove(id);
                }
                if (TextUtils.equals(kVar.edj(), "1")) {
                    this.oqB.oqx.add(id);
                } else {
                    this.oqB.oqx.remove(id);
                }
                String edk = kVar.edk();
                if (!TextUtils.isEmpty(edk) && !TextUtils.equals(edk, "0")) {
                    this.oqB.oqy.put(id, edk);
                } else {
                    this.oqB.oqy.remove(id);
                }
                String edl = kVar.edl();
                if (!TextUtils.isEmpty(edl)) {
                    this.oqB.oqz.put(id, edl);
                } else {
                    this.oqB.oqz.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ag(String str, int i) {
        if (this.oqB.oqo.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.oqB.oqr.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yN(String str) {
        if (this.opO.edt()) {
            return true;
        }
        return this.oqB.oqp.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean WC(String str) {
        if (!isBeta() && this.opO.eds() && yQ(str) > 0) {
            return new Random().nextInt(100) >= yQ(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yO(String str) {
        return this.oqB.oqq.contains(str);
    }

    boolean WD(String str) {
        return this.oqB.oqs.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yP(String str) {
        return this.oqB.oqu.containsKey(str) ? this.oqB.oqu.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bdp() {
        return this.elN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ng(int i) {
        if (i * 60000 >= this.elN) {
            this.elN = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bdq() {
        return this.elO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nh(int i) {
        if (i >= this.elO) {
            this.elO = i;
            ag.edv().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bdr() {
        return this.elP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ni(int i) {
        if (i >= this.elP) {
            this.elP = i;
            ag.edv().putInt("ubc_database_limit", i);
        }
    }

    int yQ(String str) {
        if (TextUtils.isEmpty(str) || !this.oqB.oqt.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.oqB.oqt.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yR(String str) {
        if (this.oqB.oqv == null || !this.oqB.oqv.containsKey(str)) {
            return false;
        }
        return this.oqB.oqv.get(str).bdB();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yS(String str) {
        if (this.oqB.oqv == null || !this.oqB.oqv.containsKey(str)) {
            return false;
        }
        return this.oqB.oqv.get(str).bdC();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yT(String str) {
        return (TextUtils.isEmpty(str) || !this.oqB.oqw.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean WE(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !WD(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean WF(String str) {
        return this.oqB.oqx.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean WG(String str) {
        return this.oqB.oqp.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String WH(String str) {
        return this.oqB.oqy.containsKey(str) ? this.oqB.oqy.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oqB.oqz.containsKey(str) ? this.oqB.oqz.get(str) : "";
    }

    public boolean WI(String str) {
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
