package com.baidu.tieba.immessagecenter.chatgroup.grouppage;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentContainerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.R;
import com.baidu.tieba.dt5;
import com.baidu.tieba.gk8;
import com.baidu.tieba.im.base.core.inputtool.InputDelegate;
import com.baidu.tieba.im.base.core.inputtool.InputToolFragment;
import com.baidu.tieba.im.base.core.inputtool.callback.uistate.ViewState;
import com.baidu.tieba.im.base.core.inputtool.consts.BotSourceType;
import com.baidu.tieba.im.base.core.repo.MsgProcessor;
import com.baidu.tieba.im.base.core.slice.SliceFragment;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbNoUISysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbSysMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.impl.ResponsesPanelControllerImpl;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.positionbubble.UpBubbleSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.subscribe.SubscribeSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.directchat.DirectChatSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.effect.EffectSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.ReplayEmojiSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.detail.EmojiReplayDetailSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.navigationbar.NavigationBarSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.j09;
import com.baidu.tieba.k09;
import com.baidu.tieba.k19;
import com.baidu.tieba.ln8;
import com.baidu.tieba.mv8;
import com.baidu.tieba.n19;
import com.baidu.tieba.ok5;
import com.baidu.tieba.oo4;
import com.baidu.tieba.oq8;
import com.baidu.tieba.pza;
import com.baidu.tieba.qd;
import com.baidu.tieba.qza;
import com.baidu.tieba.rk8;
import com.baidu.tieba.s19;
import com.baidu.tieba.tt5;
import com.baidu.tieba.uv8;
import com.baidu.tieba.vj5;
import com.baidu.tieba.vq6;
import com.baidu.tieba.zl8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GroupChatFragment extends SliceFragment implements qza, gk8 {
    public static /* synthetic */ Interceptable $ic;
    public static long I;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    @Nullable
    public rk8 B;
    public final CustomMessageListener C;
    public final CustomMessageListener D;
    public final CustomMessageListener E;
    public final FastRequest.b<ChatRoomDetail> F;
    public final FastRequest.b<ChatRoomDetail> G;
    public final ok5 H;
    public n e;
    public long f;
    public int g;
    @Nullable
    public GroupChatRepo h;
    @Nullable
    public ChatPage i;
    @NonNull
    public ResponsesPanelController j;
    @Nullable
    public InputDelegate k;
    public n19 l;
    @Nullable
    public ChatRoomDetail m;
    @Nullable
    public EffectSlice n;
    @Nullable
    public DirectChatSlice o;
    @Nullable
    public TopBubbleSlice p;
    @Nullable
    public UpBubbleSlice q;
    @Nullable
    public SubscribeSlice r;
    @Nullable
    public InputToolFragment s;
    @Nullable
    public NavigationBarSlice t;
    @NonNull
    public ReplayEmojiSlice u;
    @NonNull
    public EmojiReplayDetailSlice v;
    public int w;
    public long x;
    public long y;
    public BdUniqueId z;

    @Override // com.baidu.tieba.qza
    @NonNull
    public String Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "chatroom_landing_page" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qza
    @NonNull
    public String n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? "chatroom" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class j implements ok5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ String b;
            public final /* synthetic */ j c;

            public a(j jVar, int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, Integer.valueOf(i), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = jVar;
                this.a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i = this.a;
                    if (i != 0) {
                        pza.a(this.c.a, new Pair(PushMessageHelper.ERROR_TYPE, Integer.toString(i)), new Pair("error_info", this.b));
                        this.c.a.A3();
                        if (this.a == 430) {
                            BdUtilHelper.showLongToast(this.c.a.getContext(), this.c.a.getStringSafely(R.string.obfuscated_res_0x7f0f094d));
                            return;
                        } else {
                            BdUtilHelper.showLongToast(this.c.a.getContext(), this.c.a.getStringSafely(R.string.obfuscated_res_0x7f0f094e, Integer.valueOf(this.a)));
                            return;
                        }
                    }
                    this.c.a.hideLoading();
                }
            }
        }

        public j(GroupChatFragment groupChatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatFragment;
        }

        @Override // com.baidu.tieba.ok5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) {
                ln8.f(j, i, str);
                UiUtils.runOnUiThread(new a(this, i, str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;
        public final /* synthetic */ BaseFragmentActivity b;
        public final /* synthetic */ GroupChatFragment c;

        public a(GroupChatFragment groupChatFragment, TBAlertBuilder tBAlertBuilder, BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment, tBAlertBuilder, baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = groupChatFragment;
            this.a = tBAlertBuilder;
            this.b = baseFragmentActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                this.b.finish();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921781));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) ? i == 4 : invokeLIL.booleanValue;
        }

        public b(GroupChatFragment groupChatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatFragment;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatRoomDetail.BasicInfo a;
        public final /* synthetic */ TbBaseMsg b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ long d;
        public final /* synthetic */ GroupChatFragment e;

        public c(GroupChatFragment groupChatFragment, ChatRoomDetail.BasicInfo basicInfo, TbBaseMsg tbBaseMsg, boolean z, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment, basicInfo, tbBaseMsg, Boolean.valueOf(z), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = groupChatFragment;
            this.a = basicInfo;
            this.b = tbBaseMsg;
            this.c = z;
            this.d = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oq8.j().s(TbadkCoreApplication.getCurrentAccount(), this.a.getName(), this.a.getAvatar(), String.valueOf(this.a.getForumId()), this.a.getForumName(), this.a.getId(), this.b.getMsgId(), this.b.getMsgTime(), this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends SimpleTarget<Drawable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        public d(GroupChatFragment groupChatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: a */
        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, drawable, transition) == null) {
                this.a.e.a.setBackground(drawable);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(GroupChatFragment groupChatFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.e.b != null) {
                mv8.y(this.a.e.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(GroupChatFragment groupChatFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.f3() != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.f3().p0((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(GroupChatFragment groupChatFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.h != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.h.o0(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment d;

        public h(GroupChatFragment groupChatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupChatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void i(@NonNull ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatRoomDetail) == null) {
                super.i(chatRoomDetail);
                this.d.m = chatRoomDetail;
                this.d.f3().A0(chatRoomDetail);
                if (this.d.k != null) {
                    this.d.k.f0(chatRoomDetail.getExtraInfo().getTalkThresholdLevel());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment d;

        public i(GroupChatFragment groupChatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupChatFragment;
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.h();
                this.d.B3();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void e(int i, @NonNull String str, @Nullable Exception exc, @Nullable ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, exc, chatRoomDetail}) == null) {
                super.e(i, str, exc, chatRoomDetail);
                pza.a(this.d, new Pair(PushMessageHelper.ERROR_TYPE, Integer.toString(i)), new Pair("error_info", str), new Pair("log_id", b()));
                ln8.i(false, this.d.f, i, str);
                this.d.A3();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(@NonNull ChatRoomDetail chatRoomDetail) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, chatRoomDetail) == null) {
                super.i(chatRoomDetail);
                pza.c(this.d, new Pair[0]);
                if (!chatRoomDetail.isJumpH5()) {
                    this.d.m = chatRoomDetail;
                    ln8.i(true, this.d.f, 0, DnsModel.MSG_OK);
                    if (this.d.n != null) {
                        this.d.n.i0(chatRoomDetail);
                    }
                    if (this.d.s != null) {
                        this.d.s.v3(s19.b(this.d.f, chatRoomDetail), s19.a(chatRoomDetail.getBasicInfo()));
                    }
                    this.d.u.l0(chatRoomDetail.getReactions());
                    if (!ListUtils.isEmpty(chatRoomDetail.getQuickTalk()) && !this.d.q3()) {
                        this.d.x3(ViewState.VISIBLE);
                    } else {
                        this.d.x3(ViewState.GONE);
                    }
                    this.d.b3().e0(chatRoomDetail);
                    if (this.d.k3() != null) {
                        TopBubbleSlice k3 = this.d.k3();
                        if (chatRoomDetail.getBasicInfo() != null) {
                            j = chatRoomDetail.getBasicInfo().getForumId();
                        } else {
                            j = 0;
                        }
                        k3.v0(j);
                        if (!ListUtils.isEmpty(chatRoomDetail.getChatBubbleData())) {
                            this.d.k3().t0(chatRoomDetail.getChatBubbleData());
                        }
                    }
                    if (this.d.m3() != null) {
                        this.d.m3().r0(chatRoomDetail);
                    }
                    if (this.d.i3() != null) {
                        this.d.i3().o0(chatRoomDetail, this.d.h);
                    }
                    if (this.d.k != null) {
                        this.d.k.d0(s19.b(this.d.f, chatRoomDetail), chatRoomDetail.getBots());
                        if (this.d.k.i()) {
                            this.d.x3(ViewState.GONE);
                        }
                    }
                    if (this.d.f3() != null) {
                        this.d.f3().A0(chatRoomDetail);
                    }
                    this.d.i.n1(chatRoomDetail);
                    if (this.d.l != null && chatRoomDetail.getGroupChatResource() != null) {
                        this.d.l.a(chatRoomDetail.getGroupChatResource().getEggRainData(), this.d.getPageContext());
                    }
                    this.d.Q2(chatRoomDetail);
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.d.getPageContext(), new String[]{chatRoomDetail.getJumpH5ErrUrl()});
                this.d.requireActivity().finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements k09 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        public k(GroupChatFragment groupChatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatFragment;
        }

        @Override // com.baidu.tieba.k09
        public void a(BaseItem<? extends TbBaseMsg> baseItem, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, baseItem, i, i2) == null) {
                if (i == 5 && this.a.m != null && this.a.m.getTodayChatMsgCount() <= 0) {
                    this.a.m.setTodayChatMsgCount(1);
                    List<String> inputTipsList = this.a.m.getInputTipsList();
                    if (inputTipsList != null && !inputTipsList.isEmpty()) {
                        inputTipsList.remove(0);
                    }
                    GroupChatFragment groupChatFragment = this.a;
                    groupChatFragment.Q2(groupChatFragment.m);
                }
                if (i == 5) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (this.a.m != null && this.a.m.getBasicInfo() != null) {
                            jSONObject.put("forum_id", String.valueOf(this.a.m.getBasicInfo().getForumId()));
                        }
                        jSONObject.put("chatroom_id", String.valueOf(this.a.f));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    oo4.d().c("group_chat", jSONObject.toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements MsgProcessor.e<TbNoUISysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        public l(GroupChatFragment groupChatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im.base.core.repo.MsgProcessor.e
        @MainThread
        /* renamed from: b */
        public void a(@NonNull TbNoUISysMsg tbNoUISysMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbNoUISysMsg) == null) {
                if (tbNoUISysMsg.getType() == -7010) {
                    this.a.h.u0(false);
                    this.a.h.b0();
                    GroupChatFragment groupChatFragment = this.a;
                    groupChatFragment.y3(false, groupChatFragment.getStringSafely(R.string.obfuscated_res_0x7f0f0955));
                    this.a.C3(R.string.obfuscated_res_0x7f0f0948, R.string.obfuscated_res_0x7f0f0947, R.string.obfuscated_res_0x7f0f0971);
                    return;
                }
                if (this.a.k != null && tbNoUISysMsg.getMaskInfo() != null) {
                    this.a.k.b(tbNoUISysMsg.getMaskInfo());
                }
                if (this.a.m == null) {
                    return;
                }
                GroupChatFragment groupChatFragment2 = this.a;
                if (!groupChatFragment2.U2(groupChatFragment2.m, tbNoUISysMsg) && tbNoUISysMsg.getType() == 7016 && tbNoUISysMsg.getExt() != null && tbNoUISysMsg.getExt().getEggRain() != null && tbNoUISysMsg.getUserFrom() != null && tbNoUISysMsg.getUserFrom().getUserId() != TbadkCoreApplication.getCurrentAccountId() && this.a.i.J0() != null && this.a.m.getChatConf() != null) {
                    this.a.i.J0().g0(tbNoUISysMsg.getExt().getEggRain(), this.a.m.getChatConf().getResourceMaxTimeDelay() * 1000, tbNoUISysMsg.getSessionId(), tbNoUISysMsg.isMaster());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements InputToolFragment.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        public m(GroupChatFragment groupChatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatFragment;
        }

        @Override // com.baidu.tieba.im.base.core.inputtool.InputToolFragment.h
        public int A() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.e.e.getVisibility() == 8) {
                    return 0;
                }
                return this.a.e.e.getHeight();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public NoNetworkView b;
        public LinearLayout c;
        public ViewGroup d;
        public FrameLayout e;
        public FrameLayout f;
        public FrameLayout g;
        public FrameLayout h;
        public FrameLayout i;
        public FragmentContainerView j;

        public n() {
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

        public static n a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                n nVar = new n();
                nVar.a = view2;
                nVar.b = (NoNetworkView) view2.findViewById(R.id.obfuscated_res_0x7f0919f4);
                nVar.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906fe);
                nVar.d = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f090708);
                nVar.e = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0908fb);
                nVar.f = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092682);
                nVar.g = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09286b);
                nVar.h = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09193c);
                nVar.i = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092375);
                nVar.j = (FragmentContainerView) view2.findViewById(R.id.obfuscated_res_0x7f0906ec);
                return nVar;
            }
            return (n) invokeL.objValue;
        }
    }

    public GroupChatFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = -1;
        this.x = 0L;
        this.y = 0L;
        this.z = BdUniqueId.gen();
        this.C = new e(this, 2000994);
        this.D = new f(this, 2921779);
        this.E = new g(this, 2921780);
        this.F = new h(this);
        this.G = new i(this);
        this.H = new j(this);
    }

    public final void B3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && f3() != null) {
            hideNetRefreshView(getView());
            this.mRefreshView = null;
            f3().B0(8);
            rk8 rk8Var = this.B;
            if (rk8Var != null) {
                rk8Var.C0(false);
            }
            x3(ViewState.GONE);
            l3().setVisibility(8);
            showLoadingView(getView());
            LoadingView loadingView = this.loadingView;
            if (loadingView != null) {
                loadingView.getAttachedView().setClickable(false);
                this.loadingView.cancelCenterVertical();
                this.loadingView.setLayoutMarginWithHeaderHeightAndPercent(0, 0.4f);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onDestroy();
            ln8.d();
            w3();
            long currentTimeMillis = System.currentTimeMillis();
            this.y = currentTimeMillis;
            long j2 = currentTimeMillis - this.x;
            this.x = 0L;
            this.y = 0L;
            I = 0L;
            InputDelegate inputDelegate = this.k;
            if (inputDelegate != null) {
                inputDelegate.Q(null);
            }
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                uv8.a("c15323", j2, this.m.getBasicInfo().getForumId(), this.f);
            }
        }
    }

    public void p3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && getArguments() != null && getArguments().getSerializable("chat_bot_ability") != null) {
            AbilityItem abilityItem = (AbilityItem) getArguments().getSerializable("chat_bot_ability");
            if (this.i != null && !TextUtils.isEmpty(abilityItem.getType())) {
                this.i.q(abilityItem);
                getArguments().putSerializable("chat_bot_ability", null);
            }
        }
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            InputToolFragment inputToolFragment = new InputToolFragment();
            this.s = inputToolFragment;
            inputToolFragment.m3(this);
            Intent intent = new Intent();
            intent.putExtra("roomId", this.f);
            intent.putExtra("forumId", Y2());
            this.s.setArguments(intent.getExtras());
            if (getActivity() != null) {
                dt5.a(getChildFragmentManager(), R.id.obfuscated_res_0x7f0906ec, this.s);
            }
            InputToolFragment inputToolFragment2 = this.s;
            this.B = inputToolFragment2;
            n nVar = this.e;
            inputToolFragment2.t3(nVar.a, nVar.d);
            this.s.o3(new m(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            n a2 = n.a(view2);
            this.e = a2;
            ViewCommonUtil.setViewMargin(a2.c, -1, UtilHelper.getStatusBarHeight(), -1, -1);
            r3();
            u3();
        }
    }

    public final void y3(boolean z, String str) {
        InputDelegate inputDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048635, this, z, str) == null) && (inputDelegate = this.k) != null) {
            inputDelegate.U(str);
            this.k.c0(z);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    public final boolean s3(@NonNull ChatRoomDetail chatRoomDetail) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, chatRoomDetail)) == null) {
            ChatRoomDetail.UserInfo userInfo = chatRoomDetail.getUserInfo();
            if (userInfo != null && userInfo.getIdentityRole() == 4) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048616, this, layoutInflater, viewGroup, bundle)) == null) {
            pza.b(this, new Pair[0]);
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d033d, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public final void A3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hideLoadingView(getView());
            this.loadingView = null;
            showNetRefreshView(getView(), null, false);
            vj5 vj5Var = this.mRefreshView;
            if (vj5Var != null) {
                vj5Var.getAttachedView().setClickable(false);
                this.mRefreshView.k(UtilHelper.getStatusBarHeight());
                this.mRefreshView.e(R.color.transparent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onResume();
            ln8.d();
            I = this.f;
            NoNetworkView noNetworkView = this.e.b;
            if (noNetworkView != null) {
                mv8.y(noNetworkView);
            }
            GroupChatRepo groupChatRepo = this.h;
            if (groupChatRepo != null) {
                groupChatRepo.r0(this.F, this.w);
            }
            if (getArguments() != null && getArguments().getBoolean("is_new_intent")) {
                p3();
            }
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && f3() != null && !f3().u0()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921784, String.valueOf(this.f)));
        }
    }

    public final void C3(@StringRes int i2, @StringRes int i3, @StringRes int i4) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4) != null) || (baseFragmentActivity = getBaseFragmentActivity()) == null) {
            return;
        }
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(baseFragmentActivity);
        tBAlertBuilder.setTitleStr(getStringSafely(i2));
        tBAlertBuilder.setDescStr(getStringSafely(i3));
        tBAlertBuilder.setOperateBtn(new TBAlertConfig.OperateBtnConfig(getStringSafely(i4), TBAlertConfig.OperateBtnStyle.MAIN, new a(this, tBAlertBuilder, baseFragmentActivity)));
        tBAlertBuilder.setOnKeyListener(new b(this));
        tBAlertBuilder.create().setCanceledOnTouchOutside(false);
        tBAlertBuilder.show();
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048621, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (i2 == 1) {
                if (PermissionUtil.checkCamera(getContext())) {
                    SelectImageHelper.takePhoto(getPageContext());
                } else {
                    BdUtilHelper.showToast(getContext(), (int) R.string.system_permission_prompt_camera);
                }
                ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
                if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                    BdUtilHelper.showToast(getContext(), (int) R.string.sdcard_permission_denied_advert_for_camera);
                }
            }
        }
    }

    public void D3() {
        GroupChatRepo groupChatRepo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (groupChatRepo = this.h) != null) {
            groupChatRepo.v0();
        }
    }

    @Override // com.baidu.tieba.gk8
    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e.e.getVisibility();
        }
        return invokeV.intValue;
    }

    public boolean P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (f3() == null || this.h == null) {
                return true;
            }
            return !f3().I0(this.h.k0());
        }
        return invokeV.booleanValue;
    }

    public boolean R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.loadingView == null && this.mRefreshView == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.j.e();
        }
    }

    public boolean T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            InputDelegate inputDelegate = this.k;
            if (inputDelegate != null && inputDelegate.i()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void V2() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (chatPage = this.i) != null) {
            chatPage.G0();
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            InputDelegate inputDelegate = this.k;
            if (inputDelegate != null) {
                inputDelegate.a0(this.i);
            }
            InputDelegate inputDelegate2 = this.k;
            if (inputDelegate2 != null) {
                inputDelegate2.Q(new j09(this));
            }
        }
    }

    @Nullable
    public VoiceManager X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            InputDelegate inputDelegate = this.k;
            if (inputDelegate == null) {
                return null;
            }
            return inputDelegate.z();
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Nullable
    public ChatPage X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.i;
        }
        return (ChatPage) invokeV.objValue;
    }

    public long Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                return this.m.getBasicInfo().getForumId();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                return this.m.getBasicInfo().getForumName();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    @NonNull
    public DirectChatSlice b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.o;
        }
        return (DirectChatSlice) invokeV.objValue;
    }

    @Nullable
    public EffectSlice c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.n;
        }
        return (EffectSlice) invokeV.objValue;
    }

    @NonNull
    public EmojiReplayDetailSlice d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.v;
        }
        return (EmojiReplayDetailSlice) invokeV.objValue;
    }

    @Nullable
    public InputToolFragment e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.s;
        }
        return (InputToolFragment) invokeV.objValue;
    }

    @Nullable
    public NavigationBarSlice f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.t;
        }
        return (NavigationBarSlice) invokeV.objValue;
    }

    @NonNull
    public ReplayEmojiSlice g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.u;
        }
        return (ReplayEmojiSlice) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qza
    @NonNull
    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return Integer.toString(this.z.getId());
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public ResponsesPanelController h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.j;
        }
        return (ResponsesPanelController) invokeV.objValue;
    }

    public final void hideLoading() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && f3() != null) {
            f3().B0(0);
            rk8 rk8Var = this.B;
            if (rk8Var != null) {
                rk8Var.C0(true);
            }
            hideLoadingView(getView());
            this.loadingView = null;
        }
    }

    @Nullable
    public SubscribeSlice i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.r;
        }
        return (SubscribeSlice) invokeV.objValue;
    }

    public FrameLayout j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.e.i;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Nullable
    public TopBubbleSlice k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.p;
        }
        return (TopBubbleSlice) invokeV.objValue;
    }

    public FrameLayout l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.e.f;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Nullable
    public UpBubbleSlice m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.q;
        }
        return (UpBubbleSlice) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gk8
    public void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            InputToolFragment inputToolFragment = this.s;
            if (inputToolFragment != null) {
                InputDelegate P2 = inputToolFragment.P2();
                this.k = P2;
                ChatPage chatPage = this.i;
                if (chatPage != null && P2 != null) {
                    P2.M(chatPage.H0());
                }
            }
            ChatPage chatPage2 = this.i;
            if (chatPage2 != null) {
                chatPage2.C0(X0());
            }
        }
    }

    public FrameLayout n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.e.g;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public void o3() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (chatPage = this.i) != null) {
            chatPage.M0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onNetRefreshButtonClicked();
            GroupChatRepo groupChatRepo = this.h;
            if (groupChatRepo != null) {
                groupChatRepo.i0(this.G, this.H, this.w);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onPause();
            I = 0L;
            v3();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onStart();
            W2();
        }
    }

    public boolean q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            InputDelegate inputDelegate = this.k;
            if (inputDelegate != null && inputDelegate.s() != null && !"".equals(this.k.s())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            registerListener(this.C);
            registerListener(this.D);
            registerListener(this.E);
        }
    }

    public void z3() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && (chatPage = this.i) != null) {
            chatPage.r1();
        }
    }

    public final void Q2(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, chatRoomDetail) == null) {
            InputDelegate inputDelegate = this.k;
            if (inputDelegate != null && inputDelegate.i()) {
                x3(ViewState.GONE);
                return;
            }
            List<String> inputTipsList = chatRoomDetail.getInputTipsList();
            if (inputTipsList != null && !inputTipsList.isEmpty()) {
                y3(true, inputTipsList.get(0));
            } else if (chatRoomDetail.getBots() != null && !qd.isEmpty(chatRoomDetail.getBots().getGuide())) {
                y3(true, chatRoomDetail.getBots().getGuide());
            } else {
                y3(true, getStringSafely(R.string.im_msg_input_hint));
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048614, this, i2) != null) || this.g == i2) {
            return;
        }
        this.g = i2;
        super.onChangeSkinType(i2);
        NoNetworkView noNetworkView = this.e.b;
        if (noNetworkView != null) {
            noNetworkView.onChangeSkinType(getPageContext(), i2);
        }
        if (UtilHelper.isNightOrDarkMode()) {
            EMManager.from(this.e.a).setBackGroundColor(R.color.CAM_X0201);
        } else {
            Glide.with(this.e.a).load(vq6.b("chat_room_background.webp", "chat_room_background")).into((RequestBuilder<Drawable>) new d(this));
        }
        this.j.onChangeSkinType();
    }

    public final boolean U2(@NonNull ChatRoomDetail chatRoomDetail, @NonNull TbNoUISysMsg tbNoUISysMsg) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, chatRoomDetail, tbNoUISysMsg)) == null) {
            boolean z = false;
            int i3 = 0;
            z = false;
            z = false;
            z = false;
            z = false;
            z = false;
            z = false;
            z = false;
            if (this.k == null) {
                return false;
            }
            int type = tbNoUISysMsg.getType();
            ChatRoomDetail.ExtraInfo extraInfo = chatRoomDetail.getExtraInfo();
            ChatRoomDetail.UserInfo userInfo = chatRoomDetail.getUserInfo();
            zl8 y = this.k.y();
            TbSysMsg.ChatRoomInfo chatroomInfo = tbNoUISysMsg.getChatroomInfo();
            long j2 = 0;
            switch (type) {
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE /* 7003 */:
                    if (tbNoUISysMsg.getUserTo() != null) {
                        j2 = tbNoUISysMsg.getUserTo().getUserId();
                    }
                    if (!s3(chatRoomDetail) && j2 == TbadkCoreApplication.getCurrentAccountId()) {
                        if (userInfo != null) {
                            userInfo.setIsBeenTalkBanned(1);
                        }
                        y.g(type);
                        S2();
                        z = true;
                        break;
                    }
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE /* 7004 */:
                    if (tbNoUISysMsg.getUserTo() != null) {
                        j2 = tbNoUISysMsg.getUserTo().getUserId();
                    }
                    if (j2 == TbadkCoreApplication.getCurrentAccountId()) {
                        y.b(type);
                        if (userInfo != null) {
                            userInfo.setIsBeenTalkBanned(0);
                        }
                        S2();
                        z = true;
                        break;
                    }
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE_ALL /* 7005 */:
                    if (extraInfo != null) {
                        extraInfo.setIsTalkBanned(1);
                    }
                    y.g(type);
                    S2();
                    z = true;
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE_ALL /* 7006 */:
                    y.b(type);
                    if (extraInfo != null) {
                        extraInfo.setIsTalkBanned(0);
                    }
                    S2();
                    z = true;
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_FROZEN /* 7007 */:
                    if (extraInfo != null) {
                        extraInfo.setIsFreezing(1);
                    }
                    y.g(type);
                    z = true;
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_FROZEN /* 7008 */:
                    y.b(type);
                    if (extraInfo != null) {
                        extraInfo.setIsFreezing(0);
                    }
                    z = true;
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_POST /* 7011 */:
                    if (chatroomInfo != null && extraInfo != null) {
                        int talkThresholdLevel = chatroomInfo.getTalkThresholdLevel();
                        int talkType = chatroomInfo.getTalkType();
                        int forumLevel = userInfo.getForumLevel();
                        extraInfo.setTalkThresholdLevel(talkThresholdLevel);
                        extraInfo.setTalkType(talkType);
                        if (!s3(chatRoomDetail) && this.k.h(talkThresholdLevel, forumLevel)) {
                            y.g(type);
                        } else {
                            y.b(type);
                        }
                        z = true;
                        break;
                    }
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_VIEW /* 7012 */:
                    if (chatroomInfo != null && userInfo != null) {
                        if (userInfo.getIdentityRole() < chatroomInfo.getChatroomViewType()) {
                            GroupChatRepo groupChatRepo = this.h;
                            if (groupChatRepo != null) {
                                groupChatRepo.b0();
                            }
                            y.g(type);
                            C3(R.string.obfuscated_res_0x7f0f0b9c, R.string.obfuscated_res_0x7f0f0b9d, R.string.obfuscated_res_0x7f0f0971);
                        } else {
                            y.b(type);
                        }
                        z = true;
                        break;
                    }
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_ONLY_MANAGER_CAN_TALK /* 7013 */:
                    if (chatroomInfo != null) {
                        i2 = chatroomInfo.getTalkType();
                    } else {
                        i2 = 0;
                    }
                    if (userInfo != null) {
                        i3 = userInfo.getIdentityRole();
                    }
                    if (!s3(chatRoomDetail) && i2 == 1 && (i3 < 1 || i3 > 4)) {
                        if (extraInfo != null) {
                            extraInfo.setTalkType(1);
                        }
                        y.g(type);
                    } else {
                        y.b(type);
                    }
                    z = true;
                    break;
            }
            if (z) {
                Q2(chatRoomDetail);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
            super.onActivityCreated(bundle);
            NavigationBarSlice navigationBarSlice = new NavigationBarSlice(getPageContext(), this);
            this.t = navigationBarSlice;
            u2(this.e.h, navigationBarSlice);
            this.t.C0(this.A);
            SubscribeSlice subscribeSlice = new SubscribeSlice(getPageContext(), this);
            this.r = subscribeSlice;
            u2(this.e.i, subscribeSlice);
            EmojiReplayDetailSlice emojiReplayDetailSlice = new EmojiReplayDetailSlice(getPageContext(), this, this.f);
            this.v = emojiReplayDetailSlice;
            u2((ViewGroup) this.e.a, emojiReplayDetailSlice);
            EffectSlice effectSlice = new EffectSlice(getPageContext());
            this.n = effectSlice;
            u2((ViewGroup) this.e.a, effectSlice);
            this.h = new GroupChatRepo(getPageContext(), this.f);
            this.j = new ResponsesPanelControllerImpl(this);
            ChatPage chatPage = new ChatPage(this, this.h);
            this.i = chatPage;
            this.j.f(chatPage.j1());
            InputToolFragment inputToolFragment = this.s;
            if (inputToolFragment != null) {
                inputToolFragment.n3(this.i.j1());
            }
            u2(this.e.d, this.i);
            W2();
            ReplayEmojiSlice replayEmojiSlice = new ReplayEmojiSlice(getPageContext(), this, this.i.j1());
            this.u = replayEmojiSlice;
            u2((ViewGroup) this.e.a, replayEmojiSlice);
            UpBubbleSlice upBubbleSlice = new UpBubbleSlice(getPageContext(), this, this.i);
            this.q = upBubbleSlice;
            u2(this.e.g, upBubbleSlice);
            TopBubbleSlice topBubbleSlice = new TopBubbleSlice(getPageContext(), this, this.i, this.f);
            this.p = topBubbleSlice;
            u2(this.e.f, topBubbleSlice);
            DirectChatSlice directChatSlice = new DirectChatSlice(getPageContext(), this.i.j1());
            this.o = directChatSlice;
            u2(this.e.e, directChatSlice);
            this.l = new n19();
            getLifecycle().addObserver(this.h);
            getLifecycle().addObserver(this.j);
            this.i.p1(new k(this));
            this.h.i0(this.G, this.H, this.w);
            this.h.D(new l(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            tt5.b(arguments);
            this.f = arguments.getLong("roomId");
            arguments.getInt("requestCode", -1);
            this.w = arguments.getInt(IntentConfig.OBJ_LOCATED);
            this.A = arguments.getString("hotListText");
            ln8.e();
            this.x = System.currentTimeMillis();
        }
    }

    public void x3(ViewState viewState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, viewState) == null) {
            if (viewState == ViewState.VISIBLE) {
                this.e.e.setVisibility(0);
            } else if (viewState == ViewState.INVISIBLE) {
                this.e.e.setVisibility(4);
            } else {
                this.e.e.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        InputDelegate inputDelegate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048618, this, i2, keyEvent)) == null) {
            if (i2 == 4 && !P2()) {
                return true;
            }
            if (i2 == 4 && this.s != null && (inputDelegate = this.k) != null) {
                if (inputDelegate.v()) {
                    this.k.Y(null);
                    return true;
                } else if (this.s.W2() && this.k.p() == BotSourceType.ONE) {
                    this.k.J(null);
                    return true;
                }
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void t3(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getQuickTalk() != null && !ListUtils.isEmpty(this.m.getQuickTalk())) {
                InputToolFragment inputToolFragment = this.s;
                boolean z6 = false;
                if (inputToolFragment != null && inputToolFragment.U2() != null) {
                    z2 = this.s.U2().n();
                } else {
                    z2 = false;
                }
                InputDelegate inputDelegate = this.k;
                if (inputDelegate != null) {
                    z3 = inputDelegate.u();
                } else {
                    z3 = false;
                }
                InputDelegate inputDelegate2 = this.k;
                if (inputDelegate2 != null) {
                    z4 = inputDelegate2.r();
                } else {
                    z4 = false;
                }
                InputToolFragment inputToolFragment2 = this.s;
                if (inputToolFragment2 != null && inputToolFragment2.M2() != null) {
                    z6 = this.s.M2().e0();
                    z5 = this.s.M2().c0();
                } else {
                    z5 = false;
                }
                if (z) {
                    if (!z2 && !z3 && !z4 && !z6 && !z5 && !q3()) {
                        x3(ViewState.VISIBLE);
                        return;
                    } else {
                        x3(ViewState.INVISIBLE);
                        return;
                    }
                } else if (!z2 && !z3 && !z4 && !q3()) {
                    x3(ViewState.VISIBLE);
                    return;
                } else {
                    x3(ViewState.INVISIBLE);
                    return;
                }
            }
            x3(ViewState.GONE);
        }
    }

    public final void v3() {
        BaseItem<? extends TbBaseMsg> j0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048632, this) == null) && this.h != null && this.m != null && f3() != null && (j0 = this.h.j0()) != null) {
            TbBaseMsg tbMsg = j0.getTbMsg();
            ChatRoomDetail.BasicInfo basicInfo = this.m.getBasicInfo();
            UiUtils.runOnBgThread(new c(this, basicInfo, tbMsg, f3().u0(), TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis())));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921773, new k19(j0.getTbMsg(), basicInfo.getId())));
        }
    }
}
