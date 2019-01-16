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
    private e ifA;
    private a ifq;
    private b ifr;
    private long ift;
    private long ifu;
    private long ifv;
    private int ifw;
    private SparseArray<ArrayList> ifx;
    private HashMap<String, Long> ify;
    private Context mContext;
    private m ifz = o.bSQ().ZB();
    private List<j> ifs = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.ifq = new a(context);
        this.ifr = new b(context);
        s bST = s.bST();
        this.ift = bST.getLong("ubc_last_upload_all_time", 0L);
        this.ifu = bST.getLong("ubc_last_upload_non_real", 0L);
        this.ifv = bST.getLong("ubc_reset_real_time_count_time", 0L);
        this.ifw = bST.getInt("ubc_real_time_count", 0);
        this.ifA = e.bSo();
        this.ifA.a(this, context);
    }

    private void aAx() {
        if (this.ifx == null) {
            this.ifx = new SparseArray<>();
            this.ifq.f(this.ifx);
            this.ify = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.ifx.size(); i2++) {
                int keyAt = this.ifx.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.ify.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.ifA.xO(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        boolean z = false;
        if (TextUtils.equals(jVar.getId(), jVar.bSA()) && this.ifA.yr(jVar.getId()) && (jVar.bSC() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.ifq.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.ifu) >= e.bSo().bSp()) {
            if (!z) {
                this.ifs.add(jVar);
            }
            bSi();
        } else if ((jVar.bSC() & 1) == 0) {
            if (!z) {
                this.ifs.add(jVar);
            }
            if (this.ifs.size() >= 20) {
                bSe();
            }
        } else if (!z) {
            this.ifq.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.ifr.a(jVar, this.ifA.yr(jVar.getId()));
    }

    private void bSe() {
        if (this.ifs != null && this.ifs.size() != 0) {
            this.ifq.ep(this.ifs);
            this.ifs.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.ifq.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, int i, String str2) {
        this.ifq.n(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        bSe();
        this.ifq.a(str, i, j, jSONArray);
        if (this.ifA.yr(str)) {
            bSf();
        }
        if (Math.abs(System.currentTimeMillis() - this.ifu) >= e.bSo().bSp()) {
            bSi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bc(String str, int i) {
        bSe();
        this.ifq.bc(str, i);
        if (Math.abs(System.currentTimeMillis() - this.ifu) >= e.bSo().bSp()) {
            bSi();
        }
    }

    private boolean c(j jVar) {
        if (dm(this.mContext) && bSg()) {
            bSe();
            t tVar = new t();
            tVar.oQ(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", jVar.getId());
                jSONObject.put(HttpConstants.TIMESTAMP, Long.toString(jVar.getTime()));
                if (jVar.bSE() != null) {
                    jSONObject.put("content", jVar.bSE().toString());
                } else {
                    jSONObject.put("content", jVar.getContent());
                }
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(jVar.bSD())) {
                    jSONObject.put("abtest", jVar.bSD());
                    tVar.yH("1");
                }
                if (!TextUtils.isEmpty(jVar.getCategory())) {
                    jSONObject.put("c", jVar.getCategory());
                }
                if (jVar.bSy()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put("idtype", this.ifA.yx(jVar.getId()));
                tVar.aA(jSONObject);
                tVar.n(jVar.getTime(), jVar.getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.ifx == null) {
                aAx();
            }
            if (this.ifx.size() > 0) {
                this.ifq.a(this.ifx.valueAt(0), tVar);
            }
            c(tVar);
            bSh();
            return true;
        }
        return false;
    }

    private void bSf() {
        if (dm(this.mContext) && bSg()) {
            t tVar = new t();
            tVar.oQ(true);
            if (this.ifx == null) {
                aAx();
            }
            if (this.ifx.size() > 0) {
                if (o.bSQ().ZD()) {
                    this.ifq.a(tVar);
                } else {
                    this.ifq.a(this.ifx.valueAt(0), tVar);
                }
            }
            c(tVar);
            bSh();
        }
    }

    private boolean bSg() {
        if (o.bSQ().ZD()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.ifv) > 86400000) {
            this.ifw = 0;
            this.ifv = currentTimeMillis;
            s.bST().putLong("ubc_reset_real_time_count_time", this.ifv);
            s.bST().putInt("ubc_real_time_count", this.ifw);
        }
        if (this.ifw >= 1000) {
            if (this.ifw == 1000) {
                this.ifw++;
                o.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void bSh() {
        this.ifw++;
        s.bST().putInt("ubc_real_time_count", this.ifw);
    }

    private void bSi() {
        if (dm(this.mContext)) {
            this.ifu = System.currentTimeMillis();
            s.bST().putLong("ubc_last_upload_non_real", this.ifu);
            bSk();
            bSe();
            this.ifq.bSa();
            HashSet hashSet = new HashSet();
            if (this.ifx == null) {
                aAx();
            }
            t tVar = new t();
            tVar.oQ(false);
            int i = 0;
            for (int i2 = 0; i2 < this.ifx.size(); i2++) {
                int keyAt = this.ifx.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.ify.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.ifA.bSp()) {
                        i |= this.ifq.a(this.ifx.valueAt(i2), tVar);
                        this.ify.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.ifx.size(); i3++) {
                    int keyAt2 = this.ifx.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (tVar.xX(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.ifq.a(this.ifx.valueAt(i3), tVar);
                    }
                }
                c(tVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bSj() {
        if (dm(this.mContext) && Math.abs(System.currentTimeMillis() - this.ift) >= 3600000) {
            this.ifq.bSa();
            t tVar = new t();
            if (this.ifq.a(tVar) != 0) {
                t tVar2 = new t();
                tVar2.n(tVar.bSZ(), tVar.bTa());
                tVar2.yH(tVar.bSY());
                tVar2.oQ(true);
                t tVar3 = new t();
                tVar3.n(tVar.bSZ(), tVar.bTa());
                tVar3.yH(tVar.bSY());
                tVar3.oQ(false);
                SparseArray<Integer> bSV = tVar.bSV();
                int size = bSV.size();
                for (int i = 0; i < size; i++) {
                    if (this.ifA.yr(String.valueOf(bSV.valueAt(i).intValue()))) {
                        tVar2.cd(bSV.keyAt(i), bSV.valueAt(i).intValue());
                    } else {
                        tVar3.cd(bSV.keyAt(i), bSV.valueAt(i).intValue());
                    }
                }
                ArrayList bSW = tVar.bSW();
                int size2 = bSW.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bSW.get(i2);
                    if (this.ifA.yr(str)) {
                        tVar2.yG(str);
                    } else {
                        tVar3.yG(str);
                    }
                }
                JSONArray bTb = tVar.bTb();
                int length = bTb.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = bTb.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.ifA.yr(str2)) {
                                tVar2.aA(optJSONObject);
                            } else {
                                tVar3.aA(optJSONObject);
                            }
                        }
                    }
                }
                if (tVar2.bTb().length() > 0) {
                    c(tVar2);
                }
                if (tVar3.bTb().length() > 0) {
                    c(tVar3);
                }
                this.ift = System.currentTimeMillis();
                s.bST().putLong("ubc_last_upload_all_time", this.ift);
                this.ifu = this.ift;
                s.bST().putLong("ubc_last_upload_non_real", this.ifu);
            }
        }
    }

    private void c(t tVar) {
        if (!tVar.isEmpty()) {
            JSONObject bSX = tVar.bSX();
            String md5 = com.baidu.g.c.toMd5(bSX.toString().getBytes(), true);
            da(bSX.toString(), md5);
            if (!this.ifq.a(tVar.bSV(), tVar.bSW(), tVar.bTc(), md5)) {
                tVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.ifq.ym(md5);
                return;
            }
            d.bSn().k(bSX, md5);
            tVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(JSONObject jSONObject, String str) {
        if (this.ifz.a("https://mbd.baidu.com", jSONObject, false)) {
            d.bSn().af(str, true);
        } else {
            d.bSn().af(str, false);
        }
    }

    private void bSk() {
        oN(true);
        oN(false);
    }

    private void oN(boolean z) {
        t tVar = new t();
        tVar.oQ(z);
        if (this.ifr.a(tVar, z)) {
            JSONObject bSX = tVar.bSX();
            this.ifr.oM(z);
            d.bSn().ay(bSX);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ay(JSONObject jSONObject) {
        if (!this.ifz.a("http://m.baidu.com", jSONObject, false)) {
            o.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a bSl() {
        return this.ifq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.ifA.er(nVar.bSL());
        this.ifA.xP(nVar.bSK() * AiAppDateTimeUtil.TIME_DAY_MILLISECOND);
        this.ifA.xQ(nVar.getThreshold());
        s.bST().putString("ubc_version_md5", nVar.bSJ());
        this.ifq.eq(nVar.bSL());
        nVar.bSL().clear();
        if (this.ifx == null) {
            this.ifx = new SparseArray<>();
        }
        this.ifx.clear();
        if (this.ify == null) {
            this.ify = new HashMap<>();
        }
        this.ify.clear();
        this.ifq.f(this.ifx);
        int i = 0;
        for (int i2 = 0; i2 < this.ifx.size(); i2++) {
            int keyAt = this.ifx.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.ify.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.ifA.xO(i);
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
    private void da(String str, String str2) {
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
            p.yF("save to file suc");
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
    public void yo(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        p.yF("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            p.yF("delete file suc");
        }
        this.ifq.ym(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yp(String str) {
        p.yF("upload file fail");
        this.ifq.yn(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bSm() {
        this.ifq.bSb();
    }
}
