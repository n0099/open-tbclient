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
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
public class ShareToTBActivity extends BaseActivity<ShareToTBActivity> {
    private String ccX;
    private String ccY;
    private String ccZ;
    private String cda;
    private String cdb;
    private PackageManager cdc;
    private PackageInfo cdd;
    private final CustomMessageListener cde = new a(this, 2001256);
    private String mAppName;
    private String mShareContent;
    private String mShareTitle;
    private String packageName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.cdc = getPageContext().getPageActivity().getPackageManager();
        aiq();
        air();
        k.A(getPageContext().getPageActivity(), "share4sdk");
        registerListener(this.cde);
    }

    private void aiq() {
        this.packageName = getCallingPackage();
        if (this.cdc != null && this.packageName != null) {
            try {
                this.cdd = this.cdc.getPackageInfo(this.packageName, 64);
                if (this.cdd != null) {
                    if (this.cdd.applicationInfo != null && this.cdd.applicationInfo.loadLabel(this.cdc) != null) {
                        this.mAppName = this.cdd.applicationInfo.loadLabel(this.cdc).toString();
                    }
                    if (this.cdd.signatures != null && this.cdd.signatures.length > 0 && this.cdd.signatures[0] != null) {
                        this.cdb = bf.y(this.cdd.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.cdb = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.ccX = extras.getString("ShareUrl");
            this.ccY = extras.getString("ShareImageUrl");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.ccZ = extras.getString("mShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.cdb)) {
                this.cdb = extras.getString("appSign");
            }
            this.cda = extras.getString("appKey");
        } catch (Exception e2) {
        }
    }

    private void air() {
        if (TbadkApplication.isLogin()) {
            ais();
            return;
        }
        TbadkApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
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
                    this.ccZ = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    ait();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkApplication.isSDKLogin = false;
            if (i2 == -1) {
                ais();
            } else {
                finish();
            }
        }
    }

    private void ais() {
        if (TextUtils.isEmpty(this.ccZ)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            ait();
        }
    }

    private void ait() {
        if (this.ccX == null) {
            this.ccX = "";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteShareActivityConfig(getPageContext().getPageActivity(), this.ccZ, this.mShareTitle, this.mShareContent, this.ccY, this.ccX, this.cda, this.mAppName, this.cdb)));
    }
}
