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
/* loaded from: classes21.dex */
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements View.OnClickListener, f.c {
    private View btr;
    private final CustomMessageListener eEB;
    private boolean eSQ;
    private int ete;
    private BdSwipeRefreshLayout fJy;
    private final f.c fOd;
    private final CustomMessageListener ibu;
    private boolean isNeedRefresh;
    private final ChatAggregationFragment jMG;
    private ImMessageCenterModel jMH;
    private ImMessageCenterShowItemData jMI;
    private BdListView jMJ;
    private NavigationBarShadowView jMK;
    private MessageAggregationListAdapter jML;
    private ShutDownValidateTipView jMM;
    private com.baidu.tbadk.core.dialog.i jMN;
    private k.c jMO;
    private boolean jMP;
    private boolean jMQ;
    private int jMR;
    private View jMS;
    private ImageView jMT;
    private TextView jMU;
    private MessageRedDotView jMV;
    private View jMW;
    private ImageView jMX;
    private TextView jMY;
    private MessageRedDotView jMZ;
    private View jNa;
    private ImageView jNb;
    private TextView jNc;
    private MessageRedDotView jNd;
    private View jNe;
    private ImageView jNf;
    private TextView jNg;
    private MessageRedDotView jNh;
    private int jNi;
    private int jNj;
    private com.baidu.tieba.imMessageCenter.mention.base.f jNk;
    private boolean jNl;
    private f.a jNm;
    private final AdapterView.OnItemLongClickListener jNn;
    private final com.baidu.tieba.im.chat.a.b jrA;
    private com.baidu.tbadk.core.dialog.d jrw;
    private final CustomMessageListener jrx;
    private com.baidu.tieba.im.chat.a.a jrz;
    private View mHeaderView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) com.baidu.adp.base.i.I(chatAggregationFragment.getPageContext().getPageActivity()));
        this.jMH = null;
        this.jMI = null;
        this.jMJ = null;
        this.jML = null;
        this.jMN = null;
        this.jMP = true;
        this.eSQ = false;
        this.isNeedRefresh = false;
        this.jMQ = true;
        this.jMR = 16;
        this.jNl = false;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.jMK.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.jMK.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.jMK.hide();
                }
            }
        };
        this.fOd = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (e.this.fJy != null) {
                        e.this.fJy.setRefreshing(false);
                        return;
                    }
                    return;
                }
                e.this.rr(true);
                e.this.nx(false);
            }
        };
        this.jNm = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (e.this.jNk != null) {
                    e.this.jMJ.removeHeaderView(e.this.jNk.getView());
                    e.this.jNl = false;
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData Bn = e.this.jML.getItem(i);
                    TiebaStatic.eventStat(e.this.jMG.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    aq aqVar = new aq("c13720");
                    aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                    String ownerName = Bn.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(Bn);
                        aqVar.ai("obj_type", 6);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jMG.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.jMG.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.jMG.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(Bn.getFriendId(), 0L), Bn.getFriendName(), 0L, "msg_lstb")));
                        } else {
                            return;
                        }
                    } else if (Bn.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jMG.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(Bn);
                            aqVar.ai("obj_type", 7);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.boP().bpl() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.boP().bpl().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.jMG.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (Bn.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jMG.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(Bn);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.boP().bpl() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.boP().bpl().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.jMG.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("5")) {
                        TiebaStatic.log("c12931");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarFeedActivityConfig(e.this.jMG.getPageContext().getPageActivity())));
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jMG.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.jMG.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(Bn.getFriendId(), 0L), Bn.getFriendNameShow(), Bn.getFriendPortrait(), 0, Bn.getUserType())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new aq("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.jMG.getPageContext().getPageActivity())));
                        aqVar.ai("obj_type", 6);
                        return;
                    } else {
                        e(Bn);
                        aqVar.ai("obj_type", 6);
                    }
                    if (!TextUtils.isEmpty(Bn.getFriendName())) {
                        if ("贴吧热榜".equals(Bn.getFriendName())) {
                            aqVar.ai("obj_type", 8);
                        } else if ("贴吧荣誉墙".equals(Bn.getFriendName())) {
                            aqVar.ai("obj_type", 9);
                        } else if ("贴吧精选".equals(Bn.getFriendName())) {
                            aqVar.ai("obj_type", 10);
                        } else if ("贴吧活动".equals(Bn.getFriendName())) {
                            aqVar.ai("obj_type", 4);
                        } else if ("吧广播".equals(Bn.getFriendName())) {
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
                                com.baidu.tieba.im.db.d.cHE().KV("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.cHE().KV("group_intro_change");
                                com.baidu.tieba.im.db.d.cHE().KV("group_name_change");
                                com.baidu.tieba.im.db.d.cHE().KV("group_notice_change");
                                com.baidu.tieba.im.db.d.cHE().KV("group_level_up");
                                com.baidu.tieba.im.db.d.cHE().KV("dismiss_group");
                                com.baidu.tieba.im.db.d.cHE().KV("kick_out");
                                com.baidu.tieba.im.db.d.cHE().KV("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.boP().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.boP().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.jMG.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.jNn = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.jMI = e.this.jML.getItem(i);
                e.this.c(e.this.jMI);
                if (e.this.jMN != null) {
                    TiebaStatic.log("c12932");
                    e.this.jMN.NY();
                    if (e.this.jMG != null && e.this.jMG.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.jMG.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.jrx = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
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
                        e.this.rr(false);
                    } else if (customResponsedMessage.getCmd() == 2016001) {
                        e.this.jMH.setData(null, e.this.jrz);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.jML != null) {
                            e.this.jML.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.jML != null) {
                        e.this.jML.notifyDataSetChanged();
                    }
                }
            }
        };
        this.jrz = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cFX();
            }
        };
        this.eEB = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.jrA = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cFW();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.jrw != null) {
                    e.this.jrw.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.FD();
                e.this.jMG.showToast(R.string.delete_success, false);
                e.this.cFX();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.FD();
            }
        };
        this.ibu = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    e.this.b((NewsNotifyMessage) customResponsedMessage);
                }
            }
        };
        this.jMG = chatAggregationFragment;
    }

    public void aq(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.jMR = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.jMR = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.jMR);
        }
    }

    public void cww() {
        if (this.jML != null) {
            this.jML.notifyDataSetChanged();
        }
    }

    public void cuG() {
        MessageManager.getInstance().unRegisterListener(this.jrx);
        MessageManager.getInstance().unRegisterListener(this.eEB);
    }

    public View bKO() {
        this.ete = 3;
        this.rootView = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        cj(this.rootView);
        TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        cga();
        return this.rootView;
    }

    public Activity getActivity() {
        return this.jMG.getPageContext().getPageActivity();
    }

    protected void cga() {
        this.jMJ.startPullRefresh();
        this.eSQ = isLogin();
        if (!this.eSQ) {
            ah(this.eSQ, true);
        }
    }

    private void registerListener() {
        this.jMG.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.jrx);
        this.jMG.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.jrx);
        this.jMG.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.jrx);
        this.jMG.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.jrx);
        this.jMG.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.jrx);
        this.jMG.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.jrx);
        this.jMG.registerListener(this.eEB);
        this.jMG.registerListener(this.ibu);
    }

    public void Pd() {
        if (this.fJy != null && !this.fJy.isRefreshing()) {
            rr(true);
        }
    }

    public void rr(boolean z) {
        if (this.fJy != null) {
            if (z && this.jMJ != null && this.jMJ.getFirstVisiblePosition() != 0) {
                this.jMJ.setSelection(0);
            }
            this.fJy.setRefreshing(z);
        }
    }

    public void rs(boolean z) {
        this.isNeedRefresh = z;
    }

    public void rt(boolean z) {
        this.jMQ = z;
    }

    public void onPrimary() {
        if (this.jML != null && this.jML.getCount() == 0) {
            rs(true);
        }
        if (this.jMQ || this.isNeedRefresh) {
            this.jMQ = false;
            this.isNeedRefresh = false;
            nx(false);
        }
        boolean isLogin = isLogin();
        if (this.eSQ != isLogin) {
            this.eSQ = isLogin;
            onUserChanged(this.eSQ);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.jMG.getPageContext());
        }
        cNl();
    }

    private void initData() {
        this.jMH = new ImMessageCenterModel();
        rv(com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void cj(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.jMM = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.jMM.setVisibility(8);
        this.jMM.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.rv(false);
                e.this.ru(false);
            }
        });
        this.jMK = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.jMJ = (BdListView) view.findViewById(R.id.chat_list_content);
        this.jMJ.setDividerHeight(0);
        this.jML = new MessageAggregationListAdapter(this.jMG.getPageContext().getPageActivity());
        this.jML.a(this);
        this.jMJ.setAdapter((ListAdapter) this.jML);
        this.jMJ.setOnItemClickListener(this.mItemClickListener);
        this.jMJ.setOnItemLongClickListener(this.jNn);
        this.jMJ.setOnScrollListener(this.mOnScrollListener);
        this.mHeaderView = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
        this.jMS = this.mHeaderView.findViewById(R.id.at_me_layout);
        this.jMT = (ImageView) this.mHeaderView.findViewById(R.id.at_me_icon);
        this.jMU = (TextView) this.mHeaderView.findViewById(R.id.at_me_text);
        this.jMV = (MessageRedDotView) this.mHeaderView.findViewById(R.id.at_me_new_message);
        this.jMW = this.mHeaderView.findViewById(R.id.agree_me_layout);
        this.jMX = (ImageView) this.mHeaderView.findViewById(R.id.agree_me_icon);
        this.jMY = (TextView) this.mHeaderView.findViewById(R.id.agree_me_text);
        this.jMZ = (MessageRedDotView) this.mHeaderView.findViewById(R.id.agree_me_new_message);
        this.jNa = this.mHeaderView.findViewById(R.id.reply_me_layout);
        this.jNb = (ImageView) this.mHeaderView.findViewById(R.id.reply_me_icon);
        this.jNc = (TextView) this.mHeaderView.findViewById(R.id.reply_me_text);
        this.jNd = (MessageRedDotView) this.mHeaderView.findViewById(R.id.reply_me_new_message);
        this.jNe = this.mHeaderView.findViewById(R.id.fans_layout);
        this.jNf = (ImageView) this.mHeaderView.findViewById(R.id.fans_icon);
        this.jNg = (TextView) this.mHeaderView.findViewById(R.id.fans_text);
        this.jNh = (MessageRedDotView) this.mHeaderView.findViewById(R.id.fans_new_message);
        this.jMV.setThreeDotMode(2);
        this.jMZ.setThreeDotMode(2);
        this.jNd.setThreeDotMode(2);
        this.jNh.setThreeDotMode(2);
        this.jMV.setShadowEnabled(false);
        this.jMZ.setShadowEnabled(false);
        this.jNd.setShadowEnabled(false);
        this.jMS.setOnClickListener(this);
        this.jMW.setOnClickListener(this);
        this.jNa.setOnClickListener(this);
        this.jNe.setOnClickListener(this);
        this.jMJ.addHeaderView(this.mHeaderView);
        cNl();
        this.fJy = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.jMG.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fOd);
        }
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.fJy.setProgressView(this.mPullView);
        this.btr = new View(this.jMG.getFragmentActivity());
        this.btr.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.jMG.getFragmentActivity(), R.dimen.ds150)));
        this.jMJ.addFooterView(this.btr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cNl() {
        if (this.jMJ != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
            aq aqVar = new aq("c13616");
            aqVar.ai("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aqVar);
            if (areNotificationsEnabled) {
                if (this.jNk != null) {
                    this.jMJ.removeHeaderView(this.jNk.getView());
                    this.jNl = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bjf().getLong("key_im_open_notification_close_time", 0L);
            if (this.jNl) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.jNk == null) {
                    this.jNk = new com.baidu.tieba.imMessageCenter.mention.base.f(this.mContext);
                    this.jNk.a(this.jNm);
                }
                this.jMJ.addHeaderView(this.jNk.getView(), 0);
                this.jNl = true;
            }
        }
    }

    private boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jMG.getPageContext(), i);
        }
        if (this.jMM != null) {
            this.jMM.onChangeSkinType(i);
        }
        if (this.jML != null) {
            this.jML.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.fJy, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.jMU, R.color.cp_cont_b);
        ap.setViewTextColor(this.jMY, R.color.cp_cont_b);
        ap.setViewTextColor(this.jNc, R.color.cp_cont_b);
        ap.setViewTextColor(this.jNg, R.color.cp_cont_b);
        ap.setImageResource(this.jMT, R.drawable.pic_information_at_me);
        ap.setImageResource(this.jMX, R.drawable.pic_information_praise);
        ap.setImageResource(this.jNb, R.drawable.pic_information_reply);
        ap.setImageResource(this.jNf, R.drawable.pic_information_fans);
        if (this.jMV != null) {
            this.jMV.onChangeSkinType();
        }
        if (this.jMZ != null) {
            this.jMZ.onChangeSkinType();
        }
        if (this.jNd != null) {
            this.jNd.onChangeSkinType();
        }
        if (this.jNh != null) {
            this.jNh.onChangeSkinType();
        }
        if (this.jNk != null) {
            this.jNk.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    protected void onUserChanged(boolean z) {
        ah(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.jMO = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.jMN != null && e.this.jMN.isShowing() && e.this.jMG != null) {
                    e.this.jMN.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.jMH.asyncDeleteItem(imMessageCenterShowItemData, e.this.jrA);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.jMG.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.jMN = new com.baidu.tbadk.core.dialog.i(this.jMG.getPageContext());
        this.jMN.a(null, new String[]{string}, this.jMO);
    }

    protected boolean nx(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.jMJ.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void ru(boolean z) {
        if (z) {
            if (cNm() && this.jMM.getVisibility() != 0) {
                this.jMM.setVisibility(0);
            }
        } else if (this.jMM.getVisibility() != 8) {
            this.jMM.setVisibility(8);
        }
    }

    public void ah(boolean z, boolean z2) {
    }

    public boolean cNm() {
        return this.jMP;
    }

    public void rv(boolean z) {
        this.jMP = z;
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
                if (this.jMH != null) {
                    this.jMH.insertOrUpdate(data, this.jrz);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.jMH != null) {
                this.jMH.remove(data, this.jrz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.jMH != null) {
                this.jMH.setData(data, this.jrz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.jMR = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.jMR != -1) {
                rs(true);
                onPrimary();
            }
        }
    }

    public void rq(boolean z) {
        if (z && this.jMJ != null && this.jMJ.getWrappedAdapter() != null && this.jMJ.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.jMJ.startPullRefresh();
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
                cNn();
            }
        }
    }

    private void cNn() {
        if (this.jML != null) {
            this.jML.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFW() {
        FD();
        if (this.jrw == null) {
            this.jrw = com.baidu.tieba.im.db.e.cHF().fr(getPageContext().getPageActivity());
        }
        this.jrw.show();
        this.jrw.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FD() {
        if (this.jrw != null && this.jrw.isShowing()) {
            this.jrw.dismiss();
            this.jrw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFX() {
        if (this.jMJ != null && this.jMH != null) {
            this.jMJ.completePullRefreshPostDelayed(0L);
            if (this.jMH.getData() != null) {
                this.jML.setData(this.jMH.getData());
            } else {
                ah(isLogin(), true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar = new aq("c13720");
        aqVar.u("uid", TbadkApplication.getCurrentAccountId());
        if (view == this.jMS) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.boP().bpd();
            com.baidu.tbadk.coreExtra.messageCenter.b.boP().setMsgAtme(0);
            this.jNi = 0;
            Cs(this.jNi);
            TiebaStatic.log("c12925");
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            aqVar.ai("obj_type", 1);
        } else if (view == this.jMW) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.boP().bpe();
            com.baidu.tbadk.coreExtra.messageCenter.b.boP().pP(0);
            this.jNj = 0;
            Cv(this.jNj);
            TiebaStatic.log("c12926");
            aqVar.ai("obj_type", 2);
        } else if (view == this.jNa) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.boP().bpc();
            com.baidu.tbadk.coreExtra.messageCenter.b.boP().setMsgReplyme(0);
            Ct(0);
        } else if (view == this.jNe) {
            com.baidu.tieba.p.a.dsD().h(2, false, true);
            TiebaStatic.log(new aq("c12523").ai("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
            com.baidu.tbadk.coreExtra.messageCenter.b.boP().bpf();
            com.baidu.tbadk.coreExtra.messageCenter.b.boP().setMsgFans(0);
            Cu(0);
        }
        TiebaStatic.log(aqVar);
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.jNi = newsNotifyMessage.getMsgAtme();
            this.jNj = newsNotifyMessage.getMsgAgree();
            Cs(this.jNi);
            Cv(this.jNj);
            Cu(newsNotifyMessage.getMsgFans());
            Ct(newsNotifyMessage.getMsgReplyme());
        }
    }

    private void Cs(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpv() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpx()) {
                i = 0;
            }
            a(i, this.jMV);
            this.jMV.setThreeDotMode(2);
            this.jMV.refresh(i);
            this.jMV.setVisibility(0);
            return;
        }
        this.jMV.setVisibility(8);
    }

    private void Ct(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpv() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpz()) {
                i = 0;
            }
            a(i, this.jNd);
            this.jNd.setThreeDotMode(2);
            this.jNd.refresh(i);
            this.jNd.setVisibility(0);
            return;
        }
        this.jNd.setVisibility(8);
    }

    private void Cu(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpv() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpy()) {
                i = 0;
            }
            a(i, this.jNh);
            this.jNh.setThreeDotMode(2);
            this.jNh.refresh(i);
            this.jNh.setVisibility(0);
            return;
        }
        this.jNh.setVisibility(8);
    }

    private void Cv(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpv() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpJ()) {
                i = 0;
            }
            a(i, this.jMZ);
            this.jMZ.setThreeDotMode(2);
            this.jMZ.refresh(i);
            this.jMZ.setVisibility(0);
            return;
        }
        this.jMZ.setVisibility(8);
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
