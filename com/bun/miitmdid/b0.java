package com.bun.miitmdid;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
/* loaded from: classes3.dex */
public class b0 extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public Context f53085i;

    public b0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53085i = context;
    }

    @Override // com.bun.miitmdid.m
    public g a() {
        InterceptResult invokeV;
        Class<?> cls;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            g gVar = new g();
            this.f53085i = a(this.f53085i);
            try {
                cls = Class.forName("android.app.ZteDeviceIdentifyManager");
            } catch (Exception e2) {
                e0.b("ZteNewProvider", "init ZteDeviceIdentifyManager Exception: " + e2.getMessage());
                e2.printStackTrace();
                cls = null;
                obj = null;
            }
            if (cls != null) {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Context.class);
                if (declaredConstructor != null) {
                    declaredConstructor.setAccessible(true);
                    obj = declaredConstructor.newInstance(this.f53085i);
                    if (obj != null) {
                        Class<?> cls2 = cls;
                        Object obj2 = obj;
                        gVar.e(new h(cls2, obj2, "isSupported", null, null));
                        gVar.d(null);
                        gVar.b(new h(cls2, obj2, "getOAID", new Class[]{Context.class}, new Object[]{this.f53085i}));
                        gVar.c(new h(cls2, obj2, "getVAID", new Class[]{Context.class}, new Object[]{this.f53085i}));
                        gVar.a(new h(cls2, obj2, "getAAID", new Class[]{Context.class}, new Object[]{this.f53085i}));
                        return gVar;
                    }
                    throw new RuntimeException("get ZteDeviceIdentifyManager object failed");
                }
                throw new RuntimeException("get ZteDeviceIdentifyManager constructor failed");
            }
            throw new RuntimeException("get ZteDeviceIdentifyManager class failed");
        }
        return (g) invokeV.objValue;
    }

    @Override // com.bun.miitmdid.m, com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e0.c("ZteNewProvider", "doStart()");
            isSupported();
            isLimited();
            getOAID();
            getVAID();
            getAAID();
            if (this.a == null) {
                e0.d("ZteNewProvider", "doStart: callback Listener is null");
            } else if (this.f53130g && (str = this.f53127d) != null && !str.isEmpty()) {
                e0.c("ZteNewProvider", "new interface success");
                a(this.f53127d, this.f53128e, this.f53129f, this.f53130g, this.f53131h);
            } else {
                this.f53085i = a(this.f53085i);
                e0.c("ZteNewProvider", "try to call old interface");
                new c0(this.f53085i).doStartInThreadPool(this.a);
            }
        }
    }

    @Override // com.bun.miitmdid.m, com.bun.miitmdid.interfaces.IIdProvider
    public boolean isSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
