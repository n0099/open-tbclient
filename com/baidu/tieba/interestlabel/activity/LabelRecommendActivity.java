package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.b;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel eEt;
    private b eEu;
    private a eEv = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void aOE() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void cs(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.eEx[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.eEu.getRootView());
                    if (bVar == null || w.z(bVar.aOH()) || w.z(bVar.aOI())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.eEu.getRootView(), TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.eEu.getRootView());
                    LabelRecommendActivity.this.eEu.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("set_recommend_label", true);
                        LabelRecommendActivity.this.aOD();
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
        static final /* synthetic */ int[] eEx = new int[LabelRequestEnum.values().length];

        static {
            try {
                eEx[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                eEx[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eEu = new b(this);
        this.eEu.setOnClickListener(this);
        this.eEt = new LabelSettingModel(getPageContext());
        this.eEt.a(this.eEv);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new am("c12243").r("obj_type", this.mFrom));
        So();
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_label", true);
    }

    private void So() {
        this.eEt.aOK();
        showLoadingView(this.eEu.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eEu.aOQ()) {
            TiebaStatic.log(new am("c12245").r("obj_type", this.mFrom));
            finish();
        } else if (view == this.eEu.aOR()) {
            this.eEt.ct(this.eEu.aOT());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.eEu.getRootView());
        So();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOD() {
        List<Integer> aOT = this.eEu.aOT();
        if (!w.z(aOT)) {
            StringBuilder sb = new StringBuilder();
            int size = aOT.size();
            for (int i = 0; i < size; i++) {
                if (aOT.get(i) != null) {
                    sb.append(aOT.get(i));
                    if (i < size - 1) {
                        sb.append("_");
                    }
                }
            }
            TiebaStatic.log(new am("c12244").r("obj_type", this.mFrom).ah("obj_name", sb.toString()));
        }
    }
}
