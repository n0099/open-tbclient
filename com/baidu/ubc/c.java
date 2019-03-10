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
    private long boR;
    private long boS;
    private long boT;
    private int boU;
    private SparseArray<ArrayList> boV;
    private HashMap<String, Long> boW;
    private a jwh;
    private b jwi;
    private e jwk;
    private Context mContext;
    private m jwj = UBC.getUBCContext().aAe();
    private List<j> boQ = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.jwh = new a(context);
        this.jwi = new b(context);
        r csg = r.csg();
        this.boR = csg.getLong("ubc_last_upload_all_time", 0L);
        this.boS = csg.getLong("ubc_last_upload_non_real", 0L);
        this.boT = csg.getLong("ubc_reset_real_time_count_time", 0L);
        this.boU = csg.getInt("ubc_real_time_count", 0);
        this.jwk = e.crV();
        this.jwk.a(this, context);
    }

    private void SM() {
        if (this.boV == null) {
            this.boV = new SparseArray<>();
            this.jwh.a(this.boV);
            this.boW = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.boV.size(); i2++) {
                int keyAt = this.boV.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.boW.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.jwk.fo(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        boolean z = false;
        if (TextUtils.equals(jVar.getId(), jVar.Tc()) && this.jwk.jH(jVar.getId()) && (jVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.jwh.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.boS) >= e.crV().SX()) {
            if (!z) {
                this.boQ.add(jVar);
            }
            SR();
        } else if ((jVar.getOption() & 1) == 0) {
            if (!z) {
                this.boQ.add(jVar);
            }
            if (this.boQ.size() >= 20) {
                SN();
            }
        } else if (!z) {
            this.jwh.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.jwi.a(jVar, this.jwk.jH(jVar.getId()));
    }

    private void SN() {
        if (this.boQ != null && this.boQ.size() != 0) {
            this.jwh.G(this.boQ);
            this.boQ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.jwh.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.jwh.c(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        SN();
        this.jwh.a(str, i, j, jSONArray);
        if (this.jwk.jH(str)) {
            SO();
        }
        if (Math.abs(System.currentTimeMillis() - this.boS) >= e.crV().SX()) {
            SR();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(String str, int i) {
        SN();
        this.jwh.y(str, i);
        if (Math.abs(System.currentTimeMillis() - this.boS) >= e.crV().SX()) {
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
                jSONObject.put("idtype", this.jwk.jN(jVar.getId()));
                sVar.aI(jSONObject);
                sVar.g(jVar.getTime(), jVar.getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.boV == null) {
                SM();
            }
            if (this.boV.size() > 0) {
                this.jwh.a(this.boV.valueAt(0), sVar);
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
            if (this.boV == null) {
                SM();
            }
            if (this.boV.size() > 0) {
                if (UBC.getUBCContext().Fq()) {
                    this.jwh.a(sVar);
                } else {
                    this.jwh.a(this.boV.valueAt(0), sVar);
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
        if (Math.abs(currentTimeMillis - this.boT) > 86400000) {
            this.boU = 0;
            this.boT = currentTimeMillis;
            r.csg().putLong("ubc_reset_real_time_count_time", this.boT);
            r.csg().putInt("ubc_real_time_count", this.boU);
        }
        if (this.boU >= 1000) {
            if (this.boU == 1000) {
                this.boU++;
                UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void SQ() {
        this.boU++;
        r.csg().putInt("ubc_real_time_count", this.boU);
    }

    private void SR() {
        if (cD(this.mContext)) {
            this.boS = System.currentTimeMillis();
            r.csg().putLong("ubc_last_upload_non_real", this.boS);
            ST();
            SN();
            this.jwh.SI();
            HashSet hashSet = new HashSet();
            if (this.boV == null) {
                SM();
            }
            s sVar = new s();
            sVar.cW(false);
            int i = 0;
            for (int i2 = 0; i2 < this.boV.size(); i2++) {
                int keyAt = this.boV.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.boW.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.jwk.SX()) {
                        i |= this.jwh.a(this.boV.valueAt(i2), sVar);
                        this.boW.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.boV.size(); i3++) {
                    int keyAt2 = this.boV.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (sVar.fs(51200)) {
                            break;
                        }
                        this.jwh.a(this.boV.valueAt(i3), sVar);
                    }
                }
                c(sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void SS() {
        if (cD(this.mContext) && Math.abs(System.currentTimeMillis() - this.boR) >= 3600000) {
            this.jwh.SI();
            s sVar = new s();
            if (this.jwh.a(sVar) != 0) {
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
                    if (this.jwk.jH(String.valueOf(Tv.valueAt(i).intValue()))) {
                        sVar2.P(Tv.keyAt(i), Tv.valueAt(i).intValue());
                    } else {
                        sVar3.P(Tv.keyAt(i), Tv.valueAt(i).intValue());
                    }
                }
                ArrayList Tw = sVar.Tw();
                int size2 = Tw.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) Tw.get(i2);
                    if (this.jwk.jH(str)) {
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
                            if (this.jwk.jH(str2)) {
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
                this.boR = System.currentTimeMillis();
                r.csg().putLong("ubc_last_upload_all_time", this.boR);
                this.boS = this.boR;
                r.csg().putLong("ubc_last_upload_non_real", this.boS);
            }
        }
    }

    private void c(s sVar) {
        if (!sVar.isEmpty()) {
            JSONObject csi = sVar.csi();
            String md5 = com.baidu.f.c.toMd5(csi.toString().getBytes(), true);
            bk(csi.toString(), md5);
            if (!this.jwh.a(sVar.Tv(), sVar.Tw(), sVar.TC(), md5)) {
                sVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.jwh.jD(md5);
                return;
            }
            d.crU().n(csi, md5);
            sVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n(JSONObject jSONObject, String str) {
        if (this.jwj.a("https://mbd.baidu.com", jSONObject, false)) {
            d.crU().G(str, true);
        } else {
            d.crU().G(str, false);
        }
    }

    private void ST() {
        cU(true);
        cU(false);
    }

    private void cU(boolean z) {
        s sVar = new s();
        sVar.cW(z);
        if (this.jwi.a(sVar, z)) {
            JSONObject csi = sVar.csi();
            this.jwi.cT(z);
            d.crU().bH(csi);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bH(JSONObject jSONObject) {
        if (!this.jwj.a("http://m.baidu.com", jSONObject, false)) {
            UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a crT() {
        return this.jwh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.jwk.ev(nVar.cse());
        this.jwk.BE(nVar.csd() * 86400000);
        this.jwk.BF(nVar.getThreshold());
        r.csg().putString("ubc_version_md5", nVar.csc());
        this.jwh.eu(nVar.cse());
        nVar.cse().clear();
        if (this.boV == null) {
            this.boV = new SparseArray<>();
        }
        this.boV.clear();
        if (this.boW == null) {
            this.boW = new HashMap<>();
        }
        this.boW.clear();
        this.jwh.a(this.boV);
        int i = 0;
        for (int i2 = 0; i2 < this.boV.size(); i2++) {
            int keyAt = this.boV.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.boW.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.jwk.fo(i);
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
        this.jwh.jD(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jG(String str) {
        o.jT("upload file fail");
        this.jwh.jE(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void SV() {
        this.jwh.SJ();
    }
}
