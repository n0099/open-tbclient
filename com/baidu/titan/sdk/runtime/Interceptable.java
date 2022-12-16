package com.baidu.titan.sdk.runtime;
/* loaded from: classes7.dex */
public interface Interceptable {
    InterceptResult invokeB(int i, Object obj, byte b);

    InterceptResult invokeCommon(int i, Object obj, Object[] objArr);

    InterceptResult invokeF(int i, Object obj, float f);

    InterceptResult invokeI(int i, Object obj, int i2);

    InterceptResult invokeII(int i, Object obj, int i2, int i3);

    InterceptResult invokeIII(int i, Object obj, int i2, int i3, int i4);

    InterceptResult invokeIIII(int i, Object obj, int i2, int i3, int i4, int i5);

    InterceptResult invokeIIL(int i, Object obj, int i2, int i3, Object obj2);

    InterceptResult invokeIL(int i, Object obj, int i2, Object obj2);

    InterceptResult invokeILL(int i, Object obj, int i2, Object obj2, Object obj3);

    void invokeInitBody(int i, InitContext initContext);

    InterceptResult invokeJ(int i, Object obj, long j);

    InterceptResult invokeJL(int i, Object obj, long j, Object obj2);

    InterceptResult invokeL(int i, Object obj, Object obj2);

    InterceptResult invokeLF(int i, Object obj, Object obj2, float f);

    InterceptResult invokeLI(int i, Object obj, Object obj2, int i2);

    InterceptResult invokeLII(int i, Object obj, Object obj2, int i2, int i3);

    InterceptResult invokeLIII(int i, Object obj, Object obj2, int i2, int i3, int i4);

    InterceptResult invokeLIL(int i, Object obj, Object obj2, int i2, Object obj3);

    InterceptResult invokeLILL(int i, Object obj, Object obj2, int i2, Object obj3, Object obj4);

    InterceptResult invokeLJ(int i, Object obj, Object obj2, long j);

    InterceptResult invokeLL(int i, Object obj, Object obj2, Object obj3);

    InterceptResult invokeLLI(int i, Object obj, Object obj2, Object obj3, int i2);

    InterceptResult invokeLLII(int i, Object obj, Object obj2, Object obj3, int i2, int i3);

    InterceptResult invokeLLIL(int i, Object obj, Object obj2, Object obj3, int i2, Object obj4);

    InterceptResult invokeLLL(int i, Object obj, Object obj2, Object obj3, Object obj4);

    InterceptResult invokeLLLI(int i, Object obj, Object obj2, Object obj3, Object obj4, int i2);

    InterceptResult invokeLLLL(int i, Object obj, Object obj2, Object obj3, Object obj4, Object obj5);

    InterceptResult invokeLLLLL(int i, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6);

    InterceptResult invokeLLZ(int i, Object obj, Object obj2, Object obj3, boolean z);

    InterceptResult invokeLZ(int i, Object obj, Object obj2, boolean z);

    void invokeUnInit(int i, InitContext initContext);

    InterceptResult invokeV(int i, Object obj);

    InterceptResult invokeZ(int i, Object obj, boolean z);

    InterceptResult invokeZL(int i, Object obj, boolean z, Object obj2);
}
