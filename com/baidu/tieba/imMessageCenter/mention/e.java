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
    private int bYn;
    private final CustomMessageListener chc;
    private boolean cwL;
    private View epY;
    private RelativeLayout fkV;
    private final ChatAggregationFragment gOI;
    private ImMessageCenterModel gOJ;
    private ImMessageCenterShowItemData gOK;
    private BdListView gOL;
    private MessageAggregationListAdapter gOM;
    private ShutDownValidateTipView gON;
    com.baidu.tbadk.core.dialog.i gOO;
    private k.c gOP;
    private boolean gOQ;
    private boolean gOR;
    private int gOS;
    private final AdapterView.OnItemLongClickListener gOT;
    private com.baidu.tbadk.core.dialog.d gvg;
    private final CustomMessageListener gvh;
    private com.baidu.tieba.im.chat.a.a gvj;
    private final com.baidu.tieba.im.chat.a.b gvk;
    private boolean isNeedRefresh;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ab(chatAggregationFragment.getPageContext().getPageActivity()));
        this.gOJ = null;
        this.gOK = null;
        this.gOL = null;
        this.gOM = null;
        this.gOO = null;
        this.gOQ = true;
        this.cwL = false;
        this.isNeedRefresh = false;
        this.gOR = true;
        this.gOS = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData uE = e.this.gOM.getItem(i);
                    TiebaStatic.eventStat(e.this.gOI.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = uE.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(uE);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gOI.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.gOI.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.gOI.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(uE.getFriendId(), 0L), uE.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (uE.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gOI.getPageContext().getOrignalPage(), 2008021)) {
                            d(uE);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.amy().amU() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.amy().amU().jv(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.gOI.getPageContext().getPageActivity())));
                        }
                    } else if (uE.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gOI.getPageContext().getOrignalPage(), 2008013)) {
                            d(uE);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.amy().amU() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.amy().amU().ju(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.gOI.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gOI.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.gOI.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.gOI.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.gOI.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(uE.getFriendId(), 0L), uE.getFriendName(), uE.getFriendPortrait(), 0, uE.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new am("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.gOI.getPageContext().getPageActivity())));
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
                                com.baidu.tieba.im.db.d.bzR().yc("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.bzR().yc("group_intro_change");
                                com.baidu.tieba.im.db.d.bzR().yc("group_name_change");
                                com.baidu.tieba.im.db.d.bzR().yc("group_notice_change");
                                com.baidu.tieba.im.db.d.bzR().yc("group_level_up");
                                com.baidu.tieba.im.db.d.bzR().yc("dismiss_group");
                                com.baidu.tieba.im.db.d.bzR().yc("kick_out");
                                com.baidu.tieba.im.db.d.bzR().yc("group_activitys_change");
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.gOI.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.gOT = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.gOK = e.this.gOM.getItem(i);
                e.this.c(e.this.gOK);
                if (e.this.gOO != null) {
                    TiebaStatic.log("c12932");
                    e.this.gOO.showDialog();
                    if (e.this.gOI != null && e.this.gOI.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.gOI.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.gvh = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.gOJ.setData(null, e.this.gvj);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.gOM != null) {
                            e.this.gOM.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.gOM != null) {
                        e.this.gOM.notifyDataSetChanged();
                    }
                }
            }
        };
        this.gvj = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.byk();
            }
        };
        this.chc = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.gvk = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.bhD();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.gvg != null) {
                    e.this.gvg.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.ayA();
                e.this.gOI.showToast(R.string.delete_success, false);
                e.this.byk();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.ayA();
            }
        };
        this.gOI = chatAggregationFragment;
    }

    public void R(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.gOS = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.gOS = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.gOS);
        }
    }

    public void bqh() {
        if (this.gOM != null) {
            this.gOM.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gvh);
        MessageManager.getInstance().unRegisterListener(this.chc);
    }

    public View aJF() {
        this.bYn = 3;
        this.rootView = LayoutInflater.from(this.gOI.getPageContext().getPageActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bK(this.rootView);
        TiebaStatic.eventStat(this.gOI.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        aZa();
        return this.rootView;
    }

    protected void aZa() {
        this.gOL.startPullRefresh();
        this.cwL = isLogin();
        if (!this.cwL) {
            Q(this.cwL, true);
        }
    }

    private void registerListener() {
        this.gOI.registerListener(2016004, this.gvh);
        this.gOI.registerListener(2016001, this.gvh);
        this.gOI.registerListener(2016010, this.gvh);
        this.gOI.registerListener(2016007, this.gvh);
        this.gOI.registerListener(2016011, this.gvh);
        this.gOI.registerListener(2016002, this.gvh);
        this.gOI.registerListener(this.chc);
    }

    public void mw(boolean z) {
        this.isNeedRefresh = z;
    }

    public void mx(boolean z) {
        this.gOR = z;
    }

    public void onPrimary() {
        if (this.gOM != null && this.gOM.getCount() == 0) {
            mw(true);
        }
        if (this.gOR || this.isNeedRefresh) {
            this.gOR = false;
            this.isNeedRefresh = false;
            iG(false);
        }
        boolean isLogin = isLogin();
        if (this.cwL != isLogin) {
            this.cwL = isLogin;
            onUserChanged(this.cwL);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gOI.getPageContext());
        }
    }

    private void initData() {
        this.gOJ = new ImMessageCenterModel();
        mA(com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bK(View view) {
        this.fkV = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.gON = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.gON.setVisibility(8);
        this.gON.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("is_shut_down_validate", true);
                e.this.mA(false);
                e.this.mz(false);
            }
        });
        this.gOL = (BdListView) view.findViewById(R.id.chat_list_content);
        this.gOL.setDividerHeight(0);
        this.gOM = new MessageAggregationListAdapter(this.gOI.getPageContext().getPageActivity());
        this.gOM.a(this);
        this.gOL.setAdapter((ListAdapter) this.gOM);
        this.gOL.setOnItemClickListener(this.mItemClickListener);
        this.gOL.setOnItemLongClickListener(this.gOT);
        this.epY = new View(this.gOI.getFragmentActivity());
        this.epY.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.gOI.getFragmentActivity(), R.dimen.ds150)));
        this.gOL.addFooterView(this.epY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gOI.getPageContext(), i);
        }
        if (this.gON != null) {
            this.gON.onChangeSkinType(i);
        }
        if (this.gOM != null) {
            this.gOM.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.fkV);
            return true;
        }
        return true;
    }

    private void my(boolean z) {
        if (z) {
            bFa();
        } else {
            bFb();
        }
    }

    private void bFa() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.hI().ay("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gOI.getResources().getString(R.string.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.gOI.getPageContext().getPageActivity(), this.fkV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iH(R.string.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bFb() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.gOI.getResources().getString(R.string.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.gOI.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bc.cD(e.this.gOI.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.gOI.getResources().getDimensionPixelSize(R.dimen.ds320);
        int dimensionPixelSize2 = this.gOI.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.gOI.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.gOI.getResources().getDimensionPixelSize(R.dimen.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.gOI.getPageContext().getPageActivity(), this.fkV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.ac(R.string.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.gOI.getResources().getDimensionPixelSize(R.dimen.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        Q(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.gOP = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.gOO != null && e.this.gOO.isShowing() && e.this.gOI != null) {
                    e.this.gOO.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.gOJ.asyncDeleteItem(imMessageCenterShowItemData, e.this.gvk);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.gOI.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.gOO = new com.baidu.tbadk.core.dialog.i(this.gOI.getPageContext());
        this.gOO.a(null, new String[]{string}, this.gOP);
    }

    protected boolean iG(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.gOL.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void mz(boolean z) {
        if (z) {
            if (bFc() && this.gON.getVisibility() != 0) {
                this.gON.setVisibility(0);
            }
        } else if (this.gON.getVisibility() != 8) {
            this.gON.setVisibility(8);
        }
    }

    public void Q(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gOL.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.fkV.removeView(this.mNoDataView);
        }
        my(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.gOL.setVisibility(8);
    }

    public boolean bFc() {
        return this.gOQ;
    }

    public void mA(boolean z) {
        this.gOQ = z;
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
                if (this.gOJ != null) {
                    this.gOJ.insertOrUpdate(data, this.gvj);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.gOJ != null) {
                this.gOJ.remove(data, this.gvj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.gOJ != null) {
                this.gOJ.setData(data, this.gvj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.gOS = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.gOS != -1) {
                mw(true);
                onPrimary();
            }
        }
    }

    public void mv(boolean z) {
        if (z && this.gOL != null && this.gOL.getWrappedAdapter() != null && this.gOL.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gOL.startPullRefresh();
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
                bFd();
            }
        }
    }

    private void bFd() {
        if (this.gOM != null) {
            this.gOM.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhD() {
        ayA();
        if (this.gvg == null) {
            this.gvg = com.baidu.tieba.im.db.e.bzS().dO(getPageContext().getPageActivity());
        }
        this.gvg.show();
        this.gvg.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayA() {
        if (this.gvg != null && this.gvg.isShowing()) {
            this.gvg.dismiss();
            this.gvg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byk() {
        if (this.gOL != null && this.gOJ != null) {
            this.gOL.completePullRefreshPostDelayed(0L);
            if (this.gOJ.getData() != null) {
                this.gOM.setData(this.gOJ.getData());
            } else {
                Q(isLogin(), true);
            }
        }
    }
}
