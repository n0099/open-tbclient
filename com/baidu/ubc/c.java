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
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = AppConfig.isDebug();
    private List<n> dzP;
    private long dzQ;
    private long dzR;
    private long dzS;
    private int dzT;
    private SparseArray<ArrayList> dzU;
    private HashMap<String, Long> dzV;
    private Context mContext;
    private int mLA;
    private long mLB;
    private boolean mLC = false;
    private w mLD;
    private b mLE;
    private long mLF;
    private u mLG;
    private g mLH;
    private int mLI;
    private int mLJ;
    private int mLK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ag dAq = ag.dAq();
        this.mLD = new w(context);
        this.mLE = new b(context);
        this.mLG = ae.dAp();
        this.dzP = new ArrayList(20);
        this.dzQ = dAq.getLong("ubc_last_upload_all_time", 0L);
        this.dzR = dAq.getLong("ubc_last_upload_non_real", 0L);
        this.dzS = dAq.getLong("ubc_reset_real_time_count_time", 0L);
        this.mLF = dAq.getLong("ubc_last_upload_failed_data_time", 0L);
        this.dzT = dAq.getInt("ubc_real_time_count", 0);
        this.mLH = g.dAa();
        this.mLH.a(this, context);
        this.mLB = System.currentTimeMillis();
        int nextInt = new Random().nextInt(31) + 60;
        this.mLA = nextInt;
        new Timer().schedule(new TimerTask() { // from class: com.baidu.ubc.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!c.this.mLC) {
                    ah ahVar = new ah();
                    ahVar.gP(true);
                    c.this.a(ahVar, "0");
                }
            }
        }, nextInt * 1000);
    }

    private void aMQ() {
        if (this.dzU == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.dzU = new SparseArray<>();
            this.mLD.b(this.dzU);
            this.dzV = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.dzU.size(); i2++) {
                int keyAt = this.dzU.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.dzV.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.mLH.jX(i);
        }
    }

    public w dzX() {
        return this.mLD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.aNq()) && this.mLH.uP(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.mLD.a(nVar);
                return;
            }
            List<String> dhY = UBC.getUBCContext().dhY();
            if (dhY == null || !dhY.contains(nVar.getId())) {
                this.mLD.a(nVar);
                return;
            } else if (!this.mLC) {
                if ((System.currentTimeMillis() - this.mLB) / 1000 >= this.mLA) {
                    this.mLC = true;
                } else {
                    this.mLD.a(nVar);
                    return;
                }
            }
        }
        if (z && !d(nVar)) {
            if (this.mLH.QA(nVar.getId())) {
                this.mLD.a(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.mLD.aMK();
        } else if (Math.abs(System.currentTimeMillis() - this.dzR) >= g.dAa().aNc()) {
            if (!z && this.mLH.QA(nVar.getId())) {
                this.dzP.add(nVar);
            }
            aMV();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.mLH.QA(nVar.getId())) {
                this.dzP.add(nVar);
            }
            if (this.dzP.size() >= 20) {
                aMR();
            }
        } else if (!z && this.mLH.QA(nVar.getId())) {
            this.mLD.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        this.mLE.a(nVar, this.mLH.uP(nVar.getId()));
    }

    private void aMR() {
        if (this.dzP != null && this.dzP.size() != 0) {
            this.mLD.az(this.dzP);
            this.dzP.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.mLD.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.mLD.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> dhY;
        aMR();
        this.mLD.a(str, i, j, jSONArray);
        boolean uP = this.mLH.uP(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (uP && (dhY = UBC.getUBCContext().dhY()) != null && dhY.contains(str)) {
                if (!this.mLC) {
                    if ((System.currentTimeMillis() - this.mLB) / 1000 >= this.mLA) {
                        this.mLC = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (uP) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            aMS();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.dzR) >= g.dAa().aNc()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aMV();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(String str, int i) {
        aMR();
        this.mLD.G(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.dzR) >= g.dAa().aNc()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aMV();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(n nVar) {
        if (dC(this.mContext)) {
            nVar.QG("1");
            ah e = e(nVar);
            if (e.isEmpty()) {
                return false;
            }
            this.mLD.d(e);
            d.dzY().a(e.dAs(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.mLD.a(nVar2);
                    } else {
                        c.this.mLD.dAk();
                    }
                }
            });
            e.clearData();
            return true;
        }
        return false;
    }

    private boolean d(n nVar) {
        if (dC(this.mContext) && aMT()) {
            aMR();
            ah e = e(nVar);
            if (e != null) {
                if (this.dzU == null) {
                    aMQ();
                }
                if (a(e, "0")) {
                    return true;
                }
                a(this.dzU, e);
                b(e);
                aMU();
                return true;
            }
            return false;
        }
        return false;
    }

    private ah e(n nVar) {
        ah ahVar = new ah();
        ahVar.gP(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", Long.toString(nVar.getTime()));
            if (nVar.aNt() != null) {
                jSONObject.put("content", nVar.aNt().toString());
            } else {
                jSONObject.put("content", nVar.getContent());
            }
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.aNs())) {
                jSONObject.put("abtest", nVar.aNs());
                ahVar.vg("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.aNo()) {
                jSONObject.put("of", "1");
            }
            jSONObject.put("idtype", this.mLH.uV(nVar.getId()));
            jSONObject.put("isreal", this.mLH.QC(nVar.getId()) ? "1" : "0");
            String QD = this.mLH.QD(nVar.getId());
            if (!TextUtils.isEmpty(QD) && !TextUtils.equals(QD, "0")) {
                jSONObject.put("gflow", QD);
            }
            ahVar.cK(jSONObject);
            ahVar.t(nVar.getTime(), nVar.getTime());
            return ahVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void aMS() {
        if (dC(this.mContext) && aMT()) {
            ah ahVar = new ah();
            ahVar.gP(true);
            if (this.dzU == null) {
                aMQ();
            }
            if (!a(ahVar, "1")) {
                a(this.dzU, ahVar);
                b(ahVar);
                aMU();
            }
        }
    }

    private void a(SparseArray<ArrayList> sparseArray, ah ahVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size() && !ahVar.kg(com.baidu.fsg.base.statistics.b.c)) {
                this.mLD.a(sparseArray.valueAt(i2), ahVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean aMT() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.dzS) > 86400000) {
            this.dzT = 0;
            this.dzS = currentTimeMillis;
            ag.dAq().putLong("ubc_reset_real_time_count_time", this.dzS);
            ag.dAq().putInt("ubc_real_time_count", this.dzT);
        }
        if (this.dzT >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.dzT == 10000) {
                this.dzT++;
                if (!DEBUG) {
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
                }
            }
            return false;
        }
        return true;
    }

    private void aMU() {
        this.dzT++;
        ag.dAq().putInt("ubc_real_time_count", this.dzT);
    }

    private void aMV() {
        if (dC(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.dzR = System.currentTimeMillis();
            ag.dAq().putLong("ubc_last_upload_non_real", this.dzR);
            aMX();
            aMR();
            this.mLD.aMK();
            HashSet hashSet = new HashSet();
            if (this.dzU == null) {
                aMQ();
            }
            ah ahVar = new ah();
            ahVar.gP(false);
            int i = 0;
            for (int i2 = 0; i2 < this.dzU.size(); i2++) {
                int keyAt = this.dzU.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.dzV.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.mLH.aNc()) {
                        i |= this.mLD.a(this.dzU.valueAt(i2), ahVar);
                        this.dzV.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.dzU.size(); i3++) {
                    int keyAt2 = this.dzU.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ahVar.kg(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.mLD.a(this.dzU.valueAt(i3), ahVar);
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
    public void aMW() {
        if (dC(this.mContext) && Math.abs(System.currentTimeMillis() - this.dzQ) >= BdKVCache.MILLS_1Hour) {
            this.mLD.aMK();
            ah ahVar = new ah();
            if (this.mLD.c(ahVar) != 0) {
                ah ahVar2 = new ah();
                ahVar2.t(ahVar.aNT(), ahVar.getMaxTime());
                ahVar2.vg(ahVar.aNS());
                ahVar2.gP(true);
                ah ahVar3 = new ah();
                ahVar3.t(ahVar.aNT(), ahVar.getMaxTime());
                ahVar3.vg(ahVar.aNS());
                ahVar3.gP(false);
                SparseArray<Integer> aNP = ahVar.aNP();
                int size = aNP.size();
                for (int i = 0; i < size; i++) {
                    if (this.mLH.uP(String.valueOf(aNP.valueAt(i).intValue()))) {
                        ahVar2.ay(aNP.keyAt(i), aNP.valueAt(i).intValue());
                    } else {
                        ahVar3.ay(aNP.keyAt(i), aNP.valueAt(i).intValue());
                    }
                }
                ArrayList aNQ = ahVar.aNQ();
                int size2 = aNQ.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aNQ.get(i2);
                    if (this.mLH.uP(str)) {
                        ahVar2.vf(str);
                    } else {
                        ahVar3.vf(str);
                    }
                }
                JSONArray aNU = ahVar.aNU();
                int length = aNU.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = aNU.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.mLH.uP(str2)) {
                                ahVar2.cK(optJSONObject);
                            } else {
                                ahVar3.cK(optJSONObject);
                            }
                        }
                    }
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "total " + ahVar.aNU().length() + " real size = " + ahVar2.aNU().length() + "   no real  = " + ahVar3.aNU().length());
                }
                if (ahVar2.aNU().length() > 0) {
                    b(ahVar2);
                }
                if (ahVar3.aNU().length() > 0) {
                    b(ahVar3);
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "UBC all data:");
                }
                this.dzQ = System.currentTimeMillis();
                ag.dAq().putLong("ubc_last_upload_all_time", this.dzQ);
                this.dzR = this.dzQ;
                ag.dAq().putLong("ubc_last_upload_non_real", this.dzR);
            }
        }
    }

    private void b(ah ahVar) {
        if (!ahVar.isEmpty()) {
            try {
                JSONObject dAs = ahVar.dAs();
                String md5 = af.toMd5(dAs.toString().getBytes(), true);
                cU(dAs.toString(), md5);
                if (DEBUG) {
                    y.e(ahVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.mLD.a(ahVar.aNP(), ahVar.aNQ(), ahVar.aNV(), md5)) {
                    ahVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.mLD.uK(md5);
                    return;
                }
                d.dzY().C(dAs, md5);
                ahVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.mLF) >= 7200000) {
                    this.mLF = currentTimeMillis;
                    ag.dAq().putLong("ubc_last_upload_failed_data_time", this.mLF);
                    d.dzY().aMZ();
                }
            } catch (OutOfMemoryError e) {
                ahVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean i = this.mLG.i(jSONObject, z);
        if (tVar != null) {
            tVar.a(i, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.dzY().ak(str, i);
        }
    }

    private void aMX() {
        gM(true);
        gM(false);
    }

    private void gM(boolean z) {
        ah ahVar = new ah();
        ahVar.gP(z);
        if (this.mLE.a(ahVar, z)) {
            JSONObject dAs = ahVar.dAs();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + dAs.toString());
            }
            this.mLE.gL(z);
            d.dzY().dU(dAs);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        JSONArray jSONArray = new JSONArray();
        this.mLI = 0;
        this.mLJ = 0;
        this.mLK = 0;
        String dAg = vVar.dAg();
        if (dAg == null || TextUtils.equals(dAg, "1")) {
        }
        b(vVar, z, jSONArray);
        a(vVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.mLI + this.mLJ + this.mLK), Integer.valueOf(this.mLI), Integer.valueOf(this.mLK)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.mLH.aB(vVar.aNH());
        int aNG = vVar.aNG();
        if (aNG > 0) {
            this.mLH.jY(aNG * 86400000);
        }
        if (vVar.aNF() > 0) {
            this.mLH.jZ(vVar.aNF());
        }
        if (this.dzU == null) {
            this.dzU = new SparseArray<>();
        }
        this.dzU.clear();
        if (this.dzV == null) {
            this.dzV = new HashMap<>();
        }
        this.dzV.clear();
        this.mLD.b(this.dzU);
        int i = 0;
        for (int i2 = 0; i2 < this.dzU.size(); i2++) {
            int keyAt = this.dzU.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.dzV.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.mLH.jX(i);
        vVar.aNH().clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (android.text.TextUtils.equals(r7.dAd(), "1") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (android.text.TextUtils.equals(r0.dAd(), "1") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r5.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(v vVar, boolean z, JSONArray jSONArray) {
        List<k> aNH = vVar.aNH();
        if (aNH != null && aNH.size() > 0) {
            ArrayList arrayList = new ArrayList(aNH);
            Iterator<k> it = aNH.iterator();
            while (it.hasNext()) {
                k next = it.next();
                k QI = this.mLD.QI(next.getId());
                String version = next.getVersion();
                String str = "0";
                if (QI != null) {
                    str = QI.getVersion();
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
                        this.mLK++;
                    } else {
                        boolean a = this.mLD.a(next);
                        jSONObject.put("product", String.format("set/%s", next.getId()));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        jSONObject.put("version", version);
                        if (!a) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.mLJ++;
                        } else {
                            this.mLI++;
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
            vVar.eB(arrayList);
        }
    }

    void b(v vVar, boolean z, JSONArray jSONArray) {
        String str;
        JSONObject dAi = vVar.dAi();
        if (dAi != null) {
            Iterator<String> keys = dAi.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k QI = this.mLD.QI(next);
                    String optString = dAi.optString(next, "0");
                    if (QI == null) {
                        str = "0";
                    } else {
                        str = QI.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.mLK++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.mLD.QJ(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.mLJ++;
                        } else {
                            this.mLI++;
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
    private boolean dC(Context context) {
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
    private void cU(String str, String str2) {
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
            y.ve("save to file suc");
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
    public void uM(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        y.ve("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            y.ve("delete file suc");
        }
        this.mLD.uK(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uN(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        y.ve("upload file fail");
        this.mLD.uL(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aMZ() {
        File[] listFiles;
        if (dC(this.mContext)) {
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
                    this.mLD.aML();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o QK = this.mLD.QK(listFiles[i].getName());
                    if (QK != null && TextUtils.equals("0", QK.aNw())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        y.ve("processFailedData file, no need to send");
                    } else if (QK != null && TextUtils.equals("1", QK.aNw())) {
                        y.ve("processFailedData file, send");
                        this.mLD.cT(listFiles[i].getName(), "0");
                        uO(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        y.ve("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1361=5, 1363=4, 1364=4, 1365=4] */
    void uO(String str) {
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
                            d.dzY().C(jSONObject, str);
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
    public void aNa() {
        this.mLD.aMM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ah ahVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> dhY = UBC.getUBCContext().dhY();
            if (dhY == null || dhY.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= dhY.size()) {
                    break;
                }
                arrayList.add(new j(dhY.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.mLD.a(arrayList, ahVar);
            b(ahVar);
            aMU();
            return true;
        }
        return false;
    }
}
