package com.baidu.tieba.themeCenter.dressCenter;

import android.os.Bundle;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel;
import java.util.List;
/* loaded from: classes8.dex */
public class DressupCenterActivity extends BaseActivity<DressupCenterActivity> {
    private c nza;
    private DressupCenterModel nzb;
    private DressupCenterModel.a nzc = new DressupCenterModel.a() { // from class: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity.1
        @Override // com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel.a
        public void a(int i, String str, List<a> list, e eVar, List<d> list2) {
            DressupCenterActivity.this.hideLoadingView(DressupCenterActivity.this.nza.getRootView());
            if (i == 0) {
                DressupCenterActivity.this.nza.a(list, eVar, list2, DressupCenterActivity.this.nzb.dIE());
                return;
            }
            DressupCenterActivity.this.showToast(str);
            DressupCenterActivity.this.nza.czw();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nzb = new DressupCenterModel(this);
        this.nzb.a(this.nzc);
        this.nza = new c(this);
        showLoadingView(this.nza.getRootView());
        this.nzb.LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nza != null) {
            this.nza.byV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (this.nzb != null && this.nza != null) {
            hideNetRefreshView(this.nza.getRootView());
            showLoadingView(this.nza.getRootView());
            this.nzb.LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nzb != null) {
            this.nzb.destroy();
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
