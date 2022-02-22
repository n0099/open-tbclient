package com.baidubce;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.util.CheckUtils;
import java.util.Arrays;
import java.util.List;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class Region {
    public static final /* synthetic */ Region[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Region CN_N1;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> regionIds;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1706867963, "Lcom/baidubce/Region;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1706867963, "Lcom/baidubce/Region;");
                return;
            }
        }
        Region region = new Region("CN_N1", 0, "bj");
        CN_N1 = region;
        $VALUES = new Region[]{region};
    }

    public Region(String str, int i2, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), strArr};
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
        CheckUtils.isNotNull(strArr, "regionIds should not be null.");
        CheckUtils.checkArgument(strArr.length > 0, "regionIds should not be empty");
        this.regionIds = Arrays.asList(strArr);
    }

    public static Region fromValue(String str) {
        InterceptResult invokeL;
        Region[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            CheckUtils.isNotNull(str, "regionId should not be null.");
            for (Region region : values()) {
                List<String> list = region.regionIds;
                if (list != null && list.contains(str)) {
                    return region;
                }
            }
            throw new IllegalArgumentException("Cannot create region from " + str);
        }
        return (Region) invokeL.objValue;
    }

    public static Region valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Region) Enum.valueOf(Region.class, str) : (Region) invokeL.objValue;
    }

    public static Region[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Region[]) $VALUES.clone() : (Region[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.regionIds.get(0) : (String) invokeV.objValue;
    }
}
