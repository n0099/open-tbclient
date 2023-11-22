package com.baidu.tieba;

import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class ima extends qq6<jpa> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ima() {
        super(jpa.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Class) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qq6
    public void onEvent(jpa event) {
        Unit unit;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            int b = event.b();
            if (b != 1) {
                if (b != 2) {
                    return;
                }
                HomeSpriteEdgeFloatManager.l.c().P();
                return;
            }
            kpa a = event.a();
            if (a != null) {
                HomeSpriteEdgeFloatManager.l.c().w(a);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
            }
        }
    }
}
