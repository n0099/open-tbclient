package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import d.a.c.e.p.j;
import d.a.n0.i1.b.b;
import java.util.List;
/* loaded from: classes4.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements d.a.n0.i1.c.a {
    public LabelSettingModel mLabelSettingModel;
    public LabelSettingView mLabelSettingView;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f17740a;

        static {
            int[] iArr = new int[LabelRequestEnum.values().length];
            f17740a = iArr;
            try {
                iArr[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17740a[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // d.a.n0.i1.c.a
    public void callback(LabelRequestEnum labelRequestEnum, b bVar, int i2) {
        int i3 = a.f17740a[labelRequestEnum.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 && i2 == 0) {
                d.a.m0.r.d0.b.j().t("set_recommend_label", true);
                finish();
                return;
            }
            return;
        }
        this.mLabelSettingView.g();
        if (bVar != null && !ListUtils.isEmpty(bVar.b())) {
            this.mLabelSettingView.h();
            this.mLabelSettingView.setData(bVar);
            return;
        }
        this.mLabelSettingView.o(true);
    }

    @Override // d.a.n0.i1.c.a
    public void getLabel() {
        if (!j.A()) {
            this.mLabelSettingView.g();
            this.mLabelSettingView.o(true);
            return;
        }
        this.mLabelSettingView.h();
        this.mLabelSettingView.n(true);
        this.mLabelSettingModel.x();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mLabelSettingView.l();
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
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        LabelSettingView labelSettingView;
        if (i2 == 4 && (labelSettingView = this.mLabelSettingView) != null && labelSettingView.f()) {
            this.mLabelSettingView.m();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // d.a.n0.i1.c.a
    public void subLabel(List<Integer> list) {
        if (!j.A()) {
            showToast(R.string.neterror);
        } else {
            this.mLabelSettingModel.y(list);
        }
    }
}
