package com.baidu.webkit.net;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class WebAddress implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GOOD_IRI_CHAR = "a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef";
    public static final int MATCH_GROUP_AUTHORITY = 2;
    public static final int MATCH_GROUP_HOST = 3;
    public static final int MATCH_GROUP_PATH = 5;
    public static final int MATCH_GROUP_PORT = 4;
    public static final int MATCH_GROUP_SCHEME = 1;
    public static Pattern sAddressPattern;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAuthInfo;
    public String mHost;
    public String mPath;
    public int mPort;
    public String mScheme;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1988454442, "Lcom/baidu/webkit/net/WebAddress;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1988454442, "Lcom/baidu/webkit/net/WebAddress;");
                return;
            }
        }
        sAddressPattern = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef%_-][a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
    }

    public WebAddress(String str) throws RuntimeException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (str == null) {
            throw null;
        }
        this.mScheme = "";
        this.mHost = "";
        this.mPort = -1;
        this.mPath = "/";
        this.mAuthInfo = "";
        Matcher matcher = sAddressPattern.matcher(str);
        if (!matcher.matches()) {
            throw new RuntimeException("Bad address");
        }
        String group = matcher.group(1);
        if (group != null) {
            this.mScheme = group.toLowerCase(Locale.US);
        }
        String group2 = matcher.group(2);
        if (group2 != null) {
            this.mAuthInfo = group2;
        }
        String group3 = matcher.group(3);
        if (group3 != null) {
            this.mHost = group3;
        }
        String group4 = matcher.group(4);
        if (group4 != null && group4.length() > 0) {
            try {
                this.mPort = Integer.parseInt(group4);
            } catch (NumberFormatException unused) {
                throw new RuntimeException("Bad port");
            }
        }
        String group5 = matcher.group(5);
        if (group5 != null && group5.length() > 0) {
            this.mPath = group5.charAt(0) != '/' ? "/".concat(String.valueOf(group5)) : group5;
        }
        if (this.mPort == 443 && this.mScheme.equals("")) {
            this.mScheme = "https";
        } else if (this.mPort == -1) {
            if (this.mScheme.equals("https")) {
                this.mPort = Constants.SOCKET_PORT_SSL;
            } else {
                this.mPort = 80;
            }
        }
        if (this.mScheme.equals("")) {
            this.mScheme = "http";
        }
    }

    public String getAuthInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAuthInfo : (String) invokeV.objValue;
    }

    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mHost : (String) invokeV.objValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPath : (String) invokeV.objValue;
    }

    public int getPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPort : invokeV.intValue;
    }

    public String getScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mScheme : (String) invokeV.objValue;
    }

    public void setAuthInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mAuthInfo = str;
        }
    }

    public void setHost(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mHost = str;
        }
    }

    public void setPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mPath = str;
        }
    }

    public void setPort(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mPort = i2;
        }
    }

    public void setScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mScheme = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String str2 = "";
            if ((this.mPort == 443 || !this.mScheme.equals("https")) && (this.mPort == 80 || !this.mScheme.equals("http"))) {
                str = "";
            } else {
                str = ":" + Integer.toString(this.mPort);
            }
            if (this.mAuthInfo.length() > 0) {
                str2 = this.mAuthInfo + TNCManager.TNC_PROBE_HEADER_SECEPTOR;
            }
            return this.mScheme + "://" + str2 + this.mHost + str + this.mPath;
        }
        return (String) invokeV.objValue;
    }
}
