package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private long bva;
    private long bvb;
    private long bvc;
    private int bvd;
    private SparseArray<ArrayList> bve;
    private HashMap<String, Long> bvf;
    private a jOR;
    private b jOS;
    private e jOU;
    private Context mContext;
    private m jOT = UBC.getUBCContext().aGo();
    private List<j> buZ = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.jOR = new a(context);
        this.jOS = new b(context);
        r cAg = r.cAg();
        this.bva = cAg.getLong("ubc_last_upload_all_time", 0L);
        this.bvb = cAg.getLong("ubc_last_upload_non_real", 0L);
        this.bvc = cAg.getLong("ubc_reset_real_time_count_time", 0L);
        this.bvd = cAg.getInt("ubc_real_time_count", 0);
        this.jOU = e.cAf();
        this.jOU.a(this, context);
    }

    private void Wx() {
        if (this.bve == null) {
            this.bve = new SparseArray<>();
            this.jOR.a(this.bve);
            this.bvf = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.bve.size(); i2++) {
                int keyAt = this.bve.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.bvf.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.jOU.fR(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        boolean z = false;
        if (TextUtils.equals(jVar.getId(), jVar.WU()) && this.jOU.kG(jVar.getId()) && (jVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.jOR.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.bvb) >= e.cAf().WJ()) {
            if (!z) {
                this.buZ.add(jVar);
            }
            WC();
        } else if ((jVar.getOption() & 1) == 0) {
            if (!z) {
                this.buZ.add(jVar);
            }
            if (this.buZ.size() >= 20) {
                Wy();
            }
        } else if (!z) {
            this.jOR.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.jOS.a(jVar, this.jOU.kG(jVar.getId()));
    }

    private void Wy() {
        if (this.buZ != null && this.buZ.size() != 0) {
            this.jOR.H(this.buZ);
            this.buZ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.jOR.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.jOR.c(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        Wy();
        this.jOR.a(str, i, j, jSONArray);
        if (this.jOU.kG(str)) {
            Wz();
        }
        if (Math.abs(System.currentTimeMillis() - this.bvb) >= e.cAf().WJ()) {
            WC();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        Wy();
        this.jOR.t(str, i);
        if (Math.abs(System.currentTimeMillis() - this.bvb) >= e.cAf().WJ()) {
            WC();
        }
    }

    private boolean c(j jVar) {
        if (cg(this.mContext) && WA()) {
            Wy();
            s sVar = new s();
            sVar.dn(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", jVar.getId());
                jSONObject.put("timestamp", Long.toString(jVar.getTime()));
                if (jVar.WX() != null) {
                    jSONObject.put("content", jVar.WX().toString());
                } else {
                    jSONObject.put("content", jVar.getContent());
                }
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(jVar.WW())) {
                    jSONObject.put(ImageViewerConfig.ABTEST, jVar.WW());
                    sVar.kV("1");
                }
                if (!TextUtils.isEmpty(jVar.getCategory())) {
                    jSONObject.put("c", jVar.getCategory());
                }
                if (jVar.WS()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put("idtype", this.jOU.kM(jVar.getId()));
                sVar.aU(jSONObject);
                sVar.g(jVar.getTime(), jVar.getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.bve == null) {
                Wx();
            }
            if (this.bve.size() > 0) {
                this.jOR.a(this.bve.valueAt(0), sVar);
            }
            c(sVar);
            WB();
            return true;
        }
        return false;
    }

    private void Wz() {
        if (cg(this.mContext) && WA()) {
            s sVar = new s();
            sVar.dn(true);
            if (this.bve == null) {
                Wx();
            }
            if (this.bve.size() > 0) {
                if (UBC.getUBCContext().Ht()) {
                    this.jOR.a(sVar);
                } else {
                    this.jOR.a(this.bve.valueAt(0), sVar);
                }
            }
            c(sVar);
            WB();
        }
    }

    private boolean WA() {
        if (UBC.getUBCContext().Ht()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.bvc) > 86400000) {
            this.bvd = 0;
            this.bvc = currentTimeMillis;
            r.cAg().putLong("ubc_reset_real_time_count_time", this.bvc);
            r.cAg().putInt("ubc_real_time_count", this.bvd);
        }
        if (this.bvd >= 1000) {
            if (this.bvd == 1000) {
                this.bvd++;
                UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void WB() {
        this.bvd++;
        r.cAg().putInt("ubc_real_time_count", this.bvd);
    }

    private void WC() {
        if (cg(this.mContext)) {
            this.bvb = System.currentTimeMillis();
            r.cAg().putLong("ubc_last_upload_non_real", this.bvb);
            WE();
            Wy();
            this.jOR.Ws();
            HashSet hashSet = new HashSet();
            if (this.bve == null) {
                Wx();
            }
            s sVar = new s();
            sVar.dn(false);
            int i = 0;
            for (int i2 = 0; i2 < this.bve.size(); i2++) {
                int keyAt = this.bve.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.bvf.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.jOU.WJ()) {
                        i |= this.jOR.a(this.bve.valueAt(i2), sVar);
                        this.bvf.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.bve.size(); i3++) {
                    int keyAt2 = this.bve.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (sVar.ga(51200)) {
                            break;
                        }
                        this.jOR.a(this.bve.valueAt(i3), sVar);
                    }
                }
                c(sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void WD() {
        if (cg(this.mContext) && Math.abs(System.currentTimeMillis() - this.bva) >= 3600000) {
            this.jOR.Ws();
            s sVar = new s();
            if (this.jOR.a(sVar) != 0) {
                s sVar2 = new s();
                sVar2.g(sVar.Xy(), sVar.Xz());
                sVar2.kV(sVar.Xx());
                sVar2.dn(true);
                s sVar3 = new s();
                sVar3.g(sVar.Xy(), sVar.Xz());
                sVar3.kV(sVar.Xx());
                sVar3.dn(false);
                SparseArray<Integer> Xu = sVar.Xu();
                int size = Xu.size();
                for (int i = 0; i < size; i++) {
                    if (this.jOU.kG(String.valueOf(Xu.valueAt(i).intValue()))) {
                        sVar2.N(Xu.keyAt(i), Xu.valueAt(i).intValue());
                    } else {
                        sVar3.N(Xu.keyAt(i), Xu.valueAt(i).intValue());
                    }
                }
                ArrayList Xv = sVar.Xv();
                int size2 = Xv.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) Xv.get(i2);
                    if (this.jOU.kG(str)) {
                        sVar2.kU(str);
                    } else {
                        sVar3.kU(str);
                    }
                }
                JSONArray XA = sVar.XA();
                int length = XA.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = XA.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.jOU.kG(str2)) {
                                sVar2.aU(optJSONObject);
                            } else {
                                sVar3.aU(optJSONObject);
                            }
                        }
                    }
                }
                if (sVar2.XA().length() > 0) {
                    c(sVar2);
                }
                if (sVar3.XA().length() > 0) {
                    c(sVar3);
                }
                this.bva = System.currentTimeMillis();
                r.cAg().putLong("ubc_last_upload_all_time", this.bva);
                this.bvb = this.bva;
                r.cAg().putLong("ubc_last_upload_non_real", this.bvb);
            }
        }
    }

    private void c(s sVar) {
        if (!sVar.isEmpty()) {
            JSONObject cAi = sVar.cAi();
            String md5 = com.baidu.f.c.toMd5(cAi.toString().getBytes(), true);
            bp(cAi.toString(), md5);
            if (!this.jOR.a(sVar.Xu(), sVar.Xv(), sVar.XB(), md5)) {
                sVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.jOR.kB(md5);
                return;
            }
            d.cAe().m(cAi, md5);
            sVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(JSONObject jSONObject, String str) {
        if (this.jOT.a("https://mbd.baidu.com", jSONObject, false)) {
            d.cAe().I(str, true);
        } else {
            d.cAe().I(str, false);
        }
    }

    private void WE() {
        dl(true);
        dl(false);
    }

    private void dl(boolean z) {
        s sVar = new s();
        sVar.dn(z);
        if (this.jOS.a(sVar, z)) {
            JSONObject cAi = sVar.cAi();
            this.jOS.dk(z);
            d.cAe().bT(cAi);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bT(JSONObject jSONObject) {
        if (!this.jOT.a("http://m.baidu.com", jSONObject, false)) {
            UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a cAd() {
        return this.jOR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.jOU.J(nVar.Xl());
        this.jOU.fS(nVar.Xk() * 86400000);
        this.jOU.fT(nVar.getThreshold());
        r.cAg().putString("ubc_version_md5", nVar.getSign());
        this.jOR.I(nVar.Xl());
        nVar.Xl().clear();
        if (this.bve == null) {
            this.bve = new SparseArray<>();
        }
        this.bve.clear();
        if (this.bvf == null) {
            this.bvf = new HashMap<>();
        }
        this.bvf.clear();
        this.jOR.a(this.bve);
        int i = 0;
        for (int i2 = 0; i2 < this.bve.size(); i2++) {
            int keyAt = this.bve.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.bvf.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.jOU.fR(i);
    }

    private boolean cg(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isAvailable();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [952=4] */
    private void bp(String str, String str2) {
        OutputStream fileOutputStream;
        String str3 = this.mContext.getFilesDir() + File.separator + "ubcsenddir";
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str3, str2);
        if (file2.exists()) {
            return;
        }
        OutputStream outputStream = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            outputStream = new Base64OutputStream(fileOutputStream, 0);
            outputStream.write(str.getBytes());
            outputStream.flush();
            o.kT("save to file suc");
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e = e3;
            outputStream = fileOutputStream;
            e.printStackTrace();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = fileOutputStream;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kD(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        o.kT("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            o.kT("delete file suc");
        }
        this.jOR.kB(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kE(String str) {
        o.kT("upload file fail");
        this.jOR.kC(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void WH() {
        this.jOR.Wu();
    }
}
