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
    private View amm;
    private View bQQ;
    private final CustomMessageListener baN;
    private NoNetworkView bga;
    private NavigationBar chk;
    private RelativeLayout cni;
    private final CustomMessageListener cru;
    private ImMessageCenterModel dGQ;
    private ImMessageCenterShowItemData dGS;
    private BdListView dGT;
    private ShutDownValidateTipView dGW;
    com.baidu.tbadk.core.dialog.b dGX;
    private b.InterfaceC0047b dGY;
    private int dGZ;
    private boolean dHa;
    private final AdapterView.OnItemClickListener dHb;
    private final AdapterView.OnItemLongClickListener dHc;
    private final g dJO;
    private MessageAggregationListAdapter dJP;
    private boolean dJQ;
    private boolean dJR;
    private boolean dJS;
    private int dJT;
    private TextView dJU;
    private CustomMessageListener dJV;
    private final CustomMessageListener dpD;
    private com.baidu.tieba.im.chat.a.a dpF;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.Y(gVar.getPageContext().getPageActivity()));
        this.dGQ = null;
        this.dGS = null;
        this.dGT = null;
        this.dJP = null;
        this.dGX = null;
        this.dHa = true;
        this.dJQ = false;
        this.dJR = false;
        this.dJS = true;
        this.dJT = 16;
        this.baN = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && e.this.dJP != null) {
                    e.this.dJP.notifyDataSetChanged();
                }
            }
        };
        this.dJV = new CustomMessageListener(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS) { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && e.this.mNoDataView != null && e.this.mNoDataView.getVisibility() == 0) {
                    e.this.C(e.this.isLogin(), true);
                }
            }
        };
        this.dHb = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData item = e.this.dJP.getItem(i);
                    if (item != null) {
                        TiebaStatic.eventStat(e.this.dJO.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                        String ownerName = item.getOwnerName();
                        if (TextUtils.isEmpty(ownerName)) {
                            e(item);
                            return;
                        } else if (ownerName.equals("1")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dJO.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                                TiebaStatic.eventStat(e.this.dJO.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.dJO.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("2")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dJO.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yB().yW() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yB().yW().ec(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.dJO.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dJO.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yB().yW() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yB().yW().eb(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.dJO.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("6")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dJO.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yB().yW() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yB().yW().el(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(e.this.dJO.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("5")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dJO.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.dJO.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("8")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dJO.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.dJO.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, item.getUserType())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.dJO.getPageContext().getPageActivity())));
                            return;
                        } else {
                            e(item);
                            return;
                        }
                    }
                    if (i == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(e.this.dJO.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yB().yQ();
                        e.this.dJP.nj(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yB().setMsgReplyme(0);
                        TiebaStatic.eventStat(e.this.dJO.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(e.this.dJO.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yB().yR();
                        com.baidu.tbadk.coreExtra.messageCenter.a.yB().setMsgAtme(0);
                        e.this.dJP.nk(0);
                        TiebaStatic.eventStat(e.this.dJO.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    }
                    e.this.dJP.notifyDataSetChanged();
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.avc().ma("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                                com.baidu.tieba.im.db.d.avc().ma("group_intro_change");
                                com.baidu.tieba.im.db.d.avc().ma("group_name_change");
                                com.baidu.tieba.im.db.d.avc().ma("group_notice_change");
                                com.baidu.tieba.im.db.d.avc().ma("group_level_up");
                                com.baidu.tieba.im.db.d.avc().ma("dismiss_group");
                                com.baidu.tieba.im.db.d.avc().ma("kick_out");
                                com.baidu.tieba.im.db.d.avc().ma("group_activitys_change");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                                com.baidu.tieba.im.db.d.avc().ma("live_notify");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.yB().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.yB().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.dJO.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.dHc = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    return false;
                }
                e.this.dGS = e.this.dJP.getItem(i);
                e.this.c(e.this.dGS);
                if (e.this.dGX != null) {
                    e.this.dGX.tl();
                    return true;
                }
                return true;
            }
        };
        this.dpD = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
                        e.this.dGQ.setData(null, e.this.dpF);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.dJP != null) {
                            e.this.dJP.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.dJP != null) {
                        e.this.dJP.notifyDataSetChanged();
                    }
                }
            }
        };
        this.dpF = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // com.baidu.tieba.im.chat.a.a
            public void ati() {
                if (e.this.dGT != null && e.this.dGQ != null) {
                    e.this.dGT.completePullRefreshPostDelayed(2000L);
                    if (e.this.dGQ.getData() != null) {
                        e.this.dJP.setData(e.this.dGQ.getData());
                    } else {
                        e.this.C(e.this.isLogin(), true);
                    }
                }
            }
        };
        this.cru = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.h(customResponsedMessage);
                }
            }
        };
        this.dJO = gVar;
    }

    public void l(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dJT = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dJT = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dJT);
        }
    }

    public void ajw() {
        if (this.dJP != null) {
            this.dJP.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dpD);
    }

    public View Zi() {
        this.dGZ = 3;
        this.rootView = LayoutInflater.from(this.dJO.getPageContext().getPageActivity()).inflate(d.j.chat_list_activity, (ViewGroup) null, false);
        initData();
        an(this.rootView);
        TiebaStatic.eventStat(this.dJO.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        Zj();
        return this.rootView;
    }

    protected void Zj() {
        this.dGT.startPullRefresh();
        this.dJQ = isLogin();
        if (!this.dJQ) {
            C(this.dJQ, true);
        }
    }

    private void registerListener() {
        this.dJO.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dpD);
        this.dJO.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dpD);
        this.dJO.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dpD);
        this.dJO.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dpD);
        this.dJO.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dpD);
        this.dJO.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dpD);
        this.dJO.registerListener(this.baN);
        this.dJO.registerListener(this.dJV);
    }

    public void gV(boolean z) {
        this.dJR = z;
    }

    public void gW(boolean z) {
        this.dJS = z;
    }

    public void onPrimary() {
        if (this.dJP != null && this.dJP.getCount() == 0) {
            gV(true);
        }
        if (this.dJS || this.dJR) {
            this.dJS = false;
            this.dJR = false;
            dL(false);
        }
        boolean isLogin = isLogin();
        if (this.dJQ != isLogin) {
            this.dJQ = isLogin;
            onUserChanged(this.dJQ);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dJO.getPageContext());
        }
    }

    private void initData() {
        this.dGQ = new ImMessageCenterModel();
        gP(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dJO.registerListener(this.cru);
    }

    private void an(View view) {
        this.cni = (RelativeLayout) view.findViewById(d.h.chat_list);
        this.dGW = (ShutDownValidateTipView) view.findViewById(d.h.view_no_validate);
        this.dGW.setVisibility(8);
        this.dGW.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.gP(false);
                e.this.gN(false);
            }
        });
        this.chk = (NavigationBar) this.cni.findViewById(d.h.view_navigation_bar);
        this.dJU = (TextView) this.chk.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.maintab_title_layout, (View.OnClickListener) null).findViewById(d.h.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dJO.getResources().getDimension(d.f.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dJU.setLayoutParams(layoutParams);
        this.dJU.setText(d.l.my_message);
        this.chk.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.chk.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.aS(e.this.mContext.getPageActivity());
                }
            });
            this.chk.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aT(e.this.mContext.getPageActivity());
                }
            });
        }
        this.amm = new TextView(this.dJO.getPageContext().getPageActivity());
        this.amm.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dJO.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.amm, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.bga = (NoNetworkView) this.cni.findViewById(d.h.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bga.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.bga.setLayoutParams(layoutParams2);
        this.bga.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                e.this.gU(z);
            }
        });
        this.dGT = (BdListView) view.findViewById(d.h.chat_list_content);
        this.dGT.addHeaderView(this.amm);
        this.dGT.setDividerHeight(0);
        this.dJP = new MessageAggregationListAdapter(this.dJO.getPageContext().getPageActivity());
        this.dJP.a(this);
        this.dGT.setAdapter((ListAdapter) this.dJP);
        this.dGT.setOnItemClickListener(this.dHb);
        this.dGT.setOnItemLongClickListener(this.dHc);
        this.bQQ = new View(this.dJO.getFragmentActivity());
        this.bQQ.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.dJO.getFragmentActivity(), d.f.ds150)));
        this.dGT.addFooterView(this.bQQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dJO.getPageContext(), i);
        }
        this.bga.onChangeSkinType(getPageContext(), i);
        this.chk.onChangeSkinType(tbPageContext, i);
        if (this.dGW != null) {
            this.dGW.onChangeSkinType(i);
        }
        aj.a(this.dJU, d.e.cp_cont_b, d.e.s_navbar_title_color, i);
        if (this.dJP != null) {
            this.dJP.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.cni);
            return true;
        }
        return true;
    }

    private void gX(boolean z) {
        if (z) {
            azN();
        } else {
            azO();
        }
    }

    private void azN() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dJO.getResources().getString(d.l.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) e.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dJO.getPageContext().getPageActivity(), this.cni, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dJO.getResources().getDimension(d.f.ds320)), NoDataViewFactory.d.dq(d.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void azO() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dJO.getResources().getString(d.l.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.dJO.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aT(e.this.dJO.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.dJO.getResources().getDimensionPixelSize(d.f.ds320);
        int dimensionPixelSize2 = this.dJO.getResources().getDimensionPixelSize(d.f.ds480);
        int dimensionPixelSize3 = this.dJO.getResources().getDimensionPixelSize(d.f.ds360);
        int dimensionPixelSize4 = this.dJO.getResources().getDimensionPixelSize(d.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dJO.getPageContext().getPageActivity(), this.cni, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dJO.getResources().getDimensionPixelSize(d.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        C(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dGY = new b.InterfaceC0047b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        e.this.dGQ.deleteItem(imMessageCenterShowItemData, e.this.dpF);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dJO.getPageContext().getPageActivity().getString(d.l.delete_user_chat);
        this.dGX = new com.baidu.tbadk.core.dialog.b(this.dJO.getPageContext().getPageActivity());
        this.dGX.cg(d.l.operation);
        this.dGX.a(new String[]{string}, this.dGY);
        this.dGX.d(this.dJO.getPageContext());
    }

    protected boolean dL(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dGT.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void gN(boolean z) {
        if (z) {
            if (azP() && this.dGW.getVisibility() != 0) {
                this.dGW.setVisibility(0);
            }
        } else if (this.dGW.getVisibility() != 8) {
            this.dGW.setVisibility(8);
        }
    }

    public void C(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.dGT.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.cni.removeView(this.mNoDataView);
        }
        gX(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.dGT.setVisibility(8);
    }

    public boolean azP() {
        return this.dHa;
    }

    public void gP(boolean z) {
        this.dHa = z;
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
                if (this.dGQ != null) {
                    this.dGQ.insertOrUpdate(data, this.dpF);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dGQ != null) {
                this.dGQ.remove(data, this.dpF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dGQ != null) {
                this.dGQ.setData(data, this.dpF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dJT = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dJT != -1) {
                gV(true);
                onPrimary();
            }
        }
    }

    public void gU(boolean z) {
        BdListViewHelper.a(this.amm, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        if (z && this.dGT != null && this.dGT.getWrappedAdapter() != null && this.dGT.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
                @Override // java.lang.Runnable
                public void run() {
                    e.this.dGT.startPullRefresh();
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
            bn(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void bn(int i, int i2) {
        this.dJP.nj(i);
        this.dJP.nk(i2);
        this.dJP.notifyDataSetChanged();
    }

    public void gY(boolean z) {
        this.chk.setVisibility(z ? 0 : 8);
    }
}
