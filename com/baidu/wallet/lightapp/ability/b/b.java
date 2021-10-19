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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.lightapp.ability.b.b$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i2);

        void a(String str);
    }

    /* renamed from: com.baidu.wallet.lightapp.ability.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1840b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f61783a;

        /* renamed from: b  reason: collision with root package name */
        public ExecutorService f61784b;

        /* renamed from: c  reason: collision with root package name */
        public a f61785c;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String> f61786d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f61787e;

        /* renamed from: f  reason: collision with root package name */
        public Context f61788f;

        /* renamed from: g  reason: collision with root package name */
        public long f61789g;

        /* renamed from: h  reason: collision with root package name */
        public Map<String, String> f61790h;

        public C1840b(b bVar, a aVar, Context context) {
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
            this.f61783a = bVar;
            this.f61787e = false;
            this.f61789g = 0L;
            this.f61785c = aVar;
            this.f61788f = context;
        }

        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65545, this) == null) {
                this.f61784b.execute(new Runnable(this) { // from class: com.baidu.wallet.lightapp.ability.b.b.b.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ C1840b f61795a;

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
                        this.f61795a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f61795a.f61787e) {
                            return;
                        }
                        Tracker.send("NetworkTomography", this.f61795a.f61786d, this.f61795a.f61790h, DomainConfig.getInstance().getNetcheckhost(new Boolean[]{Boolean.FALSE}) + "/cloan/open/log", this.f61795a.f61788f);
                        this.f61795a.a(100);
                        if (this.f61795a.f61785c != null) {
                            long uptimeMillis = 400 - (SystemClock.uptimeMillis() - this.f61795a.f61789g);
                            if (uptimeMillis < 0) {
                                uptimeMillis = 0;
                            }
                            LightappUtils.runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.lightapp.ability.b.b.b.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f61796a;

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
                                    this.f61796a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f61796a.f61795a.f61785c.a(new JSONObject(this.f61796a.f61795a.f61786d).toString());
                                        this.f61796a.f61795a.a();
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
                this.f61784b.execute(new Runnable(this) { // from class: com.baidu.wallet.lightapp.ability.b.b.b.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ C1840b f61799a;

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
                        this.f61799a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            C1840b c1840b = this.f61799a;
                            if (c1840b.f61783a.a(c1840b.f61788f)) {
                                this.f61799a.a(30);
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
                                this.f61799a.a(true, false);
                                return;
                            }
                            this.f61799a.a(false, false);
                        }
                    }
                });
            }
        }

        public void a(String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map) == null) {
                this.f61784b = Executors.newSingleThreadExecutor();
                HashMap hashMap = new HashMap(map);
                this.f61786d = hashMap;
                hashMap.put("url", str);
                c();
                a(str);
                HashMap hashMap2 = new HashMap(3);
                this.f61790h = hashMap2;
                hashMap2.put("location", String.valueOf(LocationCache.b()) + ',' + LocationCache.a());
                this.f61790h.put("locationType", String.valueOf(LocationCache.c().type()));
                this.f61790h.put("locationTime", String.valueOf(LocationCache.d()));
                b();
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f61787e = true;
                this.f61789g = 0L;
                ExecutorService executorService = this.f61784b;
                if (executorService != null) {
                    executorService.shutdownNow();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(65539, this, i2) == null) || this.f61785c == null) {
                return;
            }
            LightappUtils.runOnUiThread(new Runnable(this, i2) { // from class: com.baidu.wallet.lightapp.ability.b.b.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f61791a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ C1840b f61792b;

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
                    this.f61792b = this;
                    this.f61791a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f61792b.f61789g == 0) {
                            this.f61792b.f61789g = SystemClock.uptimeMillis();
                        }
                        this.f61792b.f61785c.a(this.f61791a);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f61785c == null) {
                return;
            }
            if (z && z2) {
                return;
            }
            this.f61787e = true;
            LightappUtils.runOnUiThread(new Runnable(this, z) { // from class: com.baidu.wallet.lightapp.ability.b.b.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f61793a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ C1840b f61794b;

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
                    this.f61794b = this;
                    this.f61793a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (!this.f61793a) {
                                jSONObject.put("isOnline", false);
                            } else {
                                jSONObject.put("isInternetConnected", false);
                            }
                            this.f61794b.f61785c.a(jSONObject.toString());
                            this.f61794b.a();
                        } catch (JSONException unused) {
                        }
                    }
                }
            });
        }

        private void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) {
                this.f61784b.execute(new Runnable(this, str) { // from class: com.baidu.wallet.lightapp.ability.b.b.b.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f61797a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ C1840b f61798b;

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
                        this.f61798b = this;
                        this.f61797a = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f61798b.f61787e) {
                            return;
                        }
                        this.f61798b.a(80);
                        InetAddress[] inetAddressArr = new InetAddress[0];
                        JSONArray jSONArray = new JSONArray();
                        try {
                            inetAddressArr = InetAddress.getAllByName(Uri.parse(this.f61797a).getHost());
                        } catch (UnknownHostException e2) {
                            jSONArray.put(e2.getMessage());
                        }
                        for (InetAddress inetAddress : inetAddressArr) {
                            jSONArray.put(inetAddress.getHostAddress());
                        }
                        this.f61798b.f61786d.put("hostAddress", jSONArray.toString());
                    }
                });
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f61800a;
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
            f61800a = new b(null);
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final HttpURLConnection f61801a;

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
            this.f61801a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.close();
                this.f61801a.disconnect();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f61800a : (b) invokeV.objValue;
    }

    public void a(String str, a aVar, Context context, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, str, aVar, context, map) == null) || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        new C1840b(this, aVar, DxmApplicationContextImpl.getApplicationContext(context)).a(str, map);
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
