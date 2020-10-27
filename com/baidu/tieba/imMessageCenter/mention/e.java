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
    private View bzs;
    private int eNK;
    private final CustomMessageListener eZe;
    private boolean fnx;
    private BdSwipeRefreshLayout gfT;
    private final f.c gkz;
    private final CustomMessageListener iCR;
    private boolean isNeedRefresh;
    private com.baidu.tbadk.core.dialog.d jSS;
    private final CustomMessageListener jST;
    private com.baidu.tieba.im.chat.a.a jSV;
    private final com.baidu.tieba.im.chat.a.b jSW;
    private MessageRedDotView koA;
    private View koB;
    private ImageView koC;
    private TextView koD;
    private MessageRedDotView koE;
    private int koF;
    private int koG;
    private com.baidu.tieba.imMessageCenter.mention.base.f koH;
    private boolean koI;
    private f.a koJ;
    private final AdapterView.OnItemLongClickListener koK;
    private final ChatAggregationFragment kod;
    private ImMessageCenterModel koe;
    private ImMessageCenterShowItemData kof;
    private BdListView kog;
    private NavigationBarShadowView koh;
    private MessageAggregationListAdapter koi;
    private ShutDownValidateTipView koj;
    private com.baidu.tbadk.core.dialog.i kok;
    private k.c kol;
    private boolean kom;
    private boolean kon;
    private int koo;
    private View kop;
    private ImageView koq;
    private TextView kor;
    private MessageRedDotView kos;
    private View kot;
    private ImageView kou;
    private TextView kov;
    private MessageRedDotView kow;
    private View kox;
    private ImageView koy;
    private TextView koz;
    private View mHeaderView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) com.baidu.adp.base.i.I(chatAggregationFragment.getPageContext().getPageActivity()));
        this.koe = null;
        this.kof = null;
        this.kog = null;
        this.koi = null;
        this.kok = null;
        this.kom = true;
        this.fnx = false;
        this.isNeedRefresh = false;
        this.kon = true;
        this.koo = 16;
        this.koI = false;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.koh.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.koh.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.koh.hide();
                }
            }
        };
        this.gkz = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (e.this.gfT != null) {
                        e.this.gfT.setRefreshing(false);
                        return;
                    }
                    return;
                }
                e.this.sp(true);
                e.this.ou(false);
            }
        };
        this.koJ = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (e.this.koH != null) {
                    e.this.kog.removeHeaderView(e.this.koH.getView());
                    e.this.koI = false;
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData Cm = e.this.koi.getItem(i);
                    TiebaStatic.eventStat(e.this.kod.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    aq aqVar = new aq("c13720");
                    aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                    String ownerName = Cm.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(Cm);
                        aqVar.aj("obj_type", 6);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kod.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.kod.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.kod.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(Cm.getFriendId(), 0L), Cm.getFriendName(), 0L, "msg_lstb")));
                        } else {
                            return;
                        }
                    } else if (Cm.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kod.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(Cm);
                            aqVar.aj("obj_type", 7);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bts().btO() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bts().btO().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.kod.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (Cm.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kod.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(Cm);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bts().btO() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bts().btO().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.kod.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("5")) {
                        TiebaStatic.log("c12931");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarFeedActivityConfig(e.this.kod.getPageContext().getPageActivity())));
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kod.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.kod.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(Cm.getFriendId(), 0L), Cm.getFriendNameShow(), Cm.getFriendPortrait(), 0, Cm.getUserType())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new aq("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.kod.getPageContext().getPageActivity())));
                        aqVar.aj("obj_type", 6);
                        return;
                    } else {
                        e(Cm);
                        aqVar.aj("obj_type", 6);
                    }
                    if (!TextUtils.isEmpty(Cm.getFriendName())) {
                        if ("贴吧热榜".equals(Cm.getFriendName())) {
                            aqVar.aj("obj_type", 8);
                        } else if ("贴吧荣誉墙".equals(Cm.getFriendName())) {
                            aqVar.aj("obj_type", 9);
                        } else if ("贴吧精选".equals(Cm.getFriendName())) {
                            aqVar.aj("obj_type", 10);
                        } else if ("贴吧活动".equals(Cm.getFriendName())) {
                            aqVar.aj("obj_type", 4);
                        } else if ("吧广播".equals(Cm.getFriendName())) {
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
                                com.baidu.tieba.im.db.d.cOu().Mi("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.cOu().Mi("group_intro_change");
                                com.baidu.tieba.im.db.d.cOu().Mi("group_name_change");
                                com.baidu.tieba.im.db.d.cOu().Mi("group_notice_change");
                                com.baidu.tieba.im.db.d.cOu().Mi("group_level_up");
                                com.baidu.tieba.im.db.d.cOu().Mi("dismiss_group");
                                com.baidu.tieba.im.db.d.cOu().Mi("kick_out");
                                com.baidu.tieba.im.db.d.cOu().Mi("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.bts().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.bts().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.kod.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.koK = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.kof = e.this.koi.getItem(i);
                e.this.c(e.this.kof);
                if (e.this.kok != null) {
                    TiebaStatic.log("c12932");
                    e.this.kok.PJ();
                    if (e.this.kod != null && e.this.kod.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.kod.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.jST = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
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
                        e.this.sp(false);
                    } else if (customResponsedMessage.getCmd() == 2016001) {
                        e.this.koe.setData(null, e.this.jSV);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.koi != null) {
                            e.this.koi.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.koi != null) {
                        e.this.koi.notifyDataSetChanged();
                    }
                }
            }
        };
        this.jSV = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cMN();
            }
        };
        this.eZe = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.jSW = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cMM();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.jSS != null) {
                    e.this.jSS.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.GU();
                e.this.kod.showToast(R.string.delete_success, false);
                e.this.cMN();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.GU();
            }
        };
        this.iCR = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    e.this.b((NewsNotifyMessage) customResponsedMessage);
                }
            }
        };
        this.kod = chatAggregationFragment;
    }

    public void aq(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.koo = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.koo = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.koo);
        }
    }

    public void cDa() {
        if (this.koi != null) {
            this.koi.notifyDataSetChanged();
        }
    }

    public void cBk() {
        MessageManager.getInstance().unRegisterListener(this.jST);
        MessageManager.getInstance().unRegisterListener(this.eZe);
    }

    public View bQd() {
        this.eNK = 3;
        this.rootView = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        cr(this.rootView);
        TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        cmD();
        return this.rootView;
    }

    public Activity getActivity() {
        return this.kod.getPageContext().getPageActivity();
    }

    protected void cmD() {
        this.kog.startPullRefresh();
        this.fnx = isLogin();
        if (!this.fnx) {
            aj(this.fnx, true);
        }
    }

    private void registerListener() {
        this.kod.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.jST);
        this.kod.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.jST);
        this.kod.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.jST);
        this.kod.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.jST);
        this.kod.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.jST);
        this.kod.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.jST);
        this.kod.registerListener(this.eZe);
        this.kod.registerListener(this.iCR);
    }

    public void Rd() {
        if (this.gfT != null && !this.gfT.isRefreshing()) {
            sp(true);
        }
    }

    public void sp(boolean z) {
        if (this.gfT != null) {
            if (z && this.kog != null && this.kog.getFirstVisiblePosition() != 0) {
                this.kog.setSelection(0);
            }
            this.gfT.setRefreshing(z);
        }
    }

    public void sq(boolean z) {
        this.isNeedRefresh = z;
    }

    public void sr(boolean z) {
        this.kon = z;
    }

    public void onPrimary() {
        if (this.koi != null && this.koi.getCount() == 0) {
            sq(true);
        }
        if (this.kon || this.isNeedRefresh) {
            this.kon = false;
            this.isNeedRefresh = false;
            ou(false);
        }
        boolean isLogin = isLogin();
        if (this.fnx != isLogin) {
            this.fnx = isLogin;
            onUserChanged(this.fnx);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kod.getPageContext());
        }
        cUa();
    }

    private void initData() {
        this.koe = new ImMessageCenterModel();
        st(com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void cr(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.koj = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.koj.setVisibility(8);
        this.koj.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.st(false);
                e.this.ss(false);
            }
        });
        this.koh = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.kog = (BdListView) view.findViewById(R.id.chat_list_content);
        this.kog.setDividerHeight(0);
        this.koi = new MessageAggregationListAdapter(this.kod.getPageContext().getPageActivity());
        this.koi.a(this);
        this.kog.setAdapter((ListAdapter) this.koi);
        this.kog.setOnItemClickListener(this.mItemClickListener);
        this.kog.setOnItemLongClickListener(this.koK);
        this.kog.setOnScrollListener(this.mOnScrollListener);
        this.mHeaderView = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
        this.kop = this.mHeaderView.findViewById(R.id.at_me_layout);
        this.koq = (ImageView) this.mHeaderView.findViewById(R.id.at_me_icon);
        this.kor = (TextView) this.mHeaderView.findViewById(R.id.at_me_text);
        this.kos = (MessageRedDotView) this.mHeaderView.findViewById(R.id.at_me_new_message);
        this.kot = this.mHeaderView.findViewById(R.id.agree_me_layout);
        this.kou = (ImageView) this.mHeaderView.findViewById(R.id.agree_me_icon);
        this.kov = (TextView) this.mHeaderView.findViewById(R.id.agree_me_text);
        this.kow = (MessageRedDotView) this.mHeaderView.findViewById(R.id.agree_me_new_message);
        this.kox = this.mHeaderView.findViewById(R.id.reply_me_layout);
        this.koy = (ImageView) this.mHeaderView.findViewById(R.id.reply_me_icon);
        this.koz = (TextView) this.mHeaderView.findViewById(R.id.reply_me_text);
        this.koA = (MessageRedDotView) this.mHeaderView.findViewById(R.id.reply_me_new_message);
        this.koB = this.mHeaderView.findViewById(R.id.fans_layout);
        this.koC = (ImageView) this.mHeaderView.findViewById(R.id.fans_icon);
        this.koD = (TextView) this.mHeaderView.findViewById(R.id.fans_text);
        this.koE = (MessageRedDotView) this.mHeaderView.findViewById(R.id.fans_new_message);
        this.kos.setThreeDotMode(2);
        this.kow.setThreeDotMode(2);
        this.koA.setThreeDotMode(2);
        this.koE.setThreeDotMode(2);
        this.kos.setShadowEnabled(false);
        this.kow.setShadowEnabled(false);
        this.koA.setShadowEnabled(false);
        this.kop.setOnClickListener(this);
        this.kot.setOnClickListener(this);
        this.kox.setOnClickListener(this);
        this.koB.setOnClickListener(this);
        this.kog.addHeaderView(this.mHeaderView);
        cUa();
        this.gfT = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kod.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gkz);
        }
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.gfT.setProgressView(this.mPullView);
        this.bzs = new View(this.kod.getFragmentActivity());
        this.bzs.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.kod.getFragmentActivity(), R.dimen.ds150)));
        this.kog.addFooterView(this.bzs);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cUa() {
        if (this.kog != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
            aq aqVar = new aq("c13616");
            aqVar.aj("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aqVar);
            if (areNotificationsEnabled) {
                if (this.koH != null) {
                    this.kog.removeHeaderView(this.koH.getView());
                    this.koI = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bnH().getLong("key_im_open_notification_close_time", 0L);
            if (this.koI) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.koH == null) {
                    this.koH = new com.baidu.tieba.imMessageCenter.mention.base.f(this.mContext);
                    this.koH.a(this.koJ);
                }
                this.kog.addHeaderView(this.koH.getView(), 0);
                this.koI = true;
            }
        }
    }

    private boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kod.getPageContext(), i);
        }
        if (this.koj != null) {
            this.koj.onChangeSkinType(i);
        }
        if (this.koi != null) {
            this.koi.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.gfT, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.kor, R.color.cp_cont_b);
        ap.setViewTextColor(this.kov, R.color.cp_cont_b);
        ap.setViewTextColor(this.koz, R.color.cp_cont_b);
        ap.setViewTextColor(this.koD, R.color.cp_cont_b);
        ap.setImageResource(this.koq, R.drawable.pic_information_at_me);
        ap.setImageResource(this.kou, R.drawable.pic_information_praise);
        ap.setImageResource(this.koy, R.drawable.pic_information_reply);
        ap.setImageResource(this.koC, R.drawable.pic_information_fans);
        if (this.kos != null) {
            this.kos.onChangeSkinType();
        }
        if (this.kow != null) {
            this.kow.onChangeSkinType();
        }
        if (this.koA != null) {
            this.koA.onChangeSkinType();
        }
        if (this.koE != null) {
            this.koE.onChangeSkinType();
        }
        if (this.koH != null) {
            this.koH.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    protected void onUserChanged(boolean z) {
        aj(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.kol = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.kok != null && e.this.kok.isShowing() && e.this.kod != null) {
                    e.this.kok.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.koe.asyncDeleteItem(imMessageCenterShowItemData, e.this.jSW);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.kod.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.kok = new com.baidu.tbadk.core.dialog.i(this.kod.getPageContext());
        this.kok.a(null, new String[]{string}, this.kol);
    }

    protected boolean ou(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.kog.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void ss(boolean z) {
        if (z) {
            if (cUb() && this.koj.getVisibility() != 0) {
                this.koj.setVisibility(0);
            }
        } else if (this.koj.getVisibility() != 8) {
            this.koj.setVisibility(8);
        }
    }

    public void aj(boolean z, boolean z2) {
    }

    public boolean cUb() {
        return this.kom;
    }

    public void st(boolean z) {
        this.kom = z;
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
                if (this.koe != null) {
                    this.koe.insertOrUpdate(data, this.jSV);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.koe != null) {
                this.koe.remove(data, this.jSV);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.koe != null) {
                this.koe.setData(data, this.jSV);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.koo = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.koo != -1) {
                sq(true);
                onPrimary();
            }
        }
    }

    public void so(boolean z) {
        if (z && this.kog != null && this.kog.getWrappedAdapter() != null && this.kog.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.kog.startPullRefresh();
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
                cUc();
            }
        }
    }

    private void cUc() {
        if (this.koi != null) {
            this.koi.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMM() {
        GU();
        if (this.jSS == null) {
            this.jSS = com.baidu.tieba.im.db.e.cOv().fz(getPageContext().getPageActivity());
        }
        this.jSS.show();
        this.jSS.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU() {
        if (this.jSS != null && this.jSS.isShowing()) {
            this.jSS.dismiss();
            this.jSS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMN() {
        if (this.kog != null && this.koe != null) {
            this.kog.completePullRefreshPostDelayed(0L);
            if (this.koe.getData() != null) {
                this.koi.setData(this.koe.getData());
            } else {
                aj(isLogin(), true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar = new aq("c13720");
        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
        if (view == this.kop) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bts().btG();
            com.baidu.tbadk.coreExtra.messageCenter.b.bts().setMsgAtme(0);
            this.koF = 0;
            Dr(this.koF);
            TiebaStatic.log("c12925");
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            aqVar.aj("obj_type", 1);
        } else if (view == this.kot) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bts().btH();
            com.baidu.tbadk.coreExtra.messageCenter.b.bts().qy(0);
            this.koG = 0;
            Du(this.koG);
            TiebaStatic.log("c12926");
            aqVar.aj("obj_type", 2);
        } else if (view == this.kox) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bts().btF();
            com.baidu.tbadk.coreExtra.messageCenter.b.bts().setMsgReplyme(0);
            Ds(0);
        } else if (view == this.koB) {
            com.baidu.tieba.p.a.dzw().h(2, false, true);
            TiebaStatic.log(new aq("c12523").aj("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
            com.baidu.tbadk.coreExtra.messageCenter.b.bts().btI();
            com.baidu.tbadk.coreExtra.messageCenter.b.bts().setMsgFans(0);
            Dt(0);
        }
        TiebaStatic.log(aqVar);
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.koF = newsNotifyMessage.getMsgAtme();
            this.koG = newsNotifyMessage.getMsgAgree();
            Dr(this.koF);
            Du(this.koG);
            Dt(newsNotifyMessage.getMsgFans());
            Ds(newsNotifyMessage.getMsgReplyme());
        }
    }

    private void Dr(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.btV().btY() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.btV().bua()) {
                i = 0;
            }
            a(i, this.kos);
            this.kos.setThreeDotMode(2);
            this.kos.refresh(i);
            this.kos.setVisibility(0);
            return;
        }
        this.kos.setVisibility(8);
    }

    private void Ds(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.btV().btY() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.btV().buc()) {
                i = 0;
            }
            a(i, this.koA);
            this.koA.setThreeDotMode(2);
            this.koA.refresh(i);
            this.koA.setVisibility(0);
            return;
        }
        this.koA.setVisibility(8);
    }

    private void Dt(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.btV().btY() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.btV().bub()) {
                i = 0;
            }
            a(i, this.koE);
            this.koE.setThreeDotMode(2);
            this.koE.refresh(i);
            this.koE.setVisibility(0);
            return;
        }
        this.koE.setVisibility(8);
    }

    private void Du(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.btV().btY() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.btV().bum()) {
                i = 0;
            }
            a(i, this.kow);
            this.kow.setThreeDotMode(2);
            this.kow.refresh(i);
            this.kow.setVisibility(0);
            return;
        }
        this.kow.setVisibility(8);
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
