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
/* loaded from: classes7.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView egU;
    private NavigationBarCoverTip gdS;
    private TextView gdX;
    private boolean imf;
    private NavigationBarShadowView imh;
    private NavigationBarShadowView imi;
    private ConcernSelectView imm;
    private com.baidu.tieba.c.d imn;
    private View imo;
    private TextView imp;
    private e imq;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView ilX = null;
    private View ilY = null;
    private View ilZ = null;
    private TextView ima = null;
    private View imb = null;
    private TextView imc = null;
    private b imd = null;
    private NoPressedRelativeLayout ime = null;
    private boolean fsL = true;
    private TextView axT = null;
    private int eGI = 0;
    private boolean imj = false;
    private int imk = 0;
    int iml = 0;
    private final AntiHelper.a gkg = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener gkh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().djy != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().djy, PersonListActivity.this.gkg) != null) {
                            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener imr = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.imd.eh(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.imd.bec();
                    PersonListActivity.this.imd.notifyDataSetChanged();
                }
                if (PersonListActivity.this.imd.eGy) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bee()) {
                        PersonListActivity.this.imh.show();
                    } else {
                        PersonListActivity.this.imi.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bee()) {
                    PersonListActivity.this.imh.hide();
                } else {
                    PersonListActivity.this.imi.hide();
                }
            }
        }
    };
    public PersonListModel.a ims = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void Y(String str, boolean z) {
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
            if (avVar != null && avVar.cLS != PersonListActivity.this.imk && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bee()) {
                PersonListActivity.this.mModel.EM(PersonListActivity.this.mPortrait);
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
        this.imq = new e(getPageContext(), getUniqueId());
        this.imq.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.gdX == null) {
                            PersonListActivity.this.gdX = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.gdX.setGravity(19);
                            PersonListActivity.this.gdX.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.gdX.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.gdX.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.gdX.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        PersonListActivity.this.gdX.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.gdS.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.gdS.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.gdS.a(PersonListActivity.this.getActivity(), PersonListActivity.this.gdX, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.imp.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    am.setViewTextColor(PersonListActivity.this.imp, (int) R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bzC() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.gkh);
        registerListener(this.imr);
        this.mModel.aZq();
        if (this.fsL) {
            this.fsL = false;
            bei();
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
        am.setBackgroundResource(this.ime, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.mContainer, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.imd != null) {
            this.imd.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.imm.onChangeSkinType(i);
        am.setBackgroundColor(this.ima, R.color.cp_bg_line_d);
        am.setViewTextColor(this.ima, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.imc, R.color.cp_bg_line_d);
        am.setViewTextColor(this.imc, (int) R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.ilZ != null) {
            getLayoutMode().onModeChanged(this.ilZ);
        }
        if (this.imb != null) {
            getLayoutMode().onModeChanged(this.imb);
        }
        if (this.imo != null) {
            am.setViewTextColor(this.imp, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.imo, R.color.cp_bg_line_d);
        }
        this.imq.onChangeSkinType();
        this.egU.setTextColor(am.getColor(R.color.cp_cont_d));
        this.egU.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.imd != null) {
            this.imd = null;
        }
        if (this.imn != null) {
            this.imn.wP();
        }
        this.gdS.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.ims);
        if (bundle != null) {
            this.mModel.is(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.eGI = bundle.getInt("user_sex");
            this.imj = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.imk = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.eGI);
            return;
        }
        Intent intent = getIntent();
        this.mModel.is(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.eGI = intent.getIntExtra("user_sex", 0);
        this.imj = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.imk = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.eGI);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bee());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.eGI);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.imj);
    }

    private void initUI() {
        boolean z = true;
        this.ime = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.axT = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.imh = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.imi = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.ilY = findViewById(R.id.sub_title_root);
        this.ilZ = this.ilY.findViewById(R.id.newheader_root);
        this.ilY.setVisibility(8);
        this.ilY.setClickable(false);
        this.ilY.setEnabled(false);
        this.ima = (TextView) this.ilY.findViewById(R.id.person_list_title);
        this.imm = (ConcernSelectView) findViewById(R.id.select_layout);
        this.gdS = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bee()) {
                this.axT.setText(R.string.my_attention);
                this.ime.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void q(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.imm.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.imm.cet() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.ime.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.imm.ces();
                        PersonListActivity.this.ime.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.axT.setText(R.string.fans);
            }
        } else if (this.mModel.bee()) {
            if (this.eGI == 2) {
                this.axT.setText(R.string.her_attention_people);
            } else if (this.eGI == 1) {
                this.axT.setText(R.string.his_attention_people);
            } else {
                this.axT.setText(R.string.its_attention_people);
            }
        } else if (this.eGI == 2) {
            this.axT.setText(R.string.attention_to_her);
        } else if (this.eGI == 1) {
            this.axT.setText(R.string.attention_to_him);
        } else {
            this.axT.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.imd != null && PersonListActivity.this.imd.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.imd.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bee()) {
                            TiebaStatic.log(new an("c12772").cp("obj_locate", "1").cp("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new an("c12605").Z("obj_locate", 1).cp("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.iml = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.cey();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.cex();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.imd = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.ilY.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.ime, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.imd = new c(this, z, sex, onClickListener, onClickListener3);
            this.ilY.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.ime, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.ilX = (BdListView) findViewById(R.id.list);
        this.ilX.setAdapter((ListAdapter) this.imd);
        cew();
        this.ilX.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.imd != null && PersonListActivity.this.imd.isHasMore()) {
                    if (PersonListActivity.this.egU != null && !PersonListActivity.this.egU.isLoading()) {
                        PersonListActivity.this.egU.startLoadData();
                    }
                    PersonListActivity.this.cex();
                }
            }
        });
        this.ilX.setOnScrollListener(this.mOnScrollListener);
        this.imm.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void oE(boolean z2) {
                if (z2) {
                    PersonListActivity.this.bwB();
                } else if (PersonListActivity.this.imn != null) {
                    PersonListActivity.this.imn.wP();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void tM(int i) {
                PersonListActivity.this.ilX.setSelection(0);
                PersonListActivity.this.mModel.oo(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.aCY().getInt(SharedPrefConfig.KEY_MY_CONCERNED_PERSON_TIP, 0) < 2 && z && this.mModel.bee()) {
            this.imm.cer();
        }
        this.imm.setVisibility(8);
        this.imb.setVisibility(8);
        this.egU = new PbListView(getActivity());
        this.egU.getView();
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.egU.setLineGone();
        this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
        this.egU.setTextSize(R.dimen.tbfontsize33);
        this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
        this.egU.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.ilX.setNextPage(this.egU);
    }

    private void cew() {
        this.imb = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.imb.setVisibility(8);
        this.imb.setClickable(false);
        this.imb.setEnabled(false);
        this.imc = (TextView) this.imb.findViewById(R.id.person_list_title);
        this.ilX.addHeaderView(this.imb, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwB() {
        if (this.imn == null) {
            this.imn = new com.baidu.tieba.c.d(getPageContext(), this.imm.ilE);
            this.imn.bT(R.drawable.bg_tip_blue_up);
            this.imn.rm(2);
            this.imn.bU(3000);
            this.imn.rn(-10);
            this.imn.setYOffset(-16);
            this.imn.c(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.imn != null) {
                        PersonListActivity.this.imn.wP();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(av avVar, boolean z) {
        if (this.mModel != null && avVar != null && (!z || !this.imf)) {
            if (!z) {
                this.imf = true;
                d(avVar);
            }
            b(avVar);
            d(avVar, z);
            if (!this.mModel.bee()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aHP().setMsgFans(0);
            }
            b(avVar, z);
        }
    }

    private void b(av avVar) {
        if (avVar != null) {
            if (!avVar.hasMore && !StringUtils.isNull(avVar.cLT) && !this.imj) {
                bh(avVar.cLT, avVar.type);
                this.ilX.removeFooterView(this.imo);
                this.ilX.addFooterView(this.imo);
                this.ilX.removeFooterView(this.egU.getView());
                TiebaStatic.log(new an("c13106").Z("obj_locate", 2));
            } else if (!avVar.hasMore) {
                this.ilX.removeFooterView(this.imo);
                this.egU.setText(getString(R.string.no_more_data_tip));
                this.egU.endLoadData();
            } else {
                this.ilX.removeFooterView(this.imo);
                this.egU.setText(getString(R.string.pb_load_more));
                this.egU.endLoadData();
            }
        }
    }

    private void b(av avVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (avVar.cLS > 0 && !v.isEmpty(avVar.ayB())) {
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
            this.ilX.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bee()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.ilY.setVisibility(0);
                    this.ilX.removeHeaderView(this.imb);
                    TextView textView2 = this.ima;
                    textView2.setVisibility(0);
                    this.imm.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    String string5 = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cr(null, getResources().getString(R.string.not_have_attention)));
                    z = false;
                    str = string4;
                    textView = textView2;
                    str2 = string5;
                } else {
                    this.ilY.setVisibility(8);
                    this.imb.setVisibility(0);
                    TextView textView3 = this.imc;
                    textView3.setVisibility(8);
                    this.imm.setVisibility(8);
                    if (this.eGI == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.eGI == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cr(null, getResources().getString(R.string.not_have_attention_guest)));
                    String string6 = getPageContext().getString(R.string.person);
                    str = string3;
                    textView = textView3;
                    z = v.isEmpty(avVar.ayC()) ? false : true;
                    str2 = string6;
                }
            } else {
                this.ilY.setVisibility(8);
                this.imb.setVisibility(0);
                TextView textView4 = this.imc;
                this.imm.setVisibility(8);
                textView4.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    String string7 = getPageContext().getString(R.string.my_fans_prefix);
                    String string8 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cr(null, getResources().getString(R.string.not_have_fans)));
                    z = false;
                    textView = textView4;
                    str = string7;
                    str2 = string8;
                } else {
                    if (this.eGI == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.eGI == 1) {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cr(null, getResources().getString(R.string.her_no_fan_guest)));
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
            textView.setText(str + aq.numberUniformFormat(avVar.cLS) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(av avVar, boolean z) {
        String string;
        this.ilX.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bee()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.imm.setVisibility(0);
                this.ima.setVisibility(0);
                this.ilY.setVisibility(0);
                this.imb.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cr(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.ima.setText(string + 0 + string2);
                return;
            }
            this.imm.setVisibility(8);
            this.ima.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cr(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.imm.setVisibility(8);
        this.ima.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (avVar != null && !StringUtils.isNull(avVar.cLT) && !this.imj) {
                this.mNoDataView.getSuTextView().setText(bi(avVar.cLT, avVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new an("c13106").Z("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cr(null, getResources().getString(R.string.not_have_fans)));
            return;
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cr(null, getResources().getString(R.string.her_no_fan_guest)));
    }

    private void d(av avVar) {
        this.mModel.setPage(avVar.pageNum);
    }

    private void d(av avVar, boolean z) {
        if (this.imd != null) {
            if (!z) {
                if (avVar.pageNum == 1) {
                    this.imd.resetData();
                }
                this.imd.setHasMore(avVar.hasMore);
                this.imd.a(avVar);
                this.imd.bec();
                this.imd.notifyDataSetChanged();
                return;
            }
            this.imd.setHasMore(false);
            this.imd.a(avVar);
            this.imd.bec();
            this.imd.notifyDataSetChanged();
        }
    }

    private void bei() {
        showLoadingView(this.mContainer);
        this.mModel.bef();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cex() {
        if (this.imd != null) {
            this.imd.notifyDataSetChanged();
        }
        this.mModel.bef();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cey() {
        UserData userData;
        if (this.imd != null && this.imd.getItemViewType(this.iml) == 0 && (userData = (UserData) this.imd.getItem(this.iml)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            cey();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.imm.cet()) {
                this.imm.ces();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bh(String str, int i) {
        if (this.imo == null) {
            this.imo = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.imp = (TextView) this.imo.findViewById(R.id.view_forbidden_tip);
            am.setViewTextColor(this.imp, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.imo, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.imo.setVisibility(8);
            return;
        }
        this.imp.setText(bi(str, i));
        this.imp.setMovementMethod(LinkMovementMethod.getInstance());
        this.imp.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private SpannableStringBuilder bi(String str, int i) {
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
                    PersonListActivity.this.ceA();
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
                    PersonListActivity.this.cez();
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
    public void cez() {
        TiebaStatic.log(new an("c13104").Z("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.imq.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceA() {
        TiebaStatic.log(new an("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
