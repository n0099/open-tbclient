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
    private PbListView ePm;
    private NavigationBarCoverTip gTh;
    private TextView gTm;
    private NavigationBarShadowView jdA;
    private NavigationBarShadowView jdB;
    private ConcernSelectView jdF;
    private com.baidu.tieba.c.d jdG;
    private View jdH;
    private TextView jdI;
    private e jdJ;
    private boolean jdz;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView jdr = null;
    private View jds = null;
    private View jdt = null;
    private TextView jdu = null;
    private View jdv = null;
    private TextView jdw = null;
    private b jdx = null;
    private NoPressedRelativeLayout jdy = null;
    private boolean gdO = true;
    private TextView aWP = null;
    private int fqO = 0;
    private boolean jdC = false;
    private int jdD = 0;
    int jdE = 0;
    private final AntiHelper.a gZw = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener gZx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().dOo != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().dOo, PersonListActivity.this.gZw) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener jdK = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.jdx.eX(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.jdx.bqg();
                    PersonListActivity.this.jdx.notifyDataSetChanged();
                }
                if (PersonListActivity.this.jdx.fqE) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bqi()) {
                        PersonListActivity.this.jdA.show();
                    } else {
                        PersonListActivity.this.jdB.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bqi()) {
                    PersonListActivity.this.jdA.hide();
                } else {
                    PersonListActivity.this.jdB.hide();
                }
            }
        }
    };
    public PersonListModel.a jdL = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
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
            if (avVar != null && avVar.dpA != PersonListActivity.this.jdD && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bqi() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.GT(PersonListActivity.this.mPortrait);
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
        this.jdJ = new e(getPageContext(), getUniqueId());
        this.jdJ.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.gTm == null) {
                            PersonListActivity.this.gTm = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.gTm.setGravity(19);
                            PersonListActivity.this.gTm.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.gTm.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.gTm.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.gTm.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        PersonListActivity.this.gTm.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.gTh.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.gTh.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.gTh.a(PersonListActivity.this.getActivity(), PersonListActivity.this.gTm, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.jdI.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    am.setViewTextColor(PersonListActivity.this.jdI, (int) R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bMP() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.gZx);
        registerListener(this.jdK);
        this.mModel.bkZ();
        if (this.gdO) {
            this.gdO = false;
            bqm();
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
        am.setBackgroundResource(this.jdy, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.mContainer, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.jdx != null) {
            this.jdx.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.jdF.onChangeSkinType(i);
        am.setBackgroundColor(this.jdu, R.color.cp_bg_line_d);
        am.setViewTextColor(this.jdu, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.jdw, R.color.cp_bg_line_d);
        am.setViewTextColor(this.jdw, (int) R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.jdt != null) {
            getLayoutMode().onModeChanged(this.jdt);
        }
        if (this.jdv != null) {
            getLayoutMode().onModeChanged(this.jdv);
        }
        if (this.jdH != null) {
            am.setViewTextColor(this.jdI, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.jdH, R.color.cp_bg_line_d);
        }
        this.jdJ.onChangeSkinType();
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_d));
        this.ePm.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jdx != null) {
            this.jdx = null;
        }
        if (this.jdG != null) {
            this.jdG.EE();
        }
        this.gTh.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.jdL);
        if (bundle != null) {
            this.mModel.jM(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fqO = bundle.getInt("user_sex");
            this.jdC = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.jdD = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.fqO);
            return;
        }
        Intent intent = getIntent();
        this.mModel.jM(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fqO = intent.getIntExtra("user_sex", 0);
        this.jdC = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.jdD = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.fqO);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bqi());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.fqO);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.jdC);
    }

    private void initUI() {
        boolean z = true;
        this.jdy = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.aWP = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jdA = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.jdB = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.jds = findViewById(R.id.sub_title_root);
        this.jdt = this.jds.findViewById(R.id.newheader_root);
        this.jds.setVisibility(8);
        this.jds.setClickable(false);
        this.jds.setEnabled(false);
        this.jdu = (TextView) this.jds.findViewById(R.id.person_list_title);
        this.jdF = (ConcernSelectView) findViewById(R.id.select_layout);
        this.gTh = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bqi()) {
                this.aWP.setText(R.string.my_attention);
                this.jdy.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void p(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.jdF.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.jdF.csk() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.jdy.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.jdF.closeView();
                        PersonListActivity.this.jdy.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.aWP.setText(R.string.fans);
            }
        } else if (this.mModel.bqi()) {
            if (this.fqO == 2) {
                this.aWP.setText(R.string.her_attention_people);
            } else if (this.fqO == 1) {
                this.aWP.setText(R.string.his_attention_people);
            } else {
                this.aWP.setText(R.string.its_attention_people);
            }
        } else if (this.fqO == 2) {
            this.aWP.setText(R.string.attention_to_her);
        } else if (this.fqO == 1) {
            this.aWP.setText(R.string.attention_to_him);
        } else {
            this.aWP.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.jdx != null && PersonListActivity.this.jdx.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.jdx.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bqi()) {
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
                PersonListActivity.this.jdE = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.csp();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.cso();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.jdx = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.jds.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.jdy, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.jdx = new c(this, z, sex, onClickListener, onClickListener3);
            this.jds.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.jdy, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.jdr = (BdListView) findViewById(R.id.list);
        this.jdr.setAdapter((ListAdapter) this.jdx);
        csn();
        this.jdr.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.jdx != null && PersonListActivity.this.jdx.isHasMore()) {
                    if (PersonListActivity.this.ePm != null && !PersonListActivity.this.ePm.isLoading()) {
                        PersonListActivity.this.ePm.startLoadData();
                    }
                    PersonListActivity.this.cso();
                }
            }
        });
        this.jdr.setOnScrollListener(this.mOnScrollListener);
        this.jdF.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void qd(boolean z2) {
                if (z2) {
                    PersonListActivity.this.bJq();
                } else if (PersonListActivity.this.jdG != null) {
                    PersonListActivity.this.jdG.EE();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void uA(int i) {
                PersonListActivity.this.jdr.setSelection(0);
                PersonListActivity.this.mModel.pa(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.aNV().getInt(SharedPrefConfig.KEY_MY_CONCERNED_PERSON_TIP, 0) < 2 && z && this.mModel.bqi()) {
            this.jdF.csj();
        }
        this.jdF.setVisibility(8);
        this.jdv.setVisibility(8);
        this.ePm = new PbListView(getActivity());
        this.ePm.getView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setLineGone();
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePm.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.jdr.setNextPage(this.ePm);
    }

    private void csn() {
        this.jdv = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.jdv.setVisibility(8);
        this.jdv.setClickable(false);
        this.jdv.setEnabled(false);
        this.jdw = (TextView) this.jdv.findViewById(R.id.person_list_title);
        this.jdr.addHeaderView(this.jdv, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJq() {
        if (this.jdG == null) {
            this.jdG = new com.baidu.tieba.c.d(getPageContext(), this.jdF.jcY);
            this.jdG.cz(R.drawable.bg_tip_blue_up);
            this.jdG.setMaxShowTime(2);
            this.jdG.cA(3000);
            this.jdG.rS(-10);
            this.jdG.setYOffset(-16);
            this.jdG.c(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.jdG != null) {
                        PersonListActivity.this.jdG.EE();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(av avVar, boolean z) {
        if (this.mModel != null && avVar != null && (!z || !this.jdz)) {
            if (!z) {
                this.jdz = true;
                d(avVar);
            }
            b(avVar);
            d(avVar, z);
            if (!this.mModel.bqi()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aTg().setMsgFans(0);
            }
            b(avVar, z);
        }
    }

    private void b(av avVar) {
        if (avVar != null) {
            if (!avVar.hasMore && !StringUtils.isNull(avVar.dpB) && !this.jdC) {
                bq(avVar.dpB, avVar.type);
                this.jdr.removeFooterView(this.jdH);
                this.jdr.addFooterView(this.jdH);
                this.jdr.removeFooterView(this.ePm.getView());
                TiebaStatic.log(new an("c13106").af("obj_locate", 2));
            } else if (!avVar.hasMore) {
                this.jdr.removeFooterView(this.jdH);
                this.ePm.setText(getString(R.string.no_more_data_tip));
                this.ePm.endLoadData();
            } else {
                this.jdr.removeFooterView(this.jdH);
                this.ePm.setText(getString(R.string.pb_load_more));
                this.ePm.endLoadData();
            }
        }
    }

    private void b(av avVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (avVar.dpA > 0 && !v.isEmpty(avVar.aJD())) {
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
            this.jdr.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bqi()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.jds.setVisibility(0);
                    this.jdr.removeHeaderView(this.jdv);
                    TextView textView2 = this.jdu;
                    textView2.setVisibility(0);
                    this.jdF.setVisibility(0);
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
                    this.jds.setVisibility(8);
                    this.jdv.setVisibility(0);
                    TextView textView3 = this.jdw;
                    textView3.setVisibility(8);
                    this.jdF.setVisibility(8);
                    if (this.fqO == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.fqO == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(null, getResources().getString(R.string.not_have_attention_guest)));
                    String string6 = getPageContext().getString(R.string.person);
                    str = string3;
                    textView = textView3;
                    z = v.isEmpty(avVar.aJE()) ? false : true;
                    str2 = string6;
                }
            } else {
                this.jds.setVisibility(8);
                this.jdv.setVisibility(0);
                TextView textView4 = this.jdw;
                this.jdF.setVisibility(8);
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
                    if (this.fqO == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.fqO == 1) {
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
            textView.setText(str + aq.numberUniformFormat(avVar.dpA) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(av avVar, boolean z) {
        String string;
        this.jdr.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bqi()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.jdF.setVisibility(0);
                this.jdu.setVisibility(0);
                this.jds.setVisibility(0);
                this.jdv.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.jdu.setText(string + 0 + string2);
                return;
            }
            this.jdF.setVisibility(8);
            this.jdu.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.jdF.setVisibility(8);
        this.jdu.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (avVar != null && !StringUtils.isNull(avVar.dpB) && !this.jdC) {
                this.mNoDataView.getSuTextView().setText(br(avVar.dpB, avVar.type));
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
        if (this.jdx != null) {
            if (!z) {
                if (avVar.pageNum == 1) {
                    this.jdx.resetData();
                }
                this.jdx.setHasMore(avVar.hasMore);
                this.jdx.a(avVar);
                this.jdx.bqg();
                this.jdx.notifyDataSetChanged();
                return;
            }
            this.jdx.setHasMore(false);
            this.jdx.a(avVar);
            this.jdx.bqg();
            this.jdx.notifyDataSetChanged();
        }
    }

    private void bqm() {
        showLoadingView(this.mContainer);
        this.mModel.bqj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cso() {
        if (this.jdx != null) {
            this.jdx.notifyDataSetChanged();
        }
        this.mModel.bqj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csp() {
        UserData userData;
        if (this.jdx != null && this.jdx.getItemViewType(this.jdE) == 0 && (userData = (UserData) this.jdx.getItem(this.jdE)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            csp();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jdF.csk()) {
                this.jdF.closeView();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bq(String str, int i) {
        if (this.jdH == null) {
            this.jdH = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.jdI = (TextView) this.jdH.findViewById(R.id.view_forbidden_tip);
            am.setViewTextColor(this.jdI, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.jdH, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.jdH.setVisibility(8);
            return;
        }
        this.jdI.setText(br(str, i));
        this.jdI.setMovementMethod(LinkMovementMethod.getInstance());
        this.jdI.setHighlightColor(getResources().getColor(R.color.transparent));
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
                    PersonListActivity.this.csr();
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
                    PersonListActivity.this.csq();
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
    public void csq() {
        TiebaStatic.log(new an("c13104").af("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.jdJ.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csr() {
        TiebaStatic.log(new an("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
