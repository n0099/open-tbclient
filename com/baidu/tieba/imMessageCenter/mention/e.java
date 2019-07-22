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
    private int bZq;
    private final CustomMessageListener cij;
    private boolean cyb;
    private View euX;
    private RelativeLayout fpU;
    private com.baidu.tbadk.core.dialog.d gBu;
    private final CustomMessageListener gBv;
    private com.baidu.tieba.im.chat.a.a gBx;
    private final com.baidu.tieba.im.chat.a.b gBy;
    private final ChatAggregationFragment gUV;
    private ImMessageCenterModel gUW;
    private ImMessageCenterShowItemData gUX;
    private BdListView gUY;
    private MessageAggregationListAdapter gUZ;
    private ShutDownValidateTipView gVa;
    com.baidu.tbadk.core.dialog.i gVb;
    private k.c gVc;
    private boolean gVd;
    private boolean gVe;
    private int gVf;
    private final AdapterView.OnItemLongClickListener gVg;
    private boolean isNeedRefresh;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ab(chatAggregationFragment.getPageContext().getPageActivity()));
        this.gUW = null;
        this.gUX = null;
        this.gUY = null;
        this.gUZ = null;
        this.gVb = null;
        this.gVd = true;
        this.cyb = false;
        this.isNeedRefresh = false;
        this.gVe = true;
        this.gVf = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData vf = e.this.gUZ.getItem(i);
                    TiebaStatic.eventStat(e.this.gUV.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = vf.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(vf);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gUV.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.gUV.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.gUV.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(vf.getFriendId(), 0L), vf.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (vf.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gUV.getPageContext().getOrignalPage(), 2008021)) {
                            d(vf);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.anD().anZ() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.anD().anZ().jB(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.gUV.getPageContext().getPageActivity())));
                        }
                    } else if (vf.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gUV.getPageContext().getOrignalPage(), 2008013)) {
                            d(vf);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.anD().anZ() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.anD().anZ().jA(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.gUV.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gUV.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.gUV.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gUV.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.gUV.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(vf.getFriendId(), 0L), vf.getFriendName(), vf.getFriendPortrait(), 0, vf.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new an("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.gUV.getPageContext().getPageActivity())));
                    } else {
                        e(vf);
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
                                com.baidu.tieba.im.db.d.bCA().yO("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.bCA().yO("group_intro_change");
                                com.baidu.tieba.im.db.d.bCA().yO("group_name_change");
                                com.baidu.tieba.im.db.d.bCA().yO("group_notice_change");
                                com.baidu.tieba.im.db.d.bCA().yO("group_level_up");
                                com.baidu.tieba.im.db.d.bCA().yO("dismiss_group");
                                com.baidu.tieba.im.db.d.bCA().yO("kick_out");
                                com.baidu.tieba.im.db.d.bCA().yO("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.anD().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.anD().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.gUV.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.gVg = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.gUX = e.this.gUZ.getItem(i);
                e.this.c(e.this.gUX);
                if (e.this.gVb != null) {
                    TiebaStatic.log("c12932");
                    e.this.gVb.showDialog();
                    if (e.this.gUV != null && e.this.gUV.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.gUV.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.gBv = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.gUW.setData(null, e.this.gBx);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.gUZ != null) {
                            e.this.gUZ.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.gUZ != null) {
                        e.this.gUZ.notifyDataSetChanged();
                    }
                }
            }
        };
        this.gBx = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.bAS();
            }
        };
        this.cij = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.gBy = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.bjJ();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.gBu != null) {
                    e.this.gBu.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.azP();
                e.this.gUV.showToast(R.string.delete_success, false);
                e.this.bAS();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.azP();
            }
        };
        this.gUV = chatAggregationFragment;
    }

    public void R(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.gVf = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.gVf = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.gVf);
        }
    }

    public void bsn() {
        if (this.gUZ != null) {
            this.gUZ.notifyDataSetChanged();
        }
    }

    public void aFO() {
        MessageManager.getInstance().unRegisterListener(this.gBv);
        MessageManager.getInstance().unRegisterListener(this.cij);
    }

    public View aLn() {
        this.bZq = 3;
        this.rootView = LayoutInflater.from(this.gUV.getPageContext().getPageActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bM(this.rootView);
        TiebaStatic.eventStat(this.gUV.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        bbc();
        return this.rootView;
    }

    protected void bbc() {
        this.gUY.startPullRefresh();
        this.cyb = isLogin();
        if (!this.cyb) {
            T(this.cyb, true);
        }
    }

    private void registerListener() {
        this.gUV.registerListener(2016004, this.gBv);
        this.gUV.registerListener(2016001, this.gBv);
        this.gUV.registerListener(2016010, this.gBv);
        this.gUV.registerListener(2016007, this.gBv);
        this.gUV.registerListener(2016011, this.gBv);
        this.gUV.registerListener(2016002, this.gBv);
        this.gUV.registerListener(this.cij);
    }

    public void mL(boolean z) {
        this.isNeedRefresh = z;
    }

    public void mM(boolean z) {
        this.gVe = z;
    }

    public void onPrimary() {
        if (this.gUZ != null && this.gUZ.getCount() == 0) {
            mL(true);
        }
        if (this.gVe || this.isNeedRefresh) {
            this.gVe = false;
            this.isNeedRefresh = false;
            iP(false);
        }
        boolean isLogin = isLogin();
        if (this.cyb != isLogin) {
            this.cyb = isLogin;
            onUserChanged(this.cyb);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gUV.getPageContext());
        }
    }

    private void initData() {
        this.gUW = new ImMessageCenterModel();
        mP(com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bM(View view) {
        this.fpU = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.gVa = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.gVa.setVisibility(8);
        this.gVa.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("is_shut_down_validate", true);
                e.this.mP(false);
                e.this.mO(false);
            }
        });
        this.gUY = (BdListView) view.findViewById(R.id.chat_list_content);
        this.gUY.setDividerHeight(0);
        this.gUZ = new MessageAggregationListAdapter(this.gUV.getPageContext().getPageActivity());
        this.gUZ.a(this);
        this.gUY.setAdapter((ListAdapter) this.gUZ);
        this.gUY.setOnItemClickListener(this.mItemClickListener);
        this.gUY.setOnItemLongClickListener(this.gVg);
        this.euX = new View(this.gUV.getFragmentActivity());
        this.euX.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.gUV.getFragmentActivity(), R.dimen.ds150)));
        this.gUY.addFooterView(this.euX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gUV.getPageContext(), i);
        }
        if (this.gVa != null) {
            this.gVa.onChangeSkinType(i);
        }
        if (this.gUZ != null) {
            this.gUZ.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.fpU);
            return true;
        }
        return true;
    }

    private void mN(boolean z) {
        if (z) {
            bHL();
        } else {
            bHM();
        }
    }

    private void bHL() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.hS().az("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gUV.getResources().getString(R.string.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.gUV.getPageContext().getPageActivity(), this.fpU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iN(R.string.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bHM() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.gUV.getResources().getString(R.string.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.gUV.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bd.cE(e.this.gUV.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.gUV.getResources().getDimensionPixelSize(R.dimen.ds320);
        int dimensionPixelSize2 = this.gUV.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.gUV.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.gUV.getResources().getDimensionPixelSize(R.dimen.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.gUV.getPageContext().getPageActivity(), this.fpU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.af(R.string.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.gUV.getResources().getDimensionPixelSize(R.dimen.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        T(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.gVc = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.gVb != null && e.this.gVb.isShowing() && e.this.gUV != null) {
                    e.this.gVb.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.gUW.asyncDeleteItem(imMessageCenterShowItemData, e.this.gBy);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.gUV.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.gVb = new com.baidu.tbadk.core.dialog.i(this.gUV.getPageContext());
        this.gVb.a(null, new String[]{string}, this.gVc);
    }

    protected boolean iP(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.gUY.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void mO(boolean z) {
        if (z) {
            if (bHN() && this.gVa.getVisibility() != 0) {
                this.gVa.setVisibility(0);
            }
        } else if (this.gVa.getVisibility() != 8) {
            this.gVa.setVisibility(8);
        }
    }

    public void T(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gUY.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.fpU.removeView(this.mNoDataView);
        }
        mN(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.gUY.setVisibility(8);
    }

    public boolean bHN() {
        return this.gVd;
    }

    public void mP(boolean z) {
        this.gVd = z;
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
                if (this.gUW != null) {
                    this.gUW.insertOrUpdate(data, this.gBx);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.gUW != null) {
                this.gUW.remove(data, this.gBx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.gUW != null) {
                this.gUW.setData(data, this.gBx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.gVf = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.gVf != -1) {
                mL(true);
                onPrimary();
            }
        }
    }

    public void mK(boolean z) {
        if (z && this.gUY != null && this.gUY.getWrappedAdapter() != null && this.gUY.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gUY.startPullRefresh();
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
                bHO();
            }
        }
    }

    private void bHO() {
        if (this.gUZ != null) {
            this.gUZ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjJ() {
        azP();
        if (this.gBu == null) {
            this.gBu = com.baidu.tieba.im.db.e.bCB().dP(getPageContext().getPageActivity());
        }
        this.gBu.show();
        this.gBu.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azP() {
        if (this.gBu != null && this.gBu.isShowing()) {
            this.gBu.dismiss();
            this.gBu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAS() {
        if (this.gUY != null && this.gUW != null) {
            this.gUY.completePullRefreshPostDelayed(0L);
            if (this.gUW.getData() != null) {
                this.gUZ.setData(this.gUW.getData());
            } else {
                T(isLogin(), true);
            }
        }
    }
}
