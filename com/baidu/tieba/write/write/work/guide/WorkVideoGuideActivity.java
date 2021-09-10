package com.baidu.tieba.write.write.work.guide;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.d0.b;
import c.a.r0.c4.u.p.b.a;
import c.a.r0.c4.u.p.b.c;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b6\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J!\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0005R\"\u0010\u0019\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u000fR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001a\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u000fR\"\u00100\u001a\u00020/8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideActivity;", "Lc/a/r0/c4/u/p/b/a;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "", "finishPage", "()V", "initParmas", "", "error", "", "errorMsg", "netCallBack", "(ILjava/lang/String;)V", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", InvoiceBuildActivity.EXTRA_PARAMS_ISCHECK, "openUpgrade", "(Z)V", "showLog", "mFrom", "I", "getMFrom", "()I", "setMFrom", "Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideModel;", "mModel", "Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideModel;", "getMModel", "()Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideModel;", "setMModel", "(Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideModel;)V", "Landroid/view/View;", "mRootView", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mStatus", "getMStatus", "setMStatus", "Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideView;", "mView", "Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideView;", "getMView", "()Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideView;", "setMView", "(Lcom/baidu/tieba/write/write/work/guide/WorkVideoGuideView;)V", "<init>", "write_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class WorkVideoGuideActivity extends BaseFragmentActivity implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mFrom;
    public WorkVideoGuideModel mModel;
    public View mRootView;
    public int mStatus;
    public c mView;

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
            if (i3 == c.a.q0.s.m.c.f14021c) {
                i2 = 1;
            } else if (i3 == c.a.q0.s.m.c.f14023e) {
                i2 = 2;
            } else {
                i2 = i3 == c.a.q0.s.m.c.f14022d ? 3 : 0;
            }
            statisticItem.param("obj_source", i2);
            statisticItem.param("obj_type", this.mStatus);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // c.a.r0.c4.u.p.b.a
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
            if (workVideoGuideModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mModel");
            }
            return workVideoGuideModel;
        }
        return (WorkVideoGuideModel) invokeV.objValue;
    }

    public final View getMRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view = this.mRootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            return view;
        }
        return (View) invokeV.objValue;
    }

    public final int getMStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mStatus : invokeV.intValue;
    }

    public final c getMView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.mView;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public final void initParmas() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mStatus = getIntent().getIntExtra(WorkPublishGuideActivityConfig.PARAM_WORK_POP_STATUS, 0);
            this.mFrom = getIntent().getIntExtra(WorkPublishGuideActivityConfig.PARAM_WORK_FROM, 0);
        }
    }

    @Override // c.a.r0.c4.u.p.b.a
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
                str = getString(R.string.net_error_please_later);
            }
            c cVar = this.mView;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
            }
            cVar.h(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            c cVar = this.mView;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
            }
            cVar.g();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            View inflate = LayoutInflater.from(this).inflate(R.layout.work_video_guide_activity, (ViewGroup) null);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(this…deo_guide_activity, null)");
            this.mRootView = inflate;
            initParmas();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            View view = this.mRootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            this.mView = new c(pageContext, view, this.mStatus, this.mFrom, this);
            this.mModel = new WorkVideoGuideModel(getPageContext(), this);
            View view2 = this.mRootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            setContentView(view2);
            showLog();
        }
    }

    @Override // c.a.r0.c4.u.p.b.a
    public void openUpgrade(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            WorkVideoGuideModel workVideoGuideModel = this.mModel;
            if (workVideoGuideModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mModel");
            }
            workVideoGuideModel.y(z);
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
            this.mModel = workVideoGuideModel;
        }
    }

    public final void setMRootView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            this.mRootView = view;
        }
    }

    public final void setMStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mStatus = i2;
        }
    }

    public final void setMView(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
            this.mView = cVar;
        }
    }
}
