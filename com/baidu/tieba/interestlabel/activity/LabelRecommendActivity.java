package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.b;
import java.util.List;
/* loaded from: classes23.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel kAS;
    private b kAT;
    private a kAU = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void cYd() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void eu(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.kAW[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.kAT.getRootView());
                    if (bVar == null || y.isEmpty(bVar.cYg()) || y.isEmpty(bVar.cYh())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.kAT.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.kAT.getRootView());
                    LabelRecommendActivity.this.kAT.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
                        LabelRecommendActivity.this.cYc();
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
        static final /* synthetic */ int[] kAW = new int[LabelRequestEnum.values().length];

        static {
            try {
                kAW[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kAW[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kAT = new b(this);
        this.kAT.setOnClickListener(this);
        this.kAS = new LabelSettingModel(getPageContext());
        this.kAS.a(this.kAU);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new aq("c12243").al("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, true);
    }

    private void loadData() {
        this.kAS.cYj();
        showLoadingView(this.kAT.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kAT.cYp()) {
            TiebaStatic.log(new aq("c12245").al("obj_type", this.mFrom));
            finish();
        } else if (view == this.kAT.cYq()) {
            this.kAS.ev(this.kAT.cYs());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.kAT.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYc() {
        List<Integer> cYs = this.kAT.cYs();
        if (!y.isEmpty(cYs)) {
            StringBuilder sb = new StringBuilder();
            int size = cYs.size();
            for (int i = 0; i < size; i++) {
                if (cYs.get(i) != null) {
                    sb.append(cYs.get(i));
                    if (i < size - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                }
            }
            TiebaStatic.log(new aq("c12244").al("obj_type", this.mFrom).dR("obj_name", sb.toString()));
        }
    }
}
