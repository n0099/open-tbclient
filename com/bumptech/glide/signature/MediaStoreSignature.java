package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public class MediaStoreSignature implements Key {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long dateModified;
    @NonNull
    public final String mimeType;
    public final int orientation;

    public MediaStoreSignature(@Nullable String str, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mimeType = str == null ? "" : str;
        this.dateModified = j;
        this.orientation = i;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || MediaStoreSignature.class != obj.getClass()) {
                return false;
            }
            MediaStoreSignature mediaStoreSignature = (MediaStoreSignature) obj;
            if (this.dateModified == mediaStoreSignature.dateModified && this.orientation == mediaStoreSignature.orientation && this.mimeType.equals(mediaStoreSignature.mimeType)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, messageDigest) == null) {
            messageDigest.update(ByteBuffer.allocate(12).putLong(this.dateModified).putInt(this.orientation).array());
            messageDigest.update(this.mimeType.getBytes(Key.CHARSET));
        }
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j = this.dateModified;
            return (((this.mimeType.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.orientation;
        }
        return invokeV.intValue;
    }
}
