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
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes10.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView fnt;
    private NavigationBarCoverTip hut;
    private TextView huy;
    private boolean jLd;
    private NavigationBarShadowView jLe;
    private NavigationBarShadowView jLf;
    private ConcernSelectView jLj;
    private e jLk;
    private View jLl;
    private TextView jLm;
    private com.baidu.tieba.forbidden.fans.e jLn;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView jKV = null;
    private View jKW = null;
    private View jKX = null;
    private TextView jKY = null;
    private View jKZ = null;
    private TextView jLa = null;
    private b jLb = null;
    private NoPressedRelativeLayout jLc = null;
    private boolean gjX = true;
    private TextView bjy = null;
    private int fQh = 0;
    private boolean jLg = false;
    private int jLh = 0;
    int jLi = 0;
    private final AntiHelper.a hAZ = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", av.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", av.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener hBa = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().els != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().els, PersonListActivity.this.hAZ) != null) {
                    TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", av.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener jLo = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.jLb.fb(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.jLb.byT();
                    PersonListActivity.this.jLb.notifyDataSetChanged();
                }
                if (PersonListActivity.this.jLb.fPX) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.byV()) {
                        PersonListActivity.this.jLe.show();
                    } else {
                        PersonListActivity.this.jLf.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.byV()) {
                    PersonListActivity.this.jLe.hide();
                } else {
                    PersonListActivity.this.jLf.hide();
                }
            }
        }
    };
    public PersonListModel.a jLp = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void at(String str, boolean z) {
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
        public ba e(ba baVar, boolean z) {
            if (baVar != null && baVar.dJZ != PersonListActivity.this.jLh && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.byV() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.Ji(PersonListActivity.this.mPortrait);
            }
            PersonListActivity.this.a(baVar, z);
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
        this.jLn = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.jLn.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.huy == null) {
                            PersonListActivity.this.huy = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.huy.setGravity(19);
                            PersonListActivity.this.huy.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.huy.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.huy.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.huy.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        PersonListActivity.this.huy.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.hut.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.hut.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.hut.a(PersonListActivity.this.getActivity(), PersonListActivity.this.huy, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.jLm.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    an.setViewTextColor(PersonListActivity.this.jLm, (int) R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bWh() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.hBa);
        registerListener(this.jLo);
        this.mModel.bts();
        if (this.gjX) {
            this.gjX = false;
            byZ();
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
        an.setBackgroundResource(this.jLc, R.color.cp_bg_line_d);
        an.setBackgroundResource(this.mContainer, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.jLb != null) {
            this.jLb.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.jLj.onChangeSkinType(i);
        an.setBackgroundColor(this.jKY, R.color.cp_bg_line_d);
        an.setViewTextColor(this.jKY, (int) R.color.cp_cont_d);
        an.setBackgroundColor(this.jLa, R.color.cp_bg_line_d);
        an.setViewTextColor(this.jLa, (int) R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.jKX != null) {
            getLayoutMode().onModeChanged(this.jKX);
        }
        if (this.jKZ != null) {
            getLayoutMode().onModeChanged(this.jKZ);
        }
        if (this.jLl != null) {
            an.setViewTextColor(this.jLm, (int) R.color.cp_cont_d);
            an.setBackgroundColor(this.jLl, R.color.cp_bg_line_d);
        }
        this.jLn.onChangeSkinType();
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
        this.fnt.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jLb != null) {
            this.jLb = null;
        }
        if (this.jLk != null) {
            this.jLk.HH();
        }
        this.hut.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.jLp);
        if (bundle != null) {
            this.mModel.kt(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fQh = bundle.getInt("user_sex");
            this.jLg = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.jLh = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.fQh);
            return;
        }
        Intent intent = getIntent();
        this.mModel.kt(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fQh = intent.getIntExtra("user_sex", 0);
        this.jLg = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.jLh = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.fQh);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.byV());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.fQh);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.jLg);
    }

    private void initUI() {
        boolean z = true;
        this.jLc = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bjy = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jLe = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.jLf = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.jKW = findViewById(R.id.sub_title_root);
        this.jKX = this.jKW.findViewById(R.id.newheader_root);
        this.jKW.setVisibility(8);
        this.jKW.setClickable(false);
        this.jKW.setEnabled(false);
        this.jKY = (TextView) this.jKW.findViewById(R.id.person_list_title);
        this.jLj = (ConcernSelectView) findViewById(R.id.select_layout);
        this.hut = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.byV()) {
                this.bjy.setText(R.string.my_attention);
                this.jLc.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void p(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.jLj.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.jLj.cCY() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.jLc.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.jLj.closeView();
                        PersonListActivity.this.jLc.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.bjy.setText(R.string.fans);
            }
        } else if (this.mModel.byV()) {
            if (this.fQh == 2) {
                this.bjy.setText(R.string.her_attention_people);
            } else if (this.fQh == 1) {
                this.bjy.setText(R.string.his_attention_people);
            } else {
                this.bjy.setText(R.string.its_attention_people);
            }
        } else if (this.fQh == 2) {
            this.bjy.setText(R.string.attention_to_her);
        } else if (this.fQh == 1) {
            this.bjy.setText(R.string.attention_to_him);
        } else {
            this.bjy.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.jLb != null && PersonListActivity.this.jLb.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.jLb.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.byV()) {
                            TiebaStatic.log(new ao("c12772").dk("obj_locate", "1").dk("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new ao("c12605").ag("obj_locate", 1).dk("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.jLi = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.cDd();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.cDc();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.jLb = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.jKW.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.jLc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.jLb = new c(this, z, sex, onClickListener, onClickListener3);
            this.jKW.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.jLc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.jKV = (BdListView) findViewById(R.id.list);
        this.jKV.setAdapter((ListAdapter) this.jLb);
        cDb();
        this.jKV.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.jLb != null && PersonListActivity.this.jLb.isHasMore()) {
                    if (PersonListActivity.this.fnt != null && !PersonListActivity.this.fnt.isLoading()) {
                        PersonListActivity.this.fnt.startLoadData();
                    }
                    PersonListActivity.this.cDc();
                }
            }
        });
        this.jKV.setOnScrollListener(this.mOnScrollListener);
        this.jLj.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void qK(boolean z2) {
                if (z2) {
                    PersonListActivity.this.bSN();
                } else if (PersonListActivity.this.jLk != null) {
                    PersonListActivity.this.jLk.HH();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void vN(int i) {
                PersonListActivity.this.jKV.setSelection(0);
                PersonListActivity.this.mModel.qc(i);
            }
        });
        this.jLj.setVisibility(8);
        this.jKZ.setVisibility(8);
        this.fnt = new PbListView(getActivity());
        this.fnt.getView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setLineGone();
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fnt.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.jKV.setNextPage(this.fnt);
    }

    private void cDb() {
        this.jKZ = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.jKZ.setVisibility(8);
        this.jKZ.setClickable(false);
        this.jKZ.setEnabled(false);
        this.jLa = (TextView) this.jKZ.findViewById(R.id.person_list_title);
        this.jKV.addHeaderView(this.jKZ, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSN() {
        if (this.jLk == null) {
            this.jLk = new com.baidu.tieba.c.e(getPageContext(), this.jLj.jKC);
            this.jLk.cS(R.drawable.bg_tip_blue_up);
            this.jLk.setMaxShowTime(2);
            this.jLk.cT(3000);
            this.jLk.sZ(-10);
            this.jLk.setYOffset(-16);
            this.jLk.c(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.jLk != null) {
                        PersonListActivity.this.jLk.HH();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(ba baVar, boolean z) {
        if (this.mModel != null && baVar != null && (!z || !this.jLd)) {
            if (!z) {
                this.jLd = true;
                d(baVar);
            }
            b(baVar);
            d(baVar, z);
            if (!this.mModel.byV()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bbo().setMsgFans(0);
            }
            b(baVar, z);
        }
    }

    private void b(ba baVar) {
        if (baVar != null) {
            if (!baVar.hasMore && !StringUtils.isNull(baVar.dKa) && !this.jLg) {
                bq(baVar.dKa, baVar.type);
                this.jKV.removeFooterView(this.jLl);
                this.jKV.addFooterView(this.jLl);
                this.jKV.removeFooterView(this.fnt.getView());
                TiebaStatic.log(new ao("c13106").ag("obj_locate", 2));
            } else if (!baVar.hasMore) {
                this.jKV.removeFooterView(this.jLl);
                this.fnt.setText(getString(R.string.no_more_data_tip));
                this.fnt.endLoadData();
            } else {
                this.jKV.removeFooterView(this.jLl);
                this.fnt.setText(getString(R.string.pb_load_more));
                this.fnt.endLoadData();
            }
        }
    }

    private void b(ba baVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (baVar.dJZ > 0 && !w.isEmpty(baVar.aRi())) {
                c(baVar);
            } else {
                c(baVar, z);
            }
        }
    }

    private void c(ba baVar) {
        String string;
        String string2;
        boolean z;
        TextView textView;
        String str;
        String str2;
        String string3;
        String string4;
        if (baVar != null) {
            this.jKV.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.byV()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.jKW.setVisibility(0);
                    this.jKV.removeHeaderView(this.jKZ);
                    TextView textView2 = this.jKY;
                    textView2.setVisibility(0);
                    this.jLj.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    String string5 = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dm(null, getResources().getString(R.string.not_have_attention)));
                    z = false;
                    str = string4;
                    textView = textView2;
                    str2 = string5;
                } else {
                    this.jKW.setVisibility(8);
                    this.jKZ.setVisibility(0);
                    TextView textView3 = this.jLa;
                    textView3.setVisibility(8);
                    this.jLj.setVisibility(8);
                    if (this.fQh == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.fQh == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dm(null, getResources().getString(R.string.not_have_attention_guest)));
                    String string6 = getPageContext().getString(R.string.person);
                    str = string3;
                    textView = textView3;
                    z = w.isEmpty(baVar.aRj()) ? false : true;
                    str2 = string6;
                }
            } else {
                this.jKW.setVisibility(8);
                this.jKZ.setVisibility(0);
                TextView textView4 = this.jLa;
                this.jLj.setVisibility(8);
                textView4.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    String string7 = getPageContext().getString(R.string.my_fans_prefix);
                    String string8 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dm(null, getResources().getString(R.string.not_have_fans)));
                    z = false;
                    textView = textView4;
                    str = string7;
                    str2 = string8;
                } else {
                    if (this.fQh == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.fQh == 1) {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dm(null, getResources().getString(R.string.her_no_fan_guest)));
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
            textView.setText(str + ar.numberUniformFormat(baVar.dJZ) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ba baVar, boolean z) {
        String string;
        this.jKV.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.byV()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.jLj.setVisibility(0);
                this.jKY.setVisibility(0);
                this.jKW.setVisibility(0);
                this.jKZ.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dm(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.jKY.setText(string + 0 + string2);
                return;
            }
            this.jLj.setVisibility(8);
            this.jKY.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dm(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.jLj.setVisibility(8);
        this.jKY.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (baVar != null && !StringUtils.isNull(baVar.dKa) && !this.jLg) {
                this.mNoDataView.getSuTextView().setText(br(baVar.dKa, baVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new ao("c13106").ag("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dm(null, getResources().getString(R.string.not_have_fans)));
            return;
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dm(null, getResources().getString(R.string.her_no_fan_guest)));
    }

    private void d(ba baVar) {
        this.mModel.setPage(baVar.pageNum);
    }

    private void d(ba baVar, boolean z) {
        if (this.jLb != null) {
            if (!z) {
                if (baVar.pageNum == 1) {
                    this.jLb.resetData();
                }
                this.jLb.setHasMore(baVar.hasMore);
                this.jLb.a(baVar);
                this.jLb.byT();
                this.jLb.notifyDataSetChanged();
                return;
            }
            this.jLb.setHasMore(false);
            this.jLb.a(baVar);
            this.jLb.byT();
            this.jLb.notifyDataSetChanged();
        }
    }

    private void byZ() {
        showLoadingView(this.mContainer);
        this.mModel.byW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDc() {
        if (this.jLb != null) {
            this.jLb.notifyDataSetChanged();
        }
        this.mModel.byW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDd() {
        UserData userData;
        if (this.jLb != null && this.jLb.getItemViewType(this.jLi) == 0 && (userData = (UserData) this.jLb.getItem(this.jLi)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            cDd();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jLj.cCY()) {
                this.jLj.closeView();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bq(String str, int i) {
        if (this.jLl == null) {
            this.jLl = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.jLm = (TextView) this.jLl.findViewById(R.id.view_forbidden_tip);
            an.setViewTextColor(this.jLm, (int) R.color.cp_cont_d);
            an.setBackgroundColor(this.jLl, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.jLl.setVisibility(8);
            return;
        }
        this.jLm.setText(br(str, i));
        this.jLm.setMovementMethod(LinkMovementMethod.getInstance());
        this.jLm.setHighlightColor(getResources().getColor(R.color.transparent));
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
                    PersonListActivity.this.cDf();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(an.getColor(R.color.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.cDe();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(an.getColor(R.color.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDe() {
        TiebaStatic.log(new ao("c13104").ag("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.jLn.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDf() {
        TiebaStatic.log(new ao("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
