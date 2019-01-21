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
    private e ifB;
    private a ifr;
    private b ifs;
    private long ifu;
    private long ifv;
    private long ifw;
    private int ifx;
    private SparseArray<ArrayList> ify;
    private HashMap<String, Long> ifz;
    private Context mContext;
    private m ifA = o.bSQ().ZB();
    private List<j> ift = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.ifr = new a(context);
        this.ifs = new b(context);
        s bST = s.bST();
        this.ifu = bST.getLong("ubc_last_upload_all_time", 0L);
        this.ifv = bST.getLong("ubc_last_upload_non_real", 0L);
        this.ifw = bST.getLong("ubc_reset_real_time_count_time", 0L);
        this.ifx = bST.getInt("ubc_real_time_count", 0);
        this.ifB = e.bSo();
        this.ifB.a(this, context);
    }

    private void aAx() {
        if (this.ify == null) {
            this.ify = new SparseArray<>();
            this.ifr.f(this.ify);
            this.ifz = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.ify.size(); i2++) {
                int keyAt = this.ify.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.ifz.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.ifB.xO(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        boolean z = false;
        if (TextUtils.equals(jVar.getId(), jVar.bSA()) && this.ifB.yr(jVar.getId()) && (jVar.bSC() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.ifr.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.ifv) >= e.bSo().bSp()) {
            if (!z) {
                this.ift.add(jVar);
            }
            bSi();
        } else if ((jVar.bSC() & 1) == 0) {
            if (!z) {
                this.ift.add(jVar);
            }
            if (this.ift.size() >= 20) {
                bSe();
            }
        } else if (!z) {
            this.ifr.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.ifs.a(jVar, this.ifB.yr(jVar.getId()));
    }

    private void bSe() {
        if (this.ift != null && this.ift.size() != 0) {
            this.ifr.ep(this.ift);
            this.ift.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.ifr.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, int i, String str2) {
        this.ifr.n(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        bSe();
        this.ifr.a(str, i, j, jSONArray);
        if (this.ifB.yr(str)) {
            bSf();
        }
        if (Math.abs(System.currentTimeMillis() - this.ifv) >= e.bSo().bSp()) {
            bSi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bc(String str, int i) {
        bSe();
        this.ifr.bc(str, i);
        if (Math.abs(System.currentTimeMillis() - this.ifv) >= e.bSo().bSp()) {
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
                jSONObject.put("idtype", this.ifB.yx(jVar.getId()));
                tVar.aA(jSONObject);
                tVar.n(jVar.getTime(), jVar.getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.ify == null) {
                aAx();
            }
            if (this.ify.size() > 0) {
                this.ifr.a(this.ify.valueAt(0), tVar);
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
            if (this.ify == null) {
                aAx();
            }
            if (this.ify.size() > 0) {
                if (o.bSQ().ZD()) {
                    this.ifr.a(tVar);
                } else {
                    this.ifr.a(this.ify.valueAt(0), tVar);
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
        if (Math.abs(currentTimeMillis - this.ifw) > 86400000) {
            this.ifx = 0;
            this.ifw = currentTimeMillis;
            s.bST().putLong("ubc_reset_real_time_count_time", this.ifw);
            s.bST().putInt("ubc_real_time_count", this.ifx);
        }
        if (this.ifx >= 1000) {
            if (this.ifx == 1000) {
                this.ifx++;
                o.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void bSh() {
        this.ifx++;
        s.bST().putInt("ubc_real_time_count", this.ifx);
    }

    private void bSi() {
        if (dm(this.mContext)) {
            this.ifv = System.currentTimeMillis();
            s.bST().putLong("ubc_last_upload_non_real", this.ifv);
            bSk();
            bSe();
            this.ifr.bSa();
            HashSet hashSet = new HashSet();
            if (this.ify == null) {
                aAx();
            }
            t tVar = new t();
            tVar.oQ(false);
            int i = 0;
            for (int i2 = 0; i2 < this.ify.size(); i2++) {
                int keyAt = this.ify.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.ifz.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.ifB.bSp()) {
                        i |= this.ifr.a(this.ify.valueAt(i2), tVar);
                        this.ifz.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.ify.size(); i3++) {
                    int keyAt2 = this.ify.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (tVar.xX(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.ifr.a(this.ify.valueAt(i3), tVar);
                    }
                }
                c(tVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bSj() {
        if (dm(this.mContext) && Math.abs(System.currentTimeMillis() - this.ifu) >= 3600000) {
            this.ifr.bSa();
            t tVar = new t();
            if (this.ifr.a(tVar) != 0) {
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
                    if (this.ifB.yr(String.valueOf(bSV.valueAt(i).intValue()))) {
                        tVar2.cd(bSV.keyAt(i), bSV.valueAt(i).intValue());
                    } else {
                        tVar3.cd(bSV.keyAt(i), bSV.valueAt(i).intValue());
                    }
                }
                ArrayList bSW = tVar.bSW();
                int size2 = bSW.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bSW.get(i2);
                    if (this.ifB.yr(str)) {
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
                            if (this.ifB.yr(str2)) {
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
                this.ifu = System.currentTimeMillis();
                s.bST().putLong("ubc_last_upload_all_time", this.ifu);
                this.ifv = this.ifu;
                s.bST().putLong("ubc_last_upload_non_real", this.ifv);
            }
        }
    }

    private void c(t tVar) {
        if (!tVar.isEmpty()) {
            JSONObject bSX = tVar.bSX();
            String md5 = com.baidu.g.c.toMd5(bSX.toString().getBytes(), true);
            da(bSX.toString(), md5);
            if (!this.ifr.a(tVar.bSV(), tVar.bSW(), tVar.bTc(), md5)) {
                tVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.ifr.ym(md5);
                return;
            }
            d.bSn().k(bSX, md5);
            tVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(JSONObject jSONObject, String str) {
        if (this.ifA.a("https://mbd.baidu.com", jSONObject, false)) {
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
        if (this.ifs.a(tVar, z)) {
            JSONObject bSX = tVar.bSX();
            this.ifs.oM(z);
            d.bSn().ay(bSX);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ay(JSONObject jSONObject) {
        if (!this.ifA.a("http://m.baidu.com", jSONObject, false)) {
            o.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a bSl() {
        return this.ifr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.ifB.er(nVar.bSL());
        this.ifB.xP(nVar.bSK() * AiAppDateTimeUtil.TIME_DAY_MILLISECOND);
        this.ifB.xQ(nVar.getThreshold());
        s.bST().putString("ubc_version_md5", nVar.bSJ());
        this.ifr.eq(nVar.bSL());
        nVar.bSL().clear();
        if (this.ify == null) {
            this.ify = new SparseArray<>();
        }
        this.ify.clear();
        if (this.ifz == null) {
            this.ifz = new HashMap<>();
        }
        this.ifz.clear();
        this.ifr.f(this.ify);
        int i = 0;
        for (int i2 = 0; i2 < this.ify.size(); i2++) {
            int keyAt = this.ify.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.ifz.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.ifB.xO(i);
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
        this.ifr.ym(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yp(String str) {
        p.yF("upload file fail");
        this.ifr.yn(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bSm() {
        this.ifr.bSb();
    }
}
