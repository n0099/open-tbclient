package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.b;
import java.util.List;
/* loaded from: classes17.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel jvx;
    private b jvy;
    private a jvz = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void cAo() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void dL(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.jvB[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.jvy.getRootView());
                    if (bVar == null || x.isEmpty(bVar.cAr()) || x.isEmpty(bVar.cAs())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.jvy.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.jvy.getRootView());
                    LabelRecommendActivity.this.jvy.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
                        LabelRecommendActivity.this.cAn();
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
        static final /* synthetic */ int[] jvB = new int[LabelRequestEnum.values().length];

        static {
            try {
                jvB[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jvB[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jvy = new b(this);
        this.jvy.setOnClickListener(this);
        this.jvx = new LabelSettingModel(getPageContext());
        this.jvx.a(this.jvz);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new ap("c12243").ah("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, true);
    }

    private void loadData() {
        this.jvx.cAu();
        showLoadingView(this.jvy.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jvy.cAA()) {
            TiebaStatic.log(new ap("c12245").ah("obj_type", this.mFrom));
            finish();
        } else if (view == this.jvy.cAB()) {
            this.jvx.dM(this.jvy.cAD());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.jvy.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAn() {
        List<Integer> cAD = this.jvy.cAD();
        if (!x.isEmpty(cAD)) {
            StringBuilder sb = new StringBuilder();
            int size = cAD.size();
            for (int i = 0; i < size; i++) {
                if (cAD.get(i) != null) {
                    sb.append(cAD.get(i));
                    if (i < size - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                }
            }
            TiebaStatic.log(new ap("c12244").ah("obj_type", this.mFrom).dn("obj_name", sb.toString()));
        }
    }
}
