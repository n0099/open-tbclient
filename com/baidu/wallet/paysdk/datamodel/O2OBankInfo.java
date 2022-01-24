package com.baidu.wallet.paysdk.datamodel;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class O2OBankInfo implements NoProguard, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7835206922733736126L;
    public transient /* synthetic */ FieldHolder $fh;
    public String bank_name;
    public String bank_url;
    public String card_no;
    public String card_type;
    public String display_name;
    public String enabled;
    public boolean isBankCard;
    public String pay_type;
    public String selected;

    public O2OBankInfo() {
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
        this.isBankCard = true;
        this.pay_type = "2";
    }
}
