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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class ShareToTBActivity extends BaseActivity<ShareToTBActivity> {
    private String cHN;
    private String cHO;
    private String cHP;
    private String cHQ;
    private String cHR;
    private String cHS;
    private PackageManager cHT;
    private PackageInfo cHU;
    private final CustomMessageListener cHV = new a(this, CmdConfigCustom.CMD_SHARE_SDK_RESULT);
    private String mShareContent;
    private String mShareTitle;
    private String packageName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.cHT = getPageContext().getPageActivity().getPackageManager();
        aqM();
        aqN();
        TiebaStatic.log("share4sdk");
        registerListener(this.cHV);
    }

    private void aqM() {
        this.packageName = getCallingPackage();
        if (this.cHT != null && this.packageName != null) {
            try {
                this.cHU = this.cHT.getPackageInfo(this.packageName, 64);
                if (this.cHU != null) {
                    if (this.cHU.applicationInfo != null && this.cHU.applicationInfo.loadLabel(this.cHT) != null) {
                        this.cHQ = this.cHU.applicationInfo.loadLabel(this.cHT).toString();
                    }
                    if (this.cHU.signatures != null && this.cHU.signatures.length > 0 && this.cHU.signatures[0] != null) {
                        this.cHS = as.P(this.cHU.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.cHQ = null;
                this.cHS = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.cHN = extras.getString("ShareUrl");
            this.cHO = extras.getString("ShareImageUrl");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.cHP = extras.getString("mShareTargetBaName");
            if (TextUtils.isEmpty(this.cHQ)) {
                this.cHQ = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.cHS)) {
                this.cHS = extras.getString("appSign");
            }
            this.cHR = extras.getString("appKey");
        } catch (Exception e2) {
        }
    }

    private void aqN() {
        if (TbadkApplication.isLogin()) {
            aqO();
            return;
        }
        TbadkApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
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
                    this.cHP = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    aqP();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkApplication.isSDKLogin = false;
            if (i2 == -1) {
                aqO();
            } else {
                finish();
            }
        }
    }

    private void aqO() {
        if (TextUtils.isEmpty(this.cHP)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            aqP();
        }
    }

    private void aqP() {
        if (this.cHN == null) {
            this.cHN = "";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteShareActivityConfig(getPageContext().getPageActivity(), this.cHP, this.mShareTitle, this.mShareContent, this.cHO, this.cHN, this.cHR, this.cHQ, this.cHS)));
    }
}
