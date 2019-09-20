package com.baidu.ubc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
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
    private long bwo;
    private long bwp;
    private long bwq;
    private int bwr;
    private SparseArray<ArrayList> bws;
    private HashMap<String, Long> bwt;
    private a jZw;
    private b jZx;
    private e jZz;
    private Context mContext;
    private m jZy = UBC.getUBCContext().aIq();
    private List<j> bwn = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.jZw = new a(context);
        this.jZx = new b(context);
        r cEm = r.cEm();
        this.bwo = cEm.getLong("ubc_last_upload_all_time", 0L);
        this.bwp = cEm.getLong("ubc_last_upload_non_real", 0L);
        this.bwq = cEm.getLong("ubc_reset_real_time_count_time", 0L);
        this.bwr = cEm.getInt("ubc_real_time_count", 0);
        this.jZz = e.cEl();
        this.jZz.a(this, context);
    }

    private void Xv() {
        if (this.bws == null) {
            this.bws = new SparseArray<>();
            this.jZw.a(this.bws);
            this.bwt = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.bws.size(); i2++) {
                int keyAt = this.bws.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.bwt.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.jZz.fW(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        boolean z = false;
        if (TextUtils.equals(jVar.getId(), jVar.XT()) && this.jZz.kP(jVar.getId()) && (jVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(jVar)) {
            this.jZw.a(jVar);
        } else if (Math.abs(System.currentTimeMillis() - this.bwp) >= e.cEl().XH()) {
            if (!z) {
                this.bwn.add(jVar);
            }
            XA();
        } else if ((jVar.getOption() & 1) == 0) {
            if (!z) {
                this.bwn.add(jVar);
            }
            if (this.bwn.size() >= 20) {
                Xw();
            }
        } else if (!z) {
            this.jZw.a(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.jZx.a(jVar, this.jZz.kP(jVar.getId()));
    }

    private void Xw() {
        if (this.bwn != null && this.bwn.size() != 0) {
            this.jZw.H(this.bwn);
            this.bwn.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.jZw.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.jZw.c(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        Xw();
        this.jZw.a(str, i, j, jSONArray);
        if (this.jZz.kP(str)) {
            Xx();
        }
        if (Math.abs(System.currentTimeMillis() - this.bwp) >= e.cEl().XH()) {
            XA();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        Xw();
        this.jZw.t(str, i);
        if (Math.abs(System.currentTimeMillis() - this.bwp) >= e.cEl().XH()) {
            XA();
        }
    }

    private boolean c(j jVar) {
        if (ch(this.mContext) && Xy()) {
            Xw();
            s sVar = new s();
            sVar.ds(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", jVar.getId());
                jSONObject.put(DpStatConstants.KEY_TIMESTAMP, Long.toString(jVar.getTime()));
                if (jVar.XW() != null) {
                    jSONObject.put("content", jVar.XW().toString());
                } else {
                    jSONObject.put("content", jVar.getContent());
                }
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(jVar.XV())) {
                    jSONObject.put(ImageViewerConfig.ABTEST, jVar.XV());
                    sVar.le("1");
                }
                if (!TextUtils.isEmpty(jVar.getCategory())) {
                    jSONObject.put("c", jVar.getCategory());
                }
                if (jVar.XR()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put("idtype", this.jZz.kV(jVar.getId()));
                sVar.aU(jSONObject);
                sVar.g(jVar.getTime(), jVar.getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.bws == null) {
                Xv();
            }
            if (this.bws.size() > 0) {
                this.jZw.a(this.bws.valueAt(0), sVar);
            }
            c(sVar);
            Xz();
            return true;
        }
        return false;
    }

    private void Xx() {
        if (ch(this.mContext) && Xy()) {
            s sVar = new s();
            sVar.ds(true);
            if (this.bws == null) {
                Xv();
            }
            if (this.bws.size() > 0) {
                if (UBC.getUBCContext().Ij()) {
                    this.jZw.a(sVar);
                } else {
                    this.jZw.a(this.bws.valueAt(0), sVar);
                }
            }
            c(sVar);
            Xz();
        }
    }

    private boolean Xy() {
        if (UBC.getUBCContext().Ij()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.bwq) > 86400000) {
            this.bwr = 0;
            this.bwq = currentTimeMillis;
            r.cEm().putLong("ubc_reset_real_time_count_time", this.bwq);
            r.cEm().putInt("ubc_real_time_count", this.bwr);
        }
        if (this.bwr >= 1000) {
            if (this.bwr == 1000) {
                this.bwr++;
                UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void Xz() {
        this.bwr++;
        r.cEm().putInt("ubc_real_time_count", this.bwr);
    }

    private void XA() {
        if (ch(this.mContext)) {
            this.bwp = System.currentTimeMillis();
            r.cEm().putLong("ubc_last_upload_non_real", this.bwp);
            XC();
            Xw();
            this.jZw.Xq();
            HashSet hashSet = new HashSet();
            if (this.bws == null) {
                Xv();
            }
            s sVar = new s();
            sVar.ds(false);
            int i = 0;
            for (int i2 = 0; i2 < this.bws.size(); i2++) {
                int keyAt = this.bws.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.bwt.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.jZz.XH()) {
                        i |= this.jZw.a(this.bws.valueAt(i2), sVar);
                        this.bwt.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.bws.size(); i3++) {
                    int keyAt2 = this.bws.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (sVar.gf(51200)) {
                            break;
                        }
                        this.jZw.a(this.bws.valueAt(i3), sVar);
                    }
                }
                c(sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void XB() {
        if (ch(this.mContext) && Math.abs(System.currentTimeMillis() - this.bwo) >= 3600000) {
            this.jZw.Xq();
            s sVar = new s();
            if (this.jZw.a(sVar) != 0) {
                s sVar2 = new s();
                sVar2.g(sVar.Yy(), sVar.Yz());
                sVar2.le(sVar.Yx());
                sVar2.ds(true);
                s sVar3 = new s();
                sVar3.g(sVar.Yy(), sVar.Yz());
                sVar3.le(sVar.Yx());
                sVar3.ds(false);
                SparseArray<Integer> Yu = sVar.Yu();
                int size = Yu.size();
                for (int i = 0; i < size; i++) {
                    if (this.jZz.kP(String.valueOf(Yu.valueAt(i).intValue()))) {
                        sVar2.Q(Yu.keyAt(i), Yu.valueAt(i).intValue());
                    } else {
                        sVar3.Q(Yu.keyAt(i), Yu.valueAt(i).intValue());
                    }
                }
                ArrayList Yv = sVar.Yv();
                int size2 = Yv.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) Yv.get(i2);
                    if (this.jZz.kP(str)) {
                        sVar2.ld(str);
                    } else {
                        sVar3.ld(str);
                    }
                }
                JSONArray YA = sVar.YA();
                int length = YA.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = YA.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.jZz.kP(str2)) {
                                sVar2.aU(optJSONObject);
                            } else {
                                sVar3.aU(optJSONObject);
                            }
                        }
                    }
                }
                if (sVar2.YA().length() > 0) {
                    c(sVar2);
                }
                if (sVar3.YA().length() > 0) {
                    c(sVar3);
                }
                this.bwo = System.currentTimeMillis();
                r.cEm().putLong("ubc_last_upload_all_time", this.bwo);
                this.bwp = this.bwo;
                r.cEm().putLong("ubc_last_upload_non_real", this.bwp);
            }
        }
    }

    private void c(s sVar) {
        if (!sVar.isEmpty()) {
            JSONObject cEo = sVar.cEo();
            String md5 = com.baidu.f.c.toMd5(cEo.toString().getBytes(), true);
            bp(cEo.toString(), md5);
            if (!this.jZw.a(sVar.Yu(), sVar.Yv(), sVar.YB(), md5)) {
                sVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.jZw.kK(md5);
                return;
            }
            d.cEk().m(cEo, md5);
            sVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(JSONObject jSONObject, String str) {
        if (this.jZy.a("https://mbd.baidu.com", jSONObject, false)) {
            d.cEk().J(str, true);
        } else {
            d.cEk().J(str, false);
        }
    }

    private void XC() {
        dq(true);
        dq(false);
    }

    private void dq(boolean z) {
        s sVar = new s();
        sVar.ds(z);
        if (this.jZx.a(sVar, z)) {
            JSONObject cEo = sVar.cEo();
            this.jZx.dp(z);
            d.cEk().bT(cEo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bT(JSONObject jSONObject) {
        if (!this.jZy.a("http://m.baidu.com", jSONObject, false)) {
            UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a cEj() {
        return this.jZw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.jZz.J(nVar.Yl());
        this.jZz.fX(nVar.Yk() * 86400000);
        this.jZz.fY(nVar.Yj());
        r.cEm().putString("ubc_version_md5", nVar.getSign());
        this.jZw.I(nVar.Yl());
        nVar.Yl().clear();
        if (this.bws == null) {
            this.bws = new SparseArray<>();
        }
        this.bws.clear();
        if (this.bwt == null) {
            this.bwt = new HashMap<>();
        }
        this.bwt.clear();
        this.jZw.a(this.bws);
        int i = 0;
        for (int i2 = 0; i2 < this.bws.size(); i2++) {
            int keyAt = this.bws.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.bwt.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.jZz.fW(i);
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
            o.lc("save to file suc");
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
    public void kM(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        o.lc("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            o.lc("delete file suc");
        }
        this.jZw.kK(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kN(String str) {
        o.lc("upload file fail");
        this.jZw.kL(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void XF() {
        this.jZw.Xs();
    }
}
