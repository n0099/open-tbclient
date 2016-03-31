package com.baidu.tieba.supplementSign;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class SupplementSignActivity extends TbWebViewActivity {
    private int forumId;
    private final String emF = "signSuccess";
    private final String INTERFACE_NAME = "SupplementSignInterface";
    private int emG = 0;
    private int emH = 0;
    private int emI = 0;
    private CustomMessageListener emJ = new a(this, CmdConfigCustom.CMD_RESPONSE_MEM);

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.forumId = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
        }
        addJsPromptInterface(new b(this));
        this.mView.aa(false);
        MessageManager.getInstance().registerListener(this.emJ);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mView.pW();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(SupplementSignActivityConfig.FORUM_ID, this.forumId);
        intent.putExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, this.emG);
        intent.putExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, this.emH);
        intent.putExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, this.emI);
        super.finish(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mWebView != null) {
            this.mWebView.destroy();
            this.mWebView = null;
        }
        MessageManager.getInstance().unRegisterListener(this.emJ);
    }
}
