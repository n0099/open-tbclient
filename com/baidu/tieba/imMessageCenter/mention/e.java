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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.e;
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
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements j.b {
    private final CustomMessageListener aPU;
    private RelativeLayout dEn;
    private View dbn;
    private com.baidu.tbadk.core.dialog.d eKA;
    private final CustomMessageListener eKB;
    private com.baidu.tieba.im.chat.a.a eKD;
    private final com.baidu.tieba.im.chat.a.b eKE;
    private final ChatAggregationFragment fdW;
    private ImMessageCenterModel fdX;
    private ImMessageCenterShowItemData fdY;
    private BdListView fdZ;
    private MessageAggregationListAdapter fea;
    private ShutDownValidateTipView feb;
    com.baidu.tbadk.core.dialog.b fec;
    private b.InterfaceC0158b fed;
    private int fee;
    private boolean fef;
    private boolean feg;
    private boolean feh;
    private boolean fei;
    private int fej;
    private final AdapterView.OnItemLongClickListener fek;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.aK(chatAggregationFragment.getPageContext().getPageActivity()));
        this.fdX = null;
        this.fdY = null;
        this.fdZ = null;
        this.fea = null;
        this.fec = null;
        this.fef = true;
        this.feg = false;
        this.feh = false;
        this.fei = true;
        this.fej = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData pD = e.this.fea.getItem(i);
                    TiebaStatic.eventStat(e.this.fdW.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = pD.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(pD);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fdW.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.fdW.getPageContext().getContext(), "chat_list_to_group", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.fdW.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(pD.getFriendId(), 0L), pD.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (pD.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fdW.getPageContext().getOrignalPage(), 2008021)) {
                            d(pD);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.HP().Il() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.HP().Il().fb(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.fdW.getPageContext().getPageActivity())));
                        }
                    } else if (pD.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fdW.getPageContext().getOrignalPage(), 2008013)) {
                            d(pD);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.HP().Il() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.HP().Il().fa(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.fdW.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fdW.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.fdW.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fdW.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.fdW.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(pD.getFriendId(), 0L), pD.getFriendName(), pD.getFriendPortrait(), 0, pD.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new am("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.fdW.getPageContext().getPageActivity())));
                    } else {
                        e(pD);
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
                                com.baidu.tieba.im.db.d.aQp().pR("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aQp().pR("group_intro_change");
                                com.baidu.tieba.im.db.d.aQp().pR("group_name_change");
                                com.baidu.tieba.im.db.d.aQp().pR("group_notice_change");
                                com.baidu.tieba.im.db.d.aQp().pR("group_level_up");
                                com.baidu.tieba.im.db.d.aQp().pR("dismiss_group");
                                com.baidu.tieba.im.db.d.aQp().pR("kick_out");
                                com.baidu.tieba.im.db.d.aQp().pR("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.HP().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.HP().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.fdW.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.fek = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.fdY = e.this.fea.getItem(i);
                e.this.c(e.this.fdY);
                if (e.this.fec != null) {
                    TiebaStatic.log("c12932");
                    e.this.fec.BI();
                    if (e.this.fdW != null && e.this.fdW.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.fdW.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.eKB = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.fdX.setData(null, e.this.eKD);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.fea != null) {
                            e.this.fea.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.fea != null) {
                        e.this.fea.notifyDataSetChanged();
                    }
                }
            }
        };
        this.eKD = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.aOI();
            }
        };
        this.aPU = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.eKE = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.ayA();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.eKA != null) {
                    e.this.eKA.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.Tb();
                e.this.fdW.showToast(e.j.delete_success, false);
                e.this.aOI();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.Tb();
            }
        };
        this.fdW = chatAggregationFragment;
    }

    public void t(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.fej = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.fej = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.fej);
        }
    }

    public void aEb() {
        if (this.fea != null) {
            this.fea.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eKB);
        MessageManager.getInstance().unRegisterListener(this.aPU);
    }

    public View acb() {
        this.fee = 3;
        this.rootView = LayoutInflater.from(this.fdW.getPageContext().getPageActivity()).inflate(e.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        aI(this.rootView);
        TiebaStatic.eventStat(this.fdW.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        aqP();
        return this.rootView;
    }

    protected void aqP() {
        this.fdZ.startPullRefresh();
        this.feg = isLogin();
        if (!this.feg) {
            K(this.feg, true);
        }
    }

    private void registerListener() {
        this.fdW.registerListener(2016004, this.eKB);
        this.fdW.registerListener(2016001, this.eKB);
        this.fdW.registerListener(2016010, this.eKB);
        this.fdW.registerListener(2016007, this.eKB);
        this.fdW.registerListener(2016011, this.eKB);
        this.fdW.registerListener(2016002, this.eKB);
        this.fdW.registerListener(this.aPU);
    }

    public void je(boolean z) {
        this.feh = z;
    }

    public void jf(boolean z) {
        this.fei = z;
    }

    public void onPrimary() {
        if (this.fea != null && this.fea.getCount() == 0) {
            je(true);
        }
        if (this.fei || this.feh) {
            this.fei = false;
            this.feh = false;
            fE(false);
        }
        boolean isLogin = isLogin();
        if (this.feg != isLogin) {
            this.feg = isLogin;
            onUserChanged(this.feg);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.fdW.getPageContext());
        }
    }

    private void initData() {
        this.fdX = new ImMessageCenterModel();
        ji(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void aI(View view) {
        this.dEn = (RelativeLayout) view.findViewById(e.g.chat_list);
        this.feb = (ShutDownValidateTipView) view.findViewById(e.g.view_no_validate);
        this.feb.setVisibility(8);
        this.feb.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.ji(false);
                e.this.jh(false);
            }
        });
        this.fdZ = (BdListView) view.findViewById(e.g.chat_list_content);
        this.fdZ.setDividerHeight(0);
        this.fea = new MessageAggregationListAdapter(this.fdW.getPageContext().getPageActivity());
        this.fea.a(this);
        this.fdZ.setAdapter((ListAdapter) this.fea);
        this.fdZ.setOnItemClickListener(this.mItemClickListener);
        this.fdZ.setOnItemLongClickListener(this.fek);
        this.dbn = new View(this.fdW.getFragmentActivity());
        this.dbn.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.fdW.getFragmentActivity(), e.C0210e.ds150)));
        this.fdZ.addFooterView(this.dbn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fdW.getPageContext(), i);
        }
        if (this.feb != null) {
            this.feb.onChangeSkinType(i);
        }
        if (this.fea != null) {
            this.fea.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.dEn);
            return true;
        }
        return true;
    }

    private void jg(boolean z) {
        if (z) {
            aVD();
        } else {
            aVE();
        }
    }

    private void aVD() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fdW.getResources().getString(e.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin() && e.this.mContext != null) {
                        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(e.this.mContext.getPageActivity(), 0, false);
                        atListActivityConfig.setIsForChat(true);
                        e.this.mContext.sendMessage(new CustomMessage(2002001, atListActivityConfig));
                        TiebaStatic.log("c12929");
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.fdW.getPageContext().getPageActivity(), this.dEn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.fdW.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aVE() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.fdW.getResources().getString(e.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.fdW.getPageContext().getPageActivity(), "notlogin_10", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                ba.bI(e.this.fdW.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.fdW.getResources().getDimensionPixelSize(e.C0210e.ds320);
        int dimensionPixelSize2 = this.fdW.getResources().getDimensionPixelSize(e.C0210e.ds480);
        int dimensionPixelSize3 = this.fdW.getResources().getDimensionPixelSize(e.C0210e.ds360);
        int dimensionPixelSize4 = this.fdW.getResources().getDimensionPixelSize(e.C0210e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.fdW.getPageContext().getPageActivity(), this.dEn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.G(e.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.fdW.getResources().getDimensionPixelSize(e.C0210e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        K(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.fed = new b.InterfaceC0158b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.fdX.asyncDeleteItem(imMessageCenterShowItemData, e.this.eKE);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.fdW.getPageContext().getPageActivity().getString(e.j.delete_user_chat);
        this.fec = new com.baidu.tbadk.core.dialog.b(this.fdW.getPageContext().getPageActivity());
        this.fec.de(e.j.operation);
        this.fec.a(new String[]{string}, this.fed);
        this.fec.d(this.fdW.getPageContext());
    }

    protected boolean fE(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.fdZ.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
        return true;
    }

    public void jh(boolean z) {
        if (z) {
            if (aVF() && this.feb.getVisibility() != 0) {
                this.feb.setVisibility(0);
            }
        } else if (this.feb.getVisibility() != 8) {
            this.feb.setVisibility(8);
        }
    }

    public void K(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.fdZ.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.dEn.removeView(this.mNoDataView);
        }
        jg(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.fdZ.setVisibility(8);
    }

    public boolean aVF() {
        return this.fef;
    }

    public void ji(boolean z) {
        this.fef = z;
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
                if (this.fdX != null) {
                    this.fdX.insertOrUpdate(data, this.eKD);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.fdX != null) {
                this.fdX.remove(data, this.eKD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.fdX != null) {
                this.fdX.setData(data, this.eKD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.fej = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.fej != -1) {
                je(true);
                onPrimary();
            }
        }
    }

    public void jd(boolean z) {
        if (z && this.fdZ != null && this.fdZ.getWrappedAdapter() != null && this.fdZ.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.fdZ.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bH(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                aVG();
            }
        }
    }

    private void aVG() {
        if (this.fea != null) {
            this.fea.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayA() {
        Tb();
        if (this.eKA == null) {
            this.eKA = com.baidu.tieba.im.db.e.aQq().cD(getPageContext().getPageActivity());
        }
        this.eKA.show();
        this.eKA.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tb() {
        if (this.eKA != null && this.eKA.isShowing()) {
            this.eKA.dismiss();
            this.eKA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOI() {
        if (this.fdZ != null && this.fdX != null) {
            this.fdZ.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (this.fdX.getData() != null) {
                this.fea.setData(this.fdX.getData());
            } else {
                K(isLogin(), true);
            }
        }
    }
}
