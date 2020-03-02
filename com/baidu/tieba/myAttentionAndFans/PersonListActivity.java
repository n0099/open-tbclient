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
    private PbListView elj;
    private NavigationBarCoverTip gjf;
    private TextView gjk;
    private boolean irI;
    private NavigationBarShadowView irJ;
    private NavigationBarShadowView irK;
    private ConcernSelectView irO;
    private com.baidu.tieba.c.d irP;
    private View irQ;
    private TextView irR;
    private e irS;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView irA = null;
    private View irB = null;
    private View irC = null;
    private TextView irD = null;
    private View irE = null;
    private TextView irF = null;
    private b irG = null;
    private NoPressedRelativeLayout irH = null;
    private boolean fys = true;
    private TextView aCT = null;
    private int eLN = 0;
    private boolean irL = false;
    private int irM = 0;
    int irN = 0;
    private final AntiHelper.a gps = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener gpt = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().dnU != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().dnU, PersonListActivity.this.gps) != null) {
                            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener irT = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.irG.em(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.irG.bgJ();
                    PersonListActivity.this.irG.notifyDataSetChanged();
                }
                if (PersonListActivity.this.irG.eLD) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bgL()) {
                        PersonListActivity.this.irJ.show();
                    } else {
                        PersonListActivity.this.irK.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bgL()) {
                    PersonListActivity.this.irJ.hide();
                } else {
                    PersonListActivity.this.irK.hide();
                }
            }
        }
    };
    public PersonListModel.a irU = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
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
            if (avVar != null && avVar.cQg != PersonListActivity.this.irM && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bgL() && PersonListActivity.this.mModel.getLoadType() == 0) {
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
        this.irS = new e(getPageContext(), getUniqueId());
        this.irS.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.gjk == null) {
                            PersonListActivity.this.gjk = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.gjk.setGravity(19);
                            PersonListActivity.this.gjk.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.gjk.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.gjk.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.gjk.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        PersonListActivity.this.gjk.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.gjf.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.gjf.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.gjf.a(PersonListActivity.this.getActivity(), PersonListActivity.this.gjk, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.irR.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    am.setViewTextColor(PersonListActivity.this.irR, (int) R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bCi() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.gpt);
        registerListener(this.irT);
        this.mModel.bcd();
        if (this.fys) {
            this.fys = false;
            bgP();
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
        am.setBackgroundResource(this.irH, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.mContainer, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.irG != null) {
            this.irG.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.irO.onChangeSkinType(i);
        am.setBackgroundColor(this.irD, R.color.cp_bg_line_d);
        am.setViewTextColor(this.irD, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.irF, R.color.cp_bg_line_d);
        am.setViewTextColor(this.irF, (int) R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.irC != null) {
            getLayoutMode().onModeChanged(this.irC);
        }
        if (this.irE != null) {
            getLayoutMode().onModeChanged(this.irE);
        }
        if (this.irQ != null) {
            am.setViewTextColor(this.irR, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.irQ, R.color.cp_bg_line_d);
        }
        this.irS.onChangeSkinType();
        this.elj.setTextColor(am.getColor(R.color.cp_cont_d));
        this.elj.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.irG != null) {
            this.irG = null;
        }
        if (this.irP != null) {
            this.irP.zz();
        }
        this.gjf.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.irU);
        if (bundle != null) {
            this.mModel.iJ(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.eLN = bundle.getInt("user_sex");
            this.irL = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.irM = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.eLN);
            return;
        }
        Intent intent = getIntent();
        this.mModel.iJ(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.eLN = intent.getIntExtra("user_sex", 0);
        this.irL = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.irM = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.eLN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bgL());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.eLN);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.irL);
    }

    private void initUI() {
        boolean z = true;
        this.irH = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.aCT = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.irJ = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.irK = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.irB = findViewById(R.id.sub_title_root);
        this.irC = this.irB.findViewById(R.id.newheader_root);
        this.irB.setVisibility(8);
        this.irB.setClickable(false);
        this.irB.setEnabled(false);
        this.irD = (TextView) this.irB.findViewById(R.id.person_list_title);
        this.irO = (ConcernSelectView) findViewById(R.id.select_layout);
        this.gjf = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bgL()) {
                this.aCT.setText(R.string.my_attention);
                this.irH.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void q(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.irO.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.irO.chi() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.irH.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.irO.closeView();
                        PersonListActivity.this.irH.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.aCT.setText(R.string.fans);
            }
        } else if (this.mModel.bgL()) {
            if (this.eLN == 2) {
                this.aCT.setText(R.string.her_attention_people);
            } else if (this.eLN == 1) {
                this.aCT.setText(R.string.his_attention_people);
            } else {
                this.aCT.setText(R.string.its_attention_people);
            }
        } else if (this.eLN == 2) {
            this.aCT.setText(R.string.attention_to_her);
        } else if (this.eLN == 1) {
            this.aCT.setText(R.string.attention_to_him);
        } else {
            this.aCT.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.irG != null && PersonListActivity.this.irG.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.irG.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bgL()) {
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
                PersonListActivity.this.irN = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.chn();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.chm();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.irG = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.irB.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.irH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.irG = new c(this, z, sex, onClickListener, onClickListener3);
            this.irB.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.irH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.irA = (BdListView) findViewById(R.id.list);
        this.irA.setAdapter((ListAdapter) this.irG);
        chl();
        this.irA.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.irG != null && PersonListActivity.this.irG.isHasMore()) {
                    if (PersonListActivity.this.elj != null && !PersonListActivity.this.elj.isLoading()) {
                        PersonListActivity.this.elj.startLoadData();
                    }
                    PersonListActivity.this.chm();
                }
            }
        });
        this.irA.setOnScrollListener(this.mOnScrollListener);
        this.irO.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void oT(boolean z2) {
                if (z2) {
                    PersonListActivity.this.bzh();
                } else if (PersonListActivity.this.irP != null) {
                    PersonListActivity.this.irP.zz();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void tX(int i) {
                PersonListActivity.this.irA.setSelection(0);
                PersonListActivity.this.mModel.oF(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_MY_CONCERNED_PERSON_TIP, 0) < 2 && z && this.mModel.bgL()) {
            this.irO.chh();
        }
        this.irO.setVisibility(8);
        this.irE.setVisibility(8);
        this.elj = new PbListView(getActivity());
        this.elj.getView();
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elj.setLineGone();
        this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elj.setTextSize(R.dimen.tbfontsize33);
        this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elj.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.irA.setNextPage(this.elj);
    }

    private void chl() {
        this.irE = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.irE.setVisibility(8);
        this.irE.setClickable(false);
        this.irE.setEnabled(false);
        this.irF = (TextView) this.irE.findViewById(R.id.person_list_title);
        this.irA.addHeaderView(this.irE, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzh() {
        if (this.irP == null) {
            this.irP = new com.baidu.tieba.c.d(getPageContext(), this.irO.irh);
            this.irP.ck(R.drawable.bg_tip_blue_up);
            this.irP.ry(2);
            this.irP.cl(3000);
            this.irP.rz(-10);
            this.irP.setYOffset(-16);
            this.irP.c(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.irP != null) {
                        PersonListActivity.this.irP.zz();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(av avVar, boolean z) {
        if (this.mModel != null && avVar != null && (!z || !this.irI)) {
            if (!z) {
                this.irI = true;
                d(avVar);
            }
            b(avVar);
            d(avVar, z);
            if (!this.mModel.bgL()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aKE().setMsgFans(0);
            }
            b(avVar, z);
        }
    }

    private void b(av avVar) {
        if (avVar != null) {
            if (!avVar.hasMore && !StringUtils.isNull(avVar.cQh) && !this.irL) {
                bg(avVar.cQh, avVar.type);
                this.irA.removeFooterView(this.irQ);
                this.irA.addFooterView(this.irQ);
                this.irA.removeFooterView(this.elj.getView());
                TiebaStatic.log(new an("c13106").X("obj_locate", 2));
            } else if (!avVar.hasMore) {
                this.irA.removeFooterView(this.irQ);
                this.elj.setText(getString(R.string.no_more_data_tip));
                this.elj.endLoadData();
            } else {
                this.irA.removeFooterView(this.irQ);
                this.elj.setText(getString(R.string.pb_load_more));
                this.elj.endLoadData();
            }
        }
    }

    private void b(av avVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (avVar.cQg > 0 && !v.isEmpty(avVar.aBn())) {
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
            this.irA.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bgL()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.irB.setVisibility(0);
                    this.irA.removeHeaderView(this.irE);
                    TextView textView2 = this.irD;
                    textView2.setVisibility(0);
                    this.irO.setVisibility(0);
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
                    this.irB.setVisibility(8);
                    this.irE.setVisibility(0);
                    TextView textView3 = this.irF;
                    textView3.setVisibility(8);
                    this.irO.setVisibility(8);
                    if (this.eLN == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.eLN == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, getResources().getString(R.string.not_have_attention_guest)));
                    String string6 = getPageContext().getString(R.string.person);
                    str = string3;
                    textView = textView3;
                    z = v.isEmpty(avVar.aBo()) ? false : true;
                    str2 = string6;
                }
            } else {
                this.irB.setVisibility(8);
                this.irE.setVisibility(0);
                TextView textView4 = this.irF;
                this.irO.setVisibility(8);
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
                    if (this.eLN == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.eLN == 1) {
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
            textView.setText(str + aq.numberUniformFormat(avVar.cQg) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(av avVar, boolean z) {
        String string;
        this.irA.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bgL()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.irO.setVisibility(0);
                this.irD.setVisibility(0);
                this.irB.setVisibility(0);
                this.irE.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.irD.setText(string + 0 + string2);
                return;
            }
            this.irO.setVisibility(8);
            this.irD.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.irO.setVisibility(8);
        this.irD.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (avVar != null && !StringUtils.isNull(avVar.cQh) && !this.irL) {
                this.mNoDataView.getSuTextView().setText(bh(avVar.cQh, avVar.type));
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
        if (this.irG != null) {
            if (!z) {
                if (avVar.pageNum == 1) {
                    this.irG.resetData();
                }
                this.irG.setHasMore(avVar.hasMore);
                this.irG.a(avVar);
                this.irG.bgJ();
                this.irG.notifyDataSetChanged();
                return;
            }
            this.irG.setHasMore(false);
            this.irG.a(avVar);
            this.irG.bgJ();
            this.irG.notifyDataSetChanged();
        }
    }

    private void bgP() {
        showLoadingView(this.mContainer);
        this.mModel.bgM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chm() {
        if (this.irG != null) {
            this.irG.notifyDataSetChanged();
        }
        this.mModel.bgM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chn() {
        UserData userData;
        if (this.irG != null && this.irG.getItemViewType(this.irN) == 0 && (userData = (UserData) this.irG.getItem(this.irN)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            chn();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.irO.chi()) {
                this.irO.closeView();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bg(String str, int i) {
        if (this.irQ == null) {
            this.irQ = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.irR = (TextView) this.irQ.findViewById(R.id.view_forbidden_tip);
            am.setViewTextColor(this.irR, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.irQ, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.irQ.setVisibility(8);
            return;
        }
        this.irR.setText(bh(str, i));
        this.irR.setMovementMethod(LinkMovementMethod.getInstance());
        this.irR.setHighlightColor(getResources().getColor(R.color.transparent));
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
                    PersonListActivity.this.chp();
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
                    PersonListActivity.this.cho();
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
    public void cho() {
        TiebaStatic.log(new an("c13104").X("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.irS.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chp() {
        TiebaStatic.log(new an("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
