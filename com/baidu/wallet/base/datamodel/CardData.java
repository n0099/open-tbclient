package com.baidu.wallet.base.datamodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes8.dex */
public class CardData implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class BondCard implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int UNBIND_CARD_DISABLE_BAIDU_FINANCE = 0;
        public static final long serialVersionUID = -7665566829025394683L;
        public transient /* synthetic */ FieldHolder $fh;
        public String account_bank_code;
        public String account_no;
        public String account_no_head_tail;
        public String background_url;
        public String bank_card_msg;
        public String bank_code;
        public String bank_name;
        public String bank_url;
        public String bind_time;
        public String card_hint_msg;
        public String card_hint_url;
        public String card_required_msg;
        public String card_state;
        public int card_type;
        public String certificate_code;
        public String certificate_code_ec;
        public String certificate_type;
        public GetCardInfoResponse.CertificateTypeInfo[] certificate_type_info;
        public String channelDiscountDesc;
        public ChannelQuota channel_quota;
        public String find_pwd_by_sms;
        public boolean hideSMSDialog;
        public String icon;
        public boolean isCheckPass;
        public int is_need_repaired;
        public String is_recommended;
        public int is_sign_jump_bank;
        public String mobile;
        public String mobile_ec;
        public String need_cvv2;
        public String need_identity_code;
        public String need_identity_type;
        public String need_phone_num;
        public String need_sms_code;
        public String need_true_name;
        public String need_valid_date;
        public int pay_need_sms_code;
        public String quota_show_msg;
        public GetCardInfoResponse.CardItemRequired required_card_items;
        public String single_quota;
        public String status;
        public String true_name;
        public String type_name;
        public String unbund_card_desc;
        public int unbund_card_enabled;
        public String unsupport_find_pwd_msg;
        public String valid_date;
        public String verify_code;

        /* loaded from: classes8.dex */
        public static class ChannelQuota implements NoProguard, Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -3143189382088186302L;
            public transient /* synthetic */ FieldHolder $fh;
            public String day_limit;
            public String month_limit;
            public String show_msg;
            public String single_limit;

            public ChannelQuota() {
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

            public String getChannelQuotaMsg() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.show_msg) ? this.show_msg : "" : (String) invokeV.objValue;
            }
        }

        public BondCard() {
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
            this.pay_need_sms_code = 1;
            this.card_state = "1";
            this.find_pwd_by_sms = "1";
            this.isCheckPass = false;
            this.hideSMSDialog = false;
        }

        public void decrypt() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (!TextUtils.isEmpty(this.certificate_code_ec)) {
                        this.certificate_code = SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(this.certificate_code_ec));
                    }
                    if (TextUtils.isEmpty(this.mobile_ec)) {
                        return;
                    }
                    this.mobile = SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(this.mobile_ec));
                } catch (Exception e2) {
                    if (BeanConstants.DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || BondCard.class != obj.getClass()) {
                    return false;
                }
                return this.account_no.equals(((BondCard) obj).account_no);
            }
            return invokeL.booleanValue;
        }

        public boolean getCanFindPWDBySms() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TextUtils.isEmpty(this.find_pwd_by_sms) || !this.find_pwd_by_sms.equals("0") : invokeV.booleanValue;
        }

        public String getCardDesc(Context context, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, context, z)) == null) ? getCardDesc(this.bank_name, this.account_no, getCardType(context), z) : (String) invokeLZ.objValue;
        }

        public String getCardDescShort() {
            InterceptResult invokeV;
            String substring;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (TextUtils.isEmpty(this.account_no)) {
                    substring = "";
                } else {
                    int length = this.account_no.length();
                    substring = length > 3 ? this.account_no.substring(length - 4) : this.account_no;
                }
                return "(" + this.bank_name + substring + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }

        public String getCardType(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
                if (!TextUtils.isEmpty(this.type_name)) {
                    return this.type_name;
                }
                String str = "wallet_base_mode_debit";
                if (1 == this.card_type) {
                    str = "wallet_base_mode_credit";
                }
                return ResUtils.getString(context, str);
            }
            return (String) invokeL.objValue;
        }

        public String getLast4Num() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (TextUtils.isEmpty(this.account_no) || this.account_no.length() <= 4) {
                    return "";
                }
                String str = this.account_no;
                return str.substring(str.length() - 4);
            }
            return (String) invokeV.objValue;
        }

        public boolean hasCvv() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? !"1".equals(this.need_cvv2) : invokeV.booleanValue;
        }

        public boolean hasDate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? !"1".equals(this.need_valid_date) : invokeV.booleanValue;
        }

        public boolean hasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !"1".equals(this.need_identity_code) : invokeV.booleanValue;
        }

        public boolean hasIdType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? !"1".equals(this.need_identity_type) : invokeV.booleanValue;
        }

        public boolean hasMobile() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? !"1".equals(this.need_phone_num) : invokeV.booleanValue;
        }

        public boolean hasName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? !"1".equals(this.need_true_name) : invokeV.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.account_no.hashCode() : invokeV.intValue;
        }

        public boolean isCompled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.is_need_repaired != 1 : invokeV.booleanValue;
        }

        public boolean isNeedSendSms() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.pay_need_sms_code == 1 : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return "BondCard Info [" + StringUtils.LF + "bank_code = " + this.bank_code + StringUtils.LF + "account_no = " + this.account_no + StringUtils.LF + "card_type = " + this.card_type + StringUtils.LF + "mobile = " + this.mobile + StringUtils.LF + "account_no_head_tail = " + this.account_no_head_tail + StringUtils.LF + "bank_name = " + this.bank_name + StringUtils.LF + "bank_url = " + this.bank_url + StringUtils.LF + "bankground_url = " + this.background_url + StringUtils.LF + "bind_time = " + this.bind_time + StringUtils.LF + "pay_need_sms_code = " + this.pay_need_sms_code + StringUtils.LF + "bank_card_msg = " + this.bank_card_msg + StringUtils.LF + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }

        public static String getCardDesc(String str, String str2, String str3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                }
                if (z) {
                    sb.append(" ");
                }
                if (!TextUtils.isEmpty(str3)) {
                    sb.append(str3);
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (z) {
                        sb.append(" ");
                    }
                    int length = str2.length();
                    sb.append("(");
                    if (length > 3) {
                        str2 = str2.substring(length - 4);
                    }
                    sb.append(str2);
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                }
                return sb.toString();
            }
            return (String) invokeCommon.objValue;
        }
    }

    public CardData() {
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
