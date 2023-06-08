package com.baidubce;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.BceCredentials;
import com.baidubce.http.RetryPolicy;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.JoinerUtils;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.net.InetAddress;
/* loaded from: classes9.dex */
public class BceClientConfiguration {
    public static /* synthetic */ Interceptable $ic = null;
    public static String DEFAULT_ACCPET_ENCODING = null;
    public static final int DEFAULT_CONNECTION_TIMEOUT_IN_MILLIS = 30000;
    public static long DEFAULT_KEEPALIVE_DURATION = 0;
    public static final int DEFAULT_MAX_CONNECTIONS = 5;
    public static Protocol DEFAULT_PROTOCOL = null;
    public static Region DEFAULT_REGION = null;
    public static final int DEFAULT_SOCKET_TIMEOUT_IN_MILLIS = 30000;
    public static final String DEFAULT_USER_AGENT;
    public transient /* synthetic */ FieldHolder $fh;
    public String acceptEncoding;
    public int connectionTimeoutInMillis;
    public BceCredentials credentials;
    public String endpoint;
    public long keepAliveDuration;
    public InetAddress localAddress;
    public int maxConnections;
    public Protocol protocol;
    public String proxyDomain;
    public String proxyHost;
    public String proxyPassword;
    public int proxyPort;
    public boolean proxyPreemptiveAuthenticationEnabled;
    public String proxyUsername;
    public String proxyWorkstation;
    public Region region;
    public RetryPolicy retryPolicy;
    public int socketBufferSizeInBytes;
    public int socketTimeoutInMillis;
    public String token;
    public long uploadSegmentPart;
    public String userAgent;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1872096840, "Lcom/baidubce/BceClientConfiguration;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1872096840, "Lcom/baidubce/BceClientConfiguration;");
                return;
            }
        }
        DEFAULT_REGION = Region.CN_N1;
        DEFAULT_ACCPET_ENCODING = "identity";
        DEFAULT_PROTOCOL = Protocol.HTTP;
        DEFAULT_KEEPALIVE_DURATION = 30L;
        String property = System.getProperty("user.language");
        String str = "";
        if (property == null) {
            property = "";
        }
        String property2 = System.getProperty("user.region");
        if (property2 != null) {
            str = property2;
        }
        DEFAULT_USER_AGENT = JoinerUtils.on("/", "bce-sdk-android", "1.0.7", System.getProperty("os.name"), System.getProperty("os.version"), System.getProperty("java.vm.name"), System.getProperty("java.vm.version"), System.getProperty("java.version"), property, str).replace(WebvttCueParser.CHAR_SPACE, '_');
    }

    public BceClientConfiguration() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.userAgent = DEFAULT_USER_AGENT;
        this.retryPolicy = RetryPolicy.DEFAULT_RETRY_POLICY;
        this.localAddress = null;
        this.protocol = Protocol.HTTP;
        this.proxyHost = null;
        this.proxyPort = -1;
        this.proxyUsername = null;
        this.proxyPassword = null;
        this.proxyDomain = null;
        this.proxyWorkstation = null;
        this.maxConnections = 5;
        this.socketTimeoutInMillis = 30000;
        this.connectionTimeoutInMillis = 30000;
        this.socketBufferSizeInBytes = 0;
        this.endpoint = null;
        this.region = DEFAULT_REGION;
        this.acceptEncoding = DEFAULT_ACCPET_ENCODING;
        this.keepAliveDuration = DEFAULT_KEEPALIVE_DURATION;
        this.token = null;
        this.credentials = null;
        this.uploadSegmentPart = 2048L;
    }

    public BceClientConfiguration(BceClientConfiguration bceClientConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bceClientConfiguration};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.userAgent = DEFAULT_USER_AGENT;
        this.retryPolicy = RetryPolicy.DEFAULT_RETRY_POLICY;
        this.localAddress = null;
        this.protocol = Protocol.HTTP;
        this.proxyHost = null;
        this.proxyPort = -1;
        this.proxyUsername = null;
        this.proxyPassword = null;
        this.proxyDomain = null;
        this.proxyWorkstation = null;
        this.maxConnections = 5;
        this.socketTimeoutInMillis = 30000;
        this.connectionTimeoutInMillis = 30000;
        this.socketBufferSizeInBytes = 0;
        this.endpoint = null;
        this.region = DEFAULT_REGION;
        this.acceptEncoding = DEFAULT_ACCPET_ENCODING;
        this.keepAliveDuration = DEFAULT_KEEPALIVE_DURATION;
        this.token = null;
        this.credentials = null;
        this.uploadSegmentPart = 2048L;
        this.connectionTimeoutInMillis = bceClientConfiguration.connectionTimeoutInMillis;
        this.maxConnections = bceClientConfiguration.maxConnections;
        this.retryPolicy = bceClientConfiguration.retryPolicy;
        this.localAddress = bceClientConfiguration.localAddress;
        this.protocol = bceClientConfiguration.protocol;
        this.proxyDomain = bceClientConfiguration.proxyDomain;
        this.proxyHost = bceClientConfiguration.proxyHost;
        this.proxyPassword = bceClientConfiguration.proxyPassword;
        this.proxyPort = bceClientConfiguration.proxyPort;
        this.proxyUsername = bceClientConfiguration.proxyUsername;
        this.proxyWorkstation = bceClientConfiguration.proxyWorkstation;
        this.proxyPreemptiveAuthenticationEnabled = bceClientConfiguration.proxyPreemptiveAuthenticationEnabled;
        this.socketTimeoutInMillis = bceClientConfiguration.socketTimeoutInMillis;
        this.userAgent = bceClientConfiguration.userAgent;
        this.socketBufferSizeInBytes = bceClientConfiguration.socketBufferSizeInBytes;
        this.endpoint = bceClientConfiguration.endpoint;
        this.region = bceClientConfiguration.region;
        this.credentials = bceClientConfiguration.credentials;
        this.token = bceClientConfiguration.token;
        this.uploadSegmentPart = bceClientConfiguration.uploadSegmentPart;
        this.acceptEncoding = bceClientConfiguration.acceptEncoding;
        this.keepAliveDuration = bceClientConfiguration.keepAliveDuration;
    }

    public String getAcceptEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.acceptEncoding;
        }
        return (String) invokeV.objValue;
    }

    public int getConnectionTimeoutInMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.connectionTimeoutInMillis;
        }
        return invokeV.intValue;
    }

    public BceCredentials getCredentials() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.credentials;
        }
        return (BceCredentials) invokeV.objValue;
    }

    public long getKeepAliveDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.keepAliveDuration;
        }
        return invokeV.longValue;
    }

    public InetAddress getLocalAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.localAddress;
        }
        return (InetAddress) invokeV.objValue;
    }

    public int getMaxConnections() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.maxConnections;
        }
        return invokeV.intValue;
    }

    public Protocol getProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.protocol;
        }
        return (Protocol) invokeV.objValue;
    }

    public String getProxyDomain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.proxyDomain;
        }
        return (String) invokeV.objValue;
    }

    public String getProxyHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.proxyHost;
        }
        return (String) invokeV.objValue;
    }

    public String getProxyPassword() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.proxyPassword;
        }
        return (String) invokeV.objValue;
    }

    public int getProxyPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.proxyPort;
        }
        return invokeV.intValue;
    }

    public String getProxyUsername() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.proxyUsername;
        }
        return (String) invokeV.objValue;
    }

    public String getProxyWorkstation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.proxyWorkstation;
        }
        return (String) invokeV.objValue;
    }

    public Region getRegion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.region;
        }
        return (Region) invokeV.objValue;
    }

    public RetryPolicy getRetryPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.retryPolicy;
        }
        return (RetryPolicy) invokeV.objValue;
    }

    public int getSocketBufferSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.socketBufferSizeInBytes;
        }
        return invokeV.intValue;
    }

    public int getSocketTimeoutInMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.socketTimeoutInMillis;
        }
        return invokeV.intValue;
    }

    public long getUploadSegmentPart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.uploadSegmentPart;
        }
        return invokeV.longValue;
    }

    public String getUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.userAgent;
        }
        return (String) invokeV.objValue;
    }

    public boolean isProxyPreemptiveAuthenticationEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.proxyPreemptiveAuthenticationEnabled;
        }
        return invokeV.booleanValue;
    }

    public String getEndpoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String str = this.endpoint;
            if (str != null && str.length() > 0 && this.endpoint.indexOf("://") < 0) {
                return this.protocol.toString().toLowerCase() + "://" + this.endpoint;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public void setAcceptEncoding(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.acceptEncoding = str;
        }
    }

    public void setConnectionTimeoutInMillis(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            if (i >= 0) {
                z = true;
            } else {
                z = false;
            }
            CheckUtils.checkArgument(z, "connectionTimeoutInMillis should not be negative.");
            this.connectionTimeoutInMillis = i;
        }
    }

    public void setCredentials(BceCredentials bceCredentials) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bceCredentials) == null) {
            CheckUtils.isNotNull(bceCredentials, "credentials should not be null.");
            this.credentials = bceCredentials;
        }
    }

    public void setEndpoint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            CheckUtils.isNotNull(str, "endpoint should not be null.");
            this.endpoint = str;
        }
    }

    public void setKeepAliveDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            this.keepAliveDuration = j;
        }
    }

    public void setLocalAddress(InetAddress inetAddress) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, inetAddress) == null) {
            this.localAddress = inetAddress;
        }
    }

    public void setMaxConnections(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            if (i >= 0) {
                z = true;
            } else {
                z = false;
            }
            CheckUtils.checkArgument(z, "maxConnections should not be negative.");
            this.maxConnections = i;
        }
    }

    public void setProtocol(Protocol protocol) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, protocol) == null) {
            if (protocol == null) {
                protocol = DEFAULT_PROTOCOL;
            }
            this.protocol = protocol;
        }
    }

    public void setProxyDomain(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.proxyDomain = str;
        }
    }

    public void setProxyHost(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.proxyHost = str;
        }
    }

    public void setProxyPassword(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.proxyPassword = str;
        }
    }

    public void setProxyPort(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.proxyPort = i;
        }
    }

    public void setProxyPreemptiveAuthenticationEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.proxyPreemptiveAuthenticationEnabled = z;
        }
    }

    public void setProxyUsername(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.proxyUsername = str;
        }
    }

    public void setProxyWorkstation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.proxyWorkstation = str;
        }
    }

    public void setRegion(Region region) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, region) == null) {
            if (region == null) {
                region = DEFAULT_REGION;
            }
            this.region = region;
        }
    }

    public void setRetryPolicy(RetryPolicy retryPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, retryPolicy) == null) {
            if (retryPolicy == null) {
                retryPolicy = RetryPolicy.DEFAULT_RETRY_POLICY;
            }
            this.retryPolicy = retryPolicy;
        }
    }

    public void setSocketBufferSizeInBytes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.socketBufferSizeInBytes = i;
        }
    }

    public void setSocketTimeoutInMillis(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            if (i >= 0) {
                z = true;
            } else {
                z = false;
            }
            CheckUtils.checkArgument(z, "socketTimeoutInMillis should not be negative.");
            this.socketTimeoutInMillis = i;
        }
    }

    public void setUploadSegmentPart(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048616, this, j) == null) {
            this.uploadSegmentPart = (j < 1 || j > PlaybackStateCompat.ACTION_PLAY_FROM_URI) ? 2048L : 2048L;
        }
    }

    public BceClientConfiguration withConnectionTimeoutInMillis(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i)) == null) {
            setConnectionTimeoutInMillis(i);
            return this;
        }
        return (BceClientConfiguration) invokeI.objValue;
    }

    public BceClientConfiguration withCredentials(BceCredentials bceCredentials) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, bceCredentials)) == null) {
            setCredentials(bceCredentials);
            return this;
        }
        return (BceClientConfiguration) invokeL.objValue;
    }

    public BceClientConfiguration withEndpoint(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
            setEndpoint(str);
            return this;
        }
        return (BceClientConfiguration) invokeL.objValue;
    }

    public BceClientConfiguration withLocalAddress(InetAddress inetAddress) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, inetAddress)) == null) {
            setLocalAddress(inetAddress);
            return this;
        }
        return (BceClientConfiguration) invokeL.objValue;
    }

    public BceClientConfiguration withMaxConnections(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i)) == null) {
            setMaxConnections(i);
            return this;
        }
        return (BceClientConfiguration) invokeI.objValue;
    }

    public BceClientConfiguration withProtocol(Protocol protocol) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, protocol)) == null) {
            setProtocol(protocol);
            return this;
        }
        return (BceClientConfiguration) invokeL.objValue;
    }

    public BceClientConfiguration withProxyDomain(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
            setProxyDomain(str);
            return this;
        }
        return (BceClientConfiguration) invokeL.objValue;
    }

    public BceClientConfiguration withProxyHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, str)) == null) {
            setProxyHost(str);
            return this;
        }
        return (BceClientConfiguration) invokeL.objValue;
    }

    public BceClientConfiguration withProxyPassword(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) {
            setProxyPassword(str);
            return this;
        }
        return (BceClientConfiguration) invokeL.objValue;
    }

    public BceClientConfiguration withProxyPort(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i)) == null) {
            setProxyPort(i);
            return this;
        }
        return (BceClientConfiguration) invokeI.objValue;
    }

    public BceClientConfiguration withProxyPreemptiveAuthenticationEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048629, this, z)) == null) {
            setProxyPreemptiveAuthenticationEnabled(z);
            return this;
        }
        return (BceClientConfiguration) invokeZ.objValue;
    }

    public BceClientConfiguration withProxyUsername(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, str)) == null) {
            setProxyUsername(str);
            return this;
        }
        return (BceClientConfiguration) invokeL.objValue;
    }

    public BceClientConfiguration withProxyWorkstation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
            setProxyWorkstation(str);
            return this;
        }
        return (BceClientConfiguration) invokeL.objValue;
    }

    public BceClientConfiguration withRegion(Region region) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, region)) == null) {
            setRegion(region);
            return this;
        }
        return (BceClientConfiguration) invokeL.objValue;
    }

    public BceClientConfiguration withRetryPolicy(RetryPolicy retryPolicy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, retryPolicy)) == null) {
            setRetryPolicy(retryPolicy);
            return this;
        }
        return (BceClientConfiguration) invokeL.objValue;
    }

    public BceClientConfiguration withSocketBufferSizeInBytes(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i)) == null) {
            setSocketBufferSizeInBytes(i);
            return this;
        }
        return (BceClientConfiguration) invokeI.objValue;
    }

    public BceClientConfiguration withSocketTimeoutInMillis(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i)) == null) {
            setSocketTimeoutInMillis(i);
            return this;
        }
        return (BceClientConfiguration) invokeI.objValue;
    }

    public BceClientConfiguration withUploadSegmentPart(Long l) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, l)) == null) {
            setUploadSegmentPart(l.longValue());
            return this;
        }
        return (BceClientConfiguration) invokeL.objValue;
    }

    public BceClientConfiguration withUserAgent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, str)) == null) {
            setUserAgent(str);
            return this;
        }
        return (BceClientConfiguration) invokeL.objValue;
    }

    public void setUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            if (str == null) {
                this.userAgent = DEFAULT_USER_AGENT;
            } else if (str.endsWith(DEFAULT_USER_AGENT)) {
                this.userAgent = str;
            } else {
                this.userAgent = str + StringUtil.ARRAY_ELEMENT_SEPARATOR + DEFAULT_USER_AGENT;
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return "BceClientConfiguration [ \n  userAgent=" + this.userAgent + ", \n  retryPolicy=" + this.retryPolicy + ", \n  localAddress=" + this.localAddress + ", \n  protocol=" + this.protocol + ", \n  proxyHost=" + this.proxyHost + ", \n  proxyPort=" + this.proxyPort + ", \n  proxyUsername=" + this.proxyUsername + ", \n  proxyPassword=" + this.proxyPassword + ", \n  proxyDomain=" + this.proxyDomain + ", \n  proxyWorkstation=" + this.proxyWorkstation + ", \n  proxyPreemptiveAuthenticationEnabled=" + this.proxyPreemptiveAuthenticationEnabled + ", \n  maxConnections=" + this.maxConnections + ", \n  socketTimeoutInMillis=" + this.socketTimeoutInMillis + ", \n  connectionTimeoutInMillis=" + this.connectionTimeoutInMillis + ", \n  socketBufferSizeInBytes=" + this.socketBufferSizeInBytes + ", \n  endpoint=" + this.endpoint + ", \n  region=" + this.region + ", \n  credentials=" + this.credentials + ", \n  uploadSegmentPart=" + this.uploadSegmentPart + ", \n  acceptEncoding=" + this.acceptEncoding + ", \n  keepAliveDuration=" + this.keepAliveDuration + "]\n";
        }
        return (String) invokeV.objValue;
    }
}
