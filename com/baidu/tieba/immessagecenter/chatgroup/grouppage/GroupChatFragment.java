package com.baidu.tieba.immessagecenter.chatgroup.grouppage;

import android.content.DialogInterface;
import android.content.Intent;
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
import com.baidu.tieba.dp7;
import com.baidu.tieba.gi;
import com.baidu.tieba.gx7;
import com.baidu.tieba.hi;
import com.baidu.tieba.hx7;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.NotificationType;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.positionbubble.UpBubbleSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.NoUISysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.directchat.DirectChatSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.effect.EffectSlice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.navigationbar.GroupChatRoomNavigationBar;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.immessagecenter.slice.SliceFragment;
import com.baidu.tieba.jg5;
import com.baidu.tieba.kf5;
import com.baidu.tieba.lf5;
import com.baidu.tieba.lx7;
import com.baidu.tieba.ng;
import com.baidu.tieba.ov7;
import com.baidu.tieba.pp5;
import com.baidu.tieba.qw7;
import com.baidu.tieba.vu7;
import com.baidu.tieba.yu7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class GroupChatFragment extends SliceFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long e;
    public int f;
    @Nullable
    public GroupChatRepo g;
    @Nullable
    public GroupChatRoomNavigationBar h;
    @Nullable
    public ChatPage i;
    public GroupInputViewController j;
    public lx7 k;
    @Nullable
    public ChatRoomDetail l;
    @Nullable
    public EffectSlice m;
    @Nullable
    public DirectChatSlice n;
    @Nullable
    public TopBubbleSlice o;
    @Nullable
    public UpBubbleSlice p;
    public final CustomMessageListener q;
    public final CustomMessageListener r;
    public final CustomMessageListener s;
    public final FastRequest.b<ChatRoomDetail> t;
    public l u;
    public final FastRequest.b<ChatRoomDetail> v;
    public final jg5 w;

    /* loaded from: classes4.dex */
    public class h implements jg5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ h b;

            public a(h hVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = hVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a != 0) {
                        this.b.a.z2();
                        if (this.a == 430) {
                            hi.N(this.b.a.getContext(), this.b.a.getStringSafely(R.string.obfuscated_res_0x7f0f086c));
                            return;
                        } else {
                            hi.N(this.b.a.getContext(), this.b.a.getStringSafely(R.string.obfuscated_res_0x7f0f086d, Integer.valueOf(this.a)));
                            return;
                        }
                    }
                    this.b.a.p2();
                }
            }
        }

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
            this.a = groupChatFragment;
        }

        @Override // com.baidu.tieba.jg5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) {
                vu7.f(j, i, str);
                ng.e(new a(this, i));
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatRoomDetail.BasicInfo a;
        public final /* synthetic */ CommonMsgField b;
        public final /* synthetic */ BaseMsg c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ GroupChatFragment e;

        public b(GroupChatFragment groupChatFragment, ChatRoomDetail.BasicInfo basicInfo, CommonMsgField commonMsgField, BaseMsg baseMsg, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment, basicInfo, commonMsgField, baseMsg, Boolean.valueOf(z)};
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
            this.b = commonMsgField;
            this.c = baseMsg;
            this.d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dp7.f().l(TbadkCoreApplication.getCurrentAccount(), this.a.getName(), this.a.getAvatar(), String.valueOf(this.a.getForumId()), this.a.getForumName(), this.a.getId(), this.b.getMsgId(), this.c.getSdkMsg().getMsgTime(), this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(GroupChatFragment groupChatFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.u.c != null) {
                ov7.n(this.a.u.c);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.h != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.h.m((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.g != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.g.L(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment b;

        public f(GroupChatFragment groupChatFragment) {
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
                this.b.l = chatRoomDetail;
                this.b.h.D(chatRoomDetail);
                if (this.b.j != null) {
                    this.b.j.r0().g(chatRoomDetail);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void b(int i, @NonNull String str, @Nullable ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048579, this, i, str, chatRoomDetail) == null) {
                super.b(i, str, chatRoomDetail);
                vu7.i(false, this.b.e, i, str);
                this.b.z2();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.d();
                this.b.A2();
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
                this.b.l = chatRoomDetail;
                vu7.i(true, this.b.e, 0, DnsModel.MSG_OK);
                this.b.l2().Q(chatRoomDetail);
                this.b.i2().J(chatRoomDetail);
                if (this.b.m2() != null) {
                    this.b.m2().O(chatRoomDetail.getChatBubbleData(), chatRoomDetail);
                }
                if (this.b.n2() != null) {
                    this.b.n2().a0(chatRoomDetail);
                }
                if (this.b.j != null && this.b.j.r0().c()) {
                    this.b.r2(false);
                }
                if (this.b.j != null) {
                    this.b.j.r0().g(chatRoomDetail);
                    if (!ListUtils.isEmpty(chatRoomDetail.getMaskInfoList())) {
                        this.b.j.r0().d(chatRoomDetail.getMaskInfoList());
                    }
                }
                if (this.b.j != null && chatRoomDetail != null && chatRoomDetail.getBots() != null) {
                    this.b.j.P0(chatRoomDetail.getBots());
                }
                if (this.b.j != null && chatRoomDetail != null && chatRoomDetail.getBots() != null) {
                    this.b.j.Q0(chatRoomDetail.getBots().getGuide());
                }
                this.b.h.D(chatRoomDetail);
                this.b.i.M0(chatRoomDetail);
                if (this.b.k != null && chatRoomDetail.getGroupChatResource() != null) {
                    this.b.k.a(chatRoomDetail.getGroupChatResource().getEggRainData(), this.b.getPageContext());
                }
                this.b.Z1(chatRoomDetail);
                this.b.x2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements yu7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

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

        @Override // com.baidu.tieba.yu7
        public void a(BaseMsg baseMsg, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048576, this, baseMsg, i, i2) == null) && i == 5 && this.a.l != null && this.a.l.getTodayChatMsgCount() <= 0) {
                this.a.l.setTodayChatMsgCount(1);
                List<String> inputTipsList = this.a.l.getInputTipsList();
                if (inputTipsList != null && !inputTipsList.isEmpty()) {
                    inputTipsList.remove(0);
                }
                GroupChatFragment groupChatFragment = this.a;
                groupChatFragment.Z1(groupChatFragment.l);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements qw7.j<NoUISysMsg> {
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

        @Override // com.baidu.tieba.qw7.j
        @MainThread
        public void b(@NonNull ChatMsg chatMsg) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMsg) == null) && chatMsg.getNotifyCmd() == 102) {
                this.a.g.V(false);
                this.a.g.q();
                GroupChatFragment groupChatFragment = this.a;
                groupChatFragment.v2(false, groupChatFragment.getStringSafely(R.string.obfuscated_res_0x7f0f0875));
                this.a.B2(R.string.obfuscated_res_0x7f0f0867, R.string.obfuscated_res_0x7f0f0866, R.string.obfuscated_res_0x7f0f088b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qw7.j
        @MainThread
        /* renamed from: c */
        public void a(@NonNull NoUISysMsg noUISysMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, noUISysMsg) == null) {
                if (this.a.j != null && noUISysMsg.getMaskInfo() != null) {
                    this.a.j.r0().b(noUISysMsg.getMaskInfo());
                }
                if (this.a.l == null) {
                    return;
                }
                GroupChatFragment groupChatFragment = this.a;
                if (!groupChatFragment.c2(groupChatFragment.l, noUISysMsg) && noUISysMsg.getMsgType() == 7016 && noUISysMsg.getExt() != null && noUISysMsg.getExt().getEggRain() != null && noUISysMsg.getUserFrom() != null && noUISysMsg.getUserFrom().getUserId() != TbadkCoreApplication.getCurrentAccountId() && this.a.i.n0() != null && this.a.l.getChatConf() != null) {
                    this.a.i.n0().O(noUISysMsg.getExt().getEggRain(), this.a.l.getChatConf().getResourceMaxTimeDelay() * 1000, noUISysMsg.getCommonMsgField().getRoomId(), !noUISysMsg.isLeft());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;
        public final /* synthetic */ BaseFragmentActivity b;
        public final /* synthetic */ GroupChatFragment c;

        public k(GroupChatFragment groupChatFragment, TBAlertBuilder tBAlertBuilder, BaseFragmentActivity baseFragmentActivity) {
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

    /* loaded from: classes4.dex */
    public static class l {
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
        public View i;

        public l() {
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

        public static l a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                l lVar = new l();
                lVar.a = view2;
                lVar.b = view2.findViewById(R.id.obfuscated_res_0x7f090e24);
                lVar.c = (NoNetworkView) view2.findViewById(R.id.obfuscated_res_0x7f09185d);
                lVar.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09069a);
                lVar.e = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0906a5);
                lVar.f = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090889);
                lVar.i = view2.findViewById(R.id.obfuscated_res_0x7f09088e);
                lVar.g = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092478);
                lVar.h = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092673);
                return lVar;
            }
            return (l) invokeL.objValue;
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
        this.f = -1;
        this.q = new c(this, 2000994);
        this.r = new d(this, 2921779);
        this.s = new e(this, 2921780);
        this.t = new f(this);
        this.v = new g(this);
        this.w = new h(this);
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.h != null) {
            hideNetRefreshView(getView());
            this.mRefreshView = null;
            this.h.E(8);
            this.u.b.setVisibility(8);
            r2(false);
            showLoadingView(getView());
            kf5 kf5Var = this.loadingView;
            if (kf5Var != null) {
                kf5Var.j().setClickable(false);
                this.loadingView.i();
                this.loadingView.q(0, 0.4f);
            }
        }
    }

    public final void t2() {
        GroupChatRepo groupChatRepo;
        BaseMsg E;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (groupChatRepo = this.g) != null && this.l != null && this.h != null && (E = groupChatRepo.E()) != null) {
            CommonMsgField commonMsgField = E.getCommonMsgField();
            ChatRoomDetail.BasicInfo basicInfo = this.l.getBasicInfo();
            ng.d(new b(this, basicInfo, commonMsgField, E, this.h.x()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921773, new hx7(E, basicInfo.getId())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            pp5.b(arguments);
            this.e = arguments.getLong("roomId");
            arguments.getInt("requestCode", -1);
            vu7.e();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            GroupInputViewController groupInputViewController = this.j;
            if (groupInputViewController != null) {
                groupInputViewController.I0(bundle);
            }
        }
    }

    public void r2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            if (z) {
                this.u.f.setVisibility(0);
                this.u.i.setVisibility(0);
                return;
            }
            this.u.f.setVisibility(8);
            this.u.i.setVisibility(8);
        }
    }

    public void w2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.u.g.setVisibility(i2);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048596, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            GroupInputViewController groupInputViewController = this.j;
            if (groupInputViewController != null) {
                groupInputViewController.G0(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02f5, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            l a2 = l.a(view2);
            this.u = a2;
            ViewCommonUtil.setViewMargin(a2.d, -1, UtilHelper.getStatusBarHeight(), -1, -1);
            s2();
        }
    }

    public final void v2(boolean z, String str) {
        GroupInputViewController groupInputViewController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048613, this, z, str) == null) && (groupInputViewController = this.j) != null) {
            groupInputViewController.X0(str);
            this.j.m1(z);
        }
    }

    public final void B2(@StringRes int i2, @StringRes int i3, @StringRes int i4) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4) != null) || (baseFragmentActivity = getBaseFragmentActivity()) == null) {
            return;
        }
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(baseFragmentActivity);
        tBAlertBuilder.x(getStringSafely(i2));
        tBAlertBuilder.q(getStringSafely(i3));
        tBAlertBuilder.u(new TBAlertConfig.a(getStringSafely(i4), TBAlertConfig.OperateBtnStyle.MAIN, new k(this, tBAlertBuilder, baseFragmentActivity)));
        tBAlertBuilder.t(new a(this));
        tBAlertBuilder.d().setCanceledOnTouchOutside(false);
        tBAlertBuilder.z();
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048603, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (i2 == 1) {
                if (PermissionUtil.checkCamera(getContext())) {
                    SelectImageHelper.takePhoto(getPageContext());
                } else {
                    hi.P(getContext(), R.string.system_permission_prompt_camera);
                }
                ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
                if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                    hi.P(getContext(), R.string.sdcard_permission_denied_advert_for_camera);
                }
            }
        }
    }

    public boolean Y1() {
        InterceptResult invokeV;
        GroupChatRepo groupChatRepo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            GroupChatRoomNavigationBar groupChatRoomNavigationBar = this.h;
            if (groupChatRoomNavigationBar == null || (groupChatRepo = this.g) == null) {
                return true;
            }
            return !groupChatRoomNavigationBar.J(groupChatRepo.F());
        }
        return invokeV.booleanValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.loadingView == null && this.mRefreshView == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void b2() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (chatPage = this.i) != null && chatPage.p0() != null) {
            this.i.p0().a(NotificationType.TYPE_REPLY);
        }
    }

    public void d2() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (chatPage = this.i) != null) {
            chatPage.l0();
        }
    }

    @Nullable
    public GroupInputTool e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            GroupInputViewController groupInputViewController = this.j;
            if (groupInputViewController != null) {
                return groupInputViewController.k0();
            }
            return null;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public long f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.l;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                return this.l.getBasicInfo().getForumId();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.l;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                return this.l.getBasicInfo().getForumName();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    @NonNull
    public DirectChatSlice i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.n;
        }
        return (DirectChatSlice) invokeV.objValue;
    }

    public int j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.l;
            if (chatRoomDetail != null && chatRoomDetail.getUserInfo() != null) {
                return this.l.getUserInfo().getIdentityRole();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public GroupInputViewController k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.j;
        }
        return (GroupInputViewController) invokeV.objValue;
    }

    @Nullable
    public EffectSlice l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.m;
        }
        return (EffectSlice) invokeV.objValue;
    }

    @Nullable
    public TopBubbleSlice m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.o;
        }
        return (TopBubbleSlice) invokeV.objValue;
    }

    @Nullable
    public UpBubbleSlice n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.p;
        }
        return (UpBubbleSlice) invokeV.objValue;
    }

    public void o2() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (chatPage = this.i) != null) {
            chatPage.r0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onDestroy();
            vu7.d();
            t2();
            u2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onNetRefreshButtonClicked();
            GroupChatRepo groupChatRepo = this.g;
            if (groupChatRepo != null) {
                groupChatRepo.D(this.v, this.w);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onResume();
            vu7.d();
            NoNetworkView noNetworkView = this.u.c;
            if (noNetworkView != null) {
                ov7.n(noNetworkView);
            }
            GroupChatRepo groupChatRepo = this.g;
            if (groupChatRepo != null) {
                groupChatRepo.Q(this.t);
            }
        }
    }

    public final void p2() {
        GroupChatRoomNavigationBar groupChatRoomNavigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (groupChatRoomNavigationBar = this.h) != null) {
            groupChatRoomNavigationBar.E(0);
            this.u.b.setVisibility(0);
            hideLoadingView(getView());
            this.loadingView = null;
        }
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            registerListener(this.q);
            registerListener(this.r);
            registerListener(this.s);
        }
    }

    public final void u2() {
        GroupChatRoomNavigationBar groupChatRoomNavigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (groupChatRoomNavigationBar = this.h) != null && groupChatRoomNavigationBar.n()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921784, String.valueOf(this.e)));
        }
    }

    public void y2() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && (chatPage = this.i) != null) {
            chatPage.T0();
        }
    }

    public final void Z1(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, chatRoomDetail) == null) {
            GroupInputViewController groupInputViewController = this.j;
            if (groupInputViewController != null && groupInputViewController.r0().c()) {
                r2(false);
                return;
            }
            List<String> inputTipsList = chatRoomDetail.getInputTipsList();
            if (inputTipsList != null && !inputTipsList.isEmpty()) {
                v2(true, inputTipsList.get(0));
            }
            if (chatRoomDetail.getBots() != null && !gi.isEmpty(chatRoomDetail.getBots().getGuide())) {
                v2(true, chatRoomDetail.getBots().getGuide());
            } else {
                v2(true, getStringSafely(R.string.im_msg_input_hint));
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048597, this, i2) != null) || this.f == i2) {
            return;
        }
        this.f = i2;
        super.onChangeSkinType(i2);
        GroupChatRoomNavigationBar groupChatRoomNavigationBar = this.h;
        if (groupChatRoomNavigationBar != null) {
            groupChatRoomNavigationBar.B(i2);
        }
        GroupInputViewController groupInputViewController = this.j;
        if (groupInputViewController != null) {
            groupInputViewController.H0(i2);
        }
        NoNetworkView noNetworkView = this.u.c;
        if (noNetworkView != null) {
            noNetworkView.d(getPageContext(), i2);
        }
        if (UtilHelper.isNightOrDarkMode()) {
            this.u.a.setBackground(null);
        } else {
            this.u.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080473);
        }
    }

    public final boolean c2(@NonNull ChatRoomDetail chatRoomDetail, @NonNull NoUISysMsg noUISysMsg) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, chatRoomDetail, noUISysMsg)) == null) {
            boolean z = false;
            int i3 = 0;
            z = false;
            z = false;
            z = false;
            z = false;
            z = false;
            z = false;
            if (this.j == null) {
                return false;
            }
            int msgType = noUISysMsg.getMsgType();
            ChatRoomDetail.ExtraInfo extraInfo = chatRoomDetail.getExtraInfo();
            ChatRoomDetail.UserInfo userInfo = chatRoomDetail.getUserInfo();
            gx7 r0 = this.j.r0();
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
                        r0.e(msgType);
                        b2();
                        z = true;
                        break;
                    }
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE /* 7004 */:
                    if (noUISysMsg.getUserTo() != null) {
                        j2 = noUISysMsg.getUserTo().getUserId();
                    }
                    if (j2 == TbadkCoreApplication.getCurrentAccountId()) {
                        r0.a(msgType);
                        if (userInfo != null) {
                            userInfo.setIsBeenTalkBanned(0);
                        }
                        b2();
                        z = true;
                        break;
                    }
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE_ALL /* 7005 */:
                    if (extraInfo != null) {
                        extraInfo.setIsTalkBanned(1);
                    }
                    r0.e(msgType);
                    b2();
                    z = true;
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE_ALL /* 7006 */:
                    r0.a(msgType);
                    if (extraInfo != null) {
                        extraInfo.setIsTalkBanned(0);
                    }
                    b2();
                    z = true;
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_FROZEN /* 7007 */:
                    if (extraInfo != null) {
                        extraInfo.setIsFreezing(1);
                    }
                    r0.e(msgType);
                    z = true;
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_FROZEN /* 7008 */:
                    r0.a(msgType);
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
                        if (!this.j.e0(talkThresholdLevel, forumLevel)) {
                            r0.a(msgType);
                        } else {
                            r0.e(msgType);
                        }
                        z = true;
                        break;
                    }
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_VIEW /* 7012 */:
                    if (chatroomInfo != null && userInfo != null) {
                        if (userInfo.getIdentityRole() < chatroomInfo.getChatroomViewType()) {
                            GroupChatRepo groupChatRepo = this.g;
                            if (groupChatRepo != null) {
                                groupChatRepo.q();
                            }
                            r0.e(msgType);
                            B2(R.string.obfuscated_res_0x7f0f0a89, R.string.obfuscated_res_0x7f0f0a8a, R.string.obfuscated_res_0x7f0f088b);
                        } else {
                            r0.a(msgType);
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
                        r0.e(msgType);
                    } else {
                        r0.a(msgType);
                    }
                    z = true;
                    break;
            }
            if (z) {
                Z1(chatRoomDetail);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onActivityCreated(bundle);
            EffectSlice effectSlice = new EffectSlice(getPageContext());
            this.m = effectSlice;
            E1((ViewGroup) this.u.a, effectSlice);
            TopBubbleSlice topBubbleSlice = new TopBubbleSlice(getPageContext(), this);
            this.o = topBubbleSlice;
            E1(this.u.g, topBubbleSlice);
            this.g = new GroupChatRepo(getPageContext(), this.e);
            this.h = new GroupChatRoomNavigationBar(getPageContext(), this);
            ChatPage chatPage = new ChatPage(this, this.g);
            this.i = chatPage;
            this.j = new GroupInputViewController(this, this.e, chatPage.I0());
            this.i.O0();
            E1(this.u.e, this.i);
            UpBubbleSlice upBubbleSlice = new UpBubbleSlice(getPageContext(), this, this.i);
            this.p = upBubbleSlice;
            E1(this.u.h, upBubbleSlice);
            DirectChatSlice directChatSlice = new DirectChatSlice(getPageContext(), this.i.I0());
            this.n = directChatSlice;
            E1(this.u.f, directChatSlice);
            this.k = new lx7();
            this.j.i1(this.i);
            getLifecycle().addObserver(this.g);
            getLifecycle().addObserver(this.h);
            getLifecycle().addObserver(this.j);
            this.i.P0(new i(this));
            this.g.D(this.v, this.w);
            this.g.P(NoUISysMsg.MSG_TYPE_LIST, NoUISysMsg.class);
            this.g.W(new j(this));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048601, this, i2, keyEvent)) == null) {
            if (i2 == 4 && !Y1()) {
                return true;
            }
            if (i2 == 4 && e2() != null && k2() != null) {
                if (k2().o0() != null && k2().o0().h()) {
                    k2().o0().n(null);
                    return true;
                } else if (e2().G() && k2().t0() == GroupInputViewController.SourceType.ONE) {
                    k2().J0(null);
                    return true;
                }
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void q2(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            ChatRoomDetail chatRoomDetail = this.l;
            if (chatRoomDetail != null && chatRoomDetail.getQuickTalk() != null && !ListUtils.isEmpty(this.l.getQuickTalk())) {
                if (k2() != null && k2().o0() != null) {
                    z2 = k2().o0().h();
                } else {
                    z2 = false;
                }
                if (k2() != null && k2().p0() != null) {
                    z3 = k2().p0().e();
                } else {
                    z3 = false;
                }
                GroupInputViewController groupInputViewController = this.j;
                if (groupInputViewController != null) {
                    groupInputViewController.q0();
                }
                if (k2() != null && k2().m0() != null) {
                    z4 = k2().m0().V();
                } else {
                    z4 = false;
                }
                if (z) {
                    if (!z2 && !z3 && !z4) {
                        r2(true);
                        return;
                    } else {
                        r2(false);
                        return;
                    }
                } else if (!z2 && !z3) {
                    r2(true);
                    return;
                } else {
                    r2(false);
                    return;
                }
            }
            r2(false);
        }
    }

    public final void x2() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048615, this) != null) || getArguments() == null) {
            return;
        }
        String string = getArguments().getString("chat_bot_uk");
        long j2 = getArguments().getLong("chat_bot_skill_id");
        if (!TextUtils.isEmpty(string) && j2 > 0 && (chatPage = this.i) != null) {
            chatPage.Q0(string, (int) j2, GroupInputViewController.SourceType.TWO, null);
        }
    }

    public final void z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            hideLoadingView(getView());
            this.loadingView = null;
            showNetRefreshView(getView(), null, false);
            lf5 lf5Var = this.mRefreshView;
            if (lf5Var != null) {
                lf5Var.b().setClickable(false);
                this.mRefreshView.l(UtilHelper.getStatusBarHeight());
                this.mRefreshView.f(R.color.transparent);
            }
        }
    }
}
