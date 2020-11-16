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
import com.baidu.tbadk.core.data.bd;
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
import com.baidu.tieba.d.e;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes22.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView giV;
    private NavigationBarCoverTip iCK;
    private TextView iCP;
    private boolean kZD;
    private NavigationBarShadowView kZE;
    private NavigationBarShadowView kZF;
    private ConcernSelectView kZJ;
    private e kZK;
    private View kZL;
    private TextView kZM;
    private com.baidu.tieba.forbidden.fans.e kZN;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView kZv = null;
    private View kZw = null;
    private View kZx = null;
    private TextView kZy = null;
    private View kZz = null;
    private TextView kZA = null;
    private b kZB = null;
    private NoPressedRelativeLayout kZC = null;
    private boolean bpT = true;
    private TextView bDl = null;
    private int gQm = 0;
    private boolean kZG = false;
    private int kZH = 0;
    int kZI = 0;
    private final AntiHelper.a iJy = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ak("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ak("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener iJz = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().fdL != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().fdL, PersonListActivity.this.iJy) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ak("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener kZO = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.kZB.gH(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.kZB.bUT();
                    PersonListActivity.this.kZB.notifyDataSetChanged();
                }
                if (PersonListActivity.this.kZB.gQc) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bUV()) {
                        PersonListActivity.this.kZE.show();
                    } else {
                        PersonListActivity.this.kZF.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bUV()) {
                    PersonListActivity.this.kZE.hide();
                } else {
                    PersonListActivity.this.kZF.hide();
                }
            }
        }
    };
    public PersonListModel.a kZP = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
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
        public bd e(bd bdVar, boolean z) {
            if (bdVar != null && bdVar.eAD != PersonListActivity.this.kZH && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bUV() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.Op(PersonListActivity.this.mPortrait);
            }
            PersonListActivity.this.a(bdVar, z);
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
        this.kZN = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.kZN.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.iCP == null) {
                            PersonListActivity.this.iCP = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.iCP.setGravity(19);
                            PersonListActivity.this.iCP.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.iCP.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.iCP.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.iCP.setTextColor(PersonListActivity.this.getResources().getColor(R.color.CAM_X0101));
                        }
                        PersonListActivity.this.iCP.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.iCK.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.iCK.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.iCK.a(PersonListActivity.this.getActivity(), PersonListActivity.this.iCP, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.kZM.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    ap.setViewTextColor(PersonListActivity.this.kZM, R.color.CAM_X0109);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void cvU() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.iJz);
        registerListener(this.kZO);
        this.mModel.bNZ();
        if (this.bpT) {
            this.bpT = false;
            bUZ();
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
        ap.setBackgroundResource(this.kZC, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mContainer, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.kZB != null) {
            this.kZB.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.kZJ.onChangeSkinType(i);
        ap.setBackgroundColor(this.kZy, R.color.CAM_X0201);
        ap.setViewTextColor(this.kZy, R.color.CAM_X0109);
        ap.setBackgroundColor(this.kZA, R.color.CAM_X0201);
        ap.setViewTextColor(this.kZA, R.color.CAM_X0109);
        getLayoutMode().setNightMode(i == 1);
        if (this.kZx != null) {
            getLayoutMode().onModeChanged(this.kZx);
        }
        if (this.kZz != null) {
            getLayoutMode().onModeChanged(this.kZz);
        }
        if (this.kZL != null) {
            ap.setViewTextColor(this.kZM, R.color.CAM_X0109);
            ap.setBackgroundColor(this.kZL, R.color.CAM_X0201);
        }
        this.kZN.onChangeSkinType();
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.giV.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kZB != null) {
            this.kZB = null;
        }
        if (this.kZK != null) {
            this.kZK.Si();
        }
        this.iCK.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.kZP);
        if (bundle != null) {
            this.mModel.mE(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.gQm = bundle.getInt("user_sex");
            this.kZG = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.kZH = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.gQm);
            return;
        }
        Intent intent = getIntent();
        this.mModel.mE(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.gQm = intent.getIntExtra("user_sex", 0);
        this.kZG = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.kZH = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.gQm);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bUV());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.gQm);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.kZG);
    }

    private void initUI() {
        boolean z = true;
        this.kZC = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bDl = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kZE = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.kZF = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.kZw = findViewById(R.id.sub_title_root);
        this.kZx = this.kZw.findViewById(R.id.newheader_root);
        this.kZw.setVisibility(8);
        this.kZw.setClickable(false);
        this.kZw.setEnabled(false);
        this.kZy = (TextView) this.kZw.findViewById(R.id.person_list_title);
        this.kZJ = (ConcernSelectView) findViewById(R.id.select_layout);
        this.iCK = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bUV()) {
                this.bDl.setText(R.string.my_attention);
                this.kZC.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void E(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.kZJ.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.kZJ.ddT() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.kZC.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.kZJ.closeView();
                        PersonListActivity.this.kZC.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.bDl.setText(R.string.fans);
            }
        } else if (this.mModel.bUV()) {
            if (this.gQm == 2) {
                this.bDl.setText(R.string.her_attention_people);
            } else if (this.gQm == 1) {
                this.bDl.setText(R.string.his_attention_people);
            } else {
                this.bDl.setText(R.string.its_attention_people);
            }
        } else if (this.gQm == 2) {
            this.bDl.setText(R.string.attention_to_her);
        } else if (this.gQm == 1) {
            this.bDl.setText(R.string.attention_to_him);
        } else {
            this.bDl.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.kZB != null && PersonListActivity.this.kZB.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.kZB.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bUV()) {
                            TiebaStatic.log(new ar("c12772").dR("obj_locate", "1").dR("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new ar("c12605").ak("obj_locate", 1).dR("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.kZI = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.ddY();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.ddX();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.kZB = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.kZw.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.kZC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.kZB = new c(this, z, sex, onClickListener, onClickListener3);
            this.kZw.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.kZC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.kZv = (BdListView) findViewById(R.id.list);
        this.kZv.setAdapter((ListAdapter) this.kZB);
        ddW();
        this.kZv.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.kZB != null && PersonListActivity.this.kZB.isHasMore()) {
                    if (PersonListActivity.this.giV != null && !PersonListActivity.this.giV.isLoading()) {
                        PersonListActivity.this.giV.startLoadData();
                    }
                    PersonListActivity.this.ddX();
                }
            }
        });
        this.kZv.setOnScrollListener(this.mOnScrollListener);
        this.kZJ.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void tp(boolean z2) {
                if (z2) {
                    PersonListActivity.this.csr();
                } else if (PersonListActivity.this.kZK != null) {
                    PersonListActivity.this.kZK.Si();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void AH(int i) {
                PersonListActivity.this.kZv.setSelection(0);
                PersonListActivity.this.mModel.uu(i);
            }
        });
        this.kZJ.setVisibility(8);
        this.kZz.setVisibility(8);
        this.giV = new PbListView(getActivity());
        this.giV.getView();
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.giV.setLineGone();
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.giV.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.kZv.setNextPage(this.giV);
    }

    private void ddW() {
        this.kZz = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.kZz.setVisibility(8);
        this.kZz.setClickable(false);
        this.kZz.setEnabled(false);
        this.kZA = (TextView) this.kZz.findViewById(R.id.person_list_title);
        this.kZv.addHeaderView(this.kZz, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csr() {
        if (this.kZK == null) {
            this.kZK = new com.baidu.tieba.d.e(getPageContext(), this.kZJ.kZb);
            this.kZK.fq(R.drawable.bg_tip_blue_up);
            this.kZK.setMaxShowTime(2);
            this.kZK.fr(3000);
            this.kZK.xO(-10);
            this.kZK.setYOffset(-16);
            this.kZK.d(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.kZK != null) {
                        PersonListActivity.this.kZK.Si();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(bd bdVar, boolean z) {
        if (this.mModel != null && bdVar != null && (!z || !this.kZD)) {
            if (!z) {
                this.kZD = true;
                d(bdVar);
            }
            b(bdVar);
            d(bdVar, z);
            if (!this.mModel.bUV()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bvi().setMsgFans(0);
            }
            b(bdVar, z);
        }
    }

    private void b(bd bdVar) {
        if (bdVar != null) {
            if (!bdVar.hasMore && !StringUtils.isNull(bdVar.eAE) && !this.kZG) {
                bv(bdVar.eAE, bdVar.type);
                this.kZv.removeFooterView(this.kZL);
                this.kZv.addFooterView(this.kZL);
                this.kZv.removeFooterView(this.giV.getView());
                TiebaStatic.log(new ar("c13106").ak("obj_locate", 2));
            } else if (!bdVar.hasMore) {
                this.kZv.removeFooterView(this.kZL);
                this.giV.setText(getString(R.string.no_more_data_tip));
                this.giV.endLoadData();
            } else {
                this.kZv.removeFooterView(this.kZL);
                this.giV.setText(getString(R.string.pb_load_more));
                this.giV.endLoadData();
            }
        }
    }

    private void b(bd bdVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (bdVar.eAD > 0 && !y.isEmpty(bdVar.bkv())) {
                c(bdVar);
            } else {
                c(bdVar, z);
            }
        }
    }

    private void c(bd bdVar) {
        String string;
        String string2;
        boolean z;
        TextView textView;
        String str;
        String str2;
        String string3;
        String string4;
        if (bdVar != null) {
            this.kZv.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bUV()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.kZw.setVisibility(0);
                    this.kZv.removeHeaderView(this.kZz);
                    TextView textView2 = this.kZy;
                    textView2.setVisibility(0);
                    this.kZJ.setVisibility(0);
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
                    this.kZw.setVisibility(8);
                    this.kZz.setVisibility(0);
                    TextView textView3 = this.kZA;
                    textView3.setVisibility(8);
                    this.kZJ.setVisibility(8);
                    if (this.gQm == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.gQm == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_attention_guest)));
                    String string6 = getPageContext().getString(R.string.person);
                    str = string3;
                    textView = textView3;
                    z = y.isEmpty(bdVar.bkw()) ? false : true;
                    str2 = string6;
                }
            } else {
                this.kZw.setVisibility(8);
                this.kZz.setVisibility(0);
                TextView textView4 = this.kZA;
                this.kZJ.setVisibility(8);
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
                    if (this.gQm == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.gQm == 1) {
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
            textView.setText(str + au.numberUniformFormat(bdVar.eAD) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(bd bdVar, boolean z) {
        String string;
        this.kZv.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bUV()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.kZJ.setVisibility(0);
                this.kZy.setVisibility(0);
                this.kZw.setVisibility(0);
                this.kZz.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.kZy.setText(string + 0 + string2);
                return;
            }
            this.kZJ.setVisibility(8);
            this.kZy.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.kZJ.setVisibility(8);
        this.kZy.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (bdVar != null && !StringUtils.isNull(bdVar.eAE) && !this.kZG) {
                this.mNoDataView.getSuTextView().setText(bw(bdVar.eAE, bdVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new ar("c13106").ak("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.not_have_fans)));
            return;
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.her_no_fan_guest)));
    }

    private void d(bd bdVar) {
        this.mModel.setPage(bdVar.pageNum);
    }

    private void d(bd bdVar, boolean z) {
        if (this.kZB != null) {
            if (!z) {
                if (bdVar.pageNum == 1) {
                    this.kZB.resetData();
                }
                this.kZB.setHasMore(bdVar.hasMore);
                this.kZB.a(bdVar);
                this.kZB.bUT();
                this.kZB.notifyDataSetChanged();
                return;
            }
            this.kZB.setHasMore(false);
            this.kZB.a(bdVar);
            this.kZB.bUT();
            this.kZB.notifyDataSetChanged();
        }
    }

    private void bUZ() {
        showLoadingView(this.mContainer);
        this.mModel.bUW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddX() {
        if (this.kZB != null) {
            this.kZB.notifyDataSetChanged();
        }
        this.mModel.bUW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddY() {
        UserData userData;
        if (this.kZB != null && this.kZB.getItemViewType(this.kZI) == 0 && (userData = (UserData) this.kZB.getItem(this.kZI)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            ddY();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kZJ.ddT()) {
                this.kZJ.closeView();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bv(String str, int i) {
        if (this.kZL == null) {
            this.kZL = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.kZM = (TextView) this.kZL.findViewById(R.id.view_forbidden_tip);
            ap.setViewTextColor(this.kZM, R.color.CAM_X0109);
            ap.setBackgroundColor(this.kZL, R.color.CAM_X0201);
        }
        if (StringUtils.isNull(str)) {
            this.kZL.setVisibility(8);
            return;
        }
        this.kZM.setText(bw(str, i));
        this.kZM.setMovementMethod(LinkMovementMethod.getInstance());
        this.kZM.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private SpannableStringBuilder bw(String str, int i) {
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
                    PersonListActivity.this.dea();
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
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.ddZ();
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
    public void ddZ() {
        TiebaStatic.log(new ar("c13104").ak("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.kZN.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dea() {
        TiebaStatic.log(new ar("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
