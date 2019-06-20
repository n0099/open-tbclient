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
    private a jOU;
    private b jOV;
    private e jOX;
    private Context mContext;
    private m jOW = UBC.getUBCContext().aGo();
    private List<j> buZ = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.jOU = new a(context);
        this.jOV = new b(context);
        r cAf = r.cAf();
        this.bva = cAf.getLong("ubc_last_upload_all_time", 0L);
        this.bvb = cAf.getLong("ubc_last_upload_non_real", 0L);
        this.bvc = cAf.getLong("ubc_reset_real_time_count_time", 0L);
        this.bvd = cAf.getInt("ubc_real_time_count", 0);
        this.jOX = e.cAe();
        this.jOX.a(this, context);
    }

    private void Wx() {
        if (this.bve == null) {
            this.bve = new SparseArray<>();
            this.jOU.a(this.bve);
            this.bvf = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.bve.size(); i2++) {
                int keyAt = this.bve.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.bvf.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.jOX.fR(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        boolean z = false;
        if (TextUtils.equals(jVar.getId(), jVar.WU()) && this.jOX.kF(jVar.getId()) && (jVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.jOU.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.bvb) >= e.cAe().WJ()) {
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
            this.jOU.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.jOV.a(jVar, this.jOX.kF(jVar.getId()));
    }

    private void Wy() {
        if (this.buZ != null && this.buZ.size() != 0) {
            this.jOU.H(this.buZ);
            this.buZ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.jOU.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.jOU.c(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        Wy();
        this.jOU.a(str, i, j, jSONArray);
        if (this.jOX.kF(str)) {
            Wz();
        }
        if (Math.abs(System.currentTimeMillis() - this.bvb) >= e.cAe().WJ()) {
            WC();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        Wy();
        this.jOU.t(str, i);
        if (Math.abs(System.currentTimeMillis() - this.bvb) >= e.cAe().WJ()) {
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
                    sVar.kU("1");
                }
                if (!TextUtils.isEmpty(jVar.getCategory())) {
                    jSONObject.put("c", jVar.getCategory());
                }
                if (jVar.WS()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put("idtype", this.jOX.kL(jVar.getId()));
                sVar.aU(jSONObject);
                sVar.g(jVar.getTime(), jVar.getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.bve == null) {
                Wx();
            }
            if (this.bve.size() > 0) {
                this.jOU.a(this.bve.valueAt(0), sVar);
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
                    this.jOU.a(sVar);
                } else {
                    this.jOU.a(this.bve.valueAt(0), sVar);
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
            r.cAf().putLong("ubc_reset_real_time_count_time", this.bvc);
            r.cAf().putInt("ubc_real_time_count", this.bvd);
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
        r.cAf().putInt("ubc_real_time_count", this.bvd);
    }

    private void WC() {
        if (cg(this.mContext)) {
            this.bvb = System.currentTimeMillis();
            r.cAf().putLong("ubc_last_upload_non_real", this.bvb);
            WE();
            Wy();
            this.jOU.Ws();
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
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.jOX.WJ()) {
                        i |= this.jOU.a(this.bve.valueAt(i2), sVar);
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
                        this.jOU.a(this.bve.valueAt(i3), sVar);
                    }
                }
                c(sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void WD() {
        if (cg(this.mContext) && Math.abs(System.currentTimeMillis() - this.bva) >= 3600000) {
            this.jOU.Ws();
            s sVar = new s();
            if (this.jOU.a(sVar) != 0) {
                s sVar2 = new s();
                sVar2.g(sVar.Xy(), sVar.Xz());
                sVar2.kU(sVar.Xx());
                sVar2.dn(true);
                s sVar3 = new s();
                sVar3.g(sVar.Xy(), sVar.Xz());
                sVar3.kU(sVar.Xx());
                sVar3.dn(false);
                SparseArray<Integer> Xu = sVar.Xu();
                int size = Xu.size();
                for (int i = 0; i < size; i++) {
                    if (this.jOX.kF(String.valueOf(Xu.valueAt(i).intValue()))) {
                        sVar2.N(Xu.keyAt(i), Xu.valueAt(i).intValue());
                    } else {
                        sVar3.N(Xu.keyAt(i), Xu.valueAt(i).intValue());
                    }
                }
                ArrayList Xv = sVar.Xv();
                int size2 = Xv.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) Xv.get(i2);
                    if (this.jOX.kF(str)) {
                        sVar2.kT(str);
                    } else {
                        sVar3.kT(str);
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
                            if (this.jOX.kF(str2)) {
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
                r.cAf().putLong("ubc_last_upload_all_time", this.bva);
                this.bvb = this.bva;
                r.cAf().putLong("ubc_last_upload_non_real", this.bvb);
            }
        }
    }

    private void c(s sVar) {
        if (!sVar.isEmpty()) {
            JSONObject cAh = sVar.cAh();
            String md5 = com.baidu.f.c.toMd5(cAh.toString().getBytes(), true);
            bp(cAh.toString(), md5);
            if (!this.jOU.a(sVar.Xu(), sVar.Xv(), sVar.XB(), md5)) {
                sVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.jOU.kA(md5);
                return;
            }
            d.cAd().m(cAh, md5);
            sVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(JSONObject jSONObject, String str) {
        if (this.jOW.a("https://mbd.baidu.com", jSONObject, false)) {
            d.cAd().I(str, true);
        } else {
            d.cAd().I(str, false);
        }
    }

    private void WE() {
        dl(true);
        dl(false);
    }

    private void dl(boolean z) {
        s sVar = new s();
        sVar.dn(z);
        if (this.jOV.a(sVar, z)) {
            JSONObject cAh = sVar.cAh();
            this.jOV.dk(z);
            d.cAd().bT(cAh);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bT(JSONObject jSONObject) {
        if (!this.jOW.a("http://m.baidu.com", jSONObject, false)) {
            UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a cAc() {
        return this.jOU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.jOX.J(nVar.Xl());
        this.jOX.fS(nVar.Xk() * 86400000);
        this.jOX.fT(nVar.getThreshold());
        r.cAf().putString("ubc_version_md5", nVar.getSign());
        this.jOU.I(nVar.Xl());
        nVar.Xl().clear();
        if (this.bve == null) {
            this.bve = new SparseArray<>();
        }
        this.bve.clear();
        if (this.bvf == null) {
            this.bvf = new HashMap<>();
        }
        this.bvf.clear();
        this.jOU.a(this.bve);
        int i = 0;
        for (int i2 = 0; i2 < this.bve.size(); i2++) {
            int keyAt = this.bve.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.bvf.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.jOX.fR(i);
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
            o.kS("save to file suc");
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
    public void kC(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        o.kS("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            o.kS("delete file suc");
        }
        this.jOU.kA(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kD(String str) {
        o.kS("upload file fail");
        this.jOU.kB(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void WH() {
        this.jOU.Wu();
    }
}
