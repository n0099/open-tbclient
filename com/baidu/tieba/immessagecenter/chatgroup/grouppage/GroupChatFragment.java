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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
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
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.R;
import com.baidu.tieba.as8;
import com.baidu.tieba.ei;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.impl.ResponsesPanelControllerImpl;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.positionbubble.UpBubbleSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.subscribe.SubscribeSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.NoUISysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.directchat.DirectChatSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.effect.EffectSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.ReplayEmojiSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.detail.EmojiReplayDetailSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.navigationbar.NavigationBarSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.ChatMsgProcessor;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.immessagecenter.slice.SliceFragment;
import com.baidu.tieba.lf8;
import com.baidu.tieba.mg;
import com.baidu.tieba.po5;
import com.baidu.tieba.ppa;
import com.baidu.tieba.qpa;
import com.baidu.tieba.qt4;
import com.baidu.tieba.qu6;
import com.baidu.tieba.qx5;
import com.baidu.tieba.rr8;
import com.baidu.tieba.sr8;
import com.baidu.tieba.tn8;
import com.baidu.tieba.wn5;
import com.baidu.tieba.xr8;
import com.baidu.tieba.zn8;
import com.baidu.tieba.zo8;
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
public class GroupChatFragment extends SliceFragment implements qpa {
    public static /* synthetic */ Interceptable $ic;
    public static long G;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    public final CustomMessageListener B;
    public final CustomMessageListener C;
    public final FastRequest.b<ChatRoomDetail> D;
    public final FastRequest.b<ChatRoomDetail> E;
    public final po5 F;
    public m e;
    public long f;
    public int g;
    @Nullable
    public GroupChatRepo h;
    @Nullable
    public ChatPage i;
    @NonNull
    public ResponsesPanelController j;
    public GroupInputViewController k;
    public xr8 l;
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
    public NavigationBarSlice s;
    @NonNull
    public ReplayEmojiSlice t;
    @NonNull
    public EmojiReplayDetailSlice u;
    public int v;
    public long w;
    public long x;
    public BdUniqueId y;
    public String z;

    @Override // com.baidu.tieba.qpa
    @NonNull
    public String getScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? "chatroom" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class i implements po5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ i b;

            public a(i iVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = iVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a != 0) {
                        this.b.a.c3();
                        if (this.a == 430) {
                            BdUtilHelper.showLongToast(this.b.a.getContext(), this.b.a.getStringSafely(R.string.obfuscated_res_0x7f0f0937));
                            return;
                        } else {
                            BdUtilHelper.showLongToast(this.b.a.getContext(), this.b.a.getStringSafely(R.string.obfuscated_res_0x7f0f0938, Integer.valueOf(this.a)));
                            return;
                        }
                    }
                    this.b.a.hideLoading();
                }
            }
        }

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
            this.a = groupChatFragment;
        }

        @Override // com.baidu.tieba.po5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) {
                tn8.f(j, i, str);
                mg.g(new a(this, i));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) ? i == 4 : invokeLIL.booleanValue;
        }

        public a(GroupChatFragment groupChatFragment) {
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
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatRoomDetail.BasicInfo a;
        public final /* synthetic */ CommonMsgField b;
        public final /* synthetic */ BaseMsg c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ long e;
        public final /* synthetic */ GroupChatFragment f;

        public b(GroupChatFragment groupChatFragment, ChatRoomDetail.BasicInfo basicInfo, CommonMsgField commonMsgField, BaseMsg baseMsg, boolean z, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment, basicInfo, commonMsgField, baseMsg, Boolean.valueOf(z), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = groupChatFragment;
            this.a = basicInfo;
            this.b = commonMsgField;
            this.c = baseMsg;
            this.d = z;
            this.e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lf8.j().s(TbadkCoreApplication.getCurrentAccount(), this.a.getName(), this.a.getAvatar(), String.valueOf(this.a.getForumId()), this.a.getForumName(), this.a.getId(), this.b.getMsgId(), this.c.getSdkMsg().getMsgTime(), this.d, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends SimpleTarget<Drawable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        public c(GroupChatFragment groupChatFragment) {
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
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(GroupChatFragment groupChatFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.e.c != null) {
                zo8.w(this.a.e.c);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.F2() != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.F2().m0((String) customResponsedMessage.getData());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.h != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.h.Z(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment b;

        public g(GroupChatFragment groupChatFragment) {
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
            this.b = groupChatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void f(@NonNull ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatRoomDetail) == null) {
                super.f(chatRoomDetail);
                this.b.m = chatRoomDetail;
                this.b.F2().x0(chatRoomDetail);
                if (this.b.k != null) {
                    this.b.k.T0().h(chatRoomDetail);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment b;

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
            this.b = groupChatFragment;
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.e();
                this.b.d3();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void c(String str, int i, @NonNull String str2, @Nullable ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048579, this, str, i, str2, chatRoomDetail) == null) {
                super.b(i, str2, chatRoomDetail);
                ppa.a(this.b, new Pair(PushMessageHelper.ERROR_TYPE, Integer.toString(i)), new Pair("error_info", str2), new Pair("log_id", str));
                tn8.i(false, this.b.f, i, str2);
                this.b.c3();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: h */
        public void f(@NonNull ChatRoomDetail chatRoomDetail) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, chatRoomDetail) == null) {
                super.f(chatRoomDetail);
                if (chatRoomDetail.isJumpH5()) {
                    UrlManager.getInstance().dealOneLink(this.b.getPageContext(), new String[]{chatRoomDetail.getJumpH5ErrUrl()});
                    this.b.requireActivity().finish();
                    return;
                }
                ppa.c(this.b, new Pair[0]);
                this.b.m = chatRoomDetail;
                if (this.b.v2() != null && chatRoomDetail.getBasicInfo() != null) {
                    this.b.v2().n0(this.b.f, chatRoomDetail.getBasicInfo().getForumId());
                }
                tn8.i(true, this.b.f, 0, DnsModel.MSG_OK);
                this.b.I2().f0(chatRoomDetail);
                this.b.t.i0(chatRoomDetail.getReactions());
                if (!ListUtils.isEmpty(chatRoomDetail.getQuickTalk()) && !this.b.R2()) {
                    this.b.U2(true);
                } else {
                    this.b.U2(false);
                }
                this.b.B2().b0(chatRoomDetail);
                if (this.b.L2() != null) {
                    TopBubbleSlice L2 = this.b.L2();
                    if (chatRoomDetail.getBasicInfo() != null) {
                        j = chatRoomDetail.getBasicInfo().getForumId();
                    } else {
                        j = 0;
                    }
                    L2.s0(j);
                    if (!ListUtils.isEmpty(chatRoomDetail.getChatBubbleData())) {
                        this.b.L2().q0(chatRoomDetail.getChatBubbleData());
                    }
                }
                if (this.b.N2() != null) {
                    this.b.N2().o0(chatRoomDetail);
                }
                if (this.b.J2() != null) {
                    this.b.J2().l0(chatRoomDetail, this.b.h);
                }
                if (this.b.k != null && this.b.k.T0().d()) {
                    this.b.U2(false);
                }
                if (this.b.k != null) {
                    this.b.k.T0().h(chatRoomDetail);
                    if (!ListUtils.isEmpty(chatRoomDetail.getMaskInfoList())) {
                        this.b.k.T0().e(chatRoomDetail.getMaskInfoList());
                    }
                }
                if (this.b.k != null && chatRoomDetail != null && chatRoomDetail.getBots() != null) {
                    this.b.k.y1(chatRoomDetail.getBots());
                }
                if (this.b.k != null && chatRoomDetail != null && chatRoomDetail.getBots() != null) {
                    this.b.k.z1(chatRoomDetail.getBots().getGuide());
                }
                if (this.b.F2() != null) {
                    this.b.F2().x0(chatRoomDetail);
                }
                this.b.i.k1(chatRoomDetail);
                if (this.b.l != null && chatRoomDetail.getGroupChatResource() != null) {
                    this.b.l.a(chatRoomDetail.getGroupChatResource().getEggRainData(), this.b.getPageContext());
                }
                this.b.q2(chatRoomDetail);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements zn8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

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

        @Override // com.baidu.tieba.zn8
        public void a(BaseMsg baseMsg, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, baseMsg, i, i2) == null) {
                if (i == 5 && this.a.m != null && this.a.m.getTodayChatMsgCount() <= 0) {
                    this.a.m.setTodayChatMsgCount(1);
                    List<String> inputTipsList = this.a.m.getInputTipsList();
                    if (inputTipsList != null && !inputTipsList.isEmpty()) {
                        inputTipsList.remove(0);
                    }
                    GroupChatFragment groupChatFragment = this.a;
                    groupChatFragment.q2(groupChatFragment.m);
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
                    qt4.d().c("group_chat", jSONObject.toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements ChatMsgProcessor.k<NoUISysMsg> {
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.ChatMsgProcessor.k
        @MainThread
        public void b(@NonNull ChatMsg chatMsg) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMsg) == null) && chatMsg.getNotifyCmd() == 102) {
                this.a.h.l0(false);
                this.a.h.L();
                GroupChatFragment groupChatFragment = this.a;
                groupChatFragment.Z2(false, groupChatFragment.getStringSafely(R.string.obfuscated_res_0x7f0f093f));
                this.a.e3(R.string.obfuscated_res_0x7f0f0932, R.string.obfuscated_res_0x7f0f0931, R.string.obfuscated_res_0x7f0f0958);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.ChatMsgProcessor.k
        @MainThread
        /* renamed from: c */
        public void a(@NonNull NoUISysMsg noUISysMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, noUISysMsg) == null) {
                if (this.a.k != null && noUISysMsg.getMaskInfo() != null) {
                    this.a.k.T0().c(noUISysMsg.getMaskInfo());
                }
                if (this.a.m == null) {
                    return;
                }
                GroupChatFragment groupChatFragment = this.a;
                if (!groupChatFragment.t2(groupChatFragment.m, noUISysMsg) && noUISysMsg.getMsgType() == 7016 && noUISysMsg.getExt() != null && noUISysMsg.getExt().getEggRain() != null && noUISysMsg.getUserFrom() != null && noUISysMsg.getUserFrom().getUserId() != TbadkCoreApplication.getCurrentAccountId() && this.a.i.G0() != null && this.a.m.getChatConf() != null) {
                    this.a.i.G0().d0(noUISysMsg.getExt().getEggRain(), this.a.m.getChatConf().getResourceMaxTimeDelay() * 1000, noUISysMsg.getCommonMsgField().getRoomId(), !noUISysMsg.isLeft());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;
        public final /* synthetic */ BaseFragmentActivity b;
        public final /* synthetic */ GroupChatFragment c;

        public l(GroupChatFragment groupChatFragment, TBAlertBuilder tBAlertBuilder, BaseFragmentActivity baseFragmentActivity) {
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
    public static class m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public View b;
        public NoNetworkView c;
        public LinearLayout d;
        public ViewGroup e;
        public FrameLayout f;
        public FrameLayout g;
        public FrameLayout h;
        public FrameLayout i;
        public FrameLayout j;
        public View k;

        public m() {
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

        public static m a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                m mVar = new m();
                mVar.a = view2;
                mVar.b = view2.findViewById(R.id.obfuscated_res_0x7f090ea1);
                mVar.c = (NoNetworkView) view2.findViewById(R.id.obfuscated_res_0x7f091998);
                mVar.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906ca);
                mVar.e = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0906d5);
                mVar.f = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0908c8);
                mVar.k = view2.findViewById(R.id.obfuscated_res_0x7f0908d1);
                mVar.g = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092656);
                mVar.h = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09284c);
                mVar.i = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0918dd);
                mVar.j = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092349);
                return mVar;
            }
            return (m) invokeL.objValue;
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
        this.w = 0L;
        this.x = 0L;
        this.y = BdUniqueId.gen();
        this.A = new d(this, 2000994);
        this.B = new e(this, 2921779);
        this.C = new f(this, 2921780);
        this.D = new g(this);
        this.E = new h(this);
        this.F = new i(this);
    }

    public void Q2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && getArguments() != null && getArguments().getSerializable("chat_bot_ability") != null) {
            AbilityItem abilityItem = (AbilityItem) getArguments().getSerializable("chat_bot_ability");
            if (this.i != null && !TextUtils.isEmpty(abilityItem.getType())) {
                this.i.n(abilityItem);
                getArguments().putSerializable("chat_bot_ability", null);
            }
        }
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && F2() != null) {
            hideNetRefreshView(getView());
            this.mRefreshView = null;
            F2().y0(8);
            this.e.b.setVisibility(8);
            U2(false);
            M2().setVisibility(8);
            showLoadingView(getView());
            LoadingView loadingView = this.loadingView;
            if (loadingView != null) {
                loadingView.getAttachedView().setClickable(false);
                this.loadingView.cancelCenterVertical();
                this.loadingView.setLayoutMarginWithHeaderHeightAndPercent(0, 0.4f);
            }
        }
    }

    public final boolean S2(@NonNull ChatRoomDetail chatRoomDetail) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, chatRoomDetail)) == null) {
            ChatRoomDetail.UserInfo userInfo = chatRoomDetail.getUserInfo();
            if (userInfo != null && userInfo.getIdentityRole() == 4) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void U2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            if (z) {
                this.e.f.setVisibility(0);
                this.e.k.setVisibility(0);
                return;
            }
            this.e.f.setVisibility(8);
            this.e.k.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            GroupInputViewController groupInputViewController = this.k;
            if (groupInputViewController != null) {
                groupInputViewController.p1(bundle);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048613, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            GroupInputViewController groupInputViewController = this.k;
            if (groupInputViewController != null) {
                groupInputViewController.o1(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048616, this, layoutInflater, viewGroup, bundle)) == null) {
            ppa.b(this, new Pair[0]);
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d032e, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public final void Z2(boolean z, String str) {
        GroupInputViewController groupInputViewController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048601, this, z, str) == null) && (groupInputViewController = this.k) != null) {
            groupInputViewController.I1(str);
            this.k.Y1(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            m a2 = m.a(view2);
            this.e = a2;
            ViewCommonUtil.setViewMargin(a2.d, -1, UtilHelper.getStatusBarHeight(), -1, -1);
            W2();
        }
    }

    public String A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                return this.m.getBasicInfo().getName();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public DirectChatSlice B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.o;
        }
        return (DirectChatSlice) invokeV.objValue;
    }

    @NonNull
    public EmojiReplayDetailSlice C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.u;
        }
        return (EmojiReplayDetailSlice) invokeV.objValue;
    }

    public int D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getUserInfo() != null) {
                return this.m.getUserInfo().getIdentityRole();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public GroupInputViewController E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k;
        }
        return (GroupInputViewController) invokeV.objValue;
    }

    @Nullable
    public NavigationBarSlice F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.s;
        }
        return (NavigationBarSlice) invokeV.objValue;
    }

    @NonNull
    public ReplayEmojiSlice G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.t;
        }
        return (ReplayEmojiSlice) invokeV.objValue;
    }

    @NonNull
    public ResponsesPanelController H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.j;
        }
        return (ResponsesPanelController) invokeV.objValue;
    }

    @Nullable
    public EffectSlice I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.n;
        }
        return (EffectSlice) invokeV.objValue;
    }

    @Nullable
    public SubscribeSlice J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.r;
        }
        return (SubscribeSlice) invokeV.objValue;
    }

    public FrameLayout K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.e.j;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Nullable
    public TopBubbleSlice L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.p;
        }
        return (TopBubbleSlice) invokeV.objValue;
    }

    public FrameLayout M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.e.g;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Nullable
    public UpBubbleSlice N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.q;
        }
        return (UpBubbleSlice) invokeV.objValue;
    }

    public FrameLayout O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.e.h;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public void P2() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (chatPage = this.i) != null) {
            chatPage.J0();
        }
    }

    public void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.e.k.setVisibility(4);
            this.e.f.setVisibility(4);
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            registerListener(this.A);
            registerListener(this.B);
            registerListener(this.C);
        }
    }

    public boolean a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (!ListUtils.isEmpty(this.m.getQuickTalk()) && !R2()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void b3() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (chatPage = this.i) != null) {
            chatPage.p1();
        }
    }

    public void f3() {
        GroupChatRepo groupChatRepo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (groupChatRepo = this.h) != null) {
            groupChatRepo.n0();
        }
    }

    @Override // com.baidu.tieba.qpa
    @NonNull
    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return Integer.toString(this.v);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qpa
    @NonNull
    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return Integer.toString(this.y.getId());
        }
        return (String) invokeV.objValue;
    }

    public final void hideLoading() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && F2() != null) {
            F2().y0(0);
            this.e.b.setVisibility(0);
            hideLoadingView(getView());
            this.loadingView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onNetRefreshButtonClicked();
            GroupChatRepo groupChatRepo = this.h;
            if (groupChatRepo != null) {
                groupChatRepo.T(this.E, this.F, this.v);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onPause();
            G = 0L;
            X2();
        }
    }

    public boolean p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (F2() == null || this.h == null) {
                return true;
            }
            return !F2().F0(this.h.V());
        }
        return invokeV.booleanValue;
    }

    public boolean r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (this.loadingView == null && this.mRefreshView == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.j.f();
        }
    }

    public void u2() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && (chatPage = this.i) != null) {
            chatPage.D0();
        }
    }

    @Nullable
    public GroupInputTool v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            GroupInputViewController groupInputViewController = this.k;
            if (groupInputViewController != null) {
                return groupInputViewController.E0();
            }
            return null;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    @Nullable
    public ChatPage w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.i;
        }
        return (ChatPage) invokeV.objValue;
    }

    public long x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                return this.m.getBasicInfo().getForumId();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                return this.m.getBasicInfo().getForumName();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    public boolean R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (E2() != null && E2().I0() != null && !"".equals(E2().I0())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && F2() != null && !F2().r0()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921784, String.valueOf(this.f)));
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            hideLoadingView(getView());
            this.loadingView = null;
            showNetRefreshView(getView(), null, false);
            wn5 wn5Var = this.mRefreshView;
            if (wn5Var != null) {
                wn5Var.getAttachedView().setClickable(false);
                this.mRefreshView.k(UtilHelper.getStatusBarHeight());
                this.mRefreshView.e(R.color.transparent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onDestroy();
            tn8.d();
            Y2();
            long currentTimeMillis = System.currentTimeMillis();
            this.x = currentTimeMillis;
            long j2 = currentTimeMillis - this.w;
            this.w = 0L;
            this.x = 0L;
            G = 0L;
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                as8.a("c15323", j2, this.m.getBasicInfo().getForumId(), this.f);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onResume();
            tn8.d();
            G = this.f;
            NoNetworkView noNetworkView = this.e.c;
            if (noNetworkView != null) {
                zo8.w(noNetworkView);
            }
            GroupChatRepo groupChatRepo = this.h;
            if (groupChatRepo != null) {
                groupChatRepo.f0(this.D, this.v);
            }
            if (getArguments() != null && getArguments().getBoolean("is_new_intent")) {
                Q2();
            }
        }
    }

    public void T2(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getQuickTalk() != null && !ListUtils.isEmpty(this.m.getQuickTalk())) {
                if (E2() != null && E2().L0() != null) {
                    z2 = E2().L0().k();
                } else {
                    z2 = false;
                }
                if (E2() != null && E2().S0() != null) {
                    z3 = E2().S0().e();
                } else {
                    z3 = false;
                }
                if (E2() != null && E2().R0() != null) {
                    z4 = E2().R0().e();
                } else {
                    z4 = false;
                }
                if (E2() != null && E2().J0() != null) {
                    z5 = E2().J0().a0();
                    z6 = E2().J0().Y();
                } else {
                    z5 = false;
                    z6 = false;
                }
                if (z) {
                    if (!z2 && !z3 && !z4 && !z5 && !z6 && !R2()) {
                        U2(true);
                        return;
                    } else {
                        U2(false);
                        return;
                    }
                } else if (!z2 && !z3 && !z4 && !R2()) {
                    U2(true);
                    return;
                } else {
                    U2(false);
                    return;
                }
            }
            U2(false);
        }
    }

    public final void X2() {
        BaseMsg U;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.h != null && this.m != null && F2() != null && (U = this.h.U()) != null) {
            CommonMsgField commonMsgField = U.getCommonMsgField();
            ChatRoomDetail.BasicInfo basicInfo = this.m.getBasicInfo();
            mg.e(new b(this, basicInfo, commonMsgField, U, F2().r0(), TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis())));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921773, new sr8(U, basicInfo.getId())));
        }
    }

    public final void e3(@StringRes int i2, @StringRes int i3, @StringRes int i4) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIII(1048606, this, i2, i3, i4) != null) || (baseFragmentActivity = getBaseFragmentActivity()) == null) {
            return;
        }
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(baseFragmentActivity);
        tBAlertBuilder.setTitleStr(getStringSafely(i2));
        tBAlertBuilder.setDescStr(getStringSafely(i3));
        tBAlertBuilder.setOperateBtn(new TBAlertConfig.OperateBtnConfig(getStringSafely(i4), TBAlertConfig.OperateBtnStyle.MAIN, new l(this, tBAlertBuilder, baseFragmentActivity)));
        tBAlertBuilder.setOnKeyListener(new a(this));
        tBAlertBuilder.create().setCanceledOnTouchOutside(false);
        tBAlertBuilder.show();
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
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

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            super.onActivityCreated(bundle);
            NavigationBarSlice navigationBarSlice = new NavigationBarSlice(getPageContext(), this);
            this.s = navigationBarSlice;
            W1(this.e.i, navigationBarSlice);
            this.s.z0(this.z);
            SubscribeSlice subscribeSlice = new SubscribeSlice(getPageContext(), this);
            this.r = subscribeSlice;
            W1(this.e.j, subscribeSlice);
            EmojiReplayDetailSlice emojiReplayDetailSlice = new EmojiReplayDetailSlice(getPageContext(), this, this.f);
            this.u = emojiReplayDetailSlice;
            W1((ViewGroup) this.e.a, emojiReplayDetailSlice);
            EffectSlice effectSlice = new EffectSlice(getPageContext());
            this.n = effectSlice;
            W1((ViewGroup) this.e.a, effectSlice);
            this.h = new GroupChatRepo(getPageContext(), this.f);
            this.j = new ResponsesPanelControllerImpl(this);
            ChatPage chatPage = new ChatPage(this, this.h);
            this.i = chatPage;
            this.j.e(chatPage.f1());
            this.k = new GroupInputViewController(this, this.f, this.i.f1());
            this.i.m1();
            W1(this.e.e, this.i);
            ReplayEmojiSlice replayEmojiSlice = new ReplayEmojiSlice(getPageContext(), this, this.i.f1());
            this.t = replayEmojiSlice;
            W1((ViewGroup) this.e.a, replayEmojiSlice);
            UpBubbleSlice upBubbleSlice = new UpBubbleSlice(getPageContext(), this, this.i);
            this.q = upBubbleSlice;
            W1(this.e.h, upBubbleSlice);
            TopBubbleSlice topBubbleSlice = new TopBubbleSlice(getPageContext(), this, this.i, this.f);
            this.p = topBubbleSlice;
            W1(this.e.g, topBubbleSlice);
            DirectChatSlice directChatSlice = new DirectChatSlice(getPageContext(), this.i.f1());
            this.o = directChatSlice;
            W1(this.e.f, directChatSlice);
            this.l = new xr8();
            this.k.U1(this.i);
            getLifecycle().addObserver(this.h);
            getLifecycle().addObserver(this.k);
            getLifecycle().addObserver(this.j);
            this.i.n1(new j(this));
            this.h.T(this.E, this.F, this.v);
            this.h.e0(NoUISysMsg.MSG_TYPE_LIST, NoUISysMsg.class);
            this.h.m0(new k(this));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048614, this, i2) != null) || this.g == i2) {
            return;
        }
        this.g = i2;
        super.onChangeSkinType(i2);
        GroupInputViewController groupInputViewController = this.k;
        if (groupInputViewController != null) {
            groupInputViewController.onChangeSkinType(i2);
        }
        NoNetworkView noNetworkView = this.e.c;
        if (noNetworkView != null) {
            noNetworkView.onChangeSkinType(getPageContext(), i2);
        }
        if (UtilHelper.isNightOrDarkMode()) {
            EMManager.from(this.e.a).setBackGroundColor(R.color.CAM_X0201);
        } else {
            Glide.with(this.e.a).load(qu6.b("chat_room_background.webp", "chat_room_background")).into((RequestBuilder<Drawable>) new c(this));
        }
        this.j.onChangeSkinType();
    }

    public final void q2(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, chatRoomDetail) == null) {
            GroupInputViewController groupInputViewController = this.k;
            if (groupInputViewController != null && groupInputViewController.T0().d()) {
                U2(false);
                return;
            }
            List<String> inputTipsList = chatRoomDetail.getInputTipsList();
            if (inputTipsList != null && !inputTipsList.isEmpty()) {
                Z2(true, inputTipsList.get(0));
            } else if (chatRoomDetail.getBots() != null && !ei.isEmpty(chatRoomDetail.getBots().getGuide())) {
                Z2(true, chatRoomDetail.getBots().getGuide());
            } else {
                Z2(true, getStringSafely(R.string.im_msg_input_hint));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            qx5.b(arguments);
            this.f = arguments.getLong("roomId");
            arguments.getInt("requestCode", -1);
            this.v = arguments.getInt(IntentConfig.OBJ_LOCATED);
            this.z = arguments.getString("hotListText");
            tn8.e();
            this.w = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048618, this, i2, keyEvent)) == null) {
            if (i2 == 4 && !p2()) {
                return true;
            }
            if (i2 == 4 && v2() != null && E2() != null) {
                if (E2().L0() != null && E2().L0().k()) {
                    E2().L0().t(null);
                    return true;
                } else if (v2().N() && E2().V0() == GroupInputViewController.SourceType.ONE) {
                    E2().q1(null);
                    return true;
                }
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final boolean t2(@NonNull ChatRoomDetail chatRoomDetail, @NonNull NoUISysMsg noUISysMsg) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048629, this, chatRoomDetail, noUISysMsg)) == null) {
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
            int msgType = noUISysMsg.getMsgType();
            ChatRoomDetail.ExtraInfo extraInfo = chatRoomDetail.getExtraInfo();
            ChatRoomDetail.UserInfo userInfo = chatRoomDetail.getUserInfo();
            rr8 T0 = this.k.T0();
            BaseSysMsg.ChatRoomInfo chatroomInfo = noUISysMsg.getChatroomInfo();
            long j2 = 0;
            switch (msgType) {
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE /* 7003 */:
                    if (noUISysMsg.getUserTo() != null) {
                        j2 = noUISysMsg.getUserTo().getUserId();
                    }
                    if (!S2(chatRoomDetail) && j2 == TbadkCoreApplication.getCurrentAccountId()) {
                        if (userInfo != null) {
                            userInfo.setIsBeenTalkBanned(1);
                        }
                        T0.f(msgType);
                        s2();
                        z = true;
                        break;
                    }
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE /* 7004 */:
                    if (noUISysMsg.getUserTo() != null) {
                        j2 = noUISysMsg.getUserTo().getUserId();
                    }
                    if (j2 == TbadkCoreApplication.getCurrentAccountId()) {
                        T0.b(msgType);
                        if (userInfo != null) {
                            userInfo.setIsBeenTalkBanned(0);
                        }
                        s2();
                        z = true;
                        break;
                    }
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE_ALL /* 7005 */:
                    if (extraInfo != null) {
                        extraInfo.setIsTalkBanned(1);
                    }
                    T0.f(msgType);
                    s2();
                    z = true;
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE_ALL /* 7006 */:
                    T0.b(msgType);
                    if (extraInfo != null) {
                        extraInfo.setIsTalkBanned(0);
                    }
                    s2();
                    z = true;
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_FROZEN /* 7007 */:
                    if (extraInfo != null) {
                        extraInfo.setIsFreezing(1);
                    }
                    T0.f(msgType);
                    z = true;
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_FROZEN /* 7008 */:
                    T0.b(msgType);
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
                        if (!S2(chatRoomDetail) && this.k.t0(talkThresholdLevel, forumLevel)) {
                            T0.f(msgType);
                        } else {
                            T0.b(msgType);
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
                                groupChatRepo.L();
                            }
                            T0.f(msgType);
                            e3(R.string.obfuscated_res_0x7f0f0b7c, R.string.obfuscated_res_0x7f0f0b7d, R.string.obfuscated_res_0x7f0f0958);
                        } else {
                            T0.b(msgType);
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
                    if (!S2(chatRoomDetail) && i2 == 1 && (i3 < 1 || i3 > 4)) {
                        if (extraInfo != null) {
                            extraInfo.setTalkType(1);
                        }
                        T0.f(msgType);
                    } else {
                        T0.b(msgType);
                    }
                    z = true;
                    break;
            }
            if (z) {
                q2(chatRoomDetail);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }
}
