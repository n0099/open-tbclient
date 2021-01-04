package com.baidu.tieba.supplementSign;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JsPromptResult;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tieba.tbadkCore.e.b;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class SupplementSignActivity extends TbWebViewActivity {
    private int forumId;
    private final String noU = "signSuccess";
    private final String INTERFACE_NAME = "SupplementSignInterface";
    private int noV = 0;
    private int noW = 0;
    private int noX = 0;
    private CustomMessageListener noY = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.supplementSign.SupplementSignActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SupplementSignActivity.this.mWebView.loadUrl("javascript:TbJsBridge.refreshRemainDay()");
            }
        }
    };
    private b noZ = new b() { // from class: com.baidu.tieba.supplementSign.SupplementSignActivity.2
        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("SupplementSignInterface".equalsIgnoreCase(str) && "signSuccess".equalsIgnoreCase(str2)) {
                if (!StringUtils.isNull(str3)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        SupplementSignActivity.this.noV = jSONObject.optInt("all");
                        SupplementSignActivity.this.noW += jSONObject.optInt("signed", 0);
                        SupplementSignActivity.this.noX = jSONObject.optInt("bonus", 0) + SupplementSignActivity.this.noX;
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
                jsPromptResult.confirm();
                return true;
            }
            return false;
        }
    };

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.forumId = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
        }
        addJsPromptInterface(this.noZ);
        this.mView.jf(false);
        registerListener(this.noY);
    }

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mView.boc();
    }

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(SupplementSignActivityConfig.FORUM_ID, this.forumId);
        intent.putExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, this.noV);
        intent.putExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, this.noW);
        intent.putExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, this.noX);
        super.finish(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mWebView != null) {
            this.mWebView.destroy();
            this.mWebView = null;
        }
    }
}
