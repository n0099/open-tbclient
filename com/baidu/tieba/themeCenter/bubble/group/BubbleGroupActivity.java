package com.baidu.tieba.themeCenter.bubble.group;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.bubble.group.BubbleGroupModel;
import d.b.i0.k0.d;
import d.b.j0.j3.f.b.b;
import d.b.j0.j3.f.b.c;
import d.b.j0.j3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class BubbleGroupActivity extends BaseActivity<BubbleGroupActivity> {
    public BubbleGroupModel.c mCallback = new a();
    public d.b.j0.j3.f.a.a mItemController;
    public BubbleGroupModel mModel;
    public c mView;

    /* loaded from: classes5.dex */
    public class a implements BubbleGroupModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.themeCenter.bubble.group.BubbleGroupModel.c
        public void a(int i, String str, e eVar, List<b> list) {
            BubbleGroupActivity bubbleGroupActivity = BubbleGroupActivity.this;
            bubbleGroupActivity.hideLoadingView(bubbleGroupActivity.mView.d());
            BubbleGroupActivity.this.mView.i();
            if (i == 0) {
                BubbleGroupActivity.this.mView.k(eVar, list, BubbleGroupActivity.this.mModel.z());
                return;
            }
            BubbleGroupActivity.this.showToast(str);
            BubbleGroupActivity.this.mView.j();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.b.i0.k0.a
    public String getCurrentPageKey() {
        return "b010";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.f50982a = true;
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        c cVar = this.mView;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BubbleGroupModel bubbleGroupModel = new BubbleGroupModel(this);
        this.mModel = bubbleGroupModel;
        bubbleGroupModel.C(this.mCallback);
        d.b.j0.j3.f.a.a aVar = new d.b.j0.j3.f.a.a(getPageContext());
        this.mItemController = aVar;
        c cVar = new c(this, aVar);
        this.mView = cVar;
        cVar.e();
        showLoadingView(this.mView.d());
        this.mModel.LoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        c cVar;
        if (this.mModel == null || (cVar = this.mView) == null) {
            return;
        }
        showLoadingView(cVar.d());
        this.mModel.LoadData();
    }
}
