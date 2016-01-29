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
import com.baidu.tieba.t;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
/* loaded from: classes.dex */
public class WXEntryActivity extends BaseActivity<WXEntryActivity> implements IWXAPIEventHandler {
    private SapiWebView cGo;
    private FrameLayout cGq;
    private IWXAPI eua;
    private boolean eub;
    private Intent euc;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.layout_sapi_webview_login);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.sapi_login_navi);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getResources().getString(t.j.login));
        this.cGq = (FrameLayout) findViewById(t.g.webview_container);
        this.cGo = new SapiWebView(getPageContext().getPageActivity());
        this.cGq.removeAllViews();
        this.cGq.addView(this.cGo);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.cGo);
        this.cGo.setOnBackCallback(new a(this));
        this.cGo.setOnFinishCallback(new b(this));
        this.cGo.setWeixinHandler(new c(this));
        this.cGo.setAuthorizationListener(new d(this));
        this.eua = WXAPIFactory.createWXAPI(getPageContext().getPageActivity(), SapiAccountManager.getInstance().getSapiConfiguration().wxAppID, false);
        this.euc = getIntent();
        if (this.euc != null) {
            this.eua.handleIntent(getIntent(), this);
        }
        if (!this.eub) {
            this.cGo.loadWeixinSSOLogin();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.euc = intent;
        if (this.euc != null) {
            this.eua.handleIntent(intent, this);
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
        if (this.euc != null) {
            f.aVp().af(this.euc);
        }
        closeActivity();
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        String str;
        if (baseResp != null) {
            if (1 == baseResp.getType()) {
                this.eub = true;
                if (baseResp.errCode == 0) {
                    if (baseResp instanceof SendAuth.Resp) {
                        String str2 = ((SendAuth.Resp) baseResp).state;
                        String str3 = ((SendAuth.Resp) baseResp).code;
                        if (this.cGo != null) {
                            this.cGo.weixinSSOLogin(str3, str2);
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
                    k.showToast(getActivity(), t.j.share_alert_success);
                } else if (i != -2) {
                    if (i == 123456) {
                        k.showToast(getActivity(), t.j.weixin_not_installed_yet);
                    } else {
                        com.baidu.tbadk.core.log.b.a("socail_share", -1L, 0, "wx_share_fail", i, "", "share_fail_exception", String.valueOf(str) + "&" + com.baidu.tbadk.coreExtra.share.d.amA);
                        k.showToast(getActivity(), t.j.share_alert_fail);
                    }
                }
                this.eub = true;
                closeActivity();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cGq != null) {
            this.cGq.removeAllViews();
        }
        if (this.cGo != null) {
            this.cGo.setAuthorizationListener(null);
            this.cGo.setSocialLoginHandler(null);
            this.cGo.setWeixinHandler(null);
            this.cGo.setOnBackCallback(null);
            this.cGo.setOnFinishCallback(null);
            this.cGo.getSettings().setBuiltInZoomControls(true);
            this.cGo.setVisibility(8);
            h.hr().postDelayed(new e(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
        super.onDestroy();
    }
}
