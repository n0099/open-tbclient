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
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.model.IMUserListHttpResponseMsg;
import com.baidu.tieba.im.model.IMUserListModel;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.IMOfficialMaskModel;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.imMessageCenter.mention.ChatAggregationFragment;
import com.baidu.tieba.imMessageCenter.recforum.model.MsgRecForumHttpResMessage;
import com.baidu.tieba.imMessageCenter.recforum.model.MsgRecForumNetMessage;
import com.baidu.tieba.imMessageCenter.recforum.model.MsgRecForumSocketResMessage;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.sg7;
import com.baidu.tieba.uv4;
import com.baidu.tieba.zy4;
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
public class xf7 extends p9<ChatAggregationFragment> implements zy4.g, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public TextView B;
    public MessageRedDotView C;
    public View D;
    public ImageView E;
    public TextView F;
    public MessageRedDotView G;
    public View H;
    public ImageView I;
    public TextView J;
    public MessageRedDotView K;
    public View L;
    public mv4 M;
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
    public sg7 X;
    public boolean Y;
    public boolean Z;
    public final ChatAggregationFragment a;
    public boolean a0;
    public ImMessageCenterModel b;
    public IMOfficialMaskModel b0;
    public ImMessageCenterShowItemData c;
    public IMUserListModel c0;
    public BdSwipeRefreshLayout d;
    public AbsListView.OnScrollListener d0;
    public az4 e;
    public final zy4.g e0;
    public BdListView f;
    public CustomMessageListener f0;
    public NavigationBarShadowView g;
    public qb g0;
    public MessageAggregationListAdapter h;
    public CustomMessageListener h0;
    public ShutDownValidateTipView i;
    public sg7.b i0;
    public sv4 j;
    public final AdapterView.OnItemClickListener j0;
    public uv4.e k;
    public NoDataView l;
    public boolean m;
    public RelativeLayout n;
    public View o;
    public boolean p;
    public boolean q;
    public final AdapterView.OnItemLongClickListener q0;
    public boolean r;
    public View.OnClickListener r0;
    public int s;
    public final CustomMessageListener s0;
    public View t;
    public qa7 t0;
    public View u;
    public final CustomMessageListener u0;
    public View v;
    public final ra7 v0;
    public ImageView w;
    public final CustomMessageListener w0;
    public TextView x;
    public final CustomMessageListener x0;
    public MessageRedDotView y;
    public final CustomMessageListener y0;
    public View z;
    public HttpMessageListener z0;

    @Override // com.baidu.tieba.zy4.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        public a(xf7 xf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf7Var;
        }

        public final void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imMessageCenterShowItemData) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_ITEM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", "1").param("obj_param1", imMessageCenterShowItemData.getUnReadCount()).param(TiebaStatic.Params.FRIEND_UID, imMessageCenterShowItemData.getFriendId()));
                if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                    l35.h0().b0(l35.h0().w() - imMessageCenterShowItemData.getUnReadCount());
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
                if (!hf7.b(this.a.a.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                    return;
                }
                TiebaStatic.eventStat(this.a.a.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.a.a.getPageContext().getPageActivity(), xg.g(item.getFriendId(), 0L), item.getFriendName(), 0L, "msg_lstb")));
            } else if (ownerName.equals("5")) {
                TiebaStatic.log("c12931");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialBarFeedActivityConfig(this.a.a.getPageContext().getPageActivity())));
            } else if (ownerName.equals("8")) {
                if (!hf7.a(this.a.a.getPageContext().getOrignalPage(), 2002006)) {
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
            if (!TextUtils.isEmpty(item.getFriendName()) && this.a.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f1451).equals(item.getFriendName())) {
                TiebaStatic.log(new StatisticItem("c14446").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        public b(xf7 xf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf7Var;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                xf7 xf7Var = this.a;
                xf7Var.c = xf7Var.h.getItem(i);
                if (this.a.c != null && this.a.c.getDataType() == 2) {
                    return true;
                }
                xf7 xf7Var2 = this.a;
                if (!xf7Var2.l0(xf7Var2.c)) {
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
        public final /* synthetic */ xf7 a;

        public c(xf7 xf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                py4.k().w(py4.o("msg_tab_entrance_invitation_answer_unread_num"), 0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2008024));
                if (this.a.S.getVisibility() == 0) {
                    if (py4.k().h("key_question_msg_no_remind", false)) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                } else {
                    i = 0;
                }
                new StatisticItem(CommonStatisticKey.KEY_QUESTION_ENTRANCE_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_type", i).eventStat();
                this.a.t0(0);
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.a.getContext(), this.a.a.getString(R.string.obfuscated_res_0x7f0f0981), TbConfig.QUESTION_THREAD_LIST, true);
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
        public final /* synthetic */ AlertDialog a;

        public d(xf7 xf7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
                alertDialog.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ ImMessageCenterShowItemData b;
        public final /* synthetic */ xf7 c;

        public e(xf7 xf7Var, AlertDialog alertDialog, ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var, alertDialog, imMessageCenterShowItemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xf7Var;
            this.a = alertDialog;
            this.b = imMessageCenterShowItemData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                StatisticItem statisticItem = new StatisticItem("c14670");
                if (if7.a(this.b)) {
                    i = 1;
                } else {
                    i = 2;
                }
                statisticItem.param("obj_type", i);
                TiebaStatic.log(statisticItem);
                this.c.b.asyncDeleteItem(this.b, this.c.v0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements uv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ImMessageCenterShowItemData b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ xf7 g;

        public f(xf7 xf7Var, String str, ImMessageCenterShowItemData imMessageCenterShowItemData, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var, str, imMessageCenterShowItemData, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = xf7Var;
            this.a = str;
            this.b = imMessageCenterShowItemData;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
        }

        @Override // com.baidu.tieba.uv4.e
        public void n0(uv4 uv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, uv4Var, i, view2) == null) {
                if (this.g.j != null && this.g.j.isShowing() && this.g.a != null) {
                    this.g.j.dismiss();
                }
                String charSequence = ((EMTextView) view2).getText().toString();
                int i2 = 2;
                if (this.a.equals(charSequence)) {
                    TiebaStatic.log("c12933");
                    StatisticItem statisticItem = new StatisticItem("c14665");
                    if (if7.a(this.b)) {
                        i2 = 1;
                    }
                    statisticItem.param("obj_type", i2);
                    TiebaStatic.log(statisticItem);
                    this.g.M0(this.b);
                } else if (this.c.equals(charSequence)) {
                    StatisticItem statisticItem2 = new StatisticItem("c14664");
                    statisticItem2.param("obj_type", 1);
                    TiebaStatic.log(statisticItem2);
                    xe7.c(this.b.getFriendId(), true);
                } else if (this.d.equals(charSequence)) {
                    StatisticItem statisticItem3 = new StatisticItem("c14664");
                    statisticItem3.param("obj_type", 2);
                    TiebaStatic.log(statisticItem3);
                    xe7.c(this.b.getFriendId(), false);
                } else if (this.e.equals(charSequence)) {
                    if (this.g.b0 != null) {
                        StatisticItem statisticItem4 = new StatisticItem("c14669");
                        statisticItem4.param("obj_type", 1);
                        TiebaStatic.log(statisticItem4);
                        this.g.b0.z(true, this.b.getFriendId());
                    }
                } else if (this.f.equals(charSequence) && this.g.b0 != null) {
                    StatisticItem statisticItem5 = new StatisticItem("c14669");
                    statisticItem5.param("obj_type", 2);
                    TiebaStatic.log(statisticItem5);
                    this.g.b0.z(false, this.b.getFriendId());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(xf7 xf7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var, Integer.valueOf(i)};
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
            this.a = xf7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() != 2016002) {
                if (customResponsedMessage.getCmd() != 2016004) {
                    if (customResponsedMessage.getCmd() != 2016007) {
                        if (customResponsedMessage.getCmd() == 2016001) {
                            this.a.b.setData(null, this.a.t0);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            if (this.a.h != null) {
                                this.a.h.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011 && this.a.h != null) {
                            this.a.h.notifyDataSetChanged();
                            return;
                        } else {
                            return;
                        }
                    }
                    this.a.p0(customResponsedMessage);
                    this.a.H0(false);
                    this.a.B0();
                    return;
                }
                this.a.m0(customResponsedMessage);
                return;
            }
            this.a.n0(customResponsedMessage);
        }
    }

    /* loaded from: classes6.dex */
    public class h implements qa7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        public h(xf7 xf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf7Var;
        }

        @Override // com.baidu.tieba.qa7
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        public i(xf7 xf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf7Var;
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
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(xf7 xf7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var, Integer.valueOf(i)};
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
            this.a = xf7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001120) {
                return;
            }
            this.a.o0(customResponsedMessage);
        }
    }

    /* loaded from: classes6.dex */
    public class k implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        public k(xf7 xf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf7Var;
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
    public class l implements ra7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        public l(xf7 xf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf7Var;
        }

        @Override // com.baidu.tieba.ra7
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.T();
            }
        }

        @Override // com.baidu.tieba.ra7
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.T();
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f04c9, false);
                this.a.d0();
            }
        }

        @Override // com.baidu.tieba.ra7
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.O0();
            }
        }

        @Override // com.baidu.tieba.ra7
        public void onProgressUpdate(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) && this.a.M != null) {
                this.a.M.b(i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(xf7 xf7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var, Integer.valueOf(i)};
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
            this.a = xf7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                this.a.f0((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(xf7 xf7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var, Integer.valueOf(i)};
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
            this.a = xf7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2921727 && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.E0(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(xf7 xf7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var, Integer.valueOf(i)};
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
            this.a = xf7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2921726) {
                this.a.F0(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(xf7 xf7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var, Integer.valueOf(i)};
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
            this.a = xf7Var;
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
                this.a.d0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements zy4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        public q(xf7 xf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf7Var;
        }

        @Override // com.baidu.tieba.zy4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.H0(true);
                    this.a.q0();
                } else if (this.a.d != null) {
                    this.a.d.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(xf7 xf7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var, Integer.valueOf(i)};
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
            this.a = xf7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && !this.a.a0) {
                this.a.D0();
                this.a.d0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(xf7 xf7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = xf7Var;
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
                    if (!this.a.W && this.a.a != null && responsedMessage.getError() != -100000303) {
                        this.a.a.showToast(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0c81));
                        this.a.W = true;
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
                this.a.J0(list);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(xf7 xf7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var, Integer.valueOf(i)};
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
            this.a = xf7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921691) {
                this.a.b.queryMarkTopStatus((String) customResponsedMessage.getData());
                this.a.b.sortList();
                this.a.h.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        public u(xf7 xf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                py4.k().u("is_shut_down_validate", true);
                this.a.K0(false);
                this.a.L0(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements sg7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xf7 a;

        public v(xf7 xf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xf7Var;
        }

        @Override // com.baidu.tieba.sg7.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.X != null) {
                this.a.f.removeHeaderView(this.a.X.e());
                this.a.Y = false;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xf7(ChatAggregationFragment chatAggregationFragment) {
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
        this.Y = false;
        this.Z = false;
        this.a0 = false;
        this.d0 = new k(this);
        this.e0 = new q(this);
        this.f0 = new r(this, 2001371);
        this.g0 = new s(this, CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST, 309712);
        this.h0 = new t(this, 2921691);
        this.i0 = new v(this);
        this.j0 = new a(this);
        this.q0 = new b(this);
        this.r0 = new c(this);
        this.s0 = new g(this, 0);
        this.t0 = new h(this);
        this.u0 = new j(this, 2001120);
        this.v0 = new l(this);
        this.w0 = new m(this, 2001120);
        this.x0 = new n(this, 2921727);
        this.y0 = new o(this, 2921726);
        this.z0 = new p(this, CmdConfigHttp.CMD_GET_USER_LIST);
        this.a = chatAggregationFragment;
    }

    public final boolean l0(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, imMessageCenterShowItemData)) == null) {
            String string = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f04d4);
            String string2 = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f1496);
            String string3 = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0383);
            String string4 = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f08e1);
            String string5 = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f08e2);
            if (imMessageCenterShowItemData.getMarkTopIndex() > 0) {
                str = string3;
            } else {
                str = string2;
            }
            if (imMessageCenterShowItemData.getGroupSetting() != null) {
                if (imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
                    str3 = string4;
                } else {
                    str3 = string5;
                }
                str2 = str3;
            } else {
                str2 = string4;
            }
            f fVar = new f(this, string, imMessageCenterShowItemData, string2, string3, string4, string5);
            ArrayList arrayList = new ArrayList(5);
            if (if7.a(imMessageCenterShowItemData)) {
                arrayList.add(str);
                arrayList.add(string);
            } else if (if7.b(imMessageCenterShowItemData)) {
                arrayList.add(str2);
                arrayList.add(string);
            } else {
                return false;
            }
            this.k = fVar;
            this.j = new sv4(this.a.getPageContext());
            this.j.i(null, (String[]) arrayList.toArray(new String[arrayList.size()]), this.k);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void F0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.N.setVisibility(0);
                this.L.setVisibility(8);
            } else {
                this.N.setVisibility(8);
                this.L.setVisibility(0);
            }
            P0();
        }
    }

    public void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.r = z;
        }
    }

    public void H0(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && this.d != null) {
            if (z && (bdListView = this.f) != null && bdListView.getFirstVisiblePosition() != 0) {
                this.f.setSelection(0);
            }
            this.d.setRefreshing(z);
        }
    }

    public void I0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.q = z;
        }
    }

    public void K0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.m = z;
        }
    }

    public void N0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && z) {
            A0();
            P0();
        }
    }

    public void Y(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) && bundle != null) {
            this.s = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.s);
        }
    }

    public void h0(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, intent) == null) && intent != null) {
            int intExtra = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            this.s = intExtra;
            if (intExtra == -1) {
                return;
            }
            I0(true);
            i0();
        }
    }

    public final void o0(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, responsedMessage) != null) || responsedMessage == null) {
            return;
        }
        if (!(responsedMessage instanceof NewsNotifyMessage)) {
            BdLog.e("transform error");
        } else {
            u0();
        }
    }

    public final void p0(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            return;
        }
        ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
        List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
        if (responsedMemoryListMessage.getType() == 1 && (imMessageCenterModel = this.b) != null) {
            imMessageCenterModel.setData(data, this.t0);
        }
    }

    public void A0() {
        IMUserListModel iMUserListModel;
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (iMUserListModel = this.c0) != null && (imMessageCenterModel = this.b) != null) {
            iMUserListModel.request(true, imMessageCenterModel.getUids());
        }
    }

    public void B0() {
        IMUserListModel iMUserListModel;
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (iMUserListModel = this.c0) != null && (imMessageCenterModel = this.b) != null && this.V) {
            iMUserListModel.request(false, imMessageCenterModel.getUids());
            this.V = false;
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.N.getVisibility() == 0) {
            new StatisticItem(CommonStatisticKey.KEY_QUESTION_ENTRANCE_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
        }
    }

    public final void T() {
        mv4 mv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (mv4Var = this.M) != null && mv4Var.isShowing()) {
            this.M.dismiss();
            this.M = null;
        }
    }

    public final boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return TbadkCoreApplication.isLogin();
        }
        return invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public void a0() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (messageAggregationListAdapter = this.h) != null) {
            messageAggregationListAdapter.notifyDataSetChanged();
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.a.getPageContext().getPageActivity();
        }
        return (Activity) invokeV.objValue;
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.f.F();
            this.p = W();
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void u0() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048621, this) != null) || (messageAggregationListAdapter = this.h) == null) {
            return;
        }
        messageAggregationListAdapter.notifyDataSetChanged();
    }

    public void x0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (bdSwipeRefreshLayout = this.d) != null && !bdSwipeRefreshLayout.r()) {
            H0(true);
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.registerListener(2016004, this.s0);
            this.a.registerListener(2016001, this.s0);
            this.a.registerListener(2016010, this.s0);
            this.a.registerListener(2016007, this.s0);
            this.a.registerListener(2016011, this.s0);
            this.a.registerListener(2016002, this.s0);
            this.a.registerListener(this.u0);
            this.a.registerListener(this.w0);
            this.a.registerListener(this.f0);
            this.a.registerListener(this.h0);
            this.a.registerListener(this.z0);
            this.a.registerListener(this.y0);
            this.a.registerListener(this.x0);
        }
    }

    public void S() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || this.f == null) {
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
            sg7 sg7Var = this.X;
            if (sg7Var != null) {
                this.f.removeHeaderView(sg7Var.e());
                this.Y = false;
                return;
            }
            return;
        }
        long m2 = py4.k().m("key_im_open_notification_close_time", 0L);
        if (!this.Y) {
            if (m2 == 0 || System.currentTimeMillis() - m2 > 604800000) {
                if (this.X == null) {
                    sg7 sg7Var2 = new sg7(this.mContext);
                    this.X = sg7Var2;
                    sg7Var2.g(this.i0);
                }
                this.f.x(this.X.e(), 0);
                this.Y = true;
            }
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.s0);
            MessageManager.getInstance().unRegisterListener(this.u0);
            MessageManager.getInstance().unRegisterListener(this.w0);
            MessageManager.getInstance().unRegisterListener(this.y0);
            MessageManager.getInstance().unRegisterListener(this.x0);
            if (this.a0) {
                MessageManager.getInstance().unRegisterListener(this.g0);
                MessageManager.getInstance().unRegisterTask(309712);
                MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST);
            }
            MessageManager.getInstance().unRegisterListener(this.f0);
            MessageManager.getInstance().unRegisterListener(this.h0);
            MessageManager.getInstance().unRegisterListener(this.z0);
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            vf5 vf5Var = new vf5(309712);
            vf5Var.setResponsedClass(MsgRecForumSocketResMessage.class);
            vf5Var.g(true);
            vf5Var.h(false);
            vf5Var.f(SocketMessageTask.DupLicateMode.NONE);
            MessageManager.getInstance().registerTask(vf5Var);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST, to8.a("c/f/forum/getMsgRecForumlist", 309712));
            tbHttpMessageTask.setResponsedClass(MsgRecForumHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.a.registerListener(this.g0);
            this.a0 = true;
        }
    }

    public View e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            this.o = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d01d4, (ViewGroup) null, false);
            U();
            V(this.o);
            TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
            if (!this.a0) {
                D0();
            }
            C0();
            j0();
            return this.o;
        }
        return (View) invokeV.objValue;
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            MessageAggregationListAdapter messageAggregationListAdapter = this.h;
            if (messageAggregationListAdapter != null && messageAggregationListAdapter.getCount() == 0) {
                I0(true);
            }
            if (this.r || this.q) {
                this.r = false;
                this.q = false;
                q0();
            }
            boolean W = W();
            if (this.p != W) {
                this.p = W;
            }
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.d(this.a.getPageContext());
            }
            S();
        }
    }

    public void E0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f08061e, R.color.CAM_X1111, SvgManager.SvgResourceStateType.NORMAL);
                int g2 = yi.g(this.a.getContext(), R.dimen.tbds34);
                pureDrawable.setBounds(new Rect(0, 0, g2, g2));
                this.R.setCompoundDrawables(null, null, pureDrawable, null);
                this.R.setVisibility(0);
                return;
            }
            this.R.setVisibility(8);
        }
    }

    public final void t0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            if (i2 > 0) {
                if (py4.k().h("key_question_msg_no_remind", false)) {
                    i2 = 0;
                }
                this.S.setThreeDotMode(2);
                this.S.f(i2);
                this.S.setVisibility(0);
                this.Q.setText(R.string.obfuscated_res_0x7f0f06f1);
                return;
            }
            this.S.setVisibility(8);
            this.Q.setText(R.string.obfuscated_res_0x7f0f06f0);
        }
    }

    public final void J0(List<RecommendForumInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, list) == null) && list != null && list.size() > 0) {
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
                this.h.r(arrayList);
            }
        }
    }

    public void L0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                if (X() && this.i.getVisibility() != 0) {
                    this.i.setVisibility(0);
                }
            } else if (this.i.getVisibility() != 8) {
                this.i.setVisibility(8);
            }
        }
    }

    public void f0(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, newsNotifyMessage) != null) || newsNotifyMessage == null) {
            return;
        }
        this.T = newsNotifyMessage.getMsgAtme();
        this.U = newsNotifyMessage.getMsgAgree();
        s0(this.T);
        r0(this.U);
        v0(newsNotifyMessage.getMsgFans());
        y0(newsNotifyMessage.getMsgReplyme());
        t0(newsNotifyMessage.getMsgInvitation());
    }

    public void g0(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048606, this, z) == null) && z && (bdListView = this.f) != null && bdListView.getWrappedAdapter() != null && this.f.getWrappedAdapter().getCount() <= 0) {
            ah.a().post(new i(this));
        }
    }

    public final void m0(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof MemoryChangedMessage)) {
            return;
        }
        MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
        ImMessageCenterPojo data = memoryChangedMessage.getData();
        if (memoryChangedMessage.getType() == 1) {
            ImMessageCenterModel imMessageCenterModel2 = this.b;
            if (imMessageCenterModel2 != null) {
                imMessageCenterModel2.insertOrUpdate(data, this.t0);
            }
        } else if (memoryChangedMessage.getType() == 2 && (imMessageCenterModel = this.b) != null) {
            imMessageCenterModel.remove(data, this.t0);
        }
    }

    public final void n0(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            if (i2 > 0) {
                if (n35.d().f() == 0) {
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

    public final void s0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            if (i2 > 0) {
                if (n35.d().f() == 0) {
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

    public final void v0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            if (i2 > 0) {
                if (n35.d().f() == 0) {
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

    public final void y0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            if (i2 > 0) {
                if (n35.d().f() == 0) {
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

    public void M0(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, imMessageCenterShowItemData) != null) || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1505, TBAlertConfig.OperateBtnStyle.ALERT);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1504, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(TbadkCoreApplication.getInst().getCurrentActivity());
        tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f1483);
        tBAlertBuilder.k(R.string.obfuscated_res_0x7f0f127f);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        AlertDialog w = tBAlertBuilder.w();
        aVar2.a(new d(this, w));
        aVar.a(new e(this, w, imMessageCenterShowItemData));
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            T();
            if (this.M == null) {
                this.M = tb7.m().p(getPageContext().getPageActivity());
            }
            this.M.show();
            this.M.b(0);
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.b = new ImMessageCenterModel();
            K0(!py4.k().h("is_shut_down_validate", false));
            this.b0 = new IMOfficialMaskModel();
            this.c0 = new IMUserListModel(this.a.getPageContext(), this.a.getUniqueId());
        }
    }

    public final void V(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view2) == null) {
            this.n = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09061e);
            ShutDownValidateTipView shutDownValidateTipView = (ShutDownValidateTipView) view2.findViewById(R.id.obfuscated_res_0x7f092617);
            this.i = shutDownValidateTipView;
            shutDownValidateTipView.setVisibility(8);
            this.i.setShutDownClickListener(new u(this));
            this.g = (NavigationBarShadowView) view2.findViewById(R.id.obfuscated_res_0x7f091679);
            BdListView bdListView = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f09061f);
            this.f = bdListView;
            bdListView.setDividerHeight(0);
            MessageAggregationListAdapter messageAggregationListAdapter = new MessageAggregationListAdapter(this.a.getPageContext().getPageActivity());
            this.h = messageAggregationListAdapter;
            messageAggregationListAdapter.R(this.a.getPageContext());
            this.h.O(this);
            this.f.setAdapter((ListAdapter) this.h);
            this.f.setOnItemClickListener(this.j0);
            this.f.setOnItemLongClickListener(this.q0);
            this.f.setOnScrollListener(this.d0);
            View inflate = View.inflate(this.mContext.getPageActivity(), R.layout.obfuscated_res_0x7f0d05a2, null);
            this.u = inflate;
            this.v = inflate.findViewById(R.id.obfuscated_res_0x7f0902de);
            this.w = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f0902dd);
            this.x = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f0902e1);
            this.y = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f0902df);
            this.z = this.u.findViewById(R.id.obfuscated_res_0x7f09015f);
            this.A = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f09015e);
            this.B = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090163);
            this.C = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f090160);
            this.D = this.u.findViewById(R.id.obfuscated_res_0x7f091c41);
            this.E = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f091c40);
            this.F = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f091c44);
            this.G = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f091c42);
            this.H = this.u.findViewById(R.id.obfuscated_res_0x7f0909b3);
            this.I = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f0909b2);
            this.J = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f0909b7);
            this.K = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f0909b4);
            this.L = this.u.findViewById(R.id.obfuscated_res_0x7f091eb2);
            RelativeLayout relativeLayout = (RelativeLayout) this.u.findViewById(R.id.obfuscated_res_0x7f090fb5);
            this.N = relativeLayout;
            relativeLayout.setOnClickListener(this.r0);
            this.O = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f090fb1);
            this.P = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090fb4);
            this.R = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090fb3);
            E0(py4.k().h("key_question_msg_no_remind", false));
            this.Q = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090fb0);
            MessageRedDotView messageRedDotView = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f090fb2);
            this.S = messageRedDotView;
            messageRedDotView.setThreeDotMode(2);
            t0(py4.k().l(py4.o("msg_tab_entrance_invitation_answer_unread_num"), 0));
            F0(py4.k().h(py4.o("msg_tab_entrance_invitation_answer"), false));
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
            S();
            this.d = (BdSwipeRefreshLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c43);
            if (this.e == null) {
                az4 az4Var = new az4(this.a.getPageContext());
                this.e = az4Var;
                az4Var.f(this.e0);
            }
            this.e.b0(getPageContext().getUniqueId());
            this.d.setProgressView(this.e);
            this.t = new View(this.a.getFragmentActivity());
            this.t.setLayoutParams(new AbsListView.LayoutParams(-1, yi.g(this.a.getFragmentActivity(), R.dimen.obfuscated_res_0x7f07024d)));
            this.f.addFooterView(this.t);
        }
    }

    public boolean b0(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048601, this, tbPageContext, i2)) == null) {
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
            az4 az4Var = this.e;
            if (az4Var != null) {
                az4Var.H(i2);
            }
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.F, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.J, (int) R.color.CAM_X0105);
            WebPManager.setMaskDrawable(this.w, R.drawable.obfuscated_res_0x7f080808, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setMaskDrawable(this.A, R.drawable.obfuscated_res_0x7f08080a, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setMaskDrawable(this.E, R.drawable.obfuscated_res_0x7f08080b, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setMaskDrawable(this.I, R.drawable.obfuscated_res_0x7f080809, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setBackgroundColor(this.L, R.color.CAM_X0203);
            pw4 d2 = pw4.d(this.N);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0206);
            WebPManager.setMaskDrawable(this.O, R.drawable.obfuscated_res_0x7f08080c, WebPManager.ResourceStateType.NORMAL);
            pw4 d3 = pw4.d(this.P);
            d3.z(R.dimen.T_X07);
            d3.A(R.string.F_X02);
            d3.v(R.color.CAM_X0105);
            pw4 d4 = pw4.d(this.Q);
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
            sg7 sg7Var = this.X;
            if (sg7Var != null) {
                sg7Var.f(i2);
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void d0() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (bdListView = this.f) != null && this.b != null) {
            bdListView.A(0L);
            if (this.b.getData() != null && this.b.getData().size() > 0) {
                this.h.r(this.b.getData());
                if (!this.Z) {
                    this.Z = true;
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
            if (!this.Z) {
                this.Z = true;
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.IM_TAB_SHOW_KEY);
                statisticItem2.param("obj_param1", "1").param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, view2) == null) {
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
                l35.h0().j();
                l35.h0().Z(0);
                this.T = 0;
                s0(0);
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
                l35.h0().h();
                l35.h0().Y(0);
                this.U = 0;
                r0(0);
                statisticItem.param("obj_type", 2);
            } else if (view2 == this.D) {
                int A = l35.h0().A();
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
                l35.h0().o();
                l35.h0().f0(0);
                y0(0);
            } else if (view2 == this.H) {
                int x = l35.h0().x();
                StatisticItem param4 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_FANS_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount());
                if (x > 0) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                TiebaStatic.log(param4.param("obj_type", i2).param("obj_param1", x));
                PersonRedTipManager.getInstance().updateRedTipState(2, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
                PersonListActivityConfig personListActivityConfig = new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0);
                r9<T> r9Var4 = this.mContext;
                if (r9Var4 != 0 && r9Var4.getUniqueId() != null) {
                    personListActivityConfig.setLastUniqueId(this.mContext.getUniqueId().getId());
                }
                personListActivityConfig.setFansNumber(x);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personListActivityConfig));
                l35.h0().l();
                l35.h0().c0(0);
                v0(0);
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
