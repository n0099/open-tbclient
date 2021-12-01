package com.baidu.titan.sdk.runtime;
/* loaded from: classes11.dex */
public interface Interceptable {
    InterceptResult invokeB(int i2, Object obj, byte b2);

    InterceptResult invokeCommon(int i2, Object obj, Object[] objArr);

    InterceptResult invokeF(int i2, Object obj, float f2);

    InterceptResult invokeI(int i2, Object obj, int i3);

    InterceptResult invokeII(int i2, Object obj, int i3, int i4);

    InterceptResult invokeIII(int i2, Object obj, int i3, int i4, int i5);

    InterceptResult invokeIIII(int i2, Object obj, int i3, int i4, int i5, int i6);

    InterceptResult invokeIIL(int i2, Object obj, int i3, int i4, Object obj2);

    InterceptResult invokeIL(int i2, Object obj, int i3, Object obj2);

    InterceptResult invokeILL(int i2, Object obj, int i3, Object obj2, Object obj3);

    void invokeInitBody(int i2, InitContext initContext);

    InterceptResult invokeJ(int i2, Object obj, long j2);

    InterceptResult invokeJL(int i2, Object obj, long j2, Object obj2);

    InterceptResult invokeL(int i2, Object obj, Object obj2);

    InterceptResult invokeLF(int i2, Object obj, Object obj2, float f2);

    InterceptResult invokeLI(int i2, Object obj, Object obj2, int i3);

    InterceptResult invokeLII(int i2, Object obj, Object obj2, int i3, int i4);

    InterceptResult invokeLIII(int i2, Object obj, Object obj2, int i3, int i4, int i5);

    InterceptResult invokeLIL(int i2, Object obj, Object obj2, int i3, Object obj3);

    InterceptResult invokeLILL(int i2, Object obj, Object obj2, int i3, Object obj3, Object obj4);

    InterceptResult invokeLJ(int i2, Object obj, Object obj2, long j2);

    InterceptResult invokeLL(int i2, Object obj, Object obj2, Object obj3);

    InterceptResult invokeLLI(int i2, Object obj, Object obj2, Object obj3, int i3);

    InterceptResult invokeLLII(int i2, Object obj, Object obj2, Object obj3, int i3, int i4);

    InterceptResult invokeLLIL(int i2, Object obj, Object obj2, Object obj3, int i3, Object obj4);

    InterceptResult invokeLLL(int i2, Object obj, Object obj2, Object obj3, Object obj4);

    InterceptResult invokeLLLI(int i2, Object obj, Object obj2, Object obj3, Object obj4, int i3);

    InterceptResult invokeLLLL(int i2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5);

    InterceptResult invokeLLLLL(int i2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6);

    InterceptResult invokeLLZ(int i2, Object obj, Object obj2, Object obj3, boolean z);

    InterceptResult invokeLZ(int i2, Object obj, Object obj2, boolean z);

    void invokeUnInit(int i2, InitContext initContext);

    InterceptResult invokeV(int i2, Object obj);

    InterceptResult invokeZ(int i2, Object obj, boolean z);

    InterceptResult invokeZL(int i2, Object obj, boolean z, Object obj2);
}
