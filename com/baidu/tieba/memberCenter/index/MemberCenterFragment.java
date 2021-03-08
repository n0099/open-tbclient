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
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.QuickWebView;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class MemberCenterFragment extends BaseFragment {
    private NoNetworkView jEV;
    private View kaP;
    private QuickWebView lor;
    private String los;
    private boolean lot = false;
    private NavigationBar mNavigationBar;
    private View mRoot;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.index, (ViewGroup) null);
        this.jEV = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        dfr();
        this.kaP = this.mRoot.findViewById(R.id.member_content_layout);
        this.lor = (QuickWebView) this.mRoot.findViewById(R.id.webview);
        initWebView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(TbadkCoreStatisticKey.FRS_LIVE_TAB_LIST_ITEM);
        return this.mRoot;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void dfr() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.member_center);
        ap.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.CAM_X0105, R.color.s_navbar_title_color);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsU().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mNavigationBar.showBottomLine(false);
    }

    public void setUrl(String str) {
        this.los = str;
    }

    public void loadData() {
        if (this.lor != null && !this.lot) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.lor != null && !this.lot) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.lor != null) {
            this.lor.destroy();
        }
        super.onDestroy();
    }

    private void refresh() {
        this.lot = true;
        if (StringUtils.isNull(this.los)) {
            Of(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "mo/q/hybrid/tbvip");
        } else {
            Of(this.los);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.lor != null) {
                if (StringUtils.isNull(this.los)) {
                    Of(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "mo/q/hybrid/tbvip");
                } else {
                    Of(this.los);
                }
            }
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            this.jEV.onChangeSkinType(getPageContext(), i);
        }
    }

    private void Of(String str) {
        if (this.lor != null) {
            if (j.isNetworkAvailableForImmediately()) {
                bUf();
                this.lor.loadUrl(str);
                return;
            }
            bRH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUf() {
        if (this.lor != null && this.mNavigationBar != null) {
            hideNetRefreshView(this.kaP);
            this.lor.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRH() {
        if (this.lor != null && this.mNavigationBar != null) {
            this.lor.setVisibility(8);
            this.mNavigationBar.setVisibility(0);
            showNetRefreshView(this.kaP, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
        }
    }

    private void initWebView() {
        this.lor.setHorizontalScrollBarEnabled(false);
        this.lor.requestDisallowInterceptTouchEvent(true);
        this.lor.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.memberCenter.index.MemberCenterFragment.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (StringUtils.isNull(str) || !str.contains("page/tb_vip")) {
                    if (bf.bsY().a(MemberCenterFragment.this.getPageContext(), new String[]{str}) == 3) {
                        if (StringUtils.isNull(str) || !str.contains(UrlSchemaHelper.JUMP_TO_THIS_PAGE)) {
                            if (!StringUtils.isNull(str) && str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                                a.startWebActivity(MemberCenterFragment.this.getPageContext().getContext(), null, str, false, true, false, false, false);
                                return true;
                            }
                            bf.bsY().a((TbPageContext<?>) MemberCenterFragment.this.getPageContext(), new String[]{str}, true);
                            return true;
                        }
                        return false;
                    }
                    return true;
                }
                return false;
            }
        });
        this.lor.setOnPageStartedListener(new BaseWebView.d() { // from class: com.baidu.tieba.memberCenter.index.MemberCenterFragment.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
            public void onPageStarted(WebView webView, String str) {
                MemberCenterFragment.this.bUf();
            }
        });
        this.lor.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.memberCenter.index.MemberCenterFragment.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (j.isNetWorkAvailable()) {
                    MemberCenterFragment.this.bUf();
                } else {
                    MemberCenterFragment.this.bRH();
                }
            }
        });
        this.lor.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.memberCenter.index.MemberCenterFragment.4
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                MemberCenterFragment.this.bRH();
            }
        });
        this.lor.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.memberCenter.index.MemberCenterFragment.5
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                MemberCenterFragment.this.bRH();
            }
        });
    }
}
