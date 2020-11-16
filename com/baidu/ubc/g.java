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
    private static volatile g ose;
    private int ekg;
    private int ekh;
    private int eki;
    private Context mContext;
    private f osf = new f();
    private ad ors = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g ede() {
        if (ose == null) {
            synchronized (e.class) {
                if (ose == null) {
                    ose = new g();
                }
            }
        }
        return ose;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.ekg = 360000;
        ag edu = ag.edu();
        this.ekh = edu.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.eki = edu.getInt("ubc_database_limit", 10000);
        cVar.edb().a(this.osf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aZ(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.bcN())) {
                    this.osf.orS.add(id);
                    this.osf.orV.remove(id);
                } else {
                    this.osf.orS.remove(id);
                    this.osf.orV.add(id);
                }
                if ("1".equals(kVar.bcO())) {
                    this.osf.orT.add(id);
                } else {
                    this.osf.orT.remove(id);
                }
                if ("1".equals(kVar.bcP())) {
                    this.osf.orU.add(id);
                } else {
                    this.osf.orU.remove(id);
                }
                if ("1".equals(kVar.edg())) {
                    this.osf.orW.add(id);
                } else {
                    this.osf.orW.remove(id);
                }
                if (kVar.bcQ() >= 1 && kVar.bcQ() <= 100) {
                    this.osf.orX.put(id, String.valueOf(kVar.bcQ()));
                } else {
                    this.osf.orX.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.osf.orY.put(id, kVar.getCategory());
                } else {
                    this.osf.orY.remove(id);
                }
                if (kVar.bcS() != 0 && kVar.bcR() != 0) {
                    m mVar = new m(id, kVar.bcS(), kVar.bcR());
                    this.osf.orZ.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.bcT(), "1")) {
                    this.osf.osa.add(id);
                } else {
                    this.osf.osa.remove(id);
                }
                if (TextUtils.equals(kVar.edi(), "1")) {
                    this.osf.osb.add(id);
                } else {
                    this.osf.osb.remove(id);
                }
                String edj = kVar.edj();
                if (!TextUtils.isEmpty(edj) && !TextUtils.equals(edj, "0")) {
                    this.osf.osc.put(id, edj);
                } else {
                    this.osf.osc.remove(id);
                }
                String edk = kVar.edk();
                if (!TextUtils.isEmpty(edk)) {
                    this.osf.osd.put(id, edk);
                } else {
                    this.osf.osd.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ag(String str, int i) {
        if (this.osf.orS.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.osf.orV.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yI(String str) {
        if (this.ors.eds()) {
            return true;
        }
        return this.osf.orT.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Wn(String str) {
        if (!isBeta() && this.ors.edr() && yL(str) > 0) {
            return new Random().nextInt(100) >= yL(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yJ(String str) {
        return this.osf.orU.contains(str);
    }

    boolean Wo(String str) {
        return this.osf.orW.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yK(String str) {
        return this.osf.orY.containsKey(str) ? this.osf.orY.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bcI() {
        return this.ekg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nc(int i) {
        if (i * 60000 >= this.ekg) {
            this.ekg = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bcJ() {
        return this.ekh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nd(int i) {
        if (i >= this.ekh) {
            this.ekh = i;
            ag.edu().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bcK() {
        return this.eki;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ne(int i) {
        if (i >= this.eki) {
            this.eki = i;
            ag.edu().putInt("ubc_database_limit", i);
        }
    }

    int yL(String str) {
        if (TextUtils.isEmpty(str) || !this.osf.orX.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.osf.orX.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yM(String str) {
        if (this.osf.orZ == null || !this.osf.orZ.containsKey(str)) {
            return false;
        }
        return this.osf.orZ.get(str).bcU();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yN(String str) {
        if (this.osf.orZ == null || !this.osf.orZ.containsKey(str)) {
            return false;
        }
        return this.osf.orZ.get(str).bcV();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yO(String str) {
        return (TextUtils.isEmpty(str) || !this.osf.osa.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Wp(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !Wo(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Wq(String str) {
        return this.osf.osb.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Wr(String str) {
        return this.osf.orT.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Ws(String str) {
        return this.osf.osc.containsKey(str) ? this.osf.osc.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.osf.osd.containsKey(str) ? this.osf.osd.get(str) : "";
    }

    public boolean Wt(String str) {
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
