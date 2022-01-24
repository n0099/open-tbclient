package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.PayData;
import com.dxmpay.apollon.beans.IBeanResponse;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes2.dex */
public class GetCardInfoResponse implements IBeanResponse, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7267923736947733889L;
    public transient /* synthetic */ FieldHolder $fh;
    public Algorithm algorithm_check_info;
    public BindCardInfo bind_card_info;
    public CardInfo card_info;
    public Map<String, String> cashdesk;
    public ChannelInfo channel_info;
    public ProtocolInfo protocol_info;
    public ProtocolPlatformInfo protocol_platform_info;
    public SpInfo sp_info;

    /* loaded from: classes2.dex */
    public static class Algorithm implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1246105472340646254L;
        public transient /* synthetic */ FieldHolder $fh;
        public int code;
        public String msg;

        public Algorithm() {
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

    /* loaded from: classes2.dex */
    public static class BindCardInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 424736973323730942L;
        public transient /* synthetic */ FieldHolder $fh;
        public String bind_card_desc;

        public BindCardInfo() {
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

    /* loaded from: classes2.dex */
    public static class CalcPaymentResponseImpl extends CalcPaymentResponse implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String card_no;

        public CalcPaymentResponseImpl() {
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

    /* loaded from: classes2.dex */
    public static class CardInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4241463573323730942L;
        public transient /* synthetic */ FieldHolder $fh;
        public String bank_logourl;
        public String bank_name;
        public String bank_no;
        public int card_type;
        public String desc;
        public String easypay_amount;
        public String front_bank_code;
        public String type_name;

        public CardInfo() {
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

    /* loaded from: classes2.dex */
    public static class CardItemRequired implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String IS_REQUIRED = "1";
        public static final String NOT_REQUIRED = "0";
        public static final long serialVersionUID = -7604429898684469632L;
        public transient /* synthetic */ FieldHolder $fh;
        public String certificate_code;
        public String certificate_type;
        public String mobile;
        public String true_name;
        public String valid_code;
        public String valid_date;

        public CardItemRequired() {
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

    /* loaded from: classes2.dex */
    public static class CertificateTypeInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String HONG_KONG_AND_MACAO_PASS = "4";
        public static final String ID_CARD = "1";
        public static final String OFFICER = "2";
        public static final String PASSPORT = "3";
        public static final long serialVersionUID = 2006299127113478802L;
        public transient /* synthetic */ FieldHolder $fh;
        public String description;
        public boolean isDisplay;
        public String type;

        public CertificateTypeInfo() {
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
            this.isDisplay = false;
        }

        public com.baidu.wallet.paysdk.a getValidator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long j2 = "1".equals(this.type) ? 2L : 1L;
                if ("2".equals(this.type)) {
                    j2 = 16;
                }
                if ("3".equals(this.type)) {
                    j2 = 4;
                }
                if ("4".equals(this.type)) {
                    j2 = 8;
                }
                return new com.baidu.wallet.paysdk.a(j2);
            }
            return (com.baidu.wallet.paysdk.a) invokeV.objValue;
        }

        public boolean isDisplay() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isDisplay : invokeV.booleanValue;
        }

        public void setDisplay(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.isDisplay = z;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "CertificateTypeInfo [type=" + this.type + ", description=" + this.description + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class ChannelInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1655363585956229526L;
        public transient /* synthetic */ FieldHolder $fh;
        public CardItemRequired card_item_required;
        public CertificateTypeInfo[] certificate_type_info;
        public String channel_no;
        public int is_simplify_page;
        public CalcPaymentResponseImpl mkt_info;
        public String need_pay_one_cent;
        public String need_pay_one_cent_desc;
        public int need_send_sms;

        public ChannelInfo() {
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

        public boolean isNeedSendSms() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.need_send_sms == 1 : invokeV.booleanValue;
        }

        public boolean updatePhoneOnly() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.is_simplify_page == 1 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class ProtocolInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4330766379370170338L;
        public transient /* synthetic */ FieldHolder $fh;
        public String is_agreement_checked;
        public String last_separator;
        public ProtocolItem[] list;
        public String prefix;
        public String separator;
        public String suffix;

        public ProtocolInfo() {
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

        public boolean isProtocolCheckedDefault() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "1".equals(this.is_agreement_checked) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class ProtocolItem implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1246105472340646254L;
        public transient /* synthetic */ FieldHolder $fh;
        public String title;
        public String url;

        public ProtocolItem() {
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

    /* loaded from: classes2.dex */
    public static class ProtocolPlatformInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4330766379370170338L;
        public transient /* synthetic */ FieldHolder $fh;
        public String is_agreement_checked;
        public ProtocolPlatformItem[] list;
        public String main_title;
        public String prefix;
        public String prompt;
        public String snapshotId;
        public String sub_title;

        public ProtocolPlatformInfo() {
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

        public boolean isProtocolCheckedDefault() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "1".equals(this.is_agreement_checked) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class ProtocolPlatformItem implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1246105472340646254L;
        public transient /* synthetic */ FieldHolder $fh;
        public String accessPartyId;
        public String protocolType;
        public String templateCode;
        public String templateName;

        public ProtocolPlatformItem() {
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

    /* loaded from: classes2.dex */
    public static class SpInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4241462876393730942L;
        public transient /* synthetic */ FieldHolder $fh;
        public String order_no;
        public String sp_no;

        public SpInfo() {
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

    public GetCardInfoResponse() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.card_info == null || this.channel_info == null) ? false : true : invokeV.booleanValue;
    }

    public String getCardInfoCouponDesc() {
        InterceptResult invokeV;
        CalcPaymentResponseImpl calcPaymentResponseImpl;
        PayData.ChannelDiscountMap[] channelDiscountMapArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
            return (String) invokeV.objValue;
        }
        ChannelInfo channelInfo = this.channel_info;
        if (channelInfo == null || (calcPaymentResponseImpl = channelInfo.mkt_info) == null || TextUtils.isEmpty(calcPaymentResponseImpl.card_no) || (channelDiscountMapArr = this.channel_info.mkt_info.activity_map) == null || channelDiscountMapArr.length <= 0) {
            return "";
        }
        int i2 = 0;
        while (true) {
            CalcPaymentResponseImpl calcPaymentResponseImpl2 = this.channel_info.mkt_info;
            PayData.ChannelDiscountMap[] channelDiscountMapArr2 = calcPaymentResponseImpl2.activity_map;
            if (i2 >= channelDiscountMapArr2.length) {
                return "";
            }
            if (calcPaymentResponseImpl2.card_no.equals(channelDiscountMapArr2[i2].card_no)) {
                return this.channel_info.mkt_info.activity_map[i2].description;
            }
            i2++;
        }
    }

    public String getOneCentsDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ChannelInfo channelInfo = this.channel_info;
            return (channelInfo == null || TextUtils.isEmpty(channelInfo.need_pay_one_cent_desc)) ? "" : this.channel_info.need_pay_one_cent_desc;
        }
        return (String) invokeV.objValue;
    }

    public boolean isOneCentsBusiness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ChannelInfo channelInfo = this.channel_info;
            return (channelInfo == null || TextUtils.isEmpty(channelInfo.need_pay_one_cent) || !"1".equals(this.channel_info.need_pay_one_cent)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
        }
    }
}
