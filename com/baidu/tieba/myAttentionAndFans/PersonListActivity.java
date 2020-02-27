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
    private PbListView eli;
    private NavigationBarCoverTip gjd;
    private TextView gji;
    private boolean irG;
    private NavigationBarShadowView irH;
    private NavigationBarShadowView irI;
    private ConcernSelectView irM;
    private com.baidu.tieba.c.d irN;
    private View irO;
    private TextView irP;
    private e irQ;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView iry = null;
    private View irz = null;
    private View irA = null;
    private TextView irB = null;
    private View irC = null;
    private TextView irD = null;
    private b irE = null;
    private NoPressedRelativeLayout irF = null;
    private boolean fyr = true;
    private TextView aCS = null;
    private int eLM = 0;
    private boolean irJ = false;
    private int irK = 0;
    int irL = 0;
    private final AntiHelper.a gpq = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener gpr = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().dnT != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().dnT, PersonListActivity.this.gpq) != null) {
                            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener irR = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.irE.em(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.irE.bgH();
                    PersonListActivity.this.irE.notifyDataSetChanged();
                }
                if (PersonListActivity.this.irE.eLC) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bgJ()) {
                        PersonListActivity.this.irH.show();
                    } else {
                        PersonListActivity.this.irI.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bgJ()) {
                    PersonListActivity.this.irH.hide();
                } else {
                    PersonListActivity.this.irI.hide();
                }
            }
        }
    };
    public PersonListModel.a irS = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
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
            if (avVar != null && avVar.cQf != PersonListActivity.this.irK && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bgJ() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.Fl(PersonListActivity.this.mPortrait);
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
        this.irQ = new e(getPageContext(), getUniqueId());
        this.irQ.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.gji == null) {
                            PersonListActivity.this.gji = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.gji.setGravity(19);
                            PersonListActivity.this.gji.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.gji.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.gji.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.gji.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        PersonListActivity.this.gji.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.gjd.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.gjd.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.gjd.a(PersonListActivity.this.getActivity(), PersonListActivity.this.gji, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.irP.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    am.setViewTextColor(PersonListActivity.this.irP, (int) R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bCg() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.gpr);
        registerListener(this.irR);
        this.mModel.bcb();
        if (this.fyr) {
            this.fyr = false;
            bgN();
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
        am.setBackgroundResource(this.irF, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.mContainer, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.irE != null) {
            this.irE.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.irM.onChangeSkinType(i);
        am.setBackgroundColor(this.irB, R.color.cp_bg_line_d);
        am.setViewTextColor(this.irB, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.irD, R.color.cp_bg_line_d);
        am.setViewTextColor(this.irD, (int) R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.irA != null) {
            getLayoutMode().onModeChanged(this.irA);
        }
        if (this.irC != null) {
            getLayoutMode().onModeChanged(this.irC);
        }
        if (this.irO != null) {
            am.setViewTextColor(this.irP, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.irO, R.color.cp_bg_line_d);
        }
        this.irQ.onChangeSkinType();
        this.eli.setTextColor(am.getColor(R.color.cp_cont_d));
        this.eli.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.irE != null) {
            this.irE = null;
        }
        if (this.irN != null) {
            this.irN.zx();
        }
        this.gjd.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.irS);
        if (bundle != null) {
            this.mModel.iJ(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.eLM = bundle.getInt("user_sex");
            this.irJ = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.irK = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.eLM);
            return;
        }
        Intent intent = getIntent();
        this.mModel.iJ(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.eLM = intent.getIntExtra("user_sex", 0);
        this.irJ = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.irK = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.eLM);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bgJ());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.eLM);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.irJ);
    }

    private void initUI() {
        boolean z = true;
        this.irF = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.aCS = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.irH = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.irI = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.irz = findViewById(R.id.sub_title_root);
        this.irA = this.irz.findViewById(R.id.newheader_root);
        this.irz.setVisibility(8);
        this.irz.setClickable(false);
        this.irz.setEnabled(false);
        this.irB = (TextView) this.irz.findViewById(R.id.person_list_title);
        this.irM = (ConcernSelectView) findViewById(R.id.select_layout);
        this.gjd = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bgJ()) {
                this.aCS.setText(R.string.my_attention);
                this.irF.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void q(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.irM.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.irM.chg() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.irF.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.irM.closeView();
                        PersonListActivity.this.irF.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.aCS.setText(R.string.fans);
            }
        } else if (this.mModel.bgJ()) {
            if (this.eLM == 2) {
                this.aCS.setText(R.string.her_attention_people);
            } else if (this.eLM == 1) {
                this.aCS.setText(R.string.his_attention_people);
            } else {
                this.aCS.setText(R.string.its_attention_people);
            }
        } else if (this.eLM == 2) {
            this.aCS.setText(R.string.attention_to_her);
        } else if (this.eLM == 1) {
            this.aCS.setText(R.string.attention_to_him);
        } else {
            this.aCS.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.irE != null && PersonListActivity.this.irE.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.irE.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bgJ()) {
                            TiebaStatic.log(new an("c12772").cy("obj_locate", "1").cy("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new an("c12605").X("obj_locate", 1).cy("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.irL = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.chl();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.chk();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.irE = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.irz.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.irF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.irE = new c(this, z, sex, onClickListener, onClickListener3);
            this.irz.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.irF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.iry = (BdListView) findViewById(R.id.list);
        this.iry.setAdapter((ListAdapter) this.irE);
        chj();
        this.iry.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.irE != null && PersonListActivity.this.irE.isHasMore()) {
                    if (PersonListActivity.this.eli != null && !PersonListActivity.this.eli.isLoading()) {
                        PersonListActivity.this.eli.startLoadData();
                    }
                    PersonListActivity.this.chk();
                }
            }
        });
        this.iry.setOnScrollListener(this.mOnScrollListener);
        this.irM.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void oT(boolean z2) {
                if (z2) {
                    PersonListActivity.this.bzf();
                } else if (PersonListActivity.this.irN != null) {
                    PersonListActivity.this.irN.zx();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void tX(int i) {
                PersonListActivity.this.iry.setSelection(0);
                PersonListActivity.this.mModel.oF(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.aFB().getInt(SharedPrefConfig.KEY_MY_CONCERNED_PERSON_TIP, 0) < 2 && z && this.mModel.bgJ()) {
            this.irM.chf();
        }
        this.irM.setVisibility(8);
        this.irC.setVisibility(8);
        this.eli = new PbListView(getActivity());
        this.eli.getView();
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.eli.setLineGone();
        this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
        this.eli.setTextSize(R.dimen.tbfontsize33);
        this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
        this.eli.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.iry.setNextPage(this.eli);
    }

    private void chj() {
        this.irC = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.irC.setVisibility(8);
        this.irC.setClickable(false);
        this.irC.setEnabled(false);
        this.irD = (TextView) this.irC.findViewById(R.id.person_list_title);
        this.iry.addHeaderView(this.irC, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzf() {
        if (this.irN == null) {
            this.irN = new com.baidu.tieba.c.d(getPageContext(), this.irM.irf);
            this.irN.ck(R.drawable.bg_tip_blue_up);
            this.irN.ry(2);
            this.irN.cl(3000);
            this.irN.rz(-10);
            this.irN.setYOffset(-16);
            this.irN.c(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.irN != null) {
                        PersonListActivity.this.irN.zx();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(av avVar, boolean z) {
        if (this.mModel != null && avVar != null && (!z || !this.irG)) {
            if (!z) {
                this.irG = true;
                d(avVar);
            }
            b(avVar);
            d(avVar, z);
            if (!this.mModel.bgJ()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aKC().setMsgFans(0);
            }
            b(avVar, z);
        }
    }

    private void b(av avVar) {
        if (avVar != null) {
            if (!avVar.hasMore && !StringUtils.isNull(avVar.cQg) && !this.irJ) {
                bg(avVar.cQg, avVar.type);
                this.iry.removeFooterView(this.irO);
                this.iry.addFooterView(this.irO);
                this.iry.removeFooterView(this.eli.getView());
                TiebaStatic.log(new an("c13106").X("obj_locate", 2));
            } else if (!avVar.hasMore) {
                this.iry.removeFooterView(this.irO);
                this.eli.setText(getString(R.string.no_more_data_tip));
                this.eli.endLoadData();
            } else {
                this.iry.removeFooterView(this.irO);
                this.eli.setText(getString(R.string.pb_load_more));
                this.eli.endLoadData();
            }
        }
    }

    private void b(av avVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (avVar.cQf > 0 && !v.isEmpty(avVar.aBl())) {
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
            this.iry.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bgJ()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.irz.setVisibility(0);
                    this.iry.removeHeaderView(this.irC);
                    TextView textView2 = this.irB;
                    textView2.setVisibility(0);
                    this.irM.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    String string5 = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, getResources().getString(R.string.not_have_attention)));
                    z = false;
                    str = string4;
                    textView = textView2;
                    str2 = string5;
                } else {
                    this.irz.setVisibility(8);
                    this.irC.setVisibility(0);
                    TextView textView3 = this.irD;
                    textView3.setVisibility(8);
                    this.irM.setVisibility(8);
                    if (this.eLM == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.eLM == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, getResources().getString(R.string.not_have_attention_guest)));
                    String string6 = getPageContext().getString(R.string.person);
                    str = string3;
                    textView = textView3;
                    z = v.isEmpty(avVar.aBm()) ? false : true;
                    str2 = string6;
                }
            } else {
                this.irz.setVisibility(8);
                this.irC.setVisibility(0);
                TextView textView4 = this.irD;
                this.irM.setVisibility(8);
                textView4.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    String string7 = getPageContext().getString(R.string.my_fans_prefix);
                    String string8 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, getResources().getString(R.string.not_have_fans)));
                    z = false;
                    textView = textView4;
                    str = string7;
                    str2 = string8;
                } else {
                    if (this.eLM == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.eLM == 1) {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, getResources().getString(R.string.her_no_fan_guest)));
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
            textView.setText(str + aq.numberUniformFormat(avVar.cQf) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(av avVar, boolean z) {
        String string;
        this.iry.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bgJ()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.irM.setVisibility(0);
                this.irB.setVisibility(0);
                this.irz.setVisibility(0);
                this.irC.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.irB.setText(string + 0 + string2);
                return;
            }
            this.irM.setVisibility(8);
            this.irB.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.irM.setVisibility(8);
        this.irB.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (avVar != null && !StringUtils.isNull(avVar.cQg) && !this.irJ) {
                this.mNoDataView.getSuTextView().setText(bh(avVar.cQg, avVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new an("c13106").X("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, getResources().getString(R.string.not_have_fans)));
            return;
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, getResources().getString(R.string.her_no_fan_guest)));
    }

    private void d(av avVar) {
        this.mModel.setPage(avVar.pageNum);
    }

    private void d(av avVar, boolean z) {
        if (this.irE != null) {
            if (!z) {
                if (avVar.pageNum == 1) {
                    this.irE.resetData();
                }
                this.irE.setHasMore(avVar.hasMore);
                this.irE.a(avVar);
                this.irE.bgH();
                this.irE.notifyDataSetChanged();
                return;
            }
            this.irE.setHasMore(false);
            this.irE.a(avVar);
            this.irE.bgH();
            this.irE.notifyDataSetChanged();
        }
    }

    private void bgN() {
        showLoadingView(this.mContainer);
        this.mModel.bgK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chk() {
        if (this.irE != null) {
            this.irE.notifyDataSetChanged();
        }
        this.mModel.bgK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chl() {
        UserData userData;
        if (this.irE != null && this.irE.getItemViewType(this.irL) == 0 && (userData = (UserData) this.irE.getItem(this.irL)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            chl();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.irM.chg()) {
                this.irM.closeView();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bg(String str, int i) {
        if (this.irO == null) {
            this.irO = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.irP = (TextView) this.irO.findViewById(R.id.view_forbidden_tip);
            am.setViewTextColor(this.irP, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.irO, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.irO.setVisibility(8);
            return;
        }
        this.irP.setText(bh(str, i));
        this.irP.setMovementMethod(LinkMovementMethod.getInstance());
        this.irP.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private SpannableStringBuilder bh(String str, int i) {
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
                    PersonListActivity.this.chn();
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
                    PersonListActivity.this.chm();
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
    public void chm() {
        TiebaStatic.log(new an("c13104").X("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.irQ.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chn() {
        TiebaStatic.log(new an("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
