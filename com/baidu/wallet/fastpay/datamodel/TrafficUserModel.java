package com.baidu.wallet.fastpay.datamodel;

import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.StringUtils;
import java.io.Serializable;
/* loaded from: classes13.dex */
public class TrafficUserModel implements NoProguard, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 7921286508919633280L;
    public transient /* synthetic */ FieldHolder $fh;
    public String accountNo;
    public String city;
    public String provider;
    public String providerCode;
    public String province;
    public String provinceCode;
    public String publicTip;

    public TrafficUserModel() {
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
        this.accountNo = "";
        this.provider = "";
        this.providerCode = "";
        this.province = "";
        this.provinceCode = "";
        this.city = "";
        this.publicTip = "";
    }

    public String getExpressMobile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.accountNo)) {
                return "";
            }
            String unicodeDecode = SafePay.unicodeDecode(SafePay.getInstance().localDecryptProxy(this.accountNo));
            return TextUtils.isEmpty(unicodeDecode) ? "" : StringUtils.formatPhoneNumber(unicodeDecode);
        }
        return (String) invokeV.objValue;
    }
}
