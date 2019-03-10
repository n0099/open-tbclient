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
    private int bQv;
    private final CustomMessageListener bZb;
    private boolean coB;
    private RelativeLayout eVc;
    private View eoS;
    private com.baidu.tbadk.core.dialog.d geg;
    private final CustomMessageListener geh;
    private com.baidu.tieba.im.chat.a.a gej;
    private final com.baidu.tieba.im.chat.a.b gek;
    private final ChatAggregationFragment gxI;
    private ImMessageCenterModel gxJ;
    private ImMessageCenterShowItemData gxK;
    private BdListView gxL;
    private MessageAggregationListAdapter gxM;
    private ShutDownValidateTipView gxN;
    com.baidu.tbadk.core.dialog.g gxO;
    private i.c gxP;
    private boolean gxQ;
    private boolean gxR;
    private boolean gxS;
    private int gxT;
    private final AdapterView.OnItemLongClickListener gxU;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.aK(chatAggregationFragment.getPageContext().getPageActivity()));
        this.gxJ = null;
        this.gxK = null;
        this.gxL = null;
        this.gxM = null;
        this.gxO = null;
        this.gxQ = true;
        this.coB = false;
        this.gxR = false;
        this.gxS = true;
        this.gxT = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData tB = e.this.gxM.getItem(i);
                    TiebaStatic.eventStat(e.this.gxI.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = tB.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(tB);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gxI.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.gxI.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.gxI.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(tB.getFriendId(), 0L), tB.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (tB.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gxI.getPageContext().getOrignalPage(), 2008021)) {
                            d(tB);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahW() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahW().iI(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.gxI.getPageContext().getPageActivity())));
                        }
                    } else if (tB.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gxI.getPageContext().getOrignalPage(), 2008013)) {
                            d(tB);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahW() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahW().iH(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.gxI.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gxI.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.gxI.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gxI.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.gxI.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(tB.getFriendId(), 0L), tB.getFriendName(), tB.getFriendPortrait(), 0, tB.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new am("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.gxI.getPageContext().getPageActivity())));
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
                                com.baidu.tieba.im.db.d.bsj().wQ("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.bsj().wQ("group_intro_change");
                                com.baidu.tieba.im.db.d.bsj().wQ("group_name_change");
                                com.baidu.tieba.im.db.d.bsj().wQ("group_notice_change");
                                com.baidu.tieba.im.db.d.bsj().wQ("group_level_up");
                                com.baidu.tieba.im.db.d.bsj().wQ("dismiss_group");
                                com.baidu.tieba.im.db.d.bsj().wQ("kick_out");
                                com.baidu.tieba.im.db.d.bsj().wQ("group_activitys_change");
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.gxI.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.gxU = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.gxK = e.this.gxM.getItem(i);
                e.this.c(e.this.gxK);
                if (e.this.gxO != null) {
                    TiebaStatic.log("c12932");
                    e.this.gxO.showDialog();
                    if (e.this.gxI != null && e.this.gxI.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.gxI.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.geh = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.gxJ.setData(null, e.this.gej);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.gxM != null) {
                            e.this.gxM.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.gxM != null) {
                        e.this.gxM.notifyDataSetChanged();
                    }
                }
            }
        };
        this.gej = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.bqC();
            }
        };
        this.bZb = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.gek = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.ban();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.geg != null) {
                    e.this.geg.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.atz();
                e.this.gxI.showToast(d.j.delete_success, false);
                e.this.bqC();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.atz();
            }
        };
        this.gxI = chatAggregationFragment;
    }

    public void Q(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.gxT = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.gxT = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.gxT);
        }
    }

    public void biS() {
        if (this.gxM != null) {
            this.gxM.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.geh);
        MessageManager.getInstance().unRegisterListener(this.bZb);
    }

    public View aDw() {
        this.bQv = 3;
        this.rootView = LayoutInflater.from(this.gxI.getPageContext().getPageActivity()).inflate(d.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        bD(this.rootView);
        TiebaStatic.eventStat(this.gxI.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        aRU();
        return this.rootView;
    }

    protected void aRU() {
        this.gxL.startPullRefresh();
        this.coB = isLogin();
        if (!this.coB) {
            R(this.coB, true);
        }
    }

    private void registerListener() {
        this.gxI.registerListener(2016004, this.geh);
        this.gxI.registerListener(2016001, this.geh);
        this.gxI.registerListener(2016010, this.geh);
        this.gxI.registerListener(2016007, this.geh);
        this.gxI.registerListener(2016011, this.geh);
        this.gxI.registerListener(2016002, this.geh);
        this.gxI.registerListener(this.bZb);
    }

    public void lH(boolean z) {
        this.gxR = z;
    }

    public void lI(boolean z) {
        this.gxS = z;
    }

    public void onPrimary() {
        if (this.gxM != null && this.gxM.getCount() == 0) {
            lH(true);
        }
        if (this.gxS || this.gxR) {
            this.gxS = false;
            this.gxR = false;
            ib(false);
        }
        boolean isLogin = isLogin();
        if (this.coB != isLogin) {
            this.coB = isLogin;
            onUserChanged(this.coB);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gxI.getPageContext());
        }
    }

    private void initData() {
        this.gxJ = new ImMessageCenterModel();
        lL(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bD(View view) {
        this.eVc = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.gxN = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.gxN.setVisibility(8);
        this.gxN.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.lL(false);
                e.this.lK(false);
            }
        });
        this.gxL = (BdListView) view.findViewById(d.g.chat_list_content);
        this.gxL.setDividerHeight(0);
        this.gxM = new MessageAggregationListAdapter(this.gxI.getPageContext().getPageActivity());
        this.gxM.a(this);
        this.gxL.setAdapter((ListAdapter) this.gxM);
        this.gxL.setOnItemClickListener(this.mItemClickListener);
        this.gxL.setOnItemLongClickListener(this.gxU);
        this.eoS = new View(this.gxI.getFragmentActivity());
        this.eoS.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.gxI.getFragmentActivity(), d.e.ds150)));
        this.gxL.addFooterView(this.eoS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gxI.getPageContext(), i);
        }
        if (this.gxN != null) {
            this.gxN.onChangeSkinType(i);
        }
        if (this.gxM != null) {
            this.gxM.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.eVc);
            return true;
        }
        return true;
    }

    private void lJ(boolean z) {
        if (z) {
            bxw();
        } else {
            bxx();
        }
    }

    private void bxw() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gxI.getResources().getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.gxI.getPageContext().getPageActivity(), this.eVc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.hU(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bxx() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.gxI.getResources().getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.gxI.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bc.cY(e.this.gxI.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.gxI.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.gxI.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.gxI.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.gxI.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.gxI.getPageContext().getPageActivity(), this.eVc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.ac(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.gxI.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        R(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.gxP = new i.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
                if (e.this.gxO != null && e.this.gxO.isShowing() && e.this.gxI != null) {
                    e.this.gxO.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.gxJ.asyncDeleteItem(imMessageCenterShowItemData, e.this.gek);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.gxI.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.gxO = new com.baidu.tbadk.core.dialog.g(this.gxI.getPageContext());
        this.gxO.a(null, new String[]{string}, this.gxP);
    }

    protected boolean ib(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.gxL.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void lK(boolean z) {
        if (z) {
            if (bxy() && this.gxN.getVisibility() != 0) {
                this.gxN.setVisibility(0);
            }
        } else if (this.gxN.getVisibility() != 8) {
            this.gxN.setVisibility(8);
        }
    }

    public void R(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gxL.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.eVc.removeView(this.mNoDataView);
        }
        lJ(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.gxL.setVisibility(8);
    }

    public boolean bxy() {
        return this.gxQ;
    }

    public void lL(boolean z) {
        this.gxQ = z;
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
                if (this.gxJ != null) {
                    this.gxJ.insertOrUpdate(data, this.gej);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.gxJ != null) {
                this.gxJ.remove(data, this.gej);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.gxJ != null) {
                this.gxJ.setData(data, this.gej);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.gxT = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.gxT != -1) {
                lH(true);
                onPrimary();
            }
        }
    }

    public void lG(boolean z) {
        if (z && this.gxL != null && this.gxL.getWrappedAdapter() != null && this.gxL.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gxL.startPullRefresh();
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
                bxz();
            }
        }
    }

    private void bxz() {
        if (this.gxM != null) {
            this.gxM.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ban() {
        atz();
        if (this.geg == null) {
            this.geg = com.baidu.tieba.im.db.e.bsk().dZ(getPageContext().getPageActivity());
        }
        this.geg.show();
        this.geg.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atz() {
        if (this.geg != null && this.geg.isShowing()) {
            this.geg.dismiss();
            this.geg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqC() {
        if (this.gxL != null && this.gxJ != null) {
            this.gxL.completePullRefreshPostDelayed(0L);
            if (this.gxJ.getData() != null) {
                this.gxM.setData(this.gxJ.getData());
            } else {
                R(isLogin(), true);
            }
        }
    }
}
