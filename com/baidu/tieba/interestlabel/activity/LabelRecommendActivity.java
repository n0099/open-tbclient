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
/* loaded from: classes22.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel kBh;
    private b kBi;
    private a kBj = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void cXz() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void eu(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.kBl[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.kBi.getRootView());
                    if (bVar == null || y.isEmpty(bVar.cXC()) || y.isEmpty(bVar.cXD())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.kBi.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.kBi.getRootView());
                    LabelRecommendActivity.this.kBi.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
                        LabelRecommendActivity.this.cXy();
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
        static final /* synthetic */ int[] kBl = new int[LabelRequestEnum.values().length];

        static {
            try {
                kBl[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kBl[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kBi = new b(this);
        this.kBi.setOnClickListener(this);
        this.kBh = new LabelSettingModel(getPageContext());
        this.kBh.a(this.kBj);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new ar("c12243").ak("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, true);
    }

    private void loadData() {
        this.kBh.cXF();
        showLoadingView(this.kBi.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kBi.cXL()) {
            TiebaStatic.log(new ar("c12245").ak("obj_type", this.mFrom));
            finish();
        } else if (view == this.kBi.cXM()) {
            this.kBh.ev(this.kBi.cXO());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.kBi.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXy() {
        List<Integer> cXO = this.kBi.cXO();
        if (!y.isEmpty(cXO)) {
            StringBuilder sb = new StringBuilder();
            int size = cXO.size();
            for (int i = 0; i < size; i++) {
                if (cXO.get(i) != null) {
                    sb.append(cXO.get(i));
                    if (i < size - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                }
            }
            TiebaStatic.log(new ar("c12244").ak("obj_type", this.mFrom).dR("obj_name", sb.toString()));
        }
    }
}
