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
    private NoNetworkView bYY;
    private boolean cKJ;
    private final CustomMessageListener dCG;
    private View daO;
    private NavigationBar drg;
    private RelativeLayout dyl;
    private b.InterfaceC0073b eLA;
    private int eLB;
    private boolean eLC;
    private final AdapterView.OnItemLongClickListener eLD;
    private ImMessageCenterModel eLs;
    private ImMessageCenterShowItemData eLu;
    private BdListView eLv;
    private ShutDownValidateTipView eLy;
    com.baidu.tbadk.core.dialog.b eLz;
    private final g eOn;
    private MessageAggregationListAdapter eOo;
    private boolean eOp;
    private boolean eOq;
    private int eOr;
    private TextView eOs;
    private CustomMessageListener eOt;
    private final CustomMessageListener eus;
    private com.baidu.tieba.im.chat.a.a euu;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.ak(gVar.getPageContext().getPageActivity()));
        this.eLs = null;
        this.eLu = null;
        this.eLv = null;
        this.eOo = null;
        this.eLz = null;
        this.eLC = true;
        this.eOp = false;
        this.cKJ = false;
        this.eOq = true;
        this.eOr = 16;
        this.eOt = new CustomMessageListener(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS) { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
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
                    ImMessageCenterShowItemData item = e.this.eOo.getItem(i);
                    if (item != null) {
                        TiebaStatic.eventStat(e.this.eOn.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                        String ownerName = item.getOwnerName();
                        if (TextUtils.isEmpty(ownerName)) {
                            e(item);
                            return;
                        } else if (ownerName.equals("1")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eOn.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                                TiebaStatic.eventStat(e.this.eOn.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.eOn.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("2")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eOn.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().gX(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.eOn.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("3")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eOn.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().gW(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.eOn.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("6")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eOn.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().hg(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(e.this.eOn.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("5")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eOn.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.eOn.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("8")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eOn.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.eOn.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, item.getUserType())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("7")) {
                            TiebaStatic.log(new ak("c12614"));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.eOn.getPageContext().getPageActivity())));
                            return;
                        } else {
                            e(item);
                            return;
                        }
                    }
                    if (i == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(e.this.eOn.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().Gw();
                        e.this.eOo.qG(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().setMsgReplyme(0);
                        TiebaStatic.eventStat(e.this.eOn.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(e.this.eOn.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().Gx();
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().setMsgAtme(0);
                        e.this.eOo.qH(0);
                        TiebaStatic.eventStat(e.this.eOn.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    }
                    e.this.eOo.notifyDataSetChanged();
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.aGD().na("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aGD().na("group_intro_change");
                                com.baidu.tieba.im.db.d.aGD().na("group_name_change");
                                com.baidu.tieba.im.db.d.aGD().na("group_notice_change");
                                com.baidu.tieba.im.db.d.aGD().na("group_level_up");
                                com.baidu.tieba.im.db.d.aGD().na("dismiss_group");
                                com.baidu.tieba.im.db.d.aGD().na("kick_out");
                                com.baidu.tieba.im.db.d.aGD().na("group_activitys_change");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                                com.baidu.tieba.im.db.d.aGD().na("live_notify");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gh().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.Gh().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.eOn.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.eLD = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.14
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    return false;
                }
                e.this.eLu = e.this.eOo.getItem(i);
                e.this.c(e.this.eLu);
                if (e.this.eLz != null) {
                    e.this.eLz.AE();
                    return true;
                }
                return true;
            }
        };
        this.eus = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
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
                        e.this.eLs.setData(null, e.this.euu);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.eOo != null) {
                            e.this.eOo.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.eOo != null) {
                        e.this.eOo.notifyDataSetChanged();
                    }
                }
            }
        };
        this.euu = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
            @Override // com.baidu.tieba.im.chat.a.a
            public void aEJ() {
                if (e.this.eLv != null && e.this.eLs != null) {
                    e.this.eLv.completePullRefreshPostDelayed(2000L);
                    if (e.this.eLs.getData() != null) {
                        e.this.eOo.setData(e.this.eLs.getData());
                    } else {
                        e.this.F(e.this.isLogin(), true);
                    }
                }
            }
        };
        this.dCG = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.h((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.eOn = gVar;
    }

    public void n(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eOr = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eOr = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eOr);
        }
    }

    public void awE() {
        if (this.eOo != null) {
            this.eOo.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eus);
    }

    public View XJ() {
        this.eLB = 3;
        this.rootView = LayoutInflater.from(this.eOn.getPageContext().getPageActivity()).inflate(d.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        bJ(this.rootView);
        TiebaStatic.eventStat(this.eOn.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        amg();
        return this.rootView;
    }

    protected void amg() {
        this.eLv.startPullRefresh();
        this.eOp = isLogin();
        if (!this.eOp) {
            F(this.eOp, true);
        }
    }

    private void registerListener() {
        this.eOn.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.eus);
        this.eOn.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.eus);
        this.eOn.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.eus);
        this.eOn.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.eus);
        this.eOn.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.eus);
        this.eOn.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.eus);
        this.eOn.registerListener(this.eOt);
    }

    public void hW(boolean z) {
        this.cKJ = z;
    }

    public void hX(boolean z) {
        this.eOq = z;
    }

    public void onPrimary() {
        if (this.eOo != null && this.eOo.getCount() == 0) {
            hW(true);
        }
        if (this.eOq || this.cKJ) {
            this.eOq = false;
            this.cKJ = false;
            eS(false);
        }
        boolean isLogin = isLogin();
        if (this.eOp != isLogin) {
            this.eOp = isLogin;
            onUserChanged(this.eOp);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eOn.getPageContext());
        }
    }

    private void initData() {
        this.eLs = new ImMessageCenterModel();
        hQ(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dCG.setPriority(-1);
        this.eOn.registerListener(this.dCG);
    }

    private void bJ(View view) {
        this.dyl = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.eLy = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.eLy.setVisibility(8);
        this.eLy.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.hQ(false);
                e.this.hO(false);
            }
        });
        this.drg = (NavigationBar) this.dyl.findViewById(d.g.view_navigation_bar);
        this.eOs = (TextView) this.drg.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.eOn.getResources().getDimension(d.e.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.eOs.setLayoutParams(layoutParams);
        this.eOs.setText(d.j.my_message);
        this.drg.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.drg.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.aZ(e.this.mContext.getPageActivity());
                }
            });
            this.drg.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.ba(e.this.mContext.getPageActivity());
                }
            });
        }
        this.IZ = new TextView(this.eOn.getPageContext().getPageActivity());
        this.IZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.s(this.eOn.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
        this.bYY = (NoNetworkView) this.dyl.findViewById(d.g.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bYY.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.bYY.setLayoutParams(layoutParams2);
        this.bYY.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bq(boolean z) {
                e.this.hV(z);
            }
        });
        this.eLv = (BdListView) view.findViewById(d.g.chat_list_content);
        this.eLv.addHeaderView(this.IZ);
        this.eLv.setDividerHeight(0);
        this.eOo = new MessageAggregationListAdapter(this.eOn.getPageContext().getPageActivity());
        this.eOo.a(this);
        this.eLv.setAdapter((ListAdapter) this.eOo);
        this.eLv.setOnItemClickListener(this.QC);
        this.eLv.setOnItemLongClickListener(this.eLD);
        this.daO = new View(this.eOn.getFragmentActivity());
        this.daO.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.s(this.eOn.getFragmentActivity(), d.e.ds150)));
        this.eLv.addFooterView(this.daO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eOn.getPageContext(), i);
        }
        this.bYY.onChangeSkinType(getPageContext(), i);
        this.drg.onChangeSkinType(tbPageContext, i);
        if (this.eLy != null) {
            this.eLy.onChangeSkinType(i);
        }
        aj.a(this.eOs, d.C0108d.cp_cont_b, d.C0108d.s_navbar_title_color, i);
        if (this.eOo != null) {
            this.eOo.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().aM(this.dyl);
            return true;
        }
        return true;
    }

    private void hY(boolean z) {
        if (z) {
            aLb();
        } else {
            aLc();
        }
    }

    private void aLb() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eOn.getResources().getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) e.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.eOn.getPageContext().getPageActivity(), this.dyl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eOn.getResources().getDimension(d.e.ds320)), NoDataViewFactory.d.gn(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aLc() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.eOn.getResources().getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.eOn.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.ba(e.this.eOn.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.eOn.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.eOn.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.eOn.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.eOn.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eOn.getPageContext().getPageActivity(), this.dyl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aB(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.eOn.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        F(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.eLA = new b.InterfaceC0073b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        e.this.eLs.deleteItem(imMessageCenterShowItemData, e.this.euu);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.eOn.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.eLz = new com.baidu.tbadk.core.dialog.b(this.eOn.getPageContext().getPageActivity());
        this.eLz.fe(d.j.operation);
        this.eLz.a(new String[]{string}, this.eLA);
        this.eLz.d(this.eOn.getPageContext());
    }

    protected boolean eS(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.eLv.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void hO(boolean z) {
        if (z) {
            if (aLd() && this.eLy.getVisibility() != 0) {
                this.eLy.setVisibility(0);
            }
        } else if (this.eLy.getVisibility() != 8) {
            this.eLy.setVisibility(8);
        }
    }

    public void F(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eLv.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.dyl.removeView(this.mNoDataView);
        }
        hY(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.eLv.setVisibility(8);
    }

    public boolean aLd() {
        return this.eLC;
    }

    public void hQ(boolean z) {
        this.eLC = z;
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
                if (this.eLs != null) {
                    this.eLs.insertOrUpdate(data, this.euu);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eLs != null) {
                this.eLs.remove(data, this.euu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.eLs != null) {
                this.eLs.setData(data, this.euu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eOr = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eOr != -1) {
                hW(true);
                onPrimary();
            }
        }
    }

    public void hV(boolean z) {
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
        if (z && this.eLv != null && this.eLv.getWrappedAdapter() != null && this.eLv.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
                @Override // java.lang.Runnable
                public void run() {
                    e.this.eLv.startPullRefresh();
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
        this.eOo.qG(i);
        this.eOo.qH(i2);
        this.eOo.notifyDataSetChanged();
    }

    public void hZ(boolean z) {
        this.drg.setVisibility(z ? 0 : 8);
    }
}
