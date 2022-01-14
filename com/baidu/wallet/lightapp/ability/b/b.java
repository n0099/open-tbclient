package com.baidu.wallet.lightapp.ability.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.lightapp.base.LocationCache;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.lightapp.ability.b.b$1  reason: invalid class name */
    /* loaded from: classes13.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes13.dex */
    public interface a {
        void a(int i2);

        void a(String str);
    }

    /* renamed from: com.baidu.wallet.lightapp.ability.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C1997b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* renamed from: b  reason: collision with root package name */
        public ExecutorService f51344b;

        /* renamed from: c  reason: collision with root package name */
        public a f51345c;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String> f51346d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f51347e;

        /* renamed from: f  reason: collision with root package name */
        public Context f51348f;

        /* renamed from: g  reason: collision with root package name */
        public long f51349g;

        /* renamed from: h  reason: collision with root package name */
        public Map<String, String> f51350h;

        public C1997b(b bVar, a aVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.f51347e = false;
            this.f51349g = 0L;
            this.f51345c = aVar;
            this.f51348f = context;
        }

        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65545, this) == null) {
                this.f51344b.execute(new Runnable(this) { // from class: com.baidu.wallet.lightapp.ability.b.b.b.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ C1997b a;

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
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.f51347e) {
                            return;
                        }
                        Tracker.send("NetworkTomography", this.a.f51346d, this.a.f51350h, DomainConfig.getInstance().getNetcheckhost(new Boolean[]{Boolean.FALSE}) + "/cloan/open/log", this.a.f51348f);
                        this.a.a(100);
                        if (this.a.f51345c != null) {
                            long uptimeMillis = 400 - (SystemClock.uptimeMillis() - this.a.f51349g);
                            if (uptimeMillis < 0) {
                                uptimeMillis = 0;
                            }
                            LightappUtils.runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.lightapp.ability.b.b.b.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass3 a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.a.a.f51345c.a(new JSONObject(this.a.a.f51346d).toString());
                                        this.a.a.a();
                                    }
                                }
                            }, uptimeMillis);
                        }
                    }
                });
            }
        }

        private void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65546, this) == null) {
                this.f51344b.execute(new Runnable(this) { // from class: com.baidu.wallet.lightapp.ability.b.b.b.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ C1997b a;

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
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            C1997b c1997b = this.a;
                            if (c1997b.a.a(c1997b.f51348f)) {
                                this.a.a(30);
                                try {
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://www.baidu.com/").openConnection();
                                    httpURLConnection.setConnectTimeout(1500);
                                    httpURLConnection.setReadTimeout(1500);
                                    httpURLConnection.setRequestMethod("HEAD");
                                    httpURLConnection.setUseCaches(false);
                                    z = httpURLConnection.getResponseCode() != -1;
                                    try {
                                        new d(httpURLConnection).close();
                                    } catch (MalformedURLException | ProtocolException | IOException unused) {
                                    }
                                } catch (MalformedURLException | ProtocolException | IOException unused2) {
                                    z = false;
                                }
                                if (z) {
                                    return;
                                }
                                this.a.a(true, false);
                                return;
                            }
                            this.a.a(false, false);
                        }
                    }
                });
            }
        }

        public void a(String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map) == null) {
                this.f51344b = Executors.newSingleThreadExecutor();
                HashMap hashMap = new HashMap(map);
                this.f51346d = hashMap;
                hashMap.put("url", str);
                c();
                a(str);
                HashMap hashMap2 = new HashMap(3);
                this.f51350h = hashMap2;
                hashMap2.put("location", String.valueOf(LocationCache.b()) + ',' + LocationCache.a());
                this.f51350h.put("locationType", String.valueOf(LocationCache.c().type()));
                this.f51350h.put("locationTime", String.valueOf(LocationCache.d()));
                b();
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51347e = true;
                this.f51349g = 0L;
                ExecutorService executorService = this.f51344b;
                if (executorService != null) {
                    executorService.shutdownNow();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(65539, this, i2) == null) || this.f51345c == null) {
                return;
            }
            LightappUtils.runOnUiThread(new Runnable(this, i2) { // from class: com.baidu.wallet.lightapp.ability.b.b.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ C1997b f51351b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f51351b = this;
                    this.a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f51351b.f51349g == 0) {
                            this.f51351b.f51349g = SystemClock.uptimeMillis();
                        }
                        this.f51351b.f51345c.a(this.a);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f51345c == null) {
                return;
            }
            if (z && z2) {
                return;
            }
            this.f51347e = true;
            LightappUtils.runOnUiThread(new Runnable(this, z) { // from class: com.baidu.wallet.lightapp.ability.b.b.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ C1997b f51352b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f51352b = this;
                    this.a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (!this.a) {
                                jSONObject.put("isOnline", false);
                            } else {
                                jSONObject.put("isInternetConnected", false);
                            }
                            this.f51352b.f51345c.a(jSONObject.toString());
                            this.f51352b.a();
                        } catch (JSONException unused) {
                        }
                    }
                }
            });
        }

        private void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
                this.f51344b.execute(new Runnable(this, str) { // from class: com.baidu.wallet.lightapp.ability.b.b.b.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ C1997b f51353b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f51353b = this;
                        this.a = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f51353b.f51347e) {
                            return;
                        }
                        this.f51353b.a(80);
                        InetAddress[] inetAddressArr = new InetAddress[0];
                        JSONArray jSONArray = new JSONArray();
                        try {
                            inetAddressArr = InetAddress.getAllByName(Uri.parse(this.a).getHost());
                        } catch (UnknownHostException e2) {
                            jSONArray.put(e2.getMessage());
                        }
                        for (InetAddress inetAddress : inetAddressArr) {
                            jSONArray.put(inetAddress.getHostAddress());
                        }
                        this.f51353b.f51346d.put("hostAddress", jSONArray.toString());
                    }
                });
            }
        }
    }

    /* loaded from: classes13.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1893978744, "Lcom/baidu/wallet/lightapp/ability/b/b$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1893978744, "Lcom/baidu/wallet/lightapp/ability/b/b$c;");
                    return;
                }
            }
            a = new b(null);
        }
    }

    /* loaded from: classes13.dex */
    public static class d extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final HttpURLConnection a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(HttpURLConnection httpURLConnection) {
            super(b.b(httpURLConnection));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpURLConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.close();
                this.a.disconnect();
            }
        }
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static InputStream b(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, httpURLConnection)) == null) {
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (IOException unused) {
                errorStream = httpURLConnection.getErrorStream();
            }
            return errorStream == null ? new ByteArrayInputStream("Error! No input stream that reads from this open connection.".getBytes()) : errorStream;
        }
        return (InputStream) invokeL.objValue;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a : (b) invokeV.objValue;
    }

    public void a(String str, a aVar, Context context, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, str, aVar, context, map) == null) || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        new C1997b(this, aVar, DxmApplicationContextImpl.getApplicationContext(context)).a(str, map);
    }

    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return invokeL.booleanValue;
    }
}
