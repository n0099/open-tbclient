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
    public d.a.j0.h1.c.a mCallback = new a();
    public int mFrom;
    public LabelSettingModel mModel;
    public d.a.j0.h1.d.b mView;

    /* loaded from: classes4.dex */
    public class a implements d.a.j0.h1.c.a {
        public a() {
        }

        @Override // d.a.j0.h1.c.a
        public void callback(LabelRequestEnum labelRequestEnum, d.a.j0.h1.b.b bVar, int i2) {
            int i3 = b.f18514a[labelRequestEnum.ordinal()];
            if (i3 != 1) {
                if (i3 == 2 && i2 == 0) {
                    d.a.i0.r.d0.b.j().t("set_recommend_label", true);
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

        @Override // d.a.j0.h1.c.a
        public void getLabel() {
        }

        @Override // d.a.j0.h1.c.a
        public void subLabel(List<Integer> list) {
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18514a;

        static {
            int[] iArr = new int[LabelRequestEnum.values().length];
            f18514a = iArr;
            try {
                iArr[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18514a[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
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
        for (int i2 = 0; i2 < size; i2++) {
            if (d2.get(i2) != null) {
                sb.append(d2.get(i2));
                if (i2 < size - 1) {
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
        d.a.j0.h1.d.b bVar = new d.a.j0.h1.d.b(this);
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
        d.a.i0.r.d0.b.j().t("show_recommend_label", true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mView.c());
        loadData();
    }
}
