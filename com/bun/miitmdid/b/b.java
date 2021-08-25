package com.bun.miitmdid.b;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f63767j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f63768a;

    /* renamed from: b  reason: collision with root package name */
    public Context f63769b;

    /* renamed from: c  reason: collision with root package name */
    public a f63770c;

    /* renamed from: d  reason: collision with root package name */
    public Object f63771d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f63772e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f63773f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f63774g;

    /* renamed from: h  reason: collision with root package name */
    public String f63775h;

    /* renamed from: i  reason: collision with root package name */
    public AsyncTask f63776i;

    /* loaded from: classes9.dex */
    public interface a {
        void a(Exception exc, int i2, String str);
    }

    /* renamed from: com.bun.miitmdid.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1870b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f63779a;

        /* renamed from: b  reason: collision with root package name */
        public String f63780b;

        /* renamed from: c  reason: collision with root package name */
        public int f63781c;

        /* renamed from: d  reason: collision with root package name */
        public Exception f63782d;

        public C1870b(b bVar, String str, Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, exc, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63779a = bVar;
            this.f63780b = str;
            this.f63782d = exc;
            this.f63781c = i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2135557746, "Lcom/bun/miitmdid/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2135557746, "Lcom/bun/miitmdid/b/b;");
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f63768a = null;
        this.f63769b = null;
        this.f63770c = null;
        this.f63771d = null;
        this.f63772e = new HashMap();
        this.f63773f = new HashMap();
        this.f63774g = new HashMap();
        this.f63775h = "GET";
        this.f63769b = context;
    }

    public static b a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new b(context) : (b) invokeL.objValue;
    }

    private void a(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(10000);
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (this.f63768a != null) {
                StringBuilder sb = new StringBuilder("");
                try {
                    if (this.f63768a.trim().endsWith("?")) {
                        sb.append("&");
                    } else {
                        sb.append("?");
                    }
                    for (String str : this.f63774g.keySet()) {
                        if (!str.isEmpty()) {
                            sb.append(str.trim());
                            sb.append("=");
                            sb.append(URLEncoder.encode(this.f63774g.get(str), "UTF-8"));
                            sb.append("&");
                        }
                    }
                } catch (Exception unused) {
                }
                String substring = sb.toString().contains("&") ? sb.substring(0, sb.lastIndexOf("&")) : sb.toString();
                return this.f63768a + substring;
            }
            throw new NullPointerException("URL IS NULL");
        }
        return (String) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            com.bun.miitmdid.utils.a.a(b.class.getSimpleName(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C1870b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65544, this)) != null) {
            return (C1870b) invokeV.objValue;
        }
        try {
            String b2 = b();
            if (f63767j) {
                b("Making Get url call to " + b2);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b2).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            for (String str : this.f63772e.keySet()) {
                if (!str.isEmpty()) {
                    httpURLConnection.setRequestProperty(str, this.f63772e.get(str));
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            PrintStream printStream = System.out;
            printStream.println("\nSending 'GET' request to URL : " + this.f63768a);
            PrintStream printStream2 = System.out;
            printStream2.println("Response Code : " + responseCode);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return new C1870b(this, sb.toString(), null, responseCode);
                }
                sb.append(readLine);
            }
        } catch (Exception e2) {
            if (f63767j) {
                e2.printStackTrace();
            }
            return new C1870b(this, null, e2, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C1870b d() {
        InterceptResult invokeV;
        String obj;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65547, this)) != null) {
            return (C1870b) invokeV.objValue;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b()).openConnection();
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", com.bun.miitmdid.b.a.a());
            httpURLConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            StringBuilder sb = new StringBuilder("");
            if (!this.f63773f.isEmpty()) {
                for (String str : this.f63773f.keySet()) {
                    sb.append(str);
                    sb.append("=");
                    sb.append(URLEncoder.encode(this.f63773f.get(str), "UTF-8"));
                    sb.append("&");
                }
            } else if (this.f63771d != null) {
                if (!(this.f63771d instanceof JSONObject) && !(this.f63771d instanceof JSONArray)) {
                    if (this.f63771d instanceof String) {
                        obj = (String) this.f63771d;
                        sb.append(obj);
                    }
                }
                obj = this.f63771d.toString();
                sb.append(obj);
            }
            for (String str2 : this.f63772e.keySet()) {
                if (!str2.isEmpty()) {
                    httpURLConnection.setRequestProperty(str2, this.f63772e.get(str2));
                }
            }
            String sb2 = sb.toString();
            httpURLConnection.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes(sb2);
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            if (f63767j) {
                b("\nSending 'POST' request to URL : " + this.f63768a);
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
                    return new C1870b(this, sb4, null, responseCode);
                }
                sb3.append(readLine);
            }
        } catch (Exception e2) {
            if (f63767j) {
                e2.printStackTrace();
            }
            return new C1870b(this, null, e2, -1);
        }
    }

    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f63776i = new AsyncTask<Void, Void, C1870b>(this) { // from class: com.bun.miitmdid.b.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public b f63777a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f63778b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63778b = this;
                    this.f63777a = this.f63778b;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                /* renamed from: a */
                public C1870b doInBackground(Void... voidArr) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, voidArr)) == null) ? this.f63777a.f63775h.equalsIgnoreCase("GET") ? this.f63778b.c() : this.f63778b.d() : (C1870b) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                /* renamed from: a */
                public void onPostExecute(C1870b c1870b) {
                    a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1870b) == null) {
                        super.onPostExecute(c1870b);
                        if (this.f63778b.f63770c != null) {
                            if (c1870b == null) {
                                this.f63778b.f63770c.a(new Exception("Unknown Error"), -1, null);
                                return;
                            }
                            if (c1870b.f63782d != null) {
                                aVar = this.f63778b.f63770c;
                                e = c1870b.f63782d;
                            } else {
                                try {
                                    this.f63778b.f63770c.a(null, c1870b.f63781c, c1870b.f63780b);
                                    return;
                                } catch (Exception e2) {
                                    e = e2;
                                    aVar = this.f63778b.f63770c;
                                }
                            }
                            aVar.a(e, -1, null);
                        }
                    }
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return this;
        }
        return (b) invokeV.objValue;
    }

    public b a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            this.f63770c = aVar;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            this.f63771d = obj;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f63768a = str;
            this.f63775h = "POST";
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b a(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            this.f63774g.put(str, str2);
            return this;
        }
        return (b) invokeLL.objValue;
    }

    public b a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, map)) == null) {
            if (map != null && !map.isEmpty()) {
                this.f63774g.putAll(map);
            }
            return this;
        }
        return (b) invokeL.objValue;
    }
}
