package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class t0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t0() {
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

    public void a(View view2, int i, int i2, float f) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)}) == null) {
            if (view2 instanceof TextView) {
                textView = (TextView) view2;
            } else {
                textView = null;
            }
            if (textView != null) {
                textView.setTextColor(r0.d(f, i, i2));
            }
        }
    }

    public void b(View view2, int i, int i2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)}) == null) {
            e(view2, r0.d(f, i, i2));
        }
    }

    public void c(View view2, float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) && view2 != null) {
            float f4 = f + ((f2 - f) * f3);
            view2.setScaleX(f4);
            view2.setScaleY(f4);
        }
    }

    public void d(TextView textView, float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{textView, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) && textView != null) {
            textView.setTextSize(0, f + ((f2 - f) * f3));
        }
    }

    public void e(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, view2, i) == null) && view2 != null) {
            r0.D(view2, i);
        }
    }
}
