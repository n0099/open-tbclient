package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.themeCenter.background.BackgroundGroupModel;
import java.util.List;
/* loaded from: classes9.dex */
public class BackgroundGroupActivity extends BaseActivity<BackgroundGroupActivity> {
    private TbPageContext<?> mPageContext;
    private BackgroundGroupModel nGL;
    private c nGM;
    private d nGN;
    private BackgroundGroupModel.a nGO = new BackgroundGroupModel.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundGroupActivity.1
        @Override // com.baidu.tieba.themeCenter.background.BackgroundGroupModel.a
        public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.e eVar, List<b> list) {
            BackgroundGroupActivity.this.hideLoadingView(BackgroundGroupActivity.this.nGM.getRootView());
            BackgroundGroupActivity.this.nGM.cOH();
            if (i == 0) {
                BackgroundGroupActivity.this.nGM.a(eVar, list, BackgroundGroupActivity.this.nGL.dKX());
                return;
            }
            BackgroundGroupActivity.this.showToast(str);
            BackgroundGroupActivity.this.nGM.cAO();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        this.nGL = new BackgroundGroupModel(this);
        this.nGL.a(this.nGO);
        this.nGN = new d(this.mPageContext, this.nGL.getUniqueId());
        this.nGN.setFrom(1);
        this.nGM = new c(this, this.nGN);
        this.nGM.cOG();
        showLoadingView(this.nGM.getRootView());
        this.nGL.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.nGM.getRootView());
            this.nGL.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nGM != null) {
            this.nGM.bzn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nGL != null && this.nGM != null) {
            showLoadingView(this.nGM.getRootView());
            this.nGL.LoadData();
        }
    }

    public int getPropId() {
        return this.nGN.getPropId();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.BACKGROUND_LIST;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.isRouteStat = true;
        }
        return pageStayDurationItem;
    }
}
