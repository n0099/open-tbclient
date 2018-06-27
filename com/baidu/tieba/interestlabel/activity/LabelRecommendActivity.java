package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.b;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel eIj;
    private b eIk;
    private a eIl = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void aPk() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void cw(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.eIn[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.eIk.getRootView());
                    if (bVar == null || w.A(bVar.aPn()) || w.A(bVar.aPo())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.eIk.getRootView(), TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.eIk.getRootView());
                    LabelRecommendActivity.this.eIk.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("set_recommend_label", true);
                        LabelRecommendActivity.this.aPj();
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
        static final /* synthetic */ int[] eIn = new int[LabelRequestEnum.values().length];

        static {
            try {
                eIn[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                eIn[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eIk = new b(this);
        this.eIk.setOnClickListener(this);
        this.eIj = new LabelSettingModel(getPageContext());
        this.eIj.a(this.eIl);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new an("c12243").r("obj_type", this.mFrom));
        SK();
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_label", true);
    }

    private void SK() {
        this.eIj.aPq();
        showLoadingView(this.eIk.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eIk.aPw()) {
            TiebaStatic.log(new an("c12245").r("obj_type", this.mFrom));
            finish();
        } else if (view == this.eIk.aPx()) {
            this.eIj.cx(this.eIk.aPz());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.eIk.getRootView());
        SK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPj() {
        List<Integer> aPz = this.eIk.aPz();
        if (!w.A(aPz)) {
            StringBuilder sb = new StringBuilder();
            int size = aPz.size();
            for (int i = 0; i < size; i++) {
                if (aPz.get(i) != null) {
                    sb.append(aPz.get(i));
                    if (i < size - 1) {
                        sb.append("_");
                    }
                }
            }
            TiebaStatic.log(new an("c12244").r("obj_type", this.mFrom).ah("obj_name", sb.toString()));
        }
    }
}
