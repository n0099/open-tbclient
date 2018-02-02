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
    private NoNetworkView bYY;
    private RelativeLayout dyl;
    private b.InterfaceC0073b eLA;
    private int eLB;
    private ShutDownValidateTipView eLy;
    private h mNoDataView;
    private ImMessageCenterModel eLs = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> eLt = null;
    private ImMessageCenterShowItemData eLu = null;
    private BdListView eLv = null;
    private ImMessageCenterListAdapter eLw = null;
    private d eLx = null;
    com.baidu.tbadk.core.dialog.b eLz = null;
    private boolean eLC = true;
    private final AdapterView.OnItemClickListener QC = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData pI = b.this.eLw.getItem(i);
                TiebaStatic.eventStat(b.this.eLt.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (pI != null) {
                    String ownerName = pI.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(pI);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.eLt.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.eLt.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(b.this.eLt.getPageContext().getPageActivity(), Integer.parseInt(pI.getFriendId()), pI.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (pI.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.eLt.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(pI);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().gX(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(b.this.eLt.getPageContext().getPageActivity())));
                        }
                    } else if (pI.getOwnerName().equals("3")) {
                        if (a.a((BaseFragmentActivity) b.this.eLt.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(pI);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().gW(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(b.this.eLt.getPageContext().getPageActivity())));
                        }
                    } else if (pI.getOwnerName().equals("6")) {
                        if (a.a((BaseFragmentActivity) b.this.eLt.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                            d(pI);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().hg(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(b.this.eLt.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.eLt.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(b.this.eLt.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (a.a((BaseFragmentActivity) b.this.eLt.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(b.this.eLt.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(pI.getFriendId(), 0L), pI.getFriendName(), pI.getFriendPortrait(), 0, pI.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ak("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(b.this.eLt.getPageContext().getPageActivity())));
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
                            com.baidu.tieba.im.db.d.aGD().na("apply_join_group");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                            com.baidu.tieba.im.db.d.aGD().na("group_intro_change");
                            com.baidu.tieba.im.db.d.aGD().na("group_name_change");
                            com.baidu.tieba.im.db.d.aGD().na("group_notice_change");
                            com.baidu.tieba.im.db.d.aGD().na("group_level_up");
                            com.baidu.tieba.im.db.d.aGD().na("dismiss_group");
                            com.baidu.tieba.im.db.d.aGD().na("kick_out");
                            com.baidu.tieba.im.db.d.aGD().na("group_activitys_change");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                            com.baidu.tieba.im.db.d.aGD().na("live_notify");
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
                com.baidu.tbadk.coreExtra.messageCenter.a.Gh().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.Gh().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                imMessageCenterShowItemData.setUnReadCount(0);
            }
            try {
                long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                TiebaStatic.log("tab_msg_personal_chat_click");
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(b.this.eLt.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener eLD = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.eLu = b.this.eLw.getItem(i);
            b.this.c(b.this.eLu);
            if (b.this.eLz != null) {
                b.this.eLz.AE();
            }
            return true;
        }
    };
    private final j.b bTg = new j.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
        @Override // com.baidu.tbadk.core.view.j.b
        public void onListPullRefresh(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener eus = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
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
                    b.this.eLs.setData(null, b.this.euu);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.eLw != null) {
                        b.this.eLw.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.eLw != null) {
                    b.this.eLw.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a euu = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
        @Override // com.baidu.tieba.im.chat.a.a
        public void aEJ() {
            if (b.this.eLv != null && b.this.eLs != null) {
                b.this.eLv.completePullRefreshPostDelayed(2000L);
                b.this.eLw.setData(b.this.eLs.getData());
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
        this.eLB = 3;
        this.eLt = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.h.chat_list_activity, viewGroup, false);
        bJ(inflate);
        TiebaStatic.eventStat(this.eLt.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.eus);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.eus);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.eus);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.eus);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.eus);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.eus);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eLw != null) {
            this.eLw.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.eLt.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.eus);
    }

    private void initData() {
        this.eLs = new ImMessageCenterModel();
        hQ(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bJ(View view) {
        this.dyl = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.eLy = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.eLy.setVisibility(8);
        this.eLy.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.hQ(false);
                b.this.hO(false);
            }
        });
        this.eLv = (BdListView) view.findViewById(d.g.chat_list_content);
        this.eLv.setDividerHeight(0);
        this.eLx = new d(getPageContext());
        this.eLx.a(this.bTg);
        this.eLx.setTag(getUniqueId());
        this.eLv.setPullRefresh(this.eLx);
        this.eLw = new ImMessageCenterListAdapter(this.eLt.getPageContext().getPageActivity());
        this.eLv.setAdapter((ListAdapter) this.eLw);
        this.eLv.setOnItemClickListener(this.QC);
        this.eLv.setOnItemLongClickListener(this.eLD);
        this.eLv.startPullRefresh();
        this.bYY = (NoNetworkView) this.dyl.findViewById(d.g.view_no_network);
        if (!this.mIsLogin) {
            hP(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.eLB != i) {
            this.eLB = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eLt.getPageContext(), i);
            }
            if (this.eLy != null) {
                this.eLy.onChangeSkinType(i);
            }
            if (this.eLx != null) {
                this.eLx.gv(i);
            }
            if (this.eLw != null) {
                this.eLw.notifyDataSetChanged();
            }
            if (this.eLt != null && (this.eLt instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.eLt).getLayoutMode().aN(i == 1);
                ((BaseFragmentActivity) this.eLt).getLayoutMode().aM(this.dyl);
            }
            if (this.bYY != null) {
                this.bYY.onChangeSkinType(this.eLt.getPageContext(), i);
            }
        }
    }

    private void aLa() {
        if (isAdded()) {
            if (this.mIsLogin) {
                aLb();
            } else {
                aLc();
            }
        }
    }

    private void aLb() {
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
        this.mNoDataView = NoDataViewFactory.a(this.eLt.getPageContext().getPageActivity(), this.dyl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gn(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aLc() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.eLt.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.ba(b.this.eLt.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eLt.getPageContext().getPageActivity(), this.dyl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aB(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aLa();
        if (!z) {
            hP(true);
        } else {
            hP(false);
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
        this.eLA = new b.InterfaceC0073b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.eLs.deleteItem(imMessageCenterShowItemData, b.this.euu);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.eLt.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.eLz = new com.baidu.tbadk.core.dialog.b(this.eLt.getPageContext().getPageActivity());
        this.eLz.fe(d.j.operation);
        this.eLz.a(new String[]{string}, this.eLA);
        this.eLz.d(this.eLt.getPageContext());
    }

    public void hO(boolean z) {
        if (z) {
            if (aLd() && this.eLy.getVisibility() != 0) {
                this.eLy.setVisibility(0);
            }
        } else if (this.eLy.getVisibility() != 8) {
            this.eLy.setVisibility(8);
        }
    }

    public void hP(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                aLa();
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

    public boolean aLd() {
        return this.eLC;
    }

    public void hQ(boolean z) {
        this.eLC = z;
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
                if (this.eLs != null) {
                    this.eLs.insertOrUpdate(data, this.euu);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eLs != null) {
                this.eLs.remove(data, this.euu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.eLs != null) {
                this.eLs.setData(data, this.euu);
            }
        }
    }
}
