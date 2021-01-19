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
    private static volatile g oIM;
    private int ewe;
    private int ewf;
    private int ewg;
    private Context mContext;
    private int oIN = 614400;
    private int oIO = 153600;
    private f oIP = new f();
    private af oHU = new af();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g eff() {
        if (oIM == null) {
            synchronized (e.class) {
                if (oIM == null) {
                    oIM = new g();
                }
            }
        }
        return oIM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.ewe = 360000;
        ai efB = ai.efB();
        this.ewf = efB.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.ewg = efB.getInt("ubc_database_limit", 10000);
        cVar.efa().a(this.oIP);
        this.oIN = efB.getInt("ubc_launch_upload_max_limit", 614400);
        this.oIO = efB.getInt("ubc_single_log_max_limit", 153600);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bj(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.bew())) {
                    this.oIP.oIz.add(id);
                    this.oIP.oIC.remove(id);
                } else {
                    this.oIP.oIz.remove(id);
                    this.oIP.oIC.add(id);
                }
                if ("1".equals(kVar.bex())) {
                    this.oIP.oIA.add(id);
                } else {
                    this.oIP.oIA.remove(id);
                }
                if ("1".equals(kVar.bey())) {
                    this.oIP.oIB.add(id);
                } else {
                    this.oIP.oIB.remove(id);
                }
                if ("1".equals(kVar.efj())) {
                    this.oIP.oID.add(id);
                } else {
                    this.oIP.oID.remove(id);
                }
                if (kVar.bez() >= 1 && kVar.bez() <= 100) {
                    this.oIP.oIE.put(id, String.valueOf(kVar.bez()));
                } else {
                    this.oIP.oIE.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.oIP.oIF.put(id, kVar.getCategory());
                } else {
                    this.oIP.oIF.remove(id);
                }
                if (kVar.beB() != 0 && kVar.beA() != 0) {
                    m mVar = new m(id, kVar.beA(), kVar.beB());
                    this.oIP.oIG.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.beC(), "1")) {
                    this.oIP.oIH.add(id);
                } else {
                    this.oIP.oIH.remove(id);
                }
                if (TextUtils.equals(kVar.efl(), "1")) {
                    this.oIP.oII.add(id);
                } else {
                    this.oIP.oII.remove(id);
                }
                String efm = kVar.efm();
                if (!TextUtils.isEmpty(efm) && !TextUtils.equals(efm, "0")) {
                    this.oIP.oIJ.put(id, efm);
                } else {
                    this.oIP.oIJ.remove(id);
                }
                String efn = kVar.efn();
                if (!TextUtils.isEmpty(efn)) {
                    this.oIP.oIK.put(id, efn);
                } else {
                    this.oIP.oIK.remove(id);
                }
                int efo = kVar.efo();
                if (efo != 2) {
                    this.oIP.oIL.put(id, Integer.valueOf(efo));
                } else {
                    this.oIP.oIL.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aj(String str, int i) {
        if (this.oIP.oIz.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.oIP.oIC.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yd(String str) {
        if (this.oHU.efw()) {
            return true;
        }
        return this.oIP.oIA.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Wd(String str) {
        if (!isBeta() && this.oHU.efz() && yg(str) > 0) {
            return new Random().nextInt(100) >= yg(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ye(String str) {
        return this.oIP.oIB.contains(str);
    }

    boolean We(String str) {
        return this.oIP.oID.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yf(String str) {
        return this.oIP.oIF.containsKey(str) ? this.oIP.oIF.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ber() {
        return this.ewe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void md(int i) {
        if (i * 60000 >= this.ewe) {
            this.ewe = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bes() {
        return this.ewf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void me(int i) {
        if (i >= this.ewf) {
            this.ewf = i;
            ai.efB().putInt("ubc_data_expire_time", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bet() {
        return this.ewg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mf(int i) {
        if (i >= this.ewg) {
            this.ewg = i;
            ai.efB().putInt("ubc_database_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int efg() {
        return this.oIN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void MK(int i) {
        if (i >= 307200) {
            this.oIN = i;
            ai.efB().putInt("ubc_launch_upload_max_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int efh() {
        return this.oIO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ML(int i) {
        if (i >= 30720) {
            this.oIO = i;
            ai.efB().putInt("ubc_single_log_max_limit", i);
        }
    }

    int yg(String str) {
        if (TextUtils.isEmpty(str) || !this.oIP.oIE.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.oIP.oIE.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yh(String str) {
        if (this.oIP.oIG == null || !this.oIP.oIG.containsKey(str)) {
            return false;
        }
        return this.oIP.oIG.get(str).beD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yi(String str) {
        if (this.oIP.oIG == null || !this.oIP.oIG.containsKey(str)) {
            return false;
        }
        return this.oIP.oIG.get(str).beE();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yj(String str) {
        return (TextUtils.isEmpty(str) || !this.oIP.oIH.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Wf(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !We(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Wg(String str) {
        return this.oIP.oII.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Wh(String str) {
        return this.oIP.oIA.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Wi(String str) {
        return this.oIP.oIJ.containsKey(str) ? this.oIP.oIJ.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oIP.oIK.containsKey(str) ? this.oIP.oIK.get(str) : "";
    }

    public boolean Wj(String str) {
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
    public int Wk(String str) {
        Integer num;
        if (!this.oIP.oIL.containsKey(str) || (num = this.oIP.oIL.get(str)) == null) {
            return 2;
        }
        return num.intValue();
    }
}
