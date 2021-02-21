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
/* loaded from: classes8.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel kXR;
    private b kXS;
    private a kXT = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void daJ() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void eD(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.kXV[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.kXS.getRootView());
                    if (bVar == null || y.isEmpty(bVar.daM()) || y.isEmpty(bVar.daN())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.kXS.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.kXS.getRootView());
                    LabelRecommendActivity.this.kXS.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
                        LabelRecommendActivity.this.daI();
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
    /* loaded from: classes8.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] kXV = new int[LabelRequestEnum.values().length];

        static {
            try {
                kXV[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kXV[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kXS = new b(this);
        this.kXS.setOnClickListener(this);
        this.kXR = new LabelSettingModel(getPageContext());
        this.kXR.a(this.kXT);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new ar("c12243").ap("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, true);
    }

    private void loadData() {
        this.kXR.daP();
        showLoadingView(this.kXS.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kXS.daV()) {
            TiebaStatic.log(new ar("c12245").ap("obj_type", this.mFrom));
            finish();
        } else if (view == this.kXS.daW()) {
            this.kXR.eE(this.kXS.daY());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.kXS.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daI() {
        List<Integer> daY = this.kXS.daY();
        if (!y.isEmpty(daY)) {
            StringBuilder sb = new StringBuilder();
            int size = daY.size();
            for (int i = 0; i < size; i++) {
                if (daY.get(i) != null) {
                    sb.append(daY.get(i));
                    if (i < size - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                }
            }
            TiebaStatic.log(new ar("c12244").ap("obj_type", this.mFrom).dR("obj_name", sb.toString()));
        }
    }
}
