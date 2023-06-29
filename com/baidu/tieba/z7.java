package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes8.dex */
public class z7<T> extends t6<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T[] e;
    public T[] f;
    public int g;

    public z7() {
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

    @Override // com.baidu.tieba.t6
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q();
            super.clear();
        }
    }

    @Override // com.baidu.tieba.t6
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            q();
            super.l();
        }
    }

    public T[] o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            q();
            T[] tArr = this.a;
            this.e = tArr;
            this.g++;
            return tArr;
        }
        return (T[]) ((Object[]) invokeV.objValue);
    }

    @Override // com.baidu.tieba.t6
    public T pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            q();
            return (T) super.pop();
        }
        return (T) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z7(Class cls) {
        super(cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Class) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z7(boolean z, int i) {
        super(z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.t6
    public T h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            q();
            return (T) super.h(i);
        }
        return (T) invokeI.objValue;
    }

    @Override // com.baidu.tieba.t6
    public void sort(Comparator<? super T> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, comparator) == null) {
            q();
            super.sort(comparator);
        }
    }

    @Override // com.baidu.tieba.t6
    public boolean i(T t, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, t, z)) == null) {
            q();
            return super.i(t, z);
        }
        return invokeLZ.booleanValue;
    }

    @Override // com.baidu.tieba.t6
    public void insert(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, t) == null) {
            q();
            super.insert(i, t);
        }
    }

    @Override // com.baidu.tieba.t6
    public void k(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, t) == null) {
            q();
            super.k(i, t);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int max = Math.max(0, this.g - 1);
            this.g = max;
            T[] tArr = this.e;
            if (tArr == null) {
                return;
            }
            if (tArr != this.a && max == 0) {
                this.f = tArr;
                int length = tArr.length;
                for (int i = 0; i < length; i++) {
                    this.f[i] = null;
                }
            }
            this.e = null;
        }
    }

    public final void q() {
        T[] tArr;
        T[] tArr2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (tArr = this.e) != null && tArr == (tArr2 = this.a)) {
            T[] tArr3 = this.f;
            if (tArr3 != null) {
                int length = tArr3.length;
                int i = this.b;
                if (length >= i) {
                    System.arraycopy(tArr2, 0, tArr3, 0, i);
                    this.a = this.f;
                    this.f = null;
                    return;
                }
            }
            j(this.a.length);
        }
    }
}
