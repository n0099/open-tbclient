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
    private BdSwipeRefreshLayout gty;
    private final f.c gyc;
    private final CustomMessageListener iUu;
    private boolean isNeedRefresh;
    private MessageRedDotView kIA;
    private View kIB;
    private ImageView kIC;
    private TextView kID;
    private MessageRedDotView kIE;
    private int kIF;
    private int kIG;
    private com.baidu.tieba.imMessageCenter.mention.base.f kIH;
    private boolean kII;
    private f.a kIJ;
    private final AdapterView.OnItemLongClickListener kIK;
    private final ChatAggregationFragment kId;
    private ImMessageCenterModel kIe;
    private ImMessageCenterShowItemData kIf;
    private BdListView kIg;
    private NavigationBarShadowView kIh;
    private MessageAggregationListAdapter kIi;
    private ShutDownValidateTipView kIj;
    private com.baidu.tbadk.core.dialog.i kIk;
    private k.c kIl;
    private boolean kIm;
    private boolean kIn;
    private int kIo;
    private View kIp;
    private ImageView kIq;
    private TextView kIr;
    private MessageRedDotView kIs;
    private View kIt;
    private ImageView kIu;
    private TextView kIv;
    private MessageRedDotView kIw;
    private View kIx;
    private ImageView kIy;
    private TextView kIz;
    private com.baidu.tbadk.core.dialog.d knd;
    private final CustomMessageListener kne;
    private com.baidu.tieba.im.chat.a.a kng;
    private final com.baidu.tieba.im.chat.a.b knh;
    private View mHeaderView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) com.baidu.adp.base.i.J(chatAggregationFragment.getPageContext().getPageActivity()));
        this.kIe = null;
        this.kIf = null;
        this.kIg = null;
        this.kIi = null;
        this.kIk = null;
        this.kIm = true;
        this.azx = false;
        this.isNeedRefresh = false;
        this.kIn = true;
        this.kIo = 16;
        this.kII = false;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.kIh.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.kIh.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.kIh.hide();
                }
            }
        };
        this.gyc = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (e.this.gty != null) {
                        e.this.gty.setRefreshing(false);
                        return;
                    }
                    return;
                }
                e.this.td(true);
                e.this.pc(false);
            }
        };
        this.kIJ = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (e.this.kIH != null) {
                    e.this.kIg.removeHeaderView(e.this.kIH.getView());
                    e.this.kII = false;
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData DM = e.this.kIi.getItem(i);
                    TiebaStatic.eventStat(e.this.kId.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    ar arVar = new ar("c13720");
                    arVar.w("uid", TbadkApplication.getCurrentAccountId());
                    String ownerName = DM.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(DM);
                        arVar.al("obj_type", 6);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kId.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.kId.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.kId.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(DM.getFriendId(), 0L), DM.getFriendName(), 0L, "msg_lstb")));
                        } else {
                            return;
                        }
                    } else if (DM.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kId.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(DM);
                            arVar.al("obj_type", 7);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.byI().bze() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.byI().bze().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.kId.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (DM.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kId.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(DM);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.byI().bze() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.byI().bze().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.kId.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("5")) {
                        TiebaStatic.log("c12931");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarFeedActivityConfig(e.this.kId.getPageContext().getPageActivity())));
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.kId.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.kId.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(DM.getFriendId(), 0L), DM.getFriendNameShow(), DM.getFriendPortrait(), 0, DM.getUserType())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ar("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.kId.getPageContext().getPageActivity())));
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
                                com.baidu.tieba.im.db.d.cVP().Ni("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.cVP().Ni("group_intro_change");
                                com.baidu.tieba.im.db.d.cVP().Ni("group_name_change");
                                com.baidu.tieba.im.db.d.cVP().Ni("group_notice_change");
                                com.baidu.tieba.im.db.d.cVP().Ni("group_level_up");
                                com.baidu.tieba.im.db.d.cVP().Ni("dismiss_group");
                                com.baidu.tieba.im.db.d.cVP().Ni("kick_out");
                                com.baidu.tieba.im.db.d.cVP().Ni("group_activitys_change");
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.kId.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.kIK = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.kIf = e.this.kIi.getItem(i);
                e.this.c(e.this.kIf);
                if (e.this.kIk != null) {
                    TiebaStatic.log("c12932");
                    e.this.kIk.RU();
                    if (e.this.kId != null && e.this.kId.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.kId.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.kne = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
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
                        e.this.kIe.setData(null, e.this.kng);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.kIi != null) {
                            e.this.kIi.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.kIi != null) {
                        e.this.kIi.notifyDataSetChanged();
                    }
                }
            }
        };
        this.kng = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cUi();
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
        this.knh = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cUh();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.knd != null) {
                    e.this.knd.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.ID();
                e.this.kId.showToast(R.string.delete_success, false);
                e.this.cUi();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.ID();
            }
        };
        this.iUu = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    e.this.b((NewsNotifyMessage) customResponsedMessage);
                }
            }
        };
        this.kId = chatAggregationFragment;
    }

    public void as(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.kIo = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.kIo = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.kIo);
        }
    }

    public void cKv() {
        if (this.kIi != null) {
            this.kIi.notifyDataSetChanged();
        }
    }

    public void cIC() {
        MessageManager.getInstance().unRegisterListener(this.kne);
        MessageManager.getInstance().unRegisterListener(this.flC);
    }

    public View bVG() {
        this.eZW = 3;
        this.rootView = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        cH(this.rootView);
        TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        csS();
        return this.rootView;
    }

    public Activity getActivity() {
        return this.kId.getPageContext().getPageActivity();
    }

    protected void csS() {
        this.kIg.startPullRefresh();
        this.azx = isLogin();
        if (!this.azx) {
            aj(this.azx, true);
        }
    }

    private void registerListener() {
        this.kId.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.kne);
        this.kId.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.kne);
        this.kId.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.kne);
        this.kId.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.kne);
        this.kId.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.kne);
        this.kId.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.kne);
        this.kId.registerListener(this.flC);
        this.kId.registerListener(this.iUu);
    }

    public void VC() {
        if (this.gty != null && !this.gty.isRefreshing()) {
            td(true);
        }
    }

    public void td(boolean z) {
        if (this.gty != null) {
            if (z && this.kIg != null && this.kIg.getFirstVisiblePosition() != 0) {
                this.kIg.setSelection(0);
            }
            this.gty.setRefreshing(z);
        }
    }

    public void te(boolean z) {
        this.isNeedRefresh = z;
    }

    public void tf(boolean z) {
        this.kIn = z;
    }

    public void onPrimary() {
        if (this.kIi != null && this.kIi.getCount() == 0) {
            te(true);
        }
        if (this.kIn || this.isNeedRefresh) {
            this.kIn = false;
            this.isNeedRefresh = false;
            pc(false);
        }
        boolean isLogin = isLogin();
        if (this.azx != isLogin) {
            this.azx = isLogin;
            onUserChanged(this.azx);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kId.getPageContext());
        }
        dbt();
    }

    private void initData() {
        this.kIe = new ImMessageCenterModel();
        th(com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void cH(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.kIj = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.kIj.setVisibility(8);
        this.kIj.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.th(false);
                e.this.tg(false);
            }
        });
        this.kIh = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.kIg = (BdListView) view.findViewById(R.id.chat_list_content);
        this.kIg.setDividerHeight(0);
        this.kIi = new MessageAggregationListAdapter(this.kId.getPageContext().getPageActivity());
        this.kIi.a(this);
        this.kIg.setAdapter((ListAdapter) this.kIi);
        this.kIg.setOnItemClickListener(this.mItemClickListener);
        this.kIg.setOnItemLongClickListener(this.kIK);
        this.kIg.setOnScrollListener(this.mOnScrollListener);
        this.mHeaderView = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
        this.kIp = this.mHeaderView.findViewById(R.id.at_me_layout);
        this.kIq = (ImageView) this.mHeaderView.findViewById(R.id.at_me_icon);
        this.kIr = (TextView) this.mHeaderView.findViewById(R.id.at_me_text);
        this.kIs = (MessageRedDotView) this.mHeaderView.findViewById(R.id.at_me_new_message);
        this.kIt = this.mHeaderView.findViewById(R.id.agree_me_layout);
        this.kIu = (ImageView) this.mHeaderView.findViewById(R.id.agree_me_icon);
        this.kIv = (TextView) this.mHeaderView.findViewById(R.id.agree_me_text);
        this.kIw = (MessageRedDotView) this.mHeaderView.findViewById(R.id.agree_me_new_message);
        this.kIx = this.mHeaderView.findViewById(R.id.reply_me_layout);
        this.kIy = (ImageView) this.mHeaderView.findViewById(R.id.reply_me_icon);
        this.kIz = (TextView) this.mHeaderView.findViewById(R.id.reply_me_text);
        this.kIA = (MessageRedDotView) this.mHeaderView.findViewById(R.id.reply_me_new_message);
        this.kIB = this.mHeaderView.findViewById(R.id.fans_layout);
        this.kIC = (ImageView) this.mHeaderView.findViewById(R.id.fans_icon);
        this.kID = (TextView) this.mHeaderView.findViewById(R.id.fans_text);
        this.kIE = (MessageRedDotView) this.mHeaderView.findViewById(R.id.fans_new_message);
        this.kIs.setThreeDotMode(2);
        this.kIw.setThreeDotMode(2);
        this.kIA.setThreeDotMode(2);
        this.kIE.setThreeDotMode(2);
        this.kIs.setShadowEnabled(false);
        this.kIw.setShadowEnabled(false);
        this.kIA.setShadowEnabled(false);
        this.kIp.setOnClickListener(this);
        this.kIt.setOnClickListener(this);
        this.kIx.setOnClickListener(this);
        this.kIB.setOnClickListener(this);
        this.kIg.addHeaderView(this.mHeaderView);
        dbt();
        this.gty = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kId.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gyc);
        }
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.gty.setProgressView(this.mPullView);
        this.bJa = new View(this.kId.getFragmentActivity());
        this.bJa.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.kId.getFragmentActivity(), R.dimen.ds150)));
        this.kIg.addFooterView(this.bJa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dbt() {
        if (this.kIg != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
            ar arVar = new ar("c13616");
            arVar.al("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(arVar);
            if (areNotificationsEnabled) {
                if (this.kIH != null) {
                    this.kIg.removeHeaderView(this.kIH.getView());
                    this.kII = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bsO().getLong("key_im_open_notification_close_time", 0L);
            if (this.kII) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kIH == null) {
                    this.kIH = new com.baidu.tieba.imMessageCenter.mention.base.f(this.mContext);
                    this.kIH.a(this.kIJ);
                }
                this.kIg.addHeaderView(this.kIH.getView(), 0);
                this.kII = true;
            }
        }
    }

    private boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kId.getPageContext(), i);
        }
        if (this.kIj != null) {
            this.kIj.onChangeSkinType(i);
        }
        if (this.kIi != null) {
            this.kIi.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gty, R.color.CAM_X0205);
        ap.setViewTextColor(this.kIr, R.color.CAM_X0105);
        ap.setViewTextColor(this.kIv, R.color.CAM_X0105);
        ap.setViewTextColor(this.kIz, R.color.CAM_X0105);
        ap.setViewTextColor(this.kID, R.color.CAM_X0105);
        ap.setImageResource(this.kIq, R.drawable.pic_information_at_me);
        ap.setImageResource(this.kIu, R.drawable.pic_information_praise);
        ap.setImageResource(this.kIy, R.drawable.pic_information_reply);
        ap.setImageResource(this.kIC, R.drawable.pic_information_fans);
        if (this.kIs != null) {
            this.kIs.onChangeSkinType();
        }
        if (this.kIw != null) {
            this.kIw.onChangeSkinType();
        }
        if (this.kIA != null) {
            this.kIA.onChangeSkinType();
        }
        if (this.kIE != null) {
            this.kIE.onChangeSkinType();
        }
        if (this.kIH != null) {
            this.kIH.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    protected void onUserChanged(boolean z) {
        aj(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.kIl = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.kIk != null && e.this.kIk.isShowing() && e.this.kId != null) {
                    e.this.kIk.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.kIe.asyncDeleteItem(imMessageCenterShowItemData, e.this.knh);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.kId.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.kIk = new com.baidu.tbadk.core.dialog.i(this.kId.getPageContext());
        this.kIk.a(null, new String[]{string}, this.kIl);
    }

    protected boolean pc(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.kIg.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void tg(boolean z) {
        if (z) {
            if (dbu() && this.kIj.getVisibility() != 0) {
                this.kIj.setVisibility(0);
            }
        } else if (this.kIj.getVisibility() != 8) {
            this.kIj.setVisibility(8);
        }
    }

    public void aj(boolean z, boolean z2) {
    }

    public boolean dbu() {
        return this.kIm;
    }

    public void th(boolean z) {
        this.kIm = z;
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
                if (this.kIe != null) {
                    this.kIe.insertOrUpdate(data, this.kng);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.kIe != null) {
                this.kIe.remove(data, this.kng);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.kIe != null) {
                this.kIe.setData(data, this.kng);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.kIo = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.kIo != -1) {
                te(true);
                onPrimary();
            }
        }
    }

    public void tc(boolean z) {
        if (z && this.kIg != null && this.kIg.getWrappedAdapter() != null && this.kIg.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.kIg.startPullRefresh();
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
                dbv();
            }
        }
    }

    private void dbv() {
        if (this.kIi != null) {
            this.kIi.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUh() {
        ID();
        if (this.knd == null) {
            this.knd = com.baidu.tieba.im.db.e.cVQ().gf(getPageContext().getPageActivity());
        }
        this.knd.show();
        this.knd.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ID() {
        if (this.knd != null && this.knd.isShowing()) {
            this.knd.dismiss();
            this.knd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUi() {
        if (this.kIg != null && this.kIe != null) {
            this.kIg.completePullRefreshPostDelayed(0L);
            if (this.kIe.getData() != null) {
                this.kIi.setData(this.kIe.getData());
            } else {
                aj(isLogin(), true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar arVar = new ar("c13720");
        arVar.w("uid", TbadkApplication.getCurrentAccountId());
        if (view == this.kIp) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().byW();
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgAtme(0);
            this.kIF = 0;
            ER(this.kIF);
            TiebaStatic.log("c12925");
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            arVar.al("obj_type", 1);
        } else if (view == this.kIt) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().byX();
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().rH(0);
            this.kIG = 0;
            EU(this.kIG);
            TiebaStatic.log("c12926");
            arVar.al("obj_type", 2);
        } else if (view == this.kIx) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().byV();
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgReplyme(0);
            ES(0);
        } else if (view == this.kIB) {
            com.baidu.tieba.q.a.dGN().h(2, false, true);
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
            this.kIF = newsNotifyMessage.getMsgAtme();
            this.kIG = newsNotifyMessage.getMsgAgree();
            ER(this.kIF);
            EU(this.kIG);
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
            a(i, this.kIs);
            this.kIs.setThreeDotMode(2);
            this.kIs.refresh(i);
            this.kIs.setVisibility(0);
            return;
        }
        this.kIs.setVisibility(8);
    }

    private void ES(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzo() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzs()) {
                i = 0;
            }
            a(i, this.kIA);
            this.kIA.setThreeDotMode(2);
            this.kIA.refresh(i);
            this.kIA.setVisibility(0);
            return;
        }
        this.kIA.setVisibility(8);
    }

    private void ET(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzo() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzr()) {
                i = 0;
            }
            a(i, this.kIE);
            this.kIE.setThreeDotMode(2);
            this.kIE.refresh(i);
            this.kIE.setVisibility(0);
            return;
        }
        this.kIE.setVisibility(8);
    }

    private void EU(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzo() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzC()) {
                i = 0;
            }
            a(i, this.kIw);
            this.kIw.setThreeDotMode(2);
            this.kIw.refresh(i);
            this.kIw.setVisibility(0);
            return;
        }
        this.kIw.setVisibility(8);
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
