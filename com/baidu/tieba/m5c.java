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
import com.baidu.tieba.q5c;
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
public class m5c implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final m5c c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<h5c, a> b;

    /* loaded from: classes7.dex */
    public class a implements q5c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<x5c<?>> a;
        public final Queue<x5c<?>> b;
        public final q5c c;
        public HonorPushErrorEnum d;
        public final h5c e;
        public final /* synthetic */ m5c f;

        public a(m5c m5cVar, h5c h5cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m5cVar, h5cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = m5cVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new t5c(this);
            this.d = null;
            this.e = h5cVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                u4c.g(this.f.a);
                t5c t5cVar = (t5c) this.c;
                int i = t5cVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        t5cVar.a.set(4);
                        return;
                    }
                    return;
                }
                w5c w5cVar = t5cVar.d;
                if (w5cVar != null) {
                    w5cVar.c();
                }
                t5cVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    u4c.g(this.f.a);
                    for (x5c<?> x5cVar : this.a) {
                        x5cVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(x5c<?> x5cVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x5cVar) == null) {
                synchronized (this) {
                    this.b.add(x5cVar);
                    q5c q5cVar = this.c;
                    b bVar = new b(x5cVar);
                    x5cVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = x5cVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        w4c.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + x5cVar.a);
                    IPushInvoke iPushInvoke = ((t5c) q5cVar).b;
                    String str = x5cVar.a;
                    RequestHeader requestHeader = x5cVar.d;
                    IMessageEntity iMessageEntity = x5cVar.b;
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
                    u4c.g(this.f.a);
                    this.d = null;
                    for (x5c<?> x5cVar : this.a) {
                        c(x5cVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements a6c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public x5c<?> a;

        public b(x5c<?> x5cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x5cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x5cVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947925102, "Lcom/baidu/tieba/m5c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947925102, "Lcom/baidu/tieba/m5c;");
                return;
            }
        }
        c = new m5c();
    }

    public m5c() {
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

    public <TResult> n5c<TResult> a(x5c<TResult> x5cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x5cVar)) == null) {
            f6c<TResult> f6cVar = new f6c<>();
            x5cVar.e = f6cVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, x5cVar));
            return f6cVar.a;
        }
        return (n5c) invokeL.objValue;
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
                x5c<?> x5cVar = (x5c) message.obj;
                h5c h5cVar = x5cVar.c;
                a aVar2 = this.b.get(h5cVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, h5cVar);
                    this.b.put(h5cVar, aVar2);
                }
                synchronized (aVar2) {
                    u4c.g(aVar2.f.a);
                    String str = "sendRequest " + x5cVar.a;
                    if (((t5c) aVar2.c).b()) {
                        aVar2.c(x5cVar);
                    } else {
                        aVar2.a.add(x5cVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                u4c.g(aVar2.f.a);
                                if (((t5c) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((t5c) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        t5c t5cVar = (t5c) aVar2.c;
                                        t5cVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = t5cVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            b5c b5cVar = b5c.e;
                                            int b2 = HonorApiAvailability.b(b5cVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                t5cVar.a.set(5);
                                                x4c a2 = HonorApiAvailability.a(b5cVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                w5c w5cVar = new w5c(a2);
                                                t5cVar.d = w5cVar;
                                                w5cVar.b = new s5c(t5cVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + w5cVar.a;
                                                    w5cVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = w5cVar.a.c();
                                                    String b3 = w5cVar.a.b();
                                                    String d = w5cVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (w5c.e) {
                                                        if (b5cVar.a().bindService(intent, w5cVar, 1)) {
                                                            Handler handler = w5cVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                w5cVar.c = new Handler(Looper.getMainLooper(), new v5c(w5cVar));
                                                            }
                                                            w5cVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            w5cVar.d = true;
                                                            w5cVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                t5cVar.a(b2);
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
                x5c x5cVar2 = (x5c) message.obj;
                h5c h5cVar2 = x5cVar2.c;
                if (h5cVar2 != null && this.b.containsKey(h5cVar2) && (aVar = this.b.get(h5cVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + x5cVar2.a;
                        aVar.b.remove(x5cVar2);
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
