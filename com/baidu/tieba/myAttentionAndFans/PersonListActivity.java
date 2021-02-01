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
/* loaded from: classes8.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView gAi;
    private NavigationBarCoverTip jaP;
    private TextView jaU;
    private boolean lvQ;
    private NavigationBarShadowView lvR;
    private NavigationBarShadowView lvS;
    private ConcernSelectView lvW;
    private e lvX;
    private View lvY;
    private TextView lvZ;
    private com.baidu.tieba.forbidden.fans.d lwa;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView lvI = null;
    private View lvJ = null;
    private View lvK = null;
    private TextView lvL = null;
    private View lvM = null;
    private TextView lvN = null;
    private b lvO = null;
    private NoPressedRelativeLayout lvP = null;
    private boolean byF = true;
    private TextView bMg = null;
    private int hkZ = 0;
    private boolean lvT = false;
    private int lvU = 0;
    int lvV = 0;
    private final AntiHelper.a jhC = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener jhD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().fsD != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().fsD, PersonListActivity.this.jhC) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener lwb = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.lvO.hm(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.lvO.bYr();
                    PersonListActivity.this.lvO.notifyDataSetChanged();
                }
                if (PersonListActivity.this.lvO.hkP) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bYt()) {
                        PersonListActivity.this.lvR.show();
                    } else {
                        PersonListActivity.this.lvS.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bYt()) {
                    PersonListActivity.this.lvR.hide();
                } else {
                    PersonListActivity.this.lvS.hide();
                }
            }
        }
    };
    public PersonListModel.a lwc = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
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
            if (bgVar != null && bgVar.eOU != PersonListActivity.this.lvU && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bYt() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.OJ(PersonListActivity.this.mPortrait);
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
        this.lwa = new com.baidu.tieba.forbidden.fans.d(getPageContext(), getUniqueId());
        this.lwa.a(new d.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.jaU == null) {
                            PersonListActivity.this.jaU = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.jaU.setGravity(19);
                            PersonListActivity.this.jaU.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.jaU.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.jaU.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.jaU.setTextColor(PersonListActivity.this.getResources().getColor(R.color.CAM_X0101));
                        }
                        PersonListActivity.this.jaU.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.jaP.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.jaP.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.jaP.a(PersonListActivity.this.getActivity(), PersonListActivity.this.jaU, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.lvZ.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    ap.setViewTextColor(PersonListActivity.this.lvZ, R.color.CAM_X0109);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void cAx() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.jhD);
        registerListener(this.lwb);
        this.mModel.bRa();
        if (this.byF) {
            this.byF = false;
            bYx();
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
        ap.setBackgroundResource(this.lvP, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mContainer, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.lvO != null) {
            this.lvO.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.lvW.onChangeSkinType(i);
        ap.setBackgroundColor(this.lvL, R.color.CAM_X0201);
        ap.setViewTextColor(this.lvL, R.color.CAM_X0109);
        ap.setBackgroundColor(this.lvN, R.color.CAM_X0201);
        ap.setViewTextColor(this.lvN, R.color.CAM_X0109);
        getLayoutMode().setNightMode(i == 1);
        if (this.lvK != null) {
            getLayoutMode().onModeChanged(this.lvK);
        }
        if (this.lvM != null) {
            getLayoutMode().onModeChanged(this.lvM);
        }
        if (this.lvY != null) {
            ap.setViewTextColor(this.lvZ, R.color.CAM_X0109);
            ap.setBackgroundColor(this.lvY, R.color.CAM_X0201);
        }
        this.lwa.onChangeSkinType();
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gAi.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lvO != null) {
            this.lvO = null;
        }
        if (this.lvX != null) {
            this.lvX.Tz();
        }
        this.jaP.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.lwc);
        if (bundle != null) {
            this.mModel.bz(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.hkZ = bundle.getInt("user_sex");
            this.lvT = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.lvU = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.hkZ);
            return;
        }
        Intent intent = getIntent();
        this.mModel.bz(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.hkZ = intent.getIntExtra("user_sex", 0);
        this.lvT = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.lvU = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.hkZ);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bYt());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.hkZ);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.lvT);
    }

    private void initUI() {
        boolean z = true;
        this.lvP = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bMg = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lvR = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.lvS = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.lvJ = findViewById(R.id.sub_title_root);
        this.lvK = this.lvJ.findViewById(R.id.newheader_root);
        this.lvJ.setVisibility(8);
        this.lvJ.setClickable(false);
        this.lvJ.setEnabled(false);
        this.lvL = (TextView) this.lvJ.findViewById(R.id.person_list_title);
        this.lvW = (ConcernSelectView) findViewById(R.id.select_layout);
        this.jaP = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bYt()) {
                this.bMg.setText(R.string.my_attention);
                this.lvP.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void E(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.lvW.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.lvW.dhc() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.lvP.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.lvW.dhb();
                        PersonListActivity.this.lvP.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.bMg.setText(R.string.fans);
            }
        } else if (this.mModel.bYt()) {
            if (this.hkZ == 2) {
                this.bMg.setText(R.string.her_attention_people);
            } else if (this.hkZ == 1) {
                this.bMg.setText(R.string.his_attention_people);
            } else {
                this.bMg.setText(R.string.its_attention_people);
            }
        } else if (this.hkZ == 2) {
            this.bMg.setText(R.string.attention_to_her);
        } else if (this.hkZ == 1) {
            this.bMg.setText(R.string.attention_to_him);
        } else {
            this.bMg.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.lvO != null && PersonListActivity.this.lvO.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.lvO.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bYt()) {
                            TiebaStatic.log(new ar("c12772").dR("obj_locate", "1").dR("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new ar("c12605").ap("obj_locate", 1).dR("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.lvV = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.dhh();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.dhg();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.lvO = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.lvJ.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.lvP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.lvO = new c(this, z, sex, onClickListener, onClickListener3);
            this.lvJ.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.lvP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.lvI = (BdListView) findViewById(R.id.list);
        this.lvI.setAdapter((ListAdapter) this.lvO);
        dhf();
        this.lvI.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.lvO != null && PersonListActivity.this.lvO.isHasMore()) {
                    if (PersonListActivity.this.gAi != null && !PersonListActivity.this.gAi.isLoading()) {
                        PersonListActivity.this.gAi.startLoadData();
                    }
                    PersonListActivity.this.dhg();
                }
            }
        });
        this.lvI.setOnScrollListener(this.mOnScrollListener);
        this.lvW.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void ub(boolean z2) {
                if (z2) {
                    PersonListActivity.this.cwV();
                } else if (PersonListActivity.this.lvX != null) {
                    PersonListActivity.this.lvX.Tz();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void Al(int i) {
                PersonListActivity.this.lvI.setSelection(0);
                PersonListActivity.this.mModel.loadData(i);
            }
        });
        this.lvW.setVisibility(8);
        this.lvM.setVisibility(8);
        this.gAi = new PbListView(getActivity());
        this.gAi.getView();
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAi.setLineGone();
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAi.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.lvI.setNextPage(this.gAi);
    }

    private void dhf() {
        this.lvM = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.lvM.setVisibility(8);
        this.lvM.setClickable(false);
        this.lvM.setEnabled(false);
        this.lvN = (TextView) this.lvM.findViewById(R.id.person_list_title);
        this.lvI.addHeaderView(this.lvM, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwV() {
        if (this.lvX == null) {
            this.lvX = new e(getPageContext(), this.lvW.lvo);
            this.lvX.en(R.drawable.bg_tip_blue_up);
            this.lvX.setMaxShowTime(2);
            this.lvX.eo(3000);
            this.lvX.xl(-10);
            this.lvX.setYOffset(-16);
            this.lvX.e(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.lvX != null) {
                        PersonListActivity.this.lvX.Tz();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(bg bgVar, boolean z) {
        if (this.mModel != null && bgVar != null && (!z || !this.lvQ)) {
            if (!z) {
                this.lvQ = true;
                d(bgVar);
            }
            b(bgVar);
            d(bgVar, z);
            if (!this.mModel.bYt()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgFans(0);
            }
            b(bgVar, z);
        }
    }

    private void b(bg bgVar) {
        if (bgVar != null) {
            if (!bgVar.hasMore && !StringUtils.isNull(bgVar.eOV) && !this.lvT) {
                bE(bgVar.eOV, bgVar.type);
                this.lvI.removeFooterView(this.lvY);
                this.lvI.addFooterView(this.lvY);
                this.lvI.removeFooterView(this.gAi.getView());
                TiebaStatic.log(new ar("c13106").ap("obj_locate", 2));
            } else if (!bgVar.hasMore) {
                this.lvI.removeFooterView(this.lvY);
                this.gAi.setText(getString(R.string.no_more_data_tip));
                this.gAi.endLoadData();
            } else {
                this.lvI.removeFooterView(this.lvY);
                this.gAi.setText(getString(R.string.pb_load_more));
                this.gAi.endLoadData();
            }
        }
    }

    private void b(bg bgVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (bgVar.eOU > 0 && !y.isEmpty(bgVar.bmI())) {
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
            this.lvI.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bYt()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.lvJ.setVisibility(0);
                    this.lvI.removeHeaderView(this.lvM);
                    TextView textView2 = this.lvL;
                    textView2.setVisibility(0);
                    this.lvW.setVisibility(0);
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
                    this.lvJ.setVisibility(8);
                    this.lvM.setVisibility(0);
                    textView = this.lvN;
                    textView.setVisibility(8);
                    this.lvW.setVisibility(8);
                    if (this.hkZ == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.hkZ == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_attention_guest)));
                    str = getPageContext().getString(R.string.person);
                    str2 = string3;
                    z = y.isEmpty(bgVar.bmJ()) ? false : true;
                }
            } else {
                this.lvJ.setVisibility(8);
                this.lvM.setVisibility(0);
                textView = this.lvN;
                this.lvW.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    String string5 = getPageContext().getString(R.string.my_fans_prefix);
                    String string6 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_fans)));
                    str = string6;
                    str2 = string5;
                    z = false;
                } else {
                    if (this.hkZ == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.hkZ == 1) {
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
            textView.setText(str2 + au.numberUniformFormat(bgVar.eOU) + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(bg bgVar, boolean z) {
        String string;
        this.lvI.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bYt()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.lvW.setVisibility(0);
                this.lvL.setVisibility(0);
                this.lvJ.setVisibility(0);
                this.lvM.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.lvL.setText(string + 0 + string2);
                return;
            }
            this.lvW.setVisibility(8);
            this.lvL.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.lvW.setVisibility(8);
        this.lvL.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (bgVar != null && !StringUtils.isNull(bgVar.eOV) && !this.lvT) {
                this.mNoDataView.getSuTextView().setText(bF(bgVar.eOV, bgVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new ar("c13106").ap("obj_locate", 1));
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
        if (this.lvO != null) {
            if (!z) {
                if (bgVar.pageNum == 1) {
                    this.lvO.resetData();
                }
                this.lvO.setHasMore(bgVar.hasMore);
                this.lvO.a(bgVar);
                this.lvO.bYr();
                this.lvO.notifyDataSetChanged();
                return;
            }
            this.lvO.setHasMore(false);
            this.lvO.a(bgVar);
            this.lvO.bYr();
            this.lvO.notifyDataSetChanged();
        }
    }

    private void bYx() {
        showLoadingView(this.mContainer);
        this.mModel.bYu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhg() {
        if (this.lvO != null) {
            this.lvO.notifyDataSetChanged();
        }
        this.mModel.bYu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhh() {
        UserData userData;
        if (this.lvO != null && this.lvO.getItemViewType(this.lvV) == 0 && (userData = (UserData) this.lvO.getItem(this.lvV)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            dhh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lvW.dhc()) {
                this.lvW.dhb();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bE(String str, int i) {
        if (this.lvY == null) {
            this.lvY = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.lvZ = (TextView) this.lvY.findViewById(R.id.view_forbidden_tip);
            ap.setViewTextColor(this.lvZ, R.color.CAM_X0109);
            ap.setBackgroundColor(this.lvY, R.color.CAM_X0201);
        }
        if (StringUtils.isNull(str)) {
            this.lvY.setVisibility(8);
            return;
        }
        this.lvZ.setText(bF(str, i));
        this.lvZ.setMovementMethod(LinkMovementMethod.getInstance());
        this.lvZ.setHighlightColor(getResources().getColor(R.color.transparent));
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
                    PersonListActivity.this.dhj();
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
                    PersonListActivity.this.dhi();
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
    public void dhi() {
        TiebaStatic.log(new ar("c13104").ap("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.lwa.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhj() {
        TiebaStatic.log(new ar("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
