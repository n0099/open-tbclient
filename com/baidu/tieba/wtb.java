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
import com.baidu.tieba.aub;
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
public class wtb implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final wtb c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<rtb, a> b;

    /* loaded from: classes8.dex */
    public class a implements aub.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<hub<?>> a;
        public final Queue<hub<?>> b;
        public final aub c;
        public HonorPushErrorEnum d;
        public final rtb e;
        public final /* synthetic */ wtb f;

        public a(wtb wtbVar, rtb rtbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wtbVar, rtbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = wtbVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new dub(this);
            this.d = null;
            this.e = rtbVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                etb.g(this.f.a);
                dub dubVar = (dub) this.c;
                int i = dubVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        dubVar.a.set(4);
                        return;
                    }
                    return;
                }
                gub gubVar = dubVar.d;
                if (gubVar != null) {
                    gubVar.c();
                }
                dubVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    etb.g(this.f.a);
                    for (hub<?> hubVar : this.a) {
                        hubVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(hub<?> hubVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hubVar) == null) {
                synchronized (this) {
                    this.b.add(hubVar);
                    aub aubVar = this.c;
                    b bVar = new b(hubVar);
                    hubVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = hubVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        gtb.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + hubVar.a);
                    IPushInvoke iPushInvoke = ((dub) aubVar).b;
                    String str = hubVar.a;
                    RequestHeader requestHeader = hubVar.d;
                    IMessageEntity iMessageEntity = hubVar.b;
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
                    etb.g(this.f.a);
                    this.d = null;
                    for (hub<?> hubVar : this.a) {
                        c(hubVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements kub {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public hub<?> a;

        public b(hub<?> hubVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hubVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hubVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948283524, "Lcom/baidu/tieba/wtb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948283524, "Lcom/baidu/tieba/wtb;");
                return;
            }
        }
        c = new wtb();
    }

    public wtb() {
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

    public <TResult> xtb<TResult> a(hub<TResult> hubVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hubVar)) == null) {
            pub<TResult> pubVar = new pub<>();
            hubVar.e = pubVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, hubVar));
            return pubVar.a;
        }
        return (xtb) invokeL.objValue;
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
                hub<?> hubVar = (hub) message.obj;
                rtb rtbVar = hubVar.c;
                a aVar2 = this.b.get(rtbVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, rtbVar);
                    this.b.put(rtbVar, aVar2);
                }
                synchronized (aVar2) {
                    etb.g(aVar2.f.a);
                    String str = "sendRequest " + hubVar.a;
                    if (((dub) aVar2.c).b()) {
                        aVar2.c(hubVar);
                    } else {
                        aVar2.a.add(hubVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                etb.g(aVar2.f.a);
                                if (((dub) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((dub) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        dub dubVar = (dub) aVar2.c;
                                        dubVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = dubVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            ltb ltbVar = ltb.e;
                                            int b2 = HonorApiAvailability.b(ltbVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                dubVar.a.set(5);
                                                htb a2 = HonorApiAvailability.a(ltbVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                gub gubVar = new gub(a2);
                                                dubVar.d = gubVar;
                                                gubVar.b = new cub(dubVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + gubVar.a;
                                                    gubVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = gubVar.a.c();
                                                    String b3 = gubVar.a.b();
                                                    String d = gubVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (gub.e) {
                                                        if (ltbVar.a().bindService(intent, gubVar, 1)) {
                                                            Handler handler = gubVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                gubVar.c = new Handler(Looper.getMainLooper(), new fub(gubVar));
                                                            }
                                                            gubVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            gubVar.d = true;
                                                            gubVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                dubVar.a(b2);
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
                hub hubVar2 = (hub) message.obj;
                rtb rtbVar2 = hubVar2.c;
                if (rtbVar2 != null && this.b.containsKey(rtbVar2) && (aVar = this.b.get(rtbVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + hubVar2.a;
                        aVar.b.remove(hubVar2);
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
