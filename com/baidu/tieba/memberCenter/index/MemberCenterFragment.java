package com.baidu.tieba.memberCenter.index;

import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.QuickWebView;
import d.a.c.e.p.j;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class MemberCenterFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f19032e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f19033f;

    /* renamed from: g  reason: collision with root package name */
    public View f19034g;

    /* renamed from: h  reason: collision with root package name */
    public View f19035h;

    /* renamed from: i  reason: collision with root package name */
    public QuickWebView f19036i;
    public String j;
    public boolean k = false;

    /* loaded from: classes3.dex */
    public class a implements BaseWebView.d {
        public a() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (StringUtils.isNull(str) || !str.contains("page/tb_vip")) {
                if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(MemberCenterFragment.this.getPageContext(), new String[]{str}) != 3) {
                    return true;
                }
                if (StringUtils.isNull(str) || !str.contains(UrlSchemaHelper.JUMP_TO_THIS_PAGE)) {
                    if (!StringUtils.isNull(str) && str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                        d.a.i0.l.a.p(MemberCenterFragment.this.getPageContext().getContext(), null, str, false, true, false, false, false);
                        return true;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext<?>) MemberCenterFragment.this.getPageContext(), new String[]{str}, true);
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BaseWebView.f {
        public b() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
        public void a(WebView webView, String str) {
            MemberCenterFragment.this.L0();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements BaseWebView.e {
        public c() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            if (j.z()) {
                MemberCenterFragment.this.L0();
            } else {
                MemberCenterFragment.this.K0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements BaseWebView.h {
        public d() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            MemberCenterFragment.this.K0();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements BaseWebView.i {
        public e() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.i
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            MemberCenterFragment.this.K0();
        }
    }

    public final void G0(String str) {
        if (this.f19036i == null) {
            return;
        }
        if (j.A()) {
            L0();
            this.f19036i.loadUrl(str);
            return;
        }
        K0();
    }

    public void H0() {
        NavigationBar navigationBar = (NavigationBar) this.f19034g.findViewById(R.id.view_navigation_bar);
        this.f19033f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f19033f.setTitleText(R.string.member_center);
        SkinManager.setNavbarTitleColor(this.f19033f.mTextTitle, R.color.CAM_X0105, R.color.s_navbar_title_color);
        if (this.f19033f.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19033f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.f19033f.showBottomLine(false);
    }

    public final void I0() {
        this.f19036i.setHorizontalScrollBarEnabled(false);
        this.f19036i.requestDisallowInterceptTouchEvent(true);
        this.f19036i.setOnLoadUrlListener(new a());
        this.f19036i.setOnPageStartedListener(new b());
        this.f19036i.setOnPageFinishedListener(new c());
        this.f19036i.setOnReceivedErrorListener(new d());
        this.f19036i.setOnReceivedSslErrorListener(new e());
    }

    public void J0(String str) {
        this.j = str;
    }

    public final void K0() {
        QuickWebView quickWebView = this.f19036i;
        if (quickWebView == null || this.f19033f == null) {
            return;
        }
        quickWebView.setVisibility(8);
        this.f19033f.setVisibility(0);
        showNetRefreshView(this.f19035h, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
    }

    public final void L0() {
        if (this.f19036i == null || this.f19033f == null) {
            return;
        }
        hideNetRefreshView(this.f19035h);
        this.f19036i.setVisibility(0);
        this.f19033f.setVisibility(8);
    }

    public void loadData() {
        if (this.f19036i == null || this.k) {
            return;
        }
        refresh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        if (this.mSkinType == i2) {
            return;
        }
        this.mSkinType = i2;
        if (this.f19036i != null) {
            if (StringUtils.isNull(this.j)) {
                G0(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + UrlSchemaHelper.MEMBER_CENTER_URL);
            } else {
                G0(this.j);
            }
        }
        this.f19033f.onChangeSkinType(getPageContext(), i2);
        this.f19032e.c(getPageContext(), i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.index, (ViewGroup) null);
        this.f19034g = inflate;
        this.f19032e = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.f19033f = (NavigationBar) this.f19034g.findViewById(R.id.view_navigation_bar);
        H0();
        this.f19035h = this.f19034g.findViewById(R.id.member_content_layout);
        this.f19036i = (QuickWebView) this.f19034g.findViewById(R.id.webview);
        I0();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log("c10387");
        return this.f19034g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QuickWebView quickWebView = this.f19036i;
        if (quickWebView != null) {
            quickWebView.destroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        refresh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.f19036i == null || this.k) {
            return;
        }
        refresh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public final void refresh() {
        this.k = true;
        if (StringUtils.isNull(this.j)) {
            G0(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + UrlSchemaHelper.MEMBER_CENTER_URL);
            return;
        }
        G0(this.j);
    }
}
