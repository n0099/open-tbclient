package com.baidu.ufosdk.hybrid.base;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
/* loaded from: classes8.dex */
public abstract class SingleActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public static WeakHashMap<String, WeakReference<SingleActivity>> e;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2089029132, "Lcom/baidu/ufosdk/hybrid/base/SingleActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2089029132, "Lcom/baidu/ufosdk/hybrid/base/SingleActivity;");
                return;
            }
        }
        e = new WeakHashMap<>();
    }

    public SingleActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.ufosdk.hybrid.base.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            if (d() == this) {
                synchronized (e) {
                    e.remove(this.d);
                }
            }
        }
    }

    public final SingleActivity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.d == null) {
                this.d = SingleActivity.class.getName();
            }
            WeakReference<SingleActivity> weakReference = e.get(this.d);
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (SingleActivity) invokeV.objValue;
    }

    @Override // com.baidu.ufosdk.hybrid.base.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            SingleActivity d = d();
            if (d != null) {
                d.finish();
            }
            synchronized (e) {
                e.put(this.d, new WeakReference<>(this));
            }
        }
    }
}
