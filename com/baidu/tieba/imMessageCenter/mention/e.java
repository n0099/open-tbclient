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
    private View amv;
    private View bYw;
    private final CustomMessageListener bbo;
    private NoNetworkView bgM;
    private NavigationBar coN;
    private RelativeLayout cuK;
    private final CustomMessageListener cyW;
    private ShutDownValidateTipView dOB;
    com.baidu.tbadk.core.dialog.b dOC;
    private b.InterfaceC0047b dOD;
    private int dOE;
    private boolean dOF;
    private final AdapterView.OnItemClickListener dOG;
    private final AdapterView.OnItemLongClickListener dOH;
    private ImMessageCenterModel dOv;
    private ImMessageCenterShowItemData dOx;
    private BdListView dOy;
    private final g dRs;
    private MessageAggregationListAdapter dRt;
    private boolean dRu;
    private boolean dRv;
    private boolean dRw;
    private int dRx;
    private TextView dRy;
    private CustomMessageListener dRz;
    private com.baidu.tieba.im.chat.a.a dxB;
    private final CustomMessageListener dxz;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.Y(gVar.getPageContext().getPageActivity()));
        this.dOv = null;
        this.dOx = null;
        this.dOy = null;
        this.dRt = null;
        this.dOC = null;
        this.dOF = true;
        this.dRu = false;
        this.dRv = false;
        this.dRw = true;
        this.dRx = 16;
        this.bbo = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && e.this.dRt != null) {
                    e.this.dRt.notifyDataSetChanged();
                }
            }
        };
        this.dRz = new CustomMessageListener(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS) { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && e.this.mNoDataView != null && e.this.mNoDataView.getVisibility() == 0) {
                    e.this.D(e.this.isLogin(), true);
                }
            }
        };
        this.dOG = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData item = e.this.dRt.getItem(i);
                    if (item != null) {
                        TiebaStatic.eventStat(e.this.dRs.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                        String ownerName = item.getOwnerName();
                        if (TextUtils.isEmpty(ownerName)) {
                            e(item);
                            return;
                        } else if (ownerName.equals("1")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dRs.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                                TiebaStatic.eventStat(e.this.dRs.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.dRs.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("2")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dRs.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yK().zf() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yK().zf().eb(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.dRs.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dRs.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yK().zf() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yK().zf().ea(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.dRs.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("6")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dRs.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yK().zf() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yK().zf().ek(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(e.this.dRs.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("5")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dRs.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.dRs.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("8")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dRs.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.dRs.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, item.getUserType())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.dRs.getPageContext().getPageActivity())));
                            return;
                        } else {
                            e(item);
                            return;
                        }
                    }
                    if (i == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(e.this.dRs.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yK().yZ();
                        e.this.dRt.nA(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgReplyme(0);
                        TiebaStatic.eventStat(e.this.dRs.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(e.this.dRs.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yK().za();
                        com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgAtme(0);
                        e.this.dRt.nB(0);
                        TiebaStatic.eventStat(e.this.dRs.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    }
                    e.this.dRt.notifyDataSetChanged();
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.axJ().mx("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                                com.baidu.tieba.im.db.d.axJ().mx("group_intro_change");
                                com.baidu.tieba.im.db.d.axJ().mx("group_name_change");
                                com.baidu.tieba.im.db.d.axJ().mx("group_notice_change");
                                com.baidu.tieba.im.db.d.axJ().mx("group_level_up");
                                com.baidu.tieba.im.db.d.axJ().mx("dismiss_group");
                                com.baidu.tieba.im.db.d.axJ().mx("kick_out");
                                com.baidu.tieba.im.db.d.axJ().mx("group_activitys_change");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                                com.baidu.tieba.im.db.d.axJ().mx("live_notify");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.dRs.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.dOH = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    return false;
                }
                e.this.dOx = e.this.dRt.getItem(i);
                e.this.c(e.this.dOx);
                if (e.this.dOC != null) {
                    e.this.dOC.tl();
                    return true;
                }
                return true;
            }
        };
        this.dxz = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
                        e.this.dOv.setData(null, e.this.dxB);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.dRt != null) {
                            e.this.dRt.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.dRt != null) {
                        e.this.dRt.notifyDataSetChanged();
                    }
                }
            }
        };
        this.dxB = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // com.baidu.tieba.im.chat.a.a
            public void avP() {
                if (e.this.dOy != null && e.this.dOv != null) {
                    e.this.dOy.completePullRefreshPostDelayed(2000L);
                    if (e.this.dOv.getData() != null) {
                        e.this.dRt.setData(e.this.dOv.getData());
                    } else {
                        e.this.D(e.this.isLogin(), true);
                    }
                }
            }
        };
        this.cyW = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.h(customResponsedMessage);
                }
            }
        };
        this.dRs = gVar;
    }

    public void k(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dRx = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dRx = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dRx);
        }
    }

    public void alS() {
        if (this.dRt != null) {
            this.dRt.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dxz);
    }

    public View Pl() {
        this.dOE = 3;
        this.rootView = LayoutInflater.from(this.dRs.getPageContext().getPageActivity()).inflate(d.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        ar(this.rootView);
        TiebaStatic.eventStat(this.dRs.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        abA();
        return this.rootView;
    }

    protected void abA() {
        this.dOy.startPullRefresh();
        this.dRu = isLogin();
        if (!this.dRu) {
            D(this.dRu, true);
        }
    }

    private void registerListener() {
        this.dRs.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dxz);
        this.dRs.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dxz);
        this.dRs.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dxz);
        this.dRs.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dxz);
        this.dRs.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dxz);
        this.dRs.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dxz);
        this.dRs.registerListener(this.bbo);
        this.dRs.registerListener(this.dRz);
    }

    public void gW(boolean z) {
        this.dRv = z;
    }

    public void gX(boolean z) {
        this.dRw = z;
    }

    public void onPrimary() {
        if (this.dRt != null && this.dRt.getCount() == 0) {
            gW(true);
        }
        if (this.dRw || this.dRv) {
            this.dRw = false;
            this.dRv = false;
            dO(false);
        }
        boolean isLogin = isLogin();
        if (this.dRu != isLogin) {
            this.dRu = isLogin;
            onUserChanged(this.dRu);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dRs.getPageContext());
        }
    }

    private void initData() {
        this.dOv = new ImMessageCenterModel();
        gQ(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dRs.registerListener(this.cyW);
    }

    private void ar(View view) {
        this.cuK = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.dOB = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.dOB.setVisibility(8);
        this.dOB.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.gQ(false);
                e.this.gO(false);
            }
        });
        this.coN = (NavigationBar) this.cuK.findViewById(d.g.view_navigation_bar);
        this.dRy = (TextView) this.coN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dRs.getResources().getDimension(d.e.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dRy.setLayoutParams(layoutParams);
        this.dRy.setText(d.j.my_message);
        this.coN.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.coN.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.aR(e.this.mContext.getPageActivity());
                }
            });
            this.coN.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aS(e.this.mContext.getPageActivity());
                }
            });
        }
        this.amv = new TextView(this.dRs.getPageContext().getPageActivity());
        this.amv.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dRs.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.amv, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.bgM = (NoNetworkView) this.cuK.findViewById(d.g.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bgM.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.bgM.setLayoutParams(layoutParams2);
        this.bgM.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                e.this.gV(z);
            }
        });
        this.dOy = (BdListView) view.findViewById(d.g.chat_list_content);
        this.dOy.addHeaderView(this.amv);
        this.dOy.setDividerHeight(0);
        this.dRt = new MessageAggregationListAdapter(this.dRs.getPageContext().getPageActivity());
        this.dRt.a(this);
        this.dOy.setAdapter((ListAdapter) this.dRt);
        this.dOy.setOnItemClickListener(this.dOG);
        this.dOy.setOnItemLongClickListener(this.dOH);
        this.bYw = new View(this.dRs.getFragmentActivity());
        this.bYw.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.dRs.getFragmentActivity(), d.e.ds150)));
        this.dOy.addFooterView(this.bYw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dRs.getPageContext(), i);
        }
        this.bgM.onChangeSkinType(getPageContext(), i);
        this.coN.onChangeSkinType(tbPageContext, i);
        if (this.dOB != null) {
            this.dOB.onChangeSkinType(i);
        }
        aj.a(this.dRy, d.C0080d.cp_cont_b, d.C0080d.s_navbar_title_color, i);
        if (this.dRt != null) {
            this.dRt.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.cuK);
            return true;
        }
        return true;
    }

    private void gY(boolean z) {
        if (z) {
            aCh();
        } else {
            aCi();
        }
    }

    private void aCh() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dRs.getResources().getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) e.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dRs.getPageContext().getPageActivity(), this.cuK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dRs.getResources().getDimension(d.e.ds320)), NoDataViewFactory.d.dp(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aCi() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dRs.getResources().getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.dRs.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aS(e.this.dRs.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.dRs.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.dRs.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.dRs.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.dRs.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dRs.getPageContext().getPageActivity(), this.cuK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dRs.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        D(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dOD = new b.InterfaceC0047b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        e.this.dOv.deleteItem(imMessageCenterShowItemData, e.this.dxB);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dRs.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.dOC = new com.baidu.tbadk.core.dialog.b(this.dRs.getPageContext().getPageActivity());
        this.dOC.cf(d.j.operation);
        this.dOC.a(new String[]{string}, this.dOD);
        this.dOC.d(this.dRs.getPageContext());
    }

    protected boolean dO(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dOy.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void gO(boolean z) {
        if (z) {
            if (aCj() && this.dOB.getVisibility() != 0) {
                this.dOB.setVisibility(0);
            }
        } else if (this.dOB.getVisibility() != 8) {
            this.dOB.setVisibility(8);
        }
    }

    public void D(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.dOy.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.cuK.removeView(this.mNoDataView);
        }
        gY(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.dOy.setVisibility(8);
    }

    public boolean aCj() {
        return this.dOF;
    }

    public void gQ(boolean z) {
        this.dOF = z;
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
                if (this.dOv != null) {
                    this.dOv.insertOrUpdate(data, this.dxB);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dOv != null) {
                this.dOv.remove(data, this.dxB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dOv != null) {
                this.dOv.setData(data, this.dxB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dRx = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dRx != -1) {
                gW(true);
                onPrimary();
            }
        }
    }

    public void gV(boolean z) {
        BdListViewHelper.a(this.amv, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        if (z && this.dOy != null && this.dOy.getWrappedAdapter() != null && this.dOy.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
                @Override // java.lang.Runnable
                public void run() {
                    e.this.dOy.startPullRefresh();
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
        this.dRt.nA(i);
        this.dRt.nB(i2);
        this.dRt.notifyDataSetChanged();
    }

    public void gZ(boolean z) {
        this.coN.setVisibility(z ? 0 : 8);
    }
}
