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
    private View amw;
    private View bYj;
    private final CustomMessageListener bbf;
    private NoNetworkView bgD;
    private NavigationBar cou;
    private RelativeLayout cur;
    private final CustomMessageListener cyD;
    private boolean dOA;
    private final AdapterView.OnItemClickListener dOB;
    private final AdapterView.OnItemLongClickListener dOC;
    private ImMessageCenterModel dOq;
    private ImMessageCenterShowItemData dOs;
    private BdListView dOt;
    private ShutDownValidateTipView dOw;
    com.baidu.tbadk.core.dialog.b dOx;
    private b.InterfaceC0047b dOy;
    private int dOz;
    private final g dRn;
    private MessageAggregationListAdapter dRo;
    private boolean dRp;
    private boolean dRq;
    private boolean dRr;
    private int dRs;
    private TextView dRt;
    private CustomMessageListener dRu;
    private final CustomMessageListener dxf;
    private com.baidu.tieba.im.chat.a.a dxh;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.Y(gVar.getPageContext().getPageActivity()));
        this.dOq = null;
        this.dOs = null;
        this.dOt = null;
        this.dRo = null;
        this.dOx = null;
        this.dOA = true;
        this.dRp = false;
        this.dRq = false;
        this.dRr = true;
        this.dRs = 16;
        this.bbf = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && e.this.dRo != null) {
                    e.this.dRo.notifyDataSetChanged();
                }
            }
        };
        this.dRu = new CustomMessageListener(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS) { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && e.this.mNoDataView != null && e.this.mNoDataView.getVisibility() == 0) {
                    e.this.D(e.this.isLogin(), true);
                }
            }
        };
        this.dOB = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData item = e.this.dRo.getItem(i);
                    if (item != null) {
                        TiebaStatic.eventStat(e.this.dRn.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                        String ownerName = item.getOwnerName();
                        if (TextUtils.isEmpty(ownerName)) {
                            e(item);
                            return;
                        } else if (ownerName.equals("1")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dRn.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                                TiebaStatic.eventStat(e.this.dRn.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.dRn.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("2")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dRn.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yC().yX() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yC().yX().ec(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.dRn.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dRn.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yC().yX() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yC().yX().eb(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.dRn.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("6")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dRn.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yC().yX() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yC().yX().el(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(e.this.dRn.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("5")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dRn.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.dRn.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("8")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dRn.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.dRn.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, item.getUserType())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.dRn.getPageContext().getPageActivity())));
                            return;
                        } else {
                            e(item);
                            return;
                        }
                    }
                    if (i == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(e.this.dRn.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yC().yR();
                        e.this.dRo.nz(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yC().setMsgReplyme(0);
                        TiebaStatic.eventStat(e.this.dRn.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(e.this.dRn.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yC().yS();
                        com.baidu.tbadk.coreExtra.messageCenter.a.yC().setMsgAtme(0);
                        e.this.dRo.nA(0);
                        TiebaStatic.eventStat(e.this.dRn.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    }
                    e.this.dRo.notifyDataSetChanged();
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.axs().mv("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                                com.baidu.tieba.im.db.d.axs().mv("group_intro_change");
                                com.baidu.tieba.im.db.d.axs().mv("group_name_change");
                                com.baidu.tieba.im.db.d.axs().mv("group_notice_change");
                                com.baidu.tieba.im.db.d.axs().mv("group_level_up");
                                com.baidu.tieba.im.db.d.axs().mv("dismiss_group");
                                com.baidu.tieba.im.db.d.axs().mv("kick_out");
                                com.baidu.tieba.im.db.d.axs().mv("group_activitys_change");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                                com.baidu.tieba.im.db.d.axs().mv("live_notify");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.yC().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.yC().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.dRn.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.dOC = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    return false;
                }
                e.this.dOs = e.this.dRo.getItem(i);
                e.this.c(e.this.dOs);
                if (e.this.dOx != null) {
                    e.this.dOx.tl();
                    return true;
                }
                return true;
            }
        };
        this.dxf = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
                        e.this.dOq.setData(null, e.this.dxh);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.dRo != null) {
                            e.this.dRo.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.dRo != null) {
                        e.this.dRo.notifyDataSetChanged();
                    }
                }
            }
        };
        this.dxh = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // com.baidu.tieba.im.chat.a.a
            public void avy() {
                if (e.this.dOt != null && e.this.dOq != null) {
                    e.this.dOt.completePullRefreshPostDelayed(2000L);
                    if (e.this.dOq.getData() != null) {
                        e.this.dRo.setData(e.this.dOq.getData());
                    } else {
                        e.this.D(e.this.isLogin(), true);
                    }
                }
            }
        };
        this.cyD = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.h(customResponsedMessage);
                }
            }
        };
        this.dRn = gVar;
    }

    public void k(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dRs = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dRs = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dRs);
        }
    }

    public void alE() {
        if (this.dRo != null) {
            this.dRo.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dxf);
    }

    public View Pa() {
        this.dOz = 3;
        this.rootView = LayoutInflater.from(this.dRn.getPageContext().getPageActivity()).inflate(d.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        aq(this.rootView);
        TiebaStatic.eventStat(this.dRn.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        abo();
        return this.rootView;
    }

    protected void abo() {
        this.dOt.startPullRefresh();
        this.dRp = isLogin();
        if (!this.dRp) {
            D(this.dRp, true);
        }
    }

    private void registerListener() {
        this.dRn.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dxf);
        this.dRn.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dxf);
        this.dRn.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dxf);
        this.dRn.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dxf);
        this.dRn.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dxf);
        this.dRn.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dxf);
        this.dRn.registerListener(this.bbf);
        this.dRn.registerListener(this.dRu);
    }

    public void gQ(boolean z) {
        this.dRq = z;
    }

    public void gR(boolean z) {
        this.dRr = z;
    }

    public void onPrimary() {
        if (this.dRo != null && this.dRo.getCount() == 0) {
            gQ(true);
        }
        if (this.dRr || this.dRq) {
            this.dRr = false;
            this.dRq = false;
            dJ(false);
        }
        boolean isLogin = isLogin();
        if (this.dRp != isLogin) {
            this.dRp = isLogin;
            onUserChanged(this.dRp);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dRn.getPageContext());
        }
    }

    private void initData() {
        this.dOq = new ImMessageCenterModel();
        gK(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dRn.registerListener(this.cyD);
    }

    private void aq(View view) {
        this.cur = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.dOw = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.dOw.setVisibility(8);
        this.dOw.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.gK(false);
                e.this.gI(false);
            }
        });
        this.cou = (NavigationBar) this.cur.findViewById(d.g.view_navigation_bar);
        this.dRt = (TextView) this.cou.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dRn.getResources().getDimension(d.e.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dRt.setLayoutParams(layoutParams);
        this.dRt.setText(d.j.my_message);
        this.cou.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.cou.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.aR(e.this.mContext.getPageActivity());
                }
            });
            this.cou.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aS(e.this.mContext.getPageActivity());
                }
            });
        }
        this.amw = new TextView(this.dRn.getPageContext().getPageActivity());
        this.amw.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dRn.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.amw, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.bgD = (NoNetworkView) this.cur.findViewById(d.g.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bgD.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.bgD.setLayoutParams(layoutParams2);
        this.bgD.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                e.this.gP(z);
            }
        });
        this.dOt = (BdListView) view.findViewById(d.g.chat_list_content);
        this.dOt.addHeaderView(this.amw);
        this.dOt.setDividerHeight(0);
        this.dRo = new MessageAggregationListAdapter(this.dRn.getPageContext().getPageActivity());
        this.dRo.a(this);
        this.dOt.setAdapter((ListAdapter) this.dRo);
        this.dOt.setOnItemClickListener(this.dOB);
        this.dOt.setOnItemLongClickListener(this.dOC);
        this.bYj = new View(this.dRn.getFragmentActivity());
        this.bYj.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.dRn.getFragmentActivity(), d.e.ds150)));
        this.dOt.addFooterView(this.bYj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dRn.getPageContext(), i);
        }
        this.bgD.onChangeSkinType(getPageContext(), i);
        this.cou.onChangeSkinType(tbPageContext, i);
        if (this.dOw != null) {
            this.dOw.onChangeSkinType(i);
        }
        aj.a(this.dRt, d.C0080d.cp_cont_b, d.C0080d.s_navbar_title_color, i);
        if (this.dRo != null) {
            this.dRo.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.cur);
            return true;
        }
        return true;
    }

    private void gS(boolean z) {
        if (z) {
            aCd();
        } else {
            aCe();
        }
    }

    private void aCd() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dRn.getResources().getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) e.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dRn.getPageContext().getPageActivity(), this.cur, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dRn.getResources().getDimension(d.e.ds320)), NoDataViewFactory.d.dq(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aCe() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dRn.getResources().getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.dRn.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aS(e.this.dRn.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.dRn.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.dRn.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.dRn.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.dRn.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dRn.getPageContext().getPageActivity(), this.cur, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dRn.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        D(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dOy = new b.InterfaceC0047b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        e.this.dOq.deleteItem(imMessageCenterShowItemData, e.this.dxh);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dRn.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.dOx = new com.baidu.tbadk.core.dialog.b(this.dRn.getPageContext().getPageActivity());
        this.dOx.cf(d.j.operation);
        this.dOx.a(new String[]{string}, this.dOy);
        this.dOx.d(this.dRn.getPageContext());
    }

    protected boolean dJ(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dOt.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void gI(boolean z) {
        if (z) {
            if (aCf() && this.dOw.getVisibility() != 0) {
                this.dOw.setVisibility(0);
            }
        } else if (this.dOw.getVisibility() != 8) {
            this.dOw.setVisibility(8);
        }
    }

    public void D(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.dOt.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.cur.removeView(this.mNoDataView);
        }
        gS(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.dOt.setVisibility(8);
    }

    public boolean aCf() {
        return this.dOA;
    }

    public void gK(boolean z) {
        this.dOA = z;
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
                if (this.dOq != null) {
                    this.dOq.insertOrUpdate(data, this.dxh);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dOq != null) {
                this.dOq.remove(data, this.dxh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dOq != null) {
                this.dOq.setData(data, this.dxh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dRs = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dRs != -1) {
                gQ(true);
                onPrimary();
            }
        }
    }

    public void gP(boolean z) {
        BdListViewHelper.a(this.amw, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        if (z && this.dOt != null && this.dOt.getWrappedAdapter() != null && this.dOt.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
                @Override // java.lang.Runnable
                public void run() {
                    e.this.dOt.startPullRefresh();
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
            bo(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void bo(int i, int i2) {
        this.dRo.nz(i);
        this.dRo.nA(i2);
        this.dRo.notifyDataSetChanged();
    }

    public void gT(boolean z) {
        this.cou.setVisibility(z ? 0 : 8);
    }
}
