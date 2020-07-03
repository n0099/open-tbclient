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
    private List<n> dua;
    private long dub;
    private long duc;
    private long dud;
    private int due;
    private SparseArray<ArrayList> duf;
    private HashMap<String, Long> dug;
    private Context mContext;
    private int mDA;
    private int mDB;
    private int mDp;
    private long mDq;
    private boolean mDr = false;
    private w mDs;
    private b mDt;
    private long mDu;
    private u mDv;
    private g mDw;
    private int mDz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ag dwY = ag.dwY();
        this.mDs = new w(context);
        this.mDt = new b(context);
        this.mDv = ae.dwX();
        this.dua = new ArrayList(20);
        this.dub = dwY.getLong("ubc_last_upload_all_time", 0L);
        this.duc = dwY.getLong("ubc_last_upload_non_real", 0L);
        this.dud = dwY.getLong("ubc_reset_real_time_count_time", 0L);
        this.mDu = dwY.getLong("ubc_last_upload_failed_data_time", 0L);
        this.due = dwY.getInt("ubc_real_time_count", 0);
        this.mDw = g.dwI();
        this.mDw.a(this, context);
        this.mDq = System.currentTimeMillis();
        int nextInt = new Random().nextInt(31) + 60;
        this.mDp = nextInt;
        new Timer().schedule(new TimerTask() { // from class: com.baidu.ubc.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!c.this.mDr) {
                    ah ahVar = new ah();
                    ahVar.gu(true);
                    c.this.a(ahVar, "0");
                }
            }
        }, nextInt * 1000);
    }

    private void aIY() {
        if (this.duf == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.duf = new SparseArray<>();
            this.mDs.b(this.duf);
            this.dug = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.duf.size(); i2++) {
                int keyAt = this.duf.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.dug.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.mDw.jE(i);
        }
    }

    public w dwF() {
        return this.mDs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.aJy()) && this.mDw.tM(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.mDs.a(nVar);
                return;
            }
            List<String> deO = UBC.getUBCContext().deO();
            if (deO == null || !deO.contains(nVar.getId())) {
                this.mDs.a(nVar);
                return;
            } else if (!this.mDr) {
                if ((System.currentTimeMillis() - this.mDq) / 1000 >= this.mDp) {
                    this.mDr = true;
                } else {
                    this.mDs.a(nVar);
                    return;
                }
            }
        }
        if (z && !d(nVar)) {
            if (this.mDw.PO(nVar.getId())) {
                this.mDs.a(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.mDs.aIS();
        } else if (Math.abs(System.currentTimeMillis() - this.duc) >= g.dwI().aJk()) {
            if (!z && this.mDw.PO(nVar.getId())) {
                this.dua.add(nVar);
            }
            aJd();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.mDw.PO(nVar.getId())) {
                this.dua.add(nVar);
            }
            if (this.dua.size() >= 20) {
                aIZ();
            }
        } else if (!z && this.mDw.PO(nVar.getId())) {
            this.mDs.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        this.mDt.a(nVar, this.mDw.tM(nVar.getId()));
    }

    private void aIZ() {
        if (this.dua != null && this.dua.size() != 0) {
            this.mDs.at(this.dua);
            this.dua.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.mDs.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.mDs.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> deO;
        aIZ();
        this.mDs.a(str, i, j, jSONArray);
        boolean tM = this.mDw.tM(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (tM && (deO = UBC.getUBCContext().deO()) != null && deO.contains(str)) {
                if (!this.mDr) {
                    if ((System.currentTimeMillis() - this.mDq) / 1000 >= this.mDp) {
                        this.mDr = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (tM) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            aJa();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.duc) >= g.dwI().aJk()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aJd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(String str, int i) {
        aIZ();
        this.mDs.G(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.duc) >= g.dwI().aJk()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aJd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(n nVar) {
        if (dy(this.mContext)) {
            nVar.PU("1");
            ah e = e(nVar);
            if (e.isEmpty()) {
                return false;
            }
            this.mDs.d(e);
            d.dwG().a(e.dxa(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.mDs.a(nVar2);
                    } else {
                        c.this.mDs.dwS();
                    }
                }
            });
            e.clearData();
            return true;
        }
        return false;
    }

    private boolean d(n nVar) {
        if (dy(this.mContext) && aJb()) {
            aIZ();
            ah e = e(nVar);
            if (e != null) {
                if (this.duf == null) {
                    aIY();
                }
                if (a(e, "0")) {
                    return true;
                }
                a(this.duf, e);
                b(e);
                aJc();
                return true;
            }
            return false;
        }
        return false;
    }

    private ah e(n nVar) {
        ah ahVar = new ah();
        ahVar.gu(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", Long.toString(nVar.getTime()));
            if (nVar.aJB() != null) {
                jSONObject.put("content", nVar.aJB().toString());
            } else {
                jSONObject.put("content", nVar.getContent());
            }
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.aJA())) {
                jSONObject.put("abtest", nVar.aJA());
                ahVar.ud("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.aJw()) {
                jSONObject.put("of", "1");
            }
            jSONObject.put("idtype", this.mDw.tS(nVar.getId()));
            jSONObject.put("isreal", this.mDw.PQ(nVar.getId()) ? "1" : "0");
            String PR = this.mDw.PR(nVar.getId());
            if (!TextUtils.isEmpty(PR) && !TextUtils.equals(PR, "0")) {
                jSONObject.put("gflow", PR);
            }
            ahVar.cE(jSONObject);
            ahVar.s(nVar.getTime(), nVar.getTime());
            return ahVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void aJa() {
        if (dy(this.mContext) && aJb()) {
            ah ahVar = new ah();
            ahVar.gu(true);
            if (this.duf == null) {
                aIY();
            }
            if (!a(ahVar, "1")) {
                a(this.duf, ahVar);
                b(ahVar);
                aJc();
            }
        }
    }

    private void a(SparseArray<ArrayList> sparseArray, ah ahVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size() && !ahVar.jN(com.baidu.fsg.base.statistics.b.c)) {
                this.mDs.a(sparseArray.valueAt(i2), ahVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean aJb() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.dud) > 86400000) {
            this.due = 0;
            this.dud = currentTimeMillis;
            ag.dwY().putLong("ubc_reset_real_time_count_time", this.dud);
            ag.dwY().putInt("ubc_real_time_count", this.due);
        }
        if (this.due >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.due == 10000) {
                this.due++;
                if (!DEBUG) {
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
                }
            }
            return false;
        }
        return true;
    }

    private void aJc() {
        this.due++;
        ag.dwY().putInt("ubc_real_time_count", this.due);
    }

    private void aJd() {
        if (dy(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.duc = System.currentTimeMillis();
            ag.dwY().putLong("ubc_last_upload_non_real", this.duc);
            aJf();
            aIZ();
            this.mDs.aIS();
            HashSet hashSet = new HashSet();
            if (this.duf == null) {
                aIY();
            }
            ah ahVar = new ah();
            ahVar.gu(false);
            int i = 0;
            for (int i2 = 0; i2 < this.duf.size(); i2++) {
                int keyAt = this.duf.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.dug.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.mDw.aJk()) {
                        i |= this.mDs.a(this.duf.valueAt(i2), ahVar);
                        this.dug.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.duf.size(); i3++) {
                    int keyAt2 = this.duf.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ahVar.jN(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.mDs.a(this.duf.valueAt(i3), ahVar);
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
    public void aJe() {
        if (dy(this.mContext) && Math.abs(System.currentTimeMillis() - this.dub) >= BdKVCache.MILLS_1Hour) {
            this.mDs.aIS();
            ah ahVar = new ah();
            if (this.mDs.c(ahVar) != 0) {
                ah ahVar2 = new ah();
                ahVar2.s(ahVar.aKc(), ahVar.getMaxTime());
                ahVar2.ud(ahVar.aKb());
                ahVar2.gu(true);
                ah ahVar3 = new ah();
                ahVar3.s(ahVar.aKc(), ahVar.getMaxTime());
                ahVar3.ud(ahVar.aKb());
                ahVar3.gu(false);
                SparseArray<Integer> aJY = ahVar.aJY();
                int size = aJY.size();
                for (int i = 0; i < size; i++) {
                    if (this.mDw.tM(String.valueOf(aJY.valueAt(i).intValue()))) {
                        ahVar2.ay(aJY.keyAt(i), aJY.valueAt(i).intValue());
                    } else {
                        ahVar3.ay(aJY.keyAt(i), aJY.valueAt(i).intValue());
                    }
                }
                ArrayList aJZ = ahVar.aJZ();
                int size2 = aJZ.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aJZ.get(i2);
                    if (this.mDw.tM(str)) {
                        ahVar2.uc(str);
                    } else {
                        ahVar3.uc(str);
                    }
                }
                JSONArray aKd = ahVar.aKd();
                int length = aKd.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = aKd.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.mDw.tM(str2)) {
                                ahVar2.cE(optJSONObject);
                            } else {
                                ahVar3.cE(optJSONObject);
                            }
                        }
                    }
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "total " + ahVar.aKd().length() + " real size = " + ahVar2.aKd().length() + "   no real  = " + ahVar3.aKd().length());
                }
                if (ahVar2.aKd().length() > 0) {
                    b(ahVar2);
                }
                if (ahVar3.aKd().length() > 0) {
                    b(ahVar3);
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "UBC all data:");
                }
                this.dub = System.currentTimeMillis();
                ag.dwY().putLong("ubc_last_upload_all_time", this.dub);
                this.duc = this.dub;
                ag.dwY().putLong("ubc_last_upload_non_real", this.duc);
            }
        }
    }

    private void b(ah ahVar) {
        if (!ahVar.isEmpty()) {
            try {
                JSONObject dxa = ahVar.dxa();
                String md5 = af.toMd5(dxa.toString().getBytes(), true);
                cR(dxa.toString(), md5);
                if (DEBUG) {
                    y.e(ahVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.mDs.a(ahVar.aJY(), ahVar.aJZ(), ahVar.aKe(), md5)) {
                    ahVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.mDs.tH(md5);
                    return;
                }
                d.dwG().A(dxa, md5);
                ahVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.mDu) >= 7200000) {
                    this.mDu = currentTimeMillis;
                    ag.dwY().putLong("ubc_last_upload_failed_data_time", this.mDu);
                    d.dwG().aJh();
                }
            } catch (OutOfMemoryError e) {
                ahVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean i = this.mDv.i(jSONObject, z);
        if (tVar != null) {
            tVar.a(i, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.dwG().al(str, i);
        }
    }

    private void aJf() {
        gr(true);
        gr(false);
    }

    private void gr(boolean z) {
        ah ahVar = new ah();
        ahVar.gu(z);
        if (this.mDt.a(ahVar, z)) {
            JSONObject dxa = ahVar.dxa();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + dxa.toString());
            }
            this.mDt.gq(z);
            d.dwG().dN(dxa);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        JSONArray jSONArray = new JSONArray();
        this.mDz = 0;
        this.mDA = 0;
        this.mDB = 0;
        String dwO = vVar.dwO();
        if (dwO == null || TextUtils.equals(dwO, "1")) {
        }
        b(vVar, z, jSONArray);
        a(vVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.mDz + this.mDA + this.mDB), Integer.valueOf(this.mDz), Integer.valueOf(this.mDB)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.mDw.av(vVar.aJQ());
        int aJP = vVar.aJP();
        if (aJP > 0) {
            this.mDw.jF(aJP * 86400000);
        }
        if (vVar.aJO() > 0) {
            this.mDw.jG(vVar.aJO());
        }
        if (this.duf == null) {
            this.duf = new SparseArray<>();
        }
        this.duf.clear();
        if (this.dug == null) {
            this.dug = new HashMap<>();
        }
        this.dug.clear();
        this.mDs.b(this.duf);
        int i = 0;
        for (int i2 = 0; i2 < this.duf.size(); i2++) {
            int keyAt = this.duf.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.dug.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.mDw.jE(i);
        vVar.aJQ().clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (android.text.TextUtils.equals(r7.dwL(), "1") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (android.text.TextUtils.equals(r0.dwL(), "1") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r5.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(v vVar, boolean z, JSONArray jSONArray) {
        List<k> aJQ = vVar.aJQ();
        if (aJQ != null && aJQ.size() > 0) {
            ArrayList arrayList = new ArrayList(aJQ);
            Iterator<k> it = aJQ.iterator();
            while (it.hasNext()) {
                k next = it.next();
                k PW = this.mDs.PW(next.getId());
                String version = next.getVersion();
                String str = "0";
                if (PW != null) {
                    str = PW.getVersion();
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
                        this.mDB++;
                    } else {
                        boolean a = this.mDs.a(next);
                        jSONObject.put("product", String.format("set/%s", next.getId()));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        jSONObject.put("version", version);
                        if (!a) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.mDA++;
                        } else {
                            this.mDz++;
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
            vVar.ev(arrayList);
        }
    }

    void b(v vVar, boolean z, JSONArray jSONArray) {
        String str;
        JSONObject dwQ = vVar.dwQ();
        if (dwQ != null) {
            Iterator<String> keys = dwQ.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k PW = this.mDs.PW(next);
                    String optString = dwQ.optString(next, "0");
                    if (PW == null) {
                        str = "0";
                    } else {
                        str = PW.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.mDB++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.mDs.PX(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.mDA++;
                        } else {
                            this.mDz++;
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
    private boolean dy(Context context) {
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
    private void cR(String str, String str2) {
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
            y.ub("save to file suc");
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
    public void tJ(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        y.ub("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            y.ub("delete file suc");
        }
        this.mDs.tH(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tK(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        y.ub("upload file fail");
        this.mDs.tI(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aJh() {
        File[] listFiles;
        if (dy(this.mContext)) {
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
                    this.mDs.aIT();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o PY = this.mDs.PY(listFiles[i].getName());
                    if (PY != null && TextUtils.equals("0", PY.aJE())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        y.ub("processFailedData file, no need to send");
                    } else if (PY != null && TextUtils.equals("1", PY.aJE())) {
                        y.ub("processFailedData file, send");
                        this.mDs.cQ(listFiles[i].getName(), "0");
                        tL(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        y.ub("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1361=5, 1363=4, 1364=4, 1365=4] */
    void tL(String str) {
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
                            d.dwG().A(jSONObject, str);
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
    public void aJi() {
        this.mDs.aIU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ah ahVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> deO = UBC.getUBCContext().deO();
            if (deO == null || deO.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= deO.size()) {
                    break;
                }
                arrayList.add(new j(deO.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.mDs.a(arrayList, ahVar);
            b(ahVar);
            aJc();
            return true;
        }
        return false;
    }
}
