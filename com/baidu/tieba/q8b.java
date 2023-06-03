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
import com.baidu.tieba.u8b;
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
public class q8b implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final q8b c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<l8b, a> b;

    /* loaded from: classes7.dex */
    public class a implements u8b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<b9b<?>> a;
        public final Queue<b9b<?>> b;
        public final u8b c;
        public HonorPushErrorEnum d;
        public final l8b e;
        public final /* synthetic */ q8b f;

        public a(q8b q8bVar, l8b l8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q8bVar, l8bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = q8bVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new x8b(this);
            this.d = null;
            this.e = l8bVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y7b.g(this.f.a);
                x8b x8bVar = (x8b) this.c;
                int i = x8bVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        x8bVar.a.set(4);
                        return;
                    }
                    return;
                }
                a9b a9bVar = x8bVar.d;
                if (a9bVar != null) {
                    a9bVar.c();
                }
                x8bVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    y7b.g(this.f.a);
                    for (b9b<?> b9bVar : this.a) {
                        b9bVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(b9b<?> b9bVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b9bVar) == null) {
                synchronized (this) {
                    this.b.add(b9bVar);
                    u8b u8bVar = this.c;
                    b bVar = new b(b9bVar);
                    b9bVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = b9bVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        a8b.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + b9bVar.a);
                    IPushInvoke iPushInvoke = ((x8b) u8bVar).b;
                    String str = b9bVar.a;
                    RequestHeader requestHeader = b9bVar.d;
                    IMessageEntity iMessageEntity = b9bVar.b;
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
                    y7b.g(this.f.a);
                    this.d = null;
                    for (b9b<?> b9bVar : this.a) {
                        c(b9bVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements e9b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b9b<?> a;

        public b(b9b<?> b9bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b9bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b9bVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948047118, "Lcom/baidu/tieba/q8b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948047118, "Lcom/baidu/tieba/q8b;");
                return;
            }
        }
        c = new q8b();
    }

    public q8b() {
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

    public <TResult> r8b<TResult> a(b9b<TResult> b9bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b9bVar)) == null) {
            j9b<TResult> j9bVar = new j9b<>();
            b9bVar.e = j9bVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, b9bVar));
            return j9bVar.a;
        }
        return (r8b) invokeL.objValue;
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
                b9b<?> b9bVar = (b9b) message.obj;
                l8b l8bVar = b9bVar.c;
                a aVar2 = this.b.get(l8bVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, l8bVar);
                    this.b.put(l8bVar, aVar2);
                }
                synchronized (aVar2) {
                    y7b.g(aVar2.f.a);
                    String str = "sendRequest " + b9bVar.a;
                    if (((x8b) aVar2.c).b()) {
                        aVar2.c(b9bVar);
                    } else {
                        aVar2.a.add(b9bVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                y7b.g(aVar2.f.a);
                                if (((x8b) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((x8b) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        x8b x8bVar = (x8b) aVar2.c;
                                        x8bVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = x8bVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            f8b f8bVar = f8b.e;
                                            int b2 = HonorApiAvailability.b(f8bVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                x8bVar.a.set(5);
                                                b8b a2 = HonorApiAvailability.a(f8bVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                a9b a9bVar = new a9b(a2);
                                                x8bVar.d = a9bVar;
                                                a9bVar.b = new w8b(x8bVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + a9bVar.a;
                                                    a9bVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = a9bVar.a.c();
                                                    String b3 = a9bVar.a.b();
                                                    String d = a9bVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (a9b.e) {
                                                        if (f8bVar.a().bindService(intent, a9bVar, 1)) {
                                                            Handler handler = a9bVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                a9bVar.c = new Handler(Looper.getMainLooper(), new z8b(a9bVar));
                                                            }
                                                            a9bVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            a9bVar.d = true;
                                                            a9bVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                x8bVar.a(b2);
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
                b9b b9bVar2 = (b9b) message.obj;
                l8b l8bVar2 = b9bVar2.c;
                if (l8bVar2 != null && this.b.containsKey(l8bVar2) && (aVar = this.b.get(l8bVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + b9bVar2.a;
                        aVar.b.remove(b9bVar2);
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
