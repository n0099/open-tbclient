package com.baidu.tieba.themeCenter.theme.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SkinDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.theme.detail.e;
/* loaded from: classes.dex */
public class SkinDetailActivity extends BaseActivity<SkinDetailActivity> {
    private e dGC;
    private g dGD;
    private int dGE;
    private String dGF;
    private String dGG;
    private com.baidu.tieba.themeCenter.b mSkinData;
    private int mSkinType;
    private e.a dGH = new a(this);
    private View.OnClickListener mClickListener = new b(this);
    private CustomMessageListener dGI = new c(this, CmdConfigCustom.CMD_GET_SKIN_FROM_DB);

    /* JADX INFO: Access modifiers changed from: private */
    public void aFz() {
        String string;
        if (this.mSkinData.aFe() == 100) {
            if (this.mSkinData.getActivityFinish() == 0) {
                TbadkCoreApplication.m411getInst().setThemeWebviewOpen(true);
                com.baidu.tbadk.browser.f.C(getActivity(), this.mSkinData.getActivityUrl());
                return;
            }
            return;
        }
        if (this.mSkinData.aFe() == 101) {
            string = getPageContext().getString(n.i.become_annual_can_use_theme);
        } else if (this.mSkinData.aFe() > 1) {
            string = String.format(getPageContext().getString(n.i.become_vip_can_use_theme), Integer.valueOf(this.mSkinData.aFe()));
        } else {
            string = getPageContext().getString(n.i.become_member_can_use);
        }
        com.baidu.tieba.themeCenter.i.a(getPageContext(), 1, string);
    }

    public void mZ(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_GET_SKIN_FROM_DB, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
        registerListener(this.dGI);
        this.mSkinData = new com.baidu.tieba.themeCenter.b();
        Intent intent = getIntent();
        if (intent != null) {
            this.dGE = intent.getIntExtra(SkinDetailActivityConfig.THEME_ID, 0);
            this.mSkinType = intent.getIntExtra(SkinDetailActivityConfig.THEME_CURRENT_TYPE, -3);
            this.dGF = intent.getStringExtra(SkinDetailActivityConfig.THEME_ALBUM_PICTURE);
            this.dGG = intent.getStringExtra(SkinDetailActivityConfig.THEME_PERMISSION_ICON_URL);
        }
        this.dGD = new g(this);
        this.dGD.setOnClickListener(this.mClickListener);
        this.dGC = new e();
        this.dGC.a(this.dGH);
        showLoadingView(this.dGD.getRootView());
        if (this.mSkinType == -3) {
            if (TbadkApplication.getInst().getSkinType() == 2 && this.dGE == TbadkCoreApplication.m411getInst().getUsedThemeId()) {
                this.mSkinType = 0;
                this.dGC.na(this.dGE);
                return;
            }
            mZ(this.dGE);
            return;
        }
        this.dGC.na(this.dGE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.m411getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
            showLoadingView(this.dGD.getRootView());
            this.dGC.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dGC != null) {
            this.dGC.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dGC != null && this.dGD != null) {
            showLoadingView(this.dGD.getRootView());
            this.dGC.na(this.dGE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dGD != null) {
            this.dGD.wh();
        }
    }
}
