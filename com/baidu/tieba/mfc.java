package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
/* loaded from: classes7.dex */
public final class mfc {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<mfc> d;
    public transient /* synthetic */ FieldHolder $fh;
    public nfc a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947972191, "Lcom/baidu/tieba/mfc;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947972191, "Lcom/baidu/tieba/mfc;");
        }
    }

    public mfc(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        rfc.b();
        this.a = new nfc(context, str);
        this.b = str;
        this.c = context;
    }

    public static mfc b(Context context, String str) {
        InterceptResult invokeLL;
        mfc mfcVar;
        mfc mfcVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<mfc> softReference = d;
                if (softReference == null) {
                    mfcVar = null;
                } else {
                    mfcVar = softReference.get();
                }
                if (mfcVar == null || !str.equals(mfcVar.b)) {
                    synchronized (mfc.class) {
                        mfcVar2 = new mfc(context, str);
                        d = new SoftReference<>(mfcVar2);
                    }
                    return mfcVar2;
                }
                return mfcVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (mfc) invokeLL.objValue;
    }

    public final void a(Activity activity, kfc kfcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, kfcVar) == null) {
            this.a.c(activity, "123", kfcVar);
        }
    }

    public final void c(int i, int i2, Intent intent, kfc kfcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, kfcVar}) == null) {
            this.a.d(i, i2, intent, kfcVar);
        }
    }
}
