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
    public Context f27568b;

    /* renamed from: i  reason: collision with root package name */
    public AsyncTask f27575i;

    /* renamed from: a  reason: collision with root package name */
    public String f27567a = null;

    /* renamed from: c  reason: collision with root package name */
    public a f27569c = null;

    /* renamed from: d  reason: collision with root package name */
    public Object f27570d = null;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f27571e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f27572f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f27573g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public String f27574h = "GET";

    /* loaded from: classes5.dex */
    public interface a {
        void a(Exception exc, int i2, String str);
    }

    /* renamed from: com.bun.miitmdid.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0286b {

        /* renamed from: b  reason: collision with root package name */
        public String f27579b;

        /* renamed from: c  reason: collision with root package name */
        public int f27580c;

        /* renamed from: d  reason: collision with root package name */
        public Exception f27581d;

        public C0286b(String str, Exception exc, int i2) {
            this.f27579b = str;
            this.f27581d = exc;
            this.f27580c = i2;
        }
    }

    public b(Context context) {
        this.f27568b = null;
        this.f27568b = context;
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
        if (this.f27567a != null) {
            StringBuilder sb = new StringBuilder("");
            try {
                if (this.f27567a.trim().endsWith("?")) {
                    sb.append("&");
                } else {
                    sb.append("?");
                }
                for (String str : this.f27573g.keySet()) {
                    if (!str.isEmpty()) {
                        sb.append(str.trim());
                        sb.append("=");
                        sb.append(URLEncoder.encode(this.f27573g.get(str), "UTF-8"));
                        sb.append("&");
                    }
                }
            } catch (Exception unused) {
            }
            String substring = sb.toString().contains("&") ? sb.substring(0, sb.lastIndexOf("&")) : sb.toString();
            return this.f27567a + substring;
        }
        throw new NullPointerException("URL IS NULL");
    }

    public static void b(@NonNull String str) {
        com.bun.miitmdid.utils.a.a(b.class.getSimpleName(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0286b c() {
        try {
            String b2 = b();
            if (j) {
                b("Making Get url call to " + b2);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b2).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            for (String str : this.f27571e.keySet()) {
                if (!str.isEmpty()) {
                    httpURLConnection.setRequestProperty(str, this.f27571e.get(str));
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            PrintStream printStream = System.out;
            printStream.println("\nSending 'GET' request to URL : " + this.f27567a);
            PrintStream printStream2 = System.out;
            printStream2.println("Response Code : " + responseCode);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return new C0286b(sb.toString(), null, responseCode);
                }
                sb.append(readLine);
            }
        } catch (Exception e2) {
            if (j) {
                e2.printStackTrace();
            }
            return new C0286b(null, e2, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0286b d() {
        String obj;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b()).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            httpURLConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            StringBuilder sb = new StringBuilder("");
            if (!this.f27572f.isEmpty()) {
                for (String str : this.f27572f.keySet()) {
                    sb.append(str);
                    sb.append("=");
                    sb.append(URLEncoder.encode(this.f27572f.get(str), "UTF-8"));
                    sb.append("&");
                }
            } else if (this.f27570d != null) {
                if (!(this.f27570d instanceof JSONObject) && !(this.f27570d instanceof JSONArray)) {
                    if (this.f27570d instanceof String) {
                        obj = (String) this.f27570d;
                        sb.append(obj);
                    }
                }
                obj = this.f27570d.toString();
                sb.append(obj);
            }
            for (String str2 : this.f27571e.keySet()) {
                if (!str2.isEmpty()) {
                    httpURLConnection.setRequestProperty(str2, this.f27571e.get(str2));
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
                b("\nSending 'POST' request to URL : " + this.f27567a);
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
                    return new C0286b(sb4, null, responseCode);
                }
                sb3.append(readLine);
            }
        } catch (Exception e2) {
            if (j) {
                e2.printStackTrace();
            }
            return new C0286b(null, e2, -1);
        }
    }

    public b a() {
        this.f27575i = new AsyncTask<Void, Void, C0286b>() { // from class: com.bun.miitmdid.b.b.1

            /* renamed from: a  reason: collision with root package name */
            public b f27576a;

            {
                this.f27576a = b.this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public C0286b doInBackground(Void... voidArr) {
                return this.f27576a.f27574h.equalsIgnoreCase("GET") ? b.this.c() : b.this.d();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(C0286b c0286b) {
                a aVar;
                super.onPostExecute(c0286b);
                if (b.this.f27569c != null) {
                    if (c0286b == null) {
                        b.this.f27569c.a(new Exception("Unknown Error"), -1, null);
                        return;
                    }
                    if (c0286b.f27581d != null) {
                        aVar = b.this.f27569c;
                        e = c0286b.f27581d;
                    } else {
                        try {
                            b.this.f27569c.a(null, c0286b.f27580c, c0286b.f27579b);
                            return;
                        } catch (Exception e2) {
                            e = e2;
                            aVar = b.this.f27569c;
                        }
                    }
                    aVar.a(e, -1, null);
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    public b a(a aVar) {
        this.f27569c = aVar;
        return this;
    }

    public b a(Object obj) {
        this.f27570d = obj;
        return this;
    }

    public b a(@NonNull String str) {
        this.f27567a = str;
        this.f27574h = "POST";
        return this;
    }

    public b a(@NonNull String str, @NonNull String str2) {
        this.f27573g.put(str, str2);
        return this;
    }

    public b a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.f27573g.putAll(map);
        }
        return this;
    }
}
