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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.QuickWebView;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class MemberCenterFragment extends BaseFragment {
    private NoNetworkView jBY;
    private View jVC;
    private QuickWebView liA;
    private String liB;
    private boolean liC = false;
    private NavigationBar mNavigationBar;
    private View mRoot;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.index, (ViewGroup) null);
        this.jBY = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        dgT();
        this.jVC = this.mRoot.findViewById(R.id.member_content_layout);
        this.liA = (QuickWebView) this.mRoot.findViewById(R.id.webview);
        initWebView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(TbadkCoreStatisticKey.FRS_LIVE_TAB_LIST_ITEM);
        return this.mRoot;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void dgT() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.member_center);
        ao.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.CAM_X0105, R.color.s_navbar_title_color);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bwr().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mNavigationBar.showBottomLine(false);
    }

    public void setUrl(String str) {
        this.liB = str;
    }

    public void loadData() {
        if (this.liA != null && !this.liC) {
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
        if (this.liA != null && !this.liC) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.liA != null) {
            this.liA.destroy();
        }
        super.onDestroy();
    }

    private void refresh() {
        this.liC = true;
        if (StringUtils.isNull(this.liB)) {
            Or(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "n/apage-runtime/page/tb_vip");
        } else {
            Or(this.liB);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.liA != null) {
                if (StringUtils.isNull(this.liB)) {
                    Or(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "n/apage-runtime/page/tb_vip");
                } else {
                    Or(this.liB);
                }
            }
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            this.jBY.onChangeSkinType(getPageContext(), i);
        }
    }

    private void Or(String str) {
        if (this.liA != null) {
            if (j.isNetworkAvailableForImmediately()) {
                bXg();
                this.liA.loadUrl(str);
                return;
            }
            bUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXg() {
        if (this.liA != null && this.mNavigationBar != null) {
            hideNetRefreshView(this.jVC);
            this.liA.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUI() {
        if (this.liA != null && this.mNavigationBar != null) {
            this.liA.setVisibility(8);
            this.mNavigationBar.setVisibility(0);
            showNetRefreshView(this.jVC, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
        }
    }

    private void initWebView() {
        this.liA.setHorizontalScrollBarEnabled(false);
        this.liA.requestDisallowInterceptTouchEvent(true);
        this.liA.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.memberCenter.index.MemberCenterFragment.1
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (StringUtils.isNull(str) || !str.contains("page/tb_vip")) {
                    if (be.bwv().a(MemberCenterFragment.this.getPageContext(), new String[]{str}) == 3) {
                        if (StringUtils.isNull(str) || !str.contains(UrlSchemaHelper.JUMP_TO_THIS_PAGE)) {
                            if (!StringUtils.isNull(str) && str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                                a.startWebActivity(MemberCenterFragment.this.getPageContext().getContext(), null, str, false, true, false, false, false);
                                return true;
                            }
                            be.bwv().a((TbPageContext<?>) MemberCenterFragment.this.getPageContext(), new String[]{str}, true);
                            return true;
                        }
                        return false;
                    }
                    return true;
                }
                return false;
            }
        });
        this.liA.setOnPageStartedListener(new BaseWebView.d() { // from class: com.baidu.tieba.memberCenter.index.MemberCenterFragment.2
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
            public void onPageStarted(WebView webView, String str) {
                MemberCenterFragment.this.bXg();
            }
        });
        this.liA.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.memberCenter.index.MemberCenterFragment.3
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
            public void onPageFinished(WebView webView, String str) {
                if (j.isNetWorkAvailable()) {
                    MemberCenterFragment.this.bXg();
                } else {
                    MemberCenterFragment.this.bUI();
                }
            }
        });
        this.liA.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.memberCenter.index.MemberCenterFragment.4
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                MemberCenterFragment.this.bUI();
            }
        });
        this.liA.setOnReceivedSslErrorListener(new BaseWebView.g() { // from class: com.baidu.tieba.memberCenter.index.MemberCenterFragment.5
            @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                MemberCenterFragment.this.bUI();
            }
        });
    }
}
