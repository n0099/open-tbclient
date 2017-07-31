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
    private final CustomMessageListener aZp;
    private View anJ;
    private View bMP;
    private NoNetworkView beq;
    private NavigationBar ccM;
    private RelativeLayout cfN;
    private final CustomMessageListener cjY;
    private ImMessageCenterModel dBf;
    private ImMessageCenterShowItemData dBh;
    private BdListView dBi;
    private ShutDownValidateTipView dBl;
    com.baidu.tbadk.core.dialog.b dBm;
    private b.InterfaceC0043b dBn;
    private int dBo;
    private boolean dBp;
    private final AdapterView.OnItemClickListener dBq;
    private final AdapterView.OnItemLongClickListener dBr;
    private final g dEb;
    private MessageAggregationListAdapter dEc;
    private boolean dEd;
    private boolean dEe;
    private boolean dEf;
    private int dEg;
    private TextView dEh;
    private CustomMessageListener dEi;
    private final CustomMessageListener djR;
    private com.baidu.tieba.im.chat.a.a djT;
    private com.baidu.tbadk.core.view.j mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.aa(gVar.getPageContext().getPageActivity()));
        this.dBf = null;
        this.dBh = null;
        this.dBi = null;
        this.dEc = null;
        this.dBm = null;
        this.dBp = true;
        this.dEd = false;
        this.dEe = false;
        this.dEf = true;
        this.dEg = 16;
        this.aZp = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && e.this.dEc != null) {
                    e.this.dEc.notifyDataSetChanged();
                }
            }
        };
        this.dEi = new CustomMessageListener(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS) { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && e.this.mNoDataView != null && e.this.mNoDataView.getVisibility() == 0) {
                    e.this.z(e.this.isLogin(), true);
                }
            }
        };
        this.dBq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData item = e.this.dEc.getItem(i);
                    if (item != null) {
                        TiebaStatic.eventStat(e.this.dEb.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                        String ownerName = item.getOwnerName();
                        if (TextUtils.isEmpty(ownerName)) {
                            e(item);
                            return;
                        } else if (ownerName.equals("1")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dEb.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                                TiebaStatic.eventStat(e.this.dEb.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.dEb.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("2")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dEb.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu().dR(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.dEb.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dEb.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu().dQ(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.dEb.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("6")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dEb.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu().ea(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(e.this.dEb.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("5")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dEb.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.dEb.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("8")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dEb.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.dEb.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, item.getUserType())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.dEb.getPageContext().getPageActivity())));
                            return;
                        } else {
                            e(item);
                            return;
                        }
                    }
                    if (i == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(e.this.dEb.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zo();
                        e.this.dEc.mI(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgReplyme(0);
                        TiebaStatic.eventStat(e.this.dEb.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(e.this.dEb.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zp();
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgAtme(0);
                        e.this.dEc.mJ(0);
                        TiebaStatic.eventStat(e.this.dEb.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    }
                    e.this.dEc.notifyDataSetChanged();
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.atS().lU("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                                com.baidu.tieba.im.db.d.atS().lU("group_intro_change");
                                com.baidu.tieba.im.db.d.atS().lU("group_name_change");
                                com.baidu.tieba.im.db.d.atS().lU("group_notice_change");
                                com.baidu.tieba.im.db.d.atS().lU("group_level_up");
                                com.baidu.tieba.im.db.d.atS().lU("dismiss_group");
                                com.baidu.tieba.im.db.d.atS().lU("kick_out");
                                com.baidu.tieba.im.db.d.atS().lU("group_activitys_change");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                                com.baidu.tieba.im.db.d.atS().lU("live_notify");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.yZ().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.dEb.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.dBr = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    return false;
                }
                e.this.dBh = e.this.dEc.getItem(i);
                e.this.c(e.this.dBh);
                if (e.this.dBm != null) {
                    e.this.dBm.tu();
                    return true;
                }
                return true;
            }
        };
        this.djR = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
                        e.this.dBf.setData(null, e.this.djT);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.dEc != null) {
                            e.this.dEc.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.dEc != null) {
                        e.this.dEc.notifyDataSetChanged();
                    }
                }
            }
        };
        this.djT = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                if (e.this.dBi != null && e.this.dBf != null) {
                    e.this.dBi.completePullRefreshPostDelayed(2000L);
                    if (e.this.dBf.getData() != null) {
                        e.this.dEc.setData(e.this.dBf.getData());
                    } else {
                        e.this.z(e.this.isLogin(), true);
                    }
                }
            }
        };
        this.cjY = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.h(customResponsedMessage);
                }
            }
        };
        this.dEb = gVar;
    }

    public void j(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dEg = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dEg = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dEg);
        }
    }

    public void ahe() {
        if (this.dEc != null) {
            this.dEc.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.djR);
    }

    public View XR() {
        this.dBo = 3;
        this.rootView = LayoutInflater.from(this.dEb.getPageContext().getPageActivity()).inflate(d.j.chat_list_activity, (ViewGroup) null, false);
        initData();
        ah(this.rootView);
        TiebaStatic.eventStat(this.dEb.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        XS();
        return this.rootView;
    }

    protected void XS() {
        this.dBi.startPullRefresh();
        this.dEd = isLogin();
        if (!this.dEd) {
            z(this.dEd, true);
        }
    }

    private void registerListener() {
        this.dEb.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.djR);
        this.dEb.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.djR);
        this.dEb.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.djR);
        this.dEb.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.djR);
        this.dEb.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.djR);
        this.dEb.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.djR);
        this.dEb.registerListener(this.aZp);
        this.dEb.registerListener(this.dEi);
    }

    public void gW(boolean z) {
        this.dEe = z;
    }

    public void gX(boolean z) {
        this.dEf = z;
    }

    public void onPrimary() {
        if (this.dEc != null && this.dEc.getCount() == 0) {
            gW(true);
        }
        if (this.dEf || this.dEe) {
            this.dEf = false;
            this.dEe = false;
            dN(false);
        }
        boolean isLogin = isLogin();
        if (this.dEd != isLogin) {
            this.dEd = isLogin;
            onUserChanged(this.dEd);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dEb.getPageContext());
        }
    }

    private void initData() {
        this.dBf = new ImMessageCenterModel();
        gQ(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dEb.registerListener(this.cjY);
    }

    private void ah(View view) {
        this.cfN = (RelativeLayout) view.findViewById(d.h.chat_list);
        this.dBl = (ShutDownValidateTipView) view.findViewById(d.h.view_no_validate);
        this.dBl.setVisibility(8);
        this.dBl.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.gQ(false);
                e.this.gO(false);
            }
        });
        this.ccM = (NavigationBar) this.cfN.findViewById(d.h.view_navigation_bar);
        this.dEh = (TextView) this.ccM.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.maintab_title_layout, (View.OnClickListener) null).findViewById(d.h.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dEb.getResources().getDimension(d.f.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dEh.setLayoutParams(layoutParams);
        this.dEh.setText(d.l.my_message);
        this.ccM.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.ccM.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    aw.aM(e.this.mContext.getPageActivity());
                }
            });
            this.ccM.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    aw.aN(e.this.mContext.getPageActivity());
                }
            });
        }
        this.anJ = new TextView(this.dEb.getPageContext().getPageActivity());
        this.anJ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dEb.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.anJ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hr());
        this.beq = (NoNetworkView) this.cfN.findViewById(d.h.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.beq.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.beq.setLayoutParams(layoutParams2);
        this.beq.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                e.this.gV(z);
            }
        });
        this.dBi = (BdListView) view.findViewById(d.h.chat_list_content);
        this.dBi.addHeaderView(this.anJ);
        this.dBi.setDividerHeight(0);
        this.dEc = new MessageAggregationListAdapter(this.dEb.getPageContext().getPageActivity());
        this.dEc.a(this);
        this.dBi.setAdapter((ListAdapter) this.dEc);
        this.dBi.setOnItemClickListener(this.dBq);
        this.dBi.setOnItemLongClickListener(this.dBr);
        this.bMP = new View(this.dEb.getFragmentActivity());
        this.bMP.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.dEb.getFragmentActivity(), d.f.ds150)));
        this.dBi.addFooterView(this.bMP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dEb.getPageContext(), i);
        }
        this.beq.onChangeSkinType(getPageContext(), i);
        this.ccM.onChangeSkinType(tbPageContext, i);
        if (this.dBl != null) {
            this.dBl.onChangeSkinType(i);
        }
        ai.a(this.dEh, d.e.cp_cont_b, d.e.s_navbar_title_color, i);
        if (this.dEc != null) {
            this.dEc.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.cfN);
            return true;
        }
        return true;
    }

    private void gY(boolean z) {
        if (z) {
            ayA();
        } else {
            ayB();
        }
    }

    private void ayA() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dEb.getResources().getString(d.l.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) e.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dEb.getPageContext().getPageActivity(), this.cfN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dEb.getResources().getDimension(d.f.ds320)), NoDataViewFactory.d.dk(d.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void ayB() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dEb.getResources().getString(d.l.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.dEb.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                aw.aN(e.this.dEb.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.dEb.getResources().getDimensionPixelSize(d.f.ds320);
        int dimensionPixelSize2 = this.dEb.getResources().getDimensionPixelSize(d.f.ds480);
        int dimensionPixelSize3 = this.dEb.getResources().getDimensionPixelSize(d.f.ds360);
        int dimensionPixelSize4 = this.dEb.getResources().getDimensionPixelSize(d.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dEb.getPageContext().getPageActivity(), this.cfN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(d.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dEb.getResources().getDimensionPixelSize(d.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        z(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dBn = new b.InterfaceC0043b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        e.this.dBf.deleteItem(imMessageCenterShowItemData, e.this.djT);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dEb.getPageContext().getPageActivity().getString(d.l.delete_user_chat);
        this.dBm = new com.baidu.tbadk.core.dialog.b(this.dEb.getPageContext().getPageActivity());
        this.dBm.cf(d.l.operation);
        this.dBm.a(new String[]{string}, this.dBn);
        this.dBm.d(this.dEb.getPageContext());
    }

    protected boolean dN(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dBi.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void gO(boolean z) {
        if (z) {
            if (ayC() && this.dBl.getVisibility() != 0) {
                this.dBl.setVisibility(0);
            }
        } else if (this.dBl.getVisibility() != 8) {
            this.dBl.setVisibility(8);
        }
    }

    public void z(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.dBi.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.cfN.removeView(this.mNoDataView);
        }
        gY(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.dBi.setVisibility(8);
    }

    public boolean ayC() {
        return this.dBp;
    }

    public void gQ(boolean z) {
        this.dBp = z;
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
                if (this.dBf != null) {
                    this.dBf.insertOrUpdate(data, this.djT);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dBf != null) {
                this.dBf.remove(data, this.djT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dBf != null) {
                this.dBf.setData(data, this.djT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dEg = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dEg != -1) {
                gW(true);
                onPrimary();
            }
        }
    }

    public void gV(boolean z) {
        BdListViewHelper.a(this.anJ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hr());
        if (z && this.dBi != null && this.dBi.getWrappedAdapter() != null && this.dBi.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
                @Override // java.lang.Runnable
                public void run() {
                    e.this.dBi.startPullRefresh();
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
            aW(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void aW(int i, int i2) {
        this.dEc.mI(i);
        this.dEc.mJ(i2);
        this.dEc.notifyDataSetChanged();
    }

    public void gZ(boolean z) {
        this.ccM.setVisibility(z ? 0 : 8);
    }
}
