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
    private LabelSettingModel eMd;
    private b eMe;
    private a eMf = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void aQk() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void cw(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.eMh[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.eMe.getRootView());
                    if (bVar == null || w.z(bVar.aQn()) || w.z(bVar.aQo())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.eMe.getRootView(), TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.eMe.getRootView());
                    LabelRecommendActivity.this.eMe.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("set_recommend_label", true);
                        LabelRecommendActivity.this.aQj();
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
        static final /* synthetic */ int[] eMh = new int[LabelRequestEnum.values().length];

        static {
            try {
                eMh[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                eMh[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eMe = new b(this);
        this.eMe.setOnClickListener(this);
        this.eMd = new LabelSettingModel(getPageContext());
        this.eMd.a(this.eMf);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new an("c12243").r("obj_type", this.mFrom));
        SS();
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_label", true);
    }

    private void SS() {
        this.eMd.aQq();
        showLoadingView(this.eMe.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eMe.aQw()) {
            TiebaStatic.log(new an("c12245").r("obj_type", this.mFrom));
            finish();
        } else if (view == this.eMe.aQx()) {
            this.eMd.cx(this.eMe.aQz());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.eMe.getRootView());
        SS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQj() {
        List<Integer> aQz = this.eMe.aQz();
        if (!w.z(aQz)) {
            StringBuilder sb = new StringBuilder();
            int size = aQz.size();
            for (int i = 0; i < size; i++) {
                if (aQz.get(i) != null) {
                    sb.append(aQz.get(i));
                    if (i < size - 1) {
                        sb.append("_");
                    }
                }
            }
            TiebaStatic.log(new an("c12244").r("obj_type", this.mFrom).af("obj_name", sb.toString()));
        }
    }
}
