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
    private View aDx;
    private boolean dBH;
    private int dfG;
    private final CustomMessageListener dor;
    private NavigationBarShadowView hOA;
    private MessageAggregationListAdapter hOB;
    private ShutDownValidateTipView hOC;
    com.baidu.tbadk.core.dialog.i hOD;
    private k.c hOE;
    private boolean hOF;
    private boolean hOG;
    private int hOH;
    private final AdapterView.OnItemLongClickListener hOI;
    private final ChatAggregationFragment hOw;
    private ImMessageCenterModel hOx;
    private ImMessageCenterShowItemData hOy;
    private BdListView hOz;
    private com.baidu.tbadk.core.dialog.d huV;
    private final CustomMessageListener huW;
    private com.baidu.tieba.im.chat.a.a huY;
    private final com.baidu.tieba.im.chat.a.b huZ;
    private boolean isNeedRefresh;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ab(chatAggregationFragment.getPageContext().getPageActivity()));
        this.hOx = null;
        this.hOy = null;
        this.hOz = null;
        this.hOB = null;
        this.hOD = null;
        this.hOF = true;
        this.dBH = false;
        this.isNeedRefresh = false;
        this.hOG = true;
        this.hOH = 16;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.hOA.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.hOA.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.hOA.hide();
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData wc = e.this.hOB.getItem(i);
                    TiebaStatic.eventStat(e.this.hOw.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = wc.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(wc);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hOw.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.hOw.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.hOw.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(wc.getFriendId(), 0L), wc.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (wc.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hOw.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(wc);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aKE().aLa() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aKE().aLa().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.hOw.getPageContext().getPageActivity())));
                        }
                    } else if (wc.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hOw.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(wc);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aKE().aLa() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aKE().aLa().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.hOw.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hOw.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.hOw.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hOw.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.hOw.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(wc.getFriendId(), 0L), wc.getFriendName(), wc.getFriendPortrait(), 0, wc.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new an("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.hOw.getPageContext().getPageActivity())));
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
                                com.baidu.tieba.im.db.d.bUm().CP("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.bUm().CP("group_intro_change");
                                com.baidu.tieba.im.db.d.bUm().CP("group_name_change");
                                com.baidu.tieba.im.db.d.bUm().CP("group_notice_change");
                                com.baidu.tieba.im.db.d.bUm().CP("group_level_up");
                                com.baidu.tieba.im.db.d.bUm().CP("dismiss_group");
                                com.baidu.tieba.im.db.d.bUm().CP("kick_out");
                                com.baidu.tieba.im.db.d.bUm().CP("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKE().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.aKE().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.hOw.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.hOI = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.hOy = e.this.hOB.getItem(i);
                e.this.c(e.this.hOy);
                if (e.this.hOD != null) {
                    TiebaStatic.log("c12932");
                    e.this.hOD.showDialog();
                    if (e.this.hOw != null && e.this.hOw.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.hOw.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.huW = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
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
                        e.this.hOx.setData(null, e.this.huY);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.hOB != null) {
                            e.this.hOB.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.hOB != null) {
                        e.this.hOB.notifyDataSetChanged();
                    }
                }
            }
        };
        this.huY = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.bSG();
            }
        };
        this.dor = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.huZ = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.showProgressDialog();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.huV != null) {
                    e.this.huV.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.sN();
                e.this.hOw.showToast(R.string.delete_success, false);
                e.this.bSG();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.sN();
            }
        };
        this.hOw = chatAggregationFragment;
    }

    public void aj(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.hOH = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.hOH = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.hOH);
        }
    }

    public void bKq() {
        if (this.hOB != null) {
            this.hOB.notifyDataSetChanged();
        }
    }

    public void aiI() {
        MessageManager.getInstance().unRegisterListener(this.huW);
        MessageManager.getInstance().unRegisterListener(this.dor);
    }

    public View beS() {
        this.dfG = 3;
        this.rootView = LayoutInflater.from(this.hOw.getPageContext().getPageActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bJ(this.rootView);
        TiebaStatic.eventStat(this.hOw.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        bvR();
        return this.rootView;
    }

    protected void bvR() {
        this.hOz.startPullRefresh();
        this.dBH = isLogin();
        if (!this.dBH) {
            W(this.dBH, true);
        }
    }

    private void registerListener() {
        this.hOw.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.huW);
        this.hOw.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.huW);
        this.hOw.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.huW);
        this.hOw.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.huW);
        this.hOw.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.huW);
        this.hOw.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.huW);
        this.hOw.registerListener(this.dor);
    }

    public void od(boolean z) {
        this.isNeedRefresh = z;
    }

    public void oe(boolean z) {
        this.hOG = z;
    }

    public void onPrimary() {
        if (this.hOB != null && this.hOB.getCount() == 0) {
            od(true);
        }
        if (this.hOG || this.isNeedRefresh) {
            this.hOG = false;
            this.isNeedRefresh = false;
            ku(false);
        }
        boolean isLogin = isLogin();
        if (this.dBH != isLogin) {
            this.dBH = isLogin;
            onUserChanged(this.dBH);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.hOw.getPageContext());
        }
    }

    private void initData() {
        this.hOx = new ImMessageCenterModel();
        oh(com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void bJ(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.hOC = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.hOC.setVisibility(8);
        this.hOC.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.oh(false);
                e.this.og(false);
            }
        });
        this.hOA = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.hOz = (BdListView) view.findViewById(R.id.chat_list_content);
        this.hOz.setDividerHeight(0);
        this.hOB = new MessageAggregationListAdapter(this.hOw.getPageContext().getPageActivity());
        this.hOB.a(this);
        this.hOz.setAdapter((ListAdapter) this.hOB);
        this.hOz.setOnItemClickListener(this.mItemClickListener);
        this.hOz.setOnItemLongClickListener(this.hOI);
        this.hOz.setOnScrollListener(this.mOnScrollListener);
        this.aDx = new View(this.hOw.getFragmentActivity());
        this.aDx.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.hOw.getFragmentActivity(), R.dimen.ds150)));
        this.hOz.addFooterView(this.aDx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.hOw.getPageContext(), i);
        }
        if (this.hOC != null) {
            this.hOC.onChangeSkinType(i);
        }
        if (this.hOB != null) {
            this.hOB.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
            return true;
        }
        return true;
    }

    private void of(boolean z) {
        if (z) {
            bZt();
        } else {
            bZu();
        }
    }

    private void bZt() {
        this.mNoDataView = NoDataViewFactory.a(this.hOw.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.cA(null, this.hOw.getResources().getString(R.string.no_recent_chat)), SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1 ? NoDataViewFactory.b.a(new NoDataViewFactory.a(this.hOw.getResources().getString(R.string.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
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

    private void bZu() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.hOw.getResources().getString(R.string.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.hOw.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bc.skipToLoginActivity(e.this.hOw.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.hOw.getResources().getDimensionPixelSize(R.dimen.ds320);
        int dimensionPixelSize2 = this.hOw.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.hOw.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.hOw.getResources().getDimensionPixelSize(R.dimen.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.hOw.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aE(R.string.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.hOw.getResources().getDimensionPixelSize(R.dimen.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        W(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.hOE = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.hOD != null && e.this.hOD.isShowing() && e.this.hOw != null) {
                    e.this.hOD.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.hOx.asyncDeleteItem(imMessageCenterShowItemData, e.this.huZ);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.hOw.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.hOD = new com.baidu.tbadk.core.dialog.i(this.hOw.getPageContext());
        this.hOD.a(null, new String[]{string}, this.hOE);
    }

    protected boolean ku(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.hOz.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void og(boolean z) {
        if (z) {
            if (bZv() && this.hOC.getVisibility() != 0) {
                this.hOC.setVisibility(0);
            }
        } else if (this.hOC.getVisibility() != 8) {
            this.hOC.setVisibility(8);
        }
    }

    public void W(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.hOz.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.mRoot.removeView(this.mNoDataView);
        }
        of(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.hOz.setVisibility(8);
    }

    public boolean bZv() {
        return this.hOF;
    }

    public void oh(boolean z) {
        this.hOF = z;
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
                if (this.hOx != null) {
                    this.hOx.insertOrUpdate(data, this.huY);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.hOx != null) {
                this.hOx.remove(data, this.huY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.hOx != null) {
                this.hOx.setData(data, this.huY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.hOH = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.hOH != -1) {
                od(true);
                onPrimary();
            }
        }
    }

    public void oc(boolean z) {
        if (z && this.hOz != null && this.hOz.getWrappedAdapter() != null && this.hOz.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.hOz.startPullRefresh();
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
                bZw();
            }
        }
    }

    private void bZw() {
        if (this.hOB != null) {
            this.hOB.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        sN();
        if (this.huV == null) {
            this.huV = com.baidu.tieba.im.db.e.bUn().fa(getPageContext().getPageActivity());
        }
        this.huV.show();
        this.huV.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sN() {
        if (this.huV != null && this.huV.isShowing()) {
            this.huV.dismiss();
            this.huV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSG() {
        if (this.hOz != null && this.hOx != null) {
            this.hOz.completePullRefreshPostDelayed(0L);
            if (this.hOx.getData() != null) {
                this.hOB.setData(this.hOx.getData());
            } else {
                W(isLogin(), true);
            }
        }
    }
}
