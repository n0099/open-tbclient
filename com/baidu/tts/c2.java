package com.baidu.tts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class c2 implements Iterator<y1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    @Override // java.util.Iterator
    public void remove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public c2() {
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

    @Override // java.util.Iterator
    public boolean hasNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.d >= (this.a + 0) - 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: a */
    public y1 next() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            y1 y1Var = new y1();
            int i = (this.c + this.b) - 1;
            int i2 = this.a;
            int i3 = (i2 + 0) - 1;
            int i4 = this.e;
            y1Var.a = i4;
            if (i <= i3) {
                int i5 = (i - this.d) + 1;
                y1Var.b = i5;
                int i6 = i + 1;
                this.d = i6;
                this.c = i6;
                this.e = i4 + i5;
                y1Var.d = i6 / i2;
                y1Var.c = true;
            } else {
                int i7 = this.d;
                int i8 = i2 - i7;
                y1Var.b = i8;
                this.d = i7 + i8;
                this.e = i4 + i8;
            }
            return y1Var;
        }
        return (y1) invokeV.objValue;
    }
}
