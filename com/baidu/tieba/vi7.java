package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarFeedActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMeActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.GroupChatLastMsginfoData;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.az4;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedGroupChatListCompleteMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.model.IMUserListHttpResponseMsg;
import com.baidu.tieba.im.model.IMUserListModel;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.IMOfficialMaskModel;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.imMessageCenter.mention.ChatAggregationFragment;
import com.baidu.tieba.imMessageCenter.recforum.model.MsgRecForumHttpResMessage;
import com.baidu.tieba.imMessageCenter.recforum.model.MsgRecForumNetMessage;
import com.baidu.tieba.imMessageCenter.recforum.model.MsgRecForumSocketResMessage;
import com.baidu.tieba.qj7;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.rg7;
import com.baidu.tieba.wv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes6.dex */
public class vi7 extends p9<ChatAggregationFragment> implements az4.g, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public View.OnClickListener A0;
    public TextView B;
    public final CustomMessageListener B0;
    public MessageRedDotView C;
    public pb7 C0;
    public View D;
    public final CustomMessageListener D0;
    public ImageView E;
    public final CustomMessageListener E0;
    public TextView F;
    public final CustomMessageListener F0;
    public MessageRedDotView G;
    public final CustomMessageListener G0;
    public View H;
    public final CustomMessageListener H0;
    public ImageView I;
    public final qb7 I0;
    public TextView J;
    public final CustomMessageListener J0;
    public MessageRedDotView K;
    public final CustomMessageListener K0;
    public View L;
    public final CustomMessageListener L0;
    public ov4 M;
    public HttpMessageListener M0;
    public RelativeLayout N;
    public ImageView O;
    public TextView P;
    public TextView Q;
    public TextView R;
    public MessageRedDotView S;
    public int T;
    public int U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public qj7 Z;
    public final ChatAggregationFragment a;
    public boolean a0;
    public ImMessageCenterModel b;
    public boolean b0;
    public ImMessageCenterShowItemData c;
    public boolean c0;
    public BdSwipeRefreshLayout d;
    public IMOfficialMaskModel d0;
    public bz4 e;
    public IMUserListModel e0;
    public BdListView f;
    public rg7 f0;
    public NavigationBarShadowView g;
    public AlertDialog g0;
    public MessageAggregationListAdapter h;
    public TBAlertBuilder h0;
    public ShutDownValidateTipView i;
    public List<ImMessageCenterPojo> i0;
    public uv4 j;
    public ChatRoomInfo j0;
    public wv4.e k;
    public NoDataView l;
    public boolean m;
    public RelativeLayout n;
    public View o;
    public boolean p;
    public boolean q;
    public boolean q0;
    public boolean r;
    public AbsListView.OnScrollListener r0;
    public int s;
    public final az4.g s0;
    public View t;
    public CustomMessageListener t0;
    public View u;
    @NonNull
    public rg7.f u0;
    public View v;
    public qb v0;
    public ImageView w;
    public CustomMessageListener w0;
    public TextView x;
    public qj7.b x0;
    public MessageRedDotView y;
    public final AdapterView.OnItemClickListener y0;
    public View z;
    public final AdapterView.OnItemLongClickListener z0;

    @Override // com.baidu.tieba.az4.g
    public void e(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        public a(vi7 vi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi7Var;
        }

        public final void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imMessageCenterShowItemData) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_ITEM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", "1").param("obj_param1", imMessageCenterShowItemData.getUnReadCount()).param(TiebaStatic.Params.FRIEND_UID, imMessageCenterShowItemData.getFriendId()));
                if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                    n35.h0().b0(n35.h0().w() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    if (imMessageCenterShowItemData.getRelation() == 1) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.a.a.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0, i);
                    personalChatActivityConfig.setFrom(3);
                    if (this.a.mContext != null && this.a.mContext.getUniqueId() != null) {
                        personalChatActivityConfig.setLastUniqueId(this.a.mContext.getUniqueId().getId());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || i < 0) {
                return;
            }
            ImMessageCenterShowItemData item = this.a.h.getItem(i);
            if (item != null && item.getDataType() == 2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.mContext.getPageActivity()).createNormalCfg(item.getForumName(), FrsActivityConfig.FRS_FROM_IM_REC_FORUM)));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.IM_REC_FORUM_ITEM_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", item.getForumId());
                statisticItem.param("fname", item.getForumName());
                TiebaStatic.log(statisticItem);
                return;
            }
            if (CommonStatisticKey.TbMemberOfficialStatic.TB_MEMBER_OFFICIAL_ID.equals(item.getFriendId())) {
                CommonStatisticUtils.staticTbMemberNotify(CommonStatisticKey.TbMemberOfficialStatic.MEMBER_MSG_CENTER_NOTIFY_CLICK, null, item.getFriendName());
            }
            TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
            StatisticItem statisticItem2 = new StatisticItem("c13720");
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            String ownerName = item.getOwnerName();
            if (TextUtils.isEmpty(ownerName)) {
                a(item);
                statisticItem2.param("obj_type", 6);
            } else if (ownerName.equals("1")) {
                if (!fi7.b(this.a.a.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                    return;
                }
                TiebaStatic.eventStat(this.a.a.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.a.a.getPageContext().getPageActivity(), xg.g(item.getFriendId(), 0L), item.getFriendName(), 0L, "msg_lstb")));
            } else if (ownerName.equals("5")) {
                TiebaStatic.log("c12931");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialBarFeedActivityConfig(this.a.a.getPageContext().getPageActivity())));
            } else if (ownerName.equals("8")) {
                if (!fi7.a(this.a.a.getPageContext().getOrignalPage(), 2002006)) {
                    return;
                }
                long g = xg.g(item.getFriendId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.a.getPageContext().getPageActivity(), g, item.getFriendNameShow(), item.getFriendPortrait(), 0, item.getUserType())));
                if ("801001117".equals(String.valueOf(g))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SITE_SERVICE_ENTRANCE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                } else if ("3222425470".equals(String.valueOf(g))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SYSTEM_SERVICE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            } else if (ownerName.equals("7")) {
                TiebaStatic.log(new StatisticItem("c12614"));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(this.a.a.getPageContext().getPageActivity())));
                statisticItem2.param("obj_type", 6);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_ITEM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", "2").param("obj_param1", item.getUnReadCount()).param(TiebaStatic.Params.FRIEND_UID, item.getFriendId()));
                return;
            } else if (ownerName.equals(String.valueOf(9))) {
                if (!TextUtils.isEmpty(item.getGroupJumpUrl())) {
                    UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{item.getGroupJumpUrl()});
                    this.a.X = true;
                }
                if (this.a.f0 != null) {
                    item.setUnReadCount(0);
                    this.a.L0(false);
                    this.a.f0.C(xg.g(item.getFriendId(), 0L));
                    this.a.T0(null, item, 2);
                    this.a.f0.t();
                }
            } else {
                a(item);
                statisticItem2.param("obj_type", 6);
            }
            if (!TextUtils.isEmpty(item.getFriendName())) {
                if ("贴吧热榜".equals(item.getFriendName())) {
                    statisticItem2.param("obj_type", 8);
                } else if ("贴吧荣誉墙".equals(item.getFriendName())) {
                    statisticItem2.param("obj_type", 9);
                } else if ("贴吧精选".equals(item.getFriendName())) {
                    statisticItem2.param("obj_type", 10);
                } else if ("贴吧活动".equals(item.getFriendName())) {
                    statisticItem2.param("obj_type", 4);
                } else if ("吧广播".equals(item.getFriendName())) {
                    statisticItem2.param("obj_type", 5);
                }
            }
            TiebaStatic.log(statisticItem2);
            if (!TextUtils.isEmpty(item.getFriendName()) && this.a.a.getPageContext().getPageActivity().getString(R.string.tieba_user_notify).equals(item.getFriendName())) {
                TiebaStatic.log(new StatisticItem("c14446").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements qj7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        public a0(vi7 vi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi7Var;
        }

        @Override // com.baidu.tieba.qj7.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.Z != null) {
                this.a.f.removeHeaderView(this.a.Z.e());
                this.a.a0 = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        public b(vi7 vi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi7Var;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                vi7 vi7Var = this.a;
                vi7Var.c = vi7Var.h.getItem(i);
                if (this.a.c != null && this.a.c.getDataType() == 2) {
                    return true;
                }
                vi7 vi7Var2 = this.a;
                if (!vi7Var2.C0(vi7Var2.c)) {
                    adapterView.setHapticFeedbackEnabled(false);
                    return true;
                }
                if (this.a.j != null) {
                    TiebaStatic.log("c12932");
                    this.a.j.k();
                    if (this.a.a != null && this.a.a.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        this.a.a.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                    }
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        public c(vi7 vi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ry4.l().x(ry4.p("msg_tab_entrance_invitation_answer_unread_num"), 0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2008024));
                if (this.a.S.getVisibility() == 0) {
                    if (ry4.l().i("key_question_msg_no_remind", false)) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                } else {
                    i = 0;
                }
                new StatisticItem(CommonStatisticKey.KEY_QUESTION_ENTRANCE_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_type", i).eventStat();
                this.a.K0(0);
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.a.getContext(), this.a.a.getString(R.string.obfuscated_res_0x7f0f09b4), TbConfig.QUESTION_THREAD_LIST, true);
                tbWebViewActivityConfig.setFixTitle(true);
                tbWebViewActivityConfig.setNoClose(true);
                tbWebViewActivityConfig.setNoHelp(false);
                tbWebViewActivityConfig.setCustomMoreHelp(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        public d(vi7 vi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g0 != null) {
                this.a.g0.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterShowItemData a;
        public final /* synthetic */ vi7 b;

        public e(vi7 vi7Var, ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var, imMessageCenterShowItemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vi7Var;
            this.a = imMessageCenterShowItemData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.g0 != null) {
                    this.b.g0.dismiss();
                }
                StatisticItem statisticItem = new StatisticItem("c14670");
                if (gi7.a(this.a)) {
                    statisticItem.param("obj_type", 1);
                } else if (gi7.b(this.a)) {
                    statisticItem.param("obj_type", 3);
                } else {
                    statisticItem.param("obj_type", 2);
                }
                TiebaStatic.log(statisticItem);
                this.b.b.asyncDeleteItem(this.a, this.b.I0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ImMessageCenterShowItemData b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ vi7 g;

        public f(vi7 vi7Var, String str, ImMessageCenterShowItemData imMessageCenterShowItemData, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var, str, imMessageCenterShowItemData, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = vi7Var;
            this.a = str;
            this.b = imMessageCenterShowItemData;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
        }

        @Override // com.baidu.tieba.wv4.e
        public void n0(wv4 wv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wv4Var, i, view2) == null) {
                if (this.g.j != null && this.g.j.isShowing() && this.g.a != null) {
                    this.g.j.dismiss();
                }
                String charSequence = ((EMTextView) view2).getText().toString();
                if (this.a.equals(charSequence)) {
                    TiebaStatic.log("c12933");
                    StatisticItem statisticItem = new StatisticItem("c14665");
                    if (gi7.a(this.b)) {
                        statisticItem.param("obj_type", 1);
                    } else if (gi7.b(this.b)) {
                        statisticItem.param("obj_type", 3);
                    } else {
                        statisticItem.param("obj_type", 2);
                    }
                    TiebaStatic.log(statisticItem);
                    this.g.c1(this.b);
                } else if (this.c.equals(charSequence)) {
                    StatisticItem statisticItem2 = new StatisticItem("c14664");
                    statisticItem2.param("obj_type", 1);
                    if (gi7.b(this.b)) {
                        statisticItem2.param("obj_source", 2);
                        long currentTimeMillis = System.currentTimeMillis();
                        ne7.c().h(Long.valueOf(xg.g(this.b.getFriendId(), 0L)), this.b.getFriendNameShow(), this.b.getFriendBjhAvatar(), currentTimeMillis);
                        this.b.setMarkTopIndex(currentTimeMillis);
                        this.g.L0(true);
                    } else {
                        statisticItem2.param("obj_source", 1);
                        fg7.c(this.b.getFriendId(), true);
                    }
                    TiebaStatic.log(statisticItem2);
                } else if (this.d.equals(charSequence)) {
                    StatisticItem statisticItem3 = new StatisticItem("c14664");
                    statisticItem3.param("obj_type", 2);
                    if (gi7.b(this.b)) {
                        statisticItem3.param("obj_source", 2);
                        ne7.c().h(Long.valueOf(xg.g(this.b.getFriendId(), 0L)), this.b.getFriendNameShow(), this.b.getFriendBjhAvatar(), 0L);
                        this.b.setMarkTopIndex(0L);
                        this.g.L0(true);
                    } else {
                        statisticItem3.param("obj_source", 1);
                        fg7.c(this.b.getFriendId(), false);
                    }
                    TiebaStatic.log(statisticItem3);
                } else if (this.e.equals(charSequence)) {
                    StatisticItem statisticItem4 = new StatisticItem("c14669");
                    statisticItem4.param("obj_type", 1);
                    if (this.g.d0 != null && gi7.c(this.b)) {
                        statisticItem4.param("obj_source", 1);
                        this.g.d0.G(true, this.b.getFriendId());
                    } else if (gi7.b(this.b)) {
                        statisticItem4.param("obj_source", 2);
                        ne7.c().g(Long.valueOf(xg.g(this.b.getFriendId(), 0L)), this.b.getFriendNameShow(), this.b.getFriendBjhAvatar(), false);
                        this.b.setNotify(false);
                        this.g.L0(false);
                        this.g.T0(null, this.b, 5);
                    }
                    TiebaStatic.log(statisticItem4);
                } else if (this.f.equals(charSequence)) {
                    StatisticItem statisticItem5 = new StatisticItem("c14669");
                    statisticItem5.param("obj_type", 2);
                    if (this.g.d0 != null && gi7.c(this.b)) {
                        statisticItem5.param("obj_source", 1);
                        this.g.d0.G(false, this.b.getFriendId());
                    } else if (gi7.b(this.b)) {
                        statisticItem5.param("obj_source", 2);
                        ne7.c().g(Long.valueOf(xg.g(this.b.getFriendId(), 0L)), this.b.getFriendNameShow(), this.b.getFriendBjhAvatar(), true);
                        this.b.setNotify(true);
                        this.g.L0(false);
                        this.g.T0(null, this.b, 5);
                    }
                    TiebaStatic.log(statisticItem5);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(vi7 vi7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var, Integer.valueOf(i)};
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
            this.a = vi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                this.a.E0(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.D0(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.G0(customResponsedMessage);
                this.a.X0(false);
                this.a.Q0();
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.a.b.setData(null, this.a.C0);
            } else if (customResponsedMessage.getCmd() == 2016010) {
                if (this.a.h != null) {
                    this.a.h.notifyDataSetChanged();
                }
            } else if (customResponsedMessage.getCmd() == 2016011 && this.a.h != null) {
                this.a.h.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements pb7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        public h(vi7 vi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi7Var;
        }

        @Override // com.baidu.tieba.pb7
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.t0();
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        public i(vi7 vi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f.F();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        public j(vi7 vi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi7Var;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                this.a.g.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                if (i != 0) {
                    if (i == 1 || i == 2) {
                        this.a.g.c();
                        return;
                    }
                    return;
                }
                View childAt = absListView.getChildAt(0);
                if (childAt != null && childAt.getTop() == 0) {
                    this.a.g.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(vi7 vi7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var, Integer.valueOf(i)};
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
            this.a = vi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterShowItemData imMessageCenterShowItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921762 && (imMessageCenterShowItemData = (ImMessageCenterShowItemData) customResponsedMessage.getData()) != null && this.a.b.getData().contains(imMessageCenterShowItemData)) {
                imMessageCenterShowItemData.setGroupDelete(true);
                ne7.c().f(Long.valueOf(xg.g(imMessageCenterShowItemData.getFriendId(), 0L)), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendBjhAvatar(), imMessageCenterShowItemData.getServerTime());
                this.a.b.getData().remove(imMessageCenterShowItemData);
                if (this.a.h != null) {
                    this.a.h.s(this.a.b.getData());
                    this.a.h.notifyDataSetChanged();
                }
                this.a.f0.C(xg.g(imMessageCenterShowItemData.getFriendId(), 0L));
                this.a.T0(null, imMessageCenterShowItemData, 3);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(vi7 vi7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var, Integer.valueOf(i)};
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
            this.a = vi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.b == null || customResponsedMessage == null || !this.a.q0 || customResponsedMessage.getCmd() != 2921777) {
                return;
            }
            ImMessageCenterShowItemData removeItemByRoomId = this.a.b.getRemoveItemByRoomId((String) customResponsedMessage.getData());
            if (removeItemByRoomId != null && this.a.b.getData().contains(removeItemByRoomId)) {
                this.a.b.getData().remove(removeItemByRoomId);
                if (this.a.h != null) {
                    this.a.h.s(this.a.b.getData());
                    this.a.h.notifyDataSetChanged();
                }
                this.a.f0.C(xg.g(removeItemByRoomId.getFriendId(), 0L));
                this.a.T0(null, removeItemByRoomId, 3);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(vi7 vi7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var, Integer.valueOf(i)};
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
            this.a = vi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupChatLastMsginfoData groupChatLastMsginfoData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.j0 != null && customResponsedMessage.getCmd() == 2921772 && (groupChatLastMsginfoData = (GroupChatLastMsginfoData) customResponsedMessage.getData()) != null && this.a.f0 != null) {
                this.a.j0.getNewMessage().setMsgTime(groupChatLastMsginfoData.getTimeStamp());
                this.a.j0.getNewMessage().setContent(groupChatLastMsginfoData.getContent());
                this.a.j0.getNewMessage().setFromName(groupChatLastMsginfoData.getFromName());
                this.a.f0.E(this.a.j0);
                this.a.j0 = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(vi7 vi7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var, Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921770) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(vi7 vi7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var, Integer.valueOf(i)};
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
            this.a = vi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                this.a.F0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements qb7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        public p(vi7 vi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi7Var;
        }

        @Override // com.baidu.tieba.qb7
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.c0();
        }

        @Override // com.baidu.tieba.qb7
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.c0();
            this.a.a.showToast(R.string.delete_success, false);
            this.a.t0();
        }

        @Override // com.baidu.tieba.qb7
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            this.a.e1();
        }

        @Override // com.baidu.tieba.qb7
        public void onProgressUpdate(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) && this.a.M != null) {
                this.a.M.b(i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(vi7 vi7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var, Integer.valueOf(i)};
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
            this.a = vi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                this.a.v0((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(vi7 vi7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var, Integer.valueOf(i)};
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
            this.a = vi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2921727 && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.U0(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(vi7 vi7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var, Integer.valueOf(i)};
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
            this.a = vi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2921726) {
                this.a.V0(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(vi7 vi7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var, Integer.valueOf(i)};
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
            this.a = vi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            HashMap<String, ImMessageCenterPojo> hashMap;
            ImMessageCenterPojo imMessageCenterPojo;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof IMUserListHttpResponseMsg)) {
                return;
            }
            IMUserListHttpResponseMsg iMUserListHttpResponseMsg = (IMUserListHttpResponseMsg) httpResponsedMessage;
            if (this.a.b != null && !ListUtils.isEmpty(this.a.b.getData()) && (hashMap = iMUserListHttpResponseMsg.changedList) != null && !hashMap.isEmpty()) {
                for (ImMessageCenterShowItemData imMessageCenterShowItemData : this.a.b.getData()) {
                    if (imMessageCenterShowItemData != null && iMUserListHttpResponseMsg.changedList.containsKey(imMessageCenterShowItemData.getFriendId()) && (imMessageCenterPojo = iMUserListHttpResponseMsg.changedList.get(imMessageCenterShowItemData.getFriendId())) != null) {
                        imMessageCenterShowItemData.setFriendNameShow(imMessageCenterPojo.getNameShow());
                        imMessageCenterShowItemData.setRelation(imMessageCenterPojo.getIsFriend());
                        imMessageCenterShowItemData.setUserExtraData(imMessageCenterPojo.getImUserExtraData());
                    }
                }
                this.a.t0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements az4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        public u(vi7 vi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi7Var;
        }

        @Override // com.baidu.tieba.az4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.X0(true);
                this.a.H0();
                if (this.a.d != null) {
                    this.a.d.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(vi7 vi7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var, Integer.valueOf(i)};
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
            this.a = vi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371 || this.a.c0) {
                return;
            }
            this.a.S0();
            this.a.t0();
        }
    }

    /* loaded from: classes6.dex */
    public class w implements rg7.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        public w(vi7 vi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi7Var;
        }

        @Override // com.baidu.tieba.rg7.f
        public void a(@Nullable List<ImMessageCenterPojo> list, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(1048576, this, list, z) != null) || this.a.b == null) {
                return;
            }
            if (z) {
                if (ListUtils.isEmpty(list)) {
                    list = new ArrayList<>();
                }
                this.a.T0(list, null, 1);
                if (!ListUtils.isEmpty(this.a.i0)) {
                    list.addAll(this.a.i0);
                }
                this.a.b.setData(list, this.a.C0);
                return;
            }
            this.a.b.setData(this.a.i0, this.a.C0);
        }

        @Override // com.baidu.tieba.rg7.f
        public void b(List<ImMessageCenterPojo> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.a.b != null && !ListUtils.isEmpty(list)) {
                this.a.b.updateGroupchatList(list, this.a.C0);
                this.a.T0(list, null, 1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(vi7 vi7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi7Var;
        }

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof MsgRecForumHttpResMessage;
                if (!z && !(responsedMessage instanceof MsgRecForumSocketResMessage)) {
                    return;
                }
                if (responsedMessage.getError() != 0) {
                    if (!this.a.Y && this.a.a != null && responsedMessage.getError() != -100000303) {
                        this.a.a.showToast(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0cb8));
                        this.a.Y = true;
                        return;
                    }
                    return;
                }
                List<RecommendForumInfo> list = null;
                if (z) {
                    MsgRecForumHttpResMessage msgRecForumHttpResMessage = (MsgRecForumHttpResMessage) responsedMessage;
                    list = msgRecForumHttpResMessage.forumList;
                    Page page = msgRecForumHttpResMessage.pageInfo;
                } else if (responsedMessage instanceof MsgRecForumSocketResMessage) {
                    MsgRecForumSocketResMessage msgRecForumSocketResMessage = (MsgRecForumSocketResMessage) responsedMessage;
                    list = msgRecForumSocketResMessage.forumList;
                    Page page2 = msgRecForumSocketResMessage.pageInfo;
                }
                this.a.Z0(list);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(vi7 vi7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var, Integer.valueOf(i)};
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
            this.a = vi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921691) {
                return;
            }
            this.a.b.queryMarkTopStatus((String) customResponsedMessage.getData());
            this.a.b.sortList();
            this.a.h.s(this.a.b.getData());
            this.a.h.notifyDataSetChanged();
        }
    }

    /* loaded from: classes6.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        public z(vi7 vi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ry4.l().v("is_shut_down_validate", true);
                this.a.a1(false);
                this.a.b1(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vi7(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) x9.a(chatAggregationFragment.getPageContext().getPageActivity()));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatAggregationFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.f = null;
        this.h = null;
        this.j = null;
        this.m = true;
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = 16;
        this.V = true;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.a0 = false;
        this.b0 = false;
        this.c0 = false;
        this.g0 = null;
        this.h0 = null;
        this.i0 = new ArrayList();
        this.q0 = false;
        this.r0 = new j(this);
        this.s0 = new u(this);
        this.t0 = new v(this, 2001371);
        this.u0 = new w(this);
        this.v0 = new x(this, CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST, 309712);
        this.w0 = new y(this, 2921691);
        this.x0 = new a0(this);
        this.y0 = new a(this);
        this.z0 = new b(this);
        this.A0 = new c(this);
        this.B0 = new g(this, 0);
        this.C0 = new h(this);
        this.D0 = new k(this, 2921762);
        this.E0 = new l(this, 2921777);
        this.F0 = new m(this, 2921772);
        this.G0 = new n(this, 2921770);
        this.H0 = new o(this, 2001120);
        this.I0 = new p(this);
        this.J0 = new q(this, 2001120);
        this.K0 = new r(this, 2921727);
        this.L0 = new s(this, 2921726);
        this.M0 = new t(this, CmdConfigHttp.CMD_GET_USER_LIST);
        this.a = chatAggregationFragment;
    }

    public final void F0(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, responsedMessage) != null) || responsedMessage == null) {
            return;
        }
        if (!(responsedMessage instanceof NewsNotifyMessage)) {
            BdLog.e("transform error");
        } else {
            L0(false);
        }
    }

    public void V0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z2) == null) {
            if (z2) {
                this.N.setVisibility(0);
                this.L.setVisibility(8);
            } else {
                this.N.setVisibility(8);
                this.L.setVisibility(0);
            }
            f1();
        }
    }

    public void W0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z2) == null) {
            this.r = z2;
        }
    }

    public void X0(boolean z2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) && this.d != null) {
            if (z2 && (bdListView = this.f) != null && bdListView.getFirstVisiblePosition() != 0) {
                this.f.setSelection(0);
            }
            this.d.setRefreshing(z2);
        }
    }

    public void Y0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z2) == null) {
            this.q = z2;
        }
    }

    public void a1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z2) == null) {
            this.m = z2;
        }
    }

    public void d1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048607, this, z2) == null) && z2) {
            P0();
            f1();
        }
    }

    public void l0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) && bundle != null) {
            this.s = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.s);
        }
    }

    public void x0(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048630, this, intent) == null) && intent != null) {
            int intExtra = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            this.s = intExtra;
            if (intExtra == -1) {
                return;
            }
            Y0(true);
            y0();
        }
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f.F();
            this.p = j0();
        }
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.W = true;
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public void N0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (bdSwipeRefreshLayout = this.d) != null && !bdSwipeRefreshLayout.r()) {
            X0(true);
        }
    }

    public void P0() {
        IMUserListModel iMUserListModel;
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (iMUserListModel = this.e0) != null && (imMessageCenterModel = this.b) != null) {
            iMUserListModel.request(true, imMessageCenterModel.getUids());
        }
    }

    public void Q0() {
        IMUserListModel iMUserListModel;
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (iMUserListModel = this.e0) != null && (imMessageCenterModel = this.b) != null && this.V) {
            iMUserListModel.request(false, imMessageCenterModel.getUids());
            this.V = false;
        }
    }

    public final void c0() {
        ov4 ov4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (ov4Var = this.M) != null && ov4Var.isShowing()) {
            this.M.dismiss();
            this.M = null;
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            TbSingleton.getInstance().setNeedJoinChatRoom(true);
            H0();
            this.q0 = true;
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            TbSingleton.getInstance().setNeedJoinChatRoom(false);
            rg7 rg7Var = this.f0;
            if (rg7Var != null) {
                rg7Var.t();
            }
            this.q0 = false;
        }
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.N.getVisibility() == 0) {
            new StatisticItem(CommonStatisticKey.KEY_QUESTION_ENTRANCE_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.f0 != null && BdNetTypeUtil.isNetWorkAvailable()) {
            this.f0.B();
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.a.getPageContext().getPageActivity();
        }
        return (Activity) invokeV.objValue;
    }

    public final boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return TbadkCoreApplication.isLogin();
        }
        return invokeV.booleanValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public void n0() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (messageAggregationListAdapter = this.h) != null) {
            messageAggregationListAdapter.notifyDataSetChanged();
        }
    }

    public void p0() {
        rg7 rg7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (rg7Var = this.f0) != null) {
            rg7Var.t();
        }
    }

    public void q0() {
        rg7 rg7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (rg7Var = this.f0) != null) {
            if (this.X) {
                this.X = false;
                rg7Var.z();
            } else if (TbSingleton.getInstance().isNeedJoinChatRoom()) {
                this.f0.z();
            }
        }
    }

    public void r0() {
        TBAlertBuilder tBAlertBuilder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (tBAlertBuilder = this.h0) != null && this.g0 != null) {
            tBAlertBuilder.g();
        }
    }

    public final boolean C0(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterShowItemData)) == null) {
            String string = this.a.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
            String string2 = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f14d1);
            String string3 = this.a.getPageContext().getPageActivity().getString(R.string.cancel_top);
            String string4 = this.a.getPageContext().getPageActivity().getString(R.string.im_chat_no_tip);
            String string5 = this.a.getPageContext().getPageActivity().getString(R.string.im_chat_no_tip_cancel);
            if (imMessageCenterShowItemData.getMarkTopIndex() > 0) {
                str = string3;
            } else {
                str = string2;
            }
            if (imMessageCenterShowItemData.getGroupSetting() != null && !String.valueOf(9).equals(imMessageCenterShowItemData.getOwnerName()) && !imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
                str2 = string5;
            } else {
                str2 = string4;
            }
            if (String.valueOf(9).equals(imMessageCenterShowItemData.getOwnerName())) {
                if (imMessageCenterShowItemData.isNotify) {
                    str2 = string4;
                } else {
                    str2 = string5;
                }
            }
            String str3 = str2;
            f fVar = new f(this, string, imMessageCenterShowItemData, string2, string3, string4, string5);
            ArrayList arrayList = new ArrayList(5);
            if (gi7.a(imMessageCenterShowItemData)) {
                arrayList.add(str);
                arrayList.add(string);
            } else if (gi7.c(imMessageCenterShowItemData)) {
                arrayList.add(str3);
                arrayList.add(string);
            } else if (gi7.b(imMessageCenterShowItemData)) {
                arrayList.add(str);
                arrayList.add(str3);
                arrayList.add(string);
            } else {
                return false;
            }
            this.k = fVar;
            this.j = new uv4(this.a.getPageContext());
            this.j.i(null, (String[]) arrayList.toArray(new String[arrayList.size()]), this.k);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void D0(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof MemoryChangedMessage)) {
            return;
        }
        MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
        ImMessageCenterPojo data = memoryChangedMessage.getData();
        if (memoryChangedMessage.getType() == 1) {
            ImMessageCenterModel imMessageCenterModel2 = this.b;
            if (imMessageCenterModel2 != null) {
                imMessageCenterModel2.insertOrUpdate(data, this.C0);
            }
        } else if (memoryChangedMessage.getType() == 2 && (imMessageCenterModel = this.b) != null) {
            imMessageCenterModel.remove(data, this.C0);
        }
    }

    public final void E0(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
            g0();
        }
    }

    public final void I0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            if (i2 > 0) {
                if (p35.d().f() == 0) {
                    i2 = 0;
                }
                this.C.setThreeDotMode(2);
                this.C.f(i2);
                this.C.setVisibility(0);
                return;
            }
            this.C.setVisibility(8);
        }
    }

    public final void J0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (i2 > 0) {
                if (p35.d().f() == 0) {
                    i2 = 0;
                }
                this.y.setThreeDotMode(2);
                this.y.f(i2);
                this.y.setVisibility(0);
                return;
            }
            this.y.setVisibility(8);
        }
    }

    public final void L0(boolean z2) {
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048586, this, z2) != null) || this.h == null) {
            return;
        }
        if (z2 && (imMessageCenterModel = this.b) != null && imMessageCenterModel.getData() != null && this.b.getData().size() > 0) {
            this.b.sortList();
            this.h.s(this.b.getData());
        }
        this.h.notifyDataSetChanged();
    }

    public final void M0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 > 0) {
                if (p35.d().f() == 0) {
                    i2 = 0;
                }
                this.K.setThreeDotMode(2);
                this.K.f(i2);
                this.K.setVisibility(0);
                return;
            }
            this.K.setVisibility(8);
        }
    }

    public final void O0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            if (i2 > 0) {
                if (p35.d().f() == 0) {
                    i2 = 0;
                }
                this.G.setThreeDotMode(2);
                this.G.f(i2);
                this.G.setVisibility(0);
                return;
            }
            this.G.setVisibility(8);
        }
    }

    public void b1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z2) == null) {
            if (z2) {
                if (k0() && this.i.getVisibility() != 0) {
                    this.i.setVisibility(0);
                }
            } else if (this.i.getVisibility() != 8) {
                this.i.setVisibility(8);
            }
        }
    }

    public void v0(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048628, this, newsNotifyMessage) != null) || newsNotifyMessage == null) {
            return;
        }
        this.T = newsNotifyMessage.getMsgAtme();
        this.U = newsNotifyMessage.getMsgAgree();
        J0(this.T);
        I0(this.U);
        M0(newsNotifyMessage.getMsgFans());
        O0(newsNotifyMessage.getMsgReplyme());
        K0(newsNotifyMessage.getMsgInvitation());
    }

    public void w0(boolean z2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) && z2 && (bdListView = this.f) != null && bdListView.getWrappedAdapter() != null && this.f.getWrappedAdapter().getCount() <= 0) {
            ah.a().post(new i(this));
        }
    }

    public final void G0(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage) && this.b != null) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            this.i0 = responsedMemoryListMessage.getData();
            List<ImMessageCenterShowItemData> data = this.b.getData();
            if (this.f0 != null && ListUtils.isEmpty(data)) {
                this.f0.A();
            }
            if (responsedMemoryListMessage.getType() == 1 && this.W) {
                g0();
                this.W = false;
            }
        }
    }

    public final void K0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 > 0) {
                if (ry4.l().i("key_question_msg_no_remind", false)) {
                    i2 = 0;
                }
                this.S.setThreeDotMode(2);
                this.S.f(i2);
                this.S.setVisibility(0);
                this.Q.setText(R.string.obfuscated_res_0x7f0f06f9);
                return;
            }
            this.S.setVisibility(8);
            this.Q.setText(R.string.obfuscated_res_0x7f0f06f8);
        }
    }

    public void U0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z2) == null) {
            if (z2) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_shield_svg, R.color.CAM_X1111, SvgManager.SvgResourceStateType.NORMAL);
                int g2 = yi.g(this.a.getContext(), R.dimen.tbds34);
                pureDrawable.setBounds(new Rect(0, 0, g2, g2));
                this.R.setCompoundDrawables(null, null, pureDrawable, null);
                this.R.setVisibility(0);
                return;
            }
            this.R.setVisibility(8);
        }
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a.registerListener(2016004, this.B0);
            this.a.registerListener(2016001, this.B0);
            this.a.registerListener(2016010, this.B0);
            this.a.registerListener(2016007, this.B0);
            this.a.registerListener(2016011, this.B0);
            this.a.registerListener(2016002, this.B0);
            this.a.registerListener(this.H0);
            this.a.registerListener(this.D0);
            this.a.registerListener(this.E0);
            this.a.registerListener(this.G0);
            this.a.registerListener(this.J0);
            this.a.registerListener(this.t0);
            this.a.registerListener(this.w0);
            this.a.registerListener(this.M0);
            this.a.registerListener(this.L0);
            this.a.registerListener(this.K0);
            this.a.registerListener(this.F0);
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.B0);
            MessageManager.getInstance().unRegisterListener(this.H0);
            MessageManager.getInstance().unRegisterListener(this.D0);
            MessageManager.getInstance().unRegisterListener(this.E0);
            MessageManager.getInstance().unRegisterListener(this.G0);
            MessageManager.getInstance().unRegisterListener(this.J0);
            MessageManager.getInstance().unRegisterListener(this.L0);
            MessageManager.getInstance().unRegisterListener(this.K0);
            if (this.c0) {
                MessageManager.getInstance().unRegisterListener(this.v0);
                MessageManager.getInstance().unRegisterTask(309712);
                MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST);
            }
            MessageManager.getInstance().unRegisterListener(this.t0);
            MessageManager.getInstance().unRegisterListener(this.w0);
            MessageManager.getInstance().unRegisterListener(this.M0);
            MessageManager.getInstance().unRegisterListener(this.F0);
            rg7 rg7Var = this.f0;
            if (rg7Var != null) {
                rg7Var.h();
            }
            TbSingleton.getInstance().setNeedJoinChatRoom(false);
        }
    }

    public final void t0() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && (bdListView = this.f) != null && this.b != null) {
            bdListView.A(0L);
            if (this.b.getData() != null && this.b.getData().size() > 0) {
                this.h.s(this.b.getData());
                if (!this.b0) {
                    this.b0 = true;
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.IM_TAB_SHOW_KEY);
                    statisticItem.param("obj_param1", "0").param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            MsgRecForumNetMessage msgRecForumNetMessage = new MsgRecForumNetMessage();
            msgRecForumNetMessage.mPn = 1;
            msgRecForumNetMessage.mRn = 15;
            msgRecForumNetMessage.userId = Long.valueOf(TbadkCoreApplication.getCurrentAccountId());
            this.a.sendMessage(msgRecForumNetMessage);
            if (!this.b0) {
                this.b0 = true;
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.IM_TAB_SHOW_KEY);
                statisticItem2.param("obj_param1", "1").param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            og5 og5Var = new og5(309712);
            og5Var.setResponsedClass(MsgRecForumSocketResMessage.class);
            og5Var.g(true);
            og5Var.h(false);
            og5Var.f(SocketMessageTask.DupLicateMode.NONE);
            MessageManager.getInstance().registerTask(og5Var);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST, tr8.a("c/f/forum/getMsgRecForumlist", 309712));
            tbHttpMessageTask.setResponsedClass(MsgRecForumHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.a.registerListener(this.v0);
            this.c0 = true;
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.b = new ImMessageCenterModel();
            a1(!ry4.l().i("is_shut_down_validate", false));
            this.d0 = new IMOfficialMaskModel();
            this.e0 = new IMUserListModel(this.a.getPageContext(), this.a.getUniqueId());
            this.f0 = new rg7(this.a.getPageContext(), this.u0);
        }
    }

    public View u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            this.o = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d01d5, (ViewGroup) null, false);
            h0();
            i0(this.o);
            TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
            if (!this.c0) {
                S0();
            }
            R0();
            A0();
            return this.o;
        }
        return (View) invokeV.objValue;
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            MessageAggregationListAdapter messageAggregationListAdapter = this.h;
            if (messageAggregationListAdapter != null && messageAggregationListAdapter.getCount() == 0) {
                Y0(true);
            }
            if (this.r || this.q) {
                this.r = false;
                this.q = false;
                H0();
            }
            boolean j0 = j0();
            if (this.p != j0) {
                this.p = j0;
            }
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.d(this.a.getPageContext());
            }
            b0();
        }
    }

    public final void T0(List<ImMessageCenterPojo> list, ImMessageCenterShowItemData imMessageCenterShowItemData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048594, this, list, imMessageCenterShowItemData, i2) == null) {
            ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage = new ResponsedGroupChatListCompleteMessage();
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 5) {
                            responsedGroupChatListCompleteMessage.setType(5);
                        }
                    } else {
                        responsedGroupChatListCompleteMessage.setType(3);
                        responsedGroupChatListCompleteMessage.setGid(imMessageCenterShowItemData.getFriendId());
                    }
                } else {
                    responsedGroupChatListCompleteMessage.setType(2);
                    responsedGroupChatListCompleteMessage.setGid(imMessageCenterShowItemData.getFriendId());
                }
            } else {
                responsedGroupChatListCompleteMessage.setType(1);
                responsedGroupChatListCompleteMessage.setListInfo(list);
            }
            MessageManager.getInstance().dispatchResponsedMessage(responsedGroupChatListCompleteMessage);
        }
    }

    public final void Z0(List<RecommendForumInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, list) == null) && list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            ImMessageCenterShowItemData imMessageCenterShowItemData = new ImMessageCenterShowItemData();
            imMessageCenterShowItemData.setDataType(1);
            arrayList.add(imMessageCenterShowItemData);
            ImMessageCenterShowItemData imMessageCenterShowItemData2 = new ImMessageCenterShowItemData();
            imMessageCenterShowItemData2.setDataType(3);
            arrayList.add(imMessageCenterShowItemData2);
            for (RecommendForumInfo recommendForumInfo : list) {
                if (recommendForumInfo != null && !StringUtils.isNull(recommendForumInfo.forum_name)) {
                    ImMessageCenterShowItemData imMessageCenterShowItemData3 = new ImMessageCenterShowItemData();
                    imMessageCenterShowItemData3.setDataType(2);
                    imMessageCenterShowItemData3.setAvatar(recommendForumInfo.avatar);
                    imMessageCenterShowItemData3.setForumId(recommendForumInfo.forum_id.longValue());
                    imMessageCenterShowItemData3.setForumName(recommendForumInfo.forum_name);
                    imMessageCenterShowItemData3.setIsLike(recommendForumInfo.is_like.intValue());
                    imMessageCenterShowItemData3.setMemberCount(recommendForumInfo.member_count.intValue());
                    imMessageCenterShowItemData3.setSlogan(recommendForumInfo.slogan);
                    imMessageCenterShowItemData3.setThreadCount(recommendForumInfo.thread_count.intValue());
                    arrayList.add(imMessageCenterShowItemData3);
                }
            }
            ImMessageCenterShowItemData imMessageCenterShowItemData4 = new ImMessageCenterShowItemData();
            imMessageCenterShowItemData4.setDataType(4);
            arrayList.add(imMessageCenterShowItemData4);
            if (this.h.getCount() == 0) {
                this.h.s(arrayList);
            }
        }
    }

    public void b0() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048602, this) != null) || this.f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        if (areNotificationsEnabled) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        statisticItem.param("obj_type", i2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            qj7 qj7Var = this.Z;
            if (qj7Var != null) {
                this.f.removeHeaderView(qj7Var.e());
                this.a0 = false;
                return;
            }
            return;
        }
        long n2 = ry4.l().n("key_im_open_notification_close_time", 0L);
        if (!this.a0) {
            if (n2 == 0 || System.currentTimeMillis() - n2 > 604800000) {
                if (this.Z == null) {
                    qj7 qj7Var2 = new qj7(this.mContext);
                    this.Z = qj7Var2;
                    qj7Var2.g(this.x0);
                }
                this.f.x(this.Z.e(), 0);
                this.a0 = true;
            }
        }
    }

    public void c1(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, imMessageCenterShowItemData) != null) || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.unfriend_del, TBAlertConfig.OperateBtnStyle.ALERT);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.unfriend_cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        int i2 = R.string.obfuscated_res_0x7f0f12b9;
        if (String.valueOf(9).equals(imMessageCenterShowItemData.getOwnerName())) {
            i2 = R.string.obfuscated_res_0x7f0f12ba;
        }
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(TbadkCoreApplication.getInst().getCurrentActivity());
        this.h0 = tBAlertBuilder;
        tBAlertBuilder.v(R.string.obfuscated_res_0x7f0f14be);
        tBAlertBuilder.m(i2);
        tBAlertBuilder.o(true);
        tBAlertBuilder.t(aVar2, aVar);
        tBAlertBuilder.j(false);
        this.g0 = tBAlertBuilder.y();
        aVar2.a(new d(this));
        aVar.a(new e(this, imMessageCenterShowItemData));
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            c0();
            if (this.M == null) {
                this.M = uc7.m().p(getPageContext().getPageActivity());
            }
            this.M.show();
            this.M.b(0);
        }
    }

    public final void i0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, view2) == null) {
            this.n = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09062e);
            ShutDownValidateTipView shutDownValidateTipView = (ShutDownValidateTipView) view2.findViewById(R.id.obfuscated_res_0x7f09268b);
            this.i = shutDownValidateTipView;
            shutDownValidateTipView.setVisibility(8);
            this.i.setShutDownClickListener(new z(this));
            this.g = (NavigationBarShadowView) view2.findViewById(R.id.obfuscated_res_0x7f0916dd);
            BdListView bdListView = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f09062f);
            this.f = bdListView;
            bdListView.setDividerHeight(0);
            MessageAggregationListAdapter messageAggregationListAdapter = new MessageAggregationListAdapter(this.a.getPageContext().getPageActivity());
            this.h = messageAggregationListAdapter;
            messageAggregationListAdapter.T(this.a.getPageContext());
            this.h.Q(this);
            this.f.setAdapter((ListAdapter) this.h);
            this.f.setOnItemClickListener(this.y0);
            this.f.setOnItemLongClickListener(this.z0);
            this.f.setOnScrollListener(this.r0);
            View inflate = View.inflate(this.mContext.getPageActivity(), R.layout.obfuscated_res_0x7f0d05b3, null);
            this.u = inflate;
            this.v = inflate.findViewById(R.id.obfuscated_res_0x7f0902de);
            this.w = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f0902dd);
            this.x = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f0902e1);
            this.y = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f0902df);
            this.z = this.u.findViewById(R.id.obfuscated_res_0x7f09015f);
            this.A = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f09015e);
            this.B = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090163);
            this.C = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f090160);
            this.D = this.u.findViewById(R.id.obfuscated_res_0x7f091cac);
            this.E = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f091cab);
            this.F = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f091caf);
            this.G = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f091cad);
            this.H = this.u.findViewById(R.id.obfuscated_res_0x7f0909cd);
            this.I = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f0909cc);
            this.J = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f0909d1);
            this.K = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f0909ce);
            this.L = this.u.findViewById(R.id.obfuscated_res_0x7f091f1f);
            RelativeLayout relativeLayout = (RelativeLayout) this.u.findViewById(R.id.obfuscated_res_0x7f091010);
            this.N = relativeLayout;
            relativeLayout.setOnClickListener(this.A0);
            this.O = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f09100c);
            this.P = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f09100f);
            this.R = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f09100e);
            U0(ry4.l().i("key_question_msg_no_remind", false));
            this.Q = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f09100b);
            MessageRedDotView messageRedDotView = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f09100d);
            this.S = messageRedDotView;
            messageRedDotView.setThreeDotMode(2);
            K0(ry4.l().m(ry4.p("msg_tab_entrance_invitation_answer_unread_num"), 0));
            V0(ry4.l().i(ry4.p("msg_tab_entrance_invitation_answer"), false));
            this.y.setThreeDotMode(2);
            this.C.setThreeDotMode(2);
            this.G.setThreeDotMode(2);
            this.K.setThreeDotMode(2);
            this.y.setShadowEnabled(false);
            this.C.setShadowEnabled(false);
            this.G.setShadowEnabled(false);
            this.v.setOnClickListener(this);
            this.z.setOnClickListener(this);
            this.D.setOnClickListener(this);
            this.H.setOnClickListener(this);
            this.f.addHeaderView(this.u);
            b0();
            this.d = (BdSwipeRefreshLayout) view2.findViewById(R.id.obfuscated_res_0x7f091cae);
            if (this.e == null) {
                bz4 bz4Var = new bz4(this.a.getPageContext());
                this.e = bz4Var;
                bz4Var.f(this.s0);
            }
            this.e.b0(getPageContext().getUniqueId());
            this.d.setProgressView(this.e);
            this.t = new View(this.a.getFragmentActivity());
            this.t.setLayoutParams(new AbsListView.LayoutParams(-1, yi.g(this.a.getFragmentActivity(), R.dimen.obfuscated_res_0x7f07024d)));
            this.f.addFooterView(this.t);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, view2) == null) {
            StatisticItem statisticItem = new StatisticItem("c13720");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            int i4 = 2;
            if (view2 == this.v) {
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_AT_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount());
                if (this.T > 0) {
                    i4 = 1;
                }
                TiebaStatic.log(param.param("obj_type", i4).param("obj_param1", this.T));
                AtMeActivityConfig atMeActivityConfig = new AtMeActivityConfig(getPageContext().getPageActivity());
                r9<T> r9Var = this.mContext;
                if (r9Var != 0 && r9Var.getUniqueId() != null) {
                    atMeActivityConfig.setLastUniqueId(this.mContext.getUniqueId().getId());
                }
                atMeActivityConfig.setAtNumber(this.T);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atMeActivityConfig));
                n35.h0().j();
                n35.h0().Z(0);
                this.T = 0;
                J0(0);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                statisticItem.param("obj_type", 1);
            } else if (view2 == this.z) {
                StatisticItem param2 = new StatisticItem("c12926").param("uid", TbadkCoreApplication.getCurrentAccount());
                if (this.U > 0) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                TiebaStatic.log(param2.param("obj_type", i3).param("obj_param1", this.U));
                StatisticItem statisticItem2 = new StatisticItem("c12926");
                MessageRedDotView messageRedDotView = this.C;
                if (messageRedDotView != null && messageRedDotView.getVisibility() == 0) {
                    statisticItem2.addParam("obj_type", 1);
                } else {
                    statisticItem2.addParam("obj_type", 2);
                }
                statisticItem2.eventStat();
                AgreeMeActivityConfig agreeMeActivityConfig = new AgreeMeActivityConfig(getPageContext().getPageActivity());
                r9<T> r9Var2 = this.mContext;
                if (r9Var2 != 0 && r9Var2.getUniqueId() != null) {
                    agreeMeActivityConfig.setLastUniqueId(this.mContext.getUniqueId().getId());
                }
                agreeMeActivityConfig.setAgreeNumber(this.U);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, agreeMeActivityConfig));
                n35.h0().h();
                n35.h0().Y(0);
                this.U = 0;
                I0(0);
                statisticItem.param("obj_type", 2);
            } else if (view2 == this.D) {
                int A = n35.h0().A();
                StatisticItem param3 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_REPLY_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount());
                if (A > 0) {
                    i4 = 1;
                }
                TiebaStatic.log(param3.param("obj_type", i4).param("obj_param1", A));
                ReplyMeActivityConfig replyMeActivityConfig = new ReplyMeActivityConfig(getPageContext().getPageActivity());
                replyMeActivityConfig.setFrom(1);
                r9<T> r9Var3 = this.mContext;
                if (r9Var3 != 0 && r9Var3.getUniqueId() != null) {
                    replyMeActivityConfig.setLastUniqueId(this.mContext.getUniqueId().getId());
                }
                replyMeActivityConfig.setReplyNumber(A);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, replyMeActivityConfig));
                n35.h0().o();
                n35.h0().f0(0);
                O0(0);
            } else if (view2 == this.H) {
                int x2 = n35.h0().x();
                StatisticItem param4 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_FANS_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount());
                if (x2 > 0) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                TiebaStatic.log(param4.param("obj_type", i2).param("obj_param1", x2));
                PersonRedTipManager.getInstance().updateRedTipState(2, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
                PersonListActivityConfig personListActivityConfig = new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0);
                r9<T> r9Var4 = this.mContext;
                if (r9Var4 != 0 && r9Var4.getUniqueId() != null) {
                    personListActivityConfig.setLastUniqueId(this.mContext.getUniqueId().getId());
                }
                personListActivityConfig.setFansNumber(x2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personListActivityConfig));
                n35.h0().l();
                n35.h0().c0(0);
                M0(0);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean s0(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048625, this, tbPageContext, i2)) == null) {
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.f(this.a.getPageContext(), i2);
            }
            ShutDownValidateTipView shutDownValidateTipView = this.i;
            if (shutDownValidateTipView != null) {
                shutDownValidateTipView.b(i2);
            }
            MessageAggregationListAdapter messageAggregationListAdapter = this.h;
            if (messageAggregationListAdapter != null) {
                messageAggregationListAdapter.notifyDataSetChanged();
            }
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().k(this.n);
            }
            bz4 bz4Var = this.e;
            if (bz4Var != null) {
                bz4Var.H(i2);
            }
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.F, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.J, (int) R.color.CAM_X0105);
            WebPManager.setMaskDrawable(this.w, R.drawable.obfuscated_res_0x7f08082a, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setMaskDrawable(this.A, R.drawable.obfuscated_res_0x7f08082c, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setMaskDrawable(this.E, R.drawable.obfuscated_res_0x7f08082d, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setMaskDrawable(this.I, R.drawable.obfuscated_res_0x7f08082b, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setBackgroundColor(this.L, R.color.CAM_X0203);
            rw4 d2 = rw4.d(this.N);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0206);
            WebPManager.setMaskDrawable(this.O, R.drawable.obfuscated_res_0x7f08082e, WebPManager.ResourceStateType.NORMAL);
            rw4 d3 = rw4.d(this.P);
            d3.z(R.dimen.T_X07);
            d3.A(R.string.F_X02);
            d3.v(R.color.CAM_X0105);
            rw4 d4 = rw4.d(this.Q);
            d4.v(R.color.CAM_X0108);
            d4.A(R.string.F_X01);
            d4.z(R.dimen.T_X08);
            MessageRedDotView messageRedDotView = this.S;
            if (messageRedDotView != null) {
                messageRedDotView.e();
            }
            MessageRedDotView messageRedDotView2 = this.y;
            if (messageRedDotView2 != null) {
                messageRedDotView2.e();
            }
            MessageRedDotView messageRedDotView3 = this.C;
            if (messageRedDotView3 != null) {
                messageRedDotView3.e();
            }
            MessageRedDotView messageRedDotView4 = this.G;
            if (messageRedDotView4 != null) {
                messageRedDotView4.e();
            }
            MessageRedDotView messageRedDotView5 = this.K;
            if (messageRedDotView5 != null) {
                messageRedDotView5.e();
            }
            qj7 qj7Var = this.Z;
            if (qj7Var != null) {
                qj7Var.f(i2);
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
