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
    private NoNetworkView ber;
    private RelativeLayout cgz;
    private ShutDownValidateTipView dDi;
    private b.InterfaceC0043b dDk;
    private int dDl;
    private j mNoDataView;
    private ImMessageCenterModel dDc = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dDd = null;
    private ImMessageCenterShowItemData dDe = null;
    private BdListView dDf = null;
    private ImMessageCenterListAdapter dDg = null;
    private d dDh = null;
    com.baidu.tbadk.core.dialog.b dDj = null;
    private boolean dDm = true;
    private final CustomMessageListener aZq = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.dDg != null) {
                b.this.dDg.notifyDataSetChanged();
            }
        }
    };
    private final AdapterView.OnItemClickListener dDn = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData lW = b.this.dDg.getItem(i);
                TiebaStatic.eventStat(b.this.dDd.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (lW != null) {
                    String ownerName = lW.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(lW);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.dDd.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.dDd.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(b.this.dDd.getPageContext().getPageActivity(), Integer.parseInt(lW.getFriendId()), lW.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (lW.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.dDd.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(lW);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu().dR(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(b.this.dDd.getPageContext().getPageActivity())));
                        }
                    } else if (lW.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                        if (a.a((BaseFragmentActivity) b.this.dDd.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(lW);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu().dQ(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(b.this.dDd.getPageContext().getPageActivity())));
                        }
                    } else if (lW.getOwnerName().equals("6")) {
                        if (a.a((BaseFragmentActivity) b.this.dDd.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                            d(lW);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu().ea(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(b.this.dDd.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.dDd.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(b.this.dDd.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (a.a((BaseFragmentActivity) b.this.dDd.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(b.this.dDd.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(lW.getFriendId(), 0L), lW.getFriendName(), lW.getFriendPortrait(), 0, lW.getUserType())));
                        }
                    } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(b.this.dDd.getPageContext().getPageActivity())));
                    } else {
                        e(lW);
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
                            com.baidu.tieba.im.db.d.auz().lY("apply_join_group");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            com.baidu.tieba.im.db.d.auz().lY("group_intro_change");
                            com.baidu.tieba.im.db.d.auz().lY("group_name_change");
                            com.baidu.tieba.im.db.d.auz().lY("group_notice_change");
                            com.baidu.tieba.im.db.d.auz().lY("group_level_up");
                            com.baidu.tieba.im.db.d.auz().lY("dismiss_group");
                            com.baidu.tieba.im.db.d.auz().lY("kick_out");
                            com.baidu.tieba.im.db.d.auz().lY("group_activitys_change");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                            com.baidu.tieba.im.db.d.auz().lY("live_notify");
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(b.this.dDd.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener dDo = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.dDe = b.this.dDg.getItem(i);
            b.this.c(b.this.dDe);
            if (b.this.dDj != null) {
                b.this.dDj.tu();
            }
            return true;
        }
    };
    private final k.b bax = new k.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener dlO = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.10
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
                    b.this.dDc.setData(null, b.this.dlQ);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.dDg != null) {
                        b.this.dDg.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.dDg != null) {
                    b.this.dDg.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a dlQ = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.2
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            if (b.this.dDf != null && b.this.dDc != null) {
                b.this.dDf.completePullRefreshPostDelayed(2000L);
                b.this.dDg.setData(b.this.dDc.getData());
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
        this.dDl = 3;
        this.dDd = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.j.chat_list_activity, viewGroup, false);
        ah(inflate);
        TiebaStatic.eventStat(this.dDd.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dlO);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dlO);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dlO);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dlO);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dlO);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dlO);
        registerListener(this.aZq);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dDg != null) {
            this.dDg.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dDd.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.dlO);
    }

    private void initData() {
        this.dDc = new ImMessageCenterModel();
        gT(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void ah(View view) {
        this.cgz = (RelativeLayout) view.findViewById(d.h.chat_list);
        this.dDi = (ShutDownValidateTipView) view.findViewById(d.h.view_no_validate);
        this.dDi.setVisibility(8);
        this.dDi.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.gT(false);
                b.this.gR(false);
            }
        });
        this.dDf = (BdListView) view.findViewById(d.h.chat_list_content);
        this.dDf.setDividerHeight(0);
        this.dDh = new d(getPageContext());
        this.dDh.a(this.bax);
        this.dDh.setTag(getUniqueId());
        this.dDf.setPullRefresh(this.dDh);
        this.dDg = new ImMessageCenterListAdapter(this.dDd.getPageContext().getPageActivity());
        this.dDf.setAdapter((ListAdapter) this.dDg);
        this.dDf.setOnItemClickListener(this.dDn);
        this.dDf.setOnItemLongClickListener(this.dDo);
        this.dDf.startPullRefresh();
        this.ber = (NoNetworkView) this.cgz.findViewById(d.h.view_no_network);
        if (!this.mIsLogin) {
            gS(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dDl != i) {
            this.dDl = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dDd.getPageContext(), i);
            }
            if (this.dDi != null) {
                this.dDi.onChangeSkinType(i);
            }
            if (this.dDh != null) {
                this.dDh.dp(i);
            }
            if (this.dDg != null) {
                this.dDg.notifyDataSetChanged();
            }
            if (this.dDd != null && (this.dDd instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dDd).getLayoutMode().ah(i == 1);
                ((BaseFragmentActivity) this.dDd).getLayoutMode().t(this.cgz);
            }
            if (this.ber != null) {
                this.ber.onChangeSkinType(this.dDd.getPageContext(), i);
            }
        }
    }

    private void azg() {
        if (isAdded()) {
            if (this.mIsLogin) {
                azh();
            } else {
                azi();
            }
        }
    }

    private void azh() {
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
        this.mNoDataView = NoDataViewFactory.a(this.dDd.getPageContext().getPageActivity(), this.cgz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dk(d.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void azi() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.l.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.dDd.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                aw.aN(b.this.dDd.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.f.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.f.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dDd.getPageContext().getPageActivity(), this.cgz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(d.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        azg();
        if (!z) {
            gS(true);
        } else {
            gS(false);
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
        this.dDk = new b.InterfaceC0043b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.dDc.deleteItem(imMessageCenterShowItemData, b.this.dlQ);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dDd.getPageContext().getPageActivity().getString(d.l.delete_user_chat);
        this.dDj = new com.baidu.tbadk.core.dialog.b(this.dDd.getPageContext().getPageActivity());
        this.dDj.cf(d.l.operation);
        this.dDj.a(new String[]{string}, this.dDk);
        this.dDj.d(this.dDd.getPageContext());
    }

    public void gR(boolean z) {
        if (z) {
            if (azj() && this.dDi.getVisibility() != 0) {
                this.dDi.setVisibility(0);
            }
        } else if (this.dDi.getVisibility() != 8) {
            this.dDi.setVisibility(8);
        }
    }

    public void gS(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                azg();
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

    public boolean azj() {
        return this.dDm;
    }

    public void gT(boolean z) {
        this.dDm = z;
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
                if (this.dDc != null) {
                    this.dDc.insertOrUpdate(data, this.dlQ);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dDc != null) {
                this.dDc.remove(data, this.dlQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dDc != null) {
                this.dDc.setData(data, this.dlQ);
            }
        }
    }
}
