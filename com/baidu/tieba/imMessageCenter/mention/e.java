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
import com.baidu.tbadk.core.util.am;
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
    private int bYo;
    private final CustomMessageListener chd;
    private boolean cwM;
    private View epZ;
    private RelativeLayout fkW;
    private final ChatAggregationFragment gOL;
    private ImMessageCenterModel gOM;
    private ImMessageCenterShowItemData gON;
    private BdListView gOO;
    private MessageAggregationListAdapter gOP;
    private ShutDownValidateTipView gOQ;
    com.baidu.tbadk.core.dialog.i gOR;
    private k.c gOS;
    private boolean gOT;
    private boolean gOU;
    private int gOV;
    private final AdapterView.OnItemLongClickListener gOW;
    private com.baidu.tbadk.core.dialog.d gvj;
    private final CustomMessageListener gvk;
    private com.baidu.tieba.im.chat.a.a gvm;
    private final com.baidu.tieba.im.chat.a.b gvn;
    private boolean isNeedRefresh;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ab(chatAggregationFragment.getPageContext().getPageActivity()));
        this.gOM = null;
        this.gON = null;
        this.gOO = null;
        this.gOP = null;
        this.gOR = null;
        this.gOT = true;
        this.cwM = false;
        this.isNeedRefresh = false;
        this.gOU = true;
        this.gOV = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData uE = e.this.gOP.getItem(i);
                    TiebaStatic.eventStat(e.this.gOL.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = uE.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(uE);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gOL.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.gOL.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.gOL.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(uE.getFriendId(), 0L), uE.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (uE.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gOL.getPageContext().getOrignalPage(), 2008021)) {
                            d(uE);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.amy().amU() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.amy().amU().jv(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.gOL.getPageContext().getPageActivity())));
                        }
                    } else if (uE.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gOL.getPageContext().getOrignalPage(), 2008013)) {
                            d(uE);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.amy().amU() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.amy().amU().ju(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.gOL.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gOL.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.gOL.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gOL.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.gOL.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(uE.getFriendId(), 0L), uE.getFriendName(), uE.getFriendPortrait(), 0, uE.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new am("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.gOL.getPageContext().getPageActivity())));
                    } else {
                        e(uE);
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
                                com.baidu.tieba.im.db.d.bzV().ye("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.bzV().ye("group_intro_change");
                                com.baidu.tieba.im.db.d.bzV().ye("group_name_change");
                                com.baidu.tieba.im.db.d.bzV().ye("group_notice_change");
                                com.baidu.tieba.im.db.d.bzV().ye("group_level_up");
                                com.baidu.tieba.im.db.d.bzV().ye("dismiss_group");
                                com.baidu.tieba.im.db.d.bzV().ye("kick_out");
                                com.baidu.tieba.im.db.d.bzV().ye("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.amy().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.gOL.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.gOW = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.gON = e.this.gOP.getItem(i);
                e.this.c(e.this.gON);
                if (e.this.gOR != null) {
                    TiebaStatic.log("c12932");
                    e.this.gOR.showDialog();
                    if (e.this.gOL != null && e.this.gOL.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.gOL.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.gvk = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.gOM.setData(null, e.this.gvm);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.gOP != null) {
                            e.this.gOP.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.gOP != null) {
                        e.this.gOP.notifyDataSetChanged();
                    }
                }
            }
        };
        this.gvm = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.byo();
            }
        };
        this.chd = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.gvn = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.bhG();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.gvj != null) {
                    e.this.gvj.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.ayB();
                e.this.gOL.showToast(R.string.delete_success, false);
                e.this.byo();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.ayB();
            }
        };
        this.gOL = chatAggregationFragment;
    }

    public void R(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.gOV = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.gOV = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.gOV);
        }
    }

    public void bqm() {
        if (this.gOP != null) {
            this.gOP.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gvk);
        MessageManager.getInstance().unRegisterListener(this.chd);
    }

    public View aJI() {
        this.bYo = 3;
        this.rootView = LayoutInflater.from(this.gOL.getPageContext().getPageActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bK(this.rootView);
        TiebaStatic.eventStat(this.gOL.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        aZd();
        return this.rootView;
    }

    protected void aZd() {
        this.gOO.startPullRefresh();
        this.cwM = isLogin();
        if (!this.cwM) {
            Q(this.cwM, true);
        }
    }

    private void registerListener() {
        this.gOL.registerListener(2016004, this.gvk);
        this.gOL.registerListener(2016001, this.gvk);
        this.gOL.registerListener(2016010, this.gvk);
        this.gOL.registerListener(2016007, this.gvk);
        this.gOL.registerListener(2016011, this.gvk);
        this.gOL.registerListener(2016002, this.gvk);
        this.gOL.registerListener(this.chd);
    }

    public void mx(boolean z) {
        this.isNeedRefresh = z;
    }

    public void my(boolean z) {
        this.gOU = z;
    }

    public void onPrimary() {
        if (this.gOP != null && this.gOP.getCount() == 0) {
            mx(true);
        }
        if (this.gOU || this.isNeedRefresh) {
            this.gOU = false;
            this.isNeedRefresh = false;
            iG(false);
        }
        boolean isLogin = isLogin();
        if (this.cwM != isLogin) {
            this.cwM = isLogin;
            onUserChanged(this.cwM);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gOL.getPageContext());
        }
    }

    private void initData() {
        this.gOM = new ImMessageCenterModel();
        mB(com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bK(View view) {
        this.fkW = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.gOQ = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.gOQ.setVisibility(8);
        this.gOQ.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("is_shut_down_validate", true);
                e.this.mB(false);
                e.this.mA(false);
            }
        });
        this.gOO = (BdListView) view.findViewById(R.id.chat_list_content);
        this.gOO.setDividerHeight(0);
        this.gOP = new MessageAggregationListAdapter(this.gOL.getPageContext().getPageActivity());
        this.gOP.a(this);
        this.gOO.setAdapter((ListAdapter) this.gOP);
        this.gOO.setOnItemClickListener(this.mItemClickListener);
        this.gOO.setOnItemLongClickListener(this.gOW);
        this.epZ = new View(this.gOL.getFragmentActivity());
        this.epZ.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.gOL.getFragmentActivity(), R.dimen.ds150)));
        this.gOO.addFooterView(this.epZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gOL.getPageContext(), i);
        }
        if (this.gOQ != null) {
            this.gOQ.onChangeSkinType(i);
        }
        if (this.gOP != null) {
            this.gOP.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.fkW);
            return true;
        }
        return true;
    }

    private void mz(boolean z) {
        if (z) {
            bFe();
        } else {
            bFf();
        }
    }

    private void bFe() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.hI().ay("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gOL.getResources().getString(R.string.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.gOL.getPageContext().getPageActivity(), this.fkW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iH(R.string.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bFf() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.gOL.getResources().getString(R.string.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.gOL.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bc.cD(e.this.gOL.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.gOL.getResources().getDimensionPixelSize(R.dimen.ds320);
        int dimensionPixelSize2 = this.gOL.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.gOL.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.gOL.getResources().getDimensionPixelSize(R.dimen.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.gOL.getPageContext().getPageActivity(), this.fkW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.ac(R.string.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.gOL.getResources().getDimensionPixelSize(R.dimen.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        Q(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.gOS = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.gOR != null && e.this.gOR.isShowing() && e.this.gOL != null) {
                    e.this.gOR.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.gOM.asyncDeleteItem(imMessageCenterShowItemData, e.this.gvn);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.gOL.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.gOR = new com.baidu.tbadk.core.dialog.i(this.gOL.getPageContext());
        this.gOR.a(null, new String[]{string}, this.gOS);
    }

    protected boolean iG(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.gOO.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void mA(boolean z) {
        if (z) {
            if (bFg() && this.gOQ.getVisibility() != 0) {
                this.gOQ.setVisibility(0);
            }
        } else if (this.gOQ.getVisibility() != 8) {
            this.gOQ.setVisibility(8);
        }
    }

    public void Q(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gOO.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.fkW.removeView(this.mNoDataView);
        }
        mz(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.gOO.setVisibility(8);
    }

    public boolean bFg() {
        return this.gOT;
    }

    public void mB(boolean z) {
        this.gOT = z;
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
                if (this.gOM != null) {
                    this.gOM.insertOrUpdate(data, this.gvm);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.gOM != null) {
                this.gOM.remove(data, this.gvm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.gOM != null) {
                this.gOM.setData(data, this.gvm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.gOV = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.gOV != -1) {
                mx(true);
                onPrimary();
            }
        }
    }

    public void mw(boolean z) {
        if (z && this.gOO != null && this.gOO.getWrappedAdapter() != null && this.gOO.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gOO.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                bFh();
            }
        }
    }

    private void bFh() {
        if (this.gOP != null) {
            this.gOP.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhG() {
        ayB();
        if (this.gvj == null) {
            this.gvj = com.baidu.tieba.im.db.e.bzW().dO(getPageContext().getPageActivity());
        }
        this.gvj.show();
        this.gvj.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayB() {
        if (this.gvj != null && this.gvj.isShowing()) {
            this.gvj.dismiss();
            this.gvj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byo() {
        if (this.gOO != null && this.gOM != null) {
            this.gOO.completePullRefreshPostDelayed(0L);
            if (this.gOM.getData() != null) {
                this.gOP.setData(this.gOM.getData());
            } else {
                Q(isLogin(), true);
            }
        }
    }
}
