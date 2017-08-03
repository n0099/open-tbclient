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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aw;
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
    private final CustomMessageListener aYe;
    private View amq;
    private View bLF;
    private NoNetworkView bdg;
    private NavigationBar cbG;
    private RelativeLayout ceH;
    private final CustomMessageListener ciS;
    private final AdapterView.OnItemLongClickListener dAa;
    private final g dCK;
    private MessageAggregationListAdapter dCL;
    private boolean dCM;
    private boolean dCN;
    private boolean dCO;
    private int dCP;
    private TextView dCQ;
    private CustomMessageListener dCR;
    private com.baidu.tieba.im.chat.a.a diB;
    private final CustomMessageListener diz;
    private ImMessageCenterModel dzO;
    private ImMessageCenterShowItemData dzQ;
    private BdListView dzR;
    private ShutDownValidateTipView dzU;
    com.baidu.tbadk.core.dialog.b dzV;
    private b.InterfaceC0043b dzW;
    private int dzX;
    private boolean dzY;
    private final AdapterView.OnItemClickListener dzZ;
    private com.baidu.tbadk.core.view.j mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.Z(gVar.getPageContext().getPageActivity()));
        this.dzO = null;
        this.dzQ = null;
        this.dzR = null;
        this.dCL = null;
        this.dzV = null;
        this.dzY = true;
        this.dCM = false;
        this.dCN = false;
        this.dCO = true;
        this.dCP = 16;
        this.aYe = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && e.this.dCL != null) {
                    e.this.dCL.notifyDataSetChanged();
                }
            }
        };
        this.dCR = new CustomMessageListener(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS) { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && e.this.mNoDataView != null && e.this.mNoDataView.getVisibility() == 0) {
                    e.this.z(e.this.isLogin(), true);
                }
            }
        };
        this.dzZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData item = e.this.dCL.getItem(i);
                    if (item != null) {
                        TiebaStatic.eventStat(e.this.dCK.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                        String ownerName = item.getOwnerName();
                        if (TextUtils.isEmpty(ownerName)) {
                            e(item);
                            return;
                        } else if (ownerName.equals("1")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dCK.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                                TiebaStatic.eventStat(e.this.dCK.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.dCK.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("2")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dCK.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yR().zm() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yR().zm().dP(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.dCK.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dCK.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yR().zm() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yR().zm().dO(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.dCK.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("6")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dCK.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yR().zm() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yR().zm().dY(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(e.this.dCK.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("5")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dCK.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.dCK.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("8")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dCK.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.dCK.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, item.getUserType())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.dCK.getPageContext().getPageActivity())));
                            return;
                        } else {
                            e(item);
                            return;
                        }
                    }
                    if (i == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(e.this.dCK.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yR().zg();
                        e.this.dCL.mI(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yR().setMsgReplyme(0);
                        TiebaStatic.eventStat(e.this.dCK.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(e.this.dCK.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yR().zh();
                        com.baidu.tbadk.coreExtra.messageCenter.a.yR().setMsgAtme(0);
                        e.this.dCL.mJ(0);
                        TiebaStatic.eventStat(e.this.dCK.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    }
                    e.this.dCL.notifyDataSetChanged();
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.atG().lQ("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                                com.baidu.tieba.im.db.d.atG().lQ("group_intro_change");
                                com.baidu.tieba.im.db.d.atG().lQ("group_name_change");
                                com.baidu.tieba.im.db.d.atG().lQ("group_notice_change");
                                com.baidu.tieba.im.db.d.atG().lQ("group_level_up");
                                com.baidu.tieba.im.db.d.atG().lQ("dismiss_group");
                                com.baidu.tieba.im.db.d.atG().lQ("kick_out");
                                com.baidu.tieba.im.db.d.atG().lQ("group_activitys_change");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                                com.baidu.tieba.im.db.d.atG().lQ("live_notify");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.yR().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.yR().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.dCK.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.dAa = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    return false;
                }
                e.this.dzQ = e.this.dCL.getItem(i);
                e.this.c(e.this.dzQ);
                if (e.this.dzV != null) {
                    e.this.dzV.tk();
                    return true;
                }
                return true;
            }
        };
        this.diz = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
                        e.this.dzO.setData(null, e.this.diB);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.dCL != null) {
                            e.this.dCL.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.dCL != null) {
                        e.this.dCL.notifyDataSetChanged();
                    }
                }
            }
        };
        this.diB = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                if (e.this.dzR != null && e.this.dzO != null) {
                    e.this.dzR.completePullRefreshPostDelayed(2000L);
                    if (e.this.dzO.getData() != null) {
                        e.this.dCL.setData(e.this.dzO.getData());
                    } else {
                        e.this.z(e.this.isLogin(), true);
                    }
                }
            }
        };
        this.ciS = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.h(customResponsedMessage);
                }
            }
        };
        this.dCK = gVar;
    }

    public void j(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dCP = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dCP = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dCP);
        }
    }

    public void agX() {
        if (this.dCL != null) {
            this.dCL.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.diz);
    }

    public View XM() {
        this.dzX = 3;
        this.rootView = LayoutInflater.from(this.dCK.getPageContext().getPageActivity()).inflate(d.j.chat_list_activity, (ViewGroup) null, false);
        initData();
        ah(this.rootView);
        TiebaStatic.eventStat(this.dCK.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        XN();
        return this.rootView;
    }

    protected void XN() {
        this.dzR.startPullRefresh();
        this.dCM = isLogin();
        if (!this.dCM) {
            z(this.dCM, true);
        }
    }

    private void registerListener() {
        this.dCK.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.diz);
        this.dCK.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.diz);
        this.dCK.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.diz);
        this.dCK.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.diz);
        this.dCK.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.diz);
        this.dCK.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.diz);
        this.dCK.registerListener(this.aYe);
        this.dCK.registerListener(this.dCR);
    }

    public void gW(boolean z) {
        this.dCN = z;
    }

    public void gX(boolean z) {
        this.dCO = z;
    }

    public void onPrimary() {
        if (this.dCL != null && this.dCL.getCount() == 0) {
            gW(true);
        }
        if (this.dCO || this.dCN) {
            this.dCO = false;
            this.dCN = false;
            dN(false);
        }
        boolean isLogin = isLogin();
        if (this.dCM != isLogin) {
            this.dCM = isLogin;
            onUserChanged(this.dCM);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dCK.getPageContext());
        }
    }

    private void initData() {
        this.dzO = new ImMessageCenterModel();
        gQ(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dCK.registerListener(this.ciS);
    }

    private void ah(View view) {
        this.ceH = (RelativeLayout) view.findViewById(d.h.chat_list);
        this.dzU = (ShutDownValidateTipView) view.findViewById(d.h.view_no_validate);
        this.dzU.setVisibility(8);
        this.dzU.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.gQ(false);
                e.this.gO(false);
            }
        });
        this.cbG = (NavigationBar) this.ceH.findViewById(d.h.view_navigation_bar);
        this.dCQ = (TextView) this.cbG.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.maintab_title_layout, (View.OnClickListener) null).findViewById(d.h.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dCK.getResources().getDimension(d.f.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dCQ.setLayoutParams(layoutParams);
        this.dCQ.setText(d.l.my_message);
        this.cbG.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.cbG.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    aw.aL(e.this.mContext.getPageActivity());
                }
            });
            this.cbG.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    aw.aM(e.this.mContext.getPageActivity());
                }
            });
        }
        this.amq = new TextView(this.dCK.getPageContext().getPageActivity());
        this.amq.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dCK.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.amq, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hh());
        this.bdg = (NoNetworkView) this.ceH.findViewById(d.h.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bdg.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.bdg.setLayoutParams(layoutParams2);
        this.bdg.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                e.this.gV(z);
            }
        });
        this.dzR = (BdListView) view.findViewById(d.h.chat_list_content);
        this.dzR.addHeaderView(this.amq);
        this.dzR.setDividerHeight(0);
        this.dCL = new MessageAggregationListAdapter(this.dCK.getPageContext().getPageActivity());
        this.dCL.a(this);
        this.dzR.setAdapter((ListAdapter) this.dCL);
        this.dzR.setOnItemClickListener(this.dzZ);
        this.dzR.setOnItemLongClickListener(this.dAa);
        this.bLF = new View(this.dCK.getFragmentActivity());
        this.bLF.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.dCK.getFragmentActivity(), d.f.ds150)));
        this.dzR.addFooterView(this.bLF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dCK.getPageContext(), i);
        }
        this.bdg.onChangeSkinType(getPageContext(), i);
        this.cbG.onChangeSkinType(tbPageContext, i);
        if (this.dzU != null) {
            this.dzU.onChangeSkinType(i);
        }
        ai.a(this.dCQ, d.e.cp_cont_b, d.e.s_navbar_title_color, i);
        if (this.dCL != null) {
            this.dCL.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.ceH);
            return true;
        }
        return true;
    }

    private void gY(boolean z) {
        if (z) {
            ayp();
        } else {
            ayq();
        }
    }

    private void ayp() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dCK.getResources().getString(d.l.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) e.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dCK.getPageContext().getPageActivity(), this.ceH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dCK.getResources().getDimension(d.f.ds320)), NoDataViewFactory.d.di(d.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void ayq() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dCK.getResources().getString(d.l.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.dCK.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                aw.aM(e.this.dCK.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.dCK.getResources().getDimensionPixelSize(d.f.ds320);
        int dimensionPixelSize2 = this.dCK.getResources().getDimensionPixelSize(d.f.ds480);
        int dimensionPixelSize3 = this.dCK.getResources().getDimensionPixelSize(d.f.ds360);
        int dimensionPixelSize4 = this.dCK.getResources().getDimensionPixelSize(d.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dCK.getPageContext().getPageActivity(), this.ceH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.A(d.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dCK.getResources().getDimensionPixelSize(d.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        z(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dzW = new b.InterfaceC0043b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        e.this.dzO.deleteItem(imMessageCenterShowItemData, e.this.diB);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dCK.getPageContext().getPageActivity().getString(d.l.delete_user_chat);
        this.dzV = new com.baidu.tbadk.core.dialog.b(this.dCK.getPageContext().getPageActivity());
        this.dzV.cd(d.l.operation);
        this.dzV.a(new String[]{string}, this.dzW);
        this.dzV.d(this.dCK.getPageContext());
    }

    protected boolean dN(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dzR.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void gO(boolean z) {
        if (z) {
            if (ayr() && this.dzU.getVisibility() != 0) {
                this.dzU.setVisibility(0);
            }
        } else if (this.dzU.getVisibility() != 8) {
            this.dzU.setVisibility(8);
        }
    }

    public void z(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.dzR.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.ceH.removeView(this.mNoDataView);
        }
        gY(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.dzR.setVisibility(8);
    }

    public boolean ayr() {
        return this.dzY;
    }

    public void gQ(boolean z) {
        this.dzY = z;
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
                if (this.dzO != null) {
                    this.dzO.insertOrUpdate(data, this.diB);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dzO != null) {
                this.dzO.remove(data, this.diB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dzO != null) {
                this.dzO.setData(data, this.diB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dCP = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dCP != -1) {
                gW(true);
                onPrimary();
            }
        }
    }

    public void gV(boolean z) {
        BdListViewHelper.a(this.amq, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hh());
        if (z && this.dzR != null && this.dzR.getWrappedAdapter() != null && this.dzR.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
                @Override // java.lang.Runnable
                public void run() {
                    e.this.dzR.startPullRefresh();
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
            aV(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void aV(int i, int i2) {
        this.dCL.mI(i);
        this.dCL.mJ(i2);
        this.dCL.notifyDataSetChanged();
    }

    public void gZ(boolean z) {
        this.cbG.setVisibility(z ? 0 : 8);
    }
}
