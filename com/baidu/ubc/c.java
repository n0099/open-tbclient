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
    private long boS;
    private long boT;
    private long boU;
    private int boV;
    private SparseArray<ArrayList> boW;
    private HashMap<String, Long> boX;
    private a jvZ;
    private b jwa;
    private e jwc;
    private Context mContext;
    private m jwb = UBC.getUBCContext().aAd();
    private List<j> boR = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.jvZ = new a(context);
        this.jwa = new b(context);
        r csj = r.csj();
        this.boS = csj.getLong("ubc_last_upload_all_time", 0L);
        this.boT = csj.getLong("ubc_last_upload_non_real", 0L);
        this.boU = csj.getLong("ubc_reset_real_time_count_time", 0L);
        this.boV = csj.getInt("ubc_real_time_count", 0);
        this.jwc = e.crY();
        this.jwc.a(this, context);
    }

    private void SM() {
        if (this.boW == null) {
            this.boW = new SparseArray<>();
            this.jvZ.a(this.boW);
            this.boX = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.boW.size(); i2++) {
                int keyAt = this.boW.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.boX.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.jwc.fo(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        boolean z = false;
        if (TextUtils.equals(jVar.getId(), jVar.Tc()) && this.jwc.jH(jVar.getId()) && (jVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.jvZ.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.boT) >= e.crY().SX()) {
            if (!z) {
                this.boR.add(jVar);
            }
            SR();
        } else if ((jVar.getOption() & 1) == 0) {
            if (!z) {
                this.boR.add(jVar);
            }
            if (this.boR.size() >= 20) {
                SN();
            }
        } else if (!z) {
            this.jvZ.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.jwa.a(jVar, this.jwc.jH(jVar.getId()));
    }

    private void SN() {
        if (this.boR != null && this.boR.size() != 0) {
            this.jvZ.G(this.boR);
            this.boR.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.jvZ.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.jvZ.c(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        SN();
        this.jvZ.a(str, i, j, jSONArray);
        if (this.jwc.jH(str)) {
            SO();
        }
        if (Math.abs(System.currentTimeMillis() - this.boT) >= e.crY().SX()) {
            SR();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(String str, int i) {
        SN();
        this.jvZ.y(str, i);
        if (Math.abs(System.currentTimeMillis() - this.boT) >= e.crY().SX()) {
            SR();
        }
    }

    private boolean c(j jVar) {
        if (cD(this.mContext) && SP()) {
            SN();
            s sVar = new s();
            sVar.cW(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", jVar.getId());
                jSONObject.put("timestamp", Long.toString(jVar.getTime()));
                if (jVar.Tf() != null) {
                    jSONObject.put("content", jVar.Tf().toString());
                } else {
                    jSONObject.put("content", jVar.getContent());
                }
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(jVar.Te())) {
                    jSONObject.put(ImageViewerConfig.ABTEST, jVar.Te());
                    sVar.jV("1");
                }
                if (!TextUtils.isEmpty(jVar.getCategory())) {
                    jSONObject.put("c", jVar.getCategory());
                }
                if (jVar.Ta()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put("idtype", this.jwc.jN(jVar.getId()));
                sVar.aI(jSONObject);
                sVar.g(jVar.getTime(), jVar.getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.boW == null) {
                SM();
            }
            if (this.boW.size() > 0) {
                this.jvZ.a(this.boW.valueAt(0), sVar);
            }
            c(sVar);
            SQ();
            return true;
        }
        return false;
    }

    private void SO() {
        if (cD(this.mContext) && SP()) {
            s sVar = new s();
            sVar.cW(true);
            if (this.boW == null) {
                SM();
            }
            if (this.boW.size() > 0) {
                if (UBC.getUBCContext().Fq()) {
                    this.jvZ.a(sVar);
                } else {
                    this.jvZ.a(this.boW.valueAt(0), sVar);
                }
            }
            c(sVar);
            SQ();
        }
    }

    private boolean SP() {
        if (UBC.getUBCContext().Fq()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.boU) > 86400000) {
            this.boV = 0;
            this.boU = currentTimeMillis;
            r.csj().putLong("ubc_reset_real_time_count_time", this.boU);
            r.csj().putInt("ubc_real_time_count", this.boV);
        }
        if (this.boV >= 1000) {
            if (this.boV == 1000) {
                this.boV++;
                UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void SQ() {
        this.boV++;
        r.csj().putInt("ubc_real_time_count", this.boV);
    }

    private void SR() {
        if (cD(this.mContext)) {
            this.boT = System.currentTimeMillis();
            r.csj().putLong("ubc_last_upload_non_real", this.boT);
            ST();
            SN();
            this.jvZ.SI();
            HashSet hashSet = new HashSet();
            if (this.boW == null) {
                SM();
            }
            s sVar = new s();
            sVar.cW(false);
            int i = 0;
            for (int i2 = 0; i2 < this.boW.size(); i2++) {
                int keyAt = this.boW.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.boX.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.jwc.SX()) {
                        i |= this.jvZ.a(this.boW.valueAt(i2), sVar);
                        this.boX.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.boW.size(); i3++) {
                    int keyAt2 = this.boW.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (sVar.fs(51200)) {
                            break;
                        }
                        this.jvZ.a(this.boW.valueAt(i3), sVar);
                    }
                }
                c(sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void SS() {
        if (cD(this.mContext) && Math.abs(System.currentTimeMillis() - this.boS) >= 3600000) {
            this.jvZ.SI();
            s sVar = new s();
            if (this.jvZ.a(sVar) != 0) {
                s sVar2 = new s();
                sVar2.g(sVar.Tz(), sVar.TA());
                sVar2.jV(sVar.Ty());
                sVar2.cW(true);
                s sVar3 = new s();
                sVar3.g(sVar.Tz(), sVar.TA());
                sVar3.jV(sVar.Ty());
                sVar3.cW(false);
                SparseArray<Integer> Tv = sVar.Tv();
                int size = Tv.size();
                for (int i = 0; i < size; i++) {
                    if (this.jwc.jH(String.valueOf(Tv.valueAt(i).intValue()))) {
                        sVar2.P(Tv.keyAt(i), Tv.valueAt(i).intValue());
                    } else {
                        sVar3.P(Tv.keyAt(i), Tv.valueAt(i).intValue());
                    }
                }
                ArrayList Tw = sVar.Tw();
                int size2 = Tw.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) Tw.get(i2);
                    if (this.jwc.jH(str)) {
                        sVar2.jU(str);
                    } else {
                        sVar3.jU(str);
                    }
                }
                JSONArray TB = sVar.TB();
                int length = TB.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = TB.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.jwc.jH(str2)) {
                                sVar2.aI(optJSONObject);
                            } else {
                                sVar3.aI(optJSONObject);
                            }
                        }
                    }
                }
                if (sVar2.TB().length() > 0) {
                    c(sVar2);
                }
                if (sVar3.TB().length() > 0) {
                    c(sVar3);
                }
                this.boS = System.currentTimeMillis();
                r.csj().putLong("ubc_last_upload_all_time", this.boS);
                this.boT = this.boS;
                r.csj().putLong("ubc_last_upload_non_real", this.boT);
            }
        }
    }

    private void c(s sVar) {
        if (!sVar.isEmpty()) {
            JSONObject csl = sVar.csl();
            String md5 = com.baidu.f.c.toMd5(csl.toString().getBytes(), true);
            bk(csl.toString(), md5);
            if (!this.jvZ.a(sVar.Tv(), sVar.Tw(), sVar.TC(), md5)) {
                sVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.jvZ.jD(md5);
                return;
            }
            d.crX().n(csl, md5);
            sVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n(JSONObject jSONObject, String str) {
        if (this.jwb.a("https://mbd.baidu.com", jSONObject, false)) {
            d.crX().G(str, true);
        } else {
            d.crX().G(str, false);
        }
    }

    private void ST() {
        cU(true);
        cU(false);
    }

    private void cU(boolean z) {
        s sVar = new s();
        sVar.cW(z);
        if (this.jwa.a(sVar, z)) {
            JSONObject csl = sVar.csl();
            this.jwa.cT(z);
            d.crX().bH(csl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bH(JSONObject jSONObject) {
        if (!this.jwb.a("http://m.baidu.com", jSONObject, false)) {
            UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a crW() {
        return this.jvZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.jwc.ev(nVar.csh());
        this.jwc.BE(nVar.csg() * 86400000);
        this.jwc.BF(nVar.getThreshold());
        r.csj().putString("ubc_version_md5", nVar.csf());
        this.jvZ.eu(nVar.csh());
        nVar.csh().clear();
        if (this.boW == null) {
            this.boW = new SparseArray<>();
        }
        this.boW.clear();
        if (this.boX == null) {
            this.boX = new HashMap<>();
        }
        this.boX.clear();
        this.jvZ.a(this.boW);
        int i = 0;
        for (int i2 = 0; i2 < this.boW.size(); i2++) {
            int keyAt = this.boW.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.boX.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.jwc.fo(i);
    }

    private boolean cD(Context context) {
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
    private void bk(String str, String str2) {
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
            o.jT("save to file suc");
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
    public void jF(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        o.jT("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            o.jT("delete file suc");
        }
        this.jvZ.jD(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jG(String str) {
        o.jT("upload file fail");
        this.jvZ.jE(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void SV() {
        this.jvZ.SJ();
    }
}
