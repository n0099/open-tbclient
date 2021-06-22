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
    public Context f26927b;

    /* renamed from: i  reason: collision with root package name */
    public AsyncTask f26934i;

    /* renamed from: a  reason: collision with root package name */
    public String f26926a = null;

    /* renamed from: c  reason: collision with root package name */
    public a f26928c = null;

    /* renamed from: d  reason: collision with root package name */
    public Object f26929d = null;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f26930e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f26931f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f26932g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public String f26933h = "GET";

    /* loaded from: classes6.dex */
    public interface a {
        void a(Exception exc, int i2, String str);
    }

    /* renamed from: com.bun.miitmdid.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0279b {

        /* renamed from: b  reason: collision with root package name */
        public String f26938b;

        /* renamed from: c  reason: collision with root package name */
        public int f26939c;

        /* renamed from: d  reason: collision with root package name */
        public Exception f26940d;

        public C0279b(String str, Exception exc, int i2) {
            this.f26938b = str;
            this.f26940d = exc;
            this.f26939c = i2;
        }
    }

    public b(Context context) {
        this.f26927b = null;
        this.f26927b = context;
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
        if (this.f26926a != null) {
            StringBuilder sb = new StringBuilder("");
            try {
                if (this.f26926a.trim().endsWith("?")) {
                    sb.append("&");
                } else {
                    sb.append("?");
                }
                for (String str : this.f26932g.keySet()) {
                    if (!str.isEmpty()) {
                        sb.append(str.trim());
                        sb.append("=");
                        sb.append(URLEncoder.encode(this.f26932g.get(str), "UTF-8"));
                        sb.append("&");
                    }
                }
            } catch (Exception unused) {
            }
            String substring = sb.toString().contains("&") ? sb.substring(0, sb.lastIndexOf("&")) : sb.toString();
            return this.f26926a + substring;
        }
        throw new NullPointerException("URL IS NULL");
    }

    public static void b(@NonNull String str) {
        com.bun.miitmdid.utils.a.a(b.class.getSimpleName(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0279b c() {
        try {
            String b2 = b();
            if (j) {
                b("Making Get url call to " + b2);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b2).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            for (String str : this.f26930e.keySet()) {
                if (!str.isEmpty()) {
                    httpURLConnection.setRequestProperty(str, this.f26930e.get(str));
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            PrintStream printStream = System.out;
            printStream.println("\nSending 'GET' request to URL : " + this.f26926a);
            PrintStream printStream2 = System.out;
            printStream2.println("Response Code : " + responseCode);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return new C0279b(sb.toString(), null, responseCode);
                }
                sb.append(readLine);
            }
        } catch (Exception e2) {
            if (j) {
                e2.printStackTrace();
            }
            return new C0279b(null, e2, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0279b d() {
        String obj;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b()).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            httpURLConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            StringBuilder sb = new StringBuilder("");
            if (!this.f26931f.isEmpty()) {
                for (String str : this.f26931f.keySet()) {
                    sb.append(str);
                    sb.append("=");
                    sb.append(URLEncoder.encode(this.f26931f.get(str), "UTF-8"));
                    sb.append("&");
                }
            } else if (this.f26929d != null) {
                if (!(this.f26929d instanceof JSONObject) && !(this.f26929d instanceof JSONArray)) {
                    if (this.f26929d instanceof String) {
                        obj = (String) this.f26929d;
                        sb.append(obj);
                    }
                }
                obj = this.f26929d.toString();
                sb.append(obj);
            }
            for (String str2 : this.f26930e.keySet()) {
                if (!str2.isEmpty()) {
                    httpURLConnection.setRequestProperty(str2, this.f26930e.get(str2));
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
                b("\nSending 'POST' request to URL : " + this.f26926a);
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
                    return new C0279b(sb4, null, responseCode);
                }
                sb3.append(readLine);
            }
        } catch (Exception e2) {
            if (j) {
                e2.printStackTrace();
            }
            return new C0279b(null, e2, -1);
        }
    }

    public b a() {
        this.f26934i = new AsyncTask<Void, Void, C0279b>() { // from class: com.bun.miitmdid.b.b.1

            /* renamed from: a  reason: collision with root package name */
            public b f26935a;

            {
                this.f26935a = b.this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public C0279b doInBackground(Void... voidArr) {
                return this.f26935a.f26933h.equalsIgnoreCase("GET") ? b.this.c() : b.this.d();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(C0279b c0279b) {
                a aVar;
                super.onPostExecute(c0279b);
                if (b.this.f26928c != null) {
                    if (c0279b == null) {
                        b.this.f26928c.a(new Exception("Unknown Error"), -1, null);
                        return;
                    }
                    if (c0279b.f26940d != null) {
                        aVar = b.this.f26928c;
                        e = c0279b.f26940d;
                    } else {
                        try {
                            b.this.f26928c.a(null, c0279b.f26939c, c0279b.f26938b);
                            return;
                        } catch (Exception e2) {
                            e = e2;
                            aVar = b.this.f26928c;
                        }
                    }
                    aVar.a(e, -1, null);
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    public b a(a aVar) {
        this.f26928c = aVar;
        return this;
    }

    public b a(Object obj) {
        this.f26929d = obj;
        return this;
    }

    public b a(@NonNull String str) {
        this.f26926a = str;
        this.f26933h = "POST";
        return this;
    }

    public b a(@NonNull String str, @NonNull String str2) {
        this.f26932g.put(str, str2);
        return this;
    }

    public b a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.f26932g.putAll(map);
        }
        return this;
    }
}
