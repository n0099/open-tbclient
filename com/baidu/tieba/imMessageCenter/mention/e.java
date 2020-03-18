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
    private View aDM;
    private boolean dCh;
    private int dgg;
    private final CustomMessageListener doS;
    private final ChatAggregationFragment hQi;
    private ImMessageCenterModel hQj;
    private ImMessageCenterShowItemData hQk;
    private BdListView hQl;
    private NavigationBarShadowView hQm;
    private MessageAggregationListAdapter hQn;
    private ShutDownValidateTipView hQo;
    com.baidu.tbadk.core.dialog.i hQp;
    private k.c hQq;
    private boolean hQr;
    private boolean hQs;
    private int hQt;
    private final AdapterView.OnItemLongClickListener hQu;
    private com.baidu.tbadk.core.dialog.d hwH;
    private final CustomMessageListener hwI;
    private com.baidu.tieba.im.chat.a.a hwK;
    private final com.baidu.tieba.im.chat.a.b hwL;
    private boolean isNeedRefresh;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ab(chatAggregationFragment.getPageContext().getPageActivity()));
        this.hQj = null;
        this.hQk = null;
        this.hQl = null;
        this.hQn = null;
        this.hQp = null;
        this.hQr = true;
        this.dCh = false;
        this.isNeedRefresh = false;
        this.hQs = true;
        this.hQt = 16;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.hQm.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.hQm.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.hQm.hide();
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData wk = e.this.hQn.getItem(i);
                    TiebaStatic.eventStat(e.this.hQi.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = wk.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(wk);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hQi.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.hQi.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.hQi.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(wk.getFriendId(), 0L), wk.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (wk.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hQi.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(wk);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().aLf() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().aLf().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.hQi.getPageContext().getPageActivity())));
                        }
                    } else if (wk.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hQi.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(wk);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().aLf() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().aLf().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.hQi.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hQi.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.hQi.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hQi.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.hQi.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(wk.getFriendId(), 0L), wk.getFriendName(), wk.getFriendPortrait(), 0, wk.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new an("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.hQi.getPageContext().getPageActivity())));
                    } else {
                        e(wk);
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
                                com.baidu.tieba.im.db.d.bUF().CP("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.bUF().CP("group_intro_change");
                                com.baidu.tieba.im.db.d.bUF().CP("group_name_change");
                                com.baidu.tieba.im.db.d.bUF().CP("group_notice_change");
                                com.baidu.tieba.im.db.d.bUF().CP("group_level_up");
                                com.baidu.tieba.im.db.d.bUF().CP("dismiss_group");
                                com.baidu.tieba.im.db.d.bUF().CP("kick_out");
                                com.baidu.tieba.im.db.d.bUF().CP("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.hQi.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.hQu = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.hQk = e.this.hQn.getItem(i);
                e.this.c(e.this.hQk);
                if (e.this.hQp != null) {
                    TiebaStatic.log("c12932");
                    e.this.hQp.showDialog();
                    if (e.this.hQi != null && e.this.hQi.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.hQi.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.hwI = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
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
                        e.this.hQj.setData(null, e.this.hwK);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.hQn != null) {
                            e.this.hQn.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.hQn != null) {
                        e.this.hQn.notifyDataSetChanged();
                    }
                }
            }
        };
        this.hwK = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.bSZ();
            }
        };
        this.doS = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.hwL = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.showProgressDialog();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.hwH != null) {
                    e.this.hwH.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.sS();
                e.this.hQi.showToast(R.string.delete_success, false);
                e.this.bSZ();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.sS();
            }
        };
        this.hQi = chatAggregationFragment;
    }

    public void aj(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.hQt = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.hQt = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.hQt);
        }
    }

    public void bKE() {
        if (this.hQn != null) {
            this.hQn.notifyDataSetChanged();
        }
    }

    public void aiL() {
        MessageManager.getInstance().unRegisterListener(this.hwI);
        MessageManager.getInstance().unRegisterListener(this.doS);
    }

    public View beY() {
        this.dgg = 3;
        this.rootView = LayoutInflater.from(this.hQi.getPageContext().getPageActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bJ(this.rootView);
        TiebaStatic.eventStat(this.hQi.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        bvX();
        return this.rootView;
    }

    protected void bvX() {
        this.hQl.startPullRefresh();
        this.dCh = isLogin();
        if (!this.dCh) {
            W(this.dCh, true);
        }
    }

    private void registerListener() {
        this.hQi.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.hwI);
        this.hQi.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.hwI);
        this.hQi.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.hwI);
        this.hQi.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.hwI);
        this.hQi.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.hwI);
        this.hQi.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.hwI);
        this.hQi.registerListener(this.doS);
    }

    public void oj(boolean z) {
        this.isNeedRefresh = z;
    }

    public void ok(boolean z) {
        this.hQs = z;
    }

    public void onPrimary() {
        if (this.hQn != null && this.hQn.getCount() == 0) {
            oj(true);
        }
        if (this.hQs || this.isNeedRefresh) {
            this.hQs = false;
            this.isNeedRefresh = false;
            kz(false);
        }
        boolean isLogin = isLogin();
        if (this.dCh != isLogin) {
            this.dCh = isLogin;
            onUserChanged(this.dCh);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.hQi.getPageContext());
        }
    }

    private void initData() {
        this.hQj = new ImMessageCenterModel();
        on(com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void bJ(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.hQo = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.hQo.setVisibility(8);
        this.hQo.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.on(false);
                e.this.om(false);
            }
        });
        this.hQm = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.hQl = (BdListView) view.findViewById(R.id.chat_list_content);
        this.hQl.setDividerHeight(0);
        this.hQn = new MessageAggregationListAdapter(this.hQi.getPageContext().getPageActivity());
        this.hQn.a(this);
        this.hQl.setAdapter((ListAdapter) this.hQn);
        this.hQl.setOnItemClickListener(this.mItemClickListener);
        this.hQl.setOnItemLongClickListener(this.hQu);
        this.hQl.setOnScrollListener(this.mOnScrollListener);
        this.aDM = new View(this.hQi.getFragmentActivity());
        this.aDM.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.hQi.getFragmentActivity(), R.dimen.ds150)));
        this.hQl.addFooterView(this.aDM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.hQi.getPageContext(), i);
        }
        if (this.hQo != null) {
            this.hQo.onChangeSkinType(i);
        }
        if (this.hQn != null) {
            this.hQn.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
            return true;
        }
        return true;
    }

    private void ol(boolean z) {
        if (z) {
            bZM();
        } else {
            bZN();
        }
    }

    private void bZM() {
        this.mNoDataView = NoDataViewFactory.a(this.hQi.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.cz(null, this.hQi.getResources().getString(R.string.no_recent_chat)), SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1 ? NoDataViewFactory.b.a(new NoDataViewFactory.a(this.hQi.getResources().getString(R.string.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
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

    private void bZN() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.hQi.getResources().getString(R.string.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.hQi.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bc.skipToLoginActivity(e.this.hQi.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.hQi.getResources().getDimensionPixelSize(R.dimen.ds320);
        int dimensionPixelSize2 = this.hQi.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.hQi.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.hQi.getResources().getDimensionPixelSize(R.dimen.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.hQi.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aE(R.string.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.hQi.getResources().getDimensionPixelSize(R.dimen.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        W(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.hQq = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.hQp != null && e.this.hQp.isShowing() && e.this.hQi != null) {
                    e.this.hQp.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.hQj.asyncDeleteItem(imMessageCenterShowItemData, e.this.hwL);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.hQi.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.hQp = new com.baidu.tbadk.core.dialog.i(this.hQi.getPageContext());
        this.hQp.a(null, new String[]{string}, this.hQq);
    }

    protected boolean kz(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.hQl.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void om(boolean z) {
        if (z) {
            if (bZO() && this.hQo.getVisibility() != 0) {
                this.hQo.setVisibility(0);
            }
        } else if (this.hQo.getVisibility() != 8) {
            this.hQo.setVisibility(8);
        }
    }

    public void W(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.hQl.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.mRoot.removeView(this.mNoDataView);
        }
        ol(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.hQl.setVisibility(8);
    }

    public boolean bZO() {
        return this.hQr;
    }

    public void on(boolean z) {
        this.hQr = z;
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
                if (this.hQj != null) {
                    this.hQj.insertOrUpdate(data, this.hwK);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.hQj != null) {
                this.hQj.remove(data, this.hwK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.hQj != null) {
                this.hQj.setData(data, this.hwK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.hQt = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.hQt != -1) {
                oj(true);
                onPrimary();
            }
        }
    }

    public void oi(boolean z) {
        if (z && this.hQl != null && this.hQl.getWrappedAdapter() != null && this.hQl.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.hQl.startPullRefresh();
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
                bZP();
            }
        }
    }

    private void bZP() {
        if (this.hQn != null) {
            this.hQn.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        sS();
        if (this.hwH == null) {
            this.hwH = com.baidu.tieba.im.db.e.bUG().eZ(getPageContext().getPageActivity());
        }
        this.hwH.show();
        this.hwH.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sS() {
        if (this.hwH != null && this.hwH.isShowing()) {
            this.hwH.dismiss();
            this.hwH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSZ() {
        if (this.hQl != null && this.hQj != null) {
            this.hQl.completePullRefreshPostDelayed(0L);
            if (this.hQj.getData() != null) {
                this.hQn.setData(this.hQj.getData());
            } else {
                W(isLogin(), true);
            }
        }
    }
}
