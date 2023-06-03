package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.UrlRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes8.dex */
public abstract class TurbonetEngine {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "TurbonetEngine";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1179937958, "Lcom/baidu/turbonet/net/TurbonetEngine;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1179937958, "Lcom/baidu/turbonet/net/TurbonetEngine;");
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    public abstract boolean c();

    public abstract UrlRequest.Builder d(String str, UrlRequest.Callback callback, Executor executor);

    public abstract void e(String str, String str2, int i, int i2, long j, long j2, long j3, long j4);

    /* loaded from: classes8.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ICronetEngineBuilder a;

        /* loaded from: classes8.dex */
        public static abstract class LibraryLoader {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

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

        /* loaded from: classes8.dex */
        public class a implements Comparator<CronetProvider> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(CronetProvider cronetProvider, CronetProvider cronetProvider2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cronetProvider, cronetProvider2)) == null) {
                    if ("Fallback-Cronet-Provider".equals(cronetProvider.d())) {
                        return 1;
                    }
                    if ("Fallback-Cronet-Provider".equals(cronetProvider2.d())) {
                        return -1;
                    }
                    return -Builder.c(cronetProvider.e(), cronetProvider2.e());
                }
                return invokeLL.intValue;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Context context) {
            this(d(context));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    this((ICronetEngineBuilder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public Builder(ICronetEngineBuilder iCronetEngineBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iCronetEngineBuilder};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = iCronetEngineBuilder;
        }

        public Builder a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.a.a(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.a.d(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.a.e(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.a.f(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @VisibleForTesting
        public static int c(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
                if (str != null && str2 != null) {
                    String[] split = str.split("\\.");
                    String[] split2 = str2.split("\\.");
                    for (int i = 0; i < split.length && i < split2.length; i++) {
                        try {
                            int parseInt = Integer.parseInt(split[i]);
                            int parseInt2 = Integer.parseInt(split2[i]);
                            if (parseInt != parseInt2) {
                                return Integer.signum(parseInt - parseInt2);
                            }
                        } catch (IllegalArgumentException e) {
                            throw new IllegalArgumentException("Unable to convert version segments into integers: " + split[i] + " & " + split2[i], e);
                        }
                    }
                    return Integer.signum(split.length - split2.length);
                }
                throw new IllegalArgumentException("The input values cannot be null");
            }
            return invokeLL.intValue;
        }

        public static ICronetEngineBuilder d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
                ArrayList arrayList = new ArrayList(CronetProvider.c(context));
                e(context, arrayList);
                CronetProvider cronetProvider = (CronetProvider) arrayList.get(0);
                if (Log.isLoggable(TurbonetEngine.a, 3)) {
                    Log.d(TurbonetEngine.a, String.format("Using '%s' provider for creating TurbonetEngine.Builder.", cronetProvider));
                }
                return cronetProvider.b().a;
            }
            return (ICronetEngineBuilder) invokeL.objValue;
        }

        @VisibleForTesting
        public static List<CronetProvider> e(Context context, List<CronetProvider> list) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, list)) == null) {
                if (list.size() != 0) {
                    Iterator<CronetProvider> it = list.iterator();
                    while (it.hasNext()) {
                        if (!it.next().f()) {
                            it.remove();
                        }
                    }
                    if (list.size() != 0) {
                        Collections.sort(list, new a());
                        return list;
                    }
                    throw new RuntimeException("All available Cronet providers are disabled. A provider should be enabled before it can be used.");
                }
                throw new RuntimeException("Unable to find any Cronet provider. Have you included all necessary jars?");
            }
            return (List) invokeLL.objValue;
        }

        public TurbonetEngine b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.b();
            }
            return (TurbonetEngine) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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
    /* loaded from: classes8.dex */
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
            UNKNOWN = new QUICConnectStatus("UNKNOWN", 0);
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
    /* loaded from: classes8.dex */
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
            UNKNOWN = new TCPNetworkQualityStatus("UNKNOWN", 0);
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
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
