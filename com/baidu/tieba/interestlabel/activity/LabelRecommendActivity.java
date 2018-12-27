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
    private LabelSettingModel fmf;
    private b fmg;
    private a fmh = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void aXL() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void cP(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.fmj[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.fmg.getRootView());
                    if (bVar == null || v.I(bVar.aXO()) || v.I(bVar.aXP())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.fmg.getRootView(), TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.fmg.getRootView());
                    LabelRecommendActivity.this.fmg.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("set_recommend_label", true);
                        LabelRecommendActivity.this.aXK();
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
        static final /* synthetic */ int[] fmj = new int[LabelRequestEnum.values().length];

        static {
            try {
                fmj[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                fmj[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fmg = new b(this);
        this.fmg.setOnClickListener(this);
        this.fmf = new LabelSettingModel(getPageContext());
        this.fmf.a(this.fmh);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new am("c12243").x("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_label", true);
    }

    private void loadData() {
        this.fmf.aXR();
        showLoadingView(this.fmg.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fmg.aXX()) {
            TiebaStatic.log(new am("c12245").x("obj_type", this.mFrom));
            finish();
        } else if (view == this.fmg.aXY()) {
            this.fmf.cQ(this.fmg.aYa());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.fmg.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXK() {
        List<Integer> aYa = this.fmg.aYa();
        if (!v.I(aYa)) {
            StringBuilder sb = new StringBuilder();
            int size = aYa.size();
            for (int i = 0; i < size; i++) {
                if (aYa.get(i) != null) {
                    sb.append(aYa.get(i));
                    if (i < size - 1) {
                        sb.append(BaseRequestAction.SPLITE);
                    }
                }
            }
            TiebaStatic.log(new am("c12244").x("obj_type", this.mFrom).aA("obj_name", sb.toString()));
        }
    }
}
