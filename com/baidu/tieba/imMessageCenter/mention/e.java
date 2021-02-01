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
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.base.d<ChatAggregationFragment> implements View.OnClickListener, f.c {
    private boolean auP;
    private View bMM;
    private int fhf;
    private final CustomMessageListener fsV;
    private BdSwipeRefreshLayout gCC;
    private final f.c gHl;
    private boolean isNeedRefresh;
    private RelativeLayout jbT;
    private final CustomMessageListener jhH;
    private com.baidu.tbadk.core.dialog.d kDm;
    private final CustomMessageListener kDn;
    private com.baidu.tieba.im.chat.a.a kDp;
    private final com.baidu.tieba.im.chat.a.b kDq;
    private final ChatAggregationFragment kQM;
    private ImMessageCenterModel kQN;
    private ImMessageCenterShowItemData kQO;
    private BdListView kQP;
    private NavigationBarShadowView kQQ;
    private MessageAggregationListAdapter kQR;
    private ShutDownValidateTipView kQS;
    private com.baidu.tbadk.core.dialog.i kQT;
    private k.c kQU;
    private boolean kQV;
    private boolean kQW;
    private int kQX;
    private View kQY;
    private ImageView kQZ;
    private TextView kRa;
    private MessageRedDotView kRb;
    private View kRc;
    private ImageView kRd;
    private TextView kRe;
    private MessageRedDotView kRf;
    private View kRg;
    private ImageView kRh;
    private TextView kRi;
    private MessageRedDotView kRj;
    private View kRk;
    private ImageView kRl;
    private TextView kRm;
    private MessageRedDotView kRn;
    private int kRo;
    private int kRp;
    private com.baidu.tieba.imMessageCenter.mention.base.e kRq;
    private boolean kRr;
    private e.a kRs;
    private final AdapterView.OnItemLongClickListener kRt;
    private View mHeaderView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) com.baidu.adp.base.j.K(chatAggregationFragment.getPageContext().getPageActivity()));
        this.kQN = null;
        this.kQO = null;
        this.kQP = null;
        this.kQR = null;
        this.kQT = null;
        this.kQV = true;
        this.auP = false;
        this.isNeedRefresh = false;
        this.kQW = true;
        this.kQX = 16;
        this.kRr = false;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.kQQ.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.kQQ.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.kQQ.hide();
                }
            }
        };
        this.gHl = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (e.this.gCC != null) {
                        e.this.gCC.setRefreshing(false);
                        return;
                    }
                    return;
                }
                e.this.tn(true);
                e.this.pG(false);
            }
        };
        this.kRs = new e.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.imMessageCenter.mention.base.e.a
            public void onClose() {
                if (e.this.kRq != null) {
                    e.this.kQP.removeHeaderView(e.this.kRq.getView());
                    e.this.kRr = false;
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData CJ = e.this.kQR.getItem(i);
                    TiebaStatic.eventStat(e.this.kQM.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    ar arVar = new ar("c13720");
                    arVar.v("uid", TbadkApplication.getCurrentAccountId());
                    String ownerName = CJ.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(CJ);
                        arVar.ap("obj_type", 6);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kQM.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.kQM.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.kQM.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(CJ.getFriendId(), 0L), CJ.getFriendName(), 0L, "msg_lstb")));
                        } else {
                            return;
                        }
                    } else if (CJ.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kQM.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(CJ);
                            arVar.ap("obj_type", 7);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxX() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxX().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.kQM.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (CJ.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kQM.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(CJ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxX() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxX().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.kQM.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("5")) {
                        TiebaStatic.log("c12931");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarFeedActivityConfig(e.this.kQM.getPageContext().getPageActivity())));
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kQM.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            long j2 = com.baidu.adp.lib.f.b.toLong(CJ.getFriendId(), 0L);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.kQM.getPageContext().getPageActivity(), j2, CJ.getFriendNameShow(), CJ.getFriendPortrait(), 0, CJ.getUserType())));
                            if ("801001117".equals(String.valueOf(j2))) {
                                TiebaStatic.log(new ar("c14049").dR("uid", TbadkCoreApplication.getCurrentAccount()));
                            } else if ("3222425470".equals(String.valueOf(j2))) {
                                TiebaStatic.log(new ar("c14052").dR("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ar("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.kQM.getPageContext().getPageActivity())));
                        arVar.ap("obj_type", 6);
                        return;
                    } else {
                        e(CJ);
                        arVar.ap("obj_type", 6);
                    }
                    if (!TextUtils.isEmpty(CJ.getFriendName())) {
                        if ("贴吧热榜".equals(CJ.getFriendName())) {
                            arVar.ap("obj_type", 8);
                        } else if ("贴吧荣誉墙".equals(CJ.getFriendName())) {
                            arVar.ap("obj_type", 9);
                        } else if ("贴吧精选".equals(CJ.getFriendName())) {
                            arVar.ap("obj_type", 10);
                        } else if ("贴吧活动".equals(CJ.getFriendName())) {
                            arVar.ap("obj_type", 4);
                        } else if ("吧广播".equals(CJ.getFriendName())) {
                            arVar.ap("obj_type", 5);
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
                                com.baidu.tieba.im.db.d.cVt().MI("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.cVt().MI("group_intro_change");
                                com.baidu.tieba.im.db.d.cVt().MI("group_name_change");
                                com.baidu.tieba.im.db.d.cVt().MI("group_notice_change");
                                com.baidu.tieba.im.db.d.cVt().MI("group_level_up");
                                com.baidu.tieba.im.db.d.cVt().MI("dismiss_group");
                                com.baidu.tieba.im.db.d.cVt().MI("kick_out");
                                com.baidu.tieba.im.db.d.cVt().MI("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.bxB().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.kQM.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.kRt = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.kQO = e.this.kQR.getItem(i);
                e.this.c(e.this.kQO);
                if (e.this.kQT != null) {
                    TiebaStatic.log("c12932");
                    e.this.kQT.QE();
                    if (e.this.kQM != null && e.this.kQM.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.kQM.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.kDn = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
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
                        e.this.tn(false);
                    } else if (customResponsedMessage.getCmd() == 2016001) {
                        e.this.kQN.setData(null, e.this.kDp);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.kQR != null) {
                            e.this.kQR.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.kQR != null) {
                        e.this.kQR.notifyDataSetChanged();
                    }
                }
            }
        };
        this.kDp = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cVc();
            }
        };
        this.fsV = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.kDq = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cVb();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.kDm != null) {
                    e.this.kDm.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.FA();
                e.this.kQM.showToast(R.string.delete_success, false);
                e.this.cVc();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.FA();
            }
        };
        this.jhH = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    e.this.b((NewsNotifyMessage) customResponsedMessage);
                }
            }
        };
        this.kQM = chatAggregationFragment;
    }

    public void as(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.kQX = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.kQX = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.kQX);
        }
    }

    public void cKS() {
        if (this.kQR != null) {
            this.kQR.notifyDataSetChanged();
        }
    }

    public void cIZ() {
        MessageManager.getInstance().unRegisterListener(this.kDn);
        MessageManager.getInstance().unRegisterListener(this.fsV);
    }

    public View bVk() {
        this.fhf = 3;
        this.rootView = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        cP(this.rootView);
        TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        cth();
        return this.rootView;
    }

    public Activity getActivity() {
        return this.kQM.getPageContext().getPageActivity();
    }

    protected void cth() {
        this.kQP.startPullRefresh();
        this.auP = isLogin();
        if (!this.auP) {
            al(this.auP, true);
        }
    }

    private void registerListener() {
        this.kQM.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.kDn);
        this.kQM.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.kDn);
        this.kQM.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.kDn);
        this.kQM.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.kDn);
        this.kQM.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.kDn);
        this.kQM.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.kDn);
        this.kQM.registerListener(this.fsV);
        this.kQM.registerListener(this.jhH);
    }

    public void Ut() {
        if (this.gCC != null && !this.gCC.isRefreshing()) {
            tn(true);
        }
    }

    public void tn(boolean z) {
        if (this.gCC != null) {
            if (z && this.kQP != null && this.kQP.getFirstVisiblePosition() != 0) {
                this.kQP.setSelection(0);
            }
            this.gCC.setRefreshing(z);
        }
    }

    public void to(boolean z) {
        this.isNeedRefresh = z;
    }

    public void tp(boolean z) {
        this.kQW = z;
    }

    public void onPrimary() {
        if (this.kQR != null && this.kQR.getCount() == 0) {
            to(true);
        }
        if (this.kQW || this.isNeedRefresh) {
            this.kQW = false;
            this.isNeedRefresh = false;
            pG(false);
        }
        boolean isLogin = isLogin();
        if (this.auP != isLogin) {
            this.auP = isLogin;
            onUserChanged(this.auP);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kQM.getPageContext());
        }
        cZe();
    }

    private void initData() {
        this.kQN = new ImMessageCenterModel();
        tr(com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void cP(View view) {
        this.jbT = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.kQS = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.kQS.setVisibility(8);
        this.kQS.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.tr(false);
                e.this.tq(false);
            }
        });
        this.kQQ = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.kQP = (BdListView) view.findViewById(R.id.chat_list_content);
        this.kQP.setDividerHeight(0);
        this.kQR = new MessageAggregationListAdapter(this.kQM.getPageContext().getPageActivity());
        this.kQR.a(this);
        this.kQP.setAdapter((ListAdapter) this.kQR);
        this.kQP.setOnItemClickListener(this.mItemClickListener);
        this.kQP.setOnItemLongClickListener(this.kRt);
        this.kQP.setOnScrollListener(this.mOnScrollListener);
        this.mHeaderView = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
        this.kQY = this.mHeaderView.findViewById(R.id.at_me_layout);
        this.kQZ = (ImageView) this.mHeaderView.findViewById(R.id.at_me_icon);
        this.kRa = (TextView) this.mHeaderView.findViewById(R.id.at_me_text);
        this.kRb = (MessageRedDotView) this.mHeaderView.findViewById(R.id.at_me_new_message);
        this.kRc = this.mHeaderView.findViewById(R.id.agree_me_layout);
        this.kRd = (ImageView) this.mHeaderView.findViewById(R.id.agree_me_icon);
        this.kRe = (TextView) this.mHeaderView.findViewById(R.id.agree_me_text);
        this.kRf = (MessageRedDotView) this.mHeaderView.findViewById(R.id.agree_me_new_message);
        this.kRg = this.mHeaderView.findViewById(R.id.reply_me_layout);
        this.kRh = (ImageView) this.mHeaderView.findViewById(R.id.reply_me_icon);
        this.kRi = (TextView) this.mHeaderView.findViewById(R.id.reply_me_text);
        this.kRj = (MessageRedDotView) this.mHeaderView.findViewById(R.id.reply_me_new_message);
        this.kRk = this.mHeaderView.findViewById(R.id.fans_layout);
        this.kRl = (ImageView) this.mHeaderView.findViewById(R.id.fans_icon);
        this.kRm = (TextView) this.mHeaderView.findViewById(R.id.fans_text);
        this.kRn = (MessageRedDotView) this.mHeaderView.findViewById(R.id.fans_new_message);
        this.kRb.setThreeDotMode(2);
        this.kRf.setThreeDotMode(2);
        this.kRj.setThreeDotMode(2);
        this.kRn.setThreeDotMode(2);
        this.kRb.setShadowEnabled(false);
        this.kRf.setShadowEnabled(false);
        this.kRj.setShadowEnabled(false);
        this.kQY.setOnClickListener(this);
        this.kRc.setOnClickListener(this);
        this.kRg.setOnClickListener(this);
        this.kRk.setOnClickListener(this);
        this.kQP.addHeaderView(this.mHeaderView);
        cZe();
        this.gCC = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kQM.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gHl);
        }
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.gCC.setProgressView(this.mPullView);
        this.bMM = new View(this.kQM.getFragmentActivity());
        this.bMM.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.kQM.getFragmentActivity(), R.dimen.ds150)));
        this.kQP.addFooterView(this.bMM);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cZe() {
        if (this.kQP != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
            ar arVar = new ar("c13616");
            arVar.ap("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(arVar);
            if (areNotificationsEnabled) {
                if (this.kRq != null) {
                    this.kQP.removeHeaderView(this.kRq.getView());
                    this.kRr = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.brQ().getLong("key_im_open_notification_close_time", 0L);
            if (this.kRr) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kRq == null) {
                    this.kRq = new com.baidu.tieba.imMessageCenter.mention.base.e(this.mContext);
                    this.kRq.a(this.kRs);
                }
                this.kQP.addHeaderView(this.kRq.getView(), 0);
                this.kRr = true;
            }
        }
    }

    private boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kQM.getPageContext(), i);
        }
        if (this.kQS != null) {
            this.kQS.onChangeSkinType(i);
        }
        if (this.kQR != null) {
            this.kQR.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.jbT);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ap.setBackgroundColor(this.jbT, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gCC, R.color.CAM_X0205);
        ap.setViewTextColor(this.kRa, R.color.CAM_X0105);
        ap.setViewTextColor(this.kRe, R.color.CAM_X0105);
        ap.setViewTextColor(this.kRi, R.color.CAM_X0105);
        ap.setViewTextColor(this.kRm, R.color.CAM_X0105);
        ap.setImageResource(this.kQZ, R.drawable.pic_information_at_me);
        ap.setImageResource(this.kRd, R.drawable.pic_information_praise);
        ap.setImageResource(this.kRh, R.drawable.pic_information_reply);
        ap.setImageResource(this.kRl, R.drawable.pic_information_fans);
        if (this.kRb != null) {
            this.kRb.onChangeSkinType();
        }
        if (this.kRf != null) {
            this.kRf.onChangeSkinType();
        }
        if (this.kRj != null) {
            this.kRj.onChangeSkinType();
        }
        if (this.kRn != null) {
            this.kRn.onChangeSkinType();
        }
        if (this.kRq != null) {
            this.kRq.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    protected void onUserChanged(boolean z) {
        al(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.kQU = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.kQT != null && e.this.kQT.isShowing() && e.this.kQM != null) {
                    e.this.kQT.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.kQN.asyncDeleteItem(imMessageCenterShowItemData, e.this.kDq);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.kQM.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.kQT = new com.baidu.tbadk.core.dialog.i(this.kQM.getPageContext());
        this.kQT.a(null, new String[]{string}, this.kQU);
    }

    protected boolean pG(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.kQP.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void tq(boolean z) {
        if (z) {
            if (cZf() && this.kQS.getVisibility() != 0) {
                this.kQS.setVisibility(0);
            }
        } else if (this.kQS.getVisibility() != 8) {
            this.kQS.setVisibility(8);
        }
    }

    public void al(boolean z, boolean z2) {
    }

    public boolean cZf() {
        return this.kQV;
    }

    public void tr(boolean z) {
        this.kQV = z;
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
                if (this.kQN != null) {
                    this.kQN.insertOrUpdate(data, this.kDp);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.kQN != null) {
                this.kQN.remove(data, this.kDp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.kQN != null) {
                this.kQN.setData(data, this.kDp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.kQX = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.kQX != -1) {
                to(true);
                onPrimary();
            }
        }
    }

    public void tm(boolean z) {
        if (z && this.kQP != null && this.kQP.getWrappedAdapter() != null && this.kQP.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.kQP.startPullRefresh();
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
                cZg();
            }
        }
    }

    private void cZg() {
        if (this.kQR != null) {
            this.kQR.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVb() {
        FA();
        if (this.kDm == null) {
            this.kDm = com.baidu.tieba.im.db.e.cVu().gw(getPageContext().getPageActivity());
        }
        this.kDm.show();
        this.kDm.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FA() {
        if (this.kDm != null && this.kDm.isShowing()) {
            this.kDm.dismiss();
            this.kDm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVc() {
        if (this.kQP != null && this.kQN != null) {
            this.kQP.completePullRefreshPostDelayed(0L);
            if (this.kQN.getData() != null) {
                this.kQR.setData(this.kQN.getData());
            } else {
                al(isLogin(), true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar arVar = new ar("c13720");
        arVar.v("uid", TbadkApplication.getCurrentAccountId());
        if (view == this.kQY) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxP();
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgAtme(0);
            this.kRo = 0;
            Du(this.kRo);
            TiebaStatic.log("c12925");
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            arVar.ap("obj_type", 1);
        } else if (view == this.kRc) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxQ();
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().qs(0);
            this.kRp = 0;
            Dx(this.kRp);
            TiebaStatic.log("c12926");
            arVar.ap("obj_type", 2);
        } else if (view == this.kRg) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxO();
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgReplyme(0);
            Dv(0);
        } else if (view == this.kRk) {
            com.baidu.tieba.p.a.dEW().h(2, false, true);
            TiebaStatic.log(new ar("c12523").ap("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxR();
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgFans(0);
            Dw(0);
        }
        TiebaStatic.log(arVar);
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.kRo = newsNotifyMessage.getMsgAtme();
            this.kRp = newsNotifyMessage.getMsgAgree();
            Du(this.kRo);
            Dx(this.kRp);
            Dw(newsNotifyMessage.getMsgFans());
            Dv(newsNotifyMessage.getMsgReplyme());
        }
    }

    private void Du(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byh() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bye().byj()) {
                i = 0;
            }
            this.kRb.setThreeDotMode(2);
            this.kRb.refresh(i);
            this.kRb.setVisibility(0);
            return;
        }
        this.kRb.setVisibility(8);
    }

    private void Dv(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byh() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bye().byl()) {
                i = 0;
            }
            this.kRj.setThreeDotMode(2);
            this.kRj.refresh(i);
            this.kRj.setVisibility(0);
            return;
        }
        this.kRj.setVisibility(8);
    }

    private void Dw(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byh() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bye().byk()) {
                i = 0;
            }
            this.kRn.setThreeDotMode(2);
            this.kRn.refresh(i);
            this.kRn.setVisibility(0);
            return;
        }
        this.kRn.setVisibility(8);
    }

    private void Dx(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byh() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bye().byv()) {
                i = 0;
            }
            this.kRf.setThreeDotMode(2);
            this.kRf.refresh(i);
            this.kRf.setVisibility(0);
            return;
        }
        this.kRf.setVisibility(8);
    }
}
