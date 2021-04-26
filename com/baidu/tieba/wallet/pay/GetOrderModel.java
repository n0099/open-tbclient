package com.baidu.tieba.wallet.pay;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.pay.PayConfig;
import d.a.c.e.m.b;
/* loaded from: classes5.dex */
public class GetOrderModel extends BdBaseModel {
    public String mWalletSdkUa;

    public GetOrderModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
    }

    private GetOrderNetMessage createNetMessage(PayConfig payConfig) {
        GetOrderNetMessage getOrderNetMessage = new GetOrderNetMessage();
        getOrderNetMessage.setParams(payConfig.getPayType(), b.d(payConfig.getIsLeft(), 0), payConfig.getPropsId(), b.d(payConfig.getMoney(), 0), b.d(payConfig.getPropsMon(), 0), payConfig.isAutoPay(), payConfig.paymentPosKey, this.mWalletSdkUa);
        getOrderNetMessage.mReferPage = payConfig.mReferPage;
        getOrderNetMessage.mClickZone = payConfig.mClickZone;
        return getOrderNetMessage;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean sendMessage(PayConfig payConfig) {
        if (payConfig == null) {
            return false;
        }
        sendMessage(createNetMessage(payConfig));
        return true;
    }

    public void setWalletSdkUa(String str) {
        this.mWalletSdkUa = str;
    }
}
