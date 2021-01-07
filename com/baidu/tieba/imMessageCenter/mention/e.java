package com.baidu.tieba.imMessageCenter.mention;

import android.app.Activity;
import android.content.Intent;
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
import androidx.core.app.NotificationManagerCompat;
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
import com.baidu.tbadk.core.util.ao;
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
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.base.d<ChatAggregationFragment> implements View.OnClickListener, f.c {
    private boolean azN;
    private View bNO;
    private int fjA;
    private final CustomMessageListener fvn;
    private BdSwipeRefreshLayout gEz;
    private final f.c gJh;
    private boolean isNeedRefresh;
    private RelativeLayout jaT;
    private final CustomMessageListener jgI;
    private View kNA;
    private ImageView kNB;
    private TextView kNC;
    private MessageRedDotView kND;
    private View kNE;
    private ImageView kNF;
    private TextView kNG;
    private MessageRedDotView kNH;
    private View kNI;
    private ImageView kNJ;
    private TextView kNK;
    private MessageRedDotView kNL;
    private View kNM;
    private ImageView kNN;
    private TextView kNO;
    private MessageRedDotView kNP;
    private int kNQ;
    private int kNR;
    private com.baidu.tieba.imMessageCenter.mention.base.e kNS;
    private boolean kNT;
    private e.a kNU;
    private final AdapterView.OnItemLongClickListener kNV;
    private final ChatAggregationFragment kNo;
    private ImMessageCenterModel kNp;
    private ImMessageCenterShowItemData kNq;
    private BdListView kNr;
    private NavigationBarShadowView kNs;
    private MessageAggregationListAdapter kNt;
    private ShutDownValidateTipView kNu;
    private com.baidu.tbadk.core.dialog.i kNv;
    private k.c kNw;
    private boolean kNx;
    private boolean kNy;
    private int kNz;
    private com.baidu.tbadk.core.dialog.d kzL;
    private final CustomMessageListener kzM;
    private com.baidu.tieba.im.chat.a.a kzO;
    private final com.baidu.tieba.im.chat.a.b kzP;
    private View mHeaderView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) com.baidu.adp.base.j.K(chatAggregationFragment.getPageContext().getPageActivity()));
        this.kNp = null;
        this.kNq = null;
        this.kNr = null;
        this.kNt = null;
        this.kNv = null;
        this.kNx = true;
        this.azN = false;
        this.isNeedRefresh = false;
        this.kNy = true;
        this.kNz = 16;
        this.kNT = false;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.kNs.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.kNs.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.kNs.hide();
                }
            }
        };
        this.gJh = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (e.this.gEz != null) {
                        e.this.gEz.setRefreshing(false);
                        return;
                    }
                    return;
                }
                e.this.te(true);
                e.this.pA(false);
            }
        };
        this.kNU = new e.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.imMessageCenter.mention.base.e.a
            public void onClose() {
                if (e.this.kNS != null) {
                    e.this.kNr.removeHeaderView(e.this.kNS.getView());
                    e.this.kNT = false;
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData DY = e.this.kNt.getItem(i);
                    TiebaStatic.eventStat(e.this.kNo.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    aq aqVar = new aq("c13720");
                    aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                    String ownerName = DY.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(DY);
                        aqVar.an("obj_type", 6);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kNo.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.kNo.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.kNo.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(DY.getFriendId(), 0L), DY.getFriendName(), 0L, "msg_lstb")));
                        } else {
                            return;
                        }
                    } else if (DY.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kNo.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(DY);
                            aqVar.an("obj_type", 7);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBz() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBz().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.kNo.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (DY.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kNo.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(DY);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBz() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBz().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.kNo.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("5")) {
                        TiebaStatic.log("c12931");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarFeedActivityConfig(e.this.kNo.getPageContext().getPageActivity())));
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kNo.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            long j2 = com.baidu.adp.lib.f.b.toLong(DY.getFriendId(), 0L);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.kNo.getPageContext().getPageActivity(), j2, DY.getFriendNameShow(), DY.getFriendPortrait(), 0, DY.getUserType())));
                            if ("801001117".equals(String.valueOf(j2))) {
                                TiebaStatic.log(new aq("c14049").dX("uid", TbadkCoreApplication.getCurrentAccount()));
                            } else if ("3222425470".equals(String.valueOf(j2))) {
                                TiebaStatic.log(new aq("c14052").dX("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new aq("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.kNo.getPageContext().getPageActivity())));
                        aqVar.an("obj_type", 6);
                        return;
                    } else {
                        e(DY);
                        aqVar.an("obj_type", 6);
                    }
                    if (!TextUtils.isEmpty(DY.getFriendName())) {
                        if ("贴吧热榜".equals(DY.getFriendName())) {
                            aqVar.an("obj_type", 8);
                        } else if ("贴吧荣誉墙".equals(DY.getFriendName())) {
                            aqVar.an("obj_type", 9);
                        } else if ("贴吧精选".equals(DY.getFriendName())) {
                            aqVar.an("obj_type", 10);
                        } else if ("贴吧活动".equals(DY.getFriendName())) {
                            aqVar.an("obj_type", 4);
                        } else if ("吧广播".equals(DY.getFriendName())) {
                            aqVar.an("obj_type", 5);
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
                                com.baidu.tieba.im.db.d.cXn().Nb("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.cXn().Nb("group_intro_change");
                                com.baidu.tieba.im.db.d.cXn().Nb("group_name_change");
                                com.baidu.tieba.im.db.d.cXn().Nb("group_notice_change");
                                com.baidu.tieba.im.db.d.cXn().Nb("group_level_up");
                                com.baidu.tieba.im.db.d.cXn().Nb("dismiss_group");
                                com.baidu.tieba.im.db.d.cXn().Nb("kick_out");
                                com.baidu.tieba.im.db.d.cXn().Nb("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.bBd().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.bBd().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.kNo.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.kNV = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.kNq = e.this.kNt.getItem(i);
                e.this.c(e.this.kNq);
                if (e.this.kNv != null) {
                    TiebaStatic.log("c12932");
                    e.this.kNv.SY();
                    if (e.this.kNo != null && e.this.kNo.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.kNo.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.kzM = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
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
                        e.this.te(false);
                    } else if (customResponsedMessage.getCmd() == 2016001) {
                        e.this.kNp.setData(null, e.this.kzO);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.kNt != null) {
                            e.this.kNt.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.kNt != null) {
                        e.this.kNt.notifyDataSetChanged();
                    }
                }
            }
        };
        this.kzO = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cWW();
            }
        };
        this.fvn = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.kzP = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cWV();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.kzL != null) {
                    e.this.kzL.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.If();
                e.this.kNo.showToast(R.string.delete_success, false);
                e.this.cWW();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.If();
            }
        };
        this.jgI = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    e.this.b((NewsNotifyMessage) customResponsedMessage);
                }
            }
        };
        this.kNo = chatAggregationFragment;
    }

    public void as(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.kNz = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.kNz = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.kNz);
        }
    }

    public void cNx() {
        if (this.kNt != null) {
            this.kNt.notifyDataSetChanged();
        }
    }

    public void cLE() {
        MessageManager.getInstance().unRegisterListener(this.kzM);
        MessageManager.getInstance().unRegisterListener(this.fvn);
    }

    public View bYn() {
        this.fjA = 3;
        this.rootView = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        cR(this.rootView);
        TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        cvN();
        return this.rootView;
    }

    public Activity getActivity() {
        return this.kNo.getPageContext().getPageActivity();
    }

    protected void cvN() {
        this.kNr.startPullRefresh();
        this.azN = isLogin();
        if (!this.azN) {
            al(this.azN, true);
        }
    }

    private void registerListener() {
        this.kNo.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.kzM);
        this.kNo.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.kzM);
        this.kNo.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.kzM);
        this.kNo.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.kzM);
        this.kNo.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.kzM);
        this.kNo.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.kzM);
        this.kNo.registerListener(this.fvn);
        this.kNo.registerListener(this.jgI);
    }

    public void WF() {
        if (this.gEz != null && !this.gEz.isRefreshing()) {
            te(true);
        }
    }

    public void te(boolean z) {
        if (this.gEz != null) {
            if (z && this.kNr != null && this.kNr.getFirstVisiblePosition() != 0) {
                this.kNr.setSelection(0);
            }
            this.gEz.setRefreshing(z);
        }
    }

    public void tf(boolean z) {
        this.isNeedRefresh = z;
    }

    public void tg(boolean z) {
        this.kNy = z;
    }

    public void onPrimary() {
        if (this.kNt != null && this.kNt.getCount() == 0) {
            tf(true);
        }
        if (this.kNy || this.isNeedRefresh) {
            this.kNy = false;
            this.isNeedRefresh = false;
            pA(false);
        }
        boolean isLogin = isLogin();
        if (this.azN != isLogin) {
            this.azN = isLogin;
            onUserChanged(this.azN);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kNo.getPageContext());
        }
        daY();
    }

    private void initData() {
        this.kNp = new ImMessageCenterModel();
        ti(com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void cR(View view) {
        this.jaT = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.kNu = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.kNu.setVisibility(8);
        this.kNu.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.ti(false);
                e.this.th(false);
            }
        });
        this.kNs = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.kNr = (BdListView) view.findViewById(R.id.chat_list_content);
        this.kNr.setDividerHeight(0);
        this.kNt = new MessageAggregationListAdapter(this.kNo.getPageContext().getPageActivity());
        this.kNt.a(this);
        this.kNr.setAdapter((ListAdapter) this.kNt);
        this.kNr.setOnItemClickListener(this.mItemClickListener);
        this.kNr.setOnItemLongClickListener(this.kNV);
        this.kNr.setOnScrollListener(this.mOnScrollListener);
        this.mHeaderView = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
        this.kNA = this.mHeaderView.findViewById(R.id.at_me_layout);
        this.kNB = (ImageView) this.mHeaderView.findViewById(R.id.at_me_icon);
        this.kNC = (TextView) this.mHeaderView.findViewById(R.id.at_me_text);
        this.kND = (MessageRedDotView) this.mHeaderView.findViewById(R.id.at_me_new_message);
        this.kNE = this.mHeaderView.findViewById(R.id.agree_me_layout);
        this.kNF = (ImageView) this.mHeaderView.findViewById(R.id.agree_me_icon);
        this.kNG = (TextView) this.mHeaderView.findViewById(R.id.agree_me_text);
        this.kNH = (MessageRedDotView) this.mHeaderView.findViewById(R.id.agree_me_new_message);
        this.kNI = this.mHeaderView.findViewById(R.id.reply_me_layout);
        this.kNJ = (ImageView) this.mHeaderView.findViewById(R.id.reply_me_icon);
        this.kNK = (TextView) this.mHeaderView.findViewById(R.id.reply_me_text);
        this.kNL = (MessageRedDotView) this.mHeaderView.findViewById(R.id.reply_me_new_message);
        this.kNM = this.mHeaderView.findViewById(R.id.fans_layout);
        this.kNN = (ImageView) this.mHeaderView.findViewById(R.id.fans_icon);
        this.kNO = (TextView) this.mHeaderView.findViewById(R.id.fans_text);
        this.kNP = (MessageRedDotView) this.mHeaderView.findViewById(R.id.fans_new_message);
        this.kND.setThreeDotMode(2);
        this.kNH.setThreeDotMode(2);
        this.kNL.setThreeDotMode(2);
        this.kNP.setThreeDotMode(2);
        this.kND.setShadowEnabled(false);
        this.kNH.setShadowEnabled(false);
        this.kNL.setShadowEnabled(false);
        this.kNA.setOnClickListener(this);
        this.kNE.setOnClickListener(this);
        this.kNI.setOnClickListener(this);
        this.kNM.setOnClickListener(this);
        this.kNr.addHeaderView(this.mHeaderView);
        daY();
        this.gEz = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kNo.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gJh);
        }
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.gEz.setProgressView(this.mPullView);
        this.bNO = new View(this.kNo.getFragmentActivity());
        this.bNO.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.kNo.getFragmentActivity(), R.dimen.ds150)));
        this.kNr.addFooterView(this.bNO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void daY() {
        if (this.kNr != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
            aq aqVar = new aq("c13616");
            aqVar.an("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aqVar);
            if (areNotificationsEnabled) {
                if (this.kNS != null) {
                    this.kNr.removeHeaderView(this.kNS.getView());
                    this.kNT = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bvr().getLong("key_im_open_notification_close_time", 0L);
            if (this.kNT) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kNS == null) {
                    this.kNS = new com.baidu.tieba.imMessageCenter.mention.base.e(this.mContext);
                    this.kNS.a(this.kNU);
                }
                this.kNr.addHeaderView(this.kNS.getView(), 0);
                this.kNT = true;
            }
        }
    }

    private boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kNo.getPageContext(), i);
        }
        if (this.kNu != null) {
            this.kNu.onChangeSkinType(i);
        }
        if (this.kNt != null) {
            this.kNt.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.jaT);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ao.setBackgroundColor(this.jaT, R.color.CAM_X0201);
        ao.setBackgroundColor(this.gEz, R.color.CAM_X0205);
        ao.setViewTextColor(this.kNC, R.color.CAM_X0105);
        ao.setViewTextColor(this.kNG, R.color.CAM_X0105);
        ao.setViewTextColor(this.kNK, R.color.CAM_X0105);
        ao.setViewTextColor(this.kNO, R.color.CAM_X0105);
        ao.setImageResource(this.kNB, R.drawable.pic_information_at_me);
        ao.setImageResource(this.kNF, R.drawable.pic_information_praise);
        ao.setImageResource(this.kNJ, R.drawable.pic_information_reply);
        ao.setImageResource(this.kNN, R.drawable.pic_information_fans);
        if (this.kND != null) {
            this.kND.onChangeSkinType();
        }
        if (this.kNH != null) {
            this.kNH.onChangeSkinType();
        }
        if (this.kNL != null) {
            this.kNL.onChangeSkinType();
        }
        if (this.kNP != null) {
            this.kNP.onChangeSkinType();
        }
        if (this.kNS != null) {
            this.kNS.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    protected void onUserChanged(boolean z) {
        al(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.kNw = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.kNv != null && e.this.kNv.isShowing() && e.this.kNo != null) {
                    e.this.kNv.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.kNp.asyncDeleteItem(imMessageCenterShowItemData, e.this.kzP);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.kNo.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.kNv = new com.baidu.tbadk.core.dialog.i(this.kNo.getPageContext());
        this.kNv.a(null, new String[]{string}, this.kNw);
    }

    protected boolean pA(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.kNr.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void th(boolean z) {
        if (z) {
            if (daZ() && this.kNu.getVisibility() != 0) {
                this.kNu.setVisibility(0);
            }
        } else if (this.kNu.getVisibility() != 8) {
            this.kNu.setVisibility(8);
        }
    }

    public void al(boolean z, boolean z2) {
    }

    public boolean daZ() {
        return this.kNx;
    }

    public void ti(boolean z) {
        this.kNx = z;
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
                if (this.kNp != null) {
                    this.kNp.insertOrUpdate(data, this.kzO);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.kNp != null) {
                this.kNp.remove(data, this.kzO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.kNp != null) {
                this.kNp.setData(data, this.kzO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.kNz = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.kNz != -1) {
                tf(true);
                onPrimary();
            }
        }
    }

    public void td(boolean z) {
        if (z && this.kNr != null && this.kNr.getWrappedAdapter() != null && this.kNr.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.kNr.startPullRefresh();
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
                dba();
            }
        }
    }

    private void dba() {
        if (this.kNt != null) {
            this.kNt.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWV() {
        If();
        if (this.kzL == null) {
            this.kzL = com.baidu.tieba.im.db.e.cXo().gx(getPageContext().getPageActivity());
        }
        this.kzL.show();
        this.kzL.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void If() {
        if (this.kzL != null && this.kzL.isShowing()) {
            this.kzL.dismiss();
            this.kzL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWW() {
        if (this.kNr != null && this.kNp != null) {
            this.kNr.completePullRefreshPostDelayed(0L);
            if (this.kNp.getData() != null) {
                this.kNt.setData(this.kNp.getData());
            } else {
                al(isLogin(), true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar = new aq("c13720");
        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
        if (view == this.kNA) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBr();
            com.baidu.tbadk.coreExtra.messageCenter.b.bBd().setMsgAtme(0);
            this.kNQ = 0;
            EJ(this.kNQ);
            TiebaStatic.log("c12925");
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            aqVar.an("obj_type", 1);
        } else if (view == this.kNE) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBs();
            com.baidu.tbadk.coreExtra.messageCenter.b.bBd().rT(0);
            this.kNR = 0;
            EM(this.kNR);
            TiebaStatic.log("c12926");
            aqVar.an("obj_type", 2);
        } else if (view == this.kNI) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBq();
            com.baidu.tbadk.coreExtra.messageCenter.b.bBd().setMsgReplyme(0);
            EK(0);
        } else if (view == this.kNM) {
            com.baidu.tieba.p.a.dGE().h(2, false, true);
            TiebaStatic.log(new aq("c12523").an("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
            com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBt();
            com.baidu.tbadk.coreExtra.messageCenter.b.bBd().setMsgFans(0);
            EL(0);
        }
        TiebaStatic.log(aqVar);
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.kNQ = newsNotifyMessage.getMsgAtme();
            this.kNR = newsNotifyMessage.getMsgAgree();
            EJ(this.kNQ);
            EM(this.kNR);
            EL(newsNotifyMessage.getMsgFans());
            EK(newsNotifyMessage.getMsgReplyme());
        }
    }

    private void EJ(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBJ() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBL()) {
                i = 0;
            }
            a(i, this.kND);
            this.kND.setThreeDotMode(2);
            this.kND.refresh(i);
            this.kND.setVisibility(0);
            return;
        }
        this.kND.setVisibility(8);
    }

    private void EK(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBJ() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBN()) {
                i = 0;
            }
            a(i, this.kNL);
            this.kNL.setThreeDotMode(2);
            this.kNL.refresh(i);
            this.kNL.setVisibility(0);
            return;
        }
        this.kNL.setVisibility(8);
    }

    private void EL(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBJ() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBM()) {
                i = 0;
            }
            a(i, this.kNP);
            this.kNP.setThreeDotMode(2);
            this.kNP.refresh(i);
            this.kNP.setVisibility(0);
            return;
        }
        this.kNP.setVisibility(8);
    }

    private void EM(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBJ() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBX()) {
                i = 0;
            }
            a(i, this.kNH);
            this.kNH.setThreeDotMode(2);
            this.kNH.refresh(i);
            this.kNH.setVisibility(0);
            return;
        }
        this.kNH.setVisibility(8);
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
