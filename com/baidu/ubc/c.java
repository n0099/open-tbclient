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
/* loaded from: classes19.dex */
public class c {
    private static final boolean DEBUG = AppConfig.isDebug();
    private List<n> efD;
    private long efF;
    private long efG;
    private int efH;
    private SparseArray<ArrayList> efI;
    private HashMap<String, Long> efJ;
    private Context mContext;
    private int ogK;
    private long ogL;
    private boolean ogM = false;
    private w ogN;
    private b ogO;
    private long ogP;
    private u ogQ;
    private g ogR;
    private int ogS;
    private int ogT;
    private int ogU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ag dZN = ag.dZN();
        this.ogN = new w(context);
        this.ogO = new b(context);
        this.ogQ = ae.dZM();
        this.efD = new ArrayList(20);
        this.efF = dZN.getLong("ubc_last_upload_non_real", 0L);
        this.efG = dZN.getLong("ubc_reset_real_time_count_time", 0L);
        this.ogP = dZN.getLong("ubc_last_upload_failed_data_time", 0L);
        this.efH = dZN.getInt("ubc_real_time_count", 0);
        this.ogR = g.dZx();
        this.ogR.a(this, context);
        this.ogL = System.currentTimeMillis();
        int nextInt = new Random().nextInt(31) + 60;
        this.ogK = nextInt;
        new Timer().schedule(new TimerTask() { // from class: com.baidu.ubc.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!c.this.ogM) {
                    ah ahVar = new ah();
                    ahVar.hR(true);
                    c.this.a(ahVar, "0");
                }
            }
        }, nextInt * 1000);
    }

    private void baD() {
        if (this.efI == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.efI = new SparseArray<>();
            this.ogN.b(this.efI);
            this.efJ = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.efI.size(); i2++) {
                int keyAt = this.efI.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.efJ.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.ogR.mW(i);
        }
    }

    public w dZu() {
        return this.ogN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.bbd()) && this.ogR.yz(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.ogN.a(nVar);
                return;
            }
            List<String> dEk = UBC.getUBCContext().dEk();
            if (dEk == null || !dEk.contains(nVar.getId())) {
                this.ogN.a(nVar);
                return;
            } else if (!this.ogM) {
                if ((System.currentTimeMillis() - this.ogL) / 1000 >= this.ogK) {
                    this.ogM = true;
                } else {
                    this.ogN.a(nVar);
                    return;
                }
            }
        }
        if (z && !d(nVar)) {
            if (this.ogR.Wb(nVar.getId())) {
                this.ogN.a(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.ogN.bax();
        } else if (Math.abs(System.currentTimeMillis() - this.efF) >= g.dZx().baP()) {
            if (!z && this.ogR.Wb(nVar.getId())) {
                this.efD.add(nVar);
            }
            baI();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.ogR.Wb(nVar.getId())) {
                this.efD.add(nVar);
            }
            if (this.efD.size() >= 20) {
                baE();
            }
        } else if (!z && this.ogR.Wb(nVar.getId())) {
            this.ogN.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        this.ogO.a(nVar, this.ogR.yz(nVar.getId()));
    }

    private void baE() {
        if (this.efD != null && this.efD.size() != 0) {
            this.ogN.aQ(this.efD);
            this.efD.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.ogN.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, int i, String str2) {
        this.ogN.h(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> dEk;
        baE();
        this.ogN.a(str, i, j, jSONArray);
        boolean yz = this.ogR.yz(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (yz && (dEk = UBC.getUBCContext().dEk()) != null && dEk.contains(str)) {
                if (!this.ogM) {
                    if ((System.currentTimeMillis() - this.ogL) / 1000 >= this.ogK) {
                        this.ogM = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (yz) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            baF();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.efF) >= g.dZx().baP()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            baI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(String str, int i) {
        baE();
        this.ogN.I(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.efF) >= g.dZx().baP()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            baI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(n nVar) {
        if (dN(this.mContext)) {
            nVar.Wi("1");
            ah e = e(nVar);
            if (e.isEmpty()) {
                return false;
            }
            this.ogN.d(e);
            d.dZv().a(e.dZP(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.ogN.a(nVar2);
                    } else {
                        c.this.ogN.dZH();
                    }
                }
            });
            e.clearData();
            return true;
        }
        return false;
    }

    private boolean d(n nVar) {
        if (dN(this.mContext) && baG()) {
            baE();
            ah e = e(nVar);
            if (e != null) {
                if (this.efI == null) {
                    baD();
                }
                if (a(e, "0")) {
                    return true;
                }
                a(this.efI, e);
                b(e);
                baH();
                return true;
            }
            return false;
        }
        return false;
    }

    private ah e(n nVar) {
        ah ahVar = new ah();
        ahVar.hR(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", Long.toString(nVar.getTime()));
            if (nVar.bbg() != null) {
                jSONObject.put("content", nVar.bbg().toString());
            } else {
                jSONObject.put("content", nVar.getContent());
            }
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.bbf())) {
                jSONObject.put("abtest", nVar.bbf());
                ahVar.yQ("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.bbb()) {
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
            }
            jSONObject.put("idtype", this.ogR.yF(nVar.getId()));
            jSONObject.put("isreal", this.ogR.Wd(nVar.getId()) ? "1" : "0");
            String We = this.ogR.We(nVar.getId());
            if (!TextUtils.isEmpty(We) && !TextUtils.equals(We, "0")) {
                jSONObject.put("gflow", We);
            }
            ahVar.dd(jSONObject);
            ahVar.q(nVar.getTime(), nVar.getTime());
            return ahVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void baF() {
        if (dN(this.mContext) && baG()) {
            ah ahVar = new ah();
            ahVar.hR(true);
            if (this.efI == null) {
                baD();
            }
            if (!a(ahVar, "1")) {
                a(this.efI, ahVar);
                b(ahVar);
                baH();
            }
        }
    }

    private void a(SparseArray<ArrayList> sparseArray, ah ahVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size() && !ahVar.nf(com.baidu.fsg.base.statistics.b.c)) {
                this.ogN.a(sparseArray.valueAt(i2), ahVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean baG() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.efG) > 86400000) {
            this.efH = 0;
            this.efG = currentTimeMillis;
            ag.dZN().putLong("ubc_reset_real_time_count_time", this.efG);
            ag.dZN().putInt("ubc_real_time_count", this.efH);
        }
        if (this.efH >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.efH == 10000) {
                this.efH++;
                if (!DEBUG) {
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
                }
            }
            return false;
        }
        return true;
    }

    private void baH() {
        this.efH++;
        ag.dZN().putInt("ubc_real_time_count", this.efH);
    }

    private void baI() {
        if (dN(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.efF = System.currentTimeMillis();
            ag.dZN().putLong("ubc_last_upload_non_real", this.efF);
            baK();
            baE();
            this.ogN.bax();
            HashSet hashSet = new HashSet();
            if (this.efI == null) {
                baD();
            }
            ah ahVar = new ah();
            ahVar.hR(false);
            int i = 0;
            for (int i2 = 0; i2 < this.efI.size(); i2++) {
                int keyAt = this.efI.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.efJ.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.ogR.baP()) {
                        i |= this.ogN.a(this.efI.valueAt(i2), ahVar);
                        this.efJ.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.efI.size(); i3++) {
                    int keyAt2 = this.efI.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ahVar.nf(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.ogN.a(this.efI.valueAt(i3), ahVar);
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
        if (dN(this.mContext)) {
            this.ogN.bax();
            ah ahVar = new ah();
            if (this.ogN.c(ahVar) != 0) {
                ah ahVar2 = new ah();
                ahVar2.q(ahVar.bbG(), ahVar.getMaxTime());
                ahVar2.yQ(ahVar.bbF());
                ahVar2.hR(true);
                ah ahVar3 = new ah();
                ahVar3.q(ahVar.bbG(), ahVar.getMaxTime());
                ahVar3.yQ(ahVar.bbF());
                ahVar3.hR(false);
                SparseArray<Integer> bbC = ahVar.bbC();
                int size = bbC.size();
                for (int i = 0; i < size; i++) {
                    if (this.ogR.yz(String.valueOf(bbC.valueAt(i).intValue()))) {
                        ahVar2.aF(bbC.keyAt(i), bbC.valueAt(i).intValue());
                    } else {
                        ahVar3.aF(bbC.keyAt(i), bbC.valueAt(i).intValue());
                    }
                }
                ArrayList bbD = ahVar.bbD();
                int size2 = bbD.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bbD.get(i2);
                    if (this.ogR.yz(str)) {
                        ahVar2.yP(str);
                    } else {
                        ahVar3.yP(str);
                    }
                }
                JSONArray bbH = ahVar.bbH();
                int length = bbH.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = bbH.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.ogR.yz(str2)) {
                                ahVar2.dd(optJSONObject);
                            } else {
                                ahVar3.dd(optJSONObject);
                            }
                        }
                    }
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "total " + ahVar.bbH().length() + " real size = " + ahVar2.bbH().length() + "   no real  = " + ahVar3.bbH().length());
                }
                if (ahVar2.bbH().length() > 0) {
                    b(ahVar2);
                }
                if (ahVar3.bbH().length() > 0) {
                    b(ahVar3);
                }
            }
        }
    }

    private void b(ah ahVar) {
        if (!ahVar.isEmpty()) {
            try {
                JSONObject dZP = ahVar.dZP();
                String md5 = af.toMd5(dZP.toString().getBytes(), true);
                dw(dZP.toString(), md5);
                if (DEBUG) {
                    y.e(ahVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.ogN.a(ahVar.bbC(), ahVar.bbD(), ahVar.bbI(), md5)) {
                    ahVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.ogN.yu(md5);
                    return;
                }
                d.dZv().E(dZP, md5);
                ahVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.ogP) >= 7200000) {
                    this.ogP = currentTimeMillis;
                    ag.dZN().putLong("ubc_last_upload_failed_data_time", this.ogP);
                    d.dZv().baM();
                }
            } catch (OutOfMemoryError e) {
                ahVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean i = this.ogQ.i(jSONObject, z);
        if (tVar != null) {
            tVar.a(i, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.dZv().au(str, i);
        }
    }

    private void baK() {
        hO(true);
        hO(false);
    }

    private void hO(boolean z) {
        ah ahVar = new ah();
        ahVar.hR(z);
        if (this.ogO.a(ahVar, z)) {
            JSONObject dZP = ahVar.dZP();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + dZP.toString());
            }
            this.ogO.hN(z);
            d.dZv().ey(dZP);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        JSONArray jSONArray = new JSONArray();
        this.ogS = 0;
        this.ogT = 0;
        this.ogU = 0;
        String dZE = vVar.dZE();
        if (dZE == null || TextUtils.equals(dZE, "1")) {
        }
        b(vVar, z, jSONArray);
        a(vVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.ogS + this.ogT + this.ogU), Integer.valueOf(this.ogS), Integer.valueOf(this.ogU)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.ogR.aS(vVar.bbu());
        int bbt = vVar.bbt();
        if (bbt > 0) {
            this.ogR.mX(bbt * 86400000);
        }
        if (vVar.bbs() > 0) {
            this.ogR.mY(vVar.bbs());
        }
        if (this.efI == null) {
            this.efI = new SparseArray<>();
        }
        this.efI.clear();
        if (this.efJ == null) {
            this.efJ = new HashMap<>();
        }
        this.efJ.clear();
        this.ogN.b(this.efI);
        int i = 0;
        for (int i2 = 0; i2 < this.efI.size(); i2++) {
            int keyAt = this.efI.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.efJ.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.ogR.mW(i);
        vVar.bbu().clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (android.text.TextUtils.equals(r7.dZA(), "1") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (android.text.TextUtils.equals(r0.dZA(), "1") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r5.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(v vVar, boolean z, JSONArray jSONArray) {
        List<k> bbu = vVar.bbu();
        if (bbu != null && bbu.size() > 0) {
            ArrayList arrayList = new ArrayList(bbu);
            Iterator<k> it = bbu.iterator();
            while (it.hasNext()) {
                k next = it.next();
                k Wl = this.ogN.Wl(next.getId());
                String version = next.getVersion();
                String str = "0";
                if (Wl != null) {
                    str = Wl.getVersion();
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
                        this.ogU++;
                    } else {
                        boolean a2 = this.ogN.a(next);
                        jSONObject.put("product", String.format("set/%s", next.getId()));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        jSONObject.put("version", version);
                        if (!a2) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.ogT++;
                        } else {
                            this.ogS++;
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
            vVar.fd(arrayList);
        }
    }

    void b(v vVar, boolean z, JSONArray jSONArray) {
        String str;
        JSONObject dZG = vVar.dZG();
        if (dZG != null) {
            Iterator<String> keys = dZG.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k Wl = this.ogN.Wl(next);
                    String optString = dZG.optString(next, "0");
                    if (Wl == null) {
                        str = "0";
                    } else {
                        str = Wl.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.ogU++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.ogN.Wm(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.ogT++;
                        } else {
                            this.ogS++;
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
    private boolean dN(Context context) {
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
    private void dw(String str, String str2) {
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
            y.yO("save to file suc");
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
    public void yw(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        y.yO("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            y.yO("delete file suc");
        }
        this.ogN.yu(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yx(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        y.yO("upload file fail");
        this.ogN.yv(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void baM() {
        File[] listFiles;
        if (dN(this.mContext)) {
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
                    this.ogN.bay();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o Wn = this.ogN.Wn(listFiles[i].getName());
                    if (Wn != null && TextUtils.equals("0", Wn.bbj())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        y.yO("processFailedData file, no need to send");
                    } else if (Wn != null && TextUtils.equals("1", Wn.bbj())) {
                        y.yO("processFailedData file, send");
                        this.ogN.dv(listFiles[i].getName(), "0");
                        yy(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        y.yO("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1333=5, 1335=4, 1336=4, 1337=4] */
    void yy(String str) {
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
                            d.dZv().E(jSONObject, str);
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
    public void baN() {
        this.ogN.baz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ah ahVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> dEk = UBC.getUBCContext().dEk();
            if (dEk == null || dEk.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= dEk.size()) {
                    break;
                }
                arrayList.add(new j(dEk.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.ogN.a(arrayList, ahVar);
            b(ahVar);
            baH();
            return true;
        }
        return false;
    }

    public String getUploadType(String str) {
        return this.ogR != null ? this.ogR.getUploadType(str) : "";
    }
}
