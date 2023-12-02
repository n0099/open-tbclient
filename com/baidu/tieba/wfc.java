package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.agc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.yy.render.ITransDataListener;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class wfc {
    public static /* synthetic */ Interceptable $ic;
    public static wfc e;
    public static final a f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final ConcurrentHashMap<String, xfc> b;
    public final ConcurrentHashMap<String, String> c;
    public ConcurrentHashMap<String, RemoteCallbackList<ITransDataListener>> d;

    /* loaded from: classes8.dex */
    public static final class a {
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

        public final wfc a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return wfc.e;
            }
            return (wfc) invokeV.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948270101, "Lcom/baidu/tieba/wfc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948270101, "Lcom/baidu/tieba/wfc;");
                return;
            }
        }
        f = new a(null);
        e = new wfc();
    }

    public wfc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "MessageChannel";
        this.b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
    }

    public final xfc b(String str, Context context, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, context, str2)) == null) {
            try {
                Object newInstance = Class.forName(str).getConstructor(Context.class, String.class).newInstance(context, str2);
                if (newInstance != null) {
                    return (xfc) newInstance;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.yy.render.trans.ServerMessageHandler");
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (xfc) invokeLLL.objValue;
    }

    public final void c(String str, Bundle bundle) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z && bundle != null) {
                xfc xfcVar = this.b.get(str);
                if (xfcVar == null) {
                    agc.a aVar = agc.b;
                    String str2 = this.a;
                    aVar.g(str2, "onBundleFromClient " + str + " no handler");
                    return;
                }
                xfcVar.f(bundle);
                return;
            }
            agc.b.g(this.a, "onBundleFromClient null");
        }
    }

    public final boolean d(String str, Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bundle)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z && bundle != null) {
                xfc xfcVar = this.b.get(str);
                if (xfcVar == null) {
                    agc.a aVar = agc.b;
                    String str2 = this.a;
                    aVar.g(str2, "onBundleFromClientForBoolean " + str + " no handler");
                    return false;
                }
                return xfcVar.g(bundle);
            }
            agc.b.g(this.a, "onBundleFromClientForBoolean null");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final String e(String str, Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bundle)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z && bundle != null) {
                xfc xfcVar = this.b.get(str);
                if (xfcVar == null) {
                    agc.a aVar = agc.b;
                    String str2 = this.a;
                    aVar.g(str2, "onBundleFromClientForStr " + str + " no handler");
                    return "";
                }
                return xfcVar.h(bundle);
            }
            agc.b.g(this.a, "onBundleFromClientForStr null");
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public final void f(String str, String str2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            boolean z2 = false;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (!((str2 == null || str2.length() == 0) ? true : true)) {
                    xfc xfcVar = this.b.get(str);
                    if (xfcVar == null) {
                        agc.a aVar = agc.b;
                        String str3 = this.a;
                        aVar.g(str3, "onDataFromClient " + str + " no handler");
                        return;
                    }
                    xfcVar.i(str2);
                    return;
                }
            }
            agc.b.g(this.a, "onDataFromClient null");
        }
    }

    public final boolean k(String str, ITransDataListener iTransDataListener) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, iTransDataListener)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z && iTransDataListener != null) {
                xfc remove = this.b.remove(str);
                if (remove != null) {
                    remove.l();
                }
                this.c.remove(str);
                RemoteCallbackList<ITransDataListener> remoteCallbackList = this.d.get(str);
                if (remoteCallbackList == null) {
                    return true;
                }
                return remoteCallbackList.unregister(iTransDataListener);
            }
            agc.b.g(this.a, "registerDataListener null");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean g(String str, String str2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            boolean z2 = true;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (str2 != null && str2.length() != 0) {
                    z2 = false;
                }
                if (!z2) {
                    xfc xfcVar = this.b.get(str);
                    if (xfcVar == null) {
                        agc.a aVar = agc.b;
                        String str3 = this.a;
                        aVar.g(str3, "onDataFromClientForBoolean " + str + " no handler");
                        return false;
                    }
                    return xfcVar.j(str2);
                }
            }
            agc.b.g(this.a, "onDataFromClientForBoolean null");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final String h(String str, String str2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            boolean z2 = false;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (!((str2 == null || str2.length() == 0) ? true : true)) {
                    xfc xfcVar = this.b.get(str);
                    if (xfcVar == null) {
                        agc.a aVar = agc.b;
                        String str3 = this.a;
                        aVar.g(str3, "onDataFromClientForStr " + str + " no handler");
                        return "";
                    }
                    return xfcVar.k(str2);
                }
            }
            agc.b.g(this.a, "onDataFromClientForStr null");
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public final boolean i(Context context, String str, String str2, ITransDataListener iTransDataListener) {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, str, str2, iTransDataListener)) == null) {
            boolean z2 = true;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (str2 != null && str2.length() != 0) {
                    z2 = false;
                }
                if (!z2 && iTransDataListener != null) {
                    if (this.b.get(str) != null) {
                        agc.a aVar = agc.b;
                        String str3 = this.a;
                        aVar.g(str3, "registerDataListener " + str + " has handler");
                        return false;
                    }
                    if (context == null) {
                        Intrinsics.throwNpe();
                    }
                    xfc b = b(str2, context, str);
                    if (b == null) {
                        agc.b.g(this.a, "registerDataListener reflect fail");
                        return false;
                    }
                    this.b.put(str, b);
                    this.c.put(str, str2);
                    RemoteCallbackList<ITransDataListener> remoteCallbackList = this.d.get(str);
                    if (remoteCallbackList == null) {
                        remoteCallbackList = new RemoteCallbackList<>();
                        this.d.put(str, remoteCallbackList);
                    }
                    return remoteCallbackList.register(iTransDataListener);
                }
            }
            agc.b.g(this.a, "registerDataListener null");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final yfc<String> j(String str, String str2) {
        InterceptResult invokeLL;
        boolean z;
        boolean z2;
        yfc<String> yfcVar;
        String transDataForStr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (str2.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    if (!this.d.containsKey(str)) {
                        return new yfc<>(false, str + " no handler");
                    }
                    RemoteCallbackList<ITransDataListener> remoteCallbackList = this.d.get(str);
                    if (remoteCallbackList == null) {
                        return new yfc<>(false, str + "  handler is null");
                    } else if (remoteCallbackList.getRegisteredCallbackCount() == 0) {
                        return new yfc<>(false, str + " callback count = 0");
                    } else {
                        try {
                            synchronized (remoteCallbackList) {
                                int beginBroadcast = remoteCallbackList.beginBroadcast();
                                String str3 = "";
                                agc.a aVar = agc.b;
                                String str4 = this.a;
                                aVar.g(str4, "sendData2MainProcessForStr callback count = " + beginBroadcast + WebvttCueParser.CHAR_SPACE);
                                if (1 <= beginBroadcast) {
                                    int i = 1;
                                    while (true) {
                                        transDataForStr = remoteCallbackList.getBroadcastItem(i - 1).transDataForStr(str, str2);
                                        Intrinsics.checkExpressionValueIsNotNull(transDataForStr, "listener.transDataForStr(channelId, data)");
                                        if (i == beginBroadcast) {
                                            break;
                                        }
                                        i++;
                                    }
                                    str3 = transDataForStr;
                                }
                                remoteCallbackList.finishBroadcast();
                                yfcVar = new yfc<>(true, str3);
                            }
                            return yfcVar;
                        } catch (Exception e2) {
                            agc.a aVar2 = agc.b;
                            String str5 = this.a;
                            aVar2.d(str5, "sendData2MainProcessForStr ex: " + e2.getMessage());
                            return new yfc<>(false, "");
                        }
                    }
                }
            }
            return new yfc<>(false, "channelId, data is null or empty");
        }
        return (yfc) invokeLL.objValue;
    }
}
