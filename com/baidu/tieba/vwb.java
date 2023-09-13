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
import com.baidu.tieba.zwb;
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
public class vwb implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final vwb c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<qwb, a> b;

    /* loaded from: classes8.dex */
    public class a implements zwb.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<gxb<?>> a;
        public final Queue<gxb<?>> b;
        public final zwb c;
        public HonorPushErrorEnum d;
        public final qwb e;
        public final /* synthetic */ vwb f;

        public a(vwb vwbVar, qwb qwbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vwbVar, qwbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = vwbVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new cxb(this);
            this.d = null;
            this.e = qwbVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dwb.g(this.f.a);
                cxb cxbVar = (cxb) this.c;
                int i = cxbVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        cxbVar.a.set(4);
                        return;
                    }
                    return;
                }
                fxb fxbVar = cxbVar.d;
                if (fxbVar != null) {
                    fxbVar.c();
                }
                cxbVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    dwb.g(this.f.a);
                    for (gxb<?> gxbVar : this.a) {
                        gxbVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(gxb<?> gxbVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gxbVar) == null) {
                synchronized (this) {
                    this.b.add(gxbVar);
                    zwb zwbVar = this.c;
                    b bVar = new b(gxbVar);
                    gxbVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = gxbVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        fwb.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + gxbVar.a);
                    IPushInvoke iPushInvoke = ((cxb) zwbVar).b;
                    String str = gxbVar.a;
                    RequestHeader requestHeader = gxbVar.d;
                    IMessageEntity iMessageEntity = gxbVar.b;
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
                    dwb.g(this.f.a);
                    this.d = null;
                    for (gxb<?> gxbVar : this.a) {
                        c(gxbVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements jxb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public gxb<?> a;

        public b(gxb<?> gxbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gxbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gxbVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948256616, "Lcom/baidu/tieba/vwb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948256616, "Lcom/baidu/tieba/vwb;");
                return;
            }
        }
        c = new vwb();
    }

    public vwb() {
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

    public <TResult> wwb<TResult> a(gxb<TResult> gxbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gxbVar)) == null) {
            oxb<TResult> oxbVar = new oxb<>();
            gxbVar.e = oxbVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, gxbVar));
            return oxbVar.a;
        }
        return (wwb) invokeL.objValue;
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
                gxb<?> gxbVar = (gxb) message.obj;
                qwb qwbVar = gxbVar.c;
                a aVar2 = this.b.get(qwbVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, qwbVar);
                    this.b.put(qwbVar, aVar2);
                }
                synchronized (aVar2) {
                    dwb.g(aVar2.f.a);
                    String str = "sendRequest " + gxbVar.a;
                    if (((cxb) aVar2.c).b()) {
                        aVar2.c(gxbVar);
                    } else {
                        aVar2.a.add(gxbVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                dwb.g(aVar2.f.a);
                                if (((cxb) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((cxb) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        cxb cxbVar = (cxb) aVar2.c;
                                        cxbVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = cxbVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            kwb kwbVar = kwb.e;
                                            int b2 = HonorApiAvailability.b(kwbVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                cxbVar.a.set(5);
                                                gwb a2 = HonorApiAvailability.a(kwbVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                fxb fxbVar = new fxb(a2);
                                                cxbVar.d = fxbVar;
                                                fxbVar.b = new bxb(cxbVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + fxbVar.a;
                                                    fxbVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = fxbVar.a.c();
                                                    String b3 = fxbVar.a.b();
                                                    String d = fxbVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (fxb.e) {
                                                        if (kwbVar.a().bindService(intent, fxbVar, 1)) {
                                                            Handler handler = fxbVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                fxbVar.c = new Handler(Looper.getMainLooper(), new exb(fxbVar));
                                                            }
                                                            fxbVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            fxbVar.d = true;
                                                            fxbVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                cxbVar.a(b2);
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
                gxb gxbVar2 = (gxb) message.obj;
                qwb qwbVar2 = gxbVar2.c;
                if (qwbVar2 != null && this.b.containsKey(qwbVar2) && (aVar = this.b.get(qwbVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + gxbVar2.a;
                        aVar.b.remove(gxbVar2);
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
