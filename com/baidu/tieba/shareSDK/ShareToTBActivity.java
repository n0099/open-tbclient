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
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.bd;
/* loaded from: classes.dex */
public class ShareToTBActivity extends BaseActivity<ShareToTBActivity> {
    private String chb;
    private String chc;
    private String chd;
    private String che;
    private String chf;
    private PackageManager chg;
    private PackageInfo chh;
    private final CustomMessageListener chi = new a(this, 2001256);
    private String mAppName;
    private String mShareContent;
    private String mShareTitle;
    private String packageName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.chg = getPageContext().getPageActivity().getPackageManager();
        aka();
        akb();
        k.A(getPageContext().getPageActivity(), "share4sdk");
        registerListener(this.chi);
    }

    private void aka() {
        this.packageName = getCallingPackage();
        if (this.chg != null && this.packageName != null) {
            try {
                this.chh = this.chg.getPackageInfo(this.packageName, 64);
                if (this.chh != null) {
                    if (this.chh.applicationInfo != null && this.chh.applicationInfo.loadLabel(this.chg) != null) {
                        this.mAppName = this.chh.applicationInfo.loadLabel(this.chg).toString();
                    }
                    if (this.chh.signatures != null && this.chh.signatures.length > 0 && this.chh.signatures[0] != null) {
                        this.chf = bd.y(this.chh.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.chf = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.chb = extras.getString("ShareUrl");
            this.chc = extras.getString("ShareImageUrl");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.chd = extras.getString("mShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.chf)) {
                this.chf = extras.getString("appSign");
            }
            this.che = extras.getString("appKey");
        } catch (Exception e2) {
        }
    }

    private void akb() {
        if (TbadkApplication.isLogin()) {
            akc();
            return;
        }
        TbadkApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
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
                    this.chd = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    akd();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkApplication.isSDKLogin = false;
            if (i2 == -1) {
                akc();
            } else {
                finish();
            }
        }
    }

    private void akc() {
        if (TextUtils.isEmpty(this.chd)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            akd();
        }
    }

    private void akd() {
        if (this.chb == null) {
            this.chb = "";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteShareActivityConfig(getPageContext().getPageActivity(), this.chd, this.mShareTitle, this.mShareContent, this.chc, this.chb, this.che, this.mAppName, this.chf)));
    }
}
