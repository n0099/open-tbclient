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
    private LabelSettingModel etd;
    private b ete;
    private a etf = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void aJI() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void cn(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.eth[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.ete.getRootView());
                    if (bVar == null || v.w(bVar.aJL()) || v.w(bVar.aJM())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.ete.getRootView(), TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.ete.getRootView());
                    LabelRecommendActivity.this.ete.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("set_recommend_label", true);
                        LabelRecommendActivity.this.aJH();
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
        static final /* synthetic */ int[] eth = new int[LabelRequestEnum.values().length];

        static {
            try {
                eth[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                eth[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ete = new b(this);
        this.ete.setOnClickListener(this);
        this.etd = new LabelSettingModel(getPageContext());
        this.etd.a(this.etf);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new al("c12243").r("obj_type", this.mFrom));
        OQ();
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_label", true);
    }

    private void OQ() {
        this.etd.aJO();
        showLoadingView(this.ete.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.ete.aJU()) {
            TiebaStatic.log(new al("c12245").r("obj_type", this.mFrom));
            finish();
        } else if (view2 == this.ete.aJV()) {
            this.etd.co(this.ete.aJX());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.ete.getRootView());
        OQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJH() {
        List<Integer> aJX = this.ete.aJX();
        if (!v.w(aJX)) {
            StringBuilder sb = new StringBuilder();
            int size = aJX.size();
            for (int i = 0; i < size; i++) {
                if (aJX.get(i) != null) {
                    sb.append(aJX.get(i));
                    if (i < size - 1) {
                        sb.append("_");
                    }
                }
            }
            TiebaStatic.log(new al("c12244").r("obj_type", this.mFrom).ac("obj_name", sb.toString()));
        }
    }
}
