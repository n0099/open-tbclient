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
    public int f25473a;

    /* renamed from: b  reason: collision with root package name */
    public String f25474b;

    /* renamed from: c  reason: collision with root package name */
    public String f25475c;

    public <T> UserInfoBean(Context context) {
        super(context);
        this.f25473a = 0;
        this.f25474b = "";
        this.f25475c = "";
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(DirectPayContentResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("is_unify_account", String.valueOf(this.f25473a)));
        if (!TextUtils.isEmpty(this.f25474b)) {
            arrayList.add(new RestNameValuePair("sdk_from", this.f25474b));
        }
        if (!TextUtils.isEmpty(this.f25475c)) {
            arrayList.add(new RestNameValuePair("sdk_service", this.f25475c));
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

    public void setCheckPrePassSign(int i, String str) {
        this.f25473a = i;
        this.f25474b = str;
    }

    public void setSdkServiceForMyBankFragment(String str) {
        this.f25475c = str;
    }
}
