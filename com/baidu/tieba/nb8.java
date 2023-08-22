package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class nb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, ob8> a;
    public ob8 b;
    public long c;

    public nb8() {
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

    public final void a(ob8 handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, handler) == null) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            if (handler.d()) {
                this.b = handler;
            }
            for (String str : handler.f()) {
                this.a.put(str, handler);
            }
        }
    }

    public final void b(AbilityItem abilityItem, TbBaseMsg tbBaseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abilityItem, tbBaseMsg) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            ob8 ob8Var = this.b;
            if (ob8Var != null) {
                ob8Var.c(abilityItem, tbBaseMsg, null);
            }
        }
    }

    @JvmOverloads
    public final void c(AbilityItem abilityItem, TbBaseMsg tbBaseMsg, Object obj) {
        Unit unit;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, abilityItem, tbBaseMsg, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            try {
                ob8 ob8Var = this.a.get(abilityItem.getType());
                if (ob8Var != null) {
                    ob8Var.c(abilityItem, tbBaseMsg, obj);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    b(abilityItem, tbBaseMsg);
                }
            } catch (Exception e) {
                rm8.g("ability_handle_exception", this.c, e);
            }
        }
    }
}
