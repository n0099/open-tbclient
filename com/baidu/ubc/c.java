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
    private long boV;
    private long boW;
    private long boX;
    private int boY;
    private SparseArray<ArrayList> boZ;
    private HashMap<String, Long> bpa;
    private a jvP;
    private b jvQ;
    private e jvS;
    private Context mContext;
    private m jvR = UBC.getUBCContext().aAa();
    private List<j> boU = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.jvP = new a(context);
        this.jvQ = new b(context);
        r csh = r.csh();
        this.boV = csh.getLong("ubc_last_upload_all_time", 0L);
        this.boW = csh.getLong("ubc_last_upload_non_real", 0L);
        this.boX = csh.getLong("ubc_reset_real_time_count_time", 0L);
        this.boY = csh.getInt("ubc_real_time_count", 0);
        this.jvS = e.crW();
        this.jvS.a(this, context);
    }

    private void SK() {
        if (this.boZ == null) {
            this.boZ = new SparseArray<>();
            this.jvP.a(this.boZ);
            this.bpa = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.boZ.size(); i2++) {
                int keyAt = this.boZ.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.bpa.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.jvS.fn(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        boolean z = false;
        if (TextUtils.equals(jVar.getId(), jVar.Ta()) && this.jvS.jI(jVar.getId()) && (jVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.jvP.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.boW) >= e.crW().SV()) {
            if (!z) {
                this.boU.add(jVar);
            }
            SP();
        } else if ((jVar.getOption() & 1) == 0) {
            if (!z) {
                this.boU.add(jVar);
            }
            if (this.boU.size() >= 20) {
                SL();
            }
        } else if (!z) {
            this.jvP.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.jvQ.a(jVar, this.jvS.jI(jVar.getId()));
    }

    private void SL() {
        if (this.boU != null && this.boU.size() != 0) {
            this.jvP.G(this.boU);
            this.boU.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.jvP.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.jvP.c(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        SL();
        this.jvP.a(str, i, j, jSONArray);
        if (this.jvS.jI(str)) {
            SM();
        }
        if (Math.abs(System.currentTimeMillis() - this.boW) >= e.crW().SV()) {
            SP();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(String str, int i) {
        SL();
        this.jvP.y(str, i);
        if (Math.abs(System.currentTimeMillis() - this.boW) >= e.crW().SV()) {
            SP();
        }
    }

    private boolean c(j jVar) {
        if (cD(this.mContext) && SN()) {
            SL();
            s sVar = new s();
            sVar.cW(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", jVar.getId());
                jSONObject.put("timestamp", Long.toString(jVar.getTime()));
                if (jVar.Td() != null) {
                    jSONObject.put("content", jVar.Td().toString());
                } else {
                    jSONObject.put("content", jVar.getContent());
                }
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(jVar.Tc())) {
                    jSONObject.put(ImageViewerConfig.ABTEST, jVar.Tc());
                    sVar.jW("1");
                }
                if (!TextUtils.isEmpty(jVar.getCategory())) {
                    jSONObject.put("c", jVar.getCategory());
                }
                if (jVar.SY()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put("idtype", this.jvS.jO(jVar.getId()));
                sVar.aI(jSONObject);
                sVar.g(jVar.getTime(), jVar.getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.boZ == null) {
                SK();
            }
            if (this.boZ.size() > 0) {
                this.jvP.a(this.boZ.valueAt(0), sVar);
            }
            c(sVar);
            SO();
            return true;
        }
        return false;
    }

    private void SM() {
        if (cD(this.mContext) && SN()) {
            s sVar = new s();
            sVar.cW(true);
            if (this.boZ == null) {
                SK();
            }
            if (this.boZ.size() > 0) {
                if (UBC.getUBCContext().Fo()) {
                    this.jvP.a(sVar);
                } else {
                    this.jvP.a(this.boZ.valueAt(0), sVar);
                }
            }
            c(sVar);
            SO();
        }
    }

    private boolean SN() {
        if (UBC.getUBCContext().Fo()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.boX) > 86400000) {
            this.boY = 0;
            this.boX = currentTimeMillis;
            r.csh().putLong("ubc_reset_real_time_count_time", this.boX);
            r.csh().putInt("ubc_real_time_count", this.boY);
        }
        if (this.boY >= 1000) {
            if (this.boY == 1000) {
                this.boY++;
                UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void SO() {
        this.boY++;
        r.csh().putInt("ubc_real_time_count", this.boY);
    }

    private void SP() {
        if (cD(this.mContext)) {
            this.boW = System.currentTimeMillis();
            r.csh().putLong("ubc_last_upload_non_real", this.boW);
            SR();
            SL();
            this.jvP.SG();
            HashSet hashSet = new HashSet();
            if (this.boZ == null) {
                SK();
            }
            s sVar = new s();
            sVar.cW(false);
            int i = 0;
            for (int i2 = 0; i2 < this.boZ.size(); i2++) {
                int keyAt = this.boZ.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.bpa.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.jvS.SV()) {
                        i |= this.jvP.a(this.boZ.valueAt(i2), sVar);
                        this.bpa.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.boZ.size(); i3++) {
                    int keyAt2 = this.boZ.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (sVar.fr(51200)) {
                            break;
                        }
                        this.jvP.a(this.boZ.valueAt(i3), sVar);
                    }
                }
                c(sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void SQ() {
        if (cD(this.mContext) && Math.abs(System.currentTimeMillis() - this.boV) >= 3600000) {
            this.jvP.SG();
            s sVar = new s();
            if (this.jvP.a(sVar) != 0) {
                s sVar2 = new s();
                sVar2.g(sVar.Tx(), sVar.Ty());
                sVar2.jW(sVar.Tw());
                sVar2.cW(true);
                s sVar3 = new s();
                sVar3.g(sVar.Tx(), sVar.Ty());
                sVar3.jW(sVar.Tw());
                sVar3.cW(false);
                SparseArray<Integer> Tt = sVar.Tt();
                int size = Tt.size();
                for (int i = 0; i < size; i++) {
                    if (this.jvS.jI(String.valueOf(Tt.valueAt(i).intValue()))) {
                        sVar2.P(Tt.keyAt(i), Tt.valueAt(i).intValue());
                    } else {
                        sVar3.P(Tt.keyAt(i), Tt.valueAt(i).intValue());
                    }
                }
                ArrayList Tu = sVar.Tu();
                int size2 = Tu.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) Tu.get(i2);
                    if (this.jvS.jI(str)) {
                        sVar2.jV(str);
                    } else {
                        sVar3.jV(str);
                    }
                }
                JSONArray Tz = sVar.Tz();
                int length = Tz.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = Tz.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.jvS.jI(str2)) {
                                sVar2.aI(optJSONObject);
                            } else {
                                sVar3.aI(optJSONObject);
                            }
                        }
                    }
                }
                if (sVar2.Tz().length() > 0) {
                    c(sVar2);
                }
                if (sVar3.Tz().length() > 0) {
                    c(sVar3);
                }
                this.boV = System.currentTimeMillis();
                r.csh().putLong("ubc_last_upload_all_time", this.boV);
                this.boW = this.boV;
                r.csh().putLong("ubc_last_upload_non_real", this.boW);
            }
        }
    }

    private void c(s sVar) {
        if (!sVar.isEmpty()) {
            JSONObject csj = sVar.csj();
            String md5 = com.baidu.f.c.toMd5(csj.toString().getBytes(), true);
            bk(csj.toString(), md5);
            if (!this.jvP.a(sVar.Tt(), sVar.Tu(), sVar.TA(), md5)) {
                sVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.jvP.jE(md5);
                return;
            }
            d.crV().n(csj, md5);
            sVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n(JSONObject jSONObject, String str) {
        if (this.jvR.a("https://mbd.baidu.com", jSONObject, false)) {
            d.crV().G(str, true);
        } else {
            d.crV().G(str, false);
        }
    }

    private void SR() {
        cU(true);
        cU(false);
    }

    private void cU(boolean z) {
        s sVar = new s();
        sVar.cW(z);
        if (this.jvQ.a(sVar, z)) {
            JSONObject csj = sVar.csj();
            this.jvQ.cT(z);
            d.crV().bH(csj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bH(JSONObject jSONObject) {
        if (!this.jvR.a("http://m.baidu.com", jSONObject, false)) {
            UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a crU() {
        return this.jvP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.jvS.es(nVar.csf());
        this.jvS.BA(nVar.cse() * 86400000);
        this.jvS.BB(nVar.getThreshold());
        r.csh().putString("ubc_version_md5", nVar.csd());
        this.jvP.er(nVar.csf());
        nVar.csf().clear();
        if (this.boZ == null) {
            this.boZ = new SparseArray<>();
        }
        this.boZ.clear();
        if (this.bpa == null) {
            this.bpa = new HashMap<>();
        }
        this.bpa.clear();
        this.jvP.a(this.boZ);
        int i = 0;
        for (int i2 = 0; i2 < this.boZ.size(); i2++) {
            int keyAt = this.boZ.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.bpa.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.jvS.fn(i);
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
            o.jU("save to file suc");
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
    public void jG(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        o.jU("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            o.jU("delete file suc");
        }
        this.jvP.jE(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jH(String str) {
        o.jU("upload file fail");
        this.jvP.jF(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ST() {
        this.jvP.SH();
    }
}
