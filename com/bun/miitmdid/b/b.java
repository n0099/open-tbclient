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
    public Context f26813b;

    /* renamed from: i  reason: collision with root package name */
    public AsyncTask f26820i;

    /* renamed from: a  reason: collision with root package name */
    public String f26812a = null;

    /* renamed from: c  reason: collision with root package name */
    public a f26814c = null;

    /* renamed from: d  reason: collision with root package name */
    public Object f26815d = null;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f26816e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f26817f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f26818g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public String f26819h = "GET";

    /* loaded from: classes5.dex */
    public interface a {
        void a(Exception exc, int i2, String str);
    }

    /* renamed from: com.bun.miitmdid.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0273b {

        /* renamed from: b  reason: collision with root package name */
        public String f26824b;

        /* renamed from: c  reason: collision with root package name */
        public int f26825c;

        /* renamed from: d  reason: collision with root package name */
        public Exception f26826d;

        public C0273b(String str, Exception exc, int i2) {
            this.f26824b = str;
            this.f26826d = exc;
            this.f26825c = i2;
        }
    }

    public b(Context context) {
        this.f26813b = null;
        this.f26813b = context;
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
        if (this.f26812a != null) {
            StringBuilder sb = new StringBuilder("");
            try {
                if (this.f26812a.trim().endsWith("?")) {
                    sb.append("&");
                } else {
                    sb.append("?");
                }
                for (String str : this.f26818g.keySet()) {
                    if (!str.isEmpty()) {
                        sb.append(str.trim());
                        sb.append("=");
                        sb.append(URLEncoder.encode(this.f26818g.get(str), "UTF-8"));
                        sb.append("&");
                    }
                }
            } catch (Exception unused) {
            }
            String substring = sb.toString().contains("&") ? sb.substring(0, sb.lastIndexOf("&")) : sb.toString();
            return this.f26812a + substring;
        }
        throw new NullPointerException("URL IS NULL");
    }

    public static void b(@NonNull String str) {
        com.bun.miitmdid.utils.a.a(b.class.getSimpleName(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0273b c() {
        try {
            String b2 = b();
            if (j) {
                b("Making Get url call to " + b2);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b2).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            for (String str : this.f26816e.keySet()) {
                if (!str.isEmpty()) {
                    httpURLConnection.setRequestProperty(str, this.f26816e.get(str));
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            PrintStream printStream = System.out;
            printStream.println("\nSending 'GET' request to URL : " + this.f26812a);
            PrintStream printStream2 = System.out;
            printStream2.println("Response Code : " + responseCode);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return new C0273b(sb.toString(), null, responseCode);
                }
                sb.append(readLine);
            }
        } catch (Exception e2) {
            if (j) {
                e2.printStackTrace();
            }
            return new C0273b(null, e2, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0273b d() {
        String obj;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b()).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            httpURLConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            StringBuilder sb = new StringBuilder("");
            if (!this.f26817f.isEmpty()) {
                for (String str : this.f26817f.keySet()) {
                    sb.append(str);
                    sb.append("=");
                    sb.append(URLEncoder.encode(this.f26817f.get(str), "UTF-8"));
                    sb.append("&");
                }
            } else if (this.f26815d != null) {
                if (!(this.f26815d instanceof JSONObject) && !(this.f26815d instanceof JSONArray)) {
                    if (this.f26815d instanceof String) {
                        obj = (String) this.f26815d;
                        sb.append(obj);
                    }
                }
                obj = this.f26815d.toString();
                sb.append(obj);
            }
            for (String str2 : this.f26816e.keySet()) {
                if (!str2.isEmpty()) {
                    httpURLConnection.setRequestProperty(str2, this.f26816e.get(str2));
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
                b("\nSending 'POST' request to URL : " + this.f26812a);
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
                    return new C0273b(sb4, null, responseCode);
                }
                sb3.append(readLine);
            }
        } catch (Exception e2) {
            if (j) {
                e2.printStackTrace();
            }
            return new C0273b(null, e2, -1);
        }
    }

    public b a() {
        this.f26820i = new AsyncTask<Void, Void, C0273b>() { // from class: com.bun.miitmdid.b.b.1

            /* renamed from: a  reason: collision with root package name */
            public b f26821a;

            {
                this.f26821a = b.this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public C0273b doInBackground(Void... voidArr) {
                return this.f26821a.f26819h.equalsIgnoreCase("GET") ? b.this.c() : b.this.d();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(C0273b c0273b) {
                a aVar;
                super.onPostExecute(c0273b);
                if (b.this.f26814c != null) {
                    if (c0273b == null) {
                        b.this.f26814c.a(new Exception("Unknown Error"), -1, null);
                        return;
                    }
                    if (c0273b.f26826d != null) {
                        aVar = b.this.f26814c;
                        e = c0273b.f26826d;
                    } else {
                        try {
                            b.this.f26814c.a(null, c0273b.f26825c, c0273b.f26824b);
                            return;
                        } catch (Exception e2) {
                            e = e2;
                            aVar = b.this.f26814c;
                        }
                    }
                    aVar.a(e, -1, null);
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    public b a(a aVar) {
        this.f26814c = aVar;
        return this;
    }

    public b a(Object obj) {
        this.f26815d = obj;
        return this;
    }

    public b a(@NonNull String str) {
        this.f26812a = str;
        this.f26819h = "POST";
        return this;
    }

    public b a(@NonNull String str, @NonNull String str2) {
        this.f26818g.put(str, str2);
        return this;
    }

    public b a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.f26818g.putAll(map);
        }
        return this;
    }
}
