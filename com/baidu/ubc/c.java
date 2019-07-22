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
    private long bvQ;
    private long bvR;
    private long bvS;
    private int bvT;
    private SparseArray<ArrayList> bvU;
    private HashMap<String, Long> bvV;
    private a jVT;
    private b jVU;
    private e jVW;
    private Context mContext;
    private m jVV = UBC.getUBCContext().aHK();
    private List<j> bvP = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.jVT = new a(context);
        this.jVU = new b(context);
        r cDd = r.cDd();
        this.bvQ = cDd.getLong("ubc_last_upload_all_time", 0L);
        this.bvR = cDd.getLong("ubc_last_upload_non_real", 0L);
        this.bvS = cDd.getLong("ubc_reset_real_time_count_time", 0L);
        this.bvT = cDd.getInt("ubc_real_time_count", 0);
        this.jVW = e.cDc();
        this.jVW.a(this, context);
    }

    private void Xr() {
        if (this.bvU == null) {
            this.bvU = new SparseArray<>();
            this.jVT.a(this.bvU);
            this.bvV = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.bvU.size(); i2++) {
                int keyAt = this.bvU.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.bvV.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.jVW.fV(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        boolean z = false;
        if (TextUtils.equals(jVar.getId(), jVar.XP()) && this.jVW.kN(jVar.getId()) && (jVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.jVT.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.bvR) >= e.cDc().XD()) {
            if (!z) {
                this.bvP.add(jVar);
            }
            Xw();
        } else if ((jVar.getOption() & 1) == 0) {
            if (!z) {
                this.bvP.add(jVar);
            }
            if (this.bvP.size() >= 20) {
                Xs();
            }
        } else if (!z) {
            this.jVT.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.jVU.a(jVar, this.jVW.kN(jVar.getId()));
    }

    private void Xs() {
        if (this.bvP != null && this.bvP.size() != 0) {
            this.jVT.H(this.bvP);
            this.bvP.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.jVT.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.jVT.c(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        Xs();
        this.jVT.a(str, i, j, jSONArray);
        if (this.jVW.kN(str)) {
            Xt();
        }
        if (Math.abs(System.currentTimeMillis() - this.bvR) >= e.cDc().XD()) {
            Xw();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        Xs();
        this.jVT.t(str, i);
        if (Math.abs(System.currentTimeMillis() - this.bvR) >= e.cDc().XD()) {
            Xw();
        }
    }

    private boolean c(j jVar) {
        if (ch(this.mContext) && Xu()) {
            Xs();
            s sVar = new s();
            sVar.ds(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", jVar.getId());
                jSONObject.put("timestamp", Long.toString(jVar.getTime()));
                if (jVar.XS() != null) {
                    jSONObject.put("content", jVar.XS().toString());
                } else {
                    jSONObject.put("content", jVar.getContent());
                }
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(jVar.XR())) {
                    jSONObject.put(ImageViewerConfig.ABTEST, jVar.XR());
                    sVar.lc("1");
                }
                if (!TextUtils.isEmpty(jVar.getCategory())) {
                    jSONObject.put("c", jVar.getCategory());
                }
                if (jVar.XN()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put("idtype", this.jVW.kT(jVar.getId()));
                sVar.aU(jSONObject);
                sVar.g(jVar.getTime(), jVar.getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.bvU == null) {
                Xr();
            }
            if (this.bvU.size() > 0) {
                this.jVT.a(this.bvU.valueAt(0), sVar);
            }
            c(sVar);
            Xv();
            return true;
        }
        return false;
    }

    private void Xt() {
        if (ch(this.mContext) && Xu()) {
            s sVar = new s();
            sVar.ds(true);
            if (this.bvU == null) {
                Xr();
            }
            if (this.bvU.size() > 0) {
                if (UBC.getUBCContext().If()) {
                    this.jVT.a(sVar);
                } else {
                    this.jVT.a(this.bvU.valueAt(0), sVar);
                }
            }
            c(sVar);
            Xv();
        }
    }

    private boolean Xu() {
        if (UBC.getUBCContext().If()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.bvS) > 86400000) {
            this.bvT = 0;
            this.bvS = currentTimeMillis;
            r.cDd().putLong("ubc_reset_real_time_count_time", this.bvS);
            r.cDd().putInt("ubc_real_time_count", this.bvT);
        }
        if (this.bvT >= 1000) {
            if (this.bvT == 1000) {
                this.bvT++;
                UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void Xv() {
        this.bvT++;
        r.cDd().putInt("ubc_real_time_count", this.bvT);
    }

    private void Xw() {
        if (ch(this.mContext)) {
            this.bvR = System.currentTimeMillis();
            r.cDd().putLong("ubc_last_upload_non_real", this.bvR);
            Xy();
            Xs();
            this.jVT.Xm();
            HashSet hashSet = new HashSet();
            if (this.bvU == null) {
                Xr();
            }
            s sVar = new s();
            sVar.ds(false);
            int i = 0;
            for (int i2 = 0; i2 < this.bvU.size(); i2++) {
                int keyAt = this.bvU.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.bvV.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.jVW.XD()) {
                        i |= this.jVT.a(this.bvU.valueAt(i2), sVar);
                        this.bvV.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.bvU.size(); i3++) {
                    int keyAt2 = this.bvU.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (sVar.ge(51200)) {
                            break;
                        }
                        this.jVT.a(this.bvU.valueAt(i3), sVar);
                    }
                }
                c(sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Xx() {
        if (ch(this.mContext) && Math.abs(System.currentTimeMillis() - this.bvQ) >= 3600000) {
            this.jVT.Xm();
            s sVar = new s();
            if (this.jVT.a(sVar) != 0) {
                s sVar2 = new s();
                sVar2.g(sVar.Yu(), sVar.Yv());
                sVar2.lc(sVar.Yt());
                sVar2.ds(true);
                s sVar3 = new s();
                sVar3.g(sVar.Yu(), sVar.Yv());
                sVar3.lc(sVar.Yt());
                sVar3.ds(false);
                SparseArray<Integer> Yq = sVar.Yq();
                int size = Yq.size();
                for (int i = 0; i < size; i++) {
                    if (this.jVW.kN(String.valueOf(Yq.valueAt(i).intValue()))) {
                        sVar2.Q(Yq.keyAt(i), Yq.valueAt(i).intValue());
                    } else {
                        sVar3.Q(Yq.keyAt(i), Yq.valueAt(i).intValue());
                    }
                }
                ArrayList Yr = sVar.Yr();
                int size2 = Yr.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) Yr.get(i2);
                    if (this.jVW.kN(str)) {
                        sVar2.lb(str);
                    } else {
                        sVar3.lb(str);
                    }
                }
                JSONArray Yw = sVar.Yw();
                int length = Yw.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = Yw.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.jVW.kN(str2)) {
                                sVar2.aU(optJSONObject);
                            } else {
                                sVar3.aU(optJSONObject);
                            }
                        }
                    }
                }
                if (sVar2.Yw().length() > 0) {
                    c(sVar2);
                }
                if (sVar3.Yw().length() > 0) {
                    c(sVar3);
                }
                this.bvQ = System.currentTimeMillis();
                r.cDd().putLong("ubc_last_upload_all_time", this.bvQ);
                this.bvR = this.bvQ;
                r.cDd().putLong("ubc_last_upload_non_real", this.bvR);
            }
        }
    }

    private void c(s sVar) {
        if (!sVar.isEmpty()) {
            JSONObject cDf = sVar.cDf();
            String md5 = com.baidu.f.c.toMd5(cDf.toString().getBytes(), true);
            bp(cDf.toString(), md5);
            if (!this.jVT.a(sVar.Yq(), sVar.Yr(), sVar.Yx(), md5)) {
                sVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.jVT.kI(md5);
                return;
            }
            d.cDb().m(cDf, md5);
            sVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(JSONObject jSONObject, String str) {
        if (this.jVV.a("https://mbd.baidu.com", jSONObject, false)) {
            d.cDb().J(str, true);
        } else {
            d.cDb().J(str, false);
        }
    }

    private void Xy() {
        dq(true);
        dq(false);
    }

    private void dq(boolean z) {
        s sVar = new s();
        sVar.ds(z);
        if (this.jVU.a(sVar, z)) {
            JSONObject cDf = sVar.cDf();
            this.jVU.dp(z);
            d.cDb().bT(cDf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bT(JSONObject jSONObject) {
        if (!this.jVV.a("http://m.baidu.com", jSONObject, false)) {
            UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a cDa() {
        return this.jVT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.jVW.J(nVar.Yh());
        this.jVW.fW(nVar.Yg() * 86400000);
        this.jVW.fX(nVar.Yf());
        r.cDd().putString("ubc_version_md5", nVar.getSign());
        this.jVT.I(nVar.Yh());
        nVar.Yh().clear();
        if (this.bvU == null) {
            this.bvU = new SparseArray<>();
        }
        this.bvU.clear();
        if (this.bvV == null) {
            this.bvV = new HashMap<>();
        }
        this.bvV.clear();
        this.jVT.a(this.bvU);
        int i = 0;
        for (int i2 = 0; i2 < this.bvU.size(); i2++) {
            int keyAt = this.bvU.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.bvV.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.jVW.fV(i);
    }

    private boolean ch(Context context) {
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
            o.la("save to file suc");
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
    public void kK(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        o.la("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            o.la("delete file suc");
        }
        this.jVT.kI(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kL(String str) {
        o.la("upload file fail");
        this.jVT.kJ(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void XB() {
        this.jVT.Xo();
    }
}
