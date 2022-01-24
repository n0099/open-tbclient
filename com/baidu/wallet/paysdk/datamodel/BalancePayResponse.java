package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultCashbackDetail;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class BalancePayResponse implements IBeanResponse, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String amount;
    public AuthorizeInfo authorize_info;
    public Business business;
    public String cash_amount;
    public PayResultCashbackDetail cashback_dialog_detail;
    public Compliance compliance;
    public String coupon_find_prompt;
    public String coupon_msg;
    public PayResultContent.CrossMarket cross_market;
    public String discount_amount;
    public String[][] discount_info;
    public String discount_prefix;
    public FeedbackInfo feedback_info;
    public String fp_open_or_update_msg;
    public String notify;
    public String order_no;
    public String order_prefix;
    public String pay_detail_info;
    public String pay_result_params;
    public String pay_result_url;
    public String paytype_desc;
    public String[][] paytype_info;
    public String redirect_sp_succpage_remain_time;
    public String show_h5_result;
    public String title_url;
    public String total_amount;
    public String trans_no;

    /* loaded from: classes2.dex */
    public static class Business implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String expected_time;
        public String stream_recharge_msg;

        public Business() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public BalancePayResponse() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.notify) : invokeV.booleanValue;
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
        }
    }

    public boolean toShowH5ResultPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? H5ResultParams.toShowH5ResultPage(this.redirect_sp_succpage_remain_time, this.pay_result_url, this.show_h5_result) : invokeV.booleanValue;
    }
}
