package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.q0.l1.b.b;
import java.util.List;
/* loaded from: classes4.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements d.a.q0.l1.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LabelSettingModel mLabelSettingModel;
    public LabelSettingView mLabelSettingView;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18120a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1962185498, "Lcom/baidu/tieba/interestlabel/activity/LabelSettingActivity$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1962185498, "Lcom/baidu/tieba/interestlabel/activity/LabelSettingActivity$a;");
                    return;
                }
            }
            int[] iArr = new int[LabelRequestEnum.values().length];
            f18120a = iArr;
            try {
                iArr[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18120a[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public LabelSettingActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.a.q0.l1.c.a
    public void callback(LabelRequestEnum labelRequestEnum, b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, labelRequestEnum, bVar, i2) == null) {
            int i3 = a.f18120a[labelRequestEnum.ordinal()];
            if (i3 != 1) {
                if (i3 == 2 && i2 == 0) {
                    d.a.p0.s.d0.b.j().t("set_recommend_label", true);
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
    }

    @Override // d.a.q0.l1.c.a
    public void getLabel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!j.A()) {
                this.mLabelSettingView.g();
                this.mLabelSettingView.o(true);
                return;
            }
            this.mLabelSettingView.h();
            this.mLabelSettingView.n(true);
            this.mLabelSettingModel.B();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mLabelSettingView.l();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.mLabelSettingView = new LabelSettingView(getPageContext(), this);
            this.mLabelSettingModel = new LabelSettingModel(getPageContext());
            setContentView(this.mLabelSettingView);
            this.mLabelSettingModel.D(this);
            getLabel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        LabelSettingView labelSettingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i2, keyEvent)) == null) {
            if (i2 == 4 && (labelSettingView = this.mLabelSettingView) != null && labelSettingView.f()) {
                this.mLabelSettingView.m();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // d.a.q0.l1.c.a
    public void subLabel(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (!j.A()) {
                showToast(R.string.neterror);
            } else {
                this.mLabelSettingModel.C(list);
            }
        }
    }
}
