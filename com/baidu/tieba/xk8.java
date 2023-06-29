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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.aa5;
import com.baidu.tieba.ce8;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedGroupChatListCompleteMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.model.IMUserListHttpResponseMsg;
import com.baidu.tieba.im.model.IMUserListModel;
import com.baidu.tieba.immessagecenter.StrangerListActivityConfig;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.immessagecenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.immessagecenter.im.model.IMOfficialMaskModel;
import com.baidu.tieba.immessagecenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.immessagecenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.immessagecenter.mention.ChatAggregationFragment;
import com.baidu.tieba.immessagecenter.recforum.model.MsgRecForumHttpResMessage;
import com.baidu.tieba.immessagecenter.recforum.model.MsgRecForumNetMessage;
import com.baidu.tieba.immessagecenter.recforum.model.MsgRecForumSocketResMessage;
import com.baidu.tieba.r55;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.sl8;
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
/* loaded from: classes8.dex */
public class xk8 extends j9<ChatAggregationFragment> implements aa5.g, View.OnClickListener, bm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public final AdapterView.OnItemLongClickListener A0;
    public TextView B;
    public View.OnClickListener B0;
    public MessageRedDotView C;
    public final CustomMessageListener C0;
    public View D;
    public y78 D0;
    public ImageView E;
    public final CustomMessageListener E0;
    public TextView F;
    public final CustomMessageListener F0;
    public MessageRedDotView G;
    public final CustomMessageListener G0;
    public View H;
    public final CustomMessageListener H0;
    public ImageView I;
    public final CustomMessageListener I0;
    public TextView J;
    public final z78 J0;
    public MessageRedDotView K;
    public final CustomMessageListener K0;
    public View L;
    public final CustomMessageListener L0;
    public j55 M;
    public final CustomMessageListener M0;
    public RelativeLayout N;
    public HttpMessageListener N0;
    public ImageView O;
    public TextView P;
    public TextView Q;
    public TextView R;
    public MessageRedDotView S;

    /* renamed from: T  reason: collision with root package name */
    public int f1183T;
    public int U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public sl8 Z;
    public final ChatAggregationFragment a;
    public boolean a0;
    public ImMessageCenterModel b;
    public boolean b0;
    public ImMessageCenterShowItemData c;
    public boolean c0;
    public BdSwipeRefreshLayout d;
    public IMOfficialMaskModel d0;
    public ba5 e;
    public IMUserListModel e0;
    public BdListView f;
    public ce8 f0;
    public NavigationBarShadowView g;
    public AlertDialog g0;
    public MessageAggregationListAdapter h;
    public TBAlertBuilder h0;
    public ShutDownValidateTipView i;
    public List<ImMessageCenterPojo> i0;
    public p55 j;
    public ChatRoomInfo j0;
    public r55.f k;
    public NoDataView l;
    public boolean m;
    public RelativeLayout n;
    public View o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean r0;
    public int s;
    public AbsListView.OnScrollListener s0;
    public View t;
    public final aa5.g t0;
    public View u;
    public CustomMessageListener u0;
    public View v;
    @NonNull
    public ce8.h v0;
    public ImageView w;
    public kb w0;
    public TextView x;
    public CustomMessageListener x0;
    public MessageRedDotView y;
    public sl8.b y0;
    public View z;
    public final AdapterView.OnItemClickListener z0;

    @Override // com.baidu.tieba.aa5.g
    public void f(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z2) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        public a(xk8 xk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk8Var;
        }

        public final void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imMessageCenterShowItemData) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_ITEM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", "1").param("obj_param1", imMessageCenterShowItemData.getUnReadCount()).param(TiebaStatic.Params.FRIEND_UID, imMessageCenterShowItemData.getFriendId()));
                if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                    qe5.p0().i0(qe5.p0().x() - imMessageCenterShowItemData.getUnReadCount());
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
            } else if (ownerName.equals("5")) {
                TiebaStatic.log("c12931");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialBarFeedActivityConfig(this.a.a.getPageContext().getPageActivity())));
            } else if (ownerName.equals("8")) {
                if (!hk8.a(this.a.a.getPageContext().getOrignalPage(), 2002006)) {
                    return;
                }
                long g = vg.g(item.getFriendId(), 0L);
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
                    yo5.a().d(this.a.a.getPageContext().getContext(), Long.parseLong(item.getFriendId()), "source_from_message_tab", 3);
                    this.a.X = true;
                    if (this.a.f0 != null) {
                        this.a.f0.t(true);
                    }
                }
                if (this.a.f0 != null) {
                    if (item.getAtInfoData() != null) {
                        item.setAtInfoData(null);
                    }
                    item.setUnReadCount(0);
                    this.a.a1(false);
                    this.a.f0.T(vg.g(item.getFriendId(), 0L));
                    this.a.i1(null, item, 2);
                    this.a.f0.I();
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

    /* loaded from: classes8.dex */
    public class a0 implements sl8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        public a0(xk8 xk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk8Var;
        }

        @Override // com.baidu.tieba.sl8.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.Z != null) {
                this.a.f.removeHeaderView(this.a.Z.f());
                this.a.a0 = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        public b(xk8 xk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk8Var;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                xk8 xk8Var = this.a;
                xk8Var.c = xk8Var.h.getItem(i);
                if (this.a.c != null && this.a.c.getDataType() == 2) {
                    return true;
                }
                xk8 xk8Var2 = this.a;
                if (!xk8Var2.R0(xk8Var2.c)) {
                    adapterView.setHapticFeedbackEnabled(false);
                    return true;
                }
                if (this.a.j != null) {
                    TiebaStatic.log("c12932");
                    this.a.j.l();
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

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        public c(xk8 xk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                r95.p().F(r95.t("msg_tab_entrance_invitation_answer_unread_num"), 0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2008024));
                if (this.a.S.getVisibility() == 0) {
                    if (r95.p().l("key_question_msg_no_remind", false)) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                } else {
                    i = 0;
                }
                new StatisticItem(CommonStatisticKey.KEY_QUESTION_ENTRANCE_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_type", i).eventStat();
                this.a.Z0(0);
                pz4 j = pz4.j(this.a.a.getContext(), TbConfig.QUESTION_THREAD_LIST);
                j.p(this.a.a.getString(R.string.obfuscated_res_0x7f0f0ae0));
                j.k(true);
                j.d(true);
                TbWebViewActivityConfig b = j.b();
                if (b != null) {
                    b.setNoClose(true);
                    b.setNoHelp(false);
                    b.setCustomMoreHelp(true);
                    b.start();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        public d(xk8 xk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g0 != null) {
                this.a.g0.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterShowItemData a;
        public final /* synthetic */ xk8 b;

        public e(xk8 xk8Var, ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var, imMessageCenterShowItemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xk8Var;
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
                if (ik8.a(this.a)) {
                    statisticItem.param("obj_type", 1);
                } else if (ik8.b(this.a)) {
                    statisticItem.param("obj_type", 3);
                } else {
                    statisticItem.param("obj_type", 2);
                }
                TiebaStatic.log(statisticItem);
                this.b.b.asyncDeleteItem(this.a, this.b.J0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements r55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ImMessageCenterShowItemData b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ xk8 g;

        public f(xk8 xk8Var, String str, ImMessageCenterShowItemData imMessageCenterShowItemData, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var, str, imMessageCenterShowItemData, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = xk8Var;
            this.a = str;
            this.b = imMessageCenterShowItemData;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
        }

        @Override // com.baidu.tieba.r55.f
        public void M0(r55 r55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, r55Var, i, view2) == null) {
                if (this.g.j != null && this.g.j.isShowing() && this.g.a != null) {
                    this.g.j.dismiss();
                }
                String charSequence = ((EMTextView) view2).getText().toString();
                if (this.a.equals(charSequence)) {
                    TiebaStatic.log("c12933");
                    StatisticItem statisticItem = new StatisticItem("c14665");
                    if (ik8.a(this.b)) {
                        statisticItem.param("obj_type", 1);
                    } else if (ik8.b(this.b)) {
                        statisticItem.param("obj_type", 3);
                    } else {
                        statisticItem.param("obj_type", 2);
                    }
                    TiebaStatic.log(statisticItem);
                    this.g.s1(this.b);
                } else if (this.c.equals(charSequence)) {
                    StatisticItem statisticItem2 = new StatisticItem("c14664");
                    statisticItem2.param("obj_type", 1);
                    if (ik8.b(this.b)) {
                        statisticItem2.param("obj_source", 2);
                        long currentTimeMillis = System.currentTimeMillis();
                        ua8.b().g(Long.valueOf(vg.g(this.b.getFriendId(), 0L)), this.b.getFriendNameShow(), this.b.getFriendBjhAvatar(), currentTimeMillis);
                        this.b.setMarkTopIndex(currentTimeMillis);
                        this.g.a1(true);
                    } else {
                        statisticItem2.param("obj_source", 1);
                        hc8.c(this.b.getFriendId(), true);
                    }
                    TiebaStatic.log(statisticItem2);
                } else if (this.d.equals(charSequence)) {
                    StatisticItem statisticItem3 = new StatisticItem("c14664");
                    statisticItem3.param("obj_type", 2);
                    if (ik8.b(this.b)) {
                        statisticItem3.param("obj_source", 2);
                        ua8.b().g(Long.valueOf(vg.g(this.b.getFriendId(), 0L)), this.b.getFriendNameShow(), this.b.getFriendBjhAvatar(), 0L);
                        this.b.setMarkTopIndex(0L);
                        this.g.a1(true);
                    } else {
                        statisticItem3.param("obj_source", 1);
                        hc8.c(this.b.getFriendId(), false);
                    }
                    TiebaStatic.log(statisticItem3);
                } else if (this.e.equals(charSequence)) {
                    StatisticItem statisticItem4 = new StatisticItem("c14669");
                    statisticItem4.param("obj_type", 1);
                    if (this.g.d0 != null && ik8.c(this.b)) {
                        statisticItem4.param("obj_source", 1);
                        this.g.d0.U(true, this.b.getFriendId());
                    } else if (ik8.b(this.b)) {
                        statisticItem4.param("obj_source", 2);
                        ua8.b().f(Long.valueOf(vg.g(this.b.getFriendId(), 0L)), this.b.getFriendNameShow(), this.b.getFriendBjhAvatar(), false);
                        this.b.setNotify(false);
                        this.g.a1(false);
                        this.g.i1(null, this.b, 5);
                    }
                    TiebaStatic.log(statisticItem4);
                } else if (this.f.equals(charSequence)) {
                    StatisticItem statisticItem5 = new StatisticItem("c14669");
                    statisticItem5.param("obj_type", 2);
                    if (this.g.d0 != null && ik8.c(this.b)) {
                        statisticItem5.param("obj_source", 1);
                        this.g.d0.U(false, this.b.getFriendId());
                    } else if (ik8.b(this.b)) {
                        statisticItem5.param("obj_source", 2);
                        ua8.b().f(Long.valueOf(vg.g(this.b.getFriendId(), 0L)), this.b.getFriendNameShow(), this.b.getFriendBjhAvatar(), true);
                        this.b.setNotify(true);
                        this.g.a1(false);
                        this.g.i1(null, this.b, 5);
                    }
                    TiebaStatic.log(statisticItem5);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(xk8 xk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var, Integer.valueOf(i)};
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
            this.a = xk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                this.a.T0(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.S0(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.V0(customResponsedMessage);
                this.a.m1(false);
                this.a.f1();
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.a.b.setData(null, this.a.D0);
            } else if (customResponsedMessage.getCmd() == 2016010) {
                if (this.a.h != null) {
                    this.a.h.notifyDataSetChanged();
                }
            } else if (customResponsedMessage.getCmd() == 2016011 && this.a.h != null) {
                this.a.h.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements y78 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        public h(xk8 xk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk8Var;
        }

        @Override // com.baidu.tieba.y78
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.K0();
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        public i(xk8 xk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f.E();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        public j(xk8 xk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk8Var;
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

    /* loaded from: classes8.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(xk8 xk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var, Integer.valueOf(i)};
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
            this.a = xk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterShowItemData imMessageCenterShowItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921762 && (imMessageCenterShowItemData = (ImMessageCenterShowItemData) customResponsedMessage.getData()) != null && this.a.b.getData().contains(imMessageCenterShowItemData)) {
                imMessageCenterShowItemData.setGroupDelete(true);
                ua8.b().e(Long.valueOf(vg.g(imMessageCenterShowItemData.getFriendId(), 0L)), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendBjhAvatar(), imMessageCenterShowItemData.getServerTime());
                this.a.b.getData().remove(imMessageCenterShowItemData);
                if (this.a.h != null) {
                    this.a.h.u(this.a.b.getData());
                    this.a.h.notifyDataSetChanged();
                }
                this.a.f0.T(vg.g(imMessageCenterShowItemData.getFriendId(), 0L));
                this.a.i1(null, imMessageCenterShowItemData, 3);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(xk8 xk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var, Integer.valueOf(i)};
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
            this.a = xk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            ImMessageCenterShowItemData removeItemByRoomId;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.b != null && customResponsedMessage != null && this.a.r0 && this.a.f0 != null && customResponsedMessage.getCmd() == 2921784 && (removeItemByRoomId = this.a.b.getRemoveItemByRoomId((str = (String) customResponsedMessage.getData()))) != null && this.a.b.getData().contains(removeItemByRoomId)) {
                this.a.b.getData().remove(removeItemByRoomId);
                if (this.a.h != null) {
                    this.a.h.u(this.a.b.getData());
                    this.a.h.notifyDataSetChanged();
                }
                this.a.f0.V(str);
                if (!this.a.z0()) {
                    this.a.f0.U(null);
                }
                if (ListUtils.isEmpty(this.a.b.getData())) {
                    this.a.K0();
                }
                this.a.f0.T(vg.g(removeItemByRoomId.getFriendId(), 0L));
                this.a.i1(null, removeItemByRoomId, 3);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(xk8 xk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var, Integer.valueOf(i)};
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
            this.a = xk8Var;
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
                this.a.f0.X(this.a.j0);
                this.a.j0 = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(xk8 xk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var, Integer.valueOf(i)};
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

    /* loaded from: classes8.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(xk8 xk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var, Integer.valueOf(i)};
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
            this.a = xk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                this.a.U0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements z78 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        public p(xk8 xk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk8Var;
        }

        @Override // com.baidu.tieba.z78
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.s0();
        }

        @Override // com.baidu.tieba.z78
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.s0();
            this.a.a.showToast(R.string.delete_success, false);
            this.a.K0();
        }

        @Override // com.baidu.tieba.z78
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            this.a.u1();
        }

        @Override // com.baidu.tieba.z78
        public void onProgressUpdate(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) && this.a.M != null) {
                this.a.M.b(i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(xk8 xk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var, Integer.valueOf(i)};
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
            this.a = xk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                this.a.M0((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(xk8 xk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var, Integer.valueOf(i)};
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
            this.a = xk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2921727 && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.j1(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(xk8 xk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var, Integer.valueOf(i)};
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
            this.a = xk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2921726) {
                this.a.k1(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(xk8 xk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var, Integer.valueOf(i)};
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
            this.a = xk8Var;
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
                this.a.K0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u implements aa5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        public u(xk8 xk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk8Var;
        }

        @Override // com.baidu.tieba.aa5.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.m1(true);
                this.a.W0();
                if (this.a.d != null) {
                    this.a.d.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(xk8 xk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var, Integer.valueOf(i)};
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
            this.a = xk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371 || this.a.c0) {
                return;
            }
            this.a.h1();
            this.a.K0();
        }
    }

    /* loaded from: classes8.dex */
    public class w implements ce8.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        public w(xk8 xk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk8Var;
        }

        @Override // com.baidu.tieba.ce8.h
        public void a(@Nullable List<ImMessageCenterPojo> list, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(1048576, this, list, z) != null) || this.a.b == null) {
                return;
            }
            if (z) {
                if (ListUtils.isEmpty(list)) {
                    list = new ArrayList<>();
                }
                if (!ListUtils.isEmpty(this.a.i0)) {
                    list.addAll(this.a.i0);
                }
                this.a.i1(list, null, 1);
                this.a.b.setData(list, this.a.D0);
                return;
            }
            if (!ListUtils.isEmpty(this.a.i0)) {
                xk8 xk8Var = this.a;
                xk8Var.i1(xk8Var.i0, null, 1);
            }
            this.a.b.setData(this.a.i0, this.a.D0);
        }

        @Override // com.baidu.tieba.ce8.h
        public void b(List<ImMessageCenterPojo> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.a.b != null && !ListUtils.isEmpty(list)) {
                this.a.b.updateGroupchatList(list, this.a.D0);
                this.a.i1(list, null, 1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class x extends kb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(xk8 xk8Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = xk8Var;
        }

        @Override // com.baidu.tieba.kb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof MsgRecForumHttpResMessage;
                if (!z && !(responsedMessage instanceof MsgRecForumSocketResMessage)) {
                    return;
                }
                if (responsedMessage.getError() != 0) {
                    if (!this.a.Y && this.a.a != null && responsedMessage.getError() != -100000303) {
                        if (this.a.a.isPrimary()) {
                            this.a.a.showToast(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0e0f));
                        }
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
                this.a.o1(list);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(xk8 xk8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var, Integer.valueOf(i)};
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
            this.a = xk8Var;
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
            this.a.h.u(this.a.b.getData());
            this.a.h.notifyDataSetChanged();
        }
    }

    /* loaded from: classes8.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk8 a;

        public z(xk8 xk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                r95.p().A("is_shut_down_validate", true);
                this.a.p1(false);
                this.a.r1(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xk8(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) r9.a(chatAggregationFragment.getPageContext().getPageActivity()));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatAggregationFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((l9) newInitContext.callArgs[0]);
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
        this.r0 = false;
        this.s0 = new j(this);
        this.t0 = new u(this);
        this.u0 = new v(this, 2001371);
        this.v0 = new w(this);
        this.w0 = new x(this, CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST, 309712);
        this.x0 = new y(this, 2921691);
        this.y0 = new a0(this);
        this.z0 = new a(this);
        this.A0 = new b(this);
        this.B0 = new c(this);
        this.C0 = new g(this, 0);
        this.D0 = new h(this);
        this.E0 = new k(this, 2921762);
        this.F0 = new l(this, 2921784);
        this.G0 = new m(this, 2921772);
        this.H0 = new n(this, 2921770);
        this.I0 = new o(this, 2001120);
        this.J0 = new p(this);
        this.K0 = new q(this, 2001120);
        this.L0 = new r(this, 2921727);
        this.M0 = new s(this, 2921726);
        this.N0 = new t(this, CmdConfigHttp.CMD_GET_USER_LIST);
        this.a = chatAggregationFragment;
    }

    public void C0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) && bundle != null) {
            this.s = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.s);
        }
    }

    public void O0(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, intent) == null) && intent != null) {
            int intExtra = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            this.s = intExtra;
            if (intExtra == -1) {
                return;
            }
            n1(true);
            P0();
        }
    }

    public final void U0(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, responsedMessage) != null) || responsedMessage == null) {
            return;
        }
        if (!(responsedMessage instanceof NewsNotifyMessage)) {
            BdLog.e("transform error");
        } else {
            a1(false);
        }
    }

    public void k1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z2) == null) {
            if (z2) {
                this.N.setVisibility(0);
                this.L.setVisibility(8);
            } else {
                this.N.setVisibility(8);
                this.L.setVisibility(0);
            }
            v1();
        }
    }

    public void l1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z2) == null) {
            this.r = z2;
        }
    }

    public void m1(boolean z2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) && this.d != null) {
            if (z2 && (bdListView = this.f) != null) {
                bdListView.setSelection(0);
            }
            this.d.setRefreshing(z2);
        }
    }

    public void n1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z2) == null) {
            this.q = z2;
        }
    }

    public void p1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) {
            this.m = z2;
        }
    }

    public void t1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z2) == null) && z2) {
            e1();
            v1();
        }
    }

    public final boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return TbadkCoreApplication.isLogin();
        }
        return invokeV.booleanValue;
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public void D0() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (messageAggregationListAdapter = this.h) != null) {
            messageAggregationListAdapter.notifyDataSetChanged();
        }
    }

    public void F0() {
        ce8 ce8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ce8Var = this.f0) != null) {
            ce8Var.I();
        }
    }

    public void G0() {
        ce8 ce8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (ce8Var = this.f0) != null) {
            if (this.X) {
                this.X = false;
                ce8Var.Q();
            } else if (TbSingleton.getInstance().isNeedJoinChatRoom()) {
                this.f0.Q();
            }
        }
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f.E();
            this.p = A0();
        }
    }

    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.W = true;
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public void a() {
        TBAlertBuilder tBAlertBuilder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (tBAlertBuilder = this.h0) != null && this.g0 != null) {
            tBAlertBuilder.g();
        }
    }

    public void c1() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (bdSwipeRefreshLayout = this.d) != null && !bdSwipeRefreshLayout.r()) {
            m1(true);
        }
    }

    public void e1() {
        IMUserListModel iMUserListModel;
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (iMUserListModel = this.e0) != null && (imMessageCenterModel = this.b) != null) {
            iMUserListModel.request(true, imMessageCenterModel.getUids());
        }
    }

    public void f1() {
        IMUserListModel iMUserListModel;
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (iMUserListModel = this.e0) != null && (imMessageCenterModel = this.b) != null && this.V) {
            iMUserListModel.request(false, imMessageCenterModel.getUids());
            this.V = false;
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.a.getPageContext().getPageActivity();
        }
        return (Activity) invokeV.objValue;
    }

    public final void s0() {
        j55 j55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (j55Var = this.M) != null && j55Var.isShowing()) {
            this.M.dismiss();
            this.M = null;
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            TbSingleton.getInstance().setNeedJoinChatRoom(true);
            W0();
            this.r0 = true;
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            TbSingleton.getInstance().setNeedJoinChatRoom(false);
            ce8 ce8Var = this.f0;
            if (ce8Var != null) {
                ce8Var.I();
            }
            this.r0 = false;
        }
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048629, this) == null) && this.N.getVisibility() == 0) {
            new StatisticItem(CommonStatisticKey.KEY_QUESTION_ENTRANCE_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && this.f0 != null && BdNetTypeUtil.isNetWorkAvailable()) {
            this.f0.S();
        }
    }

    public final boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            ce8 ce8Var = this.f0;
            if (ce8Var == null || ListUtils.isEmpty(ce8Var.L(0))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.C0);
            MessageManager.getInstance().unRegisterListener(this.I0);
            MessageManager.getInstance().unRegisterListener(this.E0);
            MessageManager.getInstance().unRegisterListener(this.F0);
            MessageManager.getInstance().unRegisterListener(this.H0);
            MessageManager.getInstance().unRegisterListener(this.K0);
            MessageManager.getInstance().unRegisterListener(this.M0);
            MessageManager.getInstance().unRegisterListener(this.L0);
            if (this.c0) {
                MessageManager.getInstance().unRegisterListener(this.w0);
                MessageManager.getInstance().unRegisterTask(309712);
                MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST);
            }
            MessageManager.getInstance().unRegisterListener(this.u0);
            MessageManager.getInstance().unRegisterListener(this.x0);
            MessageManager.getInstance().unRegisterListener(this.N0);
            MessageManager.getInstance().unRegisterListener(this.G0);
            ce8 ce8Var = this.f0;
            if (ce8Var != null) {
                ce8Var.o();
            }
            TbSingleton.getInstance().setNeedJoinChatRoom(false);
            MessageAggregationListAdapter messageAggregationListAdapter = this.h;
            if (messageAggregationListAdapter != null) {
                messageAggregationListAdapter.Q();
            }
        }
    }

    public final void K0() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (bdListView = this.f) != null && this.b != null) {
            bdListView.z(0L);
            if (this.b.getData() != null && this.b.getData().size() > 0) {
                this.h.u(this.b.getData());
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

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.a.registerListener(2016004, this.C0);
            this.a.registerListener(2016001, this.C0);
            this.a.registerListener(2016010, this.C0);
            this.a.registerListener(2016007, this.C0);
            this.a.registerListener(2016011, this.C0);
            this.a.registerListener(2016002, this.C0);
            this.a.registerListener(this.I0);
            this.a.registerListener(this.E0);
            this.a.registerListener(this.F0);
            this.a.registerListener(this.H0);
            this.a.registerListener(this.K0);
            this.a.registerListener(this.u0);
            this.a.registerListener(this.x0);
            this.a.registerListener(this.N0);
            this.a.registerListener(this.M0);
            this.a.registerListener(this.L0);
            this.a.registerListener(this.G0);
        }
    }

    public boolean I0(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, tbPageContext, i2)) == null) {
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
            ba5 ba5Var = this.e;
            if (ba5Var != null) {
                ba5Var.H(i2);
            }
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.F, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.J, (int) R.color.CAM_X0105);
            WebPManager.setMaskDrawable(this.w, R.drawable.obfuscated_res_0x7f0809c7, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setMaskDrawable(this.A, R.drawable.obfuscated_res_0x7f0809c9, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setMaskDrawable(this.E, R.drawable.obfuscated_res_0x7f0809ca, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setMaskDrawable(this.I, R.drawable.obfuscated_res_0x7f0809c8, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setBackgroundColor(this.L, R.color.CAM_X0203);
            s75 d2 = s75.d(this.N);
            d2.o(R.string.J_X06);
            d2.f(R.color.CAM_X0206);
            WebPManager.setMaskDrawable(this.O, R.drawable.obfuscated_res_0x7f0809cb, WebPManager.ResourceStateType.NORMAL);
            s75 d3 = s75.d(this.P);
            d3.C(R.dimen.T_X07);
            d3.D(R.string.F_X02);
            d3.x(R.color.CAM_X0105);
            s75 d4 = s75.d(this.Q);
            d4.x(R.color.CAM_X0108);
            d4.D(R.string.F_X01);
            d4.C(R.dimen.T_X08);
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
            sl8 sl8Var = this.Z;
            if (sl8Var != null) {
                sl8Var.g(i2, true);
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public View L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            this.o = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d01f3, (ViewGroup) null, false);
            x0();
            y0(this.o);
            TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
            if (!this.c0) {
                h1();
            }
            g1();
            Q0();
            return this.o;
        }
        return (View) invokeV.objValue;
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageAggregationListAdapter messageAggregationListAdapter = this.h;
            if (messageAggregationListAdapter != null && messageAggregationListAdapter.getCount() == 0) {
                n1(true);
            }
            if (this.r || this.q) {
                this.r = false;
                this.q = false;
                W0();
            }
            boolean A0 = A0();
            if (this.p != A0) {
                this.p = A0;
            }
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.d(this.a.getPageContext());
            }
            r0();
        }
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            wt5 wt5Var = new wt5(309712);
            wt5Var.setResponsedClass(MsgRecForumSocketResMessage.class);
            wt5Var.g(true);
            wt5Var.h(false);
            wt5Var.f(SocketMessageTask.DupLicateMode.NONE);
            MessageManager.getInstance().registerTask(wt5Var);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST, v3a.a("c/f/forum/getMsgRecForumlist", 309712));
            tbHttpMessageTask.setResponsedClass(MsgRecForumHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.a.registerListener(this.w0);
            this.c0 = true;
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.b = new ImMessageCenterModel();
            p1(!r95.p().l("is_shut_down_validate", false));
            this.d0 = new IMOfficialMaskModel();
            this.e0 = new IMUserListModel(this.a.getPageContext(), this.a.getUniqueId());
            this.f0 = new ce8(this.a.getPageContext(), this.v0);
        }
    }

    public void M0(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, newsNotifyMessage) != null) || newsNotifyMessage == null) {
            return;
        }
        this.f1183T = newsNotifyMessage.getMsgAtme();
        this.U = newsNotifyMessage.getMsgAgree();
        Y0(this.f1183T);
        X0(this.U);
        b1(newsNotifyMessage.getMsgFans());
        d1(newsNotifyMessage.getMsgReplyme());
        Z0(newsNotifyMessage.getMsgInvitation());
    }

    public void N0(boolean z2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z2) == null) && z2 && (bdListView = this.f) != null && bdListView.getWrappedAdapter() != null && this.f.getWrappedAdapter().getCount() <= 0) {
            yg.a().post(new i(this));
        }
    }

    public final void T0(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
            w0();
        }
    }

    public final void X0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (i2 > 0) {
                if (se5.d().f() == 0) {
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

    public final void Y0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (i2 > 0) {
                if (se5.d().f() == 0) {
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

    public final void a1(boolean z2) {
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048601, this, z2) != null) || this.h == null) {
            return;
        }
        if (z2 && (imMessageCenterModel = this.b) != null && imMessageCenterModel.getData() != null && this.b.getData().size() > 0) {
            this.b.sortList();
            this.h.u(this.b.getData());
        }
        this.h.notifyDataSetChanged();
    }

    public final void b1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            if (i2 > 0) {
                if (se5.d().f() == 0) {
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

    public final void d1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            if (i2 > 0) {
                if (se5.d().f() == 0) {
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

    public void r1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z2) == null) {
            if (z2) {
                if (B0() && this.i.getVisibility() != 0) {
                    this.i.setVisibility(0);
                }
            } else if (this.i.getVisibility() != 8) {
                this.i.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.bm8
    public void u(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) {
            if (z2) {
                if (B0() && this.i.getVisibility() != 0) {
                    this.i.setVisibility(0);
                }
            } else if (this.i.getVisibility() != 8) {
                this.i.setVisibility(8);
            }
        }
    }

    public final boolean R0(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, imMessageCenterShowItemData)) == null) {
            String string = this.a.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
            String string2 = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f169a);
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
            if (ik8.a(imMessageCenterShowItemData)) {
                arrayList.add(str);
                arrayList.add(string);
            } else if (ik8.c(imMessageCenterShowItemData)) {
                arrayList.add(str3);
                arrayList.add(string);
            } else if (ik8.b(imMessageCenterShowItemData)) {
                arrayList.add(str);
                arrayList.add(str3);
                arrayList.add(string);
            } else {
                return false;
            }
            this.k = fVar;
            this.j = new p55(this.a.getPageContext());
            this.j.i(null, (String[]) arrayList.toArray(new String[arrayList.size()]), this.k);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void S0(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        ImMessageCenterModel imMessageCenterModel2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof MemoryChangedMessage)) {
            return;
        }
        MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
        ImMessageCenterPojo data = memoryChangedMessage.getData();
        if (memoryChangedMessage.getType() == 1) {
            ImMessageCenterModel imMessageCenterModel3 = this.b;
            if (imMessageCenterModel3 != null) {
                imMessageCenterModel3.insertOrUpdate(data, this.D0);
            }
        } else if (memoryChangedMessage.getType() == 2 && (imMessageCenterModel = this.b) != null) {
            imMessageCenterModel.remove(data, this.D0);
        }
        MessageAggregationListAdapter messageAggregationListAdapter = this.h;
        if (messageAggregationListAdapter != null && (imMessageCenterModel2 = this.b) != null) {
            messageAggregationListAdapter.u(imMessageCenterModel2.getData());
            this.h.notifyDataSetChanged();
        }
    }

    public final void V0(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage) && this.b != null) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            this.i0 = responsedMemoryListMessage.getData();
            List<ImMessageCenterShowItemData> data = this.b.getData();
            if (this.f0 != null && ListUtils.isEmpty(data)) {
                this.f0.R();
            }
            if (responsedMemoryListMessage.getType() == 1 && this.W) {
                w0();
                this.W = false;
            }
        }
    }

    public final void Z0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            if (i2 > 0) {
                if (r95.p().l("key_question_msg_no_remind", false)) {
                    i2 = 0;
                }
                this.S.setThreeDotMode(2);
                this.S.f(i2);
                this.S.setVisibility(0);
                this.Q.setText(R.string.obfuscated_res_0x7f0f07e1);
                return;
            }
            this.S.setVisibility(8);
            this.Q.setText(R.string.obfuscated_res_0x7f0f07e0);
        }
    }

    public void j1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z2) == null) {
            if (z2) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_shield_svg, R.color.CAM_X1111, SvgManager.SvgResourceStateType.NORMAL);
                int g2 = xi.g(this.a.getContext(), R.dimen.tbds34);
                pureDrawable.setBounds(new Rect(0, 0, g2, g2));
                this.R.setCompoundDrawables(null, null, pureDrawable, null);
                this.R.setVisibility(0);
                return;
            }
            this.R.setVisibility(8);
        }
    }

    public final void i1(List<ImMessageCenterPojo> list, ImMessageCenterShowItemData imMessageCenterShowItemData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048611, this, list, imMessageCenterShowItemData, i2) == null) {
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

    public final void o1(List<RecommendForumInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, list) == null) && list != null && list.size() > 0) {
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
                this.h.u(arrayList);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, view2) == null) {
            StatisticItem statisticItem = new StatisticItem("c13720");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            int i3 = 2;
            int i4 = 1;
            if (view2 == this.v) {
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_AT_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount());
                if (this.f1183T > 0) {
                    i3 = 1;
                }
                TiebaStatic.log(param.param("obj_type", i3).param("obj_param1", this.f1183T));
                AtMeActivityConfig atMeActivityConfig = new AtMeActivityConfig(getPageContext().getPageActivity());
                l9<T> l9Var = this.mContext;
                if (l9Var != 0 && l9Var.getUniqueId() != null) {
                    atMeActivityConfig.setLastUniqueId(this.mContext.getUniqueId().getId());
                }
                atMeActivityConfig.setAtNumber(this.f1183T);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atMeActivityConfig));
                qe5.p0().j();
                qe5.p0().g0(0);
                this.f1183T = 0;
                Y0(0);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                statisticItem.param("obj_type", 1);
            } else if (view2 == this.z) {
                StatisticItem param2 = new StatisticItem("c12926").param("uid", TbadkCoreApplication.getCurrentAccount());
                if (this.U <= 0) {
                    i4 = 2;
                }
                TiebaStatic.log(param2.param("obj_type", i4).param("obj_param1", this.U));
                AgreeMeActivityConfig agreeMeActivityConfig = new AgreeMeActivityConfig(getPageContext().getPageActivity());
                l9<T> l9Var2 = this.mContext;
                if (l9Var2 != 0 && l9Var2.getUniqueId() != null) {
                    agreeMeActivityConfig.setLastUniqueId(this.mContext.getUniqueId().getId());
                }
                agreeMeActivityConfig.setAgreeNumber(this.U);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, agreeMeActivityConfig));
                qe5.p0().h();
                qe5.p0().f0(0);
                this.U = 0;
                X0(0);
                statisticItem.param("obj_type", 2);
            } else if (view2 == this.D) {
                int B = qe5.p0().B();
                StatisticItem param3 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_REPLY_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount());
                if (B > 0) {
                    i3 = 1;
                }
                TiebaStatic.log(param3.param("obj_type", i3).param("obj_param1", B));
                ReplyMeActivityConfig replyMeActivityConfig = new ReplyMeActivityConfig(getPageContext().getPageActivity());
                replyMeActivityConfig.setFrom(1);
                l9<T> l9Var3 = this.mContext;
                if (l9Var3 != 0 && l9Var3.getUniqueId() != null) {
                    replyMeActivityConfig.setLastUniqueId(this.mContext.getUniqueId().getId());
                }
                replyMeActivityConfig.setReplyNumber(B);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, replyMeActivityConfig));
                qe5.p0().o();
                qe5.p0().m0(0);
                d1(0);
            } else if (view2 == this.H) {
                int y2 = qe5.p0().y();
                StatisticItem param4 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_FANS_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount());
                if (y2 > 0) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                TiebaStatic.log(param4.param("obj_type", i2).param("obj_param1", y2));
                PersonRedTipManager.getInstance().updateRedTipState(2, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
                PersonListActivityConfig personListActivityConfig = new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0);
                l9<T> l9Var4 = this.mContext;
                if (l9Var4 != 0 && l9Var4.getUniqueId() != null) {
                    personListActivityConfig.setLastUniqueId(this.mContext.getUniqueId().getId());
                }
                personListActivityConfig.setFansNumber(y2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personListActivityConfig));
                qe5.p0().l();
                qe5.p0().j0(0);
                b1(0);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void r0() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048620, this) != null) || this.f == null) {
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
            sl8 sl8Var = this.Z;
            if (sl8Var != null) {
                this.f.removeHeaderView(sl8Var.f());
                this.a0 = false;
                return;
            }
            return;
        }
        long r2 = r95.p().r("key_im_open_notification_close_time", 0L);
        if (!this.a0) {
            if (r2 == 0 || System.currentTimeMillis() - r2 > 604800000) {
                if (this.Z == null) {
                    sl8 sl8Var2 = new sl8(this.mContext, true);
                    this.Z = sl8Var2;
                    sl8Var2.h(this.y0);
                }
                this.f.w(this.Z.f(), 0);
                this.a0 = true;
            }
        }
    }

    public void s1(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048623, this, imMessageCenterShowItemData) != null) || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.unfriend_del, TBAlertConfig.OperateBtnStyle.ALERT);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.unfriend_cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        int i2 = R.string.obfuscated_res_0x7f0f1472;
        if (String.valueOf(9).equals(imMessageCenterShowItemData.getOwnerName())) {
            i2 = R.string.obfuscated_res_0x7f0f1473;
        }
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(TbadkCoreApplication.getInst().getCurrentActivity());
        this.h0 = tBAlertBuilder;
        tBAlertBuilder.w(R.string.obfuscated_res_0x7f0f1687);
        tBAlertBuilder.m(i2);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        this.g0 = tBAlertBuilder.z();
        aVar2.a(new d(this));
        aVar.a(new e(this, imMessageCenterShowItemData));
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            s0();
            if (this.M == null) {
                this.M = c98.l().o(getPageContext().getPageActivity());
            }
            this.M.show();
            this.M.b(0);
        }
    }

    public final void y0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, view2) == null) {
            this.n = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906cb);
            ShutDownValidateTipView shutDownValidateTipView = (ShutDownValidateTipView) view2.findViewById(R.id.obfuscated_res_0x7f092900);
            this.i = shutDownValidateTipView;
            shutDownValidateTipView.setVisibility(8);
            this.i.setShutDownClickListener(new z(this));
            this.g = (NavigationBarShadowView) view2.findViewById(R.id.obfuscated_res_0x7f091891);
            BdListView bdListView = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f0906cc);
            this.f = bdListView;
            bdListView.setDividerHeight(0);
            MessageAggregationListAdapter messageAggregationListAdapter = new MessageAggregationListAdapter(this.a.getPageContext().getPageActivity());
            this.h = messageAggregationListAdapter;
            messageAggregationListAdapter.b0(this.a.getPageContext());
            this.h.Y(this);
            this.h.X(this);
            this.f.setAdapter((ListAdapter) this.h);
            this.f.setOnItemClickListener(this.z0);
            this.f.setOnItemLongClickListener(this.A0);
            this.f.setOnScrollListener(this.s0);
            View inflate = View.inflate(this.mContext.getPageActivity(), R.layout.obfuscated_res_0x7f0d060d, null);
            this.u = inflate;
            this.v = inflate.findViewById(R.id.obfuscated_res_0x7f0902dc);
            this.w = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f0902db);
            this.x = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f0902df);
            this.y = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f0902dd);
            this.z = this.u.findViewById(R.id.obfuscated_res_0x7f090165);
            this.A = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f090164);
            this.B = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090169);
            this.C = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f090166);
            this.D = this.u.findViewById(R.id.obfuscated_res_0x7f091e8a);
            this.E = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f091e89);
            this.F = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f091e8d);
            this.G = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f091e8b);
            this.H = this.u.findViewById(R.id.obfuscated_res_0x7f090ace);
            this.I = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f090acd);
            this.J = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090ad2);
            this.K = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f090acf);
            this.L = this.u.findViewById(R.id.obfuscated_res_0x7f09211b);
            RelativeLayout relativeLayout = (RelativeLayout) this.u.findViewById(R.id.obfuscated_res_0x7f091160);
            this.N = relativeLayout;
            relativeLayout.setOnClickListener(this.B0);
            this.O = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f09115c);
            this.P = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f09115f);
            this.R = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f09115e);
            j1(r95.p().l("key_question_msg_no_remind", false));
            this.Q = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f09115b);
            MessageRedDotView messageRedDotView = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f09115d);
            this.S = messageRedDotView;
            messageRedDotView.setThreeDotMode(2);
            Z0(r95.p().q(r95.t("msg_tab_entrance_invitation_answer_unread_num"), 0));
            k1(r95.p().l(r95.t("msg_tab_entrance_invitation_answer"), false));
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
            r0();
            this.d = (BdSwipeRefreshLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e8c);
            if (this.e == null) {
                ba5 ba5Var = new ba5(this.a.getPageContext());
                this.e = ba5Var;
                ba5Var.f(this.t0);
            }
            this.e.a0(getPageContext().getUniqueId());
            this.d.setProgressView(this.e);
            this.t = new View(this.a.getFragmentActivity());
            this.t.setLayoutParams(new AbsListView.LayoutParams(-1, xi.g(this.a.getFragmentActivity(), R.dimen.obfuscated_res_0x7f07036f)));
            this.f.addFooterView(this.t);
        }
    }
}
