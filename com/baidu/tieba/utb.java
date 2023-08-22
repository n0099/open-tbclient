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
import com.baidu.tieba.ytb;
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
public class utb implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final utb c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<ptb, a> b;

    /* loaded from: classes8.dex */
    public class a implements ytb.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<fub<?>> a;
        public final Queue<fub<?>> b;
        public final ytb c;
        public HonorPushErrorEnum d;
        public final ptb e;
        public final /* synthetic */ utb f;

        public a(utb utbVar, ptb ptbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {utbVar, ptbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = utbVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new bub(this);
            this.d = null;
            this.e = ptbVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ctb.g(this.f.a);
                bub bubVar = (bub) this.c;
                int i = bubVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        bubVar.a.set(4);
                        return;
                    }
                    return;
                }
                eub eubVar = bubVar.d;
                if (eubVar != null) {
                    eubVar.c();
                }
                bubVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    ctb.g(this.f.a);
                    for (fub<?> fubVar : this.a) {
                        fubVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(fub<?> fubVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fubVar) == null) {
                synchronized (this) {
                    this.b.add(fubVar);
                    ytb ytbVar = this.c;
                    b bVar = new b(fubVar);
                    fubVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = fubVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        etb.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + fubVar.a);
                    IPushInvoke iPushInvoke = ((bub) ytbVar).b;
                    String str = fubVar.a;
                    RequestHeader requestHeader = fubVar.d;
                    IMessageEntity iMessageEntity = fubVar.b;
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
                    ctb.g(this.f.a);
                    this.d = null;
                    for (fub<?> fubVar : this.a) {
                        c(fubVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements iub {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public fub<?> a;

        public b(fub<?> fubVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fubVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fubVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948223942, "Lcom/baidu/tieba/utb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948223942, "Lcom/baidu/tieba/utb;");
                return;
            }
        }
        c = new utb();
    }

    public utb() {
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

    public <TResult> vtb<TResult> a(fub<TResult> fubVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fubVar)) == null) {
            nub<TResult> nubVar = new nub<>();
            fubVar.e = nubVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, fubVar));
            return nubVar.a;
        }
        return (vtb) invokeL.objValue;
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
                fub<?> fubVar = (fub) message.obj;
                ptb ptbVar = fubVar.c;
                a aVar2 = this.b.get(ptbVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, ptbVar);
                    this.b.put(ptbVar, aVar2);
                }
                synchronized (aVar2) {
                    ctb.g(aVar2.f.a);
                    String str = "sendRequest " + fubVar.a;
                    if (((bub) aVar2.c).b()) {
                        aVar2.c(fubVar);
                    } else {
                        aVar2.a.add(fubVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                ctb.g(aVar2.f.a);
                                if (((bub) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((bub) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        bub bubVar = (bub) aVar2.c;
                                        bubVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = bubVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            jtb jtbVar = jtb.e;
                                            int b2 = HonorApiAvailability.b(jtbVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                bubVar.a.set(5);
                                                ftb a2 = HonorApiAvailability.a(jtbVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                eub eubVar = new eub(a2);
                                                bubVar.d = eubVar;
                                                eubVar.b = new aub(bubVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + eubVar.a;
                                                    eubVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = eubVar.a.c();
                                                    String b3 = eubVar.a.b();
                                                    String d = eubVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (eub.e) {
                                                        if (jtbVar.a().bindService(intent, eubVar, 1)) {
                                                            Handler handler = eubVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                eubVar.c = new Handler(Looper.getMainLooper(), new dub(eubVar));
                                                            }
                                                            eubVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            eubVar.d = true;
                                                            eubVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                bubVar.a(b2);
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
                fub fubVar2 = (fub) message.obj;
                ptb ptbVar2 = fubVar2.c;
                if (ptbVar2 != null && this.b.containsKey(ptbVar2) && (aVar = this.b.get(ptbVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + fubVar2.a;
                        aVar.b.remove(fubVar2);
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
