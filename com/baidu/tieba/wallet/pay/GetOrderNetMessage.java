package com.baidu.tieba.wallet.pay;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.e.m.b;
import d.a.n0.z0.w;
import tbclient.GetOrder.DataReq;
import tbclient.GetOrder.GetOrderReqIdl;
import tbclient.Wares;
/* loaded from: classes5.dex */
public class GetOrderNetMessage extends NetMessage {
    public int isAutoPay;
    public String mClickZone;
    public int mIsLeft;
    public int mPayType;
    public String mPaymentPosKey;
    public String mReferPage;
    public String mWalletSdkUa;
    public Wares mWares;

    public GetOrderNetMessage() {
        super(CmdConfigHttp.CMD_GET_ORDER, 303043);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
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

    public int getIsLeft() {
        return this.mIsLeft;
    }

    public int getPayType() {
        return this.mPayType;
    }

    public Wares getWares() {
        return this.mWares;
    }

    public void setParams(int i2, int i3, String str, int i4, int i5, int i6, String str2, String str3) {
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
