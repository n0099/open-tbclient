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
    private LabelSettingModel gUl;
    private b gUm;
    private a gUn = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void bGy() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void dh(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.gUp[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.gUm.getRootView());
                    if (bVar == null || v.aa(bVar.bGB()) || v.aa(bVar.bGC())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.gUm.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.gUm.getRootView());
                    LabelRecommendActivity.this.gUm.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("set_recommend_label", true);
                        LabelRecommendActivity.this.bGx();
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
        static final /* synthetic */ int[] gUp = new int[LabelRequestEnum.values().length];

        static {
            try {
                gUp[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gUp[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gUm = new b(this);
        this.gUm.setOnClickListener(this);
        this.gUl = new LabelSettingModel(getPageContext());
        this.gUl.a(this.gUn);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new am("c12243").P("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_recommend_label", true);
    }

    private void loadData() {
        this.gUl.bGE();
        showLoadingView(this.gUm.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gUm.bGK()) {
            TiebaStatic.log(new am("c12245").P("obj_type", this.mFrom));
            finish();
        } else if (view == this.gUm.bGL()) {
            this.gUl.di(this.gUm.bGN());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.gUm.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGx() {
        List<Integer> bGN = this.gUm.bGN();
        if (!v.aa(bGN)) {
            StringBuilder sb = new StringBuilder();
            int size = bGN.size();
            for (int i = 0; i < size; i++) {
                if (bGN.get(i) != null) {
                    sb.append(bGN.get(i));
                    if (i < size - 1) {
                        sb.append("_");
                    }
                }
            }
            TiebaStatic.log(new am("c12244").P("obj_type", this.mFrom).bT("obj_name", sb.toString()));
        }
    }
}
