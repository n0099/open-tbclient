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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.e08;
import com.baidu.tieba.feed.list.TemplateAdapter;
import com.baidu.tieba.h08;
import com.baidu.tieba.hi;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.immessagecenter.slice.SliceFragment;
import com.baidu.tieba.impersonal.components.FadingEdgeRecyclerView;
import com.baidu.tieba.impersonal.databinding.SlicePersonalChatBinding;
import com.baidu.tieba.impersonal.help.CustomSpeedLinearLayoutManager;
import com.baidu.tieba.impersonal.help.MsgDiffCallback;
import com.baidu.tieba.impersonal.slices.ChatListSlice;
import com.baidu.tieba.jh6;
import com.baidu.tieba.k08;
import com.baidu.tieba.kh6;
import com.baidu.tieba.m08;
import com.baidu.tieba.mh6;
import com.baidu.tieba.n08;
import com.baidu.tieba.ng;
import com.baidu.tieba.nh6;
import com.baidu.tieba.o18;
import com.baidu.tieba.p08;
import com.baidu.tieba.p18;
import com.baidu.tieba.q18;
import com.baidu.tieba.qs6;
import com.baidu.tieba.rv7;
import com.baidu.tieba.sn;
import com.baidu.tieba.w18;
import com.baidu.tieba.x18;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0002*4\u0018\u0000 Y2\u00020\u0001:\u0001YB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010A\u001a\u00020;H\u0002J\b\u0010B\u001a\u00020;H\u0002J\b\u0010C\u001a\u00020;H\u0002J\b\u0010D\u001a\u00020;H\u0002J\b\u0010E\u001a\u00020;H\u0007J$\u0010F\u001a\u0004\u0018\u0001092\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010M\u001a\u00020;H\u0016J\u0010\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u00020#H\u0016J\u001c\u0010P\u001a\u00020;2\b\u0010Q\u001a\u0004\u0018\u0001092\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0010\u0010R\u001a\u00020;2\u0006\u0010S\u001a\u00020#H\u0002J\b\u0010T\u001a\u00020;H\u0002J\u0012\u0010U\u001a\u00020;2\b\b\u0002\u0010V\u001a\u00020WH\u0002J\b\u0010X\u001a\u00020;H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000f\u001a\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u000f\u001a\u0004\b.\u0010/R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00107\u001a\u0018\u0012\u0004\u0012\u000209\u0012\b\u0012\u0006\u0012\u0002\b\u00030:\u0012\u0004\u0012\u00020;08X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u000f\u001a\u0004\b>\u0010?¨\u0006Z"}, d2 = {"Lcom/baidu/tieba/impersonal/slices/ChatListSlice;", "Lcom/baidu/tieba/immessagecenter/slice/Slice;", "repo", "Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;", "talkType", "", "talkPrologue", "(Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;Ljava/lang/String;Ljava/lang/String;)V", "binding", "Lcom/baidu/tieba/impersonal/databinding/SlicePersonalChatBinding;", "fakeLoadingHelper", "Lcom/baidu/tieba/impersonal/util/LoadingMsgHelper;", "getFakeLoadingHelper", "()Lcom/baidu/tieba/impersonal/util/LoadingMsgHelper;", "fakeLoadingHelper$delegate", "Lkotlin/Lazy;", "layoutManager", "Lcom/baidu/tieba/impersonal/help/CustomSpeedLinearLayoutManager;", "getLayoutManager", "()Lcom/baidu/tieba/impersonal/help/CustomSpeedLinearLayoutManager;", "layoutManager$delegate", "list", "", "Lcom/baidu/tieba/feed/list/TemplateData;", "loadingView", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/view/LoadingView;", "getLoadingView", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/view/LoadingView;", "loadingView$delegate", "mEntrancePageRepo", "Lcom/baidu/tieba/impersonal/sprite/EntrancePageRepo;", "getMEntrancePageRepo", "()Lcom/baidu/tieba/impersonal/sprite/EntrancePageRepo;", "mEntrancePageRepo$delegate", "mFirstEnterPage", "", "getMFirstEnterPage", "()Z", "setMFirstEnterPage", "(Z)V", "mKeyBoardShowing", "msgArriveCallback", "com/baidu/tieba/impersonal/slices/ChatListSlice$msgArriveCallback$1", "Lcom/baidu/tieba/impersonal/slices/ChatListSlice$msgArriveCallback$1;", "notifier", "Lcom/baidu/adp/widget/ListView/RecyclerViewNotifier;", "getNotifier", "()Lcom/baidu/adp/widget/ListView/RecyclerViewNotifier;", "notifier$delegate", "paddingBottom", "", "preFetchCallback", "com/baidu/tieba/impersonal/slices/ChatListSlice$preFetchCallback$1", "Lcom/baidu/tieba/impersonal/slices/ChatListSlice$preFetchCallback$1;", "recyclerState", "resendClick", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/baidu/tieba/impersonal/data/PersonalChatMsgData;", "", "templateAdapter", "Lcom/baidu/tieba/feed/list/TemplateAdapter;", "getTemplateAdapter", "()Lcom/baidu/tieba/feed/list/TemplateAdapter;", "templateAdapter$delegate", "dealSoftKey", "fetchNextMsg", "fetchPreviousMsg", "firstLoadMsg", "initListener", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "onKeyboardVisibilityChanged", MapBundleKey.MapObjKey.OBJ_SL_VISI, "onViewCreated", NativeConstants.TYPE_VIEW, "processEnterPage", "haveHistoryMsg", "registerMsgListener", "scrollListToBottom", "duration", "", "scrollToBottomWithoutAnim", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChatListSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public static final a B;
    public static final DiffUtil.ItemCallback<qs6<?>> C;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy A;
    public final o18 j;
    public final String k;
    public final String l;
    public boolean m;
    public boolean n;
    public SlicePersonalChatBinding o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public int u;
    public final List<qs6<?>> v;
    public final int w;
    public final d x;
    public final b y;
    public final Function2<View, k08<?>, Unit> z;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        public final DiffUtil.ItemCallback<qs6<?>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return ChatListSlice.C;
            }
            return (DiffUtil.ItemCallback) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements q18.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatListSlice a;

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

        public static final void b(List msgs, q18.e loadType, ChatListSlice this$0, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{msgs, loadType, this$0, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                Intrinsics.checkNotNullParameter(msgs, "$msgs");
                Intrinsics.checkNotNullParameter(loadType, "$loadType");
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                List<qs6<?>> b = p08.a.b(msgs, loadType, this$0.z);
                DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new MsgDiffCallback(this$0.v, b, ChatListSlice.B.a()));
                Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(\n         …      )\n                )");
                this$0.v.clear();
                this$0.v.addAll(b);
                calculateDiff.dispatchUpdatesTo(this$0.k0());
                if (z) {
                    if (loadType.getType() == 4 && z2) {
                        ChatListSlice.s0(this$0, 0.0f, 1, null);
                    } else {
                        this$0.t0();
                    }
                }
                if (this$0.i0()) {
                    boolean z3 = false;
                    this$0.u0(false);
                    List list = this$0.v;
                    this$0.p0(true ^ ((list == null || list.isEmpty()) ? true : true));
                }
            }
        }

        @Override // com.baidu.tieba.q18.d
        public void a(long j, final List<? extends h08> msgs, q18.f source, final q18.e loadType) {
            final boolean z;
            final boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), msgs, source, loadType}) == null) {
                Intrinsics.checkNotNullParameter(msgs, "msgs");
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(loadType, "loadType");
                SlicePersonalChatBinding slicePersonalChatBinding = this.a.o;
                if (slicePersonalChatBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    slicePersonalChatBinding = null;
                }
                if (slicePersonalChatBinding.b.getLastVisiblePosition() == this.a.k0().getItemCount() - 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (loadType.getType() != 4 && loadType.getType() != 0 && (!source.a() || !z)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                sn j0 = this.a.j0();
                final ChatListSlice chatListSlice = this.a;
                j0.e(new Runnable() { // from class: com.baidu.tieba.q08
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ChatListSlice.b.b(msgs, loadType, chatListSlice, z2, z);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c extends nh6<n08> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatListSlice b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ChatListSlice chatListSlice, Class<n08> cls) {
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
        @Override // com.baidu.tieba.nh6
        public void onEvent(n08 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (this.b.u == 1) {
                    return;
                }
                ChatListSlice.s0(this.b, 0.0f, 1, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class d implements o18.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatListSlice a;

        public d(ChatListSlice chatListSlice) {
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

        public static final void g(ChatListSlice this$0) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.a0();
            }
        }

        @Override // com.baidu.tieba.o18.b
        public void d(String msgKey) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, msgKey) == null) {
                Intrinsics.checkNotNullParameter(msgKey, "msgKey");
                this.a.e0().c(msgKey);
                final ChatListSlice chatListSlice = this.a;
                ng.f(new Runnable() { // from class: com.baidu.tieba.s08
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ChatListSlice.d.g(ChatListSlice.this);
                        }
                    }
                }, 300L);
            }
        }

        @Override // com.baidu.tieba.o18.b
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                if (i == 0) {
                    kh6.b().b(new m08(2));
                } else {
                    hi.P(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0d1f);
                }
            }
        }

        @Override // com.baidu.tieba.o18.b
        public void a(List<? extends h08> list) {
            k08 k08Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                Intrinsics.checkNotNullParameter(list, "list");
                ChatListSlice chatListSlice = this.a;
                for (h08 h08Var : list) {
                    if (h08Var instanceof k08) {
                        k08Var = (k08) h08Var;
                    } else {
                        k08Var = null;
                    }
                    if (k08Var != null && !k08Var.e().d()) {
                        chatListSlice.e0().h(k08Var.b());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.o18.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            this.a.g0().f();
                            return;
                        }
                        return;
                    }
                    this.a.g0().g();
                    return;
                }
                kh6.b().b(new m08(1));
            }
        }

        @Override // com.baidu.tieba.o18.b
        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            this.a.g0().i();
                            return;
                        }
                        return;
                    }
                    this.a.g0().j();
                    return;
                }
                kh6.b().b(new m08(0));
            }
        }

        @Override // com.baidu.tieba.o18.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.t0();
            }
        }

        @Override // com.baidu.tieba.o18.b
        public void f(int i, String errorMsg, ChatMsg msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048581, this, i, errorMsg, msg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                Intrinsics.checkNotNullParameter(msg, "msg");
                k08<Object> c = x18.c(msg);
                if (i != 0) {
                    if (c == null) {
                        c = null;
                    }
                    if (c != null) {
                        ChatListSlice chatListSlice = this.a;
                        if (c.e().d()) {
                            chatListSlice.e0().h(c.b());
                        }
                    }
                }
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
        B = new a(null);
        C = new DiffUtil.ItemCallback<qs6<?>>() { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$Companion$DIFF_ITEM_CALLBACK$1
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
            public boolean areContentsTheSame(qs6<?> oldItem, qs6<?> newItem) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, oldItem, newItem)) == null) {
                    Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                    Intrinsics.checkNotNullParameter(newItem, "newItem");
                    if (!(oldItem instanceof e08) || !(newItem instanceof e08) || ((e08) oldItem).e((e08) newItem)) {
                        return false;
                    }
                    return true;
                }
                return invokeLL.booleanValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b */
            public boolean areItemsTheSame(qs6<?> oldItem, qs6<?> newItem) {
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

    public final void a0() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.m) {
            Context context = h().getContext();
            FragmentActivity activity = h().getActivity();
            if (activity != null) {
                view2 = activity.getCurrentFocus();
            } else {
                view2 = null;
            }
            hi.z(context, view2);
        }
    }

    public final void c0() {
        e08 e08Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Object first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.v);
            if (first instanceof e08) {
                e08Var = (e08) first;
            } else {
                e08Var = null;
            }
            if (e08Var != null) {
                this.j.b(e08Var.c().a());
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.j.l();
        }
    }

    public final w18 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (w18) this.t.getValue();
        }
        return (w18) invokeV.objValue;
    }

    public final CustomSpeedLinearLayoutManager f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (CustomSpeedLinearLayoutManager) this.p.getValue();
        }
        return (CustomSpeedLinearLayoutManager) invokeV.objValue;
    }

    public final rv7 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return (rv7) this.r.getValue();
        }
        return (rv7) invokeV.objValue;
    }

    public final p18 h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (p18) this.A.getValue();
        }
        return (p18) invokeV.objValue;
    }

    public final boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public final sn j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return (sn) this.q.getValue();
        }
        return (sn) invokeV.objValue;
    }

    public final TemplateAdapter k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (TemplateAdapter) this.s.getValue();
        }
        return (TemplateAdapter) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            SlicePersonalChatBinding slicePersonalChatBinding = this.o;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            slicePersonalChatBinding.b.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.r08
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? ChatListSlice.m0(ChatListSlice.this, view2, motionEvent) : invokeLL.booleanValue;
                }
            });
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            e0().j();
            this.j.w();
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.j.a(this.x);
            this.j.v(this.y);
            this.j.r();
        }
    }

    public ChatListSlice(o18 repo, String talkType, String talkPrologue) {
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
                SliceFragment h;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (CustomSpeedLinearLayoutManager) invokeV.objValue;
                }
                h = this.this$0.h();
                Context requireContext = h.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "host.requireContext()");
                return new CustomSpeedLinearLayoutManager(requireContext);
            }
        });
        this.q = LazyKt__LazyJVMKt.lazy(new Function0<sn>(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$notifier$2
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
            public final sn invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (sn) invokeV.objValue;
                }
                SlicePersonalChatBinding slicePersonalChatBinding = this.this$0.o;
                if (slicePersonalChatBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    slicePersonalChatBinding = null;
                }
                return new sn(slicePersonalChatBinding.b);
            }
        });
        this.r = LazyKt__LazyJVMKt.lazy(new Function0<rv7>(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$loadingView$2
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
            public final rv7 invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (rv7) invokeV.objValue;
                }
                SlicePersonalChatBinding slicePersonalChatBinding = this.this$0.o;
                if (slicePersonalChatBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    slicePersonalChatBinding = null;
                }
                return new rv7(slicePersonalChatBinding.b);
            }
        });
        this.s = LazyKt__LazyJVMKt.lazy(ChatListSlice$templateAdapter$2.INSTANCE);
        this.t = LazyKt__LazyJVMKt.lazy(new Function0<w18>(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$fakeLoadingHelper$2
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
            public final w18 invoke() {
                InterceptResult invokeV;
                o18 o18Var;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (w18) invokeV.objValue;
                }
                o18Var = this.this$0.j;
                return new w18(o18Var);
            }
        });
        this.v = new ArrayList();
        this.w = hi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X012);
        this.x = new d(this);
        this.y = new b(this);
        this.z = new Function2<View, k08<?>, Unit>(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$resendClick$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatListSlice this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
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

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view2, k08<?> k08Var) {
                invoke2(view2, k08Var);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View v, k08<?> data) {
                o18 o18Var;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v, data) == null) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    Intrinsics.checkNotNullParameter(data, "data");
                    v.setVisibility(8);
                    o18Var = this.this$0.j;
                    o18Var.q(data);
                }
            }
        };
        this.A = LazyKt__LazyJVMKt.lazy(new Function0<p18>(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$mEntrancePageRepo$2
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
            public final p18 invoke() {
                InterceptResult invokeV;
                SliceFragment h;
                o18 o18Var;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (p18) invokeV.objValue;
                }
                h = this.this$0.h();
                Context context = h.getContext();
                o18Var = this.this$0.j;
                return new p18(context, o18Var);
            }
        });
    }

    public static final void n0(ChatListSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c0();
        }
    }

    public static final void o0(ChatListSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.b0();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void A(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            super.A(z);
            this.m = z;
            t0();
            SlicePersonalChatBinding slicePersonalChatBinding = this.o;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            FadingEdgeRecyclerView fadingEdgeRecyclerView = slicePersonalChatBinding.b;
            if (z) {
                i = 0;
            } else {
                i = this.w;
            }
            fadingEdgeRecyclerView.setPadding(0, 0, 0, i);
        }
    }

    public final void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            h0().b(this.k, this.l, Boolean.valueOf(z));
        }
    }

    public final void r0(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f) == null) {
            f0().a(f);
            SlicePersonalChatBinding slicePersonalChatBinding = this.o;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            slicePersonalChatBinding.b.smoothScrollToPosition(k0().getItemCount() - 1, 0);
        }
    }

    public final void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.n = z;
        }
    }

    public static final boolean m0(ChatListSlice this$0, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, this$0, view2, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.a0();
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View u(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            SlicePersonalChatBinding it = SlicePersonalChatBinding.c(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this.o = it;
            return it.getRoot();
        }
        return (View) invokeLLL.objValue;
    }

    public static /* synthetic */ void s0(ChatListSlice chatListSlice, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 100.0f;
        }
        chatListSlice.r0(f);
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void E(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.E(view2, bundle);
            SlicePersonalChatBinding slicePersonalChatBinding = this.o;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            FadingEdgeRecyclerView fadingEdgeRecyclerView = slicePersonalChatBinding.b;
            fadingEdgeRecyclerView.setVerticalFadingEdgeEnabled(true);
            fadingEdgeRecyclerView.setFadingEdgeLength(hi.g(fadingEdgeRecyclerView.getContext(), R.dimen.tbds80));
            fadingEdgeRecyclerView.setLayoutManager(f0());
            fadingEdgeRecyclerView.setAdapter(k0());
            fadingEdgeRecyclerView.setOnScrollToTopListener(new BdListView.s() { // from class: com.baidu.tieba.v08
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.adp.widget.ListView.BdListView.s
                public final void onScrollToTop() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ChatListSlice.n0(ChatListSlice.this);
                    }
                }
            });
            fadingEdgeRecyclerView.setOnSrollToBottomListener(new BdListView.p() { // from class: com.baidu.tieba.t08
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.adp.widget.ListView.BdListView.p
                public final void onScrollToBottom() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ChatListSlice.o0(ChatListSlice.this);
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
                        this.a.u = i;
                        if (i != 1) {
                            return;
                        }
                        this.a.a0();
                    }
                }
            });
            k0().setList(this.v);
            l0();
            q0();
            d0();
            mh6 b2 = kh6.b();
            TbPageContext<BaseFragmentActivity> pageContext = h().getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "host.pageContext");
            b2.a(new jh6(pageContext, this), new c(this, n08.class));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0058 A[EDGE_INSN: B:44:0x0058->B:32:0x0058 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b0() {
        h08 h08Var;
        qs6<?> qs6Var;
        k08 k08Var;
        boolean z;
        k08 k08Var2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            List<qs6<?>> list = this.v;
            ListIterator<qs6<?>> listIterator = list.listIterator(list.size());
            while (true) {
                h08Var = null;
                if (listIterator.hasPrevious()) {
                    qs6Var = listIterator.previous();
                    qs6<?> qs6Var2 = qs6Var;
                    boolean z3 = qs6Var2 instanceof k08;
                    if (z3) {
                        k08Var = (k08) qs6Var2;
                    } else {
                        k08Var = null;
                    }
                    boolean z4 = true;
                    if (k08Var != null && k08Var.a() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (z3) {
                            k08Var2 = (k08) qs6Var2;
                        } else {
                            k08Var2 = null;
                        }
                        if (k08Var2 != null && k08Var2.a() == Long.MAX_VALUE) {
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
                    qs6Var = null;
                    break;
                }
            }
            qs6<?> qs6Var3 = qs6Var;
            if (qs6Var3 != null) {
                if (qs6Var3 instanceof h08) {
                    h08Var = (h08) qs6Var3;
                }
                if (h08Var != null) {
                    this.j.g(h08Var.a());
                }
            }
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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
                linearLayoutManager.scrollToPositionWithOffset(k0().getItemCount() - 1, 0);
            }
        }
    }
}
