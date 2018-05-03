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
    private final CustomMessageListener auR;
    private RelativeLayout cTD;
    private boolean ceF;
    private com.baidu.tbadk.core.dialog.d dTi;
    private final CustomMessageListener dTj;
    private com.baidu.tieba.im.chat.a.a dTl;
    private final com.baidu.tieba.im.chat.a.b dTm;
    private final ChatAggregationFragment emM;
    private ImMessageCenterModel emN;
    private ImMessageCenterShowItemData emO;
    private BdListView emP;
    private MessageAggregationListAdapter emQ;
    private ShutDownValidateTipView emR;
    com.baidu.tbadk.core.dialog.b emS;
    private b.InterfaceC0086b emT;
    private int emU;
    private boolean emV;
    private boolean emW;
    private boolean emX;
    private int emY;
    private final AdapterView.OnItemLongClickListener emZ;
    private View mFooterView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ab(chatAggregationFragment.getPageContext().getPageActivity()));
        this.emN = null;
        this.emO = null;
        this.emP = null;
        this.emQ = null;
        this.emS = null;
        this.emV = true;
        this.emW = false;
        this.ceF = false;
        this.emX = true;
        this.emY = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData ni = e.this.emQ.getItem(i);
                    TiebaStatic.eventStat(e.this.emM.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = ni.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(ni);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.emM.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.emM.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.emM.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(ni.getFriendId(), 0L), ni.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (ni.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.emM.getPageContext().getOrignalPage(), 2008021)) {
                            d(ni);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.zx().zT() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.zx().zT().dY(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.emM.getPageContext().getPageActivity())));
                        }
                    } else if (ni.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.emM.getPageContext().getOrignalPage(), 2008013)) {
                            d(ni);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.zx().zT() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.zx().zT().dX(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.emM.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.emM.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.emM.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.emM.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.emM.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(ni.getFriendId(), 0L), ni.getFriendName(), ni.getFriendPortrait(), 0, ni.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new al("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.emM.getPageContext().getPageActivity())));
                    } else {
                        e(ni);
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
                                com.baidu.tieba.im.db.d.aCZ().nl("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aCZ().nl("group_intro_change");
                                com.baidu.tieba.im.db.d.aCZ().nl("group_name_change");
                                com.baidu.tieba.im.db.d.aCZ().nl("group_notice_change");
                                com.baidu.tieba.im.db.d.aCZ().nl("group_level_up");
                                com.baidu.tieba.im.db.d.aCZ().nl("dismiss_group");
                                com.baidu.tieba.im.db.d.aCZ().nl("kick_out");
                                com.baidu.tieba.im.db.d.aCZ().nl("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.zx().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.emM.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.emZ = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
                e.this.emO = e.this.emQ.getItem(i);
                e.this.c(e.this.emO);
                if (e.this.emS != null) {
                    TiebaStatic.log("c12932");
                    e.this.emS.tG();
                    if (e.this.emM != null && e.this.emM.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.emM.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.dTj = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.emN.setData(null, e.this.dTl);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.emQ != null) {
                            e.this.emQ.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.emQ != null) {
                        e.this.emQ.notifyDataSetChanged();
                    }
                }
            }
        };
        this.dTl = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void aBd() {
                e.this.aBs();
            }
        };
        this.auR = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.dTm = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.aBr();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.dTi != null) {
                    e.this.dTi.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.Vl();
                e.this.emM.showToast(d.k.delete_success, false);
                e.this.aBs();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.Vl();
            }
        };
        this.emM = chatAggregationFragment;
    }

    public void l(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.emY = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.emY = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.emY);
        }
    }

    public void asc() {
        if (this.emQ != null) {
            this.emQ.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dTj);
        MessageManager.getInstance().unRegisterListener(this.auR);
    }

    public View Rn() {
        this.emU = 3;
        this.rootView = LayoutInflater.from(this.emM.getPageContext().getPageActivity()).inflate(d.i.chat_list_activity, (ViewGroup) null, false);
        initData();
        an(this.rootView);
        TiebaStatic.eventStat(this.emM.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        agN();
        return this.rootView;
    }

    protected void agN() {
        this.emP.startPullRefresh();
        this.emW = isLogin();
        if (!this.emW) {
            C(this.emW, true);
        }
    }

    private void registerListener() {
        this.emM.registerListener(2016004, this.dTj);
        this.emM.registerListener(2016001, this.dTj);
        this.emM.registerListener(2016010, this.dTj);
        this.emM.registerListener(2016007, this.dTj);
        this.emM.registerListener(2016011, this.dTj);
        this.emM.registerListener(2016002, this.dTj);
        this.emM.registerListener(this.auR);
    }

    public void hI(boolean z) {
        this.ceF = z;
    }

    public void hJ(boolean z) {
        this.emX = z;
    }

    public void onPrimary() {
        if (this.emQ != null && this.emQ.getCount() == 0) {
            hI(true);
        }
        if (this.emX || this.ceF) {
            this.emX = false;
            this.ceF = false;
            eD(false);
        }
        boolean isLogin = isLogin();
        if (this.emW != isLogin) {
            this.emW = isLogin;
            onUserChanged(this.emW);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.emM.getPageContext());
        }
    }

    private void initData() {
        this.emN = new ImMessageCenterModel();
        hM(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void an(View view2) {
        this.cTD = (RelativeLayout) view2.findViewById(d.g.chat_list);
        this.emR = (ShutDownValidateTipView) view2.findViewById(d.g.view_no_validate);
        this.emR.setVisibility(8);
        this.emR.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.hM(false);
                e.this.hL(false);
            }
        });
        this.emP = (BdListView) view2.findViewById(d.g.chat_list_content);
        this.emP.setDividerHeight(0);
        this.emQ = new MessageAggregationListAdapter(this.emM.getPageContext().getPageActivity());
        this.emQ.a(this);
        this.emP.setAdapter((ListAdapter) this.emQ);
        this.emP.setOnItemClickListener(this.mItemClickListener);
        this.emP.setOnItemLongClickListener(this.emZ);
        this.mFooterView = new View(this.emM.getFragmentActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.emM.getFragmentActivity(), d.e.ds150)));
        this.emP.addFooterView(this.mFooterView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.emM.getPageContext(), i);
        }
        if (this.emR != null) {
            this.emR.onChangeSkinType(i);
        }
        if (this.emQ != null) {
            this.emQ.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().u(this.cTD);
            return true;
        }
        return true;
    }

    private void hK(boolean z) {
        if (z) {
            aIq();
        } else {
            aIr();
        }
    }

    private void aIq() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.eE().ak("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.emM.getResources().getString(d.k.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.emM.getPageContext().getPageActivity(), this.cTD, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.emM.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.m16do(d.k.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aIr() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.emM.getResources().getString(d.k.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.eventStat(e.this.emM.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                az.aJ(e.this.emM.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.emM.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.emM.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.emM.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.emM.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.emM.getPageContext().getPageActivity(), this.cTD, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(d.k.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.emM.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        C(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.emT = new b.InterfaceC0086b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.emN.asyncDeleteItem(imMessageCenterShowItemData, e.this.dTm);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.emM.getPageContext().getPageActivity().getString(d.k.delete_user_chat);
        this.emS = new com.baidu.tbadk.core.dialog.b(this.emM.getPageContext().getPageActivity());
        this.emS.cc(d.k.operation);
        this.emS.a(new String[]{string}, this.emT);
        this.emS.d(this.emM.getPageContext());
    }

    protected boolean eD(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.emP.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void hL(boolean z) {
        if (z) {
            if (aIs() && this.emR.getVisibility() != 0) {
                this.emR.setVisibility(0);
            }
        } else if (this.emR.getVisibility() != 8) {
            this.emR.setVisibility(8);
        }
    }

    public void C(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.emP.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.cTD.removeView(this.mNoDataView);
        }
        hK(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.emP.setVisibility(8);
    }

    public boolean aIs() {
        return this.emV;
    }

    public void hM(boolean z) {
        this.emV = z;
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
                if (this.emN != null) {
                    this.emN.insertOrUpdate(data, this.dTl);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.emN != null) {
                this.emN.remove(data, this.dTl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.emN != null) {
                this.emN.setData(data, this.dTl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.emY = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.emY != -1) {
                hI(true);
                onPrimary();
            }
        }
    }

    public void hH(boolean z) {
        if (z && this.emP != null && this.emP.getWrappedAdapter() != null && this.emP.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.emP.startPullRefresh();
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
                aIt();
            }
        }
    }

    private void aIt() {
        if (this.emQ != null) {
            this.emQ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBr() {
        Vl();
        if (this.dTi == null) {
            this.dTi = com.baidu.tieba.im.db.e.aDa().bz(getPageContext().getPageActivity());
        }
        this.dTi.show();
        this.dTi.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vl() {
        if (this.dTi != null && this.dTi.isShowing()) {
            this.dTi.dismiss();
            this.dTi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBs() {
        if (this.emP != null && this.emN != null) {
            this.emP.completePullRefreshPostDelayed(2000L);
            if (this.emN.getData() != null) {
                this.emQ.setData(this.emN.getData());
            } else {
                C(isLogin(), true);
            }
        }
    }
}
