package com.baidu.turbonet.net;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tieba.yn9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.UrlRequest;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class TurbonetEngine {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface RequestFinishedListener {
    }

    /* loaded from: classes7.dex */
    public static final class UrlRequestInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class UrlRequestMetrics {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public abstract UrlRequest b(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3);

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

    public abstract void g(String str, String str2, int i, int i2, long j, long j2, long j3, long j4);

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public LibraryLoader b;
        public String c;
        public String d;
        public boolean e;
        public boolean f;
        public String g;
        public boolean h;
        public int i;
        public long j;
        public String k;
        public boolean l;
        public JSONObject m;
        public String n;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes7.dex */
        public @interface HttpCacheSetting {
        }

        /* loaded from: classes7.dex */
        public static abstract class LibraryLoader {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public abstract void a(String str);

            public LibraryLoader() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            s("turbonet");
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

        public Builder d(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                r(SchemeCollecter.CLASSIFY_BASE, "http2_enabled", Boolean.valueOf(z));
                this.e = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder p(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
                r("app", "cuid", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder q(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                r("app", "app_name", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
                this.c = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder t(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                if (new File(str).isDirectory()) {
                    this.g = str;
                    return this;
                }
                throw new IllegalArgumentException("Storage path must be set to existing directory");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder u(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
                r(SchemeCollecter.CLASSIFY_BASE, "user_agent", str);
                this.d = str;
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
                r(SchemeCollecter.CLASSIFY_BASE, "config_path", str);
                if (i() == null) {
                    u(yn9.a(this.a));
                }
                return TurbonetEngine.c(this);
            }
            return (TurbonetEngine) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.h;
            }
            return invokeV.booleanValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.k;
            }
            return (String) invokeV.objValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.n;
            }
            return (String) invokeV.objValue;
        }

        public Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.a;
            }
            return (Context) invokeV.objValue;
        }

        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.m.toString();
            }
            return (String) invokeV.objValue;
        }

        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.e;
            }
            return invokeV.booleanValue;
        }

        public long k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.j;
            }
            return invokeV.longValue;
        }

        public int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.i;
            }
            return invokeV.intValue;
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                LibraryLoader libraryLoader = this.b;
                if (libraryLoader == null) {
                    if (this.c.equals("turbonet")) {
                        System.loadLibrary(this.c);
                        return;
                    } else {
                        System.load(this.c);
                        return;
                    }
                }
                libraryLoader.a(this.c);
            }
        }

        public boolean n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.l;
            }
            return invokeV.booleanValue;
        }

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.f;
            }
            return invokeV.booleanValue;
        }

        public String v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.g;
            }
            return (String) invokeV.objValue;
        }

        public Builder e(boolean z, String str) {
            InterceptResult invokeZL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZL = interceptable.invokeZL(1048580, this, z, str)) == null) {
                r("nq", "network_quality_enabled", Boolean.valueOf(z));
                r("nq", "watched_groups", str);
                this.l = z;
                return this;
            }
            return (Builder) invokeZL.objValue;
        }

        public final void r(String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048594, this, str, str2, obj) == null) {
                try {
                    JSONObject optJSONObject = this.m.optJSONObject(str);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    optJSONObject.put(str2, obj);
                    this.m.put(str, optJSONObject);
                } catch (JSONException e) {
                    throw new IllegalStateException("JSON expcetion:", e);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
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

        public AppState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (AppState) Enum.valueOf(AppState.class, str);
            }
            return (AppState) invokeL.objValue;
        }

        public static AppState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (AppState[]) $VALUES.clone();
            }
            return (AppState[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
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

        public QUICConnectStatus(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (QUICConnectStatus) Enum.valueOf(QUICConnectStatus.class, str);
            }
            return (QUICConnectStatus) invokeL.objValue;
        }

        public static QUICConnectStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (QUICConnectStatus[]) $VALUES.clone();
            }
            return (QUICConnectStatus[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
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

        public TCPNetworkQualityStatus(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (TCPNetworkQualityStatus) Enum.valueOf(TCPNetworkQualityStatus.class, str);
            }
            return (TCPNetworkQualityStatus) invokeL.objValue;
        }

        public static TCPNetworkQualityStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (TCPNetworkQualityStatus[]) $VALUES.clone();
            }
            return (TCPNetworkQualityStatus[]) invokeV.objValue;
        }
    }

    public TurbonetEngine() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                if (!turbonetEngine.e()) {
                    return null;
                }
                return turbonetEngine;
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("ClassNotFoundException: com.baidu.turbonet.net.CronetUrlRequestContext", e);
            } catch (Exception e2) {
                throw new IllegalStateException("Cannot instantiate: com.baidu.turbonet.net.CronetUrlRequestContext", e2);
            }
        }
        return (TurbonetEngine) invokeL.objValue;
    }
}
