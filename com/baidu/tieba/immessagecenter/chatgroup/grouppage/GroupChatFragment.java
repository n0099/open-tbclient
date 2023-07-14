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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.R;
import com.baidu.tieba.bp5;
import com.baidu.tieba.bp8;
import com.baidu.tieba.co5;
import com.baidu.tieba.dh;
import com.baidu.tieba.dl8;
import com.baidu.tieba.do5;
import com.baidu.tieba.em8;
import com.baidu.tieba.ep8;
import com.baidu.tieba.eu4;
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
import com.baidu.tieba.py5;
import com.baidu.tieba.uu6;
import com.baidu.tieba.vd8;
import com.baidu.tieba.vo8;
import com.baidu.tieba.wo8;
import com.baidu.tieba.xi;
import com.baidu.tieba.yi;
import com.baidu.tieba.yk8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GroupChatFragment extends SliceFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    public final FastRequest.b<ChatRoomDetail> B;
    public final FastRequest.b<ChatRoomDetail> C;
    public final bp5 D;
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
    public bp8 l;
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
    public final CustomMessageListener y;
    public final CustomMessageListener z;

    /* loaded from: classes6.dex */
    public class i implements bp5 {
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
                        this.b.a.N2();
                        if (this.a == 430) {
                            yi.O(this.b.a.getContext(), this.b.a.getStringSafely(R.string.obfuscated_res_0x7f0f0929));
                            return;
                        } else {
                            yi.O(this.b.a.getContext(), this.b.a.getStringSafely(R.string.obfuscated_res_0x7f0f092a, Integer.valueOf(this.a)));
                            return;
                        }
                    }
                    this.b.a.D2();
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

        @Override // com.baidu.tieba.bp5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) {
                yk8.f(j, i, str);
                dh.g(new a(this, i));
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
                vd8.j().s(TbadkCoreApplication.getCurrentAccount(), this.a.getName(), this.a.getAvatar(), String.valueOf(this.a.getForumId()), this.a.getForumName(), this.a.getId(), this.b.getMsgId(), this.c.getSdkMsg().getMsgTime(), this.d, this.e);
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
                em8.w(this.a.e.c);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.q2() != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.q2().i0((String) customResponsedMessage.getData());
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
                this.a.h.a0(true);
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
        /* renamed from: f */
        public void e(@NonNull ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatRoomDetail) == null) {
                super.e(chatRoomDetail);
                this.b.m = chatRoomDetail;
                this.b.q2().x0(chatRoomDetail);
                if (this.b.k != null) {
                    this.b.k.U0().h(chatRoomDetail);
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048579, this, i, str, chatRoomDetail) == null) {
                super.b(i, str, chatRoomDetail);
                yk8.i(false, this.b.f, i, str);
                this.b.N2();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.d();
                this.b.O2();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, chatRoomDetail) == null) {
                super.e(chatRoomDetail);
                if (chatRoomDetail.isJumpH5()) {
                    UrlManager.getInstance().dealOneLink(this.b.getPageContext(), new String[]{chatRoomDetail.getJumpH5ErrUrl()});
                    this.b.requireActivity().finish();
                    return;
                }
                this.b.m = chatRoomDetail;
                if (this.b.g2() != null && chatRoomDetail.getBasicInfo() != null) {
                    this.b.g2().o0(this.b.f, chatRoomDetail.getBasicInfo().getForumId());
                }
                yk8.i(true, this.b.f, 0, DnsModel.MSG_OK);
                this.b.t2().c0(chatRoomDetail);
                this.b.t.f0(chatRoomDetail.getReactions());
                if (!ListUtils.isEmpty(chatRoomDetail.getQuickTalk()) && !this.b.C2()) {
                    this.b.F2(true);
                } else {
                    this.b.F2(false);
                }
                this.b.m2().Y(chatRoomDetail);
                if (this.b.w2() != null) {
                    this.b.w2().F0(chatRoomDetail);
                }
                if (this.b.y2() != null) {
                    this.b.y2().l0(chatRoomDetail);
                }
                if (this.b.u2() != null) {
                    this.b.u2().i0(chatRoomDetail, this.b.h);
                }
                if (this.b.k != null && this.b.k.U0().d()) {
                    this.b.F2(false);
                }
                if (this.b.k != null) {
                    this.b.k.U0().h(chatRoomDetail);
                    if (!ListUtils.isEmpty(chatRoomDetail.getMaskInfoList())) {
                        this.b.k.U0().e(chatRoomDetail.getMaskInfoList());
                    }
                }
                if (this.b.k != null && chatRoomDetail != null && chatRoomDetail.getBots() != null) {
                    this.b.k.z1(chatRoomDetail.getBots());
                }
                if (this.b.k != null && chatRoomDetail != null && chatRoomDetail.getBots() != null) {
                    this.b.k.A1(chatRoomDetail.getBots().getGuide());
                }
                if (this.b.q2() != null) {
                    this.b.q2().x0(chatRoomDetail);
                }
                this.b.i.k1(chatRoomDetail);
                if (this.b.l != null && chatRoomDetail.getGroupChatResource() != null) {
                    this.b.l.a(chatRoomDetail.getGroupChatResource().getEggRainData(), this.b.getPageContext());
                }
                this.b.b2(chatRoomDetail);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements dl8 {
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

        @Override // com.baidu.tieba.dl8
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
                    groupChatFragment.b2(groupChatFragment.m);
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
                    eu4.d().c("group_chat", jSONObject.toString());
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
                this.a.h.m0(false);
                this.a.h.K();
                GroupChatFragment groupChatFragment = this.a;
                groupChatFragment.K2(false, groupChatFragment.getStringSafely(R.string.obfuscated_res_0x7f0f0931));
                this.a.P2(R.string.obfuscated_res_0x7f0f0924, R.string.obfuscated_res_0x7f0f0923, R.string.obfuscated_res_0x7f0f094a);
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
                    this.a.k.U0().c(noUISysMsg.getMaskInfo());
                }
                if (this.a.m == null) {
                    return;
                }
                GroupChatFragment groupChatFragment = this.a;
                if (!groupChatFragment.e2(groupChatFragment.m, noUISysMsg) && noUISysMsg.getMsgType() == 7016 && noUISysMsg.getExt() != null && noUISysMsg.getExt().getEggRain() != null && noUISysMsg.getUserFrom() != null && noUISysMsg.getUserFrom().getUserId() != TbadkCoreApplication.getCurrentAccountId() && this.a.i.F0() != null && this.a.m.getChatConf() != null) {
                    this.a.i.F0().a0(noUISysMsg.getExt().getEggRain(), this.a.m.getChatConf().getResourceMaxTimeDelay() * 1000, noUISysMsg.getCommonMsgField().getRoomId(), !noUISysMsg.isLeft());
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
                mVar.b = view2.findViewById(R.id.obfuscated_res_0x7f090e83);
                mVar.c = (NoNetworkView) view2.findViewById(R.id.obfuscated_res_0x7f091947);
                mVar.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906c7);
                mVar.e = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0906d2);
                mVar.f = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0908bd);
                mVar.k = view2.findViewById(R.id.obfuscated_res_0x7f0908c6);
                mVar.g = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0925c6);
                mVar.h = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0927c8);
                mVar.i = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09188f);
                mVar.j = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0922c4);
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
        this.y = new d(this, 2000994);
        this.z = new e(this, 2921779);
        this.A = new f(this, 2921780);
        this.B = new g(this);
        this.C = new h(this);
        this.D = new i(this);
    }

    public void B2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getArguments() != null && getArguments().getSerializable("chat_bot_ability") != null) {
            AbilityItem abilityItem = (AbilityItem) getArguments().getSerializable("chat_bot_ability");
            if (this.i != null && !TextUtils.isEmpty(abilityItem.getType())) {
                this.i.m(abilityItem);
                getArguments().putSerializable("chat_bot_ability", null);
            }
        }
    }

    public final void O2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && q2() != null) {
            hideNetRefreshView(getView());
            this.mRefreshView = null;
            q2().y0(8);
            this.e.b.setVisibility(8);
            F2(false);
            x2().setVisibility(8);
            showLoadingView(getView());
            co5 co5Var = this.loadingView;
            if (co5Var != null) {
                co5Var.j().setClickable(false);
                this.loadingView.i();
                this.loadingView.q(0, 0.4f);
            }
        }
    }

    public void F2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.e.f.setVisibility(0);
                this.e.k.setVisibility(0);
                return;
            }
            this.e.f.setVisibility(8);
            this.e.k.setVisibility(8);
        }
    }

    public void L2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.v = i2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            py5.b(arguments);
            this.f = arguments.getLong("roomId");
            arguments.getInt("requestCode", -1);
            yk8.e();
            this.w = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            GroupInputViewController groupInputViewController = this.k;
            if (groupInputViewController != null) {
                groupInputViewController.q1(bundle);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048609, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            GroupInputViewController groupInputViewController = this.k;
            if (groupInputViewController != null) {
                groupInputViewController.p1(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048612, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0322, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public final void K2(boolean z, String str) {
        GroupInputViewController groupInputViewController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048586, this, z, str) == null) && (groupInputViewController = this.k) != null) {
            groupInputViewController.J1(str);
            this.k.Z1(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            m a2 = m.a(view2);
            this.e = a2;
            ViewCommonUtil.setViewMargin(a2.d, -1, UtilHelper.getStatusBarHeight(), -1, -1);
            H2();
        }
    }

    public void A2() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (chatPage = this.i) != null) {
            chatPage.I0();
        }
    }

    public final void D2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && q2() != null) {
            q2().y0(0);
            this.e.b.setVisibility(0);
            hideLoadingView(getView());
            this.loadingView = null;
        }
    }

    public void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e.k.setVisibility(4);
            this.e.f.setVisibility(4);
        }
    }

    public final void H2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            registerListener(this.y);
            registerListener(this.z);
            registerListener(this.A);
        }
    }

    public void M2() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (chatPage = this.i) != null) {
            chatPage.p1();
        }
    }

    public void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.h.o0();
        }
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (q2() == null || this.h == null) {
                return true;
            }
            return !q2().C0(this.h.W());
        }
        return invokeV.booleanValue;
    }

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.loadingView == null && this.mRefreshView == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.j.h();
        }
    }

    public void f2() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (chatPage = this.i) != null) {
            chatPage.B0();
        }
    }

    @Nullable
    public GroupInputTool g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            GroupInputViewController groupInputViewController = this.k;
            if (groupInputViewController != null) {
                return groupInputViewController.F0();
            }
            return null;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    @Nullable
    public ChatPage h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.i;
        }
        return (ChatPage) invokeV.objValue;
    }

    public long i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                return this.m.getBasicInfo().getForumId();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                return this.m.getBasicInfo().getForumName();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    public String l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                return this.m.getBasicInfo().getName();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public DirectChatSlice m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.o;
        }
        return (DirectChatSlice) invokeV.objValue;
    }

    @NonNull
    public EmojiReplayDetailSlice n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.u;
        }
        return (EmojiReplayDetailSlice) invokeV.objValue;
    }

    public int o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getUserInfo() != null) {
                return this.m.getUserInfo().getIdentityRole();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onNetRefreshButtonClicked();
            GroupChatRepo groupChatRepo = this.h;
            if (groupChatRepo != null) {
                groupChatRepo.U(this.C, this.D, this.v);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onPause();
            I2();
        }
    }

    @Nullable
    public GroupInputViewController p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.k;
        }
        return (GroupInputViewController) invokeV.objValue;
    }

    @Nullable
    public NavigationBarSlice q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.s;
        }
        return (NavigationBarSlice) invokeV.objValue;
    }

    @NonNull
    public ReplayEmojiSlice r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.t;
        }
        return (ReplayEmojiSlice) invokeV.objValue;
    }

    @NonNull
    public ResponsesPanelController s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.j;
        }
        return (ResponsesPanelController) invokeV.objValue;
    }

    @Nullable
    public EffectSlice t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.n;
        }
        return (EffectSlice) invokeV.objValue;
    }

    @Nullable
    public SubscribeSlice u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.r;
        }
        return (SubscribeSlice) invokeV.objValue;
    }

    public FrameLayout v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.e.j;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Nullable
    public TopBubbleSlice w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.p;
        }
        return (TopBubbleSlice) invokeV.objValue;
    }

    public FrameLayout x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.e.g;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Nullable
    public UpBubbleSlice y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.q;
        }
        return (UpBubbleSlice) invokeV.objValue;
    }

    public FrameLayout z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.e.h;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (p2() != null && p2().J0() != null && !"".equals(p2().J0())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && q2() != null && q2().j0()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921784, String.valueOf(this.f)));
        }
    }

    public final void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            hideLoadingView(getView());
            this.loadingView = null;
            showNetRefreshView(getView(), null, false);
            do5 do5Var = this.mRefreshView;
            if (do5Var != null) {
                do5Var.b().setClickable(false);
                this.mRefreshView.l(UtilHelper.getStatusBarHeight());
                this.mRefreshView.f(R.color.transparent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onDestroy();
            yk8.d();
            J2();
            long currentTimeMillis = System.currentTimeMillis();
            this.x = currentTimeMillis;
            long j2 = currentTimeMillis - this.w;
            this.w = 0L;
            this.x = 0L;
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                ep8.a("c15323", j2, this.m.getBasicInfo().getForumId(), this.f);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onResume();
            yk8.d();
            NoNetworkView noNetworkView = this.e.c;
            if (noNetworkView != null) {
                em8.w(noNetworkView);
            }
            GroupChatRepo groupChatRepo = this.h;
            if (groupChatRepo != null) {
                groupChatRepo.g0(this.B, this.v);
            }
            if (getArguments() != null && getArguments().getBoolean("is_new_intent")) {
                B2();
            }
        }
    }

    public void E2(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            ChatRoomDetail chatRoomDetail = this.m;
            if (chatRoomDetail != null && chatRoomDetail.getQuickTalk() != null && !ListUtils.isEmpty(this.m.getQuickTalk())) {
                if (p2() != null && p2().M0() != null) {
                    z2 = p2().M0().k();
                } else {
                    z2 = false;
                }
                if (p2() != null && p2().T0() != null) {
                    z3 = p2().T0().e();
                } else {
                    z3 = false;
                }
                if (p2() != null && p2().S0() != null) {
                    z4 = p2().S0().e();
                } else {
                    z4 = false;
                }
                if (p2() != null && p2().K0() != null) {
                    z5 = p2().K0().b0();
                    z6 = p2().K0().Z();
                } else {
                    z5 = false;
                    z6 = false;
                }
                if (z) {
                    if (!z2 && !z3 && !z4 && !z5 && !z6 && !C2()) {
                        F2(true);
                        return;
                    } else {
                        F2(false);
                        return;
                    }
                } else if (!z2 && !z3 && !z4 && !C2()) {
                    F2(true);
                    return;
                } else {
                    F2(false);
                    return;
                }
            }
            F2(false);
        }
    }

    public final void I2() {
        BaseMsg V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.h != null && this.m != null && q2() != null && (V = this.h.V()) != null) {
            CommonMsgField commonMsgField = V.getCommonMsgField();
            ChatRoomDetail.BasicInfo basicInfo = this.m.getBasicInfo();
            dh.e(new b(this, basicInfo, commonMsgField, V, q2().r0(), TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis())));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921773, new wo8(V, basicInfo.getId())));
        }
    }

    public final void P2(@StringRes int i2, @StringRes int i3, @StringRes int i4) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIII(1048591, this, i2, i3, i4) != null) || (baseFragmentActivity = getBaseFragmentActivity()) == null) {
            return;
        }
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(baseFragmentActivity);
        tBAlertBuilder.x(getStringSafely(i2));
        tBAlertBuilder.q(getStringSafely(i3));
        tBAlertBuilder.u(new TBAlertConfig.a(getStringSafely(i4), TBAlertConfig.OperateBtnStyle.MAIN, new l(this, tBAlertBuilder, baseFragmentActivity)));
        tBAlertBuilder.t(new a(this));
        tBAlertBuilder.d().setCanceledOnTouchOutside(false);
        tBAlertBuilder.z();
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048617, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (i2 == 1) {
                if (PermissionUtil.checkCamera(getContext())) {
                    SelectImageHelper.takePhoto(getPageContext());
                } else {
                    yi.Q(getContext(), R.string.system_permission_prompt_camera);
                }
                ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
                if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                    yi.Q(getContext(), R.string.sdcard_permission_denied_advert_for_camera);
                }
            }
        }
    }

    public final void b2(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, chatRoomDetail) == null) {
            GroupInputViewController groupInputViewController = this.k;
            if (groupInputViewController != null && groupInputViewController.U0().d()) {
                F2(false);
                return;
            }
            List<String> inputTipsList = chatRoomDetail.getInputTipsList();
            if (inputTipsList != null && !inputTipsList.isEmpty()) {
                K2(true, inputTipsList.get(0));
            } else if (chatRoomDetail.getBots() != null && !xi.isEmpty(chatRoomDetail.getBots().getGuide())) {
                K2(true, chatRoomDetail.getBots().getGuide());
            } else {
                K2(true, getStringSafely(R.string.im_msg_input_hint));
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048610, this, i2) != null) || this.g == i2) {
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
            noNetworkView.d(getPageContext(), i2);
        }
        if (UtilHelper.isNightOrDarkMode()) {
            this.e.a.setBackground(null);
        } else {
            Glide.with(this.e.a).load(uu6.b("chat_room_background.webp", "chat_room_background")).into((RequestBuilder<Drawable>) new c(this));
        }
        this.j.a();
    }

    public final boolean e2(@NonNull ChatRoomDetail chatRoomDetail, @NonNull NoUISysMsg noUISysMsg) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, chatRoomDetail, noUISysMsg)) == null) {
            boolean z = false;
            int i3 = 0;
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
            vo8 U0 = this.k.U0();
            BaseSysMsg.ChatRoomInfo chatroomInfo = noUISysMsg.getChatroomInfo();
            long j2 = 0;
            switch (msgType) {
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE /* 7003 */:
                    if (noUISysMsg.getUserTo() != null) {
                        j2 = noUISysMsg.getUserTo().getUserId();
                    }
                    if (j2 == TbadkCoreApplication.getCurrentAccountId()) {
                        if (userInfo != null) {
                            userInfo.setIsBeenTalkBanned(1);
                        }
                        U0.f(msgType);
                        d2();
                        z = true;
                        break;
                    }
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE /* 7004 */:
                    if (noUISysMsg.getUserTo() != null) {
                        j2 = noUISysMsg.getUserTo().getUserId();
                    }
                    if (j2 == TbadkCoreApplication.getCurrentAccountId()) {
                        U0.b(msgType);
                        if (userInfo != null) {
                            userInfo.setIsBeenTalkBanned(0);
                        }
                        d2();
                        z = true;
                        break;
                    }
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE_ALL /* 7005 */:
                    if (extraInfo != null) {
                        extraInfo.setIsTalkBanned(1);
                    }
                    U0.f(msgType);
                    d2();
                    z = true;
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE_ALL /* 7006 */:
                    U0.b(msgType);
                    if (extraInfo != null) {
                        extraInfo.setIsTalkBanned(0);
                    }
                    d2();
                    z = true;
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_FROZEN /* 7007 */:
                    if (extraInfo != null) {
                        extraInfo.setIsFreezing(1);
                    }
                    U0.f(msgType);
                    z = true;
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_FROZEN /* 7008 */:
                    U0.b(msgType);
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
                        if (!this.k.u0(talkThresholdLevel, forumLevel)) {
                            U0.b(msgType);
                        } else {
                            U0.f(msgType);
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
                                groupChatRepo.K();
                            }
                            U0.f(msgType);
                            P2(R.string.obfuscated_res_0x7f0f0b60, R.string.obfuscated_res_0x7f0f0b61, R.string.obfuscated_res_0x7f0f094a);
                        } else {
                            U0.b(msgType);
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
                    if (i2 == 1 && (i3 < 1 || i3 > 3)) {
                        if (extraInfo != null) {
                            extraInfo.setTalkType(1);
                        }
                        U0.f(msgType);
                    } else {
                        U0.b(msgType);
                    }
                    z = true;
                    break;
            }
            if (z) {
                b2(chatRoomDetail);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            super.onActivityCreated(bundle);
            NavigationBarSlice navigationBarSlice = new NavigationBarSlice(getPageContext(), this);
            this.s = navigationBarSlice;
            H1(this.e.i, navigationBarSlice);
            SubscribeSlice subscribeSlice = new SubscribeSlice(getPageContext(), this);
            this.r = subscribeSlice;
            H1(this.e.j, subscribeSlice);
            EmojiReplayDetailSlice emojiReplayDetailSlice = new EmojiReplayDetailSlice(getPageContext(), this, this.f);
            this.u = emojiReplayDetailSlice;
            H1((ViewGroup) this.e.a, emojiReplayDetailSlice);
            EffectSlice effectSlice = new EffectSlice(getPageContext());
            this.n = effectSlice;
            H1((ViewGroup) this.e.a, effectSlice);
            this.h = new GroupChatRepo(getPageContext(), this.f);
            this.j = new ResponsesPanelControllerImpl(this);
            ChatPage chatPage = new ChatPage(this, this.h);
            this.i = chatPage;
            this.j.f(chatPage.d1());
            this.k = new GroupInputViewController(this, this.f, this.i.d1());
            this.i.m1();
            H1(this.e.e, this.i);
            ReplayEmojiSlice replayEmojiSlice = new ReplayEmojiSlice(getPageContext(), this, this.i.d1());
            this.t = replayEmojiSlice;
            H1((ViewGroup) this.e.a, replayEmojiSlice);
            UpBubbleSlice upBubbleSlice = new UpBubbleSlice(getPageContext(), this, this.i);
            this.q = upBubbleSlice;
            H1(this.e.h, upBubbleSlice);
            TopBubbleSlice topBubbleSlice = new TopBubbleSlice(getPageContext(), this, this.i);
            this.p = topBubbleSlice;
            H1(this.e.g, topBubbleSlice);
            DirectChatSlice directChatSlice = new DirectChatSlice(getPageContext(), this.i.d1());
            this.o = directChatSlice;
            H1(this.e.f, directChatSlice);
            this.l = new bp8();
            this.k.V1(this.i);
            getLifecycle().addObserver(this.h);
            getLifecycle().addObserver(this.k);
            getLifecycle().addObserver(this.j);
            this.i.n1(new j(this));
            this.h.U(this.C, this.D, this.v);
            this.h.f0(NoUISysMsg.MSG_TYPE_LIST, NoUISysMsg.class);
            this.h.n0(new k(this));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048614, this, i2, keyEvent)) == null) {
            if (i2 == 4 && !a2()) {
                return true;
            }
            if (i2 == 4 && g2() != null && p2() != null) {
                if (p2().M0() != null && p2().M0().k()) {
                    p2().M0().t(null);
                    return true;
                } else if (g2().N() && p2().W0() == GroupInputViewController.SourceType.ONE) {
                    p2().r1(null);
                    return true;
                }
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
