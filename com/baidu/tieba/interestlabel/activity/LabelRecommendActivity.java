package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.b;
import java.util.List;
/* loaded from: classes23.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private b kOA;
    private a kOB = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void dcK() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void eF(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.kOD[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.kOA.getRootView());
                    if (bVar == null || y.isEmpty(bVar.dcN()) || y.isEmpty(bVar.dcO())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.kOA.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.kOA.getRootView());
                    LabelRecommendActivity.this.kOA.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
                        LabelRecommendActivity.this.dcJ();
                        LabelRecommendActivity.this.finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private LabelSettingModel kOz;
    private int mFrom;

    /* renamed from: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity$2  reason: invalid class name */
    /* loaded from: classes23.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] kOD = new int[LabelRequestEnum.values().length];

        static {
            try {
                kOD[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kOD[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kOA = new b(this);
        this.kOA.setOnClickListener(this);
        this.kOz = new LabelSettingModel(getPageContext());
        this.kOz.a(this.kOB);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new ar("c12243").al("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, true);
    }

    private void loadData() {
        this.kOz.dcQ();
        showLoadingView(this.kOA.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kOA.dcW()) {
            TiebaStatic.log(new ar("c12245").al("obj_type", this.mFrom));
            finish();
        } else if (view == this.kOA.dcX()) {
            this.kOz.eG(this.kOA.dcZ());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.kOA.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcJ() {
        List<Integer> dcZ = this.kOA.dcZ();
        if (!y.isEmpty(dcZ)) {
            StringBuilder sb = new StringBuilder();
            int size = dcZ.size();
            for (int i = 0; i < size; i++) {
                if (dcZ.get(i) != null) {
                    sb.append(dcZ.get(i));
                    if (i < size - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                }
            }
            TiebaStatic.log(new ar("c12244").al("obj_type", this.mFrom).dY("obj_name", sb.toString()));
        }
    }
}
