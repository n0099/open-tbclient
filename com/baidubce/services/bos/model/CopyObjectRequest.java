package com.baidubce.services.bos.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.BceCredentials;
import com.baidubce.util.CheckUtils;
/* loaded from: classes7.dex */
public class CopyObjectRequest extends GenericObjectRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String eTag;
    public String modifiedSinceConstraint;
    public ObjectMetadata newObjectMetadata;
    public String noneMatchETagConstraint;
    public String sourceBucketName;
    public String sourceKey;
    public String storageClass;
    public String unmodifiedSinceConstraint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CopyObjectRequest(String str, String str2, String str3, String str4) {
        super(str3, str4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.newObjectMetadata = null;
        setSourceBucketName(str);
        setSourceKey(str2);
    }

    public String getETag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.eTag : (String) invokeV.objValue;
    }

    public String getModifiedSinceConstraint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.modifiedSinceConstraint : (String) invokeV.objValue;
    }

    public ObjectMetadata getNewObjectMetadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.newObjectMetadata : (ObjectMetadata) invokeV.objValue;
    }

    public String getNoneMatchETagConstraint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.noneMatchETagConstraint : (String) invokeV.objValue;
    }

    public String getSourceBucketName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.sourceBucketName : (String) invokeV.objValue;
    }

    public String getSourceKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.sourceKey : (String) invokeV.objValue;
    }

    public String getStorageClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.storageClass : (String) invokeV.objValue;
    }

    public String getUnmodifiedSinceConstraint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.unmodifiedSinceConstraint : (String) invokeV.objValue;
    }

    public void setETag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.eTag = str;
        }
    }

    public void setModifiedSinceConstraint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.modifiedSinceConstraint = str;
        }
    }

    public void setNewObjectMetadata(ObjectMetadata objectMetadata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, objectMetadata) == null) {
            this.newObjectMetadata = objectMetadata;
        }
    }

    public void setNoneMatchETagConstraint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.noneMatchETagConstraint = str;
        }
    }

    public void setSourceBucketName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            CheckUtils.isNotNull(str, "sourceBucketName should not be null");
            this.sourceBucketName = str;
        }
    }

    public void setSourceKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            CheckUtils.isNotNull(str, "sourceKey should not be null");
            this.sourceKey = str;
        }
    }

    public void setStorageClass(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.storageClass = str;
        }
    }

    public void setUnmodifiedSinceConstraint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.unmodifiedSinceConstraint = str;
        }
    }

    public CopyObjectRequest withETag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            setETag(str);
            return this;
        }
        return (CopyObjectRequest) invokeL.objValue;
    }

    public CopyObjectRequest withModifiedSinceConstraint(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            setModifiedSinceConstraint(str);
            return this;
        }
        return (CopyObjectRequest) invokeL.objValue;
    }

    public CopyObjectRequest withNewObjectMetadata(ObjectMetadata objectMetadata) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, objectMetadata)) == null) {
            setNewObjectMetadata(objectMetadata);
            return this;
        }
        return (CopyObjectRequest) invokeL.objValue;
    }

    public CopyObjectRequest withNoMatchingETagConstraint(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            setNoneMatchETagConstraint(str);
            return this;
        }
        return (CopyObjectRequest) invokeL.objValue;
    }

    public CopyObjectRequest withSourceBucketName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            setSourceBucketName(str);
            return this;
        }
        return (CopyObjectRequest) invokeL.objValue;
    }

    public CopyObjectRequest withSourceKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            setSourceKey(str);
            return this;
        }
        return (CopyObjectRequest) invokeL.objValue;
    }

    public CopyObjectRequest withStorageClass(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            setStorageClass(str);
            return this;
        }
        return (CopyObjectRequest) invokeL.objValue;
    }

    public CopyObjectRequest withUnmodifiedSinceConstraint(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            setUnmodifiedSinceConstraint(str);
            return this;
        }
        return (CopyObjectRequest) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericBucketRequest
    public CopyObjectRequest withBucketName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            setBucketName(str);
            return this;
        }
        return (CopyObjectRequest) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericObjectRequest
    public CopyObjectRequest withKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            setKey(str);
            return this;
        }
        return (CopyObjectRequest) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public CopyObjectRequest withRequestCredentials(BceCredentials bceCredentials) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, bceCredentials)) == null) {
            setRequestCredentials(bceCredentials);
            return this;
        }
        return (CopyObjectRequest) invokeL.objValue;
    }
}
