package com.baidu.wallet.fastpay.datamodel;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes10.dex */
public class PriceInfo implements NoProguard, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 2303549421246252648L;
    public transient /* synthetic */ FieldHolder $fh;
    public int canClick;
    public String discount;
    public String face;
    public boolean isExist;
    public String sell_price;

    public PriceInfo() {
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
        this.discount = "";
        this.canClick = 0;
        this.isExist = false;
    }

    public boolean canClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? 1 == this.canClick : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? (obj instanceof PriceInfo) && TextUtils.equals(((PriceInfo) obj).face, this.face) : invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "PriceInfo [face=" + this.face + ", sell_price=" + this.sell_price + ", discount=" + this.discount + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public PriceInfo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.discount = "";
        this.canClick = 0;
        this.isExist = false;
        this.face = str;
        this.sell_price = str2;
        this.discount = str3;
        this.canClick = 0;
    }
}
