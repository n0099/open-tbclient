package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.b;
import java.util.List;
/* loaded from: classes10.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel jmR;
    private b jmS;
    private a jmT = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void cwq() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void dE(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.jmV[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.jmS.getRootView());
                    if (bVar == null || w.isEmpty(bVar.cwt()) || w.isEmpty(bVar.cwu())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.jmS.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.jmS.getRootView());
                    LabelRecommendActivity.this.jmS.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
                        LabelRecommendActivity.this.cwp();
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
    /* loaded from: classes10.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] jmV = new int[LabelRequestEnum.values().length];

        static {
            try {
                jmV[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jmV[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jmS = new b(this);
        this.jmS.setOnClickListener(this);
        this.jmR = new LabelSettingModel(getPageContext());
        this.jmR.a(this.jmT);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new ao("c12243").ag("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, true);
    }

    private void loadData() {
        this.jmR.cww();
        showLoadingView(this.jmS.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jmS.cwC()) {
            TiebaStatic.log(new ao("c12245").ag("obj_type", this.mFrom));
            finish();
        } else if (view == this.jmS.cwD()) {
            this.jmR.dF(this.jmS.cwF());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.jmS.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwp() {
        List<Integer> cwF = this.jmS.cwF();
        if (!w.isEmpty(cwF)) {
            StringBuilder sb = new StringBuilder();
            int size = cwF.size();
            for (int i = 0; i < size; i++) {
                if (cwF.get(i) != null) {
                    sb.append(cwF.get(i));
                    if (i < size - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                }
            }
            TiebaStatic.log(new ao("c12244").ag("obj_type", this.mFrom).dk("obj_name", sb.toString()));
        }
    }
}
