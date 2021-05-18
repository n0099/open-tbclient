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
    public int f25181a;

    /* renamed from: b  reason: collision with root package name */
    public String f25182b;

    /* renamed from: c  reason: collision with root package name */
    public String f25183c;

    public <T> UserInfoBean(Context context) {
        super(context);
        this.f25181a = 0;
        this.f25182b = "";
        this.f25183c = "";
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(DirectPayContentResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("is_unify_account", String.valueOf(this.f25181a)));
        if (!TextUtils.isEmpty(this.f25182b)) {
            arrayList.add(new RestNameValuePair("sdk_from", this.f25182b));
        }
        if (!TextUtils.isEmpty(this.f25183c)) {
            arrayList.add(new RestNameValuePair("sdk_service", this.f25183c));
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
        this.f25181a = i2;
        this.f25182b = str;
    }

    public void setSdkServiceForMyBankFragment(String str) {
        this.f25183c = str;
    }
}
