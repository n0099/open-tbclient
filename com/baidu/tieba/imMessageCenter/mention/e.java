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
    private final CustomMessageListener aZd;
    private View ane;
    private View bQs;
    private NoNetworkView bep;
    private NavigationBar chc;
    private RelativeLayout clR;
    private final CustomMessageListener cqf;
    private ImMessageCenterModel dJG;
    private ImMessageCenterShowItemData dJI;
    private BdListView dJJ;
    private ShutDownValidateTipView dJM;
    com.baidu.tbadk.core.dialog.b dJN;
    private b.InterfaceC0047b dJO;
    private int dJP;
    private boolean dJQ;
    private final AdapterView.OnItemClickListener dJR;
    private final AdapterView.OnItemLongClickListener dJS;
    private final g dMC;
    private MessageAggregationListAdapter dMD;
    private boolean dME;
    private boolean dMF;
    private boolean dMG;
    private int dMH;
    private TextView dMI;
    private CustomMessageListener dMJ;
    private final CustomMessageListener dss;
    private com.baidu.tieba.im.chat.a.a dsu;
    private com.baidu.tbadk.core.view.j mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.X(gVar.getPageContext().getPageActivity()));
        this.dJG = null;
        this.dJI = null;
        this.dJJ = null;
        this.dMD = null;
        this.dJN = null;
        this.dJQ = true;
        this.dME = false;
        this.dMF = false;
        this.dMG = true;
        this.dMH = 16;
        this.aZd = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && e.this.dMD != null) {
                    e.this.dMD.notifyDataSetChanged();
                }
            }
        };
        this.dMJ = new CustomMessageListener(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS) { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && e.this.mNoDataView != null && e.this.mNoDataView.getVisibility() == 0) {
                    e.this.B(e.this.isLogin(), true);
                }
            }
        };
        this.dJR = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData item = e.this.dMD.getItem(i);
                    if (item != null) {
                        TiebaStatic.eventStat(e.this.dMC.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                        String ownerName = item.getOwnerName();
                        if (TextUtils.isEmpty(ownerName)) {
                            e(item);
                            return;
                        } else if (ownerName.equals("1")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dMC.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                                TiebaStatic.eventStat(e.this.dMC.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.dMC.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("2")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dMC.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy().dS(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.dMC.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dMC.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy().dR(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.dMC.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("6")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dMC.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy().eb(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(e.this.dMC.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("5")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dMC.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.dMC.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("8")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dMC.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.dMC.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, item.getUserType())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.dMC.getPageContext().getPageActivity())));
                            return;
                        } else {
                            e(item);
                            return;
                        }
                    }
                    if (i == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(e.this.dMC.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.zd().zs();
                        e.this.dMD.nl(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.zd().setMsgReplyme(0);
                        TiebaStatic.eventStat(e.this.dMC.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(e.this.dMC.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.zd().zt();
                        com.baidu.tbadk.coreExtra.messageCenter.a.zd().setMsgAtme(0);
                        e.this.dMD.nm(0);
                        TiebaStatic.eventStat(e.this.dMC.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    }
                    e.this.dMD.notifyDataSetChanged();
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.awg().mu("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                                com.baidu.tieba.im.db.d.awg().mu("group_intro_change");
                                com.baidu.tieba.im.db.d.awg().mu("group_name_change");
                                com.baidu.tieba.im.db.d.awg().mu("group_notice_change");
                                com.baidu.tieba.im.db.d.awg().mu("group_level_up");
                                com.baidu.tieba.im.db.d.awg().mu("dismiss_group");
                                com.baidu.tieba.im.db.d.awg().mu("kick_out");
                                com.baidu.tieba.im.db.d.awg().mu("group_activitys_change");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                                com.baidu.tieba.im.db.d.awg().mu("live_notify");
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.dMC.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.dJS = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    return false;
                }
                e.this.dJI = e.this.dMD.getItem(i);
                e.this.c(e.this.dJI);
                if (e.this.dJN != null) {
                    e.this.dJN.tr();
                    return true;
                }
                return true;
            }
        };
        this.dss = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
                        e.this.dJG.setData(null, e.this.dsu);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.dMD != null) {
                            e.this.dMD.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.dMD != null) {
                        e.this.dMD.notifyDataSetChanged();
                    }
                }
            }
        };
        this.dsu = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // com.baidu.tieba.im.chat.a.a
            public void aum() {
                if (e.this.dJJ != null && e.this.dJG != null) {
                    e.this.dJJ.completePullRefreshPostDelayed(2000L);
                    if (e.this.dJG.getData() != null) {
                        e.this.dMD.setData(e.this.dJG.getData());
                    } else {
                        e.this.B(e.this.isLogin(), true);
                    }
                }
            }
        };
        this.cqf = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.h(customResponsedMessage);
                }
            }
        };
        this.dMC = gVar;
    }

    public void l(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dMH = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dMH = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dMH);
        }
    }

    public void ajg() {
        if (this.dMD != null) {
            this.dMD.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dss);
    }

    public View Zm() {
        this.dJP = 3;
        this.rootView = LayoutInflater.from(this.dMC.getPageContext().getPageActivity()).inflate(d.j.chat_list_activity, (ViewGroup) null, false);
        initData();
        ao(this.rootView);
        TiebaStatic.eventStat(this.dMC.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        Zn();
        return this.rootView;
    }

    protected void Zn() {
        this.dJJ.startPullRefresh();
        this.dME = isLogin();
        if (!this.dME) {
            B(this.dME, true);
        }
    }

    private void registerListener() {
        this.dMC.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dss);
        this.dMC.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dss);
        this.dMC.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dss);
        this.dMC.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dss);
        this.dMC.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dss);
        this.dMC.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dss);
        this.dMC.registerListener(this.aZd);
        this.dMC.registerListener(this.dMJ);
    }

    public void hh(boolean z) {
        this.dMF = z;
    }

    public void hi(boolean z) {
        this.dMG = z;
    }

    public void onPrimary() {
        if (this.dMD != null && this.dMD.getCount() == 0) {
            hh(true);
        }
        if (this.dMG || this.dMF) {
            this.dMG = false;
            this.dMF = false;
            dR(false);
        }
        boolean isLogin = isLogin();
        if (this.dME != isLogin) {
            this.dME = isLogin;
            onUserChanged(this.dME);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dMC.getPageContext());
        }
    }

    private void initData() {
        this.dJG = new ImMessageCenterModel();
        hb(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dMC.registerListener(this.cqf);
    }

    private void ao(View view) {
        this.clR = (RelativeLayout) view.findViewById(d.h.chat_list);
        this.dJM = (ShutDownValidateTipView) view.findViewById(d.h.view_no_validate);
        this.dJM.setVisibility(8);
        this.dJM.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.hb(false);
                e.this.gZ(false);
            }
        });
        this.chc = (NavigationBar) this.clR.findViewById(d.h.view_navigation_bar);
        this.dMI = (TextView) this.chc.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.maintab_title_layout, (View.OnClickListener) null).findViewById(d.h.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dMC.getResources().getDimension(d.f.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dMI.setLayoutParams(layoutParams);
        this.dMI.setText(d.l.my_message);
        this.chc.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.chc.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.aR(e.this.mContext.getPageActivity());
                }
            });
            this.chc.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aS(e.this.mContext.getPageActivity());
                }
            });
        }
        this.ane = new TextView(this.dMC.getPageContext().getPageActivity());
        this.ane.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dMC.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.ane, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hi());
        this.bep = (NoNetworkView) this.clR.findViewById(d.h.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bep.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.bep.setLayoutParams(layoutParams2);
        this.bep.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                e.this.hg(z);
            }
        });
        this.dJJ = (BdListView) view.findViewById(d.h.chat_list_content);
        this.dJJ.addHeaderView(this.ane);
        this.dJJ.setDividerHeight(0);
        this.dMD = new MessageAggregationListAdapter(this.dMC.getPageContext().getPageActivity());
        this.dMD.a(this);
        this.dJJ.setAdapter((ListAdapter) this.dMD);
        this.dJJ.setOnItemClickListener(this.dJR);
        this.dJJ.setOnItemLongClickListener(this.dJS);
        this.bQs = new View(this.dMC.getFragmentActivity());
        this.bQs.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.dMC.getFragmentActivity(), d.f.ds150)));
        this.dJJ.addFooterView(this.bQs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dMC.getPageContext(), i);
        }
        this.bep.onChangeSkinType(getPageContext(), i);
        this.chc.onChangeSkinType(tbPageContext, i);
        if (this.dJM != null) {
            this.dJM.onChangeSkinType(i);
        }
        aj.a(this.dMI, d.e.cp_cont_b, d.e.s_navbar_title_color, i);
        if (this.dMD != null) {
            this.dMD.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.clR);
            return true;
        }
        return true;
    }

    private void hj(boolean z) {
        if (z) {
            aAR();
        } else {
            aAS();
        }
    }

    private void aAR() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dMC.getResources().getString(d.l.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) e.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dMC.getPageContext().getPageActivity(), this.clR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dMC.getResources().getDimension(d.f.ds320)), NoDataViewFactory.d.dl(d.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aAS() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dMC.getResources().getString(d.l.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.dMC.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aS(e.this.dMC.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.dMC.getResources().getDimensionPixelSize(d.f.ds320);
        int dimensionPixelSize2 = this.dMC.getResources().getDimensionPixelSize(d.f.ds480);
        int dimensionPixelSize3 = this.dMC.getResources().getDimensionPixelSize(d.f.ds360);
        int dimensionPixelSize4 = this.dMC.getResources().getDimensionPixelSize(d.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dMC.getPageContext().getPageActivity(), this.clR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.A(d.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dMC.getResources().getDimensionPixelSize(d.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        B(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dJO = new b.InterfaceC0047b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        e.this.dJG.deleteItem(imMessageCenterShowItemData, e.this.dsu);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dMC.getPageContext().getPageActivity().getString(d.l.delete_user_chat);
        this.dJN = new com.baidu.tbadk.core.dialog.b(this.dMC.getPageContext().getPageActivity());
        this.dJN.cf(d.l.operation);
        this.dJN.a(new String[]{string}, this.dJO);
        this.dJN.d(this.dMC.getPageContext());
    }

    protected boolean dR(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dJJ.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void gZ(boolean z) {
        if (z) {
            if (aAT() && this.dJM.getVisibility() != 0) {
                this.dJM.setVisibility(0);
            }
        } else if (this.dJM.getVisibility() != 8) {
            this.dJM.setVisibility(8);
        }
    }

    public void B(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.dJJ.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.clR.removeView(this.mNoDataView);
        }
        hj(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.dJJ.setVisibility(8);
    }

    public boolean aAT() {
        return this.dJQ;
    }

    public void hb(boolean z) {
        this.dJQ = z;
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
                if (this.dJG != null) {
                    this.dJG.insertOrUpdate(data, this.dsu);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dJG != null) {
                this.dJG.remove(data, this.dsu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dJG != null) {
                this.dJG.setData(data, this.dsu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dMH = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dMH != -1) {
                hh(true);
                onPrimary();
            }
        }
    }

    public void hg(boolean z) {
        BdListViewHelper.a(this.ane, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hi());
        if (z && this.dJJ != null && this.dJJ.getWrappedAdapter() != null && this.dJJ.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
                @Override // java.lang.Runnable
                public void run() {
                    e.this.dJJ.startPullRefresh();
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
            bd(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void bd(int i, int i2) {
        this.dMD.nl(i);
        this.dMD.nm(i2);
        this.dMD.notifyDataSetChanged();
    }

    public void hk(boolean z) {
        this.chc.setVisibility(z ? 0 : 8);
    }
}
