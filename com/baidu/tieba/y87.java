package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ComponentFactory;
import tbclient.FrsTopThreadCardLayout;
import tbclient.FrsTopThreadComponent;
import tbclient.LayoutFactory;
/* loaded from: classes9.dex */
public final class y87 implements a97<LayoutFactory> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;

    public y87() {
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
        this.b = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a97
    /* renamed from: a */
    public rb7<?> b(LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        FrsTopThreadCardLayout frsTopThreadCardLayout;
        boolean z;
        FrsTopThreadComponent frsTopThreadComponent;
        i87 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, layoutFactory)) == null) {
            if (layoutFactory != null) {
                frsTopThreadCardLayout = layoutFactory.frs_top_thread_card;
            } else {
                frsTopThreadCardLayout = null;
            }
            if (frsTopThreadCardLayout != null) {
                List<ComponentFactory> list = layoutFactory.frs_top_thread_card.components;
                if (list != null && !list.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    ArrayList arrayList = new ArrayList();
                    for (ComponentFactory componentFactory : layoutFactory.frs_top_thread_card.components) {
                        if (Intrinsics.areEqual(componentFactory.component, "frs_top_thread") && (frsTopThreadComponent = componentFactory.frs_top_thread) != null && (a = v97.a(frsTopThreadComponent)) != null) {
                            arrayList.add(a);
                        }
                    }
                    return new sb7(new l57(arrayList, this.a, this.b), "feed_top_card");
                }
            }
            return null;
        }
        return (rb7) invokeL.objValue;
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.a = z;
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.b = str;
        }
    }
}
