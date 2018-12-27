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
    private final CustomMessageListener aPW;
    private RelativeLayout dHb;
    private View def;
    private com.baidu.tbadk.core.dialog.d eNr;
    private final CustomMessageListener eNs;
    private com.baidu.tieba.im.chat.a.a eNu;
    private final com.baidu.tieba.im.chat.a.b eNv;
    private final ChatAggregationFragment fgN;
    private ImMessageCenterModel fgO;
    private ImMessageCenterShowItemData fgP;
    private BdListView fgQ;
    private MessageAggregationListAdapter fgR;
    private ShutDownValidateTipView fgS;
    com.baidu.tbadk.core.dialog.b fgT;
    private b.InterfaceC0158b fgU;
    private int fgV;
    private boolean fgW;
    private boolean fgX;
    private boolean fgY;
    private boolean fgZ;
    private int fha;
    private final AdapterView.OnItemLongClickListener fhb;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.aK(chatAggregationFragment.getPageContext().getPageActivity()));
        this.fgO = null;
        this.fgP = null;
        this.fgQ = null;
        this.fgR = null;
        this.fgT = null;
        this.fgW = true;
        this.fgX = false;
        this.fgY = false;
        this.fgZ = true;
        this.fha = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData pQ = e.this.fgR.getItem(i);
                    TiebaStatic.eventStat(e.this.fgN.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = pQ.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(pQ);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fgN.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.fgN.getPageContext().getContext(), "chat_list_to_group", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.fgN.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(pQ.getFriendId(), 0L), pQ.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (pQ.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fgN.getPageContext().getOrignalPage(), 2008021)) {
                            d(pQ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.HQ().Im() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.HQ().Im().fc(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.fgN.getPageContext().getPageActivity())));
                        }
                    } else if (pQ.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fgN.getPageContext().getOrignalPage(), 2008013)) {
                            d(pQ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.HQ().Im() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.HQ().Im().fb(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.fgN.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fgN.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.fgN.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.fgN.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.fgN.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(pQ.getFriendId(), 0L), pQ.getFriendName(), pQ.getFriendPortrait(), 0, pQ.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new am("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.fgN.getPageContext().getPageActivity())));
                    } else {
                        e(pQ);
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
                                com.baidu.tieba.im.db.d.aRd().pU("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aRd().pU("group_intro_change");
                                com.baidu.tieba.im.db.d.aRd().pU("group_name_change");
                                com.baidu.tieba.im.db.d.aRd().pU("group_notice_change");
                                com.baidu.tieba.im.db.d.aRd().pU("group_level_up");
                                com.baidu.tieba.im.db.d.aRd().pU("dismiss_group");
                                com.baidu.tieba.im.db.d.aRd().pU("kick_out");
                                com.baidu.tieba.im.db.d.aRd().pU("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.HQ().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.HQ().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.fgN.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.fhb = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.fgP = e.this.fgR.getItem(i);
                e.this.c(e.this.fgP);
                if (e.this.fgT != null) {
                    TiebaStatic.log("c12932");
                    e.this.fgT.BI();
                    if (e.this.fgN != null && e.this.fgN.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.fgN.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.eNs = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.fgO.setData(null, e.this.eNu);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.fgR != null) {
                            e.this.fgR.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.fgR != null) {
                        e.this.fgR.notifyDataSetChanged();
                    }
                }
            }
        };
        this.eNu = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.aPw();
            }
        };
        this.aPW = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.eNv = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.azp();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.eNr != null) {
                    e.this.eNr.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.Td();
                e.this.fgN.showToast(e.j.delete_success, false);
                e.this.aPw();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.Td();
            }
        };
        this.fgN = chatAggregationFragment;
    }

    public void t(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.fha = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.fha = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.fha);
        }
    }

    public void aEQ() {
        if (this.fgR != null) {
            this.fgR.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eNs);
        MessageManager.getInstance().unRegisterListener(this.aPW);
    }

    public View acd() {
        this.fgV = 3;
        this.rootView = LayoutInflater.from(this.fgN.getPageContext().getPageActivity()).inflate(e.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        aL(this.rootView);
        TiebaStatic.eventStat(this.fgN.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        arE();
        return this.rootView;
    }

    protected void arE() {
        this.fgQ.startPullRefresh();
        this.fgX = isLogin();
        if (!this.fgX) {
            K(this.fgX, true);
        }
    }

    private void registerListener() {
        this.fgN.registerListener(2016004, this.eNs);
        this.fgN.registerListener(2016001, this.eNs);
        this.fgN.registerListener(2016010, this.eNs);
        this.fgN.registerListener(2016007, this.eNs);
        this.fgN.registerListener(2016011, this.eNs);
        this.fgN.registerListener(2016002, this.eNs);
        this.fgN.registerListener(this.aPW);
    }

    public void jh(boolean z) {
        this.fgY = z;
    }

    public void ji(boolean z) {
        this.fgZ = z;
    }

    public void onPrimary() {
        if (this.fgR != null && this.fgR.getCount() == 0) {
            jh(true);
        }
        if (this.fgZ || this.fgY) {
            this.fgZ = false;
            this.fgY = false;
            fG(false);
        }
        boolean isLogin = isLogin();
        if (this.fgX != isLogin) {
            this.fgX = isLogin;
            onUserChanged(this.fgX);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.fgN.getPageContext());
        }
    }

    private void initData() {
        this.fgO = new ImMessageCenterModel();
        jl(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void aL(View view) {
        this.dHb = (RelativeLayout) view.findViewById(e.g.chat_list);
        this.fgS = (ShutDownValidateTipView) view.findViewById(e.g.view_no_validate);
        this.fgS.setVisibility(8);
        this.fgS.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.jl(false);
                e.this.jk(false);
            }
        });
        this.fgQ = (BdListView) view.findViewById(e.g.chat_list_content);
        this.fgQ.setDividerHeight(0);
        this.fgR = new MessageAggregationListAdapter(this.fgN.getPageContext().getPageActivity());
        this.fgR.a(this);
        this.fgQ.setAdapter((ListAdapter) this.fgR);
        this.fgQ.setOnItemClickListener(this.mItemClickListener);
        this.fgQ.setOnItemLongClickListener(this.fhb);
        this.def = new View(this.fgN.getFragmentActivity());
        this.def.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.fgN.getFragmentActivity(), e.C0210e.ds150)));
        this.fgQ.addFooterView(this.def);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fgN.getPageContext(), i);
        }
        if (this.fgS != null) {
            this.fgS.onChangeSkinType(i);
        }
        if (this.fgR != null) {
            this.fgR.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.dHb);
            return true;
        }
        return true;
    }

    private void jj(boolean z) {
        if (z) {
            aWr();
        } else {
            aWs();
        }
    }

    private void aWr() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fgN.getResources().getString(e.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.fgN.getPageContext().getPageActivity(), this.dHb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.fgN.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aWs() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.fgN.getResources().getString(e.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.fgN.getPageContext().getPageActivity(), "notlogin_10", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                ba.bI(e.this.fgN.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.fgN.getResources().getDimensionPixelSize(e.C0210e.ds320);
        int dimensionPixelSize2 = this.fgN.getResources().getDimensionPixelSize(e.C0210e.ds480);
        int dimensionPixelSize3 = this.fgN.getResources().getDimensionPixelSize(e.C0210e.ds360);
        int dimensionPixelSize4 = this.fgN.getResources().getDimensionPixelSize(e.C0210e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.fgN.getPageContext().getPageActivity(), this.dHb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.G(e.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.fgN.getResources().getDimensionPixelSize(e.C0210e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        K(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.fgU = new b.InterfaceC0158b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.fgO.asyncDeleteItem(imMessageCenterShowItemData, e.this.eNv);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.fgN.getPageContext().getPageActivity().getString(e.j.delete_user_chat);
        this.fgT = new com.baidu.tbadk.core.dialog.b(this.fgN.getPageContext().getPageActivity());
        this.fgT.de(e.j.operation);
        this.fgT.a(new String[]{string}, this.fgU);
        this.fgT.d(this.fgN.getPageContext());
    }

    protected boolean fG(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.fgQ.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
        return true;
    }

    public void jk(boolean z) {
        if (z) {
            if (aWt() && this.fgS.getVisibility() != 0) {
                this.fgS.setVisibility(0);
            }
        } else if (this.fgS.getVisibility() != 8) {
            this.fgS.setVisibility(8);
        }
    }

    public void K(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.fgQ.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.dHb.removeView(this.mNoDataView);
        }
        jj(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.fgQ.setVisibility(8);
    }

    public boolean aWt() {
        return this.fgW;
    }

    public void jl(boolean z) {
        this.fgW = z;
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
                if (this.fgO != null) {
                    this.fgO.insertOrUpdate(data, this.eNu);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.fgO != null) {
                this.fgO.remove(data, this.eNu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.fgO != null) {
                this.fgO.setData(data, this.eNu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.fha = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.fha != -1) {
                jh(true);
                onPrimary();
            }
        }
    }

    public void jg(boolean z) {
        if (z && this.fgQ != null && this.fgQ.getWrappedAdapter() != null && this.fgQ.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.fgQ.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bH(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                aWu();
            }
        }
    }

    private void aWu() {
        if (this.fgR != null) {
            this.fgR.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azp() {
        Td();
        if (this.eNr == null) {
            this.eNr = com.baidu.tieba.im.db.e.aRe().cD(getPageContext().getPageActivity());
        }
        this.eNr.show();
        this.eNr.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Td() {
        if (this.eNr != null && this.eNr.isShowing()) {
            this.eNr.dismiss();
            this.eNr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPw() {
        if (this.fgQ != null && this.fgO != null) {
            this.fgQ.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (this.fgO.getData() != null) {
                this.fgR.setData(this.fgO.getData());
            } else {
                K(isLogin(), true);
            }
        }
    }
}
