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
    private boolean awp;
    private View bOm;
    private int fiH;
    private final CustomMessageListener fuv;
    private BdSwipeRefreshLayout gEz;
    private final f.c gJi;
    private boolean isNeedRefresh;
    private RelativeLayout jdQ;
    private final CustomMessageListener jjF;
    private com.baidu.tbadk.core.dialog.d kFC;
    private final CustomMessageListener kFD;
    private com.baidu.tieba.im.chat.a.a kFF;
    private final com.baidu.tieba.im.chat.a.b kFG;
    private View kTA;
    private ImageView kTB;
    private TextView kTC;
    private MessageRedDotView kTD;
    private int kTE;
    private int kTF;
    private com.baidu.tieba.imMessageCenter.mention.base.e kTG;
    private boolean kTH;
    private e.a kTI;
    private final AdapterView.OnItemLongClickListener kTJ;
    private final ChatAggregationFragment kTc;
    private ImMessageCenterModel kTd;
    private ImMessageCenterShowItemData kTe;
    private BdListView kTf;
    private NavigationBarShadowView kTg;
    private MessageAggregationListAdapter kTh;
    private ShutDownValidateTipView kTi;
    private com.baidu.tbadk.core.dialog.i kTj;
    private k.c kTk;
    private boolean kTl;
    private boolean kTm;
    private int kTn;
    private View kTo;
    private ImageView kTp;
    private TextView kTq;
    private MessageRedDotView kTr;
    private View kTs;
    private ImageView kTt;
    private TextView kTu;
    private MessageRedDotView kTv;
    private View kTw;
    private ImageView kTx;
    private TextView kTy;
    private MessageRedDotView kTz;
    private View mHeaderView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) com.baidu.adp.base.j.J(chatAggregationFragment.getPageContext().getPageActivity()));
        this.kTd = null;
        this.kTe = null;
        this.kTf = null;
        this.kTh = null;
        this.kTj = null;
        this.kTl = true;
        this.awp = false;
        this.isNeedRefresh = false;
        this.kTm = true;
        this.kTn = 16;
        this.kTH = false;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.kTg.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.kTg.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.kTg.hide();
                }
            }
        };
        this.gJi = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (e.this.gEz != null) {
                        e.this.gEz.setRefreshing(false);
                        return;
                    }
                    return;
                }
                e.this.tn(true);
                e.this.pG(false);
            }
        };
        this.kTI = new e.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.imMessageCenter.mention.base.e.a
            public void onClose() {
                if (e.this.kTG != null) {
                    e.this.kTf.removeHeaderView(e.this.kTG.getView());
                    e.this.kTH = false;
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData CM = e.this.kTh.getItem(i);
                    TiebaStatic.eventStat(e.this.kTc.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    ar arVar = new ar("c13720");
                    arVar.v("uid", TbadkApplication.getCurrentAccountId());
                    String ownerName = CM.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(CM);
                        arVar.aq("obj_type", 6);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kTc.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.kTc.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.kTc.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(CM.getFriendId(), 0L), CM.getFriendName(), 0L, "msg_lstb")));
                        } else {
                            return;
                        }
                    } else if (CM.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kTc.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(CM);
                            arVar.aq("obj_type", 7);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bxE().bya() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bxE().bya().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.kTc.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (CM.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kTc.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(CM);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bxE().bya() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bxE().bya().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.kTc.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("5")) {
                        TiebaStatic.log("c12931");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarFeedActivityConfig(e.this.kTc.getPageContext().getPageActivity())));
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kTc.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            long j2 = com.baidu.adp.lib.f.b.toLong(CM.getFriendId(), 0L);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.kTc.getPageContext().getPageActivity(), j2, CM.getFriendNameShow(), CM.getFriendPortrait(), 0, CM.getUserType())));
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.kTc.getPageContext().getPageActivity())));
                        arVar.aq("obj_type", 6);
                        return;
                    } else {
                        e(CM);
                        arVar.aq("obj_type", 6);
                    }
                    if (!TextUtils.isEmpty(CM.getFriendName())) {
                        if ("贴吧热榜".equals(CM.getFriendName())) {
                            arVar.aq("obj_type", 8);
                        } else if ("贴吧荣誉墙".equals(CM.getFriendName())) {
                            arVar.aq("obj_type", 9);
                        } else if ("贴吧精选".equals(CM.getFriendName())) {
                            arVar.aq("obj_type", 10);
                        } else if ("贴吧活动".equals(CM.getFriendName())) {
                            arVar.aq("obj_type", 4);
                        } else if ("吧广播".equals(CM.getFriendName())) {
                            arVar.aq("obj_type", 5);
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
                                com.baidu.tieba.im.db.d.cVH().MP("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.cVH().MP("group_intro_change");
                                com.baidu.tieba.im.db.d.cVH().MP("group_name_change");
                                com.baidu.tieba.im.db.d.cVH().MP("group_notice_change");
                                com.baidu.tieba.im.db.d.cVH().MP("group_level_up");
                                com.baidu.tieba.im.db.d.cVH().MP("dismiss_group");
                                com.baidu.tieba.im.db.d.cVH().MP("kick_out");
                                com.baidu.tieba.im.db.d.cVH().MP("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.bxE().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.kTc.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.kTJ = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.kTe = e.this.kTh.getItem(i);
                e.this.c(e.this.kTe);
                if (e.this.kTj != null) {
                    TiebaStatic.log("c12932");
                    e.this.kTj.QH();
                    if (e.this.kTc != null && e.this.kTc.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.kTc.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.kFD = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
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
                        e.this.kTd.setData(null, e.this.kFF);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.kTh != null) {
                            e.this.kTh.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.kTh != null) {
                        e.this.kTh.notifyDataSetChanged();
                    }
                }
            }
        };
        this.kFF = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cVq();
            }
        };
        this.fuv = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.kFG = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cVp();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.kFC != null) {
                    e.this.kFC.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.FD();
                e.this.kTc.showToast(R.string.delete_success, false);
                e.this.cVq();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.FD();
            }
        };
        this.jjF = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    e.this.b((NewsNotifyMessage) customResponsedMessage);
                }
            }
        };
        this.kTc = chatAggregationFragment;
    }

    public void as(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.kTn = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.kTn = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.kTn);
        }
    }

    public void cLf() {
        if (this.kTh != null) {
            this.kTh.notifyDataSetChanged();
        }
    }

    public void cJm() {
        MessageManager.getInstance().unRegisterListener(this.kFD);
        MessageManager.getInstance().unRegisterListener(this.fuv);
    }

    public View bVx() {
        this.fiH = 3;
        this.rootView = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        cP(this.rootView);
        TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        ctu();
        return this.rootView;
    }

    public Activity getActivity() {
        return this.kTc.getPageContext().getPageActivity();
    }

    protected void ctu() {
        this.kTf.startPullRefresh();
        this.awp = isLogin();
        if (!this.awp) {
            al(this.awp, true);
        }
    }

    private void registerListener() {
        this.kTc.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.kFD);
        this.kTc.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.kFD);
        this.kTc.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.kFD);
        this.kTc.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.kFD);
        this.kTc.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.kFD);
        this.kTc.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.kFD);
        this.kTc.registerListener(this.fuv);
        this.kTc.registerListener(this.jjF);
    }

    public void Uw() {
        if (this.gEz != null && !this.gEz.isRefreshing()) {
            tn(true);
        }
    }

    public void tn(boolean z) {
        if (this.gEz != null) {
            if (z && this.kTf != null && this.kTf.getFirstVisiblePosition() != 0) {
                this.kTf.setSelection(0);
            }
            this.gEz.setRefreshing(z);
        }
    }

    public void to(boolean z) {
        this.isNeedRefresh = z;
    }

    public void tp(boolean z) {
        this.kTm = z;
    }

    public void onPrimary() {
        if (this.kTh != null && this.kTh.getCount() == 0) {
            to(true);
        }
        if (this.kTm || this.isNeedRefresh) {
            this.kTm = false;
            this.isNeedRefresh = false;
            pG(false);
        }
        boolean isLogin = isLogin();
        if (this.awp != isLogin) {
            this.awp = isLogin;
            onUserChanged(this.awp);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kTc.getPageContext());
        }
        cZs();
    }

    private void initData() {
        this.kTd = new ImMessageCenterModel();
        tr(com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void cP(View view) {
        this.jdQ = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.kTi = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.kTi.setVisibility(8);
        this.kTi.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.tr(false);
                e.this.tq(false);
            }
        });
        this.kTg = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.kTf = (BdListView) view.findViewById(R.id.chat_list_content);
        this.kTf.setDividerHeight(0);
        this.kTh = new MessageAggregationListAdapter(this.kTc.getPageContext().getPageActivity());
        this.kTh.a(this);
        this.kTf.setAdapter((ListAdapter) this.kTh);
        this.kTf.setOnItemClickListener(this.mItemClickListener);
        this.kTf.setOnItemLongClickListener(this.kTJ);
        this.kTf.setOnScrollListener(this.mOnScrollListener);
        this.mHeaderView = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
        this.kTo = this.mHeaderView.findViewById(R.id.at_me_layout);
        this.kTp = (ImageView) this.mHeaderView.findViewById(R.id.at_me_icon);
        this.kTq = (TextView) this.mHeaderView.findViewById(R.id.at_me_text);
        this.kTr = (MessageRedDotView) this.mHeaderView.findViewById(R.id.at_me_new_message);
        this.kTs = this.mHeaderView.findViewById(R.id.agree_me_layout);
        this.kTt = (ImageView) this.mHeaderView.findViewById(R.id.agree_me_icon);
        this.kTu = (TextView) this.mHeaderView.findViewById(R.id.agree_me_text);
        this.kTv = (MessageRedDotView) this.mHeaderView.findViewById(R.id.agree_me_new_message);
        this.kTw = this.mHeaderView.findViewById(R.id.reply_me_layout);
        this.kTx = (ImageView) this.mHeaderView.findViewById(R.id.reply_me_icon);
        this.kTy = (TextView) this.mHeaderView.findViewById(R.id.reply_me_text);
        this.kTz = (MessageRedDotView) this.mHeaderView.findViewById(R.id.reply_me_new_message);
        this.kTA = this.mHeaderView.findViewById(R.id.fans_layout);
        this.kTB = (ImageView) this.mHeaderView.findViewById(R.id.fans_icon);
        this.kTC = (TextView) this.mHeaderView.findViewById(R.id.fans_text);
        this.kTD = (MessageRedDotView) this.mHeaderView.findViewById(R.id.fans_new_message);
        this.kTr.setThreeDotMode(2);
        this.kTv.setThreeDotMode(2);
        this.kTz.setThreeDotMode(2);
        this.kTD.setThreeDotMode(2);
        this.kTr.setShadowEnabled(false);
        this.kTv.setShadowEnabled(false);
        this.kTz.setShadowEnabled(false);
        this.kTo.setOnClickListener(this);
        this.kTs.setOnClickListener(this);
        this.kTw.setOnClickListener(this);
        this.kTA.setOnClickListener(this);
        this.kTf.addHeaderView(this.mHeaderView);
        cZs();
        this.gEz = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kTc.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gJi);
        }
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.gEz.setProgressView(this.mPullView);
        this.bOm = new View(this.kTc.getFragmentActivity());
        this.bOm.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.kTc.getFragmentActivity(), R.dimen.ds150)));
        this.kTf.addFooterView(this.bOm);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cZs() {
        if (this.kTf != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
            ar arVar = new ar("c13616");
            arVar.aq("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(arVar);
            if (areNotificationsEnabled) {
                if (this.kTG != null) {
                    this.kTf.removeHeaderView(this.kTG.getView());
                    this.kTH = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.brR().getLong("key_im_open_notification_close_time", 0L);
            if (this.kTH) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kTG == null) {
                    this.kTG = new com.baidu.tieba.imMessageCenter.mention.base.e(this.mContext);
                    this.kTG.a(this.kTI);
                }
                this.kTf.addHeaderView(this.kTG.getView(), 0);
                this.kTH = true;
            }
        }
    }

    private boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kTc.getPageContext(), i);
        }
        if (this.kTi != null) {
            this.kTi.onChangeSkinType(i);
        }
        if (this.kTh != null) {
            this.kTh.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.jdQ);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ap.setBackgroundColor(this.jdQ, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gEz, R.color.CAM_X0205);
        ap.setViewTextColor(this.kTq, R.color.CAM_X0105);
        ap.setViewTextColor(this.kTu, R.color.CAM_X0105);
        ap.setViewTextColor(this.kTy, R.color.CAM_X0105);
        ap.setViewTextColor(this.kTC, R.color.CAM_X0105);
        ap.setImageResource(this.kTp, R.drawable.pic_information_at_me);
        ap.setImageResource(this.kTt, R.drawable.pic_information_praise);
        ap.setImageResource(this.kTx, R.drawable.pic_information_reply);
        ap.setImageResource(this.kTB, R.drawable.pic_information_fans);
        if (this.kTr != null) {
            this.kTr.onChangeSkinType();
        }
        if (this.kTv != null) {
            this.kTv.onChangeSkinType();
        }
        if (this.kTz != null) {
            this.kTz.onChangeSkinType();
        }
        if (this.kTD != null) {
            this.kTD.onChangeSkinType();
        }
        if (this.kTG != null) {
            this.kTG.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    protected void onUserChanged(boolean z) {
        al(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.kTk = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.kTj != null && e.this.kTj.isShowing() && e.this.kTc != null) {
                    e.this.kTj.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.kTd.asyncDeleteItem(imMessageCenterShowItemData, e.this.kFG);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.kTc.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.kTj = new com.baidu.tbadk.core.dialog.i(this.kTc.getPageContext());
        this.kTj.a(null, new String[]{string}, this.kTk);
    }

    protected boolean pG(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.kTf.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void tq(boolean z) {
        if (z) {
            if (cZt() && this.kTi.getVisibility() != 0) {
                this.kTi.setVisibility(0);
            }
        } else if (this.kTi.getVisibility() != 8) {
            this.kTi.setVisibility(8);
        }
    }

    public void al(boolean z, boolean z2) {
    }

    public boolean cZt() {
        return this.kTl;
    }

    public void tr(boolean z) {
        this.kTl = z;
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
                if (this.kTd != null) {
                    this.kTd.insertOrUpdate(data, this.kFF);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.kTd != null) {
                this.kTd.remove(data, this.kFF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.kTd != null) {
                this.kTd.setData(data, this.kFF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.kTn = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.kTn != -1) {
                to(true);
                onPrimary();
            }
        }
    }

    public void tm(boolean z) {
        if (z && this.kTf != null && this.kTf.getWrappedAdapter() != null && this.kTf.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.kTf.startPullRefresh();
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
                cZu();
            }
        }
    }

    private void cZu() {
        if (this.kTh != null) {
            this.kTh.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVp() {
        FD();
        if (this.kFC == null) {
            this.kFC = com.baidu.tieba.im.db.e.cVI().gv(getPageContext().getPageActivity());
        }
        this.kFC.show();
        this.kFC.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FD() {
        if (this.kFC != null && this.kFC.isShowing()) {
            this.kFC.dismiss();
            this.kFC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVq() {
        if (this.kTf != null && this.kTd != null) {
            this.kTf.completePullRefreshPostDelayed(0L);
            if (this.kTd.getData() != null) {
                this.kTh.setData(this.kTd.getData());
            } else {
                al(isLogin(), true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar arVar = new ar("c13720");
        arVar.v("uid", TbadkApplication.getCurrentAccountId());
        if (view == this.kTo) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bxE().bxS();
            com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgAtme(0);
            this.kTE = 0;
            Dx(this.kTE);
            TiebaStatic.log("c12925");
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            arVar.aq("obj_type", 1);
        } else if (view == this.kTs) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bxE().bxT();
            com.baidu.tbadk.coreExtra.messageCenter.b.bxE().qt(0);
            this.kTF = 0;
            DA(this.kTF);
            TiebaStatic.log("c12926");
            arVar.aq("obj_type", 2);
        } else if (view == this.kTw) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bxE().bxR();
            com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgReplyme(0);
            Dy(0);
        } else if (view == this.kTA) {
            com.baidu.tieba.p.a.dFm().h(2, false, true);
            TiebaStatic.log(new ar("c12523").aq("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
            com.baidu.tbadk.coreExtra.messageCenter.b.bxE().bxU();
            com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgFans(0);
            Dz(0);
        }
        TiebaStatic.log(arVar);
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.kTE = newsNotifyMessage.getMsgAtme();
            this.kTF = newsNotifyMessage.getMsgAgree();
            Dx(this.kTE);
            DA(this.kTF);
            Dz(newsNotifyMessage.getMsgFans());
            Dy(newsNotifyMessage.getMsgReplyme());
        }
    }

    private void Dx(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.byh().byk() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.byh().bym()) {
                i = 0;
            }
            this.kTr.setThreeDotMode(2);
            this.kTr.refresh(i);
            this.kTr.setVisibility(0);
            return;
        }
        this.kTr.setVisibility(8);
    }

    private void Dy(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.byh().byk() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.byh().byo()) {
                i = 0;
            }
            this.kTz.setThreeDotMode(2);
            this.kTz.refresh(i);
            this.kTz.setVisibility(0);
            return;
        }
        this.kTz.setVisibility(8);
    }

    private void Dz(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.byh().byk() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.byh().byn()) {
                i = 0;
            }
            this.kTD.setThreeDotMode(2);
            this.kTD.refresh(i);
            this.kTD.setVisibility(0);
            return;
        }
        this.kTD.setVisibility(8);
    }

    private void DA(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.byh().byk() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.byh().byy()) {
                i = 0;
            }
            this.kTv.setThreeDotMode(2);
            this.kTv.refresh(i);
            this.kTv.setVisibility(0);
            return;
        }
        this.kTv.setVisibility(8);
    }
}
