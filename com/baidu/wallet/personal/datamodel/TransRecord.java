package com.baidu.wallet.personal.datamodel;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class TransRecord implements NoProguard, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TRANS_STATE_CANCELED = 5;
    public static final int TRANS_STATE_END = 6;
    public static final int TRANS_STATE_PART_REFUND = 7;
    public static final int TRANS_STATE_PAY_SUCCESS = 2;
    public static final int TRANS_STATE_REFUND = 4;
    public static final int TRANS_STATE_SUCCESS = 3;
    public static final int TRANS_STATE_TRANSFER_FAIL = 8;
    public static final int TRANS_STATE_WAITTING = 1;
    public static final int TRANS_STATE_WAITTING_RECEIVE = 9;
    public static final int TRANS_TYPE_CHARGE = 5;
    public static final int TRANS_TYPE_OTHER = 2;
    public static final int TRANS_TYPE_TRAFFIC = 6;
    public static final int TRANS_TYPE_TRANSFER_ACCOUNT_PAY = 10;
    public static final int TRANS_TYPE_TRANSFER_ACCOUNT_PAYEE = 11;
    public static final int TRANS_TYPE_TRANSFER_BANKCARD = 9;
    public static final long serialVersionUID = -3899635063002556799L;
    public transient /* synthetic */ FieldHolder $fh;
    public int behav;
    public int biz_type;
    public String cash_amount;
    public String create_time;
    public String end_time;
    public String expected_time;
    public String failed_reason;
    public String fee_amount;
    public String goods_amount;
    public String goods_desc;
    public String goods_name;
    public String goods_url;
    public String mCreateTime;
    public String mobile_number;
    public String mobile_number_ec;
    public String mobile_price;
    public String not_pay_time;
    public String off_msg;
    public String order_no;
    public String pay_desc;
    public String pay_info;
    public String pay_solution_amount;
    public String pay_time;
    public String pay_url;
    public String payee_recv_type;
    public String pdc_company;
    public String received_flag;
    public String recv_bank_name;
    public String recv_card_num;
    public String recv_mobile;
    public String recv_name;
    public String redirect_sp_succpage_remain_time;
    public String remark_k;
    public String remark_v;
    public String save_amount;
    public String service_tel;
    public String sp_name;
    public String sp_url;
    public int state;
    public String state_name;
    public String trans_di;
    public String trans_type_name;

    public TransRecord() {
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
        this.redirect_sp_succpage_remain_time = "1";
    }

    public void decrypt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (TextUtils.isEmpty(this.mobile_number_ec)) {
                    return;
                }
                this.mobile_number = SafePay.unicodeDecode(SafePay.getInstance().localDecryptProxy(this.mobile_number_ec));
            } catch (Exception unused) {
            }
        }
    }

    public boolean isGotoResultActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.redirect_sp_succpage_remain_time) || !this.redirect_sp_succpage_remain_time.equals("0") : invokeV.booleanValue;
    }
}
