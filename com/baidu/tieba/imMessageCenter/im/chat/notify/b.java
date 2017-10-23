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
    private NoNetworkView bfM;
    private RelativeLayout cmV;
    private ShutDownValidateTipView dGI;
    private b.InterfaceC0047b dGK;
    private int dGL;
    private f mNoDataView;
    private ImMessageCenterModel dGC = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dGD = null;
    private ImMessageCenterShowItemData dGE = null;
    private BdListView dGF = null;
    private ImMessageCenterListAdapter dGG = null;
    private d dGH = null;
    com.baidu.tbadk.core.dialog.b dGJ = null;
    private boolean dGM = true;
    private final CustomMessageListener baz = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.dGG != null) {
                b.this.dGG.notifyDataSetChanged();
            }
        }
    };
    private final AdapterView.OnItemClickListener dGN = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData ml = b.this.dGG.getItem(i);
                TiebaStatic.eventStat(b.this.dGD.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (ml != null) {
                    String ownerName = ml.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(ml);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.dGD.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.dGD.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(b.this.dGD.getPageContext().getPageActivity(), Integer.parseInt(ml.getFriendId()), ml.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (ml.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.dGD.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(ml);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ().eb(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(b.this.dGD.getPageContext().getPageActivity())));
                        }
                    } else if (ml.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                        if (a.a((BaseFragmentActivity) b.this.dGD.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(ml);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ().ea(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(b.this.dGD.getPageContext().getPageActivity())));
                        }
                    } else if (ml.getOwnerName().equals("6")) {
                        if (a.a((BaseFragmentActivity) b.this.dGD.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                            d(ml);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ().ek(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(b.this.dGD.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.dGD.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(b.this.dGD.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (a.a((BaseFragmentActivity) b.this.dGD.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(b.this.dGD.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(ml.getFriendId(), 0L), ml.getFriendName(), ml.getFriendPortrait(), 0, ml.getUserType())));
                        }
                    } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(b.this.dGD.getPageContext().getPageActivity())));
                    } else {
                        e(ml);
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
                            com.baidu.tieba.im.db.d.auX().lZ("apply_join_group");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            com.baidu.tieba.im.db.d.auX().lZ("group_intro_change");
                            com.baidu.tieba.im.db.d.auX().lZ("group_name_change");
                            com.baidu.tieba.im.db.d.auX().lZ("group_notice_change");
                            com.baidu.tieba.im.db.d.auX().lZ("group_level_up");
                            com.baidu.tieba.im.db.d.auX().lZ("dismiss_group");
                            com.baidu.tieba.im.db.d.auX().lZ("kick_out");
                            com.baidu.tieba.im.db.d.auX().lZ("group_activitys_change");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                            com.baidu.tieba.im.db.d.auX().lZ("live_notify");
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
                com.baidu.tbadk.coreExtra.messageCenter.a.yv().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.yv().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                imMessageCenterShowItemData.setUnReadCount(0);
            }
            try {
                long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                TiebaStatic.log("tab_msg_personal_chat_click");
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(b.this.dGD.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener dGO = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.dGE = b.this.dGG.getItem(i);
            b.this.c(b.this.dGE);
            if (b.this.dGJ != null) {
                b.this.dGJ.te();
            }
            return true;
        }
    };
    private final g.b bbF = new g.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefresh(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener dpq = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.10
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
                    b.this.dGC.setData(null, b.this.dps);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.dGG != null) {
                        b.this.dGG.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.dGG != null) {
                    b.this.dGG.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a dps = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.2
        @Override // com.baidu.tieba.im.chat.a.a
        public void atd() {
            if (b.this.dGF != null && b.this.dGC != null) {
                b.this.dGF.completePullRefreshPostDelayed(2000L);
                b.this.dGG.setData(b.this.dGC.getData());
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
        this.dGL = 3;
        this.dGD = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.j.chat_list_activity, viewGroup, false);
        an(inflate);
        TiebaStatic.eventStat(this.dGD.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dpq);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dpq);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dpq);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dpq);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dpq);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dpq);
        registerListener(this.baz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dGG != null) {
            this.dGG.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dGD.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.dpq);
    }

    private void initData() {
        this.dGC = new ImMessageCenterModel();
        gO(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void an(View view) {
        this.cmV = (RelativeLayout) view.findViewById(d.h.chat_list);
        this.dGI = (ShutDownValidateTipView) view.findViewById(d.h.view_no_validate);
        this.dGI.setVisibility(8);
        this.dGI.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.gO(false);
                b.this.gM(false);
            }
        });
        this.dGF = (BdListView) view.findViewById(d.h.chat_list_content);
        this.dGF.setDividerHeight(0);
        this.dGH = new d(getPageContext());
        this.dGH.a(this.bbF);
        this.dGH.setTag(getUniqueId());
        this.dGF.setPullRefresh(this.dGH);
        this.dGG = new ImMessageCenterListAdapter(this.dGD.getPageContext().getPageActivity());
        this.dGF.setAdapter((ListAdapter) this.dGG);
        this.dGF.setOnItemClickListener(this.dGN);
        this.dGF.setOnItemLongClickListener(this.dGO);
        this.dGF.startPullRefresh();
        this.bfM = (NoNetworkView) this.cmV.findViewById(d.h.view_no_network);
        if (!this.mIsLogin) {
            gN(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dGL != i) {
            this.dGL = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dGD.getPageContext(), i);
            }
            if (this.dGI != null) {
                this.dGI.onChangeSkinType(i);
            }
            if (this.dGH != null) {
                this.dGH.dy(i);
            }
            if (this.dGG != null) {
                this.dGG.notifyDataSetChanged();
            }
            if (this.dGD != null && (this.dGD instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dGD).getLayoutMode().ah(i == 1);
                ((BaseFragmentActivity) this.dGD).getLayoutMode().t(this.cmV);
            }
            if (this.bfM != null) {
                this.bfM.onChangeSkinType(this.dGD.getPageContext(), i);
            }
        }
    }

    private void azH() {
        if (isAdded()) {
            if (this.mIsLogin) {
                azI();
            } else {
                azJ();
            }
        }
    }

    private void azI() {
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
        this.mNoDataView = NoDataViewFactory.a(this.dGD.getPageContext().getPageActivity(), this.cmV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dp(d.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void azJ() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.l.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.dGD.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aS(b.this.dGD.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.f.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.f.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dGD.getPageContext().getPageActivity(), this.cmV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        azH();
        if (!z) {
            gN(true);
        } else {
            gN(false);
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
        this.dGK = new b.InterfaceC0047b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.dGC.deleteItem(imMessageCenterShowItemData, b.this.dps);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dGD.getPageContext().getPageActivity().getString(d.l.delete_user_chat);
        this.dGJ = new com.baidu.tbadk.core.dialog.b(this.dGD.getPageContext().getPageActivity());
        this.dGJ.cf(d.l.operation);
        this.dGJ.a(new String[]{string}, this.dGK);
        this.dGJ.d(this.dGD.getPageContext());
    }

    public void gM(boolean z) {
        if (z) {
            if (azK() && this.dGI.getVisibility() != 0) {
                this.dGI.setVisibility(0);
            }
        } else if (this.dGI.getVisibility() != 8) {
            this.dGI.setVisibility(8);
        }
    }

    public void gN(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                azH();
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

    public boolean azK() {
        return this.dGM;
    }

    public void gO(boolean z) {
        this.dGM = z;
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
                if (this.dGC != null) {
                    this.dGC.insertOrUpdate(data, this.dps);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dGC != null) {
                this.dGC.remove(data, this.dps);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dGC != null) {
                this.dGC.setData(data, this.dps);
            }
        }
    }
}
