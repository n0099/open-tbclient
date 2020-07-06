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
    private u mDA;
    private g mDB;
    private int mDC;
    private int mDD;
    private int mDE;
    private int mDs;
    private long mDt;
    private boolean mDu = false;
    private w mDv;
    private b mDw;
    private long mDz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ag dxc = ag.dxc();
        this.mDv = new w(context);
        this.mDw = new b(context);
        this.mDA = ae.dxb();
        this.dua = new ArrayList(20);
        this.dub = dxc.getLong("ubc_last_upload_all_time", 0L);
        this.duc = dxc.getLong("ubc_last_upload_non_real", 0L);
        this.dud = dxc.getLong("ubc_reset_real_time_count_time", 0L);
        this.mDz = dxc.getLong("ubc_last_upload_failed_data_time", 0L);
        this.due = dxc.getInt("ubc_real_time_count", 0);
        this.mDB = g.dwM();
        this.mDB.a(this, context);
        this.mDt = System.currentTimeMillis();
        int nextInt = new Random().nextInt(31) + 60;
        this.mDs = nextInt;
        new Timer().schedule(new TimerTask() { // from class: com.baidu.ubc.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!c.this.mDu) {
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
            this.mDv.b(this.duf);
            this.dug = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.duf.size(); i2++) {
                int keyAt = this.duf.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.dug.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.mDB.jE(i);
        }
    }

    public w dwJ() {
        return this.mDv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.aJy()) && this.mDB.tM(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.mDv.a(nVar);
                return;
            }
            List<String> deP = UBC.getUBCContext().deP();
            if (deP == null || !deP.contains(nVar.getId())) {
                this.mDv.a(nVar);
                return;
            } else if (!this.mDu) {
                if ((System.currentTimeMillis() - this.mDt) / 1000 >= this.mDs) {
                    this.mDu = true;
                } else {
                    this.mDv.a(nVar);
                    return;
                }
            }
        }
        if (z && !d(nVar)) {
            if (this.mDB.PP(nVar.getId())) {
                this.mDv.a(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.mDv.aIS();
        } else if (Math.abs(System.currentTimeMillis() - this.duc) >= g.dwM().aJk()) {
            if (!z && this.mDB.PP(nVar.getId())) {
                this.dua.add(nVar);
            }
            aJd();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.mDB.PP(nVar.getId())) {
                this.dua.add(nVar);
            }
            if (this.dua.size() >= 20) {
                aIZ();
            }
        } else if (!z && this.mDB.PP(nVar.getId())) {
            this.mDv.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        this.mDw.a(nVar, this.mDB.tM(nVar.getId()));
    }

    private void aIZ() {
        if (this.dua != null && this.dua.size() != 0) {
            this.mDv.at(this.dua);
            this.dua.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.mDv.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.mDv.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> deP;
        aIZ();
        this.mDv.a(str, i, j, jSONArray);
        boolean tM = this.mDB.tM(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (tM && (deP = UBC.getUBCContext().deP()) != null && deP.contains(str)) {
                if (!this.mDu) {
                    if ((System.currentTimeMillis() - this.mDt) / 1000 >= this.mDs) {
                        this.mDu = true;
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
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.duc) >= g.dwM().aJk()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aJd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(String str, int i) {
        aIZ();
        this.mDv.G(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.duc) >= g.dwM().aJk()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aJd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(n nVar) {
        if (dy(this.mContext)) {
            nVar.PV("1");
            ah e = e(nVar);
            if (e.isEmpty()) {
                return false;
            }
            this.mDv.d(e);
            d.dwK().a(e.dxe(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.mDv.a(nVar2);
                    } else {
                        c.this.mDv.dwW();
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
            jSONObject.put("idtype", this.mDB.tS(nVar.getId()));
            jSONObject.put("isreal", this.mDB.PR(nVar.getId()) ? "1" : "0");
            String PS = this.mDB.PS(nVar.getId());
            if (!TextUtils.isEmpty(PS) && !TextUtils.equals(PS, "0")) {
                jSONObject.put("gflow", PS);
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
                this.mDv.a(sparseArray.valueAt(i2), ahVar);
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
            ag.dxc().putLong("ubc_reset_real_time_count_time", this.dud);
            ag.dxc().putInt("ubc_real_time_count", this.due);
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
        ag.dxc().putInt("ubc_real_time_count", this.due);
    }

    private void aJd() {
        if (dy(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.duc = System.currentTimeMillis();
            ag.dxc().putLong("ubc_last_upload_non_real", this.duc);
            aJf();
            aIZ();
            this.mDv.aIS();
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
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.mDB.aJk()) {
                        i |= this.mDv.a(this.duf.valueAt(i2), ahVar);
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
                        this.mDv.a(this.duf.valueAt(i3), ahVar);
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
            this.mDv.aIS();
            ah ahVar = new ah();
            if (this.mDv.c(ahVar) != 0) {
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
                    if (this.mDB.tM(String.valueOf(aJY.valueAt(i).intValue()))) {
                        ahVar2.ay(aJY.keyAt(i), aJY.valueAt(i).intValue());
                    } else {
                        ahVar3.ay(aJY.keyAt(i), aJY.valueAt(i).intValue());
                    }
                }
                ArrayList aJZ = ahVar.aJZ();
                int size2 = aJZ.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aJZ.get(i2);
                    if (this.mDB.tM(str)) {
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
                            if (this.mDB.tM(str2)) {
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
                ag.dxc().putLong("ubc_last_upload_all_time", this.dub);
                this.duc = this.dub;
                ag.dxc().putLong("ubc_last_upload_non_real", this.duc);
            }
        }
    }

    private void b(ah ahVar) {
        if (!ahVar.isEmpty()) {
            try {
                JSONObject dxe = ahVar.dxe();
                String md5 = af.toMd5(dxe.toString().getBytes(), true);
                cR(dxe.toString(), md5);
                if (DEBUG) {
                    y.e(ahVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.mDv.a(ahVar.aJY(), ahVar.aJZ(), ahVar.aKe(), md5)) {
                    ahVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.mDv.tH(md5);
                    return;
                }
                d.dwK().A(dxe, md5);
                ahVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.mDz) >= 7200000) {
                    this.mDz = currentTimeMillis;
                    ag.dxc().putLong("ubc_last_upload_failed_data_time", this.mDz);
                    d.dwK().aJh();
                }
            } catch (OutOfMemoryError e) {
                ahVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean i = this.mDA.i(jSONObject, z);
        if (tVar != null) {
            tVar.a(i, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.dwK().al(str, i);
        }
    }

    private void aJf() {
        gr(true);
        gr(false);
    }

    private void gr(boolean z) {
        ah ahVar = new ah();
        ahVar.gu(z);
        if (this.mDw.a(ahVar, z)) {
            JSONObject dxe = ahVar.dxe();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + dxe.toString());
            }
            this.mDw.gq(z);
            d.dwK().dN(dxe);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        JSONArray jSONArray = new JSONArray();
        this.mDC = 0;
        this.mDD = 0;
        this.mDE = 0;
        String dwS = vVar.dwS();
        if (dwS == null || TextUtils.equals(dwS, "1")) {
        }
        b(vVar, z, jSONArray);
        a(vVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.mDC + this.mDD + this.mDE), Integer.valueOf(this.mDC), Integer.valueOf(this.mDE)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.mDB.av(vVar.aJQ());
        int aJP = vVar.aJP();
        if (aJP > 0) {
            this.mDB.jF(aJP * 86400000);
        }
        if (vVar.aJO() > 0) {
            this.mDB.jG(vVar.aJO());
        }
        if (this.duf == null) {
            this.duf = new SparseArray<>();
        }
        this.duf.clear();
        if (this.dug == null) {
            this.dug = new HashMap<>();
        }
        this.dug.clear();
        this.mDv.b(this.duf);
        int i = 0;
        for (int i2 = 0; i2 < this.duf.size(); i2++) {
            int keyAt = this.duf.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.dug.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.mDB.jE(i);
        vVar.aJQ().clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (android.text.TextUtils.equals(r7.dwP(), "1") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (android.text.TextUtils.equals(r0.dwP(), "1") == false) goto L28;
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
                k PX = this.mDv.PX(next.getId());
                String version = next.getVersion();
                String str = "0";
                if (PX != null) {
                    str = PX.getVersion();
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
                        this.mDE++;
                    } else {
                        boolean a = this.mDv.a(next);
                        jSONObject.put("product", String.format("set/%s", next.getId()));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        jSONObject.put("version", version);
                        if (!a) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.mDD++;
                        } else {
                            this.mDC++;
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
        JSONObject dwU = vVar.dwU();
        if (dwU != null) {
            Iterator<String> keys = dwU.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k PX = this.mDv.PX(next);
                    String optString = dwU.optString(next, "0");
                    if (PX == null) {
                        str = "0";
                    } else {
                        str = PX.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.mDE++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.mDv.PY(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.mDD++;
                        } else {
                            this.mDC++;
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
        this.mDv.tH(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tK(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        y.ub("upload file fail");
        this.mDv.tI(str);
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
                    this.mDv.aIT();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o PZ = this.mDv.PZ(listFiles[i].getName());
                    if (PZ != null && TextUtils.equals("0", PZ.aJE())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        y.ub("processFailedData file, no need to send");
                    } else if (PZ != null && TextUtils.equals("1", PZ.aJE())) {
                        y.ub("processFailedData file, send");
                        this.mDv.cQ(listFiles[i].getName(), "0");
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
                            d.dwK().A(jSONObject, str);
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
        this.mDv.aIU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ah ahVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> deP = UBC.getUBCContext().deP();
            if (deP == null || deP.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= deP.size()) {
                    break;
                }
                arrayList.add(new j(deP.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.mDv.a(arrayList, ahVar);
            b(ahVar);
            aJc();
            return true;
        }
        return false;
    }
}
