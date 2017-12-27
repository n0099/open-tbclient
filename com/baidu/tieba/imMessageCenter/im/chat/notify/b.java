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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseFragment {
    private NoNetworkView bYJ;
    private RelativeLayout dtq;
    private ShutDownValidateTipView eJD;
    private b.InterfaceC0074b eJF;
    private int eJG;
    private g mNoDataView;
    private ImMessageCenterModel eJx = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> eJy = null;
    private ImMessageCenterShowItemData eJz = null;
    private BdListView eJA = null;
    private ImMessageCenterListAdapter eJB = null;
    private d eJC = null;
    com.baidu.tbadk.core.dialog.b eJE = null;
    private boolean eJH = true;
    private final AdapterView.OnItemClickListener QC = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData pP = b.this.eJB.getItem(i);
                TiebaStatic.eventStat(b.this.eJy.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (pP != null) {
                    String ownerName = pP.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(pP);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.eJy.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.eJy.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(b.this.eJy.getPageContext().getPageActivity(), Integer.parseInt(pP.getFriendId()), pP.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (pP.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.eJy.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(pP);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GH() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GH().ha(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(b.this.eJy.getPageContext().getPageActivity())));
                        }
                    } else if (pP.getOwnerName().equals("3")) {
                        if (a.a((BaseFragmentActivity) b.this.eJy.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(pP);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GH() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GH().gZ(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(b.this.eJy.getPageContext().getPageActivity())));
                        }
                    } else if (pP.getOwnerName().equals("6")) {
                        if (a.a((BaseFragmentActivity) b.this.eJy.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                            d(pP);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GH() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GH().hj(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(b.this.eJy.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.eJy.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(b.this.eJy.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (a.a((BaseFragmentActivity) b.this.eJy.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(b.this.eJy.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(pP.getFriendId(), 0L), pP.getFriendName(), pP.getFriendPortrait(), 0, pP.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ak("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(b.this.eJy.getPageContext().getPageActivity())));
                    } else {
                        e(pP);
                    }
                }
            }
        }

        private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.4.1
                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    if (customMessage != null && imMessageCenterShowItemData != null) {
                        imMessageCenterShowItemData.setUnReadCount(0);
                        if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                            com.baidu.tieba.im.db.d.aGt().mP("apply_join_group");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                            com.baidu.tieba.im.db.d.aGt().mP("group_intro_change");
                            com.baidu.tieba.im.db.d.aGt().mP("group_name_change");
                            com.baidu.tieba.im.db.d.aGt().mP("group_notice_change");
                            com.baidu.tieba.im.db.d.aGt().mP("group_level_up");
                            com.baidu.tieba.im.db.d.aGt().mP("dismiss_group");
                            com.baidu.tieba.im.db.d.aGt().mP("kick_out");
                            com.baidu.tieba.im.db.d.aGt().mP("group_activitys_change");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                            com.baidu.tieba.im.db.d.aGt().mP("live_notify");
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
                com.baidu.tbadk.coreExtra.messageCenter.a.Gm().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.Gm().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                imMessageCenterShowItemData.setUnReadCount(0);
            }
            try {
                long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                TiebaStatic.log("tab_msg_personal_chat_click");
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(b.this.eJy.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener eJI = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.eJz = b.this.eJB.getItem(i);
            b.this.c(b.this.eJz);
            if (b.this.eJE != null) {
                b.this.eJE.AL();
            }
            return true;
        }
    };
    private final i.b bSR = new i.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
        @Override // com.baidu.tbadk.core.view.i.b
        public void onListPullRefresh(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener esz = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016002) {
                    b.this.f(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    b.this.g(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    b.this.h(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    b.this.eJx.setData(null, b.this.esB);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.eJB != null) {
                        b.this.eJB.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.eJB != null) {
                    b.this.eJB.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a esB = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
        @Override // com.baidu.tieba.im.chat.a.a
        public void aEz() {
            if (b.this.eJA != null && b.this.eJx != null) {
                b.this.eJA.completePullRefreshPostDelayed(2000L);
                b.this.eJB.setData(b.this.eJx.getData());
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
        this.eJG = 3;
        this.eJy = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.h.chat_list_activity, viewGroup, false);
        bH(inflate);
        TiebaStatic.eventStat(this.eJy.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.esz);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.esz);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.esz);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.esz);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.esz);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.esz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eJB != null) {
            this.eJB.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.eJy.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.esz);
    }

    private void initData() {
        this.eJx = new ImMessageCenterModel();
        hK(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bH(View view) {
        this.dtq = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.eJD = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.eJD.setVisibility(8);
        this.eJD.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.hK(false);
                b.this.hI(false);
            }
        });
        this.eJA = (BdListView) view.findViewById(d.g.chat_list_content);
        this.eJA.setDividerHeight(0);
        this.eJC = new d(getPageContext());
        this.eJC.a(this.bSR);
        this.eJC.setTag(getUniqueId());
        this.eJA.setPullRefresh(this.eJC);
        this.eJB = new ImMessageCenterListAdapter(this.eJy.getPageContext().getPageActivity());
        this.eJA.setAdapter((ListAdapter) this.eJB);
        this.eJA.setOnItemClickListener(this.QC);
        this.eJA.setOnItemLongClickListener(this.eJI);
        this.eJA.startPullRefresh();
        this.bYJ = (NoNetworkView) this.dtq.findViewById(d.g.view_no_network);
        if (!this.mIsLogin) {
            hJ(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.eJG != i) {
            this.eJG = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eJy.getPageContext(), i);
            }
            if (this.eJD != null) {
                this.eJD.onChangeSkinType(i);
            }
            if (this.eJC != null) {
                this.eJC.gy(i);
            }
            if (this.eJB != null) {
                this.eJB.notifyDataSetChanged();
            }
            if (this.eJy != null && (this.eJy instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.eJy).getLayoutMode().aM(i == 1);
                ((BaseFragmentActivity) this.eJy).getLayoutMode().aM(this.dtq);
            }
            if (this.bYJ != null) {
                this.bYJ.onChangeSkinType(this.eJy.getPageContext(), i);
            }
        }
    }

    private void aKQ() {
        if (isAdded()) {
            if (this.mIsLogin) {
                aKR();
            } else {
                aKS();
            }
        }
    }

    private void aKR() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) b.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.eJy.getPageContext().getPageActivity(), this.dtq, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aKS() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.eJy.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.bd(b.this.eJy.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eJy.getPageContext().getPageActivity(), this.dtq, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aB(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aKQ();
        if (!z) {
            hJ(true);
        } else {
            hJ(false);
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
        this.eJF = new b.InterfaceC0074b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0074b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.eJx.deleteItem(imMessageCenterShowItemData, b.this.esB);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.eJy.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.eJE = new com.baidu.tbadk.core.dialog.b(this.eJy.getPageContext().getPageActivity());
        this.eJE.fg(d.j.operation);
        this.eJE.a(new String[]{string}, this.eJF);
        this.eJE.d(this.eJy.getPageContext());
    }

    public void hI(boolean z) {
        if (z) {
            if (aKT() && this.eJD.getVisibility() != 0) {
                this.eJD.setVisibility(0);
            }
        } else if (this.eJD.getVisibility() != 8) {
            this.eJD.setVisibility(8);
        }
    }

    public void hJ(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                aKQ();
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

    public boolean aKT() {
        return this.eJH;
    }

    public void hK(boolean z) {
        this.eJH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.eJx != null) {
                    this.eJx.insertOrUpdate(data, this.esB);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eJx != null) {
                this.eJx.remove(data, this.esB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.eJx != null) {
                this.eJx.setData(data, this.esB);
            }
        }
    }
}
