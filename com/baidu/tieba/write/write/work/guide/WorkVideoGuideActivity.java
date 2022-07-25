package com.baidu.tieba.write.write.work.guide;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WorkPublishGuideActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.uz8;
import com.repackage.wz8;
import com.repackage.yt4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0016J\u0006\u0010!\u001a\u00020 J\u001a\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0005H\u0014J\u0012\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020 H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideActivity;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "Lcom/baidu/tieba/write/write/work/guide/IWorkVideoGuidePresenter;", "()V", "mFrom", "", "getMFrom", "()I", "setMFrom", "(I)V", "mModel", "Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideModel;", "getMModel", "()Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideModel;", "setMModel", "(Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideModel;)V", "mRootView", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mStatus", "getMStatus", "setMStatus", "mView", "Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideView;", "getMView", "()Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideView;", "setMView", "(Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideView;)V", "finishPage", "", "initParmas", "netCallBack", "error", "errorMsg", "", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openUpgrade", InvoiceBuildActivity.EXTRA_PARAMS_ISCHECK, "", "showLog", "write_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class WorkVideoGuideActivity extends BaseFragmentActivity implements uz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WorkVideoGuideModel a;
    public wz8 b;
    public View c;
    public int d;
    public int e;

    public WorkVideoGuideActivity() {
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

    @Override // com.repackage.uz8
    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            n0().C(z);
        }
    }

    @Override // com.repackage.uz8
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            finish();
        }
    }

    @Override // com.repackage.uz8
    public void k0(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            if (i == 0) {
                yt4.k().w("key_work_video_guide_pop", 0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921624, Boolean.TRUE));
                setResult(-1);
                finish();
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.obfuscated_res_0x7f0f0c15);
            }
            p0().F(str);
        }
    }

    public final WorkVideoGuideModel n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WorkVideoGuideModel workVideoGuideModel = this.a;
            if (workVideoGuideModel != null) {
                return workVideoGuideModel;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mModel");
            return null;
        }
        return (WorkVideoGuideModel) invokeV.objValue;
    }

    public final View o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            View view2 = this.c;
            if (view2 != null) {
                return view2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            p0().q();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            View inflate = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d08e6, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(this).inflate(R.lay…deo_guide_activity, null)");
            setMRootView(inflate);
            s0();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            w0(new wz8(pageContext, o0(), this.e, this.d, this));
            t0(new WorkVideoGuideModel(getPageContext(), this));
            setContentView(o0());
            x0();
        }
    }

    public final wz8 p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            wz8 wz8Var = this.b;
            if (wz8Var != null) {
                return wz8Var;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            return null;
        }
        return (wz8) invokeV.objValue;
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.e = getIntent().getIntExtra(WorkPublishGuideActivityConfig.PARAM_WORK_POP_STATUS, 0);
            this.d = getIntent().getIntExtra(WorkPublishGuideActivityConfig.PARAM_WORK_FROM, 0);
        }
    }

    public final void setMRootView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "<set-?>");
            this.c = view2;
        }
    }

    public final void t0(WorkVideoGuideModel workVideoGuideModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, workVideoGuideModel) == null) {
            Intrinsics.checkNotNullParameter(workVideoGuideModel, "<set-?>");
            this.a = workVideoGuideModel;
        }
    }

    public final void w0(wz8 wz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, wz8Var) == null) {
            Intrinsics.checkNotNullParameter(wz8Var, "<set-?>");
            this.b = wz8Var;
        }
    }

    public final void x0() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14364");
            int i2 = this.d;
            if (i2 == WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_HOME_VIDEO) {
                i = 1;
            } else if (i2 == WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_FRS_VIDEO) {
                i = 2;
            } else {
                i = i2 == WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_FRS_WRITE ? 3 : 0;
            }
            statisticItem.param("obj_source", i);
            statisticItem.param("obj_type", this.e);
            TiebaStatic.log(statisticItem);
        }
    }
}
