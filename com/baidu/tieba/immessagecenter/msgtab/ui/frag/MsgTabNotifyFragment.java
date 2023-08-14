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
import com.baidu.tieba.f1c;
import com.baidu.tieba.ija;
import com.baidu.tieba.immessagecenter.msgtab.obs.NotificationChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.MsgTabNotifyFragment;
import com.baidu.tieba.jja;
import com.baidu.tieba.m1c;
import com.baidu.tieba.q1c;
import com.baidu.tieba.r1c;
import com.baidu.tieba.rs8;
import com.baidu.tieba.sr8;
import com.baidu.tieba.t5c;
import com.baidu.tieba.y0c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u001a\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u000b\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\r0\r \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\r0\r\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgTabNotifyFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/tracker/interfaces/ITraceable;", "()V", "mBdUniqueId", "Lcom/baidu/adp/BdUniqueId;", "kotlin.jvm.PlatformType", "mRootView", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabNotifyFragView;", "mSubscription", "Lrx/Subscription;", "mVisibleStatusBs", "Lrx/subjects/BehaviorSubject;", "", "getFrom", "", "getScene", "getTraceId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", MissionEvent.MESSAGE_PAUSE, "onResume", "onViewCreated", "view", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgTabNotifyFragment extends BaseFragment implements jja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sr8 a;
    public final t5c<Boolean> b;
    public f1c c;
    public final BdUniqueId d;

    public static final Boolean J1(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bool)) == null) ? bool : (Boolean) invokeL.objValue;
    }

    @Override // com.baidu.tieba.jja
    public String getScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "msg_center_notify_tab" : (String) invokeV.objValue;
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
        this.b = t5c.R(Boolean.FALSE);
        this.d = BdUniqueId.gen();
    }

    @Override // com.baidu.tieba.jja
    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle arguments = getArguments();
            if (Intrinsics.areEqual("FRS", (arguments == null || (r0 = arguments.getString("FROM")) == null) ? "unknown" : "unknown")) {
                return "frs";
            }
            return "msgTab";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jja
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
            sr8 sr8Var = this.a;
            if (sr8Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                sr8Var = null;
            }
            sr8Var.i();
            super.onDestroyView();
            f1c f1cVar = this.c;
            if (f1cVar != null) {
                f1cVar.unsubscribe();
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

    public static final Boolean I1(Boolean parentVisible, Boolean visible) {
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

    public static final void K1(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bool) == null) {
            rs8.a.g();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = new sr8(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            ija.d(this, new Pair[0]);
            sr8 sr8Var = this.a;
            sr8 sr8Var2 = null;
            if (sr8Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                sr8Var = null;
            }
            FragmentActivity fragmentActivity = getFragmentActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivity, "fragmentActivity");
            sr8Var.J(fragmentActivity, viewGroup, false, false);
            sr8 sr8Var3 = this.a;
            if (sr8Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                sr8Var3 = null;
            }
            sr8Var3.c();
            sr8 sr8Var4 = this.a;
            if (sr8Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                sr8Var2 = sr8Var4;
            }
            return sr8Var2.m();
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
            y0c<Boolean> y0cVar = null;
            if (parentFragment instanceof MsgCenterContainerFragment) {
                msgCenterContainerFragment = (MsgCenterContainerFragment) parentFragment;
            } else {
                msgCenterContainerFragment = null;
            }
            if (msgCenterContainerFragment != null) {
                y0cVar = msgCenterContainerFragment.K1();
            }
            this.c = y0c.c(y0cVar, this.b.g(), new r1c() { // from class: com.baidu.tieba.yp8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.r1c
                public final Object call(Object obj, Object obj2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? MsgTabNotifyFragment.I1((Boolean) obj, (Boolean) obj2) : invokeLL.objValue;
                }
            }).k(new q1c() { // from class: com.baidu.tieba.zp8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.q1c
                public final Object call(Object obj) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) {
                        Boolean bool = (Boolean) obj;
                        MsgTabNotifyFragment.J1(bool);
                        return bool;
                    }
                    return invokeL.objValue;
                }
            }).H(new m1c() { // from class: com.baidu.tieba.wp8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.m1c
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        MsgTabNotifyFragment.K1((Boolean) obj);
                    }
                }
            });
        }
    }
}
