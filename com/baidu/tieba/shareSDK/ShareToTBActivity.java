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
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class ShareToTBActivity extends BaseActivity<ShareToTBActivity> {
    private String bNA;
    private PackageManager bNB;
    private PackageInfo bNC;
    private final CustomMessageListener bND = new d(this, 2001256);
    private String bNw;
    private String bNx;
    private String bNy;
    private String bNz;
    private String mAppName;
    private String mShareContent;
    private String mShareTitle;
    private String packageName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bNB = getPageContext().getPageActivity().getPackageManager();
        acs();
        act();
        com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "share4sdk");
        registerListener(this.bND);
    }

    private void acs() {
        Bundle extras = getIntent().getExtras();
        this.packageName = getCallingPackage();
        if (this.bNB != null && this.packageName != null) {
            try {
                this.bNC = this.bNB.getPackageInfo(this.packageName, 64);
                if (this.bNC != null) {
                    if (this.bNC.applicationInfo != null && this.bNC.applicationInfo.loadLabel(this.bNB) != null) {
                        this.mAppName = this.bNC.applicationInfo.loadLabel(this.bNB).toString();
                    }
                    if (this.bNC.signatures != null && this.bNC.signatures.length > 0 && this.bNC.signatures[0] != null) {
                        this.bNA = bc.w(this.bNC.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.bNA = null;
            }
        }
        this.bNw = extras.getString("ShareUrl");
        this.bNx = extras.getString("ShareImageUrl");
        this.mShareTitle = extras.getString("ShareTitle");
        this.mShareContent = extras.getString("ShareContent");
        this.bNy = extras.getString("mShareTargetBaName");
        if (TextUtils.isEmpty(this.mAppName)) {
            this.mAppName = extras.getString("appName");
        }
        if (TextUtils.isEmpty(this.bNA)) {
            this.bNA = extras.getString("appSign");
        }
        this.bNz = extras.getString("appKey");
    }

    private void act() {
        if (TbadkApplication.isLogin()) {
            acu();
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
                    this.bNy = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    acv();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkApplication.isSDKLogin = false;
            if (i2 == -1) {
                acu();
            } else {
                finish();
            }
        }
    }

    private void acu() {
        if (TextUtils.isEmpty(this.bNy)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            acv();
        }
    }

    private void acv() {
        if (this.bNw == null) {
            this.bNw = "";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteShareActivityConfig(getPageContext().getPageActivity(), this.bNy, this.mShareTitle, this.mShareContent, this.bNx, this.bNw, this.bNz, this.mAppName, this.bNA)));
    }
}
