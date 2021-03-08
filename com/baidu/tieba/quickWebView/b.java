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
    private static b mSi;
    private String dMi;
    private long mSk;
    private Map<String, String> mSm;
    private static final String TAG = b.class.getSimpleName() + " TestActivity";
    private static final String DOWNLOAD_DIR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    public static int mSl = 0;
    private boolean mSj = false;
    private CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.quickWebView.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && !b.this.mSj) {
                b.this.mSj = true;
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
    private com.baidu.adp.framework.listener.a mhB = new com.baidu.adp.framework.listener.a(1003365, CmdConfigSocket.WEBVIEW_CACHE_INFO) { // from class: com.baidu.tieba.quickWebView.b.2
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
                                com.baidu.tbadk.browser.a.zF(header.get(i2));
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
                    com.baidu.tieba.quickWebView.c.dDb().xy(true);
                } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                    Map<String, com.baidu.tieba.quickWebView.message.a> moduleInfos2 = ((WebViewCacheResSocketMsg) responsedMessage).getModuleInfos();
                    if (moduleInfos2 != null && moduleInfos2.size() > 0) {
                        for (String str2 : moduleInfos2.keySet()) {
                            b.a(str2, moduleInfos2.get(str2));
                        }
                        return;
                    }
                    com.baidu.tieba.quickWebView.c.dDb().xy(true);
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public static class c {
        public String errorMsg;
        public boolean mIsSuccess;
    }

    public static b dCX() {
        if (mSi == null) {
            synchronized (b.class) {
                if (mSi == null) {
                    mSi = new b();
                }
            }
        }
        return mSi;
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, com.baidu.tieba.quickWebView.message.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getVersion()) || StringUtils.isNull(aVar.getMd5()) || StringUtils.isNull(aVar.dDf())) {
            com.baidu.tieba.quickWebView.c.dDb().M(true, str);
            return;
        }
        String Rl = dCX().Rl(str);
        String version = aVar.getVersion();
        String dDf = aVar.dDf();
        boolean dDe = aVar.dDe();
        String str2 = StringUtils.isNull(Rl) ? "0.0.0.0" : Rl;
        if (dDe && version.equals(str2)) {
            com.baidu.tieba.quickWebView.c.dDb().M(true, str);
            return;
        }
        com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, 0, "downloadCache", 0, "", "url", dDf, "intallVersion", version, "lastVersion", str2, "type", "start", BdStatsConstant.StatsKey.TYPE, str);
        new C0859b(str, aVar, dDe ? false : true).execute(new Void[0]);
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
                                aVar.mSB = arrayList;
                                aVar.kwi = optString;
                                aVar.path = optString2;
                                aVar.mSC = arrayList2;
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
    public static void Rh(String str) {
        if (!TextUtils.isEmpty(str)) {
            o.deleteFileOrDir(new File(DOWNLOAD_DIR + "bdtbWCacheTemp/" + str));
        }
    }

    public String getCacheDir() {
        return this.dMi;
    }

    public void init() {
        this.mSk = System.currentTimeMillis();
        MessageManager.getInstance().registerListener(this.mhB);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.dMi = new File(DOWNLOAD_DIR + "bdtbNWCache").getAbsolutePath();
        Rj(com.baidu.tbadk.core.sharedPref.b.brR().getString("pref_key_quick_webview_versions", ""));
    }

    public void Ri(String str) {
        if (!TextUtils.isEmpty(str)) {
            Rk(str);
            com.baidu.tbadk.core.sharedPref.b.brR().putString("pref_key_quick_webview_versions", dCY());
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
        fVar.mSv = file.getAbsolutePath();
        fVar.mSx = str2;
        File file3 = new File(file2, "router.json");
        boolean exists = file3.exists();
        try {
            if (exists) {
                try {
                    ?? fileInputStream = new FileInputStream(file3);
                    try {
                        fVar.mSw = o(fileInputStream);
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

    public void Rj(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String optString = jSONObject.optString(next);
                        if (!TextUtils.isEmpty(optString)) {
                            if (this.mSm == null) {
                                this.mSm = new ConcurrentHashMap();
                            }
                            this.mSm.put(next, optString);
                        }
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public String dCY() {
        if (this.mSm == null || this.mSm.isEmpty()) {
            return null;
        }
        return new JSONObject(this.mSm).toString();
    }

    public void dCZ() {
        String dCY = dCY();
        if (!TextUtils.isEmpty(dCY)) {
            com.baidu.tbadk.core.sharedPref.b.brR().putString("pref_key_quick_webview_versions", dCY);
        }
    }

    public void ge(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mSm == null) {
                this.mSm = new ConcurrentHashMap();
            }
            this.mSm.put(str, str2);
        }
    }

    public void Rk(String str) {
        if (!TextUtils.isEmpty(str) && this.mSm != null) {
            this.mSm.remove(str);
        }
    }

    public Set<String> dDa() {
        if (this.mSm == null) {
            this.mSm = new ConcurrentHashMap();
        }
        return this.mSm.keySet();
    }

    public String Rl(String str) {
        if (this.mSm == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mSm.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x010d, code lost:
        if (r0.mIsSuccess != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c Rm(String str) {
        c cVar = new c();
        if (TextUtils.isEmpty(str)) {
            cVar.errorMsg = "module not exit";
        } else {
            File file = new File(DOWNLOAD_DIR + "bdtbNWCache", str);
            String Rl = dCX().Rl(str);
            if (TbSingleton.getInstance().isUploadOffPack()) {
                cVar.mIsSuccess = false;
                if (file == null || !file.exists()) {
                    cVar.errorMsg = "bundle not exist";
                } else if (TextUtils.isEmpty(Rl)) {
                    cVar.errorMsg = "the local has no valid version name";
                } else {
                    String str2 = file.getAbsolutePath() + "/" + Rl + "/";
                    if (!new File(str2).exists()) {
                        cVar.errorMsg = "bundle not exist";
                    } else {
                        String str3 = file.getAbsolutePath() + "/" + Rl + ".zip";
                        File file2 = new File(str3);
                        if (file2.exists()) {
                            o.deleteFileOrDir(file2);
                        }
                        if (r.dL(str2, str3)) {
                            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK);
                            aaVar.addPostData("offline_pack_version", Rl);
                            aaVar.addPostData("mod_name", str);
                            aaVar.bsu().btd().mNeedBackgroundLogin = false;
                            aaVar.bsu().btd().mIsUseCurrentBDUSS = false;
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
                Ri(str);
                if (!TextUtils.isEmpty(Rl)) {
                    TiebaStatic.log(new ar("c14055").dR("obj_name", str).dR("obj_id", Rl));
                }
                if (file.exists() && !StringUtils.isNull(Rl) && new File(file.getAbsolutePath(), Rl).exists()) {
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
        String mSv;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> mSw;
        String mSx;

        private f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e {
        Map<String, f> mSt;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> mSu;

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
    public static class C0859b extends BdAsyncTask<Void, Void, f> {
        private aa cnM;
        private final String mMd5;
        private final String mModuleName;
        private final com.baidu.tieba.quickWebView.message.a mSq;
        private final boolean mSr;
        private final String mUrl;
        private final String mVersion;

        public C0859b(String str, com.baidu.tieba.quickWebView.message.a aVar, boolean z) {
            this.mModuleName = str;
            this.mSq = aVar;
            this.mVersion = this.mSq.getVersion();
            this.mUrl = this.mSq.dDf();
            this.mMd5 = this.mSq.getMd5();
            this.mSr = z;
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
            b.Rh(this.mModuleName);
            b.dCX().Ri(this.mModuleName);
            if (this.mSr) {
                if (TextUtils.isEmpty(b.dCX().Rl(this.mModuleName))) {
                    return null;
                }
                TiebaStatic.log(new ar("c14055").dR("obj_name", this.mModuleName).dR("obj_id", this.mVersion));
                return null;
            }
            this.cnM = new aa();
            this.cnM.setUrl(this.mUrl);
            new File(b.DOWNLOAD_DIR + "bdtbWCacheTemp/" + this.mModuleName + "/").mkdirs();
            String str2 = b.DOWNLOAD_DIR + "bdtbWCacheTemp/" + this.mModuleName + "/bdtbNWCache.zip";
            if (this.cnM.downloadFile(str2, null, 0, 3, 0, true)) {
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
                            b.Rh(this.mModuleName);
                            gd = b.gd(this.mModuleName, this.mVersion);
                            if (gd == null) {
                            }
                            b.mSl = 5;
                            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "bundle incomplete", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                            b.dCX().Ri(this.mModuleName);
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
                            b.mSl = 4;
                            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "write error", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                        }
                    } else {
                        b.mSl = 3;
                        com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "unzip error", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                    }
                } else {
                    b.mSl = 2;
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "md5 error", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                    b.Rh(this.mModuleName);
                    n.close((InputStream) fileInputStream);
                    return null;
                }
            } else {
                TiebaStatic.log(new ar("c13435").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_type", "2"));
                b.mSl = 1;
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "download error", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
            }
            b.Rh(this.mModuleName);
            gd = b.gd(this.mModuleName, this.mVersion);
            if (gd == null && !TextUtils.isEmpty(gd.mSv) && gd.mSw != null && gd.mSw.size() != 0) {
                b.gc(gd.mSx, this.mModuleName);
                return gd;
            }
            b.mSl = 5;
            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "bundle incomplete", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
            b.dCX().Ri(this.mModuleName);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(f fVar) {
            super.onPostExecute(fVar);
            if (fVar != null) {
                b.dCX().ge(this.mModuleName, fVar.mSx);
                b.dCX().dCZ();
                com.baidu.tieba.quickWebView.c.dDb().e(this.mModuleName, fVar.mSw);
                com.baidu.tieba.quickWebView.c.dDb().M(true, this.mModuleName);
                TiebaStatic.log(new ar("c14055").dR("obj_name", this.mModuleName).dR("obj_id", fVar.mSx));
                return;
            }
            b.dCX().Rk(this.mModuleName);
            b.dCX().dCZ();
            com.baidu.tieba.quickWebView.c.dDb().Ro(this.mModuleName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends BdAsyncTask<Void, Void, e> {
        private boolean mSs = true;

        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public e doInBackground(Void... voidArr) {
            e eVar = new e();
            for (String str : b.dCX().dDa()) {
                f gd = b.gd(str, b.dCX().Rl(str));
                if (gd == null || TextUtils.isEmpty(gd.mSv) || gd.mSw == null || gd.mSw.size() == 0) {
                    b.mSl = 5;
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "bundle incomplete", BdStatsConstant.StatsKey.TYPE, str);
                    b.this.Ri(str);
                } else {
                    if (eVar.mSt == null) {
                        eVar.mSt = new HashMap();
                    }
                    eVar.mSt.put(str, gd);
                    if (eVar.mSu == null) {
                        eVar.mSu = new HashMap<>();
                    }
                    eVar.mSu.putAll(gd.mSw);
                    b.gc(gd.mSx, str);
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
                com.baidu.tieba.quickWebView.c.dDb().H(eVar.mSu);
            }
            MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg("0.0.0.0"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, String> {
        private aa mSo;

        private a() {
            this.mSo = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Void... voidArr) {
            c Rm;
            String modName = TbSingleton.getInstance().getModName();
            if (!TextUtils.isEmpty(modName) && (Rm = b.this.Rm(modName)) != null) {
                this.mSo = new aa(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK_STATUS);
                this.mSo.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
                this.mSo.addPostData("mod_name", modName);
                this.mSo.addPostData("status", Rm.mIsSuccess ? "1" : "2");
                this.mSo.addPostData("fail_reason", Rm.mIsSuccess ? "" : Rm.errorMsg);
                this.mSo.postNetData();
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
