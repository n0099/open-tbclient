package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.z8b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.ipc.HonorApiAvailability;
import com.huawei.hms.api.IPCTransport;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class v8b implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final v8b c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<q8b, a> b;

    /* loaded from: classes8.dex */
    public class a implements z8b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<g9b<?>> a;
        public final Queue<g9b<?>> b;
        public final z8b c;
        public HonorPushErrorEnum d;
        public final q8b e;
        public final /* synthetic */ v8b f;

        public a(v8b v8bVar, q8b q8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v8bVar, q8bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = v8bVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new c9b(this);
            this.d = null;
            this.e = q8bVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d8b.g(this.f.a);
                c9b c9bVar = (c9b) this.c;
                int i = c9bVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        c9bVar.a.set(4);
                        return;
                    }
                    return;
                }
                f9b f9bVar = c9bVar.d;
                if (f9bVar != null) {
                    f9bVar.c();
                }
                c9bVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    d8b.g(this.f.a);
                    for (g9b<?> g9bVar : this.a) {
                        g9bVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(g9b<?> g9bVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g9bVar) == null) {
                synchronized (this) {
                    this.b.add(g9bVar);
                    z8b z8bVar = this.c;
                    b bVar = new b(g9bVar);
                    g9bVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = g9bVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        f8b.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + g9bVar.a);
                    IPushInvoke iPushInvoke = ((c9b) z8bVar).b;
                    String str = g9bVar.a;
                    RequestHeader requestHeader = g9bVar.d;
                    IMessageEntity iMessageEntity = g9bVar.b;
                    Bundle bundle = new Bundle();
                    Bundle bundle2 = new Bundle();
                    MessageCodec.formMessageEntity(requestHeader, bundle);
                    MessageCodec.formMessageEntity(iMessageEntity, bundle2);
                    DataBuffer dataBuffer = new DataBuffer(str, bundle, bundle2);
                    if (iPushInvoke != null) {
                        try {
                            iPushInvoke.call(dataBuffer, rVar);
                        } catch (Exception e2) {
                            String str2 = "transport remote error. " + e2;
                        }
                    }
                    Log.i(IPCTransport.TAG, "end transport parse.");
                }
            }
        }

        public final synchronized void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnected");
                    d8b.g(this.f.a);
                    this.d = null;
                    for (g9b<?> g9bVar : this.a) {
                        c(g9bVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements j9b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public g9b<?> a;

        public b(g9b<?> g9bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g9bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g9bVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948196073, "Lcom/baidu/tieba/v8b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948196073, "Lcom/baidu/tieba/v8b;");
                return;
            }
        }
        c = new v8b();
    }

    public v8b() {
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
        this.b = new ConcurrentHashMap(5, 0.75f, 1);
        HandlerThread handlerThread = new HandlerThread("HonorApiManager");
        handlerThread.start();
        this.a = new Handler(handlerThread.getLooper(), this);
    }

    public <TResult> w8b<TResult> a(g9b<TResult> g9bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, g9bVar)) == null) {
            o9b<TResult> o9bVar = new o9b<>();
            g9bVar.e = o9bVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, g9bVar));
            return o9bVar.a;
        }
        return (w8b) invokeL.objValue;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message)) == null) {
            int i = message.what;
            boolean z = false;
            if (i == 1) {
                g9b<?> g9bVar = (g9b) message.obj;
                q8b q8bVar = g9bVar.c;
                a aVar2 = this.b.get(q8bVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, q8bVar);
                    this.b.put(q8bVar, aVar2);
                }
                synchronized (aVar2) {
                    d8b.g(aVar2.f.a);
                    String str = "sendRequest " + g9bVar.a;
                    if (((c9b) aVar2.c).b()) {
                        aVar2.c(g9bVar);
                    } else {
                        aVar2.a.add(g9bVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                d8b.g(aVar2.f.a);
                                if (((c9b) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((c9b) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        c9b c9bVar = (c9b) aVar2.c;
                                        c9bVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = c9bVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            k8b k8bVar = k8b.e;
                                            int b2 = HonorApiAvailability.b(k8bVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                c9bVar.a.set(5);
                                                g8b a2 = HonorApiAvailability.a(k8bVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                f9b f9bVar = new f9b(a2);
                                                c9bVar.d = f9bVar;
                                                f9bVar.b = new b9b(c9bVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + f9bVar.a;
                                                    f9bVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = f9bVar.a.c();
                                                    String b3 = f9bVar.a.b();
                                                    String d = f9bVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (f9b.e) {
                                                        if (k8bVar.a().bindService(intent, f9bVar, 1)) {
                                                            Handler handler = f9bVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                f9bVar.c = new Handler(Looper.getMainLooper(), new e9b(f9bVar));
                                                            }
                                                            f9bVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            f9bVar.d = true;
                                                            f9bVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                c9bVar.a(b2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return true;
            } else if (i != 2) {
                return false;
            } else {
                g9b g9bVar2 = (g9b) message.obj;
                q8b q8bVar2 = g9bVar2.c;
                if (q8bVar2 != null && this.b.containsKey(q8bVar2) && (aVar = this.b.get(q8bVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + g9bVar2.a;
                        aVar.b.remove(g9bVar2);
                        if (aVar.a.peek() == null || aVar.b.peek() == null) {
                            aVar.a();
                            aVar.f.b.remove(aVar.e);
                        }
                    }
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
