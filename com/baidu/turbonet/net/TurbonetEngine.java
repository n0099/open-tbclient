package com.baidu.turbonet.net;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.cons.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.UrlRequest;
import d.a.q0.b.c;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class TurbonetEngine {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class AppState {
        public static final /* synthetic */ AppState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AppState APP_STATE_BACKGROUND;
        public static final AppState APP_STATE_FOREGROUND;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-642008196, "Lcom/baidu/turbonet/net/TurbonetEngine$AppState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-642008196, "Lcom/baidu/turbonet/net/TurbonetEngine$AppState;");
                    return;
                }
            }
            APP_STATE_BACKGROUND = new AppState("APP_STATE_BACKGROUND", 0);
            AppState appState = new AppState("APP_STATE_FOREGROUND", 1);
            APP_STATE_FOREGROUND = appState;
            $VALUES = new AppState[]{APP_STATE_BACKGROUND, appState};
        }

        public AppState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static AppState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AppState) Enum.valueOf(AppState.class, str) : (AppState) invokeL.objValue;
        }

        public static AppState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AppState[]) $VALUES.clone() : (AppState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f23222a;

        /* renamed from: b  reason: collision with root package name */
        public LibraryLoader f23223b;

        /* renamed from: c  reason: collision with root package name */
        public String f23224c;

        /* renamed from: d  reason: collision with root package name */
        public String f23225d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f23226e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f23227f;

        /* renamed from: g  reason: collision with root package name */
        public String f23228g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f23229h;

        /* renamed from: i  reason: collision with root package name */
        public int f23230i;
        public long j;
        public String k;
        public boolean l;
        public JSONObject m;
        public String n;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes4.dex */
        public @interface HttpCacheSetting {
        }

        /* loaded from: classes4.dex */
        public static abstract class LibraryLoader {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public LibraryLoader() {
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

            public abstract void a(String str);
        }

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23222a = context;
            t("turbonet");
            this.m = new JSONObject();
            d(false);
        }

        public Builder a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.n = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public TurbonetEngine b() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    str = Environment.getExternalStorageDirectory().getPath();
                } else {
                    Log.e("chromium", "SD card is not mounted correctly");
                    str = "";
                }
                s(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
                if (j() == null) {
                    v(c.a(this.f23222a));
                }
                return TurbonetEngine.c(this);
            }
            return (TurbonetEngine) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23229h : invokeV.booleanValue;
        }

        public Builder d(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                s(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
                this.f23226e = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder e(boolean z, String str) {
            InterceptResult invokeZL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZL = interceptable.invokeZL(1048580, this, z, str)) == null) {
                s("nq", "network_quality_enabled", Boolean.valueOf(z));
                s("nq", "watched_groups", str);
                this.l = z;
                return this;
            }
            return (Builder) invokeZL.objValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : (String) invokeV.objValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n : (String) invokeV.objValue;
        }

        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m.toString() : (String) invokeV.objValue;
        }

        public Context i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f23222a : (Context) invokeV.objValue;
        }

        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f23225d : (String) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f23226e : invokeV.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : invokeV.longValue;
        }

        public int m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f23230i : invokeV.intValue;
        }

        public void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                LibraryLoader libraryLoader = this.f23223b;
                if (libraryLoader == null) {
                    if (this.f23224c.equals("turbonet")) {
                        System.loadLibrary(this.f23224c);
                        return;
                    } else {
                        System.load(this.f23224c);
                        return;
                    }
                }
                libraryLoader.a(this.f23224c);
            }
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.l : invokeV.booleanValue;
        }

        public boolean p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f23227f : invokeV.booleanValue;
        }

        public Builder q(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
                s("app", "cuid", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder r(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                s("app", "app_name", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void s(String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048594, this, str, str2, obj) == null) {
                try {
                    JSONObject optJSONObject = this.m.optJSONObject(str);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    optJSONObject.put(str2, obj);
                    this.m.put(str, optJSONObject);
                } catch (JSONException e2) {
                    throw new IllegalStateException("JSON expcetion:", e2);
                }
            }
        }

        public Builder t(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
                this.f23224c = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder u(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                if (new File(str).isDirectory()) {
                    this.f23228g = str;
                    return this;
                }
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder v(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
                s(SchemeCollecter.CLASSIFY_BASE, b.f1842b, str);
                this.f23225d = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public String w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f23228g : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class QUICConnectStatus {
        public static final /* synthetic */ QUICConnectStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final QUICConnectStatus REACHABLE;
        public static final QUICConnectStatus UNKNOWN;
        public static final QUICConnectStatus UNREACHABLE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-94012692, "Lcom/baidu/turbonet/net/TurbonetEngine$QUICConnectStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-94012692, "Lcom/baidu/turbonet/net/TurbonetEngine$QUICConnectStatus;");
                    return;
                }
            }
            UNKNOWN = new QUICConnectStatus(RomUtils.UNKNOWN, 0);
            REACHABLE = new QUICConnectStatus("REACHABLE", 1);
            QUICConnectStatus qUICConnectStatus = new QUICConnectStatus("UNREACHABLE", 2);
            UNREACHABLE = qUICConnectStatus;
            $VALUES = new QUICConnectStatus[]{UNKNOWN, REACHABLE, qUICConnectStatus};
        }

        public QUICConnectStatus(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static QUICConnectStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (QUICConnectStatus) Enum.valueOf(QUICConnectStatus.class, str) : (QUICConnectStatus) invokeL.objValue;
        }

        public static QUICConnectStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (QUICConnectStatus[]) $VALUES.clone() : (QUICConnectStatus[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface RequestFinishedListener {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class TCPNetworkQualityStatus {
        public static final /* synthetic */ TCPNetworkQualityStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TCPNetworkQualityStatus NORMAL;
        public static final TCPNetworkQualityStatus UNKNOWN;
        public static final TCPNetworkQualityStatus WEAK;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1298957478, "Lcom/baidu/turbonet/net/TurbonetEngine$TCPNetworkQualityStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1298957478, "Lcom/baidu/turbonet/net/TurbonetEngine$TCPNetworkQualityStatus;");
                    return;
                }
            }
            UNKNOWN = new TCPNetworkQualityStatus(RomUtils.UNKNOWN, 0);
            WEAK = new TCPNetworkQualityStatus("WEAK", 1);
            TCPNetworkQualityStatus tCPNetworkQualityStatus = new TCPNetworkQualityStatus("NORMAL", 2);
            NORMAL = tCPNetworkQualityStatus;
            $VALUES = new TCPNetworkQualityStatus[]{UNKNOWN, WEAK, tCPNetworkQualityStatus};
        }

        public TCPNetworkQualityStatus(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static TCPNetworkQualityStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TCPNetworkQualityStatus) Enum.valueOf(TCPNetworkQualityStatus.class, str) : (TCPNetworkQualityStatus) invokeL.objValue;
        }

        public static TCPNetworkQualityStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TCPNetworkQualityStatus[]) $VALUES.clone() : (TCPNetworkQualityStatus[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class UrlRequestInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class UrlRequestMetrics {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public TurbonetEngine() {
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

    public static TurbonetEngine c(Builder builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, builder)) == null) {
            try {
                TurbonetEngine turbonetEngine = (TurbonetEngine) TurbonetEngine.class.getClassLoader().loadClass("com.baidu.turbonet.net.CronetUrlRequestContext").asSubclass(TurbonetEngine.class).getConstructor(Builder.class).newInstance(builder);
                if (turbonetEngine.e()) {
                    return turbonetEngine;
                }
                return null;
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("ClassNotFoundException: com.baidu.turbonet.net.CronetUrlRequestContext", e2);
            } catch (Exception e3) {
                throw new IllegalStateException("Cannot instantiate: com.baidu.turbonet.net.CronetUrlRequestContext", e3);
            }
        }
        return (TurbonetEngine) invokeL.objValue;
    }

    public abstract UrlRequest b(String str, UrlRequest.Callback callback, Executor executor, int i2, Collection<Object> collection, boolean z, boolean z2, boolean z3);

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    public abstract boolean e();

    public abstract boolean f();

    public abstract void g(String str, String str2, int i2, int i3, long j, long j2, long j3, long j4);
}
