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
import com.baidu.tbadk.TbadkApplication;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
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
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements f.c {
    private View bkf;
    private int ebb;
    private final CustomMessageListener elO;
    private boolean ezb;
    private com.baidu.tbadk.core.dialog.d iNb;
    private final CustomMessageListener iNc;
    private com.baidu.tieba.im.chat.a.a iNe;
    private final com.baidu.tieba.im.chat.a.b iNf;
    private boolean isNeedRefresh;
    private final ChatAggregationFragment jgC;
    private ImMessageCenterModel jgD;
    private ImMessageCenterShowItemData jgE;
    private BdListView jgF;
    private NavigationBarShadowView jgG;
    private MessageAggregationListAdapter jgH;
    private ShutDownValidateTipView jgI;
    com.baidu.tbadk.core.dialog.i jgJ;
    private k.c jgK;
    private boolean jgL;
    private boolean jgM;
    private int jgN;
    private final AdapterView.OnItemLongClickListener jgO;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.G(chatAggregationFragment.getPageContext().getPageActivity()));
        this.jgD = null;
        this.jgE = null;
        this.jgF = null;
        this.jgH = null;
        this.jgJ = null;
        this.jgL = true;
        this.ezb = false;
        this.isNeedRefresh = false;
        this.jgM = true;
        this.jgN = 16;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.jgG.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.jgG.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.jgG.hide();
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData ya = e.this.jgH.getItem(i);
                    TiebaStatic.eventStat(e.this.jgC.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    ao aoVar = new ao("c13720");
                    aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                    String ownerName = ya.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(ya);
                        aoVar.ag("obj_type", 6);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jgC.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.jgC.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.jgC.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(ya.getFriendId(), 0L), ya.getFriendName(), 0L, "msg_lstb")));
                        } else {
                            return;
                        }
                    } else if (ya.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jgC.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(ya);
                            aoVar.ag("obj_type", 7);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bbo().bbK() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bbo().bbK().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.jgC.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ya.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jgC.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(ya);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.bbo().bbK() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.bbo().bbK().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.jgC.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jgC.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.jgC.getPageContext().getPageActivity())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.jgC.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.jgC.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(ya.getFriendId(), 0L), ya.getFriendNameShow(), ya.getFriendPortrait(), 0, ya.getUserType())));
                        } else {
                            return;
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new ao("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.jgC.getPageContext().getPageActivity())));
                        aoVar.ag("obj_type", 6);
                        return;
                    } else {
                        e(ya);
                        aoVar.ag("obj_type", 6);
                    }
                    if (!TextUtils.isEmpty(ya.getFriendName())) {
                        if ("贴吧热榜".equals(ya.getFriendName())) {
                            aoVar.ag("obj_type", 8);
                        } else if ("贴吧荣誉墙".equals(ya.getFriendName())) {
                            aoVar.ag("obj_type", 9);
                        } else if ("贴吧精选".equals(ya.getFriendName())) {
                            aoVar.ag("obj_type", 10);
                        } else if ("贴吧活动".equals(ya.getFriendName())) {
                            aoVar.ag("obj_type", 4);
                        } else if ("吧广播".equals(ya.getFriendName())) {
                            aoVar.ag("obj_type", 5);
                        }
                    }
                    TiebaStatic.log(aoVar);
                }
            }

            private void d(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
                CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && imMessageCenterShowItemData != null) {
                            imMessageCenterShowItemData.setUnReadCount(0);
                            if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                                com.baidu.tieba.im.db.d.cpA().GM("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.cpA().GM("group_intro_change");
                                com.baidu.tieba.im.db.d.cpA().GM("group_name_change");
                                com.baidu.tieba.im.db.d.cpA().GM("group_notice_change");
                                com.baidu.tieba.im.db.d.cpA().GM("group_level_up");
                                com.baidu.tieba.im.db.d.cpA().GM("dismiss_group");
                                com.baidu.tieba.im.db.d.cpA().GM("kick_out");
                                com.baidu.tieba.im.db.d.cpA().GM("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.bbo().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.bbo().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.jgC.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.jgO = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.jgE = e.this.jgH.getItem(i);
                e.this.c(e.this.jgE);
                if (e.this.jgJ != null) {
                    TiebaStatic.log("c12932");
                    e.this.jgJ.showDialog();
                    if (e.this.jgC != null && e.this.jgC.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.jgC.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.iNc = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
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
                        e.this.jgD.setData(null, e.this.iNe);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.jgH != null) {
                            e.this.jgH.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.jgH != null) {
                        e.this.jgH.notifyDataSetChanged();
                    }
                }
            }
        };
        this.iNe = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cnU();
            }
        };
        this.elO = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.iNf = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cnT();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.iNb != null) {
                    e.this.iNb.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.yY();
                e.this.jgC.showToast(R.string.delete_success, false);
                e.this.cnU();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.yY();
            }
        };
        this.jgC = chatAggregationFragment;
    }

    public void aq(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.jgN = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.jgN = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.jgN);
        }
    }

    public void cfa() {
        if (this.jgH != null) {
            this.jgH.notifyDataSetChanged();
        }
    }

    public void cdl() {
        MessageManager.getInstance().unRegisterListener(this.iNc);
        MessageManager.getInstance().unRegisterListener(this.elO);
    }

    public View bwR() {
        this.ebb = 3;
        this.rootView = LayoutInflater.from(this.jgC.getPageContext().getPageActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bS(this.rootView);
        TiebaStatic.eventStat(this.jgC.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        bPm();
        return this.rootView;
    }

    protected void bPm() {
        this.jgF.startPullRefresh();
        this.ezb = isLogin();
        if (!this.ezb) {
            aa(this.ezb, true);
        }
    }

    private void registerListener() {
        this.jgC.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.iNc);
        this.jgC.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.iNc);
        this.jgC.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.iNc);
        this.jgC.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.iNc);
        this.jgC.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.iNc);
        this.jgC.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.iNc);
        this.jgC.registerListener(this.elO);
    }

    public void pT(boolean z) {
        this.isNeedRefresh = z;
    }

    public void pU(boolean z) {
        this.jgM = z;
    }

    public void onPrimary() {
        if (this.jgH != null && this.jgH.getCount() == 0) {
            pT(true);
        }
        if (this.jgM || this.isNeedRefresh) {
            this.jgM = false;
            this.isNeedRefresh = false;
            mh(false);
        }
        boolean isLogin = isLogin();
        if (this.ezb != isLogin) {
            this.ezb = isLogin;
            onUserChanged(this.ezb);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.jgC.getPageContext());
        }
    }

    private void initData() {
        this.jgD = new ImMessageCenterModel();
        pX(com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void bS(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.jgI = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.jgI.setVisibility(8);
        this.jgI.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.pX(false);
                e.this.pW(false);
            }
        });
        this.jgG = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.jgF = (BdListView) view.findViewById(R.id.chat_list_content);
        this.jgF.setDividerHeight(0);
        this.jgH = new MessageAggregationListAdapter(this.jgC.getPageContext().getPageActivity());
        this.jgH.a(this);
        this.jgF.setAdapter((ListAdapter) this.jgH);
        this.jgF.setOnItemClickListener(this.mItemClickListener);
        this.jgF.setOnItemLongClickListener(this.jgO);
        this.jgF.setOnScrollListener(this.mOnScrollListener);
        this.bkf = new View(this.jgC.getFragmentActivity());
        this.bkf.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.jgC.getFragmentActivity(), R.dimen.ds150)));
        this.jgF.addFooterView(this.bkf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jgC.getPageContext(), i);
        }
        if (this.jgI != null) {
            this.jgI.onChangeSkinType(i);
        }
        if (this.jgH != null) {
            this.jgH.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
            return true;
        }
        return true;
    }

    private void pV(boolean z) {
        if (z) {
            cuJ();
        } else {
            cuK();
        }
    }

    private void cuJ() {
        this.mNoDataView = NoDataViewFactory.a(this.jgC.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dm(null, this.jgC.getResources().getString(R.string.no_recent_chat)), SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1 ? NoDataViewFactory.b.a(new NoDataViewFactory.a(this.jgC.getResources().getString(R.string.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
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

    private void cuK() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.jgC.getResources().getString(R.string.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.jgC.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                be.skipToLoginActivity(e.this.jgC.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.jgC.getResources().getDimensionPixelSize(R.dimen.ds320);
        int dimensionPixelSize2 = this.jgC.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.jgC.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.jgC.getResources().getDimensionPixelSize(R.dimen.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.jgC.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aO(R.string.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.jgC.getResources().getDimensionPixelSize(R.dimen.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        aa(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.jgK = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.jgJ != null && e.this.jgJ.isShowing() && e.this.jgC != null) {
                    e.this.jgJ.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.jgD.asyncDeleteItem(imMessageCenterShowItemData, e.this.iNf);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.jgC.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.jgJ = new com.baidu.tbadk.core.dialog.i(this.jgC.getPageContext());
        this.jgJ.a(null, new String[]{string}, this.jgK);
    }

    protected boolean mh(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.jgF.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void pW(boolean z) {
        if (z) {
            if (cuL() && this.jgI.getVisibility() != 0) {
                this.jgI.setVisibility(0);
            }
        } else if (this.jgI.getVisibility() != 8) {
            this.jgI.setVisibility(8);
        }
    }

    public void aa(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.jgF.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.mRoot.removeView(this.mNoDataView);
        }
        pV(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.jgF.setVisibility(8);
    }

    public boolean cuL() {
        return this.jgL;
    }

    public void pX(boolean z) {
        this.jgL = z;
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
                if (this.jgD != null) {
                    this.jgD.insertOrUpdate(data, this.iNe);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.jgD != null) {
                this.jgD.remove(data, this.iNe);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.jgD != null) {
                this.jgD.setData(data, this.iNe);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.jgN = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.jgN != -1) {
                pT(true);
                onPrimary();
            }
        }
    }

    public void pS(boolean z) {
        if (z && this.jgF != null && this.jgF.getWrappedAdapter() != null && this.jgF.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.jgF.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else {
                cuM();
            }
        }
    }

    private void cuM() {
        if (this.jgH != null) {
            this.jgH.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnT() {
        yY();
        if (this.iNb == null) {
            this.iNb = com.baidu.tieba.im.db.e.cpB().eV(getPageContext().getPageActivity());
        }
        this.iNb.show();
        this.iNb.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yY() {
        if (this.iNb != null && this.iNb.isShowing()) {
            this.iNb.dismiss();
            this.iNb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnU() {
        if (this.jgF != null && this.jgD != null) {
            this.jgF.completePullRefreshPostDelayed(0L);
            if (this.jgD.getData() != null) {
                this.jgH.setData(this.jgD.getData());
            } else {
                aa(isLogin(), true);
            }
        }
    }
}
