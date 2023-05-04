package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.f55;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.tieba.mf8;
import com.baidu.tieba.nf8;
import com.baidu.tieba.pf8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LabelSettingModel a;
    public pf8 b;
    public int c;
    public nf8 d;

    /* loaded from: classes5.dex */
    public class a implements nf8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LabelRecommendActivity a;

        public a(LabelRecommendActivity labelRecommendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {labelRecommendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = labelRecommendActivity;
        }

        @Override // com.baidu.tieba.nf8
        public void a(LabelRequestEnum labelRequestEnum, mf8 mf8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, labelRequestEnum, mf8Var, i) == null) {
                int i2 = b.a[labelRequestEnum.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2 && i == 0) {
                        f55.m().w("set_recommend_label", true);
                        this.a.A1();
                        this.a.finish();
                        return;
                    }
                    return;
                }
                LabelRecommendActivity labelRecommendActivity = this.a;
                labelRecommendActivity.hideLoadingView(labelRecommendActivity.b.c());
                if (mf8Var != null && !ListUtils.isEmpty(mf8Var.b()) && !ListUtils.isEmpty(mf8Var.a())) {
                    LabelRecommendActivity labelRecommendActivity2 = this.a;
                    labelRecommendActivity2.hideNetRefreshView(labelRecommendActivity2.b.c());
                    this.a.b.j(mf8Var);
                    return;
                }
                LabelRecommendActivity labelRecommendActivity3 = this.a;
                labelRecommendActivity3.showNetRefreshView(labelRecommendActivity3.b.c(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0d30), true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1848991399, "Lcom/baidu/tieba/interestlabel/activity/LabelRecommendActivity$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1848991399, "Lcom/baidu/tieba/interestlabel/activity/LabelRecommendActivity$b;");
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

    public LabelRecommendActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.a0();
            showLoadingView(this.b.c(), true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            hideNetRefreshView(this.b.c());
            a();
        }
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            List<Integer> d = this.b.d();
            if (ListUtils.isEmpty(d)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            int size = d.size();
            for (int i = 0; i < size; i++) {
                if (d.get(i) != null) {
                    sb.append(d.get(i));
                    if (i < size - 1) {
                        sb.append("_");
                    }
                }
            }
            TiebaStatic.log(new StatisticItem("c12244").param("obj_type", this.c).param("obj_name", sb.toString()));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.b.e()) {
                TiebaStatic.log(new StatisticItem("c12245").param("obj_type", this.c));
                finish();
            } else if (view2 == this.b.f()) {
                this.a.b0(this.b.d());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            pf8 pf8Var = new pf8(this);
            this.b = pf8Var;
            pf8Var.k(this);
            LabelSettingModel labelSettingModel = new LabelSettingModel(getPageContext());
            this.a = labelSettingModel;
            labelSettingModel.c0(this.d);
            if (getIntent() != null) {
                this.c = getIntent().getIntExtra("from", -1);
            }
            TiebaStatic.log(new StatisticItem("c12243").param("obj_type", this.c));
            a();
            f55.m().w("show_recommend_label", true);
        }
    }
}
