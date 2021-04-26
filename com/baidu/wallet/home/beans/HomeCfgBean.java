package com.baidu.wallet.home.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.home.WalletHomeBeanConstants;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class HomeCfgBean extends BaseBean<HomeCfgResponse> {
    public static String PAGE_CREDIT = "3";
    public static String PAGE_FINANCE = "1";
    public static String PAGE_HOME = "2";

    /* renamed from: a  reason: collision with root package name */
    public String f24968a;

    /* renamed from: b  reason: collision with root package name */
    public String f24969b;

    /* renamed from: c  reason: collision with root package name */
    public String f24970c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24971d;

    /* renamed from: e  reason: collision with root package name */
    public String f24972e;

    /* renamed from: f  reason: collision with root package name */
    public String f24973f;

    public <T> HomeCfgBean(Context context) {
        super(context.getApplicationContext());
        this.f24968a = "";
        this.f24969b = "";
        this.f24970c = "";
        this.f24971d = false;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(HomeCfgResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("cate[layout_content]", this.f24968a));
        arrayList.add(new RestNameValuePair("cate[layout_title]", this.f24969b));
        arrayList.add(new RestNameValuePair("cate[layout_footer]", this.f24970c));
        arrayList.add(new RestNameValuePair("page", this.f24973f));
        arrayList.add(new RestNameValuePair("changedSign", this.f24972e));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return WalletHomeBeanFactory.BEAN_ID_HOME_CFG;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 1;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(DomainConfig.getInstance().getAppHost());
        sb.append(this.f24971d ? WalletHomeBeanConstants.API_HOME_CFG_ABTYPE : WalletHomeBeanConstants.API_HOME_CFG_NEW);
        return sb.toString();
    }

    public void setAbtypeHomePage(boolean z) {
        this.f24971d = z;
    }

    public void setAllFingerPrint(String str) {
        this.f24968a = str;
    }

    public void setChangeSign(String str) {
        this.f24972e = str;
    }

    public void setFooterFingerPrint(String str) {
        this.f24970c = str;
    }

    public void setPageId(String str) {
        this.f24973f = str;
    }

    public void setTitleFingerPrint(String str) {
        this.f24969b = str;
    }
}
