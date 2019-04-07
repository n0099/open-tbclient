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
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
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
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements h.c {
    private int bQy;
    private final CustomMessageListener bZe;
    private boolean coD;
    private RelativeLayout eUK;
    private View eoA;
    private com.baidu.tbadk.core.dialog.d gdT;
    private final CustomMessageListener gdU;
    private com.baidu.tieba.im.chat.a.a gdW;
    private final com.baidu.tieba.im.chat.a.b gdX;
    com.baidu.tbadk.core.dialog.g gxA;
    private i.c gxB;
    private boolean gxC;
    private boolean gxD;
    private boolean gxE;
    private int gxF;
    private final AdapterView.OnItemLongClickListener gxG;
    private final ChatAggregationFragment gxu;
    private ImMessageCenterModel gxv;
    private ImMessageCenterShowItemData gxw;
    private BdListView gxx;
    private MessageAggregationListAdapter gxy;
    private ShutDownValidateTipView gxz;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.aK(chatAggregationFragment.getPageContext().getPageActivity()));
        this.gxv = null;
        this.gxw = null;
        this.gxx = null;
        this.gxy = null;
        this.gxA = null;
        this.gxC = true;
        this.coD = false;
        this.gxD = false;
        this.gxE = true;
        this.gxF = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData tx = e.this.gxy.getItem(i);
                    TiebaStatic.eventStat(e.this.gxu.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = tx.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(tx);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gxu.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.gxu.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.gxu.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(tx.getFriendId(), 0L), tx.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (tx.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gxu.getPageContext().getOrignalPage(), 2008021)) {
                            d(tx);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.ahx().ahT() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.ahx().ahT().iH(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.gxu.getPageContext().getPageActivity())));
                        }
                    } else if (tx.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gxu.getPageContext().getOrignalPage(), 2008013)) {
                            d(tx);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.ahx().ahT() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.ahx().ahT().iG(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.gxu.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gxu.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.gxu.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gxu.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.gxu.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(tx.getFriendId(), 0L), tx.getFriendName(), tx.getFriendPortrait(), 0, tx.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new am("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.gxu.getPageContext().getPageActivity())));
                    } else {
                        e(tx);
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
                                com.baidu.tieba.im.db.d.bsf().wN("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.bsf().wN("group_intro_change");
                                com.baidu.tieba.im.db.d.bsf().wN("group_name_change");
                                com.baidu.tieba.im.db.d.bsf().wN("group_notice_change");
                                com.baidu.tieba.im.db.d.bsf().wN("group_level_up");
                                com.baidu.tieba.im.db.d.bsf().wN("dismiss_group");
                                com.baidu.tieba.im.db.d.bsf().wN("kick_out");
                                com.baidu.tieba.im.db.d.bsf().wN("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahx().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.ahx().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.gxu.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.gxG = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.gxw = e.this.gxy.getItem(i);
                e.this.c(e.this.gxw);
                if (e.this.gxA != null) {
                    TiebaStatic.log("c12932");
                    e.this.gxA.showDialog();
                    if (e.this.gxu != null && e.this.gxu.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.gxu.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.gdU = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.gxv.setData(null, e.this.gdW);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.gxy != null) {
                            e.this.gxy.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.gxy != null) {
                        e.this.gxy.notifyDataSetChanged();
                    }
                }
            }
        };
        this.gdW = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.bqy();
            }
        };
        this.bZe = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.gdX = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.bak();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.gdT != null) {
                    e.this.gdT.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.atv();
                e.this.gxu.showToast(d.j.delete_success, false);
                e.this.bqy();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.atv();
            }
        };
        this.gxu = chatAggregationFragment;
    }

    public void Q(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.gxF = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.gxF = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.gxF);
        }
    }

    public void biP() {
        if (this.gxy != null) {
            this.gxy.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gdU);
        MessageManager.getInstance().unRegisterListener(this.bZe);
    }

    public View aDs() {
        this.bQy = 3;
        this.rootView = LayoutInflater.from(this.gxu.getPageContext().getPageActivity()).inflate(d.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        bD(this.rootView);
        TiebaStatic.eventStat(this.gxu.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        aRR();
        return this.rootView;
    }

    protected void aRR() {
        this.gxx.startPullRefresh();
        this.coD = isLogin();
        if (!this.coD) {
            P(this.coD, true);
        }
    }

    private void registerListener() {
        this.gxu.registerListener(2016004, this.gdU);
        this.gxu.registerListener(2016001, this.gdU);
        this.gxu.registerListener(2016010, this.gdU);
        this.gxu.registerListener(2016007, this.gdU);
        this.gxu.registerListener(2016011, this.gdU);
        this.gxu.registerListener(2016002, this.gdU);
        this.gxu.registerListener(this.bZe);
    }

    public void lH(boolean z) {
        this.gxD = z;
    }

    public void lI(boolean z) {
        this.gxE = z;
    }

    public void onPrimary() {
        if (this.gxy != null && this.gxy.getCount() == 0) {
            lH(true);
        }
        if (this.gxE || this.gxD) {
            this.gxE = false;
            this.gxD = false;
            ib(false);
        }
        boolean isLogin = isLogin();
        if (this.coD != isLogin) {
            this.coD = isLogin;
            onUserChanged(this.coD);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gxu.getPageContext());
        }
    }

    private void initData() {
        this.gxv = new ImMessageCenterModel();
        lL(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bD(View view) {
        this.eUK = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.gxz = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.gxz.setVisibility(8);
        this.gxz.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.lL(false);
                e.this.lK(false);
            }
        });
        this.gxx = (BdListView) view.findViewById(d.g.chat_list_content);
        this.gxx.setDividerHeight(0);
        this.gxy = new MessageAggregationListAdapter(this.gxu.getPageContext().getPageActivity());
        this.gxy.a(this);
        this.gxx.setAdapter((ListAdapter) this.gxy);
        this.gxx.setOnItemClickListener(this.mItemClickListener);
        this.gxx.setOnItemLongClickListener(this.gxG);
        this.eoA = new View(this.gxu.getFragmentActivity());
        this.eoA.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.gxu.getFragmentActivity(), d.e.ds150)));
        this.gxx.addFooterView(this.eoA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gxu.getPageContext(), i);
        }
        if (this.gxz != null) {
            this.gxz.onChangeSkinType(i);
        }
        if (this.gxy != null) {
            this.gxy.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.eUK);
            return true;
        }
        return true;
    }

    private void lJ(boolean z) {
        if (z) {
            bxs();
        } else {
            bxt();
        }
    }

    private void bxs() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gxu.getResources().getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.gxu.getPageContext().getPageActivity(), this.eUK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.hT(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bxt() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.gxu.getResources().getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.gxu.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bc.cY(e.this.gxu.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.gxu.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.gxu.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.gxu.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.gxu.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.gxu.getPageContext().getPageActivity(), this.eUK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.ac(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.gxu.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        P(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.gxB = new i.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
                if (e.this.gxA != null && e.this.gxA.isShowing() && e.this.gxu != null) {
                    e.this.gxA.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.gxv.asyncDeleteItem(imMessageCenterShowItemData, e.this.gdX);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.gxu.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.gxA = new com.baidu.tbadk.core.dialog.g(this.gxu.getPageContext());
        this.gxA.a(null, new String[]{string}, this.gxB);
    }

    protected boolean ib(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.gxx.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void lK(boolean z) {
        if (z) {
            if (bxu() && this.gxz.getVisibility() != 0) {
                this.gxz.setVisibility(0);
            }
        } else if (this.gxz.getVisibility() != 8) {
            this.gxz.setVisibility(8);
        }
    }

    public void P(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gxx.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.eUK.removeView(this.mNoDataView);
        }
        lJ(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.gxx.setVisibility(8);
    }

    public boolean bxu() {
        return this.gxC;
    }

    public void lL(boolean z) {
        this.gxC = z;
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
                if (this.gxv != null) {
                    this.gxv.insertOrUpdate(data, this.gdW);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.gxv != null) {
                this.gxv.remove(data, this.gdW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.gxv != null) {
                this.gxv.setData(data, this.gdW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.gxF = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.gxF != -1) {
                lH(true);
                onPrimary();
            }
        }
    }

    public void lG(boolean z) {
        if (z && this.gxx != null && this.gxx.getWrappedAdapter() != null && this.gxx.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gxx.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                bxv();
            }
        }
    }

    private void bxv() {
        if (this.gxy != null) {
            this.gxy.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bak() {
        atv();
        if (this.gdT == null) {
            this.gdT = com.baidu.tieba.im.db.e.bsg().dY(getPageContext().getPageActivity());
        }
        this.gdT.show();
        this.gdT.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atv() {
        if (this.gdT != null && this.gdT.isShowing()) {
            this.gdT.dismiss();
            this.gdT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqy() {
        if (this.gxx != null && this.gxv != null) {
            this.gxx.completePullRefreshPostDelayed(0L);
            if (this.gxv.getData() != null) {
                this.gxy.setData(this.gxv.getData());
            } else {
                P(isLogin(), true);
            }
        }
    }
}
