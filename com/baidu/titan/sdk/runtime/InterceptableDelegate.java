package com.baidu.titan.sdk.runtime;
/* loaded from: classes11.dex */
public abstract class InterceptableDelegate implements Interceptable {
    public Interceptable delegate;

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeB(int i2, Object obj, byte b2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeB(i2, obj, b2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeCommon(int i2, Object obj, Object[] objArr) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeCommon(i2, obj, objArr);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeF(int i2, Object obj, float f2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeF(i2, obj, f2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeI(int i2, Object obj, int i3) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeI(i2, obj, i3);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeII(int i2, Object obj, int i3, int i4) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeII(i2, obj, i3, i4);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeIII(int i2, Object obj, int i3, int i4, int i5) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeIII(i2, obj, i3, i4, i5);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeIIII(int i2, Object obj, int i3, int i4, int i5, int i6) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeIIII(i2, obj, i3, i4, i5, i6);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeIIL(int i2, Object obj, int i3, int i4, Object obj2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeIIL(i2, obj, i3, i4, obj2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeIL(int i2, Object obj, int i3, Object obj2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeIL(i2, obj, i3, obj2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeILL(int i2, Object obj, int i3, Object obj2, Object obj3) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeILL(i2, obj, i3, obj2, obj3);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public void invokeInitBody(int i2, InitContext initContext) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return;
        }
        interceptable.invokeInitBody(i2, initContext);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeJ(int i2, Object obj, long j2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeJ(i2, obj, j2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeJL(int i2, Object obj, long j2, Object obj2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeJL(i2, obj, j2, obj2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeL(int i2, Object obj, Object obj2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeL(i2, obj, obj2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLF(int i2, Object obj, Object obj2, float f2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLF(i2, obj, obj2, f2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLI(int i2, Object obj, Object obj2, int i3) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLI(i2, obj, obj2, i3);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLII(int i2, Object obj, Object obj2, int i3, int i4) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLII(i2, obj, obj2, i3, i4);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLIII(int i2, Object obj, Object obj2, int i3, int i4, int i5) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLIII(i2, obj, obj2, i3, i4, i5);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLIL(int i2, Object obj, Object obj2, int i3, Object obj3) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLIL(i2, obj, obj2, i3, obj3);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLILL(int i2, Object obj, Object obj2, int i3, Object obj3, Object obj4) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLILL(i2, obj, obj2, i3, obj3, obj4);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLJ(int i2, Object obj, Object obj2, long j2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLJ(i2, obj, obj2, j2);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLL(int i2, Object obj, Object obj2, Object obj3) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLL(i2, obj, obj2, obj3);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLI(int i2, Object obj, Object obj2, Object obj3, int i3) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLI(i2, obj, obj2, obj3, i3);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLII(int i2, Object obj, Object obj2, Object obj3, int i3, int i4) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLII(i2, obj, obj2, obj3, i3, i4);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLIL(int i2, Object obj, Object obj2, Object obj3, int i3, Object obj4) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLIL(i2, obj, obj2, obj3, i3, obj4);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLL(int i2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLL(i2, obj, obj2, obj3, obj4);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLLI(int i2, Object obj, Object obj2, Object obj3, Object obj4, int i3) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLLI(i2, obj, obj2, obj3, obj4, i3);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLLL(int i2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLLL(i2, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLLLL(int i2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLLLL(i2, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLLZ(int i2, Object obj, Object obj2, Object obj3, boolean z) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLLZ(i2, obj, obj2, obj3, z);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeLZ(int i2, Object obj, Object obj2, boolean z) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeLZ(i2, obj, obj2, z);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public void invokeUnInit(int i2, InitContext initContext) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return;
        }
        interceptable.invokeUnInit(i2, initContext);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeV(int i2, Object obj) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeV(i2, obj);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeZ(int i2, Object obj, boolean z) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeZ(i2, obj, z);
    }

    @Override // com.baidu.titan.sdk.runtime.Interceptable
    public InterceptResult invokeZL(int i2, Object obj, boolean z, Object obj2) {
        if (this.delegate == null) {
            waitLoad();
        }
        Interceptable interceptable = this.delegate;
        if (interceptable == null) {
            return null;
        }
        return interceptable.invokeZL(i2, obj, z, obj2);
    }

    public abstract boolean waitLoad();
}
