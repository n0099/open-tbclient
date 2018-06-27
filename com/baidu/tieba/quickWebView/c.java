package com.baidu.tieba.quickWebView;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.lib.util.s;
import com.baidu.adp.plugin.util.Util;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.y;
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
    private static c glT;
    private long glV;
    private String glX;
    private static final String TAG = c.class.getSimpleName() + " TestActivity";
    private static final String glW = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    private String glU = null;
    private com.baidu.adp.framework.listener.a fJe = new com.baidu.adp.framework.listener.a(CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485) { // from class: com.baidu.tieba.quickWebView.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage instanceof WebViewCacheResHttpMsg) {
                    WebViewCacheResHttpMsg webViewCacheResHttpMsg = (WebViewCacheResHttpMsg) responsedMessage;
                    c.n(webViewCacheResHttpMsg.getCacheDownloadUrl(), ((WebViewCacheReqMsg) webViewCacheResHttpMsg.getOrginalMessage().getExtra()).getVersionNum(), webViewCacheResHttpMsg.getCacheVersion(), webViewCacheResHttpMsg.getCacheMd5());
                } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                    WebViewCacheResSocketMsg webViewCacheResSocketMsg = (WebViewCacheResSocketMsg) responsedMessage;
                    c.n(webViewCacheResSocketMsg.getCacheDownloadUrl(), ((WebViewCacheReqMsg) webViewCacheResSocketMsg.getOrginalMessage().getExtra()).getVersionNum(), webViewCacheResSocketMsg.getCacheVersion(), webViewCacheResSocketMsg.getCacheMd5());
                }
            }
        }
    };

    public static c bok() {
        if (glT == null) {
            synchronized (c.class) {
                if (glT == null) {
                    glT = new c();
                }
            }
        }
        return glT;
    }

    private c() {
    }

    public String bol() {
        return this.glU;
    }

    public String ys() {
        return this.glX;
    }

    public void init() {
        this.glV = System.currentTimeMillis();
        MessageManager.getInstance().registerListener(this.fJe);
        a aVar = new a();
        aVar.setPriority(4);
        aVar.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        String glZ;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> gma;
        String gmb;

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
        /* renamed from: i */
        public b doInBackground(Void... voidArr) {
            b bon = c.this.bon();
            if (bon == null || TextUtils.isEmpty(bon.glZ) || bon.gma == null || bon.gma.size() == 0) {
                bon = c.this.bom();
            }
            if (bon != null && !TextUtils.isEmpty(bon.glZ) && bon.gma != null && bon.gma.size() != 0) {
                c.sF(bon.gmb);
                return bon;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(b bVar) {
            String str;
            if (bVar == null || StringUtils.isNull(bVar.gmb)) {
                str = "0.0.0.0";
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "read error", new Object[0]);
            } else {
                c.this.glX = bVar.glZ;
                d.boq().m(bVar.gma);
                str = bVar.gmb;
            }
            c.this.glU = str;
            MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b bom() {
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
            bVar.glZ = "/android_asset/" + str3;
            bVar.gmb = str;
            try {
                inputStream = TbadkCoreApplication.getInst().getContext().getAssets().open(str3 + "/router.json");
                bVar.gma = k(inputStream);
            } catch (IOException e4) {
                e4.printStackTrace();
            } finally {
                n.f(inputStream);
            }
            return bVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b bon() {
        String str;
        FileInputStream fileInputStream;
        String[] list;
        FileInputStream fileInputStream2 = null;
        File file = new File(glW + "bdtbWCache");
        if (file == null || !file.exists()) {
            return null;
        }
        if (!file.isDirectory() || (list = file.list()) == null || list.length == 0) {
            str = null;
        } else {
            str = list[0];
            for (String str2 : list) {
                if (!StringUtils.isNull(str2)) {
                    str = ca(str, str2);
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        File file2 = new File(file, str);
        bVar.glZ = file2.getAbsolutePath();
        bVar.gmb = str;
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
                bVar.gma = k(fileInputStream);
                n.f(fileInputStream);
            } catch (FileNotFoundException e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                n.f(fileInputStream2);
                return bVar;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                n.f(fileInputStream2);
                throw th;
            }
            return bVar;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [330=8, 331=7] */
    private static HashMap<String, com.baidu.tieba.quickWebView.data.a> k(InputStream inputStream) {
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
                                n.b(reader);
                                n.b((Reader) bufferedReader);
                                return null;
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("rules");
                            if (optJSONObject == null) {
                                n.b(reader);
                                n.b((Reader) bufferedReader);
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
                                aVar.gme = arrayList;
                                aVar.gmf = optInt == 1;
                                hashMap.put(next, aVar);
                            }
                            n.b(reader);
                            n.b((Reader) bufferedReader);
                            return hashMap;
                        } catch (IOException e) {
                            hashMap2 = hashMap;
                            e = e;
                            e.printStackTrace();
                            n.b(reader);
                            n.b((Reader) bufferedReader);
                            return hashMap2;
                        } catch (JSONException e2) {
                            hashMap2 = hashMap;
                            e = e2;
                            e.printStackTrace();
                            n.b(reader);
                            n.b((Reader) bufferedReader);
                            return hashMap2;
                        } catch (Exception e3) {
                            hashMap2 = hashMap;
                            e = e3;
                            e.printStackTrace();
                            n.b(reader);
                            n.b((Reader) bufferedReader);
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
                        n.b(reader);
                        n.b(reader2);
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
    public static void n(String str, String str2, String str3, String str4) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str3) && !StringUtils.isNull(str4)) {
            if (StringUtils.isNull(str2)) {
                str2 = "0.0.0";
            }
            Util.VersionCompare J = Util.J(str2, str3);
            if (J != Util.VersionCompare.EQUAL && J != Util.VersionCompare.GREATER) {
                new C0223c(str, str3, str4).execute(new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void boo() {
        l.r(new File(glW + "bdtbWCacheTemp"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.quickWebView.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0223c extends BdAsyncTask {
        private final String mMd5;
        private y mNetWork;
        private final String mUrl;
        private final String mVersion;

        public C0223c(String str, String str2, String str3) {
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
            String g;
            c.boo();
            if (!j.jE()) {
                return null;
            }
            this.mNetWork = new y();
            this.mNetWork.setUrl(this.mUrl);
            new File(c.glW + "bdtbWCacheTemp").mkdirs();
            String str2 = c.glW + "bdtbWCacheTemp/bdtbWCache.zip";
            InputStream inputStream = null;
            if (this.mNetWork.a(str2, null, 0, 3, 0, true)) {
                try {
                    try {
                        fileInputStream = new FileInputStream(str2);
                        try {
                            g = s.g(fileInputStream);
                        } catch (FileNotFoundException e) {
                            e = e;
                            e.printStackTrace();
                            n.f(fileInputStream);
                            str = c.glW + "bdtbWCacheTemp/" + this.mVersion;
                            if (!r.X(str2, str)) {
                            }
                            c.boo();
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        n.f(inputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    n.f(inputStream);
                    throw th;
                }
                if (!StringUtils.isNull(g) && g.toLowerCase().equals(this.mMd5.toLowerCase())) {
                    n.f(fileInputStream);
                    str = c.glW + "bdtbWCacheTemp/" + this.mVersion;
                    if (!r.X(str2, str)) {
                        if (!l.e(str, c.glW + "bdtbWCache/" + this.mVersion, true)) {
                            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "write error", new Object[0]);
                        }
                    } else {
                        com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "unzip error", new Object[0]);
                    }
                } else {
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "md5 error", new Object[0]);
                    c.boo();
                    n.f(fileInputStream);
                    return null;
                }
            } else {
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "download error", new Object[0]);
            }
            c.boo();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sF(String str) {
        String[] list;
        if (!TextUtils.isEmpty(str)) {
            String str2 = glW + "bdtbWCache";
            File file = new File(str2);
            if (file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0) {
                for (String str3 : list) {
                    if (!StringUtils.isNull(str3) && !str3.equals(str)) {
                        l.r(new File(str2 + "/" + str3));
                    }
                }
            }
        }
    }

    private static String ca(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        try {
            Util.VersionCompare J = Util.J(str, str2);
            if (J != Util.VersionCompare.EQUAL) {
                return J != Util.VersionCompare.GREATER ? str2 : str;
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
}
