package com.baidu.wallet.base.iddetect.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.base.iddetect.datamodel.IDDetectResponse;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BaseBean;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseBean<IDDetectResponse> {

    /* renamed from: a  reason: collision with root package name */
    public String f23332a;

    public <T> a(Context context) {
        super(context);
        this.f23332a = "";
    }

    public void a(String str) {
        this.f23332a = str;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(IDDetectResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("id_pic", this.f23332a));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return IDDetectBeanFactory.BEAN_ID_ID_DETECT;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getEncode() {
        return "gbk";
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 1;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DebugConfig.getInstance(this.mContext).getWalletHttpsHost() + "/odp/wireless/api/upprcid";
    }
}
