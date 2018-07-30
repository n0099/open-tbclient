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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
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
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements g.b {
    private final CustomMessageListener aDX;
    private View cFr;
    private RelativeLayout diD;
    private final ChatAggregationFragment eGV;
    private ImMessageCenterModel eGW;
    private ImMessageCenterShowItemData eGX;
    private BdListView eGY;
    private MessageAggregationListAdapter eGZ;
    private ShutDownValidateTipView eHa;
    com.baidu.tbadk.core.dialog.b eHb;
    private b.InterfaceC0101b eHc;
    private int eHd;
    private boolean eHe;
    private boolean eHf;
    private boolean eHg;
    private boolean eHh;
    private int eHi;
    private final AdapterView.OnItemLongClickListener eHj;
    private com.baidu.tbadk.core.dialog.d enn;
    private final CustomMessageListener eno;
    private com.baidu.tieba.im.chat.a.a enq;
    private final com.baidu.tieba.im.chat.a.b enr;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ad(chatAggregationFragment.getPageContext().getPageActivity()));
        this.eGW = null;
        this.eGX = null;
        this.eGY = null;
        this.eGZ = null;
        this.eHb = null;
        this.eHe = true;
        this.eHf = false;
        this.eHg = false;
        this.eHh = true;
        this.eHi = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData nO = e.this.eGZ.getItem(i);
                    TiebaStatic.eventStat(e.this.eGV.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = nO.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(nO);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eGV.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.eGV.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.eGV.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(nO.getFriendId(), 0L), nO.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (nO.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eGV.getPageContext().getOrignalPage(), 2008021)) {
                            d(nO);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH().ef(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.eGV.getPageContext().getPageActivity())));
                        }
                    } else if (nO.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eGV.getPageContext().getOrignalPage(), 2008013)) {
                            d(nO);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH().ee(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.eGV.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eGV.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.eGV.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eGV.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.eGV.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(nO.getFriendId(), 0L), nO.getFriendName(), nO.getFriendPortrait(), 0, nO.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new an("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.eGV.getPageContext().getPageActivity())));
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
                                com.baidu.tieba.im.db.d.aJA().od("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aJA().od("group_intro_change");
                                com.baidu.tieba.im.db.d.aJA().od("group_name_change");
                                com.baidu.tieba.im.db.d.aJA().od("group_notice_change");
                                com.baidu.tieba.im.db.d.aJA().od("group_level_up");
                                com.baidu.tieba.im.db.d.aJA().od("dismiss_group");
                                com.baidu.tieba.im.db.d.aJA().od("kick_out");
                                com.baidu.tieba.im.db.d.aJA().od("group_activitys_change");
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.eGV.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.eHj = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.eGX = e.this.eGZ.getItem(i);
                e.this.c(e.this.eGX);
                if (e.this.eHb != null) {
                    TiebaStatic.log("c12932");
                    e.this.eHb.xi();
                    if (e.this.eGV != null && e.this.eGV.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.eGV.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.eno = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.eGW.setData(null, e.this.enq);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.eGZ != null) {
                            e.this.eGZ.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.eGZ != null) {
                        e.this.eGZ.notifyDataSetChanged();
                    }
                }
            }
        };
        this.enq = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void aHE() {
                e.this.aHS();
            }
        };
        this.aDX = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.enr = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.asg();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.enn != null) {
                    e.this.enn.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.ZB();
                e.this.eGV.showToast(d.j.delete_success, false);
                e.this.aHS();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.ZB();
            }
        };
        this.eGV = chatAggregationFragment;
    }

    public void m(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eHi = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eHi = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eHi);
        }
    }

    public void axp() {
        if (this.eGZ != null) {
            this.eGZ.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eno);
        MessageManager.getInstance().unRegisterListener(this.aDX);
    }

    public View Vm() {
        this.eHd = 3;
        this.rootView = LayoutInflater.from(this.eGV.getPageContext().getPageActivity()).inflate(d.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        as(this.rootView);
        TiebaStatic.eventStat(this.eGV.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        ako();
        return this.rootView;
    }

    protected void ako() {
        this.eGY.startPullRefresh();
        this.eHf = isLogin();
        if (!this.eHf) {
            F(this.eHf, true);
        }
    }

    private void registerListener() {
        this.eGV.registerListener(2016004, this.eno);
        this.eGV.registerListener(2016001, this.eno);
        this.eGV.registerListener(2016010, this.eno);
        this.eGV.registerListener(2016007, this.eno);
        this.eGV.registerListener(2016011, this.eno);
        this.eGV.registerListener(2016002, this.eno);
        this.eGV.registerListener(this.aDX);
    }

    public void ic(boolean z) {
        this.eHg = z;
    }

    public void id(boolean z) {
        this.eHh = z;
    }

    public void onPrimary() {
        if (this.eGZ != null && this.eGZ.getCount() == 0) {
            ic(true);
        }
        if (this.eHh || this.eHg) {
            this.eHh = false;
            this.eHg = false;
            eJ(false);
        }
        boolean isLogin = isLogin();
        if (this.eHf != isLogin) {
            this.eHf = isLogin;
            onUserChanged(this.eHf);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eGV.getPageContext());
        }
    }

    private void initData() {
        this.eGW = new ImMessageCenterModel();
        ig(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void as(View view) {
        this.diD = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.eHa = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.eHa.setVisibility(8);
        this.eHa.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.ig(false);
                e.this.m16if(false);
            }
        });
        this.eGY = (BdListView) view.findViewById(d.g.chat_list_content);
        this.eGY.setDividerHeight(0);
        this.eGZ = new MessageAggregationListAdapter(this.eGV.getPageContext().getPageActivity());
        this.eGZ.a(this);
        this.eGY.setAdapter((ListAdapter) this.eGZ);
        this.eGY.setOnItemClickListener(this.mItemClickListener);
        this.eGY.setOnItemLongClickListener(this.eHj);
        this.cFr = new View(this.eGV.getFragmentActivity());
        this.cFr.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.eGV.getFragmentActivity(), d.e.ds150)));
        this.eGY.addFooterView(this.cFr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eGV.getPageContext(), i);
        }
        if (this.eHa != null) {
            this.eHa.onChangeSkinType(i);
        }
        if (this.eGZ != null) {
            this.eGZ.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.diD);
            return true;
        }
        return true;
    }

    private void ie(boolean z) {
        if (z) {
            aOP();
        } else {
            aOQ();
        }
    }

    private void aOP() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.hv().ax("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eGV.getResources().getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.eGV.getPageContext().getPageActivity(), this.diD, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eGV.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.du(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aOQ() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.eGV.getResources().getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.eGV.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ba.aU(e.this.eGV.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.eGV.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.eGV.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.eGV.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.eGV.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eGV.getPageContext().getPageActivity(), this.diD, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.D(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.eGV.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        F(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.eHc = new b.InterfaceC0101b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.eGW.asyncDeleteItem(imMessageCenterShowItemData, e.this.enr);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.eGV.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.eHb = new com.baidu.tbadk.core.dialog.b(this.eGV.getPageContext().getPageActivity());
        this.eHb.ci(d.j.operation);
        this.eHb.a(new String[]{string}, this.eHc);
        this.eHb.d(this.eGV.getPageContext());
    }

    protected boolean eJ(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.eGY.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    /* renamed from: if  reason: not valid java name */
    public void m16if(boolean z) {
        if (z) {
            if (aOR() && this.eHa.getVisibility() != 0) {
                this.eHa.setVisibility(0);
            }
        } else if (this.eHa.getVisibility() != 8) {
            this.eHa.setVisibility(8);
        }
    }

    public void F(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eGY.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.diD.removeView(this.mNoDataView);
        }
        ie(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.eGY.setVisibility(8);
    }

    public boolean aOR() {
        return this.eHe;
    }

    public void ig(boolean z) {
        this.eHe = z;
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
                if (this.eGW != null) {
                    this.eGW.insertOrUpdate(data, this.enq);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eGW != null) {
                this.eGW.remove(data, this.enq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.eGW != null) {
                this.eGW.setData(data, this.enq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eHi = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eHi != -1) {
                ic(true);
                onPrimary();
            }
        }
    }

    public void ib(boolean z) {
        if (z && this.eGY != null && this.eGY.getWrappedAdapter() != null && this.eGY.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.eGY.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aS(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                aOS();
            }
        }
    }

    private void aOS() {
        if (this.eGZ != null) {
            this.eGZ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asg() {
        ZB();
        if (this.enn == null) {
            this.enn = com.baidu.tieba.im.db.e.aJB().bK(getPageContext().getPageActivity());
        }
        this.enn.show();
        this.enn.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZB() {
        if (this.enn != null && this.enn.isShowing()) {
            this.enn.dismiss();
            this.enn = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHS() {
        if (this.eGY != null && this.eGW != null) {
            this.eGY.completePullRefreshPostDelayed(2000L);
            if (this.eGW.getData() != null) {
                this.eGZ.setData(this.eGW.getData());
            } else {
                F(isLogin(), true);
            }
        }
    }
}
