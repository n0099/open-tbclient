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
import com.baidu.tbadk.core.view.h;
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
public class e extends com.baidu.adp.base.c<g> implements h.b {
    private View amR;
    private final CustomMessageListener beE;
    private NoNetworkView bly;
    private RelativeLayout cEb;
    private final CustomMessageListener cIo;
    private View chl;
    private NavigationBar cxM;
    private final CustomMessageListener dGv;
    private com.baidu.tieba.im.chat.a.a dGx;
    com.baidu.tbadk.core.dialog.b dXA;
    private b.InterfaceC0060b dXB;
    private int dXC;
    private boolean dXD;
    private final AdapterView.OnItemClickListener dXE;
    private final AdapterView.OnItemLongClickListener dXF;
    private ImMessageCenterModel dXt;
    private ImMessageCenterShowItemData dXv;
    private BdListView dXw;
    private ShutDownValidateTipView dXz;
    private final g eap;
    private MessageAggregationListAdapter eaq;
    private boolean ear;
    private boolean eas;
    private boolean eat;
    private int eau;
    private TextView eav;
    private CustomMessageListener eaw;
    private com.baidu.tbadk.core.view.g mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.Y(gVar.getPageContext().getPageActivity()));
        this.dXt = null;
        this.dXv = null;
        this.dXw = null;
        this.eaq = null;
        this.dXA = null;
        this.dXD = true;
        this.ear = false;
        this.eas = false;
        this.eat = true;
        this.eau = 16;
        this.beE = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && e.this.eaq != null) {
                    e.this.eaq.notifyDataSetChanged();
                }
            }
        };
        this.eaw = new CustomMessageListener(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS) { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && e.this.mNoDataView != null && e.this.mNoDataView.getVisibility() == 0) {
                    e.this.D(e.this.isLogin(), true);
                }
            }
        };
        this.dXE = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData item = e.this.eaq.getItem(i);
                    if (item != null) {
                        TiebaStatic.eventStat(e.this.eap.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                        String ownerName = item.getOwnerName();
                        if (TextUtils.isEmpty(ownerName)) {
                            e(item);
                            return;
                        } else if (ownerName.equals("1")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eap.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                                TiebaStatic.eventStat(e.this.eap.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.eap.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("2")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eap.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi().ec(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.eap.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("3")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eap.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi().eb(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.eap.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("6")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eap.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi().el(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(e.this.eap.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("5")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eap.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.eap.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("8")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eap.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.eap.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, item.getUserType())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("7")) {
                            TiebaStatic.log(new ak("c12614"));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.eap.getPageContext().getPageActivity())));
                            return;
                        } else {
                            e(item);
                            return;
                        }
                    }
                    if (i == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(e.this.eap.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yN().zc();
                        e.this.eaq.nV(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgReplyme(0);
                        TiebaStatic.eventStat(e.this.eap.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(e.this.eap.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yN().zd();
                        com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgAtme(0);
                        e.this.eaq.nW(0);
                        TiebaStatic.eventStat(e.this.eap.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    }
                    e.this.eaq.notifyDataSetChanged();
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.azs().mG("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.azs().mG("group_intro_change");
                                com.baidu.tieba.im.db.d.azs().mG("group_name_change");
                                com.baidu.tieba.im.db.d.azs().mG("group_notice_change");
                                com.baidu.tieba.im.db.d.azs().mG("group_level_up");
                                com.baidu.tieba.im.db.d.azs().mG("dismiss_group");
                                com.baidu.tieba.im.db.d.azs().mG("kick_out");
                                com.baidu.tieba.im.db.d.azs().mG("group_activitys_change");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                                com.baidu.tieba.im.db.d.azs().mG("live_notify");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.eap.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.dXF = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    return false;
                }
                e.this.dXv = e.this.eaq.getItem(i);
                e.this.c(e.this.dXv);
                if (e.this.dXA != null) {
                    e.this.dXA.tl();
                    return true;
                }
                return true;
            }
        };
        this.dGv = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
                        e.this.dXt.setData(null, e.this.dGx);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.eaq != null) {
                            e.this.eaq.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.eaq != null) {
                        e.this.eaq.notifyDataSetChanged();
                    }
                }
            }
        };
        this.dGx = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // com.baidu.tieba.im.chat.a.a
            public void axy() {
                if (e.this.dXw != null && e.this.dXt != null) {
                    e.this.dXw.completePullRefreshPostDelayed(2000L);
                    if (e.this.dXt.getData() != null) {
                        e.this.eaq.setData(e.this.dXt.getData());
                    } else {
                        e.this.D(e.this.isLogin(), true);
                    }
                }
            }
        };
        this.cIo = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.h((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.eap = gVar;
    }

    public void k(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eau = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eau = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eau);
        }
    }

    public void anW() {
        if (this.eaq != null) {
            this.eaq.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dGv);
    }

    public View Qv() {
        this.dXC = 3;
        this.rootView = LayoutInflater.from(this.eap.getPageContext().getPageActivity()).inflate(d.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        au(this.rootView);
        TiebaStatic.eventStat(this.eap.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        ads();
        return this.rootView;
    }

    protected void ads() {
        this.dXw.startPullRefresh();
        this.ear = isLogin();
        if (!this.ear) {
            D(this.ear, true);
        }
    }

    private void registerListener() {
        this.eap.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dGv);
        this.eap.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dGv);
        this.eap.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dGv);
        this.eap.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dGv);
        this.eap.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dGv);
        this.eap.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dGv);
        this.eap.registerListener(this.beE);
        this.eap.registerListener(this.eaw);
    }

    public void hr(boolean z) {
        this.eas = z;
    }

    public void hs(boolean z) {
        this.eat = z;
    }

    public void onPrimary() {
        if (this.eaq != null && this.eaq.getCount() == 0) {
            hr(true);
        }
        if (this.eat || this.eas) {
            this.eat = false;
            this.eas = false;
            ee(false);
        }
        boolean isLogin = isLogin();
        if (this.ear != isLogin) {
            this.ear = isLogin;
            onUserChanged(this.ear);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eap.getPageContext());
        }
    }

    private void initData() {
        this.dXt = new ImMessageCenterModel();
        hl(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.eap.registerListener(this.cIo);
    }

    private void au(View view) {
        this.cEb = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.dXz = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.dXz.setVisibility(8);
        this.dXz.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.hl(false);
                e.this.hj(false);
            }
        });
        this.cxM = (NavigationBar) this.cEb.findViewById(d.g.view_navigation_bar);
        this.eav = (TextView) this.cxM.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.eap.getResources().getDimension(d.e.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.eav.setLayoutParams(layoutParams);
        this.eav.setText(d.j.my_message);
        this.cxM.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.cxM.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.aQ(e.this.mContext.getPageActivity());
                }
            });
            this.cxM.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aR(e.this.mContext.getPageActivity());
                }
            });
        }
        this.amR = new TextView(this.eap.getPageContext().getPageActivity());
        this.amR.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eap.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.amR, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.bly = (NoNetworkView) this.cEb.findViewById(d.g.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bly.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.bly.setLayoutParams(layoutParams2);
        this.bly.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                e.this.hq(z);
            }
        });
        this.dXw = (BdListView) view.findViewById(d.g.chat_list_content);
        this.dXw.addHeaderView(this.amR);
        this.dXw.setDividerHeight(0);
        this.eaq = new MessageAggregationListAdapter(this.eap.getPageContext().getPageActivity());
        this.eaq.a(this);
        this.dXw.setAdapter((ListAdapter) this.eaq);
        this.dXw.setOnItemClickListener(this.dXE);
        this.dXw.setOnItemLongClickListener(this.dXF);
        this.chl = new View(this.eap.getFragmentActivity());
        this.chl.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.eap.getFragmentActivity(), d.e.ds150)));
        this.dXw.addFooterView(this.chl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eap.getPageContext(), i);
        }
        this.bly.onChangeSkinType(getPageContext(), i);
        this.cxM.onChangeSkinType(tbPageContext, i);
        if (this.dXz != null) {
            this.dXz.onChangeSkinType(i);
        }
        aj.a(this.eav, d.C0095d.cp_cont_b, d.C0095d.s_navbar_title_color, i);
        if (this.eaq != null) {
            this.eaq.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.cEb);
            return true;
        }
        return true;
    }

    private void ht(boolean z) {
        if (z) {
            aDQ();
        } else {
            aDR();
        }
    }

    private void aDQ() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eap.getResources().getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) e.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.eap.getPageContext().getPageActivity(), this.cEb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eap.getResources().getDimension(d.e.ds320)), NoDataViewFactory.d.dq(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aDR() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.eap.getResources().getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.eap.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aR(e.this.eap.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.eap.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.eap.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.eap.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.eap.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eap.getPageContext().getPageActivity(), this.cEb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.eap.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        D(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dXB = new b.InterfaceC0060b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        e.this.dXt.deleteItem(imMessageCenterShowItemData, e.this.dGx);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.eap.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.dXA = new com.baidu.tbadk.core.dialog.b(this.eap.getPageContext().getPageActivity());
        this.dXA.cg(d.j.operation);
        this.dXA.a(new String[]{string}, this.dXB);
        this.dXA.d(this.eap.getPageContext());
    }

    protected boolean ee(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dXw.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void hj(boolean z) {
        if (z) {
            if (aDS() && this.dXz.getVisibility() != 0) {
                this.dXz.setVisibility(0);
            }
        } else if (this.dXz.getVisibility() != 8) {
            this.dXz.setVisibility(8);
        }
    }

    public void D(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.dXw.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.cEb.removeView(this.mNoDataView);
        }
        ht(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.dXw.setVisibility(8);
    }

    public boolean aDS() {
        return this.dXD;
    }

    public void hl(boolean z) {
        this.dXD = z;
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
                if (this.dXt != null) {
                    this.dXt.insertOrUpdate(data, this.dGx);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dXt != null) {
                this.dXt.remove(data, this.dGx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dXt != null) {
                this.dXt.setData(data, this.dGx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eau = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eau != -1) {
                hr(true);
                onPrimary();
            }
        }
    }

    public void hq(boolean z) {
        BdListViewHelper.a(this.amR, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        if (z && this.dXw != null && this.dXw.getWrappedAdapter() != null && this.dXw.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
                @Override // java.lang.Runnable
                public void run() {
                    e.this.dXw.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.h.b
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
            bk(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void bk(int i, int i2) {
        this.eaq.nV(i);
        this.eaq.nW(i2);
        this.eaq.notifyDataSetChanged();
    }

    public void hu(boolean z) {
        this.cxM.setVisibility(z ? 0 : 8);
    }
}
