package com.baidu.wallet.personal.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.personal.datamodel.TransfRecvRequest;
import com.baidu.wallet.personal.datamodel.TransferRecvSmSResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class TransferGetSmsBean extends BaseBean<Object> {

    /* renamed from: a  reason: collision with root package name */
    public TransfRecvRequest f26292a;

    public <T> TransferGetSmsBean(Context context) {
        super(context);
        this.f26292a = (TransfRecvRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_TRANSFER_RECV);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(TransferRecvSmSResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        TransfRecvRequest transfRecvRequest = this.f26292a;
        if (transfRecvRequest == null) {
            return arrayList;
        }
        arrayList.add(new RestNameValuePair("idt", transfRecvRequest.idt));
        arrayList.add(new RestNameValuePair("recv_card_num", this.f26292a.recv_card_num));
        arrayList.add(new RestNameValuePair("token", AccountManager.getInstance(this.mContext).getBfbToken()));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 18;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getLifeHost() + BeanConstants.API_TRANSFER_RECV_GET_SMS;
    }
}
