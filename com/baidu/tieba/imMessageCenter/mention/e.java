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
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements View.OnClickListener, f.c {
    private View bxe;
    private int eFo;
    private final CustomMessageListener eQI;
    private BdSwipeRefreshLayout fVP;
    private boolean feY;
    private final f.c gav;
    private final CustomMessageListener iqv;
    private boolean isNeedRefresh;
    private com.baidu.tbadk.core.dialog.d jGt;
    private final CustomMessageListener jGu;
    private com.baidu.tieba.im.chat.a.a jGw;
    private final com.baidu.tieba.im.chat.a.b jGx;
    private final ChatAggregationFragment kbE;
    private ImMessageCenterModel kbF;
    private ImMessageCenterShowItemData kbG;
    private BdListView kbH;
    private NavigationBarShadowView kbI;
    private MessageAggregationListAdapter kbJ;
    private ShutDownValidateTipView kbK;
    private com.baidu.tbadk.core.dialog.i kbL;
    private k.c kbM;
    private boolean kbN;
    private boolean kbO;
    private int kbP;
    private View kbQ;
    private ImageView kbR;
    private TextView kbS;
    private MessageRedDotView kbT;
    private View kbU;
    private ImageView kbV;
    private TextView kbW;
    private MessageRedDotView kbX;
    private View kbY;
    private ImageView kbZ;
    private TextView kca;
    private MessageRedDotView kcb;
    private View kcc;
    private ImageView kcd;
    private TextView kce;
    private MessageRedDotView kcf;
    private int kcg;
    private int kch;
    private com.baidu.tieba.imMessageCenter.mention.base.f kci;
    private boolean kcj;
    private f.a kck;
    private final AdapterView.OnItemLongClickListener kcl;
    private View mHeaderView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) com.baidu.adp.base.i.I(chatAggregationFragment.getPageContext().getPageActivity()));
        this.kbF = null;
        this.kbG = null;
        this.kbH = null;
        this.kbJ = null;
        this.kbL = null;
        this.kbN = true;
        this.feY = false;
        this.isNeedRefresh = false;
        this.kbO = true;
        this.kbP = 16;
        this.kcj = false;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.kbI.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.kbI.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.kbI.hide();
                }
            }
        };
        this.gav = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (e.this.fVP != null) {
                        e.this.fVP.setRefreshing(false);
                        return;
                    }
                    return;
                }
                e.this.rX(true);
                e.this.oc(false);
            }
        };
        this.kck = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (e.this.kci != null) {
                    e.this.kbH.removeHeaderView(e.this.kci.getView());
                    e.this.kcj = false;
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData BT = e.this.kbJ.getItem(i);
                    TiebaStatic.eventStat(e.this.kbE.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    aq aqVar = new aq("c13720");
                    aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                    String ownerName = BT.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(BT);
                        aqVar.aj("obj_type", 6);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kbE.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.kbE.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.kbE.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(BT.getFriendId(), 0L), BT.getFriendName(), 0L, "msg_lstb")));
                        } else {
                            return;
                        }
                    } else if (BT.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kbE.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(BT);
                            aqVar.aj("obj_type", 7);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.brz().brV() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.brz().brV().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.kbE.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (BT.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kbE.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(BT);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.brz().brV() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.brz().brV().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.kbE.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("5")) {
                        TiebaStatic.log("c12931");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarFeedActivityConfig(e.this.kbE.getPageContext().getPageActivity())));
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kbE.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.kbE.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(BT.getFriendId(), 0L), BT.getFriendNameShow(), BT.getFriendPortrait(), 0, BT.getUserType())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new aq("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.kbE.getPageContext().getPageActivity())));
                        aqVar.aj("obj_type", 6);
                        return;
                    } else {
                        e(BT);
                        aqVar.aj("obj_type", 6);
                    }
                    if (!TextUtils.isEmpty(BT.getFriendName())) {
                        if ("贴吧热榜".equals(BT.getFriendName())) {
                            aqVar.aj("obj_type", 8);
                        } else if ("贴吧荣誉墙".equals(BT.getFriendName())) {
                            aqVar.aj("obj_type", 9);
                        } else if ("贴吧精选".equals(BT.getFriendName())) {
                            aqVar.aj("obj_type", 10);
                        } else if ("贴吧活动".equals(BT.getFriendName())) {
                            aqVar.aj("obj_type", 4);
                        } else if ("吧广播".equals(BT.getFriendName())) {
                            aqVar.aj("obj_type", 5);
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
                                com.baidu.tieba.im.db.d.cLn().LK("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.cLn().LK("group_intro_change");
                                com.baidu.tieba.im.db.d.cLn().LK("group_name_change");
                                com.baidu.tieba.im.db.d.cLn().LK("group_notice_change");
                                com.baidu.tieba.im.db.d.cLn().LK("group_level_up");
                                com.baidu.tieba.im.db.d.cLn().LK("dismiss_group");
                                com.baidu.tieba.im.db.d.cLn().LK("kick_out");
                                com.baidu.tieba.im.db.d.cLn().LK("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.brz().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.brz().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.kbE.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.kcl = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.kbG = e.this.kbJ.getItem(i);
                e.this.c(e.this.kbG);
                if (e.this.kbL != null) {
                    TiebaStatic.log("c12932");
                    e.this.kbL.Pd();
                    if (e.this.kbE != null && e.this.kbE.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.kbE.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.jGu = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
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
                        e.this.rX(false);
                    } else if (customResponsedMessage.getCmd() == 2016001) {
                        e.this.kbF.setData(null, e.this.jGw);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.kbJ != null) {
                            e.this.kbJ.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.kbJ != null) {
                        e.this.kbJ.notifyDataSetChanged();
                    }
                }
            }
        };
        this.jGw = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cJG();
            }
        };
        this.eQI = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.jGx = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cJF();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.jGt != null) {
                    e.this.jGt.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.Gz();
                e.this.kbE.showToast(R.string.delete_success, false);
                e.this.cJG();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.Gz();
            }
        };
        this.iqv = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    e.this.b((NewsNotifyMessage) customResponsedMessage);
                }
            }
        };
        this.kbE = chatAggregationFragment;
    }

    public void aq(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.kbP = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.kbP = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.kbP);
        }
    }

    public void czT() {
        if (this.kbJ != null) {
            this.kbJ.notifyDataSetChanged();
        }
    }

    public void cyd() {
        MessageManager.getInstance().unRegisterListener(this.jGu);
        MessageManager.getInstance().unRegisterListener(this.eQI);
    }

    public View bNy() {
        this.eFo = 3;
        this.rootView = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        cn(this.rootView);
        TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        cjw();
        return this.rootView;
    }

    public Activity getActivity() {
        return this.kbE.getPageContext().getPageActivity();
    }

    protected void cjw() {
        this.kbH.startPullRefresh();
        this.feY = isLogin();
        if (!this.feY) {
            ag(this.feY, true);
        }
    }

    private void registerListener() {
        this.kbE.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.jGu);
        this.kbE.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.jGu);
        this.kbE.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.jGu);
        this.kbE.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.jGu);
        this.kbE.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.jGu);
        this.kbE.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.jGu);
        this.kbE.registerListener(this.eQI);
        this.kbE.registerListener(this.iqv);
    }

    public void Qi() {
        if (this.fVP != null && !this.fVP.isRefreshing()) {
            rX(true);
        }
    }

    public void rX(boolean z) {
        if (this.fVP != null) {
            if (z && this.kbH != null && this.kbH.getFirstVisiblePosition() != 0) {
                this.kbH.setSelection(0);
            }
            this.fVP.setRefreshing(z);
        }
    }

    public void rY(boolean z) {
        this.isNeedRefresh = z;
    }

    public void rZ(boolean z) {
        this.kbO = z;
    }

    public void onPrimary() {
        if (this.kbJ != null && this.kbJ.getCount() == 0) {
            rY(true);
        }
        if (this.kbO || this.isNeedRefresh) {
            this.kbO = false;
            this.isNeedRefresh = false;
            oc(false);
        }
        boolean isLogin = isLogin();
        if (this.feY != isLogin) {
            this.feY = isLogin;
            onUserChanged(this.feY);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kbE.getPageContext());
        }
        cQT();
    }

    private void initData() {
        this.kbF = new ImMessageCenterModel();
        sb(com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void cn(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.kbK = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.kbK.setVisibility(8);
        this.kbK.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.sb(false);
                e.this.sa(false);
            }
        });
        this.kbI = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.kbH = (BdListView) view.findViewById(R.id.chat_list_content);
        this.kbH.setDividerHeight(0);
        this.kbJ = new MessageAggregationListAdapter(this.kbE.getPageContext().getPageActivity());
        this.kbJ.a(this);
        this.kbH.setAdapter((ListAdapter) this.kbJ);
        this.kbH.setOnItemClickListener(this.mItemClickListener);
        this.kbH.setOnItemLongClickListener(this.kcl);
        this.kbH.setOnScrollListener(this.mOnScrollListener);
        this.mHeaderView = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
        this.kbQ = this.mHeaderView.findViewById(R.id.at_me_layout);
        this.kbR = (ImageView) this.mHeaderView.findViewById(R.id.at_me_icon);
        this.kbS = (TextView) this.mHeaderView.findViewById(R.id.at_me_text);
        this.kbT = (MessageRedDotView) this.mHeaderView.findViewById(R.id.at_me_new_message);
        this.kbU = this.mHeaderView.findViewById(R.id.agree_me_layout);
        this.kbV = (ImageView) this.mHeaderView.findViewById(R.id.agree_me_icon);
        this.kbW = (TextView) this.mHeaderView.findViewById(R.id.agree_me_text);
        this.kbX = (MessageRedDotView) this.mHeaderView.findViewById(R.id.agree_me_new_message);
        this.kbY = this.mHeaderView.findViewById(R.id.reply_me_layout);
        this.kbZ = (ImageView) this.mHeaderView.findViewById(R.id.reply_me_icon);
        this.kca = (TextView) this.mHeaderView.findViewById(R.id.reply_me_text);
        this.kcb = (MessageRedDotView) this.mHeaderView.findViewById(R.id.reply_me_new_message);
        this.kcc = this.mHeaderView.findViewById(R.id.fans_layout);
        this.kcd = (ImageView) this.mHeaderView.findViewById(R.id.fans_icon);
        this.kce = (TextView) this.mHeaderView.findViewById(R.id.fans_text);
        this.kcf = (MessageRedDotView) this.mHeaderView.findViewById(R.id.fans_new_message);
        this.kbT.setThreeDotMode(2);
        this.kbX.setThreeDotMode(2);
        this.kcb.setThreeDotMode(2);
        this.kcf.setThreeDotMode(2);
        this.kbT.setShadowEnabled(false);
        this.kbX.setShadowEnabled(false);
        this.kcb.setShadowEnabled(false);
        this.kbQ.setOnClickListener(this);
        this.kbU.setOnClickListener(this);
        this.kbY.setOnClickListener(this);
        this.kcc.setOnClickListener(this);
        this.kbH.addHeaderView(this.mHeaderView);
        cQT();
        this.fVP = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kbE.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gav);
        }
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.fVP.setProgressView(this.mPullView);
        this.bxe = new View(this.kbE.getFragmentActivity());
        this.bxe.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.kbE.getFragmentActivity(), R.dimen.ds150)));
        this.kbH.addFooterView(this.bxe);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cQT() {
        if (this.kbH != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
            aq aqVar = new aq("c13616");
            aqVar.aj("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aqVar);
            if (areNotificationsEnabled) {
                if (this.kci != null) {
                    this.kbH.removeHeaderView(this.kci.getView());
                    this.kcj = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.blO().getLong("key_im_open_notification_close_time", 0L);
            if (this.kcj) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kci == null) {
                    this.kci = new com.baidu.tieba.imMessageCenter.mention.base.f(this.mContext);
                    this.kci.a(this.kck);
                }
                this.kbH.addHeaderView(this.kci.getView(), 0);
                this.kcj = true;
            }
        }
    }

    private boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kbE.getPageContext(), i);
        }
        if (this.kbK != null) {
            this.kbK.onChangeSkinType(i);
        }
        if (this.kbJ != null) {
            this.kbJ.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.fVP, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.kbS, R.color.cp_cont_b);
        ap.setViewTextColor(this.kbW, R.color.cp_cont_b);
        ap.setViewTextColor(this.kca, R.color.cp_cont_b);
        ap.setViewTextColor(this.kce, R.color.cp_cont_b);
        ap.setImageResource(this.kbR, R.drawable.pic_information_at_me);
        ap.setImageResource(this.kbV, R.drawable.pic_information_praise);
        ap.setImageResource(this.kbZ, R.drawable.pic_information_reply);
        ap.setImageResource(this.kcd, R.drawable.pic_information_fans);
        if (this.kbT != null) {
            this.kbT.onChangeSkinType();
        }
        if (this.kbX != null) {
            this.kbX.onChangeSkinType();
        }
        if (this.kcb != null) {
            this.kcb.onChangeSkinType();
        }
        if (this.kcf != null) {
            this.kcf.onChangeSkinType();
        }
        if (this.kci != null) {
            this.kci.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    protected void onUserChanged(boolean z) {
        ag(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.kbM = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.kbL != null && e.this.kbL.isShowing() && e.this.kbE != null) {
                    e.this.kbL.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.kbF.asyncDeleteItem(imMessageCenterShowItemData, e.this.jGx);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.kbE.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.kbL = new com.baidu.tbadk.core.dialog.i(this.kbE.getPageContext());
        this.kbL.a(null, new String[]{string}, this.kbM);
    }

    protected boolean oc(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.kbH.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void sa(boolean z) {
        if (z) {
            if (cQU() && this.kbK.getVisibility() != 0) {
                this.kbK.setVisibility(0);
            }
        } else if (this.kbK.getVisibility() != 8) {
            this.kbK.setVisibility(8);
        }
    }

    public void ag(boolean z, boolean z2) {
    }

    public boolean cQU() {
        return this.kbN;
    }

    public void sb(boolean z) {
        this.kbN = z;
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
                if (this.kbF != null) {
                    this.kbF.insertOrUpdate(data, this.jGw);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.kbF != null) {
                this.kbF.remove(data, this.jGw);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.kbF != null) {
                this.kbF.setData(data, this.jGw);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.kbP = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.kbP != -1) {
                rY(true);
                onPrimary();
            }
        }
    }

    public void rW(boolean z) {
        if (z && this.kbH != null && this.kbH.getWrappedAdapter() != null && this.kbH.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.kbH.startPullRefresh();
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
                cQV();
            }
        }
    }

    private void cQV() {
        if (this.kbJ != null) {
            this.kbJ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJF() {
        Gz();
        if (this.jGt == null) {
            this.jGt = com.baidu.tieba.im.db.e.cLo().fy(getPageContext().getPageActivity());
        }
        this.jGt.show();
        this.jGt.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gz() {
        if (this.jGt != null && this.jGt.isShowing()) {
            this.jGt.dismiss();
            this.jGt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJG() {
        if (this.kbH != null && this.kbF != null) {
            this.kbH.completePullRefreshPostDelayed(0L);
            if (this.kbF.getData() != null) {
                this.kbJ.setData(this.kbF.getData());
            } else {
                ag(isLogin(), true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar = new aq("c13720");
        aqVar.u("uid", TbadkApplication.getCurrentAccountId());
        if (view == this.kbQ) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.brz().brN();
            com.baidu.tbadk.coreExtra.messageCenter.b.brz().setMsgAtme(0);
            this.kcg = 0;
            CY(this.kcg);
            TiebaStatic.log("c12925");
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            aqVar.aj("obj_type", 1);
        } else if (view == this.kbU) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.brz().brO();
            com.baidu.tbadk.coreExtra.messageCenter.b.brz().qn(0);
            this.kch = 0;
            Db(this.kch);
            TiebaStatic.log("c12926");
            aqVar.aj("obj_type", 2);
        } else if (view == this.kbY) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.brz().brM();
            com.baidu.tbadk.coreExtra.messageCenter.b.brz().setMsgReplyme(0);
            CZ(0);
        } else if (view == this.kcc) {
            com.baidu.tieba.p.a.dwo().h(2, false, true);
            TiebaStatic.log(new aq("c12523").aj("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
            com.baidu.tbadk.coreExtra.messageCenter.b.brz().brP();
            com.baidu.tbadk.coreExtra.messageCenter.b.brz().setMsgFans(0);
            Da(0);
        }
        TiebaStatic.log(aqVar);
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.kcg = newsNotifyMessage.getMsgAtme();
            this.kch = newsNotifyMessage.getMsgAgree();
            CY(this.kcg);
            Db(this.kch);
            Da(newsNotifyMessage.getMsgFans());
            CZ(newsNotifyMessage.getMsgReplyme());
        }
    }

    private void CY(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsf() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsh()) {
                i = 0;
            }
            a(i, this.kbT);
            this.kbT.setThreeDotMode(2);
            this.kbT.refresh(i);
            this.kbT.setVisibility(0);
            return;
        }
        this.kbT.setVisibility(8);
    }

    private void CZ(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsf() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsj()) {
                i = 0;
            }
            a(i, this.kcb);
            this.kcb.setThreeDotMode(2);
            this.kcb.refresh(i);
            this.kcb.setVisibility(0);
            return;
        }
        this.kcb.setVisibility(8);
    }

    private void Da(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsf() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsi()) {
                i = 0;
            }
            a(i, this.kcf);
            this.kcf.setThreeDotMode(2);
            this.kcf.refresh(i);
            this.kcf.setVisibility(0);
            return;
        }
        this.kcf.setVisibility(8);
    }

    private void Db(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsf() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bst()) {
                i = 0;
            }
            a(i, this.kbX);
            this.kbX.setThreeDotMode(2);
            this.kbX.refresh(i);
            this.kbX.setVisibility(0);
            return;
        }
        this.kbX.setVisibility(8);
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
