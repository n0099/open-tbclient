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
    private LabelSettingModel kuX;
    private b kuY;
    private a kuZ = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void cVC() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void em(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.kvb[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.kuY.getRootView());
                    if (bVar == null || y.isEmpty(bVar.cVF()) || y.isEmpty(bVar.cVG())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.kuY.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.kuY.getRootView());
                    LabelRecommendActivity.this.kuY.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
                        LabelRecommendActivity.this.cVB();
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
        static final /* synthetic */ int[] kvb = new int[LabelRequestEnum.values().length];

        static {
            try {
                kvb[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kvb[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kuY = new b(this);
        this.kuY.setOnClickListener(this);
        this.kuX = new LabelSettingModel(getPageContext());
        this.kuX.a(this.kuZ);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new aq("c12243").aj("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, true);
    }

    private void loadData() {
        this.kuX.cVI();
        showLoadingView(this.kuY.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kuY.cVO()) {
            TiebaStatic.log(new aq("c12245").aj("obj_type", this.mFrom));
            finish();
        } else if (view == this.kuY.cVP()) {
            this.kuX.en(this.kuY.cVR());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.kuY.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVB() {
        List<Integer> cVR = this.kuY.cVR();
        if (!y.isEmpty(cVR)) {
            StringBuilder sb = new StringBuilder();
            int size = cVR.size();
            for (int i = 0; i < size; i++) {
                if (cVR.get(i) != null) {
                    sb.append(cVR.get(i));
                    if (i < size - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                }
            }
            TiebaStatic.log(new aq("c12244").aj("obj_type", this.mFrom).dR("obj_name", sb.toString()));
        }
    }
}
