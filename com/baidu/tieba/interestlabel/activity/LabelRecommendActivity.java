package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.b;
import java.util.List;
/* loaded from: classes5.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel hdn;
    private b hdo;
    private a hdp = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void bKk() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void di(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.hdr[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.hdo.getRootView());
                    if (bVar == null || v.aa(bVar.bKn()) || v.aa(bVar.bKo())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.hdo.getRootView(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.hdo.getRootView());
                    LabelRecommendActivity.this.hdo.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("set_recommend_label", true);
                        LabelRecommendActivity.this.bKj();
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
        static final /* synthetic */ int[] hdr = new int[LabelRequestEnum.values().length];

        static {
            try {
                hdr[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hdr[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hdo = new b(this);
        this.hdo.setOnClickListener(this);
        this.hdn = new LabelSettingModel(getPageContext());
        this.hdn.a(this.hdp);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new an("c12243").P("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("show_recommend_label", true);
    }

    private void loadData() {
        this.hdn.bKq();
        showLoadingView(this.hdo.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hdo.bKw()) {
            TiebaStatic.log(new an("c12245").P("obj_type", this.mFrom));
            finish();
        } else if (view == this.hdo.bKx()) {
            this.hdn.dj(this.hdo.bKz());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.hdo.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKj() {
        List<Integer> bKz = this.hdo.bKz();
        if (!v.aa(bKz)) {
            StringBuilder sb = new StringBuilder();
            int size = bKz.size();
            for (int i = 0; i < size; i++) {
                if (bKz.get(i) != null) {
                    sb.append(bKz.get(i));
                    if (i < size - 1) {
                        sb.append("_");
                    }
                }
            }
            TiebaStatic.log(new an("c12244").P("obj_type", this.mFrom).bT("obj_name", sb.toString()));
        }
    }
}
