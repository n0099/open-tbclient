package com.baidu.tieba.interestlabel.activity;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import com.baidu.tieba.interestlabel.model.LabelSettingModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.r97;
import com.repackage.s97;
import com.repackage.u97;
import com.repackage.ys4;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s97 mCallback;
    public int mFrom;
    public LabelSettingModel mModel;
    public u97 mView;

    /* loaded from: classes3.dex */
    public class a implements s97 {
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

        @Override // com.repackage.s97
        public void a(LabelRequestEnum labelRequestEnum, r97 r97Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, labelRequestEnum, r97Var, i) == null) {
                int i2 = b.a[labelRequestEnum.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2 && i == 0) {
                        ys4.k().u("set_recommend_label", true);
                        this.a.statisticSubSuccess();
                        this.a.finish();
                        return;
                    }
                    return;
                }
                LabelRecommendActivity labelRecommendActivity = this.a;
                labelRecommendActivity.hideLoadingView(labelRecommendActivity.mView.c());
                if (r97Var != null && !ListUtils.isEmpty(r97Var.b()) && !ListUtils.isEmpty(r97Var.a())) {
                    LabelRecommendActivity labelRecommendActivity2 = this.a;
                    labelRecommendActivity2.hideNetRefreshView(labelRecommendActivity2.mView.c());
                    this.a.mView.j(r97Var);
                    return;
                }
                LabelRecommendActivity labelRecommendActivity3 = this.a;
                labelRecommendActivity3.showNetRefreshView(labelRecommendActivity3.mView.c(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c33), true);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.mCallback = new a(this);
    }

    private void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mModel.D();
            showLoadingView(this.mView.c(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statisticSubSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            List<Integer> d = this.mView.d();
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
            TiebaStatic.log(new StatisticItem("c12244").param("obj_type", this.mFrom).param("obj_name", sb.toString()));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.mView.e()) {
                TiebaStatic.log(new StatisticItem("c12245").param("obj_type", this.mFrom));
                finish();
            } else if (view2 == this.mView.f()) {
                this.mModel.E(this.mView.d());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            u97 u97Var = new u97(this);
            this.mView = u97Var;
            u97Var.k(this);
            LabelSettingModel labelSettingModel = new LabelSettingModel(getPageContext());
            this.mModel = labelSettingModel;
            labelSettingModel.F(this.mCallback);
            if (getIntent() != null) {
                this.mFrom = getIntent().getIntExtra("from", -1);
            }
            TiebaStatic.log(new StatisticItem("c12243").param("obj_type", this.mFrom));
            loadData();
            ys4.k().u("show_recommend_label", true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hideNetRefreshView(this.mView.c());
            loadData();
        }
    }
}
