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
import com.baidu.tbadk.core.view.g;
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
public class e extends com.baidu.adp.base.c<g> implements g.b {
    private View ama;
    private View bQE;
    private final CustomMessageListener baz;
    private NoNetworkView bfM;
    private NavigationBar cgY;
    private RelativeLayout cmV;
    private final CustomMessageListener cri;
    private ImMessageCenterModel dGC;
    private ImMessageCenterShowItemData dGE;
    private BdListView dGF;
    private ShutDownValidateTipView dGI;
    com.baidu.tbadk.core.dialog.b dGJ;
    private b.InterfaceC0047b dGK;
    private int dGL;
    private boolean dGM;
    private final AdapterView.OnItemClickListener dGN;
    private final AdapterView.OnItemLongClickListener dGO;
    private final g dJA;
    private MessageAggregationListAdapter dJB;
    private boolean dJC;
    private boolean dJD;
    private boolean dJE;
    private int dJF;
    private TextView dJG;
    private CustomMessageListener dJH;
    private final CustomMessageListener dpq;
    private com.baidu.tieba.im.chat.a.a dps;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.Y(gVar.getPageContext().getPageActivity()));
        this.dGC = null;
        this.dGE = null;
        this.dGF = null;
        this.dJB = null;
        this.dGJ = null;
        this.dGM = true;
        this.dJC = false;
        this.dJD = false;
        this.dJE = true;
        this.dJF = 16;
        this.baz = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && e.this.dJB != null) {
                    e.this.dJB.notifyDataSetChanged();
                }
            }
        };
        this.dJH = new CustomMessageListener(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS) { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && e.this.mNoDataView != null && e.this.mNoDataView.getVisibility() == 0) {
                    e.this.C(e.this.isLogin(), true);
                }
            }
        };
        this.dGN = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData item = e.this.dJB.getItem(i);
                    if (item != null) {
                        TiebaStatic.eventStat(e.this.dJA.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                        String ownerName = item.getOwnerName();
                        if (TextUtils.isEmpty(ownerName)) {
                            e(item);
                            return;
                        } else if (ownerName.equals("1")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dJA.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                                TiebaStatic.eventStat(e.this.dJA.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.dJA.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("2")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dJA.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ().eb(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.dJA.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dJA.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ().ea(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.dJA.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("6")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dJA.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ().ek(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(e.this.dJA.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("5")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dJA.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.dJA.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("8")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dJA.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.dJA.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, item.getUserType())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.dJA.getPageContext().getPageActivity())));
                            return;
                        } else {
                            e(item);
                            return;
                        }
                    }
                    if (i == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(e.this.dJA.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yv().yK();
                        e.this.dJB.ni(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yv().setMsgReplyme(0);
                        TiebaStatic.eventStat(e.this.dJA.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(e.this.dJA.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yv().yL();
                        com.baidu.tbadk.coreExtra.messageCenter.a.yv().setMsgAtme(0);
                        e.this.dJB.nj(0);
                        TiebaStatic.eventStat(e.this.dJA.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    }
                    e.this.dJB.notifyDataSetChanged();
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.auX().lZ("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                                com.baidu.tieba.im.db.d.auX().lZ("group_intro_change");
                                com.baidu.tieba.im.db.d.auX().lZ("group_name_change");
                                com.baidu.tieba.im.db.d.auX().lZ("group_notice_change");
                                com.baidu.tieba.im.db.d.auX().lZ("group_level_up");
                                com.baidu.tieba.im.db.d.auX().lZ("dismiss_group");
                                com.baidu.tieba.im.db.d.auX().lZ("kick_out");
                                com.baidu.tieba.im.db.d.auX().lZ("group_activitys_change");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                                com.baidu.tieba.im.db.d.auX().lZ("live_notify");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.yv().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.yv().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.dJA.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.dGO = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    return false;
                }
                e.this.dGE = e.this.dJB.getItem(i);
                e.this.c(e.this.dGE);
                if (e.this.dGJ != null) {
                    e.this.dGJ.te();
                    return true;
                }
                return true;
            }
        };
        this.dpq = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2016002) {
                        e.this.e(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2016004) {
                        e.this.f(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2016007) {
                        e.this.g(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2016001) {
                        e.this.dGC.setData(null, e.this.dps);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.dJB != null) {
                            e.this.dJB.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.dJB != null) {
                        e.this.dJB.notifyDataSetChanged();
                    }
                }
            }
        };
        this.dps = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // com.baidu.tieba.im.chat.a.a
            public void atd() {
                if (e.this.dGF != null && e.this.dGC != null) {
                    e.this.dGF.completePullRefreshPostDelayed(2000L);
                    if (e.this.dGC.getData() != null) {
                        e.this.dJB.setData(e.this.dGC.getData());
                    } else {
                        e.this.C(e.this.isLogin(), true);
                    }
                }
            }
        };
        this.cri = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.h(customResponsedMessage);
                }
            }
        };
        this.dJA = gVar;
    }

    public void l(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dJF = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dJF = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dJF);
        }
    }

    public void ajr() {
        if (this.dJB != null) {
            this.dJB.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dpq);
    }

    public View Ze() {
        this.dGL = 3;
        this.rootView = LayoutInflater.from(this.dJA.getPageContext().getPageActivity()).inflate(d.j.chat_list_activity, (ViewGroup) null, false);
        initData();
        an(this.rootView);
        TiebaStatic.eventStat(this.dJA.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        Zf();
        return this.rootView;
    }

    protected void Zf() {
        this.dGF.startPullRefresh();
        this.dJC = isLogin();
        if (!this.dJC) {
            C(this.dJC, true);
        }
    }

    private void registerListener() {
        this.dJA.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dpq);
        this.dJA.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dpq);
        this.dJA.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dpq);
        this.dJA.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dpq);
        this.dJA.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dpq);
        this.dJA.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dpq);
        this.dJA.registerListener(this.baz);
        this.dJA.registerListener(this.dJH);
    }

    public void gU(boolean z) {
        this.dJD = z;
    }

    public void gV(boolean z) {
        this.dJE = z;
    }

    public void onPrimary() {
        if (this.dJB != null && this.dJB.getCount() == 0) {
            gU(true);
        }
        if (this.dJE || this.dJD) {
            this.dJE = false;
            this.dJD = false;
            dK(false);
        }
        boolean isLogin = isLogin();
        if (this.dJC != isLogin) {
            this.dJC = isLogin;
            onUserChanged(this.dJC);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dJA.getPageContext());
        }
    }

    private void initData() {
        this.dGC = new ImMessageCenterModel();
        gO(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dJA.registerListener(this.cri);
    }

    private void an(View view) {
        this.cmV = (RelativeLayout) view.findViewById(d.h.chat_list);
        this.dGI = (ShutDownValidateTipView) view.findViewById(d.h.view_no_validate);
        this.dGI.setVisibility(8);
        this.dGI.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.gO(false);
                e.this.gM(false);
            }
        });
        this.cgY = (NavigationBar) this.cmV.findViewById(d.h.view_navigation_bar);
        this.dJG = (TextView) this.cgY.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.maintab_title_layout, (View.OnClickListener) null).findViewById(d.h.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dJA.getResources().getDimension(d.f.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dJG.setLayoutParams(layoutParams);
        this.dJG.setText(d.l.my_message);
        this.cgY.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.cgY.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.aR(e.this.mContext.getPageActivity());
                }
            });
            this.cgY.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aS(e.this.mContext.getPageActivity());
                }
            });
        }
        this.ama = new TextView(this.dJA.getPageContext().getPageActivity());
        this.ama.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dJA.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.ama, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.bfM = (NoNetworkView) this.cmV.findViewById(d.h.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bfM.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.bfM.setLayoutParams(layoutParams2);
        this.bfM.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aL(boolean z) {
                e.this.gT(z);
            }
        });
        this.dGF = (BdListView) view.findViewById(d.h.chat_list_content);
        this.dGF.addHeaderView(this.ama);
        this.dGF.setDividerHeight(0);
        this.dJB = new MessageAggregationListAdapter(this.dJA.getPageContext().getPageActivity());
        this.dJB.a(this);
        this.dGF.setAdapter((ListAdapter) this.dJB);
        this.dGF.setOnItemClickListener(this.dGN);
        this.dGF.setOnItemLongClickListener(this.dGO);
        this.bQE = new View(this.dJA.getFragmentActivity());
        this.bQE.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.dJA.getFragmentActivity(), d.f.ds150)));
        this.dGF.addFooterView(this.bQE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dJA.getPageContext(), i);
        }
        this.bfM.onChangeSkinType(getPageContext(), i);
        this.cgY.onChangeSkinType(tbPageContext, i);
        if (this.dGI != null) {
            this.dGI.onChangeSkinType(i);
        }
        aj.a(this.dJG, d.e.cp_cont_b, d.e.s_navbar_title_color, i);
        if (this.dJB != null) {
            this.dJB.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.cmV);
            return true;
        }
        return true;
    }

    private void gW(boolean z) {
        if (z) {
            azI();
        } else {
            azJ();
        }
    }

    private void azI() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dJA.getResources().getString(d.l.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) e.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dJA.getPageContext().getPageActivity(), this.cmV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dJA.getResources().getDimension(d.f.ds320)), NoDataViewFactory.d.dp(d.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void azJ() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dJA.getResources().getString(d.l.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.dJA.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aS(e.this.dJA.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.dJA.getResources().getDimensionPixelSize(d.f.ds320);
        int dimensionPixelSize2 = this.dJA.getResources().getDimensionPixelSize(d.f.ds480);
        int dimensionPixelSize3 = this.dJA.getResources().getDimensionPixelSize(d.f.ds360);
        int dimensionPixelSize4 = this.dJA.getResources().getDimensionPixelSize(d.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dJA.getPageContext().getPageActivity(), this.cmV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dJA.getResources().getDimensionPixelSize(d.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        C(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dGK = new b.InterfaceC0047b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        e.this.dGC.deleteItem(imMessageCenterShowItemData, e.this.dps);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dJA.getPageContext().getPageActivity().getString(d.l.delete_user_chat);
        this.dGJ = new com.baidu.tbadk.core.dialog.b(this.dJA.getPageContext().getPageActivity());
        this.dGJ.cf(d.l.operation);
        this.dGJ.a(new String[]{string}, this.dGK);
        this.dGJ.d(this.dJA.getPageContext());
    }

    protected boolean dK(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dGF.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void gM(boolean z) {
        if (z) {
            if (azK() && this.dGI.getVisibility() != 0) {
                this.dGI.setVisibility(0);
            }
        } else if (this.dGI.getVisibility() != 8) {
            this.dGI.setVisibility(8);
        }
    }

    public void C(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.dGF.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.cmV.removeView(this.mNoDataView);
        }
        gW(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.dGF.setVisibility(8);
    }

    public boolean azK() {
        return this.dGM;
    }

    public void gO(boolean z) {
        this.dGM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.dGC != null) {
                    this.dGC.insertOrUpdate(data, this.dps);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dGC != null) {
                this.dGC.remove(data, this.dps);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dGC != null) {
                this.dGC.setData(data, this.dps);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dJF = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dJF != -1) {
                gU(true);
                onPrimary();
            }
        }
    }

    public void gT(boolean z) {
        BdListViewHelper.a(this.ama, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        if (z && this.dGF != null && this.dGF.getWrappedAdapter() != null && this.dGF.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
                @Override // java.lang.Runnable
                public void run() {
                    e.this.dGF.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
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
            bn(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void bn(int i, int i2) {
        this.dJB.ni(i);
        this.dJB.nj(i2);
        this.dJB.notifyDataSetChanged();
    }

    public void gX(boolean z) {
        this.cgY.setVisibility(z ? 0 : 8);
    }
}
