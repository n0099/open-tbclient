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
    private List<n> evM;
    private long evO;
    private long evP;
    private int evQ;
    private SparseArray<ArrayList> evR;
    private HashMap<String, Long> evS;
    private Context mContext;
    private int oHV;
    private long oHW;
    private x oHY;
    private b oHZ;
    private long oIc;
    private u oId;
    private g oIe;
    private int oIf;
    private int oIg;
    private int oIh;
    private boolean oHX = false;
    private int oIa = 0;
    private long oIb = 0;
    private Runnable oIi = new Runnable() { // from class: com.baidu.ubc.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.oIa == 1) {
                long uptimeMillis = SystemClock.uptimeMillis() - c.this.oIb;
                if (uptimeMillis >= 5000) {
                    if (c.DEBUG) {
                        Log.d("UBCBehaviorModel", String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis)));
                    }
                    c.this.beg();
                    c.this.oIa = 0;
                    return;
                }
                d.efb().e(this, 5000 - uptimeMillis);
            } else if (c.this.oIa == 2) {
                c.this.oIa = 0;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ai efB = ai.efB();
        this.oHY = new x(context);
        this.oHZ = new b(context);
        this.oId = ag.efA();
        this.evM = new ArrayList(20);
        this.evO = efB.getLong("ubc_last_upload_non_real", 0L);
        this.evP = efB.getLong("ubc_reset_real_time_count_time", 0L);
        this.oIc = efB.getLong("ubc_last_upload_failed_data_time", 0L);
        this.evQ = efB.getInt("ubc_real_time_count", 0);
        this.oIe = g.eff();
        this.oIe.a(this, context);
        this.oHW = System.currentTimeMillis();
        this.oHV = new Random().nextInt(31) + 60;
    }

    private void bef() {
        int i = 0;
        if (this.evR == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.evR = new SparseArray<>();
            this.oHY.e(this.evR);
            this.evS = new HashMap<>();
            int i2 = 0;
            while (true) {
                int i3 = i;
                if (i2 < this.evR.size()) {
                    int keyAt = this.evR.keyAt(i2);
                    i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                    this.evS.put("ubc_last_upload_time_level_" + keyAt, 0L);
                    i2++;
                } else {
                    this.oIe.md(i3);
                    return;
                }
            }
        }
    }

    public x efa() {
        return this.oHY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.beF()) && this.oIe.yd(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.oHY.b(nVar);
                return;
            }
            List<String> dHW = UBC.getUBCContext().dHW();
            if (dHW == null || !dHW.contains(nVar.getId())) {
                this.oHY.b(nVar);
                return;
            } else if (!this.oHX) {
                if ((System.currentTimeMillis() - this.oHW) / 1000 >= this.oHV) {
                    this.oHX = true;
                } else {
                    this.oHY.b(nVar);
                    return;
                }
            }
        }
        if (z && !g(nVar)) {
            if (this.oIe.Wf(nVar.getId())) {
                this.oHY.b(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.oHY.bdZ();
        } else if (Math.abs(System.currentTimeMillis() - this.evO) >= g.eff().ber()) {
            if (!z && this.oIe.Wf(nVar.getId())) {
                e(nVar);
            }
            bek();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.oIe.Wf(nVar.getId())) {
                e(nVar);
            }
            if (this.evM.size() >= 20) {
                beg();
            }
        } else if (!z && this.oIe.Wf(nVar.getId())) {
            this.oHY.b(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(n nVar) {
        this.oHZ.a(nVar, this.oIe.yd(nVar.getId()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(n nVar) {
        if (com.baidu.pyramid.runtime.multiprocess.a.adK()) {
            this.oHZ.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beg() {
        if (this.evM != null && this.evM.size() != 0) {
            this.oHY.bh(this.evM);
            this.evM.clear();
            if (this.oIa == 1) {
                this.oIa = 2;
            }
        }
    }

    private void e(n nVar) {
        this.evM.add(nVar);
        if (this.oIa == 0) {
            this.oIb = SystemClock.uptimeMillis();
            d.efb().e(this.oIi, 5000L);
            this.oIa = 1;
        } else if (this.oIa == 2) {
            this.oIb = SystemClock.uptimeMillis();
            this.oIa = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.oHY.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.oHY.i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> dHW;
        beg();
        this.oHY.a(str, i, j, jSONArray);
        boolean yd = this.oIe.yd(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (yd && (dHW = UBC.getUBCContext().dHW()) != null && dHW.contains(str)) {
                if (!this.oHX) {
                    if ((System.currentTimeMillis() - this.oHW) / 1000 >= this.oHV) {
                        this.oHX = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (yd) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            beh();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.evO) >= g.eff().ber()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bek();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(String str, int i) {
        beg();
        this.oHY.M(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.evO) >= g.eff().ber()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bek();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(n nVar) {
        if (isNetWorkEnabled(this.mContext)) {
            nVar.Wn("1");
            aj h = h(nVar);
            if (h.isEmpty()) {
                return false;
            }
            this.oHY.c(h);
            d.efb().a(h.efE(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.oHY.b(nVar2);
                    } else {
                        c.this.oHY.eft();
                    }
                }
            });
            h.clearData();
            return true;
        }
        return false;
    }

    private boolean g(n nVar) {
        if (isNetWorkEnabled(this.mContext) && bei()) {
            beg();
            aj h = h(nVar);
            if (h != null) {
                if (this.evR == null) {
                    bef();
                }
                if (a(h, "0")) {
                    return true;
                }
                a(this.evR, h);
                b(h);
                bej();
                return true;
            }
            return false;
        }
        return false;
    }

    private aj h(n nVar) {
        aj ajVar = new aj();
        ajVar.iJ(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", Long.toString(nVar.getTime()));
            if (nVar.beI() != null) {
                jSONObject.put("content", nVar.beI().toString());
            } else {
                jSONObject.put("content", nVar.getContent());
            }
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.beH())) {
                jSONObject.put("abtest", nVar.beH());
                ajVar.yu("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.beD()) {
                jSONObject.put("of", "1");
            }
            jSONObject.put("idtype", this.oIe.yj(nVar.getId()));
            jSONObject.put("isreal", this.oIe.Wh(nVar.getId()) ? "1" : "0");
            String Wi = this.oIe.Wi(nVar.getId());
            if (!TextUtils.isEmpty(Wi) && !TextUtils.equals(Wi, "0")) {
                jSONObject.put("gflow", Wi);
            }
            ajVar.dn(jSONObject);
            ajVar.u(nVar.getTime(), nVar.getTime());
            return ajVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void beh() {
        if (isNetWorkEnabled(this.mContext) && bei()) {
            aj ajVar = new aj();
            ajVar.iJ(true);
            if (this.evR == null) {
                bef();
            }
            if (!a(ajVar, "1")) {
                a(this.evR, ajVar);
                b(ajVar);
                bej();
            }
        }
    }

    private void a(SparseArray<ArrayList> sparseArray, aj ajVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size() && !ajVar.mm(com.baidu.fsg.base.statistics.b.c)) {
                this.oHY.a(sparseArray.valueAt(i2), ajVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean bei() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.evP) > 86400000) {
            this.evQ = 0;
            this.evP = currentTimeMillis;
            ai.efB().putLong("ubc_reset_real_time_count_time", this.evP);
            ai.efB().putInt("ubc_real_time_count", this.evQ);
        }
        if (this.evQ >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.evQ == 10000) {
                this.evQ++;
                if (!DEBUG) {
                    ac.efx().Wt(String.valueOf(10000));
                }
            }
            return false;
        }
        return true;
    }

    private void bej() {
        this.evQ++;
        ai.efB().putInt("ubc_real_time_count", this.evQ);
    }

    private void bek() {
        if (isNetWorkEnabled(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.evO = System.currentTimeMillis();
            ai.efB().putLong("ubc_last_upload_non_real", this.evO);
            bem();
            beg();
            this.oHY.bdZ();
            HashSet hashSet = new HashSet();
            if (this.evR == null) {
                bef();
            }
            aj ajVar = new aj();
            ajVar.iJ(false);
            int i = 0;
            for (int i2 = 0; i2 < this.evR.size(); i2++) {
                int keyAt = this.evR.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.evS.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * AppStatusRules.DEFAULT_GRANULARITY)) - System.currentTimeMillis() < this.oIe.ber()) {
                        i |= this.oHY.a(this.evR.valueAt(i2), ajVar);
                        this.evS.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.evR.size(); i3++) {
                    int keyAt2 = this.evR.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ajVar.mm(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.oHY.a(this.evR.valueAt(i3), ajVar);
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
            this.oHY.bdZ();
            aj ajVar = new aj();
            ajVar.MQ(this.oIe.efg());
            ajVar.iJ(true);
            aj ajVar2 = new aj();
            ajVar2.MQ(this.oIe.efg());
            ajVar2.iJ(false);
            if (this.oHY.a(ajVar, ajVar2) != 0) {
                if (DEBUG) {
                    int length = ajVar.bfj().length();
                    Log.d("UBCBehaviorModel", "real size = " + length + "   no real  = " + ajVar2.bfj().length());
                }
                if (ajVar.bfj().length() > 0) {
                    b(ajVar);
                }
                if (ajVar2.bfj().length() > 0) {
                    b(ajVar2);
                }
            }
        }
    }

    private void b(aj ajVar) {
        if (!ajVar.isEmpty()) {
            try {
                JSONObject efE = ajVar.efE();
                String md5 = ah.toMd5(efE.toString().getBytes(), true);
                dA(efE.toString(), md5);
                if (DEBUG) {
                    z.d(ajVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.oHY.a(ajVar.bfe(), ajVar.bff(), ajVar.bfk(), md5)) {
                    ajVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.oHY.xY(md5);
                    return;
                }
                d.efb().B(efE, md5);
                ajVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.oIc) >= 7200000) {
                    this.oIc = currentTimeMillis;
                    ai.efB().putLong("ubc_last_upload_failed_data_time", this.oIc);
                    d.efb().beo();
                }
            } catch (OutOfMemoryError e) {
                ajVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean k = this.oId.k(jSONObject, z);
        if (tVar != null) {
            tVar.a(k, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.efb().av(str, k);
        }
    }

    private void bem() {
        iG(true);
        iG(false);
    }

    private void iG(boolean z) {
        aj ajVar = new aj();
        ajVar.iJ(z);
        if (this.oHZ.a(ajVar, z)) {
            JSONObject efE = ajVar.efE();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + efE.toString());
            }
            this.oHZ.iF(z);
            d.efb().eO(efE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w wVar, boolean z, s sVar) {
        int i = 0;
        JSONArray jSONArray = new JSONArray();
        this.oIf = 0;
        this.oIg = 0;
        this.oIh = 0;
        b(wVar, z, jSONArray);
        a(wVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.oIf + this.oIg + this.oIh), Integer.valueOf(this.oIf), Integer.valueOf(this.oIh)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.oIe.bj(wVar.beW());
        int beV = wVar.beV();
        if (beV > 0) {
            this.oIe.me(beV * 86400000);
        }
        if (wVar.beU() > 0) {
            this.oIe.mf(wVar.beU());
        }
        int efr = wVar.efr();
        if (efr > 307200) {
            this.oIe.MK(efr);
        }
        int efs = wVar.efs();
        if (efs > 30720) {
            this.oIe.ML(efs);
        }
        if (this.evR == null) {
            this.evR = new SparseArray<>();
        }
        this.evR.clear();
        if (this.evS == null) {
            this.evS = new HashMap<>();
        }
        this.evS.clear();
        this.oHY.e(this.evR);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.evR.size()) {
                int keyAt = this.evR.keyAt(i2);
                i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                this.evS.put("ubc_last_upload_time_level_" + keyAt, 0L);
                i2++;
            } else {
                this.oIe.md(i3);
                wVar.beW().clear();
                return;
            }
        }
    }

    void a(w wVar, boolean z, JSONArray jSONArray) {
        List<k> beW = wVar.beW();
        if (beW != null && beW.size() != 0) {
            ArrayList arrayList = new ArrayList(beW);
            if (this.oHY.efu() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((k) it.next()).getId());
                }
                HashMap<String, String> bj = this.oHY.bj(arrayList2);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    k kVar = (k) it2.next();
                    String id = kVar.getId();
                    String str = bj.get(id);
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
                                this.oIh++;
                            } else if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && TextUtils.equals(kVar.efk(), "1")) {
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
            boolean gt = this.oHY.gt(arrayList);
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                k kVar2 = (k) it3.next();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("product", "set/" + kVar2.getId());
                    jSONObject3.put("version", kVar2.getVersion());
                    if (gt) {
                        jSONObject3.put(CloudControlUBCUtils.KEY_VALID, "1");
                        this.oIf++;
                    } else {
                        jSONObject3.put(CloudControlUBCUtils.KEY_VALID, "0");
                        this.oIg++;
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
        JSONObject efq = wVar.efq();
        if (efq != null) {
            Iterator<String> keys = efq.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k Wq = this.oHY.Wq(next);
                    String optString = efq.optString(next, "0");
                    if (Wq == null) {
                        str = "0";
                    } else {
                        str = Wq.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.oIh++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.oHY.Wr(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.oIg++;
                        } else {
                            this.oIf++;
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
    private void dA(String str, String str2) {
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
            z.ys("save to file suc");
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
    public void ya(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        z.ys("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            z.ys("delete file suc");
        }
        this.oHY.xY(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yb(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        z.ys("upload file fail");
        this.oHY.xZ(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beo() {
        File[] listFiles;
        if (isNetWorkEnabled(this.mContext)) {
            File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 1000) {
                    if (!DEBUG) {
                        ac.efx().ch(String.valueOf(1000), listFiles.length);
                    }
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.oHY.bea();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o Ws = this.oHY.Ws(listFiles[i].getName());
                    if (Ws != null && TextUtils.equals("0", Ws.beL())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        z.ys("processFailedData file, no need to send");
                    } else if (Ws != null && TextUtils.equals("1", Ws.beL())) {
                        z.ys("processFailedData file, send");
                        this.oHY.dz(listFiles[i].getName(), "0");
                        yc(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        z.ys("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1409=5, 1411=4, 1412=4, 1413=4] */
    void yc(String str) {
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
                            d.efb().B(jSONObject, str);
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
    public void bep() {
        this.oHY.beb();
    }

    private boolean a(aj ajVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> dHW = UBC.getUBCContext().dHW();
            if (dHW == null || dHW.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= dHW.size()) {
                    break;
                }
                arrayList.add(new j(dHW.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.oHY.a(arrayList, ajVar);
            b(ajVar);
            bej();
            return true;
        }
        return false;
    }

    public String getUploadType(String str) {
        return this.oIe != null ? this.oIe.getUploadType(str) : "";
    }
}
