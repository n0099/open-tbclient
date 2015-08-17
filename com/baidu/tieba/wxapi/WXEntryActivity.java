package com.baidu.tieba.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.util.Timer;
/* loaded from: classes.dex */
public class WXEntryActivity extends BaseActivity<WXEntryActivity> implements IWXAPIEventHandler {
    private SapiWebView agw;
    private FrameLayout agy;
    private IWXAPI cVq;
    private boolean cVr;
    private Intent cVs;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.layout_sapi_webview_login);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.sapi_login_navi);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getResources().getString(i.C0057i.login));
        this.agy = (FrameLayout) findViewById(i.f.webview_container);
        bd.ai(getApplicationContext());
        this.agw = new SapiWebView(getPageContext().getPageActivity());
        this.agy.removeAllViews();
        this.agy.addView(this.agw);
        com.baidu.tbadk.core.a.d.a(getPageContext().getPageActivity(), this.agw);
        this.agw.setOnBackCallback(new a(this));
        this.agw.setOnFinishCallback(new b(this));
        this.agw.setWeixinHandler(new c(this));
        this.agw.setAuthorizationListener(new d(this));
        this.cVq = WXAPIFactory.createWXAPI(getPageContext().getPageActivity(), SapiAccountManager.getInstance().getSapiConfiguration().wxAppID, false);
        this.cVs = getIntent();
        if (this.cVs != null) {
            this.cVq.handleIntent(getIntent(), this);
        }
        if (!this.cVr) {
            this.agw.loadWeixinSSOLogin();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.cVs = intent;
        if (this.cVs != null) {
            this.cVq.handleIntent(intent, this);
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
        if (this.cVs != null) {
            f.avs().Z(this.cVs);
        }
        closeActivity();
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (baseResp != null) {
            if (1 == baseResp.getType()) {
                this.cVr = true;
                if (baseResp.errCode == 0) {
                    if (baseResp instanceof SendAuth.Resp) {
                        String str = ((SendAuth.Resp) baseResp).state;
                        String str2 = ((SendAuth.Resp) baseResp).code;
                        if (this.agw != null) {
                            this.agw.weixinSSOLogin(str2, str);
                            return;
                        }
                        return;
                    }
                    return;
                }
                setResult(230014);
                closeActivity();
            } else if (2 == baseResp.getType()) {
                this.cVr = true;
                closeActivity();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.agy != null) {
            this.agy.removeAllViews();
        }
        if (this.agw != null) {
            this.agw.setAuthorizationListener(null);
            this.agw.setSocialLoginHandler(null);
            this.agw.setWeixinHandler(null);
            this.agw.setOnBackCallback(null);
            this.agw.setOnFinishCallback(null);
            this.agw.getSettings().setBuiltInZoomControls(true);
            this.agw.setVisibility(8);
            new Timer().schedule(new e(this), ViewConfiguration.getZoomControlsTimeout());
        }
    }
}
