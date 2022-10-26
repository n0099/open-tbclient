package com.bumptech.glide.load;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public final class Option {
    public static /* synthetic */ Interceptable $ic;
    public static final CacheKeyUpdater EMPTY_UPDATER;
    public transient /* synthetic */ FieldHolder $fh;
    public final CacheKeyUpdater cacheKeyUpdater;
    public final Object defaultValue;
    public final String key;
    public volatile byte[] keyBytes;

    /* loaded from: classes7.dex */
    public interface CacheKeyUpdater {
        void update(byte[] bArr, Object obj, MessageDigest messageDigest);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1926557968, "Lcom/bumptech/glide/load/Option;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1926557968, "Lcom/bumptech/glide/load/Option;");
                return;
            }
        }
        EMPTY_UPDATER = new CacheKeyUpdater() { // from class: com.bumptech.glide.load.Option.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
            public void update(byte[] bArr, Object obj, MessageDigest messageDigest) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bArr, obj, messageDigest) == null) {
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        };
    }

    public static CacheKeyUpdater emptyUpdater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return EMPTY_UPDATER;
        }
        return (CacheKeyUpdater) invokeV.objValue;
    }

    private byte[] getKeyBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.keyBytes == null) {
                this.keyBytes = this.key.getBytes(Key.CHARSET);
            }
            return this.keyBytes;
        }
        return (byte[]) invokeV.objValue;
    }

    public Object getDefaultValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.defaultValue;
        }
        return invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.key.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "Option{key='" + this.key + "'}";
        }
        return (String) invokeV.objValue;
    }

    public Option(String str, Object obj, CacheKeyUpdater cacheKeyUpdater) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, obj, cacheKeyUpdater};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.key = Preconditions.checkNotEmpty(str);
        this.defaultValue = obj;
        this.cacheKeyUpdater = (CacheKeyUpdater) Preconditions.checkNotNull(cacheKeyUpdater);
    }

    public static Option disk(String str, CacheKeyUpdater cacheKeyUpdater) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, cacheKeyUpdater)) == null) {
            return new Option(str, null, cacheKeyUpdater);
        }
        return (Option) invokeLL.objValue;
    }

    public static Option memory(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, obj)) == null) {
            return new Option(str, obj, emptyUpdater());
        }
        return (Option) invokeLL.objValue;
    }

    public void update(Object obj, MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, obj, messageDigest) == null) {
            this.cacheKeyUpdater.update(getKeyBytes(), obj, messageDigest);
        }
    }

    public static Option disk(String str, Object obj, CacheKeyUpdater cacheKeyUpdater) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, obj, cacheKeyUpdater)) == null) {
            return new Option(str, obj, cacheKeyUpdater);
        }
        return (Option) invokeLLL.objValue;
    }

    public static Option memory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return new Option(str, null, emptyUpdater());
        }
        return (Option) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof Option) {
                return this.key.equals(((Option) obj).key);
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
