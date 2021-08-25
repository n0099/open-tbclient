package com.baidu.tieba.wallet.pay;

import c.a.e.e.m.b;
import c.a.p0.b1.w;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetOrder.DataReq;
import tbclient.GetOrder.GetOrderReqIdl;
import tbclient.Wares;
/* loaded from: classes7.dex */
public class GetOrderNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int isAutoPay;
    public String mClickZone;
    public int mIsLeft;
    public int mPayType;
    public String mPaymentPosKey;
    public String mReferPage;
    public String mWalletSdkUa;
    public Wares mWares;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetOrderNetMessage() {
        super(CmdConfigHttp.CMD_GET_ORDER, 303043);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pay_type = Integer.valueOf(this.mPayType);
            builder.is_left = Integer.valueOf(this.mIsLeft);
            builder.order_url = "";
            builder.mobile = "";
            builder.wares = this.mWares;
            builder.is_autopay = Integer.valueOf(this.isAutoPay);
            builder.payment_pos_key = this.mPaymentPosKey;
            if (!StringUtils.isNull(this.mReferPage)) {
                builder.refer_page = this.mReferPage;
            }
            if (!StringUtils.isNull(this.mClickZone)) {
                builder.click_zone = this.mClickZone;
            }
            if (z) {
                w.a(builder, true);
            }
            builder.wallet_sdk_ua = this.mWalletSdkUa;
            GetOrderReqIdl.Builder builder2 = new GetOrderReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public int getIsLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIsLeft : invokeV.intValue;
    }

    public int getPayType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPayType : invokeV.intValue;
    }

    public Wares getWares() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mWares : (Wares) invokeV.objValue;
    }

    public void setParams(int i2, int i3, String str, int i4, int i5, int i6, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str2, str3}) == null) {
            this.mPayType = i2;
            this.mIsLeft = i3;
            this.isAutoPay = i6;
            this.mPaymentPosKey = str2;
            this.mWalletSdkUa = str3;
            Wares.Builder builder = new Wares.Builder();
            builder.props_id = Integer.valueOf(b.d(str, 0));
            builder.new_props_id = str;
            builder.money = Integer.valueOf(i4);
            builder.props_mon = Integer.valueOf(i5);
            builder.wars_name = "";
            builder.wars_item = "";
            this.mWares = builder.build(false);
        }
    }
}
