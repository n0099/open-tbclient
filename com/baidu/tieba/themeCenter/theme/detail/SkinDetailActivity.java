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
    private e dOd;
    private g dOe;
    private int dOf;
    private String dOg;
    private String dOh;
    private com.baidu.tieba.themeCenter.b mSkinData;
    private int mSkinType;
    private e.a dOi = new a(this);
    private View.OnClickListener mClickListener = new b(this);
    private CustomMessageListener dOj = new c(this, CmdConfigCustom.CMD_GET_SKIN_FROM_DB);

    /* JADX INFO: Access modifiers changed from: private */
    public void aHO() {
        String string;
        if (this.mSkinData.aHt() == 100) {
            if (this.mSkinData.getActivityFinish() == 0) {
                TbadkCoreApplication.m411getInst().setThemeWebviewOpen(true);
                com.baidu.tbadk.browser.f.C(getActivity(), this.mSkinData.getActivityUrl());
                return;
            }
            return;
        }
        if (this.mSkinData.aHt() == 101) {
            string = getPageContext().getString(n.j.become_annual_can_use_theme);
        } else if (this.mSkinData.aHt() > 1) {
            string = String.format(getPageContext().getString(n.j.become_vip_can_use_theme), Integer.valueOf(this.mSkinData.aHt()));
        } else {
            string = getPageContext().getString(n.j.become_member_can_use);
        }
        com.baidu.tieba.themeCenter.i.a(getPageContext(), 1, string);
    }

    public void nB(int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_GET_SKIN_FROM_DB, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
        registerListener(this.dOj);
        this.mSkinData = new com.baidu.tieba.themeCenter.b();
        Intent intent = getIntent();
        if (intent != null) {
            this.dOf = intent.getIntExtra(SkinDetailActivityConfig.THEME_ID, 0);
            this.mSkinType = intent.getIntExtra(SkinDetailActivityConfig.THEME_CURRENT_TYPE, -3);
            this.dOg = intent.getStringExtra(SkinDetailActivityConfig.THEME_ALBUM_PICTURE);
            this.dOh = intent.getStringExtra(SkinDetailActivityConfig.THEME_PERMISSION_ICON_URL);
        }
        this.dOe = new g(this);
        this.dOe.setOnClickListener(this.mClickListener);
        this.dOd = new e();
        this.dOd.a(this.dOi);
        showLoadingView(this.dOe.getRootView());
        if (this.mSkinType == -3) {
            if (TbadkApplication.getInst().getSkinType() == 2 && this.dOf == TbadkCoreApplication.m411getInst().getUsedThemeId()) {
                this.mSkinType = 0;
                this.dOd.nC(this.dOf);
                return;
            }
            nB(this.dOf);
            return;
        }
        this.dOd.nC(this.dOf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.m411getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.m411getInst().setThemeWebviewOpen(false);
            showLoadingView(this.dOe.getRootView());
            this.dOd.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dOd != null) {
            this.dOd.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.dOd != null && this.dOe != null) {
            showLoadingView(this.dOe.getRootView());
            this.dOd.nC(this.dOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dOe != null) {
            this.dOe.vR();
        }
    }
}
