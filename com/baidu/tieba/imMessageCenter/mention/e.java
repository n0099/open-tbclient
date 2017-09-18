package com.baidu.tieba.imMessageCenter.mention;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.LiveNotifyActivityConfig;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarTipActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMessageActivityConfig;
import com.baidu.tbadk.core.atomData.UpdatesActivityConfig;
import com.baidu.tbadk.core.atomData.ValidateActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.base.c<g> implements k.b {
    private final CustomMessageListener aZa;
    private View anc;
    private View bRj;
    private NoNetworkView bem;
    private NavigationBar chU;
    private RelativeLayout cmK;
    private final CustomMessageListener cqX;
    private ImMessageCenterModel dKB;
    private ImMessageCenterShowItemData dKD;
    private BdListView dKE;
    private ShutDownValidateTipView dKH;
    com.baidu.tbadk.core.dialog.b dKI;
    private b.InterfaceC0046b dKJ;
    private int dKK;
    private boolean dKL;
    private final AdapterView.OnItemClickListener dKM;
    private final AdapterView.OnItemLongClickListener dKN;
    private boolean dNA;
    private int dNB;
    private TextView dNC;
    private CustomMessageListener dND;
    private final g dNw;
    private MessageAggregationListAdapter dNx;
    private boolean dNy;
    private boolean dNz;
    private final CustomMessageListener dtn;
    private com.baidu.tieba.im.chat.a.a dtp;
    private com.baidu.tbadk.core.view.j mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.Y(gVar.getPageContext().getPageActivity()));
        this.dKB = null;
        this.dKD = null;
        this.dKE = null;
        this.dNx = null;
        this.dKI = null;
        this.dKL = true;
        this.dNy = false;
        this.dNz = false;
        this.dNA = true;
        this.dNB = 16;
        this.aZa = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && e.this.dNx != null) {
                    e.this.dNx.notifyDataSetChanged();
                }
            }
        };
        this.dND = new CustomMessageListener(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS) { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && e.this.mNoDataView != null && e.this.mNoDataView.getVisibility() == 0) {
                    e.this.B(e.this.isLogin(), true);
                }
            }
        };
        this.dKM = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData item = e.this.dNx.getItem(i);
                    if (item != null) {
                        TiebaStatic.eventStat(e.this.dNw.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                        String ownerName = item.getOwnerName();
                        if (TextUtils.isEmpty(ownerName)) {
                            e(item);
                            return;
                        } else if (ownerName.equals("1")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dNw.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                                TiebaStatic.eventStat(e.this.dNw.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.dNw.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("2")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dNw.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy().dS(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.dNw.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dNw.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy().dR(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.dNw.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("6")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dNw.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy().eb(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(e.this.dNw.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("5")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dNw.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.dNw.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("8")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dNw.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.dNw.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, item.getUserType())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.dNw.getPageContext().getPageActivity())));
                            return;
                        } else {
                            e(item);
                            return;
                        }
                    }
                    if (i == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(e.this.dNw.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.zd().zs();
                        e.this.dNx.nn(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.zd().setMsgReplyme(0);
                        TiebaStatic.eventStat(e.this.dNw.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(e.this.dNw.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.zd().zt();
                        com.baidu.tbadk.coreExtra.messageCenter.a.zd().setMsgAtme(0);
                        e.this.dNx.no(0);
                        TiebaStatic.eventStat(e.this.dNw.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    }
                    e.this.dNx.notifyDataSetChanged();
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.awr().mw("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                                com.baidu.tieba.im.db.d.awr().mw("group_intro_change");
                                com.baidu.tieba.im.db.d.awr().mw("group_name_change");
                                com.baidu.tieba.im.db.d.awr().mw("group_notice_change");
                                com.baidu.tieba.im.db.d.awr().mw("group_level_up");
                                com.baidu.tieba.im.db.d.awr().mw("dismiss_group");
                                com.baidu.tieba.im.db.d.awr().mw("kick_out");
                                com.baidu.tieba.im.db.d.awr().mw("group_activitys_change");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                                com.baidu.tieba.im.db.d.awr().mw("live_notify");
                            }
                        }
                        return null;
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }

            private void e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
                if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.zd().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.zd().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.dNw.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.dKN = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    return false;
                }
                e.this.dKD = e.this.dNx.getItem(i);
                e.this.c(e.this.dKD);
                if (e.this.dKI != null) {
                    e.this.dKI.tr();
                    return true;
                }
                return true;
            }
        };
        this.dtn = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2016002) {
                        e.this.d(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2016004) {
                        e.this.e(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2016007) {
                        e.this.f(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2016001) {
                        e.this.dKB.setData(null, e.this.dtp);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.dNx != null) {
                            e.this.dNx.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.dNx != null) {
                        e.this.dNx.notifyDataSetChanged();
                    }
                }
            }
        };
        this.dtp = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // com.baidu.tieba.im.chat.a.a
            public void aux() {
                if (e.this.dKE != null && e.this.dKB != null) {
                    e.this.dKE.completePullRefreshPostDelayed(2000L);
                    if (e.this.dKB.getData() != null) {
                        e.this.dNx.setData(e.this.dKB.getData());
                    } else {
                        e.this.B(e.this.isLogin(), true);
                    }
                }
            }
        };
        this.cqX = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.h(customResponsedMessage);
                }
            }
        };
        this.dNw = gVar;
    }

    public void l(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dNB = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dNB = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dNB);
        }
    }

    public void ajr() {
        if (this.dNx != null) {
            this.dNx.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dtn);
    }

    public View Zx() {
        this.dKK = 3;
        this.rootView = LayoutInflater.from(this.dNw.getPageContext().getPageActivity()).inflate(d.j.chat_list_activity, (ViewGroup) null, false);
        initData();
        ao(this.rootView);
        TiebaStatic.eventStat(this.dNw.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        Zy();
        return this.rootView;
    }

    protected void Zy() {
        this.dKE.startPullRefresh();
        this.dNy = isLogin();
        if (!this.dNy) {
            B(this.dNy, true);
        }
    }

    private void registerListener() {
        this.dNw.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dtn);
        this.dNw.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dtn);
        this.dNw.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dtn);
        this.dNw.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dtn);
        this.dNw.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dtn);
        this.dNw.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dtn);
        this.dNw.registerListener(this.aZa);
        this.dNw.registerListener(this.dND);
    }

    public void hi(boolean z) {
        this.dNz = z;
    }

    public void hj(boolean z) {
        this.dNA = z;
    }

    public void onPrimary() {
        if (this.dNx != null && this.dNx.getCount() == 0) {
            hi(true);
        }
        if (this.dNA || this.dNz) {
            this.dNA = false;
            this.dNz = false;
            dS(false);
        }
        boolean isLogin = isLogin();
        if (this.dNy != isLogin) {
            this.dNy = isLogin;
            onUserChanged(this.dNy);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dNw.getPageContext());
        }
    }

    private void initData() {
        this.dKB = new ImMessageCenterModel();
        hc(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dNw.registerListener(this.cqX);
    }

    private void ao(View view) {
        this.cmK = (RelativeLayout) view.findViewById(d.h.chat_list);
        this.dKH = (ShutDownValidateTipView) view.findViewById(d.h.view_no_validate);
        this.dKH.setVisibility(8);
        this.dKH.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.hc(false);
                e.this.ha(false);
            }
        });
        this.chU = (NavigationBar) this.cmK.findViewById(d.h.view_navigation_bar);
        this.dNC = (TextView) this.chU.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.maintab_title_layout, (View.OnClickListener) null).findViewById(d.h.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dNw.getResources().getDimension(d.f.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dNC.setLayoutParams(layoutParams);
        this.dNC.setText(d.l.my_message);
        this.chU.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.chU.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.aS(e.this.mContext.getPageActivity());
                }
            });
            this.chU.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aT(e.this.mContext.getPageActivity());
                }
            });
        }
        this.anc = new TextView(this.dNw.getPageContext().getPageActivity());
        this.anc.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.f(this.dNw.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.anc, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hi());
        this.bem = (NoNetworkView) this.cmK.findViewById(d.h.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bem.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.bem.setLayoutParams(layoutParams2);
        this.bem.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                e.this.hh(z);
            }
        });
        this.dKE = (BdListView) view.findViewById(d.h.chat_list_content);
        this.dKE.addHeaderView(this.anc);
        this.dKE.setDividerHeight(0);
        this.dNx = new MessageAggregationListAdapter(this.dNw.getPageContext().getPageActivity());
        this.dNx.a(this);
        this.dKE.setAdapter((ListAdapter) this.dNx);
        this.dKE.setOnItemClickListener(this.dKM);
        this.dKE.setOnItemLongClickListener(this.dKN);
        this.bRj = new View(this.dNw.getFragmentActivity());
        this.bRj.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.f(this.dNw.getFragmentActivity(), d.f.ds150)));
        this.dKE.addFooterView(this.bRj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dNw.getPageContext(), i);
        }
        this.bem.onChangeSkinType(getPageContext(), i);
        this.chU.onChangeSkinType(tbPageContext, i);
        if (this.dKH != null) {
            this.dKH.onChangeSkinType(i);
        }
        aj.a(this.dNC, d.e.cp_cont_b, d.e.s_navbar_title_color, i);
        if (this.dNx != null) {
            this.dNx.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.cmK);
            return true;
        }
        return true;
    }

    private void hk(boolean z) {
        if (z) {
            aBc();
        } else {
            aBd();
        }
    }

    private void aBc() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dNw.getResources().getString(d.l.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) e.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dNw.getPageContext().getPageActivity(), this.cmK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dNw.getResources().getDimension(d.f.ds320)), NoDataViewFactory.d.dl(d.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aBd() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dNw.getResources().getString(d.l.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.dNw.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aT(e.this.dNw.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.dNw.getResources().getDimensionPixelSize(d.f.ds320);
        int dimensionPixelSize2 = this.dNw.getResources().getDimensionPixelSize(d.f.ds480);
        int dimensionPixelSize3 = this.dNw.getResources().getDimensionPixelSize(d.f.ds360);
        int dimensionPixelSize4 = this.dNw.getResources().getDimensionPixelSize(d.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dNw.getPageContext().getPageActivity(), this.cmK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.A(d.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dNw.getResources().getDimensionPixelSize(d.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        B(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dKJ = new b.InterfaceC0046b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        e.this.dKB.deleteItem(imMessageCenterShowItemData, e.this.dtp);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dNw.getPageContext().getPageActivity().getString(d.l.delete_user_chat);
        this.dKI = new com.baidu.tbadk.core.dialog.b(this.dNw.getPageContext().getPageActivity());
        this.dKI.cf(d.l.operation);
        this.dKI.a(new String[]{string}, this.dKJ);
        this.dKI.d(this.dNw.getPageContext());
    }

    protected boolean dS(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dKE.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void ha(boolean z) {
        if (z) {
            if (aBe() && this.dKH.getVisibility() != 0) {
                this.dKH.setVisibility(0);
            }
        } else if (this.dKH.getVisibility() != 8) {
            this.dKH.setVisibility(8);
        }
    }

    public void B(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.dKE.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.cmK.removeView(this.mNoDataView);
        }
        hk(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.dKE.setVisibility(8);
    }

    public boolean aBe() {
        return this.dKL;
    }

    public void hc(boolean z) {
        this.dKL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
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
                if (this.dKB != null) {
                    this.dKB.insertOrUpdate(data, this.dtp);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dKB != null) {
                this.dKB.remove(data, this.dtp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dKB != null) {
                this.dKB.setData(data, this.dtp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dNB = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dNB != -1) {
                hi(true);
                onPrimary();
            }
        }
    }

    public void hh(boolean z) {
        BdListViewHelper.a(this.anc, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hi());
        if (z && this.dKE != null && this.dKE.getWrappedAdapter() != null && this.dKE.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
                @Override // java.lang.Runnable
                public void run() {
                    e.this.dKE.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.k.b
    public void onListPullRefresh(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            bh(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void bh(int i, int i2) {
        this.dNx.nn(i);
        this.dNx.no(i2);
        this.dNx.notifyDataSetChanged();
    }

    public void hl(boolean z) {
        this.chU.setVisibility(z ? 0 : 8);
    }
}
