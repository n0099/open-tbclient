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
import com.baidu.tbadk.core.data.bi;
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
    private SapiWebView eAJ;
    private FrameLayout eAM;
    private IWXAPI gII;
    private boolean gIJ;
    private Intent gIK;
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
        this.eAM = (FrameLayout) findViewById(d.h.webview_container);
        this.eAJ = new SapiWebView(getPageContext().getPageActivity());
        this.eAM.removeAllViews();
        this.eAM.addView(this.eAJ);
        com.baidu.tbadk.core.a.d.c(getPageContext().getPageActivity(), this.eAJ);
        this.eAJ.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                WXEntryActivity.this.closeActivity();
            }
        });
        this.eAJ.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                e.fQ().postDelayed(WXEntryActivity.this.mFinishRunnable, 500L);
            }
        });
        this.eAJ.setWeixinHandler(new SapiWebView.WeixinHandler() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.4
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
        this.eAJ.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.5
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess() {
                bi biVar = new bi();
                biVar.Yf = 0;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOGIN_WEINXIN, biVar));
                WXEntryActivity.this.closeActivity();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
                bi biVar = new bi();
                biVar.Yf = 2;
                biVar.errorCode = i;
                biVar.errorMsg = str;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOGIN_WEINXIN, biVar));
                WXEntryActivity.this.closeActivity();
            }
        });
        this.gII = WXAPIFactory.createWXAPI(getPageContext().getPageActivity(), SapiAccountManager.getInstance().getSapiConfiguration().wxAppID, false);
        this.gIK = getIntent();
        if (this.gIK != null) {
            this.gII.handleIntent(getIntent(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.gIJ) {
            this.eAJ.loadWeixinSSOLogin();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.gIK = intent;
        if (this.gIK != null) {
            this.gII.handleIntent(intent, this);
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
        if (this.gIK != null && this.gII != null) {
            this.gII.handleIntent(this.gIK, this);
        }
        closeActivity();
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (baseResp != null) {
            if (1 == baseResp.getType()) {
                this.gIJ = true;
                if (baseResp.errCode == 0) {
                    if (baseResp instanceof SendAuth.Resp) {
                        String str = ((SendAuth.Resp) baseResp).state;
                        String str2 = ((SendAuth.Resp) baseResp).code;
                        if (this.eAJ != null) {
                            this.eAJ.weixinSSOLogin(str2, str);
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
                this.gIJ = true;
                BdBaseApplication.getInst().sendBroadcast(intent);
                closeActivity();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eAM != null) {
            this.eAM.removeAllViews();
        }
        if (this.eAJ != null) {
            this.eAJ.setAuthorizationListener(null);
            this.eAJ.setSocialLoginHandler(null);
            this.eAJ.setWeixinHandler(null);
            this.eAJ.setOnBackCallback(null);
            this.eAJ.setOnFinishCallback(null);
            this.eAJ.getSettings().setBuiltInZoomControls(true);
            this.eAJ.setVisibility(8);
            e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (WXEntryActivity.this.eAJ != null) {
                            WXEntryActivity.this.eAJ.destroy();
                            WXEntryActivity.this.eAJ = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
            e.fQ().removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }
}
