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
    private String ccI;
    private String ccJ;
    private String ccK;
    private String ccL;
    private String ccM;
    private PackageManager ccN;
    private PackageInfo ccO;
    private final CustomMessageListener ccP = new a(this, 2001256);
    private String mAppName;
    private String mShareContent;
    private String mShareTitle;
    private String packageName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.ccN = getPageContext().getPageActivity().getPackageManager();
        aib();
        aic();
        k.A(getPageContext().getPageActivity(), "share4sdk");
        registerListener(this.ccP);
    }

    private void aib() {
        this.packageName = getCallingPackage();
        if (this.ccN != null && this.packageName != null) {
            try {
                this.ccO = this.ccN.getPackageInfo(this.packageName, 64);
                if (this.ccO != null) {
                    if (this.ccO.applicationInfo != null && this.ccO.applicationInfo.loadLabel(this.ccN) != null) {
                        this.mAppName = this.ccO.applicationInfo.loadLabel(this.ccN).toString();
                    }
                    if (this.ccO.signatures != null && this.ccO.signatures.length > 0 && this.ccO.signatures[0] != null) {
                        this.ccM = bf.y(this.ccO.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.ccM = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.ccI = extras.getString("ShareUrl");
            this.ccJ = extras.getString("ShareImageUrl");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.ccK = extras.getString("mShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.ccM)) {
                this.ccM = extras.getString("appSign");
            }
            this.ccL = extras.getString("appKey");
        } catch (Exception e2) {
        }
    }

    private void aic() {
        if (TbadkApplication.isLogin()) {
            aid();
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
                    this.ccK = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    aie();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkApplication.isSDKLogin = false;
            if (i2 == -1) {
                aid();
            } else {
                finish();
            }
        }
    }

    private void aid() {
        if (TextUtils.isEmpty(this.ccK)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            aie();
        }
    }

    private void aie() {
        if (this.ccI == null) {
            this.ccI = "";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteShareActivityConfig(getPageContext().getPageActivity(), this.ccK, this.mShareTitle, this.mShareContent, this.ccJ, this.ccI, this.ccL, this.mAppName, this.ccM)));
    }
}
