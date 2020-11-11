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
    private SparseArray<ArrayList> elA;
    private HashMap<String, Long> elB;
    private List<n> elv;
    private long elx;
    private long ely;
    private int elz;
    private Context mContext;
    private int opP;
    private long opQ;
    private boolean opR = false;
    private w opS;
    private b opT;
    private long opU;
    private u opV;
    private g opW;
    private int opX;
    private int opY;
    private int opZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ag edv = ag.edv();
        this.opS = new w(context);
        this.opT = new b(context);
        this.opV = ae.edu();
        this.elv = new ArrayList(20);
        this.elx = edv.getLong("ubc_last_upload_non_real", 0L);
        this.ely = edv.getLong("ubc_reset_real_time_count_time", 0L);
        this.opU = edv.getLong("ubc_last_upload_failed_data_time", 0L);
        this.elz = edv.getInt("ubc_real_time_count", 0);
        this.opW = g.edf();
        this.opW.a(this, context);
        this.opQ = System.currentTimeMillis();
        int nextInt = new Random().nextInt(31) + 60;
        this.opP = nextInt;
        new Timer().schedule(new TimerTask() { // from class: com.baidu.ubc.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!c.this.opR) {
                    ah ahVar = new ah();
                    ahVar.ia(true);
                    c.this.a(ahVar, "0");
                }
            }
        }, nextInt * 1000);
    }

    private void bdd() {
        if (this.elA == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.elA = new SparseArray<>();
            this.opS.b(this.elA);
            this.elB = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.elA.size(); i2++) {
                int keyAt = this.elA.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.elB.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.opW.ng(i);
        }
    }

    public w edc() {
        return this.opS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.bdD()) && this.opW.yN(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.opS.a(nVar);
                return;
            }
            List<String> dGM = UBC.getUBCContext().dGM();
            if (dGM == null || !dGM.contains(nVar.getId())) {
                this.opS.a(nVar);
                return;
            } else if (!this.opR) {
                if ((System.currentTimeMillis() - this.opQ) / 1000 >= this.opP) {
                    this.opR = true;
                } else {
                    this.opS.a(nVar);
                    return;
                }
            }
        }
        if (z && !d(nVar)) {
            if (this.opW.WE(nVar.getId())) {
                this.opS.a(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.opS.bcX();
        } else if (Math.abs(System.currentTimeMillis() - this.elx) >= g.edf().bdp()) {
            if (!z && this.opW.WE(nVar.getId())) {
                this.elv.add(nVar);
            }
            bdi();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.opW.WE(nVar.getId())) {
                this.elv.add(nVar);
            }
            if (this.elv.size() >= 20) {
                bde();
            }
        } else if (!z && this.opW.WE(nVar.getId())) {
            this.opS.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        this.opT.a(nVar, this.opW.yN(nVar.getId()));
    }

    private void bde() {
        if (this.elv != null && this.elv.size() != 0) {
            this.opS.aX(this.elv);
            this.elv.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.opS.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.opS.i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> dGM;
        bde();
        this.opS.a(str, i, j, jSONArray);
        boolean yN = this.opW.yN(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (yN && (dGM = UBC.getUBCContext().dGM()) != null && dGM.contains(str)) {
                if (!this.opR) {
                    if ((System.currentTimeMillis() - this.opQ) / 1000 >= this.opP) {
                        this.opR = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (yN) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            bdf();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.elx) >= g.edf().bdp()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bdi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(String str, int i) {
        bde();
        this.opS.K(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.elx) >= g.edf().bdp()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bdi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(n nVar) {
        if (dN(this.mContext)) {
            nVar.WL("1");
            ah e = e(nVar);
            if (e.isEmpty()) {
                return false;
            }
            this.opS.d(e);
            d.edd().a(e.edx(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.opS.a(nVar2);
                    } else {
                        c.this.opS.edp();
                    }
                }
            });
            e.clearData();
            return true;
        }
        return false;
    }

    private boolean d(n nVar) {
        if (dN(this.mContext) && bdg()) {
            bde();
            ah e = e(nVar);
            if (e != null) {
                if (this.elA == null) {
                    bdd();
                }
                if (a(e, "0")) {
                    return true;
                }
                a(this.elA, e);
                b(e);
                bdh();
                return true;
            }
            return false;
        }
        return false;
    }

    private ah e(n nVar) {
        ah ahVar = new ah();
        ahVar.ia(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", Long.toString(nVar.getTime()));
            if (nVar.bdG() != null) {
                jSONObject.put("content", nVar.bdG().toString());
            } else {
                jSONObject.put("content", nVar.getContent());
            }
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.bdF())) {
                jSONObject.put("abtest", nVar.bdF());
                ahVar.ze("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.bdB()) {
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
            }
            jSONObject.put("idtype", this.opW.yT(nVar.getId()));
            jSONObject.put("isreal", this.opW.WG(nVar.getId()) ? "1" : "0");
            String WH = this.opW.WH(nVar.getId());
            if (!TextUtils.isEmpty(WH) && !TextUtils.equals(WH, "0")) {
                jSONObject.put("gflow", WH);
            }
            ahVar.dj(jSONObject);
            ahVar.r(nVar.getTime(), nVar.getTime());
            return ahVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void bdf() {
        if (dN(this.mContext) && bdg()) {
            ah ahVar = new ah();
            ahVar.ia(true);
            if (this.elA == null) {
                bdd();
            }
            if (!a(ahVar, "1")) {
                a(this.elA, ahVar);
                b(ahVar);
                bdh();
            }
        }
    }

    private void a(SparseArray<ArrayList> sparseArray, ah ahVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size() && !ahVar.np(com.baidu.fsg.base.statistics.b.c)) {
                this.opS.a(sparseArray.valueAt(i2), ahVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean bdg() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.ely) > 86400000) {
            this.elz = 0;
            this.ely = currentTimeMillis;
            ag.edv().putLong("ubc_reset_real_time_count_time", this.ely);
            ag.edv().putInt("ubc_real_time_count", this.elz);
        }
        if (this.elz >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.elz == 10000) {
                this.elz++;
                if (!DEBUG) {
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
                }
            }
            return false;
        }
        return true;
    }

    private void bdh() {
        this.elz++;
        ag.edv().putInt("ubc_real_time_count", this.elz);
    }

    private void bdi() {
        if (dN(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.elx = System.currentTimeMillis();
            ag.edv().putLong("ubc_last_upload_non_real", this.elx);
            bdk();
            bde();
            this.opS.bcX();
            HashSet hashSet = new HashSet();
            if (this.elA == null) {
                bdd();
            }
            ah ahVar = new ah();
            ahVar.ia(false);
            int i = 0;
            for (int i2 = 0; i2 < this.elA.size(); i2++) {
                int keyAt = this.elA.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.elB.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.opW.bdp()) {
                        i |= this.opS.a(this.elA.valueAt(i2), ahVar);
                        this.elB.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.elA.size(); i3++) {
                    int keyAt2 = this.elA.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ahVar.np(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.opS.a(this.elA.valueAt(i3), ahVar);
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
            this.opS.bcX();
            ah ahVar = new ah();
            if (this.opS.c(ahVar) != 0) {
                ah ahVar2 = new ah();
                ahVar2.r(ahVar.beg(), ahVar.getMaxTime());
                ahVar2.ze(ahVar.bef());
                ahVar2.ia(true);
                ah ahVar3 = new ah();
                ahVar3.r(ahVar.beg(), ahVar.getMaxTime());
                ahVar3.ze(ahVar.bef());
                ahVar3.ia(false);
                SparseArray<Integer> bec = ahVar.bec();
                int size = bec.size();
                for (int i = 0; i < size; i++) {
                    if (this.opW.yN(String.valueOf(bec.valueAt(i).intValue()))) {
                        ahVar2.aF(bec.keyAt(i), bec.valueAt(i).intValue());
                    } else {
                        ahVar3.aF(bec.keyAt(i), bec.valueAt(i).intValue());
                    }
                }
                ArrayList bed = ahVar.bed();
                int size2 = bed.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bed.get(i2);
                    if (this.opW.yN(str)) {
                        ahVar2.zd(str);
                    } else {
                        ahVar3.zd(str);
                    }
                }
                JSONArray beh = ahVar.beh();
                int length = beh.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = beh.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.opW.yN(str2)) {
                                ahVar2.dj(optJSONObject);
                            } else {
                                ahVar3.dj(optJSONObject);
                            }
                        }
                    }
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "total " + ahVar.beh().length() + " real size = " + ahVar2.beh().length() + "   no real  = " + ahVar3.beh().length());
                }
                if (ahVar2.beh().length() > 0) {
                    b(ahVar2);
                }
                if (ahVar3.beh().length() > 0) {
                    b(ahVar3);
                }
            }
        }
    }

    private void b(ah ahVar) {
        if (!ahVar.isEmpty()) {
            try {
                JSONObject edx = ahVar.edx();
                String md5 = af.toMd5(edx.toString().getBytes(), true);
                dw(edx.toString(), md5);
                if (DEBUG) {
                    y.e(ahVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.opS.a(ahVar.bec(), ahVar.bed(), ahVar.bei(), md5)) {
                    ahVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.opS.yI(md5);
                    return;
                }
                d.edd().E(edx, md5);
                ahVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.opU) >= 7200000) {
                    this.opU = currentTimeMillis;
                    ag.edv().putLong("ubc_last_upload_failed_data_time", this.opU);
                    d.edd().bdm();
                }
            } catch (OutOfMemoryError e) {
                ahVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean i = this.opV.i(jSONObject, z);
        if (tVar != null) {
            tVar.a(i, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.edd().au(str, i);
        }
    }

    private void bdk() {
        hX(true);
        hX(false);
    }

    private void hX(boolean z) {
        ah ahVar = new ah();
        ahVar.ia(z);
        if (this.opT.a(ahVar, z)) {
            JSONObject edx = ahVar.edx();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + edx.toString());
            }
            this.opT.hW(z);
            d.edd().eE(edx);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        JSONArray jSONArray = new JSONArray();
        this.opX = 0;
        this.opY = 0;
        this.opZ = 0;
        String edm = vVar.edm();
        if (edm == null || TextUtils.equals(edm, "1")) {
        }
        b(vVar, z, jSONArray);
        a(vVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.opX + this.opY + this.opZ), Integer.valueOf(this.opX), Integer.valueOf(this.opZ)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.opW.aZ(vVar.bdU());
        int bdT = vVar.bdT();
        if (bdT > 0) {
            this.opW.nh(bdT * 86400000);
        }
        if (vVar.bdS() > 0) {
            this.opW.ni(vVar.bdS());
        }
        if (this.elA == null) {
            this.elA = new SparseArray<>();
        }
        this.elA.clear();
        if (this.elB == null) {
            this.elB = new HashMap<>();
        }
        this.elB.clear();
        this.opS.b(this.elA);
        int i = 0;
        for (int i2 = 0; i2 < this.elA.size(); i2++) {
            int keyAt = this.elA.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.elB.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.opW.ng(i);
        vVar.bdU().clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (android.text.TextUtils.equals(r7.edi(), "1") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (android.text.TextUtils.equals(r0.edi(), "1") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r5.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(v vVar, boolean z, JSONArray jSONArray) {
        List<k> bdU = vVar.bdU();
        if (bdU != null && bdU.size() > 0) {
            ArrayList arrayList = new ArrayList(bdU);
            Iterator<k> it = bdU.iterator();
            while (it.hasNext()) {
                k next = it.next();
                k WO = this.opS.WO(next.getId());
                String version = next.getVersion();
                String str = "0";
                if (WO != null) {
                    str = WO.getVersion();
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
                        this.opZ++;
                    } else {
                        boolean a2 = this.opS.a(next);
                        jSONObject.put("product", String.format("set/%s", next.getId()));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        jSONObject.put("version", version);
                        if (!a2) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.opY++;
                        } else {
                            this.opX++;
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
            vVar.fl(arrayList);
        }
    }

    void b(v vVar, boolean z, JSONArray jSONArray) {
        String str;
        JSONObject edo = vVar.edo();
        if (edo != null) {
            Iterator<String> keys = edo.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k WO = this.opS.WO(next);
                    String optString = edo.optString(next, "0");
                    if (WO == null) {
                        str = "0";
                    } else {
                        str = WO.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.opZ++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.opS.WP(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.opY++;
                        } else {
                            this.opX++;
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
            y.zc("save to file suc");
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
    public void yK(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        y.zc("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            y.zc("delete file suc");
        }
        this.opS.yI(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yL(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        y.zc("upload file fail");
        this.opS.yJ(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bdm() {
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
                    this.opS.bcY();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o WQ = this.opS.WQ(listFiles[i].getName());
                    if (WQ != null && TextUtils.equals("0", WQ.bdJ())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        y.zc("processFailedData file, no need to send");
                    } else if (WQ != null && TextUtils.equals("1", WQ.bdJ())) {
                        y.zc("processFailedData file, send");
                        this.opS.dv(listFiles[i].getName(), "0");
                        yM(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        y.zc("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1333=5, 1335=4, 1336=4, 1337=4] */
    void yM(String str) {
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
                            d.edd().E(jSONObject, str);
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
    public void bdn() {
        this.opS.bcZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ah ahVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> dGM = UBC.getUBCContext().dGM();
            if (dGM == null || dGM.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= dGM.size()) {
                    break;
                }
                arrayList.add(new j(dGM.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.opS.a(arrayList, ahVar);
            b(ahVar);
            bdh();
            return true;
        }
        return false;
    }

    public String getUploadType(String str) {
        return this.opW != null ? this.opW.getUploadType(str) : "";
    }
}
