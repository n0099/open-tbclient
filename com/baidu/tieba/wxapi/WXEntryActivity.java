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
import com.baidu.tbadk.core.data.bc;
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
    private FrameLayout dRu;
    private SapiWebView fDR;
    private IWXAPI hNK;
    private boolean hNL;
    private Intent hNM;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(2921332, (Class) null);
        setContentView(d.h.layout_sapi_webview_login);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.sapi_login_navi);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getResources().getString(d.j.login));
        this.dRu = (FrameLayout) findViewById(d.g.webview_container);
        this.fDR = new SapiWebView(getPageContext().getPageActivity());
        this.dRu.removeAllViews();
        this.dRu.addView(this.fDR);
        com.baidu.tbadk.core.a.d.addCustomView(getPageContext().getPageActivity(), this.fDR);
        this.fDR.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                WXEntryActivity.this.closeActivity();
            }
        });
        this.fDR.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                WXEntryActivity.this.closeActivity();
            }
        });
        this.fDR.setWeixinHandler(new SapiWebView.WeixinHandler() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.3
            @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
            public void handleNotInstall() {
                WXEntryActivity.this.showToast(d.j.wxentry_not_install);
                WXEntryActivity.this.closeActivity();
            }

            @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
            public void handleServerError(String str) {
                if (TextUtils.isEmpty(str)) {
                    str = WXEntryActivity.this.getString(d.j.error_system);
                }
                WXEntryActivity.this.showToast(str);
                WXEntryActivity.this.closeActivity();
            }
        });
        this.fDR.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.4
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess() {
                bc bcVar = new bc();
                bcVar.aOs = 0;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001338, bcVar));
                WXEntryActivity.this.closeActivity();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
                bc bcVar = new bc();
                bcVar.aOs = 2;
                bcVar.errorCode = i;
                bcVar.errorMsg = str;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001338, bcVar));
                WXEntryActivity.this.closeActivity();
            }
        });
        this.hNK = WXAPIFactory.createWXAPI(getPageContext().getPageActivity(), SapiAccountManager.getInstance().getSapiConfiguration().wxAppID, false);
        this.hNM = getIntent();
        if (this.hNM != null) {
            this.hNK.handleIntent(getIntent(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.hNL) {
            this.fDR.loadWeixinSSOLogin();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.hNM = intent;
        if (this.hNM != null) {
            this.hNK.handleIntent(intent, this);
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
        if (this.hNM != null && this.hNK != null) {
            this.hNK.handleIntent(this.hNM, this);
        }
        closeActivity();
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (baseResp != null) {
            if (1 == baseResp.getType()) {
                this.hNL = true;
                if (baseResp.errCode == 0) {
                    if (baseResp instanceof SendAuth.Resp) {
                        String str = ((SendAuth.Resp) baseResp).state;
                        String str2 = ((SendAuth.Resp) baseResp).code;
                        if (this.fDR != null) {
                            this.fDR.weixinSSOLogin(str2, str);
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
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016450, true));
                    intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_SUCCESS);
                } else if (i == -2) {
                    intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_CANCLE);
                } else if (i == 123456) {
                    intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_FAIL);
                } else {
                    intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_FAIL);
                }
                this.hNL = true;
                BdBaseApplication.getInst().sendBroadcast(intent);
                closeActivity();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dRu != null) {
            this.dRu.removeAllViews();
        }
        if (this.fDR != null) {
            this.fDR.setAuthorizationListener(null);
            this.fDR.setSocialLoginHandler(null);
            this.fDR.setWeixinHandler(null);
            this.fDR.setOnBackCallback(null);
            this.fDR.setOnFinishCallback(null);
            this.fDR.getSettings().setBuiltInZoomControls(true);
            this.fDR.setVisibility(8);
            e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.wxapi.WXEntryActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (WXEntryActivity.this.fDR != null) {
                            WXEntryActivity.this.fDR.destroy();
                            WXEntryActivity.this.fDR = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
            e.ns().removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }
}
