package com.baidu.tieba.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.data.bg;
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
    private SapiWebView euE;
    private FrameLayout euH;
    private IWXAPI gOj;
    private boolean gOk;
    private Intent gOl;
    private Runnable gOm = new Runnable() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.1
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
        this.euH = (FrameLayout) findViewById(d.h.webview_container);
        this.euE = new SapiWebView(getPageContext().getPageActivity());
        this.euH.removeAllViews();
        this.euH.addView(this.euE);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.euE);
        this.euE.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                WXEntryActivity.this.closeActivity();
            }
        });
        this.euE.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                e.fP().postDelayed(WXEntryActivity.this.gOm, 500L);
            }
        });
        this.euE.setWeixinHandler(new SapiWebView.WeixinHandler() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.4
            @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
            public void handleNotInstall() {
                WXEntryActivity.this.showToast(d.l.wxentry_not_install);
                WXEntryActivity.this.closeActivity();
            }

            @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
            public void handleServerError(String str) {
                if (TextUtils.isEmpty(str)) {
                    str = WXEntryActivity.this.getString(d.l.error_system);
                }
                WXEntryActivity.this.showToast(str);
                WXEntryActivity.this.closeActivity();
            }
        });
        this.euE.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.5
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess() {
                bg bgVar = new bg();
                bgVar.XU = 0;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOGIN_WEINXIN, bgVar));
                WXEntryActivity.this.closeActivity();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
                bg bgVar = new bg();
                bgVar.XU = 2;
                bgVar.errorCode = i;
                bgVar.errorMsg = str;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOGIN_WEINXIN, bgVar));
                WXEntryActivity.this.closeActivity();
            }
        });
        this.gOj = WXAPIFactory.createWXAPI(getPageContext().getPageActivity(), SapiAccountManager.getInstance().getSapiConfiguration().wxAppID, false);
        this.gOl = getIntent();
        if (this.gOl != null) {
            this.gOj.handleIntent(getIntent(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.gOk) {
            this.euE.loadWeixinSSOLogin();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.gOl = intent;
        if (this.gOl != null) {
            this.gOj.handleIntent(intent, this);
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
        if (this.gOl != null && this.gOj != null) {
            this.gOj.handleIntent(this.gOl, this);
        }
        closeActivity();
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (baseResp != null) {
            if (1 == baseResp.getType()) {
                this.gOk = true;
                if (baseResp.errCode == 0) {
                    if (baseResp instanceof SendAuth.Resp) {
                        String str = ((SendAuth.Resp) baseResp).state;
                        String str2 = ((SendAuth.Resp) baseResp).code;
                        if (this.euE != null) {
                            this.euE.weixinSSOLogin(str2, str);
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
                intent.putExtra("weixin_result_errCode", i);
                intent.putExtra("weixin_result_errMsg", str3);
                if (i == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_WX_SHARE_SUCCESS, true));
                    intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_SUCCESS);
                } else if (i == -2) {
                    intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_CANCLE);
                } else if (i == 123456) {
                    intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_FAIL);
                } else {
                    intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_FAIL);
                }
                this.gOk = true;
                BdBaseApplication.getInst().sendBroadcast(intent);
                closeActivity();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.euH != null) {
            this.euH.removeAllViews();
        }
        if (this.euE != null) {
            this.euE.setAuthorizationListener(null);
            this.euE.setSocialLoginHandler(null);
            this.euE.setWeixinHandler(null);
            this.euE.setOnBackCallback(null);
            this.euE.setOnFinishCallback(null);
            this.euE.getSettings().setBuiltInZoomControls(true);
            this.euE.setVisibility(8);
            e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (WXEntryActivity.this.euE != null) {
                            WXEntryActivity.this.euE.destroy();
                            WXEntryActivity.this.euE = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
            e.fP().removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }
}
