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
    private String bIX;
    private String bIY;
    private String bIZ;
    private String bJa;
    private String bJb;
    private String bJc;
    private String mShareContent;
    private String mShareTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        abU();
        abV();
        com.baidu.tbadk.core.i.l(this, "share4sdk");
    }

    private void abU() {
        Bundle extras = getIntent().getExtras();
        this.bIX = extras.getString("ShareUrl");
        this.bIY = extras.getString("ShareImageUrl");
        this.mShareTitle = extras.getString("ShareTitle");
        this.mShareContent = extras.getString("ShareContent");
        this.bIZ = extras.getString("mShareTargetBaName");
        this.bJa = extras.getString("appName");
        this.bJb = extras.getString("appKey");
        this.bJc = extras.getString("appSign");
    }

    private void abV() {
        if (TbadkApplication.isLogin()) {
            abW();
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
                    this.bIZ = intent.getStringExtra("bar_name");
                    abX();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkApplication.isSDKLogin = false;
            if (i2 == -1) {
                abW();
            } else {
                finish();
            }
        }
    }

    private void abW() {
        if (TextUtils.isEmpty(this.bIZ)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this, TbadkApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            abX();
        }
    }

    private void abX() {
        finish();
        if (this.bIX == null) {
            this.bIX = "";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteShareActivityConfig(this, this.bIZ, this.mShareTitle, this.mShareContent, this.bIY, this.bIX, this.bJb, this.bJa, this.bJc)));
    }
}
