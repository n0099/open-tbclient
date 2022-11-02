package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public final class DataCacheKey implements Key {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Key signature;
    public final Key sourceKey;

    public DataCacheKey(Key key, Key key2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {key, key2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sourceKey = key;
        this.signature = key2;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof DataCacheKey)) {
                return false;
            }
            DataCacheKey dataCacheKey = (DataCacheKey) obj;
            if (!this.sourceKey.equals(dataCacheKey.sourceKey) || !this.signature.equals(dataCacheKey.signature)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, messageDigest) == null) {
            this.sourceKey.updateDiskCacheKey(messageDigest);
            this.signature.updateDiskCacheKey(messageDigest);
        }
    }

    public Key getSourceKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.sourceKey;
        }
        return (Key) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (this.sourceKey.hashCode() * 31) + this.signature.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "DataCacheKey{sourceKey=" + this.sourceKey + ", signature=" + this.signature + '}';
        }
        return (String) invokeV.objValue;
    }
}
