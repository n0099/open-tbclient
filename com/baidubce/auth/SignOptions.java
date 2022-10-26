package com.baidubce.auth;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.Set;
/* loaded from: classes7.dex */
public class SignOptions {
    public static /* synthetic */ Interceptable $ic = null;
    public static final SignOptions DEFAULT;
    public static final int DEFAULT_EXPIRATION_IN_SECONDS = 1800;
    public transient /* synthetic */ FieldHolder $fh;
    public int expirationInSeconds;
    public Set headersToSign;
    public Date timestamp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(709390261, "Lcom/baidubce/auth/SignOptions;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(709390261, "Lcom/baidubce/auth/SignOptions;");
                return;
            }
        }
        DEFAULT = new SignOptions();
    }

    public SignOptions() {
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
        this.headersToSign = null;
        this.timestamp = null;
        this.expirationInSeconds = 1800;
    }

    public int getExpirationInSeconds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.expirationInSeconds;
        }
        return invokeV.intValue;
    }

    public Set getHeadersToSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.headersToSign;
        }
        return (Set) invokeV.objValue;
    }

    public Date getTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.timestamp;
        }
        return (Date) invokeV.objValue;
    }

    public void setExpirationInSeconds(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.expirationInSeconds = i;
        }
    }

    public void setHeadersToSign(Set set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, set) == null) {
            this.headersToSign = set;
        }
    }

    public void setTimestamp(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, date) == null) {
            this.timestamp = date;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "SignOptions [\n  headersToSign=" + this.headersToSign + ",\n  timestamp=" + this.timestamp + ",\n  expirationInSeconds=" + this.expirationInSeconds + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
