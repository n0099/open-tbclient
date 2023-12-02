package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class tw0 extends ow0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.mt0
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new int[]{1} : (int[]) invokeV.objValue;
    }

    public tw0() {
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

    @Override // com.baidu.tieba.ow0, com.baidu.tieba.mt0
    public void o(ms0 event) {
        sp0 it;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(SystemEvent.ACTION_VOLUME_CHANGED, event.c()) && (it = i()) != null) {
                Intrinsics.checkNotNullExpressionValue(it, "player");
                if (!it.Y() && !it.P()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    it = null;
                }
                if (it != null) {
                    int g = event.g(5);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    er0 z2 = it.z();
                    Intrinsics.checkNotNullExpressionValue(z2, "it.playerCallbackManager");
                    yq0 c = z2.c();
                    if (c != null) {
                        c.a(g);
                    }
                }
            }
        }
    }
}
