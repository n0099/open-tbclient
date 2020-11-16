package com.baidu.tieba.imMessageCenter.mention;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationManagerCompat;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarFeedActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMeActivityConfig;
import com.baidu.tbadk.core.atomData.UpdatesActivityConfig;
import com.baidu.tbadk.core.atomData.ValidateActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.imMessageCenter.mention.base.f;
import java.util.List;
/* loaded from: classes21.dex */
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements View.OnClickListener, f.c {
    private View bDS;
    private int eSB;
    private final CustomMessageListener fed;
    private boolean fsB;
    private BdSwipeRefreshLayout glp;
    private final f.c gpT;
    private final CustomMessageListener iJC;
    private boolean isNeedRefresh;
    private com.baidu.tieba.im.chat.a.a jZB;
    private final com.baidu.tieba.im.chat.a.b jZC;
    private com.baidu.tbadk.core.dialog.d jZy;
    private final CustomMessageListener jZz;
    private final ChatAggregationFragment kuJ;
    private ImMessageCenterModel kuK;
    private ImMessageCenterShowItemData kuL;
    private BdListView kuM;
    private NavigationBarShadowView kuN;
    private MessageAggregationListAdapter kuO;
    private ShutDownValidateTipView kuP;
    private com.baidu.tbadk.core.dialog.i kuQ;
    private k.c kuR;
    private boolean kuS;
    private boolean kuT;
    private int kuU;
    private View kuV;
    private ImageView kuW;
    private TextView kuX;
    private MessageRedDotView kuY;
    private View kuZ;
    private ImageView kva;
    private TextView kvb;
    private MessageRedDotView kvc;
    private View kvd;
    private ImageView kve;
    private TextView kvf;
    private MessageRedDotView kvg;
    private View kvh;
    private ImageView kvi;
    private TextView kvj;
    private MessageRedDotView kvk;
    private int kvl;
    private int kvm;
    private com.baidu.tieba.imMessageCenter.mention.base.f kvn;
    private boolean kvo;
    private f.a kvp;
    private final AdapterView.OnItemLongClickListener kvq;
    private View mHeaderView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) com.baidu.adp.base.i.I(chatAggregationFragment.getPageContext().getPageActivity()));
        this.kuK = null;
        this.kuL = null;
        this.kuM = null;
        this.kuO = null;
        this.kuQ = null;
        this.kuS = true;
        this.fsB = false;
        this.isNeedRefresh = false;
        this.kuT = true;
        this.kuU = 16;
        this.kvo = false;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.kuN.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.kuN.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.kuN.hide();
                }
            }
        };
        this.gpT = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (e.this.glp != null) {
                        e.this.glp.setRefreshing(false);
                        return;
                    }
                    return;
                }
                e.this.sB(true);
                e.this.oG(false);
            }
        };
        this.kvp = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (e.this.kvn != null) {
                    e.this.kuM.removeHeaderView(e.this.kvn.getView());
                    e.this.kvo = false;
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData CX = e.this.kuO.getItem(i);
                    TiebaStatic.eventStat(e.this.kuJ.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    ar arVar = new ar("c13720");
                    arVar.w("uid", TbadkApplication.getCurrentAccountId());
                    String ownerName = CX.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(CX);
                        arVar.ak("obj_type", 6);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kuJ.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.kuJ.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.kuJ.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(CX.getFriendId(), 0L), CX.getFriendName(), 0L, "msg_lstb")));
                        } else {
                            return;
                        }
                    } else if (CX.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kuJ.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(CX);
                            arVar.ak("obj_type", 7);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvE() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvE().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.kuJ.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (CX.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kuJ.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(CX);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvE() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvE().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.kuJ.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("5")) {
                        TiebaStatic.log("c12931");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarFeedActivityConfig(e.this.kuJ.getPageContext().getPageActivity())));
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kuJ.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.kuJ.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(CX.getFriendId(), 0L), CX.getFriendNameShow(), CX.getFriendPortrait(), 0, CX.getUserType())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ar("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.kuJ.getPageContext().getPageActivity())));
                        arVar.ak("obj_type", 6);
                        return;
                    } else {
                        e(CX);
                        arVar.ak("obj_type", 6);
                    }
                    if (!TextUtils.isEmpty(CX.getFriendName())) {
                        if ("贴吧热榜".equals(CX.getFriendName())) {
                            arVar.ak("obj_type", 8);
                        } else if ("贴吧荣誉墙".equals(CX.getFriendName())) {
                            arVar.ak("obj_type", 9);
                        } else if ("贴吧精选".equals(CX.getFriendName())) {
                            arVar.ak("obj_type", 10);
                        } else if ("贴吧活动".equals(CX.getFriendName())) {
                            arVar.ak("obj_type", 4);
                        } else if ("吧广播".equals(CX.getFriendName())) {
                            arVar.ak("obj_type", 5);
                        }
                    }
                    TiebaStatic.log(arVar);
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.cQB().Ma("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.cQB().Ma("group_intro_change");
                                com.baidu.tieba.im.db.d.cQB().Ma("group_name_change");
                                com.baidu.tieba.im.db.d.cQB().Ma("group_notice_change");
                                com.baidu.tieba.im.db.d.cQB().Ma("group_level_up");
                                com.baidu.tieba.im.db.d.cQB().Ma("dismiss_group");
                                com.baidu.tieba.im.db.d.cQB().Ma("kick_out");
                                com.baidu.tieba.im.db.d.cQB().Ma("group_activitys_change");
                            }
                        }
                        return null;
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
            }

            private void e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
                if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.bvi().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.bvi().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.kuJ.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.kvq = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.kuL = e.this.kuO.getItem(i);
                e.this.c(e.this.kuL);
                if (e.this.kuQ != null) {
                    TiebaStatic.log("c12932");
                    e.this.kuQ.PA();
                    if (e.this.kuJ != null && e.this.kuJ.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.kuJ.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.jZz = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2016002) {
                        e.this.c(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2016004) {
                        e.this.e(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2016007) {
                        e.this.d(customResponsedMessage);
                        e.this.sB(false);
                    } else if (customResponsedMessage.getCmd() == 2016001) {
                        e.this.kuK.setData(null, e.this.jZB);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.kuO != null) {
                            e.this.kuO.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.kuO != null) {
                        e.this.kuO.notifyDataSetChanged();
                    }
                }
            }
        };
        this.jZB = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cOU();
            }
        };
        this.fed = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.jZC = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cOT();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.jZy != null) {
                    e.this.jZy.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.GM();
                e.this.kuJ.showToast(R.string.delete_success, false);
                e.this.cOU();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.GM();
            }
        };
        this.iJC = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    e.this.b((NewsNotifyMessage) customResponsedMessage);
                }
            }
        };
        this.kuJ = chatAggregationFragment;
    }

    public void aq(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.kuU = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.kuU = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.kuU);
        }
    }

    public void cFg() {
        if (this.kuO != null) {
            this.kuO.notifyDataSetChanged();
        }
    }

    public void cDp() {
        MessageManager.getInstance().unRegisterListener(this.jZz);
        MessageManager.getInstance().unRegisterListener(this.fed);
    }

    public View bRW() {
        this.eSB = 3;
        this.rootView = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        cA(this.rootView);
        TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        coF();
        return this.rootView;
    }

    public Activity getActivity() {
        return this.kuJ.getPageContext().getPageActivity();
    }

    protected void coF() {
        this.kuM.startPullRefresh();
        this.fsB = isLogin();
        if (!this.fsB) {
            aj(this.fsB, true);
        }
    }

    private void registerListener() {
        this.kuJ.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.jZz);
        this.kuJ.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.jZz);
        this.kuJ.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.jZz);
        this.kuJ.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.jZz);
        this.kuJ.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.jZz);
        this.kuJ.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.jZz);
        this.kuJ.registerListener(this.fed);
        this.kuJ.registerListener(this.iJC);
    }

    public void Tc() {
        if (this.glp != null && !this.glp.isRefreshing()) {
            sB(true);
        }
    }

    public void sB(boolean z) {
        if (this.glp != null) {
            if (z && this.kuM != null && this.kuM.getFirstVisiblePosition() != 0) {
                this.kuM.setSelection(0);
            }
            this.glp.setRefreshing(z);
        }
    }

    public void sC(boolean z) {
        this.isNeedRefresh = z;
    }

    public void sD(boolean z) {
        this.kuT = z;
    }

    public void onPrimary() {
        if (this.kuO != null && this.kuO.getCount() == 0) {
            sC(true);
        }
        if (this.kuT || this.isNeedRefresh) {
            this.kuT = false;
            this.isNeedRefresh = false;
            oG(false);
        }
        boolean isLogin = isLogin();
        if (this.fsB != isLogin) {
            this.fsB = isLogin;
            onUserChanged(this.fsB);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kuJ.getPageContext());
        }
        cWh();
    }

    private void initData() {
        this.kuK = new ImMessageCenterModel();
        sF(com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void cA(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.kuP = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.kuP.setVisibility(8);
        this.kuP.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.sF(false);
                e.this.sE(false);
            }
        });
        this.kuN = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.kuM = (BdListView) view.findViewById(R.id.chat_list_content);
        this.kuM.setDividerHeight(0);
        this.kuO = new MessageAggregationListAdapter(this.kuJ.getPageContext().getPageActivity());
        this.kuO.a(this);
        this.kuM.setAdapter((ListAdapter) this.kuO);
        this.kuM.setOnItemClickListener(this.mItemClickListener);
        this.kuM.setOnItemLongClickListener(this.kvq);
        this.kuM.setOnScrollListener(this.mOnScrollListener);
        this.mHeaderView = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
        this.kuV = this.mHeaderView.findViewById(R.id.at_me_layout);
        this.kuW = (ImageView) this.mHeaderView.findViewById(R.id.at_me_icon);
        this.kuX = (TextView) this.mHeaderView.findViewById(R.id.at_me_text);
        this.kuY = (MessageRedDotView) this.mHeaderView.findViewById(R.id.at_me_new_message);
        this.kuZ = this.mHeaderView.findViewById(R.id.agree_me_layout);
        this.kva = (ImageView) this.mHeaderView.findViewById(R.id.agree_me_icon);
        this.kvb = (TextView) this.mHeaderView.findViewById(R.id.agree_me_text);
        this.kvc = (MessageRedDotView) this.mHeaderView.findViewById(R.id.agree_me_new_message);
        this.kvd = this.mHeaderView.findViewById(R.id.reply_me_layout);
        this.kve = (ImageView) this.mHeaderView.findViewById(R.id.reply_me_icon);
        this.kvf = (TextView) this.mHeaderView.findViewById(R.id.reply_me_text);
        this.kvg = (MessageRedDotView) this.mHeaderView.findViewById(R.id.reply_me_new_message);
        this.kvh = this.mHeaderView.findViewById(R.id.fans_layout);
        this.kvi = (ImageView) this.mHeaderView.findViewById(R.id.fans_icon);
        this.kvj = (TextView) this.mHeaderView.findViewById(R.id.fans_text);
        this.kvk = (MessageRedDotView) this.mHeaderView.findViewById(R.id.fans_new_message);
        this.kuY.setThreeDotMode(2);
        this.kvc.setThreeDotMode(2);
        this.kvg.setThreeDotMode(2);
        this.kvk.setThreeDotMode(2);
        this.kuY.setShadowEnabled(false);
        this.kvc.setShadowEnabled(false);
        this.kvg.setShadowEnabled(false);
        this.kuV.setOnClickListener(this);
        this.kuZ.setOnClickListener(this);
        this.kvd.setOnClickListener(this);
        this.kvh.setOnClickListener(this);
        this.kuM.addHeaderView(this.mHeaderView);
        cWh();
        this.glp = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kuJ.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gpT);
        }
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.glp.setProgressView(this.mPullView);
        this.bDS = new View(this.kuJ.getFragmentActivity());
        this.bDS.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.kuJ.getFragmentActivity(), R.dimen.ds150)));
        this.kuM.addFooterView(this.bDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cWh() {
        if (this.kuM != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
            ar arVar = new ar("c13616");
            arVar.ak("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(arVar);
            if (areNotificationsEnabled) {
                if (this.kvn != null) {
                    this.kuM.removeHeaderView(this.kvn.getView());
                    this.kvo = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bpu().getLong("key_im_open_notification_close_time", 0L);
            if (this.kvo) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kvn == null) {
                    this.kvn = new com.baidu.tieba.imMessageCenter.mention.base.f(this.mContext);
                    this.kvn.a(this.kvp);
                }
                this.kuM.addHeaderView(this.kvn.getView(), 0);
                this.kvo = true;
            }
        }
    }

    private boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kuJ.getPageContext(), i);
        }
        if (this.kuP != null) {
            this.kuP.onChangeSkinType(i);
        }
        if (this.kuO != null) {
            this.kuO.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        ap.setBackgroundColor(this.glp, R.color.CAM_X0205);
        ap.setViewTextColor(this.kuX, R.color.CAM_X0105);
        ap.setViewTextColor(this.kvb, R.color.CAM_X0105);
        ap.setViewTextColor(this.kvf, R.color.CAM_X0105);
        ap.setViewTextColor(this.kvj, R.color.CAM_X0105);
        ap.setImageResource(this.kuW, R.drawable.pic_information_at_me);
        ap.setImageResource(this.kva, R.drawable.pic_information_praise);
        ap.setImageResource(this.kve, R.drawable.pic_information_reply);
        ap.setImageResource(this.kvi, R.drawable.pic_information_fans);
        if (this.kuY != null) {
            this.kuY.onChangeSkinType();
        }
        if (this.kvc != null) {
            this.kvc.onChangeSkinType();
        }
        if (this.kvg != null) {
            this.kvg.onChangeSkinType();
        }
        if (this.kvk != null) {
            this.kvk.onChangeSkinType();
        }
        if (this.kvn != null) {
            this.kvn.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    protected void onUserChanged(boolean z) {
        aj(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.kuR = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.kuQ != null && e.this.kuQ.isShowing() && e.this.kuJ != null) {
                    e.this.kuQ.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.kuK.asyncDeleteItem(imMessageCenterShowItemData, e.this.jZC);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.kuJ.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.kuQ = new com.baidu.tbadk.core.dialog.i(this.kuJ.getPageContext());
        this.kuQ.a(null, new String[]{string}, this.kuR);
    }

    protected boolean oG(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.kuM.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void sE(boolean z) {
        if (z) {
            if (cWi() && this.kuP.getVisibility() != 0) {
                this.kuP.setVisibility(0);
            }
        } else if (this.kuP.getVisibility() != 8) {
            this.kuP.setVisibility(8);
        }
    }

    public void aj(boolean z, boolean z2) {
    }

    public boolean cWi() {
        return this.kuS;
    }

    public void sF(boolean z) {
        this.kuS = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.kuK != null) {
                    this.kuK.insertOrUpdate(data, this.jZB);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.kuK != null) {
                this.kuK.remove(data, this.jZB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.kuK != null) {
                this.kuK.setData(data, this.jZB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.kuU = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.kuU != -1) {
                sC(true);
                onPrimary();
            }
        }
    }

    public void sA(boolean z) {
        if (z && this.kuM != null && this.kuM.getWrappedAdapter() != null && this.kuM.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.kuM.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                cWj();
            }
        }
    }

    private void cWj() {
        if (this.kuO != null) {
            this.kuO.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOT() {
        GM();
        if (this.jZy == null) {
            this.jZy = com.baidu.tieba.im.db.e.cQC().fy(getPageContext().getPageActivity());
        }
        this.jZy.show();
        this.jZy.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GM() {
        if (this.jZy != null && this.jZy.isShowing()) {
            this.jZy.dismiss();
            this.jZy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOU() {
        if (this.kuM != null && this.kuK != null) {
            this.kuM.completePullRefreshPostDelayed(0L);
            if (this.kuK.getData() != null) {
                this.kuO.setData(this.kuK.getData());
            } else {
                aj(isLogin(), true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar arVar = new ar("c13720");
        arVar.w("uid", TbadkApplication.getCurrentAccountId());
        if (view == this.kuV) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvw();
            com.baidu.tbadk.coreExtra.messageCenter.b.bvi().setMsgAtme(0);
            this.kvl = 0;
            Ec(this.kvl);
            TiebaStatic.log("c12925");
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            arVar.ak("obj_type", 1);
        } else if (view == this.kuZ) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvx();
            com.baidu.tbadk.coreExtra.messageCenter.b.bvi().rg(0);
            this.kvm = 0;
            Ef(this.kvm);
            TiebaStatic.log("c12926");
            arVar.ak("obj_type", 2);
        } else if (view == this.kvd) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvv();
            com.baidu.tbadk.coreExtra.messageCenter.b.bvi().setMsgReplyme(0);
            Ed(0);
        } else if (view == this.kvh) {
            com.baidu.tieba.q.a.dBC().h(2, false, true);
            TiebaStatic.log(new ar("c12523").ak("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
            com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvy();
            com.baidu.tbadk.coreExtra.messageCenter.b.bvi().setMsgFans(0);
            Ee(0);
        }
        TiebaStatic.log(arVar);
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.kvl = newsNotifyMessage.getMsgAtme();
            this.kvm = newsNotifyMessage.getMsgAgree();
            Ec(this.kvl);
            Ef(this.kvm);
            Ee(newsNotifyMessage.getMsgFans());
            Ed(newsNotifyMessage.getMsgReplyme());
        }
    }

    private void Ec(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvO() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvQ()) {
                i = 0;
            }
            a(i, this.kuY);
            this.kuY.setThreeDotMode(2);
            this.kuY.refresh(i);
            this.kuY.setVisibility(0);
            return;
        }
        this.kuY.setVisibility(8);
    }

    private void Ed(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvO() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvS()) {
                i = 0;
            }
            a(i, this.kvg);
            this.kvg.setThreeDotMode(2);
            this.kvg.refresh(i);
            this.kvg.setVisibility(0);
            return;
        }
        this.kvg.setVisibility(8);
    }

    private void Ee(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvO() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvR()) {
                i = 0;
            }
            a(i, this.kvk);
            this.kvk.setThreeDotMode(2);
            this.kvk.refresh(i);
            this.kvk.setVisibility(0);
            return;
        }
        this.kvk.setVisibility(8);
    }

    private void Ef(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvO() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bwc()) {
                i = 0;
            }
            a(i, this.kvc);
            this.kvc.setThreeDotMode(2);
            this.kvc.refresh(i);
            this.kvc.setVisibility(0);
            return;
        }
        this.kvc.setVisibility(8);
    }

    private void a(int i, MessageRedDotView messageRedDotView) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) messageRedDotView.getLayoutParams();
        if (i == 0) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds16);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds16);
            return;
        }
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds0);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds0);
    }
}
