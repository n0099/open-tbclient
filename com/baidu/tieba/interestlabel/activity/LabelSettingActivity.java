package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import d.b.c.e.p.j;
import d.b.j0.h1.b.b;
import java.util.List;
/* loaded from: classes4.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements d.b.j0.h1.c.a {
    public LabelSettingModel mLabelSettingModel;
    public LabelSettingView mLabelSettingView;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18167a;

        static {
            int[] iArr = new int[LabelRequestEnum.values().length];
            f18167a = iArr;
            try {
                iArr[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18167a[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // d.b.j0.h1.c.a
    public void callback(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        int i2 = a.f18167a[labelRequestEnum.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 && i == 0) {
                d.b.i0.r.d0.b.j().t("set_recommend_label", true);
                finish();
                return;
            }
            return;
        }
        this.mLabelSettingView.h();
        if (bVar != null && !ListUtils.isEmpty(bVar.b())) {
            this.mLabelSettingView.i();
            this.mLabelSettingView.setData(bVar);
            return;
        }
        this.mLabelSettingView.p(true);
    }

    @Override // d.b.j0.h1.c.a
    public void getLabel() {
        if (!j.A()) {
            this.mLabelSettingView.h();
            this.mLabelSettingView.p(true);
            return;
        }
        this.mLabelSettingView.i();
        this.mLabelSettingView.o(true);
        this.mLabelSettingModel.x();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mLabelSettingView.m();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mLabelSettingView = new LabelSettingView(getPageContext(), this);
        this.mLabelSettingModel = new LabelSettingModel(getPageContext());
        setContentView(this.mLabelSettingView);
        this.mLabelSettingModel.z(this);
        getLabel();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        LabelSettingView labelSettingView;
        if (i == 4 && (labelSettingView = this.mLabelSettingView) != null && labelSettingView.f()) {
            this.mLabelSettingView.n();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // d.b.j0.h1.c.a
    public void subLabel(List<Integer> list) {
        if (!j.A()) {
            showToast(R.string.neterror);
        } else {
            this.mLabelSettingModel.y(list);
        }
    }
}
