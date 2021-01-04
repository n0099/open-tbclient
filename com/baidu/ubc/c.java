package com.baidu.ubc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import com.baidu.searchbox.config.AppConfig;
import com.kwad.sdk.collector.AppStatusRules;
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
import org.apache.commons.codec.binary4util.bdapp.Base64InputStream;
import org.apache.commons.codec.binary4util.bdapp.Base64OutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    private static final boolean DEBUG = AppConfig.isDebug();
    private List<n> eAB;
    private long eAD;
    private long eAE;
    private int eAF;
    private SparseArray<ArrayList> eAG;
    private HashMap<String, Long> eAH;
    private Context mContext;
    private long oMA;
    private x oMC;
    private b oMD;
    private long oMG;
    private u oMH;
    private g oMI;
    private int oMJ;
    private int oMK;
    private int oML;
    private int oMz;
    private boolean oMB = false;
    private int oME = 0;
    private long oMF = 0;
    private Runnable oMM = new Runnable() { // from class: com.baidu.ubc.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.oME == 1) {
                long uptimeMillis = SystemClock.uptimeMillis() - c.this.oMF;
                if (uptimeMillis >= 5000) {
                    if (c.DEBUG) {
                        Log.d("UBCBehaviorModel", String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis)));
                    }
                    c.this.bhZ();
                    c.this.oME = 0;
                    return;
                }
                d.eiS().e(this, 5000 - uptimeMillis);
            } else if (c.this.oME == 2) {
                c.this.oME = 0;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ai ejs = ai.ejs();
        this.oMC = new x(context);
        this.oMD = new b(context);
        this.oMH = ag.ejr();
        this.eAB = new ArrayList(20);
        this.eAD = ejs.getLong("ubc_last_upload_non_real", 0L);
        this.eAE = ejs.getLong("ubc_reset_real_time_count_time", 0L);
        this.oMG = ejs.getLong("ubc_last_upload_failed_data_time", 0L);
        this.eAF = ejs.getInt("ubc_real_time_count", 0);
        this.oMI = g.eiW();
        this.oMI.a(this, context);
        this.oMA = System.currentTimeMillis();
        this.oMz = new Random().nextInt(31) + 60;
    }

    private void bhY() {
        int i = 0;
        if (this.eAG == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.eAG = new SparseArray<>();
            this.oMC.e(this.eAG);
            this.eAH = new HashMap<>();
            int i2 = 0;
            while (true) {
                int i3 = i;
                if (i2 < this.eAG.size()) {
                    int keyAt = this.eAG.keyAt(i2);
                    i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                    this.eAH.put("ubc_last_upload_time_level_" + keyAt, 0L);
                    i2++;
                } else {
                    this.oMI.nJ(i3);
                    return;
                }
            }
        }
    }

    public x eiR() {
        return this.oMC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.biy()) && this.oMI.zo(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.oMC.b(nVar);
                return;
            }
            List<String> dLN = UBC.getUBCContext().dLN();
            if (dLN == null || !dLN.contains(nVar.getId())) {
                this.oMC.b(nVar);
                return;
            } else if (!this.oMB) {
                if ((System.currentTimeMillis() - this.oMA) / 1000 >= this.oMz) {
                    this.oMB = true;
                } else {
                    this.oMC.b(nVar);
                    return;
                }
            }
        }
        if (z && !g(nVar)) {
            if (this.oMI.Xn(nVar.getId())) {
                this.oMC.b(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.oMC.bhS();
        } else if (Math.abs(System.currentTimeMillis() - this.eAD) >= g.eiW().bik()) {
            if (!z && this.oMI.Xn(nVar.getId())) {
                e(nVar);
            }
            bid();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.oMI.Xn(nVar.getId())) {
                e(nVar);
            }
            if (this.eAB.size() >= 20) {
                bhZ();
            }
        } else if (!z && this.oMI.Xn(nVar.getId())) {
            this.oMC.b(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(n nVar) {
        this.oMD.a(nVar, this.oMI.zo(nVar.getId()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(n nVar) {
        if (com.baidu.pyramid.runtime.multiprocess.a.ahD()) {
            this.oMD.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhZ() {
        if (this.eAB != null && this.eAB.size() != 0) {
            this.oMC.bh(this.eAB);
            this.eAB.clear();
            if (this.oME == 1) {
                this.oME = 2;
            }
        }
    }

    private void e(n nVar) {
        this.eAB.add(nVar);
        if (this.oME == 0) {
            this.oMF = SystemClock.uptimeMillis();
            d.eiS().e(this.oMM, 5000L);
            this.oME = 1;
        } else if (this.oME == 2) {
            this.oMF = SystemClock.uptimeMillis();
            this.oME = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.oMC.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.oMC.i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> dLN;
        bhZ();
        this.oMC.a(str, i, j, jSONArray);
        boolean zo = this.oMI.zo(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (zo && (dLN = UBC.getUBCContext().dLN()) != null && dLN.contains(str)) {
                if (!this.oMB) {
                    if ((System.currentTimeMillis() - this.oMA) / 1000 >= this.oMz) {
                        this.oMB = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (zo) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            bia();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.eAD) >= g.eiW().bik()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bid();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(String str, int i) {
        bhZ();
        this.oMC.M(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.eAD) >= g.eiW().bik()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bid();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(n nVar) {
        if (isNetWorkEnabled(this.mContext)) {
            nVar.Xv("1");
            aj h = h(nVar);
            if (h.isEmpty()) {
                return false;
            }
            this.oMC.c(h);
            d.eiS().a(h.ejv(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.oMC.b(nVar2);
                    } else {
                        c.this.oMC.ejk();
                    }
                }
            });
            h.clearData();
            return true;
        }
        return false;
    }

    private boolean g(n nVar) {
        if (isNetWorkEnabled(this.mContext) && bib()) {
            bhZ();
            aj h = h(nVar);
            if (h != null) {
                if (this.eAG == null) {
                    bhY();
                }
                if (a(h, "0")) {
                    return true;
                }
                a(this.eAG, h);
                b(h);
                bic();
                return true;
            }
            return false;
        }
        return false;
    }

    private aj h(n nVar) {
        aj ajVar = new aj();
        ajVar.iN(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", Long.toString(nVar.getTime()));
            if (nVar.biB() != null) {
                jSONObject.put("content", nVar.biB().toString());
            } else {
                jSONObject.put("content", nVar.getContent());
            }
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.biA())) {
                jSONObject.put("abtest", nVar.biA());
                ajVar.zF("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.biw()) {
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
            }
            jSONObject.put("idtype", this.oMI.zu(nVar.getId()));
            jSONObject.put("isreal", this.oMI.Xp(nVar.getId()) ? "1" : "0");
            String Xq = this.oMI.Xq(nVar.getId());
            if (!TextUtils.isEmpty(Xq) && !TextUtils.equals(Xq, "0")) {
                jSONObject.put("gflow", Xq);
            }
            ajVar.dn(jSONObject);
            ajVar.u(nVar.getTime(), nVar.getTime());
            return ajVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void bia() {
        if (isNetWorkEnabled(this.mContext) && bib()) {
            aj ajVar = new aj();
            ajVar.iN(true);
            if (this.eAG == null) {
                bhY();
            }
            if (!a(ajVar, "1")) {
                a(this.eAG, ajVar);
                b(ajVar);
                bic();
            }
        }
    }

    private void a(SparseArray<ArrayList> sparseArray, aj ajVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size() && !ajVar.nS(com.baidu.fsg.base.statistics.b.c)) {
                this.oMC.a(sparseArray.valueAt(i2), ajVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean bib() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.eAE) > 86400000) {
            this.eAF = 0;
            this.eAE = currentTimeMillis;
            ai.ejs().putLong("ubc_reset_real_time_count_time", this.eAE);
            ai.ejs().putInt("ubc_real_time_count", this.eAF);
        }
        if (this.eAF >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.eAF == 10000) {
                this.eAF++;
                if (!DEBUG) {
                    ac.ejo().XB(String.valueOf(10000));
                }
            }
            return false;
        }
        return true;
    }

    private void bic() {
        this.eAF++;
        ai.ejs().putInt("ubc_real_time_count", this.eAF);
    }

    private void bid() {
        if (isNetWorkEnabled(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.eAD = System.currentTimeMillis();
            ai.ejs().putLong("ubc_last_upload_non_real", this.eAD);
            bif();
            bhZ();
            this.oMC.bhS();
            HashSet hashSet = new HashSet();
            if (this.eAG == null) {
                bhY();
            }
            aj ajVar = new aj();
            ajVar.iN(false);
            int i = 0;
            for (int i2 = 0; i2 < this.eAG.size(); i2++) {
                int keyAt = this.eAG.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.eAH.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * AppStatusRules.DEFAULT_GRANULARITY)) - System.currentTimeMillis() < this.oMI.bik()) {
                        i |= this.oMC.a(this.eAG.valueAt(i2), ajVar);
                        this.eAH.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.eAG.size(); i3++) {
                    int keyAt2 = this.eAG.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ajVar.nS(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.oMC.a(this.eAG.valueAt(i3), ajVar);
                    }
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "UBC non real time:");
                }
                b(ajVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uploadLocalDatas() {
        if (isNetWorkEnabled(this.mContext)) {
            this.oMC.bhS();
            aj ajVar = new aj();
            ajVar.Ox(this.oMI.eiX());
            ajVar.iN(true);
            aj ajVar2 = new aj();
            ajVar2.Ox(this.oMI.eiX());
            ajVar2.iN(false);
            if (this.oMC.a(ajVar, ajVar2) != 0) {
                if (DEBUG) {
                    int length = ajVar.bjc().length();
                    Log.d("UBCBehaviorModel", "real size = " + length + "   no real  = " + ajVar2.bjc().length());
                }
                if (ajVar.bjc().length() > 0) {
                    b(ajVar);
                }
                if (ajVar2.bjc().length() > 0) {
                    b(ajVar2);
                }
            }
        }
    }

    private void b(aj ajVar) {
        if (!ajVar.isEmpty()) {
            try {
                JSONObject ejv = ajVar.ejv();
                String md5 = ah.toMd5(ejv.toString().getBytes(), true);
                dB(ejv.toString(), md5);
                if (DEBUG) {
                    z.d(ajVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.oMC.a(ajVar.biX(), ajVar.biY(), ajVar.bjd(), md5)) {
                    ajVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.oMC.zj(md5);
                    return;
                }
                d.eiS().B(ejv, md5);
                ajVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.oMG) >= 7200000) {
                    this.oMG = currentTimeMillis;
                    ai.ejs().putLong("ubc_last_upload_failed_data_time", this.oMG);
                    d.eiS().bih();
                }
            } catch (OutOfMemoryError e) {
                ajVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean k = this.oMH.k(jSONObject, z);
        if (tVar != null) {
            tVar.a(k, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.eiS().av(str, k);
        }
    }

    private void bif() {
        iK(true);
        iK(false);
    }

    private void iK(boolean z) {
        aj ajVar = new aj();
        ajVar.iN(z);
        if (this.oMD.a(ajVar, z)) {
            JSONObject ejv = ajVar.ejv();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + ejv.toString());
            }
            this.oMD.iJ(z);
            d.eiS().eO(ejv);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w wVar, boolean z, s sVar) {
        int i = 0;
        JSONArray jSONArray = new JSONArray();
        this.oMJ = 0;
        this.oMK = 0;
        this.oML = 0;
        b(wVar, z, jSONArray);
        a(wVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.oMJ + this.oMK + this.oML), Integer.valueOf(this.oMJ), Integer.valueOf(this.oML)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.oMI.bj(wVar.biP());
        int biO = wVar.biO();
        if (biO > 0) {
            this.oMI.nK(biO * 86400000);
        }
        if (wVar.biN() > 0) {
            this.oMI.nL(wVar.biN());
        }
        int eji = wVar.eji();
        if (eji > 307200) {
            this.oMI.Or(eji);
        }
        int ejj = wVar.ejj();
        if (ejj > 30720) {
            this.oMI.Os(ejj);
        }
        if (this.eAG == null) {
            this.eAG = new SparseArray<>();
        }
        this.eAG.clear();
        if (this.eAH == null) {
            this.eAH = new HashMap<>();
        }
        this.eAH.clear();
        this.oMC.e(this.eAG);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.eAG.size()) {
                int keyAt = this.eAG.keyAt(i2);
                i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                this.eAH.put("ubc_last_upload_time_level_" + keyAt, 0L);
                i2++;
            } else {
                this.oMI.nJ(i3);
                wVar.biP().clear();
                return;
            }
        }
    }

    void a(w wVar, boolean z, JSONArray jSONArray) {
        List<k> biP = wVar.biP();
        if (biP != null && biP.size() != 0) {
            ArrayList arrayList = new ArrayList(biP);
            if (this.oMC.ejl() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((k) it.next()).getId());
                }
                HashMap<String, String> bo = this.oMC.bo(arrayList2);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    k kVar = (k) it2.next();
                    String id = kVar.getId();
                    String str = bo.get(id);
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            String optString = jSONObject.optString("version");
                            String version = kVar.getVersion();
                            JSONObject jSONObject2 = new JSONObject();
                            boolean z2 = Integer.parseInt(optString) >= Integer.parseInt(version);
                            if (z && optString != null && version != null && z2) {
                                it2.remove();
                                jSONObject2.put("product", "set/" + id);
                                jSONObject2.put(CloudControlUBCUtils.KEY_VALID, "2");
                                jSONObject2.put("version", version);
                                jSONArray.put(jSONObject2);
                                this.oML++;
                            } else if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && TextUtils.equals(kVar.ejb(), "1")) {
                                it2.remove();
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
                }
            }
            boolean gt = this.oMC.gt(arrayList);
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                k kVar2 = (k) it3.next();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("product", "set/" + kVar2.getId());
                    jSONObject3.put("version", kVar2.getVersion());
                    if (gt) {
                        jSONObject3.put(CloudControlUBCUtils.KEY_VALID, "1");
                        this.oMJ++;
                    } else {
                        jSONObject3.put(CloudControlUBCUtils.KEY_VALID, "0");
                        this.oMK++;
                    }
                } catch (JSONException e3) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "Json格式转化失败");
                    }
                }
                jSONArray.put(jSONObject3);
            }
            wVar.fx(arrayList);
        }
    }

    void b(w wVar, boolean z, JSONArray jSONArray) {
        String str;
        JSONObject ejh = wVar.ejh();
        if (ejh != null) {
            Iterator<String> keys = ejh.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k Xy = this.oMC.Xy(next);
                    String optString = ejh.optString(next, "0");
                    if (Xy == null) {
                        str = "0";
                    } else {
                        str = Xy.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.oML++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.oMC.Xz(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.oMK++;
                        } else {
                            this.oMJ++;
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
    private boolean isNetWorkEnabled(Context context) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1256=4] */
    private void dB(String str, String str2) {
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
            z.zD("save to file suc");
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
    public void zl(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        z.zD("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            z.zD("delete file suc");
        }
        this.oMC.zj(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zm(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        z.zD("upload file fail");
        this.oMC.zk(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bih() {
        File[] listFiles;
        if (isNetWorkEnabled(this.mContext)) {
            File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 1000) {
                    if (!DEBUG) {
                        ac.ejo().cg(String.valueOf(1000), listFiles.length);
                    }
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.oMC.bhT();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o XA = this.oMC.XA(listFiles[i].getName());
                    if (XA != null && TextUtils.equals("0", XA.biE())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        z.zD("processFailedData file, no need to send");
                    } else if (XA != null && TextUtils.equals("1", XA.biE())) {
                        z.zD("processFailedData file, send");
                        this.oMC.dA(listFiles[i].getName(), "0");
                        zn(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        z.zD("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1409=5, 1411=4, 1412=4, 1413=4] */
    void zn(String str) {
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
                            d.eiS().B(jSONObject, str);
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
    public void bii() {
        this.oMC.bhU();
    }

    private boolean a(aj ajVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> dLN = UBC.getUBCContext().dLN();
            if (dLN == null || dLN.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= dLN.size()) {
                    break;
                }
                arrayList.add(new j(dLN.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.oMC.a(arrayList, ajVar);
            b(ajVar);
            bic();
            return true;
        }
        return false;
    }

    public String getUploadType(String str) {
        return this.oMI != null ? this.oMI.getUploadType(str) : "";
    }
}
