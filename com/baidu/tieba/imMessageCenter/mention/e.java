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
import com.baidu.tieba.imMessageCenter.mention.base.f;
import java.util.List;
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements View.OnClickListener, f.c {
    private boolean azx;
    private View bJa;
    private int eZW;
    private final CustomMessageListener flC;
    private BdSwipeRefreshLayout gtA;
    private final f.c gye;
    private final CustomMessageListener iUw;
    private boolean isNeedRefresh;
    private ImageView kIA;
    private TextView kIB;
    private MessageRedDotView kIC;
    private View kID;
    private ImageView kIE;
    private TextView kIF;
    private MessageRedDotView kIG;
    private int kIH;
    private int kII;
    private com.baidu.tieba.imMessageCenter.mention.base.f kIJ;
    private boolean kIK;
    private f.a kIL;
    private final AdapterView.OnItemLongClickListener kIM;
    private final ChatAggregationFragment kIf;
    private ImMessageCenterModel kIg;
    private ImMessageCenterShowItemData kIh;
    private BdListView kIi;
    private NavigationBarShadowView kIj;
    private MessageAggregationListAdapter kIk;
    private ShutDownValidateTipView kIl;
    private com.baidu.tbadk.core.dialog.i kIm;
    private k.c kIn;
    private boolean kIo;
    private boolean kIp;
    private int kIq;
    private View kIr;
    private ImageView kIs;
    private TextView kIt;
    private MessageRedDotView kIu;
    private View kIv;
    private ImageView kIw;
    private TextView kIx;
    private MessageRedDotView kIy;
    private View kIz;
    private com.baidu.tbadk.core.dialog.d knf;
    private final CustomMessageListener kng;
    private com.baidu.tieba.im.chat.a.a kni;
    private final com.baidu.tieba.im.chat.a.b knj;
    private View mHeaderView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) com.baidu.adp.base.i.J(chatAggregationFragment.getPageContext().getPageActivity()));
        this.kIg = null;
        this.kIh = null;
        this.kIi = null;
        this.kIk = null;
        this.kIm = null;
        this.kIo = true;
        this.azx = false;
        this.isNeedRefresh = false;
        this.kIp = true;
        this.kIq = 16;
        this.kIK = false;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.kIj.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.kIj.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.kIj.hide();
                }
            }
        };
        this.gye = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (e.this.gtA != null) {
                        e.this.gtA.setRefreshing(false);
                        return;
                    }
                    return;
                }
                e.this.td(true);
                e.this.pc(false);
            }
        };
        this.kIL = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (e.this.kIJ != null) {
                    e.this.kIi.removeHeaderView(e.this.kIJ.getView());
                    e.this.kIK = false;
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData DM = e.this.kIk.getItem(i);
                    TiebaStatic.eventStat(e.this.kIf.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    ar arVar = new ar("c13720");
                    arVar.w("uid", TbadkApplication.getCurrentAccountId());
                    String ownerName = DM.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(DM);
                        arVar.al("obj_type", 6);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kIf.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.kIf.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.kIf.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(DM.getFriendId(), 0L), DM.getFriendName(), 0L, "msg_lstb")));
                        } else {
                            return;
                        }
                    } else if (DM.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kIf.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(DM);
                            arVar.al("obj_type", 7);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.byI().bze() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.byI().bze().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.kIf.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (DM.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kIf.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(DM);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.byI().bze() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.byI().bze().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.kIf.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("5")) {
                        TiebaStatic.log("c12931");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarFeedActivityConfig(e.this.kIf.getPageContext().getPageActivity())));
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kIf.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.kIf.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(DM.getFriendId(), 0L), DM.getFriendNameShow(), DM.getFriendPortrait(), 0, DM.getUserType())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ar("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.kIf.getPageContext().getPageActivity())));
                        arVar.al("obj_type", 6);
                        return;
                    } else {
                        e(DM);
                        arVar.al("obj_type", 6);
                    }
                    if (!TextUtils.isEmpty(DM.getFriendName())) {
                        if ("贴吧热榜".equals(DM.getFriendName())) {
                            arVar.al("obj_type", 8);
                        } else if ("贴吧荣誉墙".equals(DM.getFriendName())) {
                            arVar.al("obj_type", 9);
                        } else if ("贴吧精选".equals(DM.getFriendName())) {
                            arVar.al("obj_type", 10);
                        } else if ("贴吧活动".equals(DM.getFriendName())) {
                            arVar.al("obj_type", 4);
                        } else if ("吧广播".equals(DM.getFriendName())) {
                            arVar.al("obj_type", 5);
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
                                com.baidu.tieba.im.db.d.cVQ().Ni("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.cVQ().Ni("group_intro_change");
                                com.baidu.tieba.im.db.d.cVQ().Ni("group_name_change");
                                com.baidu.tieba.im.db.d.cVQ().Ni("group_notice_change");
                                com.baidu.tieba.im.db.d.cVQ().Ni("group_level_up");
                                com.baidu.tieba.im.db.d.cVQ().Ni("dismiss_group");
                                com.baidu.tieba.im.db.d.cVQ().Ni("kick_out");
                                com.baidu.tieba.im.db.d.cVQ().Ni("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.byI().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.kIf.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.kIM = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.kIh = e.this.kIk.getItem(i);
                e.this.c(e.this.kIh);
                if (e.this.kIm != null) {
                    TiebaStatic.log("c12932");
                    e.this.kIm.RU();
                    if (e.this.kIf != null && e.this.kIf.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.kIf.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.kng = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
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
                        e.this.td(false);
                    } else if (customResponsedMessage.getCmd() == 2016001) {
                        e.this.kIg.setData(null, e.this.kni);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.kIk != null) {
                            e.this.kIk.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.kIk != null) {
                        e.this.kIk.notifyDataSetChanged();
                    }
                }
            }
        };
        this.kni = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cUj();
            }
        };
        this.flC = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.knj = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cUi();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.knf != null) {
                    e.this.knf.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.ID();
                e.this.kIf.showToast(R.string.delete_success, false);
                e.this.cUj();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.ID();
            }
        };
        this.iUw = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    e.this.b((NewsNotifyMessage) customResponsedMessage);
                }
            }
        };
        this.kIf = chatAggregationFragment;
    }

    public void as(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.kIq = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.kIq = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.kIq);
        }
    }

    public void cKw() {
        if (this.kIk != null) {
            this.kIk.notifyDataSetChanged();
        }
    }

    public void cID() {
        MessageManager.getInstance().unRegisterListener(this.kng);
        MessageManager.getInstance().unRegisterListener(this.flC);
    }

    public View bVH() {
        this.eZW = 3;
        this.rootView = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        cH(this.rootView);
        TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        csT();
        return this.rootView;
    }

    public Activity getActivity() {
        return this.kIf.getPageContext().getPageActivity();
    }

    protected void csT() {
        this.kIi.startPullRefresh();
        this.azx = isLogin();
        if (!this.azx) {
            aj(this.azx, true);
        }
    }

    private void registerListener() {
        this.kIf.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.kng);
        this.kIf.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.kng);
        this.kIf.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.kng);
        this.kIf.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.kng);
        this.kIf.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.kng);
        this.kIf.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.kng);
        this.kIf.registerListener(this.flC);
        this.kIf.registerListener(this.iUw);
    }

    public void VC() {
        if (this.gtA != null && !this.gtA.isRefreshing()) {
            td(true);
        }
    }

    public void td(boolean z) {
        if (this.gtA != null) {
            if (z && this.kIi != null && this.kIi.getFirstVisiblePosition() != 0) {
                this.kIi.setSelection(0);
            }
            this.gtA.setRefreshing(z);
        }
    }

    public void te(boolean z) {
        this.isNeedRefresh = z;
    }

    public void tf(boolean z) {
        this.kIp = z;
    }

    public void onPrimary() {
        if (this.kIk != null && this.kIk.getCount() == 0) {
            te(true);
        }
        if (this.kIp || this.isNeedRefresh) {
            this.kIp = false;
            this.isNeedRefresh = false;
            pc(false);
        }
        boolean isLogin = isLogin();
        if (this.azx != isLogin) {
            this.azx = isLogin;
            onUserChanged(this.azx);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kIf.getPageContext());
        }
        dbu();
    }

    private void initData() {
        this.kIg = new ImMessageCenterModel();
        th(com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void cH(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.kIl = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.kIl.setVisibility(8);
        this.kIl.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.th(false);
                e.this.tg(false);
            }
        });
        this.kIj = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.kIi = (BdListView) view.findViewById(R.id.chat_list_content);
        this.kIi.setDividerHeight(0);
        this.kIk = new MessageAggregationListAdapter(this.kIf.getPageContext().getPageActivity());
        this.kIk.a(this);
        this.kIi.setAdapter((ListAdapter) this.kIk);
        this.kIi.setOnItemClickListener(this.mItemClickListener);
        this.kIi.setOnItemLongClickListener(this.kIM);
        this.kIi.setOnScrollListener(this.mOnScrollListener);
        this.mHeaderView = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
        this.kIr = this.mHeaderView.findViewById(R.id.at_me_layout);
        this.kIs = (ImageView) this.mHeaderView.findViewById(R.id.at_me_icon);
        this.kIt = (TextView) this.mHeaderView.findViewById(R.id.at_me_text);
        this.kIu = (MessageRedDotView) this.mHeaderView.findViewById(R.id.at_me_new_message);
        this.kIv = this.mHeaderView.findViewById(R.id.agree_me_layout);
        this.kIw = (ImageView) this.mHeaderView.findViewById(R.id.agree_me_icon);
        this.kIx = (TextView) this.mHeaderView.findViewById(R.id.agree_me_text);
        this.kIy = (MessageRedDotView) this.mHeaderView.findViewById(R.id.agree_me_new_message);
        this.kIz = this.mHeaderView.findViewById(R.id.reply_me_layout);
        this.kIA = (ImageView) this.mHeaderView.findViewById(R.id.reply_me_icon);
        this.kIB = (TextView) this.mHeaderView.findViewById(R.id.reply_me_text);
        this.kIC = (MessageRedDotView) this.mHeaderView.findViewById(R.id.reply_me_new_message);
        this.kID = this.mHeaderView.findViewById(R.id.fans_layout);
        this.kIE = (ImageView) this.mHeaderView.findViewById(R.id.fans_icon);
        this.kIF = (TextView) this.mHeaderView.findViewById(R.id.fans_text);
        this.kIG = (MessageRedDotView) this.mHeaderView.findViewById(R.id.fans_new_message);
        this.kIu.setThreeDotMode(2);
        this.kIy.setThreeDotMode(2);
        this.kIC.setThreeDotMode(2);
        this.kIG.setThreeDotMode(2);
        this.kIu.setShadowEnabled(false);
        this.kIy.setShadowEnabled(false);
        this.kIC.setShadowEnabled(false);
        this.kIr.setOnClickListener(this);
        this.kIv.setOnClickListener(this);
        this.kIz.setOnClickListener(this);
        this.kID.setOnClickListener(this);
        this.kIi.addHeaderView(this.mHeaderView);
        dbu();
        this.gtA = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kIf.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gye);
        }
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.gtA.setProgressView(this.mPullView);
        this.bJa = new View(this.kIf.getFragmentActivity());
        this.bJa.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.kIf.getFragmentActivity(), R.dimen.ds150)));
        this.kIi.addFooterView(this.bJa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dbu() {
        if (this.kIi != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
            ar arVar = new ar("c13616");
            arVar.al("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(arVar);
            if (areNotificationsEnabled) {
                if (this.kIJ != null) {
                    this.kIi.removeHeaderView(this.kIJ.getView());
                    this.kIK = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bsO().getLong("key_im_open_notification_close_time", 0L);
            if (this.kIK) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kIJ == null) {
                    this.kIJ = new com.baidu.tieba.imMessageCenter.mention.base.f(this.mContext);
                    this.kIJ.a(this.kIL);
                }
                this.kIi.addHeaderView(this.kIJ.getView(), 0);
                this.kIK = true;
            }
        }
    }

    private boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kIf.getPageContext(), i);
        }
        if (this.kIl != null) {
            this.kIl.onChangeSkinType(i);
        }
        if (this.kIk != null) {
            this.kIk.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gtA, R.color.CAM_X0205);
        ap.setViewTextColor(this.kIt, R.color.CAM_X0105);
        ap.setViewTextColor(this.kIx, R.color.CAM_X0105);
        ap.setViewTextColor(this.kIB, R.color.CAM_X0105);
        ap.setViewTextColor(this.kIF, R.color.CAM_X0105);
        ap.setImageResource(this.kIs, R.drawable.pic_information_at_me);
        ap.setImageResource(this.kIw, R.drawable.pic_information_praise);
        ap.setImageResource(this.kIA, R.drawable.pic_information_reply);
        ap.setImageResource(this.kIE, R.drawable.pic_information_fans);
        if (this.kIu != null) {
            this.kIu.onChangeSkinType();
        }
        if (this.kIy != null) {
            this.kIy.onChangeSkinType();
        }
        if (this.kIC != null) {
            this.kIC.onChangeSkinType();
        }
        if (this.kIG != null) {
            this.kIG.onChangeSkinType();
        }
        if (this.kIJ != null) {
            this.kIJ.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    protected void onUserChanged(boolean z) {
        aj(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.kIn = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.kIm != null && e.this.kIm.isShowing() && e.this.kIf != null) {
                    e.this.kIm.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.kIg.asyncDeleteItem(imMessageCenterShowItemData, e.this.knj);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.kIf.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.kIm = new com.baidu.tbadk.core.dialog.i(this.kIf.getPageContext());
        this.kIm.a(null, new String[]{string}, this.kIn);
    }

    protected boolean pc(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.kIi.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void tg(boolean z) {
        if (z) {
            if (dbv() && this.kIl.getVisibility() != 0) {
                this.kIl.setVisibility(0);
            }
        } else if (this.kIl.getVisibility() != 8) {
            this.kIl.setVisibility(8);
        }
    }

    public void aj(boolean z, boolean z2) {
    }

    public boolean dbv() {
        return this.kIo;
    }

    public void th(boolean z) {
        this.kIo = z;
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
                if (this.kIg != null) {
                    this.kIg.insertOrUpdate(data, this.kni);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.kIg != null) {
                this.kIg.remove(data, this.kni);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.kIg != null) {
                this.kIg.setData(data, this.kni);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.kIq = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.kIq != -1) {
                te(true);
                onPrimary();
            }
        }
    }

    public void tc(boolean z) {
        if (z && this.kIi != null && this.kIi.getWrappedAdapter() != null && this.kIi.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.kIi.startPullRefresh();
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
                dbw();
            }
        }
    }

    private void dbw() {
        if (this.kIk != null) {
            this.kIk.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUi() {
        ID();
        if (this.knf == null) {
            this.knf = com.baidu.tieba.im.db.e.cVR().gf(getPageContext().getPageActivity());
        }
        this.knf.show();
        this.knf.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ID() {
        if (this.knf != null && this.knf.isShowing()) {
            this.knf.dismiss();
            this.knf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUj() {
        if (this.kIi != null && this.kIg != null) {
            this.kIi.completePullRefreshPostDelayed(0L);
            if (this.kIg.getData() != null) {
                this.kIk.setData(this.kIg.getData());
            } else {
                aj(isLogin(), true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar arVar = new ar("c13720");
        arVar.w("uid", TbadkApplication.getCurrentAccountId());
        if (view == this.kIr) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().byW();
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgAtme(0);
            this.kIH = 0;
            ER(this.kIH);
            TiebaStatic.log("c12925");
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            arVar.al("obj_type", 1);
        } else if (view == this.kIv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().byX();
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().rH(0);
            this.kII = 0;
            EU(this.kII);
            TiebaStatic.log("c12926");
            arVar.al("obj_type", 2);
        } else if (view == this.kIz) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().byV();
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgReplyme(0);
            ES(0);
        } else if (view == this.kID) {
            com.baidu.tieba.q.a.dGO().h(2, false, true);
            TiebaStatic.log(new ar("c12523").al("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().byY();
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgFans(0);
            ET(0);
        }
        TiebaStatic.log(arVar);
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.kIH = newsNotifyMessage.getMsgAtme();
            this.kII = newsNotifyMessage.getMsgAgree();
            ER(this.kIH);
            EU(this.kII);
            ET(newsNotifyMessage.getMsgFans());
            ES(newsNotifyMessage.getMsgReplyme());
        }
    }

    private void ER(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzo() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzq()) {
                i = 0;
            }
            a(i, this.kIu);
            this.kIu.setThreeDotMode(2);
            this.kIu.refresh(i);
            this.kIu.setVisibility(0);
            return;
        }
        this.kIu.setVisibility(8);
    }

    private void ES(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzo() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzs()) {
                i = 0;
            }
            a(i, this.kIC);
            this.kIC.setThreeDotMode(2);
            this.kIC.refresh(i);
            this.kIC.setVisibility(0);
            return;
        }
        this.kIC.setVisibility(8);
    }

    private void ET(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzo() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzr()) {
                i = 0;
            }
            a(i, this.kIG);
            this.kIG.setThreeDotMode(2);
            this.kIG.refresh(i);
            this.kIG.setVisibility(0);
            return;
        }
        this.kIG.setVisibility(8);
    }

    private void EU(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzo() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzC()) {
                i = 0;
            }
            a(i, this.kIy);
            this.kIy.setThreeDotMode(2);
            this.kIy.refresh(i);
            this.kIy.setVisibility(0);
            return;
        }
        this.kIy.setVisibility(8);
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
