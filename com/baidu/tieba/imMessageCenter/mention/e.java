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
    private View beU;
    private int dTT;
    private final CustomMessageListener edg;
    private boolean eqj;
    private final ChatAggregationFragment iOM;
    private ImMessageCenterModel iON;
    private ImMessageCenterShowItemData iOO;
    private BdListView iOP;
    private NavigationBarShadowView iOQ;
    private MessageAggregationListAdapter iOR;
    private ShutDownValidateTipView iOS;
    com.baidu.tbadk.core.dialog.i iOT;
    private k.c iOU;
    private boolean iOV;
    private boolean iOW;
    private int iOX;
    private final AdapterView.OnItemLongClickListener iOY;
    private boolean isNeedRefresh;
    private com.baidu.tbadk.core.dialog.d ivj;
    private final CustomMessageListener ivk;
    private com.baidu.tieba.im.chat.a.a ivm;
    private final com.baidu.tieba.im.chat.a.b ivn;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.G(chatAggregationFragment.getPageContext().getPageActivity()));
        this.iON = null;
        this.iOO = null;
        this.iOP = null;
        this.iOR = null;
        this.iOT = null;
        this.iOV = true;
        this.eqj = false;
        this.isNeedRefresh = false;
        this.iOW = true;
        this.iOX = 16;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.iOQ.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.iOQ.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.iOQ.hide();
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData xo = e.this.iOR.getItem(i);
                    TiebaStatic.eventStat(e.this.iOM.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = xo.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(xo);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.iOM.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.iOM.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.iOM.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(xo.getFriendId(), 0L), xo.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (xo.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.iOM.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(xo);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aZl().aZH() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aZl().aZH().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.iOM.getPageContext().getPageActivity())));
                        }
                    } else if (xo.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.iOM.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(xo);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aZl().aZH() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aZl().aZH().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.iOM.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.iOM.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.iOM.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.iOM.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.iOM.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(xo.getFriendId(), 0L), xo.getFriendNameShow(), xo.getFriendPortrait(), 0, xo.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new an("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.iOM.getPageContext().getPageActivity())));
                    } else {
                        e(xo);
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
                                com.baidu.tieba.im.db.d.clC().Gk("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.clC().Gk("group_intro_change");
                                com.baidu.tieba.im.db.d.clC().Gk("group_name_change");
                                com.baidu.tieba.im.db.d.clC().Gk("group_notice_change");
                                com.baidu.tieba.im.db.d.clC().Gk("group_level_up");
                                com.baidu.tieba.im.db.d.clC().Gk("dismiss_group");
                                com.baidu.tieba.im.db.d.clC().Gk("kick_out");
                                com.baidu.tieba.im.db.d.clC().Gk("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.aZl().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.aZl().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.iOM.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.iOY = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.iOO = e.this.iOR.getItem(i);
                e.this.c(e.this.iOO);
                if (e.this.iOT != null) {
                    TiebaStatic.log("c12932");
                    e.this.iOT.showDialog();
                    if (e.this.iOM != null && e.this.iOM.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.iOM.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.ivk = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
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
                        e.this.iON.setData(null, e.this.ivm);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.iOR != null) {
                            e.this.iOR.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.iOR != null) {
                        e.this.iOR.notifyDataSetChanged();
                    }
                }
            }
        };
        this.ivm = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.cjW();
            }
        };
        this.edg = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.ivn = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.cjV();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.ivj != null) {
                    e.this.ivj.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.yy();
                e.this.iOM.showToast(R.string.delete_success, false);
                e.this.cjW();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.yy();
            }
        };
        this.iOM = chatAggregationFragment;
    }

    public void ap(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.iOX = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.iOX = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.iOX);
        }
    }

    public void cbA() {
        if (this.iOR != null) {
            this.iOR.notifyDataSetChanged();
        }
    }

    public void bZP() {
        MessageManager.getInstance().unRegisterListener(this.ivk);
        MessageManager.getInstance().unRegisterListener(this.edg);
    }

    public View btU() {
        this.dTT = 3;
        this.rootView = LayoutInflater.from(this.iOM.getPageContext().getPageActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bP(this.rootView);
        TiebaStatic.eventStat(this.iOM.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        bMa();
        return this.rootView;
    }

    protected void bMa() {
        this.iOP.startPullRefresh();
        this.eqj = isLogin();
        if (!this.eqj) {
            Z(this.eqj, true);
        }
    }

    private void registerListener() {
        this.iOM.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.ivk);
        this.iOM.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.ivk);
        this.iOM.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.ivk);
        this.iOM.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.ivk);
        this.iOM.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.ivk);
        this.iOM.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.ivk);
        this.iOM.registerListener(this.edg);
    }

    public void pJ(boolean z) {
        this.isNeedRefresh = z;
    }

    public void pK(boolean z) {
        this.iOW = z;
    }

    public void onPrimary() {
        if (this.iOR != null && this.iOR.getCount() == 0) {
            pJ(true);
        }
        if (this.iOW || this.isNeedRefresh) {
            this.iOW = false;
            this.isNeedRefresh = false;
            lY(false);
        }
        boolean isLogin = isLogin();
        if (this.eqj != isLogin) {
            this.eqj = isLogin;
            onUserChanged(this.eqj);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.iOM.getPageContext());
        }
    }

    private void initData() {
        this.iON = new ImMessageCenterModel();
        pN(com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void bP(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.iOS = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.iOS.setVisibility(8);
        this.iOS.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.pN(false);
                e.this.pM(false);
            }
        });
        this.iOQ = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.iOP = (BdListView) view.findViewById(R.id.chat_list_content);
        this.iOP.setDividerHeight(0);
        this.iOR = new MessageAggregationListAdapter(this.iOM.getPageContext().getPageActivity());
        this.iOR.a(this);
        this.iOP.setAdapter((ListAdapter) this.iOR);
        this.iOP.setOnItemClickListener(this.mItemClickListener);
        this.iOP.setOnItemLongClickListener(this.iOY);
        this.iOP.setOnScrollListener(this.mOnScrollListener);
        this.beU = new View(this.iOM.getFragmentActivity());
        this.beU.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.iOM.getFragmentActivity(), R.dimen.ds150)));
        this.iOP.addFooterView(this.beU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.iOM.getPageContext(), i);
        }
        if (this.iOS != null) {
            this.iOS.onChangeSkinType(i);
        }
        if (this.iOR != null) {
            this.iOR.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
            return true;
        }
        return true;
    }

    private void pL(boolean z) {
        if (z) {
            cqK();
        } else {
            cqL();
        }
    }

    private void cqK() {
        this.mNoDataView = NoDataViewFactory.a(this.iOM.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dj(null, this.iOM.getResources().getString(R.string.no_recent_chat)), SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1 ? NoDataViewFactory.b.a(new NoDataViewFactory.a(this.iOM.getResources().getString(R.string.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
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

    private void cqL() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.iOM.getResources().getString(R.string.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.iOM.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bc.skipToLoginActivity(e.this.iOM.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.iOM.getResources().getDimensionPixelSize(R.dimen.ds320);
        int dimensionPixelSize2 = this.iOM.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.iOM.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.iOM.getResources().getDimensionPixelSize(R.dimen.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.iOM.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aL(R.string.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.iOM.getResources().getDimensionPixelSize(R.dimen.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        Z(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.iOU = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.iOT != null && e.this.iOT.isShowing() && e.this.iOM != null) {
                    e.this.iOT.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.iON.asyncDeleteItem(imMessageCenterShowItemData, e.this.ivn);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.iOM.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.iOT = new com.baidu.tbadk.core.dialog.i(this.iOM.getPageContext());
        this.iOT.a(null, new String[]{string}, this.iOU);
    }

    protected boolean lY(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.iOP.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void pM(boolean z) {
        if (z) {
            if (cqM() && this.iOS.getVisibility() != 0) {
                this.iOS.setVisibility(0);
            }
        } else if (this.iOS.getVisibility() != 8) {
            this.iOS.setVisibility(8);
        }
    }

    public void Z(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.iOP.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.mRoot.removeView(this.mNoDataView);
        }
        pL(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.iOP.setVisibility(8);
    }

    public boolean cqM() {
        return this.iOV;
    }

    public void pN(boolean z) {
        this.iOV = z;
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
                if (this.iON != null) {
                    this.iON.insertOrUpdate(data, this.ivm);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.iON != null) {
                this.iON.remove(data, this.ivm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.iON != null) {
                this.iON.setData(data, this.ivm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.iOX = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.iOX != -1) {
                pJ(true);
                onPrimary();
            }
        }
    }

    public void pI(boolean z) {
        if (z && this.iOP != null && this.iOP.getWrappedAdapter() != null && this.iOP.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.iOP.startPullRefresh();
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
                cqN();
            }
        }
    }

    private void cqN() {
        if (this.iOR != null) {
            this.iOR.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjV() {
        yy();
        if (this.ivj == null) {
            this.ivj = com.baidu.tieba.im.db.e.clD().eV(getPageContext().getPageActivity());
        }
        this.ivj.show();
        this.ivj.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yy() {
        if (this.ivj != null && this.ivj.isShowing()) {
            this.ivj.dismiss();
            this.ivj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjW() {
        if (this.iOP != null && this.iON != null) {
            this.iOP.completePullRefreshPostDelayed(0L);
            if (this.iON.getData() != null) {
                this.iOR.setData(this.iON.getData());
            } else {
                Z(isLogin(), true);
            }
        }
    }
}
