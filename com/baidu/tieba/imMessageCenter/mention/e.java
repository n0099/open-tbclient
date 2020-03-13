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
    private View aDy;
    private boolean dBU;
    private int dfT;
    private final CustomMessageListener doF;
    private final ChatAggregationFragment hOI;
    private ImMessageCenterModel hOJ;
    private ImMessageCenterShowItemData hOK;
    private BdListView hOL;
    private NavigationBarShadowView hOM;
    private MessageAggregationListAdapter hON;
    private ShutDownValidateTipView hOO;
    com.baidu.tbadk.core.dialog.i hOP;
    private k.c hOQ;
    private boolean hOR;
    private boolean hOS;
    private int hOT;
    private final AdapterView.OnItemLongClickListener hOU;
    private com.baidu.tbadk.core.dialog.d hvh;
    private final CustomMessageListener hvi;
    private com.baidu.tieba.im.chat.a.a hvk;
    private final com.baidu.tieba.im.chat.a.b hvl;
    private boolean isNeedRefresh;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ab(chatAggregationFragment.getPageContext().getPageActivity()));
        this.hOJ = null;
        this.hOK = null;
        this.hOL = null;
        this.hON = null;
        this.hOP = null;
        this.hOR = true;
        this.dBU = false;
        this.isNeedRefresh = false;
        this.hOS = true;
        this.hOT = 16;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.hOM.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.hOM.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.hOM.hide();
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData wc = e.this.hON.getItem(i);
                    TiebaStatic.eventStat(e.this.hOI.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = wc.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(wc);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hOI.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.hOI.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.hOI.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(wc.getFriendId(), 0L), wc.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (wc.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hOI.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(wc);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aKF().aLb() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aKF().aLb().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.hOI.getPageContext().getPageActivity())));
                        }
                    } else if (wc.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hOI.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(wc);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aKF().aLb() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aKF().aLb().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.hOI.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hOI.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.hOI.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hOI.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.hOI.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(wc.getFriendId(), 0L), wc.getFriendName(), wc.getFriendPortrait(), 0, wc.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new an("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.hOI.getPageContext().getPageActivity())));
                    } else {
                        e(wc);
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
                                com.baidu.tieba.im.db.d.bUn().CQ("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.bUn().CQ("group_intro_change");
                                com.baidu.tieba.im.db.d.bUn().CQ("group_name_change");
                                com.baidu.tieba.im.db.d.bUn().CQ("group_notice_change");
                                com.baidu.tieba.im.db.d.bUn().CQ("group_level_up");
                                com.baidu.tieba.im.db.d.bUn().CQ("dismiss_group");
                                com.baidu.tieba.im.db.d.bUn().CQ("kick_out");
                                com.baidu.tieba.im.db.d.bUn().CQ("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKF().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.aKF().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.hOI.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.hOU = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.hOK = e.this.hON.getItem(i);
                e.this.c(e.this.hOK);
                if (e.this.hOP != null) {
                    TiebaStatic.log("c12932");
                    e.this.hOP.showDialog();
                    if (e.this.hOI != null && e.this.hOI.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.hOI.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.hvi = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
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
                        e.this.hOJ.setData(null, e.this.hvk);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.hON != null) {
                            e.this.hON.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.hON != null) {
                        e.this.hON.notifyDataSetChanged();
                    }
                }
            }
        };
        this.hvk = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.bSH();
            }
        };
        this.doF = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.hvl = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.showProgressDialog();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.hvh != null) {
                    e.this.hvh.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.sN();
                e.this.hOI.showToast(R.string.delete_success, false);
                e.this.bSH();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.sN();
            }
        };
        this.hOI = chatAggregationFragment;
    }

    public void aj(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.hOT = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.hOT = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.hOT);
        }
    }

    public void bKr() {
        if (this.hON != null) {
            this.hON.notifyDataSetChanged();
        }
    }

    public void aiI() {
        MessageManager.getInstance().unRegisterListener(this.hvi);
        MessageManager.getInstance().unRegisterListener(this.doF);
    }

    public View beT() {
        this.dfT = 3;
        this.rootView = LayoutInflater.from(this.hOI.getPageContext().getPageActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bJ(this.rootView);
        TiebaStatic.eventStat(this.hOI.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        bvS();
        return this.rootView;
    }

    protected void bvS() {
        this.hOL.startPullRefresh();
        this.dBU = isLogin();
        if (!this.dBU) {
            W(this.dBU, true);
        }
    }

    private void registerListener() {
        this.hOI.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.hvi);
        this.hOI.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.hvi);
        this.hOI.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.hvi);
        this.hOI.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.hvi);
        this.hOI.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.hvi);
        this.hOI.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.hvi);
        this.hOI.registerListener(this.doF);
    }

    public void od(boolean z) {
        this.isNeedRefresh = z;
    }

    public void oe(boolean z) {
        this.hOS = z;
    }

    public void onPrimary() {
        if (this.hON != null && this.hON.getCount() == 0) {
            od(true);
        }
        if (this.hOS || this.isNeedRefresh) {
            this.hOS = false;
            this.isNeedRefresh = false;
            ku(false);
        }
        boolean isLogin = isLogin();
        if (this.dBU != isLogin) {
            this.dBU = isLogin;
            onUserChanged(this.dBU);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.hOI.getPageContext());
        }
    }

    private void initData() {
        this.hOJ = new ImMessageCenterModel();
        oh(com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void bJ(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.hOO = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.hOO.setVisibility(8);
        this.hOO.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.oh(false);
                e.this.og(false);
            }
        });
        this.hOM = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.hOL = (BdListView) view.findViewById(R.id.chat_list_content);
        this.hOL.setDividerHeight(0);
        this.hON = new MessageAggregationListAdapter(this.hOI.getPageContext().getPageActivity());
        this.hON.a(this);
        this.hOL.setAdapter((ListAdapter) this.hON);
        this.hOL.setOnItemClickListener(this.mItemClickListener);
        this.hOL.setOnItemLongClickListener(this.hOU);
        this.hOL.setOnScrollListener(this.mOnScrollListener);
        this.aDy = new View(this.hOI.getFragmentActivity());
        this.aDy.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.hOI.getFragmentActivity(), R.dimen.ds150)));
        this.hOL.addFooterView(this.aDy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.hOI.getPageContext(), i);
        }
        if (this.hOO != null) {
            this.hOO.onChangeSkinType(i);
        }
        if (this.hON != null) {
            this.hON.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
            return true;
        }
        return true;
    }

    private void of(boolean z) {
        if (z) {
            bZu();
        } else {
            bZv();
        }
    }

    private void bZu() {
        this.mNoDataView = NoDataViewFactory.a(this.hOI.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.cA(null, this.hOI.getResources().getString(R.string.no_recent_chat)), SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1 ? NoDataViewFactory.b.a(new NoDataViewFactory.a(this.hOI.getResources().getString(R.string.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
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

    private void bZv() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.hOI.getResources().getString(R.string.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.hOI.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bc.skipToLoginActivity(e.this.hOI.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.hOI.getResources().getDimensionPixelSize(R.dimen.ds320);
        int dimensionPixelSize2 = this.hOI.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.hOI.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.hOI.getResources().getDimensionPixelSize(R.dimen.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.hOI.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aE(R.string.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.hOI.getResources().getDimensionPixelSize(R.dimen.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        W(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.hOQ = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.hOP != null && e.this.hOP.isShowing() && e.this.hOI != null) {
                    e.this.hOP.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.hOJ.asyncDeleteItem(imMessageCenterShowItemData, e.this.hvl);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.hOI.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.hOP = new com.baidu.tbadk.core.dialog.i(this.hOI.getPageContext());
        this.hOP.a(null, new String[]{string}, this.hOQ);
    }

    protected boolean ku(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.hOL.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void og(boolean z) {
        if (z) {
            if (bZw() && this.hOO.getVisibility() != 0) {
                this.hOO.setVisibility(0);
            }
        } else if (this.hOO.getVisibility() != 8) {
            this.hOO.setVisibility(8);
        }
    }

    public void W(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.hOL.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.mRoot.removeView(this.mNoDataView);
        }
        of(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.hOL.setVisibility(8);
    }

    public boolean bZw() {
        return this.hOR;
    }

    public void oh(boolean z) {
        this.hOR = z;
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
                if (this.hOJ != null) {
                    this.hOJ.insertOrUpdate(data, this.hvk);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.hOJ != null) {
                this.hOJ.remove(data, this.hvk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.hOJ != null) {
                this.hOJ.setData(data, this.hvk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.hOT = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.hOT != -1) {
                od(true);
                onPrimary();
            }
        }
    }

    public void oc(boolean z) {
        if (z && this.hOL != null && this.hOL.getWrappedAdapter() != null && this.hOL.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.hOL.startPullRefresh();
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
                bZx();
            }
        }
    }

    private void bZx() {
        if (this.hON != null) {
            this.hON.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        sN();
        if (this.hvh == null) {
            this.hvh = com.baidu.tieba.im.db.e.bUo().fa(getPageContext().getPageActivity());
        }
        this.hvh.show();
        this.hvh.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sN() {
        if (this.hvh != null && this.hvh.isShowing()) {
            this.hvh.dismiss();
            this.hvh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSH() {
        if (this.hOL != null && this.hOJ != null) {
            this.hOL.completePullRefreshPostDelayed(0L);
            if (this.hOJ.getData() != null) {
                this.hON.setData(this.hOJ.getData());
            } else {
                W(isLogin(), true);
            }
        }
    }
}
