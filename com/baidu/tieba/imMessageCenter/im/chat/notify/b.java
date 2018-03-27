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
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarTipActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.UpdatesActivityConfig;
import com.baidu.tbadk.core.atomData.ValidateActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.e;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.tencent.connect.common.Constants;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseFragment {
    private NoNetworkView cba;
    private RelativeLayout dAU;
    private ShutDownValidateTipView ePQ;
    private b.InterfaceC0097b ePS;
    private int ePT;
    private com.baidu.tbadk.core.dialog.d eyI;
    private h mNoDataView;
    private ImMessageCenterModel ePK = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> ePL = null;
    private ImMessageCenterShowItemData ePM = null;
    private BdListView ePN = null;
    private ImMessageCenterListAdapter ePO = null;
    private d ePP = null;
    com.baidu.tbadk.core.dialog.b ePR = null;
    private boolean ePU = true;
    private final AdapterView.OnItemClickListener Qw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData pK = b.this.ePO.getItem(i);
                TiebaStatic.eventStat(b.this.ePL.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (pK != null) {
                    String ownerName = pK.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(pK);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.ePL.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.ePL.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            b.this.sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(b.this.ePL.getPageContext().getPageActivity(), Integer.parseInt(pK.getFriendId()), pK.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (pK.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.ePL.getPageContext().getOrignalPage(), 2008021)) {
                            d(pK);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.GJ().Hf() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().Hf().ha(0);
                            }
                            b.this.sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(b.this.ePL.getPageContext().getPageActivity())));
                        }
                    } else if (pK.getOwnerName().equals("3")) {
                        if (a.a((BaseFragmentActivity) b.this.ePL.getPageContext().getOrignalPage(), 2008013)) {
                            d(pK);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.GJ().Hf() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().Hf().gZ(0);
                            }
                            b.this.sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(b.this.ePL.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.ePL.getPageContext().getOrignalPage(), 2008022)) {
                            b.this.sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(b.this.ePL.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (a.a((BaseFragmentActivity) b.this.ePL.getPageContext().getOrignalPage(), 2002006)) {
                            b.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(b.this.ePL.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(pK.getFriendId(), 0L), pK.getFriendName(), pK.getFriendPortrait(), 0, pK.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ak("c12614"));
                        b.this.sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(b.this.ePL.getPageContext().getPageActivity())));
                    } else {
                        e(pK);
                    }
                }
            }
        }

        private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5.1
                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    if (customMessage != null && imMessageCenterShowItemData != null) {
                        imMessageCenterShowItemData.setUnReadCount(0);
                        if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                            com.baidu.tieba.im.db.d.aIa().nh("apply_join_group");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                            com.baidu.tieba.im.db.d.aIa().nh("group_intro_change");
                            com.baidu.tieba.im.db.d.aIa().nh("group_name_change");
                            com.baidu.tieba.im.db.d.aIa().nh("group_notice_change");
                            com.baidu.tieba.im.db.d.aIa().nh("group_level_up");
                            com.baidu.tieba.im.db.d.aIa().nh("dismiss_group");
                            com.baidu.tieba.im.db.d.aIa().nh("kick_out");
                            com.baidu.tieba.im.db.d.aIa().nh("group_activitys_change");
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
                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.GJ().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                imMessageCenterShowItemData.setUnReadCount(0);
            }
            try {
                long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                TiebaStatic.log("tab_msg_personal_chat_click");
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                b.this.sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(b.this.ePL.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener ePV = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.ePM = b.this.ePO.getItem(i);
            b.this.c(b.this.ePM);
            if (b.this.ePR != null) {
                b.this.ePR.AY();
            }
            return true;
        }
    };
    private final j.b bVd = new j.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
        @Override // com.baidu.tbadk.core.view.j.b
        public void bw(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener eyJ = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016002) {
                    b.this.c(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    b.this.e(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    b.this.d(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    b.this.ePK.setData(null, b.this.eyL);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.ePO != null) {
                        b.this.ePO.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.ePO != null) {
                    b.this.ePO.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a eyL = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.10
        @Override // com.baidu.tieba.im.chat.a.a
        public void aGd() {
            b.this.aGs();
        }
    };
    private final com.baidu.tieba.im.chat.a.b eyM = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.2
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            b.this.aGr();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (b.this.eyI != null) {
                b.this.eyI.setPercent(i);
            }
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            b.this.abk();
            b.this.showToast(d.j.delete_success, false);
            b.this.aGs();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            b.this.abk();
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ePT = 3;
        this.ePL = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.h.chat_list_activity, viewGroup, false);
        bI(inflate);
        TiebaStatic.eventStat(this.ePL.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(2016004, this.eyJ);
        registerListener(2016001, this.eyJ);
        registerListener(2016010, this.eyJ);
        registerListener(2016007, this.eyJ);
        registerListener(2016011, this.eyJ);
        registerListener(2016002, this.eyJ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ePO != null) {
            this.ePO.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        abk();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.ePL.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.eyJ);
    }

    private void initData() {
        this.ePK = new ImMessageCenterModel();
        m15if(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bI(View view) {
        this.dAU = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.ePQ = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.ePQ.setVisibility(8);
        this.ePQ.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.m15if(false);
                b.this.id(false);
            }
        });
        this.ePN = (BdListView) view.findViewById(d.g.chat_list_content);
        this.ePN.setDividerHeight(0);
        this.ePP = new d(getPageContext());
        this.ePP.a(this.bVd);
        this.ePP.setTag(getUniqueId());
        this.ePN.setPullRefresh(this.ePP);
        this.ePO = new ImMessageCenterListAdapter(this.ePL.getPageContext().getPageActivity());
        this.ePN.setAdapter((ListAdapter) this.ePO);
        this.ePN.setOnItemClickListener(this.Qw);
        this.ePN.setOnItemLongClickListener(this.ePV);
        this.ePN.startPullRefresh();
        this.cba = (NoNetworkView) this.dAU.findViewById(d.g.view_no_network);
        if (!this.mIsLogin) {
            ie(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.ePT != i) {
            this.ePT = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.ePL.getPageContext(), i);
            }
            if (this.ePQ != null) {
                this.ePQ.onChangeSkinType(i);
            }
            if (this.ePP != null) {
                this.ePP.gx(i);
            }
            if (this.ePO != null) {
                this.ePO.notifyDataSetChanged();
            }
            if (this.ePL != null && (this.ePL instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.ePL).getLayoutMode().aQ(i == 1);
                ((BaseFragmentActivity) this.ePL).getLayoutMode().aM(this.dAU);
            }
            if (this.cba != null) {
                this.cba.onChangeSkinType(this.ePL.getPageContext(), i);
            }
        }
    }

    private void aMC() {
        if (isAdded()) {
            if (this.mIsLogin) {
                aMD();
            } else {
                aME();
            }
        }
    }

    private void aMD() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.isLogin()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InviteFriendListActivityConfig((Context) b.this.getPageContext().getPageActivity(), true, true)));
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.ePL.getPageContext().getPageActivity(), this.dAU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aME() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.ePL.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ay.aZ(b.this.ePL.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.ePL.getPageContext().getPageActivity(), this.dAU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aB(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aMC();
        if (!z) {
            ie(true);
        } else {
            ie(false);
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
        this.ePS = new b.InterfaceC0097b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.ePK.asyncDeleteItem(imMessageCenterShowItemData, b.this.eyM);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.ePL.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.ePR = new com.baidu.tbadk.core.dialog.b(this.ePL.getPageContext().getPageActivity());
        this.ePR.fe(d.j.operation);
        this.ePR.a(new String[]{string}, this.ePS);
        this.ePR.d(this.ePL.getPageContext());
    }

    public void id(boolean z) {
        if (z) {
            if (aMF() && this.ePQ.getVisibility() != 0) {
                this.ePQ.setVisibility(0);
            }
        } else if (this.ePQ.getVisibility() != 8) {
            this.ePQ.setVisibility(8);
        }
    }

    public void ie(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                aMC();
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

    public boolean aMF() {
        return this.ePU;
    }

    /* renamed from: if  reason: not valid java name */
    public void m15if(boolean z) {
        this.ePU = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
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
                if (this.ePK != null) {
                    this.ePK.insertOrUpdate(data, this.eyL);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.ePK != null) {
                this.ePK.remove(data, this.eyL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.ePK != null) {
                this.ePK.setData(data, this.eyL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGr() {
        abk();
        if (this.eyI == null) {
            this.eyI = e.aIb().bL(getPageContext().getPageActivity());
        }
        this.eyI.show();
        this.eyI.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abk() {
        if (this.eyI != null && this.eyI.isShowing()) {
            this.eyI.dismiss();
            this.eyI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGs() {
        if (this.ePN != null && this.ePK != null) {
            this.ePN.completePullRefreshPostDelayed(2000L);
            this.ePO.setData(this.ePK.getData());
        }
    }
}
