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
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes10.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView ePr;
    private NavigationBarCoverTip gTn;
    private TextView gTs;
    private boolean jdD;
    private NavigationBarShadowView jdE;
    private NavigationBarShadowView jdF;
    private ConcernSelectView jdJ;
    private com.baidu.tieba.c.d jdK;
    private View jdL;
    private TextView jdM;
    private e jdN;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView jdv = null;
    private View jdw = null;
    private View jdx = null;
    private TextView jdy = null;
    private View jdz = null;
    private TextView jdA = null;
    private b jdB = null;
    private NoPressedRelativeLayout jdC = null;
    private boolean gdT = true;
    private TextView aWU = null;
    private int fqT = 0;
    private boolean jdG = false;
    private int jdH = 0;
    int jdI = 0;
    private final AntiHelper.a gZC = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener gZD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().dOt != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().dOt, PersonListActivity.this.gZC) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener jdO = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.jdB.eX(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.jdB.bqe();
                    PersonListActivity.this.jdB.notifyDataSetChanged();
                }
                if (PersonListActivity.this.jdB.fqJ) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bqg()) {
                        PersonListActivity.this.jdE.show();
                    } else {
                        PersonListActivity.this.jdF.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bqg()) {
                    PersonListActivity.this.jdE.hide();
                } else {
                    PersonListActivity.this.jdF.hide();
                }
            }
        }
    };
    public PersonListModel.a jdP = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void ae(String str, boolean z) {
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
        public av e(av avVar, boolean z) {
            if (avVar != null && avVar.dpE != PersonListActivity.this.jdH && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bqg() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.GW(PersonListActivity.this.mPortrait);
            }
            PersonListActivity.this.a(avVar, z);
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
        this.jdN = new e(getPageContext(), getUniqueId());
        this.jdN.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.gTs == null) {
                            PersonListActivity.this.gTs = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.gTs.setGravity(19);
                            PersonListActivity.this.gTs.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.gTs.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.gTs.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.gTs.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        PersonListActivity.this.gTs.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.gTn.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.gTn.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.gTn.a(PersonListActivity.this.getActivity(), PersonListActivity.this.gTs, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.jdM.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    am.setViewTextColor(PersonListActivity.this.jdM, (int) R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bMN() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.gZD);
        registerListener(this.jdO);
        this.mModel.bkX();
        if (this.gdT) {
            this.gdT = false;
            bqk();
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
        am.setBackgroundResource(this.jdC, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.mContainer, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.jdB != null) {
            this.jdB.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.jdJ.onChangeSkinType(i);
        am.setBackgroundColor(this.jdy, R.color.cp_bg_line_d);
        am.setViewTextColor(this.jdy, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.jdA, R.color.cp_bg_line_d);
        am.setViewTextColor(this.jdA, (int) R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.jdx != null) {
            getLayoutMode().onModeChanged(this.jdx);
        }
        if (this.jdz != null) {
            getLayoutMode().onModeChanged(this.jdz);
        }
        if (this.jdL != null) {
            am.setViewTextColor(this.jdM, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.jdL, R.color.cp_bg_line_d);
        }
        this.jdN.onChangeSkinType();
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_d));
        this.ePr.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jdB != null) {
            this.jdB = null;
        }
        if (this.jdK != null) {
            this.jdK.ED();
        }
        this.gTn.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.jdP);
        if (bundle != null) {
            this.mModel.jM(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fqT = bundle.getInt("user_sex");
            this.jdG = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.jdH = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.fqT);
            return;
        }
        Intent intent = getIntent();
        this.mModel.jM(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fqT = intent.getIntExtra("user_sex", 0);
        this.jdG = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.jdH = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.fqT);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bqg());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.fqT);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.jdG);
    }

    private void initUI() {
        boolean z = true;
        this.jdC = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.aWU = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jdE = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.jdF = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.jdw = findViewById(R.id.sub_title_root);
        this.jdx = this.jdw.findViewById(R.id.newheader_root);
        this.jdw.setVisibility(8);
        this.jdw.setClickable(false);
        this.jdw.setEnabled(false);
        this.jdy = (TextView) this.jdw.findViewById(R.id.person_list_title);
        this.jdJ = (ConcernSelectView) findViewById(R.id.select_layout);
        this.gTn = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bqg()) {
                this.aWU.setText(R.string.my_attention);
                this.jdC.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void p(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.jdJ.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.jdJ.csh() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.jdC.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.jdJ.closeView();
                        PersonListActivity.this.jdC.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.aWU.setText(R.string.fans);
            }
        } else if (this.mModel.bqg()) {
            if (this.fqT == 2) {
                this.aWU.setText(R.string.her_attention_people);
            } else if (this.fqT == 1) {
                this.aWU.setText(R.string.his_attention_people);
            } else {
                this.aWU.setText(R.string.its_attention_people);
            }
        } else if (this.fqT == 2) {
            this.aWU.setText(R.string.attention_to_her);
        } else if (this.fqT == 1) {
            this.aWU.setText(R.string.attention_to_him);
        } else {
            this.aWU.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.jdB != null && PersonListActivity.this.jdB.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.jdB.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bqg()) {
                            TiebaStatic.log(new an("c12772").cI("obj_locate", "1").cI("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new an("c12605").af("obj_locate", 1).cI("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.jdI = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.csm();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.csl();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.jdB = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.jdw.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.jdC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.jdB = new c(this, z, sex, onClickListener, onClickListener3);
            this.jdw.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.jdC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.jdv = (BdListView) findViewById(R.id.list);
        this.jdv.setAdapter((ListAdapter) this.jdB);
        csk();
        this.jdv.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.jdB != null && PersonListActivity.this.jdB.isHasMore()) {
                    if (PersonListActivity.this.ePr != null && !PersonListActivity.this.ePr.isLoading()) {
                        PersonListActivity.this.ePr.startLoadData();
                    }
                    PersonListActivity.this.csl();
                }
            }
        });
        this.jdv.setOnScrollListener(this.mOnScrollListener);
        this.jdJ.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void qd(boolean z2) {
                if (z2) {
                    PersonListActivity.this.bJo();
                } else if (PersonListActivity.this.jdK != null) {
                    PersonListActivity.this.jdK.ED();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void uA(int i) {
                PersonListActivity.this.jdv.setSelection(0);
                PersonListActivity.this.mModel.pa(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.aNT().getInt(SharedPrefConfig.KEY_MY_CONCERNED_PERSON_TIP, 0) < 2 && z && this.mModel.bqg()) {
            this.jdJ.csg();
        }
        this.jdJ.setVisibility(8);
        this.jdz.setVisibility(8);
        this.ePr = new PbListView(getActivity());
        this.ePr.getView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setLineGone();
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePr.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.jdv.setNextPage(this.ePr);
    }

    private void csk() {
        this.jdz = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.jdz.setVisibility(8);
        this.jdz.setClickable(false);
        this.jdz.setEnabled(false);
        this.jdA = (TextView) this.jdz.findViewById(R.id.person_list_title);
        this.jdv.addHeaderView(this.jdz, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJo() {
        if (this.jdK == null) {
            this.jdK = new com.baidu.tieba.c.d(getPageContext(), this.jdJ.jdc);
            this.jdK.cz(R.drawable.bg_tip_blue_up);
            this.jdK.setMaxShowTime(2);
            this.jdK.cA(3000);
            this.jdK.rS(-10);
            this.jdK.setYOffset(-16);
            this.jdK.c(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.jdK != null) {
                        PersonListActivity.this.jdK.ED();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(av avVar, boolean z) {
        if (this.mModel != null && avVar != null && (!z || !this.jdD)) {
            if (!z) {
                this.jdD = true;
                d(avVar);
            }
            b(avVar);
            d(avVar, z);
            if (!this.mModel.bqg()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aTe().setMsgFans(0);
            }
            b(avVar, z);
        }
    }

    private void b(av avVar) {
        if (avVar != null) {
            if (!avVar.hasMore && !StringUtils.isNull(avVar.dpF) && !this.jdG) {
                bq(avVar.dpF, avVar.type);
                this.jdv.removeFooterView(this.jdL);
                this.jdv.addFooterView(this.jdL);
                this.jdv.removeFooterView(this.ePr.getView());
                TiebaStatic.log(new an("c13106").af("obj_locate", 2));
            } else if (!avVar.hasMore) {
                this.jdv.removeFooterView(this.jdL);
                this.ePr.setText(getString(R.string.no_more_data_tip));
                this.ePr.endLoadData();
            } else {
                this.jdv.removeFooterView(this.jdL);
                this.ePr.setText(getString(R.string.pb_load_more));
                this.ePr.endLoadData();
            }
        }
    }

    private void b(av avVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (avVar.dpE > 0 && !v.isEmpty(avVar.aJB())) {
                c(avVar);
            } else {
                c(avVar, z);
            }
        }
    }

    private void c(av avVar) {
        String string;
        String string2;
        boolean z;
        TextView textView;
        String str;
        String str2;
        String string3;
        String string4;
        if (avVar != null) {
            this.jdv.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bqg()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.jdw.setVisibility(0);
                    this.jdv.removeHeaderView(this.jdz);
                    TextView textView2 = this.jdy;
                    textView2.setVisibility(0);
                    this.jdJ.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    String string5 = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(null, getResources().getString(R.string.not_have_attention)));
                    z = false;
                    str = string4;
                    textView = textView2;
                    str2 = string5;
                } else {
                    this.jdw.setVisibility(8);
                    this.jdz.setVisibility(0);
                    TextView textView3 = this.jdA;
                    textView3.setVisibility(8);
                    this.jdJ.setVisibility(8);
                    if (this.fqT == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.fqT == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(null, getResources().getString(R.string.not_have_attention_guest)));
                    String string6 = getPageContext().getString(R.string.person);
                    str = string3;
                    textView = textView3;
                    z = v.isEmpty(avVar.aJC()) ? false : true;
                    str2 = string6;
                }
            } else {
                this.jdw.setVisibility(8);
                this.jdz.setVisibility(0);
                TextView textView4 = this.jdA;
                this.jdJ.setVisibility(8);
                textView4.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    String string7 = getPageContext().getString(R.string.my_fans_prefix);
                    String string8 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(null, getResources().getString(R.string.not_have_fans)));
                    z = false;
                    textView = textView4;
                    str = string7;
                    str2 = string8;
                } else {
                    if (this.fqT == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.fqT == 1) {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(null, getResources().getString(R.string.her_no_fan_guest)));
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
            textView.setText(str + aq.numberUniformFormat(avVar.dpE) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(av avVar, boolean z) {
        String string;
        this.jdv.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bqg()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.jdJ.setVisibility(0);
                this.jdy.setVisibility(0);
                this.jdw.setVisibility(0);
                this.jdz.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.jdy.setText(string + 0 + string2);
                return;
            }
            this.jdJ.setVisibility(8);
            this.jdy.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.jdJ.setVisibility(8);
        this.jdy.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (avVar != null && !StringUtils.isNull(avVar.dpF) && !this.jdG) {
                this.mNoDataView.getSuTextView().setText(br(avVar.dpF, avVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new an("c13106").af("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(null, getResources().getString(R.string.not_have_fans)));
            return;
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(null, getResources().getString(R.string.her_no_fan_guest)));
    }

    private void d(av avVar) {
        this.mModel.setPage(avVar.pageNum);
    }

    private void d(av avVar, boolean z) {
        if (this.jdB != null) {
            if (!z) {
                if (avVar.pageNum == 1) {
                    this.jdB.resetData();
                }
                this.jdB.setHasMore(avVar.hasMore);
                this.jdB.a(avVar);
                this.jdB.bqe();
                this.jdB.notifyDataSetChanged();
                return;
            }
            this.jdB.setHasMore(false);
            this.jdB.a(avVar);
            this.jdB.bqe();
            this.jdB.notifyDataSetChanged();
        }
    }

    private void bqk() {
        showLoadingView(this.mContainer);
        this.mModel.bqh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csl() {
        if (this.jdB != null) {
            this.jdB.notifyDataSetChanged();
        }
        this.mModel.bqh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csm() {
        UserData userData;
        if (this.jdB != null && this.jdB.getItemViewType(this.jdI) == 0 && (userData = (UserData) this.jdB.getItem(this.jdI)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            csm();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jdJ.csh()) {
                this.jdJ.closeView();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bq(String str, int i) {
        if (this.jdL == null) {
            this.jdL = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.jdM = (TextView) this.jdL.findViewById(R.id.view_forbidden_tip);
            am.setViewTextColor(this.jdM, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.jdL, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.jdL.setVisibility(8);
            return;
        }
        this.jdM.setText(br(str, i));
        this.jdM.setMovementMethod(LinkMovementMethod.getInstance());
        this.jdM.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private SpannableStringBuilder br(String str, int i) {
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
                    PersonListActivity.this.cso();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.csn();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csn() {
        TiebaStatic.log(new an("c13104").af("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.jdN.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cso() {
        TiebaStatic.log(new an("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
