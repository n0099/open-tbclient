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
    private SparseArray<ArrayList> ddA;
    private HashMap<String, Long> ddB;
    private List<n> ddv;
    private long ddw;
    private long ddx;
    private long ddy;
    private int ddz;
    private int lMT;
    private long lMU;
    private boolean lMV = false;
    private w lMW;
    private b lMX;
    private long lMY;
    private u lMZ;
    private g lNa;
    private int lNb;
    private int lNc;
    private int lNd;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ag dkR = ag.dkR();
        this.lMW = new w(context);
        this.lMX = new b(context);
        this.lMZ = ae.dkQ();
        this.ddv = new ArrayList(20);
        this.ddw = dkR.getLong("ubc_last_upload_all_time", 0L);
        this.ddx = dkR.getLong("ubc_last_upload_non_real", 0L);
        this.ddy = dkR.getLong("ubc_reset_real_time_count_time", 0L);
        this.lMY = dkR.getLong("ubc_last_upload_failed_data_time", 0L);
        this.ddz = dkR.getInt("ubc_real_time_count", 0);
        this.lNa = g.dkB();
        this.lNa.a(this, context);
        this.lMU = System.currentTimeMillis();
        int nextInt = new Random().nextInt(31) + 60;
        this.lMT = nextInt;
        new Timer().schedule(new TimerTask() { // from class: com.baidu.ubc.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!c.this.lMV) {
                    ah ahVar = new ah();
                    ahVar.ge(true);
                    c.this.a(ahVar, "0");
                }
            }
        }, nextInt * 1000);
    }

    private void aDl() {
        if (this.ddA == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.ddA = new SparseArray<>();
            this.lMW.a(this.ddA);
            this.ddB = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.ddA.size(); i2++) {
                int keyAt = this.ddA.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.ddB.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.lNa.iY(i);
        }
    }

    public w dky() {
        return this.lMW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.ahG()) && this.lNa.sb(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.lMW.a(nVar);
                return;
            }
            List<String> cTg = UBC.getUBCContext().cTg();
            if (cTg == null || !cTg.contains(nVar.getId())) {
                this.lMW.a(nVar);
                return;
            } else if (!this.lMV) {
                if ((System.currentTimeMillis() - this.lMU) / 1000 >= this.lMT) {
                    this.lMV = true;
                } else {
                    this.lMW.a(nVar);
                    return;
                }
            }
        }
        if (z && !d(nVar)) {
            if (this.lNa.Nl(nVar.getId())) {
                this.lMW.a(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.lMW.aDf();
        } else if (Math.abs(System.currentTimeMillis() - this.ddx) >= g.dkB().aDx()) {
            if (!z && this.lNa.Nl(nVar.getId())) {
                this.ddv.add(nVar);
            }
            aDq();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.lNa.Nl(nVar.getId())) {
                this.ddv.add(nVar);
            }
            if (this.ddv.size() >= 20) {
                aDm();
            }
        } else if (!z && this.lNa.Nl(nVar.getId())) {
            this.lMW.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        this.lMX.a(nVar, this.lNa.sb(nVar.getId()));
    }

    private void aDm() {
        if (this.ddv != null && this.ddv.size() != 0) {
            this.lMW.au(this.ddv);
            this.ddv.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.lMW.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.lMW.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> cTg;
        aDm();
        this.lMW.a(str, i, j, jSONArray);
        boolean sb = this.lNa.sb(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (sb && (cTg = UBC.getUBCContext().cTg()) != null && cTg.contains(str)) {
                if (!this.lMV) {
                    if ((System.currentTimeMillis() - this.lMU) / 1000 >= this.lMT) {
                        this.lMV = true;
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
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.ddx) >= g.dkB().aDx()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aDq();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(String str, int i) {
        aDm();
        this.lMW.C(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.ddx) >= g.dkB().aDx()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aDq();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(n nVar) {
        if (dt(this.mContext)) {
            nVar.Nr("1");
            ah e = e(nVar);
            if (e.isEmpty()) {
                return false;
            }
            this.lMW.d(e);
            d.dkz().a(e.dkT(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.lMW.a(nVar2);
                    } else {
                        c.this.lMW.dkL();
                    }
                }
            });
            e.clearData();
            return true;
        }
        return false;
    }

    private boolean d(n nVar) {
        if (dt(this.mContext) && aDo()) {
            aDm();
            ah e = e(nVar);
            if (e != null) {
                if (this.ddA == null) {
                    aDl();
                }
                if (a(e, "0")) {
                    return true;
                }
                a(this.ddA, e);
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
            jSONObject.put("idtype", this.lNa.sh(nVar.getId()));
            jSONObject.put("isreal", this.lNa.Nn(nVar.getId()) ? "1" : "0");
            String No = this.lNa.No(nVar.getId());
            if (!TextUtils.isEmpty(No) && !TextUtils.equals(No, "0")) {
                jSONObject.put("gflow", No);
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
        if (dt(this.mContext) && aDo()) {
            ah ahVar = new ah();
            ahVar.ge(true);
            if (this.ddA == null) {
                aDl();
            }
            if (!a(ahVar, "1")) {
                a(this.ddA, ahVar);
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
                this.lMW.a(sparseArray.valueAt(i2), ahVar);
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
        if (Math.abs(currentTimeMillis - this.ddy) > 86400000) {
            this.ddz = 0;
            this.ddy = currentTimeMillis;
            ag.dkR().putLong("ubc_reset_real_time_count_time", this.ddy);
            ag.dkR().putInt("ubc_real_time_count", this.ddz);
        }
        if (this.ddz >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.ddz == 10000) {
                this.ddz++;
                if (!DEBUG) {
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
                }
            }
            return false;
        }
        return true;
    }

    private void aDp() {
        this.ddz++;
        ag.dkR().putInt("ubc_real_time_count", this.ddz);
    }

    private void aDq() {
        if (dt(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.ddx = System.currentTimeMillis();
            ag.dkR().putLong("ubc_last_upload_non_real", this.ddx);
            aDs();
            aDm();
            this.lMW.aDf();
            HashSet hashSet = new HashSet();
            if (this.ddA == null) {
                aDl();
            }
            ah ahVar = new ah();
            ahVar.ge(false);
            int i = 0;
            for (int i2 = 0; i2 < this.ddA.size(); i2++) {
                int keyAt = this.ddA.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.ddB.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.lNa.aDx()) {
                        i |= this.lMW.a(this.ddA.valueAt(i2), ahVar);
                        this.ddB.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.ddA.size(); i3++) {
                    int keyAt2 = this.ddA.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ahVar.jh(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.lMW.a(this.ddA.valueAt(i3), ahVar);
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
        if (dt(this.mContext) && Math.abs(System.currentTimeMillis() - this.ddw) >= BdKVCache.MILLS_1Hour) {
            this.lMW.aDf();
            ah ahVar = new ah();
            if (this.lMW.c(ahVar) != 0) {
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
                    if (this.lNa.sb(String.valueOf(aEk.valueAt(i).intValue()))) {
                        ahVar2.aw(aEk.keyAt(i), aEk.valueAt(i).intValue());
                    } else {
                        ahVar3.aw(aEk.keyAt(i), aEk.valueAt(i).intValue());
                    }
                }
                ArrayList aEl = ahVar.aEl();
                int size2 = aEl.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aEl.get(i2);
                    if (this.lNa.sb(str)) {
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
                            if (this.lNa.sb(str2)) {
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
                this.ddw = System.currentTimeMillis();
                ag.dkR().putLong("ubc_last_upload_all_time", this.ddw);
                this.ddx = this.ddw;
                ag.dkR().putLong("ubc_last_upload_non_real", this.ddx);
            }
        }
    }

    private void b(ah ahVar) {
        if (!ahVar.isEmpty()) {
            try {
                JSONObject dkT = ahVar.dkT();
                String md5 = af.toMd5(dkT.toString().getBytes(), true);
                cs(dkT.toString(), md5);
                if (DEBUG) {
                    y.e(ahVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.lMW.a(ahVar.aEk(), ahVar.aEl(), ahVar.aEq(), md5)) {
                    ahVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.lMW.rW(md5);
                    return;
                }
                d.dkz().s(dkT, md5);
                ahVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.lMY) >= 7200000) {
                    this.lMY = currentTimeMillis;
                    ag.dkR().putLong("ubc_last_upload_failed_data_time", this.lMY);
                    d.dkz().aDu();
                }
            } catch (OutOfMemoryError e) {
                ahVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean g = this.lMZ.g(jSONObject, z);
        if (tVar != null) {
            tVar.a(g, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.dkz().W(str, g);
        }
    }

    private void aDs() {
        gb(true);
        gb(false);
    }

    private void gb(boolean z) {
        ah ahVar = new ah();
        ahVar.ge(z);
        if (this.lMX.a(ahVar, z)) {
            JSONObject dkT = ahVar.dkT();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + dkT.toString());
            }
            this.lMX.ga(z);
            d.dkz().dw(dkT);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        JSONArray jSONArray = new JSONArray();
        this.lNb = 0;
        this.lNc = 0;
        this.lNd = 0;
        String dkH = vVar.dkH();
        if (dkH == null || TextUtils.equals(dkH, "1")) {
        }
        b(vVar, z, jSONArray);
        a(vVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.lNb + this.lNc + this.lNd), Integer.valueOf(this.lNb), Integer.valueOf(this.lNd)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.lNa.aw(vVar.aEb());
        int aEa = vVar.aEa();
        if (aEa > 0) {
            this.lNa.iZ(aEa * 86400000);
        }
        if (vVar.aDZ() > 0) {
            this.lNa.ja(vVar.aDZ());
        }
        if (this.ddA == null) {
            this.ddA = new SparseArray<>();
        }
        this.ddA.clear();
        if (this.ddB == null) {
            this.ddB = new HashMap<>();
        }
        this.ddB.clear();
        this.lMW.a(this.ddA);
        int i = 0;
        for (int i2 = 0; i2 < this.ddA.size(); i2++) {
            int keyAt = this.ddA.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.ddB.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.lNa.iY(i);
        vVar.aEb().clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (android.text.TextUtils.equals(r7.dkE(), "1") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (android.text.TextUtils.equals(r0.dkE(), "1") == false) goto L28;
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
                k Nt = this.lMW.Nt(next.getId());
                String version = next.getVersion();
                String str = "0";
                if (Nt != null) {
                    str = Nt.getVersion();
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
                        this.lNd++;
                    } else {
                        boolean a = this.lMW.a(next);
                        jSONObject.put("product", String.format("set/%s", next.getId()));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        jSONObject.put("version", version);
                        if (!a) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.lNc++;
                        } else {
                            this.lNb++;
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
        JSONObject dkJ = vVar.dkJ();
        if (dkJ != null) {
            Iterator<String> keys = dkJ.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k Nt = this.lMW.Nt(next);
                    String optString = dkJ.optString(next, "0");
                    if (Nt == null) {
                        str = "0";
                    } else {
                        str = Nt.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.lNd++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.lMW.Nu(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.lNc++;
                        } else {
                            this.lNb++;
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
    private boolean dt(Context context) {
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
        this.lMW.rW(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rZ(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        y.so("upload file fail");
        this.lMW.rX(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDu() {
        File[] listFiles;
        if (dt(this.mContext)) {
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
                    this.lMW.aDg();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o Nv = this.lMW.Nv(listFiles[i].getName());
                    if (Nv != null && TextUtils.equals("0", Nv.aDO())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        y.so("processFailedData file, no need to send");
                    } else if (Nv != null && TextUtils.equals("1", Nv.aDO())) {
                        y.so("processFailedData file, send");
                        this.lMW.cr(listFiles[i].getName(), "0");
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
                            d.dkz().s(jSONObject, str);
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
        this.lMW.aDh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ah ahVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> cTg = UBC.getUBCContext().cTg();
            if (cTg == null || cTg.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= cTg.size()) {
                    break;
                }
                arrayList.add(new j(cTg.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.lMW.a(arrayList, ahVar);
            b(ahVar);
            aDp();
            return true;
        }
        return false;
    }
}
