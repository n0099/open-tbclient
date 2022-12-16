package com.baidu.tieba.imMessageCenter.chatgroup.grouppage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.R;
import com.baidu.tieba.bk5;
import com.baidu.tieba.eb5;
import com.baidu.tieba.eh;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.NoUISysMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputTool;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.GroupInputViewController;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.navigationbar.GroupChatRoomNavigationBar;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.ka5;
import com.baidu.tieba.la5;
import com.baidu.tieba.rc7;
import com.baidu.tieba.rh7;
import com.baidu.tieba.xh7;
import com.baidu.tieba.yh7;
import com.baidu.tieba.yi;
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
    public g j;
    public final FastRequest.b<ChatRoomDetail> k;
    public final eb5 l;

    /* loaded from: classes4.dex */
    public class c implements eb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ c b;

            public a(c cVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a != 0) {
                        this.b.a.Q1();
                        if (this.a == 430) {
                            yi.N(this.b.a.getContext(), this.b.a.getString(R.string.obfuscated_res_0x7f0f082f));
                            return;
                        } else {
                            yi.N(this.b.a.getContext(), this.b.a.getString(R.string.obfuscated_res_0x7f0f0830, Integer.valueOf(this.a)));
                            return;
                        }
                    }
                    this.b.a.L1();
                }
            }
        }

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

        @Override // com.baidu.tieba.eb5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) {
                eh.e(new a(this, i));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GroupChatFragment groupChatFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.j.c != null) {
                rh7.h(this.a.j.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends FastRequest.b<ChatRoomDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment b;

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
            this.b = groupChatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable ChatRoomDetail chatRoomDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048579, this, i, str, chatRoomDetail) == null) {
                super.b(i, str, chatRoomDetail);
                this.b.Q1();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.d();
                this.b.R1();
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
                if (chatRoomDetail.isJumpH5()) {
                    UrlManager.getInstance().dealOneLink(this.b.getPageContext(), new String[]{chatRoomDetail.getJumpH5ErrUrl()});
                    this.b.requireActivity().finish();
                } else {
                    this.b.d.w(chatRoomDetail);
                    this.b.e.J(chatRoomDetail);
                }
                this.b.J1(chatRoomDetail);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements xh7.h<NoUISysMsg> {
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

        @Override // com.baidu.tieba.xh7.h
        @MainThread
        public void b(@NonNull ChatMsg chatMsg) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMsg) == null) && chatMsg.getNotifyCmd() == 102) {
                this.a.c.H(false);
                this.a.c.n();
                GroupChatFragment groupChatFragment = this.a;
                groupChatFragment.P1(false, groupChatFragment.getString(R.string.obfuscated_res_0x7f0f0833));
                this.a.S1(R.string.obfuscated_res_0x7f0f082e, R.string.obfuscated_res_0x7f0f082d, R.string.obfuscated_res_0x7f0f0843);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xh7.h
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
                        groupChatFragment.P1(false, groupChatFragment.getString(R.string.obfuscated_res_0x7f0f0834));
                        this.a.S1(R.string.obfuscated_res_0x7f0f0a2a, R.string.obfuscated_res_0x7f0f0a2b, R.string.obfuscated_res_0x7f0f0843);
                    }
                }
                if (this.a.h != null && this.a.h.getExtraInfo() != null && this.a.h.getUserInfo() != null) {
                    if (noUISysMsg.getMsgType() == 7007) {
                        this.a.h.getExtraInfo().setIsFreezing(1);
                        GroupChatFragment groupChatFragment2 = this.a;
                        groupChatFragment2.J1(groupChatFragment2.h);
                    } else if (noUISysMsg.getMsgType() == 7005) {
                        this.a.h.getExtraInfo().setIsTalkBanned(1);
                        GroupChatFragment groupChatFragment3 = this.a;
                        groupChatFragment3.J1(groupChatFragment3.h);
                    } else if (noUISysMsg.getMsgType() == 7003) {
                        if (noUISysMsg.getUserTo() != null && noUISysMsg.getUserTo().getUserId() == TbadkCoreApplication.getCurrentAccountId()) {
                            this.a.h.getUserInfo().setIsBeenTalkBanned(1);
                            GroupChatFragment groupChatFragment4 = this.a;
                            groupChatFragment4.J1(groupChatFragment4.h);
                        }
                    } else if (noUISysMsg.getMsgType() == 7011) {
                        if (noUISysMsg.getChatroomInfo() != null) {
                            this.a.h.getExtraInfo().setTalkThresholdLevel(noUISysMsg.getChatroomInfo().getTalkThresholdLevel());
                            GroupChatFragment groupChatFragment5 = this.a;
                            groupChatFragment5.J1(groupChatFragment5.h);
                        }
                    } else if (noUISysMsg.getMsgType() == 7008) {
                        this.a.h.getExtraInfo().setIsFreezing(0);
                        GroupChatFragment groupChatFragment6 = this.a;
                        groupChatFragment6.J1(groupChatFragment6.h);
                    } else if (noUISysMsg.getMsgType() == 7006) {
                        this.a.h.getExtraInfo().setIsTalkBanned(0);
                        GroupChatFragment groupChatFragment7 = this.a;
                        groupChatFragment7.J1(groupChatFragment7.h);
                    } else if (noUISysMsg.getMsgType() == 7004 && noUISysMsg.getUserTo() != null && noUISysMsg.getUserTo().getUserId() == TbadkCoreApplication.getCurrentAccountId()) {
                        this.a.h.getUserInfo().setIsBeenTalkBanned(0);
                        GroupChatFragment groupChatFragment8 = this.a;
                        groupChatFragment8.J1(groupChatFragment8.h);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;
        public final /* synthetic */ GroupChatFragment b;

        public e(GroupChatFragment groupChatFragment, TBAlertBuilder tBAlertBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatFragment, tBAlertBuilder};
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
            this.a = tBAlertBuilder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatRoomDetail.BasicInfo a;
        public final /* synthetic */ CommonMsgField b;
        public final /* synthetic */ BaseMsg c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ GroupChatFragment e;

        public f(GroupChatFragment groupChatFragment, ChatRoomDetail.BasicInfo basicInfo, CommonMsgField commonMsgField, BaseMsg baseMsg, boolean z) {
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
                rc7.f().l(TbadkCoreApplication.getCurrentAccount(), this.a.getName(), this.a.getAvatar(), String.valueOf(this.a.getForumId()), this.a.getForumName(), this.a.getId(), this.b.getMsgId(), this.c.getSdkMsg().getMsgTime(), this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public View b;
        public NoNetworkView c;

        public g() {
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

        public static g a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                g gVar = new g();
                gVar.a = view2;
                gVar.b = view2.findViewById(R.id.obfuscated_res_0x7f090d57);
                gVar.c = (NoNetworkView) view2.findViewById(R.id.obfuscated_res_0x7f091774);
                return gVar;
            }
            return (g) invokeL.objValue;
        }
    }

    public GroupChatFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = -1;
        this.i = new a(this, 2000994);
        this.k = new b(this);
        this.l = new c(this);
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            hideLoadingView(getView());
            this.loadingView = null;
            showNetRefreshView(getView(), null, false);
            la5 la5Var = this.mRefreshView;
            if (la5Var != null) {
                la5Var.b().setClickable(false);
                this.mRefreshView.l(UtilHelper.getStatusBarHeight());
                this.mRefreshView.f(R.color.transparent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            bk5.b(arguments);
            this.a = arguments.getLong("roomId");
            arguments.getInt(GroupInfoActivityConfig.REQUEST_CODE, -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            GroupInputTool groupInputTool = this.f;
            if (groupInputTool != null) {
                groupInputTool.m(bundle);
            }
        }
    }

    public final void P1(boolean z, String str) {
        GroupInputViewController groupInputViewController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048582, this, z, str) == null) && (groupInputViewController = this.g) != null) {
            groupInputViewController.O(str);
            this.g.T(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            this.j = g.a(view2);
            M1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            GroupInputViewController groupInputViewController = this.g;
            if (groupInputViewController != null) {
                groupInputViewController.G(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02e1, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public final void J1(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, chatRoomDetail) == null) && chatRoomDetail.getExtraInfo() != null && chatRoomDetail.getUserInfo() != null && this.g != null) {
            if (chatRoomDetail.getExtraInfo().getIsFreezing() == 1) {
                P1(false, getPageContext().getString(R.string.group_chat_group_had_close));
            } else if (chatRoomDetail.getExtraInfo().getIsTalkBanned() == 1) {
                P1(false, getPageContext().getString(R.string.group_chat_no_speak_all));
            } else if (chatRoomDetail.getUserInfo().getIsBeenTalkBanned() == 1) {
                P1(false, getPageContext().getString(R.string.group_chat_no_speak_person));
            } else if (this.g.w(chatRoomDetail.getExtraInfo().getTalkThresholdLevel(), chatRoomDetail.getUserInfo().getForumLevel())) {
                P1(false, String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f083a), Integer.valueOf(chatRoomDetail.getExtraInfo().getTalkThresholdLevel())));
            } else {
                P1(true, getPageContext().getString(R.string.im_msg_input_hint));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.c = new GroupChatRepo(getPageContext(), this.a);
            this.d = new GroupChatRoomNavigationBar(getPageContext(), this);
            this.e = new ChatPage(this, this.c);
            this.f = new GroupInputTool(this);
            GroupInputViewController groupInputViewController = new GroupInputViewController(this);
            this.g = groupInputViewController;
            groupInputViewController.L(this.e);
            this.g.Q(Long.valueOf(this.a));
            getLifecycle().addObserver(this.c);
            getLifecycle().addObserver(this.d);
            getLifecycle().addObserver(this.e);
            getLifecycle().addObserver(this.f);
            getLifecycle().addObserver(this.g);
            this.g.N(this.f);
            this.c.y(this.k, this.l);
            this.c.B(NoUISysMsg.MSG_TYPE_LIST, NoUISysMsg.class);
            this.c.I(new d(this));
        }
    }

    @Nullable
    public GroupInputViewController K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (GroupInputViewController) invokeV.objValue;
    }

    public final void L1() {
        GroupChatRoomNavigationBar groupChatRoomNavigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (groupChatRoomNavigationBar = this.d) != null) {
            groupChatRoomNavigationBar.x(0);
            this.j.b.setVisibility(0);
            hideLoadingView(getView());
            this.loadingView = null;
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            registerListener(this.i);
        }
    }

    public final void O1() {
        GroupChatRoomNavigationBar groupChatRoomNavigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (groupChatRoomNavigationBar = this.d) != null && groupChatRoomNavigationBar.j()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921777, String.valueOf(this.a)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            N1();
            O1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onNetRefreshButtonClicked();
            GroupChatRepo groupChatRepo = this.c;
            if (groupChatRepo != null) {
                groupChatRepo.y(this.k, this.l);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            NoNetworkView noNetworkView = this.j.c;
            if (noNetworkView != null) {
                rh7.h(noNetworkView);
            }
        }
    }

    public final void N1() {
        GroupChatRepo groupChatRepo;
        BaseMsg z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (groupChatRepo = this.c) != null && this.h != null && this.d != null && (z = groupChatRepo.z()) != null) {
            CommonMsgField commonMsgField = z.getCommonMsgField();
            ChatRoomDetail.BasicInfo basicInfo = this.h.getBasicInfo();
            eh.d(new f(this, basicInfo, commonMsgField, z, this.d.n()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921773, new yh7(z, basicInfo.getId())));
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.d != null) {
            hideNetRefreshView(getView());
            this.d.x(8);
            this.j.b.setVisibility(8);
            showLoadingView(getView());
            ka5 ka5Var = this.loadingView;
            if (ka5Var != null) {
                ka5Var.j().setClickable(false);
                this.loadingView.i();
                this.loadingView.q(0, 0.4f);
            }
        }
    }

    public final void S1(@StringRes int i, @StringRes int i2, @StringRes int i3) {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIII(1048585, this, i, i2, i3) != null) || (activity = getActivity()) == null) {
            return;
        }
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(activity);
        tBAlertBuilder.w(getString(i));
        tBAlertBuilder.q(getString(i2));
        tBAlertBuilder.t(new TBAlertConfig.a(getString(i3), TBAlertConfig.OperateBtnStyle.MAIN, new e(this, tBAlertBuilder)));
        tBAlertBuilder.y();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || this.b == i) {
            return;
        }
        this.b = i;
        super.onChangeSkinType(i);
        GroupChatRoomNavigationBar groupChatRoomNavigationBar = this.d;
        if (groupChatRoomNavigationBar != null) {
            groupChatRoomNavigationBar.t(i);
        }
        ChatPage chatPage = this.e;
        if (chatPage != null) {
            chatPage.H(i);
        }
        GroupInputTool groupInputTool = this.f;
        if (groupInputTool != null) {
            groupInputTool.l(i);
        }
        NoNetworkView noNetworkView = this.j.c;
        if (noNetworkView != null) {
            noNetworkView.d(getPageContext(), i);
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048593, this, i, strArr, iArr) == null) && i == 1) {
            if (PermissionUtil.checkCamera(getContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                yi.P(getContext(), R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                yi.P(getContext(), R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
