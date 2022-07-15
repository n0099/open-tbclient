package com.bytedance.pangle.e.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;
    public int b;
    public int c;

    public c() {
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
        this.a = new int[32];
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b();
            int i = this.b;
            int[] iArr = this.a;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.b = i + 2;
            this.c++;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int[] iArr = this.a;
            int length = iArr.length;
            int i = this.b;
            int i2 = length - i;
            if (i2 <= 2) {
                int[] iArr2 = new int[(iArr.length + i2) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this.a = iArr2;
            }
        }
    }
}
