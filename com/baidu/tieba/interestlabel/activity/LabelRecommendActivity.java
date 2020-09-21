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
/* loaded from: classes22.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel jTA;
    private b jTB;
    private a jTC = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void cON() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void ea(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.jTE[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.jTB.getRootView());
                    if (bVar == null || y.isEmpty(bVar.cOQ()) || y.isEmpty(bVar.cOR())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.jTB.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.jTB.getRootView());
                    LabelRecommendActivity.this.jTB.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
                        LabelRecommendActivity.this.cOM();
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
    /* loaded from: classes22.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] jTE = new int[LabelRequestEnum.values().length];

        static {
            try {
                jTE[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jTE[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jTB = new b(this);
        this.jTB.setOnClickListener(this);
        this.jTA = new LabelSettingModel(getPageContext());
        this.jTA.a(this.jTC);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new aq("c12243").ai("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, true);
    }

    private void loadData() {
        this.jTA.cOT();
        showLoadingView(this.jTB.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jTB.cOZ()) {
            TiebaStatic.log(new aq("c12245").ai("obj_type", this.mFrom));
            finish();
        } else if (view == this.jTB.cPa()) {
            this.jTA.eb(this.jTB.cPc());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.jTB.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOM() {
        List<Integer> cPc = this.jTB.cPc();
        if (!y.isEmpty(cPc)) {
            StringBuilder sb = new StringBuilder();
            int size = cPc.size();
            for (int i = 0; i < size; i++) {
                if (cPc.get(i) != null) {
                    sb.append(cPc.get(i));
                    if (i < size - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                }
            }
            TiebaStatic.log(new aq("c12244").ai("obj_type", this.mFrom).dF("obj_name", sb.toString()));
        }
    }
}
