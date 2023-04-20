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
import com.baidu.tieba.pua;
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
public class lua implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final lua c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<gua, a> b;

    /* loaded from: classes5.dex */
    public class a implements pua.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<wua<?>> a;
        public final Queue<wua<?>> b;
        public final pua c;
        public HonorPushErrorEnum d;
        public final gua e;
        public final /* synthetic */ lua f;

        public a(lua luaVar, gua guaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {luaVar, guaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = luaVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new sua(this);
            this.d = null;
            this.e = guaVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tta.g(this.f.a);
                sua suaVar = (sua) this.c;
                int i = suaVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        suaVar.a.set(4);
                        return;
                    }
                    return;
                }
                vua vuaVar = suaVar.d;
                if (vuaVar != null) {
                    vuaVar.c();
                }
                suaVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    tta.g(this.f.a);
                    for (wua<?> wuaVar : this.a) {
                        wuaVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(wua<?> wuaVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wuaVar) == null) {
                synchronized (this) {
                    this.b.add(wuaVar);
                    pua puaVar = this.c;
                    b bVar = new b(wuaVar);
                    wuaVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = wuaVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        vta.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + wuaVar.a);
                    IPushInvoke iPushInvoke = ((sua) puaVar).b;
                    String str = wuaVar.a;
                    RequestHeader requestHeader = wuaVar.d;
                    IMessageEntity iMessageEntity = wuaVar.b;
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
                    tta.g(this.f.a);
                    this.d = null;
                    for (wua<?> wuaVar : this.a) {
                        c(wuaVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements zua {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public wua<?> a;

        public b(wua<?> wuaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wuaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wuaVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947956753, "Lcom/baidu/tieba/lua;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947956753, "Lcom/baidu/tieba/lua;");
                return;
            }
        }
        c = new lua();
    }

    public lua() {
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

    public <TResult> mua<TResult> a(wua<TResult> wuaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wuaVar)) == null) {
            eva<TResult> evaVar = new eva<>();
            wuaVar.e = evaVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, wuaVar));
            return evaVar.a;
        }
        return (mua) invokeL.objValue;
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
                wua<?> wuaVar = (wua) message.obj;
                gua guaVar = wuaVar.c;
                a aVar2 = this.b.get(guaVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, guaVar);
                    this.b.put(guaVar, aVar2);
                }
                synchronized (aVar2) {
                    tta.g(aVar2.f.a);
                    String str = "sendRequest " + wuaVar.a;
                    if (((sua) aVar2.c).b()) {
                        aVar2.c(wuaVar);
                    } else {
                        aVar2.a.add(wuaVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                tta.g(aVar2.f.a);
                                if (((sua) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((sua) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        sua suaVar = (sua) aVar2.c;
                                        suaVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = suaVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            aua auaVar = aua.e;
                                            int b2 = HonorApiAvailability.b(auaVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                suaVar.a.set(5);
                                                wta a2 = HonorApiAvailability.a(auaVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                vua vuaVar = new vua(a2);
                                                suaVar.d = vuaVar;
                                                vuaVar.b = new rua(suaVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + vuaVar.a;
                                                    vuaVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = vuaVar.a.c();
                                                    String b3 = vuaVar.a.b();
                                                    String d = vuaVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (vua.e) {
                                                        if (auaVar.a().bindService(intent, vuaVar, 1)) {
                                                            Handler handler = vuaVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                vuaVar.c = new Handler(Looper.getMainLooper(), new uua(vuaVar));
                                                            }
                                                            vuaVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            vuaVar.d = true;
                                                            vuaVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                suaVar.a(b2);
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
                wua wuaVar2 = (wua) message.obj;
                gua guaVar2 = wuaVar2.c;
                if (guaVar2 != null && this.b.containsKey(guaVar2) && (aVar = this.b.get(guaVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + wuaVar2.a;
                        aVar.b.remove(wuaVar2);
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
