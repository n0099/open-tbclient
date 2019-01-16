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
    private final CustomMessageListener aQA;
    private RelativeLayout dHK;
    private View deS;
    private com.baidu.tbadk.core.dialog.d eOd;
    private final CustomMessageListener eOe;
    private com.baidu.tieba.im.chat.a.a eOg;
    private final com.baidu.tieba.im.chat.a.b eOh;
    private final ChatAggregationFragment fhA;
    private ImMessageCenterModel fhB;
    private ImMessageCenterShowItemData fhC;
    private BdListView fhD;
    private MessageAggregationListAdapter fhE;
    private ShutDownValidateTipView fhF;
    com.baidu.tbadk.core.dialog.b fhG;
    private b.InterfaceC0158b fhH;
    private int fhI;
    private boolean fhJ;
    private boolean fhK;
    private boolean fhL;
    private boolean fhM;
    private int fhN;
    private final AdapterView.OnItemLongClickListener fhO;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.aK(chatAggregationFragment.getPageContext().getPageActivity()));
        this.fhB = null;
        this.fhC = null;
        this.fhD = null;
        this.fhE = null;
        this.fhG = null;
        this.fhJ = true;
        this.fhK = false;
        this.fhL = false;
        this.fhM = true;
        this.fhN = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData pR = e.this.fhE.getItem(i);
                    TiebaStatic.eventStat(e.this.fhA.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = pR.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(pR);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fhA.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.fhA.getPageContext().getContext(), "chat_list_to_group", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.fhA.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(pR.getFriendId(), 0L), pR.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (pR.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fhA.getPageContext().getOrignalPage(), 2008021)) {
                            d(pR);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.If().IB() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.If().IB().fc(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.fhA.getPageContext().getPageActivity())));
                        }
                    } else if (pR.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fhA.getPageContext().getOrignalPage(), 2008013)) {
                            d(pR);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.If().IB() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.If().IB().fb(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.fhA.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fhA.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.fhA.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fhA.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.fhA.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(pR.getFriendId(), 0L), pR.getFriendName(), pR.getFriendPortrait(), 0, pR.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new am("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.fhA.getPageContext().getPageActivity())));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.fhA.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.fhO = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.fhC = e.this.fhE.getItem(i);
                e.this.c(e.this.fhC);
                if (e.this.fhG != null) {
                    TiebaStatic.log("c12932");
                    e.this.fhG.BV();
                    if (e.this.fhA != null && e.this.fhA.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.fhA.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.eOe = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.fhB.setData(null, e.this.eOg);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.fhE != null) {
                            e.this.fhE.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.fhE != null) {
                        e.this.fhE.notifyDataSetChanged();
                    }
                }
            }
        };
        this.eOg = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.aPW();
            }
        };
        this.aQA = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.eOh = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.azM();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.eOd != null) {
                    e.this.eOd.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.Tz();
                e.this.fhA.showToast(e.j.delete_success, false);
                e.this.aPW();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.Tz();
            }
        };
        this.fhA = chatAggregationFragment;
    }

    public void t(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.fhN = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.fhN = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.fhN);
        }
    }

    public void aFn() {
        if (this.fhE != null) {
            this.fhE.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eOe);
        MessageManager.getInstance().unRegisterListener(this.aQA);
    }

    public View acA() {
        this.fhI = 3;
        this.rootView = LayoutInflater.from(this.fhA.getPageContext().getPageActivity()).inflate(e.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        aL(this.rootView);
        TiebaStatic.eventStat(this.fhA.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        asc();
        return this.rootView;
    }

    protected void asc() {
        this.fhD.startPullRefresh();
        this.fhK = isLogin();
        if (!this.fhK) {
            K(this.fhK, true);
        }
    }

    private void registerListener() {
        this.fhA.registerListener(2016004, this.eOe);
        this.fhA.registerListener(2016001, this.eOe);
        this.fhA.registerListener(2016010, this.eOe);
        this.fhA.registerListener(2016007, this.eOe);
        this.fhA.registerListener(2016011, this.eOe);
        this.fhA.registerListener(2016002, this.eOe);
        this.fhA.registerListener(this.aQA);
    }

    public void jh(boolean z) {
        this.fhL = z;
    }

    public void ji(boolean z) {
        this.fhM = z;
    }

    public void onPrimary() {
        if (this.fhE != null && this.fhE.getCount() == 0) {
            jh(true);
        }
        if (this.fhM || this.fhL) {
            this.fhM = false;
            this.fhL = false;
            fJ(false);
        }
        boolean isLogin = isLogin();
        if (this.fhK != isLogin) {
            this.fhK = isLogin;
            onUserChanged(this.fhK);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.fhA.getPageContext());
        }
    }

    private void initData() {
        this.fhB = new ImMessageCenterModel();
        jl(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void aL(View view) {
        this.dHK = (RelativeLayout) view.findViewById(e.g.chat_list);
        this.fhF = (ShutDownValidateTipView) view.findViewById(e.g.view_no_validate);
        this.fhF.setVisibility(8);
        this.fhF.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.jl(false);
                e.this.jk(false);
            }
        });
        this.fhD = (BdListView) view.findViewById(e.g.chat_list_content);
        this.fhD.setDividerHeight(0);
        this.fhE = new MessageAggregationListAdapter(this.fhA.getPageContext().getPageActivity());
        this.fhE.a(this);
        this.fhD.setAdapter((ListAdapter) this.fhE);
        this.fhD.setOnItemClickListener(this.mItemClickListener);
        this.fhD.setOnItemLongClickListener(this.fhO);
        this.deS = new View(this.fhA.getFragmentActivity());
        this.deS.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.fhA.getFragmentActivity(), e.C0210e.ds150)));
        this.fhD.addFooterView(this.deS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fhA.getPageContext(), i);
        }
        if (this.fhF != null) {
            this.fhF.onChangeSkinType(i);
        }
        if (this.fhE != null) {
            this.fhE.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.dHK);
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
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fhA.getResources().getString(e.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.fhA.getPageContext().getPageActivity(), this.dHK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.fhA.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aWS() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.fhA.getResources().getString(e.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.fhA.getPageContext().getPageActivity(), "notlogin_10", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                ba.bI(e.this.fhA.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.fhA.getResources().getDimensionPixelSize(e.C0210e.ds320);
        int dimensionPixelSize2 = this.fhA.getResources().getDimensionPixelSize(e.C0210e.ds480);
        int dimensionPixelSize3 = this.fhA.getResources().getDimensionPixelSize(e.C0210e.ds360);
        int dimensionPixelSize4 = this.fhA.getResources().getDimensionPixelSize(e.C0210e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.fhA.getPageContext().getPageActivity(), this.dHK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.G(e.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.fhA.getResources().getDimensionPixelSize(e.C0210e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        K(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.fhH = new b.InterfaceC0158b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.fhB.asyncDeleteItem(imMessageCenterShowItemData, e.this.eOh);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.fhA.getPageContext().getPageActivity().getString(e.j.delete_user_chat);
        this.fhG = new com.baidu.tbadk.core.dialog.b(this.fhA.getPageContext().getPageActivity());
        this.fhG.de(e.j.operation);
        this.fhG.a(new String[]{string}, this.fhH);
        this.fhG.d(this.fhA.getPageContext());
    }

    protected boolean fJ(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.fhD.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
        return true;
    }

    public void jk(boolean z) {
        if (z) {
            if (aWT() && this.fhF.getVisibility() != 0) {
                this.fhF.setVisibility(0);
            }
        } else if (this.fhF.getVisibility() != 8) {
            this.fhF.setVisibility(8);
        }
    }

    public void K(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.fhD.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.dHK.removeView(this.mNoDataView);
        }
        jj(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.fhD.setVisibility(8);
    }

    public boolean aWT() {
        return this.fhJ;
    }

    public void jl(boolean z) {
        this.fhJ = z;
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
                if (this.fhB != null) {
                    this.fhB.insertOrUpdate(data, this.eOg);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.fhB != null) {
                this.fhB.remove(data, this.eOg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.fhB != null) {
                this.fhB.setData(data, this.eOg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.fhN = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.fhN != -1) {
                jh(true);
                onPrimary();
            }
        }
    }

    public void jg(boolean z) {
        if (z && this.fhD != null && this.fhD.getWrappedAdapter() != null && this.fhD.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.fhD.startPullRefresh();
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
        if (this.fhE != null) {
            this.fhE.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azM() {
        Tz();
        if (this.eOd == null) {
            this.eOd = com.baidu.tieba.im.db.e.aRE().cD(getPageContext().getPageActivity());
        }
        this.eOd.show();
        this.eOd.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tz() {
        if (this.eOd != null && this.eOd.isShowing()) {
            this.eOd.dismiss();
            this.eOd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPW() {
        if (this.fhD != null && this.fhB != null) {
            this.fhD.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (this.fhB.getData() != null) {
                this.fhE.setData(this.fhB.getData());
            } else {
                K(isLogin(), true);
            }
        }
    }
}
