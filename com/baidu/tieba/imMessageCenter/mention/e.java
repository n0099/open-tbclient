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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.e;
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
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements j.b {
    private final CustomMessageListener aQB;
    private RelativeLayout dHL;
    private View deT;
    private com.baidu.tbadk.core.dialog.d eOe;
    private final CustomMessageListener eOf;
    private com.baidu.tieba.im.chat.a.a eOh;
    private final com.baidu.tieba.im.chat.a.b eOi;
    private final ChatAggregationFragment fhB;
    private ImMessageCenterModel fhC;
    private ImMessageCenterShowItemData fhD;
    private BdListView fhE;
    private MessageAggregationListAdapter fhF;
    private ShutDownValidateTipView fhG;
    com.baidu.tbadk.core.dialog.b fhH;
    private b.InterfaceC0158b fhI;
    private int fhJ;
    private boolean fhK;
    private boolean fhL;
    private boolean fhM;
    private boolean fhN;
    private int fhO;
    private final AdapterView.OnItemLongClickListener fhP;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.aK(chatAggregationFragment.getPageContext().getPageActivity()));
        this.fhC = null;
        this.fhD = null;
        this.fhE = null;
        this.fhF = null;
        this.fhH = null;
        this.fhK = true;
        this.fhL = false;
        this.fhM = false;
        this.fhN = true;
        this.fhO = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData pR = e.this.fhF.getItem(i);
                    TiebaStatic.eventStat(e.this.fhB.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = pR.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(pR);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fhB.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.fhB.getPageContext().getContext(), "chat_list_to_group", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.fhB.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(pR.getFriendId(), 0L), pR.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (pR.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fhB.getPageContext().getOrignalPage(), 2008021)) {
                            d(pR);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.If().IB() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.If().IB().fc(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.fhB.getPageContext().getPageActivity())));
                        }
                    } else if (pR.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fhB.getPageContext().getOrignalPage(), 2008013)) {
                            d(pR);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.If().IB() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.If().IB().fb(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.fhB.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fhB.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.fhB.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fhB.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.fhB.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(pR.getFriendId(), 0L), pR.getFriendName(), pR.getFriendPortrait(), 0, pR.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new am("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.fhB.getPageContext().getPageActivity())));
                    } else {
                        e(pR);
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
                                com.baidu.tieba.im.db.d.aRD().qk("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aRD().qk("group_intro_change");
                                com.baidu.tieba.im.db.d.aRD().qk("group_name_change");
                                com.baidu.tieba.im.db.d.aRD().qk("group_notice_change");
                                com.baidu.tieba.im.db.d.aRD().qk("group_level_up");
                                com.baidu.tieba.im.db.d.aRD().qk("dismiss_group");
                                com.baidu.tieba.im.db.d.aRD().qk("kick_out");
                                com.baidu.tieba.im.db.d.aRD().qk("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.If().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.If().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.fhB.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.fhP = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.fhD = e.this.fhF.getItem(i);
                e.this.c(e.this.fhD);
                if (e.this.fhH != null) {
                    TiebaStatic.log("c12932");
                    e.this.fhH.BV();
                    if (e.this.fhB != null && e.this.fhB.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.fhB.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.eOf = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.fhC.setData(null, e.this.eOh);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.fhF != null) {
                            e.this.fhF.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.fhF != null) {
                        e.this.fhF.notifyDataSetChanged();
                    }
                }
            }
        };
        this.eOh = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.aPW();
            }
        };
        this.aQB = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.eOi = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.azM();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.eOe != null) {
                    e.this.eOe.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.Tz();
                e.this.fhB.showToast(e.j.delete_success, false);
                e.this.aPW();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.Tz();
            }
        };
        this.fhB = chatAggregationFragment;
    }

    public void t(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.fhO = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.fhO = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.fhO);
        }
    }

    public void aFn() {
        if (this.fhF != null) {
            this.fhF.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eOf);
        MessageManager.getInstance().unRegisterListener(this.aQB);
    }

    public View acA() {
        this.fhJ = 3;
        this.rootView = LayoutInflater.from(this.fhB.getPageContext().getPageActivity()).inflate(e.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        aL(this.rootView);
        TiebaStatic.eventStat(this.fhB.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        asc();
        return this.rootView;
    }

    protected void asc() {
        this.fhE.startPullRefresh();
        this.fhL = isLogin();
        if (!this.fhL) {
            K(this.fhL, true);
        }
    }

    private void registerListener() {
        this.fhB.registerListener(2016004, this.eOf);
        this.fhB.registerListener(2016001, this.eOf);
        this.fhB.registerListener(2016010, this.eOf);
        this.fhB.registerListener(2016007, this.eOf);
        this.fhB.registerListener(2016011, this.eOf);
        this.fhB.registerListener(2016002, this.eOf);
        this.fhB.registerListener(this.aQB);
    }

    public void jh(boolean z) {
        this.fhM = z;
    }

    public void ji(boolean z) {
        this.fhN = z;
    }

    public void onPrimary() {
        if (this.fhF != null && this.fhF.getCount() == 0) {
            jh(true);
        }
        if (this.fhN || this.fhM) {
            this.fhN = false;
            this.fhM = false;
            fJ(false);
        }
        boolean isLogin = isLogin();
        if (this.fhL != isLogin) {
            this.fhL = isLogin;
            onUserChanged(this.fhL);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.fhB.getPageContext());
        }
    }

    private void initData() {
        this.fhC = new ImMessageCenterModel();
        jl(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void aL(View view) {
        this.dHL = (RelativeLayout) view.findViewById(e.g.chat_list);
        this.fhG = (ShutDownValidateTipView) view.findViewById(e.g.view_no_validate);
        this.fhG.setVisibility(8);
        this.fhG.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.jl(false);
                e.this.jk(false);
            }
        });
        this.fhE = (BdListView) view.findViewById(e.g.chat_list_content);
        this.fhE.setDividerHeight(0);
        this.fhF = new MessageAggregationListAdapter(this.fhB.getPageContext().getPageActivity());
        this.fhF.a(this);
        this.fhE.setAdapter((ListAdapter) this.fhF);
        this.fhE.setOnItemClickListener(this.mItemClickListener);
        this.fhE.setOnItemLongClickListener(this.fhP);
        this.deT = new View(this.fhB.getFragmentActivity());
        this.deT.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.fhB.getFragmentActivity(), e.C0210e.ds150)));
        this.fhE.addFooterView(this.deT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fhB.getPageContext(), i);
        }
        if (this.fhG != null) {
            this.fhG.onChangeSkinType(i);
        }
        if (this.fhF != null) {
            this.fhF.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.dHL);
            return true;
        }
        return true;
    }

    private void jj(boolean z) {
        if (z) {
            aWR();
        } else {
            aWS();
        }
    }

    private void aWR() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fhB.getResources().getString(e.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.fhB.getPageContext().getPageActivity(), this.dHL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.fhB.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aWS() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.fhB.getResources().getString(e.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.fhB.getPageContext().getPageActivity(), "notlogin_10", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                ba.bI(e.this.fhB.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.fhB.getResources().getDimensionPixelSize(e.C0210e.ds320);
        int dimensionPixelSize2 = this.fhB.getResources().getDimensionPixelSize(e.C0210e.ds480);
        int dimensionPixelSize3 = this.fhB.getResources().getDimensionPixelSize(e.C0210e.ds360);
        int dimensionPixelSize4 = this.fhB.getResources().getDimensionPixelSize(e.C0210e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.fhB.getPageContext().getPageActivity(), this.dHL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.G(e.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.fhB.getResources().getDimensionPixelSize(e.C0210e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        K(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.fhI = new b.InterfaceC0158b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.fhC.asyncDeleteItem(imMessageCenterShowItemData, e.this.eOi);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.fhB.getPageContext().getPageActivity().getString(e.j.delete_user_chat);
        this.fhH = new com.baidu.tbadk.core.dialog.b(this.fhB.getPageContext().getPageActivity());
        this.fhH.de(e.j.operation);
        this.fhH.a(new String[]{string}, this.fhI);
        this.fhH.d(this.fhB.getPageContext());
    }

    protected boolean fJ(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.fhE.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
        return true;
    }

    public void jk(boolean z) {
        if (z) {
            if (aWT() && this.fhG.getVisibility() != 0) {
                this.fhG.setVisibility(0);
            }
        } else if (this.fhG.getVisibility() != 8) {
            this.fhG.setVisibility(8);
        }
    }

    public void K(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.fhE.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.dHL.removeView(this.mNoDataView);
        }
        jj(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.fhE.setVisibility(8);
    }

    public boolean aWT() {
        return this.fhK;
    }

    public void jl(boolean z) {
        this.fhK = z;
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
                if (this.fhC != null) {
                    this.fhC.insertOrUpdate(data, this.eOh);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.fhC != null) {
                this.fhC.remove(data, this.eOh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.fhC != null) {
                this.fhC.setData(data, this.eOh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.fhO = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.fhO != -1) {
                jh(true);
                onPrimary();
            }
        }
    }

    public void jg(boolean z) {
        if (z && this.fhE != null && this.fhE.getWrappedAdapter() != null && this.fhE.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.fhE.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bI(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                aWU();
            }
        }
    }

    private void aWU() {
        if (this.fhF != null) {
            this.fhF.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azM() {
        Tz();
        if (this.eOe == null) {
            this.eOe = com.baidu.tieba.im.db.e.aRE().cD(getPageContext().getPageActivity());
        }
        this.eOe.show();
        this.eOe.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tz() {
        if (this.eOe != null && this.eOe.isShowing()) {
            this.eOe.dismiss();
            this.eOe = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPW() {
        if (this.fhE != null && this.fhC != null) {
            this.fhE.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (this.fhC.getData() != null) {
                this.fhF.setData(this.fhC.getData());
            } else {
                K(isLogin(), true);
            }
        }
    }
}
