package com.baidu.wallet.home.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.home.WalletHomeBeanConstants;
import com.baidu.wallet.home.datamodel.HomeTabResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class HomeTabBean extends BaseBean<HomeTabResponse> {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f24214a;

    public HomeTabBean(Context context) {
        super(context);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(HomeTabResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        HashMap<String, String> hashMap = this.f24214a;
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                arrayList.add(new RestNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return WalletHomeBeanFactory.BEAN_ID_HOMETAB;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppHost() + WalletHomeBeanConstants.HOME_TAB_URL;
    }

    public void setParams(HashMap<String, String> hashMap) {
        this.f24214a = hashMap;
    }
}
