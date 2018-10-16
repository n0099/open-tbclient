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
    private final CustomMessageListener aLF;
    private View cTy;
    private RelativeLayout dww;
    private com.baidu.tbadk.core.dialog.d eCr;
    private final CustomMessageListener eCs;
    private com.baidu.tieba.im.chat.a.a eCu;
    private final com.baidu.tieba.im.chat.a.b eCv;
    private final ChatAggregationFragment eVO;
    private ImMessageCenterModel eVP;
    private ImMessageCenterShowItemData eVQ;
    private BdListView eVR;
    private MessageAggregationListAdapter eVS;
    private ShutDownValidateTipView eVT;
    com.baidu.tbadk.core.dialog.b eVU;
    private b.InterfaceC0124b eVV;
    private int eVW;
    private boolean eVX;
    private boolean eVY;
    private boolean eVZ;
    private boolean eWa;
    private int eWb;
    private final AdapterView.OnItemLongClickListener eWc;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.aK(chatAggregationFragment.getPageContext().getPageActivity()));
        this.eVP = null;
        this.eVQ = null;
        this.eVR = null;
        this.eVS = null;
        this.eVU = null;
        this.eVX = true;
        this.eVY = false;
        this.eVZ = false;
        this.eWa = true;
        this.eWb = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData oQ = e.this.eVS.getItem(i);
                    TiebaStatic.eventStat(e.this.eVO.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = oQ.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(oQ);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eVO.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.eVO.getPageContext().getContext(), "chat_list_to_group", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.eVO.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(oQ.getFriendId(), 0L), oQ.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (oQ.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eVO.getPageContext().getOrignalPage(), 2008021)) {
                            d(oQ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GV() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GV().ez(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.eVO.getPageContext().getPageActivity())));
                        }
                    } else if (oQ.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eVO.getPageContext().getOrignalPage(), 2008013)) {
                            d(oQ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GV() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GV().ey(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.eVO.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eVO.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.eVO.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eVO.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.eVO.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(oQ.getFriendId(), 0L), oQ.getFriendName(), oQ.getFriendPortrait(), 0, oQ.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new am("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.eVO.getPageContext().getPageActivity())));
                    } else {
                        e(oQ);
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
                                com.baidu.tieba.im.db.d.aPb().po("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aPb().po("group_intro_change");
                                com.baidu.tieba.im.db.d.aPb().po("group_name_change");
                                com.baidu.tieba.im.db.d.aPb().po("group_notice_change");
                                com.baidu.tieba.im.db.d.aPb().po("group_level_up");
                                com.baidu.tieba.im.db.d.aPb().po("dismiss_group");
                                com.baidu.tieba.im.db.d.aPb().po("kick_out");
                                com.baidu.tieba.im.db.d.aPb().po("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.Gz().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.eVO.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.eWc = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.eVQ = e.this.eVS.getItem(i);
                e.this.c(e.this.eVQ);
                if (e.this.eVU != null) {
                    TiebaStatic.log("c12932");
                    e.this.eVU.Ax();
                    if (e.this.eVO != null && e.this.eVO.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.eVO.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.eCs = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.eVP.setData(null, e.this.eCu);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.eVS != null) {
                            e.this.eVS.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.eVS != null) {
                        e.this.eVS.notifyDataSetChanged();
                    }
                }
            }
        };
        this.eCu = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.aNu();
            }
        };
        this.aLF = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.eCv = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.axq();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.eCr != null) {
                    e.this.eCr.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.RM();
                e.this.eVO.showToast(e.j.delete_success, false);
                e.this.aNu();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.RM();
            }
        };
        this.eVO = chatAggregationFragment;
    }

    public void n(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eWb = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eWb = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eWb);
        }
    }

    public void aCU() {
        if (this.eVS != null) {
            this.eVS.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eCs);
        MessageManager.getInstance().unRegisterListener(this.aLF);
    }

    public View aaK() {
        this.eVW = 3;
        this.rootView = LayoutInflater.from(this.eVO.getPageContext().getPageActivity()).inflate(e.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        aG(this.rootView);
        TiebaStatic.eventStat(this.eVO.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        apB();
        return this.rootView;
    }

    protected void apB() {
        this.eVR.startPullRefresh();
        this.eVY = isLogin();
        if (!this.eVY) {
            I(this.eVY, true);
        }
    }

    private void registerListener() {
        this.eVO.registerListener(2016004, this.eCs);
        this.eVO.registerListener(2016001, this.eCs);
        this.eVO.registerListener(2016010, this.eCs);
        this.eVO.registerListener(2016007, this.eCs);
        this.eVO.registerListener(2016011, this.eCs);
        this.eVO.registerListener(2016002, this.eCs);
        this.eVO.registerListener(this.aLF);
    }

    public void iS(boolean z) {
        this.eVZ = z;
    }

    public void iT(boolean z) {
        this.eWa = z;
    }

    public void onPrimary() {
        if (this.eVS != null && this.eVS.getCount() == 0) {
            iS(true);
        }
        if (this.eWa || this.eVZ) {
            this.eWa = false;
            this.eVZ = false;
            fs(false);
        }
        boolean isLogin = isLogin();
        if (this.eVY != isLogin) {
            this.eVY = isLogin;
            onUserChanged(this.eVY);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eVO.getPageContext());
        }
    }

    private void initData() {
        this.eVP = new ImMessageCenterModel();
        iW(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void aG(View view) {
        this.dww = (RelativeLayout) view.findViewById(e.g.chat_list);
        this.eVT = (ShutDownValidateTipView) view.findViewById(e.g.view_no_validate);
        this.eVT.setVisibility(8);
        this.eVT.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.iW(false);
                e.this.iV(false);
            }
        });
        this.eVR = (BdListView) view.findViewById(e.g.chat_list_content);
        this.eVR.setDividerHeight(0);
        this.eVS = new MessageAggregationListAdapter(this.eVO.getPageContext().getPageActivity());
        this.eVS.a(this);
        this.eVR.setAdapter((ListAdapter) this.eVS);
        this.eVR.setOnItemClickListener(this.mItemClickListener);
        this.eVR.setOnItemLongClickListener(this.eWc);
        this.cTy = new View(this.eVO.getFragmentActivity());
        this.cTy.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.eVO.getFragmentActivity(), e.C0175e.ds150)));
        this.eVR.addFooterView(this.cTy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eVO.getPageContext(), i);
        }
        if (this.eVT != null) {
            this.eVT.onChangeSkinType(i);
        }
        if (this.eVS != null) {
            this.eVS.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.dww);
            return true;
        }
        return true;
    }

    private void iU(boolean z) {
        if (z) {
            aUp();
        } else {
            aUq();
        }
    }

    private void aUp() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.iR().aO("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eVO.getResources().getString(e.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.eVO.getPageContext().getPageActivity(), this.dww, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eVO.getResources().getDimension(e.C0175e.ds80)), NoDataViewFactory.d.dO(e.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aUq() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.eVO.getResources().getString(e.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.eVO.getPageContext().getPageActivity(), "notlogin_10", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                ba.bH(e.this.eVO.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.eVO.getResources().getDimensionPixelSize(e.C0175e.ds320);
        int dimensionPixelSize2 = this.eVO.getResources().getDimensionPixelSize(e.C0175e.ds480);
        int dimensionPixelSize3 = this.eVO.getResources().getDimensionPixelSize(e.C0175e.ds360);
        int dimensionPixelSize4 = this.eVO.getResources().getDimensionPixelSize(e.C0175e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eVO.getPageContext().getPageActivity(), this.dww, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.F(e.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.eVO.getResources().getDimensionPixelSize(e.C0175e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        I(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.eVV = new b.InterfaceC0124b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.eVP.asyncDeleteItem(imMessageCenterShowItemData, e.this.eCv);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.eVO.getPageContext().getPageActivity().getString(e.j.delete_user_chat);
        this.eVU = new com.baidu.tbadk.core.dialog.b(this.eVO.getPageContext().getPageActivity());
        this.eVU.cC(e.j.operation);
        this.eVU.a(new String[]{string}, this.eVV);
        this.eVU.d(this.eVO.getPageContext());
    }

    protected boolean fs(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.eVR.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
        return true;
    }

    public void iV(boolean z) {
        if (z) {
            if (aUr() && this.eVT.getVisibility() != 0) {
                this.eVT.setVisibility(0);
            }
        } else if (this.eVT.getVisibility() != 8) {
            this.eVT.setVisibility(8);
        }
    }

    public void I(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eVR.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.dww.removeView(this.mNoDataView);
        }
        iU(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.eVR.setVisibility(8);
    }

    public boolean aUr() {
        return this.eVX;
    }

    public void iW(boolean z) {
        this.eVX = z;
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
                if (this.eVP != null) {
                    this.eVP.insertOrUpdate(data, this.eCu);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eVP != null) {
                this.eVP.remove(data, this.eCu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.eVP != null) {
                this.eVP.setData(data, this.eCu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eWb = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eWb != -1) {
                iS(true);
                onPrimary();
            }
        }
    }

    public void iR(boolean z) {
        if (z && this.eVR != null && this.eVR.getWrappedAdapter() != null && this.eVR.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.eVR.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bp(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                aUs();
            }
        }
    }

    private void aUs() {
        if (this.eVS != null) {
            this.eVS.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axq() {
        RM();
        if (this.eCr == null) {
            this.eCr = com.baidu.tieba.im.db.e.aPc().cE(getPageContext().getPageActivity());
        }
        this.eCr.show();
        this.eCr.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RM() {
        if (this.eCr != null && this.eCr.isShowing()) {
            this.eCr.dismiss();
            this.eCr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNu() {
        if (this.eVR != null && this.eVP != null) {
            this.eVR.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (this.eVP.getData() != null) {
                this.eVS.setData(this.eVP.getData());
            } else {
                I(isLogin(), true);
            }
        }
    }
}
