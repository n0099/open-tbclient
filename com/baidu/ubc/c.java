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
/* loaded from: classes15.dex */
public class c {
    private static final boolean DEBUG = AppConfig.isDebug();
    private List<n> eqQ;
    private long eqS;
    private long eqT;
    private int eqU;
    private SparseArray<ArrayList> eqV;
    private HashMap<String, Long> eqW;
    private Context mContext;
    private int oGA;
    private int oGB;
    private int oGC;
    private int oGq;
    private long oGr;
    private x oGt;
    private b oGu;
    private long oGx;
    private u oGy;
    private g oGz;
    private boolean oGs = false;
    private int oGv = 0;
    private long oGw = 0;
    private Runnable oGD = new Runnable() { // from class: com.baidu.ubc.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.oGv == 1) {
                long uptimeMillis = SystemClock.uptimeMillis() - c.this.oGw;
                if (uptimeMillis >= 5000) {
                    if (c.DEBUG) {
                        Log.d("UBCBehaviorModel", String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis)));
                    }
                    c.this.bfC();
                    c.this.oGv = 0;
                    return;
                }
                d.eiI().e(this, 5000 - uptimeMillis);
            } else if (c.this.oGv == 2) {
                c.this.oGv = 0;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ai eji = ai.eji();
        this.oGt = new x(context);
        this.oGu = new b(context);
        this.oGy = ag.ejh();
        this.eqQ = new ArrayList(20);
        this.eqS = eji.getLong("ubc_last_upload_non_real", 0L);
        this.eqT = eji.getLong("ubc_reset_real_time_count_time", 0L);
        this.oGx = eji.getLong("ubc_last_upload_failed_data_time", 0L);
        this.eqU = eji.getInt("ubc_real_time_count", 0);
        this.oGz = g.eiM();
        this.oGz.a(this, context);
        this.oGr = System.currentTimeMillis();
        this.oGq = new Random().nextInt(31) + 60;
    }

    private void bfB() {
        if (this.eqV == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.eqV = new SparseArray<>();
            this.oGt.b(this.eqV);
            this.eqW = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.eqV.size(); i2++) {
                int keyAt = this.eqV.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.eqW.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.oGz.nA(i);
        }
    }

    public x eiH() {
        return this.oGt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.bgb()) && this.oGz.zp(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.oGt.b(nVar);
                return;
            }
            List<String> dLV = UBC.getUBCContext().dLV();
            if (dLV == null || !dLV.contains(nVar.getId())) {
                this.oGt.b(nVar);
                return;
            } else if (!this.oGs) {
                if ((System.currentTimeMillis() - this.oGr) / 1000 >= this.oGq) {
                    this.oGs = true;
                } else {
                    this.oGt.b(nVar);
                    return;
                }
            }
        }
        if (z && !g(nVar)) {
            if (this.oGz.XE(nVar.getId())) {
                this.oGt.b(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.oGt.bfv();
        } else if (Math.abs(System.currentTimeMillis() - this.eqS) >= g.eiM().bfN()) {
            if (!z && this.oGz.XE(nVar.getId())) {
                e(nVar);
            }
            bfG();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.oGz.XE(nVar.getId())) {
                e(nVar);
            }
            if (this.eqQ.size() >= 20) {
                bfC();
            }
        } else if (!z && this.oGz.XE(nVar.getId())) {
            this.oGt.b(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(n nVar) {
        this.oGu.a(nVar, this.oGz.zp(nVar.getId()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(n nVar) {
        if (com.baidu.pyramid.runtime.multiprocess.a.afH()) {
            this.oGu.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfC() {
        if (this.eqQ != null && this.eqQ.size() != 0) {
            this.oGt.ba(this.eqQ);
            this.eqQ.clear();
            if (this.oGv == 1) {
                this.oGv = 2;
            }
        }
    }

    private void e(n nVar) {
        this.eqQ.add(nVar);
        if (this.oGv == 0) {
            this.oGw = SystemClock.uptimeMillis();
            d.eiI().e(this.oGD, 5000L);
            this.oGv = 1;
        } else if (this.oGv == 2) {
            this.oGw = SystemClock.uptimeMillis();
            this.oGv = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.oGt.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.oGt.i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> dLV;
        bfC();
        this.oGt.a(str, i, j, jSONArray);
        boolean zp = this.oGz.zp(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (zp && (dLV = UBC.getUBCContext().dLV()) != null && dLV.contains(str)) {
                if (!this.oGs) {
                    if ((System.currentTimeMillis() - this.oGr) / 1000 >= this.oGq) {
                        this.oGs = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (zp) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            bfD();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.eqS) >= g.eiM().bfN()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bfG();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(String str, int i) {
        bfC();
        this.oGt.L(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.eqS) >= g.eiM().bfN()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bfG();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(n nVar) {
        if (isNetWorkEnabled(this.mContext)) {
            nVar.XM("1");
            aj h = h(nVar);
            if (h.isEmpty()) {
                return false;
            }
            this.oGt.c(h);
            d.eiI().a(h.ejl(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.oGt.b(nVar2);
                    } else {
                        c.this.oGt.eja();
                    }
                }
            });
            h.clearData();
            return true;
        }
        return false;
    }

    private boolean g(n nVar) {
        if (isNetWorkEnabled(this.mContext) && bfE()) {
            bfC();
            aj h = h(nVar);
            if (h != null) {
                if (this.eqV == null) {
                    bfB();
                }
                if (a(h, "0")) {
                    return true;
                }
                a(this.eqV, h);
                b(h);
                bfF();
                return true;
            }
            return false;
        }
        return false;
    }

    private aj h(n nVar) {
        aj ajVar = new aj();
        ajVar.is(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", Long.toString(nVar.getTime()));
            if (nVar.bge() != null) {
                jSONObject.put("content", nVar.bge().toString());
            } else {
                jSONObject.put("content", nVar.getContent());
            }
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.bgd())) {
                jSONObject.put("abtest", nVar.bgd());
                ajVar.zG("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.bfZ()) {
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
            }
            jSONObject.put("idtype", this.oGz.zv(nVar.getId()));
            jSONObject.put("isreal", this.oGz.XG(nVar.getId()) ? "1" : "0");
            String XH = this.oGz.XH(nVar.getId());
            if (!TextUtils.isEmpty(XH) && !TextUtils.equals(XH, "0")) {
                jSONObject.put("gflow", XH);
            }
            ajVar.df(jSONObject);
            ajVar.r(nVar.getTime(), nVar.getTime());
            return ajVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void bfD() {
        if (isNetWorkEnabled(this.mContext) && bfE()) {
            aj ajVar = new aj();
            ajVar.is(true);
            if (this.eqV == null) {
                bfB();
            }
            if (!a(ajVar, "1")) {
                a(this.eqV, ajVar);
                b(ajVar);
                bfF();
            }
        }
    }

    private void a(SparseArray<ArrayList> sparseArray, aj ajVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size() && !ajVar.nJ(com.baidu.fsg.base.statistics.b.c)) {
                this.oGt.a(sparseArray.valueAt(i2), ajVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean bfE() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.eqT) > 86400000) {
            this.eqU = 0;
            this.eqT = currentTimeMillis;
            ai.eji().putLong("ubc_reset_real_time_count_time", this.eqT);
            ai.eji().putInt("ubc_real_time_count", this.eqU);
        }
        if (this.eqU >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.eqU == 10000) {
                this.eqU++;
                if (!DEBUG) {
                    ac.eje().XS(String.valueOf(10000));
                }
            }
            return false;
        }
        return true;
    }

    private void bfF() {
        this.eqU++;
        ai.eji().putInt("ubc_real_time_count", this.eqU);
    }

    private void bfG() {
        if (isNetWorkEnabled(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.eqS = System.currentTimeMillis();
            ai.eji().putLong("ubc_last_upload_non_real", this.eqS);
            bfI();
            bfC();
            this.oGt.bfv();
            HashSet hashSet = new HashSet();
            if (this.eqV == null) {
                bfB();
            }
            aj ajVar = new aj();
            ajVar.is(false);
            int i = 0;
            for (int i2 = 0; i2 < this.eqV.size(); i2++) {
                int keyAt = this.eqV.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.eqW.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.oGz.bfN()) {
                        i |= this.oGt.a(this.eqV.valueAt(i2), ajVar);
                        this.eqW.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.eqV.size(); i3++) {
                    int keyAt2 = this.eqV.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ajVar.nJ(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.oGt.a(this.eqV.valueAt(i3), ajVar);
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
            this.oGt.bfv();
            aj ajVar = new aj();
            ajVar.OI(this.oGz.eiN());
            ajVar.is(true);
            aj ajVar2 = new aj();
            ajVar2.OI(this.oGz.eiN());
            ajVar2.is(false);
            if (this.oGt.a(ajVar, ajVar2) != 0) {
                if (DEBUG) {
                    int length = ajVar.bgF().length();
                    Log.d("UBCBehaviorModel", "real size = " + length + "   no real  = " + ajVar2.bgF().length());
                }
                if (ajVar.bgF().length() > 0) {
                    b(ajVar);
                }
                if (ajVar2.bgF().length() > 0) {
                    b(ajVar2);
                }
            }
        }
    }

    private void b(aj ajVar) {
        if (!ajVar.isEmpty()) {
            try {
                JSONObject ejl = ajVar.ejl();
                String md5 = ah.toMd5(ejl.toString().getBytes(), true);
                dC(ejl.toString(), md5);
                if (DEBUG) {
                    z.d(ajVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.oGt.a(ajVar.bgA(), ajVar.bgB(), ajVar.bgG(), md5)) {
                    ajVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.oGt.zk(md5);
                    return;
                }
                d.eiI().B(ejl, md5);
                ajVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.oGx) >= 7200000) {
                    this.oGx = currentTimeMillis;
                    ai.eji().putLong("ubc_last_upload_failed_data_time", this.oGx);
                    d.eiI().bfK();
                }
            } catch (OutOfMemoryError e) {
                ajVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean i = this.oGy.i(jSONObject, z);
        if (tVar != null) {
            tVar.a(i, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.eiI().av(str, i);
        }
    }

    private void bfI() {
        ip(true);
        ip(false);
    }

    private void ip(boolean z) {
        aj ajVar = new aj();
        ajVar.is(z);
        if (this.oGu.a(ajVar, z)) {
            JSONObject ejl = ajVar.ejl();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + ejl.toString());
            }
            this.oGu.io(z);
            d.eiI().eA(ejl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w wVar, boolean z, s sVar) {
        JSONArray jSONArray = new JSONArray();
        this.oGA = 0;
        this.oGB = 0;
        this.oGC = 0;
        b(wVar, z, jSONArray);
        a(wVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.oGA + this.oGB + this.oGC), Integer.valueOf(this.oGA), Integer.valueOf(this.oGC)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.oGz.bc(wVar.bgs());
        int bgr = wVar.bgr();
        if (bgr > 0) {
            this.oGz.nB(bgr * 86400000);
        }
        if (wVar.bgq() > 0) {
            this.oGz.nC(wVar.bgq());
        }
        int eiY = wVar.eiY();
        if (eiY > 307200) {
            this.oGz.OC(eiY);
        }
        int eiZ = wVar.eiZ();
        if (eiZ > 30720) {
            this.oGz.OD(eiZ);
        }
        if (this.eqV == null) {
            this.eqV = new SparseArray<>();
        }
        this.eqV.clear();
        if (this.eqW == null) {
            this.eqW = new HashMap<>();
        }
        this.eqW.clear();
        this.oGt.b(this.eqV);
        int i = 0;
        for (int i2 = 0; i2 < this.eqV.size(); i2++) {
            int keyAt = this.eqV.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.eqW.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.oGz.nA(i);
        wVar.bgs().clear();
    }

    void a(w wVar, boolean z, JSONArray jSONArray) {
        List<k> bgs = wVar.bgs();
        if (bgs != null && bgs.size() != 0) {
            ArrayList arrayList = new ArrayList(bgs);
            if (this.oGt.ejb() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((k) it.next()).getId());
                }
                HashMap<String, String> bp = this.oGt.bp(arrayList2);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    k kVar = (k) it2.next();
                    String id = kVar.getId();
                    String str = bp.get(id);
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
                                this.oGC++;
                            } else if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && TextUtils.equals(kVar.eiR(), "1")) {
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
            boolean gB = this.oGt.gB(arrayList);
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                k kVar2 = (k) it3.next();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("product", "set/" + kVar2.getId());
                    jSONObject3.put("version", kVar2.getVersion());
                    if (gB) {
                        jSONObject3.put(CloudControlUBCUtils.KEY_VALID, "1");
                        this.oGA++;
                    } else {
                        jSONObject3.put(CloudControlUBCUtils.KEY_VALID, "0");
                        this.oGB++;
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
        JSONObject eiX = wVar.eiX();
        if (eiX != null) {
            Iterator<String> keys = eiX.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k XP = this.oGt.XP(next);
                    String optString = eiX.optString(next, "0");
                    if (XP == null) {
                        str = "0";
                    } else {
                        str = XP.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.oGC++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.oGt.XQ(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.oGB++;
                        } else {
                            this.oGA++;
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
    private void dC(String str, String str2) {
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
            z.zE("save to file suc");
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
    public void zm(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        z.zE("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            z.zE("delete file suc");
        }
        this.oGt.zk(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zn(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        z.zE("upload file fail");
        this.oGt.zl(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfK() {
        File[] listFiles;
        if (isNetWorkEnabled(this.mContext)) {
            File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 1000) {
                    if (!DEBUG) {
                        ac.eje().bY(String.valueOf(1000), listFiles.length);
                    }
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.oGt.bfw();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o XR = this.oGt.XR(listFiles[i].getName());
                    if (XR != null && TextUtils.equals("0", XR.bgh())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        z.zE("processFailedData file, no need to send");
                    } else if (XR != null && TextUtils.equals("1", XR.bgh())) {
                        z.zE("processFailedData file, send");
                        this.oGt.dB(listFiles[i].getName(), "0");
                        zo(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        z.zE("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1409=5, 1411=4, 1412=4, 1413=4] */
    void zo(String str) {
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
                            d.eiI().B(jSONObject, str);
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
    public void bfL() {
        this.oGt.bfx();
    }

    private boolean a(aj ajVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> dLV = UBC.getUBCContext().dLV();
            if (dLV == null || dLV.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= dLV.size()) {
                    break;
                }
                arrayList.add(new j(dLV.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.oGt.a(arrayList, ajVar);
            b(ajVar);
            bfF();
            return true;
        }
        return false;
    }

    public String getUploadType(String str) {
        return this.oGz != null ? this.oGz.getUploadType(str) : "";
    }
}
