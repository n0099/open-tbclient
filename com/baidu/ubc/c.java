package com.baidu.ubc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import com.baidu.searchbox.config.AppConfig;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.codec.binary4util.bdapp.Base64InputStream;
import org.apache.commons.codec.binary4util.bdapp.Base64OutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class c {
    private static final boolean DEBUG = AppConfig.isDebug();
    private List<n> dXh;
    private long dXj;
    private long dXk;
    private int dXl;
    private SparseArray<ArrayList> dXm;
    private HashMap<String, Long> dXn;
    private Context mContext;
    private int nEi;
    private long nEj;
    private boolean nEk = false;
    private w nEl;
    private b nEm;
    private long nEn;
    private u nEo;
    private g nEp;
    private int nEq;
    private int nEr;
    private int nEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ag dTV = ag.dTV();
        this.nEl = new w(context);
        this.nEm = new b(context);
        this.nEo = ae.dTU();
        this.dXh = new ArrayList(20);
        this.dXj = dTV.getLong("ubc_last_upload_non_real", 0L);
        this.dXk = dTV.getLong("ubc_reset_real_time_count_time", 0L);
        this.nEn = dTV.getLong("ubc_last_upload_failed_data_time", 0L);
        this.dXl = dTV.getInt("ubc_real_time_count", 0);
        this.nEp = g.dTF();
        this.nEp.a(this, context);
        this.nEj = System.currentTimeMillis();
        int nextInt = new Random().nextInt(31) + 60;
        this.nEi = nextInt;
        new Timer().schedule(new TimerTask() { // from class: com.baidu.ubc.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!c.this.nEk) {
                    ah ahVar = new ah();
                    ahVar.hE(true);
                    c.this.a(ahVar, "0");
                }
            }
        }, nextInt * 1000);
    }

    private void aYK() {
        if (this.dXm == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.dXm = new SparseArray<>();
            this.nEl.b(this.dXm);
            this.dXn = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.dXm.size(); i2++) {
                int keyAt = this.dXm.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.dXn.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.nEp.mL(i);
        }
    }

    public w dTC() {
        return this.nEl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.aZk()) && this.nEp.yg(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.nEl.a(nVar);
                return;
            }
            List<String> dBc = UBC.getUBCContext().dBc();
            if (dBc == null || !dBc.contains(nVar.getId())) {
                this.nEl.a(nVar);
                return;
            } else if (!this.nEk) {
                if ((System.currentTimeMillis() - this.nEj) / 1000 >= this.nEi) {
                    this.nEk = true;
                } else {
                    this.nEl.a(nVar);
                    return;
                }
            }
        }
        if (z && !d(nVar)) {
            if (this.nEp.UN(nVar.getId())) {
                this.nEl.a(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.nEl.aYE();
        } else if (Math.abs(System.currentTimeMillis() - this.dXj) >= g.dTF().aYW()) {
            if (!z && this.nEp.UN(nVar.getId())) {
                this.dXh.add(nVar);
            }
            aYP();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.nEp.UN(nVar.getId())) {
                this.dXh.add(nVar);
            }
            if (this.dXh.size() >= 20) {
                aYL();
            }
        } else if (!z && this.nEp.UN(nVar.getId())) {
            this.nEl.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        this.nEm.a(nVar, this.nEp.yg(nVar.getId()));
    }

    private void aYL() {
        if (this.dXh != null && this.dXh.size() != 0) {
            this.nEl.aG(this.dXh);
            this.dXh.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.nEl.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, int i, String str2) {
        this.nEl.h(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> dBc;
        aYL();
        this.nEl.a(str, i, j, jSONArray);
        boolean yg = this.nEp.yg(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (yg && (dBc = UBC.getUBCContext().dBc()) != null && dBc.contains(str)) {
                if (!this.nEk) {
                    if ((System.currentTimeMillis() - this.nEj) / 1000 >= this.nEi) {
                        this.nEk = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (yg) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            aYM();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.dXj) >= g.dTF().aYW()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aYP();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(String str, int i) {
        aYL();
        this.nEl.I(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.dXj) >= g.dTF().aYW()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aYP();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(n nVar) {
        if (dN(this.mContext)) {
            nVar.UU("1");
            ah e = e(nVar);
            if (e.isEmpty()) {
                return false;
            }
            this.nEl.d(e);
            d.dTD().a(e.dTX(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.nEl.a(nVar2);
                    } else {
                        c.this.nEl.dTP();
                    }
                }
            });
            e.clearData();
            return true;
        }
        return false;
    }

    private boolean d(n nVar) {
        if (dN(this.mContext) && aYN()) {
            aYL();
            ah e = e(nVar);
            if (e != null) {
                if (this.dXm == null) {
                    aYK();
                }
                if (a(e, "0")) {
                    return true;
                }
                a(this.dXm, e);
                b(e);
                aYO();
                return true;
            }
            return false;
        }
        return false;
    }

    private ah e(n nVar) {
        ah ahVar = new ah();
        ahVar.hE(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", Long.toString(nVar.getTime()));
            if (nVar.aZn() != null) {
                jSONObject.put("content", nVar.aZn().toString());
            } else {
                jSONObject.put("content", nVar.getContent());
            }
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.aZm())) {
                jSONObject.put("abtest", nVar.aZm());
                ahVar.yx("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.aZi()) {
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
            }
            jSONObject.put("idtype", this.nEp.ym(nVar.getId()));
            jSONObject.put("isreal", this.nEp.UP(nVar.getId()) ? "1" : "0");
            String UQ = this.nEp.UQ(nVar.getId());
            if (!TextUtils.isEmpty(UQ) && !TextUtils.equals(UQ, "0")) {
                jSONObject.put("gflow", UQ);
            }
            ahVar.da(jSONObject);
            ahVar.q(nVar.getTime(), nVar.getTime());
            return ahVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void aYM() {
        if (dN(this.mContext) && aYN()) {
            ah ahVar = new ah();
            ahVar.hE(true);
            if (this.dXm == null) {
                aYK();
            }
            if (!a(ahVar, "1")) {
                a(this.dXm, ahVar);
                b(ahVar);
                aYO();
            }
        }
    }

    private void a(SparseArray<ArrayList> sparseArray, ah ahVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size() && !ahVar.mU(com.baidu.fsg.base.statistics.b.c)) {
                this.nEl.a(sparseArray.valueAt(i2), ahVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean aYN() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.dXk) > 86400000) {
            this.dXl = 0;
            this.dXk = currentTimeMillis;
            ag.dTV().putLong("ubc_reset_real_time_count_time", this.dXk);
            ag.dTV().putInt("ubc_real_time_count", this.dXl);
        }
        if (this.dXl >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.dXl == 10000) {
                this.dXl++;
                if (!DEBUG) {
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
                }
            }
            return false;
        }
        return true;
    }

    private void aYO() {
        this.dXl++;
        ag.dTV().putInt("ubc_real_time_count", this.dXl);
    }

    private void aYP() {
        if (dN(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.dXj = System.currentTimeMillis();
            ag.dTV().putLong("ubc_last_upload_non_real", this.dXj);
            aYR();
            aYL();
            this.nEl.aYE();
            HashSet hashSet = new HashSet();
            if (this.dXm == null) {
                aYK();
            }
            ah ahVar = new ah();
            ahVar.hE(false);
            int i = 0;
            for (int i2 = 0; i2 < this.dXm.size(); i2++) {
                int keyAt = this.dXm.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.dXn.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.nEp.aYW()) {
                        i |= this.nEl.a(this.dXm.valueAt(i2), ahVar);
                        this.dXn.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.dXm.size(); i3++) {
                    int keyAt2 = this.dXm.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ahVar.mU(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.nEl.a(this.dXm.valueAt(i3), ahVar);
                    }
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "UBC non real time:");
                }
                b(ahVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uploadLocalDatas() {
        if (dN(this.mContext)) {
            this.nEl.aYE();
            ah ahVar = new ah();
            if (this.nEl.c(ahVar) != 0) {
                ah ahVar2 = new ah();
                ahVar2.q(ahVar.aZN(), ahVar.getMaxTime());
                ahVar2.yx(ahVar.aZM());
                ahVar2.hE(true);
                ah ahVar3 = new ah();
                ahVar3.q(ahVar.aZN(), ahVar.getMaxTime());
                ahVar3.yx(ahVar.aZM());
                ahVar3.hE(false);
                SparseArray<Integer> aZJ = ahVar.aZJ();
                int size = aZJ.size();
                for (int i = 0; i < size; i++) {
                    if (this.nEp.yg(String.valueOf(aZJ.valueAt(i).intValue()))) {
                        ahVar2.aE(aZJ.keyAt(i), aZJ.valueAt(i).intValue());
                    } else {
                        ahVar3.aE(aZJ.keyAt(i), aZJ.valueAt(i).intValue());
                    }
                }
                ArrayList aZK = ahVar.aZK();
                int size2 = aZK.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aZK.get(i2);
                    if (this.nEp.yg(str)) {
                        ahVar2.yw(str);
                    } else {
                        ahVar3.yw(str);
                    }
                }
                JSONArray aZO = ahVar.aZO();
                int length = aZO.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = aZO.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.nEp.yg(str2)) {
                                ahVar2.da(optJSONObject);
                            } else {
                                ahVar3.da(optJSONObject);
                            }
                        }
                    }
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "total " + ahVar.aZO().length() + " real size = " + ahVar2.aZO().length() + "   no real  = " + ahVar3.aZO().length());
                }
                if (ahVar2.aZO().length() > 0) {
                    b(ahVar2);
                }
                if (ahVar3.aZO().length() > 0) {
                    b(ahVar3);
                }
            }
        }
    }

    private void b(ah ahVar) {
        if (!ahVar.isEmpty()) {
            try {
                JSONObject dTX = ahVar.dTX();
                String md5 = af.toMd5(dTX.toString().getBytes(), true);
                dp(dTX.toString(), md5);
                if (DEBUG) {
                    y.e(ahVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.nEl.a(ahVar.aZJ(), ahVar.aZK(), ahVar.aZP(), md5)) {
                    ahVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.nEl.yb(md5);
                    return;
                }
                d.dTD().E(dTX, md5);
                ahVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.nEn) >= 7200000) {
                    this.nEn = currentTimeMillis;
                    ag.dTV().putLong("ubc_last_upload_failed_data_time", this.nEn);
                    d.dTD().aYT();
                }
            } catch (OutOfMemoryError e) {
                ahVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean i = this.nEo.i(jSONObject, z);
        if (tVar != null) {
            tVar.a(i, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.dTD().as(str, i);
        }
    }

    private void aYR() {
        hB(true);
        hB(false);
    }

    private void hB(boolean z) {
        ah ahVar = new ah();
        ahVar.hE(z);
        if (this.nEm.a(ahVar, z)) {
            JSONObject dTX = ahVar.dTX();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + dTX.toString());
            }
            this.nEm.hA(z);
            d.dTD().er(dTX);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        JSONArray jSONArray = new JSONArray();
        this.nEq = 0;
        this.nEr = 0;
        this.nEs = 0;
        String dTM = vVar.dTM();
        if (dTM == null || TextUtils.equals(dTM, "1")) {
        }
        b(vVar, z, jSONArray);
        a(vVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.nEq + this.nEr + this.nEs), Integer.valueOf(this.nEq), Integer.valueOf(this.nEs)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.nEp.aI(vVar.aZB());
        int aZA = vVar.aZA();
        if (aZA > 0) {
            this.nEp.mM(aZA * 86400000);
        }
        if (vVar.aZz() > 0) {
            this.nEp.mN(vVar.aZz());
        }
        if (this.dXm == null) {
            this.dXm = new SparseArray<>();
        }
        this.dXm.clear();
        if (this.dXn == null) {
            this.dXn = new HashMap<>();
        }
        this.dXn.clear();
        this.nEl.b(this.dXm);
        int i = 0;
        for (int i2 = 0; i2 < this.dXm.size(); i2++) {
            int keyAt = this.dXm.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.dXn.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.nEp.mL(i);
        vVar.aZB().clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (android.text.TextUtils.equals(r7.dTI(), "1") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (android.text.TextUtils.equals(r0.dTI(), "1") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r5.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(v vVar, boolean z, JSONArray jSONArray) {
        List<k> aZB = vVar.aZB();
        if (aZB != null && aZB.size() > 0) {
            ArrayList arrayList = new ArrayList(aZB);
            Iterator<k> it = aZB.iterator();
            while (it.hasNext()) {
                k next = it.next();
                k UX = this.nEl.UX(next.getId());
                String version = next.getVersion();
                String str = "0";
                if (UX != null) {
                    str = UX.getVersion();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(version);
                    if (z && str != null && version != null && z2) {
                        arrayList.remove(next);
                        jSONObject.put("product", String.format("set/%s", next.getId()));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", version);
                        jSONArray.put(jSONObject);
                        this.nEs++;
                    } else {
                        boolean a2 = this.nEl.a(next);
                        jSONObject.put("product", String.format("set/%s", next.getId()));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        jSONObject.put("version", version);
                        if (!a2) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.nEr++;
                        } else {
                            this.nEq++;
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (NumberFormatException e) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "数据转换失败");
                    }
                } catch (JSONException e2) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "Json格式转化失败");
                    }
                }
            }
            vVar.eU(arrayList);
        }
    }

    void b(v vVar, boolean z, JSONArray jSONArray) {
        String str;
        JSONObject dTO = vVar.dTO();
        if (dTO != null) {
            Iterator<String> keys = dTO.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k UX = this.nEl.UX(next);
                    String optString = dTO.optString(next, "0");
                    if (UX == null) {
                        str = "0";
                    } else {
                        str = UX.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.nEs++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.nEl.UY(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.nEr++;
                        } else {
                            this.nEq++;
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    private boolean dN(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "get network info error!");
            }
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isAvailable();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1175=4] */
    private void dp(String str, String str2) {
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
            y.yv("save to file suc");
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
    public void yd(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        y.yv("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            y.yv("delete file suc");
        }
        this.nEl.yb(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ye(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        y.yv("upload file fail");
        this.nEl.yc(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aYT() {
        File[] listFiles;
        if (dN(this.mContext)) {
            File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 1000) {
                    if (!DEBUG) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "del_file");
                            jSONObject.put("del_file_size", listFiles.length);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                    }
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.nEl.aYF();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o UZ = this.nEl.UZ(listFiles[i].getName());
                    if (UZ != null && TextUtils.equals("0", UZ.aZq())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        y.yv("processFailedData file, no need to send");
                    } else if (UZ != null && TextUtils.equals("1", UZ.aZq())) {
                        y.yv("processFailedData file, send");
                        this.nEl.m43do(listFiles[i].getName(), "0");
                        yf(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        y.yv("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1333=5, 1335=4, 1336=4, 1337=4] */
    void yf(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        InputStream inputStream = null;
        try {
            try {
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "uploadFile fileName:" + str);
                }
                InputStream fileInputStream = new FileInputStream(file);
                if (fileInputStream != null) {
                    try {
                        if (fileInputStream.available() > 0) {
                            inputStream = new Base64InputStream(fileInputStream, 0);
                            JSONObject jSONObject = new JSONObject(StringUtil.getStringFromInput(inputStream));
                            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
                            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
                            jSONObject.put("metadata", jSONObject2);
                            d.dTD().E(jSONObject, str);
                            fileInputStream = inputStream;
                        }
                    } catch (Exception e) {
                        e = e;
                        inputStream = fileInputStream;
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "error:" + e.getMessage());
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                        return;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        inputStream = fileInputStream;
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "OutOfMemoryError:" + e.getMessage());
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return;
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = fileInputStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e7) {
            e = e7;
        } catch (OutOfMemoryError e8) {
            e = e8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aYU() {
        this.nEl.aYG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ah ahVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> dBc = UBC.getUBCContext().dBc();
            if (dBc == null || dBc.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= dBc.size()) {
                    break;
                }
                arrayList.add(new j(dBc.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.nEl.a(arrayList, ahVar);
            b(ahVar);
            aYO();
            return true;
        }
        return false;
    }

    public String getUploadType(String str) {
        return this.nEp != null ? this.nEp.getUploadType(str) : "";
    }
}
