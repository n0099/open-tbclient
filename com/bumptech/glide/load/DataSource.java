package com.bumptech.glide.load;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes11.dex */
public final class DataSource {
    public static final /* synthetic */ DataSource[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DataSource DATA_DISK_CACHE;
    public static final DataSource LOCAL;
    public static final DataSource MEMORY_CACHE;
    public static final DataSource REMOTE;
    public static final DataSource RESOURCE_DISK_CACHE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1956132384, "Lcom/bumptech/glide/load/DataSource;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1956132384, "Lcom/bumptech/glide/load/DataSource;");
                return;
            }
        }
        LOCAL = new DataSource("LOCAL", 0);
        REMOTE = new DataSource("REMOTE", 1);
        DATA_DISK_CACHE = new DataSource("DATA_DISK_CACHE", 2);
        RESOURCE_DISK_CACHE = new DataSource("RESOURCE_DISK_CACHE", 3);
        DataSource dataSource = new DataSource("MEMORY_CACHE", 4);
        MEMORY_CACHE = dataSource;
        $VALUES = new DataSource[]{LOCAL, REMOTE, DATA_DISK_CACHE, RESOURCE_DISK_CACHE, dataSource};
    }

    public DataSource(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static DataSource valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DataSource) Enum.valueOf(DataSource.class, str) : (DataSource) invokeL.objValue;
    }

    public static DataSource[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DataSource[]) $VALUES.clone() : (DataSource[]) invokeV.objValue;
    }
}
