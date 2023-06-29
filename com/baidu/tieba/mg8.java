package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class mg8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, og8> a;
    public og8 b;
    public long c;

    @JvmOverloads
    public final void c(AbilityItem abilityItem, BaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, abilityItem, baseMsg) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            e(this, abilityItem, baseMsg, null, 4, null);
        }
    }

    public mg8() {
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
        this.a = new LinkedHashMap();
    }

    public static /* synthetic */ void e(mg8 mg8Var, AbilityItem abilityItem, BaseMsg baseMsg, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        mg8Var.d(abilityItem, baseMsg, obj);
    }

    public final void a(og8 handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, handler) == null) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            if (handler.c()) {
                this.b = handler;
            }
            for (String str : handler.e()) {
                this.a.put(str, handler);
            }
        }
    }

    public final void b(AbilityItem abilityItem, BaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abilityItem, baseMsg) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            og8 og8Var = this.b;
            if (og8Var != null) {
                og8Var.b(abilityItem, baseMsg, null);
            }
        }
    }

    @JvmOverloads
    public final void d(AbilityItem abilityItem, BaseMsg baseMsg, Object obj) {
        Unit unit;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, abilityItem, baseMsg, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            try {
                og8 og8Var = this.a.get(abilityItem.getType());
                if (og8Var != null) {
                    og8Var.b(abilityItem, baseMsg, obj);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    b(abilityItem, baseMsg);
                }
            } catch (Exception e) {
                zf8.g("ability_handle_exception", this.c, e);
            }
        }
    }

    public final void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.c = j;
        }
    }
}
