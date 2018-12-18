package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c {
    private a iaW;
    private b iaX;
    private long iaZ;
    private long iba;
    private long ibb;
    private int ibc;
    private SparseArray<ArrayList> ibd;
    private HashMap<String, Long> ibe;
    private e ibg;
    private Context mContext;
    private m ibf = o.bRr().Zc();
    private List<j> iaY = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.iaW = new a(context);
        this.iaX = new b(context);
        s bRu = s.bRu();
        this.iaZ = bRu.getLong("ubc_last_upload_all_time", 0L);
        this.iba = bRu.getLong("ubc_last_upload_non_real", 0L);
        this.ibb = bRu.getLong("ubc_reset_real_time_count_time", 0L);
        this.ibc = bRu.getInt("ubc_real_time_count", 0);
        this.ibg = e.bQP();
        this.ibg.a(this, context);
    }

    private void azl() {
        if (this.ibd == null) {
            this.ibd = new SparseArray<>();
            this.iaW.f(this.ibd);
            this.ibe = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.ibd.size(); i2++) {
                int keyAt = this.ibd.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.ibe.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.ibg.xz(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        boolean z = false;
        if (TextUtils.equals(jVar.getId(), jVar.bRb()) && this.ibg.xY(jVar.getId()) && (jVar.bRd() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.iaW.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.iba) >= e.bQP().bQQ()) {
            if (!z) {
                this.iaY.add(jVar);
            }
            bQJ();
        } else if ((jVar.bRd() & 1) == 0) {
            if (!z) {
                this.iaY.add(jVar);
            }
            if (this.iaY.size() >= 20) {
                bQF();
            }
        } else if (!z) {
            this.iaW.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.iaX.a(jVar, this.ibg.xY(jVar.getId()));
    }

    private void bQF() {
        if (this.iaY != null && this.iaY.size() != 0) {
            this.iaW.en(this.iaY);
            this.iaY.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.iaW.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, int i, String str2) {
        this.iaW.n(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        bQF();
        this.iaW.a(str, i, j, jSONArray);
        if (this.ibg.xY(str)) {
            bQG();
        }
        if (Math.abs(System.currentTimeMillis() - this.iba) >= e.bQP().bQQ()) {
            bQJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bb(String str, int i) {
        bQF();
        this.iaW.bb(str, i);
        if (Math.abs(System.currentTimeMillis() - this.iba) >= e.bQP().bQQ()) {
            bQJ();
        }
    }

    private boolean c(j jVar) {
        if (dm(this.mContext) && bQH()) {
            bQF();
            t tVar = new t();
            tVar.oM(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", jVar.getId());
                jSONObject.put(HttpConstants.TIMESTAMP, Long.toString(jVar.getTime()));
                if (jVar.bRf() != null) {
                    jSONObject.put("content", jVar.bRf().toString());
                } else {
                    jSONObject.put("content", jVar.getContent());
                }
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(jVar.bRe())) {
                    jSONObject.put("abtest", jVar.bRe());
                    tVar.yo("1");
                }
                if (!TextUtils.isEmpty(jVar.getCategory())) {
                    jSONObject.put("c", jVar.getCategory());
                }
                if (jVar.bQZ()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put("idtype", this.ibg.ye(jVar.getId()));
                tVar.aA(jSONObject);
                tVar.n(jVar.getTime(), jVar.getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.ibd == null) {
                azl();
            }
            if (this.ibd.size() > 0) {
                this.iaW.a(this.ibd.valueAt(0), tVar);
            }
            c(tVar);
            bQI();
            return true;
        }
        return false;
    }

    private void bQG() {
        if (dm(this.mContext) && bQH()) {
            t tVar = new t();
            tVar.oM(true);
            if (this.ibd == null) {
                azl();
            }
            if (this.ibd.size() > 0) {
                if (o.bRr().Ze()) {
                    this.iaW.a(tVar);
                } else {
                    this.iaW.a(this.ibd.valueAt(0), tVar);
                }
            }
            c(tVar);
            bQI();
        }
    }

    private boolean bQH() {
        if (o.bRr().Ze()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.ibb) > 86400000) {
            this.ibc = 0;
            this.ibb = currentTimeMillis;
            s.bRu().putLong("ubc_reset_real_time_count_time", this.ibb);
            s.bRu().putInt("ubc_real_time_count", this.ibc);
        }
        if (this.ibc >= 1000) {
            if (this.ibc == 1000) {
                this.ibc++;
                o.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void bQI() {
        this.ibc++;
        s.bRu().putInt("ubc_real_time_count", this.ibc);
    }

    private void bQJ() {
        if (dm(this.mContext)) {
            this.iba = System.currentTimeMillis();
            s.bRu().putLong("ubc_last_upload_non_real", this.iba);
            bQL();
            bQF();
            this.iaW.bQB();
            HashSet hashSet = new HashSet();
            if (this.ibd == null) {
                azl();
            }
            t tVar = new t();
            tVar.oM(false);
            int i = 0;
            for (int i2 = 0; i2 < this.ibd.size(); i2++) {
                int keyAt = this.ibd.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.ibe.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.ibg.bQQ()) {
                        i |= this.iaW.a(this.ibd.valueAt(i2), tVar);
                        this.ibe.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.ibd.size(); i3++) {
                    int keyAt2 = this.ibd.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (tVar.xI(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.iaW.a(this.ibd.valueAt(i3), tVar);
                    }
                }
                c(tVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bQK() {
        if (dm(this.mContext) && Math.abs(System.currentTimeMillis() - this.iaZ) >= 3600000) {
            this.iaW.bQB();
            t tVar = new t();
            if (this.iaW.a(tVar) != 0) {
                t tVar2 = new t();
                tVar2.n(tVar.bRA(), tVar.bRB());
                tVar2.yo(tVar.bRz());
                tVar2.oM(true);
                t tVar3 = new t();
                tVar3.n(tVar.bRA(), tVar.bRB());
                tVar3.yo(tVar.bRz());
                tVar3.oM(false);
                SparseArray<Integer> bRw = tVar.bRw();
                int size = bRw.size();
                for (int i = 0; i < size; i++) {
                    if (this.ibg.xY(String.valueOf(bRw.valueAt(i).intValue()))) {
                        tVar2.cc(bRw.keyAt(i), bRw.valueAt(i).intValue());
                    } else {
                        tVar3.cc(bRw.keyAt(i), bRw.valueAt(i).intValue());
                    }
                }
                ArrayList bRx = tVar.bRx();
                int size2 = bRx.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bRx.get(i2);
                    if (this.ibg.xY(str)) {
                        tVar2.yn(str);
                    } else {
                        tVar3.yn(str);
                    }
                }
                JSONArray bRC = tVar.bRC();
                int length = bRC.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = bRC.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.ibg.xY(str2)) {
                                tVar2.aA(optJSONObject);
                            } else {
                                tVar3.aA(optJSONObject);
                            }
                        }
                    }
                }
                if (tVar2.bRC().length() > 0) {
                    c(tVar2);
                }
                if (tVar3.bRC().length() > 0) {
                    c(tVar3);
                }
                this.iaZ = System.currentTimeMillis();
                s.bRu().putLong("ubc_last_upload_all_time", this.iaZ);
                this.iba = this.iaZ;
                s.bRu().putLong("ubc_last_upload_non_real", this.iba);
            }
        }
    }

    private void c(t tVar) {
        if (!tVar.isEmpty()) {
            JSONObject bRy = tVar.bRy();
            String md5 = com.baidu.g.c.toMd5(bRy.toString().getBytes(), true);
            cY(bRy.toString(), md5);
            if (!this.iaW.a(tVar.bRw(), tVar.bRx(), tVar.bRD(), md5)) {
                tVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.iaW.xT(md5);
                return;
            }
            d.bQO().k(bRy, md5);
            tVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(JSONObject jSONObject, String str) {
        if (this.ibf.a("https://mbd.baidu.com", jSONObject, false)) {
            d.bQO().ag(str, true);
        } else {
            d.bQO().ag(str, false);
        }
    }

    private void bQL() {
        oJ(true);
        oJ(false);
    }

    private void oJ(boolean z) {
        t tVar = new t();
        tVar.oM(z);
        if (this.iaX.a(tVar, z)) {
            JSONObject bRy = tVar.bRy();
            this.iaX.oI(z);
            d.bQO().ay(bRy);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ay(JSONObject jSONObject) {
        if (!this.ibf.a("http://m.baidu.com", jSONObject, false)) {
            o.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a bQM() {
        return this.iaW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.ibg.ep(nVar.bRm());
        this.ibg.xA(nVar.bRl() * AiAppDateTimeUtil.TIME_DAY_MILLISECOND);
        this.ibg.xB(nVar.getThreshold());
        s.bRu().putString("ubc_version_md5", nVar.bRk());
        this.iaW.eo(nVar.bRm());
        nVar.bRm().clear();
        if (this.ibd == null) {
            this.ibd = new SparseArray<>();
        }
        this.ibd.clear();
        if (this.ibe == null) {
            this.ibe = new HashMap<>();
        }
        this.ibe.clear();
        this.iaW.f(this.ibd);
        int i = 0;
        for (int i2 = 0; i2 < this.ibd.size(); i2++) {
            int keyAt = this.ibd.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.ibe.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.ibg.xz(i);
    }

    private boolean dm(Context context) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [943=4] */
    private void cY(String str, String str2) {
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
            p.ym("save to file suc");
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
    public void xV(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        p.ym("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            p.ym("delete file suc");
        }
        this.iaW.xT(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xW(String str) {
        p.ym("upload file fail");
        this.iaW.xU(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bQN() {
        this.iaW.bQC();
    }
}
