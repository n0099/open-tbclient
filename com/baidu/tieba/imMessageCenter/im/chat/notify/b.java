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
    private NoNetworkView bgM;
    private RelativeLayout cuK;
    private ShutDownValidateTipView dOB;
    private b.InterfaceC0047b dOD;
    private int dOE;
    private f mNoDataView;
    private ImMessageCenterModel dOv = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dOw = null;
    private ImMessageCenterShowItemData dOx = null;
    private BdListView dOy = null;
    private ImMessageCenterListAdapter dOz = null;
    private d dOA = null;
    com.baidu.tbadk.core.dialog.b dOC = null;
    private boolean dOF = true;
    private final CustomMessageListener bbo = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.dOz != null) {
                b.this.dOz.notifyDataSetChanged();
            }
        }
    };
    private final AdapterView.OnItemClickListener dOG = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData mC = b.this.dOz.getItem(i);
                TiebaStatic.eventStat(b.this.dOw.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (mC != null) {
                    String ownerName = mC.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(mC);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.dOw.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.dOw.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(b.this.dOw.getPageContext().getPageActivity(), Integer.parseInt(mC.getFriendId()), mC.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (mC.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.dOw.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(mC);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yK().zf() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yK().zf().eb(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(b.this.dOw.getPageContext().getPageActivity())));
                        }
                    } else if (mC.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                        if (a.a((BaseFragmentActivity) b.this.dOw.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(mC);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yK().zf() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yK().zf().ea(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(b.this.dOw.getPageContext().getPageActivity())));
                        }
                    } else if (mC.getOwnerName().equals("6")) {
                        if (a.a((BaseFragmentActivity) b.this.dOw.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                            d(mC);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yK().zf() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yK().zf().ek(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(b.this.dOw.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.dOw.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(b.this.dOw.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (a.a((BaseFragmentActivity) b.this.dOw.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(b.this.dOw.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(mC.getFriendId(), 0L), mC.getFriendName(), mC.getFriendPortrait(), 0, mC.getUserType())));
                        }
                    } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(b.this.dOw.getPageContext().getPageActivity())));
                    } else {
                        e(mC);
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(b.this.dOw.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener dOH = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.dOx = b.this.dOz.getItem(i);
            b.this.c(b.this.dOx);
            if (b.this.dOC != null) {
                b.this.dOC.tl();
            }
            return true;
        }
    };
    private final g.b bcu = new g.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefresh(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener dxz = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.10
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
                    b.this.dOv.setData(null, b.this.dxB);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.dOz != null) {
                        b.this.dOz.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.dOz != null) {
                    b.this.dOz.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a dxB = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.2
        @Override // com.baidu.tieba.im.chat.a.a
        public void avP() {
            if (b.this.dOy != null && b.this.dOv != null) {
                b.this.dOy.completePullRefreshPostDelayed(2000L);
                b.this.dOz.setData(b.this.dOv.getData());
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
        this.dOE = 3;
        this.dOw = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.h.chat_list_activity, viewGroup, false);
        ar(inflate);
        TiebaStatic.eventStat(this.dOw.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dxz);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dxz);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dxz);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dxz);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dxz);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dxz);
        registerListener(this.bbo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dOz != null) {
            this.dOz.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dOw.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.dxz);
    }

    private void initData() {
        this.dOv = new ImMessageCenterModel();
        gQ(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void ar(View view) {
        this.cuK = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.dOB = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.dOB.setVisibility(8);
        this.dOB.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.gQ(false);
                b.this.gO(false);
            }
        });
        this.dOy = (BdListView) view.findViewById(d.g.chat_list_content);
        this.dOy.setDividerHeight(0);
        this.dOA = new d(getPageContext());
        this.dOA.a(this.bcu);
        this.dOA.setTag(getUniqueId());
        this.dOy.setPullRefresh(this.dOA);
        this.dOz = new ImMessageCenterListAdapter(this.dOw.getPageContext().getPageActivity());
        this.dOy.setAdapter((ListAdapter) this.dOz);
        this.dOy.setOnItemClickListener(this.dOG);
        this.dOy.setOnItemLongClickListener(this.dOH);
        this.dOy.startPullRefresh();
        this.bgM = (NoNetworkView) this.cuK.findViewById(d.g.view_no_network);
        if (!this.mIsLogin) {
            gP(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dOE != i) {
            this.dOE = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dOw.getPageContext(), i);
            }
            if (this.dOB != null) {
                this.dOB.onChangeSkinType(i);
            }
            if (this.dOA != null) {
                this.dOA.dy(i);
            }
            if (this.dOz != null) {
                this.dOz.notifyDataSetChanged();
            }
            if (this.dOw != null && (this.dOw instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dOw).getLayoutMode().ag(i == 1);
                ((BaseFragmentActivity) this.dOw).getLayoutMode().t(this.cuK);
            }
            if (this.bgM != null) {
                this.bgM.onChangeSkinType(this.dOw.getPageContext(), i);
            }
        }
    }

    private void aCg() {
        if (isAdded()) {
            if (this.mIsLogin) {
                aCh();
            } else {
                aCi();
            }
        }
    }

    private void aCh() {
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
        this.mNoDataView = NoDataViewFactory.a(this.dOw.getPageContext().getPageActivity(), this.cuK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dp(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aCi() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.dOw.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aS(b.this.dOw.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dOw.getPageContext().getPageActivity(), this.cuK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aCg();
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
        this.dOD = new b.InterfaceC0047b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.dOv.deleteItem(imMessageCenterShowItemData, b.this.dxB);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dOw.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.dOC = new com.baidu.tbadk.core.dialog.b(this.dOw.getPageContext().getPageActivity());
        this.dOC.cf(d.j.operation);
        this.dOC.a(new String[]{string}, this.dOD);
        this.dOC.d(this.dOw.getPageContext());
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

    public void gP(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                aCg();
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

    public boolean aCj() {
        return this.dOF;
    }

    public void gQ(boolean z) {
        this.dOF = z;
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
}
