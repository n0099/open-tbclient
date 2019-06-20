package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.b;
import java.util.List;
/* loaded from: classes5.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel gUq;
    private b gUr;
    private a gUs = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void bGC() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void dh(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.gUu[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.gUr.getRootView());
                    if (bVar == null || v.aa(bVar.bGF()) || v.aa(bVar.bGG())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.gUr.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.gUr.getRootView());
                    LabelRecommendActivity.this.gUr.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("set_recommend_label", true);
                        LabelRecommendActivity.this.bGB();
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
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] gUu = new int[LabelRequestEnum.values().length];

        static {
            try {
                gUu[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gUu[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gUr = new b(this);
        this.gUr.setOnClickListener(this);
        this.gUq = new LabelSettingModel(getPageContext());
        this.gUq.a(this.gUs);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new am("c12243").P("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_recommend_label", true);
    }

    private void loadData() {
        this.gUq.bGI();
        showLoadingView(this.gUr.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gUr.bGO()) {
            TiebaStatic.log(new am("c12245").P("obj_type", this.mFrom));
            finish();
        } else if (view == this.gUr.bGP()) {
            this.gUq.di(this.gUr.bGR());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.gUr.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGB() {
        List<Integer> bGR = this.gUr.bGR();
        if (!v.aa(bGR)) {
            StringBuilder sb = new StringBuilder();
            int size = bGR.size();
            for (int i = 0; i < size; i++) {
                if (bGR.get(i) != null) {
                    sb.append(bGR.get(i));
                    if (i < size - 1) {
                        sb.append("_");
                    }
                }
            }
            TiebaStatic.log(new am("c12244").P("obj_type", this.mFrom).bT("obj_name", sb.toString()));
        }
    }
}
