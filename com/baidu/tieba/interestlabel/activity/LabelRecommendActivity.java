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
/* loaded from: classes17.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel jKS;
    private b jKT;
    private a jKU = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void cLg() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void dS(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.jKW[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.jKT.getRootView());
                    if (bVar == null || y.isEmpty(bVar.cLj()) || y.isEmpty(bVar.cLk())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.jKT.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.jKT.getRootView());
                    LabelRecommendActivity.this.jKT.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
                        LabelRecommendActivity.this.cLf();
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
    /* loaded from: classes17.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] jKW = new int[LabelRequestEnum.values().length];

        static {
            try {
                jKW[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jKW[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jKT = new b(this);
        this.jKT.setOnClickListener(this);
        this.jKS = new LabelSettingModel(getPageContext());
        this.jKS.a(this.jKU);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new aq("c12243").ai("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, true);
    }

    private void loadData() {
        this.jKS.cLm();
        showLoadingView(this.jKT.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jKT.cLs()) {
            TiebaStatic.log(new aq("c12245").ai("obj_type", this.mFrom));
            finish();
        } else if (view == this.jKT.cLt()) {
            this.jKS.dT(this.jKT.cLv());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.jKT.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLf() {
        List<Integer> cLv = this.jKT.cLv();
        if (!y.isEmpty(cLv)) {
            StringBuilder sb = new StringBuilder();
            int size = cLv.size();
            for (int i = 0; i < size; i++) {
                if (cLv.get(i) != null) {
                    sb.append(cLv.get(i));
                    if (i < size - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                }
            }
            TiebaStatic.log(new aq("c12244").ai("obj_type", this.mFrom).dD("obj_name", sb.toString()));
        }
    }
}
