package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.b;
import java.util.List;
/* loaded from: classes5.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel hbt;
    private b hbu;
    private a hbv = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void bJx() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void di(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.hbx[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.hbu.getRootView());
                    if (bVar == null || v.aa(bVar.bJA()) || v.aa(bVar.bJB())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.hbu.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.hbu.getRootView());
                    LabelRecommendActivity.this.hbu.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("set_recommend_label", true);
                        LabelRecommendActivity.this.bJw();
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
        static final /* synthetic */ int[] hbx = new int[LabelRequestEnum.values().length];

        static {
            try {
                hbx[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hbx[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hbu = new b(this);
        this.hbu.setOnClickListener(this);
        this.hbt = new LabelSettingModel(getPageContext());
        this.hbt.a(this.hbv);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new an("c12243").P("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("show_recommend_label", true);
    }

    private void loadData() {
        this.hbt.bJD();
        showLoadingView(this.hbu.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hbu.bJJ()) {
            TiebaStatic.log(new an("c12245").P("obj_type", this.mFrom));
            finish();
        } else if (view == this.hbu.bJK()) {
            this.hbt.dj(this.hbu.bJM());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.hbu.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJw() {
        List<Integer> bJM = this.hbu.bJM();
        if (!v.aa(bJM)) {
            StringBuilder sb = new StringBuilder();
            int size = bJM.size();
            for (int i = 0; i < size; i++) {
                if (bJM.get(i) != null) {
                    sb.append(bJM.get(i));
                    if (i < size - 1) {
                        sb.append("_");
                    }
                }
            }
            TiebaStatic.log(new an("c12244").P("obj_type", this.mFrom).bT("obj_name", sb.toString()));
        }
    }
}
