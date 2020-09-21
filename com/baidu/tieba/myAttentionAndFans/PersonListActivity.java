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
/* loaded from: classes22.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView fHm;
    private NavigationBarCoverTip hUB;
    private TextView hUG;
    private boolean krF;
    private NavigationBarShadowView krG;
    private NavigationBarShadowView krH;
    private ConcernSelectView krL;
    private e krM;
    private View krN;
    private TextView krO;
    private com.baidu.tieba.forbidden.fans.e krP;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView krx = null;
    private View kry = null;
    private View krz = null;
    private TextView krA = null;
    private View krB = null;
    private TextView krC = null;
    private b krD = null;
    private NoPressedRelativeLayout krE = null;
    private boolean bkL = true;
    private TextView bsJ = null;
    private int gkM = 0;
    private boolean krI = false;
    private int krJ = 0;
    int krK = 0;
    private final AntiHelper.a ibq = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener ibr = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().eEj != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().eEj, PersonListActivity.this.ibq) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener krQ = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.krD.fP(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.krD.bMN();
                    PersonListActivity.this.krD.notifyDataSetChanged();
                }
                if (PersonListActivity.this.krD.gkC) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bMP()) {
                        PersonListActivity.this.krG.show();
                    } else {
                        PersonListActivity.this.krH.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bMP()) {
                    PersonListActivity.this.krG.hide();
                } else {
                    PersonListActivity.this.krH.hide();
                }
            }
        }
    };
    public PersonListModel.a krR = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void av(String str, boolean z) {
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
            if (bcVar != null && bcVar.ebS != PersonListActivity.this.krJ && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bMP() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.Np(PersonListActivity.this.mPortrait);
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
        this.krP = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.krP.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.hUG == null) {
                            PersonListActivity.this.hUG = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.hUG.setGravity(19);
                            PersonListActivity.this.hUG.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.hUG.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.hUG.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.hUG.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        PersonListActivity.this.hUG.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.hUB.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.hUB.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.hUB.a(PersonListActivity.this.getActivity(), PersonListActivity.this.hUG, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.krO.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    ap.setViewTextColor(PersonListActivity.this.krO, R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void cnl() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.ibr);
        registerListener(this.krQ);
        this.mModel.bGS();
        if (this.bkL) {
            this.bkL = false;
            bMT();
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
        ap.setBackgroundResource(this.krE, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mContainer, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.krD != null) {
            this.krD.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.krL.onChangeSkinType(i);
        ap.setBackgroundColor(this.krA, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.krA, R.color.cp_cont_d);
        ap.setBackgroundColor(this.krC, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.krC, R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.krz != null) {
            getLayoutMode().onModeChanged(this.krz);
        }
        if (this.krB != null) {
            getLayoutMode().onModeChanged(this.krB);
        }
        if (this.krN != null) {
            ap.setViewTextColor(this.krO, R.color.cp_cont_d);
            ap.setBackgroundColor(this.krN, R.color.cp_bg_line_d);
        }
        this.krP.onChangeSkinType();
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fHm.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.krD != null) {
            this.krD = null;
        }
        if (this.krM != null) {
            this.krM.Oj();
        }
        this.hUB.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.krR);
        if (bundle != null) {
            this.mModel.lB(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.gkM = bundle.getInt("user_sex");
            this.krI = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.krJ = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.gkM);
            return;
        }
        Intent intent = getIntent();
        this.mModel.lB(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.gkM = intent.getIntExtra("user_sex", 0);
        this.krI = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.krJ = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.gkM);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bMP());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.gkM);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.krI);
    }

    private void initUI() {
        boolean z = true;
        this.krE = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bsJ = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.krG = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.krH = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.kry = findViewById(R.id.sub_title_root);
        this.krz = this.kry.findViewById(R.id.newheader_root);
        this.kry.setVisibility(8);
        this.kry.setClickable(false);
        this.kry.setEnabled(false);
        this.krA = (TextView) this.kry.findViewById(R.id.person_list_title);
        this.krL = (ConcernSelectView) findViewById(R.id.select_layout);
        this.hUB = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bMP()) {
                this.bsJ.setText(R.string.my_attention);
                this.krE.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void E(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.krL.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.krL.cVd() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.krE.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.krL.closeView();
                        PersonListActivity.this.krE.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.bsJ.setText(R.string.fans);
            }
        } else if (this.mModel.bMP()) {
            if (this.gkM == 2) {
                this.bsJ.setText(R.string.her_attention_people);
            } else if (this.gkM == 1) {
                this.bsJ.setText(R.string.his_attention_people);
            } else {
                this.bsJ.setText(R.string.its_attention_people);
            }
        } else if (this.gkM == 2) {
            this.bsJ.setText(R.string.attention_to_her);
        } else if (this.gkM == 1) {
            this.bsJ.setText(R.string.attention_to_him);
        } else {
            this.bsJ.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.krD != null && PersonListActivity.this.krD.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.krD.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bMP()) {
                            TiebaStatic.log(new aq("c12772").dF("obj_locate", "1").dF("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new aq("c12605").ai("obj_locate", 1).dF("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.krK = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.cVi();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.cVh();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.krD = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.kry.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.krE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.krD = new c(this, z, sex, onClickListener, onClickListener3);
            this.kry.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.krE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.krx = (BdListView) findViewById(R.id.list);
        this.krx.setAdapter((ListAdapter) this.krD);
        cVg();
        this.krx.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.krD != null && PersonListActivity.this.krD.isHasMore()) {
                    if (PersonListActivity.this.fHm != null && !PersonListActivity.this.fHm.isLoading()) {
                        PersonListActivity.this.fHm.startLoadData();
                    }
                    PersonListActivity.this.cVh();
                }
            }
        });
        this.krx.setOnScrollListener(this.mOnScrollListener);
        this.krL.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void sf(boolean z2) {
                if (z2) {
                    PersonListActivity.this.cjK();
                } else if (PersonListActivity.this.krM != null) {
                    PersonListActivity.this.krM.Oj();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void yX(int i) {
                PersonListActivity.this.krx.setSelection(0);
                PersonListActivity.this.mModel.sV(i);
            }
        });
        this.krL.setVisibility(8);
        this.krB.setVisibility(8);
        this.fHm = new PbListView(getActivity());
        this.fHm.getView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setLineGone();
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fHm.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.krx.setNextPage(this.fHm);
    }

    private void cVg() {
        this.krB = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.krB.setVisibility(8);
        this.krB.setClickable(false);
        this.krB.setEnabled(false);
        this.krC = (TextView) this.krB.findViewById(R.id.person_list_title);
        this.krx.addHeaderView(this.krB, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjK() {
        if (this.krM == null) {
            this.krM = new com.baidu.tieba.c.e(getPageContext(), this.krL.kre);
            this.krM.eW(R.drawable.bg_tip_blue_up);
            this.krM.setMaxShowTime(2);
            this.krM.eX(3000);
            this.krM.we(-10);
            this.krM.setYOffset(-16);
            this.krM.c(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.krM != null) {
                        PersonListActivity.this.krM.Oj();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(bc bcVar, boolean z) {
        if (this.mModel != null && bcVar != null && (!z || !this.krF)) {
            if (!z) {
                this.krF = true;
                d(bcVar);
            }
            b(bcVar);
            d(bcVar, z);
            if (!this.mModel.bMP()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.boP().setMsgFans(0);
            }
            b(bcVar, z);
        }
    }

    private void b(bc bcVar) {
        if (bcVar != null) {
            if (!bcVar.hasMore && !StringUtils.isNull(bcVar.ebT) && !this.krI) {
                bs(bcVar.ebT, bcVar.type);
                this.krx.removeFooterView(this.krN);
                this.krx.addFooterView(this.krN);
                this.krx.removeFooterView(this.fHm.getView());
                TiebaStatic.log(new aq("c13106").ai("obj_locate", 2));
            } else if (!bcVar.hasMore) {
                this.krx.removeFooterView(this.krN);
                this.fHm.setText(getString(R.string.no_more_data_tip));
                this.fHm.endLoadData();
            } else {
                this.krx.removeFooterView(this.krN);
                this.fHm.setText(getString(R.string.pb_load_more));
                this.fHm.endLoadData();
            }
        }
    }

    private void b(bc bcVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (bcVar.ebS > 0 && !y.isEmpty(bcVar.ber())) {
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
            this.krx.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bMP()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.kry.setVisibility(0);
                    this.krx.removeHeaderView(this.krB);
                    TextView textView2 = this.krA;
                    textView2.setVisibility(0);
                    this.krL.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    String string5 = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, getResources().getString(R.string.not_have_attention)));
                    z = false;
                    str = string4;
                    textView = textView2;
                    str2 = string5;
                } else {
                    this.kry.setVisibility(8);
                    this.krB.setVisibility(0);
                    TextView textView3 = this.krC;
                    textView3.setVisibility(8);
                    this.krL.setVisibility(8);
                    if (this.gkM == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.gkM == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, getResources().getString(R.string.not_have_attention_guest)));
                    String string6 = getPageContext().getString(R.string.person);
                    str = string3;
                    textView = textView3;
                    z = y.isEmpty(bcVar.bes()) ? false : true;
                    str2 = string6;
                }
            } else {
                this.kry.setVisibility(8);
                this.krB.setVisibility(0);
                TextView textView4 = this.krC;
                this.krL.setVisibility(8);
                textView4.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    String string7 = getPageContext().getString(R.string.my_fans_prefix);
                    String string8 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, getResources().getString(R.string.not_have_fans)));
                    z = false;
                    textView = textView4;
                    str = string7;
                    str2 = string8;
                } else {
                    if (this.gkM == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.gkM == 1) {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, getResources().getString(R.string.her_no_fan_guest)));
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
            textView.setText(str + at.numberUniformFormat(bcVar.ebS) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(bc bcVar, boolean z) {
        String string;
        this.krx.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bMP()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.krL.setVisibility(0);
                this.krA.setVisibility(0);
                this.kry.setVisibility(0);
                this.krB.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.krA.setText(string + 0 + string2);
                return;
            }
            this.krL.setVisibility(8);
            this.krA.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.krL.setVisibility(8);
        this.krA.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (bcVar != null && !StringUtils.isNull(bcVar.ebT) && !this.krI) {
                this.mNoDataView.getSuTextView().setText(bt(bcVar.ebT, bcVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new aq("c13106").ai("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, getResources().getString(R.string.not_have_fans)));
            return;
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, getResources().getString(R.string.her_no_fan_guest)));
    }

    private void d(bc bcVar) {
        this.mModel.setPage(bcVar.pageNum);
    }

    private void d(bc bcVar, boolean z) {
        if (this.krD != null) {
            if (!z) {
                if (bcVar.pageNum == 1) {
                    this.krD.resetData();
                }
                this.krD.setHasMore(bcVar.hasMore);
                this.krD.a(bcVar);
                this.krD.bMN();
                this.krD.notifyDataSetChanged();
                return;
            }
            this.krD.setHasMore(false);
            this.krD.a(bcVar);
            this.krD.bMN();
            this.krD.notifyDataSetChanged();
        }
    }

    private void bMT() {
        showLoadingView(this.mContainer);
        this.mModel.bMQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVh() {
        if (this.krD != null) {
            this.krD.notifyDataSetChanged();
        }
        this.mModel.bMQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVi() {
        UserData userData;
        if (this.krD != null && this.krD.getItemViewType(this.krK) == 0 && (userData = (UserData) this.krD.getItem(this.krK)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            cVi();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.krL.cVd()) {
                this.krL.closeView();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bs(String str, int i) {
        if (this.krN == null) {
            this.krN = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.krO = (TextView) this.krN.findViewById(R.id.view_forbidden_tip);
            ap.setViewTextColor(this.krO, R.color.cp_cont_d);
            ap.setBackgroundColor(this.krN, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.krN.setVisibility(8);
            return;
        }
        this.krO.setText(bt(str, i));
        this.krO.setMovementMethod(LinkMovementMethod.getInstance());
        this.krO.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private SpannableStringBuilder bt(String str, int i) {
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
                    PersonListActivity.this.cVk();
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
                    PersonListActivity.this.cVj();
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
    public void cVj() {
        TiebaStatic.log(new aq("c13104").ai("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.krP.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVk() {
        TiebaStatic.log(new aq("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
