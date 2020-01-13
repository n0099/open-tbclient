package com.baidu.tieba.quickWebView;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.lib.util.s;
import com.baidu.adp.plugin.util.Util;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
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
    private static c jDA;
    private long jDC;
    private String jDD;
    private static final String TAG = c.class.getSimpleName() + " TestActivity";
    private static final String DOWNLOAD_DIR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    private String jDB = null;
    private com.baidu.adp.framework.listener.a iSl = new com.baidu.adp.framework.listener.a(1003365, CmdConfigSocket.WEBVIEW_CACHE_INFO) { // from class: com.baidu.tieba.quickWebView.c.1
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
                                    com.baidu.tbadk.browser.a.rw(header.get(i2));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    c.w(webViewCacheResHttpMsg.getCacheDownloadUrl(), webViewCacheReqMsg.getVersionNum(), webViewCacheResHttpMsg.getCacheVersion(), webViewCacheResHttpMsg.getCacheMd5());
                } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                    WebViewCacheResSocketMsg webViewCacheResSocketMsg = (WebViewCacheResSocketMsg) responsedMessage;
                    c.w(webViewCacheResSocketMsg.getCacheDownloadUrl(), ((WebViewCacheReqMsg) webViewCacheResSocketMsg.getOrginalMessage().getExtra()).getVersionNum(), webViewCacheResSocketMsg.getCacheVersion(), webViewCacheResSocketMsg.getCacheMd5());
                }
            }
        }
    };

    public static c cAv() {
        if (jDA == null) {
            synchronized (c.class) {
                if (jDA == null) {
                    jDA = new c();
                }
            }
        }
        return jDA;
    }

    private c() {
    }

    public String cAw() {
        return this.jDB;
    }

    public String getCacheDir() {
        return this.jDD;
    }

    public void init() {
        this.jDC = System.currentTimeMillis();
        MessageManager.getInstance().registerListener(this.iSl);
        a aVar = new a();
        aVar.setPriority(4);
        aVar.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        String jDF;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> jDG;
        String jDH;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, b> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public b doInBackground(Void... voidArr) {
            b cAx = c.this.cAx();
            if (cAx != null && !TextUtils.isEmpty(cAx.jDF) && cAx.jDG != null && cAx.jDG.size() != 0) {
                c.Hr(cAx.jDH);
                return cAx;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(b bVar) {
            String str;
            if (bVar == null || StringUtils.isNull(bVar.jDH)) {
                str = "0.0.0.0";
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "read error", new Object[0]);
            } else {
                c.this.jDD = bVar.jDF;
                d.cAz().r(bVar.jDG);
                str = bVar.jDH;
            }
            c.this.jDB = str;
            MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b cAx() {
        String str;
        FileInputStream fileInputStream;
        String[] list;
        FileInputStream fileInputStream2 = null;
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
                    str = ee(str, str2);
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        File file2 = new File(file, str);
        bVar.jDF = file2.getAbsolutePath();
        bVar.jDH = str;
        File file3 = new File(file2, "router.json");
        if (file3.exists()) {
            try {
                try {
                    fileInputStream = new FileInputStream(file3);
                } catch (FileNotFoundException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bVar.jDG = m(fileInputStream);
                n.close((InputStream) fileInputStream);
            } catch (FileNotFoundException e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                n.close((InputStream) fileInputStream2);
                return bVar;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                n.close((InputStream) fileInputStream2);
                throw th;
            }
            return bVar;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [337=8, 338=7] */
    private static HashMap<String, com.baidu.tieba.quickWebView.data.a> m(InputStream inputStream) {
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
                                n.close(reader);
                                n.close((Reader) bufferedReader);
                                return null;
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("rules");
                            if (optJSONObject == null) {
                                n.close(reader);
                                n.close((Reader) bufferedReader);
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
                                aVar.jDK = arrayList;
                                aVar.jDL = optInt == 1;
                                hashMap.put(next, aVar);
                            }
                            n.close(reader);
                            n.close((Reader) bufferedReader);
                            return hashMap;
                        } catch (IOException e) {
                            hashMap2 = hashMap;
                            e = e;
                            e.printStackTrace();
                            n.close(reader);
                            n.close((Reader) bufferedReader);
                            return hashMap2;
                        } catch (JSONException e2) {
                            hashMap2 = hashMap;
                            e = e2;
                            e.printStackTrace();
                            n.close(reader);
                            n.close((Reader) bufferedReader);
                            return hashMap2;
                        } catch (Exception e3) {
                            hashMap2 = hashMap;
                            e = e3;
                            e.printStackTrace();
                            n.close(reader);
                            n.close((Reader) bufferedReader);
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
                        n.close(reader);
                        n.close(reader2);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(String str, String str2, String str3, String str4) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str3) && !StringUtils.isNull(str4)) {
            if (StringUtils.isNull(str2)) {
                str2 = "0.0.0";
            }
            Util.VersionCompare D = Util.D(str2, str3);
            if (D != Util.VersionCompare.EQUAL && D != Util.VersionCompare.GREATER) {
                new C0586c(str, str3, str4).execute(new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cAy() {
        m.deleteFileOrDir(new File(DOWNLOAD_DIR + "bdtbWCacheTemp"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.quickWebView.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0586c extends BdAsyncTask {
        private x cHA;
        private final String mMd5;
        private final String mUrl;
        private final String mVersion;

        public C0586c(String str, String str2, String str3) {
            this.mUrl = str;
            this.mVersion = str2;
            this.mMd5 = str3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [427=4] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00f4  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0147  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected Object doInBackground(Object[] objArr) {
            FileInputStream fileInputStream;
            String str;
            String md5;
            c.cAy();
            this.cHA = new x();
            this.cHA.setUrl(this.mUrl);
            new File(c.DOWNLOAD_DIR + "bdtbWCacheTemp").mkdirs();
            String str2 = c.DOWNLOAD_DIR + "bdtbWCacheTemp/bdtbWCache.zip";
            if (this.cHA.downloadFile(str2, null, 0, 3, 0, true)) {
                TiebaStatic.log(new an("c13435").cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_type", "1"));
                try {
                    fileInputStream = new FileInputStream(str2);
                    try {
                        try {
                            md5 = s.toMd5(fileInputStream);
                        } catch (FileNotFoundException e) {
                            e = e;
                            e.printStackTrace();
                            n.close((InputStream) fileInputStream);
                            str = c.DOWNLOAD_DIR + "bdtbWCacheTemp/" + this.mVersion;
                            if (r.unZipFiles(str2, str)) {
                            }
                            c.cAy();
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        n.close((InputStream) fileInputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    n.close((InputStream) fileInputStream);
                    throw th;
                }
                if (StringUtils.isNull(md5) || !md5.toLowerCase().equals(this.mMd5.toLowerCase())) {
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "md5 error", new Object[0]);
                    c.cAy();
                    n.close((InputStream) fileInputStream);
                    return null;
                }
                n.close((InputStream) fileInputStream);
                str = c.DOWNLOAD_DIR + "bdtbWCacheTemp/" + this.mVersion;
                if (r.unZipFiles(str2, str)) {
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "unzip error", new Object[0]);
                } else if (!m.CopyDir(str, c.DOWNLOAD_DIR + "bdtbWCache/" + this.mVersion, true)) {
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "write error", new Object[0]);
                }
            } else {
                TiebaStatic.log(new an("c13435").cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_type", "2"));
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "download error", new Object[0]);
            }
            c.cAy();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Hr(String str) {
        String[] list;
        if (!TextUtils.isEmpty(str)) {
            String str2 = DOWNLOAD_DIR + "bdtbWCache";
            File file = new File(str2);
            if (file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0) {
                for (String str3 : list) {
                    if (!StringUtils.isNull(str3) && !str3.equals(str)) {
                        m.deleteFileOrDir(new File(str2 + "/" + str3));
                    }
                }
            }
        }
    }

    private static String ee(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        try {
            Util.VersionCompare D = Util.D(str, str2);
            if (D != Util.VersionCompare.EQUAL) {
                return D != Util.VersionCompare.GREATER ? str2 : str;
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
}
