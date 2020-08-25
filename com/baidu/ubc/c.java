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
    private List<n> dIY;
    private long dIZ;
    private long dJa;
    private long dJb;
    private int dJc;
    private SparseArray<ArrayList> dJd;
    private HashMap<String, Long> dJe;
    private Context mContext;
    private b neA;
    private long neB;
    private u neC;
    private g neD;
    private int neE;
    private int neF;
    private int neG;

    /* renamed from: new  reason: not valid java name */
    private int f7new;
    private long nex;
    private boolean ney = false;
    private w nez;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ag dMd = ag.dMd();
        this.nez = new w(context);
        this.neA = new b(context);
        this.neC = ae.dMc();
        this.dIY = new ArrayList(20);
        this.dIZ = dMd.getLong("ubc_last_upload_all_time", 0L);
        this.dJa = dMd.getLong("ubc_last_upload_non_real", 0L);
        this.dJb = dMd.getLong("ubc_reset_real_time_count_time", 0L);
        this.neB = dMd.getLong("ubc_last_upload_failed_data_time", 0L);
        this.dJc = dMd.getInt("ubc_real_time_count", 0);
        this.neD = g.dLN();
        this.neD.a(this, context);
        this.nex = System.currentTimeMillis();
        int nextInt = new Random().nextInt(31) + 60;
        this.f7new = nextInt;
        new Timer().schedule(new TimerTask() { // from class: com.baidu.ubc.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!c.this.ney) {
                    ah ahVar = new ah();
                    ahVar.hj(true);
                    c.this.a(ahVar, "0");
                }
            }
        }, nextInt * 1000);
    }

    private void aVq() {
        if (this.dJd == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.dJd = new SparseArray<>();
            this.nez.b(this.dJd);
            this.dJe = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.dJd.size(); i2++) {
                int keyAt = this.dJd.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.dJe.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.neD.md(i);
        }
    }

    public w dLK() {
        return this.nez;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.aVQ()) && this.neD.xa(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.nez.a(nVar);
                return;
            }
            List<String> dtt = UBC.getUBCContext().dtt();
            if (dtt == null || !dtt.contains(nVar.getId())) {
                this.nez.a(nVar);
                return;
            } else if (!this.ney) {
                if ((System.currentTimeMillis() - this.nex) / 1000 >= this.f7new) {
                    this.ney = true;
                } else {
                    this.nez.a(nVar);
                    return;
                }
            }
        }
        if (z && !d(nVar)) {
            if (this.neD.Tz(nVar.getId())) {
                this.nez.a(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.nez.aVk();
        } else if (Math.abs(System.currentTimeMillis() - this.dJa) >= g.dLN().aVC()) {
            if (!z && this.neD.Tz(nVar.getId())) {
                this.dIY.add(nVar);
            }
            aVv();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.neD.Tz(nVar.getId())) {
                this.dIY.add(nVar);
            }
            if (this.dIY.size() >= 20) {
                aVr();
            }
        } else if (!z && this.neD.Tz(nVar.getId())) {
            this.nez.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        this.neA.a(nVar, this.neD.xa(nVar.getId()));
    }

    private void aVr() {
        if (this.dIY != null && this.dIY.size() != 0) {
            this.nez.az(this.dIY);
            this.dIY.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.nez.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.nez.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> dtt;
        aVr();
        this.nez.a(str, i, j, jSONArray);
        boolean xa = this.neD.xa(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (xa && (dtt = UBC.getUBCContext().dtt()) != null && dtt.contains(str)) {
                if (!this.ney) {
                    if ((System.currentTimeMillis() - this.nex) / 1000 >= this.f7new) {
                        this.ney = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (xa) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            aVs();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.dJa) >= g.dLN().aVC()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aVv();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(String str, int i) {
        aVr();
        this.nez.H(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.dJa) >= g.dLN().aVC()) {
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
            this.nez.d(e);
            d.dLL().a(e.dMf(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.nez.a(nVar2);
                    } else {
                        c.this.nez.dLX();
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
                if (this.dJd == null) {
                    aVq();
                }
                if (a(e, "0")) {
                    return true;
                }
                a(this.dJd, e);
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
        ahVar.hj(true);
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
                ahVar.xr("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.aVO()) {
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
            }
            jSONObject.put("idtype", this.neD.xg(nVar.getId()));
            jSONObject.put("isreal", this.neD.TB(nVar.getId()) ? "1" : "0");
            String TC = this.neD.TC(nVar.getId());
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
            ahVar.hj(true);
            if (this.dJd == null) {
                aVq();
            }
            if (!a(ahVar, "1")) {
                a(this.dJd, ahVar);
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
                this.nez.a(sparseArray.valueAt(i2), ahVar);
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
        if (Math.abs(currentTimeMillis - this.dJb) > 86400000) {
            this.dJc = 0;
            this.dJb = currentTimeMillis;
            ag.dMd().putLong("ubc_reset_real_time_count_time", this.dJb);
            ag.dMd().putInt("ubc_real_time_count", this.dJc);
        }
        if (this.dJc >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.dJc == 10000) {
                this.dJc++;
                if (!DEBUG) {
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
                }
            }
            return false;
        }
        return true;
    }

    private void aVu() {
        this.dJc++;
        ag.dMd().putInt("ubc_real_time_count", this.dJc);
    }

    private void aVv() {
        if (dI(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.dJa = System.currentTimeMillis();
            ag.dMd().putLong("ubc_last_upload_non_real", this.dJa);
            aVx();
            aVr();
            this.nez.aVk();
            HashSet hashSet = new HashSet();
            if (this.dJd == null) {
                aVq();
            }
            ah ahVar = new ah();
            ahVar.hj(false);
            int i = 0;
            for (int i2 = 0; i2 < this.dJd.size(); i2++) {
                int keyAt = this.dJd.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.dJe.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.neD.aVC()) {
                        i |= this.nez.a(this.dJd.valueAt(i2), ahVar);
                        this.dJe.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.dJd.size(); i3++) {
                    int keyAt2 = this.dJd.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ahVar.mm(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.nez.a(this.dJd.valueAt(i3), ahVar);
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
        if (dI(this.mContext) && Math.abs(System.currentTimeMillis() - this.dIZ) >= BdKVCache.MILLS_1Hour) {
            this.nez.aVk();
            ah ahVar = new ah();
            if (this.nez.c(ahVar) != 0) {
                ah ahVar2 = new ah();
                ahVar2.u(ahVar.aWt(), ahVar.getMaxTime());
                ahVar2.xr(ahVar.aWs());
                ahVar2.hj(true);
                ah ahVar3 = new ah();
                ahVar3.u(ahVar.aWt(), ahVar.getMaxTime());
                ahVar3.xr(ahVar.aWs());
                ahVar3.hj(false);
                SparseArray<Integer> aWp = ahVar.aWp();
                int size = aWp.size();
                for (int i = 0; i < size; i++) {
                    if (this.neD.xa(String.valueOf(aWp.valueAt(i).intValue()))) {
                        ahVar2.aF(aWp.keyAt(i), aWp.valueAt(i).intValue());
                    } else {
                        ahVar3.aF(aWp.keyAt(i), aWp.valueAt(i).intValue());
                    }
                }
                ArrayList aWq = ahVar.aWq();
                int size2 = aWq.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aWq.get(i2);
                    if (this.neD.xa(str)) {
                        ahVar2.xq(str);
                    } else {
                        ahVar3.xq(str);
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
                            if (this.neD.xa(str2)) {
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
                this.dIZ = System.currentTimeMillis();
                ag.dMd().putLong("ubc_last_upload_all_time", this.dIZ);
                this.dJa = this.dIZ;
                ag.dMd().putLong("ubc_last_upload_non_real", this.dJa);
            }
        }
    }

    private void b(ah ahVar) {
        if (!ahVar.isEmpty()) {
            try {
                JSONObject dMf = ahVar.dMf();
                String md5 = af.toMd5(dMf.toString().getBytes(), true);
                dk(dMf.toString(), md5);
                if (DEBUG) {
                    y.e(ahVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.nez.a(ahVar.aWp(), ahVar.aWq(), ahVar.aWv(), md5)) {
                    ahVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.nez.wV(md5);
                    return;
                }
                d.dLL().E(dMf, md5);
                ahVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.neB) >= 7200000) {
                    this.neB = currentTimeMillis;
                    ag.dMd().putLong("ubc_last_upload_failed_data_time", this.neB);
                    d.dLL().aVz();
                }
            } catch (OutOfMemoryError e) {
                ahVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean i = this.neC.i(jSONObject, z);
        if (tVar != null) {
            tVar.a(i, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.dLL().ao(str, i);
        }
    }

    private void aVx() {
        hg(true);
        hg(false);
    }

    private void hg(boolean z) {
        ah ahVar = new ah();
        ahVar.hj(z);
        if (this.neA.a(ahVar, z)) {
            JSONObject dMf = ahVar.dMf();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + dMf.toString());
            }
            this.neA.hf(z);
            d.dLL().ef(dMf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        JSONArray jSONArray = new JSONArray();
        this.neE = 0;
        this.neF = 0;
        this.neG = 0;
        String dLT = vVar.dLT();
        if (dLT == null || TextUtils.equals(dLT, "1")) {
        }
        b(vVar, z, jSONArray);
        a(vVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.neE + this.neF + this.neG), Integer.valueOf(this.neE), Integer.valueOf(this.neG)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.neD.aB(vVar.aWh());
        int aWg = vVar.aWg();
        if (aWg > 0) {
            this.neD.me(aWg * 86400000);
        }
        if (vVar.aWf() > 0) {
            this.neD.mf(vVar.aWf());
        }
        if (this.dJd == null) {
            this.dJd = new SparseArray<>();
        }
        this.dJd.clear();
        if (this.dJe == null) {
            this.dJe = new HashMap<>();
        }
        this.dJe.clear();
        this.nez.b(this.dJd);
        int i = 0;
        for (int i2 = 0; i2 < this.dJd.size(); i2++) {
            int keyAt = this.dJd.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.dJe.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.neD.md(i);
        vVar.aWh().clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (android.text.TextUtils.equals(r7.dLQ(), "1") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (android.text.TextUtils.equals(r0.dLQ(), "1") == false) goto L28;
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
                k TH = this.nez.TH(next.getId());
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
                        this.neG++;
                    } else {
                        boolean a = this.nez.a(next);
                        jSONObject.put("product", String.format("set/%s", next.getId()));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        jSONObject.put("version", version);
                        if (!a) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.neF++;
                        } else {
                            this.neE++;
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
        JSONObject dLV = vVar.dLV();
        if (dLV != null) {
            Iterator<String> keys = dLV.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k TH = this.nez.TH(next);
                    String optString = dLV.optString(next, "0");
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
                        this.neG++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.nez.TI(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.neF++;
                        } else {
                            this.neE++;
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
            y.xp("save to file suc");
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
    public void wX(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        y.xp("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            y.xp("delete file suc");
        }
        this.nez.wV(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wY(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        y.xp("upload file fail");
        this.nez.wW(str);
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
                    this.nez.aVl();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o TJ = this.nez.TJ(listFiles[i].getName());
                    if (TJ != null && TextUtils.equals("0", TJ.aVW())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        y.xp("processFailedData file, no need to send");
                    } else if (TJ != null && TextUtils.equals("1", TJ.aVW())) {
                        y.xp("processFailedData file, send");
                        this.nez.dj(listFiles[i].getName(), "0");
                        wZ(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        y.xp("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1361=5, 1363=4, 1364=4, 1365=4] */
    void wZ(String str) {
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
                            d.dLL().E(jSONObject, str);
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
        this.nez.aVm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ah ahVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> dtt = UBC.getUBCContext().dtt();
            if (dtt == null || dtt.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= dtt.size()) {
                    break;
                }
                arrayList.add(new j(dtt.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.nez.a(arrayList, ahVar);
            b(ahVar);
            aVu();
            return true;
        }
        return false;
    }
}
