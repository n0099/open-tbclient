package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public final class Options implements Key {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayMap<Option<?>, Object> values;

    public Options() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.values = new CachedHashCodeArrayMap();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.values.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "Options{values=" + this.values + '}';
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void updateDiskCacheKey(@NonNull Option<T> option, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, option, obj, messageDigest) == null) {
            option.update(obj, messageDigest);
        }
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof Options) {
                return this.values.equals(((Options) obj).values);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public <T> T get(@NonNull Option<T> option) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, option)) == null) {
            if (this.values.containsKey(option)) {
                return (T) this.values.get(option);
            }
            return option.getDefaultValue();
        }
        return (T) invokeL.objValue;
    }

    public void putAll(@NonNull Options options) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, options) == null) {
            this.values.putAll((SimpleArrayMap<? extends Option<?>, ? extends Object>) options.values);
        }
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, messageDigest) == null) {
            for (int i = 0; i < this.values.size(); i++) {
                updateDiskCacheKey(this.values.keyAt(i), this.values.valueAt(i), messageDigest);
            }
        }
    }

    @NonNull
    public <T> Options set(@NonNull Option<T> option, @NonNull T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, option, t)) == null) {
            this.values.put(option, t);
            return this;
        }
        return (Options) invokeLL.objValue;
    }
}
