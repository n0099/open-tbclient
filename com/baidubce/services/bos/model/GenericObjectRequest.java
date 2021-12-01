package com.baidubce.services.bos.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.util.CheckUtils;
/* loaded from: classes12.dex */
public abstract class GenericObjectRequest extends GenericBucketRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_OBJECT_KEY_LENGTH = 1024;
    public static final int MIN_OBJECT_KEY_LENGTH = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public String key;

    public GenericObjectRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.key : (String) invokeV.objValue;
    }

    public void setKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            CheckUtils.isNotNull(str, "key should not be null.");
            if (str.length() >= 0) {
                if (str.length() <= 1024) {
                    this.key = str;
                    return;
                }
                throw new IllegalArgumentException("Invalid objectKey:" + str + ". objectKey should not be greater than 1024.");
            }
            throw new IllegalArgumentException("Invalid objectKey:" + str + ". objectKey should not be less than 0.");
        }
    }

    public abstract GenericObjectRequest withKey(String str);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericObjectRequest(String str, String str2) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setKey(str2);
    }
}
