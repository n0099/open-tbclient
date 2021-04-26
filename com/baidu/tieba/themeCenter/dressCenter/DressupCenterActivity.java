package com.baidu.tieba.themeCenter.dressCenter;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel;
import d.a.j0.j3.h.c;
import d.a.j0.j3.h.d;
import d.a.j0.j3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class DressupCenterActivity extends BaseActivity<DressupCenterActivity> {
    public DressupCenterModel.b mCallback = new a();
    public DressupCenterModel mModel;
    public c mView;

    /* loaded from: classes5.dex */
    public class a implements DressupCenterModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel.b
        public void a(int i2, String str, List<d.a.j0.j3.h.a> list, e eVar, List<d> list2) {
            DressupCenterActivity dressupCenterActivity = DressupCenterActivity.this;
            dressupCenterActivity.hideLoadingView(dressupCenterActivity.mView.e());
            if (i2 == 0) {
                DressupCenterActivity.this.mView.m(list, eVar, list2, DressupCenterActivity.this.mModel.z());
                return;
            }
            DressupCenterActivity.this.showToast(str);
            DressupCenterActivity.this.mView.l();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.i0.k0.a
    public String getCurrentPageKey() {
        return "b003";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d.a.i0.k0.d getPageStayDurationItem() {
        d.a.i0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.f48564a = true;
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        c cVar = this.mView;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DressupCenterModel dressupCenterModel = new DressupCenterModel(this);
        this.mModel = dressupCenterModel;
        dressupCenterModel.A(this.mCallback);
        c cVar = new c(this);
        this.mView = cVar;
        showLoadingView(cVar.e());
        this.mModel.LoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        DressupCenterModel dressupCenterModel = this.mModel;
        if (dressupCenterModel != null) {
            dressupCenterModel.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        c cVar;
        if (this.mModel == null || (cVar = this.mView) == null) {
            return;
        }
        hideNetRefreshView(cVar.e());
        showLoadingView(this.mView.e());
        this.mModel.LoadData();
    }
}
