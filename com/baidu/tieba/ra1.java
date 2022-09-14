package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ra1 implements ta1 {
    public static /* synthetic */ Interceptable $ic;
    public static ra1 b;
    public static va1 c;
    public static za1 d;
    public static ya1 e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public ra1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
        d = new za1();
        e = new ya1(context);
        c = new va1();
    }

    public static ya1 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (e == null) {
                e = new ya1(context);
            }
            return e;
        }
        return (ya1) invokeL.objValue;
    }

    public static za1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                d = new za1();
            }
            return d;
        }
        return (za1) invokeV.objValue;
    }

    public static ra1 d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (b == null) {
                synchronized (ra1.class) {
                    if (b == null) {
                        b = new ra1(context);
                    }
                }
            }
            return b;
        }
        return (ra1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ta1
    public void a(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) {
            e(imageView, str, 0, 0);
        }
    }

    public void e(ImageView imageView, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, str, i, i2) == null) {
            imageView.setTag(str);
            Bitmap c2 = d.c(str);
            if (c2 != null) {
                imageView.setImageBitmap(c2);
            } else {
                pb1.a(new xa1(this.a, c, str, imageView, i, i2));
            }
        }
    }
}
