package com.baidu.wallet.paysdk.datamodel;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class Bank implements NoProguard, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HOT_BANK_LETTER = "#";
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String bank_code;
    public String display_letter;
    public String display_name;
    public String is_hot;
    public String logo_url;

    public Bank() {
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
        this.display_name = "";
        this.display_letter = "#";
        this.bank_code = "";
    }
}
