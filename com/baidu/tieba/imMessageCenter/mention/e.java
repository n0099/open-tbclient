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
import com.baidu.tbadk.core.view.i;
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
public class e extends com.baidu.adp.base.c<g> implements i.b {
    private View IZ;
    private final AdapterView.OnItemClickListener QC;
    private NoNetworkView bYJ;
    private View cVP;
    private NavigationBar dmk;
    private RelativeLayout dtq;
    private final CustomMessageListener dxK;
    private BdListView eJA;
    private ShutDownValidateTipView eJD;
    com.baidu.tbadk.core.dialog.b eJE;
    private b.InterfaceC0074b eJF;
    private int eJG;
    private boolean eJH;
    private final AdapterView.OnItemLongClickListener eJI;
    private ImMessageCenterModel eJx;
    private ImMessageCenterShowItemData eJz;
    private final g eMs;
    private MessageAggregationListAdapter eMt;
    private boolean eMu;
    private boolean eMv;
    private boolean eMw;
    private int eMx;
    private TextView eMy;
    private CustomMessageListener eMz;
    private com.baidu.tieba.im.chat.a.a esB;
    private final CustomMessageListener esz;
    private com.baidu.tbadk.core.view.g mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.ak(gVar.getPageContext().getPageActivity()));
        this.eJx = null;
        this.eJz = null;
        this.eJA = null;
        this.eMt = null;
        this.eJE = null;
        this.eJH = true;
        this.eMu = false;
        this.eMv = false;
        this.eMw = true;
        this.eMx = 16;
        this.eMz = new CustomMessageListener(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS) { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
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
                    ImMessageCenterShowItemData item = e.this.eMt.getItem(i);
                    if (item != null) {
                        TiebaStatic.eventStat(e.this.eMs.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                        String ownerName = item.getOwnerName();
                        if (TextUtils.isEmpty(ownerName)) {
                            e(item);
                            return;
                        } else if (ownerName.equals("1")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eMs.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                                TiebaStatic.eventStat(e.this.eMs.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.eMs.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("2")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eMs.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GH() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GH().ha(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.eMs.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("3")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eMs.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GH() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GH().gZ(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.eMs.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("6")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eMs.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GH() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GH().hj(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(e.this.eMs.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("5")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eMs.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.eMs.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("8")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eMs.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.eMs.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, item.getUserType())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("7")) {
                            TiebaStatic.log(new ak("c12614"));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.eMs.getPageContext().getPageActivity())));
                            return;
                        } else {
                            e(item);
                            return;
                        }
                    }
                    if (i == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(e.this.eMs.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GB();
                        e.this.eMt.qN(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gm().setMsgReplyme(0);
                        TiebaStatic.eventStat(e.this.eMs.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(e.this.eMs.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GC();
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gm().setMsgAtme(0);
                        e.this.eMt.qO(0);
                        TiebaStatic.eventStat(e.this.eMs.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    }
                    e.this.eMt.notifyDataSetChanged();
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.aGt().mP("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aGt().mP("group_intro_change");
                                com.baidu.tieba.im.db.d.aGt().mP("group_name_change");
                                com.baidu.tieba.im.db.d.aGt().mP("group_notice_change");
                                com.baidu.tieba.im.db.d.aGt().mP("group_level_up");
                                com.baidu.tieba.im.db.d.aGt().mP("dismiss_group");
                                com.baidu.tieba.im.db.d.aGt().mP("kick_out");
                                com.baidu.tieba.im.db.d.aGt().mP("group_activitys_change");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                                com.baidu.tieba.im.db.d.aGt().mP("live_notify");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gm().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.Gm().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.eMs.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.eJI = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.14
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    return false;
                }
                e.this.eJz = e.this.eMt.getItem(i);
                e.this.c(e.this.eJz);
                if (e.this.eJE != null) {
                    e.this.eJE.AL();
                    return true;
                }
                return true;
            }
        };
        this.esz = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
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
                        e.this.eJx.setData(null, e.this.esB);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.eMt != null) {
                            e.this.eMt.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.eMt != null) {
                        e.this.eMt.notifyDataSetChanged();
                    }
                }
            }
        };
        this.esB = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
            @Override // com.baidu.tieba.im.chat.a.a
            public void aEz() {
                if (e.this.eJA != null && e.this.eJx != null) {
                    e.this.eJA.completePullRefreshPostDelayed(2000L);
                    if (e.this.eJx.getData() != null) {
                        e.this.eMt.setData(e.this.eJx.getData());
                    } else {
                        e.this.F(e.this.isLogin(), true);
                    }
                }
            }
        };
        this.dxK = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.h((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.eMs = gVar;
    }

    public void n(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eMx = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eMx = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eMx);
        }
    }

    public void avw() {
        if (this.eMt != null) {
            this.eMt.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.esz);
    }

    public View XT() {
        this.eJG = 3;
        this.rootView = LayoutInflater.from(this.eMs.getPageContext().getPageActivity()).inflate(d.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        bH(this.rootView);
        TiebaStatic.eventStat(this.eMs.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        akY();
        return this.rootView;
    }

    protected void akY() {
        this.eJA.startPullRefresh();
        this.eMu = isLogin();
        if (!this.eMu) {
            F(this.eMu, true);
        }
    }

    private void registerListener() {
        this.eMs.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.esz);
        this.eMs.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.esz);
        this.eMs.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.esz);
        this.eMs.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.esz);
        this.eMs.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.esz);
        this.eMs.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.esz);
        this.eMs.registerListener(this.eMz);
    }

    public void hQ(boolean z) {
        this.eMv = z;
    }

    public void hR(boolean z) {
        this.eMw = z;
    }

    public void onPrimary() {
        if (this.eMt != null && this.eMt.getCount() == 0) {
            hQ(true);
        }
        if (this.eMw || this.eMv) {
            this.eMw = false;
            this.eMv = false;
            eL(false);
        }
        boolean isLogin = isLogin();
        if (this.eMu != isLogin) {
            this.eMu = isLogin;
            onUserChanged(this.eMu);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eMs.getPageContext());
        }
    }

    private void initData() {
        this.eJx = new ImMessageCenterModel();
        hK(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dxK.setPriority(-1);
        this.eMs.registerListener(this.dxK);
    }

    private void bH(View view) {
        this.dtq = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.eJD = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.eJD.setVisibility(8);
        this.eJD.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.hK(false);
                e.this.hI(false);
            }
        });
        this.dmk = (NavigationBar) this.dtq.findViewById(d.g.view_navigation_bar);
        this.eMy = (TextView) this.dmk.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.eMs.getResources().getDimension(d.e.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.eMy.setLayoutParams(layoutParams);
        this.eMy.setText(d.j.my_message);
        this.dmk.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.dmk.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.bc(e.this.mContext.getPageActivity());
                }
            });
            this.dmk.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.bd(e.this.mContext.getPageActivity());
                }
            });
        }
        this.IZ = new TextView(this.eMs.getPageContext().getPageActivity());
        this.IZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.s(this.eMs.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oI());
        this.bYJ = (NoNetworkView) this.dtq.findViewById(d.g.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bYJ.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.bYJ.setLayoutParams(layoutParams2);
        this.bYJ.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bp(boolean z) {
                e.this.hP(z);
            }
        });
        this.eJA = (BdListView) view.findViewById(d.g.chat_list_content);
        this.eJA.addHeaderView(this.IZ);
        this.eJA.setDividerHeight(0);
        this.eMt = new MessageAggregationListAdapter(this.eMs.getPageContext().getPageActivity());
        this.eMt.a(this);
        this.eJA.setAdapter((ListAdapter) this.eMt);
        this.eJA.setOnItemClickListener(this.QC);
        this.eJA.setOnItemLongClickListener(this.eJI);
        this.cVP = new View(this.eMs.getFragmentActivity());
        this.cVP.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.s(this.eMs.getFragmentActivity(), d.e.ds150)));
        this.eJA.addFooterView(this.cVP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eMs.getPageContext(), i);
        }
        this.bYJ.onChangeSkinType(getPageContext(), i);
        this.dmk.onChangeSkinType(tbPageContext, i);
        if (this.eJD != null) {
            this.eJD.onChangeSkinType(i);
        }
        aj.a(this.eMy, d.C0108d.cp_cont_b, d.C0108d.s_navbar_title_color, i);
        if (this.eMt != null) {
            this.eMt.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().aM(this.dtq);
            return true;
        }
        return true;
    }

    private void hS(boolean z) {
        if (z) {
            aKR();
        } else {
            aKS();
        }
    }

    private void aKR() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eMs.getResources().getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) e.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.eMs.getPageContext().getPageActivity(), this.dtq, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eMs.getResources().getDimension(d.e.ds320)), NoDataViewFactory.d.gp(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aKS() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.eMs.getResources().getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.eMs.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.bd(e.this.eMs.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.eMs.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.eMs.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.eMs.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.eMs.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eMs.getPageContext().getPageActivity(), this.dtq, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aB(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.eMs.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        F(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.eJF = new b.InterfaceC0074b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0074b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        e.this.eJx.deleteItem(imMessageCenterShowItemData, e.this.esB);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.eMs.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.eJE = new com.baidu.tbadk.core.dialog.b(this.eMs.getPageContext().getPageActivity());
        this.eJE.fg(d.j.operation);
        this.eJE.a(new String[]{string}, this.eJF);
        this.eJE.d(this.eMs.getPageContext());
    }

    protected boolean eL(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.eJA.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void hI(boolean z) {
        if (z) {
            if (aKT() && this.eJD.getVisibility() != 0) {
                this.eJD.setVisibility(0);
            }
        } else if (this.eJD.getVisibility() != 8) {
            this.eJD.setVisibility(8);
        }
    }

    public void F(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eJA.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.dtq.removeView(this.mNoDataView);
        }
        hS(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.eJA.setVisibility(8);
    }

    public boolean aKT() {
        return this.eJH;
    }

    public void hK(boolean z) {
        this.eJH = z;
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
                if (this.eJx != null) {
                    this.eJx.insertOrUpdate(data, this.esB);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eJx != null) {
                this.eJx.remove(data, this.esB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.eJx != null) {
                this.eJx.setData(data, this.esB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eMx = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eMx != -1) {
                hQ(true);
                onPrimary();
            }
        }
    }

    public void hP(boolean z) {
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oI());
        if (z && this.eJA != null && this.eJA.getWrappedAdapter() != null && this.eJA.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
                @Override // java.lang.Runnable
                public void run() {
                    e.this.eJA.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.i.b
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
        this.eMt.qN(i);
        this.eMt.qO(i2);
        this.eMt.notifyDataSetChanged();
    }

    public void hT(boolean z) {
        this.dmk.setVisibility(z ? 0 : 8);
    }
}
