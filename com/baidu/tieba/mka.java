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
import com.baidu.tieba.qka;
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
/* loaded from: classes5.dex */
public class mka implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final mka c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<hka, a> b;

    /* loaded from: classes5.dex */
    public class a implements qka.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<xka<?>> a;
        public final Queue<xka<?>> b;
        public final qka c;
        public HonorPushErrorEnum d;
        public final hka e;
        public final /* synthetic */ mka f;

        public a(mka mkaVar, hka hkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mkaVar, hkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = mkaVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new tka(this);
            this.d = null;
            this.e = hkaVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                uja.g(this.f.a);
                tka tkaVar = (tka) this.c;
                int i = tkaVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        tkaVar.a.set(4);
                        return;
                    }
                    return;
                }
                wka wkaVar = tkaVar.d;
                if (wkaVar != null) {
                    wkaVar.c();
                }
                tkaVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    uja.g(this.f.a);
                    for (xka<?> xkaVar : this.a) {
                        xkaVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(xka<?> xkaVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xkaVar) == null) {
                synchronized (this) {
                    this.b.add(xkaVar);
                    qka qkaVar = this.c;
                    b bVar = new b(xkaVar);
                    xkaVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = xkaVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        wja.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + xkaVar.a);
                    IPushInvoke iPushInvoke = ((tka) qkaVar).b;
                    String str = xkaVar.a;
                    RequestHeader requestHeader = xkaVar.d;
                    IMessageEntity iMessageEntity = xkaVar.b;
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
                    uja.g(this.f.a);
                    this.d = null;
                    for (xka<?> xkaVar : this.a) {
                        c(xkaVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements ala {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public xka<?> a;

        public b(xka<?> xkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xkaVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947976934, "Lcom/baidu/tieba/mka;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947976934, "Lcom/baidu/tieba/mka;");
                return;
            }
        }
        c = new mka();
    }

    public mka() {
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

    public <TResult> nka<TResult> a(xka<TResult> xkaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xkaVar)) == null) {
            fla<TResult> flaVar = new fla<>();
            xkaVar.e = flaVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, xkaVar));
            return flaVar.a;
        }
        return (nka) invokeL.objValue;
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
                xka<?> xkaVar = (xka) message.obj;
                hka hkaVar = xkaVar.c;
                a aVar2 = this.b.get(hkaVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, hkaVar);
                    this.b.put(hkaVar, aVar2);
                }
                synchronized (aVar2) {
                    uja.g(aVar2.f.a);
                    String str = "sendRequest " + xkaVar.a;
                    if (((tka) aVar2.c).b()) {
                        aVar2.c(xkaVar);
                    } else {
                        aVar2.a.add(xkaVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                uja.g(aVar2.f.a);
                                if (((tka) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((tka) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        tka tkaVar = (tka) aVar2.c;
                                        tkaVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = tkaVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            bka bkaVar = bka.e;
                                            int b2 = HonorApiAvailability.b(bkaVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                tkaVar.a.set(5);
                                                xja a2 = HonorApiAvailability.a(bkaVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                wka wkaVar = new wka(a2);
                                                tkaVar.d = wkaVar;
                                                wkaVar.b = new ska(tkaVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + wkaVar.a;
                                                    wkaVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = wkaVar.a.c();
                                                    String b3 = wkaVar.a.b();
                                                    String d = wkaVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (wka.e) {
                                                        if (bkaVar.a().bindService(intent, wkaVar, 1)) {
                                                            Handler handler = wkaVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                wkaVar.c = new Handler(Looper.getMainLooper(), new vka(wkaVar));
                                                            }
                                                            wkaVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            wkaVar.d = true;
                                                            wkaVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                tkaVar.a(b2);
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
                xka xkaVar2 = (xka) message.obj;
                hka hkaVar2 = xkaVar2.c;
                if (hkaVar2 != null && this.b.containsKey(hkaVar2) && (aVar = this.b.get(hkaVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + xkaVar2.a;
                        aVar.b.remove(xkaVar2);
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
