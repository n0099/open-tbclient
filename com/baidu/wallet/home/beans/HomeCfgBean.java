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
    public String f24327a;

    /* renamed from: b  reason: collision with root package name */
    public String f24328b;

    /* renamed from: c  reason: collision with root package name */
    public String f24329c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24330d;

    /* renamed from: e  reason: collision with root package name */
    public String f24331e;

    /* renamed from: f  reason: collision with root package name */
    public String f24332f;

    public <T> HomeCfgBean(Context context) {
        super(context.getApplicationContext());
        this.f24327a = "";
        this.f24328b = "";
        this.f24329c = "";
        this.f24330d = false;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(HomeCfgResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("cate[layout_content]", this.f24327a));
        arrayList.add(new RestNameValuePair("cate[layout_title]", this.f24328b));
        arrayList.add(new RestNameValuePair("cate[layout_footer]", this.f24329c));
        arrayList.add(new RestNameValuePair("page", this.f24332f));
        arrayList.add(new RestNameValuePair("changedSign", this.f24331e));
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
        sb.append(this.f24330d ? WalletHomeBeanConstants.API_HOME_CFG_ABTYPE : WalletHomeBeanConstants.API_HOME_CFG_NEW);
        return sb.toString();
    }

    public void setAbtypeHomePage(boolean z) {
        this.f24330d = z;
    }

    public void setAllFingerPrint(String str) {
        this.f24327a = str;
    }

    public void setChangeSign(String str) {
        this.f24331e = str;
    }

    public void setFooterFingerPrint(String str) {
        this.f24329c = str;
    }

    public void setPageId(String str) {
        this.f24332f = str;
    }

    public void setTitleFingerPrint(String str) {
        this.f24328b = str;
    }
}
