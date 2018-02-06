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
    private final AdapterView.OnItemClickListener QB;
    private final CustomMessageListener bjx;
    private boolean cOH;
    private RelativeLayout dBd;
    private View ddB;
    private ImMessageCenterModel ePH;
    private ImMessageCenterShowItemData ePJ;
    private BdListView ePK;
    private ShutDownValidateTipView ePN;
    com.baidu.tbadk.core.dialog.b ePO;
    private b.InterfaceC0096b ePP;
    private int ePQ;
    private boolean ePR;
    private final AdapterView.OnItemLongClickListener ePS;
    private int eSA;
    private final g eSw;
    private MessageAggregationListAdapter eSx;
    private boolean eSy;
    private boolean eSz;
    private com.baidu.tbadk.core.dialog.d eyE;
    private final CustomMessageListener eyF;
    private com.baidu.tieba.im.chat.a.a eyH;
    private final com.baidu.tieba.im.chat.a.b eyI;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private View rootView;

    public e(g gVar) {
        super(com.baidu.adp.base.i.ak(gVar.getPageContext().getPageActivity()));
        this.ePH = null;
        this.ePJ = null;
        this.ePK = null;
        this.eSx = null;
        this.ePO = null;
        this.ePR = true;
        this.eSy = false;
        this.cOH = false;
        this.eSz = true;
        this.eSA = 16;
        this.QB = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData pJ = e.this.eSx.getItem(i);
                    TiebaStatic.eventStat(e.this.eSw.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = pJ.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(pJ);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eSw.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.eSw.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.eSw.getPageContext().getPageActivity(), Integer.parseInt(pJ.getFriendId()), pJ.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (pJ.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eSw.getPageContext().getOrignalPage(), 2008021)) {
                            d(pJ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.GJ().Hf() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().Hf().ha(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.eSw.getPageContext().getPageActivity())));
                        }
                    } else if (pJ.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eSw.getPageContext().getOrignalPage(), 2008013)) {
                            d(pJ);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.GJ().Hf() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().Hf().gZ(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.eSw.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eSw.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.eSw.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eSw.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.eSw.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(pJ.getFriendId(), 0L), pJ.getFriendName(), pJ.getFriendPortrait(), 0, pJ.getUserType())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHMOOD)) {
                        TiebaStatic.log(new ak("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.eSw.getPageContext().getPageActivity())));
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
                                com.baidu.tieba.im.db.d.aIa().nh("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aIa().nh("group_intro_change");
                                com.baidu.tieba.im.db.d.aIa().nh("group_name_change");
                                com.baidu.tieba.im.db.d.aIa().nh("group_notice_change");
                                com.baidu.tieba.im.db.d.aIa().nh("group_level_up");
                                com.baidu.tieba.im.db.d.aIa().nh("dismiss_group");
                                com.baidu.tieba.im.db.d.aIa().nh("kick_out");
                                com.baidu.tieba.im.db.d.aIa().nh("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.GJ().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.GJ().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.eSw.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.ePS = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.ePJ = e.this.eSx.getItem(i);
                e.this.c(e.this.ePJ);
                if (e.this.ePO != null) {
                    TiebaStatic.log("c12932");
                    e.this.ePO.AX();
                    if (e.this.eSw != null && e.this.eSw.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.eSw.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.eyF = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.ePH.setData(null, e.this.eyH);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.eSx != null) {
                            e.this.eSx.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.eSx != null) {
                        e.this.eSx.notifyDataSetChanged();
                    }
                }
            }
        };
        this.eyH = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void aGd() {
                e.this.aGs();
            }
        };
        this.bjx = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.eyI = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.aGr();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.eyE != null) {
                    e.this.eyE.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.abk();
                e.this.eSw.showToast(d.j.delete_success, false);
                e.this.aGs();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.abk();
            }
        };
        this.eSw = gVar;
    }

    public void o(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eSA = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eSA = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eSA);
        }
    }

    public void axD() {
        if (this.eSx != null) {
            this.eSx.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eyF);
    }

    public View YO() {
        this.ePQ = 3;
        this.rootView = LayoutInflater.from(this.eSw.getPageContext().getPageActivity()).inflate(d.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        bI(this.rootView);
        TiebaStatic.eventStat(this.eSw.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        amP();
        return this.rootView;
    }

    protected void amP() {
        this.ePK.startPullRefresh();
        this.eSy = isLogin();
        if (!this.eSy) {
            G(this.eSy, true);
        }
    }

    private void registerListener() {
        this.eSw.registerListener(2016004, this.eyF);
        this.eSw.registerListener(2016001, this.eyF);
        this.eSw.registerListener(2016010, this.eyF);
        this.eSw.registerListener(2016007, this.eyF);
        this.eSw.registerListener(2016011, this.eyF);
        this.eSw.registerListener(2016002, this.eyF);
        this.eSw.registerListener(this.bjx);
    }

    public void ig(boolean z) {
        this.cOH = z;
    }

    public void ih(boolean z) {
        this.eSz = z;
    }

    public void onPrimary() {
        if (this.eSx != null && this.eSx.getCount() == 0) {
            ig(true);
        }
        if (this.eSz || this.cOH) {
            this.eSz = false;
            this.cOH = false;
            eY(false);
        }
        boolean isLogin = isLogin();
        if (this.eSy != isLogin) {
            this.eSy = isLogin;
            onUserChanged(this.eSy);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eSw.getPageContext());
        }
    }

    private void initData() {
        this.ePH = new ImMessageCenterModel();
        ia(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void bI(View view) {
        this.dBd = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.ePN = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.ePN.setVisibility(8);
        this.ePN.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.ia(false);
                e.this.hY(false);
            }
        });
        this.ePK = (BdListView) view.findViewById(d.g.chat_list_content);
        this.ePK.setDividerHeight(0);
        this.eSx = new MessageAggregationListAdapter(this.eSw.getPageContext().getPageActivity());
        this.eSx.a(this);
        this.ePK.setAdapter((ListAdapter) this.eSx);
        this.ePK.setOnItemClickListener(this.QB);
        this.ePK.setOnItemLongClickListener(this.ePS);
        this.ddB = new View(this.eSw.getFragmentActivity());
        this.ddB.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.t(this.eSw.getFragmentActivity(), d.e.ds150)));
        this.ePK.addFooterView(this.ddB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eSw.getPageContext(), i);
        }
        if (this.ePN != null) {
            this.ePN.onChangeSkinType(i);
        }
        if (this.eSx != null) {
            this.eSx.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().aM(this.dBd);
            return true;
        }
        return true;
    }

    private void ii(boolean z) {
        if (z) {
            aMD();
        } else {
            aME();
        }
    }

    private void aMD() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.mA().an("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eSw.getResources().getString(d.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.eSw.getPageContext().getPageActivity(), this.dBd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eSw.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aME() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.eSw.getResources().getString(d.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.eSw.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ay.aZ(e.this.eSw.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.eSw.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.eSw.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.eSw.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.eSw.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eSw.getPageContext().getPageActivity(), this.dBd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aB(d.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.eSw.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        G(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.ePP = new b.InterfaceC0096b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.ePH.asyncDeleteItem(imMessageCenterShowItemData, e.this.eyI);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.eSw.getPageContext().getPageActivity().getString(d.j.delete_user_chat);
        this.ePO = new com.baidu.tbadk.core.dialog.b(this.eSw.getPageContext().getPageActivity());
        this.ePO.fe(d.j.operation);
        this.ePO.a(new String[]{string}, this.ePP);
        this.ePO.d(this.eSw.getPageContext());
    }

    protected boolean eY(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.ePK.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void hY(boolean z) {
        if (z) {
            if (aMF() && this.ePN.getVisibility() != 0) {
                this.ePN.setVisibility(0);
            }
        } else if (this.ePN.getVisibility() != 8) {
            this.ePN.setVisibility(8);
        }
    }

    public void G(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.ePK.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.dBd.removeView(this.mNoDataView);
        }
        ii(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.ePK.setVisibility(8);
    }

    public boolean aMF() {
        return this.ePR;
    }

    public void ia(boolean z) {
        this.ePR = z;
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
                if (this.ePH != null) {
                    this.ePH.insertOrUpdate(data, this.eyH);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.ePH != null) {
                this.ePH.remove(data, this.eyH);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.ePH != null) {
                this.ePH.setData(data, this.eyH);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eSA = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eSA != -1) {
                ig(true);
                onPrimary();
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m17if(boolean z) {
        if (z && this.ePK != null && this.ePK.getWrappedAdapter() != null && this.ePK.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.ePK.startPullRefresh();
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
                aNw();
            }
        }
    }

    private void aNw() {
        if (this.eSx != null) {
            this.eSx.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGr() {
        abk();
        if (this.eyE == null) {
            this.eyE = com.baidu.tieba.im.db.e.aIb().bL(getPageContext().getPageActivity());
        }
        this.eyE.show();
        this.eyE.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abk() {
        if (this.eyE != null && this.eyE.isShowing()) {
            this.eyE.dismiss();
            this.eyE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGs() {
        if (this.ePK != null && this.ePH != null) {
            this.ePK.completePullRefreshPostDelayed(2000L);
            if (this.ePH.getData() != null) {
                this.eSx.setData(this.ePH.getData());
            } else {
                G(isLogin(), true);
            }
        }
    }
}
