package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class UserInfoBean extends PayBaseBean<DirectPayContentResponse> implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public int f25110a;

    /* renamed from: b  reason: collision with root package name */
    public String f25111b;

    /* renamed from: c  reason: collision with root package name */
    public String f25112c;

    public <T> UserInfoBean(Context context) {
        super(context);
        this.f25110a = 0;
        this.f25111b = "";
        this.f25112c = "";
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(DirectPayContentResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("is_unify_account", String.valueOf(this.f25110a)));
        if (!TextUtils.isEmpty(this.f25111b)) {
            arrayList.add(new RestNameValuePair("sdk_from", this.f25111b));
        }
        if (!TextUtils.isEmpty(this.f25112c)) {
            arrayList.add(new RestNameValuePair("sdk_service", this.f25112c));
        }
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 6;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_USER_INFO;
    }

    public void setCheckPrePassSign(int i2, String str) {
        this.f25110a = i2;
        this.f25111b = str;
    }

    public void setSdkServiceForMyBankFragment(String str) {
        this.f25112c = str;
    }
}
