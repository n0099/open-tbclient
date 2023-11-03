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
import com.baidu.tieba.p5c;
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
/* loaded from: classes7.dex */
public class l5c implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final l5c c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<g5c, a> b;

    /* loaded from: classes7.dex */
    public class a implements p5c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<w5c<?>> a;
        public final Queue<w5c<?>> b;
        public final p5c c;
        public HonorPushErrorEnum d;
        public final g5c e;
        public final /* synthetic */ l5c f;

        public a(l5c l5cVar, g5c g5cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l5cVar, g5cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = l5cVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new s5c(this);
            this.d = null;
            this.e = g5cVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                t4c.g(this.f.a);
                s5c s5cVar = (s5c) this.c;
                int i = s5cVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        s5cVar.a.set(4);
                        return;
                    }
                    return;
                }
                v5c v5cVar = s5cVar.d;
                if (v5cVar != null) {
                    v5cVar.c();
                }
                s5cVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    t4c.g(this.f.a);
                    for (w5c<?> w5cVar : this.a) {
                        w5cVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(w5c<?> w5cVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w5cVar) == null) {
                synchronized (this) {
                    this.b.add(w5cVar);
                    p5c p5cVar = this.c;
                    b bVar = new b(w5cVar);
                    w5cVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = w5cVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        v4c.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + w5cVar.a);
                    IPushInvoke iPushInvoke = ((s5c) p5cVar).b;
                    String str = w5cVar.a;
                    RequestHeader requestHeader = w5cVar.d;
                    IMessageEntity iMessageEntity = w5cVar.b;
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
                    t4c.g(this.f.a);
                    this.d = null;
                    for (w5c<?> w5cVar : this.a) {
                        c(w5cVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements z5c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public w5c<?> a;

        public b(w5c<?> w5cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w5cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w5cVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947895311, "Lcom/baidu/tieba/l5c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947895311, "Lcom/baidu/tieba/l5c;");
                return;
            }
        }
        c = new l5c();
    }

    public l5c() {
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

    public <TResult> m5c<TResult> a(w5c<TResult> w5cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w5cVar)) == null) {
            e6c<TResult> e6cVar = new e6c<>();
            w5cVar.e = e6cVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, w5cVar));
            return e6cVar.a;
        }
        return (m5c) invokeL.objValue;
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
                w5c<?> w5cVar = (w5c) message.obj;
                g5c g5cVar = w5cVar.c;
                a aVar2 = this.b.get(g5cVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, g5cVar);
                    this.b.put(g5cVar, aVar2);
                }
                synchronized (aVar2) {
                    t4c.g(aVar2.f.a);
                    String str = "sendRequest " + w5cVar.a;
                    if (((s5c) aVar2.c).b()) {
                        aVar2.c(w5cVar);
                    } else {
                        aVar2.a.add(w5cVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                t4c.g(aVar2.f.a);
                                if (((s5c) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((s5c) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        s5c s5cVar = (s5c) aVar2.c;
                                        s5cVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = s5cVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            a5c a5cVar = a5c.e;
                                            int b2 = HonorApiAvailability.b(a5cVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                s5cVar.a.set(5);
                                                w4c a2 = HonorApiAvailability.a(a5cVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                v5c v5cVar = new v5c(a2);
                                                s5cVar.d = v5cVar;
                                                v5cVar.b = new r5c(s5cVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + v5cVar.a;
                                                    v5cVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = v5cVar.a.c();
                                                    String b3 = v5cVar.a.b();
                                                    String d = v5cVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (v5c.e) {
                                                        if (a5cVar.a().bindService(intent, v5cVar, 1)) {
                                                            Handler handler = v5cVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                v5cVar.c = new Handler(Looper.getMainLooper(), new u5c(v5cVar));
                                                            }
                                                            v5cVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            v5cVar.d = true;
                                                            v5cVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                s5cVar.a(b2);
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
                w5c w5cVar2 = (w5c) message.obj;
                g5c g5cVar2 = w5cVar2.c;
                if (g5cVar2 != null && this.b.containsKey(g5cVar2) && (aVar = this.b.get(g5cVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + w5cVar2.a;
                        aVar.b.remove(w5cVar2);
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
