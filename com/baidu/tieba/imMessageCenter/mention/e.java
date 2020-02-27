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
    private View aDw;
    private boolean dBG;
    private int dfF;
    private final CustomMessageListener doq;
    private ShutDownValidateTipView hOA;
    com.baidu.tbadk.core.dialog.i hOB;
    private k.c hOC;
    private boolean hOD;
    private boolean hOE;
    private int hOF;
    private final AdapterView.OnItemLongClickListener hOG;
    private final ChatAggregationFragment hOu;
    private ImMessageCenterModel hOv;
    private ImMessageCenterShowItemData hOw;
    private BdListView hOx;
    private NavigationBarShadowView hOy;
    private MessageAggregationListAdapter hOz;
    private com.baidu.tbadk.core.dialog.d huT;
    private final CustomMessageListener huU;
    private com.baidu.tieba.im.chat.a.a huW;
    private final com.baidu.tieba.im.chat.a.b huX;
    private boolean isNeedRefresh;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ab(chatAggregationFragment.getPageContext().getPageActivity()));
        this.hOv = null;
        this.hOw = null;
        this.hOx = null;
        this.hOz = null;
        this.hOB = null;
        this.hOD = true;
        this.dBG = false;
        this.isNeedRefresh = false;
        this.hOE = true;
        this.hOF = 16;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.hOy.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.hOy.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.hOy.hide();
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData wc = e.this.hOz.getItem(i);
                    TiebaStatic.eventStat(e.this.hOu.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = wc.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(wc);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hOu.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.hOu.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.hOu.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(wc.getFriendId(), 0L), wc.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (wc.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hOu.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(wc);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aKC().aKY() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aKC().aKY().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.hOu.getPageContext().getPageActivity())));
                        }
                    } else if (wc.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hOu.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(wc);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aKC().aKY() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aKC().aKY().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.hOu.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hOu.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.hOu.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hOu.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.hOu.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(wc.getFriendId(), 0L), wc.getFriendName(), wc.getFriendPortrait(), 0, wc.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new an("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.hOu.getPageContext().getPageActivity())));
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
                                com.baidu.tieba.im.db.d.bUk().CP("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.bUk().CP("group_intro_change");
                                com.baidu.tieba.im.db.d.bUk().CP("group_name_change");
                                com.baidu.tieba.im.db.d.bUk().CP("group_notice_change");
                                com.baidu.tieba.im.db.d.bUk().CP("group_level_up");
                                com.baidu.tieba.im.db.d.bUk().CP("dismiss_group");
                                com.baidu.tieba.im.db.d.bUk().CP("kick_out");
                                com.baidu.tieba.im.db.d.bUk().CP("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKC().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.aKC().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.hOu.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.hOG = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.hOw = e.this.hOz.getItem(i);
                e.this.c(e.this.hOw);
                if (e.this.hOB != null) {
                    TiebaStatic.log("c12932");
                    e.this.hOB.showDialog();
                    if (e.this.hOu != null && e.this.hOu.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.hOu.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.huU = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
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
                        e.this.hOv.setData(null, e.this.huW);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.hOz != null) {
                            e.this.hOz.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.hOz != null) {
                        e.this.hOz.notifyDataSetChanged();
                    }
                }
            }
        };
        this.huW = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.bSE();
            }
        };
        this.doq = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.huX = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.showProgressDialog();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.huT != null) {
                    e.this.huT.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.sN();
                e.this.hOu.showToast(R.string.delete_success, false);
                e.this.bSE();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.sN();
            }
        };
        this.hOu = chatAggregationFragment;
    }

    public void aj(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.hOF = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.hOF = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.hOF);
        }
    }

    public void bKo() {
        if (this.hOz != null) {
            this.hOz.notifyDataSetChanged();
        }
    }

    public void aiG() {
        MessageManager.getInstance().unRegisterListener(this.huU);
        MessageManager.getInstance().unRegisterListener(this.doq);
    }

    public View beQ() {
        this.dfF = 3;
        this.rootView = LayoutInflater.from(this.hOu.getPageContext().getPageActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bJ(this.rootView);
        TiebaStatic.eventStat(this.hOu.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        bvP();
        return this.rootView;
    }

    protected void bvP() {
        this.hOx.startPullRefresh();
        this.dBG = isLogin();
        if (!this.dBG) {
            W(this.dBG, true);
        }
    }

    private void registerListener() {
        this.hOu.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.huU);
        this.hOu.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.huU);
        this.hOu.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.huU);
        this.hOu.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.huU);
        this.hOu.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.huU);
        this.hOu.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.huU);
        this.hOu.registerListener(this.doq);
    }

    public void od(boolean z) {
        this.isNeedRefresh = z;
    }

    public void oe(boolean z) {
        this.hOE = z;
    }

    public void onPrimary() {
        if (this.hOz != null && this.hOz.getCount() == 0) {
            od(true);
        }
        if (this.hOE || this.isNeedRefresh) {
            this.hOE = false;
            this.isNeedRefresh = false;
            ku(false);
        }
        boolean isLogin = isLogin();
        if (this.dBG != isLogin) {
            this.dBG = isLogin;
            onUserChanged(this.dBG);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.hOu.getPageContext());
        }
    }

    private void initData() {
        this.hOv = new ImMessageCenterModel();
        oh(com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void bJ(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.hOA = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.hOA.setVisibility(8);
        this.hOA.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.oh(false);
                e.this.og(false);
            }
        });
        this.hOy = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.hOx = (BdListView) view.findViewById(R.id.chat_list_content);
        this.hOx.setDividerHeight(0);
        this.hOz = new MessageAggregationListAdapter(this.hOu.getPageContext().getPageActivity());
        this.hOz.a(this);
        this.hOx.setAdapter((ListAdapter) this.hOz);
        this.hOx.setOnItemClickListener(this.mItemClickListener);
        this.hOx.setOnItemLongClickListener(this.hOG);
        this.hOx.setOnScrollListener(this.mOnScrollListener);
        this.aDw = new View(this.hOu.getFragmentActivity());
        this.aDw.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.hOu.getFragmentActivity(), R.dimen.ds150)));
        this.hOx.addFooterView(this.aDw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.hOu.getPageContext(), i);
        }
        if (this.hOA != null) {
            this.hOA.onChangeSkinType(i);
        }
        if (this.hOz != null) {
            this.hOz.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
            return true;
        }
        return true;
    }

    private void of(boolean z) {
        if (z) {
            bZr();
        } else {
            bZs();
        }
    }

    private void bZr() {
        this.mNoDataView = NoDataViewFactory.a(this.hOu.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.cA(null, this.hOu.getResources().getString(R.string.no_recent_chat)), SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1 ? NoDataViewFactory.b.a(new NoDataViewFactory.a(this.hOu.getResources().getString(R.string.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
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

    private void bZs() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.hOu.getResources().getString(R.string.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.hOu.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bc.skipToLoginActivity(e.this.hOu.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.hOu.getResources().getDimensionPixelSize(R.dimen.ds320);
        int dimensionPixelSize2 = this.hOu.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.hOu.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.hOu.getResources().getDimensionPixelSize(R.dimen.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.hOu.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aE(R.string.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.hOu.getResources().getDimensionPixelSize(R.dimen.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        W(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.hOC = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.hOB != null && e.this.hOB.isShowing() && e.this.hOu != null) {
                    e.this.hOB.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.hOv.asyncDeleteItem(imMessageCenterShowItemData, e.this.huX);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.hOu.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.hOB = new com.baidu.tbadk.core.dialog.i(this.hOu.getPageContext());
        this.hOB.a(null, new String[]{string}, this.hOC);
    }

    protected boolean ku(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.hOx.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void og(boolean z) {
        if (z) {
            if (bZt() && this.hOA.getVisibility() != 0) {
                this.hOA.setVisibility(0);
            }
        } else if (this.hOA.getVisibility() != 8) {
            this.hOA.setVisibility(8);
        }
    }

    public void W(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.hOx.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.mRoot.removeView(this.mNoDataView);
        }
        of(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.hOx.setVisibility(8);
    }

    public boolean bZt() {
        return this.hOD;
    }

    public void oh(boolean z) {
        this.hOD = z;
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
                if (this.hOv != null) {
                    this.hOv.insertOrUpdate(data, this.huW);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.hOv != null) {
                this.hOv.remove(data, this.huW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.hOv != null) {
                this.hOv.setData(data, this.huW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.hOF = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.hOF != -1) {
                od(true);
                onPrimary();
            }
        }
    }

    public void oc(boolean z) {
        if (z && this.hOx != null && this.hOx.getWrappedAdapter() != null && this.hOx.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.hOx.startPullRefresh();
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
                bZu();
            }
        }
    }

    private void bZu() {
        if (this.hOz != null) {
            this.hOz.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        sN();
        if (this.huT == null) {
            this.huT = com.baidu.tieba.im.db.e.bUl().fa(getPageContext().getPageActivity());
        }
        this.huT.show();
        this.huT.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sN() {
        if (this.huT != null && this.huT.isShowing()) {
            this.huT.dismiss();
            this.huT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSE() {
        if (this.hOx != null && this.hOv != null) {
            this.hOx.completePullRefreshPostDelayed(0L);
            if (this.hOv.getData() != null) {
                this.hOz.setData(this.hOv.getData());
            } else {
                W(isLogin(), true);
            }
        }
    }
}
