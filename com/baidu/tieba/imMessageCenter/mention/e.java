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
import java.util.List;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.base.c<g> implements g.b {
    private View amR;
    private final CustomMessageListener bez;
    private NoNetworkView blt;
    private RelativeLayout cDP;
    private final CustomMessageListener cIb;
    private View cgT;
    private NavigationBar cxz;
    private final CustomMessageListener dFn;
    private com.baidu.tieba.im.chat.a.a dFp;
    private ImMessageCenterModel dWk;
    private ImMessageCenterShowItemData dWm;
    private BdListView dWn;
    private ShutDownValidateTipView dWq;
    com.baidu.tbadk.core.dialog.b dWr;
    private b.InterfaceC0047b dWs;
    private int dWt;
    private boolean dWu;
    private final AdapterView.OnItemClickListener dWv;
    private final AdapterView.OnItemLongClickListener dWw;
    private final g dZg;
    private MessageAggregationListAdapter dZh;
    private boolean dZi;
    private boolean dZj;
    private boolean dZk;
    private int dZl;
    private TextView dZm;
    private CustomMessageListener dZn;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.Y(gVar.getPageContext().getPageActivity()));
        this.dWk = null;
        this.dWm = null;
        this.dWn = null;
        this.dZh = null;
        this.dWr = null;
        this.dWu = true;
        this.dZi = false;
        this.dZj = false;
        this.dZk = true;
        this.dZl = 16;
        this.bez = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && e.this.dZh != null) {
                    e.this.dZh.notifyDataSetChanged();
                }
            }
        };
        this.dZn = new CustomMessageListener(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS) { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && e.this.mNoDataView != null && e.this.mNoDataView.getVisibility() == 0) {
                    e.this.D(e.this.isLogin(), true);
                }
            }
        };
        this.dWv = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData item = e.this.dZh.getItem(i);
                    if (item != null) {
                        TiebaStatic.eventStat(e.this.dZg.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                        String ownerName = item.getOwnerName();
                        if (TextUtils.isEmpty(ownerName)) {
                            e(item);
                            return;
                        } else if (ownerName.equals("1")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dZg.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                                TiebaStatic.eventStat(e.this.dZg.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.dZg.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("2")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dZg.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh().ec(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.dZg.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("3")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dZg.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh().eb(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.dZg.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("6")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dZg.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh().el(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(e.this.dZg.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("5")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dZg.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.dZg.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("8")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dZg.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.dZg.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, item.getUserType())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("7")) {
                            TiebaStatic.log(new ak("c12614"));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.dZg.getPageContext().getPageActivity())));
                            return;
                        } else {
                            e(item);
                            return;
                        }
                    }
                    if (i == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(e.this.dZg.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yM().zb();
                        e.this.dZh.nO(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yM().setMsgReplyme(0);
                        TiebaStatic.eventStat(e.this.dZg.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(e.this.dZg.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yM().zc();
                        com.baidu.tbadk.coreExtra.messageCenter.a.yM().setMsgAtme(0);
                        e.this.dZh.nP(0);
                        TiebaStatic.eventStat(e.this.dZg.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    }
                    e.this.dZh.notifyDataSetChanged();
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.azj().mG("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.azj().mG("group_intro_change");
                                com.baidu.tieba.im.db.d.azj().mG("group_name_change");
                                com.baidu.tieba.im.db.d.azj().mG("group_notice_change");
                                com.baidu.tieba.im.db.d.azj().mG("group_level_up");
                                com.baidu.tieba.im.db.d.azj().mG("dismiss_group");
                                com.baidu.tieba.im.db.d.azj().mG("kick_out");
                                com.baidu.tieba.im.db.d.azj().mG("group_activitys_change");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                                com.baidu.tieba.im.db.d.azj().mG("live_notify");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.yM().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.yM().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.dZg.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.dWw = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    return false;
                }
                e.this.dWm = e.this.dZh.getItem(i);
                e.this.c(e.this.dWm);
                if (e.this.dWr != null) {
                    e.this.dWr.to();
                    return true;
                }
                return true;
            }
        };
        this.dFn = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
                        e.this.dWk.setData(null, e.this.dFp);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.dZh != null) {
                            e.this.dZh.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.dZh != null) {
                        e.this.dZh.notifyDataSetChanged();
                    }
                }
            }
        };
        this.dFp = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // com.baidu.tieba.im.chat.a.a
            public void axp() {
                if (e.this.dWn != null && e.this.dWk != null) {
                    e.this.dWn.completePullRefreshPostDelayed(2000L);
                    if (e.this.dWk.getData() != null) {
                        e.this.dZh.setData(e.this.dWk.getData());
                    } else {
                        e.this.D(e.this.isLogin(), true);
                    }
                }
            }
        };
        this.cIb = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.h(customResponsedMessage);
                }
            }
        };
        this.dZg = gVar;
    }

    public void k(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dZl = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dZl = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dZl);
        }
    }

    public void anN() {
        if (this.dZh != null) {
            this.dZh.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dFn);
    }

    public View Qv() {
        this.dWt = 3;
        this.rootView = LayoutInflater.from(this.dZg.getPageContext().getPageActivity()).inflate(d.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        as(this.rootView);
        TiebaStatic.eventStat(this.dZg.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        adj();
        return this.rootView;
    }

    protected void adj() {
        this.dWn.startPullRefresh();
        this.dZi = isLogin();
        if (!this.dZi) {
            D(this.dZi, true);
        }
    }

    private void registerListener() {
        this.dZg.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dFn);
        this.dZg.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dFn);
        this.dZg.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dFn);
        this.dZg.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dFn);
        this.dZg.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dFn);
        this.dZg.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dFn);
        this.dZg.registerListener(this.bez);
        this.dZg.registerListener(this.dZn);
    }

    public void hq(boolean z) {
        this.dZj = z;
    }

    public void hr(boolean z) {
        this.dZk = z;
    }

    public void onPrimary() {
        if (this.dZh != null && this.dZh.getCount() == 0) {
            hq(true);
        }
        if (this.dZk || this.dZj) {
            this.dZk = false;
            this.dZj = false;
            ed(false);
        }
        boolean isLogin = isLogin();
        if (this.dZi != isLogin) {
            this.dZi = isLogin;
            onUserChanged(this.dZi);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dZg.getPageContext());
        }
    }

    private void initData() {
        this.dWk = new ImMessageCenterModel();
        hk(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dZg.registerListener(this.cIb);
    }

    private void as(View view) {
        this.cDP = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.dWq = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.dWq.setVisibility(8);
        this.dWq.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.hk(false);
                e.this.hi(false);
            }
        });
        this.cxz = (NavigationBar) this.cDP.findViewById(d.g.view_navigation_bar);
        this.dZm = (TextView) this.cxz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dZg.getResources().getDimension(d.e.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dZm.setLayoutParams(layoutParams);
        this.dZm.setText(d.j.my_message);
        this.cxz.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.cxz.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.aT(e.this.mContext.getPageActivity());
                }
            });
            this.cxz.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aU(e.this.mContext.getPageActivity());
                }
            });
        }
        this.amR = new TextView(this.dZg.getPageContext().getPageActivity());
        this.amR.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dZg.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.amR, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.blt = (NoNetworkView) this.cDP.findViewById(d.g.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.blt.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.blt.setLayoutParams(layoutParams2);
        this.blt.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                e.this.hp(z);
            }
        });
        this.dWn = (BdListView) view.findViewById(d.g.chat_list_content);
        this.dWn.addHeaderView(this.amR);
        this.dWn.setDividerHeight(0);
        this.dZh = new MessageAggregationListAdapter(this.dZg.getPageContext().getPageActivity());
        this.dZh.a(this);
        this.dWn.setAdapter((ListAdapter) this.dZh);
        this.dWn.setOnItemClickListener(this.dWv);
        this.dWn.setOnItemLongClickListener(this.dWw);
        this.cgT = new View(this.dZg.getFragmentActivity());
        this.cgT.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.dZg.getFragmentActivity(), d.e.ds150)));
        this.dWn.addFooterView(this.cgT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dZg.getPageContext(), i);
        }
        this.blt.onChangeSkinType(getPageContext(), i);
        this.cxz.onChangeSkinType(tbPageContext, i);
        if (this.dWq != null) {
            this.dWq.onChangeSkinType(i);
        }
        aj.a(this.dZm, d.C0082d.cp_cont_b, d.C0082d.s_navbar_title_color, i);
        if (this.dZh != null) {
            this.dZh.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.cDP);
            return true;
        }
        return true;
    }

    private void hs(boolean z) {
        if (z) {
            aDH();
        } else {
            aDI();
        }
    }

    private void aDH() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dZg.getResources().getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) e.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dZg.getPageContext().getPageActivity(), this.cDP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dZg.getResources().getDimension(d.e.ds320)), NoDataViewFactory.d.dq(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aDI() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dZg.getResources().getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.dZg.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aU(e.this.dZg.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.dZg.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.dZg.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.dZg.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.dZg.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dZg.getPageContext().getPageActivity(), this.cDP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dZg.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        D(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dWs = new b.InterfaceC0047b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        e.this.dWk.deleteItem(imMessageCenterShowItemData, e.this.dFp);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dZg.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.dWr = new com.baidu.tbadk.core.dialog.b(this.dZg.getPageContext().getPageActivity());
        this.dWr.cg(d.j.operation);
        this.dWr.a(new String[]{string}, this.dWs);
        this.dWr.d(this.dZg.getPageContext());
    }

    protected boolean ed(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dWn.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void hi(boolean z) {
        if (z) {
            if (aDJ() && this.dWq.getVisibility() != 0) {
                this.dWq.setVisibility(0);
            }
        } else if (this.dWq.getVisibility() != 8) {
            this.dWq.setVisibility(8);
        }
    }

    public void D(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.dWn.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.cDP.removeView(this.mNoDataView);
        }
        hs(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.dWn.setVisibility(8);
    }

    public boolean aDJ() {
        return this.dWu;
    }

    public void hk(boolean z) {
        this.dWu = z;
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
                if (this.dWk != null) {
                    this.dWk.insertOrUpdate(data, this.dFp);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dWk != null) {
                this.dWk.remove(data, this.dFp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dWk != null) {
                this.dWk.setData(data, this.dFp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dZl = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dZl != -1) {
                hq(true);
                onPrimary();
            }
        }
    }

    public void hp(boolean z) {
        BdListViewHelper.a(this.amR, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        if (z && this.dWn != null && this.dWn.getWrappedAdapter() != null && this.dWn.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
                @Override // java.lang.Runnable
                public void run() {
                    e.this.dWn.startPullRefresh();
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
            bj(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void bj(int i, int i2) {
        this.dZh.nO(i);
        this.dZh.nP(i2);
        this.dZh.notifyDataSetChanged();
    }

    public void ht(boolean z) {
        this.cxz.setVisibility(z ? 0 : 8);
    }
}
