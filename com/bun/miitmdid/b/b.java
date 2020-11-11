package com.bun.miitmdid.b;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.baidu.webkit.internal.ETAG;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static boolean j = false;
    private Context b;
    private AsyncTask oHY;

    /* renamed from: a  reason: collision with root package name */
    private String f3977a = null;
    private a oHX = null;
    private Object d = null;
    private Map<String, String> e = new HashMap();
    private Map<String, String> f = new HashMap();
    private Map<String, String> g = new HashMap();
    private String h = "GET";

    /* loaded from: classes11.dex */
    public interface a {
        void a(Exception exc, int i, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bun.miitmdid.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0960b {
        private String b;
        private int c;
        private Exception oIb;

        public C0960b(String str, Exception exc, int i) {
            this.b = str;
            this.oIb = exc;
            this.c = i;
        }
    }

    private b(Context context) {
        this.b = null;
        this.b = context;
    }

    private void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(10000);
    }

    private String b() {
        if (this.f3977a == null) {
            throw new NullPointerException("URL IS NULL");
        }
        StringBuilder sb = new StringBuilder("");
        try {
            if (this.f3977a.trim().endsWith("?")) {
                sb.append(ETAG.ITEM_SEPARATOR);
            } else {
                sb.append("?");
            }
            for (String str : this.g.keySet()) {
                if (!str.isEmpty()) {
                    sb.append(str.trim());
                    sb.append(ETAG.EQUAL);
                    sb.append(URLEncoder.encode(this.g.get(str), "UTF-8"));
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
            }
        } catch (Exception e) {
        }
        return this.f3977a + (sb.toString().contains(ETAG.ITEM_SEPARATOR) ? sb.substring(0, sb.lastIndexOf(ETAG.ITEM_SEPARATOR)) : sb.toString());
    }

    private static void b(@NonNull String str) {
        com.bun.miitmdid.utils.a.a(b.class.getSimpleName(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0960b eiD() {
        try {
            String b = b();
            if (j) {
                b("Making Get url call to " + b);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            for (String str : this.e.keySet()) {
                if (!str.isEmpty()) {
                    httpURLConnection.setRequestProperty(str, this.e.get(str));
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + this.f3977a);
            System.out.println("Response Code : " + responseCode);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return new C0960b(sb.toString(), null, responseCode);
                }
                sb.append(readLine);
            }
        } catch (Exception e) {
            if (j) {
                e.printStackTrace();
            }
            return new C0960b(null, e, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0960b eiE() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b()).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            httpURLConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            StringBuilder sb = new StringBuilder("");
            if (!this.f.isEmpty()) {
                for (String str : this.f.keySet()) {
                    sb.append(str);
                    sb.append(ETAG.EQUAL);
                    sb.append(URLEncoder.encode(this.f.get(str), "UTF-8"));
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
            } else if (this.d != null) {
                if ((this.d instanceof JSONObject) || (this.d instanceof JSONArray)) {
                    sb.append(this.d.toString());
                } else if (this.d instanceof String) {
                    sb.append((String) this.d);
                }
            }
            for (String str2 : this.e.keySet()) {
                if (!str2.isEmpty()) {
                    httpURLConnection.setRequestProperty(str2, this.e.get(str2));
                }
            }
            String sb2 = sb.toString();
            httpURLConnection.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes(sb2);
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            if (j) {
                b("\nSending 'POST' request to URL : " + this.f3977a);
                b("Post parameters : " + sb2);
                b("Response Code : " + responseCode);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb3 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    String sb4 = sb3.toString();
                    b("\nPOST RESPONSE : " + sb4);
                    return new C0960b(sb4, null, responseCode);
                }
                sb3.append(readLine);
            }
        } catch (Exception e) {
            if (j) {
                e.printStackTrace();
            }
            return new C0960b(null, e, -1);
        }
    }

    public static b gQ(@NonNull Context context) {
        return new b(context);
    }

    public b G(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.g.putAll(map);
        }
        return this;
    }

    public b XK(@NonNull String str) {
        this.f3977a = str;
        this.h = "POST";
        return this;
    }

    public b a(a aVar) {
        this.oHX = aVar;
        return this;
    }

    public b aW(Object obj) {
        this.d = obj;
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bun.miitmdid.b.b$1] */
    public b eiC() {
        this.oHY = new AsyncTask<Void, Void, C0960b>() { // from class: com.bun.miitmdid.b.b.1
            b oHZ;

            {
                this.oHZ = b.this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(C0960b c0960b) {
                super.onPostExecute(c0960b);
                if (b.this.oHX != null) {
                    if (c0960b == null) {
                        b.this.oHX.a(new Exception("Unknown Error"), -1, null);
                    } else if (c0960b.oIb != null) {
                        b.this.oHX.a(c0960b.oIb, -1, null);
                    } else {
                        try {
                            b.this.oHX.a(null, c0960b.c, c0960b.b);
                        } catch (Exception e) {
                            b.this.oHX.a(e, -1, null);
                        }
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: r */
            public C0960b doInBackground(Void... voidArr) {
                return this.oHZ.h.equalsIgnoreCase("GET") ? b.this.eiD() : b.this.eiE();
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    public b gV(@NonNull String str, @NonNull String str2) {
        this.g.put(str, str2);
        return this;
    }
}
