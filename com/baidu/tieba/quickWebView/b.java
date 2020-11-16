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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
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
    private static b mrU;
    private String dxM;
    private long mrX;
    private static final String TAG = b.class.getSimpleName() + " TestActivity";
    private static final String DOWNLOAD_DIR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    public static int mrY = 0;
    private boolean mrV = false;
    private String mrW = null;
    private CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.quickWebView.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && !b.this.mrV) {
                b.this.mrV = true;
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
    private com.baidu.adp.framework.listener.a lHB = new com.baidu.adp.framework.listener.a(1003365, CmdConfigSocket.WEBVIEW_CACHE_INFO) { // from class: com.baidu.tieba.quickWebView.b.2
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
                                    com.baidu.tbadk.browser.a.zM(header.get(i2));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    b.F(webViewCacheResHttpMsg.getCacheDownloadUrl(), webViewCacheReqMsg.getVersionNum(), webViewCacheResHttpMsg.getCacheVersion(), webViewCacheResHttpMsg.getCacheMd5());
                } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                    WebViewCacheResSocketMsg webViewCacheResSocketMsg = (WebViewCacheResSocketMsg) responsedMessage;
                    b.F(webViewCacheResSocketMsg.getCacheDownloadUrl(), ((WebViewCacheReqMsg) webViewCacheResSocketMsg.getOrginalMessage().getExtra()).getVersionNum(), webViewCacheResSocketMsg.getCacheVersion(), webViewCacheResSocketMsg.getCacheMd5());
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.quickWebView.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0834b {
        public String errorMsg;
        public boolean mIsSuccess;
    }

    public static b dzi() {
        if (mrU == null) {
            synchronized (b.class) {
                if (mrU == null) {
                    mrU = new b();
                }
            }
        }
        return mrU;
    }

    private b() {
    }

    public String dzj() {
        return this.mrW;
    }

    public String getCacheDir() {
        return this.dxM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(String str, String str2, String str3, String str4) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str3) && !StringUtils.isNull(str4)) {
            if (StringUtils.isNull(str2)) {
                str2 = "0.0.0.0";
            }
            if (str3.equals(str2)) {
                com.baidu.tieba.quickWebView.c.dzq().wF(true);
                return;
            }
            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, 0, "downloadCache", 0, "", "url", str, "intallVersion", str3, "lastVersion", str2, "type", "start");
            new e(str, str3, str4).execute(new Void[0]);
        }
    }

    public void init() {
        this.mrX = System.currentTimeMillis();
        MessageManager.getInstance().registerListener(this.lHB);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
    }

    private static com.baidu.tieba.quickWebView.data.b o(InputStream inputStream) {
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
            bVar.msn = new ArrayList<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                bVar.msn.add(optJSONArray.optString(i));
            }
            bVar.mso = new HashMap<>();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    arrayList.add(optJSONArray2.optString(i2));
                }
                bVar.mso.put(next, arrayList);
            }
            return bVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void QD(String str) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [396=8, 397=7] */
    private static HashMap<String, com.baidu.tieba.quickWebView.data.a> p(InputStream inputStream) {
        Reader reader;
        Reader reader2;
        BufferedReader bufferedReader;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap;
        JSONArray optJSONArray;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> hashMap2 = null;
        try {
            if (inputStream == null) {
                return null;
            }
            try {
                try {
                    hashMap = new HashMap<>();
                } catch (Throwable th) {
                    reader2 = null;
                    reader = null;
                    th = th;
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
                                aVar.msl = arrayList;
                                aVar.msm = optInt == 1;
                                hashMap.put(next, aVar);
                            }
                            com.baidu.adp.lib.util.n.close(reader);
                            com.baidu.adp.lib.util.n.close((Reader) bufferedReader);
                            return hashMap;
                        } catch (IOException e2) {
                            hashMap2 = hashMap;
                            e = e2;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.close(reader);
                            com.baidu.adp.lib.util.n.close((Reader) bufferedReader);
                            return hashMap2;
                        } catch (JSONException e3) {
                            hashMap2 = hashMap;
                            e = e3;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.close(reader);
                            com.baidu.adp.lib.util.n.close((Reader) bufferedReader);
                            return hashMap2;
                        } catch (Exception e4) {
                            hashMap2 = hashMap;
                            e = e4;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.close(reader);
                            com.baidu.adp.lib.util.n.close((Reader) bufferedReader);
                            return hashMap2;
                        }
                    } catch (IOException e5) {
                        bufferedReader = null;
                        hashMap2 = hashMap;
                        e = e5;
                    } catch (JSONException e6) {
                        bufferedReader = null;
                        hashMap2 = hashMap;
                        e = e6;
                    } catch (Exception e7) {
                        bufferedReader = null;
                        hashMap2 = hashMap;
                        e = e7;
                    } catch (Throwable th2) {
                        reader2 = null;
                        th = th2;
                        com.baidu.adp.lib.util.n.close(reader);
                        com.baidu.adp.lib.util.n.close(reader2);
                        throw th;
                    }
                } catch (IOException e8) {
                    reader = null;
                    hashMap2 = hashMap;
                    e = e8;
                    bufferedReader = null;
                } catch (JSONException e9) {
                    reader = null;
                    hashMap2 = hashMap;
                    e = e9;
                    bufferedReader = null;
                } catch (Exception e10) {
                    reader = null;
                    hashMap2 = hashMap;
                    e = e10;
                    bufferedReader = null;
                }
            } catch (IOException e11) {
                e = e11;
                bufferedReader = null;
                reader = null;
            } catch (JSONException e12) {
                e = e12;
                bufferedReader = null;
                reader = null;
            } catch (Exception e13) {
                e = e13;
                bufferedReader = null;
                reader = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [447=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x00a3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x00aa */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0065 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.InputStream] */
    public d dzk() {
        FileNotFoundException e2;
        FileInputStream fileInputStream;
        File file = new File(DOWNLOAD_DIR + "bdtbWCache");
        if (file == null || !file.exists()) {
            return null;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("pref_key_quick_webview_version_name", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        d dVar = new d();
        File file2 = new File(file, string);
        dVar.msc = file2.getAbsolutePath();
        dVar.msf = string;
        ?? file3 = new File(file2, "router.json");
        if (!file3.exists()) {
            return null;
        }
        File file4 = new File(file2, "staticSources.json");
        boolean exists = file4.exists();
        try {
            if (exists != 0) {
                try {
                    exists = new FileInputStream((File) file3);
                } catch (FileNotFoundException e3) {
                    exists = 0;
                    e2 = e3;
                    fileInputStream = null;
                } catch (Throwable th) {
                    file3 = 0;
                    exists = 0;
                    th = th;
                }
                try {
                    dVar.msd = p(exists);
                    fileInputStream = new FileInputStream(file4);
                    try {
                        dVar.mse = o(fileInputStream);
                        com.baidu.adp.lib.util.n.close((InputStream) exists);
                        com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                        file3 = fileInputStream;
                        exists = exists;
                    } catch (FileNotFoundException e4) {
                        e2 = e4;
                        e2.printStackTrace();
                        com.baidu.adp.lib.util.n.close((InputStream) exists);
                        com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                        file3 = fileInputStream;
                        exists = exists;
                        return dVar;
                    }
                } catch (FileNotFoundException e5) {
                    fileInputStream = null;
                    e2 = e5;
                } catch (Throwable th2) {
                    file3 = 0;
                    th = th2;
                    com.baidu.adp.lib.util.n.close((InputStream) exists);
                    com.baidu.adp.lib.util.n.close((InputStream) file3);
                    throw th;
                }
                return dVar;
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void dzl() {
        String[] list;
        com.baidu.tbadk.core.sharedPref.b.bpu().putString("pref_key_quick_webview_version_name", "");
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
    public static void dzm() {
        n.deleteFileOrDir(new File(DOWNLOAD_DIR + "bdtbWCacheTemp"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(d dVar) {
        if (dVar == null || dVar.msc == null || dVar.mse == null) {
            return false;
        }
        Iterator<String> it = dVar.mse.msn.iterator();
        while (it.hasNext()) {
            if (!new File(dVar.msc, it.next()).exists()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        String msc;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> msd;
        com.baidu.tieba.quickWebView.data.b mse;
        String msf;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ff, code lost:
        if (r0.mIsSuccess != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0834b dzn() {
        C0834b c0834b = new C0834b();
        File file = new File(DOWNLOAD_DIR + "bdtbWCache");
        String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("pref_key_quick_webview_version_name", "");
        if (UploadOfflineWebCacheSwitch.isOn()) {
            c0834b.mIsSuccess = false;
            if (file == null || !file.exists()) {
                c0834b.errorMsg = "bundle not exist";
            } else if (TextUtils.isEmpty(string)) {
                c0834b.errorMsg = "the local has no valid version name";
            } else {
                String str = file.getAbsolutePath() + "/" + string;
                if (!new File(file.getAbsolutePath(), string).exists()) {
                    c0834b.errorMsg = "bundle not exist";
                } else {
                    String str2 = str + ".zip";
                    File file2 = new File(str2);
                    if (file2.exists()) {
                        n.deleteFileOrDir(file2);
                    }
                    if (r.dM(str, str2)) {
                        aa aaVar = new aa(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK);
                        aaVar.addPostData("offline_pack_version", string);
                        aaVar.bqa().bqH().mNeedBackgroundLogin = false;
                        aaVar.bqa().bqH().mIsUseCurrentBDUSS = false;
                        a(aaVar.dP("offline_pack_file_stream", str + ".zip"), c0834b);
                    } else {
                        c0834b.errorMsg = "zip bundle error";
                    }
                }
            }
            return c0834b;
        }
        c0834b.mIsSuccess = true;
        if (ClearOfflineWebCacheSwitch.isOn()) {
            dzl();
            if (file.exists() && !StringUtils.isNull(string) && new File(file.getAbsolutePath(), string).exists()) {
                c0834b.errorMsg = "delete fail";
                c0834b.mIsSuccess = false;
            }
        }
        return c0834b;
    }

    private C0834b a(String str, C0834b c0834b) {
        if (StringUtils.isNull(str)) {
            c0834b.errorMsg = "serve return is null";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                c0834b.mIsSuccess = jSONObject.optInt("error_code") == 0;
                c0834b.errorMsg = jSONObject.optString("error_msg");
            } catch (JSONException e2) {
                c0834b.errorMsg = "parse json exception";
                BdLog.e(e2);
            }
        }
        return c0834b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends BdAsyncTask<Void, Void, Boolean> {
        private aa bZh;
        private final String mMd5;
        private final String mUrl;
        private final String mVersion;

        public e(String str, String str2, String str3) {
            this.mUrl = str;
            this.mVersion = str2;
            this.mMd5 = str3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [635=4] */
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
            b.dzm();
            this.bZh = new aa();
            this.bZh.setUrl(this.mUrl);
            new File(b.DOWNLOAD_DIR + "bdtbWCacheTemp").mkdirs();
            String str2 = b.DOWNLOAD_DIR + "bdtbWCacheTemp/bdtbWCache.zip";
            if (this.bZh.downloadFile(str2, null, 0, 3, 0, true)) {
                TiebaStatic.log(new ar("c13435").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_type", "1"));
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
                    fileInputStream2 = fileInputStream;
                    fileNotFoundException = e2;
                    z = false;
                    try {
                        fileNotFoundException.printStackTrace();
                        com.baidu.adp.lib.util.n.close((InputStream) fileInputStream2);
                        str = b.DOWNLOAD_DIR + "bdtbWCacheTemp/" + this.mVersion;
                        if (r.unZipFiles(str2, str)) {
                        }
                        b.dzm();
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
                    b.mrY = 2;
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "md5 error", new Object[0]);
                    b.dzm();
                    com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                    return false;
                }
                com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                z = true;
                str = b.DOWNLOAD_DIR + "bdtbWCacheTemp/" + this.mVersion;
                if (r.unZipFiles(str2, str)) {
                    z = false;
                    b.mrY = 3;
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "unzip error", new Object[0]);
                } else if (!n.CopyDir(str, b.DOWNLOAD_DIR + "bdtbWCache/" + this.mVersion, true)) {
                    b.mrY = 4;
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "write error", new Object[0]);
                }
            } else {
                z = false;
                TiebaStatic.log(new ar("c13435").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_type", "2"));
                b.mrY = 1;
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "download error", new Object[0]);
            }
            b.dzm();
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((e) bool);
            if (bool.booleanValue()) {
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("pref_key_quick_webview_version_name", this.mVersion);
                b bVar = b.mrU;
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
        private boolean msb;

        public c() {
            this.msb = true;
        }

        public c(boolean z) {
            this.msb = true;
            this.msb = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public d doInBackground(Void... voidArr) {
            d dzk = b.this.dzk();
            if (dzk != null && !TextUtils.isEmpty(dzk.msc) && dzk.msd != null && dzk.msd.size() != 0 && dzk.mse != null) {
                if (b.this.a(dzk)) {
                    b.QD(dzk.msf);
                    return dzk;
                }
                b.mrY = 5;
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "bundle incomplete", new Object[0]);
                b.this.dzl();
                return null;
            }
            b.mrY = 5;
            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "bundle incomplete", new Object[0]);
            b.this.dzl();
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(d dVar) {
            String str;
            if (dVar != null && !StringUtils.isNull(dVar.msf)) {
                b.this.dxM = dVar.msc;
                com.baidu.tieba.quickWebView.c.dzq().G(dVar.msd);
                com.baidu.tieba.quickWebView.c.dzq().a(dVar.mse);
                str = dVar.msf;
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, 0, "readFile", 0, "", "version", str);
                if (!this.msb) {
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "type", "end");
                    com.baidu.tieba.quickWebView.c.dzq().wF(true);
                }
            } else {
                str = "0.0.0.0";
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readFile", -1, "read error", new Object[0]);
            }
            b.this.mrW = str;
            if (this.msb) {
                MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, String> {
        private aa msa;

        private a() {
            this.msa = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Void... voidArr) {
            C0834b dzn = b.this.dzn();
            if (dzn != null) {
                this.msa = new aa(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK_STATUS);
                this.msa.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
                this.msa.addPostData("status", dzn.mIsSuccess ? "1" : "2");
                this.msa.addPostData("fail_reason", dzn.mIsSuccess ? "" : dzn.errorMsg);
                this.msa.postNetData();
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
