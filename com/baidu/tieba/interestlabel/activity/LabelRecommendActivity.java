package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.b;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel erU;
    private b erV;
    private a erW = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void aJJ() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void ck(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.erY[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.erV.getRootView());
                    if (bVar == null || v.w(bVar.aJM()) || v.w(bVar.aJN())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.erV.getRootView(), TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.erV.getRootView());
                    LabelRecommendActivity.this.erV.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("set_recommend_label", true);
                        LabelRecommendActivity.this.aJI();
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
        static final /* synthetic */ int[] erY = new int[LabelRequestEnum.values().length];

        static {
            try {
                erY[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                erY[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.erV = new b(this);
        this.erV.setOnClickListener(this);
        this.erU = new LabelSettingModel(getPageContext());
        this.erU.a(this.erW);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new al("c12243").r("obj_type", this.mFrom));
        OT();
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_label", true);
    }

    private void OT() {
        this.erU.aJP();
        showLoadingView(this.erV.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.erV.aJV()) {
            TiebaStatic.log(new al("c12245").r("obj_type", this.mFrom));
            finish();
        } else if (view2 == this.erV.aJW()) {
            this.erU.cl(this.erV.aJY());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.erV.getRootView());
        OT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJI() {
        List<Integer> aJY = this.erV.aJY();
        if (!v.w(aJY)) {
            StringBuilder sb = new StringBuilder();
            int size = aJY.size();
            for (int i = 0; i < size; i++) {
                if (aJY.get(i) != null) {
                    sb.append(aJY.get(i));
                    if (i < size - 1) {
                        sb.append("_");
                    }
                }
            }
            TiebaStatic.log(new al("c12244").r("obj_type", this.mFrom).ac("obj_name", sb.toString()));
        }
    }
}
