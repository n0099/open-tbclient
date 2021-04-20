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
    public String f24208a;

    /* renamed from: b  reason: collision with root package name */
    public String f24209b;

    /* renamed from: c  reason: collision with root package name */
    public String f24210c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24211d;

    /* renamed from: e  reason: collision with root package name */
    public String f24212e;

    /* renamed from: f  reason: collision with root package name */
    public String f24213f;

    public <T> HomeCfgBean(Context context) {
        super(context.getApplicationContext());
        this.f24208a = "";
        this.f24209b = "";
        this.f24210c = "";
        this.f24211d = false;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(HomeCfgResponse.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("cate[layout_content]", this.f24208a));
        arrayList.add(new RestNameValuePair("cate[layout_title]", this.f24209b));
        arrayList.add(new RestNameValuePair("cate[layout_footer]", this.f24210c));
        arrayList.add(new RestNameValuePair("page", this.f24213f));
        arrayList.add(new RestNameValuePair("changedSign", this.f24212e));
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
        sb.append(this.f24211d ? WalletHomeBeanConstants.API_HOME_CFG_ABTYPE : WalletHomeBeanConstants.API_HOME_CFG_NEW);
        return sb.toString();
    }

    public void setAbtypeHomePage(boolean z) {
        this.f24211d = z;
    }

    public void setAllFingerPrint(String str) {
        this.f24208a = str;
    }

    public void setChangeSign(String str) {
        this.f24212e = str;
    }

    public void setFooterFingerPrint(String str) {
        this.f24210c = str;
    }

    public void setPageId(String str) {
        this.f24213f = str;
    }

    public void setTitleFingerPrint(String str) {
        this.f24209b = str;
    }
}
