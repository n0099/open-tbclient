package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.model.a;
import com.baidu.tieba.interestlabel.view.b;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    private LabelSettingModel eLY;
    private b eLZ;
    private a eMa = new a() { // from class: com.baidu.tieba.interestlabel.activity.LabelRecommendActivity.1
        @Override // com.baidu.tieba.interestlabel.model.a
        public void aQh() {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void cw(List<Integer> list) {
        }

        @Override // com.baidu.tieba.interestlabel.model.a
        public void a(LabelRequestEnum labelRequestEnum, com.baidu.tieba.interestlabel.b.b bVar, int i) {
            switch (AnonymousClass2.eMc[labelRequestEnum.ordinal()]) {
                case 1:
                    LabelRecommendActivity.this.hideLoadingView(LabelRecommendActivity.this.eLZ.getRootView());
                    if (bVar == null || w.z(bVar.aQk()) || w.z(bVar.aQl())) {
                        LabelRecommendActivity.this.showNetRefreshView(LabelRecommendActivity.this.eLZ.getRootView(), TbadkCoreApplication.getInst().getString(f.j.neterror), true);
                        return;
                    }
                    LabelRecommendActivity.this.hideNetRefreshView(LabelRecommendActivity.this.eLZ.getRootView());
                    LabelRecommendActivity.this.eLZ.setData(bVar);
                    return;
                case 2:
                    if (i == 0) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("set_recommend_label", true);
                        LabelRecommendActivity.this.aQg();
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
        static final /* synthetic */ int[] eMc = new int[LabelRequestEnum.values().length];

        static {
            try {
                eMc[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                eMc[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eLZ = new b(this);
        this.eLZ.setOnClickListener(this);
        this.eLY = new LabelSettingModel(getPageContext());
        this.eLY.a(this.eMa);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new an("c12243").r("obj_type", this.mFrom));
        loadData();
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_label", true);
    }

    private void loadData() {
        this.eLY.aQn();
        showLoadingView(this.eLZ.getRootView(), true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eLZ.aQt()) {
            TiebaStatic.log(new an("c12245").r("obj_type", this.mFrom));
            finish();
        } else if (view == this.eLZ.aQu()) {
            this.eLY.cx(this.eLZ.aQw());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.eLZ.getRootView());
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQg() {
        List<Integer> aQw = this.eLZ.aQw();
        if (!w.z(aQw)) {
            StringBuilder sb = new StringBuilder();
            int size = aQw.size();
            for (int i = 0; i < size; i++) {
                if (aQw.get(i) != null) {
                    sb.append(aQw.get(i));
                    if (i < size - 1) {
                        sb.append("_");
                    }
                }
            }
            TiebaStatic.log(new an("c12244").r("obj_type", this.mFrom).ae("obj_name", sb.toString()));
        }
    }
}
