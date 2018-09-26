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
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements j.b {
    private final CustomMessageListener aHc;
    private View cLf;
    private RelativeLayout dou;
    private final ChatAggregationFragment eOg;
    private ImMessageCenterModel eOh;
    private ImMessageCenterShowItemData eOi;
    private BdListView eOj;
    private MessageAggregationListAdapter eOk;
    private ShutDownValidateTipView eOl;
    com.baidu.tbadk.core.dialog.b eOm;
    private b.InterfaceC0100b eOn;
    private int eOo;
    private boolean eOp;
    private boolean eOq;
    private boolean eOr;
    private boolean eOs;
    private int eOt;
    private final AdapterView.OnItemLongClickListener eOu;
    private com.baidu.tbadk.core.dialog.d euD;
    private final CustomMessageListener euE;
    private com.baidu.tieba.im.chat.a.a euG;
    private final com.baidu.tieba.im.chat.a.b euH;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.aK(chatAggregationFragment.getPageContext().getPageActivity()));
        this.eOh = null;
        this.eOi = null;
        this.eOj = null;
        this.eOk = null;
        this.eOm = null;
        this.eOp = true;
        this.eOq = false;
        this.eOr = false;
        this.eOs = true;
        this.eOt = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData os = e.this.eOk.getItem(i);
                    TiebaStatic.eventStat(e.this.eOg.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = os.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(os);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eOg.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.eOg.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.eOg.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(os.getFriendId(), 0L), os.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (os.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eOg.getPageContext().getOrignalPage(), 2008021)) {
                            d(os);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Ey().EU() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Ey().EU().eq(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.eOg.getPageContext().getPageActivity())));
                        }
                    } else if (os.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eOg.getPageContext().getOrignalPage(), 2008013)) {
                            d(os);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Ey().EU() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Ey().EU().ep(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.eOg.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eOg.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.eOg.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eOg.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.eOg.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(os.getFriendId(), 0L), os.getFriendName(), os.getFriendPortrait(), 0, os.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new am("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.eOg.getPageContext().getPageActivity())));
                    } else {
                        e(os);
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
                                com.baidu.tieba.im.db.d.aLM().oM("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aLM().oM("group_intro_change");
                                com.baidu.tieba.im.db.d.aLM().oM("group_name_change");
                                com.baidu.tieba.im.db.d.aLM().oM("group_notice_change");
                                com.baidu.tieba.im.db.d.aLM().oM("group_level_up");
                                com.baidu.tieba.im.db.d.aLM().oM("dismiss_group");
                                com.baidu.tieba.im.db.d.aLM().oM("kick_out");
                                com.baidu.tieba.im.db.d.aLM().oM("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.Ey().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.Ey().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.eOg.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.eOu = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.eOi = e.this.eOk.getItem(i);
                e.this.c(e.this.eOi);
                if (e.this.eOm != null) {
                    TiebaStatic.log("c12932");
                    e.this.eOm.yo();
                    if (e.this.eOg != null && e.this.eOg.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.eOg.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.euE = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.eOh.setData(null, e.this.euG);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.eOk != null) {
                            e.this.eOk.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.eOk != null) {
                        e.this.eOk.notifyDataSetChanged();
                    }
                }
            }
        };
        this.euG = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void aJQ() {
                e.this.aKe();
            }
        };
        this.aHc = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.euH = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.atU();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.euD != null) {
                    e.this.euD.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.PS();
                e.this.eOg.showToast(e.j.delete_success, false);
                e.this.aKe();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.PS();
            }
        };
        this.eOg = chatAggregationFragment;
    }

    public void m(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eOt = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eOt = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eOt);
        }
    }

    public void azB() {
        if (this.eOk != null) {
            this.eOk.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.euE);
        MessageManager.getInstance().unRegisterListener(this.aHc);
    }

    public View Xd() {
        this.eOo = 3;
        this.rootView = LayoutInflater.from(this.eOg.getPageContext().getPageActivity()).inflate(e.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        aG(this.rootView);
        TiebaStatic.eventStat(this.eOg.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        amb();
        return this.rootView;
    }

    protected void amb() {
        this.eOj.startPullRefresh();
        this.eOq = isLogin();
        if (!this.eOq) {
            H(this.eOq, true);
        }
    }

    private void registerListener() {
        this.eOg.registerListener(2016004, this.euE);
        this.eOg.registerListener(2016001, this.euE);
        this.eOg.registerListener(2016010, this.euE);
        this.eOg.registerListener(2016007, this.euE);
        this.eOg.registerListener(2016011, this.euE);
        this.eOg.registerListener(2016002, this.euE);
        this.eOg.registerListener(this.aHc);
    }

    public void iA(boolean z) {
        this.eOr = z;
    }

    public void iB(boolean z) {
        this.eOs = z;
    }

    public void onPrimary() {
        if (this.eOk != null && this.eOk.getCount() == 0) {
            iA(true);
        }
        if (this.eOs || this.eOr) {
            this.eOs = false;
            this.eOr = false;
            fa(false);
        }
        boolean isLogin = isLogin();
        if (this.eOq != isLogin) {
            this.eOq = isLogin;
            onUserChanged(this.eOq);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eOg.getPageContext());
        }
    }

    private void initData() {
        this.eOh = new ImMessageCenterModel();
        iE(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void aG(View view) {
        this.dou = (RelativeLayout) view.findViewById(e.g.chat_list);
        this.eOl = (ShutDownValidateTipView) view.findViewById(e.g.view_no_validate);
        this.eOl.setVisibility(8);
        this.eOl.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.iE(false);
                e.this.iD(false);
            }
        });
        this.eOj = (BdListView) view.findViewById(e.g.chat_list_content);
        this.eOj.setDividerHeight(0);
        this.eOk = new MessageAggregationListAdapter(this.eOg.getPageContext().getPageActivity());
        this.eOk.a(this);
        this.eOj.setAdapter((ListAdapter) this.eOk);
        this.eOj.setOnItemClickListener(this.mItemClickListener);
        this.eOj.setOnItemLongClickListener(this.eOu);
        this.cLf = new View(this.eOg.getFragmentActivity());
        this.cLf.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.eOg.getFragmentActivity(), e.C0141e.ds150)));
        this.eOj.addFooterView(this.cLf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eOg.getPageContext(), i);
        }
        if (this.eOl != null) {
            this.eOl.onChangeSkinType(i);
        }
        if (this.eOk != null) {
            this.eOk.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.dou);
            return true;
        }
        return true;
    }

    private void iC(boolean z) {
        if (z) {
            aRb();
        } else {
            aRc();
        }
    }

    private void aRb() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.iB().aO("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eOg.getResources().getString(e.j.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.eOg.getPageContext().getPageActivity(), this.dou, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eOg.getResources().getDimension(e.C0141e.ds80)), NoDataViewFactory.d.dE(e.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aRc() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.eOg.getResources().getString(e.j.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.eOg.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ba.bz(e.this.eOg.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.eOg.getResources().getDimensionPixelSize(e.C0141e.ds320);
        int dimensionPixelSize2 = this.eOg.getResources().getDimensionPixelSize(e.C0141e.ds480);
        int dimensionPixelSize3 = this.eOg.getResources().getDimensionPixelSize(e.C0141e.ds360);
        int dimensionPixelSize4 = this.eOg.getResources().getDimensionPixelSize(e.C0141e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eOg.getPageContext().getPageActivity(), this.dou, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.F(e.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.eOg.getResources().getDimensionPixelSize(e.C0141e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        H(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.eOn = new b.InterfaceC0100b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.eOh.asyncDeleteItem(imMessageCenterShowItemData, e.this.euH);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.eOg.getPageContext().getPageActivity().getString(e.j.delete_user_chat);
        this.eOm = new com.baidu.tbadk.core.dialog.b(this.eOg.getPageContext().getPageActivity());
        this.eOm.cs(e.j.operation);
        this.eOm.a(new String[]{string}, this.eOn);
        this.eOm.d(this.eOg.getPageContext());
    }

    protected boolean fa(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.eOj.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void iD(boolean z) {
        if (z) {
            if (aRd() && this.eOl.getVisibility() != 0) {
                this.eOl.setVisibility(0);
            }
        } else if (this.eOl.getVisibility() != 8) {
            this.eOl.setVisibility(8);
        }
    }

    public void H(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eOj.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.dou.removeView(this.mNoDataView);
        }
        iC(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.eOj.setVisibility(8);
    }

    public boolean aRd() {
        return this.eOp;
    }

    public void iE(boolean z) {
        this.eOp = z;
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
                if (this.eOh != null) {
                    this.eOh.insertOrUpdate(data, this.euG);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eOh != null) {
                this.eOh.remove(data, this.euG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.eOh != null) {
                this.eOh.setData(data, this.euG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eOt = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eOt != -1) {
                iA(true);
                onPrimary();
            }
        }
    }

    public void iz(boolean z) {
        if (z && this.eOj != null && this.eOj.getWrappedAdapter() != null && this.eOj.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.eOj.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bf(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                aRe();
            }
        }
    }

    private void aRe() {
        if (this.eOk != null) {
            this.eOk.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atU() {
        PS();
        if (this.euD == null) {
            this.euD = com.baidu.tieba.im.db.e.aLN().cr(getPageContext().getPageActivity());
        }
        this.euD.show();
        this.euD.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PS() {
        if (this.euD != null && this.euD.isShowing()) {
            this.euD.dismiss();
            this.euD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKe() {
        if (this.eOj != null && this.eOh != null) {
            this.eOj.completePullRefreshPostDelayed(2000L);
            if (this.eOh.getData() != null) {
                this.eOk.setData(this.eOh.getData());
            } else {
                H(isLogin(), true);
            }
        }
    }
}
