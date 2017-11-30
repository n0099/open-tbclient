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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
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
    private NoNetworkView blt;
    private RelativeLayout cDP;
    private ShutDownValidateTipView dWq;
    private b.InterfaceC0047b dWs;
    private int dWt;
    private f mNoDataView;
    private ImMessageCenterModel dWk = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dWl = null;
    private ImMessageCenterShowItemData dWm = null;
    private BdListView dWn = null;
    private ImMessageCenterListAdapter dWo = null;
    private d dWp = null;
    com.baidu.tbadk.core.dialog.b dWr = null;
    private boolean dWu = true;
    private final CustomMessageListener bez = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.dWo != null) {
                b.this.dWo.notifyDataSetChanged();
            }
        }
    };
    private final AdapterView.OnItemClickListener dWv = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData mQ = b.this.dWo.getItem(i);
                TiebaStatic.eventStat(b.this.dWl.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (mQ != null) {
                    String ownerName = mQ.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(mQ);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.dWl.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.dWl.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(b.this.dWl.getPageContext().getPageActivity(), Integer.parseInt(mQ.getFriendId()), mQ.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (mQ.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.dWl.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(mQ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh().ec(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(b.this.dWl.getPageContext().getPageActivity())));
                        }
                    } else if (mQ.getOwnerName().equals("3")) {
                        if (a.a((BaseFragmentActivity) b.this.dWl.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(mQ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh().eb(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(b.this.dWl.getPageContext().getPageActivity())));
                        }
                    } else if (mQ.getOwnerName().equals("6")) {
                        if (a.a((BaseFragmentActivity) b.this.dWl.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                            d(mQ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh().el(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(b.this.dWl.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.dWl.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(b.this.dWl.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (a.a((BaseFragmentActivity) b.this.dWl.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(b.this.dWl.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(mQ.getFriendId(), 0L), mQ.getFriendName(), mQ.getFriendPortrait(), 0, mQ.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ak("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(b.this.dWl.getPageContext().getPageActivity())));
                    } else {
                        e(mQ);
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
                            com.baidu.tieba.im.db.d.azj().mG("apply_join_group");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                            com.baidu.tieba.im.db.d.azj().mG("group_intro_change");
                            com.baidu.tieba.im.db.d.azj().mG("group_name_change");
                            com.baidu.tieba.im.db.d.azj().mG("group_notice_change");
                            com.baidu.tieba.im.db.d.azj().mG("group_level_up");
                            com.baidu.tieba.im.db.d.azj().mG("dismiss_group");
                            com.baidu.tieba.im.db.d.azj().mG("kick_out");
                            com.baidu.tieba.im.db.d.azj().mG("group_activitys_change");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                            com.baidu.tieba.im.db.d.azj().mG("live_notify");
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
                com.baidu.tbadk.coreExtra.messageCenter.a.yM().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.yM().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                imMessageCenterShowItemData.setUnReadCount(0);
            }
            try {
                long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                TiebaStatic.log("tab_msg_personal_chat_click");
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(b.this.dWl.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener dWw = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.dWm = b.this.dWo.getItem(i);
            b.this.c(b.this.dWm);
            if (b.this.dWr != null) {
                b.this.dWr.to();
            }
            return true;
        }
    };
    private final g.b bfG = new g.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefresh(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener dFn = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016002) {
                    b.this.e(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    b.this.f(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    b.this.g(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    b.this.dWk.setData(null, b.this.dFp);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.dWo != null) {
                        b.this.dWo.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.dWo != null) {
                    b.this.dWo.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a dFp = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.2
        @Override // com.baidu.tieba.im.chat.a.a
        public void axp() {
            if (b.this.dWn != null && b.this.dWk != null) {
                b.this.dWn.completePullRefreshPostDelayed(2000L);
                b.this.dWo.setData(b.this.dWk.getData());
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
        this.dWt = 3;
        this.dWl = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.h.chat_list_activity, viewGroup, false);
        as(inflate);
        TiebaStatic.eventStat(this.dWl.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dFn);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dFn);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dFn);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dFn);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dFn);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dFn);
        registerListener(this.bez);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dWo != null) {
            this.dWo.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dWl.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.dFn);
    }

    private void initData() {
        this.dWk = new ImMessageCenterModel();
        hk(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void as(View view) {
        this.cDP = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.dWq = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.dWq.setVisibility(8);
        this.dWq.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.hk(false);
                b.this.hi(false);
            }
        });
        this.dWn = (BdListView) view.findViewById(d.g.chat_list_content);
        this.dWn.setDividerHeight(0);
        this.dWp = new d(getPageContext());
        this.dWp.a(this.bfG);
        this.dWp.setTag(getUniqueId());
        this.dWn.setPullRefresh(this.dWp);
        this.dWo = new ImMessageCenterListAdapter(this.dWl.getPageContext().getPageActivity());
        this.dWn.setAdapter((ListAdapter) this.dWo);
        this.dWn.setOnItemClickListener(this.dWv);
        this.dWn.setOnItemLongClickListener(this.dWw);
        this.dWn.startPullRefresh();
        this.blt = (NoNetworkView) this.cDP.findViewById(d.g.view_no_network);
        if (!this.mIsLogin) {
            hj(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dWt != i) {
            this.dWt = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dWl.getPageContext(), i);
            }
            if (this.dWq != null) {
                this.dWq.onChangeSkinType(i);
            }
            if (this.dWp != null) {
                this.dWp.dz(i);
            }
            if (this.dWo != null) {
                this.dWo.notifyDataSetChanged();
            }
            if (this.dWl != null && (this.dWl instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dWl).getLayoutMode().ag(i == 1);
                ((BaseFragmentActivity) this.dWl).getLayoutMode().t(this.cDP);
            }
            if (this.blt != null) {
                this.blt.onChangeSkinType(this.dWl.getPageContext(), i);
            }
        }
    }

    private void aDG() {
        if (isAdded()) {
            if (this.mIsLogin) {
                aDH();
            } else {
                aDI();
            }
        }
    }

    private void aDH() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) b.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dWl.getPageContext().getPageActivity(), this.cDP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dq(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aDI() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.dWl.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aU(b.this.dWl.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dWl.getPageContext().getPageActivity(), this.cDP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aDG();
        if (!z) {
            hj(true);
        } else {
            hj(false);
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
        this.dWs = new b.InterfaceC0047b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.dWk.deleteItem(imMessageCenterShowItemData, b.this.dFp);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dWl.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.dWr = new com.baidu.tbadk.core.dialog.b(this.dWl.getPageContext().getPageActivity());
        this.dWr.cg(d.j.operation);
        this.dWr.a(new String[]{string}, this.dWs);
        this.dWr.d(this.dWl.getPageContext());
    }

    public void hi(boolean z) {
        if (z) {
            if (aDJ() && this.dWq.getVisibility() != 0) {
                this.dWq.setVisibility(0);
            }
        } else if (this.dWq.getVisibility() != 8) {
            this.dWq.setVisibility(8);
        }
    }

    public void hj(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                aDG();
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

    public boolean aDJ() {
        return this.dWu;
    }

    public void hk(boolean z) {
        this.dWu = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.dWk != null) {
                    this.dWk.insertOrUpdate(data, this.dFp);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dWk != null) {
                this.dWk.remove(data, this.dFp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dWk != null) {
                this.dWk.setData(data, this.dFp);
            }
        }
    }
}
