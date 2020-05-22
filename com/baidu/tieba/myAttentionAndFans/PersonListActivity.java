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
    private PbListView fbY;
    private NavigationBarCoverTip hhY;
    private TextView hie;
    private boolean jsG;
    private NavigationBarShadowView jsH;
    private NavigationBarShadowView jsI;
    private ConcernSelectView jsM;
    private com.baidu.tieba.c.d jsN;
    private View jsO;
    private TextView jsP;
    private e jsQ;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView jsy = null;
    private View jsz = null;
    private View jsA = null;
    private TextView jsB = null;
    private View jsC = null;
    private TextView jsD = null;
    private b jsE = null;
    private NoPressedRelativeLayout jsF = null;
    private boolean fWP = true;
    private TextView bem = null;
    private int fEN = 0;
    private boolean jsJ = false;
    private int jsK = 0;
    int jsL = 0;
    private final AntiHelper.a hoq = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener hor = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().ecK != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().ecK, PersonListActivity.this.hoq) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener jsR = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.jsE.eY(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.jsE.bvW();
                    PersonListActivity.this.jsE.notifyDataSetChanged();
                }
                if (PersonListActivity.this.jsE.fED) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bvY()) {
                        PersonListActivity.this.jsH.show();
                    } else {
                        PersonListActivity.this.jsI.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bvY()) {
                    PersonListActivity.this.jsH.hide();
                } else {
                    PersonListActivity.this.jsI.hide();
                }
            }
        }
    };
    public PersonListModel.a jsS = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void ar(String str, boolean z) {
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
            if (avVar != null && avVar.dDD != PersonListActivity.this.jsK && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bvY() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.IF(PersonListActivity.this.mPortrait);
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
        this.jsQ = new e(getPageContext(), getUniqueId());
        this.jsQ.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.hie == null) {
                            PersonListActivity.this.hie = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.hie.setGravity(19);
                            PersonListActivity.this.hie.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.hie.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.hie.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.hie.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        PersonListActivity.this.hie.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.hhY.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.hhY.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.hhY.a(PersonListActivity.this.getActivity(), PersonListActivity.this.hie, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.jsP.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    am.setViewTextColor(PersonListActivity.this.jsP, (int) R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bTj() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.hor);
        registerListener(this.jsR);
        this.mModel.bqt();
        if (this.fWP) {
            this.fWP = false;
            bwc();
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
        am.setBackgroundResource(this.jsF, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.mContainer, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.jsE != null) {
            this.jsE.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.jsM.onChangeSkinType(i);
        am.setBackgroundColor(this.jsB, R.color.cp_bg_line_d);
        am.setViewTextColor(this.jsB, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.jsD, R.color.cp_bg_line_d);
        am.setViewTextColor(this.jsD, (int) R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.jsA != null) {
            getLayoutMode().onModeChanged(this.jsA);
        }
        if (this.jsC != null) {
            getLayoutMode().onModeChanged(this.jsC);
        }
        if (this.jsO != null) {
            am.setViewTextColor(this.jsP, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.jsO, R.color.cp_bg_line_d);
        }
        this.jsQ.onChangeSkinType();
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_d));
        this.fbY.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jsE != null) {
            this.jsE = null;
        }
        if (this.jsN != null) {
            this.jsN.Gu();
        }
        this.hhY.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.jsS);
        if (bundle != null) {
            this.mModel.kf(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fEN = bundle.getInt("user_sex");
            this.jsJ = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.jsK = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.fEN);
            return;
        }
        Intent intent = getIntent();
        this.mModel.kf(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fEN = intent.getIntExtra("user_sex", 0);
        this.jsJ = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.jsK = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.fEN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bvY());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.fEN);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.jsJ);
    }

    private void initUI() {
        boolean z = true;
        this.jsF = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bem = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jsH = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.jsI = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.jsz = findViewById(R.id.sub_title_root);
        this.jsA = this.jsz.findViewById(R.id.newheader_root);
        this.jsz.setVisibility(8);
        this.jsz.setClickable(false);
        this.jsz.setEnabled(false);
        this.jsB = (TextView) this.jsz.findViewById(R.id.person_list_title);
        this.jsM = (ConcernSelectView) findViewById(R.id.select_layout);
        this.hhY = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bvY()) {
                this.bem.setText(R.string.my_attention);
                this.jsF.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void p(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.jsM.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.jsM.cyK() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.jsF.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.jsM.closeView();
                        PersonListActivity.this.jsF.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.bem.setText(R.string.fans);
            }
        } else if (this.mModel.bvY()) {
            if (this.fEN == 2) {
                this.bem.setText(R.string.her_attention_people);
            } else if (this.fEN == 1) {
                this.bem.setText(R.string.his_attention_people);
            } else {
                this.bem.setText(R.string.its_attention_people);
            }
        } else if (this.fEN == 2) {
            this.bem.setText(R.string.attention_to_her);
        } else if (this.fEN == 1) {
            this.bem.setText(R.string.attention_to_him);
        } else {
            this.bem.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.jsE != null && PersonListActivity.this.jsE.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.jsE.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bvY()) {
                            TiebaStatic.log(new an("c12772").dh("obj_locate", "1").dh("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new an("c12605").ag("obj_locate", 1).dh("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.jsL = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.cyP();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.cyO();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.jsE = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.jsz.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.jsF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.jsE = new c(this, z, sex, onClickListener, onClickListener3);
            this.jsz.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.jsF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.jsy = (BdListView) findViewById(R.id.list);
        this.jsy.setAdapter((ListAdapter) this.jsE);
        cyN();
        this.jsy.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.jsE != null && PersonListActivity.this.jsE.isHasMore()) {
                    if (PersonListActivity.this.fbY != null && !PersonListActivity.this.fbY.isLoading()) {
                        PersonListActivity.this.fbY.startLoadData();
                    }
                    PersonListActivity.this.cyO();
                }
            }
        });
        this.jsy.setOnScrollListener(this.mOnScrollListener);
        this.jsM.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void qA(boolean z2) {
                if (z2) {
                    PersonListActivity.this.bPI();
                } else if (PersonListActivity.this.jsN != null) {
                    PersonListActivity.this.jsN.Gu();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void vg(int i) {
                PersonListActivity.this.jsy.setSelection(0);
                PersonListActivity.this.mModel.pB(i);
            }
        });
        this.jsM.setVisibility(8);
        this.jsC.setVisibility(8);
        this.fbY = new PbListView(getActivity());
        this.fbY.getView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setLineGone();
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fbY.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.jsy.setNextPage(this.fbY);
    }

    private void cyN() {
        this.jsC = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.jsC.setVisibility(8);
        this.jsC.setClickable(false);
        this.jsC.setEnabled(false);
        this.jsD = (TextView) this.jsC.findViewById(R.id.person_list_title);
        this.jsy.addHeaderView(this.jsC, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPI() {
        if (this.jsN == null) {
            this.jsN = new com.baidu.tieba.c.d(getPageContext(), this.jsM.jsf);
            this.jsN.cG(R.drawable.bg_tip_blue_up);
            this.jsN.setMaxShowTime(2);
            this.jsN.cH(3000);
            this.jsN.sx(-10);
            this.jsN.setYOffset(-16);
            this.jsN.c(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.jsN != null) {
                        PersonListActivity.this.jsN.Gu();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(av avVar, boolean z) {
        if (this.mModel != null && avVar != null && (!z || !this.jsG)) {
            if (!z) {
                this.jsG = true;
                d(avVar);
            }
            b(avVar);
            d(avVar, z);
            if (!this.mModel.bvY()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aZl().setMsgFans(0);
            }
            b(avVar, z);
        }
    }

    private void b(av avVar) {
        if (avVar != null) {
            if (!avVar.hasMore && !StringUtils.isNull(avVar.dDE) && !this.jsJ) {
                br(avVar.dDE, avVar.type);
                this.jsy.removeFooterView(this.jsO);
                this.jsy.addFooterView(this.jsO);
                this.jsy.removeFooterView(this.fbY.getView());
                TiebaStatic.log(new an("c13106").ag("obj_locate", 2));
            } else if (!avVar.hasMore) {
                this.jsy.removeFooterView(this.jsO);
                this.fbY.setText(getString(R.string.no_more_data_tip));
                this.fbY.endLoadData();
            } else {
                this.jsy.removeFooterView(this.jsO);
                this.fbY.setText(getString(R.string.pb_load_more));
                this.fbY.endLoadData();
            }
        }
    }

    private void b(av avVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (avVar.dDD > 0 && !v.isEmpty(avVar.aPw())) {
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
            this.jsy.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bvY()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.jsz.setVisibility(0);
                    this.jsy.removeHeaderView(this.jsC);
                    TextView textView2 = this.jsB;
                    textView2.setVisibility(0);
                    this.jsM.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    String string5 = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, getResources().getString(R.string.not_have_attention)));
                    z = false;
                    str = string4;
                    textView = textView2;
                    str2 = string5;
                } else {
                    this.jsz.setVisibility(8);
                    this.jsC.setVisibility(0);
                    TextView textView3 = this.jsD;
                    textView3.setVisibility(8);
                    this.jsM.setVisibility(8);
                    if (this.fEN == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.fEN == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, getResources().getString(R.string.not_have_attention_guest)));
                    String string6 = getPageContext().getString(R.string.person);
                    str = string3;
                    textView = textView3;
                    z = v.isEmpty(avVar.aPx()) ? false : true;
                    str2 = string6;
                }
            } else {
                this.jsz.setVisibility(8);
                this.jsC.setVisibility(0);
                TextView textView4 = this.jsD;
                this.jsM.setVisibility(8);
                textView4.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    String string7 = getPageContext().getString(R.string.my_fans_prefix);
                    String string8 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, getResources().getString(R.string.not_have_fans)));
                    z = false;
                    textView = textView4;
                    str = string7;
                    str2 = string8;
                } else {
                    if (this.fEN == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.fEN == 1) {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, getResources().getString(R.string.her_no_fan_guest)));
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
            textView.setText(str + aq.numberUniformFormat(avVar.dDD) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(av avVar, boolean z) {
        String string;
        this.jsy.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bvY()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.jsM.setVisibility(0);
                this.jsB.setVisibility(0);
                this.jsz.setVisibility(0);
                this.jsC.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.jsB.setText(string + 0 + string2);
                return;
            }
            this.jsM.setVisibility(8);
            this.jsB.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.jsM.setVisibility(8);
        this.jsB.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (avVar != null && !StringUtils.isNull(avVar.dDE) && !this.jsJ) {
                this.mNoDataView.getSuTextView().setText(bs(avVar.dDE, avVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new an("c13106").ag("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, getResources().getString(R.string.not_have_fans)));
            return;
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, getResources().getString(R.string.her_no_fan_guest)));
    }

    private void d(av avVar) {
        this.mModel.setPage(avVar.pageNum);
    }

    private void d(av avVar, boolean z) {
        if (this.jsE != null) {
            if (!z) {
                if (avVar.pageNum == 1) {
                    this.jsE.resetData();
                }
                this.jsE.setHasMore(avVar.hasMore);
                this.jsE.a(avVar);
                this.jsE.bvW();
                this.jsE.notifyDataSetChanged();
                return;
            }
            this.jsE.setHasMore(false);
            this.jsE.a(avVar);
            this.jsE.bvW();
            this.jsE.notifyDataSetChanged();
        }
    }

    private void bwc() {
        showLoadingView(this.mContainer);
        this.mModel.bvZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyO() {
        if (this.jsE != null) {
            this.jsE.notifyDataSetChanged();
        }
        this.mModel.bvZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyP() {
        UserData userData;
        if (this.jsE != null && this.jsE.getItemViewType(this.jsL) == 0 && (userData = (UserData) this.jsE.getItem(this.jsL)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            cyP();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jsM.cyK()) {
                this.jsM.closeView();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void br(String str, int i) {
        if (this.jsO == null) {
            this.jsO = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.jsP = (TextView) this.jsO.findViewById(R.id.view_forbidden_tip);
            am.setViewTextColor(this.jsP, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.jsO, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.jsO.setVisibility(8);
            return;
        }
        this.jsP.setText(bs(str, i));
        this.jsP.setMovementMethod(LinkMovementMethod.getInstance());
        this.jsP.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private SpannableStringBuilder bs(String str, int i) {
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
                    PersonListActivity.this.cyR();
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
                    PersonListActivity.this.cyQ();
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
    public void cyQ() {
        TiebaStatic.log(new an("c13104").ag("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.jsQ.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyR() {
        TiebaStatic.log(new an("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
