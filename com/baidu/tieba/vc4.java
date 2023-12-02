package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.menu.viewpager.PointPageIndicator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vc4 extends PointPageIndicator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vc4(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.swan.menu.viewpager.PointPageIndicator
    public /* bridge */ /* synthetic */ PointPageIndicator d(Drawable drawable, Drawable drawable2) {
        g(drawable, drawable2);
        return this;
    }

    public vc4 g(Drawable drawable, Drawable drawable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable, drawable2)) == null) {
            this.a = drawable;
            this.b = drawable2;
            this.c.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.d.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            return this;
        }
        return (vc4) invokeLL.objValue;
    }
}
