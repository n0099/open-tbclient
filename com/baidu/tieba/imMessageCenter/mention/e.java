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
import com.baidu.tbadk.core.util.bd;
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
    private int bZw;
    private final CustomMessageListener ciq;
    private boolean cyi;
    private View eve;
    private RelativeLayout fqt;
    private com.baidu.tbadk.core.dialog.d gCm;
    private final CustomMessageListener gCn;
    private com.baidu.tieba.im.chat.a.a gCp;
    private final com.baidu.tieba.im.chat.a.b gCq;
    private final ChatAggregationFragment gVN;
    private ImMessageCenterModel gVO;
    private ImMessageCenterShowItemData gVP;
    private BdListView gVQ;
    private MessageAggregationListAdapter gVR;
    private ShutDownValidateTipView gVS;
    com.baidu.tbadk.core.dialog.i gVT;
    private k.c gVU;
    private boolean gVV;
    private boolean gVW;
    private int gVX;
    private final AdapterView.OnItemLongClickListener gVY;
    private boolean isNeedRefresh;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ab(chatAggregationFragment.getPageContext().getPageActivity()));
        this.gVO = null;
        this.gVP = null;
        this.gVQ = null;
        this.gVR = null;
        this.gVT = null;
        this.gVV = true;
        this.cyi = false;
        this.isNeedRefresh = false;
        this.gVW = true;
        this.gVX = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData vh = e.this.gVR.getItem(i);
                    TiebaStatic.eventStat(e.this.gVN.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = vh.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(vh);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gVN.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.gVN.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.gVN.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(vh.getFriendId(), 0L), vh.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (vh.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gVN.getPageContext().getOrignalPage(), 2008021)) {
                            d(vh);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.anF().aob() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.anF().aob().jC(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.gVN.getPageContext().getPageActivity())));
                        }
                    } else if (vh.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gVN.getPageContext().getOrignalPage(), 2008013)) {
                            d(vh);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.anF().aob() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.anF().aob().jB(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.gVN.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gVN.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.gVN.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gVN.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.gVN.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(vh.getFriendId(), 0L), vh.getFriendName(), vh.getFriendPortrait(), 0, vh.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new an("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.gVN.getPageContext().getPageActivity())));
                    } else {
                        e(vh);
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
                                com.baidu.tieba.im.db.d.bCO().yP("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.bCO().yP("group_intro_change");
                                com.baidu.tieba.im.db.d.bCO().yP("group_name_change");
                                com.baidu.tieba.im.db.d.bCO().yP("group_notice_change");
                                com.baidu.tieba.im.db.d.bCO().yP("group_level_up");
                                com.baidu.tieba.im.db.d.bCO().yP("dismiss_group");
                                com.baidu.tieba.im.db.d.bCO().yP("kick_out");
                                com.baidu.tieba.im.db.d.bCO().yP("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.anF().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.anF().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.gVN.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.gVY = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.gVP = e.this.gVR.getItem(i);
                e.this.c(e.this.gVP);
                if (e.this.gVT != null) {
                    TiebaStatic.log("c12932");
                    e.this.gVT.showDialog();
                    if (e.this.gVN != null && e.this.gVN.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.gVN.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.gCn = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.gVO.setData(null, e.this.gCp);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.gVR != null) {
                            e.this.gVR.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.gVR != null) {
                        e.this.gVR.notifyDataSetChanged();
                    }
                }
            }
        };
        this.gCp = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.bBg();
            }
        };
        this.ciq = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.gCq = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.bjQ();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.gCm != null) {
                    e.this.gCm.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.azR();
                e.this.gVN.showToast(R.string.delete_success, false);
                e.this.bBg();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.azR();
            }
        };
        this.gVN = chatAggregationFragment;
    }

    public void R(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.gVX = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.gVX = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.gVX);
        }
    }

    public void bsA() {
        if (this.gVR != null) {
            this.gVR.notifyDataSetChanged();
        }
    }

    public void aFQ() {
        MessageManager.getInstance().unRegisterListener(this.gCn);
        MessageManager.getInstance().unRegisterListener(this.ciq);
    }

    public View aLp() {
        this.bZw = 3;
        this.rootView = LayoutInflater.from(this.gVN.getPageContext().getPageActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bN(this.rootView);
        TiebaStatic.eventStat(this.gVN.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        bbe();
        return this.rootView;
    }

    protected void bbe() {
        this.gVQ.startPullRefresh();
        this.cyi = isLogin();
        if (!this.cyi) {
            T(this.cyi, true);
        }
    }

    private void registerListener() {
        this.gVN.registerListener(2016004, this.gCn);
        this.gVN.registerListener(2016001, this.gCn);
        this.gVN.registerListener(2016010, this.gCn);
        this.gVN.registerListener(2016007, this.gCn);
        this.gVN.registerListener(2016011, this.gCn);
        this.gVN.registerListener(2016002, this.gCn);
        this.gVN.registerListener(this.ciq);
    }

    public void mL(boolean z) {
        this.isNeedRefresh = z;
    }

    public void mM(boolean z) {
        this.gVW = z;
    }

    public void onPrimary() {
        if (this.gVR != null && this.gVR.getCount() == 0) {
            mL(true);
        }
        if (this.gVW || this.isNeedRefresh) {
            this.gVW = false;
            this.isNeedRefresh = false;
            iP(false);
        }
        boolean isLogin = isLogin();
        if (this.cyi != isLogin) {
            this.cyi = isLogin;
            onUserChanged(this.cyi);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gVN.getPageContext());
        }
    }

    private void initData() {
        this.gVO = new ImMessageCenterModel();
        mP(com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bN(View view) {
        this.fqt = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.gVS = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.gVS.setVisibility(8);
        this.gVS.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("is_shut_down_validate", true);
                e.this.mP(false);
                e.this.mO(false);
            }
        });
        this.gVQ = (BdListView) view.findViewById(R.id.chat_list_content);
        this.gVQ.setDividerHeight(0);
        this.gVR = new MessageAggregationListAdapter(this.gVN.getPageContext().getPageActivity());
        this.gVR.a(this);
        this.gVQ.setAdapter((ListAdapter) this.gVR);
        this.gVQ.setOnItemClickListener(this.mItemClickListener);
        this.gVQ.setOnItemLongClickListener(this.gVY);
        this.eve = new View(this.gVN.getFragmentActivity());
        this.eve.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.gVN.getFragmentActivity(), R.dimen.ds150)));
        this.gVQ.addFooterView(this.eve);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gVN.getPageContext(), i);
        }
        if (this.gVS != null) {
            this.gVS.onChangeSkinType(i);
        }
        if (this.gVR != null) {
            this.gVR.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.fqt);
            return true;
        }
        return true;
    }

    private void mN(boolean z) {
        if (z) {
            bHZ();
        } else {
            bIa();
        }
    }

    private void bHZ() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.hS().az("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gVN.getResources().getString(R.string.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.gVN.getPageContext().getPageActivity(), this.fqt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iN(R.string.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bIa() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.gVN.getResources().getString(R.string.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.gVN.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bd.cE(e.this.gVN.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.gVN.getResources().getDimensionPixelSize(R.dimen.ds320);
        int dimensionPixelSize2 = this.gVN.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.gVN.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.gVN.getResources().getDimensionPixelSize(R.dimen.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.gVN.getPageContext().getPageActivity(), this.fqt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.af(R.string.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.gVN.getResources().getDimensionPixelSize(R.dimen.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        T(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.gVU = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.gVT != null && e.this.gVT.isShowing() && e.this.gVN != null) {
                    e.this.gVT.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.gVO.asyncDeleteItem(imMessageCenterShowItemData, e.this.gCq);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.gVN.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.gVT = new com.baidu.tbadk.core.dialog.i(this.gVN.getPageContext());
        this.gVT.a(null, new String[]{string}, this.gVU);
    }

    protected boolean iP(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.gVQ.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void mO(boolean z) {
        if (z) {
            if (bIb() && this.gVS.getVisibility() != 0) {
                this.gVS.setVisibility(0);
            }
        } else if (this.gVS.getVisibility() != 8) {
            this.gVS.setVisibility(8);
        }
    }

    public void T(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gVQ.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.fqt.removeView(this.mNoDataView);
        }
        mN(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.gVQ.setVisibility(8);
    }

    public boolean bIb() {
        return this.gVV;
    }

    public void mP(boolean z) {
        this.gVV = z;
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
                if (this.gVO != null) {
                    this.gVO.insertOrUpdate(data, this.gCp);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.gVO != null) {
                this.gVO.remove(data, this.gCp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.gVO != null) {
                this.gVO.setData(data, this.gCp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.gVX = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.gVX != -1) {
                mL(true);
                onPrimary();
            }
        }
    }

    public void mK(boolean z) {
        if (z && this.gVQ != null && this.gVQ.getWrappedAdapter() != null && this.gVQ.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gVQ.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                bIc();
            }
        }
    }

    private void bIc() {
        if (this.gVR != null) {
            this.gVR.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjQ() {
        azR();
        if (this.gCm == null) {
            this.gCm = com.baidu.tieba.im.db.e.bCP().dQ(getPageContext().getPageActivity());
        }
        this.gCm.show();
        this.gCm.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azR() {
        if (this.gCm != null && this.gCm.isShowing()) {
            this.gCm.dismiss();
            this.gCm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBg() {
        if (this.gVQ != null && this.gVO != null) {
            this.gVQ.completePullRefreshPostDelayed(0L);
            if (this.gVO.getData() != null) {
                this.gVR.setData(this.gVO.getData());
            } else {
                T(isLogin(), true);
            }
        }
    }
}
