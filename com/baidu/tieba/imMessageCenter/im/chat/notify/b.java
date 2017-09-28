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
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseFragment {
    private NoNetworkView bga;
    private RelativeLayout cni;
    private ShutDownValidateTipView dGW;
    private b.InterfaceC0047b dGY;
    private int dGZ;
    private f mNoDataView;
    private ImMessageCenterModel dGQ = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dGR = null;
    private ImMessageCenterShowItemData dGS = null;
    private BdListView dGT = null;
    private ImMessageCenterListAdapter dGU = null;
    private d dGV = null;
    com.baidu.tbadk.core.dialog.b dGX = null;
    private boolean dHa = true;
    private final CustomMessageListener baN = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.dGU != null) {
                b.this.dGU.notifyDataSetChanged();
            }
        }
    };
    private final AdapterView.OnItemClickListener dHb = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData mm = b.this.dGU.getItem(i);
                TiebaStatic.eventStat(b.this.dGR.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (mm != null) {
                    String ownerName = mm.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(mm);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.dGR.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.dGR.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(b.this.dGR.getPageContext().getPageActivity(), Integer.parseInt(mm.getFriendId()), mm.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (mm.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.dGR.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(mm);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yB().yW() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yB().yW().ec(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(b.this.dGR.getPageContext().getPageActivity())));
                        }
                    } else if (mm.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                        if (a.a((BaseFragmentActivity) b.this.dGR.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(mm);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yB().yW() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yB().yW().eb(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(b.this.dGR.getPageContext().getPageActivity())));
                        }
                    } else if (mm.getOwnerName().equals("6")) {
                        if (a.a((BaseFragmentActivity) b.this.dGR.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                            d(mm);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yB().yW() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yB().yW().el(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(b.this.dGR.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.dGR.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(b.this.dGR.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (a.a((BaseFragmentActivity) b.this.dGR.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(b.this.dGR.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(mm.getFriendId(), 0L), mm.getFriendName(), mm.getFriendPortrait(), 0, mm.getUserType())));
                        }
                    } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(b.this.dGR.getPageContext().getPageActivity())));
                    } else {
                        e(mm);
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(b.this.dGR.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener dHc = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.dGS = b.this.dGU.getItem(i);
            b.this.c(b.this.dGS);
            if (b.this.dGX != null) {
                b.this.dGX.tl();
            }
            return true;
        }
    };
    private final g.b bbT = new g.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefresh(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener dpD = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.10
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
                    b.this.dGQ.setData(null, b.this.dpF);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.dGU != null) {
                        b.this.dGU.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.dGU != null) {
                    b.this.dGU.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a dpF = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.2
        @Override // com.baidu.tieba.im.chat.a.a
        public void ati() {
            if (b.this.dGT != null && b.this.dGQ != null) {
                b.this.dGT.completePullRefreshPostDelayed(2000L);
                b.this.dGU.setData(b.this.dGQ.getData());
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
        this.dGZ = 3;
        this.dGR = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.j.chat_list_activity, viewGroup, false);
        an(inflate);
        TiebaStatic.eventStat(this.dGR.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dpD);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dpD);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dpD);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dpD);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dpD);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dpD);
        registerListener(this.baN);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dGU != null) {
            this.dGU.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dGR.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.dpD);
    }

    private void initData() {
        this.dGQ = new ImMessageCenterModel();
        gP(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void an(View view) {
        this.cni = (RelativeLayout) view.findViewById(d.h.chat_list);
        this.dGW = (ShutDownValidateTipView) view.findViewById(d.h.view_no_validate);
        this.dGW.setVisibility(8);
        this.dGW.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.gP(false);
                b.this.gN(false);
            }
        });
        this.dGT = (BdListView) view.findViewById(d.h.chat_list_content);
        this.dGT.setDividerHeight(0);
        this.dGV = new d(getPageContext());
        this.dGV.a(this.bbT);
        this.dGV.setTag(getUniqueId());
        this.dGT.setPullRefresh(this.dGV);
        this.dGU = new ImMessageCenterListAdapter(this.dGR.getPageContext().getPageActivity());
        this.dGT.setAdapter((ListAdapter) this.dGU);
        this.dGT.setOnItemClickListener(this.dHb);
        this.dGT.setOnItemLongClickListener(this.dHc);
        this.dGT.startPullRefresh();
        this.bga = (NoNetworkView) this.cni.findViewById(d.h.view_no_network);
        if (!this.mIsLogin) {
            gO(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dGZ != i) {
            this.dGZ = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dGR.getPageContext(), i);
            }
            if (this.dGW != null) {
                this.dGW.onChangeSkinType(i);
            }
            if (this.dGV != null) {
                this.dGV.dz(i);
            }
            if (this.dGU != null) {
                this.dGU.notifyDataSetChanged();
            }
            if (this.dGR != null && (this.dGR instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dGR).getLayoutMode().ai(i == 1);
                ((BaseFragmentActivity) this.dGR).getLayoutMode().t(this.cni);
            }
            if (this.bga != null) {
                this.bga.onChangeSkinType(this.dGR.getPageContext(), i);
            }
        }
    }

    private void azM() {
        if (isAdded()) {
            if (this.mIsLogin) {
                azN();
            } else {
                azO();
            }
        }
    }

    private void azN() {
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
        this.mNoDataView = NoDataViewFactory.a(this.dGR.getPageContext().getPageActivity(), this.cni, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dq(d.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void azO() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.l.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.dGR.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aT(b.this.dGR.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.f.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.f.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dGR.getPageContext().getPageActivity(), this.cni, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        azM();
        if (!z) {
            gO(true);
        } else {
            gO(false);
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
        this.dGY = new b.InterfaceC0047b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.dGQ.deleteItem(imMessageCenterShowItemData, b.this.dpF);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dGR.getPageContext().getPageActivity().getString(d.l.delete_user_chat);
        this.dGX = new com.baidu.tbadk.core.dialog.b(this.dGR.getPageContext().getPageActivity());
        this.dGX.cg(d.l.operation);
        this.dGX.a(new String[]{string}, this.dGY);
        this.dGX.d(this.dGR.getPageContext());
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

    public void gO(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                azM();
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

    public boolean azP() {
        return this.dHa;
    }

    public void gP(boolean z) {
        this.dHa = z;
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
}
