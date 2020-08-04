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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes16.dex */
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements View.OnClickListener, f.c {
    private View bkz;
    private boolean eFr;
    private int ehn;
    private final CustomMessageListener erZ;
    private BdSwipeRefreshLayout fuP;
    private final f.c fzt;
    private final CustomMessageListener hGY;
    private com.baidu.tbadk.core.dialog.d iTO;
    private final CustomMessageListener iTP;
    private com.baidu.tieba.im.chat.a.a iTR;
    private final com.baidu.tieba.im.chat.a.b iTS;
    private boolean isNeedRefresh;
    private TextView jpA;
    private MessageRedDotView jpB;
    private int jpC;
    private int jpD;
    private com.baidu.tieba.imMessageCenter.mention.base.f jpE;
    private boolean jpF;
    private f.a jpG;
    private final AdapterView.OnItemLongClickListener jpH;
    private final ChatAggregationFragment jpa;
    private ImMessageCenterModel jpb;
    private ImMessageCenterShowItemData jpc;
    private BdListView jpd;
    private NavigationBarShadowView jpe;
    private MessageAggregationListAdapter jpf;
    private ShutDownValidateTipView jpg;
    private com.baidu.tbadk.core.dialog.i jph;
    private k.c jpi;
    private boolean jpj;
    private boolean jpk;
    private int jpl;
    private View jpm;
    private ImageView jpn;
    private TextView jpo;
    private MessageRedDotView jpp;
    private View jpq;
    private ImageView jpr;
    private TextView jps;
    private MessageRedDotView jpt;
    private View jpu;
    private ImageView jpv;
    private TextView jpw;
    private MessageRedDotView jpx;
    private View jpy;
    private ImageView jpz;
    private View mHeaderView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) com.baidu.adp.base.i.G(chatAggregationFragment.getPageContext().getPageActivity()));
        this.jpb = null;
        this.jpc = null;
        this.jpd = null;
        this.jpf = null;
        this.jph = null;
        this.jpj = true;
        this.eFr = false;
        this.isNeedRefresh = false;
        this.jpk = true;
        this.jpl = 16;
        this.jpF = false;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.jpe.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.jpe.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.jpe.hide();
                }
            }
        };
        this.fzt = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (e.this.fuP != null) {
                        e.this.fuP.setRefreshing(false);
                        return;
                    }
                    return;
                }
                e.this.qB(true);
                e.this.mM(false);
            }
        };
        this.jpG = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (e.this.jpE != null) {
                    e.this.jpd.removeHeaderView(e.this.jpE.getView());
                    e.this.jpF = false;
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData ys = e.this.jpf.getItem(i);
                    TiebaStatic.eventStat(e.this.jpa.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    ap apVar = new ap("c13720");
                    apVar.t("uid", TbadkApplication.getCurrentAccountId());
                    String ownerName = ys.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(ys);
                        apVar.ah("obj_type", 6);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jpa.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.jpa.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.jpa.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(ys.getFriendId(), 0L), ys.getFriendName(), 0L, "msg_lstb")));
                        } else {
                            return;
                        }
                    } else if (ys.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jpa.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(ys);
                            apVar.ah("obj_type", 7);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfH() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfH().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.jpa.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ys.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jpa.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(ys);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfH() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfH().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.jpa.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("5")) {
                        TiebaStatic.log("c12931");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarFeedActivityConfig(e.this.jpa.getPageContext().getPageActivity())));
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jpa.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.jpa.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(ys.getFriendId(), 0L), ys.getFriendNameShow(), ys.getFriendPortrait(), 0, ys.getUserType())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ap("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.jpa.getPageContext().getPageActivity())));
                        apVar.ah("obj_type", 6);
                        return;
                    } else {
                        e(ys);
                        apVar.ah("obj_type", 6);
                    }
                    if (!TextUtils.isEmpty(ys.getFriendName())) {
                        if ("贴吧热榜".equals(ys.getFriendName())) {
                            apVar.ah("obj_type", 8);
                        } else if ("贴吧荣誉墙".equals(ys.getFriendName())) {
                            apVar.ah("obj_type", 9);
                        } else if ("贴吧精选".equals(ys.getFriendName())) {
                            apVar.ah("obj_type", 10);
                        } else if ("贴吧活动".equals(ys.getFriendName())) {
                            apVar.ah("obj_type", 4);
                        } else if ("吧广播".equals(ys.getFriendName())) {
                            apVar.ah("obj_type", 5);
                        }
                    }
                    TiebaStatic.log(apVar);
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.ctg().HA("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.ctg().HA("group_intro_change");
                                com.baidu.tieba.im.db.d.ctg().HA("group_name_change");
                                com.baidu.tieba.im.db.d.ctg().HA("group_notice_change");
                                com.baidu.tieba.im.db.d.ctg().HA("group_level_up");
                                com.baidu.tieba.im.db.d.ctg().HA("dismiss_group");
                                com.baidu.tieba.im.db.d.ctg().HA("kick_out");
                                com.baidu.tieba.im.db.d.ctg().HA("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.bfl().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.bfl().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.jpa.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.jpH = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.jpc = e.this.jpf.getItem(i);
                e.this.c(e.this.jpc);
                if (e.this.jph != null) {
                    TiebaStatic.log("c12932");
                    e.this.jph.showDialog();
                    if (e.this.jpa != null && e.this.jpa.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.jpa.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.iTP = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
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
                        e.this.qB(false);
                    } else if (customResponsedMessage.getCmd() == 2016001) {
                        e.this.jpb.setData(null, e.this.iTR);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.jpf != null) {
                            e.this.jpf.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.jpf != null) {
                        e.this.jpf.notifyDataSetChanged();
                    }
                }
            }
        };
        this.iTR = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cry();
            }
        };
        this.erZ = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.iTS = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.crx();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.iTO != null) {
                    e.this.iTO.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.zA();
                e.this.jpa.showToast(R.string.delete_success, false);
                e.this.cry();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.zA();
            }
        };
        this.hGY = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    e.this.b((NewsNotifyMessage) customResponsedMessage);
                }
            }
        };
        this.jpa = chatAggregationFragment;
    }

    public void ar(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.jpl = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.jpl = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.jpl);
        }
    }

    public void ciA() {
        if (this.jpf != null) {
            this.jpf.notifyDataSetChanged();
        }
    }

    public void cgL() {
        MessageManager.getInstance().unRegisterListener(this.iTP);
        MessageManager.getInstance().unRegisterListener(this.erZ);
    }

    public View bAi() {
        this.ehn = 3;
        this.rootView = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bY(this.rootView);
        TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        bSy();
        return this.rootView;
    }

    public Activity getActivity() {
        return this.jpa.getPageContext().getPageActivity();
    }

    protected void bSy() {
        this.jpd.startPullRefresh();
        this.eFr = isLogin();
        if (!this.eFr) {
            ab(this.eFr, true);
        }
    }

    private void registerListener() {
        this.jpa.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.iTP);
        this.jpa.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.iTP);
        this.jpa.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.iTP);
        this.jpa.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.iTP);
        this.jpa.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.iTP);
        this.jpa.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.iTP);
        this.jpa.registerListener(this.erZ);
        this.jpa.registerListener(this.hGY);
    }

    public void IH() {
        if (this.fuP != null && !this.fuP.isRefreshing()) {
            qB(true);
        }
    }

    public void qB(boolean z) {
        if (this.fuP != null) {
            if (z && this.jpd != null && this.jpd.getFirstVisiblePosition() != 0) {
                this.jpd.setSelection(0);
            }
            this.fuP.setRefreshing(z);
        }
    }

    public void qC(boolean z) {
        this.isNeedRefresh = z;
    }

    public void qD(boolean z) {
        this.jpk = z;
    }

    public void onPrimary() {
        if (this.jpf != null && this.jpf.getCount() == 0) {
            qC(true);
        }
        if (this.jpk || this.isNeedRefresh) {
            this.jpk = false;
            this.isNeedRefresh = false;
            mM(false);
        }
        boolean isLogin = isLogin();
        if (this.eFr != isLogin) {
            this.eFr = isLogin;
            onUserChanged(this.eFr);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.jpa.getPageContext());
        }
        cyN();
    }

    private void initData() {
        this.jpb = new ImMessageCenterModel();
        qF(com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void bY(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.jpg = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.jpg.setVisibility(8);
        this.jpg.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.qF(false);
                e.this.qE(false);
            }
        });
        this.jpe = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.jpd = (BdListView) view.findViewById(R.id.chat_list_content);
        this.jpd.setDividerHeight(0);
        this.jpf = new MessageAggregationListAdapter(this.jpa.getPageContext().getPageActivity());
        this.jpf.a(this);
        this.jpd.setAdapter((ListAdapter) this.jpf);
        this.jpd.setOnItemClickListener(this.mItemClickListener);
        this.jpd.setOnItemLongClickListener(this.jpH);
        this.jpd.setOnScrollListener(this.mOnScrollListener);
        this.mHeaderView = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
        this.jpm = this.mHeaderView.findViewById(R.id.at_me_layout);
        this.jpn = (ImageView) this.mHeaderView.findViewById(R.id.at_me_icon);
        this.jpo = (TextView) this.mHeaderView.findViewById(R.id.at_me_text);
        this.jpp = (MessageRedDotView) this.mHeaderView.findViewById(R.id.at_me_new_message);
        this.jpq = this.mHeaderView.findViewById(R.id.agree_me_layout);
        this.jpr = (ImageView) this.mHeaderView.findViewById(R.id.agree_me_icon);
        this.jps = (TextView) this.mHeaderView.findViewById(R.id.agree_me_text);
        this.jpt = (MessageRedDotView) this.mHeaderView.findViewById(R.id.agree_me_new_message);
        this.jpu = this.mHeaderView.findViewById(R.id.reply_me_layout);
        this.jpv = (ImageView) this.mHeaderView.findViewById(R.id.reply_me_icon);
        this.jpw = (TextView) this.mHeaderView.findViewById(R.id.reply_me_text);
        this.jpx = (MessageRedDotView) this.mHeaderView.findViewById(R.id.reply_me_new_message);
        this.jpy = this.mHeaderView.findViewById(R.id.fans_layout);
        this.jpz = (ImageView) this.mHeaderView.findViewById(R.id.fans_icon);
        this.jpA = (TextView) this.mHeaderView.findViewById(R.id.fans_text);
        this.jpB = (MessageRedDotView) this.mHeaderView.findViewById(R.id.fans_new_message);
        this.jpp.setThreeDotMode(2);
        this.jpt.setThreeDotMode(2);
        this.jpx.setThreeDotMode(2);
        this.jpB.setThreeDotMode(2);
        this.jpp.setShadowEnabled(false);
        this.jpt.setShadowEnabled(false);
        this.jpx.setShadowEnabled(false);
        this.jpm.setOnClickListener(this);
        this.jpq.setOnClickListener(this);
        this.jpu.setOnClickListener(this);
        this.jpy.setOnClickListener(this);
        this.jpd.addHeaderView(this.mHeaderView);
        cyN();
        this.fuP = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.jpa.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fzt);
        }
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.fuP.setProgressView(this.mPullView);
        this.bkz = new View(this.jpa.getFragmentActivity());
        this.bkz.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.jpa.getFragmentActivity(), R.dimen.ds150)));
        this.jpd.addFooterView(this.bkz);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cyN() {
        if (this.jpd != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
            ap apVar = new ap("c13616");
            apVar.ah("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(apVar);
            if (areNotificationsEnabled) {
                if (this.jpE != null) {
                    this.jpd.removeHeaderView(this.jpE.getView());
                    this.jpF = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aZP().getLong("key_im_open_notification_close_time", 0L);
            if (this.jpF) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.jpE == null) {
                    this.jpE = new com.baidu.tieba.imMessageCenter.mention.base.f(this.mContext);
                    this.jpE.a(this.jpG);
                }
                this.jpd.addHeaderView(this.jpE.getView(), 0);
                this.jpF = true;
            }
        }
    }

    private boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jpa.getPageContext(), i);
        }
        if (this.jpg != null) {
            this.jpg.onChangeSkinType(i);
        }
        if (this.jpf != null) {
            this.jpf.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ao.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.fuP, R.color.cp_bg_line_e);
        ao.setViewTextColor(this.jpo, R.color.cp_cont_b);
        ao.setViewTextColor(this.jps, R.color.cp_cont_b);
        ao.setViewTextColor(this.jpw, R.color.cp_cont_b);
        ao.setViewTextColor(this.jpA, R.color.cp_cont_b);
        ao.setImageResource(this.jpn, R.drawable.pic_information_at_me);
        ao.setImageResource(this.jpr, R.drawable.pic_information_praise);
        ao.setImageResource(this.jpv, R.drawable.pic_information_reply);
        ao.setImageResource(this.jpz, R.drawable.pic_information_fans);
        if (this.jpp != null) {
            this.jpp.onChangeSkinType();
        }
        if (this.jpt != null) {
            this.jpt.onChangeSkinType();
        }
        if (this.jpx != null) {
            this.jpx.onChangeSkinType();
        }
        if (this.jpB != null) {
            this.jpB.onChangeSkinType();
        }
        if (this.jpE != null) {
            this.jpE.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    protected void onUserChanged(boolean z) {
        ab(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.jpi = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.jph != null && e.this.jph.isShowing() && e.this.jpa != null) {
                    e.this.jph.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.jpb.asyncDeleteItem(imMessageCenterShowItemData, e.this.iTS);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.jpa.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.jph = new com.baidu.tbadk.core.dialog.i(this.jpa.getPageContext());
        this.jph.a(null, new String[]{string}, this.jpi);
    }

    protected boolean mM(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.jpd.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void qE(boolean z) {
        if (z) {
            if (cyO() && this.jpg.getVisibility() != 0) {
                this.jpg.setVisibility(0);
            }
        } else if (this.jpg.getVisibility() != 8) {
            this.jpg.setVisibility(8);
        }
    }

    public void ab(boolean z, boolean z2) {
    }

    public boolean cyO() {
        return this.jpj;
    }

    public void qF(boolean z) {
        this.jpj = z;
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
                if (this.jpb != null) {
                    this.jpb.insertOrUpdate(data, this.iTR);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.jpb != null) {
                this.jpb.remove(data, this.iTR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.jpb != null) {
                this.jpb.setData(data, this.iTR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.jpl = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.jpl != -1) {
                qC(true);
                onPrimary();
            }
        }
    }

    public void qA(boolean z) {
        if (z && this.jpd != null && this.jpd.getWrappedAdapter() != null && this.jpd.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // java.lang.Runnable
                public void run() {
                    e.this.jpd.startPullRefresh();
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
                cyP();
            }
        }
    }

    private void cyP() {
        if (this.jpf != null) {
            this.jpf.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crx() {
        zA();
        if (this.iTO == null) {
            this.iTO = com.baidu.tieba.im.db.e.cth().eZ(getPageContext().getPageActivity());
        }
        this.iTO.show();
        this.iTO.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA() {
        if (this.iTO != null && this.iTO.isShowing()) {
            this.iTO.dismiss();
            this.iTO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cry() {
        if (this.jpd != null && this.jpb != null) {
            this.jpd.completePullRefreshPostDelayed(0L);
            if (this.jpb.getData() != null) {
                this.jpf.setData(this.jpb.getData());
            } else {
                ab(isLogin(), true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ap apVar = new ap("c13720");
        apVar.t("uid", TbadkApplication.getCurrentAccountId());
        if (view == this.jpm) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfz();
            com.baidu.tbadk.coreExtra.messageCenter.b.bfl().setMsgAtme(0);
            this.jpC = 0;
            zy(this.jpC);
            TiebaStatic.log("c12925");
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            apVar.ah("obj_type", 1);
        } else if (view == this.jpq) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfA();
            com.baidu.tbadk.coreExtra.messageCenter.b.bfl().ns(0);
            this.jpD = 0;
            zB(this.jpD);
            TiebaStatic.log("c12926");
            apVar.ah("obj_type", 2);
        } else if (view == this.jpu) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
            com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfy();
            com.baidu.tbadk.coreExtra.messageCenter.b.bfl().setMsgReplyme(0);
            zz(0);
        } else if (view == this.jpy) {
            com.baidu.tieba.p.a.ddy().g(2, false, true);
            TiebaStatic.log(new ap("c12523").ah("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
            com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfB();
            com.baidu.tbadk.coreExtra.messageCenter.b.bfl().setMsgFans(0);
            zA(0);
        }
        TiebaStatic.log(apVar);
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.jpC = newsNotifyMessage.getMsgAtme();
            this.jpD = newsNotifyMessage.getMsgAgree();
            zy(this.jpC);
            zB(this.jpD);
            zA(newsNotifyMessage.getMsgFans());
            zz(newsNotifyMessage.getMsgReplyme());
        }
    }

    private void zy(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfR() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfT()) {
                i = 0;
            }
            a(i, this.jpp);
            this.jpp.setThreeDotMode(2);
            this.jpp.refresh(i);
            this.jpp.setVisibility(0);
            return;
        }
        this.jpp.setVisibility(8);
    }

    private void zz(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfR() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfV()) {
                i = 0;
            }
            a(i, this.jpx);
            this.jpx.setThreeDotMode(2);
            this.jpx.refresh(i);
            this.jpx.setVisibility(0);
            return;
        }
        this.jpx.setVisibility(8);
    }

    private void zA(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfR() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfU()) {
                i = 0;
            }
            a(i, this.jpB);
            this.jpB.setThreeDotMode(2);
            this.jpB.refresh(i);
            this.jpB.setVisibility(0);
            return;
        }
        this.jpB.setVisibility(8);
    }

    private void zB(int i) {
        if (i > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfR() == 0) {
                i = 0;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgf()) {
                i = 0;
            }
            a(i, this.jpt);
            this.jpt.setThreeDotMode(2);
            this.jpt.refresh(i);
            this.jpt.setVisibility(0);
            return;
        }
        this.jpt.setVisibility(8);
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
