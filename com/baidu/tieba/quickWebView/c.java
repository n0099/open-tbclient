package com.baidu.tieba.quickWebView;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.m;
import com.baidu.adp.lib.util.r;
import com.baidu.adp.plugin.util.Util;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.hybrid.y;
import com.baidu.tbadk.core.util.k;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static c fEm;
    private long fEo;
    private String fEq;
    private static final String TAG = c.class.getSimpleName() + " TestActivity";
    private static final String fEp = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    private String fEn = null;
    private com.baidu.adp.framework.listener.a eVz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485) { // from class: com.baidu.tieba.quickWebView.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage instanceof WebViewCacheResHttpMsg) {
                    WebViewCacheResHttpMsg webViewCacheResHttpMsg = (WebViewCacheResHttpMsg) responsedMessage;
                    c.j(webViewCacheResHttpMsg.getCacheDownloadUrl(), ((WebViewCacheReqMsg) webViewCacheResHttpMsg.getOrginalMessage().getExtra()).getVersionNum(), webViewCacheResHttpMsg.getCacheVersion(), webViewCacheResHttpMsg.getCacheMd5());
                } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                    WebViewCacheResSocketMsg webViewCacheResSocketMsg = (WebViewCacheResSocketMsg) responsedMessage;
                    c.j(webViewCacheResSocketMsg.getCacheDownloadUrl(), ((WebViewCacheReqMsg) webViewCacheResSocketMsg.getOrginalMessage().getExtra()).getVersionNum(), webViewCacheResSocketMsg.getCacheVersion(), webViewCacheResSocketMsg.getCacheMd5());
                }
            }
        }
    };

    public static c bgP() {
        if (fEm == null) {
            synchronized (c.class) {
                if (fEm == null) {
                    fEm = new c();
                }
            }
        }
        return fEm;
    }

    private c() {
    }

    public String bgQ() {
        return this.fEn;
    }

    public String uG() {
        return this.fEq;
    }

    public void init() {
        this.fEo = System.currentTimeMillis();
        MessageManager.getInstance().registerListener(this.eVz);
        a aVar = new a();
        aVar.setPriority(4);
        aVar.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        String fEs;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> fEt;
        String fEu;

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
        /* renamed from: h */
        public b doInBackground(Void... voidArr) {
            b bgS = c.this.bgS();
            if (bgS == null || TextUtils.isEmpty(bgS.fEs) || bgS.fEt == null || bgS.fEt.size() == 0) {
                bgS = c.this.bgR();
            }
            if (bgS != null && !TextUtils.isEmpty(bgS.fEs) && bgS.fEt != null && bgS.fEt.size() != 0) {
                c.qP(bgS.fEu);
                return bgS;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(b bVar) {
            String str;
            if (bVar == null || StringUtils.isNull(bVar.fEu)) {
                str = "0.0.0.0";
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "read error", new Object[0]);
            } else {
                c.this.fEq = bVar.fEs;
                d.bgW().h(bVar.fEt);
                str = bVar.fEu;
            }
            c.this.fEn = str;
            MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b bgR() {
        IOException e;
        String str;
        InputStream inputStream = null;
        try {
            String[] list = TbadkCoreApplication.getInst().getContext().getAssets().list("bdtbWCache");
            if (list == null || list.length == 0) {
                str = null;
            } else {
                int length = list.length;
                int i = 0;
                str = null;
                while (i < length) {
                    try {
                        String str2 = list[i];
                        i++;
                        str = str2;
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (TextUtils.isEmpty(str)) {
                        }
                    }
                }
            }
        } catch (IOException e3) {
            e = e3;
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            b bVar = new b();
            String str3 = "bdtbWCache/" + str;
            bVar.fEs = "/android_asset/" + str3;
            bVar.fEu = str;
            try {
                inputStream = TbadkCoreApplication.getInst().getContext().getAssets().open(str3 + "/router.json");
                bVar.fEt = l(inputStream);
            } catch (IOException e4) {
                e4.printStackTrace();
                m.d(inputStream);
            }
            return bVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b bgS() {
        String str;
        FileInputStream fileInputStream;
        String[] list;
        FileInputStream fileInputStream2 = null;
        File file = new File(fEp + "bdtbWCache");
        if (file == null || !file.exists()) {
            return null;
        }
        if (!file.isDirectory() || (list = file.list()) == null || list.length == 0) {
            str = null;
        } else {
            str = list[0];
            for (String str2 : list) {
                if (!StringUtils.isNull(str2)) {
                    str = bW(str, str2);
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        File file2 = new File(file, str);
        bVar.fEs = file2.getAbsolutePath();
        bVar.fEu = str;
        File file3 = new File(file2, "router.json");
        if (file3.exists()) {
            try {
                fileInputStream = new FileInputStream(file3);
            } catch (FileNotFoundException e) {
                e = e;
            }
            try {
                bVar.fEt = l(fileInputStream);
            } catch (FileNotFoundException e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                m.d(fileInputStream2);
                return bVar;
            }
            return bVar;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [328=8, 329=7] */
    private static HashMap<String, com.baidu.tieba.quickWebView.data.a> l(InputStream inputStream) {
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
                                m.b(reader);
                                m.b((Reader) bufferedReader);
                                return null;
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("rules");
                            if (optJSONObject == null) {
                                m.b(reader);
                                m.b((Reader) bufferedReader);
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
                                aVar.fEx = arrayList;
                                aVar.fEy = optInt == 1;
                                hashMap.put(next, aVar);
                            }
                            m.b(reader);
                            m.b((Reader) bufferedReader);
                            return hashMap;
                        } catch (IOException e) {
                            hashMap2 = hashMap;
                            e = e;
                            e.printStackTrace();
                            m.b(reader);
                            m.b((Reader) bufferedReader);
                            return hashMap2;
                        } catch (JSONException e2) {
                            hashMap2 = hashMap;
                            e = e2;
                            e.printStackTrace();
                            m.b(reader);
                            m.b((Reader) bufferedReader);
                            return hashMap2;
                        } catch (Exception e3) {
                            hashMap2 = hashMap;
                            e = e3;
                            e.printStackTrace();
                            m.b(reader);
                            m.b((Reader) bufferedReader);
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
                        m.b(reader);
                        m.b(reader2);
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
    public static void j(String str, String str2, String str3, String str4) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str3) && !StringUtils.isNull(str4)) {
            if (StringUtils.isNull(str2)) {
                str2 = "0.0.0";
            }
            Util.VersionCompare I = Util.I(str2, str3);
            if (I != Util.VersionCompare.EQUAL && I != Util.VersionCompare.GREATER) {
                new C0119c(str, str3, str4).execute(new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bgT() {
        k.t(new File(fEp + "bdtbWCacheTemp"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.quickWebView.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0119c extends BdAsyncTask {
        private final String mMd5;
        private x mNetWork;
        private final String mUrl;
        private final String mVersion;

        public C0119c(String str, String str2, String str3) {
            this.mUrl = str;
            this.mVersion = str2;
            this.mMd5 = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00dd  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0131  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected Object doInBackground(Object[] objArr) {
            FileInputStream fileInputStream;
            String str;
            String e;
            c.bgT();
            if (!i.hj()) {
                return null;
            }
            this.mNetWork = new x();
            this.mNetWork.setUrl(this.mUrl);
            new File(c.fEp + "bdtbWCacheTemp").mkdirs();
            String str2 = c.fEp + "bdtbWCacheTemp/bdtbWCache.zip";
            InputStream inputStream = null;
            if (this.mNetWork.a(str2, null, 0, 3, 0, true)) {
                try {
                    try {
                        fileInputStream = new FileInputStream(str2);
                        try {
                            e = r.e(fileInputStream);
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            e.printStackTrace();
                            m.d(fileInputStream);
                            str = c.fEp + "bdtbWCacheTemp/" + this.mVersion;
                            if (!y.U(str2, str)) {
                            }
                            c.bgT();
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        m.d(inputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    m.d(inputStream);
                    throw th;
                }
                if (!StringUtils.isNull(e) && e.toLowerCase().equals(this.mMd5.toLowerCase())) {
                    m.d(fileInputStream);
                    str = c.fEp + "bdtbWCacheTemp/" + this.mVersion;
                    if (!y.U(str2, str)) {
                        if (!k.d(str, c.fEp + "bdtbWCache/" + this.mVersion, true)) {
                            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "write error", new Object[0]);
                        }
                    } else {
                        com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "unzip error", new Object[0]);
                    }
                } else {
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "md5 error", new Object[0]);
                    c.bgT();
                    m.d(fileInputStream);
                    return null;
                }
            } else {
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "download error", new Object[0]);
            }
            c.bgT();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qP(String str) {
        String[] list;
        if (!TextUtils.isEmpty(str)) {
            String str2 = fEp + "bdtbWCache";
            File file = new File(str2);
            if (file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0) {
                for (String str3 : list) {
                    if (!StringUtils.isNull(str3) && !str3.equals(str)) {
                        k.t(new File(str2 + "/" + str3));
                    }
                }
            }
        }
    }

    private static String bW(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        try {
            Util.VersionCompare I = Util.I(str, str2);
            if (I != Util.VersionCompare.EQUAL) {
                return I != Util.VersionCompare.GREATER ? str2 : str;
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
}
