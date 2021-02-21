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
    private BdSwipeRefreshLayout gCQ;
    private final f.c gHz;
    private boolean isNeedRefresh;
    private RelativeLayout jch;
    private final CustomMessageListener jhV;
    private com.baidu.tbadk.core.dialog.d kDA;
    private final CustomMessageListener kDB;
    private com.baidu.tieba.im.chat.a.a kDD;
    private final com.baidu.tieba.im.chat.a.b kDE;
    private TextView kRA;
    private MessageRedDotView kRB;
    private int kRC;
    private int kRD;
    private com.baidu.tieba.imMessageCenter.mention.base.e kRE;
    private boolean kRF;
    private e.a kRG;
    private final AdapterView.OnItemLongClickListener kRH;
    private final ChatAggregationFragment kRa;
    private ImMessageCenterModel kRb;
    private ImMessageCenterShowItemData kRc;
    private BdListView kRd;
    private NavigationBarShadowView kRe;
    private MessageAggregationListAdapter kRf;
    private ShutDownValidateTipView kRg;
    private com.baidu.tbadk.core.dialog.i kRh;
    private k.c kRi;
    private boolean kRj;
    private boolean kRk;
    private int kRl;
    private View kRm;
    private ImageView kRn;
    private TextView kRo;
    private MessageRedDotView kRp;
    private View kRq;
    private ImageView kRr;
    private TextView kRs;
    private MessageRedDotView kRt;
    private View kRu;
    private ImageView kRv;
    private TextView kRw;
    private MessageRedDotView kRx;
    private View kRy;
    private ImageView kRz;
    private View mHeaderView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) com.baidu.adp.base.j.K(chatAggregationFragment.getPageContext().getPageActivity()));
        this.kRb = null;
        this.kRc = null;
        this.kRd = null;
        this.kRf = null;
        this.kRh = null;
        this.kRj = true;
        this.auP = false;
        this.isNeedRefresh = false;
        this.kRk = true;
        this.kRl = 16;
        this.kRF = false;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.kRe.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.kRe.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.kRe.hide();
                }
            }
        };
        this.gHz = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (e.this.gCQ != null) {
                        e.this.gCQ.setRefreshing(false);
                        return;
                    }
                    return;
                }
                e.this.tn(true);
                e.this.pG(false);
            }
        };
        this.kRG = new e.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.imMessageCenter.mention.base.e.a
            public void onClose() {
                if (e.this.kRE != null) {
                    e.this.kRd.removeHeaderView(e.this.kRE.getView());
                    e.this.kRF = false;
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData CJ = e.this.kRf.getItem(i);
                    TiebaStatic.eventStat(e.this.kRa.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    ar arVar = new ar("c13720");
                    arVar.v("uid", TbadkApplication.getCurrentAccountId());
                    String ownerName = CJ.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(CJ);
                        arVar.ap("obj_type", 6);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kRa.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.kRa.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.kRa.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(CJ.getFriendId(), 0L), CJ.getFriendName(), 0L, "msg_lstb")));
                        } else {
                            return;
                        }
                    } else if (CJ.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kRa.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(CJ);
                            arVar.ap("obj_type", 7);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxX() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxX().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.kRa.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (CJ.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kRa.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(CJ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxX() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxX().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.kRa.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("5")) {
                        TiebaStatic.log("c12931");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarFeedActivityConfig(e.this.kRa.getPageContext().getPageActivity())));
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kRa.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            long j2 = com.baidu.adp.lib.f.b.toLong(CJ.getFriendId(), 0L);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.kRa.getPageContext().getPageActivity(), j2, CJ.getFriendNameShow(), CJ.getFriendPortrait(), 0, CJ.getUserType())));
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.kRa.getPageContext().getPageActivity())));
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
                                com.baidu.tieba.im.db.d.cVA().MJ("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.cVA().MJ("group_intro_change");
                                com.baidu.tieba.im.db.d.cVA().MJ("group_name_change");
                                com.baidu.tieba.im.db.d.cVA().MJ("group_notice_change");
                                com.baidu.tieba.im.db.d.cVA().MJ("group_level_up");
                                com.baidu.tieba.im.db.d.cVA().MJ("dismiss_group");
                                com.baidu.tieba.im.db.d.cVA().MJ("kick_out");
                                com.baidu.tieba.im.db.d.cVA().MJ("group_activitys_change");
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.kRa.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.kRH = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.kRc = e.this.kRf.getItem(i);
                e.this.c(e.this.kRc);
                if (e.this.kRh != null) {
                    TiebaStatic.log("c12932");
                    e.this.kRh.QE();
                    if (e.this.kRa != null && e.this.kRa.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.kRa.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.kDB = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
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
                        e.this.kRb.setData(null, e.this.kDD);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.kRf != null) {
                            e.this.kRf.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.kRf != null) {
                        e.this.kRf.notifyDataSetChanged();
                    }
                }
            }
        };
        this.kDD = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cVj();
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
        this.kDE = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cVi();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.kDA != null) {
                    e.this.kDA.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.FA();
                e.this.kRa.showToast(R.string.delete_success, false);
                e.this.cVj();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.FA();
            }
        };
        this.jhV = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    e.this.b((NewsNotifyMessage) customResponsedMessage);
                }
            }
        };
        this.kRa = chatAggregationFragment;
    }

    public void as(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.kRl = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.kRl = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.kRl);
        }
    }

    public void cKZ() {
        if (this.kRf != null) {
            this.kRf.notifyDataSetChanged();
        }
    }

    public void cJg() {
        MessageManager.getInstance().unRegisterListener(this.kDB);
        MessageManager.getInstance().unRegisterListener(this.fsV);
    }

    public View bVr() {
        this.fhf = 3;
        this.rootView = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        cP(this.rootView);
        TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        cto();
        return this.rootView;
    }

    public Activity getActivity() {
        return this.kRa.getPageContext().getPageActivity();
    }

    protected void cto() {
        this.kRd.startPullRefresh();
        this.auP = isLogin();
        if (!this.auP) {
            al(this.auP, true);
        }
    }

    private void registerListener() {
        this.kRa.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.kDB);
        this.kRa.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.kDB);
        this.kRa.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.kDB);
        this.kRa.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.kDB);
        this.kRa.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.kDB);
        this.kRa.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.kDB);
        this.kRa.registerListener(this.fsV);
        this.kRa.registerListener(this.jhV);
    }

    public void Ut() {
        if (this.gCQ != null && !this.gCQ.isRefreshing()) {
            tn(true);
        }
    }

    public void tn(boolean z) {
        if (this.gCQ != null) {
            if (z && this.kRd != null && this.kRd.getFirstVisiblePosition() != 0) {
                this.kRd.setSelection(0);
            }
            this.gCQ.setRefreshing(z);
        }
    }

    public void to(boolean z) {
        this.isNeedRefresh = z;
    }

    public void tp(boolean z) {
        this.kRk = z;
    }

    public void onPrimary() {
        if (this.kRf != null && this.kRf.getCount() == 0) {
            to(true);
        }
        if (this.kRk || this.isNeedRefresh) {
            this.kRk = false;
            this.isNeedRefresh = false;
            pG(false);
        }
        boolean isLogin = isLogin();
        if (this.auP != isLogin) {
            this.auP = isLogin;
            onUserChanged(this.auP);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kRa.getPageContext());
        }
        cZl();
    }

    private void initData() {
        this.kRb = new ImMessageCenterModel();
        tr(com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void cP(View view) {
        this.jch = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.kRg = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.kRg.setVisibility(8);
        this.kRg.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.tr(false);
                e.this.tq(false);
            }
        });
        this.kRe = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.kRd = (BdListView) view.findViewById(R.id.chat_list_content);
        this.kRd.setDividerHeight(0);
        this.kRf = new MessageAggregationListAdapter(this.kRa.getPageContext().getPageActivity());
        this.kRf.a(this);
        this.kRd.setAdapter((ListAdapter) this.kRf);
        this.kRd.setOnItemClickListener(this.mItemClickListener);
        this.kRd.setOnItemLongClickListener(this.kRH);
        this.kRd.setOnScrollListener(this.mOnScrollListener);
        this.mHeaderView = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
        this.kRm = this.mHeaderView.findViewById(R.id.at_me_layout);
        this.kRn = (ImageView) this.mHeaderView.findViewById(R.id.at_me_icon);
        this.kRo = (TextView) this.mHeaderView.findViewById(R.id.at_me_text);
        this.kRp = (MessageRedDotView) this.mHeaderView.findViewById(R.id.at_me_new_message);
        this.kRq = this.mHeaderView.findViewById(R.id.agree_me_layout);
        this.kRr = (ImageView) this.mHeaderView.findViewById(R.id.agree_me_icon);
        this.kRs = (TextView) this.mHeaderView.findViewById(R.id.agree_me_text);
        this.kRt = (MessageRedDotView) this.mHeaderView.findViewById(R.id.agree_me_new_message);
        this.kRu = this.mHeaderView.findViewById(R.id.reply_me_layout);
        this.kRv = (ImageView) this.mHeaderView.findViewById(R.id.reply_me_icon);
        this.kRw = (TextView) this.mHeaderView.findViewById(R.id.reply_me_text);
        this.kRx = (MessageRedDotView) this.mHeaderView.findViewById(R.id.reply_me_new_message);
        this.kRy = this.mHeaderView.findViewById(R.id.fans_layout);
        this.kRz = (ImageView) this.mHeaderView.findViewById(R.id.fans_icon);
        this.kRA = (TextView) this.mHeaderView.findViewById(R.id.fans_text);
        this.kRB = (MessageRedDotView) this.mHeaderView.findViewById(R.id.fans_new_message);
        this.kRp.setThreeDotMode(2);
        this.kRt.setThreeDotMode(2);
        this.kRx.setThreeDotMode(2);
        this.kRB.setThreeDotMode(2);
        this.kRp.setShadowEnabled(false);
        this.kRt.setShadowEnabled(false);
        this.kRx.setShadowEnabled(false);
        this.kRm.setOnClickListener(this);
        this.kRq.setOnClickListener(this);
        this.kRu.setOnClickListener(this);
        this.kRy.setOnClickListener(this);
        this.kRd.addHeaderView(this.mHeaderView);
        cZl();
        this.gCQ = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kRa.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gHz);
        }
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.gCQ.setProgressView(this.mPullView);
        this.bMM = new View(this.kRa.getFragmentActivity());
        this.bMM.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.kRa.getFragmentActivity(), R.dimen.ds150)));
        this.kRd.addFooterView(this.bMM);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cZl() {
        if (this.kRd != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
            ar arVar = new ar("c13616");
            arVar.ap("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(arVar);
            if (areNotificationsEnabled) {
                if (this.kRE != null) {
                    this.kRd.removeHeaderView(this.kRE.getView());
                    this.kRF = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.brQ().getLong("key_im_open_notification_close_time", 0L);
            if (this.kRF) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kRE == null) {
                    this.kRE = new com.baidu.tieba.imMessageCenter.mention.base.e(this.mContext);
                    this.kRE.a(this.kRG);
                }
                this.kRd.addHeaderView(this.kRE.getView(), 0);
                this.kRF = true;
            }
        }
    }

    private boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kRa.getPageContext(), i);
        }
        if (this.kRg != null) {
            this.kRg.onChangeSkinType(i);
        }
        if (this.kRf != null) {
            this.kRf.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.jch);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ap.setBackgroundColor(this.jch, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gCQ, R.color.CAM_X0205);
        ap.setViewTextColor(this.kRo, R.color.CAM_X0105);
        ap.setViewTextColor(this.kRs, R.color.CAM_X0105);
        ap.setViewTextColor(this.kRw, R.color.CAM_X0105);
        ap.setViewTextColor(this.kRA, R.color.CAM_X0105);
        ap.setImageResource(this.kRn, R.drawable.pic_information_at_me);
        ap.setImageResource(this.kRr, R.drawable.pic_information_praise);
        ap.setImageResource(this.kRv, R.drawable.pic_information_reply);
        ap.setImageResource(this.kRz, R.drawable.pic_information_fans);
        if (this.kRp != null) {
            this.kRp.onChangeSkinType();
        }
        if (this.kRt != null) {
            this.kRt.onChangeSkinType();
        }
        if (this.kRx != null) {
            this.kRx.onChangeSkinType();
        }
        if (this.kRB != null) {
            this.kRB.onChangeSkinType();
        }
        if (this.kRE != null) {
            this.kRE.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    protected void onUserChanged(boolean z) {
        al(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.kRi = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.kRh != null && e.this.kRh.isShowing() && e.this.kRa != null) {
                    e.this.kRh.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.kRb.asyncDeleteItem(imMessageCenterShowItemData, e.this.kDE);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.kRa.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.kRh = new com.baidu.tbadk.core.dialog.i(this.kRa.getPageContext());
        this.kRh.a(null, new String[]{string}, this.kRi);
    }

    protected boolean pG(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.kRd.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void tq(boolean z) {
        if (z) {
            if (cZm() && this.kRg.getVisibility() != 0) {
                this.kRg.setVisibility(0);
            }
        } else if (this.kRg.getVisibility() != 8) {
            this.kRg.setVisibility(8);
        }
    }

    public void al(boolean z, boolean z2) {
    }

    public boolean cZm() {
        return this.kRj;
    }

    public void tr(boolean z) {
        this.kRj = z;
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
                if (this.kRb != null) {
                    this.kRb.insertOrUpdate(data, this.kDD);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.kRb != null) {
                this.kRb.remove(data, this.kDD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.kRb != null) {
                this.kRb.setData(data, this.kDD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.kRl = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.kRl != -1) {
                to(true);
                onPrimary();
            }
        }
    }

    public void tm(boolean z) {
        if (z && this.kRd != null && this.kRd.getWrappedAdapter() != null && this.kRd.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.kRd.startPullRefresh();
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
                cZn();
            }
        }
    }

    private void cZn() {
        if (this.kRf != null) {
            this.kRf.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVi() {
        FA();
        if (this.kDA == null) {
            this.kDA = com.baidu.tieba.im.db.e.cVB().gw(getPageContext().getPageActivity());
        }
        this.kDA.show();
        this.kDA.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FA() {
        if (this.kDA != null && this.kDA.isShowing()) {
            this.kDA.dismiss();
            this.kDA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVj() {
        if (this.kRd != null && this.kRb != null) {
            this.kRd.completePullRefreshPostDelayed(0L);
            if (this.kRb.getData() != null) {
                this.kRf.setData(this.kRb.getData());
            } else {
                al(isLogin(), true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar arVar = new ar("c13720");
        arVar.v("uid", TbadkApplication.getCurrentAccountId());
        if (view == this.kRm) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxP();
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgAtme(0);
            this.kRC = 0;
            Du(this.kRC);
            TiebaStatic.log("c12925");
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            arVar.ap("obj_type", 1);
        } else if (view == this.kRq) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxQ();
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().qs(0);
            this.kRD = 0;
            Dx(this.kRD);
            TiebaStatic.log("c12926");
            arVar.ap("obj_type", 2);
        } else if (view == this.kRu) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxO();
            com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgReplyme(0);
            Dv(0);
        } else if (view == this.kRy) {
            com.baidu.tieba.p.a.dFe().h(2, false, true);
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
            this.kRC = newsNotifyMessage.getMsgAtme();
            this.kRD = newsNotifyMessage.getMsgAgree();
            Du(this.kRC);
            Dx(this.kRD);
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
            this.kRp.setThreeDotMode(2);
            this.kRp.refresh(i);
            this.kRp.setVisibility(0);
            return;
        }
        this.kRp.setVisibility(8);
    }

    private void Dv(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byh() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bye().byl()) {
                i = 0;
            }
            this.kRx.setThreeDotMode(2);
            this.kRx.refresh(i);
            this.kRx.setVisibility(0);
            return;
        }
        this.kRx.setVisibility(8);
    }

    private void Dw(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byh() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bye().byk()) {
                i = 0;
            }
            this.kRB.setThreeDotMode(2);
            this.kRB.refresh(i);
            this.kRB.setVisibility(0);
            return;
        }
        this.kRB.setVisibility(8);
    }

    private void Dx(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byh() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bye().byv()) {
                i = 0;
            }
            this.kRt.setThreeDotMode(2);
            this.kRt.refresh(i);
            this.kRt.setVisibility(0);
            return;
        }
        this.kRt.setVisibility(8);
    }
}
