package com.baidu.wallet.core.utils.contacts;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ContractInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f60659a;

    /* renamed from: b  reason: collision with root package name */
    public String f60660b;

    /* renamed from: c  reason: collision with root package name */
    public int f60661c;

    public ContractInfo() {
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
        this.f60659a = "";
        this.f60660b = "";
        this.f60661c = -1;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ContractInfo.class == obj.getClass()) {
                ContractInfo contractInfo = (ContractInfo) obj;
                String str = this.f60660b;
                if (str == null) {
                    if (contractInfo.f60660b != null) {
                        return false;
                    }
                } else if (!str.equals(contractInfo.f60660b)) {
                    return false;
                }
                String str2 = this.f60659a;
                if (str2 == null) {
                    if (contractInfo.f60659a != null) {
                        return false;
                    }
                } else if (!str2.equals(contractInfo.f60659a)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int getErrordigit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60661c : invokeV.intValue;
    }

    public String getMobile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60660b : (String) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f60659a : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String str = this.f60660b;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.f60659a;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public void setErrordigit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f60661c = i2;
        }
    }

    public void setMobile(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f60660b = str;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f60659a = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "通讯录 [name=" + this.f60659a + ", mobile=" + this.f60660b + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public ContractInfo(String str) {
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
        this.f60659a = "";
        this.f60660b = "";
        this.f60661c = -1;
        this.f60660b = str;
        this.f60659a = "";
    }

    public ContractInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f60659a = "";
        this.f60660b = "";
        this.f60661c = -1;
        this.f60660b = str;
        this.f60659a = str2;
    }
}
