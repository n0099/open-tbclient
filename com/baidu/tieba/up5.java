package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.RemoveViewNPE;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class up5 {
    public static /* synthetic */ Interceptable $ic;
    public static final up5 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948218703, "Lcom/baidu/tieba/up5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948218703, "Lcom/baidu/tieba/up5;");
                return;
            }
        }
        a = new up5();
    }

    public up5() {
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

    @JvmStatic
    public static final void a(BdRecyclerView viewGroup, int i, NullPointerException e) {
        zp5 zp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, viewGroup, i, e) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            Intrinsics.checkNotNullParameter(e, "e");
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "viewGroup.getChildAt(index)");
            if (childAt instanceof ViewGroup) {
                zp5Var = a.b((ViewGroup) childAt);
            } else {
                zp5Var = null;
            }
            if (zp5Var != null) {
                String str = "BdRecyclerView removeViewAt() NPE at index: " + i + ", the out parent is: [class: " + childAt.getClass().getSimpleName() + ", id: " + childAt.getId() + "], internal parent is: [class: " + zp5Var.b().getClass().getSimpleName() + ", id: " + zp5Var.b().getId() + "], child index is: " + zp5Var.a();
                Throwable initCause = new RemoveViewNPE().initCause(new Throwable(str, e));
                BdLog.detailException(initCause);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 6).param("obj_source", str));
                initCause.printStackTrace();
            }
        }
    }

    public final zp5 b(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    b((ViewGroup) childAt);
                } else if (childAt == null) {
                    return new zp5(viewGroup, i);
                }
            }
            return null;
        }
        return (zp5) invokeL.objValue;
    }
}
