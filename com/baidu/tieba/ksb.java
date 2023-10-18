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
import com.baidu.tieba.osb;
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
/* loaded from: classes6.dex */
public class ksb implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final ksb c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final Map<fsb, a> b;

    /* loaded from: classes6.dex */
    public class a implements osb.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<vsb<?>> a;
        public final Queue<vsb<?>> b;
        public final osb c;
        public HonorPushErrorEnum d;
        public final fsb e;
        public final /* synthetic */ ksb f;

        public a(ksb ksbVar, fsb fsbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ksbVar, fsbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ksbVar;
            this.a = new LinkedList();
            this.b = new LinkedList();
            this.c = new rsb(this);
            this.d = null;
            this.e = fsbVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                srb.g(this.f.a);
                rsb rsbVar = (rsb) this.c;
                int i = rsbVar.a.get();
                Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
                if (i != 3) {
                    if (i == 5) {
                        rsbVar.a.set(4);
                        return;
                    }
                    return;
                }
                usb usbVar = rsbVar.d;
                if (usbVar != null) {
                    usbVar.c();
                }
                rsbVar.a.set(1);
            }
        }

        public final synchronized void b(HonorPushErrorEnum honorPushErrorEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, honorPushErrorEnum) == null) {
                synchronized (this) {
                    Log.i("HonorApiManager", "onConnectionFailed");
                    srb.g(this.f.a);
                    for (vsb<?> vsbVar : this.a) {
                        vsbVar.b(honorPushErrorEnum.toApiException(), null);
                    }
                    this.a.clear();
                    this.d = honorPushErrorEnum;
                    a();
                    this.f.b.remove(this.e);
                }
            }
        }

        public final synchronized void c(vsb<?> vsbVar) {
            Class cls;
            Type type;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vsbVar) == null) {
                synchronized (this) {
                    this.b.add(vsbVar);
                    osb osbVar = this.c;
                    b bVar = new b(vsbVar);
                    vsbVar.getClass();
                    Object obj = null;
                    try {
                        Type genericSuperclass = vsbVar.getClass().getGenericSuperclass();
                        if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) != null) {
                            cls = (Class) type;
                        } else {
                            cls = null;
                        }
                        if (cls != null && !cls.isPrimitive()) {
                            obj = cls.newInstance();
                        }
                    } catch (Exception e) {
                        urb.a("In newResponseInstance, instancing exception." + e.getMessage());
                    }
                    com.hihonor.push.sdk.r rVar = new com.hihonor.push.sdk.r(obj, bVar);
                    Log.i(IPCTransport.TAG, "start transport parse. " + vsbVar.a);
                    IPushInvoke iPushInvoke = ((rsb) osbVar).b;
                    String str = vsbVar.a;
                    RequestHeader requestHeader = vsbVar.d;
                    IMessageEntity iMessageEntity = vsbVar.b;
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
                    srb.g(this.f.a);
                    this.d = null;
                    for (vsb<?> vsbVar : this.a) {
                        c(vsbVar);
                    }
                    this.a.clear();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements ysb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public vsb<?> a;

        public b(vsb<?> vsbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vsbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vsbVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947925071, "Lcom/baidu/tieba/ksb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947925071, "Lcom/baidu/tieba/ksb;");
                return;
            }
        }
        c = new ksb();
    }

    public ksb() {
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

    public <TResult> lsb<TResult> a(vsb<TResult> vsbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vsbVar)) == null) {
            dtb<TResult> dtbVar = new dtb<>();
            vsbVar.e = dtbVar;
            Log.i("HonorApiManager", "sendRequest start");
            Handler handler = this.a;
            handler.sendMessage(handler.obtainMessage(1, vsbVar));
            return dtbVar.a;
        }
        return (lsb) invokeL.objValue;
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
                vsb<?> vsbVar = (vsb) message.obj;
                fsb fsbVar = vsbVar.c;
                a aVar2 = this.b.get(fsbVar);
                if (aVar2 == null) {
                    Log.i("HonorApiManager", "connect and send request, create new connection manager.");
                    aVar2 = new a(this, fsbVar);
                    this.b.put(fsbVar, aVar2);
                }
                synchronized (aVar2) {
                    srb.g(aVar2.f.a);
                    String str = "sendRequest " + vsbVar.a;
                    if (((rsb) aVar2.c).b()) {
                        aVar2.c(vsbVar);
                    } else {
                        aVar2.a.add(vsbVar);
                        HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                        if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                            aVar2.b(aVar2.d);
                        } else {
                            synchronized (aVar2) {
                                srb.g(aVar2.f.a);
                                if (((rsb) aVar2.c).b()) {
                                    Log.i("HonorApiManager", "client is connected");
                                } else {
                                    if (((rsb) aVar2.c).a.get() == 5) {
                                        z = true;
                                    }
                                    if (z) {
                                        Log.i("HonorApiManager", "client is isConnecting");
                                    } else {
                                        rsb rsbVar = (rsb) aVar2.c;
                                        rsbVar.getClass();
                                        Log.i("PushConnectionClient", "  ====  PUSHSDK VERSION 70001103 ====");
                                        int i2 = rsbVar.a.get();
                                        Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                        if (i2 != 3 && i2 != 5 && i2 != 4) {
                                            zrb zrbVar = zrb.e;
                                            int b2 = HonorApiAvailability.b(zrbVar.a());
                                            if (b2 == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                                rsbVar.a.set(5);
                                                vrb a2 = HonorApiAvailability.a(zrbVar.a());
                                                Log.i("PushConnectionClient", "enter bindCoreService.");
                                                usb usbVar = new usb(a2);
                                                rsbVar.d = usbVar;
                                                usbVar.b = new qsb(rsbVar);
                                                if (!a2.a()) {
                                                    String str2 = "bind core is null : " + usbVar.a;
                                                    usbVar.b(8002004);
                                                } else {
                                                    Intent intent = new Intent();
                                                    String c2 = usbVar.a.c();
                                                    String b3 = usbVar.a.b();
                                                    String d = usbVar.a.d();
                                                    if (!TextUtils.isEmpty(d)) {
                                                        intent.setComponent(new ComponentName(c2, d));
                                                    } else {
                                                        intent.setAction(b3);
                                                        intent.setPackage(c2);
                                                    }
                                                    synchronized (usb.e) {
                                                        if (zrbVar.a().bindService(intent, usbVar, 1)) {
                                                            Handler handler = usbVar.c;
                                                            if (handler != null) {
                                                                handler.removeMessages(1001);
                                                            } else {
                                                                usbVar.c = new Handler(Looper.getMainLooper(), new tsb(usbVar));
                                                            }
                                                            usbVar.c.sendEmptyMessageDelayed(1001, 10000L);
                                                        } else {
                                                            usbVar.d = true;
                                                            usbVar.b(8002001);
                                                        }
                                                    }
                                                }
                                            } else {
                                                rsbVar.a(b2);
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
                vsb vsbVar2 = (vsb) message.obj;
                fsb fsbVar2 = vsbVar2.c;
                if (fsbVar2 != null && this.b.containsKey(fsbVar2) && (aVar = this.b.get(fsbVar2)) != null) {
                    synchronized (aVar) {
                        String str3 = "resolveResult apiCall " + vsbVar2.a;
                        aVar.b.remove(vsbVar2);
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
