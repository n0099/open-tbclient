package com.baidu.tieba.write.write.work.guide;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.s.g0.b;
import c.a.r0.s.n.d;
import c.a.s0.n4.e0.p.w.c;
import c.a.s0.n4.e0.p.w.e;
import c.a.s0.n4.h;
import c.a.s0.n4.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WorkPublishGuideActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0016J\u0006\u0010!\u001a\u00020 J\u001a\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0005H\u0014J\u0012\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020 H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideActivity;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "Lcom/baidu/tieba/write/write/work/guide/IWorkVideoGuidePresenter;", "()V", "mFrom", "", "getMFrom", "()I", "setMFrom", "(I)V", "mModel", "Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideModel;", "getMModel", "()Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideModel;", "setMModel", "(Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideModel;)V", "mRootView", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mStatus", "getMStatus", "setMStatus", "mView", "Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideView;", "getMView", "()Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideView;", "setMView", "(Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideView;)V", "finishPage", "", "initParmas", "netCallBack", "error", "errorMsg", "", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openUpgrade", InvoiceBuildActivity.EXTRA_PARAMS_ISCHECK, "", "showLog", "write_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class WorkVideoGuideActivity extends BaseFragmentActivity implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mFrom;
    public WorkVideoGuideModel mModel;
    public View mRootView;
    public int mStatus;
    public e mView;

    public WorkVideoGuideActivity() {
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

    private final void showLog() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14364");
            int i3 = this.mFrom;
            if (i3 == d.f13180d) {
                i2 = 1;
            } else if (i3 == d.f13182f) {
                i2 = 2;
            } else {
                i2 = i3 == d.f13181e ? 3 : 0;
            }
            statisticItem.param("obj_source", i2);
            statisticItem.param("obj_type", this.mStatus);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // c.a.s0.n4.e0.p.w.c
    public void finishPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            finish();
        }
    }

    public final int getMFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFrom : invokeV.intValue;
    }

    public final WorkVideoGuideModel getMModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            WorkVideoGuideModel workVideoGuideModel = this.mModel;
            if (workVideoGuideModel != null) {
                return workVideoGuideModel;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mModel");
            return null;
        }
        return (WorkVideoGuideModel) invokeV.objValue;
    }

    public final View getMRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view = this.mRootView;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final int getMStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mStatus : invokeV.intValue;
    }

    public final e getMView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            e eVar = this.mView;
            if (eVar != null) {
                return eVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            return null;
        }
        return (e) invokeV.objValue;
    }

    public final void initParmas() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mStatus = getIntent().getIntExtra(WorkPublishGuideActivityConfig.PARAM_WORK_POP_STATUS, 0);
            this.mFrom = getIntent().getIntExtra(WorkPublishGuideActivityConfig.PARAM_WORK_FROM, 0);
        }
    }

    @Override // c.a.s0.n4.e0.p.w.c
    public void netCallBack(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, str) == null) {
            if (i2 == 0) {
                b.j().v("key_work_video_guide_pop", 0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921624, Boolean.TRUE));
                setResult(-1);
                finish();
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = getString(j.net_error_please_later);
            }
            getMView().F(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            getMView().q();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            View inflate = LayoutInflater.from(this).inflate(h.work_video_guide_activity, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(this).inflate(R.lay…deo_guide_activity, null)");
            setMRootView(inflate);
            initParmas();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            setMView(new e(pageContext, getMRootView(), this.mStatus, this.mFrom, this));
            setMModel(new WorkVideoGuideModel(getPageContext(), this));
            setContentView(getMRootView());
            showLog();
        }
    }

    @Override // c.a.s0.n4.e0.p.w.c
    public void openUpgrade(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            getMModel().y(z);
        }
    }

    public final void setMFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.mFrom = i2;
        }
    }

    public final void setMModel(WorkVideoGuideModel workVideoGuideModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, workVideoGuideModel) == null) {
            Intrinsics.checkNotNullParameter(workVideoGuideModel, "<set-?>");
            this.mModel = workVideoGuideModel;
        }
    }

    public final void setMRootView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.mRootView = view;
        }
    }

    public final void setMStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mStatus = i2;
        }
    }

    public final void setMView(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            Intrinsics.checkNotNullParameter(eVar, "<set-?>");
            this.mView = eVar;
        }
    }
}
