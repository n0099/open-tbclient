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
import com.baidu.tieba.sab;
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
public class oab implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final oab c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<jab, a> b;

    /* loaded from: classes7.dex */
    public class a implements sab.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<zab<?>> a;
        public final Queue<zab<?>> b;
        public final sab c;
        public HonorPushErrorEnum d;
        public final jab e;
        public final /* synthetic */ oab f;

        public a(oab oabVar, jab jabVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oabVar, jabVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = oabVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new vab(this);
            this.d = null;
            this.e = jabVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w9b.g(this.f.a);
                vab vabVar = (vab) this.c;
                int i = vabVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        vabVar.a.set(4);
                        return;
                    }
                    return;
                }
                yab yabVar = vabVar.d;
                if (yabVar != null) {
                    yabVar.c();
                }
                vabVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    w9b.g(this.f.a);
                    for (zab<?> zabVar : this.a) {
                        zabVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(zab<?> zabVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zabVar) == null) {
                synchronized (this) {
                    this.b.add(zabVar);
                    sab sabVar = this.c;
                    b bVar = new b(zabVar);
                    zabVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = zabVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        y9b.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + zabVar.a);
                    IPushInvoke iPushInvoke = ((vab) sabVar).b;
                    String str = zabVar.a;
                    RequestHeader requestHeader = zabVar.d;
                    IMessageEntity iMessageEntity = zabVar.b;
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
                    w9b.g(this.f.a);
                    this.d = null;
                    for (zab<?> zabVar : this.a) {
                        c(zabVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements cbb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public zab<?> a;

        public b(zab<?> zabVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zabVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zabVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948026937, "Lcom/baidu/tieba/oab;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948026937, "Lcom/baidu/tieba/oab;");
                return;
            }
        }
        c = new oab();
    }

    public oab() {
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

    public <TResult> pab<TResult> a(zab<TResult> zabVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zabVar)) == null) {
            hbb<TResult> hbbVar = new hbb<>();
            zabVar.e = hbbVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, zabVar));
            return hbbVar.a;
        }
        return (pab) invokeL.objValue;
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
                zab<?> zabVar = (zab) message.obj;
                jab jabVar = zabVar.c;
                a aVar2 = this.b.get(jabVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, jabVar);
                    this.b.put(jabVar, aVar2);
                }
                synchronized (aVar2) {
                    w9b.g(aVar2.f.a);
                    String str = "sendRequest " + zabVar.a;
                    if (((vab) aVar2.c).b()) {
                        aVar2.c(zabVar);
                    } else {
                        aVar2.a.add(zabVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                w9b.g(aVar2.f.a);
                                if (((vab) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((vab) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        vab vabVar = (vab) aVar2.c;
                                        vabVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = vabVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            dab dabVar = dab.e;
                                            int b2 = HonorApiAvailability.b(dabVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                vabVar.a.set(5);
                                                z9b a2 = HonorApiAvailability.a(dabVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                yab yabVar = new yab(a2);
                                                vabVar.d = yabVar;
                                                yabVar.b = new uab(vabVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + yabVar.a;
                                                    yabVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = yabVar.a.c();
                                                    String b3 = yabVar.a.b();
                                                    String d = yabVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (yab.e) {
                                                        if (dabVar.a().bindService(intent, yabVar, 1)) {
                                                            Handler handler = yabVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                yabVar.c = new Handler(Looper.getMainLooper(), new xab(yabVar));
                                                            }
                                                            yabVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            yabVar.d = true;
                                                            yabVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                vabVar.a(b2);
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
                zab zabVar2 = (zab) message.obj;
                jab jabVar2 = zabVar2.c;
                if (jabVar2 != null && this.b.containsKey(jabVar2) && (aVar = this.b.get(jabVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + zabVar2.a;
                        aVar.b.remove(zabVar2);
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
