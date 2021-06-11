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
/* loaded from: classes6.dex */
public class b {
    public static boolean j = false;

    /* renamed from: b  reason: collision with root package name */
    public Context f26845b;

    /* renamed from: i  reason: collision with root package name */
    public AsyncTask f26852i;

    /* renamed from: a  reason: collision with root package name */
    public String f26844a = null;

    /* renamed from: c  reason: collision with root package name */
    public a f26846c = null;

    /* renamed from: d  reason: collision with root package name */
    public Object f26847d = null;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f26848e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f26849f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f26850g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public String f26851h = "GET";

    /* loaded from: classes6.dex */
    public interface a {
        void a(Exception exc, int i2, String str);
    }

    /* renamed from: com.bun.miitmdid.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0276b {

        /* renamed from: b  reason: collision with root package name */
        public String f26856b;

        /* renamed from: c  reason: collision with root package name */
        public int f26857c;

        /* renamed from: d  reason: collision with root package name */
        public Exception f26858d;

        public C0276b(String str, Exception exc, int i2) {
            this.f26856b = str;
            this.f26858d = exc;
            this.f26857c = i2;
        }
    }

    public b(Context context) {
        this.f26845b = null;
        this.f26845b = context;
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
        if (this.f26844a != null) {
            StringBuilder sb = new StringBuilder("");
            try {
                if (this.f26844a.trim().endsWith("?")) {
                    sb.append("&");
                } else {
                    sb.append("?");
                }
                for (String str : this.f26850g.keySet()) {
                    if (!str.isEmpty()) {
                        sb.append(str.trim());
                        sb.append("=");
                        sb.append(URLEncoder.encode(this.f26850g.get(str), "UTF-8"));
                        sb.append("&");
                    }
                }
            } catch (Exception unused) {
            }
            String substring = sb.toString().contains("&") ? sb.substring(0, sb.lastIndexOf("&")) : sb.toString();
            return this.f26844a + substring;
        }
        throw new NullPointerException("URL IS NULL");
    }

    public static void b(@NonNull String str) {
        com.bun.miitmdid.utils.a.a(b.class.getSimpleName(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0276b c() {
        try {
            String b2 = b();
            if (j) {
                b("Making Get url call to " + b2);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b2).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            for (String str : this.f26848e.keySet()) {
                if (!str.isEmpty()) {
                    httpURLConnection.setRequestProperty(str, this.f26848e.get(str));
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            PrintStream printStream = System.out;
            printStream.println("\nSending 'GET' request to URL : " + this.f26844a);
            PrintStream printStream2 = System.out;
            printStream2.println("Response Code : " + responseCode);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return new C0276b(sb.toString(), null, responseCode);
                }
                sb.append(readLine);
            }
        } catch (Exception e2) {
            if (j) {
                e2.printStackTrace();
            }
            return new C0276b(null, e2, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0276b d() {
        String obj;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b()).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            httpURLConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            StringBuilder sb = new StringBuilder("");
            if (!this.f26849f.isEmpty()) {
                for (String str : this.f26849f.keySet()) {
                    sb.append(str);
                    sb.append("=");
                    sb.append(URLEncoder.encode(this.f26849f.get(str), "UTF-8"));
                    sb.append("&");
                }
            } else if (this.f26847d != null) {
                if (!(this.f26847d instanceof JSONObject) && !(this.f26847d instanceof JSONArray)) {
                    if (this.f26847d instanceof String) {
                        obj = (String) this.f26847d;
                        sb.append(obj);
                    }
                }
                obj = this.f26847d.toString();
                sb.append(obj);
            }
            for (String str2 : this.f26848e.keySet()) {
                if (!str2.isEmpty()) {
                    httpURLConnection.setRequestProperty(str2, this.f26848e.get(str2));
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
                b("\nSending 'POST' request to URL : " + this.f26844a);
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
                    return new C0276b(sb4, null, responseCode);
                }
                sb3.append(readLine);
            }
        } catch (Exception e2) {
            if (j) {
                e2.printStackTrace();
            }
            return new C0276b(null, e2, -1);
        }
    }

    public b a() {
        this.f26852i = new AsyncTask<Void, Void, C0276b>() { // from class: com.bun.miitmdid.b.b.1

            /* renamed from: a  reason: collision with root package name */
            public b f26853a;

            {
                this.f26853a = b.this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public C0276b doInBackground(Void... voidArr) {
                return this.f26853a.f26851h.equalsIgnoreCase("GET") ? b.this.c() : b.this.d();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(C0276b c0276b) {
                a aVar;
                super.onPostExecute(c0276b);
                if (b.this.f26846c != null) {
                    if (c0276b == null) {
                        b.this.f26846c.a(new Exception("Unknown Error"), -1, null);
                        return;
                    }
                    if (c0276b.f26858d != null) {
                        aVar = b.this.f26846c;
                        e = c0276b.f26858d;
                    } else {
                        try {
                            b.this.f26846c.a(null, c0276b.f26857c, c0276b.f26856b);
                            return;
                        } catch (Exception e2) {
                            e = e2;
                            aVar = b.this.f26846c;
                        }
                    }
                    aVar.a(e, -1, null);
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    public b a(a aVar) {
        this.f26846c = aVar;
        return this;
    }

    public b a(Object obj) {
        this.f26847d = obj;
        return this;
    }

    public b a(@NonNull String str) {
        this.f26844a = str;
        this.f26851h = "POST";
        return this;
    }

    public b a(@NonNull String str, @NonNull String str2) {
        this.f26850g.put(str, str2);
        return this;
    }

    public b a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.f26850g.putAll(map);
        }
        return this;
    }
}
