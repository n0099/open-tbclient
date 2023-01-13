package com.baidu.tieba.imMessageCenter.chatgroup.grouppage;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.R;
import com.baidu.tieba.ab5;
import com.baidu.tieba.bl7;
import com.baidu.tieba.cm7;
import com.baidu.tieba.fh;
import com.baidu.tieba.hl7;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.NoUISysMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputTool;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputViewController;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.navigationbar.GroupChatRoomNavigationBar;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.pg7;
import com.baidu.tieba.sb5;
import com.baidu.tieba.sk5;
import com.baidu.tieba.tl7;
import com.baidu.tieba.yi;
import com.baidu.tieba.za5;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GroupChatFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public int b;
    @Nullable
    public GroupChatRepo c;
    @Nullable
    public GroupChatRoomNavigationBar d;
    @Nullable
    public ChatPage e;
    public GroupInputTool f;
    public GroupInputViewController g;
    @Nullable
    public ChatRoomDetail h;
    public final CustomMessageListener i;
    public final CustomMessageListener j;
    public final CustomMessageListener k;
    public final FastRequest.b<ChatRoomDetail> l;
    public k m;
    public final FastRequest.b<ChatRoomDetail> n;
    public final sb5 o;

    /* loaded from: classes4.dex */
    public class g implements sb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ g b;

            public a(g gVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a != 0) {
                        this.b.a.h2();
                        if (this.a == 430) {
                            zi.N(this.b.a.getContext(), this.b.a.getStringSafely(R.string.obfuscated_res_0x7f0f0837));
                            return;
                        } else {
                            zi.N(this.b.a.getContext(), this.b.a.getStringSafely(R.string.obfuscated_res_0x7f0f0838, Integer.valueOf(this.a)));
                            return;
                        }
                    }
                    this.b.a.b2();
                }
            }
        }

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
            this.a = groupChatFragment;
        }

        @Override // com.baidu.tieba.sb5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) {
                bl7.e(j, i, str);
                fh.e(new a(this, i));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatRoomDetail.BasicInfo a;
        public final /* synthetic */ CommonMsgField b;
        public final /* synthetic */ BaseMsg c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ GroupChatFragment e;

        public a(GroupChatFragment groupChatFragment, ChatRoomDetail.BasicInfo basicInfo, CommonMsgField commonMsgField, BaseMsg baseMsg, boolean z) {
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
                pg7.f().l(TbadkCoreApplication.getCurrentAccount(), this.a.getName(), this.a.getAvatar(), String.valueOf(this.a.getForumId()), this.a.getForumName(), this.a.getId(), this.b.getMsgId(), this.c.getSdkMsg().getMsgTime(), this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(GroupChatFragment groupChatFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.m.c != null) {
                hl7.i(this.a.m.c);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.d != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.d.l((String) customResponsedMessage.getData());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.c != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.c.F(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment b;

        public e(GroupChatFragment groupChatFragment) {
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
                this.b.h = chatRoomDetail;
                this.b.d.z(chatRoomDetail);
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
        public void b(int i, @NonNull String str, @Nullable ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048579, this, i, str, chatRoomDetail) == null) {
                super.b(i, str, chatRoomDetail);
                bl7.d(false, this.b.a, i, str);
                this.b.h2();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.d();
                this.b.i2();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, chatRoomDetail) == null) {
                super.e(chatRoomDetail);
                this.b.h = chatRoomDetail;
                bl7.d(true, this.b.a, 0, DnsModel.MSG_OK);
                if (this.b.f != null && chatRoomDetail != null && chatRoomDetail.getBots() != null) {
                    this.b.f.N(chatRoomDetail.getBots());
                }
                if (this.b.g != null && chatRoomDetail != null && chatRoomDetail.getBots() != null) {
                    this.b.g.p0(chatRoomDetail.getBots().getGuide());
                }
                if (chatRoomDetail.isJumpH5()) {
                    UrlManager.getInstance().dealOneLink(this.b.getPageContext(), new String[]{chatRoomDetail.getJumpH5ErrUrl()});
                    this.b.requireActivity().finish();
                } else {
                    this.b.d.z(chatRoomDetail);
                    this.b.e.m0(chatRoomDetail);
                }
                this.b.S1(chatRoomDetail);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements tl7.j<NoUISysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

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

        @Override // com.baidu.tieba.tl7.j
        @MainThread
        public void b(@NonNull ChatMsg chatMsg) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMsg) == null) && chatMsg.getNotifyCmd() == 102) {
                this.a.c.N(false);
                this.a.c.n();
                GroupChatFragment groupChatFragment = this.a;
                groupChatFragment.f2(false, groupChatFragment.getStringSafely(R.string.obfuscated_res_0x7f0f0840));
                this.a.j2(R.string.obfuscated_res_0x7f0f0836, R.string.obfuscated_res_0x7f0f0835, R.string.obfuscated_res_0x7f0f0856);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tl7.j
        @MainThread
        /* renamed from: c */
        public void a(@NonNull NoUISysMsg noUISysMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, noUISysMsg) == null) {
                if (noUISysMsg.getMsgType() == 7012 && noUISysMsg.getChatroomInfo() != null) {
                    int chatroomViewType = noUISysMsg.getChatroomInfo().getChatroomViewType();
                    if (this.a.h != null && this.a.h.getUserInfo() != null && this.a.h.getUserInfo().getIdentityRole() < chatroomViewType) {
                        this.a.c.n();
                        GroupChatFragment groupChatFragment = this.a;
                        groupChatFragment.f2(false, groupChatFragment.getStringSafely(R.string.obfuscated_res_0x7f0f0842));
                        this.a.j2(R.string.obfuscated_res_0x7f0f0a44, R.string.obfuscated_res_0x7f0f0a45, R.string.obfuscated_res_0x7f0f0856);
                    }
                }
                if (this.a.h != null && this.a.h.getExtraInfo() != null && this.a.h.getUserInfo() != null) {
                    if (noUISysMsg.getMsgType() == 7007) {
                        this.a.h.getExtraInfo().setIsFreezing(1);
                        GroupChatFragment groupChatFragment2 = this.a;
                        groupChatFragment2.S1(groupChatFragment2.h);
                    } else if (noUISysMsg.getMsgType() == 7005) {
                        this.a.h.getExtraInfo().setIsTalkBanned(1);
                        GroupChatFragment groupChatFragment3 = this.a;
                        groupChatFragment3.S1(groupChatFragment3.h);
                    } else if (noUISysMsg.getMsgType() == 7003) {
                        if (noUISysMsg.getUserTo() != null && noUISysMsg.getUserTo().getUserId() == TbadkCoreApplication.getCurrentAccountId()) {
                            this.a.h.getUserInfo().setIsBeenTalkBanned(1);
                            GroupChatFragment groupChatFragment4 = this.a;
                            groupChatFragment4.S1(groupChatFragment4.h);
                        }
                    } else if (noUISysMsg.getMsgType() == 7011) {
                        if (noUISysMsg.getChatroomInfo() != null) {
                            this.a.h.getExtraInfo().setTalkThresholdLevel(noUISysMsg.getChatroomInfo().getTalkThresholdLevel());
                            this.a.h.getExtraInfo().setTalkType(noUISysMsg.getChatroomInfo().getTalkType());
                            GroupChatFragment groupChatFragment5 = this.a;
                            groupChatFragment5.S1(groupChatFragment5.h);
                        }
                    } else if (noUISysMsg.getMsgType() == 7008) {
                        this.a.h.getExtraInfo().setIsFreezing(0);
                        GroupChatFragment groupChatFragment6 = this.a;
                        groupChatFragment6.S1(groupChatFragment6.h);
                    } else if (noUISysMsg.getMsgType() == 7006) {
                        this.a.h.getExtraInfo().setIsTalkBanned(0);
                        GroupChatFragment groupChatFragment7 = this.a;
                        groupChatFragment7.S1(groupChatFragment7.h);
                    } else if (noUISysMsg.getMsgType() == 7004) {
                        if (noUISysMsg.getUserTo() != null && noUISysMsg.getUserTo().getUserId() == TbadkCoreApplication.getCurrentAccountId()) {
                            this.a.h.getUserInfo().setIsBeenTalkBanned(0);
                            GroupChatFragment groupChatFragment8 = this.a;
                            groupChatFragment8.S1(groupChatFragment8.h);
                        }
                    } else if (noUISysMsg.getMsgType() == 7013 && noUISysMsg.getChatroomInfo().getTalkType() == 1 && this.a.h.getUserInfo().getIdentityRole() != 2 && this.a.h.getUserInfo().getIdentityRole() != 3) {
                        this.a.h.getExtraInfo().setTalkType(1);
                        GroupChatFragment groupChatFragment9 = this.a;
                        groupChatFragment9.f2(false, groupChatFragment9.getStringSafely(R.string.obfuscated_res_0x7f0f0857));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;
        public final /* synthetic */ BaseFragmentActivity b;
        public final /* synthetic */ GroupChatFragment c;

        public i(GroupChatFragment groupChatFragment, TBAlertBuilder tBAlertBuilder, BaseFragmentActivity baseFragmentActivity) {
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
    public class j implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) ? i == 4 : invokeLIL.booleanValue;
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
    }

    /* loaded from: classes4.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public View b;
        public NoNetworkView c;

        public k() {
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

        public static k a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                k kVar = new k();
                kVar.a = view2;
                kVar.b = view2.findViewById(R.id.obfuscated_res_0x7f090d62);
                kVar.c = (NoNetworkView) view2.findViewById(R.id.obfuscated_res_0x7f091784);
                return kVar;
            }
            return (k) invokeL.objValue;
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
        this.b = -1;
        this.i = new b(this, 2000994);
        this.j = new c(this, 2921779);
        this.k = new d(this, 2921780);
        this.l = new e(this);
        this.n = new f(this);
        this.o = new g(this);
    }

    public final void d2() {
        GroupChatRepo groupChatRepo;
        BaseMsg z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (groupChatRepo = this.c) != null && this.h != null && this.d != null && (z = groupChatRepo.z()) != null) {
            CommonMsgField commonMsgField = z.getCommonMsgField();
            ChatRoomDetail.BasicInfo basicInfo = this.h.getBasicInfo();
            fh.d(new a(this, basicInfo, commonMsgField, z, this.d.u()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921773, new cm7(z, basicInfo.getId())));
        }
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.d != null) {
            hideNetRefreshView(getView());
            this.mRefreshView = null;
            this.d.A(8);
            this.m.b.setVisibility(8);
            showLoadingView(getView());
            za5 za5Var = this.loadingView;
            if (za5Var != null) {
                za5Var.j().setClickable(false);
                this.loadingView.i();
                this.loadingView.q(0, 0.4f);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            sk5.b(arguments);
            this.a = arguments.getLong("roomId");
            arguments.getInt("requestCode", -1);
            bl7.c("get_chat_room_detail");
            bl7.c("im_enter_user_retry");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            GroupInputTool groupInputTool = this.f;
            if (groupInputTool != null) {
                groupInputTool.M(bundle);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048596, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            GroupInputViewController groupInputViewController = this.g;
            if (groupInputViewController != null) {
                groupInputViewController.i0(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02dd, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public final void f2(boolean z, String str) {
        GroupInputViewController groupInputViewController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048590, this, z, str) == null) && (groupInputViewController = this.g) != null) {
            groupInputViewController.w0(str);
            this.g.L0(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048601, this, i2, keyEvent)) == null) {
            if (i2 == 4 && !R1()) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            this.m = k.a(view2);
            c2();
        }
    }

    public boolean R1() {
        InterceptResult invokeV;
        GroupChatRepo groupChatRepo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GroupChatRoomNavigationBar groupChatRoomNavigationBar = this.d;
            if (groupChatRoomNavigationBar == null || (groupChatRepo = this.c) == null) {
                return true;
            }
            return !groupChatRoomNavigationBar.F(groupChatRepo.A());
        }
        return invokeV.booleanValue;
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.loadingView == null && this.mRefreshView == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public GroupInputTool U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public long V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.h;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                return this.h.getBasicInfo().getForumId();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.h;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null) {
                return this.h.getBasicInfo().getForumName();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return invokeV.longValue;
    }

    public int Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.h;
            if (chatRoomDetail != null && chatRoomDetail.getUserInfo() != null) {
                return this.h.getUserInfo().getIdentityRole();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public GroupInputViewController Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return (GroupInputViewController) invokeV.objValue;
    }

    public void a2() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (chatPage = this.e) != null) {
            chatPage.Q();
        }
    }

    public final void b2() {
        GroupChatRoomNavigationBar groupChatRoomNavigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (groupChatRoomNavigationBar = this.d) != null) {
            groupChatRoomNavigationBar.A(0);
            this.m.b.setVisibility(0);
            hideLoadingView(getView());
            this.loadingView = null;
        }
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            registerListener(this.i);
            registerListener(this.j);
            registerListener(this.k);
        }
    }

    public final void e2() {
        GroupChatRoomNavigationBar groupChatRoomNavigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (groupChatRoomNavigationBar = this.d) != null && groupChatRoomNavigationBar.m()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921784, String.valueOf(this.a)));
        }
    }

    public void g2() {
        ChatPage chatPage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (chatPage = this.e) != null) {
            chatPage.n0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onDestroy();
            bl7.f("get_chat_room_detail");
            bl7.f("im_enter_user_retry");
            d2();
            e2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onNetRefreshButtonClicked();
            GroupChatRepo groupChatRepo = this.c;
            if (groupChatRepo != null) {
                groupChatRepo.y(this.n, this.o);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onResume();
            NoNetworkView noNetworkView = this.m.c;
            if (noNetworkView != null) {
                hl7.i(noNetworkView);
            }
            GroupChatRepo groupChatRepo = this.c;
            if (groupChatRepo != null) {
                groupChatRepo.I(this.l);
            }
        }
    }

    public final void S1(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatRoomDetail) == null) && chatRoomDetail.getExtraInfo() != null && chatRoomDetail.getUserInfo() != null && this.g != null) {
            if (chatRoomDetail.getExtraInfo().getIsFreezing() == 1) {
                f2(false, getStringSafely(R.string.group_chat_group_had_close));
            } else if (chatRoomDetail.getExtraInfo().getIsTalkBanned() == 1) {
                f2(false, getStringSafely(R.string.group_chat_no_speak_all));
            } else if (chatRoomDetail.getUserInfo().getIsBeenTalkBanned() == 1) {
                f2(false, getStringSafely(R.string.group_chat_no_speak_person));
            } else if (chatRoomDetail.getExtraInfo().getTalkType() == 1 && chatRoomDetail.getUserInfo().getIdentityRole() != 2 && chatRoomDetail.getUserInfo().getIdentityRole() != 3) {
                f2(false, getStringSafely(R.string.obfuscated_res_0x7f0f0857));
            } else if (this.g.N(chatRoomDetail.getExtraInfo().getTalkThresholdLevel(), chatRoomDetail.getUserInfo().getForumLevel())) {
                f2(false, String.format(getStringSafely(R.string.obfuscated_res_0x7f0f084d), Integer.valueOf(chatRoomDetail.getExtraInfo().getTalkThresholdLevel())));
            } else if (chatRoomDetail.getBots() != null && !yi.isEmpty(chatRoomDetail.getBots().getGuide())) {
                f2(true, chatRoomDetail.getBots().getGuide());
            } else {
                f2(true, getStringSafely(R.string.im_msg_input_hint));
            }
        }
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            hideLoadingView(getView());
            this.loadingView = null;
            showNetRefreshView(getView(), null, false);
            ab5 ab5Var = this.mRefreshView;
            if (ab5Var != null) {
                ab5Var.b().setClickable(false);
                this.mRefreshView.l(UtilHelper.getStatusBarHeight());
                this.mRefreshView.f(R.color.transparent);
            }
        }
    }

    public final void j2(@StringRes int i2, @StringRes int i3, @StringRes int i4) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIII(1048594, this, i2, i3, i4) != null) || (baseFragmentActivity = getBaseFragmentActivity()) == null) {
            return;
        }
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(baseFragmentActivity);
        tBAlertBuilder.x(getStringSafely(i2));
        tBAlertBuilder.q(getStringSafely(i3));
        tBAlertBuilder.u(new TBAlertConfig.a(getStringSafely(i4), TBAlertConfig.OperateBtnStyle.MAIN, new i(this, tBAlertBuilder, baseFragmentActivity)));
        tBAlertBuilder.t(new j(this));
        tBAlertBuilder.d().setCanceledOnTouchOutside(false);
        tBAlertBuilder.z();
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048603, this, i2, strArr, iArr) == null) && i2 == 1) {
            if (PermissionUtil.checkCamera(getContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                zi.P(getContext(), R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                zi.P(getContext(), R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.c = new GroupChatRepo(getPageContext(), this.a);
            this.d = new GroupChatRoomNavigationBar(getPageContext(), this);
            this.e = new ChatPage(this, this.c);
            this.f = new GroupInputTool(this);
            GroupInputViewController groupInputViewController = new GroupInputViewController(this);
            this.g = groupInputViewController;
            groupInputViewController.q0(this.e);
            this.g.D0(Long.valueOf(this.a));
            getLifecycle().addObserver(this.c);
            getLifecycle().addObserver(this.d);
            getLifecycle().addObserver(this.e);
            getLifecycle().addObserver(this.f);
            getLifecycle().addObserver(this.g);
            this.g.u0(this.f);
            this.c.y(this.n, this.o);
            this.c.H(NoUISysMsg.MSG_TYPE_LIST, NoUISysMsg.class);
            this.c.O(new h(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048597, this, i2) != null) || this.b == i2) {
            return;
        }
        this.b = i2;
        super.onChangeSkinType(i2);
        GroupChatRoomNavigationBar groupChatRoomNavigationBar = this.d;
        if (groupChatRoomNavigationBar != null) {
            groupChatRoomNavigationBar.x(i2);
        }
        ChatPage chatPage = this.e;
        if (chatPage != null) {
            chatPage.i0(i2);
        }
        GroupInputTool groupInputTool = this.f;
        if (groupInputTool != null) {
            groupInputTool.L(i2);
        }
        NoNetworkView noNetworkView = this.m.c;
        if (noNetworkView != null) {
            noNetworkView.d(getPageContext(), i2);
        }
        if (UtilHelper.isNightOrDarkMode()) {
            this.m.a.setBackground(null);
        } else {
            this.m.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080464);
        }
    }
}
