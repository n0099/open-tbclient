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
    private BackgroundGroupModel nwB;
    private c nwC;
    private d nwD;
    private BackgroundGroupModel.a nwE = new BackgroundGroupModel.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundGroupActivity.1
        @Override // com.baidu.tieba.themeCenter.background.BackgroundGroupModel.a
        public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.e eVar, List<b> list) {
            BackgroundGroupActivity.this.hideLoadingView(BackgroundGroupActivity.this.nwC.getRootView());
            BackgroundGroupActivity.this.nwC.cMD();
            if (i == 0) {
                BackgroundGroupActivity.this.nwC.a(eVar, list, BackgroundGroupActivity.this.nwB.dIE());
                return;
            }
            BackgroundGroupActivity.this.showToast(str);
            BackgroundGroupActivity.this.nwC.czw();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        this.nwB = new BackgroundGroupModel(this);
        this.nwB.a(this.nwE);
        this.nwD = new d(this.mPageContext, this.nwB.getUniqueId());
        this.nwD.setFrom(1);
        this.nwC = new c(this, this.nwD);
        this.nwC.cMC();
        showLoadingView(this.nwC.getRootView());
        this.nwB.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.nwC.getRootView());
            this.nwB.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nwC != null) {
            this.nwC.byV();
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
        if (this.nwB != null && this.nwC != null) {
            showLoadingView(this.nwC.getRootView());
            this.nwB.LoadData();
        }
    }

    public int getPropId() {
        return this.nwD.getPropId();
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
