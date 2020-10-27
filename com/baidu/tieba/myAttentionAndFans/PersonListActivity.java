package com.baidu.tieba.myAttentionAndFans;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MyForbiddenFansActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes23.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView gdy;
    private NavigationBarCoverTip ivY;
    private TextView iwd;
    private boolean kTo;
    private NavigationBarShadowView kTp;
    private NavigationBarShadowView kTq;
    private ConcernSelectView kTu;
    private e kTv;
    private View kTw;
    private TextView kTx;
    private com.baidu.tieba.forbidden.fans.e kTy;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView kTg = null;
    private View kTh = null;
    private View kTi = null;
    private TextView kTj = null;
    private View kTk = null;
    private TextView kTl = null;
    private b kTm = null;
    private NoPressedRelativeLayout kTn = null;
    private boolean bql = true;
    private TextView byL = null;
    private int gKT = 0;
    private boolean kTr = false;
    private int kTs = 0;
    int kTt = 0;
    private final AntiHelper.a iCN = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener iCO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().eYM != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().eYM, PersonListActivity.this.iCN) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener kTz = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.kTm.gi(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.kTm.bTb();
                    PersonListActivity.this.kTm.notifyDataSetChanged();
                }
                if (PersonListActivity.this.kTm.gKJ) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (PersonListActivity.this.mModel != null) {
                if (i == 1 || i == 2) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String id = PersonListActivity.this.mModel.getId();
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bTd()) {
                        PersonListActivity.this.kTp.show();
                    } else {
                        PersonListActivity.this.kTq.show();
                    }
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                String id = PersonListActivity.this.mModel.getId();
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bTd()) {
                    PersonListActivity.this.kTp.hide();
                } else {
                    PersonListActivity.this.kTq.hide();
                }
            }
        }
    };
    public PersonListModel.a kTA = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void aB(String str, boolean z) {
            if (!z) {
                if (PersonListActivity.this.isLoadingViewAttached()) {
                    PersonListActivity.this.hideLoadingView(PersonListActivity.this.mContainer);
                }
                if (!TextUtils.isEmpty(str)) {
                    PersonListActivity.this.showToast(str);
                }
                PersonListActivity.this.c(null, false);
            }
        }

        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public bc e(bc bcVar, boolean z) {
            if (bcVar != null && bcVar.ewu != PersonListActivity.this.kTs && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bTd() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.OC(PersonListActivity.this.mPortrait);
            }
            PersonListActivity.this.a(bcVar, z);
            return null;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_list_activity);
        initData(bundle);
        initUI();
        this.kTy = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.kTy.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.iwd == null) {
                            PersonListActivity.this.iwd = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.iwd.setGravity(19);
                            PersonListActivity.this.iwd.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.iwd.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.iwd.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.iwd.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        PersonListActivity.this.iwd.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.ivY.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.ivY.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.ivY.a(PersonListActivity.this.getActivity(), PersonListActivity.this.iwd, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.kTx.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    ap.setViewTextColor(PersonListActivity.this.kTx, R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void ctQ() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.iCO);
        registerListener(this.kTz);
        this.mModel.bMg();
        if (this.bql) {
            this.bql = false;
            bTh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        ap.setBackgroundResource(this.kTn, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mContainer, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.kTm != null) {
            this.kTm.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.kTu.onChangeSkinType(i);
        ap.setBackgroundColor(this.kTj, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.kTj, R.color.cp_cont_d);
        ap.setBackgroundColor(this.kTl, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.kTl, R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.kTi != null) {
            getLayoutMode().onModeChanged(this.kTi);
        }
        if (this.kTk != null) {
            getLayoutMode().onModeChanged(this.kTk);
        }
        if (this.kTw != null) {
            ap.setViewTextColor(this.kTx, R.color.cp_cont_d);
            ap.setBackgroundColor(this.kTw, R.color.cp_bg_line_d);
        }
        this.kTy.onChangeSkinType();
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.gdy.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kTm != null) {
            this.kTm = null;
        }
        if (this.kTv != null) {
            this.kTv.Qh();
        }
        this.ivY.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.kTA);
        if (bundle != null) {
            this.mModel.mu(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.gKT = bundle.getInt("user_sex");
            this.kTr = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.kTs = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.gKT);
            return;
        }
        Intent intent = getIntent();
        this.mModel.mu(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.gKT = intent.getIntExtra("user_sex", 0);
        this.kTr = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.kTs = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.gKT);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bTd());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.gKT);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.kTr);
    }

    private void initUI() {
        boolean z = true;
        this.kTn = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.byL = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kTp = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.kTq = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.kTh = findViewById(R.id.sub_title_root);
        this.kTi = this.kTh.findViewById(R.id.newheader_root);
        this.kTh.setVisibility(8);
        this.kTh.setClickable(false);
        this.kTh.setEnabled(false);
        this.kTj = (TextView) this.kTh.findViewById(R.id.person_list_title);
        this.kTu = (ConcernSelectView) findViewById(R.id.select_layout);
        this.ivY = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bTd()) {
                this.byL.setText(R.string.my_attention);
                this.kTn.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void E(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.kTu.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.kTu.dbU() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.kTn.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.kTu.closeView();
                        PersonListActivity.this.kTn.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.byL.setText(R.string.fans);
            }
        } else if (this.mModel.bTd()) {
            if (this.gKT == 2) {
                this.byL.setText(R.string.her_attention_people);
            } else if (this.gKT == 1) {
                this.byL.setText(R.string.his_attention_people);
            } else {
                this.byL.setText(R.string.its_attention_people);
            }
        } else if (this.gKT == 2) {
            this.byL.setText(R.string.attention_to_her);
        } else if (this.gKT == 1) {
            this.byL.setText(R.string.attention_to_him);
        } else {
            this.byL.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.kTm != null && PersonListActivity.this.kTm.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.kTm.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bTd()) {
                            TiebaStatic.log(new aq("c12772").dR("obj_locate", "1").dR("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new aq("c12605").aj("obj_locate", 1).dR("obj_param1", userData.getUserId()));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.15
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.myAttentionAndFans.PersonListActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.kTt = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.dbZ();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.dbY();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.kTm = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.kTh.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.kTn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.kTm = new c(this, z, sex, onClickListener, onClickListener3);
            this.kTh.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.kTn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.kTg = (BdListView) findViewById(R.id.list);
        this.kTg.setAdapter((ListAdapter) this.kTm);
        dbX();
        this.kTg.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.kTm != null && PersonListActivity.this.kTm.isHasMore()) {
                    if (PersonListActivity.this.gdy != null && !PersonListActivity.this.gdy.isLoading()) {
                        PersonListActivity.this.gdy.startLoadData();
                    }
                    PersonListActivity.this.dbY();
                }
            }
        });
        this.kTg.setOnScrollListener(this.mOnScrollListener);
        this.kTu.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void td(boolean z2) {
                if (z2) {
                    PersonListActivity.this.cqn();
                } else if (PersonListActivity.this.kTv != null) {
                    PersonListActivity.this.kTv.Qh();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void zW(int i) {
                PersonListActivity.this.kTg.setSelection(0);
                PersonListActivity.this.mModel.tM(i);
            }
        });
        this.kTu.setVisibility(8);
        this.kTk.setVisibility(8);
        this.gdy = new PbListView(getActivity());
        this.gdy.getView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setLineGone();
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gdy.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.kTg.setNextPage(this.gdy);
    }

    private void dbX() {
        this.kTk = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.kTk.setVisibility(8);
        this.kTk.setClickable(false);
        this.kTk.setEnabled(false);
        this.kTl = (TextView) this.kTk.findViewById(R.id.person_list_title);
        this.kTg.addHeaderView(this.kTk, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqn() {
        if (this.kTv == null) {
            this.kTv = new com.baidu.tieba.c.e(getPageContext(), this.kTu.kSN);
            this.kTv.fh(R.drawable.bg_tip_blue_up);
            this.kTv.setMaxShowTime(2);
            this.kTv.fi(3000);
            this.kTv.xd(-10);
            this.kTv.setYOffset(-16);
            this.kTv.c(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.kTv != null) {
                        PersonListActivity.this.kTv.Qh();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(bc bcVar, boolean z) {
        if (this.mModel != null && bcVar != null && (!z || !this.kTo)) {
            if (!z) {
                this.kTo = true;
                d(bcVar);
            }
            b(bcVar);
            d(bcVar, z);
            if (!this.mModel.bTd()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bts().setMsgFans(0);
            }
            b(bcVar, z);
        }
    }

    private void b(bc bcVar) {
        if (bcVar != null) {
            if (!bcVar.hasMore && !StringUtils.isNull(bcVar.ewv) && !this.kTr) {
                bu(bcVar.ewv, bcVar.type);
                this.kTg.removeFooterView(this.kTw);
                this.kTg.addFooterView(this.kTw);
                this.kTg.removeFooterView(this.gdy.getView());
                TiebaStatic.log(new aq("c13106").aj("obj_locate", 2));
            } else if (!bcVar.hasMore) {
                this.kTg.removeFooterView(this.kTw);
                this.gdy.setText(getString(R.string.no_more_data_tip));
                this.gdy.endLoadData();
            } else {
                this.kTg.removeFooterView(this.kTw);
                this.gdy.setText(getString(R.string.pb_load_more));
                this.gdy.endLoadData();
            }
        }
    }

    private void b(bc bcVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (bcVar.ewu > 0 && !y.isEmpty(bcVar.biT())) {
                c(bcVar);
            } else {
                c(bcVar, z);
            }
        }
    }

    private void c(bc bcVar) {
        String string;
        String string2;
        boolean z;
        TextView textView;
        String str;
        String str2;
        String string3;
        String string4;
        if (bcVar != null) {
            this.kTg.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bTd()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.kTh.setVisibility(0);
                    this.kTg.removeHeaderView(this.kTk);
                    TextView textView2 = this.kTj;
                    textView2.setVisibility(0);
                    this.kTu.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    String string5 = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_attention)));
                    z = false;
                    str = string4;
                    textView = textView2;
                    str2 = string5;
                } else {
                    this.kTh.setVisibility(8);
                    this.kTk.setVisibility(0);
                    TextView textView3 = this.kTl;
                    textView3.setVisibility(8);
                    this.kTu.setVisibility(8);
                    if (this.gKT == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.gKT == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_attention_guest)));
                    String string6 = getPageContext().getString(R.string.person);
                    str = string3;
                    textView = textView3;
                    z = y.isEmpty(bcVar.biU()) ? false : true;
                    str2 = string6;
                }
            } else {
                this.kTh.setVisibility(8);
                this.kTk.setVisibility(0);
                TextView textView4 = this.kTl;
                this.kTu.setVisibility(8);
                textView4.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    String string7 = getPageContext().getString(R.string.my_fans_prefix);
                    String string8 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_fans)));
                    z = false;
                    textView = textView4;
                    str = string7;
                    str2 = string8;
                } else {
                    if (this.gKT == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.gKT == 1) {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.her_no_fan_guest)));
                    z = false;
                    String str3 = string2;
                    textView = textView4;
                    str = string;
                    str2 = str3;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(R.string.we_common_fans));
                return;
            }
            textView.setText(str + at.numberUniformFormat(bcVar.ewu) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(bc bcVar, boolean z) {
        String string;
        this.kTg.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bTd()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.kTu.setVisibility(0);
                this.kTj.setVisibility(0);
                this.kTh.setVisibility(0);
                this.kTk.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.kTj.setText(string + 0 + string2);
                return;
            }
            this.kTu.setVisibility(8);
            this.kTj.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.kTu.setVisibility(8);
        this.kTj.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (bcVar != null && !StringUtils.isNull(bcVar.ewv) && !this.kTr) {
                this.mNoDataView.getSuTextView().setText(bv(bcVar.ewv, bcVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new aq("c13106").aj("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_fans)));
            return;
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.her_no_fan_guest)));
    }

    private void d(bc bcVar) {
        this.mModel.setPage(bcVar.pageNum);
    }

    private void d(bc bcVar, boolean z) {
        if (this.kTm != null) {
            if (!z) {
                if (bcVar.pageNum == 1) {
                    this.kTm.resetData();
                }
                this.kTm.setHasMore(bcVar.hasMore);
                this.kTm.a(bcVar);
                this.kTm.bTb();
                this.kTm.notifyDataSetChanged();
                return;
            }
            this.kTm.setHasMore(false);
            this.kTm.a(bcVar);
            this.kTm.bTb();
            this.kTm.notifyDataSetChanged();
        }
    }

    private void bTh() {
        showLoadingView(this.mContainer);
        this.mModel.bTe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbY() {
        if (this.kTm != null) {
            this.kTm.notifyDataSetChanged();
        }
        this.mModel.bTe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbZ() {
        UserData userData;
        if (this.kTm != null && this.kTm.getItemViewType(this.kTt) == 0 && (userData = (UserData) this.kTm.getItem(this.kTt)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "enter_chat", "personlistclick", 1, new Object[0]);
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 11028) {
            dbZ();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kTu.dbU()) {
                this.kTu.closeView();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bu(String str, int i) {
        if (this.kTw == null) {
            this.kTw = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.kTx = (TextView) this.kTw.findViewById(R.id.view_forbidden_tip);
            ap.setViewTextColor(this.kTx, R.color.cp_cont_d);
            ap.setBackgroundColor(this.kTw, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.kTw.setVisibility(8);
            return;
        }
        this.kTx.setText(bv(str, i));
        this.kTx.setMovementMethod(LinkMovementMethod.getInstance());
        this.kTx.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private SpannableStringBuilder bv(String str, int i) {
        String string;
        String str2 = null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        switch (i) {
            case 1:
                spannableStringBuilder.append((CharSequence) "，");
                string = getString(R.string.click_for_look_all);
                spannableStringBuilder.append((CharSequence) string);
                break;
            case 2:
                spannableStringBuilder.append((CharSequence) "，");
                String string2 = getString(R.string.remove_all_forbidden_fans);
                spannableStringBuilder.append((CharSequence) string2);
                string = null;
                str2 = string2;
                break;
            case 3:
                string = getString(R.string.click_for_look_all);
                str2 = getString(R.string.remove_all_forbidden_fans);
                spannableStringBuilder.append((CharSequence) "，");
                spannableStringBuilder.append((CharSequence) string);
                spannableStringBuilder.append((CharSequence) getString(R.string.tip_or));
                spannableStringBuilder.append((CharSequence) str2);
                break;
            default:
                string = null;
                break;
        }
        if (!StringUtils.isNull(string)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), string, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.6
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.dcb();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ap.getColor(R.color.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.dca();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ap.getColor(R.color.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dca() {
        TiebaStatic.log(new aq("c13104").aj("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.kTy.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcb() {
        TiebaStatic.log(new aq("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
