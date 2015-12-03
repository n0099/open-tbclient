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
    private SapiWebView cwe;
    private FrameLayout cwg;
    private IWXAPI dRN;
    private boolean dRO;
    private Intent dRP;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.layout_sapi_webview_login);
        this.mNavigationBar = (NavigationBar) findViewById(n.f.sapi_login_navi);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getResources().getString(n.i.login));
        this.cwg = (FrameLayout) findViewById(n.f.webview_container);
        this.cwe = new SapiWebView(getPageContext().getPageActivity());
        this.cwg.removeAllViews();
        this.cwg.addView(this.cwe);
        com.baidu.tbadk.core.a.d.a(getPageContext().getPageActivity(), this.cwe);
        this.cwe.setOnBackCallback(new a(this));
        this.cwe.setOnFinishCallback(new b(this));
        this.cwe.setWeixinHandler(new c(this));
        this.cwe.setAuthorizationListener(new d(this));
        this.dRN = WXAPIFactory.createWXAPI(getPageContext().getPageActivity(), SapiAccountManager.getInstance().getSapiConfiguration().wxAppID, false);
        this.dRP = getIntent();
        if (this.dRP != null) {
            this.dRN.handleIntent(getIntent(), this);
        }
        if (!this.dRO) {
            this.cwe.loadWeixinSSOLogin();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.dRP = intent;
        if (this.dRP != null) {
            this.dRN.handleIntent(intent, this);
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
        if (this.dRP != null) {
            f.aKa().ad(this.dRP);
        }
        closeActivity();
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        String str;
        if (baseResp != null) {
            if (1 == baseResp.getType()) {
                this.dRO = true;
                if (baseResp.errCode == 0) {
                    if (baseResp instanceof SendAuth.Resp) {
                        String str2 = ((SendAuth.Resp) baseResp).state;
                        String str3 = ((SendAuth.Resp) baseResp).code;
                        if (this.cwe != null) {
                            this.cwe.weixinSSOLogin(str3, str2);
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
                    k.showToast(getActivity(), n.i.share_alert_success);
                } else if (i != -2) {
                    com.baidu.tbadk.core.log.b.a("socail_share", -1L, 0, "wx_share_fail", i, "", "share_fail_exception", String.valueOf(str) + "&" + com.baidu.tbadk.coreExtra.share.d.akC);
                    k.showToast(getActivity(), n.i.share_alert_fail);
                }
                this.dRO = true;
                closeActivity();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cwg != null) {
            this.cwg.removeAllViews();
        }
        if (this.cwe != null) {
            this.cwe.setAuthorizationListener(null);
            this.cwe.setSocialLoginHandler(null);
            this.cwe.setWeixinHandler(null);
            this.cwe.setOnBackCallback(null);
            this.cwe.setOnFinishCallback(null);
            this.cwe.getSettings().setBuiltInZoomControls(true);
            this.cwe.setVisibility(8);
            h.hj().postDelayed(new e(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
        super.onDestroy();
    }
}
