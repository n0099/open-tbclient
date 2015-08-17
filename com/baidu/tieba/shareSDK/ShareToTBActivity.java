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
    private String czp;
    private String czq;
    private String czr;
    private String czs;
    private String czt;
    private String czu;
    private PackageManager czv;
    private PackageInfo czw;
    private final CustomMessageListener czx = new a(this, CmdConfigCustom.CMD_SHARE_SDK_RESULT);
    private String mShareContent;
    private String mShareTitle;
    private String packageName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.czv = getPageContext().getPageActivity().getPackageManager();
        amD();
        amE();
        TiebaStatic.log("share4sdk");
        registerListener(this.czx);
    }

    private void amD() {
        this.packageName = getCallingPackage();
        if (this.czv != null && this.packageName != null) {
            try {
                this.czw = this.czv.getPackageInfo(this.packageName, 64);
                if (this.czw != null) {
                    if (this.czw.applicationInfo != null && this.czw.applicationInfo.loadLabel(this.czv) != null) {
                        this.czs = this.czw.applicationInfo.loadLabel(this.czv).toString();
                    }
                    if (this.czw.signatures != null && this.czw.signatures.length > 0 && this.czw.signatures[0] != null) {
                        this.czu = as.P(this.czw.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.czs = null;
                this.czu = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.czp = extras.getString("ShareUrl");
            this.czq = extras.getString("ShareImageUrl");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.czr = extras.getString("mShareTargetBaName");
            if (TextUtils.isEmpty(this.czs)) {
                this.czs = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.czu)) {
                this.czu = extras.getString("appSign");
            }
            this.czt = extras.getString("appKey");
        } catch (Exception e2) {
        }
    }

    private void amE() {
        if (TbadkApplication.isLogin()) {
            amF();
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
                    this.czr = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    amG();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkApplication.isSDKLogin = false;
            if (i2 == -1) {
                amF();
            } else {
                finish();
            }
        }
    }

    private void amF() {
        if (TextUtils.isEmpty(this.czr)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            amG();
        }
    }

    private void amG() {
        if (this.czp == null) {
            this.czp = "";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteShareActivityConfig(getPageContext().getPageActivity(), this.czr, this.mShareTitle, this.mShareContent, this.czq, this.czp, this.czt, this.czs, this.czu)));
    }
}
