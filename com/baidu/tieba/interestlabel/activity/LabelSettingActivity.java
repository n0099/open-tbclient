package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import c.a.d.f.p.l;
import c.a.p0.z1.b.b;
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
import java.util.List;
/* loaded from: classes5.dex */
public class LabelSettingActivity extends BaseActivity<LabelSettingActivity> implements c.a.p0.z1.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LabelSettingModel mLabelSettingModel;
    public LabelSettingView mLabelSettingView;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
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
            a = iArr;
            try {
                iArr[LabelRequestEnum.GET_LABEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LabelRequestEnum.SUB_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public LabelSettingActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.p0.z1.c.a
    public void callback(LabelRequestEnum labelRequestEnum, b bVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, labelRequestEnum, bVar, i) == null) {
            int i2 = a.a[labelRequestEnum.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 && i == 0) {
                    c.a.o0.r.j0.b.k().u("set_recommend_label", true);
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

    @Override // c.a.p0.z1.c.a
    public void getLabel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!l.A()) {
                this.mLabelSettingView.g();
                this.mLabelSettingView.o(true);
                return;
            }
            this.mLabelSettingView.h();
            this.mLabelSettingView.n(true);
            this.mLabelSettingModel.D();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
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
            this.mLabelSettingModel.F(this);
            getLabel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        LabelSettingView labelSettingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, keyEvent)) == null) {
            if (i == 4 && (labelSettingView = this.mLabelSettingView) != null && labelSettingView.f()) {
                this.mLabelSettingView.m();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // c.a.p0.z1.c.a
    public void subLabel(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (!l.A()) {
                showToast(R.string.obfuscated_res_0x7f0f0c15);
            } else {
                this.mLabelSettingModel.E(list);
            }
        }
    }
}
