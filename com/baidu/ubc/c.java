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
    private long bOe;
    private long bOf;
    private long bOg;
    private int bOh;
    private SparseArray<ArrayList> bOi;
    private HashMap<String, Long> bOj;
    private a jWE;
    private b jWF;
    private e jWH;
    private Context mContext;
    private m jWG = UBC.getUBCContext().aIy();
    private List<j> bOd = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.jWE = new a(context);
        this.jWF = new b(context);
        r cAU = r.cAU();
        this.bOe = cAU.getLong("ubc_last_upload_all_time", 0L);
        this.bOf = cAU.getLong("ubc_last_upload_non_real", 0L);
        this.bOg = cAU.getLong("ubc_reset_real_time_count_time", 0L);
        this.bOh = cAU.getInt("ubc_real_time_count", 0);
        this.jWH = e.cAT();
        this.jWH.a(this, context);
    }

    private void aci() {
        if (this.bOi == null) {
            this.bOi = new SparseArray<>();
            this.jWE.a(this.bOi);
            this.bOj = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.bOi.size(); i2++) {
                int keyAt = this.bOi.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.bOj.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.jWH.gQ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        boolean z = false;
        if (TextUtils.equals(jVar.getId(), jVar.acG()) && this.jWH.lr(jVar.getId()) && (jVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.jWE.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.bOf) >= e.cAT().acu()) {
            if (!z) {
                this.bOd.add(jVar);
            }
            acn();
        } else if ((jVar.getOption() & 1) == 0) {
            if (!z) {
                this.bOd.add(jVar);
            }
            if (this.bOd.size() >= 20) {
                acj();
            }
        } else if (!z) {
            this.jWE.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.jWF.a(jVar, this.jWH.lr(jVar.getId()));
    }

    private void acj() {
        if (this.bOd != null && this.bOd.size() != 0) {
            this.jWE.ag(this.bOd);
            this.bOd.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.jWE.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, int i, String str2) {
        this.jWE.e(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        acj();
        this.jWE.a(str, i, j, jSONArray);
        if (this.jWH.lr(str)) {
            ack();
        }
        if (Math.abs(System.currentTimeMillis() - this.bOf) >= e.cAT().acu()) {
            acn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        acj();
        this.jWE.t(str, i);
        if (Math.abs(System.currentTimeMillis() - this.bOf) >= e.cAT().acu()) {
            acn();
        }
    }

    private boolean c(j jVar) {
        if (ch(this.mContext) && acl()) {
            acj();
            s sVar = new s();
            sVar.dJ(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", jVar.getId());
                jSONObject.put("timestamp", Long.toString(jVar.getTime()));
                if (jVar.acJ() != null) {
                    jSONObject.put("content", jVar.acJ().toString());
                } else {
                    jSONObject.put("content", jVar.getContent());
                }
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(jVar.acI())) {
                    jSONObject.put("abtest", jVar.acI());
                    sVar.lG("1");
                }
                if (!TextUtils.isEmpty(jVar.getCategory())) {
                    jSONObject.put("c", jVar.getCategory());
                }
                if (jVar.acE()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put("idtype", this.jWH.lx(jVar.getId()));
                sVar.bt(jSONObject);
                sVar.m(jVar.getTime(), jVar.getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.bOi == null) {
                aci();
            }
            if (this.bOi.size() > 0) {
                this.jWE.a(this.bOi.valueAt(0), sVar);
            }
            c(sVar);
            acm();
            return true;
        }
        return false;
    }

    private void ack() {
        if (ch(this.mContext) && acl()) {
            s sVar = new s();
            sVar.dJ(true);
            if (this.bOi == null) {
                aci();
            }
            if (this.bOi.size() > 0) {
                if (UBC.getUBCContext().Ne()) {
                    this.jWE.a(sVar);
                } else {
                    this.jWE.a(this.bOi.valueAt(0), sVar);
                }
            }
            c(sVar);
            acm();
        }
    }

    private boolean acl() {
        if (UBC.getUBCContext().Ne()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.bOg) > 86400000) {
            this.bOh = 0;
            this.bOg = currentTimeMillis;
            r.cAU().putLong("ubc_reset_real_time_count_time", this.bOg);
            r.cAU().putInt("ubc_real_time_count", this.bOh);
        }
        if (this.bOh >= 1000) {
            if (this.bOh == 1000) {
                this.bOh++;
                UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void acm() {
        this.bOh++;
        r.cAU().putInt("ubc_real_time_count", this.bOh);
    }

    private void acn() {
        if (ch(this.mContext)) {
            this.bOf = System.currentTimeMillis();
            r.cAU().putLong("ubc_last_upload_non_real", this.bOf);
            acp();
            acj();
            this.jWE.acd();
            HashSet hashSet = new HashSet();
            if (this.bOi == null) {
                aci();
            }
            s sVar = new s();
            sVar.dJ(false);
            int i = 0;
            for (int i2 = 0; i2 < this.bOi.size(); i2++) {
                int keyAt = this.bOi.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.bOj.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.jWH.acu()) {
                        i |= this.jWE.a(this.bOi.valueAt(i2), sVar);
                        this.bOj.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.bOi.size(); i3++) {
                    int keyAt2 = this.bOi.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (sVar.gZ(51200)) {
                            break;
                        }
                        this.jWE.a(this.bOi.valueAt(i3), sVar);
                    }
                }
                c(sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aco() {
        if (ch(this.mContext) && Math.abs(System.currentTimeMillis() - this.bOe) >= BdKVCache.MILLS_1Hour) {
            this.jWE.acd();
            s sVar = new s();
            if (this.jWE.a(sVar) != 0) {
                s sVar2 = new s();
                sVar2.m(sVar.adm(), sVar.getMaxTime());
                sVar2.lG(sVar.adl());
                sVar2.dJ(true);
                s sVar3 = new s();
                sVar3.m(sVar.adm(), sVar.getMaxTime());
                sVar3.lG(sVar.adl());
                sVar3.dJ(false);
                SparseArray<Integer> adi = sVar.adi();
                int size = adi.size();
                for (int i = 0; i < size; i++) {
                    if (this.jWH.lr(String.valueOf(adi.valueAt(i).intValue()))) {
                        sVar2.U(adi.keyAt(i), adi.valueAt(i).intValue());
                    } else {
                        sVar3.U(adi.keyAt(i), adi.valueAt(i).intValue());
                    }
                }
                ArrayList adj = sVar.adj();
                int size2 = adj.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) adj.get(i2);
                    if (this.jWH.lr(str)) {
                        sVar2.lF(str);
                    } else {
                        sVar3.lF(str);
                    }
                }
                JSONArray adn = sVar.adn();
                int length = adn.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = adn.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.jWH.lr(str2)) {
                                sVar2.bt(optJSONObject);
                            } else {
                                sVar3.bt(optJSONObject);
                            }
                        }
                    }
                }
                if (sVar2.adn().length() > 0) {
                    c(sVar2);
                }
                if (sVar3.adn().length() > 0) {
                    c(sVar3);
                }
                this.bOe = System.currentTimeMillis();
                r.cAU().putLong("ubc_last_upload_all_time", this.bOe);
                this.bOf = this.bOe;
                r.cAU().putLong("ubc_last_upload_non_real", this.bOf);
            }
        }
    }

    private void c(s sVar) {
        if (!sVar.isEmpty()) {
            JSONObject cAW = sVar.cAW();
            String md5 = com.baidu.f.c.toMd5(cAW.toString().getBytes(), true);
            bw(cAW.toString(), md5);
            if (!this.jWE.a(sVar.adi(), sVar.adj(), sVar.ado(), md5)) {
                sVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.jWE.lm(md5);
                return;
            }
            d.cAS().m(cAW, md5);
            sVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(JSONObject jSONObject, String str) {
        if (this.jWG.a("https://mbd.baidu.com", jSONObject, false)) {
            d.cAS().M(str, true);
        } else {
            d.cAS().M(str, false);
        }
    }

    private void acp() {
        dH(true);
        dH(false);
    }

    private void dH(boolean z) {
        s sVar = new s();
        sVar.dJ(z);
        if (this.jWF.a(sVar, z)) {
            JSONObject cAW = sVar.cAW();
            this.jWF.dG(z);
            d.cAS().ct(cAW);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ct(JSONObject jSONObject) {
        if (!this.jWG.a("http://m.baidu.com", jSONObject, false)) {
            UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a cAR() {
        return this.jWE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.jWH.ai(nVar.acZ());
        this.jWH.gR(nVar.acY() * 86400000);
        this.jWH.gS(nVar.acX());
        r.cAU().putString("ubc_version_md5", nVar.getSign());
        this.jWE.ah(nVar.acZ());
        nVar.acZ().clear();
        if (this.bOi == null) {
            this.bOi = new SparseArray<>();
        }
        this.bOi.clear();
        if (this.bOj == null) {
            this.bOj = new HashMap<>();
        }
        this.bOj.clear();
        this.jWE.a(this.bOi);
        int i = 0;
        for (int i2 = 0; i2 < this.bOi.size(); i2++) {
            int keyAt = this.bOi.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.bOj.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.jWH.gQ(i);
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
        this.jWE.lm(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lp(String str) {
        o.lE("upload file fail");
        this.jWE.ln(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void acs() {
        this.jWE.acf();
    }
}
