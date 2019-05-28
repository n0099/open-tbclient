package com.baidu.tieba.quickWebView;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.lib.util.s;
import com.baidu.adp.plugin.util.Util;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static final String TAG = c.class.getSimpleName() + " TestActivity";
    private static final String cQe = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    private static c iyo;
    private long iyq;
    private String iyr;
    private String iyp = null;
    private com.baidu.adp.framework.listener.a hSt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485) { // from class: com.baidu.tieba.quickWebView.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage instanceof WebViewCacheResHttpMsg) {
                    WebViewCacheResHttpMsg webViewCacheResHttpMsg = (WebViewCacheResHttpMsg) responsedMessage;
                    WebViewCacheReqMsg webViewCacheReqMsg = (WebViewCacheReqMsg) webViewCacheResHttpMsg.getOrginalMessage().getExtra();
                    List<String> header = webViewCacheResHttpMsg.getHeader("Set-Cookie");
                    if (header != null && header.size() > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < header.size()) {
                                if (TextUtils.isEmpty(header.get(i2)) || !header.get(i2).contains("BAIDUID=")) {
                                    i = i2 + 1;
                                } else {
                                    com.baidu.tbadk.browser.a.lw(header.get(i2));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    c.r(webViewCacheResHttpMsg.getCacheDownloadUrl(), webViewCacheReqMsg.getVersionNum(), webViewCacheResHttpMsg.getCacheVersion(), webViewCacheResHttpMsg.getCacheMd5());
                } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                    WebViewCacheResSocketMsg webViewCacheResSocketMsg = (WebViewCacheResSocketMsg) responsedMessage;
                    c.r(webViewCacheResSocketMsg.getCacheDownloadUrl(), ((WebViewCacheReqMsg) webViewCacheResSocketMsg.getOrginalMessage().getExtra()).getVersionNum(), webViewCacheResSocketMsg.getCacheVersion(), webViewCacheResSocketMsg.getCacheMd5());
                }
            }
        }
    };

    public static c cen() {
        if (iyo == null) {
            synchronized (c.class) {
                if (iyo == null) {
                    iyo = new c();
                }
            }
        }
        return iyo;
    }

    private c() {
    }

    public String ceo() {
        return this.iyp;
    }

    public String ahb() {
        return this.iyr;
    }

    public void init() {
        this.iyq = System.currentTimeMillis();
        MessageManager.getInstance().registerListener(this.hSt);
        a aVar = new a();
        aVar.setPriority(4);
        aVar.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        String iyt;
        HashMap<String, com.baidu.tieba.quickWebView.data.a> iyu;
        String iyv;

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
            b cep = c.this.cep();
            if (cep != null && !TextUtils.isEmpty(cep.iyt) && cep.iyu != null && cep.iyu.size() != 0) {
                c.CK(cep.iyv);
                return cep;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(b bVar) {
            String str;
            if (bVar == null || StringUtils.isNull(bVar.iyv)) {
                str = "0.0.0.0";
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "read error", new Object[0]);
            } else {
                c.this.iyr = bVar.iyt;
                d.ces().s(bVar.iyu);
                str = bVar.iyv;
            }
            c.this.iyp = str;
            MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b cep() {
        String str;
        FileInputStream fileInputStream;
        String[] list;
        FileInputStream fileInputStream2 = null;
        File file = new File(cQe + "bdtbWCache");
        if (file == null || !file.exists()) {
            return null;
        }
        if (!file.isDirectory() || (list = file.list()) == null || list.length == 0) {
            str = null;
        } else {
            str = list[0];
            for (String str2 : list) {
                if (!StringUtils.isNull(str2)) {
                    str = dV(str, str2);
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        File file2 = new File(file, str);
        bVar.iyt = file2.getAbsolutePath();
        bVar.iyv = str;
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
                bVar.iyu = p(fileInputStream);
                n.g(fileInputStream);
            } catch (FileNotFoundException e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                n.g(fileInputStream2);
                return bVar;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                n.g(fileInputStream2);
                throw th;
            }
            return bVar;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [337=8, 338=7] */
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
                                aVar.iyy = arrayList;
                                aVar.iyz = optInt == 1;
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
    public static void r(String str, String str2, String str3, String str4) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str3) && !StringUtils.isNull(str4)) {
            if (StringUtils.isNull(str2)) {
                str2 = "0.0.0";
            }
            Util.VersionCompare J = Util.J(str2, str3);
            if (J != Util.VersionCompare.EQUAL && J != Util.VersionCompare.GREATER) {
                new C0392c(str, str3, str4).execute(new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ceq() {
        m.A(new File(cQe + "bdtbWCacheTemp"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.quickWebView.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0392c extends BdAsyncTask {
        private final String mMd5;
        private x mNetWork;
        private final String mUrl;
        private final String mVersion;

        public C0392c(String str, String str2, String str3) {
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
            String h;
            c.ceq();
            this.mNetWork = new x();
            this.mNetWork.setUrl(this.mUrl);
            new File(c.cQe + "bdtbWCacheTemp").mkdirs();
            String str2 = c.cQe + "bdtbWCacheTemp/bdtbWCache.zip";
            if (this.mNetWork.a(str2, null, 0, 3, 0, true)) {
                TiebaStatic.log(new am("c13435").bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_type", "1"));
                try {
                    fileInputStream = new FileInputStream(str2);
                    try {
                        try {
                            h = s.h(fileInputStream);
                        } catch (FileNotFoundException e) {
                            e = e;
                            e.printStackTrace();
                            n.g(fileInputStream);
                            str = c.cQe + "bdtbWCacheTemp/" + this.mVersion;
                            if (r.bK(str2, str)) {
                            }
                            c.ceq();
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        n.g(fileInputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    n.g(fileInputStream);
                    throw th;
                }
                if (StringUtils.isNull(h) || !h.toLowerCase().equals(this.mMd5.toLowerCase())) {
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "md5 error", new Object[0]);
                    c.ceq();
                    n.g(fileInputStream);
                    return null;
                }
                n.g(fileInputStream);
                str = c.cQe + "bdtbWCacheTemp/" + this.mVersion;
                if (r.bK(str2, str)) {
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "unzip error", new Object[0]);
                } else if (!m.q(str, c.cQe + "bdtbWCache/" + this.mVersion, true)) {
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "write error", new Object[0]);
                }
            } else {
                TiebaStatic.log(new am("c13435").bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_type", "2"));
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "download error", new Object[0]);
            }
            c.ceq();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void CK(String str) {
        String[] list;
        if (!TextUtils.isEmpty(str)) {
            String str2 = cQe + "bdtbWCache";
            File file = new File(str2);
            if (file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0) {
                for (String str3 : list) {
                    if (!StringUtils.isNull(str3) && !str3.equals(str)) {
                        m.A(new File(str2 + "/" + str3));
                    }
                }
            }
        }
    }

    private static String dV(String str, String str2) {
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
