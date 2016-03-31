package com.baidu.tieba.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.h.h;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
    private SapiWebView cZw;
    private FrameLayout cZy;
    private IWXAPI eNR;
    private boolean eNS;
    private Intent eNT;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.layout_sapi_webview_login);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.sapi_login_navi);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getResources().getString(t.j.login));
        this.cZy = (FrameLayout) findViewById(t.g.webview_container);
        this.cZw = new SapiWebView(getPageContext().getPageActivity());
        this.cZy.removeAllViews();
        this.cZy.addView(this.cZw);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.cZw);
        this.cZw.setOnBackCallback(new a(this));
        this.cZw.setOnFinishCallback(new b(this));
        this.cZw.setWeixinHandler(new c(this));
        this.cZw.setAuthorizationListener(new d(this));
        this.eNR = WXAPIFactory.createWXAPI(getPageContext().getPageActivity(), SapiAccountManager.getInstance().getSapiConfiguration().wxAppID, false);
        this.eNT = getIntent();
        if (this.eNT != null) {
            this.eNR.handleIntent(getIntent(), this);
        }
        if (!this.eNS) {
            this.cZw.loadWeixinSSOLogin();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.eNT = intent;
        if (this.eNT != null) {
            this.eNR.handleIntent(intent, this);
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
        if (this.eNT != null) {
            f.bbP().D(this.eNT);
        }
        closeActivity();
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        String str;
        if (baseResp != null) {
            if (1 == baseResp.getType()) {
                this.eNS = true;
                if (baseResp.errCode == 0) {
                    if (baseResp instanceof SendAuth.Resp) {
                        String str2 = ((SendAuth.Resp) baseResp).state;
                        String str3 = ((SendAuth.Resp) baseResp).code;
                        if (this.cZw != null) {
                            this.cZw.weixinSSOLogin(str3, str2);
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
                    BdToast.b(getActivity(), getResources().getString(t.j.share_alert_success), t.f.icon_toast_game_ok).ux();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_WX_SHARE_SUCCESS, true));
                } else if (i != -2) {
                    if (i == 123456) {
                        BdToast.b(getActivity(), getResources().getString(t.j.weixin_not_installed_yet), t.f.icon_toast_game_error).ux();
                    } else {
                        com.baidu.tbadk.core.log.b.a("socail_share", -1L, 0, "wx_share_fail", i, "", "share_fail_exception", String.valueOf(str) + "&" + com.baidu.tbadk.coreExtra.share.d.amR);
                        BdToast.b(getActivity(), getResources().getString(t.j.share_alert_fail), t.f.icon_toast_game_error).ux();
                    }
                }
                this.eNS = true;
                closeActivity();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cZy != null) {
            this.cZy.removeAllViews();
        }
        if (this.cZw != null) {
            this.cZw.setAuthorizationListener(null);
            this.cZw.setSocialLoginHandler(null);
            this.cZw.setWeixinHandler(null);
            this.cZw.setOnBackCallback(null);
            this.cZw.setOnFinishCallback(null);
            this.cZw.getSettings().setBuiltInZoomControls(true);
            this.cZw.setVisibility(8);
            h.hx().postDelayed(new e(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
        super.onDestroy();
    }
}
