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
    private LabelSettingModel jKY;
    private b jKZ;
    private a jLa = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void cLh() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void dS(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.jLc[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.jKZ.getRootView());
                    if (bVar == null || y.isEmpty(bVar.cLk()) || y.isEmpty(bVar.cLl())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.jKZ.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.jKZ.getRootView());
                    LabelRecommendActivity.this.jKZ.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.SET_RECOMMEND_LABEL, true);
                        LabelRecommendActivity.this.cLg();
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
        static final /* synthetic */ int[] jLc = new int[LabelRequestEnum.values().length];

        static {
            try {
                jLc[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jLc[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jKZ = new b(this);
        this.jKZ.setOnClickListener(this);
        this.jKY = new LabelSettingModel(getPageContext());
        this.jKY.a(this.jLa);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new aq("c12243").ai("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_LABEL, true);
    }

    private void loadData() {
        this.jKY.cLn();
        showLoadingView(this.jKZ.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jKZ.cLt()) {
            TiebaStatic.log(new aq("c12245").ai("obj_type", this.mFrom));
            finish();
        } else if (view == this.jKZ.cLu()) {
            this.jKY.dT(this.jKZ.cLw());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.jKZ.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLg() {
        List<Integer> cLw = this.jKZ.cLw();
        if (!y.isEmpty(cLw)) {
            StringBuilder sb = new StringBuilder();
            int size = cLw.size();
            for (int i = 0; i < size; i++) {
                if (cLw.get(i) != null) {
                    sb.append(cLw.get(i));
                    if (i < size - 1) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                }
            }
            TiebaStatic.log(new aq("c12244").ai("obj_type", this.mFrom).dD("obj_name", sb.toString()));
        }
    }
}
