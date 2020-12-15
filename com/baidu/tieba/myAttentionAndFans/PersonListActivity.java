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
    private PbListView grg;
    private NavigationBarCoverTip iNE;
    private TextView iNJ;
    private boolean lnb;
    private NavigationBarShadowView lnc;
    private NavigationBarShadowView lnd;
    private ConcernSelectView lni;
    private e lnj;
    private View lnk;
    private TextView lnl;
    private com.baidu.tieba.forbidden.fans.e lnm;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView lmT = null;
    private View lmU = null;
    private View lmV = null;
    private TextView lmW = null;
    private View lmX = null;
    private TextView lmY = null;
    private b lmZ = null;
    private NoPressedRelativeLayout lna = null;
    private boolean bve = true;
    private TextView bIt = null;
    private int gZB = 0;
    private boolean lne = false;
    private int lnf = 0;
    int lnh = 0;
    private final AntiHelper.a iUs = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener iUt = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().flk != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().flk, PersonListActivity.this.iUs) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener lnn = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.lmZ.hm(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.lmZ.bYD();
                    PersonListActivity.this.lmZ.notifyDataSetChanged();
                }
                if (PersonListActivity.this.lmZ.gZr) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bYF()) {
                        PersonListActivity.this.lnc.show();
                    } else {
                        PersonListActivity.this.lnd.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bYF()) {
                    PersonListActivity.this.lnc.hide();
                } else {
                    PersonListActivity.this.lnd.hide();
                }
            }
        }
    };
    public PersonListModel.a lno = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
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
            if (beVar != null && beVar.eHC != PersonListActivity.this.lnf && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bYF() && PersonListActivity.this.mModel.getLoadType() == 0) {
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
        this.lnm = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.lnm.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.iNJ == null) {
                            PersonListActivity.this.iNJ = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.iNJ.setGravity(19);
                            PersonListActivity.this.iNJ.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.iNJ.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.iNJ.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.iNJ.setTextColor(PersonListActivity.this.getResources().getColor(R.color.CAM_X0101));
                        }
                        PersonListActivity.this.iNJ.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.iNE.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.iNE.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.iNE.a(PersonListActivity.this.getActivity(), PersonListActivity.this.iNJ, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.lnl.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    ap.setViewTextColor(PersonListActivity.this.lnl, R.color.CAM_X0109);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void cAk() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.iUt);
        registerListener(this.lnn);
        this.mModel.bRL();
        if (this.bve) {
            this.bve = false;
            bYJ();
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
        ap.setBackgroundResource(this.lna, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mContainer, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.lmZ != null) {
            this.lmZ.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.lni.onChangeSkinType(i);
        ap.setBackgroundColor(this.lmW, R.color.CAM_X0201);
        ap.setViewTextColor(this.lmW, R.color.CAM_X0109);
        ap.setBackgroundColor(this.lmY, R.color.CAM_X0201);
        ap.setViewTextColor(this.lmY, R.color.CAM_X0109);
        getLayoutMode().setNightMode(i == 1);
        if (this.lmV != null) {
            getLayoutMode().onModeChanged(this.lmV);
        }
        if (this.lmX != null) {
            getLayoutMode().onModeChanged(this.lmX);
        }
        if (this.lnk != null) {
            ap.setViewTextColor(this.lnl, R.color.CAM_X0109);
            ap.setBackgroundColor(this.lnk, R.color.CAM_X0201);
        }
        this.lnm.onChangeSkinType();
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.grg.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lmZ != null) {
            this.lmZ = null;
        }
        if (this.lnj != null) {
            this.lnj.UG();
        }
        this.iNE.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.lno);
        if (bundle != null) {
            this.mModel.mZ(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.gZB = bundle.getInt("user_sex");
            this.lne = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.lnf = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.gZB);
            return;
        }
        Intent intent = getIntent();
        this.mModel.mZ(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.gZB = intent.getIntExtra("user_sex", 0);
        this.lne = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.lnf = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.gZB);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bYF());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.gZB);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.lne);
    }

    private void initUI() {
        boolean z = true;
        this.lna = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bIt = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lnc = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.lnd = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.lmU = findViewById(R.id.sub_title_root);
        this.lmV = this.lmU.findViewById(R.id.newheader_root);
        this.lmU.setVisibility(8);
        this.lmU.setClickable(false);
        this.lmU.setEnabled(false);
        this.lmW = (TextView) this.lmU.findViewById(R.id.person_list_title);
        this.lni = (ConcernSelectView) findViewById(R.id.select_layout);
        this.iNE = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bYF()) {
                this.bIt.setText(R.string.my_attention);
                this.lna.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void E(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.lni.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.lni.djg() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.lna.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.lni.djf();
                        PersonListActivity.this.lna.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.bIt.setText(R.string.fans);
            }
        } else if (this.mModel.bYF()) {
            if (this.gZB == 2) {
                this.bIt.setText(R.string.her_attention_people);
            } else if (this.gZB == 1) {
                this.bIt.setText(R.string.his_attention_people);
            } else {
                this.bIt.setText(R.string.its_attention_people);
            }
        } else if (this.gZB == 2) {
            this.bIt.setText(R.string.attention_to_her);
        } else if (this.gZB == 1) {
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
                    if (PersonListActivity.this.lmZ != null && PersonListActivity.this.lmZ.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.lmZ.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bYF()) {
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
                PersonListActivity.this.lnh = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.djl();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.djk();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.lmZ = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.lmU.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.lna, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.lmZ = new c(this, z, sex, onClickListener, onClickListener3);
            this.lmU.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.lna, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.lmT = (BdListView) findViewById(R.id.list);
        this.lmT.setAdapter((ListAdapter) this.lmZ);
        djj();
        this.lmT.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.lmZ != null && PersonListActivity.this.lmZ.isHasMore()) {
                    if (PersonListActivity.this.grg != null && !PersonListActivity.this.grg.isLoading()) {
                        PersonListActivity.this.grg.startLoadData();
                    }
                    PersonListActivity.this.djk();
                }
            }
        });
        this.lmT.setOnScrollListener(this.mOnScrollListener);
        this.lni.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void tR(boolean z2) {
                if (z2) {
                    PersonListActivity.this.cwH();
                } else if (PersonListActivity.this.lnj != null) {
                    PersonListActivity.this.lnj.UG();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void Bv(int i) {
                PersonListActivity.this.lmT.setSelection(0);
                PersonListActivity.this.mModel.uY(i);
            }
        });
        this.lni.setVisibility(8);
        this.lmX.setVisibility(8);
        this.grg = new PbListView(getActivity());
        this.grg.getView();
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.grg.setLineGone();
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.grg.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.lmT.setNextPage(this.grg);
    }

    private void djj() {
        this.lmX = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.lmX.setVisibility(8);
        this.lmX.setClickable(false);
        this.lmX.setEnabled(false);
        this.lmY = (TextView) this.lmX.findViewById(R.id.person_list_title);
        this.lmT.addHeaderView(this.lmX, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwH() {
        if (this.lnj == null) {
            this.lnj = new com.baidu.tieba.d.e(getPageContext(), this.lni.lmz);
            this.lnj.fO(R.drawable.bg_tip_blue_up);
            this.lnj.setMaxShowTime(2);
            this.lnj.fP(3000);
            this.lnj.yt(-10);
            this.lnj.setYOffset(-16);
            this.lnj.d(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.lnj != null) {
                        PersonListActivity.this.lnj.UG();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(be beVar, boolean z) {
        if (this.mModel != null && beVar != null && (!z || !this.lnb)) {
            if (!z) {
                this.lnb = true;
                d(beVar);
            }
            b(beVar);
            d(beVar, z);
            if (!this.mModel.bYF()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.byI().setMsgFans(0);
            }
            b(beVar, z);
        }
    }

    private void b(be beVar) {
        if (beVar != null) {
            if (!beVar.hasMore && !StringUtils.isNull(beVar.eHD) && !this.lne) {
                bw(beVar.eHD, beVar.type);
                this.lmT.removeFooterView(this.lnk);
                this.lmT.addFooterView(this.lnk);
                this.lmT.removeFooterView(this.grg.getView());
                TiebaStatic.log(new ar("c13106").al("obj_locate", 2));
            } else if (!beVar.hasMore) {
                this.lmT.removeFooterView(this.lnk);
                this.grg.setText(getString(R.string.no_more_data_tip));
                this.grg.endLoadData();
            } else {
                this.lmT.removeFooterView(this.lnk);
                this.grg.setText(getString(R.string.pb_load_more));
                this.grg.endLoadData();
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
            this.lmT.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bYF()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.lmU.setVisibility(0);
                    this.lmT.removeHeaderView(this.lmX);
                    TextView textView2 = this.lmW;
                    textView2.setVisibility(0);
                    this.lni.setVisibility(0);
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
                    this.lmU.setVisibility(8);
                    this.lmX.setVisibility(0);
                    TextView textView3 = this.lmY;
                    textView3.setVisibility(8);
                    this.lni.setVisibility(8);
                    if (this.gZB == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.gZB == 1) {
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
                this.lmU.setVisibility(8);
                this.lmX.setVisibility(0);
                TextView textView4 = this.lmY;
                this.lni.setVisibility(8);
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
                    if (this.gZB == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.gZB == 1) {
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
        this.lmT.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bYF()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.lni.setVisibility(0);
                this.lmW.setVisibility(0);
                this.lmU.setVisibility(0);
                this.lmX.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.lmW.setText(string + 0 + string2);
                return;
            }
            this.lni.setVisibility(8);
            this.lmW.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.lni.setVisibility(8);
        this.lmW.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (beVar != null && !StringUtils.isNull(beVar.eHD) && !this.lne) {
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
        if (this.lmZ != null) {
            if (!z) {
                if (beVar.pageNum == 1) {
                    this.lmZ.resetData();
                }
                this.lmZ.setHasMore(beVar.hasMore);
                this.lmZ.a(beVar);
                this.lmZ.bYD();
                this.lmZ.notifyDataSetChanged();
                return;
            }
            this.lmZ.setHasMore(false);
            this.lmZ.a(beVar);
            this.lmZ.bYD();
            this.lmZ.notifyDataSetChanged();
        }
    }

    private void bYJ() {
        showLoadingView(this.mContainer);
        this.mModel.bYG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djk() {
        if (this.lmZ != null) {
            this.lmZ.notifyDataSetChanged();
        }
        this.mModel.bYG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djl() {
        UserData userData;
        if (this.lmZ != null && this.lmZ.getItemViewType(this.lnh) == 0 && (userData = (UserData) this.lmZ.getItem(this.lnh)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            djl();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lni.djg()) {
                this.lni.djf();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bw(String str, int i) {
        if (this.lnk == null) {
            this.lnk = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.lnl = (TextView) this.lnk.findViewById(R.id.view_forbidden_tip);
            ap.setViewTextColor(this.lnl, R.color.CAM_X0109);
            ap.setBackgroundColor(this.lnk, R.color.CAM_X0201);
        }
        if (StringUtils.isNull(str)) {
            this.lnk.setVisibility(8);
            return;
        }
        this.lnl.setText(bx(str, i));
        this.lnl.setMovementMethod(LinkMovementMethod.getInstance());
        this.lnl.setHighlightColor(getResources().getColor(R.color.transparent));
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
                    PersonListActivity.this.djn();
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
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djm() {
        TiebaStatic.log(new ar("c13104").al("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.lnm.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djn() {
        TiebaStatic.log(new ar("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
