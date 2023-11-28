package com.baidu.tieba;

import android.content.Context;
import android.content.MutableContextWrapper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
/* loaded from: classes7.dex */
public final class mx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947988063, "Lcom/baidu/tieba/mx5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947988063, "Lcom/baidu/tieba/mx5;");
        }
    }

    @JvmStatic
    public static final Lifecycle a(Context context) {
        InterceptResult invokeL;
        Context context2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context instanceof MutableContextWrapper) {
                context2 = ((MutableContextWrapper) context).getBaseContext();
            } else {
                context2 = context;
            }
            if (context2 instanceof FragmentActivity) {
                return ((FragmentActivity) context2).getLifecycle();
            }
            if (GlobalBuildConfig.isDebug()) {
                BdToast.makeText(context, "context isn't FragmentActivity:" + context).show();
                return null;
            }
            return null;
        }
        return (Lifecycle) invokeL.objValue;
    }
}
