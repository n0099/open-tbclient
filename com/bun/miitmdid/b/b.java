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
    public Context f27064b;
    public AsyncTask i;

    /* renamed from: a  reason: collision with root package name */
    public String f27063a = null;

    /* renamed from: c  reason: collision with root package name */
    public a f27065c = null;

    /* renamed from: d  reason: collision with root package name */
    public Object f27066d = null;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f27067e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f27068f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f27069g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public String f27070h = "GET";

    /* loaded from: classes5.dex */
    public interface a {
        void a(Exception exc, int i, String str);
    }

    /* renamed from: com.bun.miitmdid.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0289b {

        /* renamed from: b  reason: collision with root package name */
        public String f27074b;

        /* renamed from: c  reason: collision with root package name */
        public int f27075c;

        /* renamed from: d  reason: collision with root package name */
        public Exception f27076d;

        public C0289b(String str, Exception exc, int i) {
            this.f27074b = str;
            this.f27076d = exc;
            this.f27075c = i;
        }
    }

    public b(Context context) {
        this.f27064b = null;
        this.f27064b = context;
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
        if (this.f27063a != null) {
            StringBuilder sb = new StringBuilder("");
            try {
                if (this.f27063a.trim().endsWith("?")) {
                    sb.append("&");
                } else {
                    sb.append("?");
                }
                for (String str : this.f27069g.keySet()) {
                    if (!str.isEmpty()) {
                        sb.append(str.trim());
                        sb.append("=");
                        sb.append(URLEncoder.encode(this.f27069g.get(str), "UTF-8"));
                        sb.append("&");
                    }
                }
            } catch (Exception unused) {
            }
            String substring = sb.toString().contains("&") ? sb.substring(0, sb.lastIndexOf("&")) : sb.toString();
            return this.f27063a + substring;
        }
        throw new NullPointerException("URL IS NULL");
    }

    public static void b(@NonNull String str) {
        com.bun.miitmdid.utils.a.a(b.class.getSimpleName(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0289b c() {
        try {
            String b2 = b();
            if (j) {
                b("Making Get url call to " + b2);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b2).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            for (String str : this.f27067e.keySet()) {
                if (!str.isEmpty()) {
                    httpURLConnection.setRequestProperty(str, this.f27067e.get(str));
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            PrintStream printStream = System.out;
            printStream.println("\nSending 'GET' request to URL : " + this.f27063a);
            PrintStream printStream2 = System.out;
            printStream2.println("Response Code : " + responseCode);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return new C0289b(sb.toString(), null, responseCode);
                }
                sb.append(readLine);
            }
        } catch (Exception e2) {
            if (j) {
                e2.printStackTrace();
            }
            return new C0289b(null, e2, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0289b d() {
        String obj;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b()).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            httpURLConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            StringBuilder sb = new StringBuilder("");
            if (!this.f27068f.isEmpty()) {
                for (String str : this.f27068f.keySet()) {
                    sb.append(str);
                    sb.append("=");
                    sb.append(URLEncoder.encode(this.f27068f.get(str), "UTF-8"));
                    sb.append("&");
                }
            } else if (this.f27066d != null) {
                if (!(this.f27066d instanceof JSONObject) && !(this.f27066d instanceof JSONArray)) {
                    if (this.f27066d instanceof String) {
                        obj = (String) this.f27066d;
                        sb.append(obj);
                    }
                }
                obj = this.f27066d.toString();
                sb.append(obj);
            }
            for (String str2 : this.f27067e.keySet()) {
                if (!str2.isEmpty()) {
                    httpURLConnection.setRequestProperty(str2, this.f27067e.get(str2));
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
                b("\nSending 'POST' request to URL : " + this.f27063a);
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
                    return new C0289b(sb4, null, responseCode);
                }
                sb3.append(readLine);
            }
        } catch (Exception e2) {
            if (j) {
                e2.printStackTrace();
            }
            return new C0289b(null, e2, -1);
        }
    }

    public b a() {
        this.i = new AsyncTask<Void, Void, C0289b>() { // from class: com.bun.miitmdid.b.b.1

            /* renamed from: a  reason: collision with root package name */
            public b f27071a;

            {
                this.f27071a = b.this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public C0289b doInBackground(Void... voidArr) {
                return this.f27071a.f27070h.equalsIgnoreCase("GET") ? b.this.c() : b.this.d();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(C0289b c0289b) {
                a aVar;
                super.onPostExecute(c0289b);
                if (b.this.f27065c != null) {
                    if (c0289b == null) {
                        b.this.f27065c.a(new Exception("Unknown Error"), -1, null);
                        return;
                    }
                    if (c0289b.f27076d != null) {
                        aVar = b.this.f27065c;
                        e = c0289b.f27076d;
                    } else {
                        try {
                            b.this.f27065c.a(null, c0289b.f27075c, c0289b.f27074b);
                            return;
                        } catch (Exception e2) {
                            e = e2;
                            aVar = b.this.f27065c;
                        }
                    }
                    aVar.a(e, -1, null);
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    public b a(a aVar) {
        this.f27065c = aVar;
        return this;
    }

    public b a(Object obj) {
        this.f27066d = obj;
        return this;
    }

    public b a(@NonNull String str) {
        this.f27063a = str;
        this.f27070h = "POST";
        return this;
    }

    public b a(@NonNull String str, @NonNull String str2) {
        this.f27069g.put(str, str2);
        return this;
    }

    public b a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.f27069g.putAll(map);
        }
        return this;
    }
}
