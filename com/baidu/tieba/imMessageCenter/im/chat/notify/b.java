package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.LiveNotifyActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarTipActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.UpdatesActivityConfig;
import com.baidu.tbadk.core.atomData.ValidateActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseFragment {
    private NoNetworkView bdg;
    private RelativeLayout ceH;
    private ShutDownValidateTipView dzU;
    private b.InterfaceC0043b dzW;
    private int dzX;
    private j mNoDataView;
    private ImMessageCenterModel dzO = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dzP = null;
    private ImMessageCenterShowItemData dzQ = null;
    private BdListView dzR = null;
    private ImMessageCenterListAdapter dzS = null;
    private d dzT = null;
    com.baidu.tbadk.core.dialog.b dzV = null;
    private boolean dzY = true;
    private final CustomMessageListener aYe = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.dzS != null) {
                b.this.dzS.notifyDataSetChanged();
            }
        }
    };
    private final AdapterView.OnItemClickListener dzZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData lM = b.this.dzS.getItem(i);
                TiebaStatic.eventStat(b.this.dzP.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (lM != null) {
                    String ownerName = lM.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(lM);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.dzP.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.dzP.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(b.this.dzP.getPageContext().getPageActivity(), Integer.parseInt(lM.getFriendId()), lM.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (lM.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.dzP.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(lM);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yR().zm() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yR().zm().dP(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(b.this.dzP.getPageContext().getPageActivity())));
                        }
                    } else if (lM.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                        if (a.a((BaseFragmentActivity) b.this.dzP.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(lM);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yR().zm() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yR().zm().dO(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(b.this.dzP.getPageContext().getPageActivity())));
                        }
                    } else if (lM.getOwnerName().equals("6")) {
                        if (a.a((BaseFragmentActivity) b.this.dzP.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                            d(lM);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yR().zm() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yR().zm().dY(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(b.this.dzP.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.dzP.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(b.this.dzP.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (a.a((BaseFragmentActivity) b.this.dzP.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(b.this.dzP.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(lM.getFriendId(), 0L), lM.getFriendName(), lM.getFriendPortrait(), 0, lM.getUserType())));
                        }
                    } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(b.this.dzP.getPageContext().getPageActivity())));
                    } else {
                        e(lM);
                    }
                }
            }
        }

        private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6.1
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(b.this.dzP.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener dAa = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.dzQ = b.this.dzS.getItem(i);
            b.this.c(b.this.dzQ);
            if (b.this.dzV != null) {
                b.this.dzV.tk();
            }
            return true;
        }
    };
    private final k.b aZk = new k.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener diz = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016002) {
                    b.this.d(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    b.this.e(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    b.this.f(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    b.this.dzO.setData(null, b.this.diB);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.dzS != null) {
                        b.this.dzS.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.dzS != null) {
                    b.this.dzS.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a diB = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.2
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            if (b.this.dzR != null && b.this.dzO != null) {
                b.this.dzR.completePullRefreshPostDelayed(2000L);
                b.this.dzS.setData(b.this.dzO.getData());
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dzX = 3;
        this.dzP = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.j.chat_list_activity, viewGroup, false);
        ah(inflate);
        TiebaStatic.eventStat(this.dzP.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.diz);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.diz);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.diz);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.diz);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.diz);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.diz);
        registerListener(this.aYe);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dzS != null) {
            this.dzS.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dzP.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.diz);
    }

    private void initData() {
        this.dzO = new ImMessageCenterModel();
        gQ(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void ah(View view) {
        this.ceH = (RelativeLayout) view.findViewById(d.h.chat_list);
        this.dzU = (ShutDownValidateTipView) view.findViewById(d.h.view_no_validate);
        this.dzU.setVisibility(8);
        this.dzU.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.gQ(false);
                b.this.gO(false);
            }
        });
        this.dzR = (BdListView) view.findViewById(d.h.chat_list_content);
        this.dzR.setDividerHeight(0);
        this.dzT = new d(getPageContext());
        this.dzT.a(this.aZk);
        this.dzT.setTag(getUniqueId());
        this.dzR.setPullRefresh(this.dzT);
        this.dzS = new ImMessageCenterListAdapter(this.dzP.getPageContext().getPageActivity());
        this.dzR.setAdapter((ListAdapter) this.dzS);
        this.dzR.setOnItemClickListener(this.dzZ);
        this.dzR.setOnItemLongClickListener(this.dAa);
        this.dzR.startPullRefresh();
        this.bdg = (NoNetworkView) this.ceH.findViewById(d.h.view_no_network);
        if (!this.mIsLogin) {
            gP(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dzX != i) {
            this.dzX = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dzP.getPageContext(), i);
            }
            if (this.dzU != null) {
                this.dzU.onChangeSkinType(i);
            }
            if (this.dzT != null) {
                this.dzT.dn(i);
            }
            if (this.dzS != null) {
                this.dzS.notifyDataSetChanged();
            }
            if (this.dzP != null && (this.dzP instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dzP).getLayoutMode().ah(i == 1);
                ((BaseFragmentActivity) this.dzP).getLayoutMode().t(this.ceH);
            }
            if (this.bdg != null) {
                this.bdg.onChangeSkinType(this.dzP.getPageContext(), i);
            }
        }
    }

    private void ayo() {
        if (isAdded()) {
            if (this.mIsLogin) {
                ayp();
            } else {
                ayq();
            }
        }
    }

    private void ayp() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(d.l.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) b.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dzP.getPageContext().getPageActivity(), this.ceH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.di(d.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void ayq() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.l.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.dzP.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                aw.aM(b.this.dzP.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.f.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.f.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dzP.getPageContext().getPageActivity(), this.ceH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.A(d.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        ayo();
        if (!z) {
            gP(true);
        } else {
            gP(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dzW = new b.InterfaceC0043b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.dzO.deleteItem(imMessageCenterShowItemData, b.this.diB);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dzP.getPageContext().getPageActivity().getString(d.l.delete_user_chat);
        this.dzV = new com.baidu.tbadk.core.dialog.b(this.dzP.getPageContext().getPageActivity());
        this.dzV.cd(d.l.operation);
        this.dzV.a(new String[]{string}, this.dzW);
        this.dzV.d(this.dzP.getPageContext());
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

    public void gP(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                ayo();
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(0);
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        if (!isAdded()) {
        }
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
            sendMessage(new RequestMemoryListMessage(1));
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
}
