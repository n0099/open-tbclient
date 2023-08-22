package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public abstract class ob8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nb8 a;

    public abstract void c(AbilityItem abilityItem, TbBaseMsg tbBaseMsg, Object obj);

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public ob8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public Set<String> f() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String e = e();
            if (e.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return SetsKt__SetsKt.emptySet();
            }
            return SetsKt__SetsJVMKt.setOf(e);
        }
        return (Set) invokeV.objValue;
    }

    public static /* synthetic */ void b(ob8 ob8Var, AbilityItem abilityItem, TbBaseMsg tbBaseMsg, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                tbBaseMsg = null;
            }
            ob8Var.a(abilityItem, tbBaseMsg);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doDefaultHandle");
    }

    public final void a(AbilityItem abilityItem, TbBaseMsg tbBaseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, abilityItem, tbBaseMsg) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            nb8 nb8Var = this.a;
            if (nb8Var != null) {
                nb8Var.b(abilityItem, tbBaseMsg);
            }
        }
    }
}
