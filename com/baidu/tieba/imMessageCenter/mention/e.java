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
    private int bQw;
    private final CustomMessageListener bZc;
    private boolean coB;
    private RelativeLayout eUY;
    private View eoO;
    private com.baidu.tbadk.core.dialog.d gef;
    private final CustomMessageListener geg;
    private com.baidu.tieba.im.chat.a.a gei;
    private final com.baidu.tieba.im.chat.a.b gej;
    private final ChatAggregationFragment gxH;
    private ImMessageCenterModel gxI;
    private ImMessageCenterShowItemData gxJ;
    private BdListView gxK;
    private MessageAggregationListAdapter gxL;
    private ShutDownValidateTipView gxM;
    com.baidu.tbadk.core.dialog.g gxN;
    private i.c gxO;
    private boolean gxP;
    private boolean gxQ;
    private boolean gxR;
    private int gxS;
    private final AdapterView.OnItemLongClickListener gxT;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.aK(chatAggregationFragment.getPageContext().getPageActivity()));
        this.gxI = null;
        this.gxJ = null;
        this.gxK = null;
        this.gxL = null;
        this.gxN = null;
        this.gxP = true;
        this.coB = false;
        this.gxQ = false;
        this.gxR = true;
        this.gxS = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData tB = e.this.gxL.getItem(i);
                    TiebaStatic.eventStat(e.this.gxH.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = tB.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(tB);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gxH.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.gxH.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.gxH.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(tB.getFriendId(), 0L), tB.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (tB.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gxH.getPageContext().getOrignalPage(), 2008021)) {
                            d(tB);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahW() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahW().iI(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.gxH.getPageContext().getPageActivity())));
                        }
                    } else if (tB.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gxH.getPageContext().getOrignalPage(), 2008013)) {
                            d(tB);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahW() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahW().iH(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.gxH.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gxH.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.gxH.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gxH.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.gxH.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(tB.getFriendId(), 0L), tB.getFriendName(), tB.getFriendPortrait(), 0, tB.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new am("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.gxH.getPageContext().getPageActivity())));
                    } else {
                        e(tB);
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
                                com.baidu.tieba.im.db.d.bsi().wO("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.bsi().wO("group_intro_change");
                                com.baidu.tieba.im.db.d.bsi().wO("group_name_change");
                                com.baidu.tieba.im.db.d.bsi().wO("group_notice_change");
                                com.baidu.tieba.im.db.d.bsi().wO("group_level_up");
                                com.baidu.tieba.im.db.d.bsi().wO("dismiss_group");
                                com.baidu.tieba.im.db.d.bsi().wO("kick_out");
                                com.baidu.tieba.im.db.d.bsi().wO("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahA().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.ahA().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.gxH.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.gxT = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.gxJ = e.this.gxL.getItem(i);
                e.this.c(e.this.gxJ);
                if (e.this.gxN != null) {
                    TiebaStatic.log("c12932");
                    e.this.gxN.showDialog();
                    if (e.this.gxH != null && e.this.gxH.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.gxH.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.geg = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.gxI.setData(null, e.this.gei);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.gxL != null) {
                            e.this.gxL.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.gxL != null) {
                        e.this.gxL.notifyDataSetChanged();
                    }
                }
            }
        };
        this.gei = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.bqB();
            }
        };
        this.bZc = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.gej = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.bam();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.gef != null) {
                    e.this.gef.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.aty();
                e.this.gxH.showToast(d.j.delete_success, false);
                e.this.bqB();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.aty();
            }
        };
        this.gxH = chatAggregationFragment;
    }

    public void Q(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.gxS = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.gxS = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.gxS);
        }
    }

    public void biR() {
        if (this.gxL != null) {
            this.gxL.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.geg);
        MessageManager.getInstance().unRegisterListener(this.bZc);
    }

    public View aDv() {
        this.bQw = 3;
        this.rootView = LayoutInflater.from(this.gxH.getPageContext().getPageActivity()).inflate(d.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        bD(this.rootView);
        TiebaStatic.eventStat(this.gxH.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        aRT();
        return this.rootView;
    }

    protected void aRT() {
        this.gxK.startPullRefresh();
        this.coB = isLogin();
        if (!this.coB) {
            R(this.coB, true);
        }
    }

    private void registerListener() {
        this.gxH.registerListener(2016004, this.geg);
        this.gxH.registerListener(2016001, this.geg);
        this.gxH.registerListener(2016010, this.geg);
        this.gxH.registerListener(2016007, this.geg);
        this.gxH.registerListener(2016011, this.geg);
        this.gxH.registerListener(2016002, this.geg);
        this.gxH.registerListener(this.bZc);
    }

    public void lH(boolean z) {
        this.gxQ = z;
    }

    public void lI(boolean z) {
        this.gxR = z;
    }

    public void onPrimary() {
        if (this.gxL != null && this.gxL.getCount() == 0) {
            lH(true);
        }
        if (this.gxR || this.gxQ) {
            this.gxR = false;
            this.gxQ = false;
            ib(false);
        }
        boolean isLogin = isLogin();
        if (this.coB != isLogin) {
            this.coB = isLogin;
            onUserChanged(this.coB);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gxH.getPageContext());
        }
    }

    private void initData() {
        this.gxI = new ImMessageCenterModel();
        lL(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bD(View view) {
        this.eUY = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.gxM = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.gxM.setVisibility(8);
        this.gxM.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.lL(false);
                e.this.lK(false);
            }
        });
        this.gxK = (BdListView) view.findViewById(d.g.chat_list_content);
        this.gxK.setDividerHeight(0);
        this.gxL = new MessageAggregationListAdapter(this.gxH.getPageContext().getPageActivity());
        this.gxL.a(this);
        this.gxK.setAdapter((ListAdapter) this.gxL);
        this.gxK.setOnItemClickListener(this.mItemClickListener);
        this.gxK.setOnItemLongClickListener(this.gxT);
        this.eoO = new View(this.gxH.getFragmentActivity());
        this.eoO.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.gxH.getFragmentActivity(), d.e.ds150)));
        this.gxK.addFooterView(this.eoO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gxH.getPageContext(), i);
        }
        if (this.gxM != null) {
            this.gxM.onChangeSkinType(i);
        }
        if (this.gxL != null) {
            this.gxL.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.eUY);
            return true;
        }
        return true;
    }

    private void lJ(boolean z) {
        if (z) {
            bxv();
        } else {
            bxw();
        }
    }

    private void bxv() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gxH.getResources().getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.gxH.getPageContext().getPageActivity(), this.eUY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.hU(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bxw() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.gxH.getResources().getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.gxH.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bc.cY(e.this.gxH.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.gxH.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.gxH.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.gxH.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.gxH.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.gxH.getPageContext().getPageActivity(), this.eUY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.ac(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.gxH.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        R(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.gxO = new i.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
                if (e.this.gxN != null && e.this.gxN.isShowing() && e.this.gxH != null) {
                    e.this.gxN.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.gxI.asyncDeleteItem(imMessageCenterShowItemData, e.this.gej);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.gxH.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.gxN = new com.baidu.tbadk.core.dialog.g(this.gxH.getPageContext());
        this.gxN.a(null, new String[]{string}, this.gxO);
    }

    protected boolean ib(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.gxK.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void lK(boolean z) {
        if (z) {
            if (bxx() && this.gxM.getVisibility() != 0) {
                this.gxM.setVisibility(0);
            }
        } else if (this.gxM.getVisibility() != 8) {
            this.gxM.setVisibility(8);
        }
    }

    public void R(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gxK.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.eUY.removeView(this.mNoDataView);
        }
        lJ(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.gxK.setVisibility(8);
    }

    public boolean bxx() {
        return this.gxP;
    }

    public void lL(boolean z) {
        this.gxP = z;
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
                if (this.gxI != null) {
                    this.gxI.insertOrUpdate(data, this.gei);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.gxI != null) {
                this.gxI.remove(data, this.gei);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.gxI != null) {
                this.gxI.setData(data, this.gei);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.gxS = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.gxS != -1) {
                lH(true);
                onPrimary();
            }
        }
    }

    public void lG(boolean z) {
        if (z && this.gxK != null && this.gxK.getWrappedAdapter() != null && this.gxK.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gxK.startPullRefresh();
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
                bxy();
            }
        }
    }

    private void bxy() {
        if (this.gxL != null) {
            this.gxL.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bam() {
        aty();
        if (this.gef == null) {
            this.gef = com.baidu.tieba.im.db.e.bsj().dY(getPageContext().getPageActivity());
        }
        this.gef.show();
        this.gef.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aty() {
        if (this.gef != null && this.gef.isShowing()) {
            this.gef.dismiss();
            this.gef = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqB() {
        if (this.gxK != null && this.gxI != null) {
            this.gxK.completePullRefreshPostDelayed(0L);
            if (this.gxI.getData() != null) {
                this.gxL.setData(this.gxI.getData());
            } else {
                R(isLogin(), true);
            }
        }
    }
}
