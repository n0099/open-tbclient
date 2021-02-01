package com.baidu.tieba.themeCenter.dressCenter;

import android.os.Bundle;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel;
import java.util.List;
/* loaded from: classes9.dex */
public class DressupCenterActivity extends BaseActivity<DressupCenterActivity> {
    private c nIL;
    private DressupCenterModel nIM;
    private DressupCenterModel.a nIN = new DressupCenterModel.a() { // from class: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity.1
        @Override // com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel.a
        public void a(int i, String str, List<a> list, e eVar, List<d> list2) {
            DressupCenterActivity.this.hideLoadingView(DressupCenterActivity.this.nIL.getRootView());
            if (i == 0) {
                DressupCenterActivity.this.nIL.a(list, eVar, list2, DressupCenterActivity.this.nIM.dKP());
                return;
            }
            DressupCenterActivity.this.showToast(str);
            DressupCenterActivity.this.nIL.cAH();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nIM = new DressupCenterModel(this);
        this.nIM.a(this.nIN);
        this.nIL = new c(this);
        showLoadingView(this.nIL.getRootView());
        this.nIM.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nIL != null) {
            this.nIL.bzn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nIM != null && this.nIL != null) {
            hideNetRefreshView(this.nIL.getRootView());
            showLoadingView(this.nIL.getRootView());
            this.nIM.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nIM != null) {
            this.nIM.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.THEME_CENTER;
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
