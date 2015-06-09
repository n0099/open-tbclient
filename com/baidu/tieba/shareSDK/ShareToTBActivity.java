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
    private String chc;
    private String chd;
    private String che;
    private String chf;
    private String chg;
    private PackageManager chh;
    private PackageInfo chi;
    private final CustomMessageListener chj = new a(this, 2001256);
    private String mAppName;
    private String mShareContent;
    private String mShareTitle;
    private String packageName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.chh = getPageContext().getPageActivity().getPackageManager();
        akb();
        akc();
        k.A(getPageContext().getPageActivity(), "share4sdk");
        registerListener(this.chj);
    }

    private void akb() {
        this.packageName = getCallingPackage();
        if (this.chh != null && this.packageName != null) {
            try {
                this.chi = this.chh.getPackageInfo(this.packageName, 64);
                if (this.chi != null) {
                    if (this.chi.applicationInfo != null && this.chi.applicationInfo.loadLabel(this.chh) != null) {
                        this.mAppName = this.chi.applicationInfo.loadLabel(this.chh).toString();
                    }
                    if (this.chi.signatures != null && this.chi.signatures.length > 0 && this.chi.signatures[0] != null) {
                        this.chg = bd.y(this.chi.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.chg = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.chc = extras.getString("ShareUrl");
            this.chd = extras.getString("ShareImageUrl");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.che = extras.getString("mShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.chg)) {
                this.chg = extras.getString("appSign");
            }
            this.chf = extras.getString("appKey");
        } catch (Exception e2) {
        }
    }

    private void akc() {
        if (TbadkApplication.isLogin()) {
            akd();
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
                    this.che = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    ake();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkApplication.isSDKLogin = false;
            if (i2 == -1) {
                akd();
            } else {
                finish();
            }
        }
    }

    private void akd() {
        if (TextUtils.isEmpty(this.che)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            ake();
        }
    }

    private void ake() {
        if (this.chc == null) {
            this.chc = "";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteShareActivityConfig(getPageContext().getPageActivity(), this.che, this.mShareTitle, this.mShareContent, this.chd, this.chc, this.chf, this.mAppName, this.chg)));
    }
}
