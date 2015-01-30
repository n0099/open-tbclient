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
    private String bPg;
    private String bPh;
    private String bPi;
    private String bPj;
    private String bPk;
    private PackageManager bPl;
    private PackageInfo bPm;
    private final CustomMessageListener bPn = new d(this, 2001256);
    private String mAppName;
    private String mShareContent;
    private String mShareTitle;
    private String packageName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bPl = getPageContext().getPageActivity().getPackageManager();
        acW();
        acX();
        com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "share4sdk");
        registerListener(this.bPn);
    }

    private void acW() {
        this.packageName = getCallingPackage();
        if (this.bPl != null && this.packageName != null) {
            try {
                this.bPm = this.bPl.getPackageInfo(this.packageName, 64);
                if (this.bPm != null) {
                    if (this.bPm.applicationInfo != null && this.bPm.applicationInfo.loadLabel(this.bPl) != null) {
                        this.mAppName = this.bPm.applicationInfo.loadLabel(this.bPl).toString();
                    }
                    if (this.bPm.signatures != null && this.bPm.signatures.length > 0 && this.bPm.signatures[0] != null) {
                        this.bPk = bh.w(this.bPm.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.bPk = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.bPg = extras.getString("ShareUrl");
            this.bPh = extras.getString("ShareImageUrl");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.bPi = extras.getString("mShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.bPk)) {
                this.bPk = extras.getString("appSign");
            }
            this.bPj = extras.getString("appKey");
        } catch (Exception e2) {
        }
    }

    private void acX() {
        if (TbadkApplication.isLogin()) {
            acY();
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
                    this.bPi = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    acZ();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkApplication.isSDKLogin = false;
            if (i2 == -1) {
                acY();
            } else {
                finish();
            }
        }
    }

    private void acY() {
        if (TextUtils.isEmpty(this.bPi)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            acZ();
        }
    }

    private void acZ() {
        if (this.bPg == null) {
            this.bPg = "";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteShareActivityConfig(getPageContext().getPageActivity(), this.bPi, this.mShareTitle, this.mShareContent, this.bPh, this.bPg, this.bPj, this.mAppName, this.bPk)));
    }
}
