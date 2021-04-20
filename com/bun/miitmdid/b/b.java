package com.bun.miitmdid.b;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    public static boolean j = false;

    /* renamed from: b  reason: collision with root package name */
    public Context f26749b;
    public AsyncTask i;

    /* renamed from: a  reason: collision with root package name */
    public String f26748a = null;

    /* renamed from: c  reason: collision with root package name */
    public a f26750c = null;

    /* renamed from: d  reason: collision with root package name */
    public Object f26751d = null;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f26752e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f26753f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f26754g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public String f26755h = "GET";

    /* loaded from: classes5.dex */
    public interface a {
        void a(Exception exc, int i, String str);
    }

    /* renamed from: com.bun.miitmdid.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0291b {

        /* renamed from: b  reason: collision with root package name */
        public String f26759b;

        /* renamed from: c  reason: collision with root package name */
        public int f26760c;

        /* renamed from: d  reason: collision with root package name */
        public Exception f26761d;

        public C0291b(String str, Exception exc, int i) {
            this.f26759b = str;
            this.f26761d = exc;
            this.f26760c = i;
        }
    }

    public b(Context context) {
        this.f26749b = null;
        this.f26749b = context;
    }

    public static b a(@NonNull Context context) {
        return new b(context);
    }

    private void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(10000);
    }

    private String b() {
        if (this.f26748a != null) {
            StringBuilder sb = new StringBuilder("");
            try {
                if (this.f26748a.trim().endsWith("?")) {
                    sb.append("&");
                } else {
                    sb.append("?");
                }
                for (String str : this.f26754g.keySet()) {
                    if (!str.isEmpty()) {
                        sb.append(str.trim());
                        sb.append("=");
                        sb.append(URLEncoder.encode(this.f26754g.get(str), "UTF-8"));
                        sb.append("&");
                    }
                }
            } catch (Exception unused) {
            }
            String substring = sb.toString().contains("&") ? sb.substring(0, sb.lastIndexOf("&")) : sb.toString();
            return this.f26748a + substring;
        }
        throw new NullPointerException("URL IS NULL");
    }

    public static void b(@NonNull String str) {
        com.bun.miitmdid.utils.a.a(b.class.getSimpleName(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0291b c() {
        try {
            String b2 = b();
            if (j) {
                b("Making Get url call to " + b2);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b2).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            for (String str : this.f26752e.keySet()) {
                if (!str.isEmpty()) {
                    httpURLConnection.setRequestProperty(str, this.f26752e.get(str));
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            PrintStream printStream = System.out;
            printStream.println("\nSending 'GET' request to URL : " + this.f26748a);
            PrintStream printStream2 = System.out;
            printStream2.println("Response Code : " + responseCode);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return new C0291b(sb.toString(), null, responseCode);
                }
                sb.append(readLine);
            }
        } catch (Exception e2) {
            if (j) {
                e2.printStackTrace();
            }
            return new C0291b(null, e2, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0291b d() {
        String obj;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b()).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            httpURLConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            StringBuilder sb = new StringBuilder("");
            if (!this.f26753f.isEmpty()) {
                for (String str : this.f26753f.keySet()) {
                    sb.append(str);
                    sb.append("=");
                    sb.append(URLEncoder.encode(this.f26753f.get(str), "UTF-8"));
                    sb.append("&");
                }
            } else if (this.f26751d != null) {
                if (!(this.f26751d instanceof JSONObject) && !(this.f26751d instanceof JSONArray)) {
                    if (this.f26751d instanceof String) {
                        obj = (String) this.f26751d;
                        sb.append(obj);
                    }
                }
                obj = this.f26751d.toString();
                sb.append(obj);
            }
            for (String str2 : this.f26752e.keySet()) {
                if (!str2.isEmpty()) {
                    httpURLConnection.setRequestProperty(str2, this.f26752e.get(str2));
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
                b("\nSending 'POST' request to URL : " + this.f26748a);
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
                    return new C0291b(sb4, null, responseCode);
                }
                sb3.append(readLine);
            }
        } catch (Exception e2) {
            if (j) {
                e2.printStackTrace();
            }
            return new C0291b(null, e2, -1);
        }
    }

    public b a() {
        this.i = new AsyncTask<Void, Void, C0291b>() { // from class: com.bun.miitmdid.b.b.1

            /* renamed from: a  reason: collision with root package name */
            public b f26756a;

            {
                this.f26756a = b.this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public C0291b doInBackground(Void... voidArr) {
                return this.f26756a.f26755h.equalsIgnoreCase("GET") ? b.this.c() : b.this.d();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(C0291b c0291b) {
                a aVar;
                super.onPostExecute(c0291b);
                if (b.this.f26750c != null) {
                    if (c0291b == null) {
                        b.this.f26750c.a(new Exception("Unknown Error"), -1, null);
                        return;
                    }
                    if (c0291b.f26761d != null) {
                        aVar = b.this.f26750c;
                        e = c0291b.f26761d;
                    } else {
                        try {
                            b.this.f26750c.a(null, c0291b.f26760c, c0291b.f26759b);
                            return;
                        } catch (Exception e2) {
                            e = e2;
                            aVar = b.this.f26750c;
                        }
                    }
                    aVar.a(e, -1, null);
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    public b a(a aVar) {
        this.f26750c = aVar;
        return this;
    }

    public b a(Object obj) {
        this.f26751d = obj;
        return this;
    }

    public b a(@NonNull String str) {
        this.f26748a = str;
        this.f26755h = "POST";
        return this;
    }

    public b a(@NonNull String str, @NonNull String str2) {
        this.f26754g.put(str, str2);
        return this;
    }

    public b a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.f26754g.putAll(map);
        }
        return this;
    }
}
