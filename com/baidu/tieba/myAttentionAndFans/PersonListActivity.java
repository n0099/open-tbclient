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
/* loaded from: classes17.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView fEa;
    private NavigationBarCoverTip hNA;
    private TextView hNF;
    private boolean kjg;
    private NavigationBarShadowView kjh;
    private NavigationBarShadowView kji;
    private ConcernSelectView kjm;
    private e kjn;
    private View kjo;
    private TextView kjp;
    private com.baidu.tieba.forbidden.fans.e kjq;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView kiY = null;
    private View kiZ = null;
    private View kja = null;
    private TextView kjb = null;
    private View kjc = null;
    private TextView kjd = null;
    private b kje = null;
    private NoPressedRelativeLayout kjf = null;
    private boolean gBQ = true;
    private TextView bpA = null;
    private int ghD = 0;
    private boolean kjj = false;
    private int kjk = 0;
    int kjl = 0;
    private final AntiHelper.a hUq = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener hUr = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().eCe != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().eCe, PersonListActivity.this.hUq) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener kjr = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.kje.fB(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.kje.bLD();
                    PersonListActivity.this.kje.notifyDataSetChanged();
                }
                if (PersonListActivity.this.kje.ght) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bLF()) {
                        PersonListActivity.this.kjh.show();
                    } else {
                        PersonListActivity.this.kji.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bLF()) {
                    PersonListActivity.this.kjh.hide();
                } else {
                    PersonListActivity.this.kji.hide();
                }
            }
        }
    };
    public PersonListModel.a kjs = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
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
            if (bcVar != null && bcVar.dZI != PersonListActivity.this.kjk && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bLF() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.MN(PersonListActivity.this.mPortrait);
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
        this.kjq = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.kjq.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.hNF == null) {
                            PersonListActivity.this.hNF = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.hNF.setGravity(19);
                            PersonListActivity.this.hNF.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.hNF.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.hNF.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.hNF.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        PersonListActivity.this.hNF.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.hNA.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.hNA.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.hNA.a(PersonListActivity.this.getActivity(), PersonListActivity.this.hNF, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.kjp.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    ap.setViewTextColor(PersonListActivity.this.kjp, R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void cjY() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.hUr);
        registerListener(this.kjr);
        this.mModel.bFC();
        if (this.gBQ) {
            this.gBQ = false;
            bLJ();
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
        ap.setBackgroundResource(this.kjf, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mContainer, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.kje != null) {
            this.kje.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.kjm.onChangeSkinType(i);
        ap.setBackgroundColor(this.kjb, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.kjb, R.color.cp_cont_d);
        ap.setBackgroundColor(this.kjd, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.kjd, R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.kja != null) {
            getLayoutMode().onModeChanged(this.kja);
        }
        if (this.kjc != null) {
            getLayoutMode().onModeChanged(this.kjc);
        }
        if (this.kjo != null) {
            ap.setViewTextColor(this.kjp, R.color.cp_cont_d);
            ap.setBackgroundColor(this.kjo, R.color.cp_bg_line_d);
        }
        this.kjq.onChangeSkinType();
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fEa.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kje != null) {
            this.kje = null;
        }
        if (this.kjn != null) {
            this.kjn.NG();
        }
        this.hNA.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.kjs);
        if (bundle != null) {
            this.mModel.lz(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.ghD = bundle.getInt("user_sex");
            this.kjj = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.kjk = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.ghD);
            return;
        }
        Intent intent = getIntent();
        this.mModel.lz(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.ghD = intent.getIntExtra("user_sex", 0);
        this.kjj = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.kjk = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.ghD);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bLF());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.ghD);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.kjj);
    }

    private void initUI() {
        boolean z = true;
        this.kjf = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bpA = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kjh = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.kji = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.kiZ = findViewById(R.id.sub_title_root);
        this.kja = this.kiZ.findViewById(R.id.newheader_root);
        this.kiZ.setVisibility(8);
        this.kiZ.setClickable(false);
        this.kiZ.setEnabled(false);
        this.kjb = (TextView) this.kiZ.findViewById(R.id.person_list_title);
        this.kjm = (ConcernSelectView) findViewById(R.id.select_layout);
        this.hNA = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bLF()) {
                this.bpA.setText(R.string.my_attention);
                this.kjf.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void E(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.kjm.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.kjm.cRx() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.kjf.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.kjm.closeView();
                        PersonListActivity.this.kjf.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.bpA.setText(R.string.fans);
            }
        } else if (this.mModel.bLF()) {
            if (this.ghD == 2) {
                this.bpA.setText(R.string.her_attention_people);
            } else if (this.ghD == 1) {
                this.bpA.setText(R.string.his_attention_people);
            } else {
                this.bpA.setText(R.string.its_attention_people);
            }
        } else if (this.ghD == 2) {
            this.bpA.setText(R.string.attention_to_her);
        } else if (this.ghD == 1) {
            this.bpA.setText(R.string.attention_to_him);
        } else {
            this.bpA.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.kje != null && PersonListActivity.this.kje.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.kje.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bLF()) {
                            TiebaStatic.log(new aq("c12772").dD("obj_locate", "1").dD("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new aq("c12605").ai("obj_locate", 1).dD("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.kjl = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.cRC();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.cRB();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.kje = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.kiZ.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.kjf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.kje = new c(this, z, sex, onClickListener, onClickListener3);
            this.kiZ.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.kjf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.kiY = (BdListView) findViewById(R.id.list);
        this.kiY.setAdapter((ListAdapter) this.kje);
        cRA();
        this.kiY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.kje != null && PersonListActivity.this.kje.isHasMore()) {
                    if (PersonListActivity.this.fEa != null && !PersonListActivity.this.fEa.isLoading()) {
                        PersonListActivity.this.fEa.startLoadData();
                    }
                    PersonListActivity.this.cRB();
                }
            }
        });
        this.kiY.setOnScrollListener(this.mOnScrollListener);
        this.kjm.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void rX(boolean z2) {
                if (z2) {
                    PersonListActivity.this.cgt();
                } else if (PersonListActivity.this.kjn != null) {
                    PersonListActivity.this.kjn.NG();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void yy(int i) {
                PersonListActivity.this.kiY.setSelection(0);
                PersonListActivity.this.mModel.sD(i);
            }
        });
        this.kjm.setVisibility(8);
        this.kjc.setVisibility(8);
        this.fEa = new PbListView(getActivity());
        this.fEa.getView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setLineGone();
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fEa.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.kiY.setNextPage(this.fEa);
    }

    private void cRA() {
        this.kjc = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.kjc.setVisibility(8);
        this.kjc.setClickable(false);
        this.kjc.setEnabled(false);
        this.kjd = (TextView) this.kjc.findViewById(R.id.person_list_title);
        this.kiY.addHeaderView(this.kjc, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgt() {
        if (this.kjn == null) {
            this.kjn = new com.baidu.tieba.c.e(getPageContext(), this.kjm.kiF);
            this.kjn.eL(R.drawable.bg_tip_blue_up);
            this.kjn.setMaxShowTime(2);
            this.kjn.eM(3000);
            this.kjn.vF(-10);
            this.kjn.setYOffset(-16);
            this.kjn.c(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.kjn != null) {
                        PersonListActivity.this.kjn.NG();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(bc bcVar, boolean z) {
        if (this.mModel != null && bcVar != null && (!z || !this.kjg)) {
            if (!z) {
                this.kjg = true;
                d(bcVar);
            }
            b(bcVar);
            d(bcVar, z);
            if (!this.mModel.bLF()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgFans(0);
            }
            b(bcVar, z);
        }
    }

    private void b(bc bcVar) {
        if (bcVar != null) {
            if (!bcVar.hasMore && !StringUtils.isNull(bcVar.dZJ) && !this.kjj) {
                bs(bcVar.dZJ, bcVar.type);
                this.kiY.removeFooterView(this.kjo);
                this.kiY.addFooterView(this.kjo);
                this.kiY.removeFooterView(this.fEa.getView());
                TiebaStatic.log(new aq("c13106").ai("obj_locate", 2));
            } else if (!bcVar.hasMore) {
                this.kiY.removeFooterView(this.kjo);
                this.fEa.setText(getString(R.string.no_more_data_tip));
                this.fEa.endLoadData();
            } else {
                this.kiY.removeFooterView(this.kjo);
                this.fEa.setText(getString(R.string.pb_load_more));
                this.fEa.endLoadData();
            }
        }
    }

    private void b(bc bcVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (bcVar.dZI > 0 && !y.isEmpty(bcVar.bdx())) {
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
            this.kiY.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bLF()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.kiZ.setVisibility(0);
                    this.kiY.removeHeaderView(this.kjc);
                    TextView textView2 = this.kjb;
                    textView2.setVisibility(0);
                    this.kjm.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    String string5 = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, getResources().getString(R.string.not_have_attention)));
                    z = false;
                    str = string4;
                    textView = textView2;
                    str2 = string5;
                } else {
                    this.kiZ.setVisibility(8);
                    this.kjc.setVisibility(0);
                    TextView textView3 = this.kjd;
                    textView3.setVisibility(8);
                    this.kjm.setVisibility(8);
                    if (this.ghD == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.ghD == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, getResources().getString(R.string.not_have_attention_guest)));
                    String string6 = getPageContext().getString(R.string.person);
                    str = string3;
                    textView = textView3;
                    z = y.isEmpty(bcVar.bdy()) ? false : true;
                    str2 = string6;
                }
            } else {
                this.kiZ.setVisibility(8);
                this.kjc.setVisibility(0);
                TextView textView4 = this.kjd;
                this.kjm.setVisibility(8);
                textView4.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    String string7 = getPageContext().getString(R.string.my_fans_prefix);
                    String string8 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, getResources().getString(R.string.not_have_fans)));
                    z = false;
                    textView = textView4;
                    str = string7;
                    str2 = string8;
                } else {
                    if (this.ghD == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.ghD == 1) {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, getResources().getString(R.string.her_no_fan_guest)));
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
            textView.setText(str + at.numberUniformFormat(bcVar.dZI) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(bc bcVar, boolean z) {
        String string;
        this.kiY.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bLF()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.kjm.setVisibility(0);
                this.kjb.setVisibility(0);
                this.kiZ.setVisibility(0);
                this.kjc.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.kjb.setText(string + 0 + string2);
                return;
            }
            this.kjm.setVisibility(8);
            this.kjb.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.kjm.setVisibility(8);
        this.kjb.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (bcVar != null && !StringUtils.isNull(bcVar.dZJ) && !this.kjj) {
                this.mNoDataView.getSuTextView().setText(bt(bcVar.dZJ, bcVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new aq("c13106").ai("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, getResources().getString(R.string.not_have_fans)));
            return;
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, getResources().getString(R.string.her_no_fan_guest)));
    }

    private void d(bc bcVar) {
        this.mModel.setPage(bcVar.pageNum);
    }

    private void d(bc bcVar, boolean z) {
        if (this.kje != null) {
            if (!z) {
                if (bcVar.pageNum == 1) {
                    this.kje.resetData();
                }
                this.kje.setHasMore(bcVar.hasMore);
                this.kje.a(bcVar);
                this.kje.bLD();
                this.kje.notifyDataSetChanged();
                return;
            }
            this.kje.setHasMore(false);
            this.kje.a(bcVar);
            this.kje.bLD();
            this.kje.notifyDataSetChanged();
        }
    }

    private void bLJ() {
        showLoadingView(this.mContainer);
        this.mModel.bLG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRB() {
        if (this.kje != null) {
            this.kje.notifyDataSetChanged();
        }
        this.mModel.bLG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRC() {
        UserData userData;
        if (this.kje != null && this.kje.getItemViewType(this.kjl) == 0 && (userData = (UserData) this.kje.getItem(this.kjl)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            cRC();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kjm.cRx()) {
                this.kjm.closeView();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bs(String str, int i) {
        if (this.kjo == null) {
            this.kjo = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.kjp = (TextView) this.kjo.findViewById(R.id.view_forbidden_tip);
            ap.setViewTextColor(this.kjp, R.color.cp_cont_d);
            ap.setBackgroundColor(this.kjo, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.kjo.setVisibility(8);
            return;
        }
        this.kjp.setText(bt(str, i));
        this.kjp.setMovementMethod(LinkMovementMethod.getInstance());
        this.kjp.setHighlightColor(getResources().getColor(R.color.transparent));
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
                    PersonListActivity.this.cRE();
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
                    PersonListActivity.this.cRD();
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
    public void cRD() {
        TiebaStatic.log(new aq("c13104").ai("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.kjq.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRE() {
        TiebaStatic.log(new aq("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
