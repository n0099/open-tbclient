package com.baidu.tieba.themeCenter.dressCenter;

import android.os.Bundle;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel;
import java.util.List;
/* loaded from: classes9.dex */
public class DressupCenterActivity extends BaseActivity<DressupCenterActivity> {
    private c nJl;
    private DressupCenterModel nJm;
    private DressupCenterModel.a nJn = new DressupCenterModel.a() { // from class: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity.1
        @Override // com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel.a
        public void a(int i, String str, List<a> list, e eVar, List<d> list2) {
            DressupCenterActivity.this.hideLoadingView(DressupCenterActivity.this.nJl.getRootView());
            if (i == 0) {
                DressupCenterActivity.this.nJl.a(list, eVar, list2, DressupCenterActivity.this.nJm.dKX());
                return;
            }
            DressupCenterActivity.this.showToast(str);
            DressupCenterActivity.this.nJl.cAO();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nJm = new DressupCenterModel(this);
        this.nJm.a(this.nJn);
        this.nJl = new c(this);
        showLoadingView(this.nJl.getRootView());
        this.nJm.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nJl != null) {
            this.nJl.bzn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nJm != null && this.nJl != null) {
            hideNetRefreshView(this.nJl.getRootView());
            showLoadingView(this.nJl.getRootView());
            this.nJm.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nJm != null) {
            this.nJm.destroy();
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
