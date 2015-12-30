package com.baidu.tieba.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.adp.lib.h.h;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
/* loaded from: classes.dex */
public class WXEntryActivity extends BaseActivity<WXEntryActivity> implements IWXAPIEventHandler {
    private SapiWebView czI;
    private FrameLayout czK;
    private IWXAPI dZl;
    private boolean dZm;
    private Intent dZn;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.layout_sapi_webview_login);
        this.mNavigationBar = (NavigationBar) findViewById(n.g.sapi_login_navi);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getResources().getString(n.j.login));
        this.czK = (FrameLayout) findViewById(n.g.webview_container);
        this.czI = new SapiWebView(getPageContext().getPageActivity());
        this.czK.removeAllViews();
        this.czK.addView(this.czI);
        com.baidu.tbadk.core.a.d.a(getPageContext().getPageActivity(), this.czI);
        this.czI.setOnBackCallback(new a(this));
        this.czI.setOnFinishCallback(new b(this));
        this.czI.setWeixinHandler(new c(this));
        this.czI.setAuthorizationListener(new d(this));
        this.dZl = WXAPIFactory.createWXAPI(getPageContext().getPageActivity(), SapiAccountManager.getInstance().getSapiConfiguration().wxAppID, false);
        this.dZn = getIntent();
        if (this.dZn != null) {
            this.dZl.handleIntent(getIntent(), this);
        }
        if (!this.dZm) {
            this.czI.loadWeixinSSOLogin();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.dZn = intent;
        if (this.dZn != null) {
            this.dZl.handleIntent(intent, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        if (this.dZn != null) {
            f.aMv().ac(this.dZn);
        }
        closeActivity();
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        String str;
        if (baseResp != null) {
            if (1 == baseResp.getType()) {
                this.dZm = true;
                if (baseResp.errCode == 0) {
                    if (baseResp instanceof SendAuth.Resp) {
                        String str2 = ((SendAuth.Resp) baseResp).state;
                        String str3 = ((SendAuth.Resp) baseResp).code;
                        if (this.czI != null) {
                            this.czI.weixinSSOLogin(str3, str2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                setResult(230014);
                closeActivity();
            } else if (2 == baseResp.getType() && (baseResp instanceof SendMessageToWX.Resp)) {
                SendMessageToWX.Resp resp = (SendMessageToWX.Resp) baseResp;
                int i = resp.errCode;
                if (resp.errStr == null) {
                    str = "";
                } else {
                    str = resp.errStr;
                }
                if (i == 0) {
                    k.showToast(getActivity(), n.j.share_alert_success);
                } else if (i != -2) {
                    if (i == 123456) {
                        k.showToast(getActivity(), n.j.weixin_not_installed_yet);
                    } else {
                        com.baidu.tbadk.core.log.b.a("socail_share", -1L, 0, "wx_share_fail", i, "", "share_fail_exception", String.valueOf(str) + "&" + com.baidu.tbadk.coreExtra.share.d.alI);
                        k.showToast(getActivity(), n.j.share_alert_fail);
                    }
                }
                this.dZm = true;
                closeActivity();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.czK != null) {
            this.czK.removeAllViews();
        }
        if (this.czI != null) {
            this.czI.setAuthorizationListener(null);
            this.czI.setSocialLoginHandler(null);
            this.czI.setWeixinHandler(null);
            this.czI.setOnBackCallback(null);
            this.czI.setOnFinishCallback(null);
            this.czI.getSettings().setBuiltInZoomControls(true);
            this.czI.setVisibility(8);
            h.hj().postDelayed(new e(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
        super.onDestroy();
    }
}
