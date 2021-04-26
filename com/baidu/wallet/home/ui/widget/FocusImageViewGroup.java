package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;
import com.baidu.wallet.home.beans.HomeCfgBean;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class FocusImageViewGroup extends BannerFocusImageViewGroup {
    public String mPageType;

    public FocusImageViewGroup(Context context) {
        super(context);
        this.mPageType = HomeCfgBean.PAGE_HOME;
    }

    @Override // com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup
    public void jump(BannerBaseItemInfo bannerBaseItemInfo) {
        com.baidu.wallet.home.a.a().a(getContext(), bannerBaseItemInfo.getStat() != null ? bannerBaseItemInfo.getStat() : bannerBaseItemInfo.getName(), bannerBaseItemInfo.getType(), bannerBaseItemInfo.getLinkAddr(), bannerBaseItemInfo.getPrevlogin(), this.mPageType);
    }

    public void setFocusConfigInfo(BannerBaseItemInfo[] bannerBaseItemInfoArr, String str, String str2) {
        this.mPageType = str2;
        super.setFocusConfigInfo(bannerBaseItemInfoArr, str);
    }

    @Override // com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup
    public void triggerOnEvent(String str) {
        DXMSdkSAUtils.onEventWithValues("newHomeAdClick", Arrays.asList(str));
        PayStatisticsUtil.onEventWithValue("newHomeAdClick", str);
    }

    public FocusImageViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPageType = HomeCfgBean.PAGE_HOME;
    }

    public FocusImageViewGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mPageType = HomeCfgBean.PAGE_HOME;
    }
}
