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
    private int oSd;
    private long oSe;
    private x oSg;
    private b oSh;
    private long oSk;
    private u oSl;
    private g oSm;
    private int oSn;
    private int oSo;
    private int oSp;
    private boolean oSf = false;
    private int oSi = 0;
    private long oSj = 0;
    private Runnable oSq = new Runnable() { // from class: com.baidu.ubc.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.oSi == 1) {
                long uptimeMillis = SystemClock.uptimeMillis() - c.this.oSj;
                if (uptimeMillis >= 5000) {
                    if (c.DEBUG) {
                        Log.d("UBCBehaviorModel", String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis)));
                    }
                    c.this.bet();
                    c.this.oSi = 0;
                    return;
                }
                d.eht().e(this, 5000 - uptimeMillis);
            } else if (c.this.oSi == 2) {
                c.this.oSi = 0;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ai ehT = ai.ehT();
        this.oSg = new x(context);
        this.oSh = new b(context);
        this.oSl = ag.ehS();
        this.exT = new ArrayList(20);
        this.exV = ehT.getLong("ubc_last_upload_non_real", 0L);
        this.exW = ehT.getLong("ubc_reset_real_time_count_time", 0L);
        this.oSk = ehT.getLong("ubc_last_upload_failed_data_time", 0L);
        this.exX = ehT.getInt("ubc_real_time_count", 0);
        this.oSm = g.ehx();
        this.oSm.a(this, context);
        this.oSe = System.currentTimeMillis();
        this.oSd = new Random().nextInt(31) + 60;
    }

    private void bes() {
        int i = 0;
        if (this.exY == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.exY = new SparseArray<>();
            this.oSg.e(this.exY);
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
                    this.oSm.mg(i3);
                    return;
                }
            }
        }
    }

    public x ehs() {
        return this.oSg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.beS()) && this.oSm.yw(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.oSg.b(nVar);
                return;
            }
            List<String> dKh = UBC.getUBCContext().dKh();
            if (dKh == null || !dKh.contains(nVar.getId())) {
                this.oSg.b(nVar);
                return;
            } else if (!this.oSf) {
                if ((System.currentTimeMillis() - this.oSe) / 1000 >= this.oSd) {
                    this.oSf = true;
                } else {
                    this.oSg.b(nVar);
                    return;
                }
            }
        }
        if (z && !g(nVar)) {
            if (this.oSm.Xe(nVar.getId())) {
                this.oSg.b(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.oSg.bem();
        } else if (Math.abs(System.currentTimeMillis() - this.exV) >= g.ehx().beE()) {
            if (!z && this.oSm.Xe(nVar.getId())) {
                e(nVar);
            }
            bex();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.oSm.Xe(nVar.getId())) {
                e(nVar);
            }
            if (this.exT.size() >= 20) {
                bet();
            }
        } else if (!z && this.oSm.Xe(nVar.getId())) {
            this.oSg.b(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(n nVar) {
        this.oSh.a(nVar, this.oSm.yw(nVar.getId()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(n nVar) {
        if (com.baidu.pyramid.runtime.multiprocess.a.aeb()) {
            this.oSh.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bet() {
        if (this.exT != null && this.exT.size() != 0) {
            this.oSg.bc(this.exT);
            this.exT.clear();
            if (this.oSi == 1) {
                this.oSi = 2;
            }
        }
    }

    private void e(n nVar) {
        this.exT.add(nVar);
        if (this.oSi == 0) {
            this.oSj = SystemClock.uptimeMillis();
            d.eht().e(this.oSq, 5000L);
            this.oSi = 1;
        } else if (this.oSi == 2) {
            this.oSj = SystemClock.uptimeMillis();
            this.oSi = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.oSg.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.oSg.i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> dKh;
        bet();
        this.oSg.a(str, i, j, jSONArray);
        boolean yw = this.oSm.yw(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (yw && (dKh = UBC.getUBCContext().dKh()) != null && dKh.contains(str)) {
                if (!this.oSf) {
                    if ((System.currentTimeMillis() - this.oSe) / 1000 >= this.oSd) {
                        this.oSf = true;
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
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.exV) >= g.ehx().beE()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bex();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(String str, int i) {
        bet();
        this.oSg.O(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.exV) >= g.ehx().beE()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bex();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(n nVar) {
        if (isNetWorkEnabled(this.mContext)) {
            nVar.Xm("1");
            aj h = h(nVar);
            if (h.isEmpty()) {
                return false;
            }
            this.oSg.c(h);
            d.eht().a(h.ehW(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.oSg.b(nVar2);
                    } else {
                        c.this.oSg.ehL();
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
            jSONObject.put("idtype", this.oSm.yC(nVar.getId()));
            jSONObject.put("isreal", this.oSm.Xg(nVar.getId()) ? "1" : "0");
            String Xh = this.oSm.Xh(nVar.getId());
            if (!TextUtils.isEmpty(Xh) && !TextUtils.equals(Xh, "0")) {
                jSONObject.put("gflow", Xh);
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
                this.oSg.a(sparseArray.valueAt(i2), ajVar);
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
            ai.ehT().putLong("ubc_reset_real_time_count_time", this.exW);
            ai.ehT().putInt("ubc_real_time_count", this.exX);
        }
        if (this.exX >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.exX == 10000) {
                this.exX++;
                if (!DEBUG) {
                    ac.ehP().Xs(String.valueOf(10000));
                }
            }
            return false;
        }
        return true;
    }

    private void bew() {
        this.exX++;
        ai.ehT().putInt("ubc_real_time_count", this.exX);
    }

    private void bex() {
        if (isNetWorkEnabled(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.exV = System.currentTimeMillis();
            ai.ehT().putLong("ubc_last_upload_non_real", this.exV);
            bez();
            bet();
            this.oSg.bem();
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
                    if (longValue == 0 || (longValue + (keyAt * AppStatusRules.DEFAULT_GRANULARITY)) - System.currentTimeMillis() < this.oSm.beE()) {
                        i |= this.oSg.a(this.exY.valueAt(i2), ajVar);
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
                        this.oSg.a(this.exY.valueAt(i3), ajVar);
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
            this.oSg.bem();
            aj ajVar = new aj();
            ajVar.Nm(this.oSm.ehy());
            ajVar.iL(true);
            aj ajVar2 = new aj();
            ajVar2.Nm(this.oSm.ehy());
            ajVar2.iL(false);
            if (this.oSg.a(ajVar, ajVar2) != 0) {
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
                JSONObject ehW = ajVar.ehW();
                String md5 = ah.toMd5(ehW.toString().getBytes(), true);
                du(ehW.toString(), md5);
                if (DEBUG) {
                    z.d(ajVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.oSg.a(ajVar.bfr(), ajVar.bfs(), ajVar.bfx(), md5)) {
                    ajVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.oSg.yr(md5);
                    return;
                }
                d.eht().B(ehW, md5);
                ajVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.oSk) >= 7200000) {
                    this.oSk = currentTimeMillis;
                    ai.ehT().putLong("ubc_last_upload_failed_data_time", this.oSk);
                    d.eht().beB();
                }
            } catch (OutOfMemoryError e) {
                ajVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean k = this.oSl.k(jSONObject, z);
        if (tVar != null) {
            tVar.a(k, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.eht().au(str, k);
        }
    }

    private void bez() {
        iI(true);
        iI(false);
    }

    private void iI(boolean z) {
        aj ajVar = new aj();
        ajVar.iL(z);
        if (this.oSh.a(ajVar, z)) {
            JSONObject ehW = ajVar.ehW();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + ehW.toString());
            }
            this.oSh.iH(z);
            d.eht().eP(ehW);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w wVar, boolean z, s sVar) {
        int i = 0;
        JSONArray jSONArray = new JSONArray();
        this.oSn = 0;
        this.oSo = 0;
        this.oSp = 0;
        b(wVar, z, jSONArray);
        a(wVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.oSn + this.oSo + this.oSp), Integer.valueOf(this.oSn), Integer.valueOf(this.oSp)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.oSm.be(wVar.bfj());
        int bfi = wVar.bfi();
        if (bfi > 0) {
            this.oSm.mh(bfi * 86400000);
        }
        if (wVar.bfh() > 0) {
            this.oSm.mi(wVar.bfh());
        }
        int ehJ = wVar.ehJ();
        if (ehJ > 307200) {
            this.oSm.Ng(ehJ);
        }
        int ehK = wVar.ehK();
        if (ehK > 30720) {
            this.oSm.Nh(ehK);
        }
        if (this.exY == null) {
            this.exY = new SparseArray<>();
        }
        this.exY.clear();
        if (this.exZ == null) {
            this.exZ = new HashMap<>();
        }
        this.exZ.clear();
        this.oSg.e(this.exY);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.exY.size()) {
                int keyAt = this.exY.keyAt(i2);
                i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                this.exZ.put("ubc_last_upload_time_level_" + keyAt, 0L);
                i2++;
            } else {
                this.oSm.mg(i3);
                wVar.bfj().clear();
                return;
            }
        }
    }

    void a(w wVar, boolean z, JSONArray jSONArray) {
        List<k> bfj = wVar.bfj();
        if (bfj != null && bfj.size() != 0) {
            ArrayList arrayList = new ArrayList(bfj);
            if (this.oSg.ehM() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((k) it.next()).getId());
                }
                HashMap<String, String> bi = this.oSg.bi(arrayList2);
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
                                this.oSp++;
                            } else if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && TextUtils.equals(kVar.ehC(), "1")) {
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
            boolean gr = this.oSg.gr(arrayList);
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                k kVar2 = (k) it3.next();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("product", "set/" + kVar2.getId());
                    jSONObject3.put("version", kVar2.getVersion());
                    if (gr) {
                        jSONObject3.put(CloudControlUBCUtils.KEY_VALID, "1");
                        this.oSn++;
                    } else {
                        jSONObject3.put(CloudControlUBCUtils.KEY_VALID, "0");
                        this.oSo++;
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
        JSONObject ehI = wVar.ehI();
        if (ehI != null) {
            Iterator<String> keys = ehI.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k Xp = this.oSg.Xp(next);
                    String optString = ehI.optString(next, "0");
                    if (Xp == null) {
                        str = "0";
                    } else {
                        str = Xp.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.oSp++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.oSg.Xq(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.oSo++;
                        } else {
                            this.oSn++;
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
        this.oSg.yr(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yu(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        z.yL("upload file fail");
        this.oSg.ys(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beB() {
        File[] listFiles;
        if (isNetWorkEnabled(this.mContext)) {
            File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 1000) {
                    if (!DEBUG) {
                        ac.ehP().ci(String.valueOf(1000), listFiles.length);
                    }
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.oSg.ben();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o Xr = this.oSg.Xr(listFiles[i].getName());
                    if (Xr != null && TextUtils.equals("0", Xr.beY())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        z.yL("processFailedData file, no need to send");
                    } else if (Xr != null && TextUtils.equals("1", Xr.beY())) {
                        z.yL("processFailedData file, send");
                        this.oSg.dt(listFiles[i].getName(), "0");
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
                            d.eht().B(jSONObject, str);
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
        this.oSg.beo();
    }

    private boolean a(aj ajVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> dKh = UBC.getUBCContext().dKh();
            if (dKh == null || dKh.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= dKh.size()) {
                    break;
                }
                arrayList.add(new j(dKh.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.oSg.a(arrayList, ajVar);
            b(ajVar);
            bew();
            return true;
        }
        return false;
    }

    public String getUploadType(String str) {
        return this.oSm != null ? this.oSm.getUploadType(str) : "";
    }
}
