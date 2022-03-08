package com.baidubce.services.bos.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.BceCredentials;
import com.baidubce.services.bos.callback.BosProgressCallback;
import com.baidubce.util.CheckUtils;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class PutObjectRequest extends GenericObjectRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public File file;
    public InputStream inputStream;
    public ObjectMetadata objectMetadata;
    public BosProgressCallback progressCallback;
    public String storageClass;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PutObjectRequest(String str, String str2, File file) {
        this(str, str2, file, null, new ObjectMetadata());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (File) objArr2[2], (InputStream) objArr2[3], (ObjectMetadata) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CheckUtils.isNotNull(file, "file should not be null.");
    }

    public File getFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.file : (File) invokeV.objValue;
    }

    public InputStream getInputStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.inputStream : (InputStream) invokeV.objValue;
    }

    public ObjectMetadata getObjectMetadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.objectMetadata : (ObjectMetadata) invokeV.objValue;
    }

    public BosProgressCallback getProgressCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.progressCallback : (BosProgressCallback) invokeV.objValue;
    }

    public String getStorageClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.storageClass : (String) invokeV.objValue;
    }

    public void setFile(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, file) == null) {
            this.file = file;
        }
    }

    public void setInputStream(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, inputStream) == null) {
            this.inputStream = inputStream;
        }
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, objectMetadata) == null) {
            this.objectMetadata = objectMetadata;
        }
    }

    public <T extends PutObjectRequest> void setProgressCallback(BosProgressCallback<T> bosProgressCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bosProgressCallback) == null) {
            this.progressCallback = bosProgressCallback;
        }
    }

    public void setStorageClass(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.storageClass = str;
        }
    }

    public PutObjectRequest withFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, file)) == null) {
            setFile(file);
            return this;
        }
        return (PutObjectRequest) invokeL.objValue;
    }

    public PutObjectRequest withInputStream(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, inputStream)) == null) {
            setInputStream(inputStream);
            return this;
        }
        return (PutObjectRequest) invokeL.objValue;
    }

    public PutObjectRequest withObjectMetadata(ObjectMetadata objectMetadata) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, objectMetadata)) == null) {
            setObjectMetadata(objectMetadata);
            return this;
        }
        return (PutObjectRequest) invokeL.objValue;
    }

    public <T extends PutObjectRequest> PutObjectRequest withProgressCallback(BosProgressCallback<T> bosProgressCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bosProgressCallback)) == null) {
            this.progressCallback = bosProgressCallback;
            return this;
        }
        return (PutObjectRequest) invokeL.objValue;
    }

    public PutObjectRequest withStorageClass(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            setStorageClass(str);
            return this;
        }
        return (PutObjectRequest) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericBucketRequest
    public PutObjectRequest withBucketName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            setBucketName(str);
            return this;
        }
        return (PutObjectRequest) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericObjectRequest
    public PutObjectRequest withKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            setKey(str);
            return this;
        }
        return (PutObjectRequest) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public PutObjectRequest withRequestCredentials(BceCredentials bceCredentials) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, bceCredentials)) == null) {
            setRequestCredentials(bceCredentials);
            return this;
        }
        return (PutObjectRequest) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PutObjectRequest(String str, String str2, File file, ObjectMetadata objectMetadata) {
        this(str, str2, file, null, objectMetadata);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, file, objectMetadata};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (File) objArr2[2], (InputStream) objArr2[3], (ObjectMetadata) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        CheckUtils.isNotNull(file, "file should not be null.");
        CheckUtils.isNotNull(objectMetadata, "metadata should not be null.");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PutObjectRequest(String str, String str2, InputStream inputStream) {
        this(str, str2, null, inputStream, new ObjectMetadata());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, inputStream};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (File) objArr2[2], (InputStream) objArr2[3], (ObjectMetadata) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        CheckUtils.isNotNull(inputStream, "inputStream should not be null.");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PutObjectRequest(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        this(str, str2, null, inputStream, objectMetadata);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, inputStream, objectMetadata};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (File) objArr2[2], (InputStream) objArr2[3], (ObjectMetadata) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        CheckUtils.isNotNull(inputStream, "inputStream should not be null.");
        CheckUtils.isNotNull(objectMetadata, "metadata should not be null.");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PutObjectRequest(String str, String str2, File file, InputStream inputStream, ObjectMetadata objectMetadata) {
        super(str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, file, inputStream, objectMetadata};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.objectMetadata = new ObjectMetadata();
        this.progressCallback = null;
        this.file = file;
        this.inputStream = inputStream;
        this.objectMetadata = objectMetadata;
    }
}
