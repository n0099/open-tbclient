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
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
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
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.switchs.MessageChooseFriendSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements g.c {
    private View aXA;
    private int dFH;
    private final CustomMessageListener dOP;
    private boolean ebX;
    private final ChatAggregationFragment iAf;
    private ImMessageCenterModel iAg;
    private ImMessageCenterShowItemData iAh;
    private BdListView iAi;
    private NavigationBarShadowView iAj;
    private MessageAggregationListAdapter iAk;
    private ShutDownValidateTipView iAl;
    com.baidu.tbadk.core.dialog.i iAm;
    private k.c iAn;
    private boolean iAo;
    private boolean iAp;
    private int iAq;
    private final AdapterView.OnItemLongClickListener iAr;
    private com.baidu.tbadk.core.dialog.d igA;
    private final CustomMessageListener igB;
    private com.baidu.tieba.im.chat.a.a igD;
    private final com.baidu.tieba.im.chat.a.b igE;
    private boolean isNeedRefresh;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.G(chatAggregationFragment.getPageContext().getPageActivity()));
        this.iAg = null;
        this.iAh = null;
        this.iAi = null;
        this.iAk = null;
        this.iAm = null;
        this.iAo = true;
        this.ebX = false;
        this.isNeedRefresh = false;
        this.iAp = true;
        this.iAq = 16;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.iAj.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.iAj.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.iAj.hide();
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData wI = e.this.iAk.getItem(i);
                    TiebaStatic.eventStat(e.this.iAf.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = wI.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(wI);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.iAf.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.iAf.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.iAf.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(wI.getFriendId(), 0L), wI.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (wI.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.iAf.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(wI);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aTe().aTA() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aTe().aTA().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.iAf.getPageContext().getPageActivity())));
                        }
                    } else if (wI.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.iAf.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(wI);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aTe().aTA() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aTe().aTA().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.iAf.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.iAf.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.iAf.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.iAf.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.iAf.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(wI.getFriendId(), 0L), wI.getFriendName(), wI.getFriendPortrait(), 0, wI.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new an("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.iAf.getPageContext().getPageActivity())));
                    } else {
                        e(wI);
                    }
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.cff().EB("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.cff().EB("group_intro_change");
                                com.baidu.tieba.im.db.d.cff().EB("group_name_change");
                                com.baidu.tieba.im.db.d.cff().EB("group_notice_change");
                                com.baidu.tieba.im.db.d.cff().EB("group_level_up");
                                com.baidu.tieba.im.db.d.cff().EB("dismiss_group");
                                com.baidu.tieba.im.db.d.cff().EB("kick_out");
                                com.baidu.tieba.im.db.d.cff().EB("group_activitys_change");
                            }
                        }
                        return null;
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
            }

            private void e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
                if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.b.aTe().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.aTe().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.iAf.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.iAr = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.iAh = e.this.iAk.getItem(i);
                e.this.c(e.this.iAh);
                if (e.this.iAm != null) {
                    TiebaStatic.log("c12932");
                    e.this.iAm.showDialog();
                    if (e.this.iAf != null && e.this.iAf.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.iAf.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.igB = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
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
                        e.this.iAg.setData(null, e.this.igD);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.iAk != null) {
                            e.this.iAk.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.iAk != null) {
                        e.this.iAk.notifyDataSetChanged();
                    }
                }
            }
        };
        this.igD = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cdy();
            }
        };
        this.dOP = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.igE = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cdx();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.igA != null) {
                    e.this.igA.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.xk();
                e.this.iAf.showToast(R.string.delete_success, false);
                e.this.cdy();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.xk();
            }
        };
        this.iAf = chatAggregationFragment;
    }

    public void aj(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.iAq = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.iAq = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.iAq);
        }
    }

    public void bVd() {
        if (this.iAk != null) {
            this.iAk.notifyDataSetChanged();
        }
    }

    public void aqS() {
        MessageManager.getInstance().unRegisterListener(this.igB);
        MessageManager.getInstance().unRegisterListener(this.dOP);
    }

    public View bom() {
        this.dFH = 3;
        this.rootView = LayoutInflater.from(this.iAf.getPageContext().getPageActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bP(this.rootView);
        TiebaStatic.eventStat(this.iAf.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        bFH();
        return this.rootView;
    }

    protected void bFH() {
        this.iAi.startPullRefresh();
        this.ebX = isLogin();
        if (!this.ebX) {
            W(this.ebX, true);
        }
    }

    private void registerListener() {
        this.iAf.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.igB);
        this.iAf.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.igB);
        this.iAf.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.igB);
        this.iAf.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.igB);
        this.iAf.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.igB);
        this.iAf.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.igB);
        this.iAf.registerListener(this.dOP);
    }

    public void pn(boolean z) {
        this.isNeedRefresh = z;
    }

    public void po(boolean z) {
        this.iAp = z;
    }

    public void onPrimary() {
        if (this.iAk != null && this.iAk.getCount() == 0) {
            pn(true);
        }
        if (this.iAp || this.isNeedRefresh) {
            this.iAp = false;
            this.isNeedRefresh = false;
            lC(false);
        }
        boolean isLogin = isLogin();
        if (this.ebX != isLogin) {
            this.ebX = isLogin;
            onUserChanged(this.ebX);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.iAf.getPageContext());
        }
    }

    private void initData() {
        this.iAg = new ImMessageCenterModel();
        pr(com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void bP(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.iAl = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.iAl.setVisibility(8);
        this.iAl.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.pr(false);
                e.this.pq(false);
            }
        });
        this.iAj = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.iAi = (BdListView) view.findViewById(R.id.chat_list_content);
        this.iAi.setDividerHeight(0);
        this.iAk = new MessageAggregationListAdapter(this.iAf.getPageContext().getPageActivity());
        this.iAk.a(this);
        this.iAi.setAdapter((ListAdapter) this.iAk);
        this.iAi.setOnItemClickListener(this.mItemClickListener);
        this.iAi.setOnItemLongClickListener(this.iAr);
        this.iAi.setOnScrollListener(this.mOnScrollListener);
        this.aXA = new View(this.iAf.getFragmentActivity());
        this.aXA.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.iAf.getFragmentActivity(), R.dimen.ds150)));
        this.iAi.addFooterView(this.aXA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.iAf.getPageContext(), i);
        }
        if (this.iAl != null) {
            this.iAl.onChangeSkinType(i);
        }
        if (this.iAk != null) {
            this.iAk.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
            return true;
        }
        return true;
    }

    private void pp(boolean z) {
        if (z) {
            ckm();
        } else {
            ckn();
        }
    }

    private void ckm() {
        this.mNoDataView = NoDataViewFactory.a(this.iAf.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.cK(null, this.iAf.getResources().getString(R.string.no_recent_chat)), SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1 ? NoDataViewFactory.b.a(new NoDataViewFactory.a(this.iAf.getResources().getString(R.string.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.isLogin() && e.this.mContext != null) {
                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(e.this.mContext.getPageActivity(), 0, false);
                    atListActivityConfig.setIsForChat(true);
                    e.this.mContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, atListActivityConfig));
                    TiebaStatic.log("c12929");
                }
            }
        })) : null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void ckn() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.iAf.getResources().getString(R.string.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.iAf.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bc.skipToLoginActivity(e.this.iAf.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.iAf.getResources().getDimensionPixelSize(R.dimen.ds320);
        int dimensionPixelSize2 = this.iAf.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.iAf.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.iAf.getResources().getDimensionPixelSize(R.dimen.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.iAf.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aI(R.string.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.iAf.getResources().getDimensionPixelSize(R.dimen.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        W(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.iAn = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.iAm != null && e.this.iAm.isShowing() && e.this.iAf != null) {
                    e.this.iAm.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.iAg.asyncDeleteItem(imMessageCenterShowItemData, e.this.igE);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.iAf.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.iAm = new com.baidu.tbadk.core.dialog.i(this.iAf.getPageContext());
        this.iAm.a(null, new String[]{string}, this.iAn);
    }

    protected boolean lC(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.iAi.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void pq(boolean z) {
        if (z) {
            if (cko() && this.iAl.getVisibility() != 0) {
                this.iAl.setVisibility(0);
            }
        } else if (this.iAl.getVisibility() != 8) {
            this.iAl.setVisibility(8);
        }
    }

    public void W(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.iAi.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.mRoot.removeView(this.mNoDataView);
        }
        pp(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.iAi.setVisibility(8);
    }

    public boolean cko() {
        return this.iAo;
    }

    public void pr(boolean z) {
        this.iAo = z;
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
                if (this.iAg != null) {
                    this.iAg.insertOrUpdate(data, this.igD);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.iAg != null) {
                this.iAg.remove(data, this.igD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.iAg != null) {
                this.iAg.setData(data, this.igD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.iAq = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.iAq != -1) {
                pn(true);
                onPrimary();
            }
        }
    }

    public void pm(boolean z) {
        if (z && this.iAi != null && this.iAi.getWrappedAdapter() != null && this.iAi.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.iAi.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                ckp();
            }
        }
    }

    private void ckp() {
        if (this.iAk != null) {
            this.iAk.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdx() {
        xk();
        if (this.igA == null) {
            this.igA = com.baidu.tieba.im.db.e.cfg().eG(getPageContext().getPageActivity());
        }
        this.igA.show();
        this.igA.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xk() {
        if (this.igA != null && this.igA.isShowing()) {
            this.igA.dismiss();
            this.igA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdy() {
        if (this.iAi != null && this.iAg != null) {
            this.iAi.completePullRefreshPostDelayed(0L);
            if (this.iAg.getData() != null) {
                this.iAk.setData(this.iAg.getData());
            } else {
                W(isLogin(), true);
            }
        }
    }
}
