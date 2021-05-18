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
    public NoNetworkView f18320e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f18321f;

    /* renamed from: g  reason: collision with root package name */
    public View f18322g;

    /* renamed from: h  reason: collision with root package name */
    public View f18323h;

    /* renamed from: i  reason: collision with root package name */
    public QuickWebView f18324i;
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
                        d.a.j0.l.a.p(MemberCenterFragment.this.getPageContext().getContext(), null, str, false, true, false, false, false);
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
            MemberCenterFragment.this.K0();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements BaseWebView.e {
        public c() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            if (j.z()) {
                MemberCenterFragment.this.K0();
            } else {
                MemberCenterFragment.this.J0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements BaseWebView.h {
        public d() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            MemberCenterFragment.this.J0();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements BaseWebView.i {
        public e() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.i
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            MemberCenterFragment.this.J0();
        }
    }

    public final void F0(String str) {
        if (this.f18324i == null) {
            return;
        }
        if (j.A()) {
            K0();
            this.f18324i.loadUrl(str);
            return;
        }
        J0();
    }

    public void G0() {
        NavigationBar navigationBar = (NavigationBar) this.f18322g.findViewById(R.id.view_navigation_bar);
        this.f18321f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f18321f.setTitleText(R.string.member_center);
        SkinManager.setNavbarTitleColor(this.f18321f.mTextTitle, R.color.CAM_X0105, R.color.s_navbar_title_color);
        if (this.f18321f.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f18321f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.f18321f.showBottomLine(false);
    }

    public final void H0() {
        this.f18324i.setHorizontalScrollBarEnabled(false);
        this.f18324i.requestDisallowInterceptTouchEvent(true);
        this.f18324i.setOnLoadUrlListener(new a());
        this.f18324i.setOnPageStartedListener(new b());
        this.f18324i.setOnPageFinishedListener(new c());
        this.f18324i.setOnReceivedErrorListener(new d());
        this.f18324i.setOnReceivedSslErrorListener(new e());
    }

    public void I0(String str) {
        this.j = str;
    }

    public final void J0() {
        QuickWebView quickWebView = this.f18324i;
        if (quickWebView == null || this.f18321f == null) {
            return;
        }
        quickWebView.setVisibility(8);
        this.f18321f.setVisibility(0);
        showNetRefreshView(this.f18323h, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
    }

    public final void K0() {
        if (this.f18324i == null || this.f18321f == null) {
            return;
        }
        hideNetRefreshView(this.f18323h);
        this.f18324i.setVisibility(0);
        this.f18321f.setVisibility(8);
    }

    public void loadData() {
        if (this.f18324i == null || this.k) {
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
        if (this.f18324i != null) {
            if (StringUtils.isNull(this.j)) {
                F0(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + UrlSchemaHelper.MEMBER_CENTER_URL);
            } else {
                F0(this.j);
            }
        }
        this.f18321f.onChangeSkinType(getPageContext(), i2);
        this.f18320e.c(getPageContext(), i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.index, (ViewGroup) null);
        this.f18322g = inflate;
        this.f18320e = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.f18321f = (NavigationBar) this.f18322g.findViewById(R.id.view_navigation_bar);
        G0();
        this.f18323h = this.f18322g.findViewById(R.id.member_content_layout);
        this.f18324i = (QuickWebView) this.f18322g.findViewById(R.id.webview);
        H0();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log("c10387");
        return this.f18322g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QuickWebView quickWebView = this.f18324i;
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
        if (this.f18324i == null || this.k) {
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
            F0(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + UrlSchemaHelper.MEMBER_CENTER_URL);
            return;
        }
        F0(this.j);
    }
}
