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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
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
    private NoNetworkView blu;
    private RelativeLayout cDX;
    private ShutDownValidateTipView dXv;
    private b.InterfaceC0061b dXx;
    private int dXy;
    private g mNoDataView;
    private ImMessageCenterModel dXp = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dXq = null;
    private ImMessageCenterShowItemData dXr = null;
    private BdListView dXs = null;
    private ImMessageCenterListAdapter dXt = null;
    private d dXu = null;
    com.baidu.tbadk.core.dialog.b dXw = null;
    private boolean dXz = true;
    private final CustomMessageListener beA = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.dXt != null) {
                b.this.dXt.notifyDataSetChanged();
            }
        }
    };
    private final AdapterView.OnItemClickListener dXA = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData mX = b.this.dXt.getItem(i);
                TiebaStatic.eventStat(b.this.dXq.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (mX != null) {
                    String ownerName = mX.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(mX);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.dXq.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.dXq.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(b.this.dXq.getPageContext().getPageActivity(), Integer.parseInt(mX.getFriendId()), mX.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (mX.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.dXq.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(mX);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi().ec(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(b.this.dXq.getPageContext().getPageActivity())));
                        }
                    } else if (mX.getOwnerName().equals("3")) {
                        if (a.a((BaseFragmentActivity) b.this.dXq.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(mX);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi().eb(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(b.this.dXq.getPageContext().getPageActivity())));
                        }
                    } else if (mX.getOwnerName().equals("6")) {
                        if (a.a((BaseFragmentActivity) b.this.dXq.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                            d(mX);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi().el(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(b.this.dXq.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.dXq.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(b.this.dXq.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (a.a((BaseFragmentActivity) b.this.dXq.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(b.this.dXq.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(mX.getFriendId(), 0L), mX.getFriendName(), mX.getFriendPortrait(), 0, mX.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ak("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(b.this.dXq.getPageContext().getPageActivity())));
                    } else {
                        e(mX);
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
                            com.baidu.tieba.im.db.d.azr().mG("apply_join_group");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                            com.baidu.tieba.im.db.d.azr().mG("group_intro_change");
                            com.baidu.tieba.im.db.d.azr().mG("group_name_change");
                            com.baidu.tieba.im.db.d.azr().mG("group_notice_change");
                            com.baidu.tieba.im.db.d.azr().mG("group_level_up");
                            com.baidu.tieba.im.db.d.azr().mG("dismiss_group");
                            com.baidu.tieba.im.db.d.azr().mG("kick_out");
                            com.baidu.tieba.im.db.d.azr().mG("group_activitys_change");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                            com.baidu.tieba.im.db.d.azr().mG("live_notify");
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
                com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                imMessageCenterShowItemData.setUnReadCount(0);
            }
            try {
                long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                TiebaStatic.log("tab_msg_personal_chat_click");
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(b.this.dXq.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener dXB = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.dXr = b.this.dXt.getItem(i);
            b.this.c(b.this.dXr);
            if (b.this.dXw != null) {
                b.this.dXw.tl();
            }
            return true;
        }
    };
    private final h.b bfH = new h.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
        @Override // com.baidu.tbadk.core.view.h.b
        public void onListPullRefresh(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener dGr = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016002) {
                    b.this.f(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    b.this.g(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    b.this.h(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    b.this.dXp.setData(null, b.this.dGt);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.dXt != null) {
                        b.this.dXt.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.dXt != null) {
                    b.this.dXt.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a dGt = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.2
        @Override // com.baidu.tieba.im.chat.a.a
        public void axx() {
            if (b.this.dXs != null && b.this.dXp != null) {
                b.this.dXs.completePullRefreshPostDelayed(2000L);
                b.this.dXt.setData(b.this.dXp.getData());
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
        this.dXy = 3;
        this.dXq = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.h.chat_list_activity, viewGroup, false);
        au(inflate);
        TiebaStatic.eventStat(this.dXq.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dGr);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dGr);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dGr);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dGr);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dGr);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dGr);
        registerListener(this.beA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dXt != null) {
            this.dXt.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dXq.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.dGr);
    }

    private void initData() {
        this.dXp = new ImMessageCenterModel();
        hl(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void au(View view) {
        this.cDX = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.dXv = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.dXv.setVisibility(8);
        this.dXv.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.hl(false);
                b.this.hj(false);
            }
        });
        this.dXs = (BdListView) view.findViewById(d.g.chat_list_content);
        this.dXs.setDividerHeight(0);
        this.dXu = new d(getPageContext());
        this.dXu.a(this.bfH);
        this.dXu.setTag(getUniqueId());
        this.dXs.setPullRefresh(this.dXu);
        this.dXt = new ImMessageCenterListAdapter(this.dXq.getPageContext().getPageActivity());
        this.dXs.setAdapter((ListAdapter) this.dXt);
        this.dXs.setOnItemClickListener(this.dXA);
        this.dXs.setOnItemLongClickListener(this.dXB);
        this.dXs.startPullRefresh();
        this.blu = (NoNetworkView) this.cDX.findViewById(d.g.view_no_network);
        if (!this.mIsLogin) {
            hk(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dXy != i) {
            this.dXy = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dXq.getPageContext(), i);
            }
            if (this.dXv != null) {
                this.dXv.onChangeSkinType(i);
            }
            if (this.dXu != null) {
                this.dXu.dz(i);
            }
            if (this.dXt != null) {
                this.dXt.notifyDataSetChanged();
            }
            if (this.dXq != null && (this.dXq instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dXq).getLayoutMode().ag(i == 1);
                ((BaseFragmentActivity) this.dXq).getLayoutMode().t(this.cDX);
            }
            if (this.blu != null) {
                this.blu.onChangeSkinType(this.dXq.getPageContext(), i);
            }
        }
    }

    private void aDO() {
        if (isAdded()) {
            if (this.mIsLogin) {
                aDP();
            } else {
                aDQ();
            }
        }
    }

    private void aDP() {
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
        this.mNoDataView = NoDataViewFactory.a(this.dXq.getPageContext().getPageActivity(), this.cDX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dq(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aDQ() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.dXq.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aR(b.this.dXq.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dXq.getPageContext().getPageActivity(), this.cDX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aDO();
        if (!z) {
            hk(true);
        } else {
            hk(false);
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
        this.dXx = new b.InterfaceC0061b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.dXp.deleteItem(imMessageCenterShowItemData, b.this.dGt);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dXq.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.dXw = new com.baidu.tbadk.core.dialog.b(this.dXq.getPageContext().getPageActivity());
        this.dXw.cg(d.j.operation);
        this.dXw.a(new String[]{string}, this.dXx);
        this.dXw.d(this.dXq.getPageContext());
    }

    public void hj(boolean z) {
        if (z) {
            if (aDR() && this.dXv.getVisibility() != 0) {
                this.dXv.setVisibility(0);
            }
        } else if (this.dXv.getVisibility() != 8) {
            this.dXv.setVisibility(8);
        }
    }

    public void hk(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                aDO();
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

    public boolean aDR() {
        return this.dXz;
    }

    public void hl(boolean z) {
        this.dXz = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.dXp != null) {
                    this.dXp.insertOrUpdate(data, this.dGt);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dXp != null) {
                this.dXp.remove(data, this.dGt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dXp != null) {
                this.dXp.setData(data, this.dGt);
            }
        }
    }
}
