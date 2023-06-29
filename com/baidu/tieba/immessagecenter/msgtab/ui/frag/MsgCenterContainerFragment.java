package com.baidu.tieba.immessagecenter.msgtab.ui.frag;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.c65;
import com.baidu.tieba.c98;
import com.baidu.tieba.d65;
import com.baidu.tieba.etb;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.msgtab.obs.MainTabChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.obs.NotificationChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.MsgCenterContainerFragment;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgCenterContainerView;
import com.baidu.tieba.ltb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0017J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "()V", "mChannelListChangedListener", "com/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment$mChannelListChangedListener$1", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment$mChannelListChangedListener$1;", "mHasCallInitMethod", "", "mRootView", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgCenterContainerView;", "mSubscription", "Lrx/Subscription;", "getCurrentPageKey", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onPrimary", "onResume", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgCenterContainerFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MsgCenterContainerView a;
    public etb b;
    public boolean c;
    public final a d;

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.cs5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a079" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgCenterContainerFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MsgCenterContainerFragment msgCenterContainerFragment) {
            super(2921811);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgCenterContainerFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgCenterContainerFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                MsgCenterContainerView msgCenterContainerView = this.a.a;
                if (msgCenterContainerView != null) {
                    msgCenterContainerView.f0();
                }
            }
        }
    }

    public MsgCenterContainerFragment() {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.d);
            c98.l().c();
            this.a = null;
            etb etbVar = this.b;
            if (etbVar != null) {
                etbVar.unsubscribe();
            }
            this.b = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPause();
            MsgCenterContainerView msgCenterContainerView = this.a;
            if (msgCenterContainerView != null) {
                msgCenterContainerView.h0(false);
            }
            d65.n(c65.l);
        }
    }

    public static final void I1(MsgCenterContainerFragment this$0, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, num) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (num != null && num.intValue() == 3) {
                MsgCenterContainerView msgCenterContainerView = this$0.a;
                if (msgCenterContainerView != null) {
                    msgCenterContainerView.e0();
                }
                MsgCenterContainerView msgCenterContainerView2 = this$0.a;
                if (msgCenterContainerView2 != null) {
                    msgCenterContainerView2.i0();
                    return;
                }
                return;
            }
            MsgCenterContainerView msgCenterContainerView3 = this$0.a;
            if (msgCenterContainerView3 != null) {
                msgCenterContainerView3.g0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            Intrinsics.checkNotNullExpressionValue(baseFragmentActivity, "baseFragmentActivity");
            this.a = new MsgCenterContainerView(baseFragmentActivity, this);
            MessageManager.getInstance().registerListener(this.d);
            this.b = MainTabChangedMonitor.c.a().d().g().F(new ltb() { // from class: com.baidu.tieba.km8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ltb
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        MsgCenterContainerFragment.I1(MsgCenterContainerFragment.this, (Integer) obj);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @CallSuper
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            MsgCenterContainerView msgCenterContainerView = this.a;
            if (msgCenterContainerView != null) {
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return BaseView.H(msgCenterContainerView, requireContext, viewGroup, false, false, 8, null);
            }
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                MsgCenterContainerView msgCenterContainerView = this.a;
                if (msgCenterContainerView != null) {
                    msgCenterContainerView.h0(true);
                }
                Context context = getContext();
                if (context != null) {
                    d65.o(context, c65.l);
                    return;
                }
                return;
            }
            MsgCenterContainerView msgCenterContainerView2 = this.a;
            if (msgCenterContainerView2 != null) {
                msgCenterContainerView2.h0(false);
            }
            d65.n(c65.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        MsgCenterContainerView msgCenterContainerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            NotificationChangedMonitor.c.a().i();
            MsgCenterContainerView msgCenterContainerView2 = this.a;
            if (msgCenterContainerView2 != null) {
                msgCenterContainerView2.h0(true);
            }
            if ((getActivity() instanceof MessageCenterActivity) && !this.c) {
                this.c = true;
                MsgCenterContainerView msgCenterContainerView3 = this.a;
                if (msgCenterContainerView3 != null) {
                    msgCenterContainerView3.e0();
                }
                MsgCenterContainerView msgCenterContainerView4 = this.a;
                if (msgCenterContainerView4 != null) {
                    msgCenterContainerView4.i0();
                }
            } else if ((isPrimary() || (getActivity() instanceof MessageCenterActivity)) && (msgCenterContainerView = this.a) != null) {
                msgCenterContainerView.Q();
            }
        }
    }
}
