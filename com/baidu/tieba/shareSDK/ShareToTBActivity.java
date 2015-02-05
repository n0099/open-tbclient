package com.baidu.tieba.shareSDK;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.util.bh;
/* loaded from: classes.dex */
public class ShareToTBActivity extends BaseActivity<ShareToTBActivity> {
    private String bPf;
    private String bPg;
    private String bPh;
    private String bPi;
    private String bPj;
    private PackageManager bPk;
    private PackageInfo bPl;
    private final CustomMessageListener bPm = new d(this, 2001256);
    private String mAppName;
    private String mShareContent;
    private String mShareTitle;
    private String packageName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bPk = getPageContext().getPageActivity().getPackageManager();
        acR();
        acS();
        com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "share4sdk");
        registerListener(this.bPm);
    }

    private void acR() {
        this.packageName = getCallingPackage();
        if (this.bPk != null && this.packageName != null) {
            try {
                this.bPl = this.bPk.getPackageInfo(this.packageName, 64);
                if (this.bPl != null) {
                    if (this.bPl.applicationInfo != null && this.bPl.applicationInfo.loadLabel(this.bPk) != null) {
                        this.mAppName = this.bPl.applicationInfo.loadLabel(this.bPk).toString();
                    }
                    if (this.bPl.signatures != null && this.bPl.signatures.length > 0 && this.bPl.signatures[0] != null) {
                        this.bPj = bh.w(this.bPl.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.bPj = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.bPf = extras.getString("ShareUrl");
            this.bPg = extras.getString("ShareImageUrl");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.bPh = extras.getString("mShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.bPj)) {
                this.bPj = extras.getString("appSign");
            }
            this.bPi = extras.getString("appKey");
        } catch (Exception e2) {
        }
    }

    private void acS() {
        if (TbadkApplication.isLogin()) {
            acT();
            return;
        }
        TbadkApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
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
                    this.bPh = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    acU();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkApplication.isSDKLogin = false;
            if (i2 == -1) {
                acT();
            } else {
                finish();
            }
        }
    }

    private void acT() {
        if (TextUtils.isEmpty(this.bPh)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            acU();
        }
    }

    private void acU() {
        if (this.bPf == null) {
            this.bPf = "";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteShareActivityConfig(getPageContext().getPageActivity(), this.bPh, this.mShareTitle, this.mShareContent, this.bPg, this.bPf, this.bPi, this.mAppName, this.bPj)));
    }
}
