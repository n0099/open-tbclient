package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.b;
import java.util.List;
/* loaded from: classes7.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel kPB;
    private b kPC;
    private a kPD = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void cYE() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void eF(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.kPF[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.kPC.getRootView());
                    if (bVar == null || x.isEmpty(bVar.cYH()) || x.isEmpty(bVar.cYI())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.kPC.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.kPC.getRootView());
                    LabelRecommendActivity.this.kPC.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
                        LabelRecommendActivity.this.cYD();
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
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] kPF = new int[LabelRequestEnum.values().length];

        static {
            try {
                kPF[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kPF[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kPC = new b(this);
        this.kPC.setOnClickListener(this);
        this.kPB = new LabelSettingModel(getPageContext());
        this.kPB.a(this.kPD);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new aq("c12243").an("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, true);
    }

    private void loadData() {
        this.kPB.cYK();
        showLoadingView(this.kPC.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kPC.cYQ()) {
            TiebaStatic.log(new aq("c12245").an("obj_type", this.mFrom));
            finish();
        } else if (view == this.kPC.cYR()) {
            this.kPB.eG(this.kPC.cYT());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.kPC.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYD() {
        List<Integer> cYT = this.kPC.cYT();
        if (!x.isEmpty(cYT)) {
            StringBuilder sb = new StringBuilder();
            int size = cYT.size();
            for (int i = 0; i < size; i++) {
                if (cYT.get(i) != null) {
                    sb.append(cYT.get(i));
                    if (i < size - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                }
            }
            TiebaStatic.log(new aq("c12244").an("obj_type", this.mFrom).dW("obj_name", sb.toString()));
        }
    }
}
