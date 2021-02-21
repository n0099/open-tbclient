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
/* loaded from: classes5.dex */
public class c {
    private static final boolean DEBUG = AppConfig.isDebug();
    private List<n> exT;
    private long exV;
    private long exW;
    private int exX;
    private SparseArray<ArrayList> exY;
    private HashMap<String, Long> exZ;
    private Context mContext;
    private int oSD;
    private long oSE;
    private x oSG;
    private b oSH;
    private long oSK;
    private u oSL;
    private g oSM;
    private int oSN;
    private int oSO;
    private int oSP;
    private boolean oSF = false;
    private int oSI = 0;
    private long oSJ = 0;
    private Runnable oSQ = new Runnable() { // from class: com.baidu.ubc.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.oSI == 1) {
                long uptimeMillis = SystemClock.uptimeMillis() - c.this.oSJ;
                if (uptimeMillis >= 5000) {
                    if (c.DEBUG) {
                        Log.d("UBCBehaviorModel", String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis)));
                    }
                    c.this.bet();
                    c.this.oSI = 0;
                    return;
                }
                d.ehB().e(this, 5000 - uptimeMillis);
            } else if (c.this.oSI == 2) {
                c.this.oSI = 0;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ai eib = ai.eib();
        this.oSG = new x(context);
        this.oSH = new b(context);
        this.oSL = ag.eia();
        this.exT = new ArrayList(20);
        this.exV = eib.getLong("ubc_last_upload_non_real", 0L);
        this.exW = eib.getLong("ubc_reset_real_time_count_time", 0L);
        this.oSK = eib.getLong("ubc_last_upload_failed_data_time", 0L);
        this.exX = eib.getInt("ubc_real_time_count", 0);
        this.oSM = g.ehF();
        this.oSM.a(this, context);
        this.oSE = System.currentTimeMillis();
        this.oSD = new Random().nextInt(31) + 60;
    }

    private void bes() {
        int i = 0;
        if (this.exY == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.exY = new SparseArray<>();
            this.oSG.e(this.exY);
            this.exZ = new HashMap<>();
            int i2 = 0;
            while (true) {
                int i3 = i;
                if (i2 < this.exY.size()) {
                    int keyAt = this.exY.keyAt(i2);
                    i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                    this.exZ.put("ubc_last_upload_time_level_" + keyAt, 0L);
                    i2++;
                } else {
                    this.oSM.mg(i3);
                    return;
                }
            }
        }
    }

    public x ehA() {
        return this.oSG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.beS()) && this.oSM.yw(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.oSG.b(nVar);
                return;
            }
            List<String> dKp = UBC.getUBCContext().dKp();
            if (dKp == null || !dKp.contains(nVar.getId())) {
                this.oSG.b(nVar);
                return;
            } else if (!this.oSF) {
                if ((System.currentTimeMillis() - this.oSE) / 1000 >= this.oSD) {
                    this.oSF = true;
                } else {
                    this.oSG.b(nVar);
                    return;
                }
            }
        }
        if (z && !g(nVar)) {
            if (this.oSM.Xq(nVar.getId())) {
                this.oSG.b(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.oSG.bem();
        } else if (Math.abs(System.currentTimeMillis() - this.exV) >= g.ehF().beE()) {
            if (!z && this.oSM.Xq(nVar.getId())) {
                e(nVar);
            }
            bex();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.oSM.Xq(nVar.getId())) {
                e(nVar);
            }
            if (this.exT.size() >= 20) {
                bet();
            }
        } else if (!z && this.oSM.Xq(nVar.getId())) {
            this.oSG.b(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(n nVar) {
        this.oSH.a(nVar, this.oSM.yw(nVar.getId()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(n nVar) {
        if (com.baidu.pyramid.runtime.multiprocess.a.aeb()) {
            this.oSH.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bet() {
        if (this.exT != null && this.exT.size() != 0) {
            this.oSG.bc(this.exT);
            this.exT.clear();
            if (this.oSI == 1) {
                this.oSI = 2;
            }
        }
    }

    private void e(n nVar) {
        this.exT.add(nVar);
        if (this.oSI == 0) {
            this.oSJ = SystemClock.uptimeMillis();
            d.ehB().e(this.oSQ, 5000L);
            this.oSI = 1;
        } else if (this.oSI == 2) {
            this.oSJ = SystemClock.uptimeMillis();
            this.oSI = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.oSG.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.oSG.i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> dKp;
        bet();
        this.oSG.a(str, i, j, jSONArray);
        boolean yw = this.oSM.yw(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (yw && (dKp = UBC.getUBCContext().dKp()) != null && dKp.contains(str)) {
                if (!this.oSF) {
                    if ((System.currentTimeMillis() - this.oSE) / 1000 >= this.oSD) {
                        this.oSF = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (yw) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            beu();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.exV) >= g.ehF().beE()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bex();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(String str, int i) {
        bet();
        this.oSG.O(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.exV) >= g.ehF().beE()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bex();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(n nVar) {
        if (isNetWorkEnabled(this.mContext)) {
            nVar.Xy("1");
            aj h = h(nVar);
            if (h.isEmpty()) {
                return false;
            }
            this.oSG.c(h);
            d.ehB().a(h.eie(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.oSG.b(nVar2);
                    } else {
                        c.this.oSG.ehT();
                    }
                }
            });
            h.clearData();
            return true;
        }
        return false;
    }

    private boolean g(n nVar) {
        if (isNetWorkEnabled(this.mContext) && bev()) {
            bet();
            aj h = h(nVar);
            if (h != null) {
                if (this.exY == null) {
                    bes();
                }
                if (a(h, "0")) {
                    return true;
                }
                a(this.exY, h);
                b(h);
                bew();
                return true;
            }
            return false;
        }
        return false;
    }

    private aj h(n nVar) {
        aj ajVar = new aj();
        ajVar.iL(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", Long.toString(nVar.getTime()));
            if (nVar.beV() != null) {
                jSONObject.put("content", nVar.beV().toString());
            } else {
                jSONObject.put("content", nVar.getContent());
            }
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.beU())) {
                jSONObject.put("abtest", nVar.beU());
                ajVar.yN("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.beQ()) {
                jSONObject.put("of", "1");
            }
            jSONObject.put("idtype", this.oSM.yC(nVar.getId()));
            jSONObject.put("isreal", this.oSM.Xs(nVar.getId()) ? "1" : "0");
            String Xt = this.oSM.Xt(nVar.getId());
            if (!TextUtils.isEmpty(Xt) && !TextUtils.equals(Xt, "0")) {
                jSONObject.put("gflow", Xt);
            }
            ajVar.dk(jSONObject);
            ajVar.y(nVar.getTime(), nVar.getTime());
            return ajVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void beu() {
        if (isNetWorkEnabled(this.mContext) && bev()) {
            aj ajVar = new aj();
            ajVar.iL(true);
            if (this.exY == null) {
                bes();
            }
            if (!a(ajVar, "1")) {
                a(this.exY, ajVar);
                b(ajVar);
                bew();
            }
        }
    }

    private void a(SparseArray<ArrayList> sparseArray, aj ajVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size() && !ajVar.mp(com.baidu.fsg.base.statistics.b.c)) {
                this.oSG.a(sparseArray.valueAt(i2), ajVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean bev() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.exW) > 86400000) {
            this.exX = 0;
            this.exW = currentTimeMillis;
            ai.eib().putLong("ubc_reset_real_time_count_time", this.exW);
            ai.eib().putInt("ubc_real_time_count", this.exX);
        }
        if (this.exX >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.exX == 10000) {
                this.exX++;
                if (!DEBUG) {
                    ac.ehX().XE(String.valueOf(10000));
                }
            }
            return false;
        }
        return true;
    }

    private void bew() {
        this.exX++;
        ai.eib().putInt("ubc_real_time_count", this.exX);
    }

    private void bex() {
        if (isNetWorkEnabled(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.exV = System.currentTimeMillis();
            ai.eib().putLong("ubc_last_upload_non_real", this.exV);
            bez();
            bet();
            this.oSG.bem();
            HashSet hashSet = new HashSet();
            if (this.exY == null) {
                bes();
            }
            aj ajVar = new aj();
            ajVar.iL(false);
            int i = 0;
            for (int i2 = 0; i2 < this.exY.size(); i2++) {
                int keyAt = this.exY.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.exZ.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * AppStatusRules.DEFAULT_GRANULARITY)) - System.currentTimeMillis() < this.oSM.beE()) {
                        i |= this.oSG.a(this.exY.valueAt(i2), ajVar);
                        this.exZ.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.exY.size(); i3++) {
                    int keyAt2 = this.exY.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ajVar.mp(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.oSG.a(this.exY.valueAt(i3), ajVar);
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
            this.oSG.bem();
            aj ajVar = new aj();
            ajVar.Nn(this.oSM.ehG());
            ajVar.iL(true);
            aj ajVar2 = new aj();
            ajVar2.Nn(this.oSM.ehG());
            ajVar2.iL(false);
            if (this.oSG.a(ajVar, ajVar2) != 0) {
                if (DEBUG) {
                    int length = ajVar.bfw().length();
                    Log.d("UBCBehaviorModel", "real size = " + length + "   no real  = " + ajVar2.bfw().length());
                }
                if (ajVar.bfw().length() > 0) {
                    b(ajVar);
                }
                if (ajVar2.bfw().length() > 0) {
                    b(ajVar2);
                }
            }
        }
    }

    private void b(aj ajVar) {
        if (!ajVar.isEmpty()) {
            try {
                JSONObject eie = ajVar.eie();
                String md5 = ah.toMd5(eie.toString().getBytes(), true);
                du(eie.toString(), md5);
                if (DEBUG) {
                    z.d(ajVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.oSG.a(ajVar.bfr(), ajVar.bfs(), ajVar.bfx(), md5)) {
                    ajVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.oSG.yr(md5);
                    return;
                }
                d.ehB().B(eie, md5);
                ajVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.oSK) >= 7200000) {
                    this.oSK = currentTimeMillis;
                    ai.eib().putLong("ubc_last_upload_failed_data_time", this.oSK);
                    d.ehB().beB();
                }
            } catch (OutOfMemoryError e) {
                ajVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean k = this.oSL.k(jSONObject, z);
        if (tVar != null) {
            tVar.a(k, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.ehB().au(str, k);
        }
    }

    private void bez() {
        iI(true);
        iI(false);
    }

    private void iI(boolean z) {
        aj ajVar = new aj();
        ajVar.iL(z);
        if (this.oSH.a(ajVar, z)) {
            JSONObject eie = ajVar.eie();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + eie.toString());
            }
            this.oSH.iH(z);
            d.ehB().eP(eie);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w wVar, boolean z, s sVar) {
        int i = 0;
        JSONArray jSONArray = new JSONArray();
        this.oSN = 0;
        this.oSO = 0;
        this.oSP = 0;
        b(wVar, z, jSONArray);
        a(wVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.oSN + this.oSO + this.oSP), Integer.valueOf(this.oSN), Integer.valueOf(this.oSP)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.oSM.be(wVar.bfj());
        int bfi = wVar.bfi();
        if (bfi > 0) {
            this.oSM.mh(bfi * 86400000);
        }
        if (wVar.bfh() > 0) {
            this.oSM.mi(wVar.bfh());
        }
        int ehR = wVar.ehR();
        if (ehR > 307200) {
            this.oSM.Nh(ehR);
        }
        int ehS = wVar.ehS();
        if (ehS > 30720) {
            this.oSM.Ni(ehS);
        }
        if (this.exY == null) {
            this.exY = new SparseArray<>();
        }
        this.exY.clear();
        if (this.exZ == null) {
            this.exZ = new HashMap<>();
        }
        this.exZ.clear();
        this.oSG.e(this.exY);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.exY.size()) {
                int keyAt = this.exY.keyAt(i2);
                i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                this.exZ.put("ubc_last_upload_time_level_" + keyAt, 0L);
                i2++;
            } else {
                this.oSM.mg(i3);
                wVar.bfj().clear();
                return;
            }
        }
    }

    void a(w wVar, boolean z, JSONArray jSONArray) {
        List<k> bfj = wVar.bfj();
        if (bfj != null && bfj.size() != 0) {
            ArrayList arrayList = new ArrayList(bfj);
            if (this.oSG.ehU() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((k) it.next()).getId());
                }
                HashMap<String, String> bi = this.oSG.bi(arrayList2);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    k kVar = (k) it2.next();
                    String id = kVar.getId();
                    String str = bi.get(id);
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
                                this.oSP++;
                            } else if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && TextUtils.equals(kVar.ehK(), "1")) {
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
            boolean gr = this.oSG.gr(arrayList);
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                k kVar2 = (k) it3.next();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("product", "set/" + kVar2.getId());
                    jSONObject3.put("version", kVar2.getVersion());
                    if (gr) {
                        jSONObject3.put(CloudControlUBCUtils.KEY_VALID, "1");
                        this.oSN++;
                    } else {
                        jSONObject3.put(CloudControlUBCUtils.KEY_VALID, "0");
                        this.oSO++;
                    }
                } catch (JSONException e3) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "Json格式转化失败");
                    }
                }
                jSONArray.put(jSONObject3);
            }
            wVar.fv(arrayList);
        }
    }

    void b(w wVar, boolean z, JSONArray jSONArray) {
        String str;
        JSONObject ehQ = wVar.ehQ();
        if (ehQ != null) {
            Iterator<String> keys = ehQ.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k XB = this.oSG.XB(next);
                    String optString = ehQ.optString(next, "0");
                    if (XB == null) {
                        str = "0";
                    } else {
                        str = XB.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.oSP++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.oSG.XC(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.oSO++;
                        } else {
                            this.oSN++;
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
    private void du(String str, String str2) {
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
            z.yL("save to file suc");
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
    public void yt(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        z.yL("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            z.yL("delete file suc");
        }
        this.oSG.yr(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yu(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        z.yL("upload file fail");
        this.oSG.ys(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beB() {
        File[] listFiles;
        if (isNetWorkEnabled(this.mContext)) {
            File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 1000) {
                    if (!DEBUG) {
                        ac.ehX().ci(String.valueOf(1000), listFiles.length);
                    }
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.oSG.ben();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o XD = this.oSG.XD(listFiles[i].getName());
                    if (XD != null && TextUtils.equals("0", XD.beY())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        z.yL("processFailedData file, no need to send");
                    } else if (XD != null && TextUtils.equals("1", XD.beY())) {
                        z.yL("processFailedData file, send");
                        this.oSG.dt(listFiles[i].getName(), "0");
                        yv(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        z.yL("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1409=5, 1411=4, 1412=4, 1413=4] */
    void yv(String str) {
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
                            d.ehB().B(jSONObject, str);
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
    public void beC() {
        this.oSG.beo();
    }

    private boolean a(aj ajVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> dKp = UBC.getUBCContext().dKp();
            if (dKp == null || dKp.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= dKp.size()) {
                    break;
                }
                arrayList.add(new j(dKp.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.oSG.a(arrayList, ajVar);
            b(ajVar);
            bew();
            return true;
        }
        return false;
    }

    public String getUploadType(String str) {
        return this.oSM != null ? this.oSM.getUploadType(str) : "";
    }
}
