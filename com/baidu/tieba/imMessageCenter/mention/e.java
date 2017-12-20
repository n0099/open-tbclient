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
    private View amO;
    private final CustomMessageListener beA;
    private NoNetworkView blu;
    private RelativeLayout cDX;
    private final CustomMessageListener cIk;
    private View chh;
    private NavigationBar cxI;
    private final CustomMessageListener dGr;
    private com.baidu.tieba.im.chat.a.a dGt;
    private final AdapterView.OnItemClickListener dXA;
    private final AdapterView.OnItemLongClickListener dXB;
    private ImMessageCenterModel dXp;
    private ImMessageCenterShowItemData dXr;
    private BdListView dXs;
    private ShutDownValidateTipView dXv;
    com.baidu.tbadk.core.dialog.b dXw;
    private b.InterfaceC0061b dXx;
    private int dXy;
    private boolean dXz;
    private final g eal;
    private MessageAggregationListAdapter eam;
    private boolean ean;
    private boolean eao;
    private boolean eap;
    private int eaq;
    private TextView ear;
    private CustomMessageListener eas;
    private com.baidu.tbadk.core.view.g mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.Y(gVar.getPageContext().getPageActivity()));
        this.dXp = null;
        this.dXr = null;
        this.dXs = null;
        this.eam = null;
        this.dXw = null;
        this.dXz = true;
        this.ean = false;
        this.eao = false;
        this.eap = true;
        this.eaq = 16;
        this.beA = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && e.this.eam != null) {
                    e.this.eam.notifyDataSetChanged();
                }
            }
        };
        this.eas = new CustomMessageListener(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS) { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && e.this.mNoDataView != null && e.this.mNoDataView.getVisibility() == 0) {
                    e.this.D(e.this.isLogin(), true);
                }
            }
        };
        this.dXA = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData item = e.this.eam.getItem(i);
                    if (item != null) {
                        TiebaStatic.eventStat(e.this.eal.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                        String ownerName = item.getOwnerName();
                        if (TextUtils.isEmpty(ownerName)) {
                            e(item);
                            return;
                        } else if (ownerName.equals("1")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eal.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                                TiebaStatic.eventStat(e.this.eal.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.eal.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("2")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eal.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi().ec(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.eal.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("3")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eal.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi().eb(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.eal.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("6")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eal.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi().el(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(e.this.eal.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("5")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eal.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.eal.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("8")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eal.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.eal.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, item.getUserType())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("7")) {
                            TiebaStatic.log(new ak("c12614"));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.eal.getPageContext().getPageActivity())));
                            return;
                        } else {
                            e(item);
                            return;
                        }
                    }
                    if (i == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(e.this.eal.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yN().zc();
                        e.this.eam.nV(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgReplyme(0);
                        TiebaStatic.eventStat(e.this.eal.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(e.this.eal.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yN().zd();
                        com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgAtme(0);
                        e.this.eam.nW(0);
                        TiebaStatic.eventStat(e.this.eal.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    }
                    e.this.eam.notifyDataSetChanged();
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.azr().mG("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.azr().mG("group_intro_change");
                                com.baidu.tieba.im.db.d.azr().mG("group_name_change");
                                com.baidu.tieba.im.db.d.azr().mG("group_notice_change");
                                com.baidu.tieba.im.db.d.azr().mG("group_level_up");
                                com.baidu.tieba.im.db.d.azr().mG("dismiss_group");
                                com.baidu.tieba.im.db.d.azr().mG("kick_out");
                                com.baidu.tieba.im.db.d.azr().mG("group_activitys_change");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                                com.baidu.tieba.im.db.d.azr().mG("live_notify");
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.eal.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.dXB = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    return false;
                }
                e.this.dXr = e.this.eam.getItem(i);
                e.this.c(e.this.dXr);
                if (e.this.dXw != null) {
                    e.this.dXw.tl();
                    return true;
                }
                return true;
            }
        };
        this.dGr = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
                        e.this.dXp.setData(null, e.this.dGt);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.eam != null) {
                            e.this.eam.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.eam != null) {
                        e.this.eam.notifyDataSetChanged();
                    }
                }
            }
        };
        this.dGt = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // com.baidu.tieba.im.chat.a.a
            public void axx() {
                if (e.this.dXs != null && e.this.dXp != null) {
                    e.this.dXs.completePullRefreshPostDelayed(2000L);
                    if (e.this.dXp.getData() != null) {
                        e.this.eam.setData(e.this.dXp.getData());
                    } else {
                        e.this.D(e.this.isLogin(), true);
                    }
                }
            }
        };
        this.cIk = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.h((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.eal = gVar;
    }

    public void k(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eaq = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eaq = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eaq);
        }
    }

    public void anV() {
        if (this.eam != null) {
            this.eam.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dGr);
    }

    public View Qv() {
        this.dXy = 3;
        this.rootView = LayoutInflater.from(this.eal.getPageContext().getPageActivity()).inflate(d.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        au(this.rootView);
        TiebaStatic.eventStat(this.eal.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        ads();
        return this.rootView;
    }

    protected void ads() {
        this.dXs.startPullRefresh();
        this.ean = isLogin();
        if (!this.ean) {
            D(this.ean, true);
        }
    }

    private void registerListener() {
        this.eal.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dGr);
        this.eal.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dGr);
        this.eal.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dGr);
        this.eal.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dGr);
        this.eal.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dGr);
        this.eal.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dGr);
        this.eal.registerListener(this.beA);
        this.eal.registerListener(this.eas);
    }

    public void hr(boolean z) {
        this.eao = z;
    }

    public void hs(boolean z) {
        this.eap = z;
    }

    public void onPrimary() {
        if (this.eam != null && this.eam.getCount() == 0) {
            hr(true);
        }
        if (this.eap || this.eao) {
            this.eap = false;
            this.eao = false;
            ee(false);
        }
        boolean isLogin = isLogin();
        if (this.ean != isLogin) {
            this.ean = isLogin;
            onUserChanged(this.ean);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eal.getPageContext());
        }
    }

    private void initData() {
        this.dXp = new ImMessageCenterModel();
        hl(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.eal.registerListener(this.cIk);
    }

    private void au(View view) {
        this.cDX = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.dXv = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.dXv.setVisibility(8);
        this.dXv.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.hl(false);
                e.this.hj(false);
            }
        });
        this.cxI = (NavigationBar) this.cDX.findViewById(d.g.view_navigation_bar);
        this.ear = (TextView) this.cxI.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.eal.getResources().getDimension(d.e.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.ear.setLayoutParams(layoutParams);
        this.ear.setText(d.j.my_message);
        this.cxI.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.cxI.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.aQ(e.this.mContext.getPageActivity());
                }
            });
            this.cxI.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aR(e.this.mContext.getPageActivity());
                }
            });
        }
        this.amO = new TextView(this.eal.getPageContext().getPageActivity());
        this.amO.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eal.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.amO, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.blu = (NoNetworkView) this.cDX.findViewById(d.g.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.blu.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.blu.setLayoutParams(layoutParams2);
        this.blu.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                e.this.hq(z);
            }
        });
        this.dXs = (BdListView) view.findViewById(d.g.chat_list_content);
        this.dXs.addHeaderView(this.amO);
        this.dXs.setDividerHeight(0);
        this.eam = new MessageAggregationListAdapter(this.eal.getPageContext().getPageActivity());
        this.eam.a(this);
        this.dXs.setAdapter((ListAdapter) this.eam);
        this.dXs.setOnItemClickListener(this.dXA);
        this.dXs.setOnItemLongClickListener(this.dXB);
        this.chh = new View(this.eal.getFragmentActivity());
        this.chh.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.eal.getFragmentActivity(), d.e.ds150)));
        this.dXs.addFooterView(this.chh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eal.getPageContext(), i);
        }
        this.blu.onChangeSkinType(getPageContext(), i);
        this.cxI.onChangeSkinType(tbPageContext, i);
        if (this.dXv != null) {
            this.dXv.onChangeSkinType(i);
        }
        aj.a(this.ear, d.C0096d.cp_cont_b, d.C0096d.s_navbar_title_color, i);
        if (this.eam != null) {
            this.eam.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.cDX);
            return true;
        }
        return true;
    }

    private void ht(boolean z) {
        if (z) {
            aDP();
        } else {
            aDQ();
        }
    }

    private void aDP() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eal.getResources().getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) e.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.eal.getPageContext().getPageActivity(), this.cDX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eal.getResources().getDimension(d.e.ds320)), NoDataViewFactory.d.dq(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aDQ() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.eal.getResources().getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.eal.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aR(e.this.eal.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.eal.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.eal.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.eal.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.eal.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eal.getPageContext().getPageActivity(), this.cDX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.eal.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        D(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dXx = new b.InterfaceC0061b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        e.this.dXp.deleteItem(imMessageCenterShowItemData, e.this.dGt);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.eal.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.dXw = new com.baidu.tbadk.core.dialog.b(this.eal.getPageContext().getPageActivity());
        this.dXw.cg(d.j.operation);
        this.dXw.a(new String[]{string}, this.dXx);
        this.dXw.d(this.eal.getPageContext());
    }

    protected boolean ee(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dXs.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void hj(boolean z) {
        if (z) {
            if (aDR() && this.dXv.getVisibility() != 0) {
                this.dXv.setVisibility(0);
            }
        } else if (this.dXv.getVisibility() != 8) {
            this.dXv.setVisibility(8);
        }
    }

    public void D(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.dXs.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.cDX.removeView(this.mNoDataView);
        }
        ht(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.dXs.setVisibility(8);
    }

    public boolean aDR() {
        return this.dXz;
    }

    public void hl(boolean z) {
        this.dXz = z;
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
                if (this.dXp != null) {
                    this.dXp.insertOrUpdate(data, this.dGt);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dXp != null) {
                this.dXp.remove(data, this.dGt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dXp != null) {
                this.dXp.setData(data, this.dGt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eaq = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eaq != -1) {
                hr(true);
                onPrimary();
            }
        }
    }

    public void hq(boolean z) {
        BdListViewHelper.a(this.amO, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        if (z && this.dXs != null && this.dXs.getWrappedAdapter() != null && this.dXs.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
                @Override // java.lang.Runnable
                public void run() {
                    e.this.dXs.startPullRefresh();
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
        this.eam.nV(i);
        this.eam.nW(i2);
        this.eam.notifyDataSetChanged();
    }

    public void hu(boolean z) {
        this.cxI.setVisibility(z ? 0 : 8);
    }
}
