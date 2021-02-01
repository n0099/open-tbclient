package com.baidu.tieba.quickWebView;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.lib.util.s;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.quickWebView.message.WebViewCacheReqMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResHttpMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResSocketMsg;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static b mPQ;
    private String dKH;
    private long mPS;
    private Map<String, String> mPU;
    private static final String TAG = b.class.getSimpleName() + " TestActivity";
    private static final String DOWNLOAD_DIR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    public static int mPT = 0;
    private boolean mPR = false;
    private CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.quickWebView.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && !b.this.mPR) {
                b.this.mPR = true;
                if (QuickWebViewSwitch.getInOn()) {
                    if (TbSingleton.getInstance().isUploadOffPack() || TbSingleton.getInstance().isClearOffPack()) {
                        a aVar = new a();
                        aVar.setPriority(4);
                        aVar.execute(new Void[0]);
                        return;
                    }
                    d dVar = new d();
                    dVar.setPriority(4);
                    dVar.execute(new Void[0]);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a mfk = new com.baidu.adp.framework.listener.a(1003365, CmdConfigSocket.WEBVIEW_CACHE_INFO) { // from class: com.baidu.tieba.quickWebView.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage instanceof WebViewCacheResHttpMsg) {
                    WebViewCacheResHttpMsg webViewCacheResHttpMsg = (WebViewCacheResHttpMsg) responsedMessage;
                    List<String> header = webViewCacheResHttpMsg.getHeader(SM.SET_COOKIE);
                    if (header != null && header.size() > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= header.size()) {
                                break;
                            } else if (TextUtils.isEmpty(header.get(i2)) || !header.get(i2).contains("BAIDUID=")) {
                                i = i2 + 1;
                            } else {
                                com.baidu.tbadk.browser.a.zy(header.get(i2));
                                break;
                            }
                        }
                    }
                    Map<String, com.baidu.tieba.quickWebView.message.a> moduleInfos = webViewCacheResHttpMsg.getModuleInfos();
                    if (moduleInfos != null && moduleInfos.size() > 0) {
                        for (String str : moduleInfos.keySet()) {
                            b.a(str, moduleInfos.get(str));
                        }
                        return;
                    }
                    com.baidu.tieba.quickWebView.c.dCM().xy(true);
                } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                    Map<String, com.baidu.tieba.quickWebView.message.a> moduleInfos2 = ((WebViewCacheResSocketMsg) responsedMessage).getModuleInfos();
                    if (moduleInfos2 != null && moduleInfos2.size() > 0) {
                        for (String str2 : moduleInfos2.keySet()) {
                            b.a(str2, moduleInfos2.get(str2));
                        }
                        return;
                    }
                    com.baidu.tieba.quickWebView.c.dCM().xy(true);
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public static class c {
        public String errorMsg;
        public boolean mIsSuccess;
    }

    public static b dCI() {
        if (mPQ == null) {
            synchronized (b.class) {
                if (mPQ == null) {
                    mPQ = new b();
                }
            }
        }
        return mPQ;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, com.baidu.tieba.quickWebView.message.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getVersion()) || StringUtils.isNull(aVar.getMd5()) || StringUtils.isNull(aVar.dCQ())) {
            com.baidu.tieba.quickWebView.c.dCM().M(true, str);
            return;
        }
        String Re = dCI().Re(str);
        String version = aVar.getVersion();
        String dCQ = aVar.dCQ();
        boolean dCP = aVar.dCP();
        String str2 = StringUtils.isNull(Re) ? "0.0.0.0" : Re;
        if (dCP && version.equals(str2)) {
            com.baidu.tieba.quickWebView.c.dCM().M(true, str);
            return;
        }
        com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, 0, "downloadCache", 0, "", "url", dCQ, "intallVersion", version, "lastVersion", str2, "type", "start", BdStatsConstant.StatsKey.TYPE, str);
        new C0852b(str, aVar, dCP ? false : true).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gc(String str, String str2) {
        String[] list;
        if (!TextUtils.isEmpty(str)) {
            String str3 = DOWNLOAD_DIR + "bdtbNWCache/" + str2;
            File file = new File(str3);
            if (file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0) {
                for (String str4 : list) {
                    if (!StringUtils.isNull(str4) && !str4.equals(str)) {
                        o.deleteFileOrDir(new File(str3 + "/" + str4));
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [326=9, 327=8] */
    private static HashMap<String, com.baidu.tieba.quickWebView.data.a> o(InputStream inputStream) {
        Reader reader;
        Reader reader2;
        Exception e2;
        BufferedReader bufferedReader;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap;
        JSONException e3;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap2;
        IOException e4;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap3;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap4;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        try {
            if (inputStream == null) {
                return null;
            }
            try {
                try {
                    hashMap4 = new HashMap<>();
                } catch (Throwable th) {
                    th = th;
                    reader2 = null;
                    reader = null;
                }
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    reader = new InputStreamReader(inputStream);
                    try {
                        bufferedReader = new BufferedReader(reader);
                        try {
                            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                                stringBuffer.append(readLine);
                            }
                            bufferedReader.close();
                            JSONObject jSONObject = new JSONObject(stringBuffer.toString());
                            if (!jSONObject.has("config")) {
                                n.close(reader);
                                n.close((Reader) bufferedReader);
                                return null;
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("config");
                            if (optJSONObject == null) {
                                n.close(reader);
                                n.close((Reader) bufferedReader);
                                return null;
                            }
                            Iterator<String> keys = optJSONObject.keys();
                            if (keys == null) {
                                n.close(reader);
                                n.close((Reader) bufferedReader);
                                return null;
                            }
                            while (keys.hasNext()) {
                                String next = keys.next();
                                JSONObject jSONObject2 = optJSONObject.getJSONObject(next);
                                ArrayList<String> arrayList = new ArrayList<>();
                                if (jSONObject2.has("data_urls") && (optJSONArray2 = jSONObject2.optJSONArray("data_urls")) != null) {
                                    for (int i = 0; i < optJSONArray2.length(); i++) {
                                        arrayList.add(optJSONArray2.optString(i));
                                    }
                                }
                                String optString = jSONObject2.has(BdStatsConstant.StatsKey.TYPE) ? jSONObject2.optString(BdStatsConstant.StatsKey.TYPE) : "";
                                String optString2 = jSONObject2.has("path") ? jSONObject2.optString("path") : "";
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                if (jSONObject2.has("source") && (optJSONArray = jSONObject2.optJSONArray("source")) != null) {
                                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                        arrayList2.add(optJSONArray.optString(i2));
                                    }
                                }
                                com.baidu.tieba.quickWebView.data.a aVar = new com.baidu.tieba.quickWebView.data.a();
                                aVar.mQi = arrayList;
                                aVar.ktS = optString;
                                aVar.path = optString2;
                                aVar.mQj = arrayList2;
                                hashMap4.put(next, aVar);
                            }
                            n.close(reader);
                            n.close((Reader) bufferedReader);
                            return hashMap4;
                        } catch (IOException e5) {
                            e4 = e5;
                            hashMap3 = hashMap4;
                            e4.printStackTrace();
                            n.close(reader);
                            n.close((Reader) bufferedReader);
                            return hashMap3;
                        } catch (JSONException e6) {
                            e3 = e6;
                            hashMap2 = hashMap4;
                            e3.printStackTrace();
                            n.close(reader);
                            n.close((Reader) bufferedReader);
                            return hashMap2;
                        } catch (Exception e7) {
                            e2 = e7;
                            hashMap = hashMap4;
                            e2.printStackTrace();
                            n.close(reader);
                            n.close((Reader) bufferedReader);
                            return hashMap;
                        }
                    } catch (IOException e8) {
                        e4 = e8;
                        bufferedReader = null;
                        hashMap3 = hashMap4;
                    } catch (JSONException e9) {
                        e3 = e9;
                        bufferedReader = null;
                        hashMap2 = hashMap4;
                    } catch (Exception e10) {
                        e2 = e10;
                        bufferedReader = null;
                        hashMap = hashMap4;
                    } catch (Throwable th2) {
                        th = th2;
                        reader2 = null;
                        n.close(reader);
                        n.close(reader2);
                        throw th;
                    }
                } catch (IOException e11) {
                    e4 = e11;
                    bufferedReader = null;
                    reader = null;
                    hashMap3 = hashMap4;
                } catch (JSONException e12) {
                    e3 = e12;
                    bufferedReader = null;
                    reader = null;
                    hashMap2 = hashMap4;
                } catch (Exception e13) {
                    e2 = e13;
                    bufferedReader = null;
                    reader = null;
                    hashMap = hashMap4;
                }
            } catch (IOException e14) {
                e4 = e14;
                bufferedReader = null;
                reader = null;
                hashMap3 = null;
            } catch (JSONException e15) {
                e3 = e15;
                bufferedReader = null;
                reader = null;
                hashMap2 = null;
            } catch (Exception e16) {
                e2 = e16;
                bufferedReader = null;
                reader = null;
                hashMap = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Ra(String str) {
        if (!TextUtils.isEmpty(str)) {
            o.deleteFileOrDir(new File(DOWNLOAD_DIR + "bdtbWCacheTemp/" + str));
        }
    }

    public String getCacheDir() {
        return this.dKH;
    }

    public void init() {
        this.mPS = System.currentTimeMillis();
        MessageManager.getInstance().registerListener(this.mfk);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.dKH = new File(DOWNLOAD_DIR + "bdtbNWCache").getAbsolutePath();
        Rc(com.baidu.tbadk.core.sharedPref.b.brQ().getString("pref_key_quick_webview_versions", ""));
    }

    public void Rb(String str) {
        if (!TextUtils.isEmpty(str)) {
            Rd(str);
            com.baidu.tbadk.core.sharedPref.b.brQ().putString("pref_key_quick_webview_versions", dCJ());
            File file = new File(DOWNLOAD_DIR + "bdtbNWCache/" + str);
            if (file != null && file.exists() && file.isDirectory()) {
                o.deleteFileOrDir(file);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0077 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    public static f gd(String str, String str2) {
        Throwable th;
        ?? r3;
        ?? r32;
        File file = new File(DOWNLOAD_DIR + "bdtbNWCache");
        if (file == null || !file.exists() || TextUtils.isEmpty(str2)) {
            return null;
        }
        f fVar = new f();
        File file2 = new File(file.getAbsolutePath() + "/" + str + "/" + str2 + "/");
        fVar.mQc = file.getAbsolutePath();
        fVar.mQe = str2;
        File file3 = new File(file2, "router.json");
        boolean exists = file3.exists();
        try {
            if (exists) {
                try {
                    ?? fileInputStream = new FileInputStream(file3);
                    try {
                        fVar.mQd = o(fileInputStream);
                        n.close((InputStream) fileInputStream);
                        exists = fileInputStream;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        r32 = fileInputStream;
                        e.printStackTrace();
                        n.close((InputStream) r32);
                        exists = r32;
                        return fVar;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    r32 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    r3 = 0;
                    n.close((InputStream) r3);
                    throw th;
                }
                return fVar;
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            r3 = exists;
        }
    }

    public void Rc(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String optString = jSONObject.optString(next);
                        if (!TextUtils.isEmpty(optString)) {
                            if (this.mPU == null) {
                                this.mPU = new ConcurrentHashMap();
                            }
                            this.mPU.put(next, optString);
                        }
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public String dCJ() {
        if (this.mPU == null || this.mPU.isEmpty()) {
            return null;
        }
        return new JSONObject(this.mPU).toString();
    }

    public void dCK() {
        String dCJ = dCJ();
        if (!TextUtils.isEmpty(dCJ)) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putString("pref_key_quick_webview_versions", dCJ);
        }
    }

    public void ge(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mPU == null) {
                this.mPU = new ConcurrentHashMap();
            }
            this.mPU.put(str, str2);
        }
    }

    public void Rd(String str) {
        if (!TextUtils.isEmpty(str) && this.mPU != null) {
            this.mPU.remove(str);
        }
    }

    public Set<String> dCL() {
        if (this.mPU == null) {
            this.mPU = new ConcurrentHashMap();
        }
        return this.mPU.keySet();
    }

    public String Re(String str) {
        if (this.mPU == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mPU.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x010d, code lost:
        if (r0.mIsSuccess != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c Rf(String str) {
        c cVar = new c();
        if (TextUtils.isEmpty(str)) {
            cVar.errorMsg = "module not exit";
        } else {
            File file = new File(DOWNLOAD_DIR + "bdtbNWCache", str);
            String Re = dCI().Re(str);
            if (TbSingleton.getInstance().isUploadOffPack()) {
                cVar.mIsSuccess = false;
                if (file == null || !file.exists()) {
                    cVar.errorMsg = "bundle not exist";
                } else if (TextUtils.isEmpty(Re)) {
                    cVar.errorMsg = "the local has no valid version name";
                } else {
                    String str2 = file.getAbsolutePath() + "/" + Re + "/";
                    if (!new File(str2).exists()) {
                        cVar.errorMsg = "bundle not exist";
                    } else {
                        String str3 = file.getAbsolutePath() + "/" + Re + ".zip";
                        File file2 = new File(str3);
                        if (file2.exists()) {
                            o.deleteFileOrDir(file2);
                        }
                        if (r.dL(str2, str3)) {
                            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK);
                            aaVar.addPostData("offline_pack_version", Re);
                            aaVar.addPostData("mod_name", str);
                            aaVar.bsr().bta().mNeedBackgroundLogin = false;
                            aaVar.bsr().bta().mIsUseCurrentBDUSS = false;
                            a(aaVar.dP("offline_pack_file_stream", str3), cVar);
                        } else {
                            cVar.errorMsg = "zip bundle error";
                        }
                    }
                }
            } else {
                cVar.mIsSuccess = true;
            }
            if (TbSingleton.getInstance().isClearOffPack()) {
                Rb(str);
                if (!TextUtils.isEmpty(Re)) {
                    TiebaStatic.log(new ar("c14055").dR("obj_name", str).dR("obj_id", Re));
                }
                if (file.exists() && !StringUtils.isNull(Re) && new File(file.getAbsolutePath(), Re).exists()) {
                    cVar.errorMsg = "delete fail";
                    cVar.mIsSuccess = false;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f {
        String mQc;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> mQd;
        String mQe;

        private f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e {
        Map<String, f> mQa;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> mQb;

        private e() {
        }
    }

    private c a(String str, c cVar) {
        if (StringUtils.isNull(str)) {
            cVar.errorMsg = "serve return is null";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                cVar.mIsSuccess = jSONObject.optInt("error_code") == 0;
                cVar.errorMsg = jSONObject.optString("error_msg");
            } catch (JSONException e2) {
                cVar.errorMsg = "parse json exception";
                BdLog.e(e2);
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.quickWebView.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0852b extends BdAsyncTask<Void, Void, f> {
        private aa cml;
        private final String mMd5;
        private final String mModuleName;
        private final com.baidu.tieba.quickWebView.message.a mPX;
        private final boolean mPY;
        private final String mUrl;
        private final String mVersion;

        public C0852b(String str, com.baidu.tieba.quickWebView.message.a aVar, boolean z) {
            this.mModuleName = str;
            this.mPX = aVar;
            this.mVersion = this.mPX.getVersion();
            this.mUrl = this.mPX.dCQ();
            this.mMd5 = this.mPX.getMd5();
            this.mPY = z;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x02b8 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0180  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0249  */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v12, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public f doInBackground(Void... voidArr) {
            f gd;
            FileInputStream fileInputStream;
            String str;
            String md5;
            b.Ra(this.mModuleName);
            b.dCI().Rb(this.mModuleName);
            if (this.mPY) {
                if (TextUtils.isEmpty(b.dCI().Re(this.mModuleName))) {
                    return null;
                }
                TiebaStatic.log(new ar("c14055").dR("obj_name", this.mModuleName).dR("obj_id", this.mVersion));
                return null;
            }
            this.cml = new aa();
            this.cml.setUrl(this.mUrl);
            new File(b.DOWNLOAD_DIR + "bdtbWCacheTemp/" + this.mModuleName + "/").mkdirs();
            String str2 = b.DOWNLOAD_DIR + "bdtbWCacheTemp/" + this.mModuleName + "/bdtbNWCache.zip";
            if (this.cml.downloadFile(str2, null, 0, 3, 0, true)) {
                ?? r2 = "obj_type";
                TiebaStatic.log(new ar("c13435").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_type", "1"));
                try {
                    try {
                        fileInputStream = new FileInputStream(str2);
                        try {
                            md5 = s.toMd5(fileInputStream);
                        } catch (FileNotFoundException e) {
                            e = e;
                            e.printStackTrace();
                            n.close((InputStream) fileInputStream);
                            str = b.DOWNLOAD_DIR + "bdtbWCacheTemp/" + this.mModuleName + "/" + this.mVersion + "/";
                            new File(str).mkdirs();
                            if (!r.unZipFiles(str2, str)) {
                            }
                            b.Ra(this.mModuleName);
                            gd = b.gd(this.mModuleName, this.mVersion);
                            if (gd == null) {
                            }
                            b.mPT = 5;
                            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "bundle incomplete", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                            b.dCI().Rb(this.mModuleName);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        n.close((InputStream) r2);
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    r2 = 0;
                    n.close((InputStream) r2);
                    throw th;
                }
                if (!StringUtils.isNull(md5) && md5.toLowerCase().equals(this.mMd5.toLowerCase())) {
                    n.close((InputStream) fileInputStream);
                    str = b.DOWNLOAD_DIR + "bdtbWCacheTemp/" + this.mModuleName + "/" + this.mVersion + "/";
                    new File(str).mkdirs();
                    if (!r.unZipFiles(str2, str)) {
                        String str3 = b.DOWNLOAD_DIR + "bdtbNWCache/" + this.mModuleName + "/" + this.mVersion + "/";
                        new File(str3).mkdirs();
                        if (!o.CopyDir(str, str3, true)) {
                            b.mPT = 4;
                            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "write error", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                        }
                    } else {
                        b.mPT = 3;
                        com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "unzip error", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                    }
                } else {
                    b.mPT = 2;
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "md5 error", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                    b.Ra(this.mModuleName);
                    n.close((InputStream) fileInputStream);
                    return null;
                }
            } else {
                TiebaStatic.log(new ar("c13435").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_type", "2"));
                b.mPT = 1;
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "download error", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
            }
            b.Ra(this.mModuleName);
            gd = b.gd(this.mModuleName, this.mVersion);
            if (gd == null && !TextUtils.isEmpty(gd.mQc) && gd.mQd != null && gd.mQd.size() != 0) {
                b.gc(gd.mQe, this.mModuleName);
                return gd;
            }
            b.mPT = 5;
            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "bundle incomplete", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
            b.dCI().Rb(this.mModuleName);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(f fVar) {
            super.onPostExecute(fVar);
            if (fVar != null) {
                b.dCI().ge(this.mModuleName, fVar.mQe);
                b.dCI().dCK();
                com.baidu.tieba.quickWebView.c.dCM().e(this.mModuleName, fVar.mQd);
                com.baidu.tieba.quickWebView.c.dCM().M(true, this.mModuleName);
                TiebaStatic.log(new ar("c14055").dR("obj_name", this.mModuleName).dR("obj_id", fVar.mQe));
                return;
            }
            b.dCI().Rd(this.mModuleName);
            b.dCI().dCK();
            com.baidu.tieba.quickWebView.c.dCM().Rh(this.mModuleName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends BdAsyncTask<Void, Void, e> {
        private boolean mPZ = true;

        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public e doInBackground(Void... voidArr) {
            e eVar = new e();
            for (String str : b.dCI().dCL()) {
                f gd = b.gd(str, b.dCI().Re(str));
                if (gd == null || TextUtils.isEmpty(gd.mQc) || gd.mQd == null || gd.mQd.size() == 0) {
                    b.mPT = 5;
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "bundle incomplete", BdStatsConstant.StatsKey.TYPE, str);
                    b.this.Rb(str);
                } else {
                    if (eVar.mQa == null) {
                        eVar.mQa = new HashMap();
                    }
                    eVar.mQa.put(str, gd);
                    if (eVar.mQb == null) {
                        eVar.mQb = new HashMap<>();
                    }
                    eVar.mQb.putAll(gd.mQd);
                    b.gc(gd.mQe, str);
                }
            }
            return eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(e eVar) {
            if (eVar == null) {
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readFile", -1, "read error", new Object[0]);
            } else {
                com.baidu.tieba.quickWebView.c.dCM().H(eVar.mQb);
            }
            MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg("0.0.0.0"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, String> {
        private aa mPW;

        private a() {
            this.mPW = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Void... voidArr) {
            c Rf;
            String modName = TbSingleton.getInstance().getModName();
            if (!TextUtils.isEmpty(modName) && (Rf = b.this.Rf(modName)) != null) {
                this.mPW = new aa(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK_STATUS);
                this.mPW.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
                this.mPW.addPostData("mod_name", modName);
                this.mPW.addPostData("status", Rf.mIsSuccess ? "1" : "2");
                this.mPW.addPostData("fail_reason", Rf.mIsSuccess ? "" : Rf.errorMsg);
                this.mPW.postNetData();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            d dVar = new d();
            dVar.setPriority(4);
            dVar.execute(new Void[0]);
        }
    }
}
