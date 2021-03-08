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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
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
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes7.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView gCf;
    private NavigationBarCoverTip jcM;
    private TextView jcR;
    private boolean lyg;
    private NavigationBarShadowView lyh;
    private NavigationBarShadowView lyi;
    private ConcernSelectView lym;
    private e lyn;
    private View lyp;
    private TextView lyq;
    private com.baidu.tieba.forbidden.fans.d lyr;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView lxY = null;
    private View lxZ = null;
    private View lya = null;
    private TextView lyb = null;
    private View lyc = null;
    private TextView lyd = null;
    private b lye = null;
    private NoPressedRelativeLayout lyf = null;
    private boolean bAf = true;
    private TextView bNG = null;
    private int hmW = 0;
    private boolean lyj = false;
    private int lyk = 0;
    int lyl = 0;
    private final AntiHelper.a jjA = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aq("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aq("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener jjB = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().fud != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().fud, PersonListActivity.this.jjA) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aq("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener lys = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.lye.hm(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.lye.bYE();
                    PersonListActivity.this.lye.notifyDataSetChanged();
                }
                if (PersonListActivity.this.lye.hmM) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bYG()) {
                        PersonListActivity.this.lyh.show();
                    } else {
                        PersonListActivity.this.lyi.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bYG()) {
                    PersonListActivity.this.lyh.hide();
                } else {
                    PersonListActivity.this.lyi.hide();
                }
            }
        }
    };
    public PersonListModel.a lyt = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void aC(String str, boolean z) {
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
        public bg e(bg bgVar, boolean z) {
            if (bgVar != null && bgVar.eQv != PersonListActivity.this.lyk && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bYG() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.OQ(PersonListActivity.this.mPortrait);
            }
            PersonListActivity.this.a(bgVar, z);
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
        this.lyr = new com.baidu.tieba.forbidden.fans.d(getPageContext(), getUniqueId());
        this.lyr.a(new d.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.jcR == null) {
                            PersonListActivity.this.jcR = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.jcR.setGravity(19);
                            PersonListActivity.this.jcR.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.jcR.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.jcR.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.jcR.setTextColor(PersonListActivity.this.getResources().getColor(R.color.CAM_X0101));
                        }
                        PersonListActivity.this.jcR.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.jcM.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.jcM.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.jcM.a(PersonListActivity.this.getActivity(), PersonListActivity.this.jcR, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.lyq.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    ap.setViewTextColor(PersonListActivity.this.lyq, R.color.CAM_X0109);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void cAK() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.jjB);
        registerListener(this.lys);
        this.mModel.bRn();
        if (this.bAf) {
            this.bAf = false;
            bYK();
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
        ap.setBackgroundResource(this.lyf, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mContainer, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.lye != null) {
            this.lye.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.lym.onChangeSkinType(i);
        ap.setBackgroundColor(this.lyb, R.color.CAM_X0201);
        ap.setViewTextColor(this.lyb, R.color.CAM_X0109);
        ap.setBackgroundColor(this.lyd, R.color.CAM_X0201);
        ap.setViewTextColor(this.lyd, R.color.CAM_X0109);
        getLayoutMode().setNightMode(i == 1);
        if (this.lya != null) {
            getLayoutMode().onModeChanged(this.lya);
        }
        if (this.lyc != null) {
            getLayoutMode().onModeChanged(this.lyc);
        }
        if (this.lyp != null) {
            ap.setViewTextColor(this.lyq, R.color.CAM_X0109);
            ap.setBackgroundColor(this.lyp, R.color.CAM_X0201);
        }
        this.lyr.onChangeSkinType();
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gCf.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lye != null) {
            this.lye = null;
        }
        if (this.lyn != null) {
            this.lyn.TC();
        }
        this.jcM.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.lyt);
        if (bundle != null) {
            this.mModel.bz(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.hmW = bundle.getInt("user_sex");
            this.lyj = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.lyk = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.hmW);
            return;
        }
        Intent intent = getIntent();
        this.mModel.bz(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.hmW = intent.getIntExtra("user_sex", 0);
        this.lyj = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.lyk = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.hmW);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bYG());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.hmW);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.lyj);
    }

    private void initUI() {
        boolean z = true;
        this.lyf = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bNG = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lyh = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.lyi = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.lxZ = findViewById(R.id.sub_title_root);
        this.lya = this.lxZ.findViewById(R.id.newheader_root);
        this.lxZ.setVisibility(8);
        this.lxZ.setClickable(false);
        this.lxZ.setEnabled(false);
        this.lyb = (TextView) this.lxZ.findViewById(R.id.person_list_title);
        this.lym = (ConcernSelectView) findViewById(R.id.select_layout);
        this.jcM = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bYG()) {
                this.bNG.setText(R.string.my_attention);
                this.lyf.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void E(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.lym.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.lym.dhs() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.lyf.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.lym.dhr();
                        PersonListActivity.this.lyf.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.bNG.setText(R.string.fans);
            }
        } else if (this.mModel.bYG()) {
            if (this.hmW == 2) {
                this.bNG.setText(R.string.her_attention_people);
            } else if (this.hmW == 1) {
                this.bNG.setText(R.string.his_attention_people);
            } else {
                this.bNG.setText(R.string.its_attention_people);
            }
        } else if (this.hmW == 2) {
            this.bNG.setText(R.string.attention_to_her);
        } else if (this.hmW == 1) {
            this.bNG.setText(R.string.attention_to_him);
        } else {
            this.bNG.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.lye != null && PersonListActivity.this.lye.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.lye.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bYG()) {
                            TiebaStatic.log(new ar("c12772").dR("obj_locate", "1").dR("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new ar("c12605").aq("obj_locate", 1).dR("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.lyl = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.dhx();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.dhw();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.lye = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.lxZ.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.lyf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.lye = new c(this, z, sex, onClickListener, onClickListener3);
            this.lxZ.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.lyf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.lxY = (BdListView) findViewById(R.id.list);
        this.lxY.setAdapter((ListAdapter) this.lye);
        dhv();
        this.lxY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.lye != null && PersonListActivity.this.lye.isHasMore()) {
                    if (PersonListActivity.this.gCf != null && !PersonListActivity.this.gCf.isLoading()) {
                        PersonListActivity.this.gCf.startLoadData();
                    }
                    PersonListActivity.this.dhw();
                }
            }
        });
        this.lxY.setOnScrollListener(this.mOnScrollListener);
        this.lym.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void ub(boolean z2) {
                if (z2) {
                    PersonListActivity.this.cxi();
                } else if (PersonListActivity.this.lyn != null) {
                    PersonListActivity.this.lyn.TC();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void Am(int i) {
                PersonListActivity.this.lxY.setSelection(0);
                PersonListActivity.this.mModel.loadData(i);
            }
        });
        this.lym.setVisibility(8);
        this.lyc.setVisibility(8);
        this.gCf = new PbListView(getActivity());
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.lxY.setNextPage(this.gCf);
    }

    private void dhv() {
        this.lyc = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.lyc.setVisibility(8);
        this.lyc.setClickable(false);
        this.lyc.setEnabled(false);
        this.lyd = (TextView) this.lyc.findViewById(R.id.person_list_title);
        this.lxY.addHeaderView(this.lyc, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxi() {
        if (this.lyn == null) {
            this.lyn = new e(getPageContext(), this.lym.lxE);
            this.lyn.eo(R.drawable.bg_tip_blue_up);
            this.lyn.setMaxShowTime(2);
            this.lyn.ep(3000);
            this.lyn.xm(-10);
            this.lyn.setYOffset(-16);
            this.lyn.e(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.lyn != null) {
                        PersonListActivity.this.lyn.TC();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(bg bgVar, boolean z) {
        if (this.mModel != null && bgVar != null && (!z || !this.lyg)) {
            if (!z) {
                this.lyg = true;
                d(bgVar);
            }
            b(bgVar);
            d(bgVar, z);
            if (!this.mModel.bYG()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxE().setMsgFans(0);
            }
            b(bgVar, z);
        }
    }

    private void b(bg bgVar) {
        if (bgVar != null) {
            if (!bgVar.hasMore && !StringUtils.isNull(bgVar.eQw) && !this.lyj) {
                bE(bgVar.eQw, bgVar.type);
                this.lxY.removeFooterView(this.lyp);
                this.lxY.addFooterView(this.lyp);
                this.lxY.removeFooterView(this.gCf.getView());
                TiebaStatic.log(new ar("c13106").aq("obj_locate", 2));
            } else if (!bgVar.hasMore) {
                this.lxY.removeFooterView(this.lyp);
                this.gCf.setText(getString(R.string.no_more_data_tip));
                this.gCf.endLoadData();
            } else {
                this.lxY.removeFooterView(this.lyp);
                this.gCf.setText(getString(R.string.pb_load_more));
                this.gCf.endLoadData();
            }
        }
    }

    private void b(bg bgVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (bgVar.eQv > 0 && !y.isEmpty(bgVar.bmK())) {
                c(bgVar);
            } else {
                c(bgVar, z);
            }
        }
    }

    private void c(bg bgVar) {
        TextView textView;
        String string;
        String string2;
        String str;
        String str2;
        boolean z;
        String string3;
        String string4;
        if (bgVar != null) {
            this.lxY.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bYG()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.lxZ.setVisibility(0);
                    this.lxY.removeHeaderView(this.lyc);
                    TextView textView2 = this.lyb;
                    textView2.setVisibility(0);
                    this.lym.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    str = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_attention)));
                    textView = textView2;
                    str2 = string4;
                    z = false;
                } else {
                    this.lxZ.setVisibility(8);
                    this.lyc.setVisibility(0);
                    textView = this.lyd;
                    textView.setVisibility(8);
                    this.lym.setVisibility(8);
                    if (this.hmW == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.hmW == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_attention_guest)));
                    str = getPageContext().getString(R.string.person);
                    str2 = string3;
                    z = y.isEmpty(bgVar.bmL()) ? false : true;
                }
            } else {
                this.lxZ.setVisibility(8);
                this.lyc.setVisibility(0);
                textView = this.lyd;
                this.lym.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    String string5 = getPageContext().getString(R.string.my_fans_prefix);
                    String string6 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_fans)));
                    str = string6;
                    str2 = string5;
                    z = false;
                } else {
                    if (this.hmW == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.hmW == 1) {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.her_no_fan_guest)));
                    str = string2;
                    str2 = string;
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(R.string.we_common_fans));
                return;
            }
            textView.setText(str2 + au.numberUniformFormat(bgVar.eQv) + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(bg bgVar, boolean z) {
        String string;
        this.lxY.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bYG()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.lym.setVisibility(0);
                this.lyb.setVisibility(0);
                this.lxZ.setVisibility(0);
                this.lyc.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.lyb.setText(string + 0 + string2);
                return;
            }
            this.lym.setVisibility(8);
            this.lyb.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.lym.setVisibility(8);
        this.lyb.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (bgVar != null && !StringUtils.isNull(bgVar.eQw) && !this.lyj) {
                this.mNoDataView.getSuTextView().setText(bF(bgVar.eQw, bgVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new ar("c13106").aq("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_fans)));
            return;
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.her_no_fan_guest)));
    }

    private void d(bg bgVar) {
        this.mModel.setPage(bgVar.pageNum);
    }

    private void d(bg bgVar, boolean z) {
        if (this.lye != null) {
            if (!z) {
                if (bgVar.pageNum == 1) {
                    this.lye.resetData();
                }
                this.lye.setHasMore(bgVar.hasMore);
                this.lye.a(bgVar);
                this.lye.bYE();
                this.lye.notifyDataSetChanged();
                return;
            }
            this.lye.setHasMore(false);
            this.lye.a(bgVar);
            this.lye.bYE();
            this.lye.notifyDataSetChanged();
        }
    }

    private void bYK() {
        showLoadingView(this.mContainer);
        this.mModel.bYH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhw() {
        if (this.lye != null) {
            this.lye.notifyDataSetChanged();
        }
        this.mModel.bYH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhx() {
        UserData userData;
        if (this.lye != null && this.lye.getItemViewType(this.lyl) == 0 && (userData = (UserData) this.lye.getItem(this.lyl)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            dhx();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lym.dhs()) {
                this.lym.dhr();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bE(String str, int i) {
        if (this.lyp == null) {
            this.lyp = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.lyq = (TextView) this.lyp.findViewById(R.id.view_forbidden_tip);
            ap.setViewTextColor(this.lyq, R.color.CAM_X0109);
            ap.setBackgroundColor(this.lyp, R.color.CAM_X0201);
        }
        if (StringUtils.isNull(str)) {
            this.lyp.setVisibility(8);
            return;
        }
        this.lyq.setText(bF(str, i));
        this.lyq.setMovementMethod(LinkMovementMethod.getInstance());
        this.lyq.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private SpannableStringBuilder bF(String str, int i) {
        String string;
        String str2;
        if (StringUtils.isNull(str)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        switch (i) {
            case 1:
                spannableStringBuilder.append((CharSequence) "，");
                str2 = getString(R.string.click_for_look_all);
                spannableStringBuilder.append((CharSequence) str2);
                string = null;
                break;
            case 2:
                spannableStringBuilder.append((CharSequence) "，");
                string = getString(R.string.remove_all_forbidden_fans);
                spannableStringBuilder.append((CharSequence) string);
                str2 = null;
                break;
            case 3:
                String string2 = getString(R.string.click_for_look_all);
                string = getString(R.string.remove_all_forbidden_fans);
                spannableStringBuilder.append((CharSequence) "，");
                spannableStringBuilder.append((CharSequence) string2);
                spannableStringBuilder.append((CharSequence) getString(R.string.tip_or));
                spannableStringBuilder.append((CharSequence) string);
                str2 = string2;
                break;
            default:
                string = null;
                str2 = null;
                break;
        }
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.6
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.dhz();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ap.getColor(R.color.CAM_X0302));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        if (!StringUtils.isNull(string)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), string, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.dhy();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ap.getColor(R.color.CAM_X0302));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhy() {
        TiebaStatic.log(new ar("c13104").aq("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.lyr.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhz() {
        TiebaStatic.log(new ar("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
