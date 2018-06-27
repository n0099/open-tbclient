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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
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
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements g.b {
    private final CustomMessageListener aDX;
    private RelativeLayout dfN;
    private final ChatAggregationFragment eDb;
    private ImMessageCenterModel eDc;
    private ImMessageCenterShowItemData eDd;
    private BdListView eDe;
    private MessageAggregationListAdapter eDf;
    private ShutDownValidateTipView eDg;
    com.baidu.tbadk.core.dialog.b eDh;
    private b.InterfaceC0104b eDi;
    private int eDj;
    private boolean eDk;
    private boolean eDl;
    private boolean eDm;
    private boolean eDn;
    private int eDo;
    private final AdapterView.OnItemLongClickListener eDp;
    private com.baidu.tbadk.core.dialog.d ejv;
    private final CustomMessageListener ejw;
    private com.baidu.tieba.im.chat.a.a ejy;
    private final com.baidu.tieba.im.chat.a.b ejz;
    private View mFooterView;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ad(chatAggregationFragment.getPageContext().getPageActivity()));
        this.eDc = null;
        this.eDd = null;
        this.eDe = null;
        this.eDf = null;
        this.eDh = null;
        this.eDk = true;
        this.eDl = false;
        this.eDm = false;
        this.eDn = true;
        this.eDo = 16;
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData nA = e.this.eDf.getItem(i);
                    TiebaStatic.eventStat(e.this.eDb.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = nA.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(nA);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eDb.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.eDb.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.eDb.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(nA.getFriendId(), 0L), nA.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (nA.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eDb.getPageContext().getOrignalPage(), 2008021)) {
                            d(nA);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DL() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DL().ec(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.eDb.getPageContext().getPageActivity())));
                        }
                    } else if (nA.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eDb.getPageContext().getOrignalPage(), 2008013)) {
                            d(nA);
                            if (com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DL() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DL().eb(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.eDb.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eDb.getPageContext().getOrignalPage(), 2008022)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(e.this.eDb.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.eDb.getPageContext().getOrignalPage(), 2002006)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.eDb.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(nA.getFriendId(), 0L), nA.getFriendName(), nA.getFriendPortrait(), 0, nA.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new an("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.eDb.getPageContext().getPageActivity())));
                    } else {
                        e(nA);
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
                                com.baidu.tieba.im.db.d.aIz().ob("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.aIz().ob("group_intro_change");
                                com.baidu.tieba.im.db.d.aIz().ob("group_name_change");
                                com.baidu.tieba.im.db.d.aIz().ob("group_notice_change");
                                com.baidu.tieba.im.db.d.aIz().ob("group_level_up");
                                com.baidu.tieba.im.db.d.aIz().ob("dismiss_group");
                                com.baidu.tieba.im.db.d.aIz().ob("kick_out");
                                com.baidu.tieba.im.db.d.aIz().ob("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dp().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.Dp().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.eDb.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.eDp = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.eDd = e.this.eDf.getItem(i);
                e.this.c(e.this.eDd);
                if (e.this.eDh != null) {
                    TiebaStatic.log("c12932");
                    e.this.eDh.xq();
                    if (e.this.eDb != null && e.this.eDb.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.eDb.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.ejw = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
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
                        e.this.eDc.setData(null, e.this.ejy);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.eDf != null) {
                            e.this.eDf.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.eDf != null) {
                        e.this.eDf.notifyDataSetChanged();
                    }
                }
            }
        };
        this.ejy = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tieba.im.chat.a.a
            public void aGE() {
                e.this.aGS();
            }
        };
        this.aDX = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.c((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.ejz = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.arD();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.ejv != null) {
                    e.this.ejv.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.Zr();
                e.this.eDb.showToast(d.k.delete_success, false);
                e.this.aGS();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.Zr();
            }
        };
        this.eDb = chatAggregationFragment;
    }

    public void m(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.eDo = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.eDo = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.eDo);
        }
    }

    public void awK() {
        if (this.eDf != null) {
            this.eDf.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ejw);
        MessageManager.getInstance().unRegisterListener(this.aDX);
    }

    public View Vd() {
        this.eDj = 3;
        this.rootView = LayoutInflater.from(this.eDb.getPageContext().getPageActivity()).inflate(d.i.chat_list_activity, (ViewGroup) null, false);
        initData();
        ap(this.rootView);
        TiebaStatic.eventStat(this.eDb.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        ajP();
        return this.rootView;
    }

    protected void ajP() {
        this.eDe.startPullRefresh();
        this.eDl = isLogin();
        if (!this.eDl) {
            F(this.eDl, true);
        }
    }

    private void registerListener() {
        this.eDb.registerListener(2016004, this.ejw);
        this.eDb.registerListener(2016001, this.ejw);
        this.eDb.registerListener(2016010, this.ejw);
        this.eDb.registerListener(2016007, this.ejw);
        this.eDb.registerListener(2016011, this.ejw);
        this.eDb.registerListener(2016002, this.ejw);
        this.eDb.registerListener(this.aDX);
    }

    public void hZ(boolean z) {
        this.eDm = z;
    }

    public void ia(boolean z) {
        this.eDn = z;
    }

    public void onPrimary() {
        if (this.eDf != null && this.eDf.getCount() == 0) {
            hZ(true);
        }
        if (this.eDn || this.eDm) {
            this.eDn = false;
            this.eDm = false;
            eI(false);
        }
        boolean isLogin = isLogin();
        if (this.eDl != isLogin) {
            this.eDl = isLogin;
            onUserChanged(this.eDl);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eDb.getPageContext());
        }
    }

    private void initData() {
        this.eDc = new ImMessageCenterModel();
        id(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void ap(View view) {
        this.dfN = (RelativeLayout) view.findViewById(d.g.chat_list);
        this.eDg = (ShutDownValidateTipView) view.findViewById(d.g.view_no_validate);
        this.eDg.setVisibility(8);
        this.eDg.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
                e.this.id(false);
                e.this.ic(false);
            }
        });
        this.eDe = (BdListView) view.findViewById(d.g.chat_list_content);
        this.eDe.setDividerHeight(0);
        this.eDf = new MessageAggregationListAdapter(this.eDb.getPageContext().getPageActivity());
        this.eDf.a(this);
        this.eDe.setAdapter((ListAdapter) this.eDf);
        this.eDe.setOnItemClickListener(this.mItemClickListener);
        this.eDe.setOnItemLongClickListener(this.eDp);
        this.mFooterView = new View(this.eDb.getFragmentActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.eDb.getFragmentActivity(), d.e.ds150)));
        this.eDe.addFooterView(this.mFooterView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eDb.getPageContext(), i);
        }
        if (this.eDg != null) {
            this.eDg.onChangeSkinType(i);
        }
        if (this.eDf != null) {
            this.eDf.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.dfN);
            return true;
        }
        return true;
    }

    private void ib(boolean z) {
        if (z) {
            aNP();
        } else {
            aNQ();
        }
    }

    private void aNP() {
        NoDataViewFactory.b bVar = null;
        if (com.baidu.adp.lib.b.d.hv().aw("android_message_can_friend_chat") == 1) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eDb.getResources().getString(d.k.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
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
        this.mNoDataView = NoDataViewFactory.a(this.eDb.getPageContext().getPageActivity(), this.dfN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eDb.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.ds(d.k.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void aNQ() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.eDb.getResources().getString(d.k.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.eDb.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bb.aT(e.this.eDb.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.eDb.getResources().getDimensionPixelSize(d.e.ds320);
        int dimensionPixelSize2 = this.eDb.getResources().getDimensionPixelSize(d.e.ds480);
        int dimensionPixelSize3 = this.eDb.getResources().getDimensionPixelSize(d.e.ds360);
        int dimensionPixelSize4 = this.eDb.getResources().getDimensionPixelSize(d.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.eDb.getPageContext().getPageActivity(), this.dfN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.k.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.eDb.getResources().getDimensionPixelSize(d.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        F(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.eDi = new b.InterfaceC0104b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.eDc.asyncDeleteItem(imMessageCenterShowItemData, e.this.ejz);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.eDb.getPageContext().getPageActivity().getString(d.k.delete_user_chat);
        this.eDh = new com.baidu.tbadk.core.dialog.b(this.eDb.getPageContext().getPageActivity());
        this.eDh.cg(d.k.operation);
        this.eDh.a(new String[]{string}, this.eDi);
        this.eDh.d(this.eDb.getPageContext());
    }

    protected boolean eI(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.eDe.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void ic(boolean z) {
        if (z) {
            if (aNR() && this.eDg.getVisibility() != 0) {
                this.eDg.setVisibility(0);
            }
        } else if (this.eDg.getVisibility() != 8) {
            this.eDg.setVisibility(8);
        }
    }

    public void F(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eDe.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.dfN.removeView(this.mNoDataView);
        }
        ib(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.eDe.setVisibility(8);
    }

    public boolean aNR() {
        return this.eDk;
    }

    public void id(boolean z) {
        this.eDk = z;
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
                if (this.eDc != null) {
                    this.eDc.insertOrUpdate(data, this.ejy);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eDc != null) {
                this.eDc.remove(data, this.ejy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.eDc != null) {
                this.eDc.setData(data, this.ejy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.eDo = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.eDo != -1) {
                hZ(true);
                onPrimary();
            }
        }
    }

    public void hY(boolean z) {
        if (z && this.eDe != null && this.eDe.getWrappedAdapter() != null && this.eDe.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
                @Override // java.lang.Runnable
                public void run() {
                    e.this.eDe.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aU(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                aNS();
            }
        }
    }

    private void aNS() {
        if (this.eDf != null) {
            this.eDf.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arD() {
        Zr();
        if (this.ejv == null) {
            this.ejv = com.baidu.tieba.im.db.e.aIA().bJ(getPageContext().getPageActivity());
        }
        this.ejv.show();
        this.ejv.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zr() {
        if (this.ejv != null && this.ejv.isShowing()) {
            this.ejv.dismiss();
            this.ejv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGS() {
        if (this.eDe != null && this.eDc != null) {
            this.eDe.completePullRefreshPostDelayed(2000L);
            if (this.eDc.getData() != null) {
                this.eDf.setData(this.eDc.getData());
            } else {
                F(isLogin(), true);
            }
        }
    }
}
