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
    private NoNetworkView bem;
    private RelativeLayout cmK;
    private ShutDownValidateTipView dKH;
    private b.InterfaceC0046b dKJ;
    private int dKK;
    private j mNoDataView;
    private ImMessageCenterModel dKB = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dKC = null;
    private ImMessageCenterShowItemData dKD = null;
    private BdListView dKE = null;
    private ImMessageCenterListAdapter dKF = null;
    private d dKG = null;
    com.baidu.tbadk.core.dialog.b dKI = null;
    private boolean dKL = true;
    private final CustomMessageListener aZa = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.dKF != null) {
                b.this.dKF.notifyDataSetChanged();
            }
        }
    };
    private final AdapterView.OnItemClickListener dKM = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData mq = b.this.dKF.getItem(i);
                TiebaStatic.eventStat(b.this.dKC.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (mq != null) {
                    String ownerName = mq.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(mq);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.dKC.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.dKC.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(b.this.dKC.getPageContext().getPageActivity(), Integer.parseInt(mq.getFriendId()), mq.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (mq.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.dKC.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(mq);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy().dS(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(b.this.dKC.getPageContext().getPageActivity())));
                        }
                    } else if (mq.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                        if (a.a((BaseFragmentActivity) b.this.dKC.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(mq);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy().dR(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(b.this.dKC.getPageContext().getPageActivity())));
                        }
                    } else if (mq.getOwnerName().equals("6")) {
                        if (a.a((BaseFragmentActivity) b.this.dKC.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                            d(mq);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy().eb(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(b.this.dKC.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.dKC.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(b.this.dKC.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (a.a((BaseFragmentActivity) b.this.dKC.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(b.this.dKC.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(mq.getFriendId(), 0L), mq.getFriendName(), mq.getFriendPortrait(), 0, mq.getUserType())));
                        }
                    } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(b.this.dKC.getPageContext().getPageActivity())));
                    } else {
                        e(mq);
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
                            com.baidu.tieba.im.db.d.awr().mw("apply_join_group");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            com.baidu.tieba.im.db.d.awr().mw("group_intro_change");
                            com.baidu.tieba.im.db.d.awr().mw("group_name_change");
                            com.baidu.tieba.im.db.d.awr().mw("group_notice_change");
                            com.baidu.tieba.im.db.d.awr().mw("group_level_up");
                            com.baidu.tieba.im.db.d.awr().mw("dismiss_group");
                            com.baidu.tieba.im.db.d.awr().mw("kick_out");
                            com.baidu.tieba.im.db.d.awr().mw("group_activitys_change");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                            com.baidu.tieba.im.db.d.awr().mw("live_notify");
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
                com.baidu.tbadk.coreExtra.messageCenter.a.zd().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.zd().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                imMessageCenterShowItemData.setUnReadCount(0);
            }
            try {
                long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                TiebaStatic.log("tab_msg_personal_chat_click");
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(b.this.dKC.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener dKN = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.dKD = b.this.dKF.getItem(i);
            b.this.c(b.this.dKD);
            if (b.this.dKI != null) {
                b.this.dKI.tr();
            }
            return true;
        }
    };
    private final k.b bag = new k.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener dtn = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.10
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
                    b.this.dKB.setData(null, b.this.dtp);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.dKF != null) {
                        b.this.dKF.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.dKF != null) {
                    b.this.dKF.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a dtp = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.2
        @Override // com.baidu.tieba.im.chat.a.a
        public void aux() {
            if (b.this.dKE != null && b.this.dKB != null) {
                b.this.dKE.completePullRefreshPostDelayed(2000L);
                b.this.dKF.setData(b.this.dKB.getData());
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
        this.dKK = 3;
        this.dKC = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.j.chat_list_activity, viewGroup, false);
        ao(inflate);
        TiebaStatic.eventStat(this.dKC.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dtn);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dtn);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dtn);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dtn);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dtn);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dtn);
        registerListener(this.aZa);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dKF != null) {
            this.dKF.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dKC.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.dtn);
    }

    private void initData() {
        this.dKB = new ImMessageCenterModel();
        hc(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void ao(View view) {
        this.cmK = (RelativeLayout) view.findViewById(d.h.chat_list);
        this.dKH = (ShutDownValidateTipView) view.findViewById(d.h.view_no_validate);
        this.dKH.setVisibility(8);
        this.dKH.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.hc(false);
                b.this.ha(false);
            }
        });
        this.dKE = (BdListView) view.findViewById(d.h.chat_list_content);
        this.dKE.setDividerHeight(0);
        this.dKG = new d(getPageContext());
        this.dKG.a(this.bag);
        this.dKG.setTag(getUniqueId());
        this.dKE.setPullRefresh(this.dKG);
        this.dKF = new ImMessageCenterListAdapter(this.dKC.getPageContext().getPageActivity());
        this.dKE.setAdapter((ListAdapter) this.dKF);
        this.dKE.setOnItemClickListener(this.dKM);
        this.dKE.setOnItemLongClickListener(this.dKN);
        this.dKE.startPullRefresh();
        this.bem = (NoNetworkView) this.cmK.findViewById(d.h.view_no_network);
        if (!this.mIsLogin) {
            hb(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dKK != i) {
            this.dKK = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dKC.getPageContext(), i);
            }
            if (this.dKH != null) {
                this.dKH.onChangeSkinType(i);
            }
            if (this.dKG != null) {
                this.dKG.dq(i);
            }
            if (this.dKF != null) {
                this.dKF.notifyDataSetChanged();
            }
            if (this.dKC != null && (this.dKC instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dKC).getLayoutMode().ah(i == 1);
                ((BaseFragmentActivity) this.dKC).getLayoutMode().t(this.cmK);
            }
            if (this.bem != null) {
                this.bem.onChangeSkinType(this.dKC.getPageContext(), i);
            }
        }
    }

    private void aBb() {
        if (isAdded()) {
            if (this.mIsLogin) {
                aBc();
            } else {
                aBd();
            }
        }
    }

    private void aBc() {
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
        this.mNoDataView = NoDataViewFactory.a(this.dKC.getPageContext().getPageActivity(), this.cmK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dl(d.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aBd() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.l.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.dKC.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aT(b.this.dKC.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.f.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.f.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dKC.getPageContext().getPageActivity(), this.cmK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.A(d.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aBb();
        if (!z) {
            hb(true);
        } else {
            hb(false);
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
        this.dKJ = new b.InterfaceC0046b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.dKB.deleteItem(imMessageCenterShowItemData, b.this.dtp);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dKC.getPageContext().getPageActivity().getString(d.l.delete_user_chat);
        this.dKI = new com.baidu.tbadk.core.dialog.b(this.dKC.getPageContext().getPageActivity());
        this.dKI.cf(d.l.operation);
        this.dKI.a(new String[]{string}, this.dKJ);
        this.dKI.d(this.dKC.getPageContext());
    }

    public void ha(boolean z) {
        if (z) {
            if (aBe() && this.dKH.getVisibility() != 0) {
                this.dKH.setVisibility(0);
            }
        } else if (this.dKH.getVisibility() != 8) {
            this.dKH.setVisibility(8);
        }
    }

    public void hb(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                aBb();
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

    public boolean aBe() {
        return this.dKL;
    }

    public void hc(boolean z) {
        this.dKL = z;
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
                if (this.dKB != null) {
                    this.dKB.insertOrUpdate(data, this.dtp);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dKB != null) {
                this.dKB.remove(data, this.dtp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dKB != null) {
                this.dKB.setData(data, this.dtp);
            }
        }
    }
}
