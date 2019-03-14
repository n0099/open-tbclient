package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.b;
import java.util.List;
/* loaded from: classes5.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel gDf;
    private b gDg;
    private a gDh = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void byR() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void dc(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.gDj[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.gDg.getRootView());
                    if (bVar == null || v.T(bVar.byU()) || v.T(bVar.byV())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.gDg.getRootView(), TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.gDg.getRootView());
                    LabelRecommendActivity.this.gDg.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("set_recommend_label", true);
                        LabelRecommendActivity.this.byQ();
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
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] gDj = new int[LabelRequestEnum.values().length];

        static {
            try {
                gDj[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gDj[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gDg = new b(this);
        this.gDg.setOnClickListener(this);
        this.gDf = new LabelSettingModel(getPageContext());
        this.gDf.a(this.gDh);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new am("c12243").T("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_label", true);
    }

    private void loadData() {
        this.gDf.byX();
        showLoadingView(this.gDg.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gDg.bzd()) {
            TiebaStatic.log(new am("c12245").T("obj_type", this.mFrom));
            finish();
        } else if (view == this.gDg.bze()) {
            this.gDf.dd(this.gDg.bzg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.gDg.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byQ() {
        List<Integer> bzg = this.gDg.bzg();
        if (!v.T(bzg)) {
            StringBuilder sb = new StringBuilder();
            int size = bzg.size();
            for (int i = 0; i < size; i++) {
                if (bzg.get(i) != null) {
                    sb.append(bzg.get(i));
                    if (i < size - 1) {
                        sb.append("_");
                    }
                }
            }
            TiebaStatic.log(new am("c12244").T("obj_type", this.mFrom).bJ("obj_name", sb.toString()));
        }
    }
}
