package com.baidu.tieba.shareSDK;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* loaded from: classes.dex */
public class ShareToTBActivity extends BaseActivity {
    private String bJl;
    private String bJm;
    private String bJn;
    private String bJo;
    private String bJp;
    private String bJq;
    private String mShareContent;
    private String mShareTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        abX();
        abY();
        com.baidu.tbadk.core.j.l(this, "share4sdk");
    }

    private void abX() {
        Bundle extras = getIntent().getExtras();
        this.bJl = extras.getString("ShareUrl");
        this.bJm = extras.getString("ShareImageUrl");
        this.mShareTitle = extras.getString("ShareTitle");
        this.mShareContent = extras.getString("ShareContent");
        this.bJn = extras.getString("mShareTargetBaName");
        this.bJo = extras.getString("appName");
        this.bJp = extras.getString("appKey");
        this.bJq = extras.getString("appSign");
    }

    private void abY() {
        if (TbadkApplication.isLogin()) {
            abZ();
            return;
        }
        TbadkApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        LoginActivity.a((Activity) this, (String) null, true, 11003);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        overridePendingTransition(-1, -1);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.bJn = intent.getStringExtra("bar_name");
                    aca();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkApplication.isSDKLogin = false;
            if (i2 == -1) {
                abZ();
            } else {
                finish();
            }
        }
    }

    private void abZ() {
        if (TextUtils.isEmpty(this.bJn)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this, TbadkApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            aca();
        }
    }

    private void aca() {
        finish();
        if (this.bJl == null) {
            this.bJl = "";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteShareActivityConfig(this, this.bJn, this.mShareTitle, this.mShareContent, this.bJm, this.bJl, this.bJp, this.bJo, this.bJq)));
    }
}
