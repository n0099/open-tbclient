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
import java.util.List;
/* loaded from: classes12.dex */
public class LabelRecommendActivity extends BaseActivity<LabelRecommendActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.v1.c.a mCallback;
    public int mFrom;
    public LabelSettingModel mModel;
    public c.a.t0.v1.d.b mView;

    /* loaded from: classes12.dex */
    public class a implements c.a.t0.v1.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LabelRecommendActivity f45409e;

        public a(LabelRecommendActivity labelRecommendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {labelRecommendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45409e = labelRecommendActivity;
        }

        @Override // c.a.t0.v1.c.a
        public void callback(LabelRequestEnum labelRequestEnum, c.a.t0.v1.b.b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, labelRequestEnum, bVar, i2) == null) {
                int i3 = b.a[labelRequestEnum.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2 && i2 == 0) {
                        c.a.s0.s.h0.b.k().u("set_recommend_label", true);
                        this.f45409e.statisticSubSuccess();
                        this.f45409e.finish();
                        return;
                    }
                    return;
                }
                LabelRecommendActivity labelRecommendActivity = this.f45409e;
                labelRecommendActivity.hideLoadingView(labelRecommendActivity.mView.c());
                if (bVar != null && !ListUtils.isEmpty(bVar.c()) && !ListUtils.isEmpty(bVar.b())) {
                    LabelRecommendActivity labelRecommendActivity2 = this.f45409e;
                    labelRecommendActivity2.hideNetRefreshView(labelRecommendActivity2.mView.c());
                    this.f45409e.mView.j(bVar);
                    return;
                }
                LabelRecommendActivity labelRecommendActivity3 = this.f45409e;
                labelRecommendActivity3.showNetRefreshView(labelRecommendActivity3.mView.c(), TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            }
        }

        @Override // c.a.t0.v1.c.a
        public void getLabel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.t0.v1.c.a
        public void subLabel(List<Integer> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.mModel.B();
            showLoadingView(this.mView.c(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statisticSubSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
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
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            super.onClick(view);
            if (view == this.mView.e()) {
                TiebaStatic.log(new StatisticItem("c12245").param("obj_type", this.mFrom));
                finish();
            } else if (view == this.mView.f()) {
                this.mModel.C(this.mView.d());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            c.a.t0.v1.d.b bVar = new c.a.t0.v1.d.b(this);
            this.mView = bVar;
            bVar.k(this);
            LabelSettingModel labelSettingModel = new LabelSettingModel(getPageContext());
            this.mModel = labelSettingModel;
            labelSettingModel.D(this.mCallback);
            if (getIntent() != null) {
                this.mFrom = getIntent().getIntExtra("from", -1);
            }
            TiebaStatic.log(new StatisticItem("c12243").param("obj_type", this.mFrom));
            loadData();
            c.a.s0.s.h0.b.k().u("show_recommend_label", true);
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
