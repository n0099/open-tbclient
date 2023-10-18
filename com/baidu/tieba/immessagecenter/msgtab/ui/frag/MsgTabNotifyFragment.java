package com.baidu.tieba.immessagecenter.msgtab.ui.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.a7c;
import com.baidu.tieba.b7c;
import com.baidu.tieba.fbc;
import com.baidu.tieba.h6c;
import com.baidu.tieba.immessagecenter.msgtab.obs.NotificationChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.MsgTabNotifyFragment;
import com.baidu.tieba.o6c;
import com.baidu.tieba.pma;
import com.baidu.tieba.ut8;
import com.baidu.tieba.v6c;
import com.baidu.tieba.xs8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u001a\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u000b\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\r0\r \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\r0\r\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgTabNotifyFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/tracker/interfaces/ITraceable;", "()V", "mBdUniqueId", "Lcom/baidu/adp/BdUniqueId;", "kotlin.jvm.PlatformType", "mRootView", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabNotifyFragView;", "mSubscription", "Lrx/Subscription;", "mVisibleStatusBs", "Lrx/subjects/BehaviorSubject;", "", "getTraceId", "", "getTraceScene", "getTraceSource", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onResume", "onViewCreated", "view", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgTabNotifyFragment extends BaseFragment implements pma {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xs8 a;
    public final fbc<Boolean> b;
    public o6c c;
    public final BdUniqueId d;

    public static final Boolean d2(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bool)) == null) ? bool : (Boolean) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pma
    public String I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "msg_center_notify_tab_landing_page" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pma
    public String V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "msg_tab" : (String) invokeV.objValue;
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
        this.b = fbc.R(Boolean.FALSE);
        this.d = BdUniqueId.gen();
    }

    @Override // com.baidu.tieba.pma
    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return String.valueOf(this.d.getId());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            xs8 xs8Var = this.a;
            if (xs8Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                xs8Var = null;
            }
            xs8Var.g();
            super.onDestroyView();
            o6c o6cVar = this.c;
            if (o6cVar != null) {
                o6cVar.unsubscribe();
            }
            this.c = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
            this.b.onNext(Boolean.FALSE);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            NotificationChangedMonitor.c.a().i();
            this.b.onNext(Boolean.TRUE);
        }
    }

    public static final Boolean c2(Boolean parentVisible, Boolean visible) {
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

    public static final void e2(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bool) == null) {
            ut8.a.g();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = new xs8(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            xs8 xs8Var = this.a;
            xs8 xs8Var2 = null;
            if (xs8Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                xs8Var = null;
            }
            FragmentActivity fragmentActivity = getFragmentActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivity, "fragmentActivity");
            xs8Var.L(fragmentActivity, viewGroup, false, false);
            xs8 xs8Var3 = this.a;
            if (xs8Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                xs8Var3 = null;
            }
            xs8Var3.b();
            xs8 xs8Var4 = this.a;
            if (xs8Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                xs8Var2 = xs8Var4;
            }
            return xs8Var2.n();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        MsgCenterContainerFragment msgCenterContainerFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, bundle) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            super.onViewCreated(view2, bundle);
            this.b.onNext(Boolean.valueOf(isVisible()));
            Fragment parentFragment = getParentFragment();
            h6c<Boolean> h6cVar = null;
            if (parentFragment instanceof MsgCenterContainerFragment) {
                msgCenterContainerFragment = (MsgCenterContainerFragment) parentFragment;
            } else {
                msgCenterContainerFragment = null;
            }
            if (msgCenterContainerFragment != null) {
                h6cVar = msgCenterContainerFragment.e2();
            }
            this.c = h6c.c(h6cVar, this.b.g(), new b7c() { // from class: com.baidu.tieba.er8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.b7c
                public final Object a(Object obj, Object obj2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? MsgTabNotifyFragment.c2((Boolean) obj, (Boolean) obj2) : invokeLL.objValue;
                }
            }).k(new a7c() { // from class: com.baidu.tieba.fr8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.a7c
                public final Object call(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) {
                        Boolean bool = (Boolean) obj;
                        MsgTabNotifyFragment.d2(bool);
                        return bool;
                    }
                    return invokeL.objValue;
                }
            }).H(new v6c() { // from class: com.baidu.tieba.cr8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.v6c
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        MsgTabNotifyFragment.e2((Boolean) obj);
                    }
                }
            });
        }
    }
}
