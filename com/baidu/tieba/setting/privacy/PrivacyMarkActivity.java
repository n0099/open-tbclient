package com.baidu.tieba.setting.privacy;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
/* loaded from: classes7.dex */
public class PrivacyMarkActivity extends BaseActivity<PrivacyMarkActivity> {
    private a nlG;
    private HttpMessageListener nlH = new HttpMessageListener(1001506, true) { // from class: com.baidu.tieba.setting.privacy.PrivacyMarkActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    if (PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE.equals(operation)) {
                        PrivacyMarkActivity.this.nlG.dJg();
                    } else if (PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE.equals(operation)) {
                        PrivacyMarkActivity.this.nlG.dJh();
                    }
                    if (httpResponsedMessage.getError() == -1 || !j.isNetWorkAvailable()) {
                        PrivacyMarkActivity.this.showToast(R.string.neterror);
                        return;
                    } else {
                        PrivacyMarkActivity.this.showToast(R.string.privacy_setting_failed);
                        return;
                    }
                }
                b.brR().putInt(operation + TbadkCoreApplication.getCurrentAccount(), type);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921499, null));
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i = 1;
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, 0);
        int intExtra2 = getIntent().getIntExtra(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, 0);
        if (intExtra != 1 && intExtra != 3) {
            intExtra = 1;
        }
        if (intExtra2 == 1 || intExtra2 == 3) {
            i = intExtra2;
        }
        this.nlG = new a(getPageContext(), i | (intExtra << 2));
        setContentView(this.nlG.getView());
        registerListener(this.nlH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.nlG.onChangeSkinType();
    }
}
