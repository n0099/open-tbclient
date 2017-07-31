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
    private NoNetworkView beq;
    private RelativeLayout cfN;
    private ShutDownValidateTipView dBl;
    private b.InterfaceC0043b dBn;
    private int dBo;
    private j mNoDataView;
    private ImMessageCenterModel dBf = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dBg = null;
    private ImMessageCenterShowItemData dBh = null;
    private BdListView dBi = null;
    private ImMessageCenterListAdapter dBj = null;
    private d dBk = null;
    com.baidu.tbadk.core.dialog.b dBm = null;
    private boolean dBp = true;
    private final CustomMessageListener aZp = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.dBj != null) {
                b.this.dBj.notifyDataSetChanged();
            }
        }
    };
    private final AdapterView.OnItemClickListener dBq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData lM = b.this.dBj.getItem(i);
                TiebaStatic.eventStat(b.this.dBg.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (lM != null) {
                    String ownerName = lM.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(lM);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.dBg.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.dBg.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(b.this.dBg.getPageContext().getPageActivity(), Integer.parseInt(lM.getFriendId()), lM.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (lM.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.dBg.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(lM);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu().dR(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(b.this.dBg.getPageContext().getPageActivity())));
                        }
                    } else if (lM.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                        if (a.a((BaseFragmentActivity) b.this.dBg.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(lM);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu().dQ(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(b.this.dBg.getPageContext().getPageActivity())));
                        }
                    } else if (lM.getOwnerName().equals("6")) {
                        if (a.a((BaseFragmentActivity) b.this.dBg.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                            d(lM);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu().ea(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(b.this.dBg.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.dBg.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(b.this.dBg.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (a.a((BaseFragmentActivity) b.this.dBg.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(b.this.dBg.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(lM.getFriendId(), 0L), lM.getFriendName(), lM.getFriendPortrait(), 0, lM.getUserType())));
                        }
                    } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(b.this.dBg.getPageContext().getPageActivity())));
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(b.this.dBg.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener dBr = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.dBh = b.this.dBj.getItem(i);
            b.this.c(b.this.dBh);
            if (b.this.dBm != null) {
                b.this.dBm.tu();
            }
            return true;
        }
    };
    private final k.b baw = new k.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener djR = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.10
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
                    b.this.dBf.setData(null, b.this.djT);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.dBj != null) {
                        b.this.dBj.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.dBj != null) {
                    b.this.dBj.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a djT = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.2
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            if (b.this.dBi != null && b.this.dBf != null) {
                b.this.dBi.completePullRefreshPostDelayed(2000L);
                b.this.dBj.setData(b.this.dBf.getData());
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
        this.dBo = 3;
        this.dBg = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.j.chat_list_activity, viewGroup, false);
        ah(inflate);
        TiebaStatic.eventStat(this.dBg.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.djR);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.djR);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.djR);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.djR);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.djR);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.djR);
        registerListener(this.aZp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dBj != null) {
            this.dBj.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dBg.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.djR);
    }

    private void initData() {
        this.dBf = new ImMessageCenterModel();
        gQ(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void ah(View view) {
        this.cfN = (RelativeLayout) view.findViewById(d.h.chat_list);
        this.dBl = (ShutDownValidateTipView) view.findViewById(d.h.view_no_validate);
        this.dBl.setVisibility(8);
        this.dBl.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.gQ(false);
                b.this.gO(false);
            }
        });
        this.dBi = (BdListView) view.findViewById(d.h.chat_list_content);
        this.dBi.setDividerHeight(0);
        this.dBk = new d(getPageContext());
        this.dBk.a(this.baw);
        this.dBk.setTag(getUniqueId());
        this.dBi.setPullRefresh(this.dBk);
        this.dBj = new ImMessageCenterListAdapter(this.dBg.getPageContext().getPageActivity());
        this.dBi.setAdapter((ListAdapter) this.dBj);
        this.dBi.setOnItemClickListener(this.dBq);
        this.dBi.setOnItemLongClickListener(this.dBr);
        this.dBi.startPullRefresh();
        this.beq = (NoNetworkView) this.cfN.findViewById(d.h.view_no_network);
        if (!this.mIsLogin) {
            gP(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dBo != i) {
            this.dBo = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dBg.getPageContext(), i);
            }
            if (this.dBl != null) {
                this.dBl.onChangeSkinType(i);
            }
            if (this.dBk != null) {
                this.dBk.dp(i);
            }
            if (this.dBj != null) {
                this.dBj.notifyDataSetChanged();
            }
            if (this.dBg != null && (this.dBg instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dBg).getLayoutMode().ah(i == 1);
                ((BaseFragmentActivity) this.dBg).getLayoutMode().t(this.cfN);
            }
            if (this.beq != null) {
                this.beq.onChangeSkinType(this.dBg.getPageContext(), i);
            }
        }
    }

    private void ayz() {
        if (isAdded()) {
            if (this.mIsLogin) {
                ayA();
            } else {
                ayB();
            }
        }
    }

    private void ayA() {
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
        this.mNoDataView = NoDataViewFactory.a(this.dBg.getPageContext().getPageActivity(), this.cfN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dk(d.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void ayB() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.l.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.dBg.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                aw.aN(b.this.dBg.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.f.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.f.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dBg.getPageContext().getPageActivity(), this.cfN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(d.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        ayz();
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
        this.dBn = new b.InterfaceC0043b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.dBf.deleteItem(imMessageCenterShowItemData, b.this.djT);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dBg.getPageContext().getPageActivity().getString(d.l.delete_user_chat);
        this.dBm = new com.baidu.tbadk.core.dialog.b(this.dBg.getPageContext().getPageActivity());
        this.dBm.cf(d.l.operation);
        this.dBm.a(new String[]{string}, this.dBn);
        this.dBm.d(this.dBg.getPageContext());
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

    public void gP(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                ayz();
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

    public boolean ayC() {
        return this.dBp;
    }

    public void gQ(boolean z) {
        this.dBp = z;
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
}
