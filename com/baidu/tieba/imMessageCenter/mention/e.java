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
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.d;
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
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.base.c<g> implements j.b {
    private final AdapterView.OnItemClickListener Qw;
    private final CustomMessageListener bjk;
    private boolean cOv;
    private RelativeLayout dAR;
    private View ddo;
    private ShutDownValidateTipView ePB;
    com.baidu.tbadk.core.dialog.b ePC;
    private b.InterfaceC0097b ePD;
    private int ePE;
    private boolean ePF;
    private final AdapterView.OnItemLongClickListener ePG;
    private ImMessageCenterModel ePv;
    private ImMessageCenterShowItemData ePx;
    private BdListView ePy;
    private final g eSk;
    private MessageAggregationListAdapter eSl;
    private boolean eSm;
    private boolean eSn;
    private int eSo;
    private com.baidu.tbadk.core.dialog.d eys;
    private final CustomMessageListener eyt;
    private com.baidu.tieba.im.chat.a.a eyv;
    private final com.baidu.tieba.im.chat.a.b eyw;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.ak(gVar.getPageContext().getPageActivity()));
        this.ePv = null;
        this.ePx = null;
        this.ePy = null;
        this.eSl = null;
        this.ePC = null;
        this.ePF = true;
        this.eSm = false;
        this.cOv = false;
        this.eSn = true;
        this.eSo = 16;
        this.Qw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData pJ = e.this.eSl.getItem(i);
                    TiebaStatic.eventStat(e.this.eSk.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = pJ.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(pJ);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eSk.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.eSk.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.eSk.getPageContext().getPageActivity(), Integer.parseInt(pJ.getFriendId()), pJ.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (pJ.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eSk.getPageContext().getOrignalPage(), 2008021)) {
                            d(pJ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.GI().He() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.GI().He().ha(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.eSk.getPageContext().getPageActivity())));
                        }
                    } else if (pJ.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eSk.getPageContext().getOrignalPage(), 2008013)) {
                            d(pJ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.GI().He() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.GI().He().gZ(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.eSk.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eSk.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.eSk.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eSk.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.eSk.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(pJ.getFriendId(), 0L), pJ.getFriendName(), pJ.getFriendPortrait(), 0, pJ.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ak("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.eSk.getPageContext().getPageActivity())));
                    } else {
                        e(pJ);
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
                                com.baidu.tieba.im.db.d.aHZ().nh("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aHZ().nh("group_intro_change");
                                com.baidu.tieba.im.db.d.aHZ().nh("group_name_change");
                                com.baidu.tieba.im.db.d.aHZ().nh("group_notice_change");
                                com.baidu.tieba.im.db.d.aHZ().nh("group_level_up");
                                com.baidu.tieba.im.db.d.aHZ().nh("dismiss_group");
                                com.baidu.tieba.im.db.d.aHZ().nh("kick_out");
                                com.baidu.tieba.im.db.d.aHZ().nh("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.GI().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.GI().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.eSk.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.ePG = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.ePx = e.this.eSl.getItem(i);
                e.this.c(e.this.ePx);
                if (e.this.ePC != null) {
                    TiebaStatic.log("c12932");
                    e.this.ePC.AX();
                    if (e.this.eSk != null && e.this.eSk.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.eSk.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.eyt = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.ePv.setData(null, e.this.eyv);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.eSl != null) {
                            e.this.eSl.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.eSl != null) {
                        e.this.eSl.notifyDataSetChanged();
                    }
                }
            }
        };
        this.eyv = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void aGc() {
                e.this.aGr();
            }
        };
        this.bjk = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.eyw = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.aGq();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.eys != null) {
                    e.this.eys.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.abj();
                e.this.eSk.showToast(d.j.delete_success, false);
                e.this.aGr();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.abj();
            }
        };
        this.eSk = gVar;
    }

    public void o(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eSo = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eSo = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eSo);
        }
    }

    public void axC() {
        if (this.eSl != null) {
            this.eSl.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eyt);
    }

    public View YN() {
        this.ePE = 3;
        this.rootView = LayoutInflater.from(this.eSk.getPageContext().getPageActivity()).inflate(d.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        bI(this.rootView);
        TiebaStatic.eventStat(this.eSk.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        amO();
        return this.rootView;
    }

    protected void amO() {
        this.ePy.startPullRefresh();
        this.eSm = isLogin();
        if (!this.eSm) {
            G(this.eSm, true);
        }
    }

    private void registerListener() {
        this.eSk.registerListener(2016004, this.eyt);
        this.eSk.registerListener(2016001, this.eyt);
        this.eSk.registerListener(2016010, this.eyt);
        this.eSk.registerListener(2016007, this.eyt);
        this.eSk.registerListener(2016011, this.eyt);
        this.eSk.registerListener(2016002, this.eyt);
        this.eSk.registerListener(this.bjk);
    }

    public void ig(boolean z) {
        this.cOv = z;
    }

    public void ih(boolean z) {
        this.eSn = z;
    }

    public void onPrimary() {
        if (this.eSl != null && this.eSl.getCount() == 0) {
            ig(true);
        }
        if (this.eSn || this.cOv) {
            this.eSn = false;
            this.cOv = false;
            eY(false);
        }
        boolean isLogin = isLogin();
        if (this.eSm != isLogin) {
            this.eSm = isLogin;
            onUserChanged(this.eSm);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eSk.getPageContext());
        }
    }

    private void initData() {
        this.ePv = new ImMessageCenterModel();
        ia(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bI(View view) {
        this.dAR = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.ePB = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.ePB.setVisibility(8);
        this.ePB.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.ia(false);
                e.this.hY(false);
            }
        });
        this.ePy = (BdListView) view.findViewById(d.g.chat_list_content);
        this.ePy.setDividerHeight(0);
        this.eSl = new MessageAggregationListAdapter(this.eSk.getPageContext().getPageActivity());
        this.eSl.a(this);
        this.ePy.setAdapter((ListAdapter) this.eSl);
        this.ePy.setOnItemClickListener(this.Qw);
        this.ePy.setOnItemLongClickListener(this.ePG);
        this.ddo = new View(this.eSk.getFragmentActivity());
        this.ddo.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.t(this.eSk.getFragmentActivity(), d.e.ds150)));
        this.ePy.addFooterView(this.ddo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eSk.getPageContext(), i);
        }
        if (this.ePB != null) {
            this.ePB.onChangeSkinType(i);
        }
        if (this.eSl != null) {
            this.eSl.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().aM(this.dAR);
            return true;
        }
        return true;
    }

    private void ii(boolean z) {
        if (z) {
            aMC();
        } else {
            aMD();
        }
    }

    private void aMC() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.mA().an("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eSk.getResources().getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.eSk.getPageContext().getPageActivity(), this.dAR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eSk.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aMD() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.eSk.getResources().getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.eSk.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ay.aZ(e.this.eSk.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.eSk.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.eSk.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.eSk.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.eSk.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eSk.getPageContext().getPageActivity(), this.dAR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aB(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.eSk.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        G(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.ePD = new b.InterfaceC0097b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.ePv.asyncDeleteItem(imMessageCenterShowItemData, e.this.eyw);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.eSk.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.ePC = new com.baidu.tbadk.core.dialog.b(this.eSk.getPageContext().getPageActivity());
        this.ePC.fe(d.j.operation);
        this.ePC.a(new String[]{string}, this.ePD);
        this.ePC.d(this.eSk.getPageContext());
    }

    protected boolean eY(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.ePy.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void hY(boolean z) {
        if (z) {
            if (aME() && this.ePB.getVisibility() != 0) {
                this.ePB.setVisibility(0);
            }
        } else if (this.ePB.getVisibility() != 8) {
            this.ePB.setVisibility(8);
        }
    }

    public void G(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.ePy.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.dAR.removeView(this.mNoDataView);
        }
        ii(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.ePy.setVisibility(8);
    }

    public boolean aME() {
        return this.ePF;
    }

    public void ia(boolean z) {
        this.ePF = z;
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
                if (this.ePv != null) {
                    this.ePv.insertOrUpdate(data, this.eyv);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.ePv != null) {
                this.ePv.remove(data, this.eyv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.ePv != null) {
                this.ePv.setData(data, this.eyv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eSo = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eSo != -1) {
                ig(true);
                onPrimary();
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m17if(boolean z) {
        if (z && this.ePy != null && this.ePy.getWrappedAdapter() != null && this.ePy.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.ePy.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bw(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                aNv();
            }
        }
    }

    private void aNv() {
        if (this.eSl != null) {
            this.eSl.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGq() {
        abj();
        if (this.eys == null) {
            this.eys = com.baidu.tieba.im.db.e.aIa().bL(getPageContext().getPageActivity());
        }
        this.eys.show();
        this.eys.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abj() {
        if (this.eys != null && this.eys.isShowing()) {
            this.eys.dismiss();
            this.eys = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGr() {
        if (this.ePy != null && this.ePv != null) {
            this.ePy.completePullRefreshPostDelayed(2000L);
            if (this.ePv.getData() != null) {
                this.eSl.setData(this.ePv.getData());
            } else {
                G(isLogin(), true);
            }
        }
    }
}
