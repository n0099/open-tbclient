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
    private a hSc;
    private b hSd;
    private long hSf;
    private long hSg;
    private long hSh;
    private int hSi;
    private SparseArray<ArrayList> hSj;
    private HashMap<String, Long> hSk;
    private e hSm;
    private Context mContext;
    private m hSl = o.bPN().XO();
    private List<j> hSe = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.hSc = new a(context);
        this.hSd = new b(context);
        s bPQ = s.bPQ();
        this.hSf = bPQ.getLong("ubc_last_upload_all_time", 0L);
        this.hSg = bPQ.getLong("ubc_last_upload_non_real", 0L);
        this.hSh = bPQ.getLong("ubc_reset_real_time_count_time", 0L);
        this.hSi = bPQ.getInt("ubc_real_time_count", 0);
        this.hSm = e.bPl();
        this.hSm.a(this, context);
    }

    private void aye() {
        if (this.hSj == null) {
            this.hSj = new SparseArray<>();
            this.hSc.f(this.hSj);
            this.hSk = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.hSj.size(); i2++) {
                int keyAt = this.hSj.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.hSk.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.hSm.wJ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        boolean z = false;
        if (TextUtils.equals(jVar.getId(), jVar.bPx()) && this.hSm.xq(jVar.getId()) && (jVar.bPz() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.hSc.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.hSg) >= e.bPl().bPm()) {
            if (!z) {
                this.hSe.add(jVar);
            }
            bPf();
        } else if ((jVar.bPz() & 1) == 0) {
            if (!z) {
                this.hSe.add(jVar);
            }
            if (this.hSe.size() >= 20) {
                bPb();
            }
        } else if (!z) {
            this.hSc.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.hSd.a(jVar, this.hSm.xq(jVar.getId()));
    }

    private void bPb() {
        if (this.hSe != null && this.hSe.size() != 0) {
            this.hSc.el(this.hSe);
            this.hSe.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.hSc.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, int i, String str2) {
        this.hSc.n(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        bPb();
        this.hSc.a(str, i, j, jSONArray);
        if (this.hSm.xq(str)) {
            bPc();
        }
        if (Math.abs(System.currentTimeMillis() - this.hSg) >= e.bPl().bPm()) {
            bPf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ba(String str, int i) {
        bPb();
        this.hSc.ba(str, i);
        if (Math.abs(System.currentTimeMillis() - this.hSg) >= e.bPl().bPm()) {
            bPf();
        }
    }

    private boolean c(j jVar) {
        if (dn(this.mContext) && bPd()) {
            bPb();
            t tVar = new t();
            tVar.ow(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", jVar.getId());
                jSONObject.put(HttpConstants.TIMESTAMP, Long.toString(jVar.getTime()));
                if (jVar.bPB() != null) {
                    jSONObject.put("content", jVar.bPB().toString());
                } else {
                    jSONObject.put("content", jVar.getContent());
                }
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(jVar.bPA())) {
                    jSONObject.put("abtest", jVar.bPA());
                    tVar.xG("1");
                }
                if (!TextUtils.isEmpty(jVar.getCategory())) {
                    jSONObject.put("c", jVar.getCategory());
                }
                if (jVar.bPv()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put("idtype", this.hSm.xw(jVar.getId()));
                tVar.ay(jSONObject);
                tVar.o(jVar.getTime(), jVar.getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.hSj == null) {
                aye();
            }
            if (this.hSj.size() > 0) {
                this.hSc.a(this.hSj.valueAt(0), tVar);
            }
            c(tVar);
            bPe();
            return true;
        }
        return false;
    }

    private void bPc() {
        if (dn(this.mContext) && bPd()) {
            t tVar = new t();
            tVar.ow(true);
            if (this.hSj == null) {
                aye();
            }
            if (this.hSj.size() > 0) {
                if (o.bPN().XQ()) {
                    this.hSc.a(tVar);
                } else {
                    this.hSc.a(this.hSj.valueAt(0), tVar);
                }
            }
            c(tVar);
            bPe();
        }
    }

    private boolean bPd() {
        if (o.bPN().XQ()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.hSh) > 86400000) {
            this.hSi = 0;
            this.hSh = currentTimeMillis;
            s.bPQ().putLong("ubc_reset_real_time_count_time", this.hSh);
            s.bPQ().putInt("ubc_real_time_count", this.hSi);
        }
        if (this.hSi >= 1000) {
            if (this.hSi == 1000) {
                this.hSi++;
                o.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void bPe() {
        this.hSi++;
        s.bPQ().putInt("ubc_real_time_count", this.hSi);
    }

    private void bPf() {
        if (dn(this.mContext)) {
            this.hSg = System.currentTimeMillis();
            s.bPQ().putLong("ubc_last_upload_non_real", this.hSg);
            bPh();
            bPb();
            this.hSc.bOX();
            HashSet hashSet = new HashSet();
            if (this.hSj == null) {
                aye();
            }
            t tVar = new t();
            tVar.ow(false);
            int i = 0;
            for (int i2 = 0; i2 < this.hSj.size(); i2++) {
                int keyAt = this.hSj.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.hSk.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.hSm.bPm()) {
                        i |= this.hSc.a(this.hSj.valueAt(i2), tVar);
                        this.hSk.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.hSj.size(); i3++) {
                    int keyAt2 = this.hSj.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (tVar.wS(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.hSc.a(this.hSj.valueAt(i3), tVar);
                    }
                }
                c(tVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bPg() {
        if (dn(this.mContext) && Math.abs(System.currentTimeMillis() - this.hSf) >= 3600000) {
            this.hSc.bOX();
            t tVar = new t();
            if (this.hSc.a(tVar) != 0) {
                t tVar2 = new t();
                tVar2.o(tVar.bPW(), tVar.bPX());
                tVar2.xG(tVar.bPV());
                tVar2.ow(true);
                t tVar3 = new t();
                tVar3.o(tVar.bPW(), tVar.bPX());
                tVar3.xG(tVar.bPV());
                tVar3.ow(false);
                SparseArray<Integer> bPS = tVar.bPS();
                int size = bPS.size();
                for (int i = 0; i < size; i++) {
                    if (this.hSm.xq(String.valueOf(bPS.valueAt(i).intValue()))) {
                        tVar2.ca(bPS.keyAt(i), bPS.valueAt(i).intValue());
                    } else {
                        tVar3.ca(bPS.keyAt(i), bPS.valueAt(i).intValue());
                    }
                }
                ArrayList bPT = tVar.bPT();
                int size2 = bPT.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bPT.get(i2);
                    if (this.hSm.xq(str)) {
                        tVar2.xF(str);
                    } else {
                        tVar3.xF(str);
                    }
                }
                JSONArray bPY = tVar.bPY();
                int length = bPY.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = bPY.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.hSm.xq(str2)) {
                                tVar2.ay(optJSONObject);
                            } else {
                                tVar3.ay(optJSONObject);
                            }
                        }
                    }
                }
                if (tVar2.bPY().length() > 0) {
                    c(tVar2);
                }
                if (tVar3.bPY().length() > 0) {
                    c(tVar3);
                }
                this.hSf = System.currentTimeMillis();
                s.bPQ().putLong("ubc_last_upload_all_time", this.hSf);
                this.hSg = this.hSf;
                s.bPQ().putLong("ubc_last_upload_non_real", this.hSg);
            }
        }
    }

    private void c(t tVar) {
        if (!tVar.isEmpty()) {
            JSONObject bPU = tVar.bPU();
            String md5 = com.baidu.g.c.toMd5(bPU.toString().getBytes(), true);
            cT(bPU.toString(), md5);
            if (!this.hSc.a(tVar.bPS(), tVar.bPT(), tVar.bPZ(), md5)) {
                tVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.hSc.xl(md5);
                return;
            }
            d.bPk().j(bPU, md5);
            tVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j(JSONObject jSONObject, String str) {
        if (this.hSl.a("https://mbd.baidu.com", jSONObject, false)) {
            d.bPk().ae(str, true);
        } else {
            d.bPk().ae(str, false);
        }
    }

    private void bPh() {
        ot(true);
        ot(false);
    }

    private void ot(boolean z) {
        t tVar = new t();
        tVar.ow(z);
        if (this.hSd.a(tVar, z)) {
            JSONObject bPU = tVar.bPU();
            this.hSd.os(z);
            d.bPk().aw(bPU);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aw(JSONObject jSONObject) {
        if (!this.hSl.a("http://m.baidu.com", jSONObject, false)) {
            o.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a bPi() {
        return this.hSc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.hSm.en(nVar.bPI());
        this.hSm.wK(nVar.bPH() * AiAppDateTimeUtil.TIME_DAY_MILLISECOND);
        this.hSm.wL(nVar.getThreshold());
        s.bPQ().putString("ubc_version_md5", nVar.bPG());
        this.hSc.em(nVar.bPI());
        nVar.bPI().clear();
        if (this.hSj == null) {
            this.hSj = new SparseArray<>();
        }
        this.hSj.clear();
        if (this.hSk == null) {
            this.hSk = new HashMap<>();
        }
        this.hSk.clear();
        this.hSc.f(this.hSj);
        int i = 0;
        for (int i2 = 0; i2 < this.hSj.size(); i2++) {
            int keyAt = this.hSj.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.hSk.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.hSm.wJ(i);
    }

    private boolean dn(Context context) {
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
    private void cT(String str, String str2) {
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
            p.xE("save to file suc");
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
    public void xn(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        p.xE("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            p.xE("delete file suc");
        }
        this.hSc.xl(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xo(String str) {
        p.xE("upload file fail");
        this.hSc.xm(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bPj() {
        this.hSc.bOY();
    }
}
