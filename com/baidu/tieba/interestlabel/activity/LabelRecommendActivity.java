package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import java.util.List;
/* loaded from: classes4.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    public d.b.i0.g1.c.a mCallback = new a();
    public int mFrom;
    public LabelSettingModel mModel;
    public d.b.i0.g1.d.b mView;

    /* loaded from: classes4.dex */
    public class a implements d.b.i0.g1.c.a {
        public a() {
        }

        @Override // d.b.i0.g1.c.a
        public void callback(LabelRequestEnum labelRequestEnum, d.b.i0.g1.b.b bVar, int i) {
            int i2 = b.f18480a[labelRequestEnum.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 && i == 0) {
                    d.b.h0.r.d0.b.i().s("set_recommend_label", true);
                    LabelRecommendActivity.this.statisticSubSuccess();
                    LabelRecommendActivity.this.finish();
                    return;
                }
                return;
            }
            LabelRecommendActivity labelRecommendActivity = LabelRecommendActivity.this;
            labelRecommendActivity.hideLoadingView(labelRecommendActivity.mView.c());
            if (bVar != null && !ListUtils.isEmpty(bVar.c()) && !ListUtils.isEmpty(bVar.b())) {
                LabelRecommendActivity labelRecommendActivity2 = LabelRecommendActivity.this;
                labelRecommendActivity2.hideNetRefreshView(labelRecommendActivity2.mView.c());
                LabelRecommendActivity.this.mView.j(bVar);
                return;
            }
            LabelRecommendActivity labelRecommendActivity3 = LabelRecommendActivity.this;
            labelRecommendActivity3.showNetRefreshView(labelRecommendActivity3.mView.c(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
        }

        @Override // d.b.i0.g1.c.a
        public void getLabel() {
        }

        @Override // d.b.i0.g1.c.a
        public void subLabel(List<Integer> list) {
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18480a;

        static {
            int[] iArr = new int[LabelRequestEnum.values().length];
            f18480a = iArr;
            try {
                iArr[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18480a[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void loadData() {
        this.mModel.x();
        showLoadingView(this.mView.c(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statisticSubSuccess() {
        List<Integer> d2 = this.mView.d();
        if (ListUtils.isEmpty(d2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int size = d2.size();
        for (int i = 0; i < size; i++) {
            if (d2.get(i) != null) {
                sb.append(d2.get(i));
                if (i < size - 1) {
                    sb.append("_");
                }
            }
        }
        TiebaStatic.log(new StatisticItem("c12244").param("obj_type", this.mFrom).param("obj_name", sb.toString()));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mView.e()) {
            TiebaStatic.log(new StatisticItem("c12245").param("obj_type", this.mFrom));
            finish();
        } else if (view == this.mView.f()) {
            this.mModel.y(this.mView.d());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.b.i0.g1.d.b bVar = new d.b.i0.g1.d.b(this);
        this.mView = bVar;
        bVar.k(this);
        LabelSettingModel labelSettingModel = new LabelSettingModel(getPageContext());
        this.mModel = labelSettingModel;
        labelSettingModel.z(this.mCallback);
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        }
        TiebaStatic.log(new StatisticItem("c12243").param("obj_type", this.mFrom));
        loadData();
        d.b.h0.r.d0.b.i().s("show_recommend_label", true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mView.c());
        loadData();
    }
}
