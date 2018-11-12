package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.b;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel fcw;
    private b fcx;
    private a fcy = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void aVg() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void cK(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.fcA[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.fcx.getRootView());
                    if (bVar == null || v.I(bVar.aVj()) || v.I(bVar.aVk())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.fcx.getRootView(), TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.fcx.getRootView());
                    LabelRecommendActivity.this.fcx.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("set_recommend_label", true);
                        LabelRecommendActivity.this.aVf();
                        LabelRecommendActivity.this.finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private int mFrom;

    /* renamed from: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] fcA = new int[LabelRequestEnum.values().length];

        static {
            try {
                fcA[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                fcA[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fcx = new b(this);
        this.fcx.setOnClickListener(this);
        this.fcw = new LabelSettingModel(getPageContext());
        this.fcw.a(this.fcy);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new am("c12243").x("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_label", true);
    }

    private void loadData() {
        this.fcw.aVm();
        showLoadingView(this.fcx.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fcx.aVs()) {
            TiebaStatic.log(new am("c12245").x("obj_type", this.mFrom));
            finish();
        } else if (view == this.fcx.aVt()) {
            this.fcw.cL(this.fcx.aVv());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.fcx.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVf() {
        List<Integer> aVv = this.fcx.aVv();
        if (!v.I(aVv)) {
            StringBuilder sb = new StringBuilder();
            int size = aVv.size();
            for (int i = 0; i < size; i++) {
                if (aVv.get(i) != null) {
                    sb.append(aVv.get(i));
                    if (i < size - 1) {
                        sb.append(BaseRequestAction.SPLITE);
                    }
                }
            }
            TiebaStatic.log(new am("c12244").x("obj_type", this.mFrom).ax("obj_name", sb.toString()));
        }
    }
}
