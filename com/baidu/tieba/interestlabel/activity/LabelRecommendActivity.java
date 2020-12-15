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
    private LabelSettingModel kOB;
    private b kOC;
    private a kOD = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void dcL() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void eF(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.kOF[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.kOC.getRootView());
                    if (bVar == null || y.isEmpty(bVar.dcO()) || y.isEmpty(bVar.dcP())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.kOC.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.kOC.getRootView());
                    LabelRecommendActivity.this.kOC.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
                        LabelRecommendActivity.this.dcK();
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
    /* loaded from: classes23.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] kOF = new int[LabelRequestEnum.values().length];

        static {
            try {
                kOF[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kOF[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kOC = new b(this);
        this.kOC.setOnClickListener(this);
        this.kOB = new LabelSettingModel(getPageContext());
        this.kOB.a(this.kOD);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new ar("c12243").al("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, true);
    }

    private void loadData() {
        this.kOB.dcR();
        showLoadingView(this.kOC.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kOC.dcX()) {
            TiebaStatic.log(new ar("c12245").al("obj_type", this.mFrom));
            finish();
        } else if (view == this.kOC.dcY()) {
            this.kOB.eG(this.kOC.dda());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.kOC.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcK() {
        List<Integer> dda = this.kOC.dda();
        if (!y.isEmpty(dda)) {
            StringBuilder sb = new StringBuilder();
            int size = dda.size();
            for (int i = 0; i < size; i++) {
                if (dda.get(i) != null) {
                    sb.append(dda.get(i));
                    if (i < size - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                }
            }
            TiebaStatic.log(new ar("c12244").al("obj_type", this.mFrom).dY("obj_name", sb.toString()));
        }
    }
}
