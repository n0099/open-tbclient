package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.WalletInterfaceResponse;
import com.baidu.wallet.paysdk.storage.PayPreferenceManager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class w extends BaseBean<WalletInterfaceResponse> {
    public w(Context context) {
        super(context);
    }

    private boolean a(Context context) {
        return ((Boolean) SharedPreferencesUtils.getParam(context, com.baidu.wallet.core.beans.BeanConstants.PREFERENCES_NAME, "key_for_home_mask_switch" + PayPreferenceManager.getPpKey(context), Boolean.FALSE)).booleanValue();
    }

    private boolean b(Context context) {
        return ((Boolean) SharedPreferencesUtils.getParam(context, com.baidu.wallet.core.beans.BeanConstants.PREFERENCES_NAME, "key_for_home_mask_switch" + PayPreferenceManager.getNewPpKey(context), Boolean.FALSE)).booleanValue();
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(WalletInterfaceResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("isOpenSecurity", a(this.mContext) || b(this.mContext) ? "1" : "0"));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_GET_WALLET_INTERFACE;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 0;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppHost() + BeanConstants.API_WALLET_INTERFACE;
    }
}
