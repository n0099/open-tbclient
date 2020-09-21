package com.baidu.ubc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.platform.comapi.map.MapBundleKey;
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
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = AppConfig.isDebug();
    private List<n> dLg;
    private long dLi;
    private long dLj;
    private int dLk;
    private SparseArray<ArrayList> dLl;
    private HashMap<String, Long> dLm;
    private Context mContext;
    private int noO;
    private long noP;
    private boolean noQ = false;
    private w noR;
    private b noS;
    private long noT;
    private u noU;
    private g noV;
    private int noW;
    private int noX;
    private int noY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ag dQk = ag.dQk();
        this.noR = new w(context);
        this.noS = new b(context);
        this.noU = ae.dQj();
        this.dLg = new ArrayList(20);
        this.dLi = dQk.getLong("ubc_last_upload_non_real", 0L);
        this.dLj = dQk.getLong("ubc_reset_real_time_count_time", 0L);
        this.noT = dQk.getLong("ubc_last_upload_failed_data_time", 0L);
        this.dLk = dQk.getInt("ubc_real_time_count", 0);
        this.noV = g.dPU();
        this.noV.a(this, context);
        this.noP = System.currentTimeMillis();
        int nextInt = new Random().nextInt(31) + 60;
        this.noO = nextInt;
        new Timer().schedule(new TimerTask() { // from class: com.baidu.ubc.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!c.this.noQ) {
                    ah ahVar = new ah();
                    ahVar.hi(true);
                    c.this.a(ahVar, "0");
                }
            }
        }, nextInt * 1000);
    }

    private void aWc() {
        if (this.dLl == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.dLl = new SparseArray<>();
            this.noR.b(this.dLl);
            this.dLm = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.dLl.size(); i2++) {
                int keyAt = this.dLl.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.dLm.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.noV.mo(i);
        }
    }

    public w dPR() {
        return this.noR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.aWC()) && this.noV.xu(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.noR.a(nVar);
                return;
            }
            List<String> dxr = UBC.getUBCContext().dxr();
            if (dxr == null || !dxr.contains(nVar.getId())) {
                this.noR.a(nVar);
                return;
            } else if (!this.noQ) {
                if ((System.currentTimeMillis() - this.noP) / 1000 >= this.noO) {
                    this.noQ = true;
                } else {
                    this.noR.a(nVar);
                    return;
                }
            }
        }
        if (z && !d(nVar)) {
            if (this.noV.TZ(nVar.getId())) {
                this.noR.a(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.noR.aVW();
        } else if (Math.abs(System.currentTimeMillis() - this.dLi) >= g.dPU().aWo()) {
            if (!z && this.noV.TZ(nVar.getId())) {
                this.dLg.add(nVar);
            }
            aWh();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.noV.TZ(nVar.getId())) {
                this.dLg.add(nVar);
            }
            if (this.dLg.size() >= 20) {
                aWd();
            }
        } else if (!z && this.noV.TZ(nVar.getId())) {
            this.noR.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        this.noS.a(nVar, this.noV.xu(nVar.getId()));
    }

    private void aWd() {
        if (this.dLg != null && this.dLg.size() != 0) {
            this.noR.aD(this.dLg);
            this.dLg.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.noR.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.noR.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> dxr;
        aWd();
        this.noR.a(str, i, j, jSONArray);
        boolean xu = this.noV.xu(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (xu && (dxr = UBC.getUBCContext().dxr()) != null && dxr.contains(str)) {
                if (!this.noQ) {
                    if ((System.currentTimeMillis() - this.noP) / 1000 >= this.noO) {
                        this.noQ = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (xu) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            aWe();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.dLi) >= g.dPU().aWo()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aWh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(String str, int i) {
        aWd();
        this.noR.H(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.dLi) >= g.dPU().aWo()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            aWh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(n nVar) {
        if (dH(this.mContext)) {
            nVar.Ug("1");
            ah e = e(nVar);
            if (e.isEmpty()) {
                return false;
            }
            this.noR.d(e);
            d.dPS().a(e.dQm(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.noR.a(nVar2);
                    } else {
                        c.this.noR.dQe();
                    }
                }
            });
            e.clearData();
            return true;
        }
        return false;
    }

    private boolean d(n nVar) {
        if (dH(this.mContext) && aWf()) {
            aWd();
            ah e = e(nVar);
            if (e != null) {
                if (this.dLl == null) {
                    aWc();
                }
                if (a(e, "0")) {
                    return true;
                }
                a(this.dLl, e);
                b(e);
                aWg();
                return true;
            }
            return false;
        }
        return false;
    }

    private ah e(n nVar) {
        ah ahVar = new ah();
        ahVar.hi(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", Long.toString(nVar.getTime()));
            if (nVar.aWF() != null) {
                jSONObject.put("content", nVar.aWF().toString());
            } else {
                jSONObject.put("content", nVar.getContent());
            }
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.aWE())) {
                jSONObject.put("abtest", nVar.aWE());
                ahVar.xL("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.aWA()) {
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
            }
            jSONObject.put("idtype", this.noV.xA(nVar.getId()));
            jSONObject.put("isreal", this.noV.Ub(nVar.getId()) ? "1" : "0");
            String Uc = this.noV.Uc(nVar.getId());
            if (!TextUtils.isEmpty(Uc) && !TextUtils.equals(Uc, "0")) {
                jSONObject.put("gflow", Uc);
            }
            ahVar.cT(jSONObject);
            ahVar.q(nVar.getTime(), nVar.getTime());
            return ahVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void aWe() {
        if (dH(this.mContext) && aWf()) {
            ah ahVar = new ah();
            ahVar.hi(true);
            if (this.dLl == null) {
                aWc();
            }
            if (!a(ahVar, "1")) {
                a(this.dLl, ahVar);
                b(ahVar);
                aWg();
            }
        }
    }

    private void a(SparseArray<ArrayList> sparseArray, ah ahVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size() && !ahVar.mx(com.baidu.fsg.base.statistics.b.c)) {
                this.noR.a(sparseArray.valueAt(i2), ahVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean aWf() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.dLj) > 86400000) {
            this.dLk = 0;
            this.dLj = currentTimeMillis;
            ag.dQk().putLong("ubc_reset_real_time_count_time", this.dLj);
            ag.dQk().putInt("ubc_real_time_count", this.dLk);
        }
        if (this.dLk >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.dLk == 10000) {
                this.dLk++;
                if (!DEBUG) {
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
                }
            }
            return false;
        }
        return true;
    }

    private void aWg() {
        this.dLk++;
        ag.dQk().putInt("ubc_real_time_count", this.dLk);
    }

    private void aWh() {
        if (dH(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.dLi = System.currentTimeMillis();
            ag.dQk().putLong("ubc_last_upload_non_real", this.dLi);
            aWj();
            aWd();
            this.noR.aVW();
            HashSet hashSet = new HashSet();
            if (this.dLl == null) {
                aWc();
            }
            ah ahVar = new ah();
            ahVar.hi(false);
            int i = 0;
            for (int i2 = 0; i2 < this.dLl.size(); i2++) {
                int keyAt = this.dLl.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.dLm.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.noV.aWo()) {
                        i |= this.noR.a(this.dLl.valueAt(i2), ahVar);
                        this.dLm.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.dLl.size(); i3++) {
                    int keyAt2 = this.dLl.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ahVar.mx(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.noR.a(this.dLl.valueAt(i3), ahVar);
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
    public void uploadLocalDatas() {
        if (dH(this.mContext)) {
            this.noR.aVW();
            ah ahVar = new ah();
            if (this.noR.c(ahVar) != 0) {
                ah ahVar2 = new ah();
                ahVar2.q(ahVar.aXf(), ahVar.getMaxTime());
                ahVar2.xL(ahVar.aXe());
                ahVar2.hi(true);
                ah ahVar3 = new ah();
                ahVar3.q(ahVar.aXf(), ahVar.getMaxTime());
                ahVar3.xL(ahVar.aXe());
                ahVar3.hi(false);
                SparseArray<Integer> aXb = ahVar.aXb();
                int size = aXb.size();
                for (int i = 0; i < size; i++) {
                    if (this.noV.xu(String.valueOf(aXb.valueAt(i).intValue()))) {
                        ahVar2.aF(aXb.keyAt(i), aXb.valueAt(i).intValue());
                    } else {
                        ahVar3.aF(aXb.keyAt(i), aXb.valueAt(i).intValue());
                    }
                }
                ArrayList aXc = ahVar.aXc();
                int size2 = aXc.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aXc.get(i2);
                    if (this.noV.xu(str)) {
                        ahVar2.xK(str);
                    } else {
                        ahVar3.xK(str);
                    }
                }
                JSONArray aXg = ahVar.aXg();
                int length = aXg.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = aXg.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.noV.xu(str2)) {
                                ahVar2.cT(optJSONObject);
                            } else {
                                ahVar3.cT(optJSONObject);
                            }
                        }
                    }
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "total " + ahVar.aXg().length() + " real size = " + ahVar2.aXg().length() + "   no real  = " + ahVar3.aXg().length());
                }
                if (ahVar2.aXg().length() > 0) {
                    b(ahVar2);
                }
                if (ahVar3.aXg().length() > 0) {
                    b(ahVar3);
                }
            }
        }
    }

    private void b(ah ahVar) {
        if (!ahVar.isEmpty()) {
            try {
                JSONObject dQm = ahVar.dQm();
                String md5 = af.toMd5(dQm.toString().getBytes(), true);
                dk(dQm.toString(), md5);
                if (DEBUG) {
                    y.e(ahVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.noR.a(ahVar.aXb(), ahVar.aXc(), ahVar.aXh(), md5)) {
                    ahVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.noR.xp(md5);
                    return;
                }
                d.dPS().E(dQm, md5);
                ahVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.noT) >= 7200000) {
                    this.noT = currentTimeMillis;
                    ag.dQk().putLong("ubc_last_upload_failed_data_time", this.noT);
                    d.dPS().aWl();
                }
            } catch (OutOfMemoryError e) {
                ahVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean i = this.noU.i(jSONObject, z);
        if (tVar != null) {
            tVar.a(i, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.dPS().ao(str, i);
        }
    }

    private void aWj() {
        hf(true);
        hf(false);
    }

    private void hf(boolean z) {
        ah ahVar = new ah();
        ahVar.hi(z);
        if (this.noS.a(ahVar, z)) {
            JSONObject dQm = ahVar.dQm();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + dQm.toString());
            }
            this.noS.he(z);
            d.dPS().en(dQm);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        JSONArray jSONArray = new JSONArray();
        this.noW = 0;
        this.noX = 0;
        this.noY = 0;
        String dQb = vVar.dQb();
        if (dQb == null || TextUtils.equals(dQb, "1")) {
        }
        b(vVar, z, jSONArray);
        a(vVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.noW + this.noX + this.noY), Integer.valueOf(this.noW), Integer.valueOf(this.noY)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.noV.aF(vVar.aWT());
        int aWS = vVar.aWS();
        if (aWS > 0) {
            this.noV.mp(aWS * 86400000);
        }
        if (vVar.aWR() > 0) {
            this.noV.mq(vVar.aWR());
        }
        if (this.dLl == null) {
            this.dLl = new SparseArray<>();
        }
        this.dLl.clear();
        if (this.dLm == null) {
            this.dLm = new HashMap<>();
        }
        this.dLm.clear();
        this.noR.b(this.dLl);
        int i = 0;
        for (int i2 = 0; i2 < this.dLl.size(); i2++) {
            int keyAt = this.dLl.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.dLm.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.noV.mo(i);
        vVar.aWT().clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (android.text.TextUtils.equals(r7.dPX(), "1") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (android.text.TextUtils.equals(r0.dPX(), "1") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r5.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(v vVar, boolean z, JSONArray jSONArray) {
        List<k> aWT = vVar.aWT();
        if (aWT != null && aWT.size() > 0) {
            ArrayList arrayList = new ArrayList(aWT);
            Iterator<k> it = aWT.iterator();
            while (it.hasNext()) {
                k next = it.next();
                k Uj = this.noR.Uj(next.getId());
                String version = next.getVersion();
                String str = "0";
                if (Uj != null) {
                    str = Uj.getVersion();
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
                        this.noY++;
                    } else {
                        boolean a = this.noR.a(next);
                        jSONObject.put("product", String.format("set/%s", next.getId()));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        jSONObject.put("version", version);
                        if (!a) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.noX++;
                        } else {
                            this.noW++;
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
            vVar.eR(arrayList);
        }
    }

    void b(v vVar, boolean z, JSONArray jSONArray) {
        String str;
        JSONObject dQd = vVar.dQd();
        if (dQd != null) {
            Iterator<String> keys = dQd.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k Uj = this.noR.Uj(next);
                    String optString = dQd.optString(next, "0");
                    if (Uj == null) {
                        str = "0";
                    } else {
                        str = Uj.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.noY++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.noR.Uk(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.noX++;
                        } else {
                            this.noW++;
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
    private boolean dH(Context context) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1175=4] */
    private void dk(String str, String str2) {
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
            y.xJ("save to file suc");
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
    public void xr(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        y.xJ("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            y.xJ("delete file suc");
        }
        this.noR.xp(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xs(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        y.xJ("upload file fail");
        this.noR.xq(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aWl() {
        File[] listFiles;
        if (dH(this.mContext)) {
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
                    this.noR.aVX();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o Ul = this.noR.Ul(listFiles[i].getName());
                    if (Ul != null && TextUtils.equals("0", Ul.aWI())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        y.xJ("processFailedData file, no need to send");
                    } else if (Ul != null && TextUtils.equals("1", Ul.aWI())) {
                        y.xJ("processFailedData file, send");
                        this.noR.dj(listFiles[i].getName(), "0");
                        xt(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        y.xJ("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1333=5, 1335=4, 1336=4, 1337=4] */
    void xt(String str) {
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
                            d.dPS().E(jSONObject, str);
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
    public void aWm() {
        this.noR.aVY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ah ahVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> dxr = UBC.getUBCContext().dxr();
            if (dxr == null || dxr.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= dxr.size()) {
                    break;
                }
                arrayList.add(new j(dxr.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.noR.a(arrayList, ahVar);
            b(ahVar);
            aWg();
            return true;
        }
        return false;
    }

    public String getUploadType(String str) {
        return this.noV != null ? this.noV.getUploadType(str) : "";
    }
}
