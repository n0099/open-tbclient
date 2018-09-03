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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.f;
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
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements g.b {
    private final CustomMessageListener aDW;
    private View cFo;
    private RelativeLayout diB;
    private final ChatAggregationFragment eGQ;
    private ImMessageCenterModel eGR;
    private ImMessageCenterShowItemData eGS;
    private BdListView eGT;
    private MessageAggregationListAdapter eGU;
    private ShutDownValidateTipView eGV;
    com.baidu.tbadk.core.dialog.b eGW;
    private b.InterfaceC0101b eGX;
    private int eGY;
    private boolean eGZ;
    private boolean eHa;
    private boolean eHb;
    private boolean eHc;
    private int eHd;
    private final AdapterView.OnItemLongClickListener eHe;
    private com.baidu.tbadk.core.dialog.d enj;
    private final CustomMessageListener enk;
    private com.baidu.tieba.im.chat.a.a enm;
    private final com.baidu.tieba.im.chat.a.b enn;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ad(chatAggregationFragment.getPageContext().getPageActivity()));
        this.eGR = null;
        this.eGS = null;
        this.eGT = null;
        this.eGU = null;
        this.eGW = null;
        this.eGZ = true;
        this.eHa = false;
        this.eHb = false;
        this.eHc = true;
        this.eHd = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData nO = e.this.eGU.getItem(i);
                    TiebaStatic.eventStat(e.this.eGQ.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = nO.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(nO);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eGQ.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.eGQ.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.eGQ.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(nO.getFriendId(), 0L), nO.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (nO.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eGQ.getPageContext().getOrignalPage(), 2008021)) {
                            d(nO);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH().ee(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.eGQ.getPageContext().getPageActivity())));
                        }
                    } else if (nO.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eGQ.getPageContext().getOrignalPage(), 2008013)) {
                            d(nO);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH().ed(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.eGQ.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eGQ.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.eGQ.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eGQ.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.eGQ.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(nO.getFriendId(), 0L), nO.getFriendName(), nO.getFriendPortrait(), 0, nO.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new an("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.eGQ.getPageContext().getPageActivity())));
                    } else {
                        e(nO);
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
                                com.baidu.tieba.im.db.d.aJx().og("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aJx().og("group_intro_change");
                                com.baidu.tieba.im.db.d.aJx().og("group_name_change");
                                com.baidu.tieba.im.db.d.aJx().og("group_notice_change");
                                com.baidu.tieba.im.db.d.aJx().og("group_level_up");
                                com.baidu.tieba.im.db.d.aJx().og("dismiss_group");
                                com.baidu.tieba.im.db.d.aJx().og("kick_out");
                                com.baidu.tieba.im.db.d.aJx().og("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.Dl().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.eGQ.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.eHe = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.eGS = e.this.eGU.getItem(i);
                e.this.c(e.this.eGS);
                if (e.this.eGW != null) {
                    TiebaStatic.log("c12932");
                    e.this.eGW.xh();
                    if (e.this.eGQ != null && e.this.eGQ.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.eGQ.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.enk = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.eGR.setData(null, e.this.enm);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.eGU != null) {
                            e.this.eGU.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.eGU != null) {
                        e.this.eGU.notifyDataSetChanged();
                    }
                }
            }
        };
        this.enm = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void aHB() {
                e.this.aHP();
            }
        };
        this.aDW = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.enn = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.asg();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.enj != null) {
                    e.this.enj.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.ZD();
                e.this.eGQ.showToast(f.j.delete_success, false);
                e.this.aHP();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.ZD();
            }
        };
        this.eGQ = chatAggregationFragment;
    }

    public void m(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eHd = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eHd = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eHd);
        }
    }

    public void axo() {
        if (this.eGU != null) {
            this.eGU.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.enk);
        MessageManager.getInstance().unRegisterListener(this.aDW);
    }

    public View Vq() {
        this.eGY = 3;
        this.rootView = LayoutInflater.from(this.eGQ.getPageContext().getPageActivity()).inflate(f.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        as(this.rootView);
        TiebaStatic.eventStat(this.eGQ.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        akq();
        return this.rootView;
    }

    protected void akq() {
        this.eGT.startPullRefresh();
        this.eHa = isLogin();
        if (!this.eHa) {
            F(this.eHa, true);
        }
    }

    private void registerListener() {
        this.eGQ.registerListener(2016004, this.enk);
        this.eGQ.registerListener(2016001, this.enk);
        this.eGQ.registerListener(2016010, this.enk);
        this.eGQ.registerListener(2016007, this.enk);
        this.eGQ.registerListener(2016011, this.enk);
        this.eGQ.registerListener(2016002, this.enk);
        this.eGQ.registerListener(this.aDW);
    }

    public void ic(boolean z) {
        this.eHb = z;
    }

    public void id(boolean z) {
        this.eHc = z;
    }

    public void onPrimary() {
        if (this.eGU != null && this.eGU.getCount() == 0) {
            ic(true);
        }
        if (this.eHc || this.eHb) {
            this.eHc = false;
            this.eHb = false;
            eJ(false);
        }
        boolean isLogin = isLogin();
        if (this.eHa != isLogin) {
            this.eHa = isLogin;
            onUserChanged(this.eHa);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eGQ.getPageContext());
        }
    }

    private void initData() {
        this.eGR = new ImMessageCenterModel();
        ig(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void as(View view) {
        this.diB = (RelativeLayout) view.findViewById(f.g.chat_list);
        this.eGV = (ShutDownValidateTipView) view.findViewById(f.g.view_no_validate);
        this.eGV.setVisibility(8);
        this.eGV.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.ig(false);
                e.this.m16if(false);
            }
        });
        this.eGT = (BdListView) view.findViewById(f.g.chat_list_content);
        this.eGT.setDividerHeight(0);
        this.eGU = new MessageAggregationListAdapter(this.eGQ.getPageContext().getPageActivity());
        this.eGU.a(this);
        this.eGT.setAdapter((ListAdapter) this.eGU);
        this.eGT.setOnItemClickListener(this.mItemClickListener);
        this.eGT.setOnItemLongClickListener(this.eHe);
        this.cFo = new View(this.eGQ.getFragmentActivity());
        this.cFo.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.eGQ.getFragmentActivity(), f.e.ds150)));
        this.eGT.addFooterView(this.cFo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eGQ.getPageContext(), i);
        }
        if (this.eGV != null) {
            this.eGV.onChangeSkinType(i);
        }
        if (this.eGU != null) {
            this.eGU.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.diB);
            return true;
        }
        return true;
    }

    private void ie(boolean z) {
        if (z) {
            aOM();
        } else {
            aON();
        }
    }

    private void aOM() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.hv().ax("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eGQ.getResources().getString(f.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.eGQ.getPageContext().getPageActivity(), this.diB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eGQ.getResources().getDimension(f.e.ds80)), NoDataViewFactory.d.dt(f.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aON() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.eGQ.getResources().getString(f.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.eGQ.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bb.aT(e.this.eGQ.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.eGQ.getResources().getDimensionPixelSize(f.e.ds320);
        int dimensionPixelSize2 = this.eGQ.getResources().getDimensionPixelSize(f.e.ds480);
        int dimensionPixelSize3 = this.eGQ.getResources().getDimensionPixelSize(f.e.ds360);
        int dimensionPixelSize4 = this.eGQ.getResources().getDimensionPixelSize(f.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eGQ.getPageContext().getPageActivity(), this.diB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, f.C0146f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.D(f.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.eGQ.getResources().getDimensionPixelSize(f.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        F(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.eGX = new b.InterfaceC0101b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.eGR.asyncDeleteItem(imMessageCenterShowItemData, e.this.enn);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.eGQ.getPageContext().getPageActivity().getString(f.j.delete_user_chat);
        this.eGW = new com.baidu.tbadk.core.dialog.b(this.eGQ.getPageContext().getPageActivity());
        this.eGW.ci(f.j.operation);
        this.eGW.a(new String[]{string}, this.eGX);
        this.eGW.d(this.eGQ.getPageContext());
    }

    protected boolean eJ(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.eGT.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    /* renamed from: if  reason: not valid java name */
    public void m16if(boolean z) {
        if (z) {
            if (aOO() && this.eGV.getVisibility() != 0) {
                this.eGV.setVisibility(0);
            }
        } else if (this.eGV.getVisibility() != 8) {
            this.eGV.setVisibility(8);
        }
    }

    public void F(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eGT.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.diB.removeView(this.mNoDataView);
        }
        ie(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.eGT.setVisibility(8);
    }

    public boolean aOO() {
        return this.eGZ;
    }

    public void ig(boolean z) {
        this.eGZ = z;
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
                if (this.eGR != null) {
                    this.eGR.insertOrUpdate(data, this.enm);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eGR != null) {
                this.eGR.remove(data, this.enm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.eGR != null) {
                this.eGR.setData(data, this.enm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eHd = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eHd != -1) {
                ic(true);
                onPrimary();
            }
        }
    }

    public void ib(boolean z) {
        if (z && this.eGT != null && this.eGT.getWrappedAdapter() != null && this.eGT.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.eGT.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aT(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                aOP();
            }
        }
    }

    private void aOP() {
        if (this.eGU != null) {
            this.eGU.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asg() {
        ZD();
        if (this.enj == null) {
            this.enj = com.baidu.tieba.im.db.e.aJy().bK(getPageContext().getPageActivity());
        }
        this.enj.show();
        this.enj.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZD() {
        if (this.enj != null && this.enj.isShowing()) {
            this.enj.dismiss();
            this.enj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHP() {
        if (this.eGT != null && this.eGR != null) {
            this.eGT.completePullRefreshPostDelayed(2000L);
            if (this.eGR.getData() != null) {
                this.eGU.setData(this.eGR.getData());
            } else {
                F(isLogin(), true);
            }
        }
    }
}
