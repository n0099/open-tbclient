package com.baidu.tieba.setting.more.youngster;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterVerifyActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.setting.more.youngster.model.YoungsterVerifyModel;
/* loaded from: classes8.dex */
public class YoungsterVerifyActivity extends TbWebViewActivity {
    private int from;
    private YoungsterVerifyModel niM;

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mView != null) {
            this.mView.bkB();
        }
        if (this.mWebView != null) {
            this.mWebView.setWebViewClient(new a());
        }
        TbSingleton.getInstance().setCanWebViewActivityShowProgress(false);
        this.niM = new YoungsterVerifyModel(getPageContext(), new YoungsterVerifyModel.a() { // from class: com.baidu.tieba.setting.more.youngster.YoungsterVerifyActivity.1
            @Override // com.baidu.tieba.setting.more.youngster.model.YoungsterVerifyModel.a
            public void onSuccess() {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(YoungsterVerifyActivity.this.getPageContext().getPageActivity());
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(4);
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(YoungsterVerifyActivity.this.from);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
                YoungsterVerifyActivity.this.getPageContext().getPageActivity().finish();
            }

            @Override // com.baidu.tieba.setting.more.youngster.model.YoungsterVerifyModel.a
            public void b(ErrorData errorData) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921489));
                YoungsterVerifyActivity.this.getPageContext().getPageActivity().finish();
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            this.from = intent.getIntExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_FROM, 0);
        }
    }

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mView != null) {
            this.mView.bkB();
        }
    }

    /* loaded from: classes8.dex */
    protected class a extends TbWebViewActivity.b {
        protected a() {
            super();
        }

        @Override // com.baidu.tbadk.browser.TbWebViewActivity.b, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TbSingleton.getInstance().setCanWebViewActivityShowProgress(true);
        }

        @Override // com.baidu.tbadk.browser.TbWebViewActivity.b, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.baidu.tbadk.browser.TbWebViewActivity.b, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (StringUtils.isNull(str) || !str.contains(TbConfig.URL_YOUNGSTER_VERIFY_AUTHID)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            YoungsterVerifyActivity.this.niM.Sn(UrlUtil.getUrlField(str, YoungsterVerifyActivityConfig.PARAMA_AUTH_ID));
            return true;
        }
    }
}
