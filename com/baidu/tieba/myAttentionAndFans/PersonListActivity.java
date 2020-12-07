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
import com.baidu.tbadk.core.data.be;
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
/* loaded from: classes23.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView gre;
    private NavigationBarCoverTip iNC;
    private TextView iNH;
    private boolean lmZ;
    private NavigationBarShadowView lna;
    private NavigationBarShadowView lnb;
    private ConcernSelectView lnf;
    private e lnh;
    private View lni;
    private TextView lnj;
    private com.baidu.tieba.forbidden.fans.e lnk;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView lmR = null;
    private View lmS = null;
    private View lmT = null;
    private TextView lmU = null;
    private View lmV = null;
    private TextView lmW = null;
    private b lmX = null;
    private NoPressedRelativeLayout lmY = null;
    private boolean bve = true;
    private TextView bIt = null;
    private int gZz = 0;
    private boolean lnc = false;
    private int lnd = 0;
    int lne = 0;
    private final AntiHelper.a iUq = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener iUr = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().flk != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().flk, PersonListActivity.this.iUq) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener lnl = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.lmX.hm(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.lmX.bYC();
                    PersonListActivity.this.lmX.notifyDataSetChanged();
                }
                if (PersonListActivity.this.lmX.gZp) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bYE()) {
                        PersonListActivity.this.lna.show();
                    } else {
                        PersonListActivity.this.lnb.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bYE()) {
                    PersonListActivity.this.lna.hide();
                } else {
                    PersonListActivity.this.lnb.hide();
                }
            }
        }
    };
    public PersonListModel.a lnm = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
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
        public be e(be beVar, boolean z) {
            if (beVar != null && beVar.eHC != PersonListActivity.this.lnd && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bYE() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.Px(PersonListActivity.this.mPortrait);
            }
            PersonListActivity.this.a(beVar, z);
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
        this.lnk = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.lnk.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.iNH == null) {
                            PersonListActivity.this.iNH = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.iNH.setGravity(19);
                            PersonListActivity.this.iNH.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.iNH.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.iNH.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.iNH.setTextColor(PersonListActivity.this.getResources().getColor(R.color.CAM_X0101));
                        }
                        PersonListActivity.this.iNH.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.iNC.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.iNC.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.iNC.a(PersonListActivity.this.getActivity(), PersonListActivity.this.iNH, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.lnj.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    ap.setViewTextColor(PersonListActivity.this.lnj, R.color.CAM_X0109);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void cAj() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.iUr);
        registerListener(this.lnl);
        this.mModel.bRK();
        if (this.bve) {
            this.bve = false;
            bYI();
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
        ap.setBackgroundResource(this.lmY, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mContainer, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.lmX != null) {
            this.lmX.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.lnf.onChangeSkinType(i);
        ap.setBackgroundColor(this.lmU, R.color.CAM_X0201);
        ap.setViewTextColor(this.lmU, R.color.CAM_X0109);
        ap.setBackgroundColor(this.lmW, R.color.CAM_X0201);
        ap.setViewTextColor(this.lmW, R.color.CAM_X0109);
        getLayoutMode().setNightMode(i == 1);
        if (this.lmT != null) {
            getLayoutMode().onModeChanged(this.lmT);
        }
        if (this.lmV != null) {
            getLayoutMode().onModeChanged(this.lmV);
        }
        if (this.lni != null) {
            ap.setViewTextColor(this.lnj, R.color.CAM_X0109);
            ap.setBackgroundColor(this.lni, R.color.CAM_X0201);
        }
        this.lnk.onChangeSkinType();
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gre.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lmX != null) {
            this.lmX = null;
        }
        if (this.lnh != null) {
            this.lnh.UG();
        }
        this.iNC.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.lnm);
        if (bundle != null) {
            this.mModel.mZ(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.gZz = bundle.getInt("user_sex");
            this.lnc = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.lnd = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.gZz);
            return;
        }
        Intent intent = getIntent();
        this.mModel.mZ(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.gZz = intent.getIntExtra("user_sex", 0);
        this.lnc = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.lnd = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.gZz);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bYE());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.gZz);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.lnc);
    }

    private void initUI() {
        boolean z = true;
        this.lmY = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bIt = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lna = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.lnb = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.lmS = findViewById(R.id.sub_title_root);
        this.lmT = this.lmS.findViewById(R.id.newheader_root);
        this.lmS.setVisibility(8);
        this.lmS.setClickable(false);
        this.lmS.setEnabled(false);
        this.lmU = (TextView) this.lmS.findViewById(R.id.person_list_title);
        this.lnf = (ConcernSelectView) findViewById(R.id.select_layout);
        this.iNC = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bYE()) {
                this.bIt.setText(R.string.my_attention);
                this.lmY.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void E(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.lnf.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.lnf.djf() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.lmY.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.lnf.dje();
                        PersonListActivity.this.lmY.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.bIt.setText(R.string.fans);
            }
        } else if (this.mModel.bYE()) {
            if (this.gZz == 2) {
                this.bIt.setText(R.string.her_attention_people);
            } else if (this.gZz == 1) {
                this.bIt.setText(R.string.his_attention_people);
            } else {
                this.bIt.setText(R.string.its_attention_people);
            }
        } else if (this.gZz == 2) {
            this.bIt.setText(R.string.attention_to_her);
        } else if (this.gZz == 1) {
            this.bIt.setText(R.string.attention_to_him);
        } else {
            this.bIt.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.lmX != null && PersonListActivity.this.lmX.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.lmX.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bYE()) {
                            TiebaStatic.log(new ar("c12772").dY("obj_locate", "1").dY("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new ar("c12605").al("obj_locate", 1).dY("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.lne = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.djk();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.djj();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.lmX = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.lmS.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.lmY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.lmX = new c(this, z, sex, onClickListener, onClickListener3);
            this.lmS.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.lmY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.lmR = (BdListView) findViewById(R.id.list);
        this.lmR.setAdapter((ListAdapter) this.lmX);
        dji();
        this.lmR.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.lmX != null && PersonListActivity.this.lmX.isHasMore()) {
                    if (PersonListActivity.this.gre != null && !PersonListActivity.this.gre.isLoading()) {
                        PersonListActivity.this.gre.startLoadData();
                    }
                    PersonListActivity.this.djj();
                }
            }
        });
        this.lmR.setOnScrollListener(this.mOnScrollListener);
        this.lnf.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void tR(boolean z2) {
                if (z2) {
                    PersonListActivity.this.cwG();
                } else if (PersonListActivity.this.lnh != null) {
                    PersonListActivity.this.lnh.UG();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void Bv(int i) {
                PersonListActivity.this.lmR.setSelection(0);
                PersonListActivity.this.mModel.uY(i);
            }
        });
        this.lnf.setVisibility(8);
        this.lmV.setVisibility(8);
        this.gre = new PbListView(getActivity());
        this.gre.getView();
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gre.setLineGone();
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gre.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.lmR.setNextPage(this.gre);
    }

    private void dji() {
        this.lmV = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.lmV.setVisibility(8);
        this.lmV.setClickable(false);
        this.lmV.setEnabled(false);
        this.lmW = (TextView) this.lmV.findViewById(R.id.person_list_title);
        this.lmR.addHeaderView(this.lmV, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwG() {
        if (this.lnh == null) {
            this.lnh = new com.baidu.tieba.d.e(getPageContext(), this.lnf.lmx);
            this.lnh.fO(R.drawable.bg_tip_blue_up);
            this.lnh.setMaxShowTime(2);
            this.lnh.fP(3000);
            this.lnh.yt(-10);
            this.lnh.setYOffset(-16);
            this.lnh.d(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.lnh != null) {
                        PersonListActivity.this.lnh.UG();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(be beVar, boolean z) {
        if (this.mModel != null && beVar != null && (!z || !this.lmZ)) {
            if (!z) {
                this.lmZ = true;
                d(beVar);
            }
            b(beVar);
            d(beVar, z);
            if (!this.mModel.bYE()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgFans(0);
            }
            b(beVar, z);
        }
    }

    private void b(be beVar) {
        if (beVar != null) {
            if (!beVar.hasMore && !StringUtils.isNull(beVar.eHD) && !this.lnc) {
                bw(beVar.eHD, beVar.type);
                this.lmR.removeFooterView(this.lni);
                this.lmR.addFooterView(this.lni);
                this.lmR.removeFooterView(this.gre.getView());
                TiebaStatic.log(new ar("c13106").al("obj_locate", 2));
            } else if (!beVar.hasMore) {
                this.lmR.removeFooterView(this.lni);
                this.gre.setText(getString(R.string.no_more_data_tip));
                this.gre.endLoadData();
            } else {
                this.lmR.removeFooterView(this.lni);
                this.gre.setText(getString(R.string.pb_load_more));
                this.gre.endLoadData();
            }
        }
    }

    private void b(be beVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (beVar.eHC > 0 && !y.isEmpty(beVar.bnI())) {
                c(beVar);
            } else {
                c(beVar, z);
            }
        }
    }

    private void c(be beVar) {
        String string;
        String string2;
        boolean z;
        TextView textView;
        String str;
        String str2;
        String string3;
        String string4;
        if (beVar != null) {
            this.lmR.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bYE()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.lmS.setVisibility(0);
                    this.lmR.removeHeaderView(this.lmV);
                    TextView textView2 = this.lmU;
                    textView2.setVisibility(0);
                    this.lnf.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    String string5 = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, getResources().getString(R.string.not_have_attention)));
                    z = false;
                    str = string4;
                    textView = textView2;
                    str2 = string5;
                } else {
                    this.lmS.setVisibility(8);
                    this.lmV.setVisibility(0);
                    TextView textView3 = this.lmW;
                    textView3.setVisibility(8);
                    this.lnf.setVisibility(8);
                    if (this.gZz == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.gZz == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, getResources().getString(R.string.not_have_attention_guest)));
                    String string6 = getPageContext().getString(R.string.person);
                    str = string3;
                    textView = textView3;
                    z = y.isEmpty(beVar.bnJ()) ? false : true;
                    str2 = string6;
                }
            } else {
                this.lmS.setVisibility(8);
                this.lmV.setVisibility(0);
                TextView textView4 = this.lmW;
                this.lnf.setVisibility(8);
                textView4.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    String string7 = getPageContext().getString(R.string.my_fans_prefix);
                    String string8 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, getResources().getString(R.string.not_have_fans)));
                    z = false;
                    textView = textView4;
                    str = string7;
                    str2 = string8;
                } else {
                    if (this.gZz == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.gZz == 1) {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, getResources().getString(R.string.her_no_fan_guest)));
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
            textView.setText(str + au.numberUniformFormat(beVar.eHC) + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(be beVar, boolean z) {
        String string;
        this.lmR.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bYE()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.lnf.setVisibility(0);
                this.lmU.setVisibility(0);
                this.lmS.setVisibility(0);
                this.lmV.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.lmU.setText(string + 0 + string2);
                return;
            }
            this.lnf.setVisibility(8);
            this.lmU.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.lnf.setVisibility(8);
        this.lmU.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (beVar != null && !StringUtils.isNull(beVar.eHD) && !this.lnc) {
                this.mNoDataView.getSuTextView().setText(bx(beVar.eHD, beVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new ar("c13106").al("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, getResources().getString(R.string.not_have_fans)));
            return;
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, getResources().getString(R.string.her_no_fan_guest)));
    }

    private void d(be beVar) {
        this.mModel.setPage(beVar.pageNum);
    }

    private void d(be beVar, boolean z) {
        if (this.lmX != null) {
            if (!z) {
                if (beVar.pageNum == 1) {
                    this.lmX.resetData();
                }
                this.lmX.setHasMore(beVar.hasMore);
                this.lmX.a(beVar);
                this.lmX.bYC();
                this.lmX.notifyDataSetChanged();
                return;
            }
            this.lmX.setHasMore(false);
            this.lmX.a(beVar);
            this.lmX.bYC();
            this.lmX.notifyDataSetChanged();
        }
    }

    private void bYI() {
        showLoadingView(this.mContainer);
        this.mModel.bYF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djj() {
        if (this.lmX != null) {
            this.lmX.notifyDataSetChanged();
        }
        this.mModel.bYF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djk() {
        UserData userData;
        if (this.lmX != null && this.lmX.getItemViewType(this.lne) == 0 && (userData = (UserData) this.lmX.getItem(this.lne)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            djk();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lnf.djf()) {
                this.lnf.dje();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bw(String str, int i) {
        if (this.lni == null) {
            this.lni = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.lnj = (TextView) this.lni.findViewById(R.id.view_forbidden_tip);
            ap.setViewTextColor(this.lnj, R.color.CAM_X0109);
            ap.setBackgroundColor(this.lni, R.color.CAM_X0201);
        }
        if (StringUtils.isNull(str)) {
            this.lni.setVisibility(8);
            return;
        }
        this.lnj.setText(bx(str, i));
        this.lnj.setMovementMethod(LinkMovementMethod.getInstance());
        this.lnj.setHighlightColor(getResources().getColor(R.color.transparent));
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
                    PersonListActivity.this.djm();
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
                    PersonListActivity.this.djl();
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
    public void djl() {
        TiebaStatic.log(new ar("c13104").al("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.lnk.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djm() {
        TiebaStatic.log(new ar("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
