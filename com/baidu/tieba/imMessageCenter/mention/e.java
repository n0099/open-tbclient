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
    private com.baidu.tbadk.core.dialog.d eCs;
    private final CustomMessageListener eCt;
    private com.baidu.tieba.im.chat.a.a eCv;
    private final com.baidu.tieba.im.chat.a.b eCw;
    private final ChatAggregationFragment eVP;
    private ImMessageCenterModel eVQ;
    private ImMessageCenterShowItemData eVR;
    private BdListView eVS;
    private MessageAggregationListAdapter eVT;
    private ShutDownValidateTipView eVU;
    com.baidu.tbadk.core.dialog.b eVV;
    private b.InterfaceC0124b eVW;
    private int eVX;
    private boolean eVY;
    private boolean eVZ;
    private boolean eWa;
    private boolean eWb;
    private int eWc;
    private final AdapterView.OnItemLongClickListener eWd;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.aK(chatAggregationFragment.getPageContext().getPageActivity()));
        this.eVQ = null;
        this.eVR = null;
        this.eVS = null;
        this.eVT = null;
        this.eVV = null;
        this.eVY = true;
        this.eVZ = false;
        this.eWa = false;
        this.eWb = true;
        this.eWc = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData oQ = e.this.eVT.getItem(i);
                    TiebaStatic.eventStat(e.this.eVP.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = oQ.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(oQ);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eVP.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.eVP.getPageContext().getContext(), "chat_list_to_group", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.eVP.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(oQ.getFriendId(), 0L), oQ.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (oQ.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eVP.getPageContext().getOrignalPage(), 2008021)) {
                            d(oQ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GV() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GV().ez(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.eVP.getPageContext().getPageActivity())));
                        }
                    } else if (oQ.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eVP.getPageContext().getOrignalPage(), 2008013)) {
                            d(oQ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GV() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GV().ey(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.eVP.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eVP.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.eVP.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eVP.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.eVP.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(oQ.getFriendId(), 0L), oQ.getFriendName(), oQ.getFriendPortrait(), 0, oQ.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new am("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.eVP.getPageContext().getPageActivity())));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.eVP.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.eWd = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.eVR = e.this.eVT.getItem(i);
                e.this.c(e.this.eVR);
                if (e.this.eVV != null) {
                    TiebaStatic.log("c12932");
                    e.this.eVV.Ax();
                    if (e.this.eVP != null && e.this.eVP.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.eVP.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.eCt = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.eVQ.setData(null, e.this.eCv);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.eVT != null) {
                            e.this.eVT.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.eVT != null) {
                        e.this.eVT.notifyDataSetChanged();
                    }
                }
            }
        };
        this.eCv = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
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
        this.eCw = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.axr();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.eCs != null) {
                    e.this.eCs.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.RM();
                e.this.eVP.showToast(e.j.delete_success, false);
                e.this.aNu();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.RM();
            }
        };
        this.eVP = chatAggregationFragment;
    }

    public void n(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eWc = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eWc = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eWc);
        }
    }

    public void aCV() {
        if (this.eVT != null) {
            this.eVT.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eCt);
        MessageManager.getInstance().unRegisterListener(this.aLF);
    }

    public View aaL() {
        this.eVX = 3;
        this.rootView = LayoutInflater.from(this.eVP.getPageContext().getPageActivity()).inflate(e.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        aG(this.rootView);
        TiebaStatic.eventStat(this.eVP.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        apC();
        return this.rootView;
    }

    protected void apC() {
        this.eVS.startPullRefresh();
        this.eVZ = isLogin();
        if (!this.eVZ) {
            I(this.eVZ, true);
        }
    }

    private void registerListener() {
        this.eVP.registerListener(2016004, this.eCt);
        this.eVP.registerListener(2016001, this.eCt);
        this.eVP.registerListener(2016010, this.eCt);
        this.eVP.registerListener(2016007, this.eCt);
        this.eVP.registerListener(2016011, this.eCt);
        this.eVP.registerListener(2016002, this.eCt);
        this.eVP.registerListener(this.aLF);
    }

    public void iS(boolean z) {
        this.eWa = z;
    }

    public void iT(boolean z) {
        this.eWb = z;
    }

    public void onPrimary() {
        if (this.eVT != null && this.eVT.getCount() == 0) {
            iS(true);
        }
        if (this.eWb || this.eWa) {
            this.eWb = false;
            this.eWa = false;
            fs(false);
        }
        boolean isLogin = isLogin();
        if (this.eVZ != isLogin) {
            this.eVZ = isLogin;
            onUserChanged(this.eVZ);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eVP.getPageContext());
        }
    }

    private void initData() {
        this.eVQ = new ImMessageCenterModel();
        iW(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void aG(View view) {
        this.dww = (RelativeLayout) view.findViewById(e.g.chat_list);
        this.eVU = (ShutDownValidateTipView) view.findViewById(e.g.view_no_validate);
        this.eVU.setVisibility(8);
        this.eVU.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.iW(false);
                e.this.iV(false);
            }
        });
        this.eVS = (BdListView) view.findViewById(e.g.chat_list_content);
        this.eVS.setDividerHeight(0);
        this.eVT = new MessageAggregationListAdapter(this.eVP.getPageContext().getPageActivity());
        this.eVT.a(this);
        this.eVS.setAdapter((ListAdapter) this.eVT);
        this.eVS.setOnItemClickListener(this.mItemClickListener);
        this.eVS.setOnItemLongClickListener(this.eWd);
        this.cTy = new View(this.eVP.getFragmentActivity());
        this.cTy.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.eVP.getFragmentActivity(), e.C0175e.ds150)));
        this.eVS.addFooterView(this.cTy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eVP.getPageContext(), i);
        }
        if (this.eVU != null) {
            this.eVU.onChangeSkinType(i);
        }
        if (this.eVT != null) {
            this.eVT.notifyDataSetChanged();
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
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eVP.getResources().getString(e.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.eVP.getPageContext().getPageActivity(), this.dww, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eVP.getResources().getDimension(e.C0175e.ds80)), NoDataViewFactory.d.dO(e.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aUq() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.eVP.getResources().getString(e.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.eVP.getPageContext().getPageActivity(), "notlogin_10", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                ba.bH(e.this.eVP.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.eVP.getResources().getDimensionPixelSize(e.C0175e.ds320);
        int dimensionPixelSize2 = this.eVP.getResources().getDimensionPixelSize(e.C0175e.ds480);
        int dimensionPixelSize3 = this.eVP.getResources().getDimensionPixelSize(e.C0175e.ds360);
        int dimensionPixelSize4 = this.eVP.getResources().getDimensionPixelSize(e.C0175e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eVP.getPageContext().getPageActivity(), this.dww, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.F(e.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.eVP.getResources().getDimensionPixelSize(e.C0175e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        I(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.eVW = new b.InterfaceC0124b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.eVQ.asyncDeleteItem(imMessageCenterShowItemData, e.this.eCw);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.eVP.getPageContext().getPageActivity().getString(e.j.delete_user_chat);
        this.eVV = new com.baidu.tbadk.core.dialog.b(this.eVP.getPageContext().getPageActivity());
        this.eVV.cC(e.j.operation);
        this.eVV.a(new String[]{string}, this.eVW);
        this.eVV.d(this.eVP.getPageContext());
    }

    protected boolean fs(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.eVS.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
        return true;
    }

    public void iV(boolean z) {
        if (z) {
            if (aUr() && this.eVU.getVisibility() != 0) {
                this.eVU.setVisibility(0);
            }
        } else if (this.eVU.getVisibility() != 8) {
            this.eVU.setVisibility(8);
        }
    }

    public void I(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eVS.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.dww.removeView(this.mNoDataView);
        }
        iU(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.eVS.setVisibility(8);
    }

    public boolean aUr() {
        return this.eVY;
    }

    public void iW(boolean z) {
        this.eVY = z;
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
                if (this.eVQ != null) {
                    this.eVQ.insertOrUpdate(data, this.eCv);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eVQ != null) {
                this.eVQ.remove(data, this.eCv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.eVQ != null) {
                this.eVQ.setData(data, this.eCv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eWc = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eWc != -1) {
                iS(true);
                onPrimary();
            }
        }
    }

    public void iR(boolean z) {
        if (z && this.eVS != null && this.eVS.getWrappedAdapter() != null && this.eVS.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.eVS.startPullRefresh();
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
        if (this.eVT != null) {
            this.eVT.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axr() {
        RM();
        if (this.eCs == null) {
            this.eCs = com.baidu.tieba.im.db.e.aPc().cE(getPageContext().getPageActivity());
        }
        this.eCs.show();
        this.eCs.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RM() {
        if (this.eCs != null && this.eCs.isShowing()) {
            this.eCs.dismiss();
            this.eCs = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNu() {
        if (this.eVS != null && this.eVQ != null) {
            this.eVS.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            if (this.eVQ.getData() != null) {
                this.eVT.setData(this.eVQ.getData());
            } else {
                I(isLogin(), true);
            }
        }
    }
}
