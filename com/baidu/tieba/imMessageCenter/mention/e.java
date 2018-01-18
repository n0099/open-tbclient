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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
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
import java.util.List;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.base.c<g> implements j.b {
    private View IZ;
    private final AdapterView.OnItemClickListener QC;
    private NoNetworkView bYQ;
    private boolean cKv;
    private final CustomMessageListener dCl;
    private View dar;
    private NavigationBar dqL;
    private RelativeLayout dxQ;
    private ImMessageCenterModel eKX;
    private ImMessageCenterShowItemData eKZ;
    private BdListView eLa;
    private ShutDownValidateTipView eLd;
    com.baidu.tbadk.core.dialog.b eLe;
    private b.InterfaceC0073b eLf;
    private int eLg;
    private boolean eLh;
    private final AdapterView.OnItemLongClickListener eLi;
    private final g eNS;
    private MessageAggregationListAdapter eNT;
    private boolean eNU;
    private boolean eNV;
    private int eNW;
    private TextView eNX;
    private CustomMessageListener eNY;
    private final CustomMessageListener etX;
    private com.baidu.tieba.im.chat.a.a etZ;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.ak(gVar.getPageContext().getPageActivity()));
        this.eKX = null;
        this.eKZ = null;
        this.eLa = null;
        this.eNT = null;
        this.eLe = null;
        this.eLh = true;
        this.eNU = false;
        this.cKv = false;
        this.eNV = true;
        this.eNW = 16;
        this.eNY = new CustomMessageListener(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS) { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && e.this.mNoDataView != null && e.this.mNoDataView.getVisibility() == 0) {
                    e.this.F(e.this.isLogin(), true);
                }
            }
        };
        this.QC = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData item = e.this.eNT.getItem(i);
                    if (item != null) {
                        TiebaStatic.eventStat(e.this.eNS.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                        String ownerName = item.getOwnerName();
                        if (TextUtils.isEmpty(ownerName)) {
                            e(item);
                            return;
                        } else if (ownerName.equals("1")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eNS.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                                TiebaStatic.eventStat(e.this.eNS.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.eNS.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("2")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eNS.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA().gX(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.eNS.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("3")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eNS.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA().gW(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.eNS.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("6")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eNS.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA().hg(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(e.this.eNS.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("5")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eNS.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.eNS.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("8")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eNS.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.eNS.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, item.getUserType())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("7")) {
                            TiebaStatic.log(new ak("c12614"));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.eNS.getPageContext().getPageActivity())));
                            return;
                        } else {
                            e(item);
                            return;
                        }
                    }
                    if (i == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(e.this.eNS.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gf().Gu();
                        e.this.eNT.qG(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gf().setMsgReplyme(0);
                        TiebaStatic.eventStat(e.this.eNS.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(e.this.eNS.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gf().Gv();
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gf().setMsgAtme(0);
                        e.this.eNT.qH(0);
                        TiebaStatic.eventStat(e.this.eNS.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    }
                    e.this.eNT.notifyDataSetChanged();
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.aGy().mS("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aGy().mS("group_intro_change");
                                com.baidu.tieba.im.db.d.aGy().mS("group_name_change");
                                com.baidu.tieba.im.db.d.aGy().mS("group_notice_change");
                                com.baidu.tieba.im.db.d.aGy().mS("group_level_up");
                                com.baidu.tieba.im.db.d.aGy().mS("dismiss_group");
                                com.baidu.tieba.im.db.d.aGy().mS("kick_out");
                                com.baidu.tieba.im.db.d.aGy().mS("group_activitys_change");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                                com.baidu.tieba.im.db.d.aGy().mS("live_notify");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gf().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.Gf().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.eNS.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.eLi = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.14
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    return false;
                }
                e.this.eKZ = e.this.eNT.getItem(i);
                e.this.c(e.this.eKZ);
                if (e.this.eLe != null) {
                    e.this.eLe.AD();
                    return true;
                }
                return true;
            }
        };
        this.etX = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2016002) {
                        e.this.f(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2016004) {
                        e.this.g(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2016007) {
                        e.this.h(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2016001) {
                        e.this.eKX.setData(null, e.this.etZ);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.eNT != null) {
                            e.this.eNT.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.eNT != null) {
                        e.this.eNT.notifyDataSetChanged();
                    }
                }
            }
        };
        this.etZ = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
            @Override // com.baidu.tieba.im.chat.a.a
            public void aEE() {
                if (e.this.eLa != null && e.this.eKX != null) {
                    e.this.eLa.completePullRefreshPostDelayed(2000L);
                    if (e.this.eKX.getData() != null) {
                        e.this.eNT.setData(e.this.eKX.getData());
                    } else {
                        e.this.F(e.this.isLogin(), true);
                    }
                }
            }
        };
        this.dCl = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.h((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.eNS = gVar;
    }

    public void n(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eNW = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eNW = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eNW);
        }
    }

    public void awz() {
        if (this.eNT != null) {
            this.eNT.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.etX);
    }

    public View XH() {
        this.eLg = 3;
        this.rootView = LayoutInflater.from(this.eNS.getPageContext().getPageActivity()).inflate(d.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        bJ(this.rootView);
        TiebaStatic.eventStat(this.eNS.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        amb();
        return this.rootView;
    }

    protected void amb() {
        this.eLa.startPullRefresh();
        this.eNU = isLogin();
        if (!this.eNU) {
            F(this.eNU, true);
        }
    }

    private void registerListener() {
        this.eNS.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.etX);
        this.eNS.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.etX);
        this.eNS.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.etX);
        this.eNS.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.etX);
        this.eNS.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.etX);
        this.eNS.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.etX);
        this.eNS.registerListener(this.eNY);
    }

    public void hT(boolean z) {
        this.cKv = z;
    }

    public void hU(boolean z) {
        this.eNV = z;
    }

    public void onPrimary() {
        if (this.eNT != null && this.eNT.getCount() == 0) {
            hT(true);
        }
        if (this.eNV || this.cKv) {
            this.eNV = false;
            this.cKv = false;
            eP(false);
        }
        boolean isLogin = isLogin();
        if (this.eNU != isLogin) {
            this.eNU = isLogin;
            onUserChanged(this.eNU);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eNS.getPageContext());
        }
    }

    private void initData() {
        this.eKX = new ImMessageCenterModel();
        hN(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dCl.setPriority(-1);
        this.eNS.registerListener(this.dCl);
    }

    private void bJ(View view) {
        this.dxQ = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.eLd = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.eLd.setVisibility(8);
        this.eLd.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.hN(false);
                e.this.hL(false);
            }
        });
        this.dqL = (NavigationBar) this.dxQ.findViewById(d.g.view_navigation_bar);
        this.eNX = (TextView) this.dqL.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.eNS.getResources().getDimension(d.e.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.eNX.setLayoutParams(layoutParams);
        this.eNX.setText(d.j.my_message);
        this.dqL.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.dqL.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.bc(e.this.mContext.getPageActivity());
                }
            });
            this.dqL.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.bd(e.this.mContext.getPageActivity());
                }
            });
        }
        this.IZ = new TextView(this.eNS.getPageContext().getPageActivity());
        this.IZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.s(this.eNS.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oI());
        this.bYQ = (NoNetworkView) this.dxQ.findViewById(d.g.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bYQ.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.bYQ.setLayoutParams(layoutParams2);
        this.bYQ.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bp(boolean z) {
                e.this.hS(z);
            }
        });
        this.eLa = (BdListView) view.findViewById(d.g.chat_list_content);
        this.eLa.addHeaderView(this.IZ);
        this.eLa.setDividerHeight(0);
        this.eNT = new MessageAggregationListAdapter(this.eNS.getPageContext().getPageActivity());
        this.eNT.a(this);
        this.eLa.setAdapter((ListAdapter) this.eNT);
        this.eLa.setOnItemClickListener(this.QC);
        this.eLa.setOnItemLongClickListener(this.eLi);
        this.dar = new View(this.eNS.getFragmentActivity());
        this.dar.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.s(this.eNS.getFragmentActivity(), d.e.ds150)));
        this.eLa.addFooterView(this.dar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eNS.getPageContext(), i);
        }
        this.bYQ.onChangeSkinType(getPageContext(), i);
        this.dqL.onChangeSkinType(tbPageContext, i);
        if (this.eLd != null) {
            this.eLd.onChangeSkinType(i);
        }
        aj.a(this.eNX, d.C0107d.cp_cont_b, d.C0107d.s_navbar_title_color, i);
        if (this.eNT != null) {
            this.eNT.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().aM(this.dxQ);
            return true;
        }
        return true;
    }

    private void hV(boolean z) {
        if (z) {
            aKW();
        } else {
            aKX();
        }
    }

    private void aKW() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eNS.getResources().getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) e.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.eNS.getPageContext().getPageActivity(), this.dxQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eNS.getResources().getDimension(d.e.ds320)), NoDataViewFactory.d.gn(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aKX() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.eNS.getResources().getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.eNS.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.bd(e.this.eNS.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.eNS.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.eNS.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.eNS.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.eNS.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eNS.getPageContext().getPageActivity(), this.dxQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aB(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.eNS.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        F(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.eLf = new b.InterfaceC0073b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        e.this.eKX.deleteItem(imMessageCenterShowItemData, e.this.etZ);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.eNS.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.eLe = new com.baidu.tbadk.core.dialog.b(this.eNS.getPageContext().getPageActivity());
        this.eLe.fe(d.j.operation);
        this.eLe.a(new String[]{string}, this.eLf);
        this.eLe.d(this.eNS.getPageContext());
    }

    protected boolean eP(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.eLa.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void hL(boolean z) {
        if (z) {
            if (aKY() && this.eLd.getVisibility() != 0) {
                this.eLd.setVisibility(0);
            }
        } else if (this.eLd.getVisibility() != 8) {
            this.eLd.setVisibility(8);
        }
    }

    public void F(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eLa.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.dxQ.removeView(this.mNoDataView);
        }
        hV(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.eLa.setVisibility(8);
    }

    public boolean aKY() {
        return this.eLh;
    }

    public void hN(boolean z) {
        this.eLh = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.eKX != null) {
                    this.eKX.insertOrUpdate(data, this.etZ);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eKX != null) {
                this.eKX.remove(data, this.etZ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.eKX != null) {
                this.eKX.setData(data, this.etZ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eNW = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eNW != -1) {
                hT(true);
                onPrimary();
            }
        }
    }

    public void hS(boolean z) {
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oI());
        if (z && this.eLa != null && this.eLa.getWrappedAdapter() != null && this.eLa.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
                @Override // java.lang.Runnable
                public void run() {
                    e.this.eLa.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
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
            ci(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void ci(int i, int i2) {
        this.eNT.qG(i);
        this.eNT.qH(i2);
        this.eNT.notifyDataSetChanged();
    }

    public void hW(boolean z) {
        this.dqL.setVisibility(z ? 0 : 8);
    }
}
