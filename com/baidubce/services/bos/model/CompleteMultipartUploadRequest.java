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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes6.dex */
public class CompleteMultipartUploadRequest extends GenericUploadRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ObjectMetadata objectMetadata;
    public List<PartETag> partETags;

    public CompleteMultipartUploadRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.objectMetadata = new ObjectMetadata();
    }

    public ObjectMetadata getObjectMetadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.objectMetadata : (ObjectMetadata) invokeV.objValue;
    }

    public List<PartETag> getPartETags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.partETags : (List) invokeV.objValue;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objectMetadata) == null) {
            this.objectMetadata = objectMetadata;
        }
    }

    public void setPartETags(List<PartETag> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            CheckUtils.isNotNull(list, "partETags should not be null.");
            for (int i2 = 0; i2 < list.size(); i2++) {
                PartETag partETag = list.get(i2);
                CheckUtils.isNotNull(partETag, "partETags[%s] should not be null.", Integer.valueOf(i2));
                int partNumber = partETag.getPartNumber();
                CheckUtils.checkArgument(partNumber > 0, "partNumber should be positive. partETags[%s].partNumber:%s", Integer.valueOf(i2), Integer.valueOf(partNumber));
                CheckUtils.isNotNull(partETag.getETag(), "partETags[%s].eTag should not be null.", Integer.valueOf(i2));
            }
            Collections.sort(list, new Comparator<PartETag>(this) { // from class: com.baidubce.services.bos.model.CompleteMultipartUploadRequest.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CompleteMultipartUploadRequest this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(PartETag partETag2, PartETag partETag3) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, partETag2, partETag3)) == null) ? partETag2.getPartNumber() - partETag3.getPartNumber() : invokeLL.intValue;
                }
            });
            int i3 = 0;
            int i4 = 0;
            while (i3 < list.size()) {
                int partNumber2 = list.get(i3).getPartNumber();
                CheckUtils.checkArgument(partNumber2 != i4, "Duplicated partNumber %s.", Integer.valueOf(partNumber2));
                i3++;
                i4 = partNumber2;
            }
            this.partETags = list;
        }
    }

    public CompleteMultipartUploadRequest withObjectMetadata(ObjectMetadata objectMetadata) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, objectMetadata)) == null) {
            setObjectMetadata(objectMetadata);
            return this;
        }
        return (CompleteMultipartUploadRequest) invokeL.objValue;
    }

    public CompleteMultipartUploadRequest withPartETags(List<PartETag> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, list)) == null) {
            setPartETags(list);
            return this;
        }
        return (CompleteMultipartUploadRequest) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericBucketRequest
    public CompleteMultipartUploadRequest withBucketName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            setBucketName(str);
            return this;
        }
        return (CompleteMultipartUploadRequest) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericObjectRequest
    public CompleteMultipartUploadRequest withKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            setKey(str);
            return this;
        }
        return (CompleteMultipartUploadRequest) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public CompleteMultipartUploadRequest withRequestCredentials(BceCredentials bceCredentials) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bceCredentials)) == null) {
            setRequestCredentials(bceCredentials);
            return this;
        }
        return (CompleteMultipartUploadRequest) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericUploadRequest
    public CompleteMultipartUploadRequest withUploadId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            setUploadId(str);
            return this;
        }
        return (CompleteMultipartUploadRequest) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompleteMultipartUploadRequest(String str, String str2, String str3, List<PartETag> list) {
        this(str, str2, str3, list, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (List) objArr2[3], (ObjectMetadata) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompleteMultipartUploadRequest(String str, String str2, String str3, List<PartETag> list, ObjectMetadata objectMetadata) {
        super(str, str2, str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, list, objectMetadata};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.objectMetadata = new ObjectMetadata();
        this.partETags = list;
        this.objectMetadata = objectMetadata;
    }
}
