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
import com.baidu.tbadk.RobotMallConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.cjb;
import com.baidu.tieba.gbc;
import com.baidu.tieba.gy8;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.msgtab.obs.MainTabChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.obs.NotificationChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.MsgCenterContainerFragment;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgCenterContainerView;
import com.baidu.tieba.lbc;
import com.baidu.tieba.mbc;
import com.baidu.tieba.mn6;
import com.baidu.tieba.nf8;
import com.baidu.tieba.ofc;
import com.baidu.tieba.qpa;
import com.baidu.tieba.qu8;
import com.baidu.tieba.rx8;
import com.baidu.tieba.sac;
import com.baidu.tieba.t55;
import com.baidu.tieba.tfc;
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
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000f\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0#J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010'H\u0017J\b\u0010.\u001a\u00020%H\u0016J\b\u0010/\u001a\u00020%H\u0016J\b\u00100\u001a\u00020%H\u0016J\b\u00101\u001a\u00020%H\u0016J\b\u00102\u001a\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R2\u0010\u0017\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\n0\n \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\n0\n\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/tracker/interfaces/ITraceable;", "()V", "ROBOT_MALL_EMTRANCE_EXPLORE", "", "SOURCE_FROM_BOTTOM_NAVIGATION", "SOURCE_FROM_FRS", "SOURCE_FROM_PUSH_OTHER", "isFirstEnter", "", "mBdUniqueId", "Lcom/baidu/adp/BdUniqueId;", "kotlin.jvm.PlatformType", "mChannelListChangedListener", "com/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment$mChannelListChangedListener$1", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/MsgCenterContainerFragment$mChannelListChangedListener$1;", "mDataChangedBs", "Lrx/subjects/BehaviorSubject;", "", "Lcom/baidu/tieba/immessagecenter/msgtab/data/NavigationData;", "getMDataChangedBs", "()Lrx/subjects/BehaviorSubject;", "mFragmentVisibleBs", "mHasCallInitMethod", "mRootView", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgCenterContainerView;", "mSubscription", "Lrx/subscriptions/CompositeSubscription;", "getCurrentPageKey", "", "getFrom", "getScene", "getTraceId", "getVisibleObs", "Lrx/Observable;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onPrimary", "onResume", "setRobotMallStatistic", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgCenterContainerFragment extends BaseFragment implements qpa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MsgCenterContainerView a;
    public tfc b;
    public final ofc<List<qu8>> c;
    public final ofc<Boolean> d;
    public final BdUniqueId e;
    public final int f;
    public boolean g;
    public final int h;
    public final int i;
    public final int j;
    public boolean k;
    public final a l;

    public static final Boolean e2(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bool)) == null) ? bool : (Boolean) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "a079" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qpa
    public String getScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "msgTab" : (String) invokeV.objValue;
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
                    msgCenterContainerView.g0();
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
        ofc<List<qu8>> Q = ofc.Q();
        Intrinsics.checkNotNullExpressionValue(Q, "create()");
        this.c = Q;
        this.d = ofc.R(Boolean.FALSE);
        this.e = BdUniqueId.gen();
        this.f = 1;
        this.h = 1;
        this.i = 2;
        this.j = 3;
        this.k = true;
        this.l = new a(this);
    }

    public final void g2() {
        RobotMallConfig robotMallConfig;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (robotMallConfig = TbSingleton.getInstance().getRobotMallConfig()) != null && gy8.a() && !cjb.a(robotMallConfig.getAiChatEntranceImage()) && !cjb.a(robotMallConfig.getAiChatEntranceUrl())) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ROBOT_MALL_ENTRANCE_EXPLORE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.f));
        }
    }

    public static final void d2(Pair pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, pair) == null) {
            rx8 rx8Var = rx8.a;
            Object second = pair.getSecond();
            Intrinsics.checkNotNullExpressionValue(second, "it.second");
            rx8Var.j((List) second);
        }
    }

    public static final void Z1(MsgCenterContainerFragment this$0, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, num) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (num != null && num.intValue() == 3) {
                MsgCenterContainerView msgCenterContainerView = this$0.a;
                if (msgCenterContainerView != null) {
                    msgCenterContainerView.f0();
                }
                if (this$0.k) {
                    this$0.k = false;
                    MsgCenterContainerView msgCenterContainerView2 = this$0.a;
                    if (msgCenterContainerView2 != null) {
                        msgCenterContainerView2.h0();
                    }
                }
                MsgCenterContainerView msgCenterContainerView3 = this$0.a;
                if (msgCenterContainerView3 != null) {
                    msgCenterContainerView3.i0();
                    return;
                }
                return;
            }
            MsgCenterContainerView msgCenterContainerView4 = this$0.a;
            if (msgCenterContainerView4 != null) {
                msgCenterContainerView4.h0();
            }
        }
    }

    public static final Pair a2(List list, Boolean bool) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, list, bool)) == null) {
            return new Pair(bool, list);
        }
        return (Pair) invokeLL.objValue;
    }

    public static final Boolean b2(Pair pair, Pair pair2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pair, pair2)) == null) {
            return Boolean.valueOf(Intrinsics.areEqual(pair.getFirst(), pair2.getFirst()));
        }
        return (Boolean) invokeLL.objValue;
    }

    public static final Boolean c2(Pair pair) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pair)) == null) {
            Object first = pair.getFirst();
            Intrinsics.checkNotNullExpressionValue(first, "it.first");
            if (((Boolean) first).booleanValue() && !mn6.a((Collection) pair.getSecond())) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeL.objValue;
    }

    public static final void f2(MsgCenterContainerFragment this$0, Boolean bool) {
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
                    rx8.a.i(this$0.j);
                    this$0.g2();
                }
            }
            if (this$0.getActivity() instanceof MessageCenterActivity) {
                rx8.a.i(this$0.i);
            } else {
                rx8.a.i(this$0.h);
            }
            this$0.g2();
        }
    }

    public final ofc<List<qu8>> X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (ofc) invokeV.objValue;
    }

    public final sac<Boolean> Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            sac<Boolean> g = this.d.a().g();
            Intrinsics.checkNotNullExpressionValue(g, "mFragmentVisibleBs.asObs…().distinctUntilChanged()");
            return g;
        }
        return (sac) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qpa
    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (getActivity() instanceof MessageCenterActivity) {
                return "frs";
            }
            return "msgTab";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qpa
    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return String.valueOf(this.e.getId());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            this.d.onNext(Boolean.FALSE);
            YunDialogManager.onHidden(t55.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Integer num;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            FragmentActivity activity = getActivity();
            Long l = null;
            if (activity != null && (intent = activity.getIntent()) != null) {
                num = Integer.valueOf(intent.getIntExtra(MessageCenterActivityConfig.SELECTED_TAB_ID, 0));
            } else {
                num = null;
            }
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            Intrinsics.checkNotNullExpressionValue(baseFragmentActivity, "baseFragmentActivity");
            if (num != null) {
                l = Long.valueOf(num.intValue());
            }
            this.a = new MsgCenterContainerView(baseFragmentActivity, this, l);
            MessageManager.getInstance().registerListener(this.l);
            tfc tfcVar = new tfc();
            this.b = tfcVar;
            if (tfcVar != null) {
                tfcVar.a(MainTabChangedMonitor.c.a().d().g().H(new gbc() { // from class: com.baidu.tieba.cv8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.gbc
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            MsgCenterContainerFragment.Z1(MsgCenterContainerFragment.this, (Integer) obj);
                        }
                    }
                }));
            }
            tfc tfcVar2 = this.b;
            if (tfcVar2 != null) {
                tfcVar2.a(sac.c(this.c, Y1(), new mbc() { // from class: com.baidu.tieba.fv8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.mbc
                    public final Object call(Object obj, Object obj2) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? MsgCenterContainerFragment.a2((List) obj, (Boolean) obj2) : invokeLL.objValue;
                    }
                }).D(1).h(new mbc() { // from class: com.baidu.tieba.dv8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.mbc
                    public final Object call(Object obj, Object obj2) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? MsgCenterContainerFragment.b2((Pair) obj, (Pair) obj2) : invokeLL.objValue;
                    }
                }).k(new lbc() { // from class: com.baidu.tieba.hv8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.lbc
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? MsgCenterContainerFragment.c2((Pair) obj) : invokeL.objValue;
                    }
                }).w().H(new gbc() { // from class: com.baidu.tieba.kv8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.gbc
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            MsgCenterContainerFragment.d2((Pair) obj);
                        }
                    }
                }));
            }
            tfc tfcVar3 = this.b;
            if (tfcVar3 != null) {
                tfcVar3.a(Y1().k(new lbc() { // from class: com.baidu.tieba.xu8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.lbc
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) {
                            Boolean bool = (Boolean) obj;
                            MsgCenterContainerFragment.e2(bool);
                            return bool;
                        }
                        return invokeL.objValue;
                    }
                }).x().H(new gbc() { // from class: com.baidu.tieba.gv8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.gbc
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            MsgCenterContainerFragment.f2(MsgCenterContainerFragment.this, (Boolean) obj);
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            MsgCenterContainerView msgCenterContainerView = this.a;
            if (msgCenterContainerView != null) {
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return BaseView.L(msgCenterContainerView, requireContext, viewGroup, false, false, 8, null);
            }
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.l);
            nf8.l().c();
            this.a = null;
            tfc tfcVar = this.b;
            if (tfcVar != null) {
                tfcVar.unsubscribe();
            }
            tfc tfcVar2 = this.b;
            if (tfcVar2 != null) {
                tfcVar2.c();
            }
            this.b = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPrimary();
            this.d.onNext(Boolean.valueOf(isPrimary()));
            if (isPrimary()) {
                Context context = getContext();
                if (context != null) {
                    YunDialogManager.onShow(context, t55.l);
                    return;
                }
                return;
            }
            YunDialogManager.onHidden(t55.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        MsgCenterContainerView msgCenterContainerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            NotificationChangedMonitor.c.a().i();
            if ((getActivity() instanceof MessageCenterActivity) && !this.g) {
                this.g = true;
                MsgCenterContainerView msgCenterContainerView2 = this.a;
                if (msgCenterContainerView2 != null) {
                    msgCenterContainerView2.f0();
                }
                MsgCenterContainerView msgCenterContainerView3 = this.a;
                if (msgCenterContainerView3 != null) {
                    msgCenterContainerView3.i0();
                }
            } else if ((isPrimary() || (getActivity() instanceof MessageCenterActivity)) && (msgCenterContainerView = this.a) != null) {
                msgCenterContainerView.R();
            }
            if (getActivity() instanceof MessageCenterActivity) {
                this.d.onNext(Boolean.TRUE);
            } else {
                this.d.onNext(Boolean.valueOf(isPrimary()));
            }
        }
    }
}
