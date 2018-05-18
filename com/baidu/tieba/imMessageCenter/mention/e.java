package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarTipActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.UpdatesActivityConfig;
import com.baidu.tbadk.core.atomData.ValidateActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.tencent.connect.common.Constants;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements e.b {
    private final CustomMessageListener auS;
    private RelativeLayout cUK;
    private boolean cfB;
    private com.baidu.tbadk.core.dialog.d dUp;
    private final CustomMessageListener dUq;
    private com.baidu.tieba.im.chat.a.a dUs;
    private final com.baidu.tieba.im.chat.a.b dUt;
    private final ChatAggregationFragment enU;
    private ImMessageCenterModel enV;
    private ImMessageCenterShowItemData enW;
    private BdListView enX;
    private MessageAggregationListAdapter enY;
    private ShutDownValidateTipView enZ;
    com.baidu.tbadk.core.dialog.b eoa;
    private b.InterfaceC0086b eob;
    private int eoc;
    private boolean eod;
    private boolean eoe;
    private boolean eog;
    private int eoh;
    private final AdapterView.OnItemLongClickListener eoi;
    private View mFooterView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ab(chatAggregationFragment.getPageContext().getPageActivity()));
        this.enV = null;
        this.enW = null;
        this.enX = null;
        this.enY = null;
        this.eoa = null;
        this.eod = true;
        this.eoe = false;
        this.cfB = false;
        this.eog = true;
        this.eoh = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData nh = e.this.enY.getItem(i);
                    TiebaStatic.eventStat(e.this.enU.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = nh.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(nh);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.enU.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.enU.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.enU.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(nh.getFriendId(), 0L), nh.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (nh.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.enU.getPageContext().getOrignalPage(), 2008021)) {
                            d(nh);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.zw().zS() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.zw().zS().dZ(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.enU.getPageContext().getPageActivity())));
                        }
                    } else if (nh.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.enU.getPageContext().getOrignalPage(), 2008013)) {
                            d(nh);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.zw().zS() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.zw().zS().dY(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.enU.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.enU.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.enU.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.enU.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.enU.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(nh.getFriendId(), 0L), nh.getFriendName(), nh.getFriendPortrait(), 0, nh.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new al("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.enU.getPageContext().getPageActivity())));
                    } else {
                        e(nh);
                    }
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.aCX().no("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aCX().no("group_intro_change");
                                com.baidu.tieba.im.db.d.aCX().no("group_name_change");
                                com.baidu.tieba.im.db.d.aCX().no("group_notice_change");
                                com.baidu.tieba.im.db.d.aCX().no("group_level_up");
                                com.baidu.tieba.im.db.d.aCX().no("dismiss_group");
                                com.baidu.tieba.im.db.d.aCX().no("kick_out");
                                com.baidu.tieba.im.db.d.aCX().no("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.zw().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.zw().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.enU.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.eoi = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
                e.this.enW = e.this.enY.getItem(i);
                e.this.c(e.this.enW);
                if (e.this.eoa != null) {
                    TiebaStatic.log("c12932");
                    e.this.eoa.tF();
                    if (e.this.enU != null && e.this.enU.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.enU.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.dUq = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2016002) {
                        e.this.c(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2016004) {
                        e.this.e(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2016007) {
                        e.this.d(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2016001) {
                        e.this.enV.setData(null, e.this.dUs);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.enY != null) {
                            e.this.enY.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.enY != null) {
                        e.this.enY.notifyDataSetChanged();
                    }
                }
            }
        };
        this.dUs = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void aBb() {
                e.this.aBq();
            }
        };
        this.auS = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.dUt = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.aBp();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.dUp != null) {
                    e.this.dUp.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.Vp();
                e.this.enU.showToast(d.k.delete_success, false);
                e.this.aBq();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.Vp();
            }
        };
        this.enU = chatAggregationFragment;
    }

    public void l(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eoh = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eoh = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eoh);
        }
    }

    public void asb() {
        if (this.enY != null) {
            this.enY.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dUq);
        MessageManager.getInstance().unRegisterListener(this.auS);
    }

    public View Rk() {
        this.eoc = 3;
        this.rootView = LayoutInflater.from(this.enU.getPageContext().getPageActivity()).inflate(d.i.chat_list_activity, (ViewGroup) null, false);
        initData();
        an(this.rootView);
        TiebaStatic.eventStat(this.enU.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        agN();
        return this.rootView;
    }

    protected void agN() {
        this.enX.startPullRefresh();
        this.eoe = isLogin();
        if (!this.eoe) {
            C(this.eoe, true);
        }
    }

    private void registerListener() {
        this.enU.registerListener(2016004, this.dUq);
        this.enU.registerListener(2016001, this.dUq);
        this.enU.registerListener(2016010, this.dUq);
        this.enU.registerListener(2016007, this.dUq);
        this.enU.registerListener(2016011, this.dUq);
        this.enU.registerListener(2016002, this.dUq);
        this.enU.registerListener(this.auS);
    }

    public void hJ(boolean z) {
        this.cfB = z;
    }

    public void hK(boolean z) {
        this.eog = z;
    }

    public void onPrimary() {
        if (this.enY != null && this.enY.getCount() == 0) {
            hJ(true);
        }
        if (this.eog || this.cfB) {
            this.eog = false;
            this.cfB = false;
            eE(false);
        }
        boolean isLogin = isLogin();
        if (this.eoe != isLogin) {
            this.eoe = isLogin;
            onUserChanged(this.eoe);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.enU.getPageContext());
        }
    }

    private void initData() {
        this.enV = new ImMessageCenterModel();
        hN(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void an(View view2) {
        this.cUK = (RelativeLayout) view2.findViewById(d.g.chat_list);
        this.enZ = (ShutDownValidateTipView) view2.findViewById(d.g.view_no_validate);
        this.enZ.setVisibility(8);
        this.enZ.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.hN(false);
                e.this.hM(false);
            }
        });
        this.enX = (BdListView) view2.findViewById(d.g.chat_list_content);
        this.enX.setDividerHeight(0);
        this.enY = new MessageAggregationListAdapter(this.enU.getPageContext().getPageActivity());
        this.enY.a(this);
        this.enX.setAdapter((ListAdapter) this.enY);
        this.enX.setOnItemClickListener(this.mItemClickListener);
        this.enX.setOnItemLongClickListener(this.eoi);
        this.mFooterView = new View(this.enU.getFragmentActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.enU.getFragmentActivity(), d.e.ds150)));
        this.enX.addFooterView(this.mFooterView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.enU.getPageContext(), i);
        }
        if (this.enZ != null) {
            this.enZ.onChangeSkinType(i);
        }
        if (this.enY != null) {
            this.enY.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().u(this.cUK);
            return true;
        }
        return true;
    }

    private void hL(boolean z) {
        if (z) {
            aIo();
        } else {
            aIp();
        }
    }

    private void aIo() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.eE().ak("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.enU.getResources().getString(d.k.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.isLogin() && e.this.mContext != null) {
                        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(e.this.mContext.getPageActivity(), 0, false);
                        atListActivityConfig.setIsForChat(true);
                        e.this.mContext.sendMessage(new CustomMessage(2002001, atListActivityConfig));
                        TiebaStatic.log("c12929");
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.enU.getPageContext().getPageActivity(), this.cUK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.enU.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dp(d.k.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aIp() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.enU.getResources().getString(d.k.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.eventStat(e.this.enU.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                az.aJ(e.this.enU.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.enU.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.enU.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.enU.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.enU.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.enU.getPageContext().getPageActivity(), this.cUK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(d.k.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.enU.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        C(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.eob = new b.InterfaceC0086b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.enV.asyncDeleteItem(imMessageCenterShowItemData, e.this.dUt);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.enU.getPageContext().getPageActivity().getString(d.k.delete_user_chat);
        this.eoa = new com.baidu.tbadk.core.dialog.b(this.enU.getPageContext().getPageActivity());
        this.eoa.cd(d.k.operation);
        this.eoa.a(new String[]{string}, this.eob);
        this.eoa.d(this.enU.getPageContext());
    }

    protected boolean eE(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.enX.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void hM(boolean z) {
        if (z) {
            if (aIq() && this.enZ.getVisibility() != 0) {
                this.enZ.setVisibility(0);
            }
        } else if (this.enZ.getVisibility() != 8) {
            this.enZ.setVisibility(8);
        }
    }

    public void C(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.enX.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.cUK.removeView(this.mNoDataView);
        }
        hL(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.enX.setVisibility(8);
    }

    public boolean aIq() {
        return this.eod;
    }

    public void hN(boolean z) {
        this.eod = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.enV != null) {
                    this.enV.insertOrUpdate(data, this.dUs);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.enV != null) {
                this.enV.remove(data, this.dUs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.enV != null) {
                this.enV.setData(data, this.dUs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eoh = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eoh != -1) {
                hJ(true);
                onPrimary();
            }
        }
    }

    public void hI(boolean z) {
        if (z && this.enX != null && this.enX.getWrappedAdapter() != null && this.enX.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.enX.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.e.b
    public void aO(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                aIr();
            }
        }
    }

    private void aIr() {
        if (this.enY != null) {
            this.enY.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBp() {
        Vp();
        if (this.dUp == null) {
            this.dUp = com.baidu.tieba.im.db.e.aCY().bz(getPageContext().getPageActivity());
        }
        this.dUp.show();
        this.dUp.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vp() {
        if (this.dUp != null && this.dUp.isShowing()) {
            this.dUp.dismiss();
            this.dUp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBq() {
        if (this.enX != null && this.enV != null) {
            this.enX.completePullRefreshPostDelayed(2000L);
            if (this.enV.getData() != null) {
                this.enY.setData(this.enV.getData());
            } else {
                C(isLogin(), true);
            }
        }
    }
}
