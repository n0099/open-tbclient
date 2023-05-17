package com.baidubce;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes8.dex */
public class BceResponseMetadata {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String bceContentSha256;
    public String bceRequestId;
    public String contentDisposition;
    public String contentEncoding;
    public long contentLength;
    public String contentMd5;
    public String contentRange;
    public String contentType;
    public Long crc32;
    public Date date;
    public String eTag;
    public Date expires;
    public Date lastModified;
    public String location;
    public String server;
    public String transferEncoding;

    public BceResponseMetadata() {
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
        this.contentLength = -1L;
    }

    public String getBceContentSha256() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.bceContentSha256;
        }
        return (String) invokeV.objValue;
    }

    public String getBceRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.bceRequestId;
        }
        return (String) invokeV.objValue;
    }

    public String getContentDisposition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.contentDisposition;
        }
        return (String) invokeV.objValue;
    }

    public String getContentEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.contentEncoding;
        }
        return (String) invokeV.objValue;
    }

    public long getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.contentLength;
        }
        return invokeV.longValue;
    }

    public String getContentMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.contentMd5;
        }
        return (String) invokeV.objValue;
    }

    public String getContentRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.contentRange;
        }
        return (String) invokeV.objValue;
    }

    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.contentType;
        }
        return (String) invokeV.objValue;
    }

    public Long getCrc32() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.crc32;
        }
        return (Long) invokeV.objValue;
    }

    public Date getDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.date;
        }
        return (Date) invokeV.objValue;
    }

    public String getETag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.eTag;
        }
        return (String) invokeV.objValue;
    }

    public Date getExpires() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.expires;
        }
        return (Date) invokeV.objValue;
    }

    public Date getLastModified() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.lastModified;
        }
        return (Date) invokeV.objValue;
    }

    public String getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.location;
        }
        return (String) invokeV.objValue;
    }

    public String getServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.server;
        }
        return (String) invokeV.objValue;
    }

    public String getTransferEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.transferEncoding;
        }
        return (String) invokeV.objValue;
    }

    public void setBceContentSha256(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.bceContentSha256 = str;
        }
    }

    public void setBceRequestId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.bceRequestId = str;
        }
    }

    public void setContentDisposition(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.contentDisposition = str;
        }
    }

    public void setContentEncoding(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.contentEncoding = str;
        }
    }

    public void setContentLength(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.contentLength = j;
        }
    }

    public void setContentMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.contentMd5 = str;
        }
    }

    public void setContentRange(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.contentRange = str;
        }
    }

    public void setContentType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.contentType = str;
        }
    }

    public void setCrc32(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, l) == null) {
            this.crc32 = l;
        }
    }

    public void setDate(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, date) == null) {
            this.date = date;
        }
    }

    public void setETag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.eTag = str;
        }
    }

    public void setExpires(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, date) == null) {
            this.expires = date;
        }
    }

    public void setLastModified(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, date) == null) {
            this.lastModified = date;
        }
    }

    public void setLocation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.location = str;
        }
    }

    public void setServer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.server = str;
        }
    }

    public void setTransferEncoding(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.transferEncoding = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return "BceResponseMetadata [\n  bceRequestId=" + this.bceRequestId + ", \n  bceContentSha256=" + this.bceContentSha256 + ", \n  contentDisposition=" + this.contentDisposition + ", \n  contentEncoding=" + this.contentEncoding + ", \n  contentLength=" + this.contentLength + ", \n  contentMd5=" + this.contentMd5 + ", \n  contentRange=" + this.contentRange + ", \n  contentType=" + this.contentType + ", \n  date=" + this.date + ", \n  eTag=" + this.eTag + ", \n  expires=" + this.expires + ", \n  lastModified=" + this.lastModified + ", \n  server=" + this.server + ", \n  location=" + this.location + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
