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
    private final CustomMessageListener aMv;
    private View cUE;
    private RelativeLayout dxO;
    private com.baidu.tbadk.core.dialog.d eDL;
    private final CustomMessageListener eDM;
    private com.baidu.tieba.im.chat.a.a eDO;
    private final com.baidu.tieba.im.chat.a.b eDP;
    private final ChatAggregationFragment eXh;
    private ImMessageCenterModel eXi;
    private ImMessageCenterShowItemData eXj;
    private BdListView eXk;
    private MessageAggregationListAdapter eXl;
    private ShutDownValidateTipView eXm;
    com.baidu.tbadk.core.dialog.b eXn;
    private b.InterfaceC0148b eXo;
    private int eXp;
    private boolean eXq;
    private boolean eXr;
    private boolean eXs;
    private boolean eXt;
    private int eXu;
    private final AdapterView.OnItemLongClickListener eXv;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.aK(chatAggregationFragment.getPageContext().getPageActivity()));
        this.eXi = null;
        this.eXj = null;
        this.eXk = null;
        this.eXl = null;
        this.eXn = null;
        this.eXq = true;
        this.eXr = false;
        this.eXs = false;
        this.eXt = true;
        this.eXu = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData pi = e.this.eXl.getItem(i);
                    TiebaStatic.eventStat(e.this.eXh.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = pi.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(pi);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eXh.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.eXh.getPageContext().getContext(), "chat_list_to_group", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.eXh.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(pi.getFriendId(), 0L), pi.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (pi.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eXh.getPageContext().getOrignalPage(), 2008021)) {
                            d(pi);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.GL().Hh() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.GL().Hh().eN(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.eXh.getPageContext().getPageActivity())));
                        }
                    } else if (pi.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eXh.getPageContext().getOrignalPage(), 2008013)) {
                            d(pi);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.GL().Hh() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.GL().Hh().eM(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.eXh.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eXh.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.eXh.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eXh.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.eXh.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(pi.getFriendId(), 0L), pi.getFriendName(), pi.getFriendPortrait(), 0, pi.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new am("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.eXh.getPageContext().getPageActivity())));
                    } else {
                        e(pi);
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
                                com.baidu.tieba.im.db.d.aOy().pp("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aOy().pp("group_intro_change");
                                com.baidu.tieba.im.db.d.aOy().pp("group_name_change");
                                com.baidu.tieba.im.db.d.aOy().pp("group_notice_change");
                                com.baidu.tieba.im.db.d.aOy().pp("group_level_up");
                                com.baidu.tieba.im.db.d.aOy().pp("dismiss_group");
                                com.baidu.tieba.im.db.d.aOy().pp("kick_out");
                                com.baidu.tieba.im.db.d.aOy().pp("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.GL().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.eXh.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.eXv = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.eXj = e.this.eXl.getItem(i);
                e.this.c(e.this.eXj);
                if (e.this.eXn != null) {
                    TiebaStatic.log("c12932");
                    e.this.eXn.AE();
                    if (e.this.eXh != null && e.this.eXh.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.eXh.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.eDM = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.eXi.setData(null, e.this.eDO);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.eXl != null) {
                            e.this.eXl.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.eXl != null) {
                        e.this.eXl.notifyDataSetChanged();
                    }
                }
            }
        };
        this.eDO = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.aMR();
            }
        };
        this.aMv = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.eDP = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.awP();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.eDL != null) {
                    e.this.eDL.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.RV();
                e.this.eXh.showToast(e.j.delete_success, false);
                e.this.aMR();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.RV();
            }
        };
        this.eXh = chatAggregationFragment;
    }

    public void q(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eXu = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eXu = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eXu);
        }
    }

    public void aCp() {
        if (this.eXl != null) {
            this.eXl.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eDM);
        MessageManager.getInstance().unRegisterListener(this.aMv);
    }

    public View aaV() {
        this.eXp = 3;
        this.rootView = LayoutInflater.from(this.eXh.getPageContext().getPageActivity()).inflate(e.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        aI(this.rootView);
        TiebaStatic.eventStat(this.eXh.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        apc();
        return this.rootView;
    }

    protected void apc() {
        this.eXk.startPullRefresh();
        this.eXr = isLogin();
        if (!this.eXr) {
            K(this.eXr, true);
        }
    }

    private void registerListener() {
        this.eXh.registerListener(2016004, this.eDM);
        this.eXh.registerListener(2016001, this.eDM);
        this.eXh.registerListener(2016010, this.eDM);
        this.eXh.registerListener(2016007, this.eDM);
        this.eXh.registerListener(2016011, this.eDM);
        this.eXh.registerListener(2016002, this.eDM);
        this.eXh.registerListener(this.aMv);
    }

    public void jb(boolean z) {
        this.eXs = z;
    }

    public void jc(boolean z) {
        this.eXt = z;
    }

    public void onPrimary() {
        if (this.eXl != null && this.eXl.getCount() == 0) {
            jb(true);
        }
        if (this.eXt || this.eXs) {
            this.eXt = false;
            this.eXs = false;
            fD(false);
        }
        boolean isLogin = isLogin();
        if (this.eXr != isLogin) {
            this.eXr = isLogin;
            onUserChanged(this.eXr);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eXh.getPageContext());
        }
    }

    private void initData() {
        this.eXi = new ImMessageCenterModel();
        jf(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void aI(View view) {
        this.dxO = (RelativeLayout) view.findViewById(e.g.chat_list);
        this.eXm = (ShutDownValidateTipView) view.findViewById(e.g.view_no_validate);
        this.eXm.setVisibility(8);
        this.eXm.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.jf(false);
                e.this.je(false);
            }
        });
        this.eXk = (BdListView) view.findViewById(e.g.chat_list_content);
        this.eXk.setDividerHeight(0);
        this.eXl = new MessageAggregationListAdapter(this.eXh.getPageContext().getPageActivity());
        this.eXl.a(this);
        this.eXk.setAdapter((ListAdapter) this.eXl);
        this.eXk.setOnItemClickListener(this.mItemClickListener);
        this.eXk.setOnItemLongClickListener(this.eXv);
        this.cUE = new View(this.eXh.getFragmentActivity());
        this.cUE.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.eXh.getFragmentActivity(), e.C0200e.ds150)));
        this.eXk.addFooterView(this.cUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eXh.getPageContext(), i);
        }
        if (this.eXm != null) {
            this.eXm.onChangeSkinType(i);
        }
        if (this.eXl != null) {
            this.eXl.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.dxO);
            return true;
        }
        return true;
    }

    private void jd(boolean z) {
        if (z) {
            aTM();
        } else {
            aTN();
        }
    }

    private void aTM() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eXh.getResources().getString(e.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.eXh.getPageContext().getPageActivity(), this.dxO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eXh.getResources().getDimension(e.C0200e.ds80)), NoDataViewFactory.d.ec(e.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aTN() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.eXh.getResources().getString(e.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.eXh.getPageContext().getPageActivity(), "notlogin_10", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                ba.bF(e.this.eXh.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.eXh.getResources().getDimensionPixelSize(e.C0200e.ds320);
        int dimensionPixelSize2 = this.eXh.getResources().getDimensionPixelSize(e.C0200e.ds480);
        int dimensionPixelSize3 = this.eXh.getResources().getDimensionPixelSize(e.C0200e.ds360);
        int dimensionPixelSize4 = this.eXh.getResources().getDimensionPixelSize(e.C0200e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eXh.getPageContext().getPageActivity(), this.dxO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.F(e.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.eXh.getResources().getDimensionPixelSize(e.C0200e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        K(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.eXo = new b.InterfaceC0148b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.eXi.asyncDeleteItem(imMessageCenterShowItemData, e.this.eDP);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.eXh.getPageContext().getPageActivity().getString(e.j.delete_user_chat);
        this.eXn = new com.baidu.tbadk.core.dialog.b(this.eXh.getPageContext().getPageActivity());
        this.eXn.cQ(e.j.operation);
        this.eXn.a(new String[]{string}, this.eXo);
        this.eXn.d(this.eXh.getPageContext());
    }

    protected boolean fD(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.eXk.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
        return true;
    }

    public void je(boolean z) {
        if (z) {
            if (aTO() && this.eXm.getVisibility() != 0) {
                this.eXm.setVisibility(0);
            }
        } else if (this.eXm.getVisibility() != 8) {
            this.eXm.setVisibility(8);
        }
    }

    public void K(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eXk.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.dxO.removeView(this.mNoDataView);
        }
        jd(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.eXk.setVisibility(8);
    }

    public boolean aTO() {
        return this.eXq;
    }

    public void jf(boolean z) {
        this.eXq = z;
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
                if (this.eXi != null) {
                    this.eXi.insertOrUpdate(data, this.eDO);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eXi != null) {
                this.eXi.remove(data, this.eDO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.eXi != null) {
                this.eXi.setData(data, this.eDO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eXu = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eXu != -1) {
                jb(true);
                onPrimary();
            }
        }
    }

    public void ja(boolean z) {
        if (z && this.eXk != null && this.eXk.getWrappedAdapter() != null && this.eXk.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.eXk.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bG(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                aTP();
            }
        }
    }

    private void aTP() {
        if (this.eXl != null) {
            this.eXl.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awP() {
        RV();
        if (this.eDL == null) {
            this.eDL = com.baidu.tieba.im.db.e.aOz().cz(getPageContext().getPageActivity());
        }
        this.eDL.show();
        this.eDL.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RV() {
        if (this.eDL != null && this.eDL.isShowing()) {
            this.eDL.dismiss();
            this.eDL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMR() {
        if (this.eXk != null && this.eXi != null) {
            this.eXk.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (this.eXi.getData() != null) {
                this.eXl.setData(this.eXi.getData());
            } else {
                K(isLogin(), true);
            }
        }
    }
}
