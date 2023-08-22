package com.baidu.titan.sdk.runtime;
/* loaded from: classes9.dex */
public abstract class InterceptableDelegate implements Interceptable {
    public Interceptable delegate;

    public abstract boolean waitLoad();

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeB(int i, Object obj, byte b) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeB(i, obj, b);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeCommon(int i, Object obj, Object[] objArr) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeCommon(i, obj, objArr);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeF(int i, Object obj, float f) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeF(i, obj, f);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeI(int i, Object obj, int i2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeI(i, obj, i2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeJ(int i, Object obj, long j) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeJ(i, obj, j);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeL(int i, Object obj, Object obj2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeL(i, obj, obj2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeZ(int i, Object obj, boolean z) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeZ(i, obj, z);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeII(int i, Object obj, int i2, int i3) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeII(i, obj, i2, i3);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeIL(int i, Object obj, int i2, Object obj2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeIL(i, obj, i2, obj2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeJL(int i, Object obj, long j, Object obj2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeJL(i, obj, j, obj2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLF(int i, Object obj, Object obj2, float f) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLF(i, obj, obj2, f);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLI(int i, Object obj, Object obj2, int i2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLI(i, obj, obj2, i2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLJ(int i, Object obj, Object obj2, long j) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLJ(i, obj, obj2, j);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLL(int i, Object obj, Object obj2, Object obj3) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLL(i, obj, obj2, obj3);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLZ(int i, Object obj, Object obj2, boolean z) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLZ(i, obj, obj2, z);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeZL(int i, Object obj, boolean z, Object obj2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeZL(i, obj, z, obj2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeIII(int i, Object obj, int i2, int i3, int i4) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeIII(i, obj, i2, i3, i4);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeIIL(int i, Object obj, int i2, int i3, Object obj2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeIIL(i, obj, i2, i3, obj2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeILL(int i, Object obj, int i2, Object obj2, Object obj3) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeILL(i, obj, i2, obj2, obj3);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLII(int i, Object obj, Object obj2, int i2, int i3) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLII(i, obj, obj2, i2, i3);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLIL(int i, Object obj, Object obj2, int i2, Object obj3) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLIL(i, obj, obj2, i2, obj3);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLI(int i, Object obj, Object obj2, Object obj3, int i2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLI(i, obj, obj2, obj3, i2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLL(int i, Object obj, Object obj2, Object obj3, Object obj4) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLL(i, obj, obj2, obj3, obj4);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLZ(int i, Object obj, Object obj2, Object obj3, boolean z) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLZ(i, obj, obj2, obj3, z);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeIIII(int i, Object obj, int i2, int i3, int i4, int i5) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeIIII(i, obj, i2, i3, i4, i5);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLIII(int i, Object obj, Object obj2, int i2, int i3, int i4) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLIII(i, obj, obj2, i2, i3, i4);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLILL(int i, Object obj, Object obj2, int i2, Object obj3, Object obj4) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLILL(i, obj, obj2, i2, obj3, obj4);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLII(int i, Object obj, Object obj2, Object obj3, int i2, int i3) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLII(i, obj, obj2, obj3, i2, i3);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLIL(int i, Object obj, Object obj2, Object obj3, int i2, Object obj4) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLIL(i, obj, obj2, obj3, i2, obj4);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLLI(int i, Object obj, Object obj2, Object obj3, Object obj4, int i2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLLI(i, obj, obj2, obj3, obj4, i2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLLL(int i, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLLL(i, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public void invokeInitBody(int i, InitContext initContext) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return;
        }
        interceptable.invokeInitBody(i, initContext);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public void invokeUnInit(int i, InitContext initContext) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return;
        }
        interceptable.invokeUnInit(i, initContext);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeV(int i, Object obj) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeV(i, obj);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLLLL(int i, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLLLL(i, obj, obj2, obj3, obj4, obj5, obj6);
    }
}
