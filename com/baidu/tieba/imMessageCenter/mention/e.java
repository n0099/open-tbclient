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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
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
public class e extends com.baidu.adp.base.c<g> implements j.b {
    private final AdapterView.OnItemClickListener Qw;
    private final CustomMessageListener bjn;
    private boolean cOy;
    private RelativeLayout dAU;
    private View ddr;
    private ImMessageCenterModel ePK;
    private ImMessageCenterShowItemData ePM;
    private BdListView ePN;
    private ShutDownValidateTipView ePQ;
    com.baidu.tbadk.core.dialog.b ePR;
    private b.InterfaceC0097b ePS;
    private int ePT;
    private boolean ePU;
    private final AdapterView.OnItemLongClickListener ePV;
    private MessageAggregationListAdapter eSA;
    private boolean eSB;
    private boolean eSC;
    private int eSD;
    private final g eSz;
    private com.baidu.tbadk.core.dialog.d eyI;
    private final CustomMessageListener eyJ;
    private com.baidu.tieba.im.chat.a.a eyL;
    private final com.baidu.tieba.im.chat.a.b eyM;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.ak(gVar.getPageContext().getPageActivity()));
        this.ePK = null;
        this.ePM = null;
        this.ePN = null;
        this.eSA = null;
        this.ePR = null;
        this.ePU = true;
        this.eSB = false;
        this.cOy = false;
        this.eSC = true;
        this.eSD = 16;
        this.Qw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData pK = e.this.eSA.getItem(i);
                    TiebaStatic.eventStat(e.this.eSz.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = pK.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(pK);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eSz.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.eSz.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.eSz.getPageContext().getPageActivity(), Integer.parseInt(pK.getFriendId()), pK.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (pK.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eSz.getPageContext().getOrignalPage(), 2008021)) {
                            d(pK);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.GJ().Hf() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().Hf().ha(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.eSz.getPageContext().getPageActivity())));
                        }
                    } else if (pK.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eSz.getPageContext().getOrignalPage(), 2008013)) {
                            d(pK);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.GJ().Hf() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().Hf().gZ(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.eSz.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eSz.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.eSz.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eSz.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.eSz.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(pK.getFriendId(), 0L), pK.getFriendName(), pK.getFriendPortrait(), 0, pK.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ak("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.eSz.getPageContext().getPageActivity())));
                    } else {
                        e(pK);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.eSz.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.ePV = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.ePM = e.this.eSA.getItem(i);
                e.this.c(e.this.ePM);
                if (e.this.ePR != null) {
                    TiebaStatic.log("c12932");
                    e.this.ePR.AY();
                    if (e.this.eSz != null && e.this.eSz.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.eSz.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.eyJ = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.ePK.setData(null, e.this.eyL);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.eSA != null) {
                            e.this.eSA.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.eSA != null) {
                        e.this.eSA.notifyDataSetChanged();
                    }
                }
            }
        };
        this.eyL = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void aGd() {
                e.this.aGs();
            }
        };
        this.bjn = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.eyM = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.aGr();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.eyI != null) {
                    e.this.eyI.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.abk();
                e.this.eSz.showToast(d.j.delete_success, false);
                e.this.aGs();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.abk();
            }
        };
        this.eSz = gVar;
    }

    public void o(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eSD = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eSD = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eSD);
        }
    }

    public void axE() {
        if (this.eSA != null) {
            this.eSA.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eyJ);
    }

    public View YO() {
        this.ePT = 3;
        this.rootView = LayoutInflater.from(this.eSz.getPageContext().getPageActivity()).inflate(d.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        bI(this.rootView);
        TiebaStatic.eventStat(this.eSz.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        amP();
        return this.rootView;
    }

    protected void amP() {
        this.ePN.startPullRefresh();
        this.eSB = isLogin();
        if (!this.eSB) {
            G(this.eSB, true);
        }
    }

    private void registerListener() {
        this.eSz.registerListener(2016004, this.eyJ);
        this.eSz.registerListener(2016001, this.eyJ);
        this.eSz.registerListener(2016010, this.eyJ);
        this.eSz.registerListener(2016007, this.eyJ);
        this.eSz.registerListener(2016011, this.eyJ);
        this.eSz.registerListener(2016002, this.eyJ);
        this.eSz.registerListener(this.bjn);
    }

    public void il(boolean z) {
        this.cOy = z;
    }

    public void im(boolean z) {
        this.eSC = z;
    }

    public void onPrimary() {
        if (this.eSA != null && this.eSA.getCount() == 0) {
            il(true);
        }
        if (this.eSC || this.cOy) {
            this.eSC = false;
            this.cOy = false;
            eY(false);
        }
        boolean isLogin = isLogin();
        if (this.eSB != isLogin) {
            this.eSB = isLogin;
            onUserChanged(this.eSB);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eSz.getPageContext());
        }
    }

    private void initData() {
        this.ePK = new ImMessageCenterModel();
        m16if(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bI(View view) {
        this.dAU = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.ePQ = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.ePQ.setVisibility(8);
        this.ePQ.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.m16if(false);
                e.this.id(false);
            }
        });
        this.ePN = (BdListView) view.findViewById(d.g.chat_list_content);
        this.ePN.setDividerHeight(0);
        this.eSA = new MessageAggregationListAdapter(this.eSz.getPageContext().getPageActivity());
        this.eSA.a(this);
        this.ePN.setAdapter((ListAdapter) this.eSA);
        this.ePN.setOnItemClickListener(this.Qw);
        this.ePN.setOnItemLongClickListener(this.ePV);
        this.ddr = new View(this.eSz.getFragmentActivity());
        this.ddr.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.t(this.eSz.getFragmentActivity(), d.e.ds150)));
        this.ePN.addFooterView(this.ddr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eSz.getPageContext(), i);
        }
        if (this.ePQ != null) {
            this.ePQ.onChangeSkinType(i);
        }
        if (this.eSA != null) {
            this.eSA.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().aM(this.dAU);
            return true;
        }
        return true;
    }

    private void in(boolean z) {
        if (z) {
            aMD();
        } else {
            aME();
        }
    }

    private void aMD() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.mA().an("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eSz.getResources().getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.eSz.getPageContext().getPageActivity(), this.dAU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eSz.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aME() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.eSz.getResources().getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.eSz.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ay.aZ(e.this.eSz.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.eSz.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.eSz.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.eSz.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.eSz.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eSz.getPageContext().getPageActivity(), this.dAU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aB(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.eSz.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        G(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.ePS = new b.InterfaceC0097b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.ePK.asyncDeleteItem(imMessageCenterShowItemData, e.this.eyM);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.eSz.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.ePR = new com.baidu.tbadk.core.dialog.b(this.eSz.getPageContext().getPageActivity());
        this.ePR.fe(d.j.operation);
        this.ePR.a(new String[]{string}, this.ePS);
        this.ePR.d(this.eSz.getPageContext());
    }

    protected boolean eY(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.ePN.completePullRefreshPostDelayed(2000L);
        }
        return true;
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

    public void G(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.ePN.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.dAU.removeView(this.mNoDataView);
        }
        in(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.ePN.setVisibility(8);
    }

    public boolean aMF() {
        return this.ePU;
    }

    /* renamed from: if  reason: not valid java name */
    public void m16if(boolean z) {
        this.ePU = z;
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eSD = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eSD != -1) {
                il(true);
                onPrimary();
            }
        }
    }

    public void ik(boolean z) {
        if (z && this.ePN != null && this.ePN.getWrappedAdapter() != null && this.ePN.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.ePN.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bw(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                aNw();
            }
        }
    }

    private void aNw() {
        if (this.eSA != null) {
            this.eSA.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGr() {
        abk();
        if (this.eyI == null) {
            this.eyI = com.baidu.tieba.im.db.e.aIb().bL(getPageContext().getPageActivity());
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
            if (this.ePK.getData() != null) {
                this.eSA.setData(this.ePK.getData());
            } else {
                G(isLogin(), true);
            }
        }
    }
}
