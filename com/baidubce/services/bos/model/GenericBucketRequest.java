package com.baidubce.services.bos.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.model.AbstractBceRequest;
/* loaded from: classes7.dex */
public abstract class GenericBucketRequest extends AbstractBceRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_BUCKET_NAME_LENGTH = 63;
    public static final int MIN_BUCKET_NAME_LENGTH = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public String bucketName;

    public GenericBucketRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean isLowercaseOrDigit(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Character.valueOf(c)})) == null) ? Character.isDigit(c) || (c >= 'a' && c <= 'z') : invokeCommon.booleanValue;
    }

    public String getBucketName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bucketName : (String) invokeV.objValue;
    }

    public void setBucketName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str != null && !str.isEmpty()) {
                String trim = str.trim();
                if (trim.length() >= 3) {
                    if (trim.length() <= 63) {
                        if (isLowercaseOrDigit(trim.charAt(0))) {
                            if (isLowercaseOrDigit(trim.charAt(trim.length() - 1))) {
                                for (int i = 1; i < trim.length() - 1; i++) {
                                    char charAt = trim.charAt(i);
                                    if (!isLowercaseOrDigit(charAt) && charAt != '-') {
                                        throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should contain only lowercase leters, digits and hyphens(-).");
                                    }
                                }
                                this.bucketName = trim;
                                return;
                            }
                            throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should end with a lowercase letter or digit.");
                        }
                        throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should start with a lowercase letter or digit.");
                    }
                    throw new IllegalArgumentException("Invalid bucketName:" + trim + ". bucketName should not be greater than 63.");
                }
                throw new IllegalArgumentException("Invalid bucketNamse:" + trim + ". bucketName should not be less than 3.");
            }
            this.bucketName = str;
        }
    }

    public abstract GenericBucketRequest withBucketName(String str);

    public GenericBucketRequest(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setBucketName(str);
    }
}
