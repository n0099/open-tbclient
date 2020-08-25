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
    private PbListView fDW;
    private NavigationBarCoverTip hNu;
    private TextView hNz;
    private boolean kiZ;
    private NavigationBarShadowView kja;
    private NavigationBarShadowView kjb;
    private ConcernSelectView kjf;
    private e kjg;
    private View kjh;
    private TextView kji;
    private com.baidu.tieba.forbidden.fans.e kjj;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView kiR = null;
    private View kiS = null;
    private View kiT = null;
    private TextView kiU = null;
    private View kiV = null;
    private TextView kiW = null;
    private b kiX = null;
    private NoPressedRelativeLayout kiY = null;
    private boolean gBM = true;
    private TextView bpx = null;
    private int ghz = 0;
    private boolean kjc = false;
    private int kjd = 0;
    int kje = 0;
    private final AntiHelper.a hUk = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener hUl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().eCa != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().eCa, PersonListActivity.this.hUk) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener kjk = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.kiX.fB(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.kiX.bLC();
                    PersonListActivity.this.kiX.notifyDataSetChanged();
                }
                if (PersonListActivity.this.kiX.ghp) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bLE()) {
                        PersonListActivity.this.kja.show();
                    } else {
                        PersonListActivity.this.kjb.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bLE()) {
                    PersonListActivity.this.kja.hide();
                } else {
                    PersonListActivity.this.kjb.hide();
                }
            }
        }
    };
    public PersonListModel.a kjl = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
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
            if (bcVar != null && bcVar.dZE != PersonListActivity.this.kjd && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bLE() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.MM(PersonListActivity.this.mPortrait);
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
        this.kjj = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.kjj.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.hNz == null) {
                            PersonListActivity.this.hNz = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.hNz.setGravity(19);
                            PersonListActivity.this.hNz.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.hNz.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.hNz.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.hNz.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        PersonListActivity.this.hNz.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.hNu.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.hNu.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.hNu.a(PersonListActivity.this.getActivity(), PersonListActivity.this.hNz, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.kji.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    ap.setViewTextColor(PersonListActivity.this.kji, R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void cjX() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.hUl);
        registerListener(this.kjk);
        this.mModel.bFB();
        if (this.gBM) {
            this.gBM = false;
            bLI();
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
        ap.setBackgroundResource(this.kiY, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mContainer, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.kiX != null) {
            this.kiX.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.kjf.onChangeSkinType(i);
        ap.setBackgroundColor(this.kiU, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.kiU, R.color.cp_cont_d);
        ap.setBackgroundColor(this.kiW, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.kiW, R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.kiT != null) {
            getLayoutMode().onModeChanged(this.kiT);
        }
        if (this.kiV != null) {
            getLayoutMode().onModeChanged(this.kiV);
        }
        if (this.kjh != null) {
            ap.setViewTextColor(this.kji, R.color.cp_cont_d);
            ap.setBackgroundColor(this.kjh, R.color.cp_bg_line_d);
        }
        this.kjj.onChangeSkinType();
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fDW.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kiX != null) {
            this.kiX = null;
        }
        if (this.kjg != null) {
            this.kjg.NG();
        }
        this.hNu.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.kjl);
        if (bundle != null) {
            this.mModel.lx(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.ghz = bundle.getInt("user_sex");
            this.kjc = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.kjd = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.ghz);
            return;
        }
        Intent intent = getIntent();
        this.mModel.lx(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.ghz = intent.getIntExtra("user_sex", 0);
        this.kjc = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.kjd = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.ghz);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bLE());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.ghz);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.kjc);
    }

    private void initUI() {
        boolean z = true;
        this.kiY = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bpx = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kja = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.kjb = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.kiS = findViewById(R.id.sub_title_root);
        this.kiT = this.kiS.findViewById(R.id.newheader_root);
        this.kiS.setVisibility(8);
        this.kiS.setClickable(false);
        this.kiS.setEnabled(false);
        this.kiU = (TextView) this.kiS.findViewById(R.id.person_list_title);
        this.kjf = (ConcernSelectView) findViewById(R.id.select_layout);
        this.hNu = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bLE()) {
                this.bpx.setText(R.string.my_attention);
                this.kiY.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void E(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.kjf.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.kjf.cRw() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.kiY.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.kjf.closeView();
                        PersonListActivity.this.kiY.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.bpx.setText(R.string.fans);
            }
        } else if (this.mModel.bLE()) {
            if (this.ghz == 2) {
                this.bpx.setText(R.string.her_attention_people);
            } else if (this.ghz == 1) {
                this.bpx.setText(R.string.his_attention_people);
            } else {
                this.bpx.setText(R.string.its_attention_people);
            }
        } else if (this.ghz == 2) {
            this.bpx.setText(R.string.attention_to_her);
        } else if (this.ghz == 1) {
            this.bpx.setText(R.string.attention_to_him);
        } else {
            this.bpx.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.kiX != null && PersonListActivity.this.kiX.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.kiX.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bLE()) {
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
                PersonListActivity.this.kje = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.cRB();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.cRA();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.kiX = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.kiS.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.kiY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.kiX = new c(this, z, sex, onClickListener, onClickListener3);
            this.kiS.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.kiY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.kiR = (BdListView) findViewById(R.id.list);
        this.kiR.setAdapter((ListAdapter) this.kiX);
        cRz();
        this.kiR.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.kiX != null && PersonListActivity.this.kiX.isHasMore()) {
                    if (PersonListActivity.this.fDW != null && !PersonListActivity.this.fDW.isLoading()) {
                        PersonListActivity.this.fDW.startLoadData();
                    }
                    PersonListActivity.this.cRA();
                }
            }
        });
        this.kiR.setOnScrollListener(this.mOnScrollListener);
        this.kjf.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void rV(boolean z2) {
                if (z2) {
                    PersonListActivity.this.cgs();
                } else if (PersonListActivity.this.kjg != null) {
                    PersonListActivity.this.kjg.NG();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void yy(int i) {
                PersonListActivity.this.kiR.setSelection(0);
                PersonListActivity.this.mModel.sD(i);
            }
        });
        this.kjf.setVisibility(8);
        this.kiV.setVisibility(8);
        this.fDW = new PbListView(getActivity());
        this.fDW.getView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setLineGone();
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fDW.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.kiR.setNextPage(this.fDW);
    }

    private void cRz() {
        this.kiV = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.kiV.setVisibility(8);
        this.kiV.setClickable(false);
        this.kiV.setEnabled(false);
        this.kiW = (TextView) this.kiV.findViewById(R.id.person_list_title);
        this.kiR.addHeaderView(this.kiV, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgs() {
        if (this.kjg == null) {
            this.kjg = new com.baidu.tieba.c.e(getPageContext(), this.kjf.kiy);
            this.kjg.eL(R.drawable.bg_tip_blue_up);
            this.kjg.setMaxShowTime(2);
            this.kjg.eM(3000);
            this.kjg.vF(-10);
            this.kjg.setYOffset(-16);
            this.kjg.c(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.kjg != null) {
                        PersonListActivity.this.kjg.NG();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(bc bcVar, boolean z) {
        if (this.mModel != null && bcVar != null && (!z || !this.kiZ)) {
            if (!z) {
                this.kiZ = true;
                d(bcVar);
            }
            b(bcVar);
            d(bcVar, z);
            if (!this.mModel.bLE()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bnV().setMsgFans(0);
            }
            b(bcVar, z);
        }
    }

    private void b(bc bcVar) {
        if (bcVar != null) {
            if (!bcVar.hasMore && !StringUtils.isNull(bcVar.dZF) && !this.kjc) {
                bs(bcVar.dZF, bcVar.type);
                this.kiR.removeFooterView(this.kjh);
                this.kiR.addFooterView(this.kjh);
                this.kiR.removeFooterView(this.fDW.getView());
                TiebaStatic.log(new aq("c13106").ai("obj_locate", 2));
            } else if (!bcVar.hasMore) {
                this.kiR.removeFooterView(this.kjh);
                this.fDW.setText(getString(R.string.no_more_data_tip));
                this.fDW.endLoadData();
            } else {
                this.kiR.removeFooterView(this.kjh);
                this.fDW.setText(getString(R.string.pb_load_more));
                this.fDW.endLoadData();
            }
        }
    }

    private void b(bc bcVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (bcVar.dZE > 0 && !y.isEmpty(bcVar.bdx())) {
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
            this.kiR.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bLE()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.kiS.setVisibility(0);
                    this.kiR.removeHeaderView(this.kiV);
                    TextView textView2 = this.kiU;
                    textView2.setVisibility(0);
                    this.kjf.setVisibility(0);
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
                    this.kiS.setVisibility(8);
                    this.kiV.setVisibility(0);
                    TextView textView3 = this.kiW;
                    textView3.setVisibility(8);
                    this.kjf.setVisibility(8);
                    if (this.ghz == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.ghz == 1) {
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
                this.kiS.setVisibility(8);
                this.kiV.setVisibility(0);
                TextView textView4 = this.kiW;
                this.kjf.setVisibility(8);
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
                    if (this.ghz == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.ghz == 1) {
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
            textView.setText(str + at.numberUniformFormat(bcVar.dZE) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(bc bcVar, boolean z) {
        String string;
        this.kiR.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bLE()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.kjf.setVisibility(0);
                this.kiU.setVisibility(0);
                this.kiS.setVisibility(0);
                this.kiV.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.kiU.setText(string + 0 + string2);
                return;
            }
            this.kjf.setVisibility(8);
            this.kiU.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.kjf.setVisibility(8);
        this.kiU.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (bcVar != null && !StringUtils.isNull(bcVar.dZF) && !this.kjc) {
                this.mNoDataView.getSuTextView().setText(bt(bcVar.dZF, bcVar.type));
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
        if (this.kiX != null) {
            if (!z) {
                if (bcVar.pageNum == 1) {
                    this.kiX.resetData();
                }
                this.kiX.setHasMore(bcVar.hasMore);
                this.kiX.a(bcVar);
                this.kiX.bLC();
                this.kiX.notifyDataSetChanged();
                return;
            }
            this.kiX.setHasMore(false);
            this.kiX.a(bcVar);
            this.kiX.bLC();
            this.kiX.notifyDataSetChanged();
        }
    }

    private void bLI() {
        showLoadingView(this.mContainer);
        this.mModel.bLF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRA() {
        if (this.kiX != null) {
            this.kiX.notifyDataSetChanged();
        }
        this.mModel.bLF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRB() {
        UserData userData;
        if (this.kiX != null && this.kiX.getItemViewType(this.kje) == 0 && (userData = (UserData) this.kiX.getItem(this.kje)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            cRB();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kjf.cRw()) {
                this.kjf.closeView();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bs(String str, int i) {
        if (this.kjh == null) {
            this.kjh = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.kji = (TextView) this.kjh.findViewById(R.id.view_forbidden_tip);
            ap.setViewTextColor(this.kji, R.color.cp_cont_d);
            ap.setBackgroundColor(this.kjh, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.kjh.setVisibility(8);
            return;
        }
        this.kji.setText(bt(str, i));
        this.kji.setMovementMethod(LinkMovementMethod.getInstance());
        this.kji.setHighlightColor(getResources().getColor(R.color.transparent));
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
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.cRC();
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
    public void cRC() {
        TiebaStatic.log(new aq("c13104").ai("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.kjj.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRD() {
        TiebaStatic.log(new aq("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
