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
/* loaded from: classes15.dex */
public class c {
    private static final boolean DEBUG = AppConfig.isDebug();
    private List<n> ejO;
    private long ejQ;
    private long ejR;
    private int ejS;
    private SparseArray<ArrayList> ejT;
    private HashMap<String, Long> ejU;
    private Context mContext;
    private g orA;
    private int orB;
    private int orC;
    private int orD;
    private int ort;
    private long oru;
    private boolean orv = false;
    private w orw;
    private b orx;
    private long ory;
    private u orz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ag edu = ag.edu();
        this.orw = new w(context);
        this.orx = new b(context);
        this.orz = ae.edt();
        this.ejO = new ArrayList(20);
        this.ejQ = edu.getLong("ubc_last_upload_non_real", 0L);
        this.ejR = edu.getLong("ubc_reset_real_time_count_time", 0L);
        this.ory = edu.getLong("ubc_last_upload_failed_data_time", 0L);
        this.ejS = edu.getInt("ubc_real_time_count", 0);
        this.orA = g.ede();
        this.orA.a(this, context);
        this.oru = System.currentTimeMillis();
        int nextInt = new Random().nextInt(31) + 60;
        this.ort = nextInt;
        new Timer().schedule(new TimerTask() { // from class: com.baidu.ubc.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!c.this.orv) {
                    ah ahVar = new ah();
                    ahVar.id(true);
                    c.this.a(ahVar, "0");
                }
            }
        }, nextInt * 1000);
    }

    private void bcw() {
        if (this.ejT == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.ejT = new SparseArray<>();
            this.orw.b(this.ejT);
            this.ejU = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.ejT.size(); i2++) {
                int keyAt = this.ejT.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.ejU.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.orA.nc(i);
        }
    }

    public w edb() {
        return this.orw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.bcW()) && this.orA.yI(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.orw.a(nVar);
                return;
            }
            List<String> dGD = UBC.getUBCContext().dGD();
            if (dGD == null || !dGD.contains(nVar.getId())) {
                this.orw.a(nVar);
                return;
            } else if (!this.orv) {
                if ((System.currentTimeMillis() - this.oru) / 1000 >= this.ort) {
                    this.orv = true;
                } else {
                    this.orw.a(nVar);
                    return;
                }
            }
        }
        if (z && !d(nVar)) {
            if (this.orA.Wp(nVar.getId())) {
                this.orw.a(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.orw.bcq();
        } else if (Math.abs(System.currentTimeMillis() - this.ejQ) >= g.ede().bcI()) {
            if (!z && this.orA.Wp(nVar.getId())) {
                this.ejO.add(nVar);
            }
            bcB();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.orA.Wp(nVar.getId())) {
                this.ejO.add(nVar);
            }
            if (this.ejO.size() >= 20) {
                bcx();
            }
        } else if (!z && this.orA.Wp(nVar.getId())) {
            this.orw.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        this.orx.a(nVar, this.orA.yI(nVar.getId()));
    }

    private void bcx() {
        if (this.ejO != null && this.ejO.size() != 0) {
            this.orw.aX(this.ejO);
            this.ejO.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.orw.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.orw.i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> dGD;
        bcx();
        this.orw.a(str, i, j, jSONArray);
        boolean yI = this.orA.yI(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (yI && (dGD = UBC.getUBCContext().dGD()) != null && dGD.contains(str)) {
                if (!this.orv) {
                    if ((System.currentTimeMillis() - this.oru) / 1000 >= this.ort) {
                        this.orv = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (yI) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            bcy();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.ejQ) >= g.ede().bcI()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bcB();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(String str, int i) {
        bcx();
        this.orw.K(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.ejQ) >= g.ede().bcI()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bcB();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(n nVar) {
        if (dN(this.mContext)) {
            nVar.Ww("1");
            ah e = e(nVar);
            if (e.isEmpty()) {
                return false;
            }
            this.orw.d(e);
            d.edc().a(e.edw(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.orw.a(nVar2);
                    } else {
                        c.this.orw.edo();
                    }
                }
            });
            e.clearData();
            return true;
        }
        return false;
    }

    private boolean d(n nVar) {
        if (dN(this.mContext) && bcz()) {
            bcx();
            ah e = e(nVar);
            if (e != null) {
                if (this.ejT == null) {
                    bcw();
                }
                if (a(e, "0")) {
                    return true;
                }
                a(this.ejT, e);
                b(e);
                bcA();
                return true;
            }
            return false;
        }
        return false;
    }

    private ah e(n nVar) {
        ah ahVar = new ah();
        ahVar.id(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", Long.toString(nVar.getTime()));
            if (nVar.bcZ() != null) {
                jSONObject.put("content", nVar.bcZ().toString());
            } else {
                jSONObject.put("content", nVar.getContent());
            }
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.bcY())) {
                jSONObject.put("abtest", nVar.bcY());
                ahVar.yZ("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.bcU()) {
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
            }
            jSONObject.put("idtype", this.orA.yO(nVar.getId()));
            jSONObject.put("isreal", this.orA.Wr(nVar.getId()) ? "1" : "0");
            String Ws = this.orA.Ws(nVar.getId());
            if (!TextUtils.isEmpty(Ws) && !TextUtils.equals(Ws, "0")) {
                jSONObject.put("gflow", Ws);
            }
            ahVar.dd(jSONObject);
            ahVar.r(nVar.getTime(), nVar.getTime());
            return ahVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void bcy() {
        if (dN(this.mContext) && bcz()) {
            ah ahVar = new ah();
            ahVar.id(true);
            if (this.ejT == null) {
                bcw();
            }
            if (!a(ahVar, "1")) {
                a(this.ejT, ahVar);
                b(ahVar);
                bcA();
            }
        }
    }

    private void a(SparseArray<ArrayList> sparseArray, ah ahVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size() && !ahVar.nl(com.baidu.fsg.base.statistics.b.c)) {
                this.orw.a(sparseArray.valueAt(i2), ahVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean bcz() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.ejR) > 86400000) {
            this.ejS = 0;
            this.ejR = currentTimeMillis;
            ag.edu().putLong("ubc_reset_real_time_count_time", this.ejR);
            ag.edu().putInt("ubc_real_time_count", this.ejS);
        }
        if (this.ejS >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.ejS == 10000) {
                this.ejS++;
                if (!DEBUG) {
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
                }
            }
            return false;
        }
        return true;
    }

    private void bcA() {
        this.ejS++;
        ag.edu().putInt("ubc_real_time_count", this.ejS);
    }

    private void bcB() {
        if (dN(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.ejQ = System.currentTimeMillis();
            ag.edu().putLong("ubc_last_upload_non_real", this.ejQ);
            bcD();
            bcx();
            this.orw.bcq();
            HashSet hashSet = new HashSet();
            if (this.ejT == null) {
                bcw();
            }
            ah ahVar = new ah();
            ahVar.id(false);
            int i = 0;
            for (int i2 = 0; i2 < this.ejT.size(); i2++) {
                int keyAt = this.ejT.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.ejU.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.orA.bcI()) {
                        i |= this.orw.a(this.ejT.valueAt(i2), ahVar);
                        this.ejU.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.ejT.size(); i3++) {
                    int keyAt2 = this.ejT.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ahVar.nl(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.orw.a(this.ejT.valueAt(i3), ahVar);
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
            this.orw.bcq();
            ah ahVar = new ah();
            if (this.orw.c(ahVar) != 0) {
                ah ahVar2 = new ah();
                ahVar2.r(ahVar.bdz(), ahVar.getMaxTime());
                ahVar2.yZ(ahVar.bdy());
                ahVar2.id(true);
                ah ahVar3 = new ah();
                ahVar3.r(ahVar.bdz(), ahVar.getMaxTime());
                ahVar3.yZ(ahVar.bdy());
                ahVar3.id(false);
                SparseArray<Integer> bdv = ahVar.bdv();
                int size = bdv.size();
                for (int i = 0; i < size; i++) {
                    if (this.orA.yI(String.valueOf(bdv.valueAt(i).intValue()))) {
                        ahVar2.aF(bdv.keyAt(i), bdv.valueAt(i).intValue());
                    } else {
                        ahVar3.aF(bdv.keyAt(i), bdv.valueAt(i).intValue());
                    }
                }
                ArrayList bdw = ahVar.bdw();
                int size2 = bdw.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bdw.get(i2);
                    if (this.orA.yI(str)) {
                        ahVar2.yY(str);
                    } else {
                        ahVar3.yY(str);
                    }
                }
                JSONArray bdA = ahVar.bdA();
                int length = bdA.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = bdA.optJSONObject(i3);
                    if (optJSONObject.has("id")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.orA.yI(str2)) {
                                ahVar2.dd(optJSONObject);
                            } else {
                                ahVar3.dd(optJSONObject);
                            }
                        }
                    }
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "total " + ahVar.bdA().length() + " real size = " + ahVar2.bdA().length() + "   no real  = " + ahVar3.bdA().length());
                }
                if (ahVar2.bdA().length() > 0) {
                    b(ahVar2);
                }
                if (ahVar3.bdA().length() > 0) {
                    b(ahVar3);
                }
            }
        }
    }

    private void b(ah ahVar) {
        if (!ahVar.isEmpty()) {
            try {
                JSONObject edw = ahVar.edw();
                String md5 = af.toMd5(edw.toString().getBytes(), true);
                dv(edw.toString(), md5);
                if (DEBUG) {
                    y.e(ahVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.orw.a(ahVar.bdv(), ahVar.bdw(), ahVar.bdB(), md5)) {
                    ahVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.orw.yD(md5);
                    return;
                }
                d.edc().B(edw, md5);
                ahVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.ory) >= 7200000) {
                    this.ory = currentTimeMillis;
                    ag.edu().putLong("ubc_last_upload_failed_data_time", this.ory);
                    d.edc().bcF();
                }
            } catch (OutOfMemoryError e) {
                ahVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean i = this.orz.i(jSONObject, z);
        if (tVar != null) {
            tVar.a(i, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.edc().au(str, i);
        }
    }

    private void bcD() {
        ia(true);
        ia(false);
    }

    private void ia(boolean z) {
        ah ahVar = new ah();
        ahVar.id(z);
        if (this.orx.a(ahVar, z)) {
            JSONObject edw = ahVar.edw();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + edw.toString());
            }
            this.orx.hZ(z);
            d.edc().ez(edw);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, boolean z, s sVar) {
        JSONArray jSONArray = new JSONArray();
        this.orB = 0;
        this.orC = 0;
        this.orD = 0;
        String edl = vVar.edl();
        if (edl == null || TextUtils.equals(edl, "1")) {
        }
        b(vVar, z, jSONArray);
        a(vVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.orB + this.orC + this.orD), Integer.valueOf(this.orB), Integer.valueOf(this.orD)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.orA.aZ(vVar.bdn());
        int bdm = vVar.bdm();
        if (bdm > 0) {
            this.orA.nd(bdm * 86400000);
        }
        if (vVar.bdl() > 0) {
            this.orA.ne(vVar.bdl());
        }
        if (this.ejT == null) {
            this.ejT = new SparseArray<>();
        }
        this.ejT.clear();
        if (this.ejU == null) {
            this.ejU = new HashMap<>();
        }
        this.ejU.clear();
        this.orw.b(this.ejT);
        int i = 0;
        for (int i2 = 0; i2 < this.ejT.size(); i2++) {
            int keyAt = this.ejT.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.ejU.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.orA.nc(i);
        vVar.bdn().clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (android.text.TextUtils.equals(r7.edh(), "1") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (android.text.TextUtils.equals(r0.edh(), "1") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r5.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(v vVar, boolean z, JSONArray jSONArray) {
        List<k> bdn = vVar.bdn();
        if (bdn != null && bdn.size() > 0) {
            ArrayList arrayList = new ArrayList(bdn);
            Iterator<k> it = bdn.iterator();
            while (it.hasNext()) {
                k next = it.next();
                k Wz = this.orw.Wz(next.getId());
                String version = next.getVersion();
                String str = "0";
                if (Wz != null) {
                    str = Wz.getVersion();
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
                        this.orD++;
                    } else {
                        boolean a2 = this.orw.a(next);
                        jSONObject.put("product", String.format("set/%s", next.getId()));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        jSONObject.put("version", version);
                        if (!a2) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.orC++;
                        } else {
                            this.orB++;
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
        JSONObject edn = vVar.edn();
        if (edn != null) {
            Iterator<String> keys = edn.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k Wz = this.orw.Wz(next);
                    String optString = edn.optString(next, "0");
                    if (Wz == null) {
                        str = "0";
                    } else {
                        str = Wz.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.orD++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.orw.WA(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.orC++;
                        } else {
                            this.orB++;
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
    private void dv(String str, String str2) {
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
            y.yX("save to file suc");
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
    public void yF(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        y.yX("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            y.yX("delete file suc");
        }
        this.orw.yD(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yG(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        y.yX("upload file fail");
        this.orw.yE(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcF() {
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
                    this.orw.bcr();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o WB = this.orw.WB(listFiles[i].getName());
                    if (WB != null && TextUtils.equals("0", WB.bdc())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        y.yX("processFailedData file, no need to send");
                    } else if (WB != null && TextUtils.equals("1", WB.bdc())) {
                        y.yX("processFailedData file, send");
                        this.orw.du(listFiles[i].getName(), "0");
                        yH(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        y.yX("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1333=5, 1335=4, 1336=4, 1337=4] */
    void yH(String str) {
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
                            d.edc().B(jSONObject, str);
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
    public void bcG() {
        this.orw.bcs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ah ahVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> dGD = UBC.getUBCContext().dGD();
            if (dGD == null || dGD.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= dGD.size()) {
                    break;
                }
                arrayList.add(new j(dGD.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.orw.a(arrayList, ahVar);
            b(ahVar);
            bcA();
            return true;
        }
        return false;
    }

    public String getUploadType(String str) {
        return this.orA != null ? this.orA.getUploadType(str) : "";
    }
}
