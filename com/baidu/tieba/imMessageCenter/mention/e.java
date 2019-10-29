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
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
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
    private View arb;
    private boolean cKw;
    private int coT;
    private final CustomMessageListener cwZ;
    private RelativeLayout fru;
    private com.baidu.tbadk.core.dialog.d gCd;
    private final CustomMessageListener gCe;
    private com.baidu.tieba.im.chat.a.a gCg;
    private final com.baidu.tieba.im.chat.a.b gCh;
    private final ChatAggregationFragment gVI;
    private ImMessageCenterModel gVJ;
    private ImMessageCenterShowItemData gVK;
    private BdListView gVL;
    private MessageAggregationListAdapter gVM;
    private ShutDownValidateTipView gVN;
    com.baidu.tbadk.core.dialog.i gVO;
    private k.c gVP;
    private boolean gVQ;
    private boolean gVR;
    private int gVS;
    private final AdapterView.OnItemLongClickListener gVT;
    private boolean isNeedRefresh;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ab(chatAggregationFragment.getPageContext().getPageActivity()));
        this.gVJ = null;
        this.gVK = null;
        this.gVL = null;
        this.gVM = null;
        this.gVO = null;
        this.gVQ = true;
        this.cKw = false;
        this.isNeedRefresh = false;
        this.gVR = true;
        this.gVS = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData tQ = e.this.gVM.getItem(i);
                    TiebaStatic.eventStat(e.this.gVI.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = tQ.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(tQ);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gVI.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.gVI.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.gVI.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(tQ.getFriendId(), 0L), tQ.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (tQ.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gVI.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(tQ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aqt().aqP() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aqt().aqP().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.gVI.getPageContext().getPageActivity())));
                        }
                    } else if (tQ.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gVI.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(tQ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aqt().aqP() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aqt().aqP().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.gVI.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gVI.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.gVI.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gVI.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.gVI.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(tQ.getFriendId(), 0L), tQ.getFriendName(), tQ.getFriendPortrait(), 0, tQ.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new an("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.gVI.getPageContext().getPageActivity())));
                    } else {
                        e(tQ);
                    }
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.bAm().xG("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.bAm().xG("group_intro_change");
                                com.baidu.tieba.im.db.d.bAm().xG("group_name_change");
                                com.baidu.tieba.im.db.d.bAm().xG("group_notice_change");
                                com.baidu.tieba.im.db.d.bAm().xG("group_level_up");
                                com.baidu.tieba.im.db.d.bAm().xG("dismiss_group");
                                com.baidu.tieba.im.db.d.bAm().xG("kick_out");
                                com.baidu.tieba.im.db.d.bAm().xG("group_activitys_change");
                            }
                        }
                        return null;
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
            }

            private void e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
                if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.aqt().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.aqt().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.gVI.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.gVT = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.gVK = e.this.gVM.getItem(i);
                e.this.c(e.this.gVK);
                if (e.this.gVO != null) {
                    TiebaStatic.log("c12932");
                    e.this.gVO.showDialog();
                    if (e.this.gVI != null && e.this.gVI.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.gVI.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.gCe = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.gVJ.setData(null, e.this.gCg);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.gVM != null) {
                            e.this.gVM.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.gVM != null) {
                        e.this.gVM.notifyDataSetChanged();
                    }
                }
            }
        };
        this.gCg = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.byF();
            }
        };
        this.cwZ = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.gCh = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.byE();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.gCd != null) {
                    e.this.gCd.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.aAm();
                e.this.gVI.showToast(R.string.delete_success, false);
                e.this.byF();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.aAm();
            }
        };
        this.gVI = chatAggregationFragment;
    }

    public void Q(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.gVS = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.gVS = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.gVS);
        }
    }

    public void bqq() {
        if (this.gVM != null) {
            this.gVM.notifyDataSetChanged();
        }
    }

    public void aGH() {
        MessageManager.getInstance().unRegisterListener(this.gCe);
        MessageManager.getInstance().unRegisterListener(this.cwZ);
    }

    public View aKY() {
        this.coT = 3;
        this.rootView = LayoutInflater.from(this.gVI.getPageContext().getPageActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bJ(this.rootView);
        TiebaStatic.eventStat(this.gVI.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        bbN();
        return this.rootView;
    }

    protected void bbN() {
        this.gVL.startPullRefresh();
        this.cKw = isLogin();
        if (!this.cKw) {
            V(this.cKw, true);
        }
    }

    private void registerListener() {
        this.gVI.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.gCe);
        this.gVI.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.gCe);
        this.gVI.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.gCe);
        this.gVI.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.gCe);
        this.gVI.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.gCe);
        this.gVI.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.gCe);
        this.gVI.registerListener(this.cwZ);
    }

    public void mC(boolean z) {
        this.isNeedRefresh = z;
    }

    public void mD(boolean z) {
        this.gVR = z;
    }

    public void onPrimary() {
        if (this.gVM != null && this.gVM.getCount() == 0) {
            mC(true);
        }
        if (this.gVR || this.isNeedRefresh) {
            this.gVR = false;
            this.isNeedRefresh = false;
            iV(false);
        }
        boolean isLogin = isLogin();
        if (this.cKw != isLogin) {
            this.cKw = isLogin;
            onUserChanged(this.cKw);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gVI.getPageContext());
        }
    }

    private void initData() {
        this.gVJ = new ImMessageCenterModel();
        mG(com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void bJ(View view) {
        this.fru = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.gVN = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.gVN.setVisibility(8);
        this.gVN.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.mG(false);
                e.this.mF(false);
            }
        });
        this.gVL = (BdListView) view.findViewById(R.id.chat_list_content);
        this.gVL.setDividerHeight(0);
        this.gVM = new MessageAggregationListAdapter(this.gVI.getPageContext().getPageActivity());
        this.gVM.a(this);
        this.gVL.setAdapter((ListAdapter) this.gVM);
        this.gVL.setOnItemClickListener(this.mItemClickListener);
        this.gVL.setOnItemLongClickListener(this.gVT);
        this.arb = new View(this.gVI.getFragmentActivity());
        this.arb.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gVI.getFragmentActivity(), R.dimen.ds150)));
        this.gVL.addFooterView(this.arb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gVI.getPageContext(), i);
        }
        if (this.gVN != null) {
            this.gVN.onChangeSkinType(i);
        }
        if (this.gVM != null) {
            this.gVM.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.fru);
            return true;
        }
        return true;
    }

    private void mE(boolean z) {
        if (z) {
            bFx();
        } else {
            bFy();
        }
    }

    private void bFx() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.ft().af("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gVI.getResources().getString(R.string.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.isLogin() && e.this.mContext != null) {
                        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(e.this.mContext.getPageActivity(), 0, false);
                        atListActivityConfig.setIsForChat(true);
                        e.this.mContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig));
                        TiebaStatic.log("c12929");
                    }
                }
            }));
        }
        this.mNoDataView = NoDataViewFactory.a(this.gVI.getPageContext().getPageActivity(), this.fru, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iL(R.string.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bFy() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.gVI.getResources().getString(R.string.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.gVI.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bc.skipToLoginActivity(e.this.gVI.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.gVI.getResources().getDimensionPixelSize(R.dimen.ds320);
        int dimensionPixelSize2 = this.gVI.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.gVI.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.gVI.getResources().getDimensionPixelSize(R.dimen.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.gVI.getPageContext().getPageActivity(), this.fru, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aj(R.string.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.gVI.getResources().getDimensionPixelSize(R.dimen.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        V(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.gVP = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.gVO != null && e.this.gVO.isShowing() && e.this.gVI != null) {
                    e.this.gVO.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.gVJ.asyncDeleteItem(imMessageCenterShowItemData, e.this.gCh);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.gVI.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.gVO = new com.baidu.tbadk.core.dialog.i(this.gVI.getPageContext());
        this.gVO.a(null, new String[]{string}, this.gVP);
    }

    protected boolean iV(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.gVL.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void mF(boolean z) {
        if (z) {
            if (bFz() && this.gVN.getVisibility() != 0) {
                this.gVN.setVisibility(0);
            }
        } else if (this.gVN.getVisibility() != 8) {
            this.gVN.setVisibility(8);
        }
    }

    public void V(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gVL.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.fru.removeView(this.mNoDataView);
        }
        mE(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.gVL.setVisibility(8);
    }

    public boolean bFz() {
        return this.gVQ;
    }

    public void mG(boolean z) {
        this.gVQ = z;
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
                if (this.gVJ != null) {
                    this.gVJ.insertOrUpdate(data, this.gCg);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.gVJ != null) {
                this.gVJ.remove(data, this.gCg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.gVJ != null) {
                this.gVJ.setData(data, this.gCg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.gVS = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.gVS != -1) {
                mC(true);
                onPrimary();
            }
        }
    }

    public void mB(boolean z) {
        if (z && this.gVL != null && this.gVL.getWrappedAdapter() != null && this.gVL.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gVL.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                bFA();
            }
        }
    }

    private void bFA() {
        if (this.gVM != null) {
            this.gVM.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byE() {
        aAm();
        if (this.gCd == null) {
            this.gCd = com.baidu.tieba.im.db.e.bAn().dE(getPageContext().getPageActivity());
        }
        this.gCd.show();
        this.gCd.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAm() {
        if (this.gCd != null && this.gCd.isShowing()) {
            this.gCd.dismiss();
            this.gCd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byF() {
        if (this.gVL != null && this.gVJ != null) {
            this.gVL.completePullRefreshPostDelayed(0L);
            if (this.gVJ.getData() != null) {
                this.gVM.setData(this.gVJ.getData());
            } else {
                V(isLogin(), true);
            }
        }
    }
}
