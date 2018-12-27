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
    private a iej;
    private b iek;
    private long iem;
    private long ien;
    private long ieo;
    private int iep;
    private SparseArray<ArrayList> ieq;
    private HashMap<String, Long> ier;
    private e iet;
    private Context mContext;
    private m ies = o.bSi().Ze();
    private List<j> iel = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.iej = new a(context);
        this.iek = new b(context);
        s bSl = s.bSl();
        this.iem = bSl.getLong("ubc_last_upload_all_time", 0L);
        this.ien = bSl.getLong("ubc_last_upload_non_real", 0L);
        this.ieo = bSl.getLong("ubc_reset_real_time_count_time", 0L);
        this.iep = bSl.getInt("ubc_real_time_count", 0);
        this.iet = e.bRG();
        this.iet.a(this, context);
    }

    private void aAa() {
        if (this.ieq == null) {
            this.ieq = new SparseArray<>();
            this.iej.f(this.ieq);
            this.ier = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.ieq.size(); i2++) {
                int keyAt = this.ieq.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.ier.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.iet.xM(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        boolean z = false;
        if (TextUtils.equals(jVar.getId(), jVar.bRS()) && this.iet.yb(jVar.getId()) && (jVar.bRU() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.iej.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.ien) >= e.bRG().bRH()) {
            if (!z) {
                this.iel.add(jVar);
            }
            bRA();
        } else if ((jVar.bRU() & 1) == 0) {
            if (!z) {
                this.iel.add(jVar);
            }
            if (this.iel.size() >= 20) {
                bRw();
            }
        } else if (!z) {
            this.iej.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.iek.a(jVar, this.iet.yb(jVar.getId()));
    }

    private void bRw() {
        if (this.iel != null && this.iel.size() != 0) {
            this.iej.eo(this.iel);
            this.iel.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.iej.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, int i, String str2) {
        this.iej.n(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        bRw();
        this.iej.a(str, i, j, jSONArray);
        if (this.iet.yb(str)) {
            bRx();
        }
        if (Math.abs(System.currentTimeMillis() - this.ien) >= e.bRG().bRH()) {
            bRA();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bc(String str, int i) {
        bRw();
        this.iej.bc(str, i);
        if (Math.abs(System.currentTimeMillis() - this.ien) >= e.bRG().bRH()) {
            bRA();
        }
    }

    private boolean c(j jVar) {
        if (dm(this.mContext) && bRy()) {
            bRw();
            t tVar = new t();
            tVar.oP(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", jVar.getId());
                jSONObject.put(HttpConstants.TIMESTAMP, Long.toString(jVar.getTime()));
                if (jVar.bRW() != null) {
                    jSONObject.put("content", jVar.bRW().toString());
                } else {
                    jSONObject.put("content", jVar.getContent());
                }
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(jVar.bRV())) {
                    jSONObject.put("abtest", jVar.bRV());
                    tVar.yr("1");
                }
                if (!TextUtils.isEmpty(jVar.getCategory())) {
                    jSONObject.put("c", jVar.getCategory());
                }
                if (jVar.bRQ()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put("idtype", this.iet.yh(jVar.getId()));
                tVar.aA(jSONObject);
                tVar.n(jVar.getTime(), jVar.getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.ieq == null) {
                aAa();
            }
            if (this.ieq.size() > 0) {
                this.iej.a(this.ieq.valueAt(0), tVar);
            }
            c(tVar);
            bRz();
            return true;
        }
        return false;
    }

    private void bRx() {
        if (dm(this.mContext) && bRy()) {
            t tVar = new t();
            tVar.oP(true);
            if (this.ieq == null) {
                aAa();
            }
            if (this.ieq.size() > 0) {
                if (o.bSi().Zg()) {
                    this.iej.a(tVar);
                } else {
                    this.iej.a(this.ieq.valueAt(0), tVar);
                }
            }
            c(tVar);
            bRz();
        }
    }

    private boolean bRy() {
        if (o.bSi().Zg()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.ieo) > 86400000) {
            this.iep = 0;
            this.ieo = currentTimeMillis;
            s.bSl().putLong("ubc_reset_real_time_count_time", this.ieo);
            s.bSl().putInt("ubc_real_time_count", this.iep);
        }
        if (this.iep >= 1000) {
            if (this.iep == 1000) {
                this.iep++;
                o.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void bRz() {
        this.iep++;
        s.bSl().putInt("ubc_real_time_count", this.iep);
    }

    private void bRA() {
        if (dm(this.mContext)) {
            this.ien = System.currentTimeMillis();
            s.bSl().putLong("ubc_last_upload_non_real", this.ien);
            bRC();
            bRw();
            this.iej.bRs();
            HashSet hashSet = new HashSet();
            if (this.ieq == null) {
                aAa();
            }
            t tVar = new t();
            tVar.oP(false);
            int i = 0;
            for (int i2 = 0; i2 < this.ieq.size(); i2++) {
                int keyAt = this.ieq.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.ier.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.iet.bRH()) {
                        i |= this.iej.a(this.ieq.valueAt(i2), tVar);
                        this.ier.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.ieq.size(); i3++) {
                    int keyAt2 = this.ieq.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (tVar.xV(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.iej.a(this.ieq.valueAt(i3), tVar);
                    }
                }
                c(tVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bRB() {
        if (dm(this.mContext) && Math.abs(System.currentTimeMillis() - this.iem) >= 3600000) {
            this.iej.bRs();
            t tVar = new t();
            if (this.iej.a(tVar) != 0) {
                t tVar2 = new t();
                tVar2.n(tVar.bSr(), tVar.bSs());
                tVar2.yr(tVar.bSq());
                tVar2.oP(true);
                t tVar3 = new t();
                tVar3.n(tVar.bSr(), tVar.bSs());
                tVar3.yr(tVar.bSq());
                tVar3.oP(false);
                SparseArray<Integer> bSn = tVar.bSn();
                int size = bSn.size();
                for (int i = 0; i < size; i++) {
                    if (this.iet.yb(String.valueOf(bSn.valueAt(i).intValue()))) {
                        tVar2.cd(bSn.keyAt(i), bSn.valueAt(i).intValue());
                    } else {
                        tVar3.cd(bSn.keyAt(i), bSn.valueAt(i).intValue());
                    }
                }
                ArrayList bSo = tVar.bSo();
                int size2 = bSo.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bSo.get(i2);
                    if (this.iet.yb(str)) {
                        tVar2.yq(str);
                    } else {
                        tVar3.yq(str);
                    }
                }
                JSONArray bSt = tVar.bSt();
                int length = bSt.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = bSt.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.iet.yb(str2)) {
                                tVar2.aA(optJSONObject);
                            } else {
                                tVar3.aA(optJSONObject);
                            }
                        }
                    }
                }
                if (tVar2.bSt().length() > 0) {
                    c(tVar2);
                }
                if (tVar3.bSt().length() > 0) {
                    c(tVar3);
                }
                this.iem = System.currentTimeMillis();
                s.bSl().putLong("ubc_last_upload_all_time", this.iem);
                this.ien = this.iem;
                s.bSl().putLong("ubc_last_upload_non_real", this.ien);
            }
        }
    }

    private void c(t tVar) {
        if (!tVar.isEmpty()) {
            JSONObject bSp = tVar.bSp();
            String md5 = com.baidu.g.c.toMd5(bSp.toString().getBytes(), true);
            cY(bSp.toString(), md5);
            if (!this.iej.a(tVar.bSn(), tVar.bSo(), tVar.bSu(), md5)) {
                tVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.iej.xW(md5);
                return;
            }
            d.bRF().k(bSp, md5);
            tVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(JSONObject jSONObject, String str) {
        if (this.ies.a("https://mbd.baidu.com", jSONObject, false)) {
            d.bRF().ag(str, true);
        } else {
            d.bRF().ag(str, false);
        }
    }

    private void bRC() {
        oM(true);
        oM(false);
    }

    private void oM(boolean z) {
        t tVar = new t();
        tVar.oP(z);
        if (this.iek.a(tVar, z)) {
            JSONObject bSp = tVar.bSp();
            this.iek.oL(z);
            d.bRF().ay(bSp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ay(JSONObject jSONObject) {
        if (!this.ies.a("http://m.baidu.com", jSONObject, false)) {
            o.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a bRD() {
        return this.iej;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.iet.eq(nVar.bSd());
        this.iet.xN(nVar.bSc() * AiAppDateTimeUtil.TIME_DAY_MILLISECOND);
        this.iet.xO(nVar.getThreshold());
        s.bSl().putString("ubc_version_md5", nVar.bSb());
        this.iej.ep(nVar.bSd());
        nVar.bSd().clear();
        if (this.ieq == null) {
            this.ieq = new SparseArray<>();
        }
        this.ieq.clear();
        if (this.ier == null) {
            this.ier = new HashMap<>();
        }
        this.ier.clear();
        this.iej.f(this.ieq);
        int i = 0;
        for (int i2 = 0; i2 < this.ieq.size(); i2++) {
            int keyAt = this.ieq.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.ier.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.iet.xM(i);
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
            p.yp("save to file suc");
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
    public void xY(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        p.yp("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            p.yp("delete file suc");
        }
        this.iej.xW(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xZ(String str) {
        p.yp("upload file fail");
        this.iej.xX(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bRE() {
        this.iej.bRt();
    }
}
