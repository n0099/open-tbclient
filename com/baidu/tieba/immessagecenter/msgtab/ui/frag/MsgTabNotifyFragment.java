package com.baidu.tieba.immessagecenter.msgtab.ui.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.b2c;
import com.baidu.tieba.i2c;
import com.baidu.tieba.immessagecenter.msgtab.obs.NotificationChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.MsgTabNotifyFragment;
import com.baidu.tieba.m2c;
import com.baidu.tieba.n2c;
import com.baidu.tieba.p6c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.ut8;
import com.baidu.tieba.uu8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u001a\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0007\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgTabNotifyFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "()V", "mRootView", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabNotifyFragView;", "mSubscription", "Lrx/Subscription;", "mVisibleStatusBs", "Lrx/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onResume", "onViewCreated", "view", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgTabNotifyFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ut8 a;
    public final p6c<Boolean> b;
    public b2c c;

    public static final Boolean I1(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bool)) == null) ? bool : (Boolean) invokeL.objValue;
    }

    public MsgTabNotifyFragment() {
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
        this.b = p6c.R(Boolean.FALSE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ut8 ut8Var = this.a;
            if (ut8Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                ut8Var = null;
            }
            ut8Var.i();
            super.onDestroyView();
            b2c b2cVar = this.c;
            if (b2cVar != null) {
                b2cVar.unsubscribe();
            }
            this.c = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPause();
            this.b.onNext(Boolean.FALSE);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            NotificationChangedMonitor.c.a().i();
            this.b.onNext(Boolean.TRUE);
        }
    }

    public static final Boolean H1(Boolean parentVisible, Boolean visible) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, parentVisible, visible)) == null) {
            Intrinsics.checkNotNullExpressionValue(parentVisible, "parentVisible");
            if (parentVisible.booleanValue()) {
                Intrinsics.checkNotNullExpressionValue(visible, "visible");
                if (visible.booleanValue()) {
                    z = true;
                    return Boolean.valueOf(z);
                }
            }
            z = false;
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeLL.objValue;
    }

    public static final void J1(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bool) == null) {
            uu8.a.g();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = new ut8(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            ut8 ut8Var = this.a;
            ut8 ut8Var2 = null;
            if (ut8Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                ut8Var = null;
            }
            FragmentActivity fragmentActivity = getFragmentActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivity, "fragmentActivity");
            ut8Var.I(fragmentActivity, viewGroup, false, false);
            ut8 ut8Var3 = this.a;
            if (ut8Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                ut8Var3 = null;
            }
            ut8Var3.b();
            ut8 ut8Var4 = this.a;
            if (ut8Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                ut8Var2 = ut8Var4;
            }
            return ut8Var2.m();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        MsgCenterContainerFragment msgCenterContainerFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, bundle) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            super.onViewCreated(view2, bundle);
            this.b.onNext(Boolean.TRUE);
            Fragment parentFragment = getParentFragment();
            u1c<Boolean> u1cVar = null;
            if (parentFragment instanceof MsgCenterContainerFragment) {
                msgCenterContainerFragment = (MsgCenterContainerFragment) parentFragment;
            } else {
                msgCenterContainerFragment = null;
            }
            if (msgCenterContainerFragment != null) {
                u1cVar = msgCenterContainerFragment.J1();
            }
            this.c = u1c.c(u1cVar, this.b.g(), new n2c() { // from class: com.baidu.tieba.bs8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.n2c
                public final Object call(Object obj, Object obj2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? MsgTabNotifyFragment.H1((Boolean) obj, (Boolean) obj2) : invokeLL.objValue;
                }
            }).k(new m2c() { // from class: com.baidu.tieba.cs8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.m2c
                public final Object call(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) {
                        Boolean bool = (Boolean) obj;
                        MsgTabNotifyFragment.I1(bool);
                        return bool;
                    }
                    return invokeL.objValue;
                }
            }).H(new i2c() { // from class: com.baidu.tieba.as8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.i2c
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        MsgTabNotifyFragment.J1((Boolean) obj);
                    }
                }
            });
        }
    }
}
