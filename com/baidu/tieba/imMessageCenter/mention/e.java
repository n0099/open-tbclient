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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
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
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements f.b {
    private final CustomMessageListener aDd;
    private boolean cnG;
    private RelativeLayout ddV;
    private com.baidu.tbadk.core.dialog.d efC;
    private final CustomMessageListener efD;
    private com.baidu.tieba.im.chat.a.a efF;
    private final com.baidu.tieba.im.chat.a.b efG;
    private final ChatAggregationFragment ezm;
    private ImMessageCenterModel ezn;
    private ImMessageCenterShowItemData ezo;
    private BdListView ezp;
    private MessageAggregationListAdapter ezq;
    private ShutDownValidateTipView ezr;
    com.baidu.tbadk.core.dialog.b ezs;
    private b.InterfaceC0103b ezt;
    private int ezu;
    private boolean ezv;
    private boolean ezw;
    private boolean ezx;
    private int ezy;
    private final AdapterView.OnItemLongClickListener ezz;
    private View mFooterView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ad(chatAggregationFragment.getPageContext().getPageActivity()));
        this.ezn = null;
        this.ezo = null;
        this.ezp = null;
        this.ezq = null;
        this.ezs = null;
        this.ezv = true;
        this.ezw = false;
        this.cnG = false;
        this.ezx = true;
        this.ezy = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData nt = e.this.ezq.getItem(i);
                    TiebaStatic.eventStat(e.this.ezm.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = nt.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(nt);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.ezm.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.ezm.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.ezm.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(nt.getFriendId(), 0L), nt.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (nt.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.ezm.getPageContext().getOrignalPage(), 2008021)) {
                            d(nt);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.CX().Dt() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.CX().Dt().eb(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.ezm.getPageContext().getPageActivity())));
                        }
                    } else if (nt.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.ezm.getPageContext().getOrignalPage(), 2008013)) {
                            d(nt);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.CX().Dt() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.CX().Dt().ea(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.ezm.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.ezm.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.ezm.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.d(e.this.ezm.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.ezm.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(nt.getFriendId(), 0L), nt.getFriendName(), nt.getFriendPortrait(), 0, nt.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new am("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.ezm.getPageContext().getPageActivity())));
                    } else {
                        e(nt);
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
                                com.baidu.tieba.im.db.d.aHS().oa("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aHS().oa("group_intro_change");
                                com.baidu.tieba.im.db.d.aHS().oa("group_name_change");
                                com.baidu.tieba.im.db.d.aHS().oa("group_notice_change");
                                com.baidu.tieba.im.db.d.aHS().oa("group_level_up");
                                com.baidu.tieba.im.db.d.aHS().oa("dismiss_group");
                                com.baidu.tieba.im.db.d.aHS().oa("kick_out");
                                com.baidu.tieba.im.db.d.aHS().oa("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.CX().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.ezm.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.ezz = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.ezo = e.this.ezq.getItem(i);
                e.this.c(e.this.ezo);
                if (e.this.ezs != null) {
                    TiebaStatic.log("c12932");
                    e.this.ezs.xd();
                    if (e.this.ezm != null && e.this.ezm.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.ezm.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.efD = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.ezn.setData(null, e.this.efF);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.ezq != null) {
                            e.this.ezq.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.ezq != null) {
                        e.this.ezq.notifyDataSetChanged();
                    }
                }
            }
        };
        this.efF = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void aFW() {
                e.this.aGl();
            }
        };
        this.aDd = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.efG = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.aGk();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.efC != null) {
                    e.this.efC.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.YO();
                e.this.ezm.showToast(d.k.delete_success, false);
                e.this.aGl();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.YO();
            }
        };
        this.ezm = chatAggregationFragment;
    }

    public void m(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.ezy = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.ezy = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.ezy);
        }
    }

    public void awg() {
        if (this.ezq != null) {
            this.ezq.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.efD);
        MessageManager.getInstance().unRegisterListener(this.aDd);
    }

    public View UI() {
        this.ezu = 3;
        this.rootView = LayoutInflater.from(this.ezm.getPageContext().getPageActivity()).inflate(d.i.chat_list_activity, (ViewGroup) null, false);
        initData();
        an(this.rootView);
        TiebaStatic.eventStat(this.ezm.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        akv();
        return this.rootView;
    }

    protected void akv() {
        this.ezp.startPullRefresh();
        this.ezw = isLogin();
        if (!this.ezw) {
            C(this.ezw, true);
        }
    }

    private void registerListener() {
        this.ezm.registerListener(2016004, this.efD);
        this.ezm.registerListener(2016001, this.efD);
        this.ezm.registerListener(2016010, this.efD);
        this.ezm.registerListener(2016007, this.efD);
        this.ezm.registerListener(2016011, this.efD);
        this.ezm.registerListener(2016002, this.efD);
        this.ezm.registerListener(this.aDd);
    }

    public void hP(boolean z) {
        this.cnG = z;
    }

    public void hQ(boolean z) {
        this.ezx = z;
    }

    public void onPrimary() {
        if (this.ezq != null && this.ezq.getCount() == 0) {
            hP(true);
        }
        if (this.ezx || this.cnG) {
            this.ezx = false;
            this.cnG = false;
            eI(false);
        }
        boolean isLogin = isLogin();
        if (this.ezw != isLogin) {
            this.ezw = isLogin;
            onUserChanged(this.ezw);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.ezm.getPageContext());
        }
    }

    private void initData() {
        this.ezn = new ImMessageCenterModel();
        hT(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void an(View view) {
        this.ddV = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.ezr = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.ezr.setVisibility(8);
        this.ezr.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.hT(false);
                e.this.hS(false);
            }
        });
        this.ezp = (BdListView) view.findViewById(d.g.chat_list_content);
        this.ezp.setDividerHeight(0);
        this.ezq = new MessageAggregationListAdapter(this.ezm.getPageContext().getPageActivity());
        this.ezq.a(this);
        this.ezp.setAdapter((ListAdapter) this.ezq);
        this.ezp.setOnItemClickListener(this.mItemClickListener);
        this.ezp.setOnItemLongClickListener(this.ezz);
        this.mFooterView = new View(this.ezm.getFragmentActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.ezm.getFragmentActivity(), d.e.ds150)));
        this.ezp.addFooterView(this.mFooterView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ezm.getPageContext(), i);
        }
        if (this.ezr != null) {
            this.ezr.onChangeSkinType(i);
        }
        if (this.ezq != null) {
            this.ezq.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.ddV);
            return true;
        }
        return true;
    }

    private void hR(boolean z) {
        if (z) {
            aNj();
        } else {
            aNk();
        }
    }

    private void aNj() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.hv().aw("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ezm.getResources().getString(d.k.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.ezm.getPageContext().getPageActivity(), this.ddV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.ezm.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dr(d.k.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aNk() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.ezm.getResources().getString(d.k.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.ezm.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ba.aT(e.this.ezm.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.ezm.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.ezm.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.ezm.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.ezm.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.ezm.getPageContext().getPageActivity(), this.ddV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.k.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.ezm.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        C(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.ezt = new b.InterfaceC0103b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.ezn.asyncDeleteItem(imMessageCenterShowItemData, e.this.efG);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.ezm.getPageContext().getPageActivity().getString(d.k.delete_user_chat);
        this.ezs = new com.baidu.tbadk.core.dialog.b(this.ezm.getPageContext().getPageActivity());
        this.ezs.cf(d.k.operation);
        this.ezs.a(new String[]{string}, this.ezt);
        this.ezs.d(this.ezm.getPageContext());
    }

    protected boolean eI(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.ezp.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void hS(boolean z) {
        if (z) {
            if (aNl() && this.ezr.getVisibility() != 0) {
                this.ezr.setVisibility(0);
            }
        } else if (this.ezr.getVisibility() != 8) {
            this.ezr.setVisibility(8);
        }
    }

    public void C(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.ezp.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.ddV.removeView(this.mNoDataView);
        }
        hR(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.ezp.setVisibility(8);
    }

    public boolean aNl() {
        return this.ezv;
    }

    public void hT(boolean z) {
        this.ezv = z;
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
                if (this.ezn != null) {
                    this.ezn.insertOrUpdate(data, this.efF);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.ezn != null) {
                this.ezn.remove(data, this.efF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.ezn != null) {
                this.ezn.setData(data, this.efF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.ezy = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.ezy != -1) {
                hP(true);
                onPrimary();
            }
        }
    }

    public void hO(boolean z) {
        if (z && this.ezp != null && this.ezp.getWrappedAdapter() != null && this.ezp.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.ezp.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.f.b
    public void aS(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                aNm();
            }
        }
    }

    private void aNm() {
        if (this.ezq != null) {
            this.ezq.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGk() {
        YO();
        if (this.efC == null) {
            this.efC = com.baidu.tieba.im.db.e.aHT().bK(getPageContext().getPageActivity());
        }
        this.efC.show();
        this.efC.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YO() {
        if (this.efC != null && this.efC.isShowing()) {
            this.efC.dismiss();
            this.efC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGl() {
        if (this.ezp != null && this.ezn != null) {
            this.ezp.completePullRefreshPostDelayed(2000L);
            if (this.ezn.getData() != null) {
                this.ezq.setData(this.ezn.getData());
            } else {
                C(isLogin(), true);
            }
        }
    }
}
