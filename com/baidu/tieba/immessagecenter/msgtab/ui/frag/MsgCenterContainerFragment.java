package com.baidu.tieba.immessagecenter.msgtab.ui.frag;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.fl6;
import com.baidu.tieba.h55;
import com.baidu.tieba.ija;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.msgtab.obs.MainTabChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.obs.NotificationChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.MsgCenterContainerFragment;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgCenterContainerView;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgTabGuide;
import com.baidu.tieba.jja;
import com.baidu.tieba.m1c;
import com.baidu.tieba.op8;
import com.baidu.tieba.q1c;
import com.baidu.tieba.r1c;
import com.baidu.tieba.rb8;
import com.baidu.tieba.rs8;
import com.baidu.tieba.t5c;
import com.baidu.tieba.y0c;
import com.baidu.tieba.y5c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020 H\u0016J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190%J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J&\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010(\u001a\u0004\u0018\u00010)H\u0017J\b\u00100\u001a\u00020'H\u0016J\b\u00101\u001a\u00020'H\u0016J\b\u00102\u001a\u00020'H\u0016J\b\u00103\u001a\u00020'H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R2\u0010\u0018\u001a&\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00190\u0019 \u000e*\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/tracker/interfaces/ITraceable;", "()V", "SOURCE_FROM_BOTTOM_NAVIGATION", "", "getSOURCE_FROM_BOTTOM_NAVIGATION", "()I", "SOURCE_FROM_FRS", "getSOURCE_FROM_FRS", "SOURCE_FROM_PUSH_OTHER", "getSOURCE_FROM_PUSH_OTHER", "mBdUniqueId", "Lcom/baidu/adp/BdUniqueId;", "kotlin.jvm.PlatformType", "mChannelListChangedListener", "com/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment$mChannelListChangedListener$1", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment$mChannelListChangedListener$1;", "mDataChangedBs", "Lrx/subjects/BehaviorSubject;", "", "Lcom/baidu/tieba/immessagecenter/msgtab/data/NavigationData;", "getMDataChangedBs", "()Lrx/subjects/BehaviorSubject;", "mFragmentVisibleBs", "", "mHasCallInitMethod", "mRootView", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgCenterContainerView;", "mSubscription", "Lrx/subscriptions/CompositeSubscription;", "getCurrentPageKey", "", "getFrom", "getScene", "getTraceId", "getVisibleObs", "Lrx/Observable;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onPrimary", "onResume", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgCenterContainerFragment extends BaseFragment implements jja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MsgCenterContainerView a;
    public y5c b;
    public final t5c<List<op8>> c;
    public final t5c<Boolean> d;
    public final BdUniqueId e;
    public boolean f;
    public final int g;
    public final int h;
    public final int i;
    public final a j;

    public static final Boolean Q1(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bool)) == null) ? bool : (Boolean) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a079" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jja
    public String getScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "msgTab" : (String) invokeV.objValue;
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
                    msgCenterContainerView.i0();
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
        t5c<List<op8>> Q = t5c.Q();
        Intrinsics.checkNotNullExpressionValue(Q, "create()");
        this.c = Q;
        this.d = t5c.R(Boolean.FALSE);
        this.e = BdUniqueId.gen();
        this.g = 1;
        this.h = 2;
        this.i = 3;
        this.j = new a(this);
    }

    public static final void P1(Pair pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, pair) == null) {
            rs8 rs8Var = rs8.a;
            Object second = pair.getSecond();
            Intrinsics.checkNotNullExpressionValue(second, "it.second");
            rs8Var.i((List) second);
        }
    }

    public static final void L1(MsgCenterContainerFragment this$0, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, num) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (num != null && num.intValue() == 3) {
                MsgCenterContainerView msgCenterContainerView = this$0.a;
                if (msgCenterContainerView != null) {
                    msgCenterContainerView.h0();
                }
                MsgCenterContainerView msgCenterContainerView2 = this$0.a;
                if (msgCenterContainerView2 != null) {
                    msgCenterContainerView2.k0();
                    return;
                }
                return;
            }
            MsgCenterContainerView msgCenterContainerView3 = this$0.a;
            if (msgCenterContainerView3 != null) {
                msgCenterContainerView3.j0();
            }
        }
    }

    public static final Pair M1(List list, Boolean bool) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, list, bool)) == null) {
            return new Pair(bool, list);
        }
        return (Pair) invokeLL.objValue;
    }

    public static final Boolean N1(Pair pair, Pair pair2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pair, pair2)) == null) {
            return Boolean.valueOf(Intrinsics.areEqual(pair.getFirst(), pair2.getFirst()));
        }
        return (Boolean) invokeLL.objValue;
    }

    public static final Boolean O1(Pair pair) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pair)) == null) {
            Object first = pair.getFirst();
            Intrinsics.checkNotNullExpressionValue(first, "it.first");
            if (((Boolean) first).booleanValue() && !fl6.a((Collection) pair.getSecond())) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeL.objValue;
    }

    public static final void R1(MsgCenterContainerFragment this$0, Boolean bool) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, this$0, bool) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.getActivity() instanceof MessageCenterActivity) {
                FragmentActivity activity = this$0.getActivity();
                boolean z = false;
                if (activity != null && (intent = activity.getIntent()) != null && intent.getIntExtra(MessageCenterActivityConfig.SELECTED_TAB_ID, 0) == 0) {
                    z = true;
                }
                if (!z) {
                    rs8.a.h(this$0.i);
                    return;
                }
            }
            if (this$0.getActivity() instanceof MessageCenterActivity) {
                rs8.a.h(this$0.h);
            } else {
                rs8.a.h(this$0.g);
            }
        }
    }

    public final t5c<List<op8>> J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (t5c) invokeV.objValue;
    }

    public final y0c<Boolean> K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            y0c<Boolean> g = this.d.a().g();
            Intrinsics.checkNotNullExpressionValue(g, "mFragmentVisibleBs.asObs…().distinctUntilChanged()");
            return g;
        }
        return (y0c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jja
    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (getActivity() instanceof MessageCenterActivity) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return String.valueOf(this.e.getId());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            this.d.onNext(Boolean.FALSE);
            YunDialogManager.onHidden(h55.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Integer num;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            ija.c(this, getTraceId(), new Pair[0]);
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            Intrinsics.checkNotNullExpressionValue(baseFragmentActivity, "baseFragmentActivity");
            this.a = new MsgCenterContainerView(baseFragmentActivity, this, null, 4, null);
            FragmentActivity activity = getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                num = Integer.valueOf(intent.getIntExtra(MessageCenterActivityConfig.SELECTED_TAB_ID, 0));
            } else {
                num = null;
            }
            if (num != null && num.intValue() == -2) {
                MsgTabGuide.j.a();
                TbSingleton.MsgUpgradeTips.markHasShown();
            }
            BaseFragmentActivity baseFragmentActivity2 = getBaseFragmentActivity();
            Intrinsics.checkNotNullExpressionValue(baseFragmentActivity2, "baseFragmentActivity");
            this.a = new MsgCenterContainerView(baseFragmentActivity2, this, num);
            MessageManager.getInstance().registerListener(this.j);
            y5c y5cVar = new y5c();
            this.b = y5cVar;
            if (y5cVar != null) {
                y5cVar.a(MainTabChangedMonitor.c.a().d().g().H(new m1c() { // from class: com.baidu.tieba.aq8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.m1c
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            MsgCenterContainerFragment.L1(MsgCenterContainerFragment.this, (Integer) obj);
                        }
                    }
                }));
            }
            y5c y5cVar2 = this.b;
            if (y5cVar2 != null) {
                y5cVar2.a(y0c.c(this.c, K1(), new r1c() { // from class: com.baidu.tieba.dq8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.r1c
                    public final Object call(Object obj, Object obj2) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? MsgCenterContainerFragment.M1((List) obj, (Boolean) obj2) : invokeLL.objValue;
                    }
                }).D(1).h(new r1c() { // from class: com.baidu.tieba.bq8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.r1c
                    public final Object call(Object obj, Object obj2) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? MsgCenterContainerFragment.N1((Pair) obj, (Pair) obj2) : invokeLL.objValue;
                    }
                }).k(new q1c() { // from class: com.baidu.tieba.fq8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.q1c
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? MsgCenterContainerFragment.O1((Pair) obj) : invokeL.objValue;
                    }
                }).w().H(new m1c() { // from class: com.baidu.tieba.iq8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.m1c
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            MsgCenterContainerFragment.P1((Pair) obj);
                        }
                    }
                }));
            }
            y5c y5cVar3 = this.b;
            if (y5cVar3 != null) {
                y5cVar3.a(K1().k(new q1c() { // from class: com.baidu.tieba.vp8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.q1c
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) {
                            Boolean bool = (Boolean) obj;
                            MsgCenterContainerFragment.Q1(bool);
                            return bool;
                        }
                        return invokeL.objValue;
                    }
                }).x().H(new m1c() { // from class: com.baidu.tieba.eq8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.m1c
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            MsgCenterContainerFragment.R1(MsgCenterContainerFragment.this, (Boolean) obj);
                        }
                    }
                }));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @CallSuper
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            MsgCenterContainerView msgCenterContainerView = this.a;
            if (msgCenterContainerView != null) {
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return BaseView.M(msgCenterContainerView, requireContext, viewGroup, false, false, 8, null);
            }
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.j);
            rb8.l().c();
            this.a = null;
            y5c y5cVar = this.b;
            if (y5cVar != null) {
                y5cVar.unsubscribe();
            }
            y5c y5cVar2 = this.b;
            if (y5cVar2 != null) {
                y5cVar2.c();
            }
            this.b = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPrimary();
            this.d.onNext(Boolean.valueOf(isPrimary()));
            if (isPrimary()) {
                Context context = getContext();
                if (context != null) {
                    YunDialogManager.onShow(context, h55.l);
                    return;
                }
                return;
            }
            YunDialogManager.onHidden(h55.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        MsgCenterContainerView msgCenterContainerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            NotificationChangedMonitor.c.a().i();
            if ((getActivity() instanceof MessageCenterActivity) && !this.f) {
                this.f = true;
                MsgCenterContainerView msgCenterContainerView2 = this.a;
                if (msgCenterContainerView2 != null) {
                    msgCenterContainerView2.h0();
                }
                MsgCenterContainerView msgCenterContainerView3 = this.a;
                if (msgCenterContainerView3 != null) {
                    msgCenterContainerView3.k0();
                }
            } else if ((isPrimary() || (getActivity() instanceof MessageCenterActivity)) && (msgCenterContainerView = this.a) != null) {
                msgCenterContainerView.T();
            }
            if (getActivity() instanceof MessageCenterActivity) {
                this.d.onNext(Boolean.TRUE);
            } else {
                this.d.onNext(Boolean.valueOf(isPrimary()));
            }
        }
    }
}
