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
    private m ibf = o.bRs().Zc();
    private List<j> iaY = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.iaW = new a(context);
        this.iaX = new b(context);
        s bRv = s.bRv();
        this.iaZ = bRv.getLong("ubc_last_upload_all_time", 0L);
        this.iba = bRv.getLong("ubc_last_upload_non_real", 0L);
        this.ibb = bRv.getLong("ubc_reset_real_time_count_time", 0L);
        this.ibc = bRv.getInt("ubc_real_time_count", 0);
        this.ibg = e.bQQ();
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
        if (TextUtils.equals(jVar.getId(), jVar.bRc()) && this.ibg.xY(jVar.getId()) && (jVar.bRe() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.iaW.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.iba) >= e.bQQ().bQR()) {
            if (!z) {
                this.iaY.add(jVar);
            }
            bQK();
        } else if ((jVar.bRe() & 1) == 0) {
            if (!z) {
                this.iaY.add(jVar);
            }
            if (this.iaY.size() >= 20) {
                bQG();
            }
        } else if (!z) {
            this.iaW.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.iaX.a(jVar, this.ibg.xY(jVar.getId()));
    }

    private void bQG() {
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
        bQG();
        this.iaW.a(str, i, j, jSONArray);
        if (this.ibg.xY(str)) {
            bQH();
        }
        if (Math.abs(System.currentTimeMillis() - this.iba) >= e.bQQ().bQR()) {
            bQK();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bb(String str, int i) {
        bQG();
        this.iaW.bb(str, i);
        if (Math.abs(System.currentTimeMillis() - this.iba) >= e.bQQ().bQR()) {
            bQK();
        }
    }

    private boolean c(j jVar) {
        if (dm(this.mContext) && bQI()) {
            bQG();
            t tVar = new t();
            tVar.oM(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", jVar.getId());
                jSONObject.put(HttpConstants.TIMESTAMP, Long.toString(jVar.getTime()));
                if (jVar.bRg() != null) {
                    jSONObject.put("content", jVar.bRg().toString());
                } else {
                    jSONObject.put("content", jVar.getContent());
                }
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(jVar.bRf())) {
                    jSONObject.put("abtest", jVar.bRf());
                    tVar.yo("1");
                }
                if (!TextUtils.isEmpty(jVar.getCategory())) {
                    jSONObject.put("c", jVar.getCategory());
                }
                if (jVar.bRa()) {
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
            bQJ();
            return true;
        }
        return false;
    }

    private void bQH() {
        if (dm(this.mContext) && bQI()) {
            t tVar = new t();
            tVar.oM(true);
            if (this.ibd == null) {
                azl();
            }
            if (this.ibd.size() > 0) {
                if (o.bRs().Ze()) {
                    this.iaW.a(tVar);
                } else {
                    this.iaW.a(this.ibd.valueAt(0), tVar);
                }
            }
            c(tVar);
            bQJ();
        }
    }

    private boolean bQI() {
        if (o.bRs().Ze()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.ibb) > 86400000) {
            this.ibc = 0;
            this.ibb = currentTimeMillis;
            s.bRv().putLong("ubc_reset_real_time_count_time", this.ibb);
            s.bRv().putInt("ubc_real_time_count", this.ibc);
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

    private void bQJ() {
        this.ibc++;
        s.bRv().putInt("ubc_real_time_count", this.ibc);
    }

    private void bQK() {
        if (dm(this.mContext)) {
            this.iba = System.currentTimeMillis();
            s.bRv().putLong("ubc_last_upload_non_real", this.iba);
            bQM();
            bQG();
            this.iaW.bQC();
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
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.ibg.bQR()) {
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
    public void bQL() {
        if (dm(this.mContext) && Math.abs(System.currentTimeMillis() - this.iaZ) >= 3600000) {
            this.iaW.bQC();
            t tVar = new t();
            if (this.iaW.a(tVar) != 0) {
                t tVar2 = new t();
                tVar2.n(tVar.bRB(), tVar.bRC());
                tVar2.yo(tVar.bRA());
                tVar2.oM(true);
                t tVar3 = new t();
                tVar3.n(tVar.bRB(), tVar.bRC());
                tVar3.yo(tVar.bRA());
                tVar3.oM(false);
                SparseArray<Integer> bRx = tVar.bRx();
                int size = bRx.size();
                for (int i = 0; i < size; i++) {
                    if (this.ibg.xY(String.valueOf(bRx.valueAt(i).intValue()))) {
                        tVar2.cc(bRx.keyAt(i), bRx.valueAt(i).intValue());
                    } else {
                        tVar3.cc(bRx.keyAt(i), bRx.valueAt(i).intValue());
                    }
                }
                ArrayList bRy = tVar.bRy();
                int size2 = bRy.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bRy.get(i2);
                    if (this.ibg.xY(str)) {
                        tVar2.yn(str);
                    } else {
                        tVar3.yn(str);
                    }
                }
                JSONArray bRD = tVar.bRD();
                int length = bRD.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = bRD.optJSONObject(i3);
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
                if (tVar2.bRD().length() > 0) {
                    c(tVar2);
                }
                if (tVar3.bRD().length() > 0) {
                    c(tVar3);
                }
                this.iaZ = System.currentTimeMillis();
                s.bRv().putLong("ubc_last_upload_all_time", this.iaZ);
                this.iba = this.iaZ;
                s.bRv().putLong("ubc_last_upload_non_real", this.iba);
            }
        }
    }

    private void c(t tVar) {
        if (!tVar.isEmpty()) {
            JSONObject bRz = tVar.bRz();
            String md5 = com.baidu.g.c.toMd5(bRz.toString().getBytes(), true);
            cY(bRz.toString(), md5);
            if (!this.iaW.a(tVar.bRx(), tVar.bRy(), tVar.bRE(), md5)) {
                tVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.iaW.xT(md5);
                return;
            }
            d.bQP().k(bRz, md5);
            tVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(JSONObject jSONObject, String str) {
        if (this.ibf.a("https://mbd.baidu.com", jSONObject, false)) {
            d.bQP().ag(str, true);
        } else {
            d.bQP().ag(str, false);
        }
    }

    private void bQM() {
        oJ(true);
        oJ(false);
    }

    private void oJ(boolean z) {
        t tVar = new t();
        tVar.oM(z);
        if (this.iaX.a(tVar, z)) {
            JSONObject bRz = tVar.bRz();
            this.iaX.oI(z);
            d.bQP().ay(bRz);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ay(JSONObject jSONObject) {
        if (!this.ibf.a("http://m.baidu.com", jSONObject, false)) {
            o.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a bQN() {
        return this.iaW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.ibg.ep(nVar.bRn());
        this.ibg.xA(nVar.bRm() * AiAppDateTimeUtil.TIME_DAY_MILLISECOND);
        this.ibg.xB(nVar.getThreshold());
        s.bRv().putString("ubc_version_md5", nVar.bRl());
        this.iaW.eo(nVar.bRn());
        nVar.bRn().clear();
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
    public void bQO() {
        this.iaW.bQD();
    }
}
