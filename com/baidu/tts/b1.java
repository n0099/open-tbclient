package com.baidu.tts;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
/* loaded from: classes9.dex */
public class b1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Hashtable<WeakReference<Context>, a1> a;
    public WeakReference<Context> b;

    public b1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Hashtable<>();
    }

    public static b1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (b1.class) {
                    if (c == null) {
                        c = new b1();
                    }
                }
            }
            return c;
        }
        return (b1) invokeV.objValue;
    }

    public a1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WeakReference<Context> weakReference = this.b;
            if (weakReference == null) {
                return null;
            }
            a1 a1Var = this.a.get(weakReference);
            if (a1Var == null) {
                a1Var = new a1(weakReference);
                this.a.put(weakReference, a1Var);
            }
            return a1Var;
        }
        return (a1) invokeV.objValue;
    }

    public Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.get();
        }
        return (Context) invokeV.objValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.b = new WeakReference<>(context);
        }
    }

    public String c() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                a1 a = a();
                if (a == null) {
                    return null;
                }
                if (a.b == null) {
                    WeakReference<Context> weakReference = a.a;
                    if (weakReference == null) {
                        context = null;
                    } else {
                        context = weakReference.get();
                    }
                    String cuid = DeviceId.getCUID(context);
                    LoggerProxy.d("PrivacyInfoTool", "cuid=" + cuid);
                    a.b = cuid;
                }
                return a.b;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
