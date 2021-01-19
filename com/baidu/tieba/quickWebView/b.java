package com.baidu.tieba.quickWebView;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.switchs.ClearOfflineWebCacheSwitch;
import com.baidu.tbadk.switchs.UploadOfflineWebCacheSwitch;
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
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static b mGL;
    private String dID;
    private long mGN;
    private static final String TAG = b.class.getSimpleName() + " TestActivity";
    private static final String DOWNLOAD_DIR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    public static int mGP = 0;
    private boolean mGM = false;
    private String mGO = null;
    private CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.quickWebView.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && !b.this.mGM) {
                b.this.mGM = true;
                if (UploadOfflineWebCacheSwitch.isOn() || ClearOfflineWebCacheSwitch.isOn()) {
                    a aVar = new a();
                    aVar.setPriority(4);
                    aVar.execute(new Void[0]);
                    return;
                }
                c cVar = new c();
                cVar.setPriority(4);
                cVar.execute(new Void[0]);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lWf = new com.baidu.adp.framework.listener.a(1003365, CmdConfigSocket.WEBVIEW_CACHE_INFO) { // from class: com.baidu.tieba.quickWebView.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage instanceof WebViewCacheResHttpMsg) {
                    WebViewCacheResHttpMsg webViewCacheResHttpMsg = (WebViewCacheResHttpMsg) responsedMessage;
                    WebViewCacheReqMsg webViewCacheReqMsg = (WebViewCacheReqMsg) webViewCacheResHttpMsg.getOrginalMessage().getExtra();
                    List<String> header = webViewCacheResHttpMsg.getHeader(SM.SET_COOKIE);
                    if (header != null && header.size() > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < header.size()) {
                                if (TextUtils.isEmpty(header.get(i2)) || !header.get(i2).contains("BAIDUID=")) {
                                    i = i2 + 1;
                                } else {
                                    com.baidu.tbadk.browser.a.zg(header.get(i2));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    b.E(webViewCacheResHttpMsg.getCacheDownloadUrl(), webViewCacheReqMsg.getVersionNum(), webViewCacheResHttpMsg.getCacheVersion(), webViewCacheResHttpMsg.getCacheMd5());
                } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                    WebViewCacheResSocketMsg webViewCacheResSocketMsg = (WebViewCacheResSocketMsg) responsedMessage;
                    b.E(webViewCacheResSocketMsg.getCacheDownloadUrl(), ((WebViewCacheReqMsg) webViewCacheResSocketMsg.getOrginalMessage().getExtra()).getVersionNum(), webViewCacheResSocketMsg.getCacheVersion(), webViewCacheResSocketMsg.getCacheMd5());
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.quickWebView.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0849b {
        public String errorMsg;
        public boolean mIsSuccess;
    }

    public static b dAy() {
        if (mGL == null) {
            synchronized (b.class) {
                if (mGL == null) {
                    mGL = new b();
                }
            }
        }
        return mGL;
    }

    private b() {
    }

    public String getCacheDir() {
        return this.dID;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void E(String str, String str2, String str3, String str4) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str3) && !StringUtils.isNull(str4)) {
            if (StringUtils.isNull(str2)) {
                str2 = "0.0.0.0";
            }
            if (str3.equals(str2)) {
                com.baidu.tieba.quickWebView.c.dAG().xg(true);
                return;
            }
            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, 0, "downloadCache", 0, "", "url", str, "intallVersion", str3, "lastVersion", str2, "type", "start");
            new e(str, str3, str4).execute(new Void[0]);
        }
    }

    private static com.baidu.tieba.quickWebView.data.b q(InputStream inputStream) {
        JSONObject jSONObject;
        if (inputStream == null) {
            return null;
        }
        com.baidu.tieba.quickWebView.data.b bVar = new com.baidu.tieba.quickWebView.data.b();
        try {
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                stringBuffer.append(readLine);
            }
            bufferedReader.close();
            jSONObject = new JSONObject(stringBuffer.toString());
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        if (jSONObject.has("all") && jSONObject.has("entry")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("all");
            JSONObject optJSONObject = jSONObject.optJSONObject("entry");
            if (optJSONArray == null || optJSONObject == null) {
                return null;
            }
            bVar.mHd = new ArrayList<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                bVar.mHd.add(optJSONArray.optString(i));
            }
            bVar.mHe = new HashMap<>();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    arrayList.add(optJSONArray2.optString(i2));
                }
                bVar.mHe.put(next, arrayList);
            }
            return bVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Qk(String str) {
        String[] list;
        if (!TextUtils.isEmpty(str)) {
            String str2 = DOWNLOAD_DIR + "bdtbWCache";
            File file = new File(str2);
            if (file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0) {
                for (String str3 : list) {
                    if (!StringUtils.isNull(str3) && !str3.equals(str)) {
                        n.deleteFileOrDir(new File(str2 + "/" + str3));
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [343=8, 344=7] */
    private static HashMap<String, com.baidu.tieba.quickWebView.data.a> r(InputStream inputStream) {
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
                            if (!jSONObject.has("rules")) {
                                com.baidu.adp.lib.util.n.close(reader);
                                com.baidu.adp.lib.util.n.close((Reader) bufferedReader);
                                return null;
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("rules");
                            if (optJSONObject == null) {
                                com.baidu.adp.lib.util.n.close(reader);
                                com.baidu.adp.lib.util.n.close((Reader) bufferedReader);
                                return null;
                            }
                            Iterator<String> keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                JSONObject jSONObject2 = optJSONObject.getJSONObject(next);
                                ArrayList<String> arrayList = new ArrayList<>();
                                if (jSONObject2.has("data_urls") && (optJSONArray = jSONObject2.optJSONArray("data_urls")) != null) {
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        arrayList.add(optJSONArray.optString(i));
                                    }
                                }
                                int optInt = jSONObject2.has("offline") ? jSONObject2.optInt("offline") : 0;
                                com.baidu.tieba.quickWebView.data.a aVar = new com.baidu.tieba.quickWebView.data.a();
                                aVar.mHb = arrayList;
                                aVar.mHc = optInt == 1;
                                hashMap4.put(next, aVar);
                            }
                            com.baidu.adp.lib.util.n.close(reader);
                            com.baidu.adp.lib.util.n.close((Reader) bufferedReader);
                            return hashMap4;
                        } catch (IOException e5) {
                            e4 = e5;
                            hashMap3 = hashMap4;
                            e4.printStackTrace();
                            com.baidu.adp.lib.util.n.close(reader);
                            com.baidu.adp.lib.util.n.close((Reader) bufferedReader);
                            return hashMap3;
                        } catch (JSONException e6) {
                            e3 = e6;
                            hashMap2 = hashMap4;
                            e3.printStackTrace();
                            com.baidu.adp.lib.util.n.close(reader);
                            com.baidu.adp.lib.util.n.close((Reader) bufferedReader);
                            return hashMap2;
                        } catch (Exception e7) {
                            e2 = e7;
                            hashMap = hashMap4;
                            e2.printStackTrace();
                            com.baidu.adp.lib.util.n.close(reader);
                            com.baidu.adp.lib.util.n.close((Reader) bufferedReader);
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
                        com.baidu.adp.lib.util.n.close(reader);
                        com.baidu.adp.lib.util.n.close(reader2);
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
    public static void dAz() {
        n.deleteFileOrDir(new File(DOWNLOAD_DIR + "bdtbWCacheTemp"));
    }

    public String dAA() {
        return this.mGO;
    }

    public void init() {
        this.mGN = System.currentTimeMillis();
        MessageManager.getInstance().registerListener(this.lWf);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [450=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public d dAB() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        File file = new File(DOWNLOAD_DIR + "bdtbWCache");
        if (file == null || !file.exists()) {
            return null;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.brx().getString("pref_key_quick_webview_version_name", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        d dVar = new d();
        File file2 = new File(file, string);
        dVar.mGT = file2.getAbsolutePath();
        dVar.mGW = string;
        File file3 = new File(file2, "router.json");
        if (file3.exists()) {
            File file4 = new File(file2, "staticSources.json");
            if (file4.exists()) {
                try {
                    fileInputStream2 = new FileInputStream(file3);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream = null;
                    fileInputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = null;
                    fileInputStream2 = null;
                }
                try {
                    dVar.mGU = r(fileInputStream2);
                    fileInputStream = new FileInputStream(file4);
                    try {
                        try {
                            dVar.mGV = q(fileInputStream);
                            com.baidu.adp.lib.util.n.close((InputStream) fileInputStream2);
                            com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.close((InputStream) fileInputStream2);
                            com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                            return dVar;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.adp.lib.util.n.close((InputStream) fileInputStream2);
                        com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    fileInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    com.baidu.adp.lib.util.n.close((InputStream) fileInputStream2);
                    com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                    throw th;
                }
                return dVar;
            }
            return null;
        }
        return null;
    }

    public void dAC() {
        String[] list;
        com.baidu.tbadk.core.sharedPref.b.brx().putString("pref_key_quick_webview_version_name", "");
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0) {
            for (String str2 : list) {
                if (!StringUtils.isNull(str2)) {
                    n.deleteFileOrDir(new File(str + "/" + str2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(d dVar) {
        if (dVar == null || dVar.mGT == null || dVar.mGV == null) {
            return false;
        }
        Iterator<String> it = dVar.mGV.mHd.iterator();
        while (it.hasNext()) {
            if (!new File(dVar.mGT, it.next()).exists()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ff, code lost:
        if (r0.mIsSuccess != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0849b dAD() {
        C0849b c0849b = new C0849b();
        File file = new File(DOWNLOAD_DIR + "bdtbWCache");
        String string = com.baidu.tbadk.core.sharedPref.b.brx().getString("pref_key_quick_webview_version_name", "");
        if (UploadOfflineWebCacheSwitch.isOn()) {
            c0849b.mIsSuccess = false;
            if (file == null || !file.exists()) {
                c0849b.errorMsg = "bundle not exist";
            } else if (TextUtils.isEmpty(string)) {
                c0849b.errorMsg = "the local has no valid version name";
            } else {
                String str = file.getAbsolutePath() + "/" + string;
                if (!new File(file.getAbsolutePath(), string).exists()) {
                    c0849b.errorMsg = "bundle not exist";
                } else {
                    String str2 = str + ".zip";
                    File file2 = new File(str2);
                    if (file2.exists()) {
                        n.deleteFileOrDir(file2);
                    }
                    if (r.dR(str, str2)) {
                        z zVar = new z(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK);
                        zVar.addPostData("offline_pack_version", string);
                        zVar.brX().bsG().mNeedBackgroundLogin = false;
                        zVar.brX().bsG().mIsUseCurrentBDUSS = false;
                        a(zVar.dU("offline_pack_file_stream", str + ".zip"), c0849b);
                    } else {
                        c0849b.errorMsg = "zip bundle error";
                    }
                }
            }
            return c0849b;
        }
        c0849b.mIsSuccess = true;
        if (ClearOfflineWebCacheSwitch.isOn()) {
            dAC();
            if (file.exists() && !StringUtils.isNull(string) && new File(file.getAbsolutePath(), string).exists()) {
                c0849b.errorMsg = "delete fail";
                c0849b.mIsSuccess = false;
            }
        }
        return c0849b;
    }

    private C0849b a(String str, C0849b c0849b) {
        if (StringUtils.isNull(str)) {
            c0849b.errorMsg = "serve return is null";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                c0849b.mIsSuccess = jSONObject.optInt("error_code") == 0;
                c0849b.errorMsg = jSONObject.optString("error_msg");
            } catch (JSONException e2) {
                c0849b.errorMsg = "parse json exception";
                BdLog.e(e2);
            }
        }
        return c0849b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        String mGT;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> mGU;
        com.baidu.tieba.quickWebView.data.b mGV;
        String mGW;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends BdAsyncTask<Void, Void, Boolean> {
        private z chV;
        private final String mMd5;
        private final String mUrl;
        private final String mVersion;

        public e(String str, String str2, String str3) {
            this.mUrl = str;
            this.mVersion = str2;
            this.mMd5 = str3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [637=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00fd  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0157  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Boolean doInBackground(Void... voidArr) {
            boolean z;
            FileInputStream fileInputStream;
            FileNotFoundException fileNotFoundException;
            String str;
            String md5;
            b.dAz();
            this.chV = new z();
            this.chV.setUrl(this.mUrl);
            new File(b.DOWNLOAD_DIR + "bdtbWCacheTemp").mkdirs();
            String str2 = b.DOWNLOAD_DIR + "bdtbWCacheTemp/bdtbWCache.zip";
            if (this.chV.downloadFile(str2, null, 0, 3, 0, true)) {
                TiebaStatic.log(new aq("c13435").dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("obj_type", "1"));
                FileInputStream fileInputStream2 = null;
                try {
                    fileInputStream = new FileInputStream(str2);
                } catch (FileNotFoundException e) {
                    fileNotFoundException = e;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = null;
                }
                try {
                    md5 = s.toMd5(fileInputStream);
                } catch (FileNotFoundException e2) {
                    fileNotFoundException = e2;
                    fileInputStream2 = fileInputStream;
                    z = false;
                    try {
                        fileNotFoundException.printStackTrace();
                        com.baidu.adp.lib.util.n.close((InputStream) fileInputStream2);
                        str = b.DOWNLOAD_DIR + "bdtbWCacheTemp/" + this.mVersion;
                        if (r.unZipFiles(str2, str)) {
                        }
                        b.dAz();
                        return Boolean.valueOf(z);
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                    throw th;
                }
                if (StringUtils.isNull(md5) || !md5.toLowerCase().equals(this.mMd5.toLowerCase())) {
                    b.mGP = 2;
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "md5 error", new Object[0]);
                    b.dAz();
                    com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                    return false;
                }
                com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                z = true;
                str = b.DOWNLOAD_DIR + "bdtbWCacheTemp/" + this.mVersion;
                if (r.unZipFiles(str2, str)) {
                    z = false;
                    b.mGP = 3;
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "unzip error", new Object[0]);
                } else if (!n.CopyDir(str, b.DOWNLOAD_DIR + "bdtbWCache/" + this.mVersion, true)) {
                    b.mGP = 4;
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "write error", new Object[0]);
                }
            } else {
                z = false;
                TiebaStatic.log(new aq("c13435").dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("obj_type", "2"));
                b.mGP = 1;
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "download error", new Object[0]);
            }
            b.dAz();
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((e) bool);
            if (bool.booleanValue()) {
                com.baidu.tbadk.core.sharedPref.b.brx().putString("pref_key_quick_webview_version_name", this.mVersion);
                b bVar = b.mGL;
                bVar.getClass();
                c cVar = new c(false);
                cVar.setPriority(4);
                cVar.execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, d> {
        private boolean mGS;

        public c() {
            this.mGS = true;
        }

        public c(boolean z) {
            this.mGS = true;
            this.mGS = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public d doInBackground(Void... voidArr) {
            d dAB = b.this.dAB();
            if (dAB != null && !TextUtils.isEmpty(dAB.mGT) && dAB.mGU != null && dAB.mGU.size() != 0 && dAB.mGV != null) {
                if (b.this.a(dAB)) {
                    b.Qk(dAB.mGW);
                    return dAB;
                }
                b.mGP = 5;
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "bundle incomplete", new Object[0]);
                b.this.dAC();
                return null;
            }
            b.mGP = 5;
            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "bundle incomplete", new Object[0]);
            b.this.dAC();
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(d dVar) {
            String str;
            if (dVar != null && !StringUtils.isNull(dVar.mGW)) {
                b.this.dID = dVar.mGT;
                com.baidu.tieba.quickWebView.c.dAG().F(dVar.mGU);
                com.baidu.tieba.quickWebView.c.dAG().a(dVar.mGV);
                str = dVar.mGW;
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, 0, "readFile", 0, "", "version", str);
                if (!this.mGS) {
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "type", "end");
                    com.baidu.tieba.quickWebView.c.dAG().xg(true);
                }
            } else {
                str = "0.0.0.0";
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readFile", -1, "read error", new Object[0]);
            }
            b.this.mGO = str;
            if (this.mGS) {
                MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, String> {
        private z mGR;

        private a() {
            this.mGR = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Void... voidArr) {
            C0849b dAD = b.this.dAD();
            if (dAD != null) {
                this.mGR = new z(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK_STATUS);
                this.mGR.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
                this.mGR.addPostData("status", dAD.mIsSuccess ? "1" : "2");
                this.mGR.addPostData("fail_reason", dAD.mIsSuccess ? "" : dAD.errorMsg);
                this.mGR.postNetData();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            c cVar = new c();
            cVar.setPriority(4);
            cVar.execute(new Void[0]);
        }
    }
}
