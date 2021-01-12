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
    private boolean ava;
    private View bJc;
    private int feP;
    private final CustomMessageListener fqC;
    private final f.c gEB;
    private BdSwipeRefreshLayout gzS;
    private RelativeLayout iWm;
    private boolean isNeedRefresh;
    private final CustomMessageListener jcb;
    private final ChatAggregationFragment kIJ;
    private ImMessageCenterModel kIK;
    private ImMessageCenterShowItemData kIL;
    private BdListView kIM;
    private NavigationBarShadowView kIN;
    private MessageAggregationListAdapter kIO;
    private ShutDownValidateTipView kIP;
    private com.baidu.tbadk.core.dialog.i kIQ;
    private k.c kIR;
    private boolean kIS;
    private boolean kIT;
    private int kIU;
    private View kIV;
    private ImageView kIW;
    private TextView kIX;
    private MessageRedDotView kIY;
    private View kIZ;
    private ImageView kJa;
    private TextView kJb;
    private MessageRedDotView kJc;
    private View kJd;
    private ImageView kJe;
    private TextView kJf;
    private MessageRedDotView kJg;
    private View kJh;
    private ImageView kJi;
    private TextView kJj;
    private MessageRedDotView kJk;
    private int kJl;
    private int kJm;
    private com.baidu.tieba.imMessageCenter.mention.base.e kJn;
    private boolean kJo;
    private e.a kJp;
    private final AdapterView.OnItemLongClickListener kJq;
    private com.baidu.tbadk.core.dialog.d kvg;
    private final CustomMessageListener kvh;
    private com.baidu.tieba.im.chat.a.a kvj;
    private final com.baidu.tieba.im.chat.a.b kvk;
    private View mHeaderView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) com.baidu.adp.base.j.K(chatAggregationFragment.getPageContext().getPageActivity()));
        this.kIK = null;
        this.kIL = null;
        this.kIM = null;
        this.kIO = null;
        this.kIQ = null;
        this.kIS = true;
        this.ava = false;
        this.isNeedRefresh = false;
        this.kIT = true;
        this.kIU = 16;
        this.kJo = false;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.kIN.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.kIN.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.kIN.hide();
                }
            }
        };
        this.gEB = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (e.this.gzS != null) {
                        e.this.gzS.setRefreshing(false);
                        return;
                    }
                    return;
                }
                e.this.ta(true);
                e.this.pw(false);
            }
        };
        this.kJp = new e.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.imMessageCenter.mention.base.e.a
            public void onClose() {
                if (e.this.kJn != null) {
                    e.this.kIM.removeHeaderView(e.this.kJn.getView());
                    e.this.kJo = false;
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData Cs = e.this.kIO.getItem(i);
                    TiebaStatic.eventStat(e.this.kIJ.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    aq aqVar = new aq("c13720");
                    aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                    String ownerName = Cs.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(Cs);
                        aqVar.an("obj_type", 6);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kIJ.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.kIJ.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.kIJ.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(Cs.getFriendId(), 0L), Cs.getFriendName(), 0L, "msg_lstb")));
                        } else {
                            return;
                        }
                    } else if (Cs.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kIJ.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(Cs);
                            aqVar.an("obj_type", 7);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bxj().bxF() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bxj().bxF().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.kIJ.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (Cs.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kIJ.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(Cs);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bxj().bxF() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bxj().bxF().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.kIJ.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("5")) {
                        TiebaStatic.log("c12931");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarFeedActivityConfig(e.this.kIJ.getPageContext().getPageActivity())));
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kIJ.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            long j2 = com.baidu.adp.lib.f.b.toLong(Cs.getFriendId(), 0L);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.kIJ.getPageContext().getPageActivity(), j2, Cs.getFriendNameShow(), Cs.getFriendPortrait(), 0, Cs.getUserType())));
                            if ("801001117".equals(String.valueOf(j2))) {
                                TiebaStatic.log(new aq("c14049").dW("uid", TbadkCoreApplication.getCurrentAccount()));
                            } else if ("3222425470".equals(String.valueOf(j2))) {
                                TiebaStatic.log(new aq("c14052").dW("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new aq("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.kIJ.getPageContext().getPageActivity())));
                        aqVar.an("obj_type", 6);
                        return;
                    } else {
                        e(Cs);
                        aqVar.an("obj_type", 6);
                    }
                    if (!TextUtils.isEmpty(Cs.getFriendName())) {
                        if ("贴吧热榜".equals(Cs.getFriendName())) {
                            aqVar.an("obj_type", 8);
                        } else if ("贴吧荣誉墙".equals(Cs.getFriendName())) {
                            aqVar.an("obj_type", 9);
                        } else if ("贴吧精选".equals(Cs.getFriendName())) {
                            aqVar.an("obj_type", 10);
                        } else if ("贴吧活动".equals(Cs.getFriendName())) {
                            aqVar.an("obj_type", 4);
                        } else if ("吧广播".equals(Cs.getFriendName())) {
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
                                com.baidu.tieba.im.db.d.cTv().LT("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.cTv().LT("group_intro_change");
                                com.baidu.tieba.im.db.d.cTv().LT("group_name_change");
                                com.baidu.tieba.im.db.d.cTv().LT("group_notice_change");
                                com.baidu.tieba.im.db.d.cTv().LT("group_level_up");
                                com.baidu.tieba.im.db.d.cTv().LT("dismiss_group");
                                com.baidu.tieba.im.db.d.cTv().LT("kick_out");
                                com.baidu.tieba.im.db.d.cTv().LT("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxj().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.bxj().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.kIJ.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.kJq = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.kIL = e.this.kIO.getItem(i);
                e.this.c(e.this.kIL);
                if (e.this.kIQ != null) {
                    TiebaStatic.log("c12932");
                    e.this.kIQ.Pd();
                    if (e.this.kIJ != null && e.this.kIJ.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.kIJ.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.kvh = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
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
                        e.this.ta(false);
                    } else if (customResponsedMessage.getCmd() == 2016001) {
                        e.this.kIK.setData(null, e.this.kvj);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.kIO != null) {
                            e.this.kIO.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.kIO != null) {
                        e.this.kIO.notifyDataSetChanged();
                    }
                }
            }
        };
        this.kvj = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cTe();
            }
        };
        this.fqC = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.kvk = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cTd();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.kvg != null) {
                    e.this.kvg.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.Ek();
                e.this.kIJ.showToast(R.string.delete_success, false);
                e.this.cTe();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.Ek();
            }
        };
        this.jcb = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    e.this.b((NewsNotifyMessage) customResponsedMessage);
                }
            }
        };
        this.kIJ = chatAggregationFragment;
    }

    public void as(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.kIU = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.kIU = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.kIU);
        }
    }

    public void cJF() {
        if (this.kIO != null) {
            this.kIO.notifyDataSetChanged();
        }
    }

    public void cHM() {
        MessageManager.getInstance().unRegisterListener(this.kvh);
        MessageManager.getInstance().unRegisterListener(this.fqC);
    }

    public View bUv() {
        this.feP = 3;
        this.rootView = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        cR(this.rootView);
        TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        crV();
        return this.rootView;
    }

    public Activity getActivity() {
        return this.kIJ.getPageContext().getPageActivity();
    }

    protected void crV() {
        this.kIM.startPullRefresh();
        this.ava = isLogin();
        if (!this.ava) {
            al(this.ava, true);
        }
    }

    private void registerListener() {
        this.kIJ.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.kvh);
        this.kIJ.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.kvh);
        this.kIJ.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.kvh);
        this.kIJ.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.kvh);
        this.kIJ.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.kvh);
        this.kIJ.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.kvh);
        this.kIJ.registerListener(this.fqC);
        this.kIJ.registerListener(this.jcb);
    }

    public void SM() {
        if (this.gzS != null && !this.gzS.isRefreshing()) {
            ta(true);
        }
    }

    public void ta(boolean z) {
        if (this.gzS != null) {
            if (z && this.kIM != null && this.kIM.getFirstVisiblePosition() != 0) {
                this.kIM.setSelection(0);
            }
            this.gzS.setRefreshing(z);
        }
    }

    public void tb(boolean z) {
        this.isNeedRefresh = z;
    }

    public void tc(boolean z) {
        this.kIT = z;
    }

    public void onPrimary() {
        if (this.kIO != null && this.kIO.getCount() == 0) {
            tb(true);
        }
        if (this.kIT || this.isNeedRefresh) {
            this.kIT = false;
            this.isNeedRefresh = false;
            pw(false);
        }
        boolean isLogin = isLogin();
        if (this.ava != isLogin) {
            this.ava = isLogin;
            onUserChanged(this.ava);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kIJ.getPageContext());
        }
        cXg();
    }

    private void initData() {
        this.kIK = new ImMessageCenterModel();
        te(com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void cR(View view) {
        this.iWm = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.kIP = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.kIP.setVisibility(8);
        this.kIP.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.te(false);
                e.this.td(false);
            }
        });
        this.kIN = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.kIM = (BdListView) view.findViewById(R.id.chat_list_content);
        this.kIM.setDividerHeight(0);
        this.kIO = new MessageAggregationListAdapter(this.kIJ.getPageContext().getPageActivity());
        this.kIO.a(this);
        this.kIM.setAdapter((ListAdapter) this.kIO);
        this.kIM.setOnItemClickListener(this.mItemClickListener);
        this.kIM.setOnItemLongClickListener(this.kJq);
        this.kIM.setOnScrollListener(this.mOnScrollListener);
        this.mHeaderView = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
        this.kIV = this.mHeaderView.findViewById(R.id.at_me_layout);
        this.kIW = (ImageView) this.mHeaderView.findViewById(R.id.at_me_icon);
        this.kIX = (TextView) this.mHeaderView.findViewById(R.id.at_me_text);
        this.kIY = (MessageRedDotView) this.mHeaderView.findViewById(R.id.at_me_new_message);
        this.kIZ = this.mHeaderView.findViewById(R.id.agree_me_layout);
        this.kJa = (ImageView) this.mHeaderView.findViewById(R.id.agree_me_icon);
        this.kJb = (TextView) this.mHeaderView.findViewById(R.id.agree_me_text);
        this.kJc = (MessageRedDotView) this.mHeaderView.findViewById(R.id.agree_me_new_message);
        this.kJd = this.mHeaderView.findViewById(R.id.reply_me_layout);
        this.kJe = (ImageView) this.mHeaderView.findViewById(R.id.reply_me_icon);
        this.kJf = (TextView) this.mHeaderView.findViewById(R.id.reply_me_text);
        this.kJg = (MessageRedDotView) this.mHeaderView.findViewById(R.id.reply_me_new_message);
        this.kJh = this.mHeaderView.findViewById(R.id.fans_layout);
        this.kJi = (ImageView) this.mHeaderView.findViewById(R.id.fans_icon);
        this.kJj = (TextView) this.mHeaderView.findViewById(R.id.fans_text);
        this.kJk = (MessageRedDotView) this.mHeaderView.findViewById(R.id.fans_new_message);
        this.kIY.setThreeDotMode(2);
        this.kJc.setThreeDotMode(2);
        this.kJg.setThreeDotMode(2);
        this.kJk.setThreeDotMode(2);
        this.kIY.setShadowEnabled(false);
        this.kJc.setShadowEnabled(false);
        this.kJg.setShadowEnabled(false);
        this.kIV.setOnClickListener(this);
        this.kIZ.setOnClickListener(this);
        this.kJd.setOnClickListener(this);
        this.kJh.setOnClickListener(this);
        this.kIM.addHeaderView(this.mHeaderView);
        cXg();
        this.gzS = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kIJ.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gEB);
        }
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.gzS.setProgressView(this.mPullView);
        this.bJc = new View(this.kIJ.getFragmentActivity());
        this.bJc.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.kIJ.getFragmentActivity(), R.dimen.ds150)));
        this.kIM.addFooterView(this.bJc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cXg() {
        if (this.kIM != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
            aq aqVar = new aq("c13616");
            aqVar.an("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aqVar);
            if (areNotificationsEnabled) {
                if (this.kJn != null) {
                    this.kIM.removeHeaderView(this.kJn.getView());
                    this.kJo = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.brx().getLong("key_im_open_notification_close_time", 0L);
            if (this.kJo) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kJn == null) {
                    this.kJn = new com.baidu.tieba.imMessageCenter.mention.base.e(this.mContext);
                    this.kJn.a(this.kJp);
                }
                this.kIM.addHeaderView(this.kJn.getView(), 0);
                this.kJo = true;
            }
        }
    }

    private boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kIJ.getPageContext(), i);
        }
        if (this.kIP != null) {
            this.kIP.onChangeSkinType(i);
        }
        if (this.kIO != null) {
            this.kIO.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.iWm);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ao.setBackgroundColor(this.iWm, R.color.CAM_X0201);
        ao.setBackgroundColor(this.gzS, R.color.CAM_X0205);
        ao.setViewTextColor(this.kIX, R.color.CAM_X0105);
        ao.setViewTextColor(this.kJb, R.color.CAM_X0105);
        ao.setViewTextColor(this.kJf, R.color.CAM_X0105);
        ao.setViewTextColor(this.kJj, R.color.CAM_X0105);
        ao.setImageResource(this.kIW, R.drawable.pic_information_at_me);
        ao.setImageResource(this.kJa, R.drawable.pic_information_praise);
        ao.setImageResource(this.kJe, R.drawable.pic_information_reply);
        ao.setImageResource(this.kJi, R.drawable.pic_information_fans);
        if (this.kIY != null) {
            this.kIY.onChangeSkinType();
        }
        if (this.kJc != null) {
            this.kJc.onChangeSkinType();
        }
        if (this.kJg != null) {
            this.kJg.onChangeSkinType();
        }
        if (this.kJk != null) {
            this.kJk.onChangeSkinType();
        }
        if (this.kJn != null) {
            this.kJn.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    protected void onUserChanged(boolean z) {
        al(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.kIR = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.kIQ != null && e.this.kIQ.isShowing() && e.this.kIJ != null) {
                    e.this.kIQ.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.kIK.asyncDeleteItem(imMessageCenterShowItemData, e.this.kvk);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.kIJ.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.kIQ = new com.baidu.tbadk.core.dialog.i(this.kIJ.getPageContext());
        this.kIQ.a(null, new String[]{string}, this.kIR);
    }

    protected boolean pw(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.kIM.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void td(boolean z) {
        if (z) {
            if (cXh() && this.kIP.getVisibility() != 0) {
                this.kIP.setVisibility(0);
            }
        } else if (this.kIP.getVisibility() != 8) {
            this.kIP.setVisibility(8);
        }
    }

    public void al(boolean z, boolean z2) {
    }

    public boolean cXh() {
        return this.kIS;
    }

    public void te(boolean z) {
        this.kIS = z;
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
                if (this.kIK != null) {
                    this.kIK.insertOrUpdate(data, this.kvj);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.kIK != null) {
                this.kIK.remove(data, this.kvj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.kIK != null) {
                this.kIK.setData(data, this.kvj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.kIU = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.kIU != -1) {
                tb(true);
                onPrimary();
            }
        }
    }

    public void sZ(boolean z) {
        if (z && this.kIM != null && this.kIM.getWrappedAdapter() != null && this.kIM.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.kIM.startPullRefresh();
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
                cXi();
            }
        }
    }

    private void cXi() {
        if (this.kIO != null) {
            this.kIO.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTd() {
        Ek();
        if (this.kvg == null) {
            this.kvg = com.baidu.tieba.im.db.e.cTw().gv(getPageContext().getPageActivity());
        }
        this.kvg.show();
        this.kvg.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ek() {
        if (this.kvg != null && this.kvg.isShowing()) {
            this.kvg.dismiss();
            this.kvg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTe() {
        if (this.kIM != null && this.kIK != null) {
            this.kIM.completePullRefreshPostDelayed(0L);
            if (this.kIK.getData() != null) {
                this.kIO.setData(this.kIK.getData());
            } else {
                al(isLogin(), true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar = new aq("c13720");
        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
        if (view == this.kIV) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bxj().bxx();
            com.baidu.tbadk.coreExtra.messageCenter.b.bxj().setMsgAtme(0);
            this.kJl = 0;
            Dd(this.kJl);
            TiebaStatic.log("c12925");
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            aqVar.an("obj_type", 1);
        } else if (view == this.kIZ) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bxj().bxy();
            com.baidu.tbadk.coreExtra.messageCenter.b.bxj().qn(0);
            this.kJm = 0;
            Dg(this.kJm);
            TiebaStatic.log("c12926");
            aqVar.an("obj_type", 2);
        } else if (view == this.kJd) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bxj().bxw();
            com.baidu.tbadk.coreExtra.messageCenter.b.bxj().setMsgReplyme(0);
            De(0);
        } else if (view == this.kJh) {
            com.baidu.tieba.p.a.dCM().h(2, false, true);
            TiebaStatic.log(new aq("c12523").an("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
            com.baidu.tbadk.coreExtra.messageCenter.b.bxj().bxz();
            com.baidu.tbadk.coreExtra.messageCenter.b.bxj().setMsgFans(0);
            Df(0);
        }
        TiebaStatic.log(aqVar);
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.kJl = newsNotifyMessage.getMsgAtme();
            this.kJm = newsNotifyMessage.getMsgAgree();
            Dd(this.kJl);
            Dg(this.kJm);
            Df(newsNotifyMessage.getMsgFans());
            De(newsNotifyMessage.getMsgReplyme());
        }
    }

    private void Dd(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxP() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxR()) {
                i = 0;
            }
            a(i, this.kIY);
            this.kIY.setThreeDotMode(2);
            this.kIY.refresh(i);
            this.kIY.setVisibility(0);
            return;
        }
        this.kIY.setVisibility(8);
    }

    private void De(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxP() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxT()) {
                i = 0;
            }
            a(i, this.kJg);
            this.kJg.setThreeDotMode(2);
            this.kJg.refresh(i);
            this.kJg.setVisibility(0);
            return;
        }
        this.kJg.setVisibility(8);
    }

    private void Df(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxP() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxS()) {
                i = 0;
            }
            a(i, this.kJk);
            this.kJk.setThreeDotMode(2);
            this.kJk.refresh(i);
            this.kJk.setVisibility(0);
            return;
        }
        this.kJk.setVisibility(8);
    }

    private void Dg(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxP() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bxM().byd()) {
                i = 0;
            }
            a(i, this.kJc);
            this.kJc.setThreeDotMode(2);
            this.kJc.refresh(i);
            this.kJc.setVisibility(0);
            return;
        }
        this.kJc.setVisibility(8);
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
