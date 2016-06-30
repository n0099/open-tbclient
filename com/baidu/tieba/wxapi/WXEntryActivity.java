package com.baidu.tieba.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.u;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
/* loaded from: classes.dex */
public class WXEntryActivity extends BaseActivity<WXEntryActivity> implements IWXAPIEventHandler {
    private FrameLayout dIA;
    private SapiWebView dIy;
    private IWXAPI fKj;
    private boolean fKk;
    private Intent fKl;
    private Runnable fKm = new a(this);
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.layout_sapi_webview_login);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.sapi_login_navi);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getResources().getString(u.j.login));
        this.dIA = (FrameLayout) findViewById(u.g.webview_container);
        this.dIy = new SapiWebView(getPageContext().getPageActivity());
        this.dIA.removeAllViews();
        this.dIA.addView(this.dIy);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.dIy);
        this.dIy.setOnBackCallback(new b(this));
        this.dIy.setOnFinishCallback(new c(this));
        this.dIy.setWeixinHandler(new d(this));
        this.dIy.setAuthorizationListener(new e(this));
        this.fKj = WXAPIFactory.createWXAPI(getPageContext().getPageActivity(), SapiAccountManager.getInstance().getSapiConfiguration().wxAppID, false);
        this.fKl = getIntent();
        if (this.fKl != null) {
            this.fKj.handleIntent(getIntent(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.fKk) {
            this.dIy.loadWeixinSSOLogin();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fKl = intent;
        if (this.fKl != null) {
            this.fKj.handleIntent(intent, this);
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
        if (this.fKl != null) {
            g.bmJ().J(this.fKl);
        }
        closeActivity();
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        String str;
        if (baseResp != null) {
            if (1 == baseResp.getType()) {
                this.fKk = true;
                if (baseResp.errCode == 0) {
                    if (baseResp instanceof SendAuth.Resp) {
                        String str2 = ((SendAuth.Resp) baseResp).state;
                        String str3 = ((SendAuth.Resp) baseResp).code;
                        if (this.dIy != null) {
                            this.dIy.weixinSSOLogin(str3, str2);
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
                Intent intent = new Intent(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
                if (i == 0) {
                    BdToast.b(getActivity(), getResources().getString(u.j.share_alert_success), u.f.icon_toast_game_ok).sb();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_WX_SHARE_SUCCESS, true));
                    intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_SUCCESS);
                } else if (i == -2) {
                    intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_CANCLE);
                } else if (i == 123456) {
                    BdToast.b(getActivity(), getResources().getString(u.j.weixin_not_installed_yet), u.f.icon_toast_game_error).sb();
                } else {
                    com.baidu.tbadk.core.log.b.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", String.valueOf(str) + "&" + com.baidu.tbadk.coreExtra.share.d.ajk);
                    BdToast.b(getActivity(), getResources().getString(u.j.share_alert_fail), u.f.icon_toast_game_error).sb();
                    intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_FAIL);
                }
                this.fKk = true;
                BdBaseApplication.getInst().sendBroadcast(intent);
                closeActivity();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dIA != null) {
            this.dIA.removeAllViews();
        }
        if (this.dIy != null) {
            this.dIy.setAuthorizationListener(null);
            this.dIy.setSocialLoginHandler(null);
            this.dIy.setWeixinHandler(null);
            this.dIy.setOnBackCallback(null);
            this.dIy.setOnFinishCallback(null);
            this.dIy.getSettings().setBuiltInZoomControls(true);
            this.dIy.setVisibility(8);
            com.baidu.adp.lib.h.h.dM().postDelayed(new f(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
            com.baidu.adp.lib.h.h.dM().removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }
}
