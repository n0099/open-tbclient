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
    private View bqh;
    private final CustomMessageListener eCw;
    private boolean ePZ;
    private int eqY;
    private BdSwipeRefreshLayout fGm;
    private final f.c fKP;
    private final CustomMessageListener hUu;
    private boolean isNeedRefresh;
    private TextView jEA;
    private MessageRedDotView jEB;
    private View jEC;
    private ImageView jED;
    private TextView jEE;
    private MessageRedDotView jEF;
    private int jEG;
    private int jEH;
    private com.baidu.tieba.imMessageCenter.mention.base.f jEI;
    private boolean jEJ;
    private f.a jEK;
    private final AdapterView.OnItemLongClickListener jEL;
    private final ChatAggregationFragment jEe;
    private ImMessageCenterModel jEf;
    private ImMessageCenterShowItemData jEg;
    private BdListView jEh;
    private NavigationBarShadowView jEi;
    private MessageAggregationListAdapter jEj;
    private ShutDownValidateTipView jEk;
    private com.baidu.tbadk.core.dialog.i jEl;
    private k.c jEm;
    private boolean jEn;
    private boolean jEo;
    private int jEp;
    private View jEq;
    private ImageView jEr;
    private TextView jEs;
    private MessageRedDotView jEt;
    private View jEu;
    private ImageView jEv;
    private TextView jEw;
    private MessageRedDotView jEx;
    private View jEy;
    private ImageView jEz;
    private com.baidu.tbadk.core.dialog.d jiS;
    private final CustomMessageListener jiT;
    private com.baidu.tieba.im.chat.a.a jiV;
    private final com.baidu.tieba.im.chat.a.b jiW;
    private View mHeaderView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) com.baidu.adp.base.i.I(chatAggregationFragment.getPageContext().getPageActivity()));
        this.jEf = null;
        this.jEg = null;
        this.jEh = null;
        this.jEj = null;
        this.jEl = null;
        this.jEn = true;
        this.ePZ = false;
        this.isNeedRefresh = false;
        this.jEo = true;
        this.jEp = 16;
        this.jEJ = false;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.jEi.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.jEi.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.jEi.hide();
                }
            }
        };
        this.fKP = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (e.this.fGm != null) {
                        e.this.fGm.setRefreshing(false);
                        return;
                    }
                    return;
                }
                e.this.rj(true);
                e.this.nr(false);
            }
        };
        this.jEK = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (e.this.jEI != null) {
                    e.this.jEh.removeHeaderView(e.this.jEI.getView());
                    e.this.jEJ = false;
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData AM = e.this.jEj.getItem(i);
                    TiebaStatic.eventStat(e.this.jEe.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    aq aqVar = new aq("c13720");
                    aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                    String ownerName = AM.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(AM);
                        aqVar.ai("obj_type", 6);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jEe.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.jEe.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.jEe.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(AM.getFriendId(), 0L), AM.getFriendName(), 0L, "msg_lstb")));
                        } else {
                            return;
                        }
                    } else if (AM.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jEe.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(AM);
                            aqVar.ai("obj_type", 7);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bnV().bor() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bnV().bor().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.jEe.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (AM.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jEe.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(AM);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bnV().bor() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bnV().bor().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.jEe.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("5")) {
                        TiebaStatic.log("c12931");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarFeedActivityConfig(e.this.jEe.getPageContext().getPageActivity())));
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jEe.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.jEe.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(AM.getFriendId(), 0L), AM.getFriendNameShow(), AM.getFriendPortrait(), 0, AM.getUserType())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new aq("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.jEe.getPageContext().getPageActivity())));
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
                                com.baidu.tieba.im.db.d.cDY().Kt("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.cDY().Kt("group_intro_change");
                                com.baidu.tieba.im.db.d.cDY().Kt("group_name_change");
                                com.baidu.tieba.im.db.d.cDY().Kt("group_notice_change");
                                com.baidu.tieba.im.db.d.cDY().Kt("group_level_up");
                                com.baidu.tieba.im.db.d.cDY().Kt("dismiss_group");
                                com.baidu.tieba.im.db.d.cDY().Kt("kick_out");
                                com.baidu.tieba.im.db.d.cDY().Kt("group_activitys_change");
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.jEe.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.jEL = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.jEg = e.this.jEj.getItem(i);
                e.this.c(e.this.jEg);
                if (e.this.jEl != null) {
                    TiebaStatic.log("c12932");
                    e.this.jEl.Nv();
                    if (e.this.jEe != null && e.this.jEe.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.jEe.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.jiT = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
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
                        e.this.rj(false);
                    } else if (customResponsedMessage.getCmd() == 2016001) {
                        e.this.jEf.setData(null, e.this.jiV);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.jEj != null) {
                            e.this.jEj.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.jEj != null) {
                        e.this.jEj.notifyDataSetChanged();
                    }
                }
            }
        };
        this.jiV = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cCr();
            }
        };
        this.eCw = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.jiW = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cCq();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.jiS != null) {
                    e.this.jiS.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.Fd();
                e.this.jEe.showToast(R.string.delete_success, false);
                e.this.cCr();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.Fd();
            }
        };
        this.hUu = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    e.this.b((NewsNotifyMessage) customResponsedMessage);
                }
            }
        };
        this.jEe = chatAggregationFragment;
    }

    public void aq(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.jEp = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.jEp = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.jEp);
        }
    }

    public void ctf() {
        if (this.jEj != null) {
            this.jEj.notifyDataSetChanged();
        }
    }

    public void crr() {
        MessageManager.getInstance().unRegisterListener(this.jiT);
        MessageManager.getInstance().unRegisterListener(this.eCw);
    }

    public View bJE() {
        this.eqY = 3;
        this.rootView = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        ca(this.rootView);
        TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        ccL();
        return this.rootView;
    }

    public Activity getActivity() {
        return this.jEe.getPageContext().getPageActivity();
    }

    protected void ccL() {
        this.jEh.startPullRefresh();
        this.ePZ = isLogin();
        if (!this.ePZ) {
            af(this.ePZ, true);
        }
    }

    private void registerListener() {
        this.jEe.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.jiT);
        this.jEe.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.jiT);
        this.jEe.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.jiT);
        this.jEe.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.jiT);
        this.jEe.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.jiT);
        this.jEe.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.jiT);
        this.jEe.registerListener(this.eCw);
        this.jEe.registerListener(this.hUu);
    }

    public void OA() {
        if (this.fGm != null && !this.fGm.isRefreshing()) {
            rj(true);
        }
    }

    public void rj(boolean z) {
        if (this.fGm != null) {
            if (z && this.jEh != null && this.jEh.getFirstVisiblePosition() != 0) {
                this.jEh.setSelection(0);
            }
            this.fGm.setRefreshing(z);
        }
    }

    public void rk(boolean z) {
        this.isNeedRefresh = z;
    }

    public void rl(boolean z) {
        this.jEo = z;
    }

    public void onPrimary() {
        if (this.jEj != null && this.jEj.getCount() == 0) {
            rk(true);
        }
        if (this.jEo || this.isNeedRefresh) {
            this.jEo = false;
            this.isNeedRefresh = false;
            nr(false);
        }
        boolean isLogin = isLogin();
        if (this.ePZ != isLogin) {
            this.ePZ = isLogin;
            onUserChanged(this.ePZ);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.jEe.getPageContext());
        }
        cJF();
    }

    private void initData() {
        this.jEf = new ImMessageCenterModel();
        rn(com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void ca(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.jEk = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.jEk.setVisibility(8);
        this.jEk.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.rn(false);
                e.this.rm(false);
            }
        });
        this.jEi = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.jEh = (BdListView) view.findViewById(R.id.chat_list_content);
        this.jEh.setDividerHeight(0);
        this.jEj = new MessageAggregationListAdapter(this.jEe.getPageContext().getPageActivity());
        this.jEj.a(this);
        this.jEh.setAdapter((ListAdapter) this.jEj);
        this.jEh.setOnItemClickListener(this.mItemClickListener);
        this.jEh.setOnItemLongClickListener(this.jEL);
        this.jEh.setOnScrollListener(this.mOnScrollListener);
        this.mHeaderView = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
        this.jEq = this.mHeaderView.findViewById(R.id.at_me_layout);
        this.jEr = (ImageView) this.mHeaderView.findViewById(R.id.at_me_icon);
        this.jEs = (TextView) this.mHeaderView.findViewById(R.id.at_me_text);
        this.jEt = (MessageRedDotView) this.mHeaderView.findViewById(R.id.at_me_new_message);
        this.jEu = this.mHeaderView.findViewById(R.id.agree_me_layout);
        this.jEv = (ImageView) this.mHeaderView.findViewById(R.id.agree_me_icon);
        this.jEw = (TextView) this.mHeaderView.findViewById(R.id.agree_me_text);
        this.jEx = (MessageRedDotView) this.mHeaderView.findViewById(R.id.agree_me_new_message);
        this.jEy = this.mHeaderView.findViewById(R.id.reply_me_layout);
        this.jEz = (ImageView) this.mHeaderView.findViewById(R.id.reply_me_icon);
        this.jEA = (TextView) this.mHeaderView.findViewById(R.id.reply_me_text);
        this.jEB = (MessageRedDotView) this.mHeaderView.findViewById(R.id.reply_me_new_message);
        this.jEC = this.mHeaderView.findViewById(R.id.fans_layout);
        this.jED = (ImageView) this.mHeaderView.findViewById(R.id.fans_icon);
        this.jEE = (TextView) this.mHeaderView.findViewById(R.id.fans_text);
        this.jEF = (MessageRedDotView) this.mHeaderView.findViewById(R.id.fans_new_message);
        this.jEt.setThreeDotMode(2);
        this.jEx.setThreeDotMode(2);
        this.jEB.setThreeDotMode(2);
        this.jEF.setThreeDotMode(2);
        this.jEt.setShadowEnabled(false);
        this.jEx.setShadowEnabled(false);
        this.jEB.setShadowEnabled(false);
        this.jEq.setOnClickListener(this);
        this.jEu.setOnClickListener(this);
        this.jEy.setOnClickListener(this);
        this.jEC.setOnClickListener(this);
        this.jEh.addHeaderView(this.mHeaderView);
        cJF();
        this.fGm = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.jEe.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fKP);
        }
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.fGm.setProgressView(this.mPullView);
        this.bqh = new View(this.jEe.getFragmentActivity());
        this.bqh.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.jEe.getFragmentActivity(), R.dimen.ds150)));
        this.jEh.addFooterView(this.bqh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cJF() {
        if (this.jEh != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
            aq aqVar = new aq("c13616");
            aqVar.ai("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aqVar);
            if (areNotificationsEnabled) {
                if (this.jEI != null) {
                    this.jEh.removeHeaderView(this.jEI.getView());
                    this.jEJ = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_im_open_notification_close_time", 0L);
            if (this.jEJ) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.jEI == null) {
                    this.jEI = new com.baidu.tieba.imMessageCenter.mention.base.f(this.mContext);
                    this.jEI.a(this.jEK);
                }
                this.jEh.addHeaderView(this.jEI.getView(), 0);
                this.jEJ = true;
            }
        }
    }

    private boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jEe.getPageContext(), i);
        }
        if (this.jEk != null) {
            this.jEk.onChangeSkinType(i);
        }
        if (this.jEj != null) {
            this.jEj.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.fGm, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.jEs, R.color.cp_cont_b);
        ap.setViewTextColor(this.jEw, R.color.cp_cont_b);
        ap.setViewTextColor(this.jEA, R.color.cp_cont_b);
        ap.setViewTextColor(this.jEE, R.color.cp_cont_b);
        ap.setImageResource(this.jEr, R.drawable.pic_information_at_me);
        ap.setImageResource(this.jEv, R.drawable.pic_information_praise);
        ap.setImageResource(this.jEz, R.drawable.pic_information_reply);
        ap.setImageResource(this.jED, R.drawable.pic_information_fans);
        if (this.jEt != null) {
            this.jEt.onChangeSkinType();
        }
        if (this.jEx != null) {
            this.jEx.onChangeSkinType();
        }
        if (this.jEB != null) {
            this.jEB.onChangeSkinType();
        }
        if (this.jEF != null) {
            this.jEF.onChangeSkinType();
        }
        if (this.jEI != null) {
            this.jEI.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    protected void onUserChanged(boolean z) {
        af(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.jEm = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.jEl != null && e.this.jEl.isShowing() && e.this.jEe != null) {
                    e.this.jEl.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.jEf.asyncDeleteItem(imMessageCenterShowItemData, e.this.jiW);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.jEe.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.jEl = new com.baidu.tbadk.core.dialog.i(this.jEe.getPageContext());
        this.jEl.a(null, new String[]{string}, this.jEm);
    }

    protected boolean nr(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.jEh.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void rm(boolean z) {
        if (z) {
            if (cJG() && this.jEk.getVisibility() != 0) {
                this.jEk.setVisibility(0);
            }
        } else if (this.jEk.getVisibility() != 8) {
            this.jEk.setVisibility(8);
        }
    }

    public void af(boolean z, boolean z2) {
    }

    public boolean cJG() {
        return this.jEn;
    }

    public void rn(boolean z) {
        this.jEn = z;
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
                if (this.jEf != null) {
                    this.jEf.insertOrUpdate(data, this.jiV);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.jEf != null) {
                this.jEf.remove(data, this.jiV);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.jEf != null) {
                this.jEf.setData(data, this.jiV);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.jEp = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.jEp != -1) {
                rk(true);
                onPrimary();
            }
        }
    }

    public void ri(boolean z) {
        if (z && this.jEh != null && this.jEh.getWrappedAdapter() != null && this.jEh.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.jEh.startPullRefresh();
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
                cJH();
            }
        }
    }

    private void cJH() {
        if (this.jEj != null) {
            this.jEj.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCq() {
        Fd();
        if (this.jiS == null) {
            this.jiS = com.baidu.tieba.im.db.e.cDZ().fl(getPageContext().getPageActivity());
        }
        this.jiS.show();
        this.jiS.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd() {
        if (this.jiS != null && this.jiS.isShowing()) {
            this.jiS.dismiss();
            this.jiS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCr() {
        if (this.jEh != null && this.jEf != null) {
            this.jEh.completePullRefreshPostDelayed(0L);
            if (this.jEf.getData() != null) {
                this.jEj.setData(this.jEf.getData());
            } else {
                af(isLogin(), true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar = new aq("c13720");
        aqVar.u("uid", TbadkApplication.getCurrentAccountId());
        if (view == this.jEq) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().boj();
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgAtme(0);
            this.jEG = 0;
            BR(this.jEG);
            TiebaStatic.log("c12925");
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            aqVar.ai("obj_type", 1);
        } else if (view == this.jEu) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().bok();
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().pC(0);
            this.jEH = 0;
            BU(this.jEH);
            TiebaStatic.log("c12926");
            aqVar.ai("obj_type", 2);
        } else if (view == this.jEy) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().boi();
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgReplyme(0);
            BS(0);
        } else if (view == this.jEC) {
            com.baidu.tieba.p.a.doT().h(2, false, true);
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
            this.jEG = newsNotifyMessage.getMsgAtme();
            this.jEH = newsNotifyMessage.getMsgAgree();
            BR(this.jEG);
            BU(this.jEH);
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
            a(i, this.jEt);
            this.jEt.setThreeDotMode(2);
            this.jEt.refresh(i);
            this.jEt.setVisibility(0);
            return;
        }
        this.jEt.setVisibility(8);
    }

    private void BS(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boB() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.boy().boF()) {
                i = 0;
            }
            a(i, this.jEB);
            this.jEB.setThreeDotMode(2);
            this.jEB.refresh(i);
            this.jEB.setVisibility(0);
            return;
        }
        this.jEB.setVisibility(8);
    }

    private void BT(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boB() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.boy().boE()) {
                i = 0;
            }
            a(i, this.jEF);
            this.jEF.setThreeDotMode(2);
            this.jEF.refresh(i);
            this.jEF.setVisibility(0);
            return;
        }
        this.jEF.setVisibility(8);
    }

    private void BU(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boB() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.boy().boP()) {
                i = 0;
            }
            a(i, this.jEx);
            this.jEx.setThreeDotMode(2);
            this.jEx.refresh(i);
            this.jEx.setVisibility(0);
            return;
        }
        this.jEx.setVisibility(8);
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
