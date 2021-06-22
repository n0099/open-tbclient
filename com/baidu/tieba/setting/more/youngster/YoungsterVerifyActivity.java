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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterVerifyActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tieba.setting.more.youngster.model.YoungsterVerifyModel;
import d.a.n0.l.e;
/* loaded from: classes5.dex */
public class YoungsterVerifyActivity extends TbWebViewActivity {
    public int from;
    public YoungsterVerifyModel youngsterVerifyModel;

    /* loaded from: classes5.dex */
    public class a implements YoungsterVerifyModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.setting.more.youngster.model.YoungsterVerifyModel.b
        public void onError(ErrorData errorData) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921489));
            YoungsterVerifyActivity.this.getPageContext().getPageActivity().finish();
        }

        @Override // com.baidu.tieba.setting.more.youngster.model.YoungsterVerifyModel.b
        public void onSuccess() {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(YoungsterVerifyActivity.this.getPageContext().getPageActivity());
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(4);
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(YoungsterVerifyActivity.this.from);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
            YoungsterVerifyActivity.this.getPageContext().getPageActivity().finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends TbWebViewActivity.t {
        public b() {
            super();
        }

        @Override // com.baidu.tbadk.browser.TbWebViewActivity.t, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TbSingleton.getInstance().setCanWebViewActivityShowProgress(true);
        }

        @Override // com.baidu.tbadk.browser.TbWebViewActivity.t, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.baidu.tbadk.browser.TbWebViewActivity.t, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!StringUtils.isNull(str) && str.contains(TbConfig.URL_YOUNGSTER_VERIFY_AUTHID)) {
                YoungsterVerifyActivity.this.youngsterVerifyModel.B(UrlUtil.getUrlField(str, YoungsterVerifyActivityConfig.PARAMA_AUTH_ID));
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        e eVar = this.mView;
        if (eVar != null) {
            eVar.E();
        }
    }

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e eVar = this.mView;
        if (eVar != null) {
            eVar.E();
        }
        BridgeWebView bridgeWebView = this.mWebView;
        if (bridgeWebView != null) {
            bridgeWebView.setWebViewClient(new b());
        }
        TbSingleton.getInstance().setCanWebViewActivityShowProgress(false);
        this.youngsterVerifyModel = new YoungsterVerifyModel(getPageContext(), new a());
        Intent intent = getIntent();
        if (intent != null) {
            this.from = intent.getIntExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_FROM, 0);
        }
    }
}
