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
    private NoNetworkView bep;
    private RelativeLayout clR;
    private ShutDownValidateTipView dJM;
    private b.InterfaceC0047b dJO;
    private int dJP;
    private j mNoDataView;
    private ImMessageCenterModel dJG = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dJH = null;
    private ImMessageCenterShowItemData dJI = null;
    private BdListView dJJ = null;
    private ImMessageCenterListAdapter dJK = null;
    private d dJL = null;
    com.baidu.tbadk.core.dialog.b dJN = null;
    private boolean dJQ = true;
    private final CustomMessageListener aZd = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.dJK != null) {
                b.this.dJK.notifyDataSetChanged();
            }
        }
    };
    private final AdapterView.OnItemClickListener dJR = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData mo = b.this.dJK.getItem(i);
                TiebaStatic.eventStat(b.this.dJH.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (mo != null) {
                    String ownerName = mo.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(mo);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.dJH.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.dJH.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(b.this.dJH.getPageContext().getPageActivity(), Integer.parseInt(mo.getFriendId()), mo.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (mo.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.dJH.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(mo);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy().dS(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(b.this.dJH.getPageContext().getPageActivity())));
                        }
                    } else if (mo.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                        if (a.a((BaseFragmentActivity) b.this.dJH.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(mo);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy().dR(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(b.this.dJH.getPageContext().getPageActivity())));
                        }
                    } else if (mo.getOwnerName().equals("6")) {
                        if (a.a((BaseFragmentActivity) b.this.dJH.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                            d(mo);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.zd().zy().eb(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(b.this.dJH.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.dJH.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(b.this.dJH.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (a.a((BaseFragmentActivity) b.this.dJH.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(b.this.dJH.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(mo.getFriendId(), 0L), mo.getFriendName(), mo.getFriendPortrait(), 0, mo.getUserType())));
                        }
                    } else if (ownerName.equals(NewWriteModel.THREAD_TYPE_LBS)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(b.this.dJH.getPageContext().getPageActivity())));
                    } else {
                        e(mo);
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
                            com.baidu.tieba.im.db.d.awg().mu("apply_join_group");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            com.baidu.tieba.im.db.d.awg().mu("group_intro_change");
                            com.baidu.tieba.im.db.d.awg().mu("group_name_change");
                            com.baidu.tieba.im.db.d.awg().mu("group_notice_change");
                            com.baidu.tieba.im.db.d.awg().mu("group_level_up");
                            com.baidu.tieba.im.db.d.awg().mu("dismiss_group");
                            com.baidu.tieba.im.db.d.awg().mu("kick_out");
                            com.baidu.tieba.im.db.d.awg().mu("group_activitys_change");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                            com.baidu.tieba.im.db.d.awg().mu("live_notify");
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(b.this.dJH.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener dJS = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.dJI = b.this.dJK.getItem(i);
            b.this.c(b.this.dJI);
            if (b.this.dJN != null) {
                b.this.dJN.tr();
            }
            return true;
        }
    };
    private final k.b baj = new k.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
        @Override // com.baidu.tbadk.core.view.k.b
        public void onListPullRefresh(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener dss = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.10
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
                    b.this.dJG.setData(null, b.this.dsu);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.dJK != null) {
                        b.this.dJK.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.dJK != null) {
                    b.this.dJK.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a dsu = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.2
        @Override // com.baidu.tieba.im.chat.a.a
        public void aum() {
            if (b.this.dJJ != null && b.this.dJG != null) {
                b.this.dJJ.completePullRefreshPostDelayed(2000L);
                b.this.dJK.setData(b.this.dJG.getData());
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
        this.dJP = 3;
        this.dJH = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.j.chat_list_activity, viewGroup, false);
        ao(inflate);
        TiebaStatic.eventStat(this.dJH.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dss);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dss);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dss);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dss);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dss);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dss);
        registerListener(this.aZd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dJK != null) {
            this.dJK.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dJH.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.dss);
    }

    private void initData() {
        this.dJG = new ImMessageCenterModel();
        hb(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void ao(View view) {
        this.clR = (RelativeLayout) view.findViewById(d.h.chat_list);
        this.dJM = (ShutDownValidateTipView) view.findViewById(d.h.view_no_validate);
        this.dJM.setVisibility(8);
        this.dJM.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.hb(false);
                b.this.gZ(false);
            }
        });
        this.dJJ = (BdListView) view.findViewById(d.h.chat_list_content);
        this.dJJ.setDividerHeight(0);
        this.dJL = new d(getPageContext());
        this.dJL.a(this.baj);
        this.dJL.setTag(getUniqueId());
        this.dJJ.setPullRefresh(this.dJL);
        this.dJK = new ImMessageCenterListAdapter(this.dJH.getPageContext().getPageActivity());
        this.dJJ.setAdapter((ListAdapter) this.dJK);
        this.dJJ.setOnItemClickListener(this.dJR);
        this.dJJ.setOnItemLongClickListener(this.dJS);
        this.dJJ.startPullRefresh();
        this.bep = (NoNetworkView) this.clR.findViewById(d.h.view_no_network);
        if (!this.mIsLogin) {
            ha(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dJP != i) {
            this.dJP = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dJH.getPageContext(), i);
            }
            if (this.dJM != null) {
                this.dJM.onChangeSkinType(i);
            }
            if (this.dJL != null) {
                this.dJL.dq(i);
            }
            if (this.dJK != null) {
                this.dJK.notifyDataSetChanged();
            }
            if (this.dJH != null && (this.dJH instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dJH).getLayoutMode().ah(i == 1);
                ((BaseFragmentActivity) this.dJH).getLayoutMode().t(this.clR);
            }
            if (this.bep != null) {
                this.bep.onChangeSkinType(this.dJH.getPageContext(), i);
            }
        }
    }

    private void aAQ() {
        if (isAdded()) {
            if (this.mIsLogin) {
                aAR();
            } else {
                aAS();
            }
        }
    }

    private void aAR() {
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
        this.mNoDataView = NoDataViewFactory.a(this.dJH.getPageContext().getPageActivity(), this.clR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dl(d.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aAS() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.l.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.dJH.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aS(b.this.dJH.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.f.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.f.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dJH.getPageContext().getPageActivity(), this.clR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.A(d.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aAQ();
        if (!z) {
            ha(true);
        } else {
            ha(false);
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
        this.dJO = new b.InterfaceC0047b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.dJG.deleteItem(imMessageCenterShowItemData, b.this.dsu);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dJH.getPageContext().getPageActivity().getString(d.l.delete_user_chat);
        this.dJN = new com.baidu.tbadk.core.dialog.b(this.dJH.getPageContext().getPageActivity());
        this.dJN.cf(d.l.operation);
        this.dJN.a(new String[]{string}, this.dJO);
        this.dJN.d(this.dJH.getPageContext());
    }

    public void gZ(boolean z) {
        if (z) {
            if (aAT() && this.dJM.getVisibility() != 0) {
                this.dJM.setVisibility(0);
            }
        } else if (this.dJM.getVisibility() != 8) {
            this.dJM.setVisibility(8);
        }
    }

    public void ha(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                aAQ();
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

    public boolean aAT() {
        return this.dJQ;
    }

    public void hb(boolean z) {
        this.dJQ = z;
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
                if (this.dJG != null) {
                    this.dJG.insertOrUpdate(data, this.dsu);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dJG != null) {
                this.dJG.remove(data, this.dsu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dJG != null) {
                this.dJG.setData(data, this.dsu);
            }
        }
    }
}
