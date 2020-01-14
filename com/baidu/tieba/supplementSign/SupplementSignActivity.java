package com.baidu.tieba.supplementSign;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JsPromptResult;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tieba.tbadkCore.e.b;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SupplementSignActivity extends TbWebViewActivity {
    private int forumId;
    private final String kcW = "signSuccess";
    private final String INTERFACE_NAME = "SupplementSignInterface";
    private int kcX = 0;
    private int kcY = 0;
    private int kcZ = 0;
    private CustomMessageListener kda = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.supplementSign.SupplementSignActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SupplementSignActivity.this.mWebView.loadUrl("javascript:TbJsBridge.refreshRemainDay()");
            }
        }
    };
    private b kdb = new b() { // from class: com.baidu.tieba.supplementSign.SupplementSignActivity.2
        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("SupplementSignInterface".equalsIgnoreCase(str) && "signSuccess".equalsIgnoreCase(str2)) {
                if (!StringUtils.isNull(str3)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        SupplementSignActivity.this.kcX = jSONObject.optInt(SchemeCollecter.CLASSIFY_ALL);
                        SupplementSignActivity.this.kcY += jSONObject.optInt("signed", 0);
                        SupplementSignActivity.this.kcZ = jSONObject.optInt("bonus", 0) + SupplementSignActivity.this.kcZ;
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
        addJsPromptInterface(this.kdb);
        this.mView.fj(false);
        registerListener(this.kda);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mView.axm();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(SupplementSignActivityConfig.FORUM_ID, this.forumId);
        intent.putExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, this.kcX);
        intent.putExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, this.kcY);
        intent.putExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, this.kcZ);
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
