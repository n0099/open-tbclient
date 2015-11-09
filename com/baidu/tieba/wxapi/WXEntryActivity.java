package com.baidu.tieba.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.adp.lib.g.h;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
/* loaded from: classes.dex */
public class WXEntryActivity extends BaseActivity<WXEntryActivity> implements IWXAPIEventHandler {
    private SapiWebView cdG;
    private FrameLayout cdI;
    private IWXAPI dsI;
    private boolean dsJ;
    private Intent dsK;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.layout_sapi_webview_login);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.sapi_login_navi);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getResources().getString(i.h.login));
        this.cdI = (FrameLayout) findViewById(i.f.webview_container);
        this.cdG = new SapiWebView(getPageContext().getPageActivity());
        this.cdI.removeAllViews();
        this.cdI.addView(this.cdG);
        com.baidu.tbadk.core.a.d.a(getPageContext().getPageActivity(), this.cdG);
        this.cdG.setOnBackCallback(new a(this));
        this.cdG.setOnFinishCallback(new b(this));
        this.cdG.setWeixinHandler(new c(this));
        this.cdG.setAuthorizationListener(new d(this));
        this.dsI = WXAPIFactory.createWXAPI(getPageContext().getPageActivity(), SapiAccountManager.getInstance().getSapiConfiguration().wxAppID, false);
        this.dsK = getIntent();
        if (this.dsK != null) {
            this.dsI.handleIntent(getIntent(), this);
        }
        if (!this.dsJ) {
            this.cdG.loadWeixinSSOLogin();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.dsK = intent;
        if (this.dsK != null) {
            this.dsI.handleIntent(intent, this);
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
        if (this.dsK != null) {
            f.aED().ad(this.dsK);
        }
        closeActivity();
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        String str;
        if (baseResp != null) {
            if (1 == baseResp.getType()) {
                this.dsJ = true;
                if (baseResp.errCode == 0) {
                    if (baseResp instanceof SendAuth.Resp) {
                        String str2 = ((SendAuth.Resp) baseResp).state;
                        String str3 = ((SendAuth.Resp) baseResp).code;
                        if (this.cdG != null) {
                            this.cdG.weixinSSOLogin(str3, str2);
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
                    k.showToast(getActivity(), i.h.share_alert_success);
                } else if (i != -2) {
                    com.baidu.tbadk.core.log.b.a("socail_share", -1L, 0, "wx_share_fail", i, "", "share_fail_exception", str);
                    k.showToast(getActivity(), i.h.share_alert_fail);
                }
                this.dsJ = true;
                closeActivity();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cdI != null) {
            this.cdI.removeAllViews();
        }
        if (this.cdG != null) {
            this.cdG.setAuthorizationListener(null);
            this.cdG.setSocialLoginHandler(null);
            this.cdG.setWeixinHandler(null);
            this.cdG.setOnBackCallback(null);
            this.cdG.setOnFinishCallback(null);
            this.cdG.getSettings().setBuiltInZoomControls(true);
            this.cdG.setVisibility(8);
            h.hh().postDelayed(new e(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
        super.onDestroy();
    }
}
