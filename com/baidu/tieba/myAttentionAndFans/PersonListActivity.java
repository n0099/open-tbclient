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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.x;
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
    private PbListView fsC;
    private NavigationBarCoverTip hAf;
    private TextView hAk;
    private boolean jTD;
    private NavigationBarShadowView jTE;
    private NavigationBarShadowView jTF;
    private ConcernSelectView jTJ;
    private e jTK;
    private View jTL;
    private TextView jTM;
    private com.baidu.tieba.forbidden.fans.e jTN;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView jTv = null;
    private View jTw = null;
    private View jTx = null;
    private TextView jTy = null;
    private View jTz = null;
    private TextView jTA = null;
    private b jTB = null;
    private NoPressedRelativeLayout jTC = null;
    private boolean goW = true;
    private TextView bjS = null;
    private int fVA = 0;
    private boolean jTG = false;
    private int jTH = 0;
    int jTI = 0;
    private final AntiHelper.a hGU = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener hGV = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().erH != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().erH, PersonListActivity.this.hGU) != null) {
                    TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ah("obj_locate", aw.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener jTO = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.jTB.fp(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.jTB.bCi();
                    PersonListActivity.this.jTB.notifyDataSetChanged();
                }
                if (PersonListActivity.this.jTB.fVq) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bCk()) {
                        PersonListActivity.this.jTE.show();
                    } else {
                        PersonListActivity.this.jTF.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bCk()) {
                    PersonListActivity.this.jTE.hide();
                } else {
                    PersonListActivity.this.jTF.hide();
                }
            }
        }
    };
    public PersonListModel.a jTP = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
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
        public bb e(bb bbVar, boolean z) {
            if (bbVar != null && bbVar.dQl != PersonListActivity.this.jTH && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bCk() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.JU(PersonListActivity.this.mPortrait);
            }
            PersonListActivity.this.a(bbVar, z);
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
        this.jTN = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.jTN.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.hAk == null) {
                            PersonListActivity.this.hAk = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.hAk.setGravity(19);
                            PersonListActivity.this.hAk.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.hAk.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.hAk.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.hAk.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        PersonListActivity.this.hAk.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.hAf.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.hAf.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.hAf.a(PersonListActivity.this.getActivity(), PersonListActivity.this.hAk, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.jTM.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    ao.setViewTextColor(PersonListActivity.this.jTM, R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bZB() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.hGV);
        registerListener(this.jTO);
        this.mModel.bwC();
        if (this.goW) {
            this.goW = false;
            bCo();
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
        ao.setBackgroundResource(this.jTC, R.color.cp_bg_line_d);
        ao.setBackgroundResource(this.mContainer, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.jTB != null) {
            this.jTB.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.jTJ.onChangeSkinType(i);
        ao.setBackgroundColor(this.jTy, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.jTy, R.color.cp_cont_d);
        ao.setBackgroundColor(this.jTA, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.jTA, R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.jTx != null) {
            getLayoutMode().onModeChanged(this.jTx);
        }
        if (this.jTz != null) {
            getLayoutMode().onModeChanged(this.jTz);
        }
        if (this.jTL != null) {
            ao.setViewTextColor(this.jTM, R.color.cp_cont_d);
            ao.setBackgroundColor(this.jTL, R.color.cp_bg_line_d);
        }
        this.jTN.onChangeSkinType();
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
        this.fsC.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jTB != null) {
            this.jTB = null;
        }
        if (this.jTK != null) {
            this.jTK.HN();
        }
        this.hAf.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.jTP);
        if (bundle != null) {
            this.mModel.kX(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fVA = bundle.getInt("user_sex");
            this.jTG = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.jTH = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.fVA);
            return;
        }
        Intent intent = getIntent();
        this.mModel.kX(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fVA = intent.getIntExtra("user_sex", 0);
        this.jTG = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.jTH = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.fVA);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bCk());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.fVA);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.jTG);
    }

    private void initUI() {
        boolean z = true;
        this.jTC = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bjS = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jTE = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.jTF = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.jTw = findViewById(R.id.sub_title_root);
        this.jTx = this.jTw.findViewById(R.id.newheader_root);
        this.jTw.setVisibility(8);
        this.jTw.setClickable(false);
        this.jTw.setEnabled(false);
        this.jTy = (TextView) this.jTw.findViewById(R.id.person_list_title);
        this.jTJ = (ConcernSelectView) findViewById(R.id.select_layout);
        this.hAf = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bCk()) {
                this.bjS.setText(R.string.my_attention);
                this.jTC.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void p(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.jTJ.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.jTJ.cGH() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.jTC.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.jTJ.closeView();
                        PersonListActivity.this.jTC.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.bjS.setText(R.string.fans);
            }
        } else if (this.mModel.bCk()) {
            if (this.fVA == 2) {
                this.bjS.setText(R.string.her_attention_people);
            } else if (this.fVA == 1) {
                this.bjS.setText(R.string.his_attention_people);
            } else {
                this.bjS.setText(R.string.its_attention_people);
            }
        } else if (this.fVA == 2) {
            this.bjS.setText(R.string.attention_to_her);
        } else if (this.fVA == 1) {
            this.bjS.setText(R.string.attention_to_him);
        } else {
            this.bjS.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.jTB != null && PersonListActivity.this.jTB.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.jTB.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bCk()) {
                            TiebaStatic.log(new ap("c12772").dn("obj_locate", "1").dn("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new ap("c12605").ah("obj_locate", 1).dn("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.jTI = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.cGM();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.cGL();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.jTB = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.jTw.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.jTC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.jTB = new c(this, z, sex, onClickListener, onClickListener3);
            this.jTw.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.jTC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.jTv = (BdListView) findViewById(R.id.list);
        this.jTv.setAdapter((ListAdapter) this.jTB);
        cGK();
        this.jTv.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.jTB != null && PersonListActivity.this.jTB.isHasMore()) {
                    if (PersonListActivity.this.fsC != null && !PersonListActivity.this.fsC.isLoading()) {
                        PersonListActivity.this.fsC.startLoadData();
                    }
                    PersonListActivity.this.cGL();
                }
            }
        });
        this.jTv.setOnScrollListener(this.mOnScrollListener);
        this.jTJ.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void rp(boolean z2) {
                if (z2) {
                    PersonListActivity.this.bWf();
                } else if (PersonListActivity.this.jTK != null) {
                    PersonListActivity.this.jTK.HN();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void wf(int i) {
                PersonListActivity.this.jTv.setSelection(0);
                PersonListActivity.this.mModel.qr(i);
            }
        });
        this.jTJ.setVisibility(8);
        this.jTz.setVisibility(8);
        this.fsC = new PbListView(getActivity());
        this.fsC.getView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setLineGone();
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fsC.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.jTv.setNextPage(this.fsC);
    }

    private void cGK() {
        this.jTz = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.jTz.setVisibility(8);
        this.jTz.setClickable(false);
        this.jTz.setEnabled(false);
        this.jTA = (TextView) this.jTz.findViewById(R.id.person_list_title);
        this.jTv.addHeaderView(this.jTz, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWf() {
        if (this.jTK == null) {
            this.jTK = new com.baidu.tieba.c.e(getPageContext(), this.jTJ.jTc);
            this.jTK.cS(R.drawable.bg_tip_blue_up);
            this.jTK.setMaxShowTime(2);
            this.jTK.cT(3000);
            this.jTK.tr(-10);
            this.jTK.setYOffset(-16);
            this.jTK.c(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.jTK != null) {
                        PersonListActivity.this.jTK.HN();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(bb bbVar, boolean z) {
        if (this.mModel != null && bbVar != null && (!z || !this.jTD)) {
            if (!z) {
                this.jTD = true;
                d(bbVar);
            }
            b(bbVar);
            d(bbVar, z);
            if (!this.mModel.bCk()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bfl().setMsgFans(0);
            }
            b(bbVar, z);
        }
    }

    private void b(bb bbVar) {
        if (bbVar != null) {
            if (!bbVar.hasMore && !StringUtils.isNull(bbVar.dQm) && !this.jTG) {
                bo(bbVar.dQm, bbVar.type);
                this.jTv.removeFooterView(this.jTL);
                this.jTv.addFooterView(this.jTL);
                this.jTv.removeFooterView(this.fsC.getView());
                TiebaStatic.log(new ap("c13106").ah("obj_locate", 2));
            } else if (!bbVar.hasMore) {
                this.jTv.removeFooterView(this.jTL);
                this.fsC.setText(getString(R.string.no_more_data_tip));
                this.fsC.endLoadData();
            } else {
                this.jTv.removeFooterView(this.jTL);
                this.fsC.setText(getString(R.string.pb_load_more));
                this.fsC.endLoadData();
            }
        }
    }

    private void b(bb bbVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (bbVar.dQl > 0 && !x.isEmpty(bbVar.aVe())) {
                c(bbVar);
            } else {
                c(bbVar, z);
            }
        }
    }

    private void c(bb bbVar) {
        String string;
        String string2;
        boolean z;
        TextView textView;
        String str;
        String str2;
        String string3;
        String string4;
        if (bbVar != null) {
            this.jTv.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bCk()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.jTw.setVisibility(0);
                    this.jTv.removeHeaderView(this.jTz);
                    TextView textView2 = this.jTy;
                    textView2.setVisibility(0);
                    this.jTJ.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    String string5 = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.m31do(null, getResources().getString(R.string.not_have_attention)));
                    z = false;
                    str = string4;
                    textView = textView2;
                    str2 = string5;
                } else {
                    this.jTw.setVisibility(8);
                    this.jTz.setVisibility(0);
                    TextView textView3 = this.jTA;
                    textView3.setVisibility(8);
                    this.jTJ.setVisibility(8);
                    if (this.fVA == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.fVA == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.m31do(null, getResources().getString(R.string.not_have_attention_guest)));
                    String string6 = getPageContext().getString(R.string.person);
                    str = string3;
                    textView = textView3;
                    z = x.isEmpty(bbVar.aVf()) ? false : true;
                    str2 = string6;
                }
            } else {
                this.jTw.setVisibility(8);
                this.jTz.setVisibility(0);
                TextView textView4 = this.jTA;
                this.jTJ.setVisibility(8);
                textView4.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    String string7 = getPageContext().getString(R.string.my_fans_prefix);
                    String string8 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.m31do(null, getResources().getString(R.string.not_have_fans)));
                    z = false;
                    textView = textView4;
                    str = string7;
                    str2 = string8;
                } else {
                    if (this.fVA == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.fVA == 1) {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.m31do(null, getResources().getString(R.string.her_no_fan_guest)));
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
            textView.setText(str + as.numberUniformFormat(bbVar.dQl) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(bb bbVar, boolean z) {
        String string;
        this.jTv.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bCk()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.jTJ.setVisibility(0);
                this.jTy.setVisibility(0);
                this.jTw.setVisibility(0);
                this.jTz.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.m31do(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.jTy.setText(string + 0 + string2);
                return;
            }
            this.jTJ.setVisibility(8);
            this.jTy.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.m31do(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.jTJ.setVisibility(8);
        this.jTy.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (bbVar != null && !StringUtils.isNull(bbVar.dQm) && !this.jTG) {
                this.mNoDataView.getSuTextView().setText(bp(bbVar.dQm, bbVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new ap("c13106").ah("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.m31do(null, getResources().getString(R.string.not_have_fans)));
            return;
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.m31do(null, getResources().getString(R.string.her_no_fan_guest)));
    }

    private void d(bb bbVar) {
        this.mModel.setPage(bbVar.pageNum);
    }

    private void d(bb bbVar, boolean z) {
        if (this.jTB != null) {
            if (!z) {
                if (bbVar.pageNum == 1) {
                    this.jTB.resetData();
                }
                this.jTB.setHasMore(bbVar.hasMore);
                this.jTB.a(bbVar);
                this.jTB.bCi();
                this.jTB.notifyDataSetChanged();
                return;
            }
            this.jTB.setHasMore(false);
            this.jTB.a(bbVar);
            this.jTB.bCi();
            this.jTB.notifyDataSetChanged();
        }
    }

    private void bCo() {
        showLoadingView(this.mContainer);
        this.mModel.bCl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGL() {
        if (this.jTB != null) {
            this.jTB.notifyDataSetChanged();
        }
        this.mModel.bCl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGM() {
        UserData userData;
        if (this.jTB != null && this.jTB.getItemViewType(this.jTI) == 0 && (userData = (UserData) this.jTB.getItem(this.jTI)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            cGM();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jTJ.cGH()) {
                this.jTJ.closeView();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bo(String str, int i) {
        if (this.jTL == null) {
            this.jTL = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.jTM = (TextView) this.jTL.findViewById(R.id.view_forbidden_tip);
            ao.setViewTextColor(this.jTM, R.color.cp_cont_d);
            ao.setBackgroundColor(this.jTL, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.jTL.setVisibility(8);
            return;
        }
        this.jTM.setText(bp(str, i));
        this.jTM.setMovementMethod(LinkMovementMethod.getInstance());
        this.jTM.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private SpannableStringBuilder bp(String str, int i) {
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
                    PersonListActivity.this.cGO();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ao.getColor(R.color.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.cGN();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ao.getColor(R.color.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGN() {
        TiebaStatic.log(new ap("c13104").ah("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.jTN.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGO() {
        TiebaStatic.log(new ap("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
