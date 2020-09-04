package com.baidu.tieba.quickWebView;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.adp.plugin.util.Util;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.n;
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
public class c {
    private static final String DOWNLOAD_DIR;
    private static final String TAG = c.class.getSimpleName() + " TestActivity";
    private static c lAZ;
    private String cWP;
    private long lBb;
    private String lBa = null;
    private com.baidu.adp.framework.listener.a kQU = new com.baidu.adp.framework.listener.a(1003365, CmdConfigSocket.WEBVIEW_CACHE_INFO) { // from class: com.baidu.tieba.quickWebView.c.1
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
                                    com.baidu.tbadk.browser.a.ye(header.get(i2));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    c.A(webViewCacheResHttpMsg.getCacheDownloadUrl(), webViewCacheReqMsg.getVersionNum(), webViewCacheResHttpMsg.getCacheVersion(), webViewCacheResHttpMsg.getCacheMd5());
                } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                    WebViewCacheResSocketMsg webViewCacheResSocketMsg = (WebViewCacheResSocketMsg) responsedMessage;
                    c.A(webViewCacheResSocketMsg.getCacheDownloadUrl(), ((WebViewCacheReqMsg) webViewCacheResSocketMsg.getOrginalMessage().getExtra()).getVersionNum(), webViewCacheResSocketMsg.getCacheVersion(), webViewCacheResSocketMsg.getCacheMd5());
                }
            }
        }
    };

    static {
        String str;
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            str = TbadkCoreApplication.getInst().getExternalFilesDir(null).getAbsolutePath() + "/";
        } else {
            str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
        }
        DOWNLOAD_DIR = str;
    }

    public static c dmH() {
        if (lAZ == null) {
            synchronized (c.class) {
                if (lAZ == null) {
                    lAZ = new c();
                }
            }
        }
        return lAZ;
    }

    private c() {
    }

    public String dmI() {
        return this.lBa;
    }

    public String getCacheDir() {
        return this.cWP;
    }

    public void init() {
        this.lBb = System.currentTimeMillis();
        MessageManager.getInstance().registerListener(this.kQU);
        a aVar = new a();
        aVar.setPriority(4);
        aVar.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A(String str, String str2, String str3, String str4) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str3) && !StringUtils.isNull(str4)) {
            if (StringUtils.isNull(str2)) {
                str2 = "0.0.0";
            }
            Util.VersionCompare L = Util.L(str2, str3);
            if (L == Util.VersionCompare.EQUAL || L == Util.VersionCompare.GREATER) {
                d.dmN().vn(true);
                return;
            }
            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, 0, "downloadCache", 0, "", "url", str, "intallVersion", str3, "lastVersion", str2, "type", "start");
            new C0786c(str, str3, str4).execute(new Void[0]);
        }
    }

    private static com.baidu.tieba.quickWebView.data.b n(InputStream inputStream) {
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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (jSONObject.has("all") && jSONObject.has("entry")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("all");
            JSONObject optJSONObject = jSONObject.optJSONObject("entry");
            if (optJSONArray == null || optJSONObject == null) {
                return null;
            }
            bVar.lBo = new ArrayList<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                bVar.lBo.add(optJSONArray.optString(i));
            }
            bVar.lBp = new HashMap<>();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    arrayList.add(optJSONArray2.optString(i2));
                }
                bVar.lBp.put(next, arrayList);
            }
            return bVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Pd(String str) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [350=8, 351=7] */
    private static HashMap<String, com.baidu.tieba.quickWebView.data.a> o(InputStream inputStream) {
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
                                aVar.lBm = arrayList;
                                aVar.lBn = optInt == 1;
                                hashMap.put(next, aVar);
                            }
                            com.baidu.adp.lib.util.n.close(reader);
                            com.baidu.adp.lib.util.n.close((Reader) bufferedReader);
                            return hashMap;
                        } catch (IOException e) {
                            hashMap2 = hashMap;
                            e = e;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.close(reader);
                            com.baidu.adp.lib.util.n.close((Reader) bufferedReader);
                            return hashMap2;
                        } catch (JSONException e2) {
                            hashMap2 = hashMap;
                            e = e2;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.close(reader);
                            com.baidu.adp.lib.util.n.close((Reader) bufferedReader);
                            return hashMap2;
                        } catch (Exception e3) {
                            hashMap2 = hashMap;
                            e = e3;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.close(reader);
                            com.baidu.adp.lib.util.n.close((Reader) bufferedReader);
                            return hashMap2;
                        }
                    } catch (IOException e4) {
                        bufferedReader = null;
                        hashMap2 = hashMap;
                        e = e4;
                    } catch (JSONException e5) {
                        bufferedReader = null;
                        hashMap2 = hashMap;
                        e = e5;
                    } catch (Exception e6) {
                        bufferedReader = null;
                        hashMap2 = hashMap;
                        e = e6;
                    } catch (Throwable th2) {
                        reader2 = null;
                        th = th2;
                        com.baidu.adp.lib.util.n.close(reader);
                        com.baidu.adp.lib.util.n.close(reader2);
                        throw th;
                    }
                } catch (IOException e7) {
                    reader = null;
                    hashMap2 = hashMap;
                    e = e7;
                    bufferedReader = null;
                } catch (JSONException e8) {
                    reader = null;
                    hashMap2 = hashMap;
                    e = e8;
                    bufferedReader = null;
                } catch (Exception e9) {
                    reader = null;
                    hashMap2 = hashMap;
                    e = e9;
                    bufferedReader = null;
                }
            } catch (IOException e10) {
                e = e10;
                bufferedReader = null;
                reader = null;
            } catch (JSONException e11) {
                e = e11;
                bufferedReader = null;
                reader = null;
            } catch (Exception e12) {
                e = e12;
                bufferedReader = null;
                reader = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [414=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public b dmJ() {
        String str;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        String[] list;
        FileInputStream fileInputStream3 = null;
        File file = new File(DOWNLOAD_DIR + "bdtbWCache");
        if (file == null || !file.exists()) {
            return null;
        }
        if (!file.isDirectory() || (list = file.list()) == null || list.length == 0) {
            str = null;
        } else {
            str = list[0];
            for (String str2 : list) {
                if (!StringUtils.isNull(str2)) {
                    str = fC(str, str2);
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        File file2 = new File(file, str);
        bVar.lBe = file2.getAbsolutePath();
        bVar.lBh = str;
        File file3 = new File(file2, "router.json");
        if (file3.exists()) {
            File file4 = new File(file2, "staticSources.json");
            if (file4.exists()) {
                try {
                    fileInputStream = new FileInputStream(file3);
                    try {
                        bVar.lBf = o(fileInputStream);
                        FileInputStream fileInputStream4 = new FileInputStream(file4);
                        try {
                            bVar.lBg = n(fileInputStream4);
                            com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                            com.baidu.adp.lib.util.n.close((InputStream) fileInputStream4);
                        } catch (FileNotFoundException e) {
                            e = e;
                            fileInputStream3 = fileInputStream4;
                            fileInputStream2 = fileInputStream;
                            try {
                                e.printStackTrace();
                                com.baidu.adp.lib.util.n.close((InputStream) fileInputStream2);
                                com.baidu.adp.lib.util.n.close((InputStream) fileInputStream3);
                                return bVar;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                                com.baidu.adp.lib.util.n.close((InputStream) fileInputStream3);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream3 = fileInputStream4;
                            com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                            com.baidu.adp.lib.util.n.close((InputStream) fileInputStream3);
                            throw th;
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileInputStream2 = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = null;
                }
                return bVar;
            }
            return null;
        }
        return null;
    }

    public void dmK() {
        String[] list;
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
    public static void dmL() {
        n.deleteFileOrDir(new File(DOWNLOAD_DIR + "bdtbWCacheTemp"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b bVar) {
        if (bVar == null || bVar.lBe == null || bVar.lBg == null) {
            return false;
        }
        Iterator<String> it = bVar.lBg.lBo.iterator();
        while (it.hasNext()) {
            if (!new File(bVar.lBe, it.next()).exists()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        String lBe;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> lBf;
        com.baidu.tieba.quickWebView.data.b lBg;
        String lBh;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.quickWebView.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0786c extends BdAsyncTask<Void, Void, Boolean> {
        private aa bEb;
        private final String mMd5;
        private final String mUrl;
        private final String mVersion;

        public C0786c(String str, String str2, String str3) {
            this.mUrl = str;
            this.mVersion = str2;
            this.mMd5 = str3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [522=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00fa  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0151  */
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
            c.dmL();
            this.bEb = new aa();
            this.bEb.setUrl(this.mUrl);
            new File(c.DOWNLOAD_DIR + "bdtbWCacheTemp").mkdirs();
            String str2 = c.DOWNLOAD_DIR + "bdtbWCacheTemp/bdtbWCache.zip";
            if (this.bEb.downloadFile(str2, null, 0, 3, 0, true)) {
                TiebaStatic.log(new aq("c13435").dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("obj_type", "1"));
                FileInputStream fileInputStream2 = null;
                try {
                    fileInputStream = new FileInputStream(str2);
                    try {
                        md5 = s.toMd5(fileInputStream);
                    } catch (FileNotFoundException e) {
                        fileInputStream2 = fileInputStream;
                        fileNotFoundException = e;
                        z = false;
                        try {
                            fileNotFoundException.printStackTrace();
                            com.baidu.adp.lib.util.n.close((InputStream) fileInputStream2);
                            str = c.DOWNLOAD_DIR + "bdtbWCacheTemp/" + this.mVersion;
                            if (r.unZipFiles(str2, str)) {
                            }
                            c.dmL();
                            return Boolean.valueOf(z);
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    fileNotFoundException = e2;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
                if (StringUtils.isNull(md5) || !md5.toLowerCase().equals(this.mMd5.toLowerCase())) {
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "md5 error", new Object[0]);
                    c.dmL();
                    com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                    return false;
                }
                com.baidu.adp.lib.util.n.close((InputStream) fileInputStream);
                z = true;
                str = c.DOWNLOAD_DIR + "bdtbWCacheTemp/" + this.mVersion;
                if (r.unZipFiles(str2, str)) {
                    z = false;
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "unzip error", new Object[0]);
                } else if (!n.CopyDir(str, c.DOWNLOAD_DIR + "bdtbWCache/" + this.mVersion, true)) {
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "write error", new Object[0]);
                }
            } else {
                z = false;
                TiebaStatic.log(new aq("c13435").dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("obj_type", "2"));
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "download error", new Object[0]);
            }
            c.dmL();
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((C0786c) bool);
            if (bool.booleanValue()) {
                c cVar = c.lAZ;
                cVar.getClass();
                a aVar = new a(false);
                aVar.setPriority(4);
                aVar.execute(new Void[0]);
            }
        }
    }

    private static String fC(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        try {
            Util.VersionCompare L = Util.L(str, str2);
            if (L != Util.VersionCompare.EQUAL) {
                return L != Util.VersionCompare.GREATER ? str2 : str;
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, b> {
        private boolean lBd;

        public a() {
            this.lBd = true;
        }

        public a(boolean z) {
            this.lBd = true;
            this.lBd = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public b doInBackground(Void... voidArr) {
            b dmJ = c.this.dmJ();
            if (dmJ != null && !TextUtils.isEmpty(dmJ.lBe) && dmJ.lBf != null && dmJ.lBf.size() != 0 && dmJ.lBg != null) {
                if (c.this.a(dmJ)) {
                    c.Pd(dmJ.lBh);
                    return dmJ;
                }
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "bundle incomplete", new Object[0]);
                c.this.dmK();
                return null;
            }
            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "bundle incomplete", new Object[0]);
            c.this.dmK();
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(b bVar) {
            String str;
            if (bVar != null && !StringUtils.isNull(bVar.lBh)) {
                c.this.cWP = bVar.lBe;
                d.dmN().F(bVar.lBf);
                d.dmN().a(bVar.lBg);
                str = bVar.lBh;
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, 0, "readFile", 0, "", "version", str);
                if (!this.lBd) {
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "type", "end");
                    d.dmN().vn(true);
                }
            } else {
                str = "0.0.0.0";
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readFile", -1, "read error", new Object[0]);
            }
            c.this.lBa = str;
            if (this.lBd) {
                MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg(str));
            }
        }
    }

    public void Pe(String str) {
        this.lBa = str;
    }
}
