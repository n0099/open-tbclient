package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.b;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel fbc;
    private b fbd;
    private a fbe = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void aVJ() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void cM(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.fbg[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.fbd.getRootView());
                    if (bVar == null || v.J(bVar.aVM()) || v.J(bVar.aVN())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.fbd.getRootView(), TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.fbd.getRootView());
                    LabelRecommendActivity.this.fbd.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("set_recommend_label", true);
                        LabelRecommendActivity.this.aVI();
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
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] fbg = new int[LabelRequestEnum.values().length];

        static {
            try {
                fbg[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                fbg[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fbd = new b(this);
        this.fbd.setOnClickListener(this);
        this.fbc = new LabelSettingModel(getPageContext());
        this.fbc.a(this.fbe);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new am("c12243").x("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_label", true);
    }

    private void loadData() {
        this.fbc.aVP();
        showLoadingView(this.fbd.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fbd.aVV()) {
            TiebaStatic.log(new am("c12245").x("obj_type", this.mFrom));
            finish();
        } else if (view == this.fbd.aVW()) {
            this.fbc.cN(this.fbd.aVY());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.fbd.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVI() {
        List<Integer> aVY = this.fbd.aVY();
        if (!v.J(aVY)) {
            StringBuilder sb = new StringBuilder();
            int size = aVY.size();
            for (int i = 0; i < size; i++) {
                if (aVY.get(i) != null) {
                    sb.append(aVY.get(i));
                    if (i < size - 1) {
                        sb.append(BaseRequestAction.SPLITE);
                    }
                }
            }
            TiebaStatic.log(new am("c12244").x("obj_type", this.mFrom).ax("obj_name", sb.toString()));
        }
    }
}
