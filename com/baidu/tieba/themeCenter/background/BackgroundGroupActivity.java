package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.themeCenter.background.BackgroundGroupModel;
import java.util.List;
/* loaded from: classes8.dex */
public class BackgroundGroupActivity extends BaseActivity<BackgroundGroupActivity> {
    private TbPageContext<?> mPageContext;
    private BackgroundGroupModel nIR;
    private c nIS;
    private d nIT;
    private BackgroundGroupModel.a nIU = new BackgroundGroupModel.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundGroupActivity.1
        @Override // com.baidu.tieba.themeCenter.background.BackgroundGroupModel.a
        public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.e eVar, List<b> list) {
            BackgroundGroupActivity.this.hideLoadingView(BackgroundGroupActivity.this.nIS.getRootView());
            BackgroundGroupActivity.this.nIS.cOO();
            if (i == 0) {
                BackgroundGroupActivity.this.nIS.a(eVar, list, BackgroundGroupActivity.this.nIR.dLf());
                return;
            }
            BackgroundGroupActivity.this.showToast(str);
            BackgroundGroupActivity.this.nIS.cAU();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        this.nIR = new BackgroundGroupModel(this);
        this.nIR.a(this.nIU);
        this.nIT = new d(this.mPageContext, this.nIR.getUniqueId());
        this.nIT.setFrom(1);
        this.nIS = new c(this, this.nIT);
        this.nIS.cON();
        showLoadingView(this.nIS.getRootView());
        this.nIR.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.nIS.getRootView());
            this.nIR.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nIS != null) {
            this.nIS.bzq();
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
        if (this.nIR != null && this.nIS != null) {
            showLoadingView(this.nIS.getRootView());
            this.nIR.LoadData();
        }
    }

    public int getPropId() {
        return this.nIT.getPropId();
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
