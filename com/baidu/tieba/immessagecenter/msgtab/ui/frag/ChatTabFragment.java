package com.baidu.tieba.immessagecenter.msgtab.ui.frag;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.b79;
import com.baidu.tieba.btc;
import com.baidu.tieba.doc;
import com.baidu.tieba.gtc;
import com.baidu.tieba.i89;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.base.core.slice.SliceFragment;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.tieba.immessagecenter.msgtab.obs.MainTabChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.obs.NotificationChangedMonitor;
import com.baidu.tieba.immessagecenter.msgtab.ui.frag.ChatTabFragment;
import com.baidu.tieba.immessagecenter.msgtab.ui.prenster.PopActionChatPresenter;
import com.baidu.tieba.immessagecenter.msgtab.ui.slice.MsgChatCenterNavSlice;
import com.baidu.tieba.immessagecenter.msgtab.ui.slice.MsgChatCenterSlice;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView;
import com.baidu.tieba.l4b;
import com.baidu.tieba.na9;
import com.baidu.tieba.qa9;
import com.baidu.tieba.roc;
import com.baidu.tieba.t69;
import com.baidu.tieba.woc;
import com.baidu.tieba.xoc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u000289B\u0005¢\u0006\u0002\u0010\u0004J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\u0012\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0016J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010.\u001a\u00020 H\u0016J\b\u0010/\u001a\u00020 H\u0016J\u0010\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020 H\u0016J\b\u00103\u001a\u00020 H\u0016J\u0010\u00104\u001a\u00020 2\u0006\u00105\u001a\u00020\nH\u0014J\u001a\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020)2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0012\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\n0\n \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\n0\n\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/ChatTabFragment;", "Lcom/baidu/tieba/im/base/core/slice/SliceFragment;", "Lcom/baidu/tbadk/core/view/NoNetworkView$NetworkChangeListener;", "Lcom/baidu/tieba/tracker/interfaces/ITraceable;", "()V", "binding", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/ChatTabFragment$Binding;", "chatSlice", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/slice/MsgChatCenterSlice;", "hasRenderData", "", "mBdUniqueId", "Lcom/baidu/adp/BdUniqueId;", "kotlin.jvm.PlatformType", "mRenderCallBack", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/listener/MsgChatDataChangedCallBack;", "mSubscribes", "Lrx/subscriptions/CompositeSubscription;", "mVisibleStatusBs", "Lrx/subjects/BehaviorSubject;", "noDataNotificationView", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/frag/ChatTabFragment$NoDataNotificationView;", AiBotChatDispatcher.AI_SINGLE_FROM, "", "popActionController", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/prenster/PopActionChatPresenter;", "getIntent", "Landroid/content/Intent;", "getTraceId", "getTraceScene", "getTraceSource", "initPushPermission", "", "initSubSlice", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "onDestroyView", "onNetworkChange", "hasNetwork", MissionEvent.MESSAGE_PAUSE, "onResume", "onUserChanged", "isLogin", "onViewCreated", "view", "Binding", "NoDataNotificationView", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatTabFragment extends SliceFragment implements NoNetworkView.b, l4b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a e;
    public MsgChatCenterSlice f;
    public String g;
    public gtc h;
    public final BdUniqueId i;
    public final btc<Boolean> j;
    public b k;
    public boolean l;
    public final i89 m;

    public static final Boolean Q2(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bool)) == null) ? bool : (Boolean) invokeL.objValue;
    }

    @Override // com.baidu.tieba.l4b
    public String l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "msg_center_chat_tab_landing_page" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l4b
    public String z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? "msg_tab" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final C0347a f;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public FrameLayout b;
        public FrameLayout c;
        public NoNetworkView d;
        public FrameLayout e;

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
            f = new C0347a(null);
        }

        /* renamed from: com.baidu.tieba.immessagecenter.msgtab.ui.frag.ChatTabFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0347a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ C0347a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public C0347a() {
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
                    aVar.f((FrameLayout) root.findViewById(R.id.obfuscated_res_0x7f09189a));
                    aVar.e((FrameLayout) root.findViewById(R.id.obfuscated_res_0x7f091899));
                    aVar.g((NoNetworkView) root.findViewById(R.id.obfuscated_res_0x7f09189b));
                    aVar.h((FrameLayout) root.findViewById(R.id.obfuscated_res_0x7f0918c6));
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

        public final FrameLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.e;
            }
            return (FrameLayout) invokeV.objValue;
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

        public final void h(FrameLayout frameLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, frameLayout) == null) {
                this.e = frameLayout;
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
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TbPageContext<?> a;
        public final FrameLayout b;
        public t69 c;

        public b(TbPageContext<?> pageContext, FrameLayout viewContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pageContext, viewContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            Intrinsics.checkNotNullParameter(viewContainer, "viewContainer");
            this.a = pageContext;
            this.b = viewContainer;
        }

        public static final void d(b this$0) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.a();
            }
        }

        public final void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
                t69 t69Var = this.c;
                if (t69Var != null) {
                    t69Var.b(i, true);
                }
            }
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.setVisibility(8);
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.c == null) {
                    t69 t69Var = new t69(this.a, true);
                    this.c = t69Var;
                    Intrinsics.checkNotNull(t69Var);
                    t69Var.c(new t69.a() { // from class: com.baidu.tieba.h89
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.t69.a
                        public final void onClose() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                ChatTabFragment.b.d(ChatTabFragment.b.this);
                            }
                        }
                    });
                    FrameLayout frameLayout = this.b;
                    t69 t69Var2 = this.c;
                    Intrinsics.checkNotNull(t69Var2);
                    frameLayout.addView(t69Var2.a());
                }
                this.b.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements i89 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatTabFragment a;

        public c(ChatTabFragment chatTabFragment) {
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

        @Override // com.baidu.tieba.i89
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.l = z;
            if (z || !t69.d()) {
                b bVar = this.a.k;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            b bVar2 = this.a.k;
            if (bVar2 != null) {
                bVar2.c();
            }
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
        this.j = btc.R(Boolean.FALSE);
        this.m = new c(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        NoNetworkView c2;
        NoNetworkView c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            a aVar = this.e;
            if (aVar != null && (c3 = aVar.c()) != null) {
                c3.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            a aVar2 = this.e;
            if (aVar2 != null && (c2 = aVar2.c()) != null) {
                c2.addNetworkChangeListener(this);
            }
            if (!this.l) {
                NotificationChangedMonitor.c.a().i();
            }
            this.j.onNext(Boolean.TRUE);
        }
    }

    public static final void S2(Pair pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, pair) == null) {
            qa9.a.h(((Boolean) pair.getFirst()).booleanValue());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            super.onUserChanged(z);
            MsgChatCenterSlice msgChatCenterSlice = this.f;
            if (msgChatCenterSlice != null) {
                Intrinsics.checkNotNull(msgChatCenterSlice);
                msgChatCenterSlice.j0(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void p(boolean z) {
        MsgChatCenterSlice msgChatCenterSlice;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (msgChatCenterSlice = this.f) != null) {
            msgChatCenterSlice.h0(z);
        }
    }

    public static final void O2(Ref.ObjectRef chatCenterNavSlice, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, chatCenterNavSlice, num) == null) {
            Intrinsics.checkNotNullParameter(chatCenterNavSlice, "$chatCenterNavSlice");
            MsgChatCenterNavSlice msgChatCenterNavSlice = (MsgChatCenterNavSlice) chatCenterNavSlice.element;
            if (msgChatCenterNavSlice != null) {
                msgChatCenterNavSlice.e0();
            }
        }
    }

    public static final void R2(ChatTabFragment this$0, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, bool) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            na9.a.e();
            MsgChatCenterSlice msgChatCenterSlice = this$0.f;
            if (msgChatCenterSlice != null) {
                msgChatCenterSlice.i0();
            }
        }
    }

    public static final Boolean P2(Boolean parentVisible, Boolean visible) {
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

    public final Intent L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                return activity.getIntent();
            }
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            new b79(this).c();
        }
    }

    @Override // com.baidu.tieba.l4b
    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return String.valueOf(this.i.getId());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MsgChatCenterSliceView e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            MsgChatCenterSlice msgChatCenterSlice = this.f;
            if (msgChatCenterSlice != null && (e0 = msgChatCenterSlice.e0()) != null) {
                e0.z0(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroyView();
            gtc gtcVar = this.h;
            if (gtcVar != null) {
                gtcVar.unsubscribe();
            }
            gtc gtcVar2 = this.h;
            if (gtcVar2 != null) {
                gtcVar2.c();
            }
            this.h = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        NoNetworkView c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            a aVar = this.e;
            if (aVar != null && (c2 = aVar.c()) != null) {
                c2.removeNetworkChangeListener(this);
            }
            this.j.onNext(Boolean.FALSE);
        }
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.baidu.tieba.immessagecenter.msgtab.ui.slice.MsgChatCenterNavSlice, T] */
    public final void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f = new MsgChatCenterSlice(this, L2(), this.g);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            a aVar = this.e;
            Intrinsics.checkNotNull(aVar);
            FrameLayout a2 = aVar.a();
            Intrinsics.checkNotNull(a2);
            MsgChatCenterSlice msgChatCenterSlice = this.f;
            Intrinsics.checkNotNull(msgChatCenterSlice);
            G2(a2, msgChatCenterSlice);
            if (Intrinsics.areEqual(this.g, "MSGTAB")) {
                TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
                Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
                objectRef.element = new MsgChatCenterNavSlice(pageContext);
                a aVar2 = this.e;
                Intrinsics.checkNotNull(aVar2);
                FrameLayout b2 = aVar2.b();
                Intrinsics.checkNotNull(b2);
                G2(b2, (Slice) objectRef.element);
            }
            gtc gtcVar = this.h;
            if (gtcVar != null) {
                gtcVar.a(MainTabChangedMonitor.c.a().d().g().H(new roc() { // from class: com.baidu.tieba.z79
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.roc
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            ChatTabFragment.O2(Ref.ObjectRef.this, (Integer) obj);
                        }
                    }
                }));
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Object obj;
        b bVar;
        MsgCenterContainerFragment msgCenterContainerFragment;
        FrameLayout d;
        MsgChatCenterSliceView e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onActivityCreated(bundle);
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            new PopActionChatPresenter(requireContext);
            Bundle arguments = getArguments();
            doc<Boolean> docVar = null;
            if (arguments != null) {
                obj = arguments.get("FROM");
            } else {
                obj = null;
            }
            this.g = String.valueOf(obj);
            N2();
            M2();
            MsgChatCenterSlice msgChatCenterSlice = this.f;
            if (msgChatCenterSlice != null && (e0 = msgChatCenterSlice.e0()) != null) {
                e0.z0(this.m);
            }
            a aVar = this.e;
            if (aVar != null && (d = aVar.d()) != null) {
                TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
                Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
                bVar = new b(pageContext, d);
            } else {
                bVar = null;
            }
            this.k = bVar;
            gtc gtcVar = this.h;
            if (gtcVar != null) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment instanceof MsgCenterContainerFragment) {
                    msgCenterContainerFragment = (MsgCenterContainerFragment) parentFragment;
                } else {
                    msgCenterContainerFragment = null;
                }
                if (msgCenterContainerFragment != null) {
                    docVar = msgCenterContainerFragment.I2();
                }
                gtcVar.a(doc.c(docVar, this.j.g(), new xoc() { // from class: com.baidu.tieba.f89
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.xoc
                    public final Object a(Object obj2, Object obj3) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj2, obj3)) == null) ? ChatTabFragment.P2((Boolean) obj2, (Boolean) obj3) : invokeLL.objValue;
                    }
                }).k(new woc() { // from class: com.baidu.tieba.a89
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.woc
                    public final Object call(Object obj2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj2)) == null) {
                            Boolean bool = (Boolean) obj2;
                            ChatTabFragment.Q2(bool);
                            return bool;
                        }
                        return invokeL.objValue;
                    }
                }).x().H(new roc() { // from class: com.baidu.tieba.v79
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.roc
                    public final void call(Object obj2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj2) == null) {
                            ChatTabFragment.R2(ChatTabFragment.this, (Boolean) obj2);
                        }
                    }
                }));
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        NoNetworkView c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            a aVar = this.e;
            if (aVar != null && (c2 = aVar.c()) != null) {
                c2.onChangeSkinType(getPageContext(), i);
            }
            b bVar = this.k;
            if (bVar != null) {
                bVar.b(i);
            }
            if (Intrinsics.areEqual("FRS", this.g)) {
                EMManager.from(getView()).setCorner(R.string.J_X19).setBackGroundColor(R.color.CAM_X0201);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View inflate = inflater.inflate(R.layout.obfuscated_res_0x7f0d033e, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…er_tab, container, false)");
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, view2, bundle) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            super.onViewCreated(view2, bundle);
            this.e = a.f.a(view2);
            gtc gtcVar = new gtc();
            this.h = gtcVar;
            if (gtcVar != null) {
                gtcVar.a(NotificationChangedMonitor.c.a().f().H(new roc() { // from class: com.baidu.tieba.s79
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.roc
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            ChatTabFragment.S2((Pair) obj);
                        }
                    }
                }));
            }
            this.j.onNext(Boolean.valueOf(isVisible()));
        }
    }
}
