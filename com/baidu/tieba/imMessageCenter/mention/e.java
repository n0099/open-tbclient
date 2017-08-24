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
    private final CustomMessageListener aZr;
    private View anK;
    private View bNz;
    private NoNetworkView bes;
    private NavigationBar cdz;
    private RelativeLayout cgA;
    private final CustomMessageListener ckM;
    private ImMessageCenterModel dDc;
    private ImMessageCenterShowItemData dDe;
    private BdListView dDf;
    private ShutDownValidateTipView dDi;
    com.baidu.tbadk.core.dialog.b dDj;
    private b.InterfaceC0043b dDk;
    private int dDl;
    private boolean dDm;
    private final AdapterView.OnItemClickListener dDn;
    private final AdapterView.OnItemLongClickListener dDo;
    private final g dFY;
    private MessageAggregationListAdapter dFZ;
    private boolean dGa;
    private boolean dGb;
    private boolean dGc;
    private int dGd;
    private TextView dGe;
    private CustomMessageListener dGf;
    private final CustomMessageListener dlO;
    private com.baidu.tieba.im.chat.a.a dlQ;
    private com.baidu.tbadk.core.view.j mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.aa(gVar.getPageContext().getPageActivity()));
        this.dDc = null;
        this.dDe = null;
        this.dDf = null;
        this.dFZ = null;
        this.dDj = null;
        this.dDm = true;
        this.dGa = false;
        this.dGb = false;
        this.dGc = true;
        this.dGd = 16;
        this.aZr = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && e.this.dFZ != null) {
                    e.this.dFZ.notifyDataSetChanged();
                }
            }
        };
        this.dGf = new CustomMessageListener(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS) { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && e.this.mNoDataView != null && e.this.mNoDataView.getVisibility() == 0) {
                    e.this.A(e.this.isLogin(), true);
                }
            }
        };
        this.dDn = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData item = e.this.dFZ.getItem(i);
                    if (item != null) {
                        TiebaStatic.eventStat(e.this.dFY.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                        String ownerName = item.getOwnerName();
                        if (TextUtils.isEmpty(ownerName)) {
                            e(item);
                            return;
                        } else if (ownerName.equals("1")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dFY.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                                TiebaStatic.eventStat(e.this.dFY.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.dFY.getPageContext().getPageActivity(), Integer.parseInt(item.getFriendId()), item.getFriendName(), 0L, "msg_lstb")));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("2")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dFY.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu().dR(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.dFY.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dFY.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu().dQ(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.dFY.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (item.getOwnerName().equals("6")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dFY.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                                d(item);
                                if (com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu() != null) {
                                    com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu().ea(0);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(e.this.dFY.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("5")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dFY.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.dFY.getPageContext().getPageActivity())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals("8")) {
                            if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.dFY.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.dFY.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, item.getUserType())));
                                return;
                            }
                            return;
                        } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.dFY.getPageContext().getPageActivity())));
                            return;
                        } else {
                            e(item);
                            return;
                        }
                    }
                    if (i == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ReplyMessageActivityConfig(e.this.dFY.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zo();
                        e.this.dFZ.mS(0);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgReplyme(0);
                        TiebaStatic.eventStat(e.this.dFY.getPageContext().getPageActivity(), "msg_reply_tab_click", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(e.this.dFY.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zp();
                        com.baidu.tbadk.coreExtra.messageCenter.a.yZ().setMsgAtme(0);
                        e.this.dFZ.mT(0);
                        TiebaStatic.eventStat(e.this.dFY.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    }
                    e.this.dFZ.notifyDataSetChanged();
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.15.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.auu().md("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                                com.baidu.tieba.im.db.d.auu().md("group_intro_change");
                                com.baidu.tieba.im.db.d.auu().md("group_name_change");
                                com.baidu.tieba.im.db.d.auu().md("group_notice_change");
                                com.baidu.tieba.im.db.d.auu().md("group_level_up");
                                com.baidu.tieba.im.db.d.auu().md("dismiss_group");
                                com.baidu.tieba.im.db.d.auu().md("kick_out");
                                com.baidu.tieba.im.db.d.auu().md("group_activitys_change");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                                com.baidu.tieba.im.db.d.auu().md("live_notify");
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.dFY.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.dDo = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i <= 1) {
                    return false;
                }
                e.this.dDe = e.this.dFZ.getItem(i);
                e.this.c(e.this.dDe);
                if (e.this.dDj != null) {
                    e.this.dDj.tv();
                    return true;
                }
                return true;
            }
        };
        this.dlO = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
                        e.this.dDc.setData(null, e.this.dlQ);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.dFZ != null) {
                            e.this.dFZ.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.dFZ != null) {
                        e.this.dFZ.notifyDataSetChanged();
                    }
                }
            }
        };
        this.dlQ = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                if (e.this.dDf != null && e.this.dDc != null) {
                    e.this.dDf.completePullRefreshPostDelayed(2000L);
                    if (e.this.dDc.getData() != null) {
                        e.this.dFZ.setData(e.this.dDc.getData());
                    } else {
                        e.this.A(e.this.isLogin(), true);
                    }
                }
            }
        };
        this.ckM = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.h(customResponsedMessage);
                }
            }
        };
        this.dFY = gVar;
    }

    public void i(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dGd = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dGd = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dGd);
        }
    }

    public void aht() {
        if (this.dFZ != null) {
            this.dFZ.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dlO);
    }

    public View Yj() {
        this.dDl = 3;
        this.rootView = LayoutInflater.from(this.dFY.getPageContext().getPageActivity()).inflate(d.j.chat_list_activity, (ViewGroup) null, false);
        initData();
        ag(this.rootView);
        TiebaStatic.eventStat(this.dFY.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        Yk();
        return this.rootView;
    }

    protected void Yk() {
        this.dDf.startPullRefresh();
        this.dGa = isLogin();
        if (!this.dGa) {
            A(this.dGa, true);
        }
    }

    private void registerListener() {
        this.dFY.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dlO);
        this.dFY.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dlO);
        this.dFY.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dlO);
        this.dFY.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dlO);
        this.dFY.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dlO);
        this.dFY.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dlO);
        this.dFY.registerListener(this.aZr);
        this.dFY.registerListener(this.dGf);
    }

    public void gZ(boolean z) {
        this.dGb = z;
    }

    public void ha(boolean z) {
        this.dGc = z;
    }

    public void onPrimary() {
        if (this.dFZ != null && this.dFZ.getCount() == 0) {
            gZ(true);
        }
        if (this.dGc || this.dGb) {
            this.dGc = false;
            this.dGb = false;
            dO(false);
        }
        boolean isLogin = isLogin();
        if (this.dGa != isLogin) {
            this.dGa = isLogin;
            onUserChanged(this.dGa);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dFY.getPageContext());
        }
    }

    private void initData() {
        this.dDc = new ImMessageCenterModel();
        gT(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dFY.registerListener(this.ckM);
    }

    private void ag(View view) {
        this.cgA = (RelativeLayout) view.findViewById(d.h.chat_list);
        this.dDi = (ShutDownValidateTipView) view.findViewById(d.h.view_no_validate);
        this.dDi.setVisibility(8);
        this.dDi.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.gT(false);
                e.this.gR(false);
            }
        });
        this.cdz = (NavigationBar) this.cgA.findViewById(d.h.view_navigation_bar);
        this.dGe = (TextView) this.cdz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.maintab_title_layout, (View.OnClickListener) null).findViewById(d.h.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dFY.getResources().getDimension(d.f.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dGe.setLayoutParams(layoutParams);
        this.dGe.setText(d.l.my_message);
        this.cdz.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.cdz.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    aw.aM(e.this.mContext.getPageActivity());
                }
            });
            this.cdz.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    aw.aN(e.this.mContext.getPageActivity());
                }
            });
        }
        this.anK = new TextView(this.dFY.getPageContext().getPageActivity());
        this.anK.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dFY.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.anK, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hr());
        this.bes = (NoNetworkView) this.cgA.findViewById(d.h.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bes.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.bes.setLayoutParams(layoutParams2);
        this.bes.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                e.this.gY(z);
            }
        });
        this.dDf = (BdListView) view.findViewById(d.h.chat_list_content);
        this.dDf.addHeaderView(this.anK);
        this.dDf.setDividerHeight(0);
        this.dFZ = new MessageAggregationListAdapter(this.dFY.getPageContext().getPageActivity());
        this.dFZ.a(this);
        this.dDf.setAdapter((ListAdapter) this.dFZ);
        this.dDf.setOnItemClickListener(this.dDn);
        this.dDf.setOnItemLongClickListener(this.dDo);
        this.bNz = new View(this.dFY.getFragmentActivity());
        this.bNz.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.dFY.getFragmentActivity(), d.f.ds150)));
        this.dDf.addFooterView(this.bNz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dFY.getPageContext(), i);
        }
        this.bes.onChangeSkinType(getPageContext(), i);
        this.cdz.onChangeSkinType(tbPageContext, i);
        if (this.dDi != null) {
            this.dDi.onChangeSkinType(i);
        }
        ai.a(this.dGe, d.e.cp_cont_b, d.e.s_navbar_title_color, i);
        if (this.dFZ != null) {
            this.dFZ.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.cgA);
            return true;
        }
        return true;
    }

    private void hb(boolean z) {
        if (z) {
            azc();
        } else {
            azd();
        }
    }

    private void azc() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dFY.getResources().getString(d.l.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) e.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dFY.getPageContext().getPageActivity(), this.cgA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dFY.getResources().getDimension(d.f.ds320)), NoDataViewFactory.d.dk(d.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void azd() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dFY.getResources().getString(d.l.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.dFY.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                aw.aN(e.this.dFY.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.dFY.getResources().getDimensionPixelSize(d.f.ds320);
        int dimensionPixelSize2 = this.dFY.getResources().getDimensionPixelSize(d.f.ds480);
        int dimensionPixelSize3 = this.dFY.getResources().getDimensionPixelSize(d.f.ds360);
        int dimensionPixelSize4 = this.dFY.getResources().getDimensionPixelSize(d.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dFY.getPageContext().getPageActivity(), this.cgA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(d.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dFY.getResources().getDimensionPixelSize(d.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        A(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dDk = new b.InterfaceC0043b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        e.this.dDc.deleteItem(imMessageCenterShowItemData, e.this.dlQ);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dFY.getPageContext().getPageActivity().getString(d.l.delete_user_chat);
        this.dDj = new com.baidu.tbadk.core.dialog.b(this.dFY.getPageContext().getPageActivity());
        this.dDj.cf(d.l.operation);
        this.dDj.a(new String[]{string}, this.dDk);
        this.dDj.d(this.dFY.getPageContext());
    }

    protected boolean dO(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dDf.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void gR(boolean z) {
        if (z) {
            if (aze() && this.dDi.getVisibility() != 0) {
                this.dDi.setVisibility(0);
            }
        } else if (this.dDi.getVisibility() != 8) {
            this.dDi.setVisibility(8);
        }
    }

    public void A(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.dDf.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.cgA.removeView(this.mNoDataView);
        }
        hb(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.dDf.setVisibility(8);
    }

    public boolean aze() {
        return this.dDm;
    }

    public void gT(boolean z) {
        this.dDm = z;
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
                if (this.dDc != null) {
                    this.dDc.insertOrUpdate(data, this.dlQ);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dDc != null) {
                this.dDc.remove(data, this.dlQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dDc != null) {
                this.dDc.setData(data, this.dlQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dGd = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dGd != -1) {
                gZ(true);
                onPrimary();
            }
        }
    }

    public void gY(boolean z) {
        BdListViewHelper.a(this.anK, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hr());
        if (z && this.dDf != null && this.dDf.getWrappedAdapter() != null && this.dDf.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
                @Override // java.lang.Runnable
                public void run() {
                    e.this.dDf.startPullRefresh();
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
            be(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void be(int i, int i2) {
        this.dFZ.mS(i);
        this.dFZ.mT(i2);
        this.dFZ.notifyDataSetChanged();
    }

    public void hc(boolean z) {
        this.cdz.setVisibility(z ? 0 : 8);
    }
}
