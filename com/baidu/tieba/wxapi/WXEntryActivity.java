package com.baidu.tieba.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
/* loaded from: classes.dex */
public class WXEntryActivity extends BaseActivity<WXEntryActivity> implements IWXAPIEventHandler {
    private SapiWebView eCu;
    private FrameLayout eCw;
    private IWXAPI gKc;
    private boolean gKd;
    private Intent gKe;
    private Runnable mFinishRunnable = new Runnable() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.1
        @Override // java.lang.Runnable
        public void run() {
            WXEntryActivity.this.closeActivity();
        }
    };
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.layout_sapi_webview_login);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.sapi_login_navi);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getResources().getString(d.l.login));
        this.eCw = (FrameLayout) findViewById(d.h.webview_container);
        this.eCu = new SapiWebView(getPageContext().getPageActivity());
        this.eCw.removeAllViews();
        this.eCw.addView(this.eCu);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.eCu);
        this.eCu.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                WXEntryActivity.this.closeActivity();
            }
        });
        this.eCu.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                e.ga().postDelayed(WXEntryActivity.this.mFinishRunnable, 500L);
            }
        });
        this.eCu.setWeixinHandler(new SapiWebView.WeixinHandler() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.4
            @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
            public void handleNotInstall() {
                WXEntryActivity.this.showToast(d.l.wxentry_not_install);
                WXEntryActivity.this.closeActivity();
            }

            @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
            public void handleServerError(String str) {
                WXEntryActivity.this.showToast(WXEntryActivity.this.getResources().getString(d.l.error_system, str));
                WXEntryActivity.this.closeActivity();
            }
        });
        this.eCu.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.5
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess() {
                bk bkVar = new bk();
                bkVar.Zb = 0;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOGIN_WEINXIN, bkVar));
                WXEntryActivity.this.closeActivity();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
                bk bkVar = new bk();
                bkVar.Zb = 2;
                bkVar.errorCode = i;
                bkVar.errorMsg = str;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOGIN_WEINXIN, bkVar));
                WXEntryActivity.this.closeActivity();
            }
        });
        this.gKc = WXAPIFactory.createWXAPI(getPageContext().getPageActivity(), SapiAccountManager.getInstance().getSapiConfiguration().wxAppID, false);
        this.gKe = getIntent();
        if (this.gKe != null) {
            this.gKc.handleIntent(getIntent(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.gKd) {
            this.eCu.loadWeixinSSOLogin();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.gKe = intent;
        if (this.gKe != null) {
            this.gKc.handleIntent(intent, this);
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
        if (this.gKe != null) {
            a.bBr().am(this.gKe);
        }
        closeActivity();
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (baseResp != null) {
            if (1 == baseResp.getType()) {
                this.gKd = true;
                if (baseResp.errCode == 0) {
                    if (baseResp instanceof SendAuth.Resp) {
                        String str = ((SendAuth.Resp) baseResp).state;
                        String str2 = ((SendAuth.Resp) baseResp).code;
                        if (this.eCu != null) {
                            this.eCu.weixinSSOLogin(str2, str);
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
                String str3 = "";
                if (resp.errStr != null) {
                    str3 = resp.errStr;
                }
                Intent intent = new Intent(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
                if (i == 0) {
                    BdToast.b(getActivity(), getResources().getString(d.l.share_alert_success), d.g.icon_toast_game_ok).tA();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_WX_SHARE_SUCCESS, true));
                    intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_SUCCESS);
                } else if (i == -2) {
                    intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_CANCLE);
                } else if (i == 123456) {
                    BdToast.b(getActivity(), getResources().getString(d.l.weixin_not_installed_yet), d.g.icon_toast_game_error).tA();
                } else {
                    com.baidu.tbadk.core.d.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str3 + "&" + com.baidu.tbadk.coreExtra.share.d.auX);
                    BdToast.b(getActivity(), getResources().getString(d.l.share_alert_fail), d.g.icon_toast_game_error).tA();
                    intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_FAIL);
                }
                this.gKd = true;
                BdBaseApplication.getInst().sendBroadcast(intent);
                closeActivity();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eCw != null) {
            this.eCw.removeAllViews();
        }
        if (this.eCu != null) {
            this.eCu.setAuthorizationListener(null);
            this.eCu.setSocialLoginHandler(null);
            this.eCu.setWeixinHandler(null);
            this.eCu.setOnBackCallback(null);
            this.eCu.setOnFinishCallback(null);
            this.eCu.getSettings().setBuiltInZoomControls(true);
            this.eCu.setVisibility(8);
            e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (WXEntryActivity.this.eCu != null) {
                            WXEntryActivity.this.eCu.destroy();
                            WXEntryActivity.this.eCu = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
            e.ga().removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }
}
