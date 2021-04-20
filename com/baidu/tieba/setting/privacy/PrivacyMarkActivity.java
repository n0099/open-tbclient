package com.baidu.tieba.setting.privacy;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import d.b.c.e.p.j;
import d.b.h0.r.d0.b;
/* loaded from: classes4.dex */
public class PrivacyMarkActivity extends BaseActivity<PrivacyMarkActivity> {
    public d.b.i0.v2.e.a privacyMarkView;
    public HttpMessageListener setPrivateHttpListener = new a(CmdConfigHttp.SET_PRIVATE_CMD, true);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i, boolean z) {
            super(i, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || !(httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                return;
            }
            PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
            String operation = privacySettingMessage.getOperation();
            int type = privacySettingMessage.getType();
            if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError()) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                b j = b.j();
                j.v(operation + currentAccount, type);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921499, null));
                return;
            }
            if (PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE.equals(operation)) {
                PrivacyMarkActivity.this.privacyMarkView.m();
            } else if (PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE.equals(operation)) {
                PrivacyMarkActivity.this.privacyMarkView.n();
            }
            if (httpResponsedMessage.getError() != -1 && j.z()) {
                PrivacyMarkActivity.this.showToast(R.string.privacy_setting_failed);
            } else {
                PrivacyMarkActivity.this.showToast(R.string.neterror);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.privacyMarkView.l();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, 0);
        int intExtra2 = getIntent().getIntExtra(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, 0);
        if (intExtra != 1 && intExtra != 3) {
            intExtra = 1;
        }
        if (intExtra2 != 1 && intExtra2 != 3) {
            intExtra2 = 1;
        }
        d.b.i0.v2.e.a aVar = new d.b.i0.v2.e.a(getPageContext(), (intExtra << 2) | intExtra2);
        this.privacyMarkView = aVar;
        setContentView(aVar.i());
        registerListener(this.setPrivateHttpListener);
    }
}
