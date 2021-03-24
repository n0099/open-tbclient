package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.WalletChargeResultBannerResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class u extends BaseBean<WalletChargeResultBannerResponse> {

    /* renamed from: a  reason: collision with root package name */
    public String f25533a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f25534b;

    public u(Context context) {
        super(context);
    }

    public void a(String str) {
        this.f25533a = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(WalletChargeResultBannerResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("subBizType", this.f25534b ? "1003003" : "1003002"));
        arrayList.add(new RestNameValuePair("returnType", "2"));
        arrayList.add(new RestNameValuePair("orderNo", this.f25533a));
        arrayList.add(new RestNameValuePair("ua", "WAP"));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_CHARGE_RESULT_BANNER;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getNfcHost() + com.baidu.wallet.core.beans.BeanConstants.API_PAY_RESULT_CALLBACK_FOR_PHONECHARGE;
    }

    public void a(boolean z) {
        this.f25534b = z;
    }
}
