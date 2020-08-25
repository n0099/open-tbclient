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
import com.baidu.tbadk.core.util.aq;
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
/* loaded from: classes16.dex */
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements View.OnClickListener, f.c {
    private View bqe;
    private final CustomMessageListener eCs;
    private boolean ePV;
    private int eqU;
    private BdSwipeRefreshLayout fGi;
    private final f.c fKL;
    private final CustomMessageListener hUo;
    private boolean isNeedRefresh;
    private final ChatAggregationFragment jDY;
    private ImMessageCenterModel jDZ;
    private int jEA;
    private int jEB;
    private com.baidu.tieba.imMessageCenter.mention.base.f jEC;
    private boolean jED;
    private f.a jEE;
    private final AdapterView.OnItemLongClickListener jEF;
    private ImMessageCenterShowItemData jEa;
    private BdListView jEb;
    private NavigationBarShadowView jEc;
    private MessageAggregationListAdapter jEd;
    private ShutDownValidateTipView jEe;
    private com.baidu.tbadk.core.dialog.i jEf;
    private k.c jEg;
    private boolean jEh;
    private boolean jEi;
    private int jEj;
    private View jEk;
    private ImageView jEl;
    private TextView jEm;
    private MessageRedDotView jEn;
    private View jEo;
    private ImageView jEp;
    private TextView jEq;
    private MessageRedDotView jEr;
    private View jEs;
    private ImageView jEt;
    private TextView jEu;
    private MessageRedDotView jEv;
    private View jEw;
    private ImageView jEx;
    private TextView jEy;
    private MessageRedDotView jEz;
    private com.baidu.tbadk.core.dialog.d jiM;
    private final CustomMessageListener jiN;
    private com.baidu.tieba.im.chat.a.a jiP;
    private final com.baidu.tieba.im.chat.a.b jiQ;
    private View mHeaderView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) com.baidu.adp.base.i.I(chatAggregationFragment.getPageContext().getPageActivity()));
        this.jDZ = null;
        this.jEa = null;
        this.jEb = null;
        this.jEd = null;
        this.jEf = null;
        this.jEh = true;
        this.ePV = false;
        this.isNeedRefresh = false;
        this.jEi = true;
        this.jEj = 16;
        this.jED = false;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.jEc.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.jEc.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.jEc.hide();
                }
            }
        };
        this.fKL = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (e.this.fGi != null) {
                        e.this.fGi.setRefreshing(false);
                        return;
                    }
                    return;
                }
                e.this.rh(true);
                e.this.np(false);
            }
        };
        this.jEE = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (e.this.jEC != null) {
                    e.this.jEb.removeHeaderView(e.this.jEC.getView());
                    e.this.jED = false;
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData AM = e.this.jEd.getItem(i);
                    TiebaStatic.eventStat(e.this.jDY.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    aq aqVar = new aq("c13720");
                    aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                    String ownerName = AM.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(AM);
                        aqVar.ai("obj_type", 6);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jDY.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.jDY.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.jDY.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(AM.getFriendId(), 0L), AM.getFriendName(), 0L, "msg_lstb")));
                        } else {
                            return;
                        }
                    } else if (AM.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jDY.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(AM);
                            aqVar.ai("obj_type", 7);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bnV().bor() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bnV().bor().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.jDY.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (AM.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jDY.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(AM);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bnV().bor() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bnV().bor().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.jDY.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("5")) {
                        TiebaStatic.log("c12931");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarFeedActivityConfig(e.this.jDY.getPageContext().getPageActivity())));
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jDY.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.jDY.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(AM.getFriendId(), 0L), AM.getFriendNameShow(), AM.getFriendPortrait(), 0, AM.getUserType())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new aq("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.jDY.getPageContext().getPageActivity())));
                        aqVar.ai("obj_type", 6);
                        return;
                    } else {
                        e(AM);
                        aqVar.ai("obj_type", 6);
                    }
                    if (!TextUtils.isEmpty(AM.getFriendName())) {
                        if ("贴吧热榜".equals(AM.getFriendName())) {
                            aqVar.ai("obj_type", 8);
                        } else if ("贴吧荣誉墙".equals(AM.getFriendName())) {
                            aqVar.ai("obj_type", 9);
                        } else if ("贴吧精选".equals(AM.getFriendName())) {
                            aqVar.ai("obj_type", 10);
                        } else if ("贴吧活动".equals(AM.getFriendName())) {
                            aqVar.ai("obj_type", 4);
                        } else if ("吧广播".equals(AM.getFriendName())) {
                            aqVar.ai("obj_type", 5);
                        }
                    }
                    TiebaStatic.log(aqVar);
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.cDX().Ks("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.cDX().Ks("group_intro_change");
                                com.baidu.tieba.im.db.d.cDX().Ks("group_name_change");
                                com.baidu.tieba.im.db.d.cDX().Ks("group_notice_change");
                                com.baidu.tieba.im.db.d.cDX().Ks("group_level_up");
                                com.baidu.tieba.im.db.d.cDX().Ks("dismiss_group");
                                com.baidu.tieba.im.db.d.cDX().Ks("kick_out");
                                com.baidu.tieba.im.db.d.cDX().Ks("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.bnV().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.jDY.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.jEF = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.jEa = e.this.jEd.getItem(i);
                e.this.c(e.this.jEa);
                if (e.this.jEf != null) {
                    TiebaStatic.log("c12932");
                    e.this.jEf.Nv();
                    if (e.this.jDY != null && e.this.jDY.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.jDY.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.jiN = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
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
                        e.this.rh(false);
                    } else if (customResponsedMessage.getCmd() == 2016001) {
                        e.this.jDZ.setData(null, e.this.jiP);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.jEd != null) {
                            e.this.jEd.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.jEd != null) {
                        e.this.jEd.notifyDataSetChanged();
                    }
                }
            }
        };
        this.jiP = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cCq();
            }
        };
        this.eCs = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.jiQ = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cCp();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.jiM != null) {
                    e.this.jiM.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.Fd();
                e.this.jDY.showToast(R.string.delete_success, false);
                e.this.cCq();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.Fd();
            }
        };
        this.hUo = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    e.this.b((NewsNotifyMessage) customResponsedMessage);
                }
            }
        };
        this.jDY = chatAggregationFragment;
    }

    public void aq(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.jEj = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.jEj = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.jEj);
        }
    }

    public void cte() {
        if (this.jEd != null) {
            this.jEd.notifyDataSetChanged();
        }
    }

    public void crq() {
        MessageManager.getInstance().unRegisterListener(this.jiN);
        MessageManager.getInstance().unRegisterListener(this.eCs);
    }

    public View bJD() {
        this.eqU = 3;
        this.rootView = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        ca(this.rootView);
        TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        ccK();
        return this.rootView;
    }

    public Activity getActivity() {
        return this.jDY.getPageContext().getPageActivity();
    }

    protected void ccK() {
        this.jEb.startPullRefresh();
        this.ePV = isLogin();
        if (!this.ePV) {
            af(this.ePV, true);
        }
    }

    private void registerListener() {
        this.jDY.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.jiN);
        this.jDY.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.jiN);
        this.jDY.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.jiN);
        this.jDY.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.jiN);
        this.jDY.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.jiN);
        this.jDY.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.jiN);
        this.jDY.registerListener(this.eCs);
        this.jDY.registerListener(this.hUo);
    }

    public void OA() {
        if (this.fGi != null && !this.fGi.isRefreshing()) {
            rh(true);
        }
    }

    public void rh(boolean z) {
        if (this.fGi != null) {
            if (z && this.jEb != null && this.jEb.getFirstVisiblePosition() != 0) {
                this.jEb.setSelection(0);
            }
            this.fGi.setRefreshing(z);
        }
    }

    public void ri(boolean z) {
        this.isNeedRefresh = z;
    }

    public void rj(boolean z) {
        this.jEi = z;
    }

    public void onPrimary() {
        if (this.jEd != null && this.jEd.getCount() == 0) {
            ri(true);
        }
        if (this.jEi || this.isNeedRefresh) {
            this.jEi = false;
            this.isNeedRefresh = false;
            np(false);
        }
        boolean isLogin = isLogin();
        if (this.ePV != isLogin) {
            this.ePV = isLogin;
            onUserChanged(this.ePV);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.jDY.getPageContext());
        }
        cJE();
    }

    private void initData() {
        this.jDZ = new ImMessageCenterModel();
        rl(com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void ca(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.jEe = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.jEe.setVisibility(8);
        this.jEe.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.rl(false);
                e.this.rk(false);
            }
        });
        this.jEc = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.jEb = (BdListView) view.findViewById(R.id.chat_list_content);
        this.jEb.setDividerHeight(0);
        this.jEd = new MessageAggregationListAdapter(this.jDY.getPageContext().getPageActivity());
        this.jEd.a(this);
        this.jEb.setAdapter((ListAdapter) this.jEd);
        this.jEb.setOnItemClickListener(this.mItemClickListener);
        this.jEb.setOnItemLongClickListener(this.jEF);
        this.jEb.setOnScrollListener(this.mOnScrollListener);
        this.mHeaderView = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
        this.jEk = this.mHeaderView.findViewById(R.id.at_me_layout);
        this.jEl = (ImageView) this.mHeaderView.findViewById(R.id.at_me_icon);
        this.jEm = (TextView) this.mHeaderView.findViewById(R.id.at_me_text);
        this.jEn = (MessageRedDotView) this.mHeaderView.findViewById(R.id.at_me_new_message);
        this.jEo = this.mHeaderView.findViewById(R.id.agree_me_layout);
        this.jEp = (ImageView) this.mHeaderView.findViewById(R.id.agree_me_icon);
        this.jEq = (TextView) this.mHeaderView.findViewById(R.id.agree_me_text);
        this.jEr = (MessageRedDotView) this.mHeaderView.findViewById(R.id.agree_me_new_message);
        this.jEs = this.mHeaderView.findViewById(R.id.reply_me_layout);
        this.jEt = (ImageView) this.mHeaderView.findViewById(R.id.reply_me_icon);
        this.jEu = (TextView) this.mHeaderView.findViewById(R.id.reply_me_text);
        this.jEv = (MessageRedDotView) this.mHeaderView.findViewById(R.id.reply_me_new_message);
        this.jEw = this.mHeaderView.findViewById(R.id.fans_layout);
        this.jEx = (ImageView) this.mHeaderView.findViewById(R.id.fans_icon);
        this.jEy = (TextView) this.mHeaderView.findViewById(R.id.fans_text);
        this.jEz = (MessageRedDotView) this.mHeaderView.findViewById(R.id.fans_new_message);
        this.jEn.setThreeDotMode(2);
        this.jEr.setThreeDotMode(2);
        this.jEv.setThreeDotMode(2);
        this.jEz.setThreeDotMode(2);
        this.jEn.setShadowEnabled(false);
        this.jEr.setShadowEnabled(false);
        this.jEv.setShadowEnabled(false);
        this.jEk.setOnClickListener(this);
        this.jEo.setOnClickListener(this);
        this.jEs.setOnClickListener(this);
        this.jEw.setOnClickListener(this);
        this.jEb.addHeaderView(this.mHeaderView);
        cJE();
        this.fGi = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.jDY.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fKL);
        }
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.fGi.setProgressView(this.mPullView);
        this.bqe = new View(this.jDY.getFragmentActivity());
        this.bqe.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.jDY.getFragmentActivity(), R.dimen.ds150)));
        this.jEb.addFooterView(this.bqe);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cJE() {
        if (this.jEb != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
            aq aqVar = new aq("c13616");
            aqVar.ai("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aqVar);
            if (areNotificationsEnabled) {
                if (this.jEC != null) {
                    this.jEb.removeHeaderView(this.jEC.getView());
                    this.jED = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_im_open_notification_close_time", 0L);
            if (this.jED) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.jEC == null) {
                    this.jEC = new com.baidu.tieba.imMessageCenter.mention.base.f(this.mContext);
                    this.jEC.a(this.jEE);
                }
                this.jEb.addHeaderView(this.jEC.getView(), 0);
                this.jED = true;
            }
        }
    }

    private boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jDY.getPageContext(), i);
        }
        if (this.jEe != null) {
            this.jEe.onChangeSkinType(i);
        }
        if (this.jEd != null) {
            this.jEd.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.fGi, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.jEm, R.color.cp_cont_b);
        ap.setViewTextColor(this.jEq, R.color.cp_cont_b);
        ap.setViewTextColor(this.jEu, R.color.cp_cont_b);
        ap.setViewTextColor(this.jEy, R.color.cp_cont_b);
        ap.setImageResource(this.jEl, R.drawable.pic_information_at_me);
        ap.setImageResource(this.jEp, R.drawable.pic_information_praise);
        ap.setImageResource(this.jEt, R.drawable.pic_information_reply);
        ap.setImageResource(this.jEx, R.drawable.pic_information_fans);
        if (this.jEn != null) {
            this.jEn.onChangeSkinType();
        }
        if (this.jEr != null) {
            this.jEr.onChangeSkinType();
        }
        if (this.jEv != null) {
            this.jEv.onChangeSkinType();
        }
        if (this.jEz != null) {
            this.jEz.onChangeSkinType();
        }
        if (this.jEC != null) {
            this.jEC.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    protected void onUserChanged(boolean z) {
        af(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.jEg = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.jEf != null && e.this.jEf.isShowing() && e.this.jDY != null) {
                    e.this.jEf.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.jDZ.asyncDeleteItem(imMessageCenterShowItemData, e.this.jiQ);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.jDY.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.jEf = new com.baidu.tbadk.core.dialog.i(this.jDY.getPageContext());
        this.jEf.a(null, new String[]{string}, this.jEg);
    }

    protected boolean np(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.jEb.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void rk(boolean z) {
        if (z) {
            if (cJF() && this.jEe.getVisibility() != 0) {
                this.jEe.setVisibility(0);
            }
        } else if (this.jEe.getVisibility() != 8) {
            this.jEe.setVisibility(8);
        }
    }

    public void af(boolean z, boolean z2) {
    }

    public boolean cJF() {
        return this.jEh;
    }

    public void rl(boolean z) {
        this.jEh = z;
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
                if (this.jDZ != null) {
                    this.jDZ.insertOrUpdate(data, this.jiP);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.jDZ != null) {
                this.jDZ.remove(data, this.jiP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.jDZ != null) {
                this.jDZ.setData(data, this.jiP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.jEj = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.jEj != -1) {
                ri(true);
                onPrimary();
            }
        }
    }

    public void rg(boolean z) {
        if (z && this.jEb != null && this.jEb.getWrappedAdapter() != null && this.jEb.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.jEb.startPullRefresh();
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
                cJG();
            }
        }
    }

    private void cJG() {
        if (this.jEd != null) {
            this.jEd.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCp() {
        Fd();
        if (this.jiM == null) {
            this.jiM = com.baidu.tieba.im.db.e.cDY().fl(getPageContext().getPageActivity());
        }
        this.jiM.show();
        this.jiM.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd() {
        if (this.jiM != null && this.jiM.isShowing()) {
            this.jiM.dismiss();
            this.jiM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCq() {
        if (this.jEb != null && this.jDZ != null) {
            this.jEb.completePullRefreshPostDelayed(0L);
            if (this.jDZ.getData() != null) {
                this.jEd.setData(this.jDZ.getData());
            } else {
                af(isLogin(), true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar = new aq("c13720");
        aqVar.u("uid", TbadkApplication.getCurrentAccountId());
        if (view == this.jEk) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().boj();
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgAtme(0);
            this.jEA = 0;
            BR(this.jEA);
            TiebaStatic.log("c12925");
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            aqVar.ai("obj_type", 1);
        } else if (view == this.jEo) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().bok();
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().pC(0);
            this.jEB = 0;
            BU(this.jEB);
            TiebaStatic.log("c12926");
            aqVar.ai("obj_type", 2);
        } else if (view == this.jEs) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().boi();
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgReplyme(0);
            BS(0);
        } else if (view == this.jEw) {
            com.baidu.tieba.p.a.doQ().h(2, false, true);
            TiebaStatic.log(new aq("c12523").ai("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().bol();
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgFans(0);
            BT(0);
        }
        TiebaStatic.log(aqVar);
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.jEA = newsNotifyMessage.getMsgAtme();
            this.jEB = newsNotifyMessage.getMsgAgree();
            BR(this.jEA);
            BU(this.jEB);
            BT(newsNotifyMessage.getMsgFans());
            BS(newsNotifyMessage.getMsgReplyme());
        }
    }

    private void BR(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boB() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.boy().boD()) {
                i = 0;
            }
            a(i, this.jEn);
            this.jEn.setThreeDotMode(2);
            this.jEn.refresh(i);
            this.jEn.setVisibility(0);
            return;
        }
        this.jEn.setVisibility(8);
    }

    private void BS(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boB() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.boy().boF()) {
                i = 0;
            }
            a(i, this.jEv);
            this.jEv.setThreeDotMode(2);
            this.jEv.refresh(i);
            this.jEv.setVisibility(0);
            return;
        }
        this.jEv.setVisibility(8);
    }

    private void BT(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boB() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.boy().boE()) {
                i = 0;
            }
            a(i, this.jEz);
            this.jEz.setThreeDotMode(2);
            this.jEz.refresh(i);
            this.jEz.setVisibility(0);
            return;
        }
        this.jEz.setVisibility(8);
    }

    private void BU(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boB() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.boy().boP()) {
                i = 0;
            }
            a(i, this.jEr);
            this.jEr.setThreeDotMode(2);
            this.jEr.refresh(i);
            this.jEr.setVisibility(0);
            return;
        }
        this.jEr.setVisibility(8);
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
