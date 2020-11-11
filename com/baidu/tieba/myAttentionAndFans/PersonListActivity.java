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
    private PbListView gjo;
    private NavigationBarCoverTip iBV;
    private TextView iCa;
    private boolean kZk;
    private NavigationBarShadowView kZl;
    private NavigationBarShadowView kZm;
    private ConcernSelectView kZq;
    private e kZr;
    private View kZs;
    private TextView kZt;
    private com.baidu.tieba.forbidden.fans.e kZu;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView kZc = null;
    private View kZd = null;
    private View kZe = null;
    private TextView kZf = null;
    private View kZg = null;
    private TextView kZh = null;
    private b kZi = null;
    private NoPressedRelativeLayout kZj = null;
    private boolean brE = true;
    private TextView bEW = null;
    private int gQF = 0;
    private boolean kZn = false;
    private int kZo = 0;
    int kZp = 0;
    private final AntiHelper.a iIK = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener iIL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().feD != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().feD, PersonListActivity.this.iIK) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener kZv = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.kZi.gE(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.kZi.bVA();
                    PersonListActivity.this.kZi.notifyDataSetChanged();
                }
                if (PersonListActivity.this.kZi.gQv) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bVC()) {
                        PersonListActivity.this.kZl.show();
                    } else {
                        PersonListActivity.this.kZm.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bVC()) {
                    PersonListActivity.this.kZl.hide();
                } else {
                    PersonListActivity.this.kZm.hide();
                }
            }
        }
    };
    public PersonListModel.a kZw = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
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
            if (bcVar != null && bcVar.eCm != PersonListActivity.this.kZo && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bVC() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.OT(PersonListActivity.this.mPortrait);
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
        this.kZu = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.kZu.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.iCa == null) {
                            PersonListActivity.this.iCa = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.iCa.setGravity(19);
                            PersonListActivity.this.iCa.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.iCa.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.iCa.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.iCa.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        PersonListActivity.this.iCa.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.iBV.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.iBV.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.iBV.a(PersonListActivity.this.getActivity(), PersonListActivity.this.iCa, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.kZt.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    ap.setViewTextColor(PersonListActivity.this.kZt, R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void cwr() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.iIL);
        registerListener(this.kZv);
        this.mModel.bOG();
        if (this.brE) {
            this.brE = false;
            bVG();
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
        ap.setBackgroundResource(this.kZj, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mContainer, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.kZi != null) {
            this.kZi.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.kZq.onChangeSkinType(i);
        ap.setBackgroundColor(this.kZf, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.kZf, R.color.cp_cont_d);
        ap.setBackgroundColor(this.kZh, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.kZh, R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.kZe != null) {
            getLayoutMode().onModeChanged(this.kZe);
        }
        if (this.kZg != null) {
            getLayoutMode().onModeChanged(this.kZg);
        }
        if (this.kZs != null) {
            ap.setViewTextColor(this.kZt, R.color.cp_cont_d);
            ap.setBackgroundColor(this.kZs, R.color.cp_bg_line_d);
        }
        this.kZu.onChangeSkinType();
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.gjo.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kZi != null) {
            this.kZi = null;
        }
        if (this.kZr != null) {
            this.kZr.SR();
        }
        this.iBV.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.kZw);
        if (bundle != null) {
            this.mModel.mD(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.gQF = bundle.getInt("user_sex");
            this.kZn = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.kZo = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.gQF);
            return;
        }
        Intent intent = getIntent();
        this.mModel.mD(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.gQF = intent.getIntExtra("user_sex", 0);
        this.kZn = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.kZo = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.gQF);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bVC());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.gQF);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.kZn);
    }

    private void initUI() {
        boolean z = true;
        this.kZj = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bEW = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kZl = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.kZm = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.kZd = findViewById(R.id.sub_title_root);
        this.kZe = this.kZd.findViewById(R.id.newheader_root);
        this.kZd.setVisibility(8);
        this.kZd.setClickable(false);
        this.kZd.setEnabled(false);
        this.kZf = (TextView) this.kZd.findViewById(R.id.person_list_title);
        this.kZq = (ConcernSelectView) findViewById(R.id.select_layout);
        this.iBV = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bVC()) {
                this.bEW.setText(R.string.my_attention);
                this.kZj.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void E(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.kZq.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.kZq.dew() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.kZj.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.kZq.closeView();
                        PersonListActivity.this.kZj.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.bEW.setText(R.string.fans);
            }
        } else if (this.mModel.bVC()) {
            if (this.gQF == 2) {
                this.bEW.setText(R.string.her_attention_people);
            } else if (this.gQF == 1) {
                this.bEW.setText(R.string.his_attention_people);
            } else {
                this.bEW.setText(R.string.its_attention_people);
            }
        } else if (this.gQF == 2) {
            this.bEW.setText(R.string.attention_to_her);
        } else if (this.gQF == 1) {
            this.bEW.setText(R.string.attention_to_him);
        } else {
            this.bEW.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.kZi != null && PersonListActivity.this.kZi.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.kZi.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bVC()) {
                            TiebaStatic.log(new aq("c12772").dR("obj_locate", "1").dR("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new aq("c12605").al("obj_locate", 1).dR("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.kZp = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.deB();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.deA();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.kZi = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.kZd.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.kZj, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.kZi = new c(this, z, sex, onClickListener, onClickListener3);
            this.kZd.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.kZj, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.kZc = (BdListView) findViewById(R.id.list);
        this.kZc.setAdapter((ListAdapter) this.kZi);
        dez();
        this.kZc.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.kZi != null && PersonListActivity.this.kZi.isHasMore()) {
                    if (PersonListActivity.this.gjo != null && !PersonListActivity.this.gjo.isLoading()) {
                        PersonListActivity.this.gjo.startLoadData();
                    }
                    PersonListActivity.this.deA();
                }
            }
        });
        this.kZc.setOnScrollListener(this.mOnScrollListener);
        this.kZq.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void tm(boolean z2) {
                if (z2) {
                    PersonListActivity.this.csO();
                } else if (PersonListActivity.this.kZr != null) {
                    PersonListActivity.this.kZr.SR();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void Aj(int i) {
                PersonListActivity.this.kZc.setSelection(0);
                PersonListActivity.this.mModel.tW(i);
            }
        });
        this.kZq.setVisibility(8);
        this.kZg.setVisibility(8);
        this.gjo = new PbListView(getActivity());
        this.gjo.getView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setLineGone();
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gjo.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.kZc.setNextPage(this.gjo);
    }

    private void dez() {
        this.kZg = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.kZg.setVisibility(8);
        this.kZg.setClickable(false);
        this.kZg.setEnabled(false);
        this.kZh = (TextView) this.kZg.findViewById(R.id.person_list_title);
        this.kZc.addHeaderView(this.kZg, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csO() {
        if (this.kZr == null) {
            this.kZr = new com.baidu.tieba.c.e(getPageContext(), this.kZq.kYJ);
            this.kZr.fu(R.drawable.bg_tip_blue_up);
            this.kZr.setMaxShowTime(2);
            this.kZr.fv(3000);
            this.kZr.xq(-10);
            this.kZr.setYOffset(-16);
            this.kZr.d(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.kZr != null) {
                        PersonListActivity.this.kZr.SR();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(bc bcVar, boolean z) {
        if (this.mModel != null && bcVar != null && (!z || !this.kZk)) {
            if (!z) {
                this.kZk = true;
                d(bcVar);
            }
            b(bcVar);
            d(bcVar, z);
            if (!this.mModel.bVC()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bvS().setMsgFans(0);
            }
            b(bcVar, z);
        }
    }

    private void b(bc bcVar) {
        if (bcVar != null) {
            if (!bcVar.hasMore && !StringUtils.isNull(bcVar.eCn) && !this.kZn) {
                bw(bcVar.eCn, bcVar.type);
                this.kZc.removeFooterView(this.kZs);
                this.kZc.addFooterView(this.kZs);
                this.kZc.removeFooterView(this.gjo.getView());
                TiebaStatic.log(new aq("c13106").al("obj_locate", 2));
            } else if (!bcVar.hasMore) {
                this.kZc.removeFooterView(this.kZs);
                this.gjo.setText(getString(R.string.no_more_data_tip));
                this.gjo.endLoadData();
            } else {
                this.kZc.removeFooterView(this.kZs);
                this.gjo.setText(getString(R.string.pb_load_more));
                this.gjo.endLoadData();
            }
        }
    }

    private void b(bc bcVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (bcVar.eCm > 0 && !y.isEmpty(bcVar.blt())) {
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
            this.kZc.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bVC()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.kZd.setVisibility(0);
                    this.kZc.removeHeaderView(this.kZg);
                    TextView textView2 = this.kZf;
                    textView2.setVisibility(0);
                    this.kZq.setVisibility(0);
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
                    this.kZd.setVisibility(8);
                    this.kZg.setVisibility(0);
                    TextView textView3 = this.kZh;
                    textView3.setVisibility(8);
                    this.kZq.setVisibility(8);
                    if (this.gQF == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.gQF == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_attention_guest)));
                    String string6 = getPageContext().getString(R.string.person);
                    str = string3;
                    textView = textView3;
                    z = y.isEmpty(bcVar.blu()) ? false : true;
                    str2 = string6;
                }
            } else {
                this.kZd.setVisibility(8);
                this.kZg.setVisibility(0);
                TextView textView4 = this.kZh;
                this.kZq.setVisibility(8);
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
                    if (this.gQF == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.gQF == 1) {
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
            textView.setText(str + at.numberUniformFormat(bcVar.eCm) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(bc bcVar, boolean z) {
        String string;
        this.kZc.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bVC()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.kZq.setVisibility(0);
                this.kZf.setVisibility(0);
                this.kZd.setVisibility(0);
                this.kZg.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.kZf.setText(string + 0 + string2);
                return;
            }
            this.kZq.setVisibility(8);
            this.kZf.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.kZq.setVisibility(8);
        this.kZf.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (bcVar != null && !StringUtils.isNull(bcVar.eCn) && !this.kZn) {
                this.mNoDataView.getSuTextView().setText(bx(bcVar.eCn, bcVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new aq("c13106").al("obj_locate", 1));
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
        if (this.kZi != null) {
            if (!z) {
                if (bcVar.pageNum == 1) {
                    this.kZi.resetData();
                }
                this.kZi.setHasMore(bcVar.hasMore);
                this.kZi.a(bcVar);
                this.kZi.bVA();
                this.kZi.notifyDataSetChanged();
                return;
            }
            this.kZi.setHasMore(false);
            this.kZi.a(bcVar);
            this.kZi.bVA();
            this.kZi.notifyDataSetChanged();
        }
    }

    private void bVG() {
        showLoadingView(this.mContainer);
        this.mModel.bVD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deA() {
        if (this.kZi != null) {
            this.kZi.notifyDataSetChanged();
        }
        this.mModel.bVD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deB() {
        UserData userData;
        if (this.kZi != null && this.kZi.getItemViewType(this.kZp) == 0 && (userData = (UserData) this.kZi.getItem(this.kZp)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            deB();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kZq.dew()) {
                this.kZq.closeView();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bw(String str, int i) {
        if (this.kZs == null) {
            this.kZs = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.kZt = (TextView) this.kZs.findViewById(R.id.view_forbidden_tip);
            ap.setViewTextColor(this.kZt, R.color.cp_cont_d);
            ap.setBackgroundColor(this.kZs, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.kZs.setVisibility(8);
            return;
        }
        this.kZt.setText(bx(str, i));
        this.kZt.setMovementMethod(LinkMovementMethod.getInstance());
        this.kZt.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private SpannableStringBuilder bx(String str, int i) {
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
                    PersonListActivity.this.deD();
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
                    PersonListActivity.this.deC();
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
    public void deC() {
        TiebaStatic.log(new aq("c13104").al("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.kZu.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deD() {
        TiebaStatic.log(new aq("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
