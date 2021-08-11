package com.baidubce.services.bos.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.util.CheckUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class ObjectMetadata {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long appendOffset;
    public String bceContentSha256;
    public String cacheControl;
    public String contentDisposition;
    public String contentEncoding;
    public long contentLength;
    public String contentMd5;
    public String contentRange;
    public String contentType;
    public Long crc32;
    public String eTag;
    public String expires;
    public long instanceLength;
    public Date lastModified;
    public String objectType;
    public String storageClass;
    public Map<String, String> userMetadata;

    public ObjectMetadata() {
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
        this.userMetadata = new HashMap();
        this.contentLength = -1L;
        this.instanceLength = -1L;
    }

    public void addUserMetadata(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.userMetadata.put(str, str2);
        }
    }

    public long getAppendOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.appendOffset : invokeV.longValue;
    }

    public String getBceContentSha256() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bceContentSha256 : (String) invokeV.objValue;
    }

    public String getCacheControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.cacheControl : (String) invokeV.objValue;
    }

    public String getContentDisposition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.contentDisposition : (String) invokeV.objValue;
    }

    public String getContentEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.contentEncoding : (String) invokeV.objValue;
    }

    public long getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.contentLength : invokeV.longValue;
    }

    public String getContentMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.contentMd5 : (String) invokeV.objValue;
    }

    public String getContentRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.contentRange : (String) invokeV.objValue;
    }

    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.contentType : (String) invokeV.objValue;
    }

    public Long getCrc32() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.crc32 : (Long) invokeV.objValue;
    }

    public String getETag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.eTag : (String) invokeV.objValue;
    }

    public String getExpires() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.expires : (String) invokeV.objValue;
    }

    public long getInstanceLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.instanceLength : invokeV.longValue;
    }

    public Date getLastModified() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.lastModified : (Date) invokeV.objValue;
    }

    public String getObjectType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.objectType : (String) invokeV.objValue;
    }

    public String getStorageClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.storageClass : (String) invokeV.objValue;
    }

    public String getUserMetaDataOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            Map<String, String> map = this.userMetadata;
            if (map == null) {
                return null;
            }
            return map.get(str);
        }
        return (String) invokeL.objValue;
    }

    public Map<String, String> getUserMetadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.userMetadata : (Map) invokeV.objValue;
    }

    public void setAppendOffset(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
            this.appendOffset = j2;
        }
    }

    public void setBceContentSha256(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.bceContentSha256 = str;
        }
    }

    public void setCacheControl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.cacheControl = str;
        }
    }

    public void setContentDisposition(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.contentDisposition = str;
        }
    }

    public void setContentEncoding(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.contentEncoding = str;
        }
    }

    public void setContentLength(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j2) == null) {
            this.contentLength = j2;
        }
    }

    public void setContentMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.contentMd5 = str;
        }
    }

    public void setContentRange(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.contentRange = str;
        }
    }

    public void setContentType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.contentType = str;
        }
    }

    public void setCrc32(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, l) == null) {
            this.crc32 = l;
        }
    }

    public void setETag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.eTag = str;
        }
    }

    public void setExpires(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.expires = str;
        }
    }

    public void setInstanceLength(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048607, this, j2) == null) {
            this.instanceLength = j2;
        }
    }

    public void setLastModified(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, date) == null) {
            this.lastModified = date;
        }
    }

    public void setObjectType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.objectType = str;
        }
    }

    public void setStorageClass(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.storageClass = str;
        }
    }

    public void setUserMetadata(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, map) == null) {
            CheckUtils.isNotNull(map, "userMetadata should not be null.");
            this.userMetadata = map;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            StringBuilder sb = new StringBuilder("ObjectMetadata [");
            sb.append("userMetadata=");
            sb.append(this.userMetadata);
            if (this.bceContentSha256 != null) {
                sb.append(", bceContentSha256=");
                sb.append(this.bceContentSha256);
            }
            if (this.contentDisposition != null) {
                sb.append(", contentDisposition=");
                sb.append(this.contentDisposition);
            }
            if (this.contentEncoding != null) {
                sb.append(", contentEncoding=");
                sb.append(this.contentEncoding);
            }
            if (this.contentLength >= 0) {
                sb.append(", contentLength=");
                sb.append(this.contentLength);
            }
            if (this.contentMd5 != null) {
                sb.append(", contentMd5=");
                sb.append(this.contentMd5);
            }
            if (this.contentType != null) {
                sb.append(", contentType=");
                sb.append(this.contentType);
            }
            if (this.eTag != null) {
                sb.append(", eTag=");
                sb.append(this.eTag);
            }
            if (this.instanceLength >= 0) {
                sb.append(", instanceLength=");
                sb.append(this.instanceLength);
            }
            if (this.lastModified != null) {
                sb.append(", lastModified=");
                sb.append(this.lastModified);
            }
            if (this.cacheControl != null) {
                sb.append(", cacheControl=");
                sb.append(this.cacheControl);
            }
            if (this.storageClass != null) {
                sb.append(", storageClass=");
                sb.append(this.storageClass);
            }
            if (this.crc32 != null) {
                sb.append(", crc32=");
                sb.append(this.crc32);
            }
            sb.append(']');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public ObjectMetadata(ObjectMetadata objectMetadata) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {objectMetadata};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.userMetadata = new HashMap();
        this.contentLength = -1L;
        this.instanceLength = -1L;
        if (objectMetadata.userMetadata != null) {
            this.userMetadata = new HashMap(objectMetadata.userMetadata);
        }
        setBceContentSha256(objectMetadata.getBceContentSha256());
        setContentDisposition(objectMetadata.getContentDisposition());
        setContentEncoding(objectMetadata.getContentEncoding());
        setContentLength(objectMetadata.getContentLength());
        setContentMd5(objectMetadata.getContentMd5());
        setContentType(objectMetadata.getContentType());
        setETag(objectMetadata.getETag());
        setCrc32(objectMetadata.getCrc32());
        setInstanceLength(objectMetadata.getInstanceLength());
        setLastModified(objectMetadata.getLastModified());
        setExpires(objectMetadata.getExpires());
        setAppendOffset(objectMetadata.getAppendOffset());
        setObjectType(objectMetadata.getObjectType());
        setCacheControl(objectMetadata.getCacheControl());
        setStorageClass(objectMetadata.getStorageClass());
    }
}
