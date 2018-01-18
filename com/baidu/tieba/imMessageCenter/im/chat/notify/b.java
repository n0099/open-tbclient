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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.j;
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
    private NoNetworkView bYQ;
    private RelativeLayout dxQ;
    private ShutDownValidateTipView eLd;
    private b.InterfaceC0073b eLf;
    private int eLg;
    private h mNoDataView;
    private ImMessageCenterModel eKX = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> eKY = null;
    private ImMessageCenterShowItemData eKZ = null;
    private BdListView eLa = null;
    private ImMessageCenterListAdapter eLb = null;
    private d eLc = null;
    com.baidu.tbadk.core.dialog.b eLe = null;
    private boolean eLh = true;
    private final AdapterView.OnItemClickListener QC = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData pI = b.this.eLb.getItem(i);
                TiebaStatic.eventStat(b.this.eKY.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (pI != null) {
                    String ownerName = pI.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(pI);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.eKY.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.eKY.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(b.this.eKY.getPageContext().getPageActivity(), Integer.parseInt(pI.getFriendId()), pI.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (pI.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.eKY.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(pI);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA().gX(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(b.this.eKY.getPageContext().getPageActivity())));
                        }
                    } else if (pI.getOwnerName().equals("3")) {
                        if (a.a((BaseFragmentActivity) b.this.eKY.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(pI);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA().gW(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(b.this.eKY.getPageContext().getPageActivity())));
                        }
                    } else if (pI.getOwnerName().equals("6")) {
                        if (a.a((BaseFragmentActivity) b.this.eKY.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                            d(pI);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA().hg(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(b.this.eKY.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.eKY.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(b.this.eKY.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (a.a((BaseFragmentActivity) b.this.eKY.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(b.this.eKY.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(pI.getFriendId(), 0L), pI.getFriendName(), pI.getFriendPortrait(), 0, pI.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ak("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(b.this.eKY.getPageContext().getPageActivity())));
                    } else {
                        e(pI);
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
                            com.baidu.tieba.im.db.d.aGy().mS("apply_join_group");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                            com.baidu.tieba.im.db.d.aGy().mS("group_intro_change");
                            com.baidu.tieba.im.db.d.aGy().mS("group_name_change");
                            com.baidu.tieba.im.db.d.aGy().mS("group_notice_change");
                            com.baidu.tieba.im.db.d.aGy().mS("group_level_up");
                            com.baidu.tieba.im.db.d.aGy().mS("dismiss_group");
                            com.baidu.tieba.im.db.d.aGy().mS("kick_out");
                            com.baidu.tieba.im.db.d.aGy().mS("group_activitys_change");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                            com.baidu.tieba.im.db.d.aGy().mS("live_notify");
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
                com.baidu.tbadk.coreExtra.messageCenter.a.Gf().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.Gf().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                imMessageCenterShowItemData.setUnReadCount(0);
            }
            try {
                long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                TiebaStatic.log("tab_msg_personal_chat_click");
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(b.this.eKY.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener eLi = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.eKZ = b.this.eLb.getItem(i);
            b.this.c(b.this.eKZ);
            if (b.this.eLe != null) {
                b.this.eLe.AD();
            }
            return true;
        }
    };
    private final j.b bSY = new j.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
        @Override // com.baidu.tbadk.core.view.j.b
        public void onListPullRefresh(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener etX = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
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
                    b.this.eKX.setData(null, b.this.etZ);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.eLb != null) {
                        b.this.eLb.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.eLb != null) {
                    b.this.eLb.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a etZ = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
        @Override // com.baidu.tieba.im.chat.a.a
        public void aEE() {
            if (b.this.eLa != null && b.this.eKX != null) {
                b.this.eLa.completePullRefreshPostDelayed(2000L);
                b.this.eLb.setData(b.this.eKX.getData());
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
        this.eLg = 3;
        this.eKY = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.h.chat_list_activity, viewGroup, false);
        bJ(inflate);
        TiebaStatic.eventStat(this.eKY.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.etX);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.etX);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.etX);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.etX);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.etX);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.etX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eLb != null) {
            this.eLb.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.eKY.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.etX);
    }

    private void initData() {
        this.eKX = new ImMessageCenterModel();
        hN(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bJ(View view) {
        this.dxQ = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.eLd = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.eLd.setVisibility(8);
        this.eLd.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.hN(false);
                b.this.hL(false);
            }
        });
        this.eLa = (BdListView) view.findViewById(d.g.chat_list_content);
        this.eLa.setDividerHeight(0);
        this.eLc = new d(getPageContext());
        this.eLc.a(this.bSY);
        this.eLc.setTag(getUniqueId());
        this.eLa.setPullRefresh(this.eLc);
        this.eLb = new ImMessageCenterListAdapter(this.eKY.getPageContext().getPageActivity());
        this.eLa.setAdapter((ListAdapter) this.eLb);
        this.eLa.setOnItemClickListener(this.QC);
        this.eLa.setOnItemLongClickListener(this.eLi);
        this.eLa.startPullRefresh();
        this.bYQ = (NoNetworkView) this.dxQ.findViewById(d.g.view_no_network);
        if (!this.mIsLogin) {
            hM(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.eLg != i) {
            this.eLg = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eKY.getPageContext(), i);
            }
            if (this.eLd != null) {
                this.eLd.onChangeSkinType(i);
            }
            if (this.eLc != null) {
                this.eLc.gv(i);
            }
            if (this.eLb != null) {
                this.eLb.notifyDataSetChanged();
            }
            if (this.eKY != null && (this.eKY instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.eKY).getLayoutMode().aM(i == 1);
                ((BaseFragmentActivity) this.eKY).getLayoutMode().aM(this.dxQ);
            }
            if (this.bYQ != null) {
                this.bYQ.onChangeSkinType(this.eKY.getPageContext(), i);
            }
        }
    }

    private void aKV() {
        if (isAdded()) {
            if (this.mIsLogin) {
                aKW();
            } else {
                aKX();
            }
        }
    }

    private void aKW() {
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
        this.mNoDataView = NoDataViewFactory.a(this.eKY.getPageContext().getPageActivity(), this.dxQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gn(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aKX() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.eKY.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.bd(b.this.eKY.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eKY.getPageContext().getPageActivity(), this.dxQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aB(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aKV();
        if (!z) {
            hM(true);
        } else {
            hM(false);
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
        this.eLf = new b.InterfaceC0073b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.eKX.deleteItem(imMessageCenterShowItemData, b.this.etZ);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.eKY.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.eLe = new com.baidu.tbadk.core.dialog.b(this.eKY.getPageContext().getPageActivity());
        this.eLe.fe(d.j.operation);
        this.eLe.a(new String[]{string}, this.eLf);
        this.eLe.d(this.eKY.getPageContext());
    }

    public void hL(boolean z) {
        if (z) {
            if (aKY() && this.eLd.getVisibility() != 0) {
                this.eLd.setVisibility(0);
            }
        } else if (this.eLd.getVisibility() != 8) {
            this.eLd.setVisibility(8);
        }
    }

    public void hM(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                aKV();
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

    public boolean aKY() {
        return this.eLh;
    }

    public void hN(boolean z) {
        this.eLh = z;
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
                if (this.eKX != null) {
                    this.eKX.insertOrUpdate(data, this.etZ);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eKX != null) {
                this.eKX.remove(data, this.etZ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.eKX != null) {
                this.eKX.setData(data, this.etZ);
            }
        }
    }
}
