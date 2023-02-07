package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] a;
    public int b;
    public boolean c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p7() {
        this(true, 16);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Boolean) objArr[0]).booleanValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p7(int i) {
        this(true, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public p7(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.c = z;
        this.a = new float[i];
    }

    public void a(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            float[] fArr = this.a;
            int i = this.b;
            if (i == fArr.length) {
                fArr = d(Math.max(8, (int) (i * 1.75f)));
            }
            int i2 = this.b;
            this.b = i2 + 1;
            fArr[i2] = f;
        }
    }

    public float[] d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            float[] fArr = new float[i];
            System.arraycopy(this.a, 0, fArr, 0, Math.min(this.b, i));
            this.a = fArr;
            return fArr;
        }
        return (float[]) invokeI.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = 0;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.c) {
                return super.hashCode();
            }
            float[] fArr = this.a;
            int i = this.b;
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                i2 = (i2 * 31) + a8.b(fArr[i3]);
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public float c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i < this.b) {
                return this.a[i];
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
        }
        return invokeI.floatValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!this.c || !(obj instanceof p7)) {
                return false;
            }
            p7 p7Var = (p7) obj;
            if (!p7Var.c || (i = this.b) != p7Var.b) {
                return false;
            }
            float[] fArr = this.a;
            float[] fArr2 = p7Var.a;
            for (int i2 = 0; i2 < i; i2++) {
                if (fArr[i2] != fArr2[i2]) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void insert(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            int i2 = this.b;
            if (i <= i2) {
                float[] fArr = this.a;
                if (i2 == fArr.length) {
                    fArr = d(Math.max(8, (int) (i2 * 1.75f)));
                }
                if (this.c) {
                    System.arraycopy(fArr, i, fArr, i + 1, this.b - i);
                } else {
                    fArr[this.b] = fArr[i];
                }
                this.b++;
                fArr[i] = f;
                return;
            }
            throw new IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.b);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.b == 0) {
                return "[]";
            }
            float[] fArr = this.a;
            q8 q8Var = new q8(32);
            q8Var.a('[');
            q8Var.c(fArr[0]);
            for (int i = 1; i < this.b; i++) {
                q8Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                q8Var.c(fArr[i]);
            }
            q8Var.a(']');
            return q8Var.toString();
        }
        return (String) invokeV.objValue;
    }
}
