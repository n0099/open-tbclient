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
/* loaded from: classes13.dex */
public class c {
    private static final boolean DEBUG = AppConfig.isDebug();
    private List<n> dpo;
    private long dpp;
    private long dpq;
    private long dpr;
    private int dps;
    private SparseArray<ArrayList> dpt;
    private HashMap<String, Long> dpu;
    private Context mContext;
    private int mgm;
    private long mgn;
    private boolean mgo = false;
    private w mgp;
    private b mgq;
    private long mgr;
    private u mgs;
    private g mgt;
    private int mgu;
    private int mgv;
    private int mgw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ag dsf = ag.dsf();
        this.mgp = new w(context);
        this.mgq = new b(context);
        this.mgs = ae.dse();
        this.dpo = new ArrayList(20);
        this.dpp = dsf.getLong("ubc_last_upload_all_time", 0L);
        this.dpq = dsf.getLong("ubc_last_upload_non_real", 0L);
        this.dpr = dsf.getLong("ubc_reset_real_time_count_time", 0L);
        this.mgr = dsf.getLong("ubc_last_upload_failed_data_time", 0L);
        this.dps = dsf.getInt("ubc_real_time_count", 0);
        this.mgt = g.drP();
        this.mgt.a(this, context);
        this.mgn = System.currentTimeMillis();
        int nextInt = new Random().nextInt(31) + 60;
        this.mgm = nextInt;
        new Timer().schedule(new TimerTask() { // from class: com.baidu.ubc.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!c.this.mgo) {
                    ah ahVar = new ah();
                    ahVar.gp(true);
                    c.this.a(ahVar, "0");
                }
            }
        }, nextInt * 1000);
    }

    private void aHS() {
        if (this.dpt == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.dpt = new SparseArray<>();
            this.mgp.b(this.dpt);
            this.dpu = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.dpt.size(); i2++) {
                int keyAt = this.dpt.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.dpu.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.mgt.jr(i);
        }
    }

    public w drM() {
        return this.mgp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.aIs()) && this.mgt.tE(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.mgp.a(nVar);
                return;
            }
            List<String> dai = UBC.getUBCContext().dai();
            if (dai == null || !dai.contains(nVar.getId())) {
                this.mgp.a(nVar);
                return;
            } else if (!this.mgo) {
                if ((System.currentTimeMillis() - this.mgn) / 1000 >= this.mgm) {
                    this.mgo = true;
                } else {
                    this.mgp.a(nVar);
                    return;
                }
            }
        }
        if (z && !d(nVar)) {
            if (this.mgt.Pb(nVar.getId())) {
                this.mgp.a(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.mgp.aHM();
        } else if (Math.abs(System.currentTimeMillis() - this.dpq) >= g.drP().aIe()) {
            if (!z && this.mgt.Pb(nVar.getId())) {
                this.dpo.add(nVar);
            }
            aHX();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.mgt.Pb(nVar.getId())) {
                this.dpo.add(nVar);
            }
            if (this.dpo.size() >= 20) {
                aHT();
            }
        } else if (!z && this.mgt.Pb(nVar.getId())) {
            this.mgp.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        this.mgq.a(nVar, this.mgt.tE(nVar.getId()));
    }

    private void aHT() {
        if (this.dpo != null && this.dpo.size() != 0) {
            this.mgp.ap(this.dpo);
            this.dpo.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.mgp.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.mgp.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> dai;
        aHT();
        this.mgp.a(str, i, j, jSONArray);
        boolean tE = this.mgt.tE(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (tE && (dai = UBC.getUBCContext().dai()) != null && dai.contains(str)) {
                if (!this.mgo) {
                    if ((System.currentTimeMillis() - this.mgn) / 1000 >= this.mgm) {
                        this.mgo = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (tE) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            aHU();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.dpq) >= g.drP().aIe()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aHX();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(String str, int i) {
        aHT();
        this.mgp.G(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.dpq) >= g.drP().aIe()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aHX();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(n nVar) {
        if (dx(this.mContext)) {
            nVar.Ph("1");
            ah e = e(nVar);
            if (e.isEmpty()) {
                return false;
            }
            this.mgp.d(e);
            d.drN().a(e.dsh(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.mgp.a(nVar2);
                    } else {
                        c.this.mgp.drZ();
                    }
                }
            });
            e.clearData();
            return true;
        }
        return false;
    }

    private boolean d(n nVar) {
        if (dx(this.mContext) && aHV()) {
            aHT();
            ah e = e(nVar);
            if (e != null) {
                if (this.dpt == null) {
                    aHS();
                }
                if (a(e, "0")) {
                    return true;
                }
                a(this.dpt, e);
                b(e);
                aHW();
                return true;
            }
            return false;
        }
        return false;
    }

    private ah e(n nVar) {
        ah ahVar = new ah();
        ahVar.gp(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", Long.toString(nVar.getTime()));
            if (nVar.aIv() != null) {
                jSONObject.put("content", nVar.aIv().toString());
            } else {
                jSONObject.put("content", nVar.getContent());
            }
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.aIu())) {
                jSONObject.put("abtest", nVar.aIu());
                ahVar.tV("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.aIq()) {
                jSONObject.put("of", "1");
            }
            jSONObject.put("idtype", this.mgt.tK(nVar.getId()));
            jSONObject.put("isreal", this.mgt.Pd(nVar.getId()) ? "1" : "0");
            String Pe = this.mgt.Pe(nVar.getId());
            if (!TextUtils.isEmpty(Pe) && !TextUtils.equals(Pe, "0")) {
                jSONObject.put("gflow", Pe);
            }
            ahVar.cx(jSONObject);
            ahVar.s(nVar.getTime(), nVar.getTime());
            return ahVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void aHU() {
        if (dx(this.mContext) && aHV()) {
            ah ahVar = new ah();
            ahVar.gp(true);
            if (this.dpt == null) {
                aHS();
            }
            if (!a(ahVar, "1")) {
                a(this.dpt, ahVar);
                b(ahVar);
                aHW();
            }
        }
    }

    private void a(SparseArray<ArrayList> sparseArray, ah ahVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size() && !ahVar.jA(com.baidu.fsg.base.statistics.b.c)) {
                this.mgp.a(sparseArray.valueAt(i2), ahVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean aHV() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.dpr) > 86400000) {
            this.dps = 0;
            this.dpr = currentTimeMillis;
            ag.dsf().putLong("ubc_reset_real_time_count_time", this.dpr);
            ag.dsf().putInt("ubc_real_time_count", this.dps);
        }
        if (this.dps >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.dps == 10000) {
                this.dps++;
                if (!DEBUG) {
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
                }
            }
            return false;
        }
        return true;
    }

    private void aHW() {
        this.dps++;
        ag.dsf().putInt("ubc_real_time_count", this.dps);
    }

    private void aHX() {
        if (dx(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.dpq = System.currentTimeMillis();
            ag.dsf().putLong("ubc_last_upload_non_real", this.dpq);
            aHZ();
            aHT();
            this.mgp.aHM();
            HashSet hashSet = new HashSet();
            if (this.dpt == null) {
                aHS();
            }
            ah ahVar = new ah();
            ahVar.gp(false);
            int i = 0;
            for (int i2 = 0; i2 < this.dpt.size(); i2++) {
                int keyAt = this.dpt.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.dpu.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.mgt.aIe()) {
                        i |= this.mgp.a(this.dpt.valueAt(i2), ahVar);
                        this.dpu.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.dpt.size(); i3++) {
                    int keyAt2 = this.dpt.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ahVar.jA(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.mgp.a(this.dpt.valueAt(i3), ahVar);
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
    public void aHY() {
        if (dx(this.mContext) && Math.abs(System.currentTimeMillis() - this.dpp) >= BdKVCache.MILLS_1Hour) {
            this.mgp.aHM();
            ah ahVar = new ah();
            if (this.mgp.c(ahVar) != 0) {
                ah ahVar2 = new ah();
                ahVar2.s(ahVar.aIW(), ahVar.getMaxTime());
                ahVar2.tV(ahVar.aIV());
                ahVar2.gp(true);
                ah ahVar3 = new ah();
                ahVar3.s(ahVar.aIW(), ahVar.getMaxTime());
                ahVar3.tV(ahVar.aIV());
                ahVar3.gp(false);
                SparseArray<Integer> aIS = ahVar.aIS();
                int size = aIS.size();
                for (int i = 0; i < size; i++) {
                    if (this.mgt.tE(String.valueOf(aIS.valueAt(i).intValue()))) {
                        ahVar2.aw(aIS.keyAt(i), aIS.valueAt(i).intValue());
                    } else {
                        ahVar3.aw(aIS.keyAt(i), aIS.valueAt(i).intValue());
                    }
                }
                ArrayList aIT = ahVar.aIT();
                int size2 = aIT.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aIT.get(i2);
                    if (this.mgt.tE(str)) {
                        ahVar2.tU(str);
                    } else {
                        ahVar3.tU(str);
                    }
                }
                JSONArray aIX = ahVar.aIX();
                int length = aIX.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = aIX.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.mgt.tE(str2)) {
                                ahVar2.cx(optJSONObject);
                            } else {
                                ahVar3.cx(optJSONObject);
                            }
                        }
                    }
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "total " + ahVar.aIX().length() + " real size = " + ahVar2.aIX().length() + "   no real  = " + ahVar3.aIX().length());
                }
                if (ahVar2.aIX().length() > 0) {
                    b(ahVar2);
                }
                if (ahVar3.aIX().length() > 0) {
                    b(ahVar3);
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "UBC all data:");
                }
                this.dpp = System.currentTimeMillis();
                ag.dsf().putLong("ubc_last_upload_all_time", this.dpp);
                this.dpq = this.dpp;
                ag.dsf().putLong("ubc_last_upload_non_real", this.dpq);
            }
        }
    }

    private void b(ah ahVar) {
        if (!ahVar.isEmpty()) {
            try {
                JSONObject dsh = ahVar.dsh();
                String md5 = af.toMd5(dsh.toString().getBytes(), true);
                cP(dsh.toString(), md5);
                if (DEBUG) {
                    y.e(ahVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.mgp.a(ahVar.aIS(), ahVar.aIT(), ahVar.aIY(), md5)) {
                    ahVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.mgp.tz(md5);
                    return;
                }
                d.drN().z(dsh, md5);
                ahVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.mgr) >= 7200000) {
                    this.mgr = currentTimeMillis;
                    ag.dsf().putLong("ubc_last_upload_failed_data_time", this.mgr);
                    d.drN().aIb();
                }
            } catch (OutOfMemoryError e) {
                ahVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean h = this.mgs.h(jSONObject, z);
        if (tVar != null) {
            tVar.a(h, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.drN().aj(str, h);
        }
    }

    private void aHZ() {
        gm(true);
        gm(false);
    }

    private void gm(boolean z) {
        ah ahVar = new ah();
        ahVar.gp(z);
        if (this.mgq.a(ahVar, z)) {
            JSONObject dsh = ahVar.dsh();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + dsh.toString());
            }
            this.mgq.gl(z);
            d.drN().dD(dsh);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        JSONArray jSONArray = new JSONArray();
        this.mgu = 0;
        this.mgv = 0;
        this.mgw = 0;
        String drV = vVar.drV();
        if (drV == null || TextUtils.equals(drV, "1")) {
        }
        b(vVar, z, jSONArray);
        a(vVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.mgu + this.mgv + this.mgw), Integer.valueOf(this.mgu), Integer.valueOf(this.mgw)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.mgt.ar(vVar.aIK());
        int aIJ = vVar.aIJ();
        if (aIJ > 0) {
            this.mgt.js(aIJ * 86400000);
        }
        if (vVar.aII() > 0) {
            this.mgt.jt(vVar.aII());
        }
        if (this.dpt == null) {
            this.dpt = new SparseArray<>();
        }
        this.dpt.clear();
        if (this.dpu == null) {
            this.dpu = new HashMap<>();
        }
        this.dpu.clear();
        this.mgp.b(this.dpt);
        int i = 0;
        for (int i2 = 0; i2 < this.dpt.size(); i2++) {
            int keyAt = this.dpt.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.dpu.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.mgt.jr(i);
        vVar.aIK().clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (android.text.TextUtils.equals(r7.drS(), "1") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (android.text.TextUtils.equals(r0.drS(), "1") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r5.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(v vVar, boolean z, JSONArray jSONArray) {
        List<k> aIK = vVar.aIK();
        if (aIK != null && aIK.size() > 0) {
            ArrayList arrayList = new ArrayList(aIK);
            Iterator<k> it = aIK.iterator();
            while (it.hasNext()) {
                k next = it.next();
                k Pj = this.mgp.Pj(next.getId());
                String version = next.getVersion();
                String str = "0";
                if (Pj != null) {
                    str = Pj.getVersion();
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
                        this.mgw++;
                    } else {
                        boolean a = this.mgp.a(next);
                        jSONObject.put("product", String.format("set/%s", next.getId()));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        jSONObject.put("version", version);
                        if (!a) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.mgv++;
                        } else {
                            this.mgu++;
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
            vVar.eZ(arrayList);
        }
    }

    void b(v vVar, boolean z, JSONArray jSONArray) {
        String str;
        JSONObject drX = vVar.drX();
        if (drX != null) {
            Iterator<String> keys = drX.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k Pj = this.mgp.Pj(next);
                    String optString = drX.optString(next, "0");
                    if (Pj == null) {
                        str = "0";
                    } else {
                        str = Pj.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.mgw++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.mgp.Pk(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.mgv++;
                        } else {
                            this.mgu++;
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
    private boolean dx(Context context) {
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
    private void cP(String str, String str2) {
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
            y.tT("save to file suc");
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
    public void tB(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        y.tT("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            y.tT("delete file suc");
        }
        this.mgp.tz(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tC(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        y.tT("upload file fail");
        this.mgp.tA(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aIb() {
        File[] listFiles;
        if (dx(this.mContext)) {
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
                    this.mgp.aHN();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o Pl = this.mgp.Pl(listFiles[i].getName());
                    if (Pl != null && TextUtils.equals("0", Pl.aIy())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        y.tT("processFailedData file, no need to send");
                    } else if (Pl != null && TextUtils.equals("1", Pl.aIy())) {
                        y.tT("processFailedData file, send");
                        this.mgp.cO(listFiles[i].getName(), "0");
                        tD(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        y.tT("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1361=5, 1363=4, 1364=4, 1365=4] */
    void tD(String str) {
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
                            d.drN().z(jSONObject, str);
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
    public void aIc() {
        this.mgp.aHO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ah ahVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> dai = UBC.getUBCContext().dai();
            if (dai == null || dai.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= dai.size()) {
                    break;
                }
                arrayList.add(new j(dai.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.mgp.a(arrayList, ahVar);
            b(ahVar);
            aHW();
            return true;
        }
        return false;
    }
}
