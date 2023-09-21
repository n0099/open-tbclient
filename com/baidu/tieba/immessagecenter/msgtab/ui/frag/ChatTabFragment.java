package com.baidu.tieba.immessagecenter.msgtab.ui.frag;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ddc;
import com.baidu.tieba.edc;
import com.baidu.tieba.fx8;
import com.baidu.tieba.ghc;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.base.core.slice.SliceFragment;
import com.baidu.tieba.immessagecenter.mention.base.NotificationView;
import com.baidu.tieba.immessagecenter.msgtab.obs.MainTabChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.ChatTabFragment;
import com.baidu.tieba.immessagecenter.msgtab.ui.prenster.PopActionChatPresenter;
import com.baidu.tieba.immessagecenter.msgtab.ui.slice.MsgChatCenterNavSlice;
import com.baidu.tieba.immessagecenter.msgtab.ui.slice.MsgChatCenterSlice;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView;
import com.baidu.tieba.ix8;
import com.baidu.tieba.kcc;
import com.baidu.tieba.kz8;
import com.baidu.tieba.lhc;
import com.baidu.tieba.mz8;
import com.baidu.tieba.tv8;
import com.baidu.tieba.xra;
import com.baidu.tieba.ycc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00018B\u0005¢\u0006\u0002\u0010\u0004J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\u0012\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0016J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010.\u001a\u00020 H\u0016J\b\u0010/\u001a\u00020 H\u0016J\u0010\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020 H\u0016J\b\u00103\u001a\u00020 H\u0016J\u0010\u00104\u001a\u00020 2\u0006\u00105\u001a\u00020\nH\u0014J\u001a\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020)2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0012\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\n0\n \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\n0\n\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/ChatTabFragment;", "Lcom/baidu/tieba/im/base/core/slice/SliceFragment;", "Lcom/baidu/tbadk/core/view/NoNetworkView$NetworkChangeListener;", "Lcom/baidu/tieba/tracker/interfaces/ITraceable;", "()V", "binding", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/ChatTabFragment$Binding;", "chatSlice", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/slice/MsgChatCenterSlice;", "hasRenderData", "", "mBdUniqueId", "Lcom/baidu/adp/BdUniqueId;", "kotlin.jvm.PlatformType", "mRenderCallBack", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/listener/MsgChatDataChangedCallBack;", "mSubscribes", "Lrx/subscriptions/CompositeSubscription;", "mVisibleStatusBs", "Lrx/subjects/BehaviorSubject;", "pageSource", "", "popActionController", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/prenster/PopActionChatPresenter;", "refreshNotificationRunnable", "Ljava/lang/Runnable;", "getIntent", "Landroid/content/Intent;", "getTraceFrom", "getTraceId", "getTraceScene", "initPushPermission", "", "initSubSlice", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", "onNetworkChange", "hasNetwork", MissionEvent.MESSAGE_PAUSE, "onResume", "onUserChanged", "isLogin", "onViewCreated", "view", "Binding", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatTabFragment extends SliceFragment implements NoNetworkView.b, xra {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a e;
    public MsgChatCenterSlice f;
    public String g;
    public lhc h;
    public final BdUniqueId i;
    public final ghc<Boolean> j;
    public boolean k;
    public final fx8 l;
    public final Runnable m;

    public static final Boolean m2(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bool)) == null) ? bool : (Boolean) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xra
    public String V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "msg_center_chat_tab" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final C0346a f;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public FrameLayout b;
        public FrameLayout c;
        public NoNetworkView d;
        public NotificationView e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1639256297, "Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/ChatTabFragment$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1639256297, "Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/ChatTabFragment$a;");
                    return;
                }
            }
            f = new C0346a(null);
        }

        /* renamed from: com.baidu.tieba.immessagecenter.msgtab.ui.frag.ChatTabFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0346a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ C0346a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public C0346a() {
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

            public final a a(View root) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, root)) == null) {
                    Intrinsics.checkNotNullParameter(root, "root");
                    a aVar = new a();
                    aVar.i(root);
                    aVar.f((FrameLayout) root.findViewById(R.id.obfuscated_res_0x7f0917ca));
                    aVar.e((FrameLayout) root.findViewById(R.id.obfuscated_res_0x7f0917c9));
                    aVar.g((NoNetworkView) root.findViewById(R.id.obfuscated_res_0x7f0917cb));
                    aVar.h((NotificationView) root.findViewById(R.id.obfuscated_res_0x7f0917f4));
                    return aVar;
                }
                return (a) invokeL.objValue;
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final FrameLayout a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c;
            }
            return (FrameLayout) invokeV.objValue;
        }

        public final FrameLayout b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (FrameLayout) invokeV.objValue;
        }

        public final NoNetworkView c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.d;
            }
            return (NoNetworkView) invokeV.objValue;
        }

        public final NotificationView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.e;
            }
            return (NotificationView) invokeV.objValue;
        }

        public final void e(FrameLayout frameLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, frameLayout) == null) {
                this.c = frameLayout;
            }
        }

        public final void f(FrameLayout frameLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, frameLayout) == null) {
                this.b = frameLayout;
            }
        }

        public final void g(NoNetworkView noNetworkView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, noNetworkView) == null) {
                this.d = noNetworkView;
            }
        }

        public final void h(NotificationView notificationView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, notificationView) == null) {
                this.e = notificationView;
            }
        }

        public final void i(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
                this.a = view2;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements fx8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatTabFragment a;

        public b(ChatTabFragment chatTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatTabFragment;
        }

        @Override // com.baidu.tieba.fx8
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.k = z;
            SafeHandler.getInst().postDelayed(this.a.m, 500L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatTabFragment() {
        super(null, 1, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((Slice) objArr[0], ((Integer) objArr[1]).intValue(), (DefaultConstructorMarker) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = "MSGTAB";
        this.i = BdUniqueId.gen();
        this.j = ghc.R(Boolean.FALSE);
        this.l = new b(this);
        this.m = new Runnable() { // from class: com.baidu.tieba.sw8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ChatTabFragment.o2(ChatTabFragment.this);
                }
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void k(boolean z) {
        MsgChatCenterSlice msgChatCenterSlice;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && (msgChatCenterSlice = this.f) != null) {
            msgChatCenterSlice.g0(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            super.onUserChanged(z);
            MsgChatCenterSlice msgChatCenterSlice = this.f;
            if (msgChatCenterSlice != null) {
                Intrinsics.checkNotNull(msgChatCenterSlice);
                msgChatCenterSlice.i0(z);
            }
        }
    }

    public static final void k2(Ref.ObjectRef chatCenterNavSlice, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, chatCenterNavSlice, num) == null) {
            Intrinsics.checkNotNullParameter(chatCenterNavSlice, "$chatCenterNavSlice");
            MsgChatCenterNavSlice msgChatCenterNavSlice = (MsgChatCenterNavSlice) chatCenterNavSlice.element;
            if (msgChatCenterNavSlice != null) {
                msgChatCenterNavSlice.d0();
            }
        }
    }

    public static final void n2(ChatTabFragment this$0, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, bool) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            kz8.a.e();
            MsgChatCenterSlice msgChatCenterSlice = this$0.f;
            if (msgChatCenterSlice != null) {
                msgChatCenterSlice.h0();
            }
        }
    }

    public static final Boolean l2(Boolean parentVisible, Boolean visible) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, parentVisible, visible)) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        NotificationView notificationView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view2, bundle) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            super.onViewCreated(view2, bundle);
            a a2 = a.f.a(view2);
            this.e = a2;
            if (a2 != null) {
                notificationView = a2.d();
            } else {
                notificationView = null;
            }
            new ix8(notificationView);
            this.h = new lhc();
            this.j.onNext(Boolean.valueOf(isVisible()));
        }
    }

    public static final void o2(ChatTabFragment this$0) {
        NotificationView notificationView;
        boolean z;
        NotificationView d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            boolean z2 = true;
            int i = 0;
            if (!this$0.k) {
                a aVar = this$0.e;
                if (aVar != null && (d = aVar.d()) != null && d.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            z2 = (NotificationManagerCompat.from(this$0.getPageContext().getPageActivity()).areNotificationsEnabled() || this$0.k) ? false : false;
            a aVar2 = this$0.e;
            if (aVar2 != null) {
                notificationView = aVar2.d();
            } else {
                notificationView = null;
            }
            if (notificationView != null) {
                if (!z2) {
                    i = 8;
                }
                notificationView.setVisibility(i);
            }
            mz8.a.h(z2);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Object obj;
        MsgCenterContainerFragment msgCenterContainerFragment;
        MsgChatCenterSliceView d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onActivityCreated(bundle);
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            new PopActionChatPresenter(requireContext);
            Bundle arguments = getArguments();
            kcc<Boolean> kccVar = null;
            if (arguments != null) {
                obj = arguments.get("FROM");
            } else {
                obj = null;
            }
            this.g = String.valueOf(obj);
            j2();
            i2();
            MsgChatCenterSlice msgChatCenterSlice = this.f;
            if (msgChatCenterSlice != null && (d0 = msgChatCenterSlice.d0()) != null) {
                d0.F0(this.l);
            }
            lhc lhcVar = this.h;
            if (lhcVar != null) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment instanceof MsgCenterContainerFragment) {
                    msgCenterContainerFragment = (MsgCenterContainerFragment) parentFragment;
                } else {
                    msgCenterContainerFragment = null;
                }
                if (msgCenterContainerFragment != null) {
                    kccVar = msgCenterContainerFragment.e2();
                }
                lhcVar.a(kcc.c(kccVar, this.j.g(), new edc() { // from class: com.baidu.tieba.cx8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.edc
                    public final Object call(Object obj2, Object obj3) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj2, obj3)) == null) ? ChatTabFragment.l2((Boolean) obj2, (Boolean) obj3) : invokeLL.objValue;
                    }
                }).k(new ddc() { // from class: com.baidu.tieba.tw8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.ddc
                    public final Object call(Object obj2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj2)) == null) {
                            Boolean bool = (Boolean) obj2;
                            ChatTabFragment.m2(bool);
                            return bool;
                        }
                        return invokeL.objValue;
                    }
                }).x().H(new ycc() { // from class: com.baidu.tieba.bx8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.ycc
                    public final void call(Object obj2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj2) == null) {
                            ChatTabFragment.n2(ChatTabFragment.this, (Boolean) obj2);
                        }
                    }
                }));
            }
        }
    }

    @Override // com.baidu.tieba.xra
    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Intrinsics.areEqual("FRS", this.g)) {
                return "frs";
            }
            return "msgTab";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xra
    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return String.valueOf(this.i.getId());
        }
        return (String) invokeV.objValue;
    }

    public final Intent h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                return activity.getIntent();
            }
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            new tv8(this).c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MsgChatCenterSliceView d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            MsgChatCenterSlice msgChatCenterSlice = this.f;
            if (msgChatCenterSlice != null && (d0 = msgChatCenterSlice.d0()) != null) {
                d0.F0(null);
            }
            SafeHandler.getInst().removeCallbacks(this.m);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroyView();
            lhc lhcVar = this.h;
            if (lhcVar != null) {
                lhcVar.unsubscribe();
            }
            lhc lhcVar2 = this.h;
            if (lhcVar2 != null) {
                lhcVar2.c();
            }
            this.h = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        NoNetworkView c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPause();
            a aVar = this.e;
            if (aVar != null && (c = aVar.c()) != null) {
                c.removeNetworkChangeListener(this);
            }
            this.j.onNext(Boolean.FALSE);
        }
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.baidu.tieba.immessagecenter.msgtab.ui.slice.MsgChatCenterNavSlice, T] */
    public final void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f = new MsgChatCenterSlice(this, h2(), this.g);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            a aVar = this.e;
            Intrinsics.checkNotNull(aVar);
            FrameLayout a2 = aVar.a();
            Intrinsics.checkNotNull(a2);
            MsgChatCenterSlice msgChatCenterSlice = this.f;
            Intrinsics.checkNotNull(msgChatCenterSlice);
            c2(a2, msgChatCenterSlice);
            if (Intrinsics.areEqual(this.g, "MSGTAB")) {
                TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
                Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
                objectRef.element = new MsgChatCenterNavSlice(pageContext);
                a aVar2 = this.e;
                Intrinsics.checkNotNull(aVar2);
                FrameLayout b2 = aVar2.b();
                Intrinsics.checkNotNull(b2);
                c2(b2, (Slice) objectRef.element);
            }
            lhc lhcVar = this.h;
            if (lhcVar != null) {
                lhcVar.a(MainTabChangedMonitor.c.a().d().g().H(new ycc() { // from class: com.baidu.tieba.dx8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.ycc
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            ChatTabFragment.k2(Ref.ObjectRef.this, (Integer) obj);
                        }
                    }
                }));
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        NotificationView notificationView;
        NotificationView d;
        NoNetworkView c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            a aVar = this.e;
            if (aVar != null && (c = aVar.c()) != null) {
                c.onChangeSkinType(getPageContext(), i);
            }
            a aVar2 = this.e;
            if (aVar2 != null && (d = aVar2.d()) != null) {
                d.a(i);
            }
            if (Intrinsics.areEqual("FRS", this.g)) {
                EMManager.from(getView()).setCorner(R.string.J_X19).setBackGroundColor(R.color.CAM_X0201);
                a aVar3 = this.e;
                if (aVar3 != null) {
                    notificationView = aVar3.d();
                } else {
                    notificationView = null;
                }
                EMManager.from(notificationView).setCorner(R.string.J_X19);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View inflate = inflater.inflate(R.layout.obfuscated_res_0x7f0d0327, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…er_tab, container, false)");
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        NoNetworkView c;
        NoNetworkView c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            a aVar = this.e;
            if (aVar != null && (c2 = aVar.c()) != null) {
                c2.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            a aVar2 = this.e;
            if (aVar2 != null && (c = aVar2.c()) != null) {
                c.addNetworkChangeListener(this);
            }
            this.j.onNext(Boolean.TRUE);
        }
    }
}
