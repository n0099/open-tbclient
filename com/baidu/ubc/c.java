package com.baidu.ubc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.live.adp.lib.cache.BdKVCache;
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
/* loaded from: classes18.dex */
public class c {
    private static final boolean DEBUG = AppConfig.isDebug();
    private List<n> dJc;
    private long dJd;
    private long dJe;
    private long dJf;
    private int dJg;
    private SparseArray<ArrayList> dJh;
    private HashMap<String, Long> dJi;
    private Context mContext;
    private int neO;
    private long neP;
    private boolean neQ = false;
    private w neR;
    private b neS;
    private long neT;
    private u neU;
    private g neV;
    private int neW;
    private int neX;
    private int neY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ag dMm = ag.dMm();
        this.neR = new w(context);
        this.neS = new b(context);
        this.neU = ae.dMl();
        this.dJc = new ArrayList(20);
        this.dJd = dMm.getLong("ubc_last_upload_all_time", 0L);
        this.dJe = dMm.getLong("ubc_last_upload_non_real", 0L);
        this.dJf = dMm.getLong("ubc_reset_real_time_count_time", 0L);
        this.neT = dMm.getLong("ubc_last_upload_failed_data_time", 0L);
        this.dJg = dMm.getInt("ubc_real_time_count", 0);
        this.neV = g.dLW();
        this.neV.a(this, context);
        this.neP = System.currentTimeMillis();
        int nextInt = new Random().nextInt(31) + 60;
        this.neO = nextInt;
        new Timer().schedule(new TimerTask() { // from class: com.baidu.ubc.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!c.this.neQ) {
                    ah ahVar = new ah();
                    ahVar.hk(true);
                    c.this.a(ahVar, "0");
                }
            }
        }, nextInt * 1000);
    }

    private void aVq() {
        if (this.dJh == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.dJh = new SparseArray<>();
            this.neR.b(this.dJh);
            this.dJi = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.dJh.size(); i2++) {
                int keyAt = this.dJh.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.dJi.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.neV.md(i);
        }
    }

    public w dLT() {
        return this.neR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.aVQ()) && this.neV.xb(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.neR.a(nVar);
                return;
            }
            List<String> dty = UBC.getUBCContext().dty();
            if (dty == null || !dty.contains(nVar.getId())) {
                this.neR.a(nVar);
                return;
            } else if (!this.neQ) {
                if ((System.currentTimeMillis() - this.neP) / 1000 >= this.neO) {
                    this.neQ = true;
                } else {
                    this.neR.a(nVar);
                    return;
                }
            }
        }
        if (z && !d(nVar)) {
            if (this.neV.Tz(nVar.getId())) {
                this.neR.a(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.neR.aVk();
        } else if (Math.abs(System.currentTimeMillis() - this.dJe) >= g.dLW().aVC()) {
            if (!z && this.neV.Tz(nVar.getId())) {
                this.dJc.add(nVar);
            }
            aVv();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.neV.Tz(nVar.getId())) {
                this.dJc.add(nVar);
            }
            if (this.dJc.size() >= 20) {
                aVr();
            }
        } else if (!z && this.neV.Tz(nVar.getId())) {
            this.neR.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        this.neS.a(nVar, this.neV.xb(nVar.getId()));
    }

    private void aVr() {
        if (this.dJc != null && this.dJc.size() != 0) {
            this.neR.az(this.dJc);
            this.dJc.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.neR.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.neR.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> dty;
        aVr();
        this.neR.a(str, i, j, jSONArray);
        boolean xb = this.neV.xb(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (xb && (dty = UBC.getUBCContext().dty()) != null && dty.contains(str)) {
                if (!this.neQ) {
                    if ((System.currentTimeMillis() - this.neP) / 1000 >= this.neO) {
                        this.neQ = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (xb) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            aVs();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.dJe) >= g.dLW().aVC()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aVv();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(String str, int i) {
        aVr();
        this.neR.H(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.dJe) >= g.dLW().aVC()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aVv();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(n nVar) {
        if (dI(this.mContext)) {
            nVar.TF("1");
            ah e = e(nVar);
            if (e.isEmpty()) {
                return false;
            }
            this.neR.d(e);
            d.dLU().a(e.dMo(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.neR.a(nVar2);
                    } else {
                        c.this.neR.dMg();
                    }
                }
            });
            e.clearData();
            return true;
        }
        return false;
    }

    private boolean d(n nVar) {
        if (dI(this.mContext) && aVt()) {
            aVr();
            ah e = e(nVar);
            if (e != null) {
                if (this.dJh == null) {
                    aVq();
                }
                if (a(e, "0")) {
                    return true;
                }
                a(this.dJh, e);
                b(e);
                aVu();
                return true;
            }
            return false;
        }
        return false;
    }

    private ah e(n nVar) {
        ah ahVar = new ah();
        ahVar.hk(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", Long.toString(nVar.getTime()));
            if (nVar.aVT() != null) {
                jSONObject.put("content", nVar.aVT().toString());
            } else {
                jSONObject.put("content", nVar.getContent());
            }
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.aVS())) {
                jSONObject.put("abtest", nVar.aVS());
                ahVar.xs("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.aVO()) {
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
            }
            jSONObject.put("idtype", this.neV.xh(nVar.getId()));
            jSONObject.put("isreal", this.neV.TB(nVar.getId()) ? "1" : "0");
            String TC = this.neV.TC(nVar.getId());
            if (!TextUtils.isEmpty(TC) && !TextUtils.equals(TC, "0")) {
                jSONObject.put("gflow", TC);
            }
            ahVar.cQ(jSONObject);
            ahVar.u(nVar.getTime(), nVar.getTime());
            return ahVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void aVs() {
        if (dI(this.mContext) && aVt()) {
            ah ahVar = new ah();
            ahVar.hk(true);
            if (this.dJh == null) {
                aVq();
            }
            if (!a(ahVar, "1")) {
                a(this.dJh, ahVar);
                b(ahVar);
                aVu();
            }
        }
    }

    private void a(SparseArray<ArrayList> sparseArray, ah ahVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size() && !ahVar.mm(com.baidu.fsg.base.statistics.b.c)) {
                this.neR.a(sparseArray.valueAt(i2), ahVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean aVt() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.dJf) > 86400000) {
            this.dJg = 0;
            this.dJf = currentTimeMillis;
            ag.dMm().putLong("ubc_reset_real_time_count_time", this.dJf);
            ag.dMm().putInt("ubc_real_time_count", this.dJg);
        }
        if (this.dJg >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.dJg == 10000) {
                this.dJg++;
                if (!DEBUG) {
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
                }
            }
            return false;
        }
        return true;
    }

    private void aVu() {
        this.dJg++;
        ag.dMm().putInt("ubc_real_time_count", this.dJg);
    }

    private void aVv() {
        if (dI(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.dJe = System.currentTimeMillis();
            ag.dMm().putLong("ubc_last_upload_non_real", this.dJe);
            aVx();
            aVr();
            this.neR.aVk();
            HashSet hashSet = new HashSet();
            if (this.dJh == null) {
                aVq();
            }
            ah ahVar = new ah();
            ahVar.hk(false);
            int i = 0;
            for (int i2 = 0; i2 < this.dJh.size(); i2++) {
                int keyAt = this.dJh.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.dJi.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.neV.aVC()) {
                        i |= this.neR.a(this.dJh.valueAt(i2), ahVar);
                        this.dJi.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.dJh.size(); i3++) {
                    int keyAt2 = this.dJh.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ahVar.mm(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.neR.a(this.dJh.valueAt(i3), ahVar);
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
    public void aVw() {
        if (dI(this.mContext) && Math.abs(System.currentTimeMillis() - this.dJd) >= BdKVCache.MILLS_1Hour) {
            this.neR.aVk();
            ah ahVar = new ah();
            if (this.neR.c(ahVar) != 0) {
                ah ahVar2 = new ah();
                ahVar2.u(ahVar.aWt(), ahVar.getMaxTime());
                ahVar2.xs(ahVar.aWs());
                ahVar2.hk(true);
                ah ahVar3 = new ah();
                ahVar3.u(ahVar.aWt(), ahVar.getMaxTime());
                ahVar3.xs(ahVar.aWs());
                ahVar3.hk(false);
                SparseArray<Integer> aWp = ahVar.aWp();
                int size = aWp.size();
                for (int i = 0; i < size; i++) {
                    if (this.neV.xb(String.valueOf(aWp.valueAt(i).intValue()))) {
                        ahVar2.aF(aWp.keyAt(i), aWp.valueAt(i).intValue());
                    } else {
                        ahVar3.aF(aWp.keyAt(i), aWp.valueAt(i).intValue());
                    }
                }
                ArrayList aWq = ahVar.aWq();
                int size2 = aWq.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aWq.get(i2);
                    if (this.neV.xb(str)) {
                        ahVar2.xr(str);
                    } else {
                        ahVar3.xr(str);
                    }
                }
                JSONArray aWu = ahVar.aWu();
                int length = aWu.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = aWu.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.neV.xb(str2)) {
                                ahVar2.cQ(optJSONObject);
                            } else {
                                ahVar3.cQ(optJSONObject);
                            }
                        }
                    }
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "total " + ahVar.aWu().length() + " real size = " + ahVar2.aWu().length() + "   no real  = " + ahVar3.aWu().length());
                }
                if (ahVar2.aWu().length() > 0) {
                    b(ahVar2);
                }
                if (ahVar3.aWu().length() > 0) {
                    b(ahVar3);
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "UBC all data:");
                }
                this.dJd = System.currentTimeMillis();
                ag.dMm().putLong("ubc_last_upload_all_time", this.dJd);
                this.dJe = this.dJd;
                ag.dMm().putLong("ubc_last_upload_non_real", this.dJe);
            }
        }
    }

    private void b(ah ahVar) {
        if (!ahVar.isEmpty()) {
            try {
                JSONObject dMo = ahVar.dMo();
                String md5 = af.toMd5(dMo.toString().getBytes(), true);
                dk(dMo.toString(), md5);
                if (DEBUG) {
                    y.e(ahVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.neR.a(ahVar.aWp(), ahVar.aWq(), ahVar.aWv(), md5)) {
                    ahVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.neR.wW(md5);
                    return;
                }
                d.dLU().E(dMo, md5);
                ahVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.neT) >= 7200000) {
                    this.neT = currentTimeMillis;
                    ag.dMm().putLong("ubc_last_upload_failed_data_time", this.neT);
                    d.dLU().aVz();
                }
            } catch (OutOfMemoryError e) {
                ahVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean i = this.neU.i(jSONObject, z);
        if (tVar != null) {
            tVar.a(i, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.dLU().ao(str, i);
        }
    }

    private void aVx() {
        hh(true);
        hh(false);
    }

    private void hh(boolean z) {
        ah ahVar = new ah();
        ahVar.hk(z);
        if (this.neS.a(ahVar, z)) {
            JSONObject dMo = ahVar.dMo();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + dMo.toString());
            }
            this.neS.hg(z);
            d.dLU().ef(dMo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        JSONArray jSONArray = new JSONArray();
        this.neW = 0;
        this.neX = 0;
        this.neY = 0;
        String dMc = vVar.dMc();
        if (dMc == null || TextUtils.equals(dMc, "1")) {
        }
        b(vVar, z, jSONArray);
        a(vVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.neW + this.neX + this.neY), Integer.valueOf(this.neW), Integer.valueOf(this.neY)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.neV.aB(vVar.aWh());
        int aWg = vVar.aWg();
        if (aWg > 0) {
            this.neV.me(aWg * 86400000);
        }
        if (vVar.aWf() > 0) {
            this.neV.mf(vVar.aWf());
        }
        if (this.dJh == null) {
            this.dJh = new SparseArray<>();
        }
        this.dJh.clear();
        if (this.dJi == null) {
            this.dJi = new HashMap<>();
        }
        this.dJi.clear();
        this.neR.b(this.dJh);
        int i = 0;
        for (int i2 = 0; i2 < this.dJh.size(); i2++) {
            int keyAt = this.dJh.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.dJi.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.neV.md(i);
        vVar.aWh().clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (android.text.TextUtils.equals(r7.dLZ(), "1") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (android.text.TextUtils.equals(r0.dLZ(), "1") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r5.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(v vVar, boolean z, JSONArray jSONArray) {
        List<k> aWh = vVar.aWh();
        if (aWh != null && aWh.size() > 0) {
            ArrayList arrayList = new ArrayList(aWh);
            Iterator<k> it = aWh.iterator();
            while (it.hasNext()) {
                k next = it.next();
                k TH = this.neR.TH(next.getId());
                String version = next.getVersion();
                String str = "0";
                if (TH != null) {
                    str = TH.getVersion();
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
                        this.neY++;
                    } else {
                        boolean a = this.neR.a(next);
                        jSONObject.put("product", String.format("set/%s", next.getId()));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        jSONObject.put("version", version);
                        if (!a) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.neX++;
                        } else {
                            this.neW++;
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
            vVar.eJ(arrayList);
        }
    }

    void b(v vVar, boolean z, JSONArray jSONArray) {
        String str;
        JSONObject dMe = vVar.dMe();
        if (dMe != null) {
            Iterator<String> keys = dMe.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k TH = this.neR.TH(next);
                    String optString = dMe.optString(next, "0");
                    if (TH == null) {
                        str = "0";
                    } else {
                        str = TH.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.neY++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.neR.TI(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.neX++;
                        } else {
                            this.neW++;
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
    private boolean dI(Context context) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1203=4] */
    private void dk(String str, String str2) {
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
            y.xq("save to file suc");
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
    public void wY(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        y.xq("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            y.xq("delete file suc");
        }
        this.neR.wW(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wZ(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        y.xq("upload file fail");
        this.neR.wX(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVz() {
        File[] listFiles;
        if (dI(this.mContext)) {
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
                    this.neR.aVl();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o TJ = this.neR.TJ(listFiles[i].getName());
                    if (TJ != null && TextUtils.equals("0", TJ.aVW())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        y.xq("processFailedData file, no need to send");
                    } else if (TJ != null && TextUtils.equals("1", TJ.aVW())) {
                        y.xq("processFailedData file, send");
                        this.neR.dj(listFiles[i].getName(), "0");
                        xa(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        y.xq("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1361=5, 1363=4, 1364=4, 1365=4] */
    void xa(String str) {
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
                            d.dLU().E(jSONObject, str);
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
    public void aVA() {
        this.neR.aVm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ah ahVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> dty = UBC.getUBCContext().dty();
            if (dty == null || dty.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= dty.size()) {
                    break;
                }
                arrayList.add(new j(dty.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.neR.a(arrayList, ahVar);
            b(ahVar);
            aVu();
            return true;
        }
        return false;
    }
}
