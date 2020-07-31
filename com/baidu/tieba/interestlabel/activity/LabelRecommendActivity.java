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
    private LabelSettingModel jvv;
    private b jvw;
    private a jvx = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void cAo() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void dL(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.jvz[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.jvw.getRootView());
                    if (bVar == null || x.isEmpty(bVar.cAr()) || x.isEmpty(bVar.cAs())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.jvw.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.jvw.getRootView());
                    LabelRecommendActivity.this.jvw.setData(bVar);
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
        static final /* synthetic */ int[] jvz = new int[LabelRequestEnum.values().length];

        static {
            try {
                jvz[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jvz[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jvw = new b(this);
        this.jvw.setOnClickListener(this);
        this.jvv = new LabelSettingModel(getPageContext());
        this.jvv.a(this.jvx);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new ap("c12243").ah("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, true);
    }

    private void loadData() {
        this.jvv.cAu();
        showLoadingView(this.jvw.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jvw.cAA()) {
            TiebaStatic.log(new ap("c12245").ah("obj_type", this.mFrom));
            finish();
        } else if (view == this.jvw.cAB()) {
            this.jvv.dM(this.jvw.cAD());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.jvw.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAn() {
        List<Integer> cAD = this.jvw.cAD();
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
