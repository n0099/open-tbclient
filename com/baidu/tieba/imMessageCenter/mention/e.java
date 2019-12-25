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
/* loaded from: classes6.dex */
public class e extends com.baidu.adp.base.c<ChatAggregationFragment> implements g.c {
    private View ayx;
    private int dbp;
    private final CustomMessageListener djU;
    private boolean dxv;
    private final ChatAggregationFragment hIT;
    private ImMessageCenterModel hIU;
    private ImMessageCenterShowItemData hIV;
    private BdListView hIW;
    private NavigationBarShadowView hIX;
    private MessageAggregationListAdapter hIY;
    private ShutDownValidateTipView hIZ;
    com.baidu.tbadk.core.dialog.i hJa;
    private k.c hJb;
    private boolean hJc;
    private boolean hJd;
    private int hJe;
    private final AdapterView.OnItemLongClickListener hJf;
    private com.baidu.tbadk.core.dialog.d hpr;
    private final CustomMessageListener hps;
    private com.baidu.tieba.im.chat.a.a hpu;
    private final com.baidu.tieba.im.chat.a.b hpv;
    private boolean isNeedRefresh;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private NoDataView mNoDataView;
    private AbsListView.OnScrollListener mOnScrollListener;
    private RelativeLayout mRoot;
    private View rootView;

    public e(ChatAggregationFragment chatAggregationFragment) {
        super(com.baidu.adp.base.i.ab(chatAggregationFragment.getPageContext().getPageActivity()));
        this.hIU = null;
        this.hIV = null;
        this.hIW = null;
        this.hIY = null;
        this.hJa = null;
        this.hJc = true;
        this.dxv = false;
        this.isNeedRefresh = false;
        this.hJd = true;
        this.hJe = 16;
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    case 0:
                        View childAt = absListView.getChildAt(0);
                        if (childAt != null && childAt.getTop() == 0) {
                            e.this.hIX.hide();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        e.this.hIX.show();
                        return;
                    default:
                        return;
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View childAt;
                if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                    e.this.hIX.hide();
                }
            }
        };
        this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    ImMessageCenterShowItemData vR = e.this.hIY.getItem(i);
                    TiebaStatic.eventStat(e.this.hIT.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                    String ownerName = vR.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        e(vR);
                    } else if (ownerName.equals("1")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hIT.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                            TiebaStatic.eventStat(e.this.hIT.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(e.this.hIT.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(vR.getFriendId(), 0L), vR.getFriendName(), 0L, "msg_lstb")));
                        }
                    } else if (vR.getOwnerName().equals("2")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hIT.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START)) {
                            d(vR);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aHP().aIl() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aHP().aIl().setUnReadGroupValidate(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_VALIDATE_ACTIVITY_START, new ValidateActivityConfig(e.this.hIT.getPageContext().getPageActivity())));
                        }
                    } else if (vR.getOwnerName().equals("3")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hIT.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START)) {
                            d(vR);
                            if (com.baidu.tbadk.coreExtra.messageCenter.b.aHP().aIl() != null) {
                                com.baidu.tbadk.coreExtra.messageCenter.b.aHP().aIl().setUnReadGroupUpdates(0);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_UPDATES_ACTIVITY_START, new UpdatesActivityConfig(e.this.hIT.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("5")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hIT.getPageContext().getOrignalPage(), (int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START)) {
                            TiebaStatic.log("c12931");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_OFFICIALBARTIP_ACTIVITY_START, new OfficialBarTipActivityConfig(e.this.hIT.getPageContext().getPageActivity())));
                        }
                    } else if (ownerName.equals("8")) {
                        if (com.baidu.tieba.imMessageCenter.im.chat.notify.a.a(e.this.hIT.getPageContext().getOrignalPage(), (int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(e.this.hIT.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(vR.getFriendId(), 0L), vR.getFriendName(), vR.getFriendPortrait(), 0, vR.getUserType())));
                        }
                    } else if (ownerName.equals("7")) {
                        TiebaStatic.log(new an("c12614"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StrangerListActivityConfig(e.this.hIT.getPageContext().getPageActivity())));
                    } else {
                        e(vR);
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
                                com.baidu.tieba.im.db.d.bRA().Cp("apply_join_group");
                            } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                                com.baidu.tieba.im.db.d.bRA().Cp("group_intro_change");
                                com.baidu.tieba.im.db.d.bRA().Cp("group_name_change");
                                com.baidu.tieba.im.db.d.bRA().Cp("group_notice_change");
                                com.baidu.tieba.im.db.d.bRA().Cp("group_level_up");
                                com.baidu.tieba.im.db.d.bRA().Cp("dismiss_group");
                                com.baidu.tieba.im.db.d.bRA().Cp("kick_out");
                                com.baidu.tieba.im.db.d.bRA().Cp("group_activitys_change");
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.aHP().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.b.aHP().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(e.this.hIT.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.hJf = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.9
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.this.hIV = e.this.hIY.getItem(i);
                e.this.c(e.this.hIV);
                if (e.this.hJa != null) {
                    TiebaStatic.log("c12932");
                    e.this.hJa.showDialog();
                    if (e.this.hIT != null && e.this.hIT.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        e.this.hIT.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.hps = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.e.11
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
                        e.this.hIU.setData(null, e.this.hpu);
                    } else if (customResponsedMessage.getCmd() == 2016010) {
                        if (e.this.hIY != null) {
                            e.this.hIY.notifyDataSetChanged();
                        }
                    } else if (customResponsedMessage.getCmd() == 2016011 && e.this.hIY != null) {
                        e.this.hIY.notifyDataSetChanged();
                    }
                }
            }
        };
        this.hpu = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.mention.e.12
            @Override // com.baidu.tieba.im.chat.a.a
            public void onComplete() {
                e.this.bPU();
            }
        };
        this.djU = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    e.this.d((ResponsedMessage<?>) customResponsedMessage);
                }
            }
        };
        this.hpv = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.mention.e.4
            @Override // com.baidu.tieba.im.chat.a.b
            public void onPreExecute() {
                e.this.showProgressDialog();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onProgressUpdate(int i, String str, int i2) {
                if (e.this.hpr != null) {
                    e.this.hpr.setPercent(i);
                }
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onPostExecute() {
                e.this.wN();
                e.this.hIT.showToast(R.string.delete_success, false);
                e.this.bPU();
            }

            @Override // com.baidu.tieba.im.chat.a.b
            public void onCanceled() {
                e.this.wN();
            }
        };
        this.hIT = chatAggregationFragment;
    }

    public void aj(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.hJe = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.hJe = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.hJe);
        }
    }

    public void bHK() {
        if (this.hIY != null) {
            this.hIY.notifyDataSetChanged();
        }
    }

    public void afZ() {
        MessageManager.getInstance().unRegisterListener(this.hps);
        MessageManager.getInstance().unRegisterListener(this.djU);
    }

    public View bci() {
        this.dbp = 3;
        this.rootView = LayoutInflater.from(this.hIT.getPageContext().getPageActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        initData();
        bE(this.rootView);
        TiebaStatic.eventStat(this.hIT.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        btj();
        return this.rootView;
    }

    protected void btj() {
        this.hIW.startPullRefresh();
        this.dxv = isLogin();
        if (!this.dxv) {
            U(this.dxv, true);
        }
    }

    private void registerListener() {
        this.hIT.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.hps);
        this.hIT.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.hps);
        this.hIT.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.hps);
        this.hIT.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.hps);
        this.hIT.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.hps);
        this.hIT.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.hps);
        this.hIT.registerListener(this.djU);
    }

    public void nP(boolean z) {
        this.isNeedRefresh = z;
    }

    public void nQ(boolean z) {
        this.hJd = z;
    }

    public void onPrimary() {
        if (this.hIY != null && this.hIY.getCount() == 0) {
            nP(true);
        }
        if (this.hJd || this.isNeedRefresh) {
            this.hJd = false;
            this.isNeedRefresh = false;
            kh(false);
        }
        boolean isLogin = isLogin();
        if (this.dxv != isLogin) {
            this.dxv = isLogin;
            onUserChanged(this.dxv);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.hIT.getPageContext());
        }
    }

    private void initData() {
        this.hIU = new ImMessageCenterModel();
        nT(com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, false) ? false : true);
    }

    private void bE(View view) {
        this.mRoot = (RelativeLayout) view.findViewById(R.id.chat_list);
        this.hIZ = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.hIZ.setVisibility(8);
        this.hIZ.setShutDownClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.IS_SHUT_DOWN_VALIDATE, true);
                e.this.nT(false);
                e.this.nS(false);
            }
        });
        this.hIX = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        this.hIW = (BdListView) view.findViewById(R.id.chat_list_content);
        this.hIW.setDividerHeight(0);
        this.hIY = new MessageAggregationListAdapter(this.hIT.getPageContext().getPageActivity());
        this.hIY.a(this);
        this.hIW.setAdapter((ListAdapter) this.hIY);
        this.hIW.setOnItemClickListener(this.mItemClickListener);
        this.hIW.setOnItemLongClickListener(this.hJf);
        this.hIW.setOnScrollListener(this.mOnScrollListener);
        this.ayx = new View(this.hIT.getFragmentActivity());
        this.ayx.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.hIT.getFragmentActivity(), R.dimen.ds150)));
        this.hIW.addFooterView(this.ayx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.hIT.getPageContext(), i);
        }
        if (this.hIZ != null) {
            this.hIZ.onChangeSkinType(i);
        }
        if (this.hIY != null) {
            this.hIY.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().onModeChanged(this.mRoot);
            return true;
        }
        return true;
    }

    private void nR(boolean z) {
        if (z) {
            bWH();
        } else {
            bWI();
        }
    }

    private void bWH() {
        this.mNoDataView = NoDataViewFactory.a(this.hIT.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.cr(null, this.hIT.getResources().getString(R.string.no_recent_chat)), SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1 ? NoDataViewFactory.b.a(new NoDataViewFactory.a(this.hIT.getResources().getString(R.string.maintab_imcenter_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.6
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

    private void bWI() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.hIT.getResources().getString(R.string.maintab_imcenter_unlogin_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.eventStat(e.this.hIT.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                bc.skipToLoginActivity(e.this.hIT.getPageContext().getPageActivity());
            }
        });
        int dimensionPixelSize = this.hIT.getResources().getDimensionPixelSize(R.dimen.ds320);
        int dimensionPixelSize2 = this.hIT.getResources().getDimensionPixelSize(R.dimen.ds480);
        int dimensionPixelSize3 = this.hIT.getResources().getDimensionPixelSize(R.dimen.ds360);
        int dimensionPixelSize4 = this.hIT.getResources().getDimensionPixelSize(R.dimen.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.hIT.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aA(R.string.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.hIT.getResources().getDimensionPixelSize(R.dimen.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        U(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.hJb = new k.c() { // from class: com.baidu.tieba.imMessageCenter.mention.e.10
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (e.this.hJa != null && e.this.hJa.isShowing() && e.this.hIT != null) {
                    e.this.hJa.dismiss();
                }
                switch (i) {
                    case 0:
                        TiebaStatic.log("c12933");
                        e.this.hIU.asyncDeleteItem(imMessageCenterShowItemData, e.this.hpv);
                        return;
                    default:
                        BdLog.e("error prepareMenuDialog");
                        return;
                }
            }
        };
        String string = this.hIT.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        this.hJa = new com.baidu.tbadk.core.dialog.i(this.hIT.getPageContext());
        this.hJa.a(null, new String[]{string}, this.hJb);
    }

    protected boolean kh(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.hIW.completePullRefreshPostDelayed(0L);
        }
        return true;
    }

    public void nS(boolean z) {
        if (z) {
            if (bWJ() && this.hIZ.getVisibility() != 0) {
                this.hIZ.setVisibility(0);
            }
        } else if (this.hIZ.getVisibility() != 8) {
            this.hIZ.setVisibility(8);
        }
    }

    public void U(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.hIW.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.mRoot.removeView(this.mNoDataView);
        }
        nR(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.hIW.setVisibility(8);
    }

    public boolean bWJ() {
        return this.hJc;
    }

    public void nT(boolean z) {
        this.hJc = z;
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
                if (this.hIU != null) {
                    this.hIU.insertOrUpdate(data, this.hpu);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.hIU != null) {
                this.hIU.remove(data, this.hpu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.hIU != null) {
                this.hIU.setData(data, this.hpu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.hJe = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.hJe != -1) {
                nP(true);
                onPrimary();
            }
        }
    }

    public void nO(boolean z) {
        if (z && this.hIW != null && this.hIW.getWrappedAdapter() != null && this.hIW.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.hIW.startPullRefresh();
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
                bWK();
            }
        }
    }

    private void bWK() {
        if (this.hIY != null) {
            this.hIY.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        wN();
        if (this.hpr == null) {
            this.hpr = com.baidu.tieba.im.db.e.bRB().eX(getPageContext().getPageActivity());
        }
        this.hpr.show();
        this.hpr.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wN() {
        if (this.hpr != null && this.hpr.isShowing()) {
            this.hpr.dismiss();
            this.hpr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPU() {
        if (this.hIW != null && this.hIU != null) {
            this.hIW.completePullRefreshPostDelayed(0L);
            if (this.hIU.getData() != null) {
                this.hIY.setData(this.hIU.getData());
            } else {
                U(isLogin(), true);
            }
        }
    }
}
