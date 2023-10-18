package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class yo implements bn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> a;
    public final ck b;

    public yo(ck ckVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ckVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ckVar;
    }

    @Override // com.baidu.tieba.bn
    public void b(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && !ao.a(activity)) {
            this.a = new WeakReference<>(activity);
        }
    }

    @Override // com.baidu.tieba.bn
    public Activity a() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WeakReference<Activity> weakReference = this.a;
            if (weakReference == null) {
                return null;
            }
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            if (ao.a(activity)) {
                return null;
            }
            return activity;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bn
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.u();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bn
    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context l = this.b.l();
            Intrinsics.checkExpressionValueIsNotNull(l, "bdTaskConfig.context");
            return l;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bn
    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String k = this.b.k();
            Intrinsics.checkExpressionValueIsNotNull(k, "bdTaskConfig.appVersion");
            return k;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bn
    public cn getEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            cn s = this.b.s();
            Intrinsics.checkExpressionValueIsNotNull(s, "bdTaskConfig.taskEnv");
            return s;
        }
        return (cn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bn
    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String r = this.b.r();
            Intrinsics.checkExpressionValueIsNotNull(r, "bdTaskConfig.sdkVersion");
            return r;
        }
        return (String) invokeV.objValue;
    }
}
