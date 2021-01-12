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
    private BackgroundGroupModel nwA;
    private c nwB;
    private d nwC;
    private BackgroundGroupModel.a nwD = new BackgroundGroupModel.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundGroupActivity.1
        @Override // com.baidu.tieba.themeCenter.background.BackgroundGroupModel.a
        public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.e eVar, List<b> list) {
            BackgroundGroupActivity.this.hideLoadingView(BackgroundGroupActivity.this.nwB.getRootView());
            BackgroundGroupActivity.this.nwB.cMD();
            if (i == 0) {
                BackgroundGroupActivity.this.nwB.a(eVar, list, BackgroundGroupActivity.this.nwA.dIE());
                return;
            }
            BackgroundGroupActivity.this.showToast(str);
            BackgroundGroupActivity.this.nwB.czw();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        this.nwA = new BackgroundGroupModel(this);
        this.nwA.a(this.nwD);
        this.nwC = new d(this.mPageContext, this.nwA.getUniqueId());
        this.nwC.setFrom(1);
        this.nwB = new c(this, this.nwC);
        this.nwB.cMC();
        showLoadingView(this.nwB.getRootView());
        this.nwA.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.nwB.getRootView());
            this.nwA.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nwB != null) {
            this.nwB.byV();
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
        if (this.nwA != null && this.nwB != null) {
            showLoadingView(this.nwB.getRootView());
            this.nwA.LoadData();
        }
    }

    public int getPropId() {
        return this.nwC.getPropId();
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
