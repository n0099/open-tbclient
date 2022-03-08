package com.baidu.wallet.paysdk.datamodel;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class O2OPayResultItemInfo implements NoProguard, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 6167322055541341900L;
    public transient /* synthetic */ FieldHolder $fh;
    public String cash_amount;
    public String coupon_find_prompt;
    public String coupon_msg;
    public String create_time;
    public String discount_amount;
    public String discount_prefix;
    public String goods_name;
    public String notify;
    public String notify_msg;
    public String order_no;
    public String order_prefix;
    public String pay_detail_info;
    public String paytype_desc;
    public String[][] paytype_info;
    public String redirect_sp_succpage_remain_time;
    public String score_tip;
    public String seller_company;
    public String title_url;
    public String total_amount;

    public O2OPayResultItemInfo() {
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
        this.order_no = "";
    }
}
