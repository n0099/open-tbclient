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
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.R;
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
    private int cap;
    private final CustomMessageListener cjl;
    private boolean cze;
    private View ewO;
    private RelativeLayout fsh;
    private com.baidu.tbadk.core.dialog.d gEd;
    private final CustomMessageListener gEe;
    private com.baidu.tieba.im.chat.a.a gEg;
    private final com.baidu.tieba.im.chat.a.b gEh;
    private final ChatAggregationFragment gXH;
    private ImMessageCenterModel gXI;
    private ImMessageCenterShowItemData gXJ;
    private BdListView gXK;
    private MessageAggregationListAdapter gXL;
    private ShutDownValidateTipView gXM;
    com.baidu.tbadk.core.dialog.i gXN;
    private k.c gXO;
    private boolean gXP;
    private boolean gXQ;
    private int gXR;
    private final AdapterView.OnItemLongClickListener gXS;
    private boolean isNeedRefresh;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ab(chatAggregationFragment.getPageContext().getPageActivity()));
        this.gXI = null;
        this.gXJ = null;
        this.gXK = null;
        this.gXL = null;
        this.gXN = null;
        this.gXP = true;
        this.cze = false;
        this.isNeedRefresh = false;
        this.gXQ = true;
        this.gXR = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData vl = e.this.gXL.getItem(i);
                    TiebaStatic.eventStat(e.this.gXH.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = vl.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(vl);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gXH.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.gXH.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.gXH.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.e(vl.getFriendId(), 0L), vl.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (vl.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gXH.getPageContext().getOrignalPage(), 2008021)) {
                            d(vl);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.anR().aon() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.anR().aon().jF(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.gXH.getPageContext().getPageActivity())));
                        }
                    } else if (vl.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gXH.getPageContext().getOrignalPage(), 2008013)) {
                            d(vl);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.anR().aon() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.anR().aon().jE(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.gXH.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gXH.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.gXH.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gXH.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.gXH.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.e(vl.getFriendId(), 0L), vl.getFriendName(), vl.getFriendPortrait(), 0, vl.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new an("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.gXH.getPageContext().getPageActivity())));
                    } else {
                        e(vl);
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
                                com.baidu.tieba.im.db.d.bDC().zo("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.bDC().zo("group_intro_change");
                                com.baidu.tieba.im.db.d.bDC().zo("group_name_change");
                                com.baidu.tieba.im.db.d.bDC().zo("group_notice_change");
                                com.baidu.tieba.im.db.d.bDC().zo("group_level_up");
                                com.baidu.tieba.im.db.d.bDC().zo("dismiss_group");
                                com.baidu.tieba.im.db.d.bDC().zo("kick_out");
                                com.baidu.tieba.im.db.d.bDC().zo("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.anR().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.anR().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.gXH.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.gXS = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.gXJ = e.this.gXL.getItem(i);
                e.this.c(e.this.gXJ);
                if (e.this.gXN != null) {
                    TiebaStatic.log("c12932");
                    e.this.gXN.showDialog();
                    if (e.this.gXH != null && e.this.gXH.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.gXH.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.gEe = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.gXI.setData(null, e.this.gEg);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.gXL != null) {
                            e.this.gXL.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.gXL != null) {
                        e.this.gXL.notifyDataSetChanged();
                    }
                }
            }
        };
        this.gEg = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.bBU();
            }
        };
        this.cjl = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.gEh = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.bkB();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.gEd != null) {
                    e.this.gEd.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.aAd();
                e.this.gXH.showToast(R.string.delete_success, false);
                e.this.bBU();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.aAd();
            }
        };
        this.gXH = chatAggregationFragment;
    }

    public void R(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.gXR = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.gXR = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.gXR);
        }
    }

    public void btn() {
        if (this.gXL != null) {
            this.gXL.notifyDataSetChanged();
        }
    }

    public void aGu() {
        MessageManager.getInstance().unRegisterListener(this.gEe);
        MessageManager.getInstance().unRegisterListener(this.cjl);
    }

    public View aLT() {
        this.cap = 3;
        this.rootView = LayoutInflater.from(this.gXH.getPageContext().getPageActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bM(this.rootView);
        TiebaStatic.eventStat(this.gXH.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        bbI();
        return this.rootView;
    }

    protected void bbI() {
        this.gXK.startPullRefresh();
        this.cze = isLogin();
        if (!this.cze) {
            T(this.cze, true);
        }
    }

    private void registerListener() {
        this.gXH.registerListener(2016004, this.gEe);
        this.gXH.registerListener(2016001, this.gEe);
        this.gXH.registerListener(2016010, this.gEe);
        this.gXH.registerListener(2016007, this.gEe);
        this.gXH.registerListener(2016011, this.gEe);
        this.gXH.registerListener(2016002, this.gEe);
        this.gXH.registerListener(this.cjl);
    }

    public void mO(boolean z) {
        this.isNeedRefresh = z;
    }

    public void mP(boolean z) {
        this.gXQ = z;
    }

    public void onPrimary() {
        if (this.gXL != null && this.gXL.getCount() == 0) {
            mO(true);
        }
        if (this.gXQ || this.isNeedRefresh) {
            this.gXQ = false;
            this.isNeedRefresh = false;
            iS(false);
        }
        boolean isLogin = isLogin();
        if (this.cze != isLogin) {
            this.cze = isLogin;
            onUserChanged(this.cze);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gXH.getPageContext());
        }
    }

    private void initData() {
        this.gXI = new ImMessageCenterModel();
        mS(com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bM(View view) {
        this.fsh = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.gXM = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.gXM.setVisibility(8);
        this.gXM.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("is_shut_down_validate", true);
                e.this.mS(false);
                e.this.mR(false);
            }
        });
        this.gXK = (BdListView) view.findViewById(R.id.chat_list_content);
        this.gXK.setDividerHeight(0);
        this.gXL = new MessageAggregationListAdapter(this.gXH.getPageContext().getPageActivity());
        this.gXL.a(this);
        this.gXK.setAdapter((ListAdapter) this.gXL);
        this.gXK.setOnItemClickListener(this.mItemClickListener);
        this.gXK.setOnItemLongClickListener(this.gXS);
        this.ewO = new View(this.gXH.getFragmentActivity());
        this.ewO.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.gXH.getFragmentActivity(), R.dimen.ds150)));
        this.gXK.addFooterView(this.ewO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gXH.getPageContext(), i);
        }
        if (this.gXM != null) {
            this.gXM.onChangeSkinType(i);
        }
        if (this.gXL != null) {
            this.gXL.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.fsh);
            return true;
        }
        return true;
    }

    private void mQ(boolean z) {
        if (z) {
            bIN();
        } else {
            bIO();
        }
    }

    private void bIN() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.hS().az("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gXH.getResources().getString(R.string.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.gXH.getPageContext().getPageActivity(), this.fsh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iQ(R.string.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bIO() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.gXH.getResources().getString(R.string.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.gXH.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bc.cE(e.this.gXH.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.gXH.getResources().getDimensionPixelSize(R.dimen.ds320);
        int dimensionPixelSize2 = this.gXH.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.gXH.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.gXH.getResources().getDimensionPixelSize(R.dimen.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.gXH.getPageContext().getPageActivity(), this.fsh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.af(R.string.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.gXH.getResources().getDimensionPixelSize(R.dimen.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        T(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.gXO = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.gXN != null && e.this.gXN.isShowing() && e.this.gXH != null) {
                    e.this.gXN.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.gXI.asyncDeleteItem(imMessageCenterShowItemData, e.this.gEh);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.gXH.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.gXN = new com.baidu.tbadk.core.dialog.i(this.gXH.getPageContext());
        this.gXN.a(null, new String[]{string}, this.gXO);
    }

    protected boolean iS(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.gXK.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void mR(boolean z) {
        if (z) {
            if (bIP() && this.gXM.getVisibility() != 0) {
                this.gXM.setVisibility(0);
            }
        } else if (this.gXM.getVisibility() != 8) {
            this.gXM.setVisibility(8);
        }
    }

    public void T(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gXK.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.fsh.removeView(this.mNoDataView);
        }
        mQ(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.gXK.setVisibility(8);
    }

    public boolean bIP() {
        return this.gXP;
    }

    public void mS(boolean z) {
        this.gXP = z;
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
                if (this.gXI != null) {
                    this.gXI.insertOrUpdate(data, this.gEg);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.gXI != null) {
                this.gXI.remove(data, this.gEg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.gXI != null) {
                this.gXI.setData(data, this.gEg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.gXR = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.gXR != -1) {
                mO(true);
                onPrimary();
            }
        }
    }

    public void mN(boolean z) {
        if (z && this.gXK != null && this.gXK.getWrappedAdapter() != null && this.gXK.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gXK.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void eu(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                bIQ();
            }
        }
    }

    private void bIQ() {
        if (this.gXL != null) {
            this.gXL.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkB() {
        aAd();
        if (this.gEd == null) {
            this.gEd = com.baidu.tieba.im.db.e.bDD().dR(getPageContext().getPageActivity());
        }
        this.gEd.show();
        this.gEd.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAd() {
        if (this.gEd != null && this.gEd.isShowing()) {
            this.gEd.dismiss();
            this.gEd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBU() {
        if (this.gXK != null && this.gXI != null) {
            this.gXK.completePullRefreshPostDelayed(0L);
            if (this.gXI.getData() != null) {
                this.gXL.setData(this.gXI.getData());
            } else {
                T(isLogin(), true);
            }
        }
    }
}
