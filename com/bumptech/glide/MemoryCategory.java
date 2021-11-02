package com.bumptech.glide;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes11.dex */
public final class MemoryCategory {
    public static final /* synthetic */ MemoryCategory[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final MemoryCategory HIGH;
    public static final MemoryCategory LOW;
    public static final MemoryCategory NORMAL;
    public transient /* synthetic */ FieldHolder $fh;
    public final float multiplier;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1669312265, "Lcom/bumptech/glide/MemoryCategory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1669312265, "Lcom/bumptech/glide/MemoryCategory;");
                return;
            }
        }
        LOW = new MemoryCategory("LOW", 0, 0.5f);
        NORMAL = new MemoryCategory("NORMAL", 1, 1.0f);
        MemoryCategory memoryCategory = new MemoryCategory("HIGH", 2, 1.5f);
        HIGH = memoryCategory;
        $VALUES = new MemoryCategory[]{LOW, NORMAL, memoryCategory};
    }

    public MemoryCategory(String str, int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.multiplier = f2;
    }

    public static MemoryCategory valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MemoryCategory) Enum.valueOf(MemoryCategory.class, str) : (MemoryCategory) invokeL.objValue;
    }

    public static MemoryCategory[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MemoryCategory[]) $VALUES.clone() : (MemoryCategory[]) invokeV.objValue;
    }

    public float getMultiplier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.multiplier : invokeV.floatValue;
    }
}
