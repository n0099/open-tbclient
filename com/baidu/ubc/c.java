package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.live.adp.lib.cache.BdKVCache;
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
    private long bOV;
    private long bOW;
    private long bOX;
    private int bOY;
    private SparseArray<ArrayList> bOZ;
    private HashMap<String, Long> bPa;
    private a jXv;
    private b jXw;
    private e jXy;
    private Context mContext;
    private m jXx = UBC.getUBCContext().aIA();
    private List<j> bOU = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.jXv = new a(context);
        this.jXw = new b(context);
        r cAW = r.cAW();
        this.bOV = cAW.getLong("ubc_last_upload_all_time", 0L);
        this.bOW = cAW.getLong("ubc_last_upload_non_real", 0L);
        this.bOX = cAW.getLong("ubc_reset_real_time_count_time", 0L);
        this.bOY = cAW.getInt("ubc_real_time_count", 0);
        this.jXy = e.cAV();
        this.jXy.a(this, context);
    }

    private void ack() {
        if (this.bOZ == null) {
            this.bOZ = new SparseArray<>();
            this.jXv.a(this.bOZ);
            this.bPa = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.bOZ.size(); i2++) {
                int keyAt = this.bOZ.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.bPa.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.jXy.gR(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        boolean z = false;
        if (TextUtils.equals(jVar.getId(), jVar.acI()) && this.jXy.lr(jVar.getId()) && (jVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.jXv.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.bOW) >= e.cAV().acw()) {
            if (!z) {
                this.bOU.add(jVar);
            }
            acp();
        } else if ((jVar.getOption() & 1) == 0) {
            if (!z) {
                this.bOU.add(jVar);
            }
            if (this.bOU.size() >= 20) {
                acl();
            }
        } else if (!z) {
            this.jXv.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.jXw.a(jVar, this.jXy.lr(jVar.getId()));
    }

    private void acl() {
        if (this.bOU != null && this.bOU.size() != 0) {
            this.jXv.ag(this.bOU);
            this.bOU.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.jXv.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, int i, String str2) {
        this.jXv.e(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        acl();
        this.jXv.a(str, i, j, jSONArray);
        if (this.jXy.lr(str)) {
            acm();
        }
        if (Math.abs(System.currentTimeMillis() - this.bOW) >= e.cAV().acw()) {
            acp();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        acl();
        this.jXv.t(str, i);
        if (Math.abs(System.currentTimeMillis() - this.bOW) >= e.cAV().acw()) {
            acp();
        }
    }

    private boolean c(j jVar) {
        if (ch(this.mContext) && acn()) {
            acl();
            s sVar = new s();
            sVar.dJ(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", jVar.getId());
                jSONObject.put("timestamp", Long.toString(jVar.getTime()));
                if (jVar.acL() != null) {
                    jSONObject.put("content", jVar.acL().toString());
                } else {
                    jSONObject.put("content", jVar.getContent());
                }
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(jVar.acK())) {
                    jSONObject.put("abtest", jVar.acK());
                    sVar.lG("1");
                }
                if (!TextUtils.isEmpty(jVar.getCategory())) {
                    jSONObject.put("c", jVar.getCategory());
                }
                if (jVar.acG()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put("idtype", this.jXy.lx(jVar.getId()));
                sVar.bs(jSONObject);
                sVar.m(jVar.getTime(), jVar.getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.bOZ == null) {
                ack();
            }
            if (this.bOZ.size() > 0) {
                this.jXv.a(this.bOZ.valueAt(0), sVar);
            }
            c(sVar);
            aco();
            return true;
        }
        return false;
    }

    private void acm() {
        if (ch(this.mContext) && acn()) {
            s sVar = new s();
            sVar.dJ(true);
            if (this.bOZ == null) {
                ack();
            }
            if (this.bOZ.size() > 0) {
                if (UBC.getUBCContext().Nd()) {
                    this.jXv.a(sVar);
                } else {
                    this.jXv.a(this.bOZ.valueAt(0), sVar);
                }
            }
            c(sVar);
            aco();
        }
    }

    private boolean acn() {
        if (UBC.getUBCContext().Nd()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.bOX) > 86400000) {
            this.bOY = 0;
            this.bOX = currentTimeMillis;
            r.cAW().putLong("ubc_reset_real_time_count_time", this.bOX);
            r.cAW().putInt("ubc_real_time_count", this.bOY);
        }
        if (this.bOY >= 1000) {
            if (this.bOY == 1000) {
                this.bOY++;
                UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void aco() {
        this.bOY++;
        r.cAW().putInt("ubc_real_time_count", this.bOY);
    }

    private void acp() {
        if (ch(this.mContext)) {
            this.bOW = System.currentTimeMillis();
            r.cAW().putLong("ubc_last_upload_non_real", this.bOW);
            acr();
            acl();
            this.jXv.acf();
            HashSet hashSet = new HashSet();
            if (this.bOZ == null) {
                ack();
            }
            s sVar = new s();
            sVar.dJ(false);
            int i = 0;
            for (int i2 = 0; i2 < this.bOZ.size(); i2++) {
                int keyAt = this.bOZ.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.bPa.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.jXy.acw()) {
                        i |= this.jXv.a(this.bOZ.valueAt(i2), sVar);
                        this.bPa.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.bOZ.size(); i3++) {
                    int keyAt2 = this.bOZ.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (sVar.ha(51200)) {
                            break;
                        }
                        this.jXv.a(this.bOZ.valueAt(i3), sVar);
                    }
                }
                c(sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void acq() {
        if (ch(this.mContext) && Math.abs(System.currentTimeMillis() - this.bOV) >= BdKVCache.MILLS_1Hour) {
            this.jXv.acf();
            s sVar = new s();
            if (this.jXv.a(sVar) != 0) {
                s sVar2 = new s();
                sVar2.m(sVar.ado(), sVar.getMaxTime());
                sVar2.lG(sVar.adn());
                sVar2.dJ(true);
                s sVar3 = new s();
                sVar3.m(sVar.ado(), sVar.getMaxTime());
                sVar3.lG(sVar.adn());
                sVar3.dJ(false);
                SparseArray<Integer> adk = sVar.adk();
                int size = adk.size();
                for (int i = 0; i < size; i++) {
                    if (this.jXy.lr(String.valueOf(adk.valueAt(i).intValue()))) {
                        sVar2.W(adk.keyAt(i), adk.valueAt(i).intValue());
                    } else {
                        sVar3.W(adk.keyAt(i), adk.valueAt(i).intValue());
                    }
                }
                ArrayList adl = sVar.adl();
                int size2 = adl.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) adl.get(i2);
                    if (this.jXy.lr(str)) {
                        sVar2.lF(str);
                    } else {
                        sVar3.lF(str);
                    }
                }
                JSONArray adp = sVar.adp();
                int length = adp.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = adp.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.jXy.lr(str2)) {
                                sVar2.bs(optJSONObject);
                            } else {
                                sVar3.bs(optJSONObject);
                            }
                        }
                    }
                }
                if (sVar2.adp().length() > 0) {
                    c(sVar2);
                }
                if (sVar3.adp().length() > 0) {
                    c(sVar3);
                }
                this.bOV = System.currentTimeMillis();
                r.cAW().putLong("ubc_last_upload_all_time", this.bOV);
                this.bOW = this.bOV;
                r.cAW().putLong("ubc_last_upload_non_real", this.bOW);
            }
        }
    }

    private void c(s sVar) {
        if (!sVar.isEmpty()) {
            JSONObject cAY = sVar.cAY();
            String md5 = com.baidu.f.c.toMd5(cAY.toString().getBytes(), true);
            bw(cAY.toString(), md5);
            if (!this.jXv.a(sVar.adk(), sVar.adl(), sVar.adq(), md5)) {
                sVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.jXv.lm(md5);
                return;
            }
            d.cAU().m(cAY, md5);
            sVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(JSONObject jSONObject, String str) {
        if (this.jXx.a("https://mbd.baidu.com", jSONObject, false)) {
            d.cAU().M(str, true);
        } else {
            d.cAU().M(str, false);
        }
    }

    private void acr() {
        dH(true);
        dH(false);
    }

    private void dH(boolean z) {
        s sVar = new s();
        sVar.dJ(z);
        if (this.jXw.a(sVar, z)) {
            JSONObject cAY = sVar.cAY();
            this.jXw.dG(z);
            d.cAU().cs(cAY);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cs(JSONObject jSONObject) {
        if (!this.jXx.a("http://m.baidu.com", jSONObject, false)) {
            UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a cAT() {
        return this.jXv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.jXy.ai(nVar.adb());
        this.jXy.gS(nVar.ada() * 86400000);
        this.jXy.gT(nVar.acZ());
        r.cAW().putString("ubc_version_md5", nVar.getSign());
        this.jXv.ah(nVar.adb());
        nVar.adb().clear();
        if (this.bOZ == null) {
            this.bOZ = new SparseArray<>();
        }
        this.bOZ.clear();
        if (this.bPa == null) {
            this.bPa = new HashMap<>();
        }
        this.bPa.clear();
        this.jXv.a(this.bOZ);
        int i = 0;
        for (int i2 = 0; i2 < this.bOZ.size(); i2++) {
            int keyAt = this.bOZ.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.bPa.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.jXy.gR(i);
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
    private void bw(String str, String str2) {
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
            o.lE("save to file suc");
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
    public void lo(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        o.lE("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            o.lE("delete file suc");
        }
        this.jXv.lm(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lp(String str) {
        o.lE("upload file fail");
        this.jXv.ln(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void acu() {
        this.jXv.ach();
    }
}
