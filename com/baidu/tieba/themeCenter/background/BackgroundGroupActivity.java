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
    private BackgroundGroupModel nGl;
    private c nGm;
    private d nGn;
    private BackgroundGroupModel.a nGo = new BackgroundGroupModel.a() { // from class: com.baidu.tieba.themeCenter.background.BackgroundGroupActivity.1
        @Override // com.baidu.tieba.themeCenter.background.BackgroundGroupModel.a
        public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.e eVar, List<b> list) {
            BackgroundGroupActivity.this.hideLoadingView(BackgroundGroupActivity.this.nGm.getRootView());
            BackgroundGroupActivity.this.nGm.cOA();
            if (i == 0) {
                BackgroundGroupActivity.this.nGm.a(eVar, list, BackgroundGroupActivity.this.nGl.dKP());
                return;
            }
            BackgroundGroupActivity.this.showToast(str);
            BackgroundGroupActivity.this.nGm.cAH();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
        this.mPageContext = getPageContext();
        this.nGl = new BackgroundGroupModel(this);
        this.nGl.a(this.nGo);
        this.nGn = new d(this.mPageContext, this.nGl.getUniqueId());
        this.nGn.setFrom(1);
        this.nGm = new c(this, this.nGn);
        this.nGm.cOz();
        showLoadingView(this.nGm.getRootView());
        this.nGl.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            showLoadingView(this.nGm.getRootView());
            this.nGl.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nGm != null) {
            this.nGm.bzn();
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
        if (this.nGl != null && this.nGm != null) {
            showLoadingView(this.nGm.getRootView());
            this.nGl.LoadData();
        }
    }

    public int getPropId() {
        return this.nGn.getPropId();
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
