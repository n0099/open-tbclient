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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
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
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes7.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView gxy;
    private NavigationBarCoverTip iVi;
    private TextView iVn;
    private boolean lnK;
    private NavigationBarShadowView lnL;
    private NavigationBarShadowView lnM;
    private ConcernSelectView lnQ;
    private e lnR;
    private View lnS;
    private TextView lnT;
    private com.baidu.tieba.forbidden.fans.d lnU;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView lnC = null;
    private View lnD = null;
    private View lnE = null;
    private TextView lnF = null;
    private View lnG = null;
    private TextView lnH = null;
    private b lnI = null;
    private NoPressedRelativeLayout lnJ = null;
    private boolean bvd = true;
    private TextView bIw = null;
    private int hgJ = 0;
    private boolean lnN = false;
    private int lnO = 0;
    int lnP = 0;
    private final AntiHelper.a jbW = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener jbX = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().fqk != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().fqk, PersonListActivity.this.jbW) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener lnV = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.lnI.hh(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.lnI.bXr();
                    PersonListActivity.this.lnI.notifyDataSetChanged();
                }
                if (PersonListActivity.this.lnI.hgz) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bXt()) {
                        PersonListActivity.this.lnL.show();
                    } else {
                        PersonListActivity.this.lnM.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.bXt()) {
                    PersonListActivity.this.lnL.hide();
                } else {
                    PersonListActivity.this.lnM.hide();
                }
            }
        }
    };
    public PersonListModel.a lnW = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void aD(String str, boolean z) {
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
            if (beVar != null && beVar.eMI != PersonListActivity.this.lnO && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.bXt() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.NV(PersonListActivity.this.mPortrait);
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
        this.lnU = new com.baidu.tieba.forbidden.fans.d(getPageContext(), getUniqueId());
        this.lnU.a(new d.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.iVn == null) {
                            PersonListActivity.this.iVn = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.iVn.setGravity(19);
                            PersonListActivity.this.iVn.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.iVn.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.iVn.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.iVn.setTextColor(PersonListActivity.this.getResources().getColor(R.color.CAM_X0101));
                        }
                        PersonListActivity.this.iVn.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.iVi.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.iVi.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.iVi.a(PersonListActivity.this.getActivity(), PersonListActivity.this.iVn, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.lnT.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    ao.setViewTextColor(PersonListActivity.this.lnT, R.color.CAM_X0109);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void czm() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.jbX);
        registerListener(this.lnV);
        this.mModel.bQw();
        if (this.bvd) {
            this.bvd = false;
            bXx();
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
        ao.setBackgroundResource(this.lnJ, R.color.CAM_X0201);
        ao.setBackgroundResource(this.mContainer, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.lnI != null) {
            this.lnI.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.lnQ.onChangeSkinType(i);
        ao.setBackgroundColor(this.lnF, R.color.CAM_X0201);
        ao.setViewTextColor(this.lnF, R.color.CAM_X0109);
        ao.setBackgroundColor(this.lnH, R.color.CAM_X0201);
        ao.setViewTextColor(this.lnH, R.color.CAM_X0109);
        getLayoutMode().setNightMode(i == 1);
        if (this.lnE != null) {
            getLayoutMode().onModeChanged(this.lnE);
        }
        if (this.lnG != null) {
            getLayoutMode().onModeChanged(this.lnG);
        }
        if (this.lnS != null) {
            ao.setViewTextColor(this.lnT, R.color.CAM_X0109);
            ao.setBackgroundColor(this.lnS, R.color.CAM_X0201);
        }
        this.lnU.onChangeSkinType();
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.gxy.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lnI != null) {
            this.lnI = null;
        }
        if (this.lnR != null) {
            this.lnR.RS();
        }
        this.iVi.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.lnW);
        if (bundle != null) {
            this.mModel.bu(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.hgJ = bundle.getInt("user_sex");
            this.lnN = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.lnO = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.hgJ);
            return;
        }
        Intent intent = getIntent();
        this.mModel.bu(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.hgJ = intent.getIntExtra("user_sex", 0);
        this.lnN = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.lnO = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.hgJ);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.bXt());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.hgJ);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.lnN);
    }

    private void initUI() {
        boolean z = true;
        this.lnJ = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bIw = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lnL = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.lnM = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.lnD = findViewById(R.id.sub_title_root);
        this.lnE = this.lnD.findViewById(R.id.newheader_root);
        this.lnD.setVisibility(8);
        this.lnD.setClickable(false);
        this.lnD.setEnabled(false);
        this.lnF = (TextView) this.lnD.findViewById(R.id.person_list_title);
        this.lnQ = (ConcernSelectView) findViewById(R.id.select_layout);
        this.iVi = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bXt()) {
                this.bIw.setText(R.string.my_attention);
                this.lnJ.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void E(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.lnQ.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.lnQ.dfc() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.lnJ.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.lnQ.dfb();
                        PersonListActivity.this.lnJ.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.bIw.setText(R.string.fans);
            }
        } else if (this.mModel.bXt()) {
            if (this.hgJ == 2) {
                this.bIw.setText(R.string.her_attention_people);
            } else if (this.hgJ == 1) {
                this.bIw.setText(R.string.his_attention_people);
            } else {
                this.bIw.setText(R.string.its_attention_people);
            }
        } else if (this.hgJ == 2) {
            this.bIw.setText(R.string.attention_to_her);
        } else if (this.hgJ == 1) {
            this.bIw.setText(R.string.attention_to_him);
        } else {
            this.bIw.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.lnI != null && PersonListActivity.this.lnI.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.lnI.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bXt()) {
                            TiebaStatic.log(new aq("c12772").dW("obj_locate", "1").dW("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new aq("c12605").an("obj_locate", 1).dW("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.lnP = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.dfh();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.dfg();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.lnI = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.lnD.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.lnJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.lnI = new c(this, z, sex, onClickListener, onClickListener3);
            this.lnD.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.lnJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.lnC = (BdListView) findViewById(R.id.list);
        this.lnC.setAdapter((ListAdapter) this.lnI);
        dff();
        this.lnC.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.lnI != null && PersonListActivity.this.lnI.isHasMore()) {
                    if (PersonListActivity.this.gxy != null && !PersonListActivity.this.gxy.isLoading()) {
                        PersonListActivity.this.gxy.startLoadData();
                    }
                    PersonListActivity.this.dfg();
                }
            }
        });
        this.lnC.setOnScrollListener(this.mOnScrollListener);
        this.lnQ.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void tO(boolean z2) {
                if (z2) {
                    PersonListActivity.this.cvJ();
                } else if (PersonListActivity.this.lnR != null) {
                    PersonListActivity.this.lnR.RS();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void Ab(int i) {
                PersonListActivity.this.lnC.setSelection(0);
                PersonListActivity.this.mModel.loadData(i);
            }
        });
        this.lnQ.setVisibility(8);
        this.lnG.setVisibility(8);
        this.gxy = new PbListView(getActivity());
        this.gxy.getView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gxy.setLineGone();
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gxy.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.lnC.setNextPage(this.gxy);
    }

    private void dff() {
        this.lnG = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.lnG.setVisibility(8);
        this.lnG.setClickable(false);
        this.lnG.setEnabled(false);
        this.lnH = (TextView) this.lnG.findViewById(R.id.person_list_title);
        this.lnC.addHeaderView(this.lnG, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvJ() {
        if (this.lnR == null) {
            this.lnR = new e(getPageContext(), this.lnQ.lni);
            this.lnR.ej(R.drawable.bg_tip_blue_up);
            this.lnR.setMaxShowTime(2);
            this.lnR.ek(3000);
            this.lnR.xb(-10);
            this.lnR.setYOffset(-16);
            this.lnR.e(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.lnR != null) {
                        PersonListActivity.this.lnR.RS();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(be beVar, boolean z) {
        if (this.mModel != null && beVar != null && (!z || !this.lnK)) {
            if (!z) {
                this.lnK = true;
                d(beVar);
            }
            b(beVar);
            d(beVar, z);
            if (!this.mModel.bXt()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bxj().setMsgFans(0);
            }
            b(beVar, z);
        }
    }

    private void b(be beVar) {
        if (beVar != null) {
            if (!beVar.hasMore && !StringUtils.isNull(beVar.eMJ) && !this.lnN) {
                bE(beVar.eMJ, beVar.type);
                this.lnC.removeFooterView(this.lnS);
                this.lnC.addFooterView(this.lnS);
                this.lnC.removeFooterView(this.gxy.getView());
                TiebaStatic.log(new aq("c13106").an("obj_locate", 2));
            } else if (!beVar.hasMore) {
                this.lnC.removeFooterView(this.lnS);
                this.gxy.setText(getString(R.string.no_more_data_tip));
                this.gxy.endLoadData();
            } else {
                this.lnC.removeFooterView(this.lnS);
                this.gxy.setText(getString(R.string.pb_load_more));
                this.gxy.endLoadData();
            }
        }
    }

    private void b(be beVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (beVar.eMI > 0 && !x.isEmpty(beVar.bmp())) {
                c(beVar);
            } else {
                c(beVar, z);
            }
        }
    }

    private void c(be beVar) {
        TextView textView;
        String string;
        String string2;
        String str;
        String str2;
        boolean z;
        String string3;
        String string4;
        if (beVar != null) {
            this.lnC.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bXt()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.lnD.setVisibility(0);
                    this.lnC.removeHeaderView(this.lnG);
                    TextView textView2 = this.lnF;
                    textView2.setVisibility(0);
                    this.lnQ.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    str = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, getResources().getString(R.string.not_have_attention)));
                    textView = textView2;
                    str2 = string4;
                    z = false;
                } else {
                    this.lnD.setVisibility(8);
                    this.lnG.setVisibility(0);
                    textView = this.lnH;
                    textView.setVisibility(8);
                    this.lnQ.setVisibility(8);
                    if (this.hgJ == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.hgJ == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, getResources().getString(R.string.not_have_attention_guest)));
                    str = getPageContext().getString(R.string.person);
                    str2 = string3;
                    z = x.isEmpty(beVar.bmq()) ? false : true;
                }
            } else {
                this.lnD.setVisibility(8);
                this.lnG.setVisibility(0);
                textView = this.lnH;
                this.lnQ.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    String string5 = getPageContext().getString(R.string.my_fans_prefix);
                    String string6 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, getResources().getString(R.string.not_have_fans)));
                    str = string6;
                    str2 = string5;
                    z = false;
                } else {
                    if (this.hgJ == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.hgJ == 1) {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, getResources().getString(R.string.her_no_fan_guest)));
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
            textView.setText(str2 + at.numberUniformFormat(beVar.eMI) + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(be beVar, boolean z) {
        String string;
        this.lnC.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bXt()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.lnQ.setVisibility(0);
                this.lnF.setVisibility(0);
                this.lnD.setVisibility(0);
                this.lnG.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.lnF.setText(string + 0 + string2);
                return;
            }
            this.lnQ.setVisibility(8);
            this.lnF.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.lnQ.setVisibility(8);
        this.lnF.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (beVar != null && !StringUtils.isNull(beVar.eMJ) && !this.lnN) {
                this.mNoDataView.getSuTextView().setText(bF(beVar.eMJ, beVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new aq("c13106").an("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, getResources().getString(R.string.not_have_fans)));
            return;
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, getResources().getString(R.string.her_no_fan_guest)));
    }

    private void d(be beVar) {
        this.mModel.setPage(beVar.pageNum);
    }

    private void d(be beVar, boolean z) {
        if (this.lnI != null) {
            if (!z) {
                if (beVar.pageNum == 1) {
                    this.lnI.resetData();
                }
                this.lnI.setHasMore(beVar.hasMore);
                this.lnI.a(beVar);
                this.lnI.bXr();
                this.lnI.notifyDataSetChanged();
                return;
            }
            this.lnI.setHasMore(false);
            this.lnI.a(beVar);
            this.lnI.bXr();
            this.lnI.notifyDataSetChanged();
        }
    }

    private void bXx() {
        showLoadingView(this.mContainer);
        this.mModel.bXu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfg() {
        if (this.lnI != null) {
            this.lnI.notifyDataSetChanged();
        }
        this.mModel.bXu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfh() {
        UserData userData;
        if (this.lnI != null && this.lnI.getItemViewType(this.lnP) == 0 && (userData = (UserData) this.lnI.getItem(this.lnP)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            dfh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lnQ.dfc()) {
                this.lnQ.dfb();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bE(String str, int i) {
        if (this.lnS == null) {
            this.lnS = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.lnT = (TextView) this.lnS.findViewById(R.id.view_forbidden_tip);
            ao.setViewTextColor(this.lnT, R.color.CAM_X0109);
            ao.setBackgroundColor(this.lnS, R.color.CAM_X0201);
        }
        if (StringUtils.isNull(str)) {
            this.lnS.setVisibility(8);
            return;
        }
        this.lnT.setText(bF(str, i));
        this.lnT.setMovementMethod(LinkMovementMethod.getInstance());
        this.lnT.setHighlightColor(getResources().getColor(R.color.transparent));
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
                    PersonListActivity.this.dfj();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ao.getColor(R.color.CAM_X0302));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        if (!StringUtils.isNull(string)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), string, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.dfi();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ao.getColor(R.color.CAM_X0302));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfi() {
        TiebaStatic.log(new aq("c13104").an("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.lnU.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfj() {
        TiebaStatic.log(new aq("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
