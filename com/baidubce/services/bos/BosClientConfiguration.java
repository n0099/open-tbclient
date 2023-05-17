package com.baidubce.services.bos;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.BceClientConfiguration;
import com.baidubce.Protocol;
import com.baidubce.Region;
import com.baidubce.auth.BceCredentials;
import com.baidubce.http.RetryPolicy;
import com.baidubce.util.CheckUtils;
import java.net.InetAddress;
/* loaded from: classes8.dex */
public class BosClientConfiguration extends BceClientConfiguration {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 5242880;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean cnameEnabled;
    public int streamBufferSize;

    public BosClientConfiguration() {
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
        this.streamBufferSize = 5242880;
    }

    public int getStreamBufferSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.streamBufferSize;
        }
        return invokeV.intValue;
    }

    public Boolean isCnameEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.cnameEnabled;
        }
        return (Boolean) invokeV.objValue;
    }

    public void setCnameEnabled(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
            this.cnameEnabled = bool;
        }
    }

    public void setStreamBufferSize(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            CheckUtils.checkArgument(z, "streamBufferSize should be positive.");
            this.streamBufferSize = i;
        }
    }

    public BosClientConfiguration withCnameEnabled(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bool)) == null) {
            setCnameEnabled(bool);
            return this;
        }
        return (BosClientConfiguration) invokeL.objValue;
    }

    @Override // com.baidubce.BceClientConfiguration
    public BceClientConfiguration withProxyPreemptiveAuthenticationEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
            setProxyPreemptiveAuthenticationEnabled(z);
            return this;
        }
        return (BceClientConfiguration) invokeZ.objValue;
    }

    public BosClientConfiguration withStreamBufferSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i)) == null) {
            setStreamBufferSize(i);
            return this;
        }
        return (BosClientConfiguration) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withConnectionTimeoutInMillis(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            setConnectionTimeoutInMillis(i);
            return this;
        }
        return (BosClientConfiguration) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withCredentials(BceCredentials bceCredentials) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bceCredentials)) == null) {
            setCredentials(bceCredentials);
            return this;
        }
        return (BosClientConfiguration) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withEndpoint(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            setEndpoint(str);
            return this;
        }
        return (BosClientConfiguration) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withLocalAddress(InetAddress inetAddress) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, inetAddress)) == null) {
            setLocalAddress(inetAddress);
            return this;
        }
        return (BosClientConfiguration) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withMaxConnections(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            setMaxConnections(i);
            return this;
        }
        return (BosClientConfiguration) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withProtocol(Protocol protocol) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, protocol)) == null) {
            setProtocol(protocol);
            return this;
        }
        return (BosClientConfiguration) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withProxyDomain(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            setProxyDomain(str);
            return this;
        }
        return (BosClientConfiguration) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withProxyHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            setProxyHost(str);
            return this;
        }
        return (BosClientConfiguration) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withProxyPassword(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            setProxyPassword(str);
            return this;
        }
        return (BosClientConfiguration) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withProxyPort(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            setProxyPort(i);
            return this;
        }
        return (BosClientConfiguration) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withProxyUsername(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            setProxyUsername(str);
            return this;
        }
        return (BosClientConfiguration) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withProxyWorkstation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            setProxyWorkstation(str);
            return this;
        }
        return (BosClientConfiguration) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withRegion(Region region) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, region)) == null) {
            setRegion(region);
            return this;
        }
        return (BosClientConfiguration) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withRetryPolicy(RetryPolicy retryPolicy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, retryPolicy)) == null) {
            setRetryPolicy(retryPolicy);
            return this;
        }
        return (BosClientConfiguration) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withSocketBufferSizeInBytes(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            setSocketBufferSizeInBytes(i);
            return this;
        }
        return (BosClientConfiguration) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withSocketTimeoutInMillis(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i)) == null) {
            setSocketTimeoutInMillis(i);
            return this;
        }
        return (BosClientConfiguration) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.BceClientConfiguration
    public BosClientConfiguration withUserAgent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) {
            setUserAgent(str);
            return this;
        }
        return (BosClientConfiguration) invokeL.objValue;
    }
}
