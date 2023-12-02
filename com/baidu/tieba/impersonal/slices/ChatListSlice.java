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
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ar6;
import com.baidu.tieba.bj;
import com.baidu.tieba.br6;
import com.baidu.tieba.dr6;
import com.baidu.tieba.er6;
import com.baidu.tieba.f49;
import com.baidu.tieba.fd9;
import com.baidu.tieba.feed.list.TemplateAdapter;
import com.baidu.tieba.gd9;
import com.baidu.tieba.hb9;
import com.baidu.tieba.hd9;
import com.baidu.tieba.id9;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.base.core.slice.SliceFragment;
import com.baidu.tieba.impersonal.components.FadingEdgeRecyclerView;
import com.baidu.tieba.impersonal.data.BehaviorExt;
import com.baidu.tieba.impersonal.databinding.SlicePersonalChatBinding;
import com.baidu.tieba.impersonal.help.CustomSpeedLinearLayoutManager;
import com.baidu.tieba.impersonal.help.MsgDiffCallback;
import com.baidu.tieba.impersonal.slices.ChatListSlice;
import com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor;
import com.baidu.tieba.jb9;
import com.baidu.tieba.kq8;
import com.baidu.tieba.pb9;
import com.baidu.tieba.rb7;
import com.baidu.tieba.ub9;
import com.baidu.tieba.vb9;
import com.baidu.tieba.wb9;
import com.baidu.tieba.xb9;
import com.baidu.tieba.za9;
import com.baidu.tieba.zb9;
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
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u000215\u0018\u0000 Z2\u00020\u0001:\u0001ZB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020?H\u0002J\b\u0010A\u001a\u00020?H\u0002J\b\u0010B\u001a\u00020?H\u0002J\b\u0010C\u001a\u00020?H\u0007J$\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u00020?H\u0016J\u0010\u0010M\u001a\u00020?2\u0006\u0010N\u001a\u00020!H\u0016J\u001c\u0010O\u001a\u00020?2\b\u0010P\u001a\u0004\u0018\u00010E2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010Q\u001a\u00020?2\u0006\u0010R\u001a\u00020!H\u0002J\b\u0010S\u001a\u00020?H\u0002J\u0012\u0010T\u001a\u00020?2\b\b\u0002\u0010U\u001a\u00020VH\u0002J\b\u0010W\u001a\u00020?H\u0002J\f\u0010X\u001a\u00020!*\u00020YH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0012\u001a\u0004\b+\u0010,R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0012\u001a\u0004\b;\u0010<¨\u0006["}, d2 = {"Lcom/baidu/tieba/impersonal/slices/ChatListSlice;", "Lcom/baidu/tieba/im/base/core/slice/Slice;", "repo", "Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;", "behaviorExt", "Lcom/baidu/tieba/impersonal/data/BehaviorExt;", "processor", "Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "detailManager", "Lcom/baidu/tieba/impersonal/sprite/SpriteDetailManager;", "(Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;Lcom/baidu/tieba/impersonal/data/BehaviorExt;Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;Lcom/baidu/tieba/impersonal/sprite/SpriteDetailManager;)V", "binding", "Lcom/baidu/tieba/impersonal/databinding/SlicePersonalChatBinding;", "layoutManager", "Lcom/baidu/tieba/impersonal/help/CustomSpeedLinearLayoutManager;", "getLayoutManager", "()Lcom/baidu/tieba/impersonal/help/CustomSpeedLinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "list", "", "Lcom/baidu/tieba/feed/list/TemplateData;", "loadingView", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/view/LoadingView;", "getLoadingView", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/view/LoadingView;", "loadingView$delegate", "mEntrancePageRepo", "Lcom/baidu/tieba/impersonal/sprite/EntrancePageRepo;", "getMEntrancePageRepo", "()Lcom/baidu/tieba/impersonal/sprite/EntrancePageRepo;", "mEntrancePageRepo$delegate", "mFirstEnterPage", "", "getMFirstEnterPage", "()Z", "setMFirstEnterPage", "(Z)V", "mKeyBoardShowing", "msgArriveCallback", "Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor$MsgCallback;", "notifier", "Lcom/baidu/adp/widget/ListView/RecyclerViewNotifier;", "getNotifier", "()Lcom/baidu/adp/widget/ListView/RecyclerViewNotifier;", "notifier$delegate", "paddingBottom", "", "preFetchCallback", "com/baidu/tieba/impersonal/slices/ChatListSlice$preFetchCallback$1", "Lcom/baidu/tieba/impersonal/slices/ChatListSlice$preFetchCallback$1;", "recyclerState", "sendMsgTransfer", "com/baidu/tieba/impersonal/slices/ChatListSlice$sendMsgTransfer$1", "Lcom/baidu/tieba/impersonal/slices/ChatListSlice$sendMsgTransfer$1;", "spriteChatDetail", "Lcom/baidu/tieba/impersonal/components/SpriteDetailCallback;", "templateAdapter", "Lcom/baidu/tieba/feed/list/TemplateAdapter;", "getTemplateAdapter", "()Lcom/baidu/tieba/feed/list/TemplateAdapter;", "templateAdapter$delegate", "dealSoftKey", "", "fetchNextMsg", "fetchPreviousMsg", "firstLoadMsg", "initListener", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "onKeyboardVisibilityChanged", MapBundleKey.MapObjKey.OBJ_SL_VISI, "onViewCreated", "view", "processEnterPage", "haveHistoryMsg", "registerMsgListener", "scrollListToBottom", "duration", "", "scrollToBottomWithoutAnim", "ensureScrollToBottom", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatListSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public static final DiffUtil.ItemCallback<rb7<?>> C;
    public transient /* synthetic */ FieldHolder $fh;
    public final c A;
    public final Lazy B;
    public final fd9 j;
    public final BehaviorExt k;
    public final kq8 l;
    public final id9 m;
    public boolean n;
    public boolean o;
    public SlicePersonalChatBinding p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public int u;
    public final List<rb7<?>> v;
    public final int w;
    public final b x;
    public final SpriteMsgProcessor.d y;
    public final hb9 z;

    /* loaded from: classes6.dex */
    public static final class a extends er6<xb9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatListSlice b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ChatListSlice chatListSlice, Class<xb9> cls) {
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
        @Override // com.baidu.tieba.er6
        public void onEvent(xb9 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (this.b.u == 1) {
                    return;
                }
                ChatListSlice.J0(this.b, 0.0f, 1, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements fd9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatListSlice a;

        @Override // com.baidu.tieba.fd9.b
        public void a(List<? extends pb9> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                Intrinsics.checkNotNullParameter(list, "list");
            }
        }

        @Override // com.baidu.tieba.fd9.b
        public void b(int i, String errorMsg, ub9<?> msg) {
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
                this$0.o0();
            }
        }

        @Override // com.baidu.tieba.fd9.b
        public void d(String msgKey) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, msgKey) == null) {
                Intrinsics.checkNotNullParameter(msgKey, "msgKey");
                final ChatListSlice chatListSlice = this.a;
                UiUtils.runOnUiThreadDelay(new Runnable() { // from class: com.baidu.tieba.ic9
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

        @Override // com.baidu.tieba.fd9.b
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                if (i == 0) {
                    br6.b().c(new wb9(2));
                } else {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.obfuscated_res_0x7f0f0e70);
                }
            }
        }

        @Override // com.baidu.tieba.fd9.b
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            this.a.v0().f();
                            return;
                        }
                        return;
                    }
                    this.a.v0().g();
                    return;
                }
                br6.b().c(new wb9(1));
            }
        }

        @Override // com.baidu.tieba.fd9.b
        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            this.a.v0().i();
                            return;
                        }
                        return;
                    }
                    this.a.v0().j();
                    return;
                }
                br6.b().c(new wb9(0));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements hd9 {
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

        @Override // com.baidu.tieba.hd9
        public void a(ub9<vb9> msgData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msgData) == null) {
                Intrinsics.checkNotNullParameter(msgData, "msgData");
                this.a.j.u(msgData);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements hb9 {
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

        @Override // com.baidu.tieba.hb9
        public void a() {
            id9 id9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (id9Var = this.a.m) != null) {
                id9Var.b();
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
        C = new DiffUtil.ItemCallback<rb7<?>>() { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$Companion$DIFF_ITEM_CALLBACK$1
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
            public boolean areContentsTheSame(rb7<?> oldItem, rb7<?> newItem) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, oldItem, newItem)) == null) {
                    Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                    Intrinsics.checkNotNullParameter(newItem, "newItem");
                    if (!(oldItem instanceof jb9) || !(newItem instanceof jb9) || ((jb9) oldItem).f((jb9) newItem)) {
                        return false;
                    }
                    return true;
                }
                return invokeLL.booleanValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b */
            public boolean areItemsTheSame(rb7<?> oldItem, rb7<?> newItem) {
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

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j.a(this.x);
            this.j.w(this.y);
            this.j.v(this.z);
            this.j.s();
        }
    }

    public final void o0() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.n) {
            Context context = K().getContext();
            FragmentActivity activity = K().getActivity();
            if (activity != null) {
                view2 = activity.getCurrentFocus();
            } else {
                view2 = null;
            }
            BdUtilHelper.hideSoftKeyPad(context, view2);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            this.j.w(null);
            this.j.x();
            this.j.t();
        }
    }

    public final void s0() {
        jb9 jb9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Object first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.v);
            if (first instanceof jb9) {
                jb9Var = (jb9) first;
            } else {
                jb9Var = null;
            }
            if (jb9Var != null) {
                this.j.c(jb9Var.c().a());
            }
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.j.m();
        }
    }

    public final CustomSpeedLinearLayoutManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return (CustomSpeedLinearLayoutManager) this.q.getValue();
        }
        return (CustomSpeedLinearLayoutManager) invokeV.objValue;
    }

    public final f49 v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return (f49) this.s.getValue();
        }
        return (f49) invokeV.objValue;
    }

    public final gd9 w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (gd9) this.B.getValue();
        }
        return (gd9) invokeV.objValue;
    }

    public final bj x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return (bj) this.r.getValue();
        }
        return (bj) invokeV.objValue;
    }

    public final TemplateAdapter y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return (TemplateAdapter) this.t.getValue();
        }
        return (TemplateAdapter) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            SlicePersonalChatBinding slicePersonalChatBinding = this.p;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            slicePersonalChatBinding.b.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ec9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? ChatListSlice.A0(ChatListSlice.this, view2, motionEvent) : invokeLL.booleanValue;
                }
            });
        }
    }

    public ChatListSlice(fd9 repo, BehaviorExt behaviorExt, kq8 processor, id9 id9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {repo, behaviorExt, processor, id9Var};
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
        Intrinsics.checkNotNullParameter(behaviorExt, "behaviorExt");
        Intrinsics.checkNotNullParameter(processor, "processor");
        this.j = repo;
        this.k = behaviorExt;
        this.l = processor;
        this.m = id9Var;
        this.o = true;
        this.q = LazyKt__LazyJVMKt.lazy(new Function0<CustomSpeedLinearLayoutManager>(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$layoutManager$2
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
                SliceFragment K;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (CustomSpeedLinearLayoutManager) invokeV.objValue;
                }
                K = this.this$0.K();
                Context requireContext = K.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "host.requireContext()");
                return new CustomSpeedLinearLayoutManager(requireContext);
            }
        });
        this.r = LazyKt__LazyJVMKt.lazy(new Function0<bj>(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$notifier$2
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
            public final bj invoke() {
                InterceptResult invokeV;
                SlicePersonalChatBinding slicePersonalChatBinding;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (bj) invokeV.objValue;
                }
                slicePersonalChatBinding = this.this$0.p;
                if (slicePersonalChatBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    slicePersonalChatBinding = null;
                }
                return new bj(slicePersonalChatBinding.b);
            }
        });
        this.s = LazyKt__LazyJVMKt.lazy(new Function0<f49>(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$loadingView$2
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
            public final f49 invoke() {
                InterceptResult invokeV;
                SlicePersonalChatBinding slicePersonalChatBinding;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (f49) invokeV.objValue;
                }
                slicePersonalChatBinding = this.this$0.p;
                if (slicePersonalChatBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    slicePersonalChatBinding = null;
                }
                return new f49(slicePersonalChatBinding.b);
            }
        });
        this.t = LazyKt__LazyJVMKt.lazy(new Function0<TemplateAdapter>(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$templateAdapter$2
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
                kq8 kq8Var;
                ChatListSlice.c cVar;
                BehaviorExt behaviorExt2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    TemplateAdapter templateAdapter = new TemplateAdapter();
                    ChatListSlice chatListSlice = this.this$0;
                    kq8Var = chatListSlice.l;
                    cVar = chatListSlice.A;
                    behaviorExt2 = chatListSlice.k;
                    templateAdapter.j(new za9(kq8Var, cVar, behaviorExt2));
                    return templateAdapter;
                }
                return (TemplateAdapter) invokeV.objValue;
            }
        });
        this.v = new ArrayList();
        this.w = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
        this.x = new b(this);
        this.y = new SpriteMsgProcessor.d() { // from class: com.baidu.tieba.cc9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor.d
            public final void a(long j, List list, SpriteMsgProcessor.f fVar, SpriteMsgProcessor.e eVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), list, fVar, eVar}) == null) {
                    ChatListSlice.B0(ChatListSlice.this, j, list, fVar, eVar);
                }
            }
        };
        this.z = new d(this);
        this.A = new c(this);
        this.B = LazyKt__LazyJVMKt.lazy(new Function0<gd9>(this) { // from class: com.baidu.tieba.impersonal.slices.ChatListSlice$mEntrancePageRepo$2
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
            public final gd9 invoke() {
                InterceptResult invokeV;
                SliceFragment K;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (gd9) invokeV.objValue;
                }
                K = this.this$0.K();
                return new gd9(K.getContext(), this.this$0.j);
            }
        });
    }

    public static final boolean A0(ChatListSlice this$0, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, this$0, view2, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.o0();
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public View U(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            SlicePersonalChatBinding it = SlicePersonalChatBinding.c(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this.p = it;
            return it.getRoot();
        }
        return (View) invokeLLL.objValue;
    }

    public static final void B0(final ChatListSlice this$0, long j, final List msgs, SpriteMsgProcessor.f source, final SpriteMsgProcessor.e loadType) {
        final boolean z;
        final boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{this$0, Long.valueOf(j), msgs, source, loadType}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(msgs, "msgs");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            SlicePersonalChatBinding slicePersonalChatBinding = this$0.p;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            if (slicePersonalChatBinding.b.getLastVisiblePosition() == this$0.y0().getItemCount() - 1) {
                z = true;
            } else {
                z = false;
            }
            if (loadType.a() != 4 && loadType.a() != 0 && loadType.a() != 6 && (!source.a() || !z)) {
                z2 = false;
            } else {
                z2 = true;
            }
            this$0.x0().e(new Runnable() { // from class: com.baidu.tieba.fc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ChatListSlice.C0(ChatListSlice.this, msgs, loadType, z2, z);
                    }
                }
            });
        }
    }

    public static final void C0(final ChatListSlice this$0, List msgs, SpriteMsgProcessor.e loadType, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{this$0, msgs, loadType, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(msgs, "$msgs");
            Intrinsics.checkNotNullParameter(loadType, "$loadType");
            List<rb7<?>> b2 = zb9.a.b(this$0.j, msgs, loadType);
            DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new MsgDiffCallback(this$0.v, b2, C));
            Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(\n         …      )\n                )");
            this$0.v.clear();
            this$0.v.addAll(b2);
            calculateDiff.dispatchUpdatesTo(this$0.y0());
            if (z) {
                if (loadType.a() == 4 && z2) {
                    J0(this$0, 0.0f, 1, null);
                } else if (loadType.a() == 0) {
                    UiUtils.post(new Runnable() { // from class: com.baidu.tieba.gc9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                ChatListSlice.D0(ChatListSlice.this);
                            }
                        }
                    });
                } else {
                    this$0.K0();
                }
            }
            if (this$0.o) {
                boolean z3 = false;
                this$0.o = false;
                List<rb7<?>> list = this$0.v;
                this$0.G0(true ^ ((list == null || list.isEmpty()) ? true : true));
            }
        }
    }

    public static final void D0(ChatListSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.K0();
        }
    }

    public static final void E0(ChatListSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.s0();
        }
    }

    public static final void F0(ChatListSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.r0();
        }
    }

    public final void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            w0().b(this.k.getTalkType(), this.k.getTalkPrologue(), Boolean.valueOf(z));
        }
    }

    public final void I0(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
            u0().a(f);
            SlicePersonalChatBinding slicePersonalChatBinding = this.p;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            slicePersonalChatBinding.b.smoothScrollToPosition(y0().getItemCount() - 1, 0);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void W(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.W(z);
            this.n = z;
            K0();
            SlicePersonalChatBinding slicePersonalChatBinding = this.p;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            FadingEdgeRecyclerView fadingEdgeRecyclerView = slicePersonalChatBinding.b;
            if (z) {
                i = this.w;
            } else {
                i = 0;
            }
            fadingEdgeRecyclerView.setPadding(0, 0, 0, i);
        }
    }

    public final boolean p0(final LinearLayoutManager linearLayoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, linearLayoutManager)) == null) {
            SlicePersonalChatBinding slicePersonalChatBinding = this.p;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            return slicePersonalChatBinding.b.post(new Runnable() { // from class: com.baidu.tieba.dc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ChatListSlice.q0(LinearLayoutManager.this, this);
                    }
                }
            });
        }
        return invokeL.booleanValue;
    }

    public static /* synthetic */ void J0(ChatListSlice chatListSlice, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 100.0f;
        }
        chatListSlice.I0(f);
    }

    public static final void q0(LinearLayoutManager this_ensureScrollToBottom, ChatListSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, this_ensureScrollToBottom, this$0) == null) {
            Intrinsics.checkNotNullParameter(this_ensureScrollToBottom, "$this_ensureScrollToBottom");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View findViewByPosition = this_ensureScrollToBottom.findViewByPosition(this$0.y0().getItemCount() - 1);
            if (findViewByPosition != null) {
                SlicePersonalChatBinding slicePersonalChatBinding = this$0.p;
                SlicePersonalChatBinding slicePersonalChatBinding2 = null;
                if (slicePersonalChatBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    slicePersonalChatBinding = null;
                }
                int measuredHeight = slicePersonalChatBinding.b.getMeasuredHeight() - findViewByPosition.getMeasuredHeight();
                SlicePersonalChatBinding slicePersonalChatBinding3 = this$0.p;
                if (slicePersonalChatBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    slicePersonalChatBinding2 = slicePersonalChatBinding3;
                }
                this_ensureScrollToBottom.scrollToPositionWithOffset(this$0.y0().getItemCount() - 1, (measuredHeight - slicePersonalChatBinding2.b.getPaddingBottom()) - 10000);
            }
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SlicePersonalChatBinding slicePersonalChatBinding = this.p;
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
                linearLayoutManager.scrollToPositionWithOffset(y0().getItemCount() - 1, 0);
                p0(linearLayoutManager);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void a0(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, bundle) == null) {
            super.a0(view2, bundle);
            SlicePersonalChatBinding slicePersonalChatBinding = this.p;
            if (slicePersonalChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalChatBinding = null;
            }
            FadingEdgeRecyclerView fadingEdgeRecyclerView = slicePersonalChatBinding.b;
            fadingEdgeRecyclerView.setVerticalFadingEdgeEnabled(true);
            fadingEdgeRecyclerView.setFadingEdgeLength(BdUtilHelper.getDimens(fadingEdgeRecyclerView.getContext(), R.dimen.tbds80));
            fadingEdgeRecyclerView.setLayoutManager(u0());
            fadingEdgeRecyclerView.setAdapter(y0());
            fadingEdgeRecyclerView.setOnScrollToTopListener(new BdListView.s() { // from class: com.baidu.tieba.kc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.adp.widget.ListView.BdListView.s
                public final void onScrollToTop() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ChatListSlice.E0(ChatListSlice.this);
                    }
                }
            });
            fadingEdgeRecyclerView.setOnSrollToBottomListener(new BdListView.p() { // from class: com.baidu.tieba.hc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.adp.widget.ListView.BdListView.p
                public final void onScrollToBottom() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ChatListSlice.F0(ChatListSlice.this);
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
                        this.a.o0();
                    }
                }
            });
            y0().setList(this.v);
            z0();
            H0();
            t0();
            dr6 b2 = br6.b();
            TbPageContext<BaseFragmentActivity> pageContext = K().getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "host.pageContext");
            b2.b(new ar6(pageContext, this), new a(this, xb9.class));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0058 A[EDGE_INSN: B:44:0x0058->B:32:0x0058 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r0() {
        pb9 pb9Var;
        rb7<?> rb7Var;
        ub9 ub9Var;
        boolean z;
        ub9 ub9Var2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            List<rb7<?>> list = this.v;
            ListIterator<rb7<?>> listIterator = list.listIterator(list.size());
            while (true) {
                pb9Var = null;
                if (listIterator.hasPrevious()) {
                    rb7Var = listIterator.previous();
                    rb7<?> rb7Var2 = rb7Var;
                    boolean z3 = rb7Var2 instanceof ub9;
                    if (z3) {
                        ub9Var = (ub9) rb7Var2;
                    } else {
                        ub9Var = null;
                    }
                    boolean z4 = true;
                    if (ub9Var != null && ub9Var.a() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (z3) {
                            ub9Var2 = (ub9) rb7Var2;
                        } else {
                            ub9Var2 = null;
                        }
                        if (ub9Var2 != null && ub9Var2.a() == Long.MAX_VALUE) {
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
                    rb7Var = null;
                    break;
                }
            }
            rb7<?> rb7Var3 = rb7Var;
            if (rb7Var3 != null) {
                if (rb7Var3 instanceof pb9) {
                    pb9Var = (pb9) rb7Var3;
                }
                if (pb9Var != null) {
                    this.j.h(pb9Var.a());
                }
            }
        }
    }
}
