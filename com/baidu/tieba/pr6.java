package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d67;
import com.baidu.tieba.view.TbLayerImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class pr6 implements d67.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pr6() {
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

    @Override // com.baidu.tieba.d67.c
    public void a(View view2, List<String> list) {
        TbLayerImageView tbLayerImageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, view2, list) != null) || list == null) {
            return;
        }
        if (view2 instanceof TbLayerImageView) {
            tbLayerImageView = (TbLayerImageView) view2;
        } else {
            tbLayerImageView = null;
        }
        if (tbLayerImageView != null) {
            tbLayerImageView.a(list);
        }
    }

    @Override // com.baidu.tieba.d67.c
    public View create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new TbLayerImageView(context, null, 0, 6, null);
        }
        return (View) invokeL.objValue;
    }
}
