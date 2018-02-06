package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.b.b;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.c;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel eXn;
    private c eXo;
    private a eXp = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void aOH() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void cr(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, b bVar, int i) {
            switch (AnonymousClass2.eXr[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.eXo.getRootView());
                    if (bVar == null || v.E(bVar.aOK()) || v.E(bVar.aOL())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.eXo.getRootView(), TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.eXo.getRootView());
                    LabelRecommendActivity.this.eXo.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("set_recommend_label", true);
                        LabelRecommendActivity.this.aOG();
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
        static final /* synthetic */ int[] eXr = new int[LabelRequestEnum.values().length];

        static {
            try {
                eXr[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                eXr[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eXo = new c(this);
        this.eXo.setOnClickListener(this);
        this.eXn = new LabelSettingModel(getPageContext());
        this.eXn.a(this.eXp);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new ak("c12243").s("obj_type", this.mFrom));
        Wt();
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_label", true);
    }

    private void Wt() {
        this.eXn.aON();
        showLoadingView(this.eXo.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eXo.aOT()) {
            TiebaStatic.log(new ak("c12245").s("obj_type", this.mFrom));
            finish();
        } else if (view == this.eXo.aOU()) {
            this.eXn.cs(this.eXo.aOW());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.eXo.getRootView());
        Wt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOG() {
        List<Integer> aOW = this.eXo.aOW();
        if (!v.E(aOW)) {
            StringBuilder sb = new StringBuilder();
            int size = aOW.size();
            for (int i = 0; i < size; i++) {
                if (aOW.get(i) != null) {
                    sb.append(aOW.get(i));
                    if (i < size - 1) {
                        sb.append("_");
                    }
                }
            }
            TiebaStatic.log(new ak("c12244").s("obj_type", this.mFrom).ab("obj_name", sb.toString()));
        }
    }
}
