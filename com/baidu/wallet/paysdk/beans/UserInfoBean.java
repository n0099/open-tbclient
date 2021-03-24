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
    public int f25472a;

    /* renamed from: b  reason: collision with root package name */
    public String f25473b;

    /* renamed from: c  reason: collision with root package name */
    public String f25474c;

    public <T> UserInfoBean(Context context) {
        super(context);
        this.f25472a = 0;
        this.f25473b = "";
        this.f25474c = "";
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(DirectPayContentResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("is_unify_account", String.valueOf(this.f25472a)));
        if (!TextUtils.isEmpty(this.f25473b)) {
            arrayList.add(new RestNameValuePair("sdk_from", this.f25473b));
        }
        if (!TextUtils.isEmpty(this.f25474c)) {
            arrayList.add(new RestNameValuePair("sdk_service", this.f25474c));
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
        this.f25472a = i;
        this.f25473b = str;
    }

    public void setSdkServiceForMyBankFragment(String str) {
        this.f25474c = str;
    }
}
