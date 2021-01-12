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
    private static volatile g oIL;
    private int ewe;
    private int ewf;
    private int ewg;
    private Context mContext;
    private int oIM = 614400;
    private int oIN = 153600;
    private f oIO = new f();
    private af oHT = new af();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g eff() {
        if (oIL == null) {
            synchronized (e.class) {
                if (oIL == null) {
                    oIL = new g();
                }
            }
        }
        return oIL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.ewe = 360000;
        ai efB = ai.efB();
        this.ewf = efB.getInt("ubc_data_expire_time", PersonListModel.CACHETIME);
        this.ewg = efB.getInt("ubc_database_limit", 10000);
        cVar.efa().a(this.oIO);
        this.oIM = efB.getInt("ubc_launch_upload_max_limit", 614400);
        this.oIN = efB.getInt("ubc_single_log_max_limit", 153600);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bj(List<k> list) {
        for (k kVar : list) {
            String id = kVar.getId();
            if (!TextUtils.isEmpty(id)) {
                if ("0".equals(kVar.bew())) {
                    this.oIO.oIy.add(id);
                    this.oIO.oIB.remove(id);
                } else {
                    this.oIO.oIy.remove(id);
                    this.oIO.oIB.add(id);
                }
                if ("1".equals(kVar.bex())) {
                    this.oIO.oIz.add(id);
                } else {
                    this.oIO.oIz.remove(id);
                }
                if ("1".equals(kVar.bey())) {
                    this.oIO.oIA.add(id);
                } else {
                    this.oIO.oIA.remove(id);
                }
                if ("1".equals(kVar.efj())) {
                    this.oIO.oIC.add(id);
                } else {
                    this.oIO.oIC.remove(id);
                }
                if (kVar.bez() >= 1 && kVar.bez() <= 100) {
                    this.oIO.oID.put(id, String.valueOf(kVar.bez()));
                } else {
                    this.oIO.oID.remove(id);
                }
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    this.oIO.oIE.put(id, kVar.getCategory());
                } else {
                    this.oIO.oIE.remove(id);
                }
                if (kVar.beB() != 0 && kVar.beA() != 0) {
                    m mVar = new m(id, kVar.beA(), kVar.beB());
                    this.oIO.oIF.put(mVar.getId(), mVar);
                }
                if (TextUtils.equals(kVar.beC(), "1")) {
                    this.oIO.oIG.add(id);
                } else {
                    this.oIO.oIG.remove(id);
                }
                if (TextUtils.equals(kVar.efl(), "1")) {
                    this.oIO.oIH.add(id);
                } else {
                    this.oIO.oIH.remove(id);
                }
                String efm = kVar.efm();
                if (!TextUtils.isEmpty(efm) && !TextUtils.equals(efm, "0")) {
                    this.oIO.oII.put(id, efm);
                } else {
                    this.oIO.oII.remove(id);
                }
                String efn = kVar.efn();
                if (!TextUtils.isEmpty(efn)) {
                    this.oIO.oIJ.put(id, efn);
                } else {
                    this.oIO.oIJ.remove(id);
                }
                int efo = kVar.efo();
                if (efo != 2) {
                    this.oIO.oIK.put(id, Integer.valueOf(efo));
                } else {
                    this.oIO.oIK.remove(id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aj(String str, int i) {
        if (this.oIO.oIy.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.oIO.oIB.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yd(String str) {
        if (this.oHT.efw()) {
            return true;
        }
        return this.oIO.oIz.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Wc(String str) {
        if (!isBeta() && this.oHT.efz() && yg(str) > 0) {
            return new Random().nextInt(100) >= yg(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ye(String str) {
        return this.oIO.oIA.contains(str);
    }

    boolean Wd(String str) {
        return this.oIO.oIC.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yf(String str) {
        return this.oIO.oIE.containsKey(str) ? this.oIO.oIE.get(str) : "";
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
        return this.oIM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void MK(int i) {
        if (i >= 307200) {
            this.oIM = i;
            ai.efB().putInt("ubc_launch_upload_max_limit", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int efh() {
        return this.oIN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ML(int i) {
        if (i >= 30720) {
            this.oIN = i;
            ai.efB().putInt("ubc_single_log_max_limit", i);
        }
    }

    int yg(String str) {
        if (TextUtils.isEmpty(str) || !this.oIO.oID.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.oIO.oID.get(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yh(String str) {
        if (this.oIO.oIF == null || !this.oIO.oIF.containsKey(str)) {
            return false;
        }
        return this.oIO.oIF.get(str).beD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean yi(String str) {
        if (this.oIO.oIF == null || !this.oIO.oIF.containsKey(str)) {
            return false;
        }
        return this.oIO.oIF.get(str).beE();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yj(String str) {
        return (TextUtils.isEmpty(str) || !this.oIO.oIG.contains(str)) ? "0" : "1";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean We(String str) {
        return this.mContext == null || isNetworkConnected(this.mContext) || !Wd(str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Wf(String str) {
        return this.oIO.oIH.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Wg(String str) {
        return this.oIO.oIz.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Wh(String str) {
        return this.oIO.oII.containsKey(str) ? this.oIO.oII.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadType(String str) {
        return this.oIO.oIJ.containsKey(str) ? this.oIO.oIJ.get(str) : "";
    }

    public boolean Wi(String str) {
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
    public int Wj(String str) {
        Integer num;
        if (!this.oIO.oIK.containsKey(str) || (num = this.oIO.oIK.get(str)) == null) {
            return 2;
        }
        return num.intValue();
    }
}
