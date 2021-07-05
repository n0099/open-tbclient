package com.baidu.turbonet.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@JNINamespace
/* loaded from: classes5.dex */
public class ProxyChangeListener {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f23066g = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Looper f23067a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f23068b;

    /* renamed from: c  reason: collision with root package name */
    public long f23069c;

    /* renamed from: d  reason: collision with root package name */
    public Context f23070d;

    /* renamed from: e  reason: collision with root package name */
    public c f23071e;

    /* renamed from: f  reason: collision with root package name */
    public Delegate f23072f;

    /* loaded from: classes5.dex */
    public interface Delegate {
        void a();
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f23073a;

        /* renamed from: b  reason: collision with root package name */
        public final int f23074b;

        /* renamed from: c  reason: collision with root package name */
        public final String f23075c;

        /* renamed from: d  reason: collision with root package name */
        public final String[] f23076d;

        public b(String str, int i2, String str2, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2, strArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23073a = str;
            this.f23074b = i2;
            this.f23075c = str2;
            this.f23076d = strArr;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ProxyChangeListener this$0;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Intent f23077e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f23078f;

            public a(c cVar, Intent intent) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, intent};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23078f = cVar;
                this.f23077e = intent;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.f23078f;
                    cVar.this$0.e(cVar, cVar.extractNewProxy(this.f23077e));
                }
            }
        }

        public c(ProxyChangeListener proxyChangeListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {proxyChangeListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = proxyChangeListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b extractNewProxy(Intent intent) {
            InterceptResult invokeL;
            String str;
            String str2;
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, intent)) == null) {
                try {
                    if (Build.VERSION.SDK_INT < 21) {
                        str = "android.net.ProxyProperties";
                        str2 = IMTrack.AckBuilder.PROXY_TYPE;
                    } else {
                        str = "android.net.ProxyInfo";
                        str2 = "android.intent.extra.PROXY_INFO";
                    }
                    Object obj = intent.getExtras().get(str2);
                    if (obj == null) {
                        return null;
                    }
                    Class<?> cls = Class.forName(str);
                    Method declaredMethod = cls.getDeclaredMethod("getHost", new Class[0]);
                    Method declaredMethod2 = cls.getDeclaredMethod("getPort", new Class[0]);
                    Method declaredMethod3 = cls.getDeclaredMethod("getExclusionList", new Class[0]);
                    String str3 = (String) declaredMethod.invoke(obj, new Object[0]);
                    int intValue = ((Integer) declaredMethod2.invoke(obj, new Object[0])).intValue();
                    if (Build.VERSION.SDK_INT < 21) {
                        strArr = ((String) declaredMethod3.invoke(obj, new Object[0])).split(",");
                    } else {
                        strArr = (String[]) declaredMethod3.invoke(obj, new Object[0]);
                    }
                    if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                        String str4 = (String) cls.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(obj, new Object[0]);
                        if (!TextUtils.isEmpty(str4)) {
                            return new b(str3, intValue, str4, strArr);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        Uri uri = (Uri) cls.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(obj, new Object[0]);
                        if (!Uri.EMPTY.equals(uri)) {
                            return new b(str3, intValue, uri.toString(), strArr);
                        }
                    }
                    return new b(str3, intValue, null, strArr);
                } catch (ClassNotFoundException e2) {
                    Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e2);
                    return null;
                } catch (IllegalAccessException e3) {
                    Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e3);
                    return null;
                } catch (NoSuchMethodException e4) {
                    Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e4);
                    return null;
                } catch (NullPointerException e5) {
                    Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e5);
                    return null;
                } catch (InvocationTargetException e6) {
                    Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e6);
                    return null;
                }
            }
            return (b) invokeL.objValue;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
                this.this$0.g(new a(this, intent));
            }
        }

        public /* synthetic */ c(ProxyChangeListener proxyChangeListener, a aVar) {
            this(proxyChangeListener);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-251676355, "Lcom/baidu/turbonet/net/ProxyChangeListener;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-251676355, "Lcom/baidu/turbonet/net/ProxyChangeListener;");
        }
    }

    public ProxyChangeListener(Context context) {
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
        this.f23070d = context;
        this.f23067a = Looper.myLooper();
        this.f23068b = new Handler(this.f23067a);
    }

    @CalledByNative
    public static ProxyChangeListener create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) ? new ProxyChangeListener(context) : (ProxyChangeListener) invokeL.objValue;
    }

    @CalledByNative
    public static String getProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? System.getProperty(str) : (String) invokeL.objValue;
    }

    @NativeClassQualifiedName
    private native void nativeProxySettingsChanged(long j);

    @NativeClassQualifiedName
    private native void nativeProxySettingsChangedTo(long j, String str, int i2, String str2, String[] strArr);

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !d()) {
            throw new IllegalStateException("Must be called on ProxyChangeListener thread.");
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23067a == Looper.myLooper() : invokeV.booleanValue;
    }

    public final void e(c cVar, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, bVar) == null) && f23066g && cVar == this.f23071e) {
            Delegate delegate = this.f23072f;
            if (delegate != null) {
                delegate.a();
            }
            long j = this.f23069c;
            if (j == 0) {
                return;
            }
            if (bVar != null) {
                nativeProxySettingsChangedTo(j, bVar.f23073a, bVar.f23074b, bVar.f23075c, bVar.f23076d);
            } else {
                nativeProxySettingsChanged(j);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f23071e == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PROXY_CHANGE");
            this.f23071e = new c(this, null);
            this.f23070d.getApplicationContext().registerReceiver(this.f23071e, intentFilter);
        }
    }

    public final void g(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, runnable) == null) {
            if (d()) {
                runnable.run();
            } else {
                this.f23068b.post(runnable);
            }
        }
    }

    public final void h() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (cVar = this.f23071e) == null) {
            return;
        }
        this.f23070d.unregisterReceiver(cVar);
        this.f23071e = null;
    }

    @CalledByNative
    public void start(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            c();
            this.f23069c = j;
            f();
        }
    }

    @CalledByNative
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c();
            this.f23069c = 0L;
            h();
        }
    }
}
