package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class HomeMainView extends LinearLayout implements b {

    /* renamed from: a  reason: collision with root package name */
    public List<BaseItemLayout> f24583a;

    /* renamed from: b  reason: collision with root package name */
    public String f24584b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24585c;

    /* renamed from: d  reason: collision with root package name */
    public d f24586d;

    /* renamed from: e  reason: collision with root package name */
    public String f24587e;
    public HomeCfgResponse.AllConfig mAllConfig;

    public HomeMainView(Context context) {
        super(context);
        this.f24583a = new ArrayList();
        this.f24585c = false;
    }

    private void a() {
        removeAllViews();
        this.f24583a.clear();
    }

    private boolean b() {
        for (BaseItemLayout baseItemLayout : this.f24583a) {
            if (baseItemLayout.hasItemShowPoint()) {
                return true;
            }
        }
        return false;
    }

    public void dispatchDot(String str) {
        for (BaseItemLayout baseItemLayout : this.f24583a) {
            baseItemLayout.dispatchShowPoint(str);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.b
    public String getAndroidPrefix() {
        return TextUtils.isEmpty(this.f24584b) ? "" : this.f24584b;
    }

    @Override // com.baidu.wallet.home.ui.widget.b
    public String getPageType() {
        return this.f24587e;
    }

    public boolean isApp() {
        return BeanConstants.CHANNEL_ID_WALLET_APP.equalsIgnoreCase(BeanConstants.CHANNEL_ID);
    }

    @Override // com.baidu.wallet.home.ui.widget.b
    public boolean isLoginData() {
        return this.f24585c;
    }

    @Override // com.baidu.wallet.home.ui.widget.b
    public void jump(String str, String str2, String str3, boolean z) {
        d dVar = this.f24586d;
        if (dVar == null || !dVar.a(str, str2, str3)) {
            com.baidu.wallet.home.a.a().a(getContext(), str, str2, str3, z, this.f24587e);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.b
    public void login() {
        WalletLoginHelper.getInstance().login(new LoginBackListenerProxy(getContext(), new ILoginBackListener() { // from class: com.baidu.wallet.home.ui.widget.HomeMainView.1
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str) {
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str) {
            }
        }));
    }

    @Override // com.baidu.wallet.home.ui.widget.b
    public void onEyeMaskBtnClick() {
        boolean z = !com.baidu.wallet.home.storage.a.a(getContext());
        com.baidu.wallet.home.storage.a.a(getContext(), z);
        for (BaseItemLayout baseItemLayout : this.f24583a) {
            baseItemLayout.onEyeMaskChanged();
        }
        PayStatisticsUtil.onEventWithValue(com.baidu.wallet.home.a.a.f24521a, z ? "true" : "false");
    }

    @Override // com.baidu.wallet.home.ui.widget.b
    public void onPointShowChanged() {
        d dVar = this.f24586d;
        if (dVar != null) {
            dVar.a(b());
        }
    }

    public void setAdapter(Context context, HomeCfgResponse homeCfgResponse, String str) {
        HomeCfgResponse.TitleItem[] titleItemArr;
        this.f24587e = str;
        a();
        this.mAllConfig = homeCfgResponse.layout_content;
        this.f24584b = homeCfgResponse.android_prefix;
        this.f24585c = homeCfgResponse.isLogin();
        HomeCfgResponse.AllConfig allConfig = this.mAllConfig;
        if (allConfig != null && allConfig.data != null) {
            boolean z = true;
            for (int i = 0; i < this.mAllConfig.data.length; i++) {
                BaseItemLayout a2 = a.a().a(context, this.mAllConfig.data[i], this.f24584b);
                if (a2 != null) {
                    a2.setConfigData(this.mAllConfig.data[i], this);
                    if (a2.isDataValid()) {
                        if (this.mAllConfig.data[i].isLayoutHasGap()) {
                            if (z) {
                                a(2);
                            } else {
                                a(3);
                            }
                        }
                        if (z) {
                            z = false;
                        }
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.weight = 0.0f;
                        addView(a2, layoutParams);
                        this.f24583a.add(a2);
                    }
                }
            }
            if (this.f24583a.size() > 0) {
                a(1);
            }
        }
        HomeCfgResponse.TitleConfig titleConfig = homeCfgResponse.layout_title;
        if (titleConfig != null && (titleItemArr = titleConfig.data) != null && titleItemArr.length > 0) {
            HomeCfgResponse.TitleItem titleItem = titleItemArr[0];
            FeedBackLayout feedBackLayout = new FeedBackLayout(context);
            feedBackLayout.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_base_background1_color"));
            feedBackLayout.setData(titleItem, this);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.weight = 1.0f;
            addView(feedBackLayout, layoutParams2);
            this.f24583a.add(feedBackLayout);
        }
        onPointShowChanged();
    }

    public void setClickOuterInterface(d dVar) {
        this.f24586d = dVar;
    }

    private void a(int i) {
        boolean z;
        boolean z2 = false;
        boolean z3 = true;
        if (i != 0) {
            if (i == 1) {
                z = false;
                z2 = true;
            } else if (i == 2) {
                z = true;
            } else if (i != 3) {
                z = false;
            } else {
                z = true;
                z2 = true;
            }
            z3 = false;
        } else {
            z = false;
        }
        if (z2) {
            View view = new View(getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), 0.5f)));
            view.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_base_separateColor"));
            addView(view);
        }
        if (z3) {
            View view2 = new View(getContext());
            view2.setLayoutParams(new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), 10.0f)));
            view2.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_base_background1_color"));
            addView(view2);
        }
        if (z) {
            View view3 = new View(getContext());
            view3.setLayoutParams(new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), 0.5f)));
            view3.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_base_separateColor"));
            addView(view3);
        }
    }

    public HomeMainView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24583a = new ArrayList();
        this.f24585c = false;
    }
}
