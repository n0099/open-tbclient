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
    private RelativeLayout cTG;
    private boolean ceI;
    private com.baidu.tbadk.core.dialog.d dTl;
    private final CustomMessageListener dTm;
    private com.baidu.tieba.im.chat.a.a dTo;
    private final com.baidu.tieba.im.chat.a.b dTp;
    private final ChatAggregationFragment emP;
    private ImMessageCenterModel emQ;
    private ImMessageCenterShowItemData emR;
    private BdListView emS;
    private MessageAggregationListAdapter emT;
    private ShutDownValidateTipView emU;
    com.baidu.tbadk.core.dialog.b emV;
    private b.InterfaceC0086b emW;
    private int emX;
    private boolean emY;
    private boolean emZ;
    private boolean ena;
    private int enb;
    private final AdapterView.OnItemLongClickListener enc;
    private View mFooterView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ab(chatAggregationFragment.getPageContext().getPageActivity()));
        this.emQ = null;
        this.emR = null;
        this.emS = null;
        this.emT = null;
        this.emV = null;
        this.emY = true;
        this.emZ = false;
        this.ceI = false;
        this.ena = true;
        this.enb = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData nj = e.this.emT.getItem(i);
                    TiebaStatic.eventStat(e.this.emP.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = nj.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(nj);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.emP.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.emP.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.emP.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(nj.getFriendId(), 0L), nj.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (nj.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.emP.getPageContext().getOrignalPage(), 2008021)) {
                            d(nj);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.zx().zT() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.zx().zT().dZ(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.emP.getPageContext().getPageActivity())));
                        }
                    } else if (nj.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.emP.getPageContext().getOrignalPage(), 2008013)) {
                            d(nj);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.zx().zT() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.zx().zT().dY(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.emP.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.emP.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.emP.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.emP.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.emP.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(nj.getFriendId(), 0L), nj.getFriendName(), nj.getFriendPortrait(), 0, nj.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new al("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.emP.getPageContext().getPageActivity())));
                    } else {
                        e(nj);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.emP.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.enc = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
                e.this.emR = e.this.emT.getItem(i);
                e.this.c(e.this.emR);
                if (e.this.emV != null) {
                    TiebaStatic.log("c12932");
                    e.this.emV.tG();
                    if (e.this.emP != null && e.this.emP.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.emP.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.dTm = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.emQ.setData(null, e.this.dTo);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.emT != null) {
                            e.this.emT.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.emT != null) {
                        e.this.emT.notifyDataSetChanged();
                    }
                }
            }
        };
        this.dTo = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
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
        this.dTp = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.aBr();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.dTl != null) {
                    e.this.dTl.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.Vl();
                e.this.emP.showToast(d.k.delete_success, false);
                e.this.aBs();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.Vl();
            }
        };
        this.emP = chatAggregationFragment;
    }

    public void l(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.enb = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.enb = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.enb);
        }
    }

    public void asc() {
        if (this.emT != null) {
            this.emT.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dTm);
        MessageManager.getInstance().unRegisterListener(this.auR);
    }

    public View Rn() {
        this.emX = 3;
        this.rootView = LayoutInflater.from(this.emP.getPageContext().getPageActivity()).inflate(d.i.chat_list_activity, (ViewGroup) null, false);
        initData();
        an(this.rootView);
        TiebaStatic.eventStat(this.emP.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        agN();
        return this.rootView;
    }

    protected void agN() {
        this.emS.startPullRefresh();
        this.emZ = isLogin();
        if (!this.emZ) {
            C(this.emZ, true);
        }
    }

    private void registerListener() {
        this.emP.registerListener(2016004, this.dTm);
        this.emP.registerListener(2016001, this.dTm);
        this.emP.registerListener(2016010, this.dTm);
        this.emP.registerListener(2016007, this.dTm);
        this.emP.registerListener(2016011, this.dTm);
        this.emP.registerListener(2016002, this.dTm);
        this.emP.registerListener(this.auR);
    }

    public void hI(boolean z) {
        this.ceI = z;
    }

    public void hJ(boolean z) {
        this.ena = z;
    }

    public void onPrimary() {
        if (this.emT != null && this.emT.getCount() == 0) {
            hI(true);
        }
        if (this.ena || this.ceI) {
            this.ena = false;
            this.ceI = false;
            eD(false);
        }
        boolean isLogin = isLogin();
        if (this.emZ != isLogin) {
            this.emZ = isLogin;
            onUserChanged(this.emZ);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.emP.getPageContext());
        }
    }

    private void initData() {
        this.emQ = new ImMessageCenterModel();
        hM(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void an(View view2) {
        this.cTG = (RelativeLayout) view2.findViewById(d.g.chat_list);
        this.emU = (ShutDownValidateTipView) view2.findViewById(d.g.view_no_validate);
        this.emU.setVisibility(8);
        this.emU.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.hM(false);
                e.this.hL(false);
            }
        });
        this.emS = (BdListView) view2.findViewById(d.g.chat_list_content);
        this.emS.setDividerHeight(0);
        this.emT = new MessageAggregationListAdapter(this.emP.getPageContext().getPageActivity());
        this.emT.a(this);
        this.emS.setAdapter((ListAdapter) this.emT);
        this.emS.setOnItemClickListener(this.mItemClickListener);
        this.emS.setOnItemLongClickListener(this.enc);
        this.mFooterView = new View(this.emP.getFragmentActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.emP.getFragmentActivity(), d.e.ds150)));
        this.emS.addFooterView(this.mFooterView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.emP.getPageContext(), i);
        }
        if (this.emU != null) {
            this.emU.onChangeSkinType(i);
        }
        if (this.emT != null) {
            this.emT.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().u(this.cTG);
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
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.emP.getResources().getString(d.k.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.emP.getPageContext().getPageActivity(), this.cTG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.emP.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dp(d.k.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aIr() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.emP.getResources().getString(d.k.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.eventStat(e.this.emP.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                az.aJ(e.this.emP.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.emP.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.emP.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.emP.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.emP.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.emP.getPageContext().getPageActivity(), this.cTG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(d.k.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.emP.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        C(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.emW = new b.InterfaceC0086b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.emQ.asyncDeleteItem(imMessageCenterShowItemData, e.this.dTp);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.emP.getPageContext().getPageActivity().getString(d.k.delete_user_chat);
        this.emV = new com.baidu.tbadk.core.dialog.b(this.emP.getPageContext().getPageActivity());
        this.emV.cd(d.k.operation);
        this.emV.a(new String[]{string}, this.emW);
        this.emV.d(this.emP.getPageContext());
    }

    protected boolean eD(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.emS.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void hL(boolean z) {
        if (z) {
            if (aIs() && this.emU.getVisibility() != 0) {
                this.emU.setVisibility(0);
            }
        } else if (this.emU.getVisibility() != 8) {
            this.emU.setVisibility(8);
        }
    }

    public void C(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.emS.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.cTG.removeView(this.mNoDataView);
        }
        hK(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.emS.setVisibility(8);
    }

    public boolean aIs() {
        return this.emY;
    }

    public void hM(boolean z) {
        this.emY = z;
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
                if (this.emQ != null) {
                    this.emQ.insertOrUpdate(data, this.dTo);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.emQ != null) {
                this.emQ.remove(data, this.dTo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.emQ != null) {
                this.emQ.setData(data, this.dTo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.enb = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.enb != -1) {
                hI(true);
                onPrimary();
            }
        }
    }

    public void hH(boolean z) {
        if (z && this.emS != null && this.emS.getWrappedAdapter() != null && this.emS.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.emS.startPullRefresh();
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
        if (this.emT != null) {
            this.emT.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBr() {
        Vl();
        if (this.dTl == null) {
            this.dTl = com.baidu.tieba.im.db.e.aDa().bz(getPageContext().getPageActivity());
        }
        this.dTl.show();
        this.dTl.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vl() {
        if (this.dTl != null && this.dTl.isShowing()) {
            this.dTl.dismiss();
            this.dTl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBs() {
        if (this.emS != null && this.emQ != null) {
            this.emS.completePullRefreshPostDelayed(2000L);
            if (this.emQ.getData() != null) {
                this.emT.setData(this.emQ.getData());
            } else {
                C(isLogin(), true);
            }
        }
    }
}
