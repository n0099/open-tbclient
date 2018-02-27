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
    private NoNetworkView caX;
    private RelativeLayout dAR;
    private ShutDownValidateTipView ePB;
    private b.InterfaceC0097b ePD;
    private int ePE;
    private com.baidu.tbadk.core.dialog.d eys;
    private h mNoDataView;
    private ImMessageCenterModel ePv = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> ePw = null;
    private ImMessageCenterShowItemData ePx = null;
    private BdListView ePy = null;
    private ImMessageCenterListAdapter ePz = null;
    private d ePA = null;
    com.baidu.tbadk.core.dialog.b ePC = null;
    private boolean ePF = true;
    private final AdapterView.OnItemClickListener Qw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData pJ = b.this.ePz.getItem(i);
                TiebaStatic.eventStat(b.this.ePw.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (pJ != null) {
                    String ownerName = pJ.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(pJ);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.ePw.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.ePw.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            b.this.sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(b.this.ePw.getPageContext().getPageActivity(), Integer.parseInt(pJ.getFriendId()), pJ.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (pJ.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.ePw.getPageContext().getOrignalPage(), 2008021)) {
                            d(pJ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.GI().He() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.GI().He().ha(0);
                            }
                            b.this.sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(b.this.ePw.getPageContext().getPageActivity())));
                        }
                    } else if (pJ.getOwnerName().equals("3")) {
                        if (a.a((BaseFragmentActivity) b.this.ePw.getPageContext().getOrignalPage(), 2008013)) {
                            d(pJ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.GI().He() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.GI().He().gZ(0);
                            }
                            b.this.sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(b.this.ePw.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.ePw.getPageContext().getOrignalPage(), 2008022)) {
                            b.this.sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(b.this.ePw.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (a.a((BaseFragmentActivity) b.this.ePw.getPageContext().getOrignalPage(), 2002006)) {
                            b.this.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(b.this.ePw.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(pJ.getFriendId(), 0L), pJ.getFriendName(), pJ.getFriendPortrait(), 0, pJ.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ak("c12614"));
                        b.this.sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(b.this.ePw.getPageContext().getPageActivity())));
                    } else {
                        e(pJ);
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
                            com.baidu.tieba.im.db.d.aHZ().nh("apply_join_group");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                            com.baidu.tieba.im.db.d.aHZ().nh("group_intro_change");
                            com.baidu.tieba.im.db.d.aHZ().nh("group_name_change");
                            com.baidu.tieba.im.db.d.aHZ().nh("group_notice_change");
                            com.baidu.tieba.im.db.d.aHZ().nh("group_level_up");
                            com.baidu.tieba.im.db.d.aHZ().nh("dismiss_group");
                            com.baidu.tieba.im.db.d.aHZ().nh("kick_out");
                            com.baidu.tieba.im.db.d.aHZ().nh("group_activitys_change");
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
                com.baidu.tbadk.coreExtra.messageCenter.a.GI().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.GI().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                imMessageCenterShowItemData.setUnReadCount(0);
            }
            try {
                long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                TiebaStatic.log("tab_msg_personal_chat_click");
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                b.this.sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(b.this.ePw.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener ePG = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.ePx = b.this.ePz.getItem(i);
            b.this.c(b.this.ePx);
            if (b.this.ePC != null) {
                b.this.ePC.AX();
            }
            return true;
        }
    };
    private final j.b bVa = new j.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
        @Override // com.baidu.tbadk.core.view.j.b
        public void bw(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener eyt = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
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
                    b.this.ePv.setData(null, b.this.eyv);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.ePz != null) {
                        b.this.ePz.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.ePz != null) {
                    b.this.ePz.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a eyv = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.10
        @Override // com.baidu.tieba.im.chat.a.a
        public void aGc() {
            b.this.aGr();
        }
    };
    private final com.baidu.tieba.im.chat.a.b eyw = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.2
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            b.this.aGq();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (b.this.eys != null) {
                b.this.eys.setPercent(i);
            }
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            b.this.abj();
            b.this.showToast(d.j.delete_success, false);
            b.this.aGr();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            b.this.abj();
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ePE = 3;
        this.ePw = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.h.chat_list_activity, viewGroup, false);
        bI(inflate);
        TiebaStatic.eventStat(this.ePw.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(2016004, this.eyt);
        registerListener(2016001, this.eyt);
        registerListener(2016010, this.eyt);
        registerListener(2016007, this.eyt);
        registerListener(2016011, this.eyt);
        registerListener(2016002, this.eyt);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ePz != null) {
            this.ePz.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        abj();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.ePw.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.eyt);
    }

    private void initData() {
        this.ePv = new ImMessageCenterModel();
        ia(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bI(View view) {
        this.dAR = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.ePB = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.ePB.setVisibility(8);
        this.ePB.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.ia(false);
                b.this.hY(false);
            }
        });
        this.ePy = (BdListView) view.findViewById(d.g.chat_list_content);
        this.ePy.setDividerHeight(0);
        this.ePA = new d(getPageContext());
        this.ePA.a(this.bVa);
        this.ePA.setTag(getUniqueId());
        this.ePy.setPullRefresh(this.ePA);
        this.ePz = new ImMessageCenterListAdapter(this.ePw.getPageContext().getPageActivity());
        this.ePy.setAdapter((ListAdapter) this.ePz);
        this.ePy.setOnItemClickListener(this.Qw);
        this.ePy.setOnItemLongClickListener(this.ePG);
        this.ePy.startPullRefresh();
        this.caX = (NoNetworkView) this.dAR.findViewById(d.g.view_no_network);
        if (!this.mIsLogin) {
            hZ(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.ePE != i) {
            this.ePE = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.ePw.getPageContext(), i);
            }
            if (this.ePB != null) {
                this.ePB.onChangeSkinType(i);
            }
            if (this.ePA != null) {
                this.ePA.gx(i);
            }
            if (this.ePz != null) {
                this.ePz.notifyDataSetChanged();
            }
            if (this.ePw != null && (this.ePw instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.ePw).getLayoutMode().aQ(i == 1);
                ((BaseFragmentActivity) this.ePw).getLayoutMode().aM(this.dAR);
            }
            if (this.caX != null) {
                this.caX.onChangeSkinType(this.ePw.getPageContext(), i);
            }
        }
    }

    private void aMB() {
        if (isAdded()) {
            if (this.mIsLogin) {
                aMC();
            } else {
                aMD();
            }
        }
    }

    private void aMC() {
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
        this.mNoDataView = NoDataViewFactory.a(this.ePw.getPageContext().getPageActivity(), this.dAR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aMD() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.ePw.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ay.aZ(b.this.ePw.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.ePw.getPageContext().getPageActivity(), this.dAR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aB(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aMB();
        if (!z) {
            hZ(true);
        } else {
            hZ(false);
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
        this.ePD = new b.InterfaceC0097b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.ePv.asyncDeleteItem(imMessageCenterShowItemData, b.this.eyw);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.ePw.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.ePC = new com.baidu.tbadk.core.dialog.b(this.ePw.getPageContext().getPageActivity());
        this.ePC.fe(d.j.operation);
        this.ePC.a(new String[]{string}, this.ePD);
        this.ePC.d(this.ePw.getPageContext());
    }

    public void hY(boolean z) {
        if (z) {
            if (aME() && this.ePB.getVisibility() != 0) {
                this.ePB.setVisibility(0);
            }
        } else if (this.ePB.getVisibility() != 8) {
            this.ePB.setVisibility(8);
        }
    }

    public void hZ(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                aMB();
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

    public boolean aME() {
        return this.ePF;
    }

    public void ia(boolean z) {
        this.ePF = z;
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
                if (this.ePv != null) {
                    this.ePv.insertOrUpdate(data, this.eyv);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.ePv != null) {
                this.ePv.remove(data, this.eyv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.ePv != null) {
                this.ePv.setData(data, this.eyv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGq() {
        abj();
        if (this.eys == null) {
            this.eys = e.aIa().bL(getPageContext().getPageActivity());
        }
        this.eys.show();
        this.eys.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abj() {
        if (this.eys != null && this.eys.isShowing()) {
            this.eys.dismiss();
            this.eys = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGr() {
        if (this.ePy != null && this.ePv != null) {
            this.ePy.completePullRefreshPostDelayed(2000L);
            this.ePz.setData(this.ePv.getData());
        }
    }
}
