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
import com.baidu.tieba.ryb;
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
public class nyb implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final nyb c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<iyb, a> b;

    /* loaded from: classes7.dex */
    public class a implements ryb.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<yyb<?>> a;
        public final Queue<yyb<?>> b;
        public final ryb c;
        public HonorPushErrorEnum d;
        public final iyb e;
        public final /* synthetic */ nyb f;

        public a(nyb nybVar, iyb iybVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nybVar, iybVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = nybVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new uyb(this);
            this.d = null;
            this.e = iybVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vxb.g(this.f.a);
                uyb uybVar = (uyb) this.c;
                int i = uybVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        uybVar.a.set(4);
                        return;
                    }
                    return;
                }
                xyb xybVar = uybVar.d;
                if (xybVar != null) {
                    xybVar.c();
                }
                uybVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    vxb.g(this.f.a);
                    for (yyb<?> yybVar : this.a) {
                        yybVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(yyb<?> yybVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yybVar) == null) {
                synchronized (this) {
                    this.b.add(yybVar);
                    ryb rybVar = this.c;
                    b bVar = new b(yybVar);
                    yybVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = yybVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        xxb.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + yybVar.a);
                    IPushInvoke iPushInvoke = ((uyb) rybVar).b;
                    String str = yybVar.a;
                    RequestHeader requestHeader = yybVar.d;
                    IMessageEntity iMessageEntity = yybVar.b;
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
                    vxb.g(this.f.a);
                    this.d = null;
                    for (yyb<?> yybVar : this.a) {
                        c(yybVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements bzb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public yyb<?> a;

        public b(yyb<?> yybVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yybVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yybVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948020210, "Lcom/baidu/tieba/nyb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948020210, "Lcom/baidu/tieba/nyb;");
                return;
            }
        }
        c = new nyb();
    }

    public nyb() {
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

    public <TResult> oyb<TResult> a(yyb<TResult> yybVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yybVar)) == null) {
            gzb<TResult> gzbVar = new gzb<>();
            yybVar.e = gzbVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, yybVar));
            return gzbVar.a;
        }
        return (oyb) invokeL.objValue;
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
                yyb<?> yybVar = (yyb) message.obj;
                iyb iybVar = yybVar.c;
                a aVar2 = this.b.get(iybVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, iybVar);
                    this.b.put(iybVar, aVar2);
                }
                synchronized (aVar2) {
                    vxb.g(aVar2.f.a);
                    String str = "sendRequest " + yybVar.a;
                    if (((uyb) aVar2.c).b()) {
                        aVar2.c(yybVar);
                    } else {
                        aVar2.a.add(yybVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                vxb.g(aVar2.f.a);
                                if (((uyb) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((uyb) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        uyb uybVar = (uyb) aVar2.c;
                                        uybVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = uybVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            cyb cybVar = cyb.e;
                                            int b2 = HonorApiAvailability.b(cybVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                uybVar.a.set(5);
                                                yxb a2 = HonorApiAvailability.a(cybVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                xyb xybVar = new xyb(a2);
                                                uybVar.d = xybVar;
                                                xybVar.b = new tyb(uybVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + xybVar.a;
                                                    xybVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = xybVar.a.c();
                                                    String b3 = xybVar.a.b();
                                                    String d = xybVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (xyb.e) {
                                                        if (cybVar.a().bindService(intent, xybVar, 1)) {
                                                            Handler handler = xybVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                xybVar.c = new Handler(Looper.getMainLooper(), new wyb(xybVar));
                                                            }
                                                            xybVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            xybVar.d = true;
                                                            xybVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                uybVar.a(b2);
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
                yyb yybVar2 = (yyb) message.obj;
                iyb iybVar2 = yybVar2.c;
                if (iybVar2 != null && this.b.containsKey(iybVar2) && (aVar = this.b.get(iybVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + yybVar2.a;
                        aVar.b.remove(yybVar2);
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
