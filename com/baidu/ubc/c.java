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
    private int ezA;
    private SparseArray<ArrayList> ezB;
    private HashMap<String, Long> ezC;
    private List<n> ezw;
    private long ezy;
    private long ezz;
    private Context mContext;
    private int oUI;
    private long oUJ;
    private x oUL;
    private b oUM;
    private long oUP;
    private u oUQ;
    private g oUR;
    private int oUS;
    private int oUT;
    private int oUU;
    private boolean oUK = false;
    private int oUN = 0;
    private long oUO = 0;
    private Runnable oUV = new Runnable() { // from class: com.baidu.ubc.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.oUN == 1) {
                long uptimeMillis = SystemClock.uptimeMillis() - c.this.oUO;
                if (uptimeMillis >= 5000) {
                    if (c.DEBUG) {
                        Log.d("UBCBehaviorModel", String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis)));
                    }
                    c.this.bev();
                    c.this.oUN = 0;
                    return;
                }
                d.ehJ().e(this, 5000 - uptimeMillis);
            } else if (c.this.oUN == 2) {
                c.this.oUN = 0;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        ai eij = ai.eij();
        this.oUL = new x(context);
        this.oUM = new b(context);
        this.oUQ = ag.eii();
        this.ezw = new ArrayList(20);
        this.ezy = eij.getLong("ubc_last_upload_non_real", 0L);
        this.ezz = eij.getLong("ubc_reset_real_time_count_time", 0L);
        this.oUP = eij.getLong("ubc_last_upload_failed_data_time", 0L);
        this.ezA = eij.getInt("ubc_real_time_count", 0);
        this.oUR = g.ehN();
        this.oUR.a(this, context);
        this.oUJ = System.currentTimeMillis();
        this.oUI = new Random().nextInt(31) + 60;
    }

    private void beu() {
        int i = 0;
        if (this.ezB == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.ezB = new SparseArray<>();
            this.oUL.c(this.ezB);
            this.ezC = new HashMap<>();
            int i2 = 0;
            while (true) {
                int i3 = i;
                if (i2 < this.ezB.size()) {
                    int keyAt = this.ezB.keyAt(i2);
                    i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                    this.ezC.put("ubc_last_upload_time_level_" + keyAt, 0L);
                    i2++;
                } else {
                    this.oUR.mh(i3);
                    return;
                }
            }
        }
    }

    public x ehI() {
        return this.oUL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(n nVar) {
        boolean z = false;
        if (TextUtils.equals(nVar.getId(), nVar.beU()) && this.oUR.yD(nVar.getId()) && (nVar.getOption() & 64) == 0) {
            z = true;
        }
        if (UBC.getUBCContext().isPeakTime()) {
            if (!z) {
                this.oUL.b(nVar);
                return;
            }
            List<String> dKx = UBC.getUBCContext().dKx();
            if (dKx == null || !dKx.contains(nVar.getId())) {
                this.oUL.b(nVar);
                return;
            } else if (!this.oUK) {
                if ((System.currentTimeMillis() - this.oUJ) / 1000 >= this.oUI) {
                    this.oUK = true;
                } else {
                    this.oUL.b(nVar);
                    return;
                }
            }
        }
        if (z && !g(nVar)) {
            if (this.oUR.Xx(nVar.getId())) {
                this.oUL.b(nVar);
            }
        } else if (UBC.getUBCContext().isPeakTime()) {
            this.oUL.beo();
        } else if (Math.abs(System.currentTimeMillis() - this.ezy) >= g.ehN().beG()) {
            if (!z && this.oUR.Xx(nVar.getId())) {
                e(nVar);
            }
            bez();
        } else if ((nVar.getOption() & 1) == 0) {
            if (!z && this.oUR.Xx(nVar.getId())) {
                e(nVar);
            }
            if (this.ezw.size() >= 20) {
                bev();
            }
        } else if (!z && this.oUR.Xx(nVar.getId())) {
            this.oUL.b(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(n nVar) {
        this.oUM.a(nVar, this.oUR.yD(nVar.getId()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(n nVar) {
        if (com.baidu.pyramid.runtime.multiprocess.a.aee()) {
            this.oUM.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bev() {
        if (this.ezw != null && this.ezw.size() != 0) {
            this.oUL.bc(this.ezw);
            this.ezw.clear();
            if (this.oUN == 1) {
                this.oUN = 2;
            }
        }
    }

    private void e(n nVar) {
        this.ezw.add(nVar);
        if (this.oUN == 0) {
            this.oUO = SystemClock.uptimeMillis();
            d.ehJ().e(this.oUV, 5000L);
            this.oUN = 1;
        } else if (this.oUN == 2) {
            this.oUO = SystemClock.uptimeMillis();
            this.oUN = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.oUL.b(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.oUL.i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        List<String> dKx;
        bev();
        this.oUL.a(str, i, j, jSONArray);
        boolean yD = this.oUR.yD(str);
        if (UBC.getUBCContext().isPeakTime()) {
            if (yD && (dKx = UBC.getUBCContext().dKx()) != null && dKx.contains(str)) {
                if (!this.oUK) {
                    if ((System.currentTimeMillis() - this.oUJ) / 1000 >= this.oUI) {
                        this.oUK = true;
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        if (yD) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            bew();
        }
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.ezy) >= g.ehN().beG()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bez();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(String str, int i) {
        bev();
        this.oUL.P(str, i);
        if (!UBC.getUBCContext().isPeakTime() && Math.abs(System.currentTimeMillis() - this.ezy) >= g.ehN().beG()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            bez();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(n nVar) {
        if (isNetWorkEnabled(this.mContext)) {
            nVar.XF("1");
            aj h = h(nVar);
            if (h.isEmpty()) {
                return false;
            }
            this.oUL.c(h);
            d.ehJ().a(h.eim(), true, nVar, new t() { // from class: com.baidu.ubc.c.2
                @Override // com.baidu.ubc.t
                public void a(boolean z, n nVar2) {
                    if (!z) {
                        c.this.oUL.b(nVar2);
                    } else {
                        c.this.oUL.eib();
                    }
                }
            });
            h.clearData();
            return true;
        }
        return false;
    }

    private boolean g(n nVar) {
        if (isNetWorkEnabled(this.mContext) && bex()) {
            bev();
            aj h = h(nVar);
            if (h != null) {
                if (this.ezB == null) {
                    beu();
                }
                if (a(h, "0")) {
                    return true;
                }
                a(this.ezB, h);
                b(h);
                bey();
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
            if (nVar.beX() != null) {
                jSONObject.put("content", nVar.beX().toString());
            } else {
                jSONObject.put("content", nVar.getContent());
            }
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.beW())) {
                jSONObject.put("abtest", nVar.beW());
                ajVar.yU("1");
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.beS()) {
                jSONObject.put("of", "1");
            }
            jSONObject.put("idtype", this.oUR.yJ(nVar.getId()));
            jSONObject.put("isreal", this.oUR.Xz(nVar.getId()) ? "1" : "0");
            String XA = this.oUR.XA(nVar.getId());
            if (!TextUtils.isEmpty(XA) && !TextUtils.equals(XA, "0")) {
                jSONObject.put("gflow", XA);
            }
            ajVar.dm(jSONObject);
            ajVar.y(nVar.getTime(), nVar.getTime());
            return ajVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void bew() {
        if (isNetWorkEnabled(this.mContext) && bex()) {
            aj ajVar = new aj();
            ajVar.iL(true);
            if (this.ezB == null) {
                beu();
            }
            if (!a(ajVar, "1")) {
                a(this.ezB, ajVar);
                b(ajVar);
                bey();
            }
        }
    }

    private void a(SparseArray<ArrayList> sparseArray, aj ajVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size() && !ajVar.mq(com.baidu.fsg.base.statistics.b.c)) {
                this.oUL.a(sparseArray.valueAt(i2), ajVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean bex() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.ezz) > 86400000) {
            this.ezA = 0;
            this.ezz = currentTimeMillis;
            ai.eij().putLong("ubc_reset_real_time_count_time", this.ezz);
            ai.eij().putInt("ubc_real_time_count", this.ezA);
        }
        if (this.ezA >= 10000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.ezA == 10000) {
                this.ezA++;
                if (!DEBUG) {
                    ac.eif().XL(String.valueOf(10000));
                }
            }
            return false;
        }
        return true;
    }

    private void bey() {
        this.ezA++;
        ai.eij().putInt("ubc_real_time_count", this.ezA);
    }

    private void bez() {
        if (isNetWorkEnabled(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.ezy = System.currentTimeMillis();
            ai.eij().putLong("ubc_last_upload_non_real", this.ezy);
            beB();
            bev();
            this.oUL.beo();
            HashSet hashSet = new HashSet();
            if (this.ezB == null) {
                beu();
            }
            aj ajVar = new aj();
            ajVar.iL(false);
            int i = 0;
            for (int i2 = 0; i2 < this.ezB.size(); i2++) {
                int keyAt = this.ezB.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.ezC.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * AppStatusRules.DEFAULT_GRANULARITY)) - System.currentTimeMillis() < this.oUR.beG()) {
                        i |= this.oUL.a(this.ezB.valueAt(i2), ajVar);
                        this.ezC.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.ezB.size(); i3++) {
                    int keyAt2 = this.ezB.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (ajVar.mq(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.oUL.a(this.ezB.valueAt(i3), ajVar);
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
            this.oUL.beo();
            aj ajVar = new aj();
            ajVar.Nr(this.oUR.ehO());
            ajVar.iL(true);
            aj ajVar2 = new aj();
            ajVar2.Nr(this.oUR.ehO());
            ajVar2.iL(false);
            if (this.oUL.a(ajVar, ajVar2) != 0) {
                if (DEBUG) {
                    int length = ajVar.bfy().length();
                    Log.d("UBCBehaviorModel", "real size = " + length + "   no real  = " + ajVar2.bfy().length());
                }
                if (ajVar.bfy().length() > 0) {
                    b(ajVar);
                }
                if (ajVar2.bfy().length() > 0) {
                    b(ajVar2);
                }
            }
        }
    }

    private void b(aj ajVar) {
        if (!ajVar.isEmpty()) {
            try {
                JSONObject eim = ajVar.eim();
                String md5 = ah.toMd5(eim.toString().getBytes(), true);
                du(eim.toString(), md5);
                if (DEBUG) {
                    z.d(ajVar);
                    Log.d("UBCBehaviorModel", "save send data to file " + md5);
                }
                if (!this.oUL.a(ajVar.bft(), ajVar.bfu(), ajVar.bfz(), md5)) {
                    ajVar.clearData();
                    File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                    if (file.exists() && file.delete()) {
                        Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                    }
                    this.oUL.yy(md5);
                    return;
                }
                d.ehJ().B(eim, md5);
                ajVar.clearData();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.oUP) >= 7200000) {
                    this.oUP = currentTimeMillis;
                    ai.eij().putLong("ubc_last_upload_failed_data_time", this.oUP);
                    d.ehJ().beD();
                }
            } catch (OutOfMemoryError e) {
                ajVar.clearData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean i = this.oUQ.i(jSONObject, z);
        if (tVar != null) {
            tVar.a(i, nVar);
        }
        if (!TextUtils.isEmpty(str)) {
            d.ehJ().au(str, i);
        }
    }

    private void beB() {
        iI(true);
        iI(false);
    }

    private void iI(boolean z) {
        aj ajVar = new aj();
        ajVar.iL(z);
        if (this.oUM.a(ajVar, z)) {
            JSONObject eim = ajVar.eim();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + eim.toString());
            }
            this.oUM.iH(z);
            d.ehJ().eS(eim);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w wVar, boolean z, s sVar) {
        int i = 0;
        JSONArray jSONArray = new JSONArray();
        this.oUS = 0;
        this.oUT = 0;
        this.oUU = 0;
        b(wVar, z, jSONArray);
        a(wVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.oUS + this.oUT + this.oUU), Integer.valueOf(this.oUS), Integer.valueOf(this.oUU)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        this.oUR.be(wVar.bfl());
        int bfk = wVar.bfk();
        if (bfk > 0) {
            this.oUR.mi(bfk * 86400000);
        }
        if (wVar.bfj() > 0) {
            this.oUR.mj(wVar.bfj());
        }
        int ehZ = wVar.ehZ();
        if (ehZ > 307200) {
            this.oUR.Nl(ehZ);
        }
        int eia = wVar.eia();
        if (eia > 30720) {
            this.oUR.Nm(eia);
        }
        if (this.ezB == null) {
            this.ezB = new SparseArray<>();
        }
        this.ezB.clear();
        if (this.ezC == null) {
            this.ezC = new HashMap<>();
        }
        this.ezC.clear();
        this.oUL.c(this.ezB);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.ezB.size()) {
                int keyAt = this.ezB.keyAt(i2);
                i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                this.ezC.put("ubc_last_upload_time_level_" + keyAt, 0L);
                i2++;
            } else {
                this.oUR.mh(i3);
                wVar.bfl().clear();
                return;
            }
        }
    }

    void a(w wVar, boolean z, JSONArray jSONArray) {
        List<k> bfl = wVar.bfl();
        if (bfl != null && bfl.size() != 0) {
            ArrayList arrayList = new ArrayList(bfl);
            if (this.oUL.eic() > 0) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((k) it.next()).getId());
                }
                HashMap<String, String> bi = this.oUL.bi(arrayList2);
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
                                this.oUU++;
                            } else if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && TextUtils.equals(kVar.ehS(), "1")) {
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
            boolean gr = this.oUL.gr(arrayList);
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                k kVar2 = (k) it3.next();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("product", "set/" + kVar2.getId());
                    jSONObject3.put("version", kVar2.getVersion());
                    if (gr) {
                        jSONObject3.put(CloudControlUBCUtils.KEY_VALID, "1");
                        this.oUS++;
                    } else {
                        jSONObject3.put(CloudControlUBCUtils.KEY_VALID, "0");
                        this.oUT++;
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
        JSONObject ehY = wVar.ehY();
        if (ehY != null) {
            Iterator<String> keys = ehY.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    k XI = this.oUL.XI(next);
                    String optString = ehY.optString(next, "0");
                    if (XI == null) {
                        str = "0";
                    } else {
                        str = XI.getVersion();
                    }
                    boolean z2 = Integer.parseInt(str) >= Integer.parseInt(optString);
                    if (z && str != null && z2) {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "2");
                        jSONObject.put("version", optString);
                        jSONArray.put(jSONObject);
                        this.oUU++;
                    } else {
                        jSONObject.put("product", String.format("del/%s", next));
                        jSONObject.put("version", optString);
                        jSONObject.put(CloudControlUBCUtils.KEY_VALID, "1");
                        if (!this.oUL.XJ(next)) {
                            jSONObject.put(CloudControlUBCUtils.KEY_VALID, "0");
                            this.oUT++;
                        } else {
                            this.oUS++;
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
            z.yS("save to file suc");
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
    public void yA(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        z.yS("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            z.yS("delete file suc");
        }
        this.oUL.yy(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yB(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        z.yS("upload file fail");
        this.oUL.yz(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beD() {
        File[] listFiles;
        if (isNetWorkEnabled(this.mContext)) {
            File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 1000) {
                    if (!DEBUG) {
                        ac.eif().ci(String.valueOf(1000), listFiles.length);
                    }
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.oUL.bep();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o XK = this.oUL.XK(listFiles[i].getName());
                    if (XK != null && TextUtils.equals("0", XK.bfa())) {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        z.yS("processFailedData file, no need to send");
                    } else if (XK != null && TextUtils.equals("1", XK.bfa())) {
                        z.yS("processFailedData file, send");
                        this.oUL.dt(listFiles[i].getName(), "0");
                        yC(listFiles[i].getName());
                    } else {
                        if (DEBUG) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        z.yS("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1409=5, 1411=4, 1412=4, 1413=4] */
    void yC(String str) {
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
                            d.ehJ().B(jSONObject, str);
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
    public void beE() {
        this.oUL.beq();
    }

    private boolean a(aj ajVar, String str) {
        int i = 0;
        if (UBC.getUBCContext().isPeakTime()) {
            List<String> dKx = UBC.getUBCContext().dKx();
            if (dKx == null || dKx.size() == 0) {
                return true;
            }
            ArrayList<j> arrayList = new ArrayList<>();
            while (true) {
                int i2 = i;
                if (i2 >= dKx.size()) {
                    break;
                }
                arrayList.add(new j(dKx.get(i2), str));
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                return true;
            }
            this.oUL.a(arrayList, ajVar);
            b(ajVar);
            bey();
            return true;
        }
        return false;
    }

    public String getUploadType(String str) {
        return this.oUR != null ? this.oUR.getUploadType(str) : "";
    }
}
