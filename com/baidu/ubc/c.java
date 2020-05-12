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
    private List<n> ddA;
    private long ddB;
    private long ddC;
    private long ddD;
    private int ddE;
    private SparseArray<ArrayList> ddF;
    private HashMap<String, Long> ddG;
    private int lMX;
    private long lMY;
    private boolean lMZ = false;
    private w lNa;
    private b lNb;
    private long lNc;
    private u lNd;
    private g lNe;
    private int lNf;
    private int lNg;
    private int lNh;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ag dkP = ag.dkP();
        this.lNa = new w(context);
        this.lNb = new b(context);
        this.lNd = ae.dkO();
        this.ddA = new ArrayList(20);
        this.ddB = dkP.getLong("ubc_last_upload_all_time", 0L);
        this.ddC = dkP.getLong("ubc_last_upload_non_real", 0L);
        this.ddD = dkP.getLong("ubc_reset_real_time_count_time", 0L);
        this.lNc = dkP.getLong("ubc_last_upload_failed_data_time", 0L);
        this.ddE = dkP.getInt("ubc_real_time_count", 0);
        this.lNe = g.dkz();
        this.lNe.a(this, context);
        this.lMY = System.currentTimeMillis();
        int nextInt = new Random().nextInt(31) + 60;
        this.lMX = nextInt;
        new Timer().schedule(new TimerTask() { // from class: com.baidu.ubc.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!c.this.lMZ) {
                    ah ahVar = new ah();
                    ahVar.ge(true);
                    c.this.a(ahVar, "0");
                }
            }
        }, nextInt * 1000);
    }

    private void aDl() {
        if (this.ddF == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.ddF = new SparseArray<>();
            this.lNa.a(this.ddF);
            this.ddG = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.ddF.size(); i2++) {
                int keyAt = this.ddF.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.ddG.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.lNe.iY(i);
        }
    }

    public w dkw() {
        return this.lNa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.ahF()) && this.lNe.sb(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.lNa.a(nVar);
                return;
            }
            List<String> cTe = UBC.getUBCContext().cTe();
            if (cTe == null || !cTe.contains(nVar.getId())) {
                this.lNa.a(nVar);
                return;
            } else if (!this.lMZ) {
                if ((System.currentTimeMillis() - this.lMY) / 1000 >= this.lMX) {
                    this.lMZ = true;
                } else {
                    this.lNa.a(nVar);
                    return;
                }
            }
        }
        if (z && !d(nVar)) {
            if (this.lNe.No(nVar.getId())) {
                this.lNa.a(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.lNa.aDf();
        } else if (Math.abs(System.currentTimeMillis() - this.ddC) >= g.dkz().aDx()) {
            if (!z && this.lNe.No(nVar.getId())) {
                this.ddA.add(nVar);
            }
            aDq();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.lNe.No(nVar.getId())) {
                this.ddA.add(nVar);
            }
            if (this.ddA.size() >= 20) {
                aDm();
            }
        } else if (!z && this.lNe.No(nVar.getId())) {
            this.lNa.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        this.lNb.a(nVar, this.lNe.sb(nVar.getId()));
    }

    private void aDm() {
        if (this.ddA != null && this.ddA.size() != 0) {
            this.lNa.au(this.ddA);
            this.ddA.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.lNa.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.lNa.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> cTe;
        aDm();
        this.lNa.a(str, i, j, jSONArray);
        boolean sb = this.lNe.sb(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (sb && (cTe = UBC.getUBCContext().cTe()) != null && cTe.contains(str)) {
                if (!this.lMZ) {
                    if ((System.currentTimeMillis() - this.lMY) / 1000 >= this.lMX) {
                        this.lMZ = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (sb) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            aDn();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.ddC) >= g.dkz().aDx()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aDq();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(String str, int i) {
        aDm();
        this.lNa.C(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.ddC) >= g.dkz().aDx()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aDq();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(n nVar) {
        if (dh(this.mContext)) {
            nVar.Nu("1");
            ah e = e(nVar);
            if (e.isEmpty()) {
                return false;
            }
            this.lNa.d(e);
            d.dkx().a(e.dkR(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.lNa.a(nVar2);
                    } else {
                        c.this.lNa.dkJ();
                    }
                }
            });
            e.clearData();
            return true;
        }
        return false;
    }

    private boolean d(n nVar) {
        if (dh(this.mContext) && aDo()) {
            aDm();
            ah e = e(nVar);
            if (e != null) {
                if (this.ddF == null) {
                    aDl();
                }
                if (a(e, "0")) {
                    return true;
                }
                a(this.ddF, e);
                b(e);
                aDp();
                return true;
            }
            return false;
        }
        return false;
    }

    private ah e(n nVar) {
        ah ahVar = new ah();
        ahVar.ge(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", Long.toString(nVar.getTime()));
            if (nVar.aDL() != null) {
                jSONObject.put("content", nVar.aDL().toString());
            } else {
                jSONObject.put("content", nVar.getContent());
            }
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.aDK())) {
                jSONObject.put("abtest", nVar.aDK());
                ahVar.sq("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.aDH()) {
                jSONObject.put("of", "1");
            }
            jSONObject.put("idtype", this.lNe.sh(nVar.getId()));
            jSONObject.put("isreal", this.lNe.Nq(nVar.getId()) ? "1" : "0");
            String Nr = this.lNe.Nr(nVar.getId());
            if (!TextUtils.isEmpty(Nr) && !TextUtils.equals(Nr, "0")) {
                jSONObject.put("gflow", Nr);
            }
            ahVar.cr(jSONObject);
            ahVar.r(nVar.getTime(), nVar.getTime());
            return ahVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void aDn() {
        if (dh(this.mContext) && aDo()) {
            ah ahVar = new ah();
            ahVar.ge(true);
            if (this.ddF == null) {
                aDl();
            }
            if (!a(ahVar, "1")) {
                a(this.ddF, ahVar);
                b(ahVar);
                aDp();
            }
        }
    }

    private void a(SparseArray<ArrayList> sparseArray, ah ahVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size() && !ahVar.jh(com.baidu.fsg.base.statistics.b.c)) {
                this.lNa.a(sparseArray.valueAt(i2), ahVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean aDo() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.ddD) > 86400000) {
            this.ddE = 0;
            this.ddD = currentTimeMillis;
            ag.dkP().putLong("ubc_reset_real_time_count_time", this.ddD);
            ag.dkP().putInt("ubc_real_time_count", this.ddE);
        }
        if (this.ddE >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.ddE == 10000) {
                this.ddE++;
                if (!DEBUG) {
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
                }
            }
            return false;
        }
        return true;
    }

    private void aDp() {
        this.ddE++;
        ag.dkP().putInt("ubc_real_time_count", this.ddE);
    }

    private void aDq() {
        if (dh(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.ddC = System.currentTimeMillis();
            ag.dkP().putLong("ubc_last_upload_non_real", this.ddC);
            aDs();
            aDm();
            this.lNa.aDf();
            HashSet hashSet = new HashSet();
            if (this.ddF == null) {
                aDl();
            }
            ah ahVar = new ah();
            ahVar.ge(false);
            int i = 0;
            for (int i2 = 0; i2 < this.ddF.size(); i2++) {
                int keyAt = this.ddF.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.ddG.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.lNe.aDx()) {
                        i |= this.lNa.a(this.ddF.valueAt(i2), ahVar);
                        this.ddG.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.ddF.size(); i3++) {
                    int keyAt2 = this.ddF.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ahVar.jh(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.lNa.a(this.ddF.valueAt(i3), ahVar);
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
    public void aDr() {
        if (dh(this.mContext) && Math.abs(System.currentTimeMillis() - this.ddB) >= BdKVCache.MILLS_1Hour) {
            this.lNa.aDf();
            ah ahVar = new ah();
            if (this.lNa.c(ahVar) != 0) {
                ah ahVar2 = new ah();
                ahVar2.r(ahVar.aEo(), ahVar.getMaxTime());
                ahVar2.sq(ahVar.aEn());
                ahVar2.ge(true);
                ah ahVar3 = new ah();
                ahVar3.r(ahVar.aEo(), ahVar.getMaxTime());
                ahVar3.sq(ahVar.aEn());
                ahVar3.ge(false);
                SparseArray<Integer> aEk = ahVar.aEk();
                int size = aEk.size();
                for (int i = 0; i < size; i++) {
                    if (this.lNe.sb(String.valueOf(aEk.valueAt(i).intValue()))) {
                        ahVar2.aw(aEk.keyAt(i), aEk.valueAt(i).intValue());
                    } else {
                        ahVar3.aw(aEk.keyAt(i), aEk.valueAt(i).intValue());
                    }
                }
                ArrayList aEl = ahVar.aEl();
                int size2 = aEl.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aEl.get(i2);
                    if (this.lNe.sb(str)) {
                        ahVar2.sp(str);
                    } else {
                        ahVar3.sp(str);
                    }
                }
                JSONArray aEp = ahVar.aEp();
                int length = aEp.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = aEp.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.lNe.sb(str2)) {
                                ahVar2.cr(optJSONObject);
                            } else {
                                ahVar3.cr(optJSONObject);
                            }
                        }
                    }
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "total " + ahVar.aEp().length() + " real size = " + ahVar2.aEp().length() + "   no real  = " + ahVar3.aEp().length());
                }
                if (ahVar2.aEp().length() > 0) {
                    b(ahVar2);
                }
                if (ahVar3.aEp().length() > 0) {
                    b(ahVar3);
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "UBC all data:");
                }
                this.ddB = System.currentTimeMillis();
                ag.dkP().putLong("ubc_last_upload_all_time", this.ddB);
                this.ddC = this.ddB;
                ag.dkP().putLong("ubc_last_upload_non_real", this.ddC);
            }
        }
    }

    private void b(ah ahVar) {
        if (!ahVar.isEmpty()) {
            try {
                JSONObject dkR = ahVar.dkR();
                String md5 = af.toMd5(dkR.toString().getBytes(), true);
                cs(dkR.toString(), md5);
                if (DEBUG) {
                    y.e(ahVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.lNa.a(ahVar.aEk(), ahVar.aEl(), ahVar.aEq(), md5)) {
                    ahVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.lNa.rW(md5);
                    return;
                }
                d.dkx().s(dkR, md5);
                ahVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.lNc) >= 7200000) {
                    this.lNc = currentTimeMillis;
                    ag.dkP().putLong("ubc_last_upload_failed_data_time", this.lNc);
                    d.dkx().aDu();
                }
            } catch (OutOfMemoryError e) {
                ahVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean g = this.lNd.g(jSONObject, z);
        if (tVar != null) {
            tVar.a(g, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.dkx().W(str, g);
        }
    }

    private void aDs() {
        gb(true);
        gb(false);
    }

    private void gb(boolean z) {
        ah ahVar = new ah();
        ahVar.ge(z);
        if (this.lNb.a(ahVar, z)) {
            JSONObject dkR = ahVar.dkR();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + dkR.toString());
            }
            this.lNb.ga(z);
            d.dkx().dw(dkR);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        JSONArray jSONArray = new JSONArray();
        this.lNf = 0;
        this.lNg = 0;
        this.lNh = 0;
        String dkF = vVar.dkF();
        if (dkF == null || TextUtils.equals(dkF, "1")) {
        }
        b(vVar, z, jSONArray);
        a(vVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.lNf + this.lNg + this.lNh), Integer.valueOf(this.lNf), Integer.valueOf(this.lNh)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.lNe.aw(vVar.aEb());
        int aEa = vVar.aEa();
        if (aEa > 0) {
            this.lNe.iZ(aEa * 86400000);
        }
        if (vVar.aDZ() > 0) {
            this.lNe.ja(vVar.aDZ());
        }
        if (this.ddF == null) {
            this.ddF = new SparseArray<>();
        }
        this.ddF.clear();
        if (this.ddG == null) {
            this.ddG = new HashMap<>();
        }
        this.ddG.clear();
        this.lNa.a(this.ddF);
        int i = 0;
        for (int i2 = 0; i2 < this.ddF.size(); i2++) {
            int keyAt = this.ddF.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.ddG.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.lNe.iY(i);
        vVar.aEb().clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (android.text.TextUtils.equals(r7.dkC(), "1") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (android.text.TextUtils.equals(r0.dkC(), "1") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r5.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(v vVar, boolean z, JSONArray jSONArray) {
        List<k> aEb = vVar.aEb();
        if (aEb != null && aEb.size() > 0) {
            ArrayList arrayList = new ArrayList(aEb);
            Iterator<k> it = aEb.iterator();
            while (it.hasNext()) {
                k next = it.next();
                k Nw = this.lNa.Nw(next.getId());
                String version = next.getVersion();
                String str = "0";
                if (Nw != null) {
                    str = Nw.getVersion();
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
                        this.lNh++;
                    } else {
                        boolean a = this.lNa.a(next);
                        jSONObject.put("product", String.format("set/%s", next.getId()));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        jSONObject.put("version", version);
                        if (!a) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.lNg++;
                        } else {
                            this.lNf++;
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
            vVar.eS(arrayList);
        }
    }

    void b(v vVar, boolean z, JSONArray jSONArray) {
        String str;
        JSONObject dkH = vVar.dkH();
        if (dkH != null) {
            Iterator<String> keys = dkH.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k Nw = this.lNa.Nw(next);
                    String optString = dkH.optString(next, "0");
                    if (Nw == null) {
                        str = "0";
                    } else {
                        str = Nw.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.lNh++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.lNa.Nx(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.lNg++;
                        } else {
                            this.lNf++;
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
    private boolean dh(Context context) {
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
    private void cs(String str, String str2) {
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
            y.so("save to file suc");
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
    public void rY(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        y.so("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            y.so("delete file suc");
        }
        this.lNa.rW(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rZ(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        y.so("upload file fail");
        this.lNa.rX(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDu() {
        File[] listFiles;
        if (dh(this.mContext)) {
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
                    this.lNa.aDg();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o Ny = this.lNa.Ny(listFiles[i].getName());
                    if (Ny != null && TextUtils.equals("0", Ny.aDO())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        y.so("processFailedData file, no need to send");
                    } else if (Ny != null && TextUtils.equals("1", Ny.aDO())) {
                        y.so("processFailedData file, send");
                        this.lNa.cr(listFiles[i].getName(), "0");
                        sa(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        y.so("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1361=5, 1363=4, 1364=4, 1365=4] */
    void sa(String str) {
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
                            d.dkx().s(jSONObject, str);
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
    public void aDv() {
        this.lNa.aDh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ah ahVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> cTe = UBC.getUBCContext().cTe();
            if (cTe == null || cTe.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= cTe.size()) {
                    break;
                }
                arrayList.add(new j(cTe.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.lNa.a(arrayList, ahVar);
            b(ahVar);
            aDp();
            return true;
        }
        return false;
    }
}
