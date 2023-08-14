package com.baidu.tieba.impersonal.slices;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.au8;
import com.baidu.tieba.bu8;
import com.baidu.tieba.cu8;
import com.baidu.tieba.ek8;
import com.baidu.tieba.eu8;
import com.baidu.tieba.feed.list.TemplateAdapter;
import com.baidu.tieba.ft8;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.immessagecenter.slice.SliceFragment;
import com.baidu.tieba.impersonal.components.FadingEdgeRecyclerView;
import com.baidu.tieba.impersonal.databinding.SlicePersonalChatBinding;
import com.baidu.tieba.impersonal.help.CustomSpeedLinearLayoutManager;
import com.baidu.tieba.impersonal.help.MsgDiffCallback;
import com.baidu.tieba.impersonal.slices.ChatListSlice;
import com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor;
import com.baidu.tieba.iv8;
import com.baidu.tieba.jv8;
import com.baidu.tieba.kn;
import com.baidu.tieba.kv8;
import com.baidu.tieba.lg;
import com.baidu.tieba.ot8;
import com.baidu.tieba.rr6;
import com.baidu.tieba.sr6;
import com.baidu.tieba.ur6;
import com.baidu.tieba.ut8;
import com.baidu.tieba.v97;
import com.baidu.tieba.vr6;
import com.baidu.tieba.zt8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002.2\u0018\u0000 U2\u00020\u0001:\u0001UB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020:H\u0002J\b\u0010<\u001a\u00020:H\u0002J\b\u0010=\u001a\u00020:H\u0002J\b\u0010>\u001a\u00020:H\u0007J$\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020:H\u0016J\u0010\u0010H\u001a\u00020:2\u0006\u0010I\u001a\u00020\u001eH\u0016J\u001c\u0010J\u001a\u00020:2\b\u0010K\u001a\u0004\u0018\u00010@2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0010\u0010L\u001a\u00020:2\u0006\u0010M\u001a\u00020\u001eH\u0002J\b\u0010N\u001a\u00020:H\u0002J\u0012\u0010O\u001a\u00020:2\b\b\u0002\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020:H\u0002J\f\u0010S\u001a\u00020\u001e*\u00020TH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000f\u001a\u0004\b(\u0010)R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/R\u000e\u00100\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000f\u001a\u0004\b6\u00107¨\u0006V"}, d2 = {"Lcom/baidu/tieba/impersonal/slices/ChatListSlice;", "Lcom/baidu/tieba/immessagecenter/slice/Slice;", "repo", "Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;", "talkType", "", "talkPrologue", "(Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;Ljava/lang/String;Ljava/lang/String;)V", "binding", "Lcom/baidu/tieba/impersonal/databinding/SlicePersonalChatBinding;", "layoutManager", "Lcom/baidu/tieba/impersonal/help/CustomSpeedLinearLayoutManager;", "getLayoutManager", "()Lcom/baidu/tieba/impersonal/help/CustomSpeedLinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "list", "", "Lcom/baidu/tieba/feed/list/TemplateData;", "loadingView", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/view/LoadingView;", "getLoadingView", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/view/LoadingView;", "loadingView$delegate", "mEntrancePageRepo", "Lcom/baidu/tieba/impersonal/sprite/EntrancePageRepo;", "getMEntrancePageRepo", "()Lcom/baidu/tieba/impersonal/sprite/EntrancePageRepo;", "mEntrancePageRepo$delegate", "mFirstEnterPage", "", "getMFirstEnterPage", "()Z", "setMFirstEnterPage", "(Z)V", "mKeyBoardShowing", "msgArriveCallback", "Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor$MsgCallback;", "notifier", "Lcom/baidu/adp/widget/ListView/RecyclerViewNotifier;", "getNotifier", "()Lcom/baidu/adp/widget/ListView/RecyclerViewNotifier;", "notifier$delegate", "paddingBottom", "", "preFetchCallback", "com/baidu/tieba/impersonal/slices/ChatListSlice$preFetchCallback$1", "Lcom/baidu/tieba/impersonal/slices/ChatListSlice$preFetchCallback$1;", "recyclerState", "sendMsgTransfer", "com/baidu/tieba/impersonal/slices/ChatListSlice$sendMsgTransfer$1", "Lcom/baidu/tieba/impersonal/slices/ChatListSlice$sendMsgTransfer$1;", "templateAdapter", "Lcom/baidu/tieba/feed/list/TemplateAdapter;", "getTemplateAdapter", "()Lcom/baidu/tieba/feed/list/TemplateAdapter;", "templateAdapter$delegate", "dealSoftKey", "", "fetchNextMsg", "fetchPreviousMsg", "firstLoadMsg", "initListener", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "onKeyboardVisibilityChanged", MapBundleKey.MapObjKey.OBJ_SL_VISI, "onViewCreated", "view", "processEnterPage", "haveHistoryMsg", "registerMsgListener", "scrollListToBottom", "duration", "", "scrollToBottomWithoutAnim", "ensureScrollToBottom", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatListSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public static final DiffUtil.ItemCallback<v97<?>> A;
    public transient /* synthetic */ FieldHolder $fh;
    public final iv8 j;
    public final String k;
    public final String l;
    public boolean m;
    public boolean n;
    public SlicePersonalChatBinding o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public int t;
    public final List<v97<?>> u;
    public final int v;
    public final b w;
    public final SpriteMsgProcessor.d x;
    public final c y;
    public final Lazy z;

    /* loaded from: classes6.dex */
    public static final class a extends vr6<cu8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatListSlice b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ChatListSlice chatListSlice, Class<cu8> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatListSlice, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = chatListSlice;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vr6
        public void onEvent(cu8 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (this.b.t == 1) {
                    return;
                }
                ChatListSlice.A0(this.b, 0.0f, 1, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements iv8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatListSlice a;

        @Override // com.baidu.tieba.iv8.b
        public void a(List<? extends ut8> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                Intrinsics.checkNotNullParameter(list, "list");
            }
        }

        @Override // com.baidu.tieba.iv8.b
        public void b(int i, String errorMsg, zt8<?> msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, errorMsg, msg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                Intrinsics.checkNotNullParameter(msg, "msg");
            }
        }

        public b(ChatListSlice chatListSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatListSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatListSlice;
        }

        public static final void f(ChatListSlice this$0) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.f0();
            }
        }

        @Override // com.baidu.tieba.iv8.b
        public void d(String msgKey) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, msgKey) == null) {
                Intrinsics.checkNotNullParameter(msgKey, "msgKey");
                final ChatListSlice chatListSlice = this.a;
                lg.h(new Runnable() { // from class: com.baidu.tieba.nu8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ChatListSlice.b.f(ChatListSlice.this);
                        }
                    }
                }, 300L);
            }
        }

        @Override // com.baidu.tieba.iv8.b
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                if (i == 0) {
                    sr6.b().b(new bu8(2));
                } else {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.obfuscated_res_0x7f0f0e21);
                }
            }
        }

        @Override // com.baidu.tieba.iv8.b
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            this.a.m0().f();
                            return;
                        }
                        return;
                    }
                    this.a.m0().g();
                    return;
                }
                sr6.b().b(new bu8(1));
            }
        }

        @Override // com.baidu.tieba.iv8.b
        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            this.a.m0().i();
                            return;
                        }
                        return;
                    }
                    this.a.m0().j();
                    return;
                }
                sr6.b().b(new bu8(0));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements kv8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatListSlice a;

        public c(ChatListSlice chatListSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatListSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatListSlice;
        }

        @Override // com.baidu.tieba.kv8
        public void a(zt8<au8> msgData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msgData) == null) {
                Intrinsics.checkNotNullParameter(msgData, "msgData");
                this.a.j.t(msgData);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(446611664, "Lcom/baidu/tieba/impersonal/slices/ChatListSlice;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(446611664, "Lcom/baidu/tieba/impersonal/slices/ChatListSlice;");
                return;
            }
        }
        A = new DiffUtil.ItemCallback<v97<?>>() { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$Companion$DIFF_ITEM_CALLBACK$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a */
            public boolean areContentsTheSame(v97<?> oldItem, v97<?> newItem) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, oldItem, newItem)) == null) {
                    Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                    Intrinsics.checkNotNullParameter(newItem, "newItem");
                    if (!(oldItem instanceof ot8) || !(newItem instanceof ot8) || ((ot8) oldItem).f((ot8) newItem)) {
                        return false;
                    }
                    return true;
                }
                return invokeLL.booleanValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b */
            public boolean areItemsTheSame(v97<?> oldItem, v97<?> newItem) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048579, this, oldItem, newItem)) == null) {
                    Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                    Intrinsics.checkNotNullParameter(newItem, "newItem");
                    return Intrinsics.areEqual(oldItem, newItem);
                }
                return invokeLL.booleanValue;
            }
        };
    }

    public final void f0() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.m) {
            Context context = F().getContext();
            FragmentActivity activity = F().getActivity();
            if (activity != null) {
                view2 = activity.getCurrentFocus();
            } else {
                view2 = null;
            }
            BdUtilHelper.hideSoftKeyPad(context, view2);
        }
    }

    public final void j0() {
        ot8 ot8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Object first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.u);
            if (first instanceof ot8) {
                ot8Var = (ot8) first;
            } else {
                ot8Var = null;
            }
            if (ot8Var != null) {
                this.j.b(ot8Var.c().a());
            }
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.j.l();
        }
    }

    public final CustomSpeedLinearLayoutManager l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (CustomSpeedLinearLayoutManager) this.p.getValue();
        }
        return (CustomSpeedLinearLayoutManager) invokeV.objValue;
    }

    public final ek8 m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return (ek8) this.r.getValue();
        }
        return (ek8) invokeV.objValue;
    }

    public final jv8 n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return (jv8) this.z.getValue();
        }
        return (jv8) invokeV.objValue;
    }

    public final kn o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (kn) this.q.getValue();
        }
        return (kn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            this.j.u(null);
            this.j.v();
            this.j.s();
        }
    }

    public final TemplateAdapter p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return (TemplateAdapter) this.s.getValue();
        }
        return (TemplateAdapter) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            SlicePersonalChatBinding slicePersonalChatBinding = this.o;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            slicePersonalChatBinding.b.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ju8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? ChatListSlice.r0(ChatListSlice.this, view2, motionEvent) : invokeLL.booleanValue;
                }
            });
        }
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.j.a(this.w);
            this.j.u(this.x);
            this.j.r();
        }
    }

    public ChatListSlice(iv8 repo, String talkType, String talkPrologue) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {repo, talkType, talkPrologue};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(talkType, "talkType");
        Intrinsics.checkNotNullParameter(talkPrologue, "talkPrologue");
        this.j = repo;
        this.k = talkType;
        this.l = talkPrologue;
        this.n = true;
        this.p = LazyKt__LazyJVMKt.lazy(new Function0<CustomSpeedLinearLayoutManager>(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$layoutManager$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatListSlice this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CustomSpeedLinearLayoutManager invoke() {
                InterceptResult invokeV;
                SliceFragment F;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (CustomSpeedLinearLayoutManager) invokeV.objValue;
                }
                F = this.this$0.F();
                Context requireContext = F.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "host.requireContext()");
                return new CustomSpeedLinearLayoutManager(requireContext);
            }
        });
        this.q = LazyKt__LazyJVMKt.lazy(new Function0<kn>(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$notifier$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatListSlice this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final kn invoke() {
                InterceptResult invokeV;
                SlicePersonalChatBinding slicePersonalChatBinding;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (kn) invokeV.objValue;
                }
                slicePersonalChatBinding = this.this$0.o;
                if (slicePersonalChatBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    slicePersonalChatBinding = null;
                }
                return new kn(slicePersonalChatBinding.b);
            }
        });
        this.r = LazyKt__LazyJVMKt.lazy(new Function0<ek8>(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$loadingView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatListSlice this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ek8 invoke() {
                InterceptResult invokeV;
                SlicePersonalChatBinding slicePersonalChatBinding;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (ek8) invokeV.objValue;
                }
                slicePersonalChatBinding = this.this$0.o;
                if (slicePersonalChatBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    slicePersonalChatBinding = null;
                }
                return new ek8(slicePersonalChatBinding.b);
            }
        });
        this.s = LazyKt__LazyJVMKt.lazy(new Function0<TemplateAdapter>(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$templateAdapter$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatListSlice this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TemplateAdapter invoke() {
                InterceptResult invokeV;
                ChatListSlice.c cVar;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    TemplateAdapter templateAdapter = new TemplateAdapter();
                    cVar = this.this$0.y;
                    templateAdapter.j(new ft8(cVar));
                    return templateAdapter;
                }
                return (TemplateAdapter) invokeV.objValue;
            }
        });
        this.u = new ArrayList();
        this.v = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
        this.w = new b(this);
        this.x = new SpriteMsgProcessor.d() { // from class: com.baidu.tieba.hu8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor.d
            public final void a(long j, List list, SpriteMsgProcessor.f fVar, SpriteMsgProcessor.e eVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), list, fVar, eVar}) == null) {
                    ChatListSlice.s0(ChatListSlice.this, j, list, fVar, eVar);
                }
            }
        };
        this.y = new c(this);
        this.z = LazyKt__LazyJVMKt.lazy(new Function0<jv8>(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$mEntrancePageRepo$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatListSlice this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final jv8 invoke() {
                InterceptResult invokeV;
                SliceFragment F;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (jv8) invokeV.objValue;
                }
                F = this.this$0.F();
                return new jv8(F.getContext(), this.this$0.j);
            }
        });
    }

    public static /* synthetic */ void A0(ChatListSlice chatListSlice, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 100.0f;
        }
        chatListSlice.z0(f);
    }

    public static final void u0(ChatListSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.B0();
        }
    }

    public static final void v0(ChatListSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.j0();
        }
    }

    public static final void w0(ChatListSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.i0();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void Q(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            super.Q(z);
            this.m = z;
            B0();
            SlicePersonalChatBinding slicePersonalChatBinding = this.o;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            FadingEdgeRecyclerView fadingEdgeRecyclerView = slicePersonalChatBinding.b;
            if (z) {
                i = this.v;
            } else {
                i = 0;
            }
            fadingEdgeRecyclerView.setPadding(0, 0, 0, i);
        }
    }

    public final boolean g0(final LinearLayoutManager linearLayoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, linearLayoutManager)) == null) {
            SlicePersonalChatBinding slicePersonalChatBinding = this.o;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            return slicePersonalChatBinding.b.post(new Runnable() { // from class: com.baidu.tieba.iu8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ChatListSlice.h0(LinearLayoutManager.this, this);
                    }
                }
            });
        }
        return invokeL.booleanValue;
    }

    public final void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            n0().b(this.k, this.l, Boolean.valueOf(z));
        }
    }

    public final void z0(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f) == null) {
            l0().a(f);
            SlicePersonalChatBinding slicePersonalChatBinding = this.o;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            slicePersonalChatBinding.b.smoothScrollToPosition(p0().getItemCount() - 1, 0);
        }
    }

    public static final void h0(LinearLayoutManager this_ensureScrollToBottom, ChatListSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, this_ensureScrollToBottom, this$0) == null) {
            Intrinsics.checkNotNullParameter(this_ensureScrollToBottom, "$this_ensureScrollToBottom");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View findViewByPosition = this_ensureScrollToBottom.findViewByPosition(this$0.p0().getItemCount() - 1);
            if (findViewByPosition != null) {
                SlicePersonalChatBinding slicePersonalChatBinding = this$0.o;
                SlicePersonalChatBinding slicePersonalChatBinding2 = null;
                if (slicePersonalChatBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    slicePersonalChatBinding = null;
                }
                int measuredHeight = slicePersonalChatBinding.b.getMeasuredHeight() - findViewByPosition.getMeasuredHeight();
                SlicePersonalChatBinding slicePersonalChatBinding3 = this$0.o;
                if (slicePersonalChatBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    slicePersonalChatBinding2 = slicePersonalChatBinding3;
                }
                this_ensureScrollToBottom.scrollToPositionWithOffset(this$0.p0().getItemCount() - 1, (measuredHeight - slicePersonalChatBinding2.b.getPaddingBottom()) - 10000);
            }
        }
    }

    public static final boolean r0(ChatListSlice this$0, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, this$0, view2, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.f0();
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View O(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            SlicePersonalChatBinding it = SlicePersonalChatBinding.c(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this.o = it;
            return it.getRoot();
        }
        return (View) invokeLLL.objValue;
    }

    public static final void s0(final ChatListSlice this$0, long j, final List msgs, SpriteMsgProcessor.f source, final SpriteMsgProcessor.e loadType) {
        final boolean z;
        final boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{this$0, Long.valueOf(j), msgs, source, loadType}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(msgs, "msgs");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            SlicePersonalChatBinding slicePersonalChatBinding = this$0.o;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            if (slicePersonalChatBinding.b.getLastVisiblePosition() == this$0.p0().getItemCount() - 1) {
                z = true;
            } else {
                z = false;
            }
            if (loadType.getType() != 4 && loadType.getType() != 0 && loadType.getType() != 6 && (!source.a() || !z)) {
                z2 = false;
            } else {
                z2 = true;
            }
            this$0.o0().e(new Runnable() { // from class: com.baidu.tieba.ku8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ChatListSlice.t0(ChatListSlice.this, msgs, loadType, z2, z);
                    }
                }
            });
        }
    }

    public static final void t0(final ChatListSlice this$0, List msgs, SpriteMsgProcessor.e loadType, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{this$0, msgs, loadType, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(msgs, "$msgs");
            Intrinsics.checkNotNullParameter(loadType, "$loadType");
            List<v97<?>> b2 = eu8.a.b(this$0.j, msgs, loadType);
            DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new MsgDiffCallback(this$0.u, b2, A));
            Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(\n         …      )\n                )");
            this$0.u.clear();
            this$0.u.addAll(b2);
            calculateDiff.dispatchUpdatesTo(this$0.p0());
            if (z) {
                if (loadType.getType() == 4 && z2) {
                    A0(this$0, 0.0f, 1, null);
                } else if (loadType.getType() == 0) {
                    lg.c(new Runnable() { // from class: com.baidu.tieba.lu8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                ChatListSlice.u0(ChatListSlice.this);
                            }
                        }
                    });
                } else {
                    this$0.B0();
                }
            }
            if (this$0.n) {
                boolean z3 = false;
                this$0.n = false;
                List<v97<?>> list = this$0.u;
                this$0.x0(true ^ ((list == null || list.isEmpty()) ? true : true));
            }
        }
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SlicePersonalChatBinding slicePersonalChatBinding = this.o;
            LinearLayoutManager linearLayoutManager = null;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            RecyclerView.LayoutManager layoutManager = slicePersonalChatBinding.b.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            }
            if (linearLayoutManager != null) {
                linearLayoutManager.scrollToPositionWithOffset(p0().getItemCount() - 1, 0);
                g0(linearLayoutManager);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void U(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view2, bundle) == null) {
            super.U(view2, bundle);
            SlicePersonalChatBinding slicePersonalChatBinding = this.o;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            FadingEdgeRecyclerView fadingEdgeRecyclerView = slicePersonalChatBinding.b;
            fadingEdgeRecyclerView.setVerticalFadingEdgeEnabled(true);
            fadingEdgeRecyclerView.setFadingEdgeLength(BdUtilHelper.getDimens(fadingEdgeRecyclerView.getContext(), R.dimen.tbds80));
            fadingEdgeRecyclerView.setLayoutManager(l0());
            fadingEdgeRecyclerView.setAdapter(p0());
            fadingEdgeRecyclerView.setOnScrollToTopListener(new BdListView.s() { // from class: com.baidu.tieba.pu8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.adp.widget.ListView.BdListView.s
                public final void onScrollToTop() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ChatListSlice.v0(ChatListSlice.this);
                    }
                }
            });
            fadingEdgeRecyclerView.setOnSrollToBottomListener(new BdListView.p() { // from class: com.baidu.tieba.mu8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.adp.widget.ListView.BdListView.p
                public final void onScrollToBottom() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ChatListSlice.w0(ChatListSlice.this);
                    }
                }
            });
            fadingEdgeRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$onViewCreated$1$3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatListSlice a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i) == null) {
                        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                        super.onScrollStateChanged(recyclerView, i);
                        this.a.t = i;
                        if (i != 1) {
                            return;
                        }
                        this.a.f0();
                    }
                }
            });
            p0().setList(this.u);
            q0();
            y0();
            k0();
            ur6 b2 = sr6.b();
            TbPageContext<BaseFragmentActivity> pageContext = F().getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "host.pageContext");
            b2.a(new rr6(pageContext, this), new a(this, cu8.class));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0058 A[EDGE_INSN: B:44:0x0058->B:32:0x0058 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i0() {
        ut8 ut8Var;
        v97<?> v97Var;
        zt8 zt8Var;
        boolean z;
        zt8 zt8Var2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            List<v97<?>> list = this.u;
            ListIterator<v97<?>> listIterator = list.listIterator(list.size());
            while (true) {
                ut8Var = null;
                if (listIterator.hasPrevious()) {
                    v97Var = listIterator.previous();
                    v97<?> v97Var2 = v97Var;
                    boolean z3 = v97Var2 instanceof zt8;
                    if (z3) {
                        zt8Var = (zt8) v97Var2;
                    } else {
                        zt8Var = null;
                    }
                    boolean z4 = true;
                    if (zt8Var != null && zt8Var.a() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (z3) {
                            zt8Var2 = (zt8) v97Var2;
                        } else {
                            zt8Var2 = null;
                        }
                        if (zt8Var2 != null && zt8Var2.a() == Long.MAX_VALUE) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            continue;
                            if (z4) {
                                break;
                            }
                        }
                    }
                    z4 = false;
                    continue;
                    if (z4) {
                    }
                } else {
                    v97Var = null;
                    break;
                }
            }
            v97<?> v97Var3 = v97Var;
            if (v97Var3 != null) {
                if (v97Var3 instanceof ut8) {
                    ut8Var = (ut8) v97Var3;
                }
                if (ut8Var != null) {
                    this.j.g(ut8Var.a());
                }
            }
        }
    }
}
