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
    private NoNetworkView bly;
    private RelativeLayout cEb;
    private b.InterfaceC0060b dXB;
    private int dXC;
    private ShutDownValidateTipView dXz;
    private g mNoDataView;
    private ImMessageCenterModel dXt = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dXu = null;
    private ImMessageCenterShowItemData dXv = null;
    private BdListView dXw = null;
    private ImMessageCenterListAdapter dXx = null;
    private d dXy = null;
    com.baidu.tbadk.core.dialog.b dXA = null;
    private boolean dXD = true;
    private final CustomMessageListener beE = new CustomMessageListener(CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && b.this.dXx != null) {
                b.this.dXx.notifyDataSetChanged();
            }
        }
    };
    private final AdapterView.OnItemClickListener dXE = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                ImMessageCenterShowItemData mX = b.this.dXx.getItem(i);
                TiebaStatic.eventStat(b.this.dXu.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (mX != null) {
                    String ownerName = mX.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(mX);
                    } else if (ownerName.equals("1")) {
                        if (a.a((BaseFragmentActivity) b.this.dXu.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(b.this.dXu.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(b.this.dXu.getPageContext().getPageActivity(), Integer.parseInt(mX.getFriendId()), mX.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (mX.getOwnerName().equals("2")) {
                        if (a.a((BaseFragmentActivity) b.this.dXu.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(mX);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi().ec(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(b.this.dXu.getPageContext().getPageActivity())));
                        }
                    } else if (mX.getOwnerName().equals("3")) {
                        if (a.a((BaseFragmentActivity) b.this.dXu.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(mX);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi().eb(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(b.this.dXu.getPageContext().getPageActivity())));
                        }
                    } else if (mX.getOwnerName().equals("6")) {
                        if (a.a((BaseFragmentActivity) b.this.dXu.getPageContext().getOrignalPage(), LiveNotifyActivityConfig.class)) {
                            d(mX);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi().el(0);
                            }
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveNotifyActivityConfig(b.this.dXu.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (a.a((BaseFragmentActivity) b.this.dXu.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(b.this.dXu.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (a.a((BaseFragmentActivity) b.this.dXu.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(b.this.dXu.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(mX.getFriendId(), 0L), mX.getFriendName(), mX.getFriendPortrait(), 0, mX.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ak("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(b.this.dXu.getPageContext().getPageActivity())));
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
                            com.baidu.tieba.im.db.d.azs().mG("apply_join_group");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                            com.baidu.tieba.im.db.d.azs().mG("group_intro_change");
                            com.baidu.tieba.im.db.d.azs().mG("group_name_change");
                            com.baidu.tieba.im.db.d.azs().mG("group_notice_change");
                            com.baidu.tieba.im.db.d.azs().mG("group_level_up");
                            com.baidu.tieba.im.db.d.azs().mG("dismiss_group");
                            com.baidu.tieba.im.db.d.azs().mG("kick_out");
                            com.baidu.tieba.im.db.d.azs().mG("group_activitys_change");
                        } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                            com.baidu.tieba.im.db.d.azs().mG("live_notify");
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(b.this.dXu.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private final AdapterView.OnItemLongClickListener dXF = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.7
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return false;
            }
            b.this.dXv = b.this.dXx.getItem(i);
            b.this.c(b.this.dXv);
            if (b.this.dXA != null) {
                b.this.dXA.tl();
            }
            return true;
        }
    };
    private final h.b bfL = new h.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.9
        @Override // com.baidu.tbadk.core.view.h.b
        public void onListPullRefresh(boolean z) {
            if (!z) {
                b.this.sendMessage(new RequestMemoryListMessage(1));
            }
        }
    };
    private final CustomMessageListener dGv = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.10
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
                    b.this.dXt.setData(null, b.this.dGx);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    if (b.this.dXx != null) {
                        b.this.dXx.notifyDataSetChanged();
                    }
                } else if (customResponsedMessage.getCmd() == 2016011 && b.this.dXx != null) {
                    b.this.dXx.notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a dGx = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.2
        @Override // com.baidu.tieba.im.chat.a.a
        public void axy() {
            if (b.this.dXw != null && b.this.dXt != null) {
                b.this.dXw.completePullRefreshPostDelayed(2000L);
                b.this.dXx.setData(b.this.dXt.getData());
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
        this.dXC = 3;
        this.dXu = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(d.h.chat_list_activity, viewGroup, false);
        au(inflate);
        TiebaStatic.eventStat(this.dXu.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dGv);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dGv);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dGv);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dGv);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dGv);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dGv);
        registerListener(this.beE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dXx != null) {
            this.dXx.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dXu.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.dGv);
    }

    private void initData() {
        this.dXt = new ImMessageCenterModel();
        hl(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void au(View view) {
        this.cEb = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.dXz = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.dXz.setVisibility(8);
        this.dXz.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                b.this.hl(false);
                b.this.hj(false);
            }
        });
        this.dXw = (BdListView) view.findViewById(d.g.chat_list_content);
        this.dXw.setDividerHeight(0);
        this.dXy = new d(getPageContext());
        this.dXy.a(this.bfL);
        this.dXy.setTag(getUniqueId());
        this.dXw.setPullRefresh(this.dXy);
        this.dXx = new ImMessageCenterListAdapter(this.dXu.getPageContext().getPageActivity());
        this.dXw.setAdapter((ListAdapter) this.dXx);
        this.dXw.setOnItemClickListener(this.dXE);
        this.dXw.setOnItemLongClickListener(this.dXF);
        this.dXw.startPullRefresh();
        this.bly = (NoNetworkView) this.cEb.findViewById(d.g.view_no_network);
        if (!this.mIsLogin) {
            hk(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dXC != i) {
            this.dXC = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dXu.getPageContext(), i);
            }
            if (this.dXz != null) {
                this.dXz.onChangeSkinType(i);
            }
            if (this.dXy != null) {
                this.dXy.dz(i);
            }
            if (this.dXx != null) {
                this.dXx.notifyDataSetChanged();
            }
            if (this.dXu != null && (this.dXu instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dXu).getLayoutMode().ag(i == 1);
                ((BaseFragmentActivity) this.dXu).getLayoutMode().t(this.cEb);
            }
            if (this.bly != null) {
                this.bly.onChangeSkinType(this.dXu.getPageContext(), i);
            }
        }
    }

    private void aDP() {
        if (isAdded()) {
            if (this.mIsLogin) {
                aDQ();
            } else {
                aDR();
            }
        }
    }

    private void aDQ() {
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
        this.mNoDataView = NoDataViewFactory.a(this.dXu.getPageContext().getPageActivity(), this.cEb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dq(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aDR() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(b.this.dXu.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ax.aR(b.this.dXu.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dXu.getPageContext().getPageActivity(), this.cEb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aDP();
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
        this.dXB = new b.InterfaceC0060b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.b.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        b.this.dXt.deleteItem(imMessageCenterShowItemData, b.this.dGx);
                        return;
                    default:
                        return;
                }
            }
        };
        String string = this.dXu.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.dXA = new com.baidu.tbadk.core.dialog.b(this.dXu.getPageContext().getPageActivity());
        this.dXA.cg(d.j.operation);
        this.dXA.a(new String[]{string}, this.dXB);
        this.dXA.d(this.dXu.getPageContext());
    }

    public void hj(boolean z) {
        if (z) {
            if (aDS() && this.dXz.getVisibility() != 0) {
                this.dXz.setVisibility(0);
            }
        } else if (this.dXz.getVisibility() != 8) {
            this.dXz.setVisibility(8);
        }
    }

    public void hk(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                aDP();
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

    public boolean aDS() {
        return this.dXD;
    }

    public void hl(boolean z) {
        this.dXD = z;
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
                if (this.dXt != null) {
                    this.dXt.insertOrUpdate(data, this.dGx);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dXt != null) {
                this.dXt.remove(data, this.dGx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dXt != null) {
                this.dXt.setData(data, this.dGx);
            }
        }
    }
}
