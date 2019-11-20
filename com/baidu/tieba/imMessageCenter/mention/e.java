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
    private View aqJ;
    private boolean cJF;
    private int coc;
    private final CustomMessageListener cwi;
    private RelativeLayout fqC;
    private com.baidu.tbadk.core.dialog.d gBm;
    private final CustomMessageListener gBn;
    private com.baidu.tieba.im.chat.a.a gBp;
    private final com.baidu.tieba.im.chat.a.b gBq;
    private final ChatAggregationFragment gUR;
    private ImMessageCenterModel gUS;
    private ImMessageCenterShowItemData gUT;
    private BdListView gUU;
    private MessageAggregationListAdapter gUV;
    private ShutDownValidateTipView gUW;
    com.baidu.tbadk.core.dialog.i gUX;
    private k.c gUY;
    private boolean gUZ;
    private boolean gVa;
    private int gVb;
    private final AdapterView.OnItemLongClickListener gVc;
    private boolean isNeedRefresh;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ab(chatAggregationFragment.getPageContext().getPageActivity()));
        this.gUS = null;
        this.gUT = null;
        this.gUU = null;
        this.gUV = null;
        this.gUX = null;
        this.gUZ = true;
        this.cJF = false;
        this.isNeedRefresh = false;
        this.gVa = true;
        this.gVb = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData tP = e.this.gUV.getItem(i);
                    TiebaStatic.eventStat(e.this.gUR.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = tP.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(tP);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gUR.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.gUR.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.gUR.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(tP.getFriendId(), 0L), tP.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (tP.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gUR.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(tP);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aqr().aqN() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aqr().aqN().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.gUR.getPageContext().getPageActivity())));
                        }
                    } else if (tP.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gUR.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(tP);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aqr().aqN() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aqr().aqN().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.gUR.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gUR.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.gUR.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gUR.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.gUR.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(tP.getFriendId(), 0L), tP.getFriendName(), tP.getFriendPortrait(), 0, tP.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new an("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.gUR.getPageContext().getPageActivity())));
                    } else {
                        e(tP);
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
                                com.baidu.tieba.im.db.d.bAk().xG("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.bAk().xG("group_intro_change");
                                com.baidu.tieba.im.db.d.bAk().xG("group_name_change");
                                com.baidu.tieba.im.db.d.bAk().xG("group_notice_change");
                                com.baidu.tieba.im.db.d.bAk().xG("group_level_up");
                                com.baidu.tieba.im.db.d.bAk().xG("dismiss_group");
                                com.baidu.tieba.im.db.d.bAk().xG("kick_out");
                                com.baidu.tieba.im.db.d.bAk().xG("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.aqr().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.aqr().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.gUR.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.gVc = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.gUT = e.this.gUV.getItem(i);
                e.this.c(e.this.gUT);
                if (e.this.gUX != null) {
                    TiebaStatic.log("c12932");
                    e.this.gUX.showDialog();
                    if (e.this.gUR != null && e.this.gUR.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.gUR.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.gBn = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.gUS.setData(null, e.this.gBp);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.gUV != null) {
                            e.this.gUV.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.gUV != null) {
                        e.this.gUV.notifyDataSetChanged();
                    }
                }
            }
        };
        this.gBp = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.byD();
            }
        };
        this.cwi = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.gBq = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.byC();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.gBm != null) {
                    e.this.gBm.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.aAk();
                e.this.gUR.showToast(R.string.delete_success, false);
                e.this.byD();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.aAk();
            }
        };
        this.gUR = chatAggregationFragment;
    }

    public void Q(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.gVb = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.gVb = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.gVb);
        }
    }

    public void bqo() {
        if (this.gUV != null) {
            this.gUV.notifyDataSetChanged();
        }
    }

    public void aGF() {
        MessageManager.getInstance().unRegisterListener(this.gBn);
        MessageManager.getInstance().unRegisterListener(this.cwi);
    }

    public View aKW() {
        this.coc = 3;
        this.rootView = LayoutInflater.from(this.gUR.getPageContext().getPageActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bJ(this.rootView);
        TiebaStatic.eventStat(this.gUR.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        bbL();
        return this.rootView;
    }

    protected void bbL() {
        this.gUU.startPullRefresh();
        this.cJF = isLogin();
        if (!this.cJF) {
            V(this.cJF, true);
        }
    }

    private void registerListener() {
        this.gUR.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.gBn);
        this.gUR.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.gBn);
        this.gUR.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.gBn);
        this.gUR.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.gBn);
        this.gUR.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.gBn);
        this.gUR.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.gBn);
        this.gUR.registerListener(this.cwi);
    }

    public void mC(boolean z) {
        this.isNeedRefresh = z;
    }

    public void mD(boolean z) {
        this.gVa = z;
    }

    public void onPrimary() {
        if (this.gUV != null && this.gUV.getCount() == 0) {
            mC(true);
        }
        if (this.gVa || this.isNeedRefresh) {
            this.gVa = false;
            this.isNeedRefresh = false;
            iV(false);
        }
        boolean isLogin = isLogin();
        if (this.cJF != isLogin) {
            this.cJF = isLogin;
            onUserChanged(this.cJF);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gUR.getPageContext());
        }
    }

    private void initData() {
        this.gUS = new ImMessageCenterModel();
        mG(com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void bJ(View view) {
        this.fqC = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.gUW = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.gUW.setVisibility(8);
        this.gUW.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.mG(false);
                e.this.mF(false);
            }
        });
        this.gUU = (BdListView) view.findViewById(R.id.chat_list_content);
        this.gUU.setDividerHeight(0);
        this.gUV = new MessageAggregationListAdapter(this.gUR.getPageContext().getPageActivity());
        this.gUV.a(this);
        this.gUU.setAdapter((ListAdapter) this.gUV);
        this.gUU.setOnItemClickListener(this.mItemClickListener);
        this.gUU.setOnItemLongClickListener(this.gVc);
        this.aqJ = new View(this.gUR.getFragmentActivity());
        this.aqJ.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gUR.getFragmentActivity(), R.dimen.ds150)));
        this.gUU.addFooterView(this.aqJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gUR.getPageContext(), i);
        }
        if (this.gUW != null) {
            this.gUW.onChangeSkinType(i);
        }
        if (this.gUV != null) {
            this.gUV.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.fqC);
            return true;
        }
        return true;
    }

    private void mE(boolean z) {
        if (z) {
            bFv();
        } else {
            bFw();
        }
    }

    private void bFv() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.ft().af("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gUR.getResources().getString(R.string.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.gUR.getPageContext().getPageActivity(), this.fqC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iK(R.string.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bFw() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.gUR.getResources().getString(R.string.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.gUR.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bc.skipToLoginActivity(e.this.gUR.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.gUR.getResources().getDimensionPixelSize(R.dimen.ds320);
        int dimensionPixelSize2 = this.gUR.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.gUR.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.gUR.getResources().getDimensionPixelSize(R.dimen.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.gUR.getPageContext().getPageActivity(), this.fqC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.ah(R.string.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.gUR.getResources().getDimensionPixelSize(R.dimen.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        V(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.gUY = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.gUX != null && e.this.gUX.isShowing() && e.this.gUR != null) {
                    e.this.gUX.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.gUS.asyncDeleteItem(imMessageCenterShowItemData, e.this.gBq);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.gUR.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.gUX = new com.baidu.tbadk.core.dialog.i(this.gUR.getPageContext());
        this.gUX.a(null, new String[]{string}, this.gUY);
    }

    protected boolean iV(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.gUU.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void mF(boolean z) {
        if (z) {
            if (bFx() && this.gUW.getVisibility() != 0) {
                this.gUW.setVisibility(0);
            }
        } else if (this.gUW.getVisibility() != 8) {
            this.gUW.setVisibility(8);
        }
    }

    public void V(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gUU.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.fqC.removeView(this.mNoDataView);
        }
        mE(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.gUU.setVisibility(8);
    }

    public boolean bFx() {
        return this.gUZ;
    }

    public void mG(boolean z) {
        this.gUZ = z;
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
                if (this.gUS != null) {
                    this.gUS.insertOrUpdate(data, this.gBp);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.gUS != null) {
                this.gUS.remove(data, this.gBp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.gUS != null) {
                this.gUS.setData(data, this.gBp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.gVb = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.gVb != -1) {
                mC(true);
                onPrimary();
            }
        }
    }

    public void mB(boolean z) {
        if (z && this.gUU != null && this.gUU.getWrappedAdapter() != null && this.gUU.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gUU.startPullRefresh();
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
                bFy();
            }
        }
    }

    private void bFy() {
        if (this.gUV != null) {
            this.gUV.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byC() {
        aAk();
        if (this.gBm == null) {
            this.gBm = com.baidu.tieba.im.db.e.bAl().dE(getPageContext().getPageActivity());
        }
        this.gBm.show();
        this.gBm.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAk() {
        if (this.gBm != null && this.gBm.isShowing()) {
            this.gBm.dismiss();
            this.gBm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byD() {
        if (this.gUU != null && this.gUS != null) {
            this.gUU.completePullRefreshPostDelayed(0L);
            if (this.gUS.getData() != null) {
                this.gUV.setData(this.gUS.getData());
            } else {
                V(isLogin(), true);
            }
        }
    }
}
