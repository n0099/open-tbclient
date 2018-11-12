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
    private a hTM;
    private b hTN;
    private long hTP;
    private long hTQ;
    private long hTR;
    private int hTS;
    private SparseArray<ArrayList> hTT;
    private HashMap<String, Long> hTU;
    private e hTW;
    private Context mContext;
    private m hTV = o.bPm().XY();
    private List<j> hTO = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.hTM = new a(context);
        this.hTN = new b(context);
        s bPp = s.bPp();
        this.hTP = bPp.getLong("ubc_last_upload_all_time", 0L);
        this.hTQ = bPp.getLong("ubc_last_upload_non_real", 0L);
        this.hTR = bPp.getLong("ubc_reset_real_time_count_time", 0L);
        this.hTS = bPp.getInt("ubc_real_time_count", 0);
        this.hTW = e.bOK();
        this.hTW.a(this, context);
    }

    private void axB() {
        if (this.hTT == null) {
            this.hTT = new SparseArray<>();
            this.hTM.f(this.hTT);
            this.hTU = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.hTT.size(); i2++) {
                int keyAt = this.hTT.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.hTU.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.hTW.xc(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        boolean z = false;
        if (TextUtils.equals(jVar.getId(), jVar.bOW()) && this.hTW.xv(jVar.getId()) && (jVar.bOY() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.hTM.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.hTQ) >= e.bOK().bOL()) {
            if (!z) {
                this.hTO.add(jVar);
            }
            bOE();
        } else if ((jVar.bOY() & 1) == 0) {
            if (!z) {
                this.hTO.add(jVar);
            }
            if (this.hTO.size() >= 20) {
                bOA();
            }
        } else if (!z) {
            this.hTM.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.hTN.a(jVar, this.hTW.xv(jVar.getId()));
    }

    private void bOA() {
        if (this.hTO != null && this.hTO.size() != 0) {
            this.hTM.ej(this.hTO);
            this.hTO.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.hTM.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, int i, String str2) {
        this.hTM.n(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        bOA();
        this.hTM.a(str, i, j, jSONArray);
        if (this.hTW.xv(str)) {
            bOB();
        }
        if (Math.abs(System.currentTimeMillis() - this.hTQ) >= e.bOK().bOL()) {
            bOE();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ba(String str, int i) {
        bOA();
        this.hTM.ba(str, i);
        if (Math.abs(System.currentTimeMillis() - this.hTQ) >= e.bOK().bOL()) {
            bOE();
        }
    }

    private boolean c(j jVar) {
        if (di(this.mContext) && bOC()) {
            bOA();
            t tVar = new t();
            tVar.oK(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", jVar.getId());
                jSONObject.put(HttpConstants.TIMESTAMP, Long.toString(jVar.getTime()));
                if (jVar.bPa() != null) {
                    jSONObject.put("content", jVar.bPa().toString());
                } else {
                    jSONObject.put("content", jVar.getContent());
                }
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(jVar.bOZ())) {
                    jSONObject.put("abtest", jVar.bOZ());
                    tVar.xL("1");
                }
                if (!TextUtils.isEmpty(jVar.getCategory())) {
                    jSONObject.put("c", jVar.getCategory());
                }
                if (jVar.bOU()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put("idtype", this.hTW.xB(jVar.getId()));
                tVar.ay(jSONObject);
                tVar.n(jVar.getTime(), jVar.getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.hTT == null) {
                axB();
            }
            if (this.hTT.size() > 0) {
                this.hTM.a(this.hTT.valueAt(0), tVar);
            }
            c(tVar);
            bOD();
            return true;
        }
        return false;
    }

    private void bOB() {
        if (di(this.mContext) && bOC()) {
            t tVar = new t();
            tVar.oK(true);
            if (this.hTT == null) {
                axB();
            }
            if (this.hTT.size() > 0) {
                if (o.bPm().Ya()) {
                    this.hTM.a(tVar);
                } else {
                    this.hTM.a(this.hTT.valueAt(0), tVar);
                }
            }
            c(tVar);
            bOD();
        }
    }

    private boolean bOC() {
        if (o.bPm().Ya()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.hTR) > 86400000) {
            this.hTS = 0;
            this.hTR = currentTimeMillis;
            s.bPp().putLong("ubc_reset_real_time_count_time", this.hTR);
            s.bPp().putInt("ubc_real_time_count", this.hTS);
        }
        if (this.hTS >= 1000) {
            if (this.hTS == 1000) {
                this.hTS++;
                o.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void bOD() {
        this.hTS++;
        s.bPp().putInt("ubc_real_time_count", this.hTS);
    }

    private void bOE() {
        if (di(this.mContext)) {
            this.hTQ = System.currentTimeMillis();
            s.bPp().putLong("ubc_last_upload_non_real", this.hTQ);
            bOG();
            bOA();
            this.hTM.bOw();
            HashSet hashSet = new HashSet();
            if (this.hTT == null) {
                axB();
            }
            t tVar = new t();
            tVar.oK(false);
            int i = 0;
            for (int i2 = 0; i2 < this.hTT.size(); i2++) {
                int keyAt = this.hTT.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.hTU.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.hTW.bOL()) {
                        i |= this.hTM.a(this.hTT.valueAt(i2), tVar);
                        this.hTU.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.hTT.size(); i3++) {
                    int keyAt2 = this.hTT.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (tVar.xl(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.hTM.a(this.hTT.valueAt(i3), tVar);
                    }
                }
                c(tVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bOF() {
        if (di(this.mContext) && Math.abs(System.currentTimeMillis() - this.hTP) >= 3600000) {
            this.hTM.bOw();
            t tVar = new t();
            if (this.hTM.a(tVar) != 0) {
                t tVar2 = new t();
                tVar2.n(tVar.bPv(), tVar.bPw());
                tVar2.xL(tVar.bPu());
                tVar2.oK(true);
                t tVar3 = new t();
                tVar3.n(tVar.bPv(), tVar.bPw());
                tVar3.xL(tVar.bPu());
                tVar3.oK(false);
                SparseArray<Integer> bPr = tVar.bPr();
                int size = bPr.size();
                for (int i = 0; i < size; i++) {
                    if (this.hTW.xv(String.valueOf(bPr.valueAt(i).intValue()))) {
                        tVar2.ce(bPr.keyAt(i), bPr.valueAt(i).intValue());
                    } else {
                        tVar3.ce(bPr.keyAt(i), bPr.valueAt(i).intValue());
                    }
                }
                ArrayList bPs = tVar.bPs();
                int size2 = bPs.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bPs.get(i2);
                    if (this.hTW.xv(str)) {
                        tVar2.xK(str);
                    } else {
                        tVar3.xK(str);
                    }
                }
                JSONArray bPx = tVar.bPx();
                int length = bPx.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = bPx.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.hTW.xv(str2)) {
                                tVar2.ay(optJSONObject);
                            } else {
                                tVar3.ay(optJSONObject);
                            }
                        }
                    }
                }
                if (tVar2.bPx().length() > 0) {
                    c(tVar2);
                }
                if (tVar3.bPx().length() > 0) {
                    c(tVar3);
                }
                this.hTP = System.currentTimeMillis();
                s.bPp().putLong("ubc_last_upload_all_time", this.hTP);
                this.hTQ = this.hTP;
                s.bPp().putLong("ubc_last_upload_non_real", this.hTQ);
            }
        }
    }

    private void c(t tVar) {
        if (!tVar.isEmpty()) {
            JSONObject bPt = tVar.bPt();
            String md5 = com.baidu.g.c.toMd5(bPt.toString().getBytes(), true);
            cT(bPt.toString(), md5);
            if (!this.hTM.a(tVar.bPr(), tVar.bPs(), tVar.bPy(), md5)) {
                tVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.hTM.xq(md5);
                return;
            }
            d.bOJ().k(bPt, md5);
            tVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(JSONObject jSONObject, String str) {
        if (this.hTV.a("https://mbd.baidu.com", jSONObject, false)) {
            d.bOJ().ae(str, true);
        } else {
            d.bOJ().ae(str, false);
        }
    }

    private void bOG() {
        oH(true);
        oH(false);
    }

    private void oH(boolean z) {
        t tVar = new t();
        tVar.oK(z);
        if (this.hTN.a(tVar, z)) {
            JSONObject bPt = tVar.bPt();
            this.hTN.oG(z);
            d.bOJ().aw(bPt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aw(JSONObject jSONObject) {
        if (!this.hTV.a("http://m.baidu.com", jSONObject, false)) {
            o.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a bOH() {
        return this.hTM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.hTW.el(nVar.bPh());
        this.hTW.xd(nVar.bPg() * AiAppDateTimeUtil.TIME_DAY_MILLISECOND);
        this.hTW.xe(nVar.getThreshold());
        s.bPp().putString("ubc_version_md5", nVar.bPf());
        this.hTM.ek(nVar.bPh());
        nVar.bPh().clear();
        if (this.hTT == null) {
            this.hTT = new SparseArray<>();
        }
        this.hTT.clear();
        if (this.hTU == null) {
            this.hTU = new HashMap<>();
        }
        this.hTU.clear();
        this.hTM.f(this.hTT);
        int i = 0;
        for (int i2 = 0; i2 < this.hTT.size(); i2++) {
            int keyAt = this.hTT.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.hTU.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.hTW.xc(i);
    }

    private boolean di(Context context) {
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
            p.xJ("save to file suc");
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
    public void xs(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        p.xJ("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            p.xJ("delete file suc");
        }
        this.hTM.xq(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xt(String str) {
        p.xJ("upload file fail");
        this.hTM.xr(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bOI() {
        this.hTM.bOx();
    }
}
