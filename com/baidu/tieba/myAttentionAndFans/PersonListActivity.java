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
/* loaded from: classes8.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView gCf;
    private NavigationBarCoverTip iZP;
    private TextView iZU;
    private e lsA;
    private View lsB;
    private TextView lsC;
    private com.baidu.tieba.forbidden.fans.d lsD;
    private boolean lst;
    private NavigationBarShadowView lsu;
    private NavigationBarShadowView lsv;
    private ConcernSelectView lsz;
    private RelativeLayout mContainer;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mPortrait;
    private BdListView lsl = null;
    private View lsm = null;
    private View lsn = null;
    private TextView lso = null;
    private View lsp = null;
    private TextView lsq = null;
    private b lsr = null;
    private NoPressedRelativeLayout lss = null;
    private boolean bzP = true;
    private TextView bNi = null;
    private int hlq = 0;
    private boolean lsw = false;
    private int lsx = 0;
    int lsy = 0;
    private final AntiHelper.a jgD = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener jgE = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) && updateAttentionMessage.getData().fuV != null && AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().fuV, PersonListActivity.this.jgD) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };
    private HttpMessageListener lsE = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.lsr.hh(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.lsr.cbi();
                    PersonListActivity.this.lsr.notifyDataSetChanged();
                }
                if (PersonListActivity.this.lsr.hlg) {
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
                    if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.cbk()) {
                        PersonListActivity.this.lsu.show();
                    } else {
                        PersonListActivity.this.lsv.show();
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
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.cbk()) {
                    PersonListActivity.this.lsu.hide();
                } else {
                    PersonListActivity.this.lsv.hide();
                }
            }
        }
    };
    public PersonListModel.a lsF = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
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
            if (beVar != null && beVar.eRt != PersonListActivity.this.lsx && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.cbk() && PersonListActivity.this.mModel.getLoadType() == 0) {
                PersonListActivity.this.mModel.Pd(PersonListActivity.this.mPortrait);
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
        this.lsD = new com.baidu.tieba.forbidden.fans.d(getPageContext(), getUniqueId());
        this.lsD.a(new d.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.iZU == null) {
                            PersonListActivity.this.iZU = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.iZU.setGravity(19);
                            PersonListActivity.this.iZU.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.iZU.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.iZU.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.iZU.setTextColor(PersonListActivity.this.getResources().getColor(R.color.CAM_X0101));
                        }
                        PersonListActivity.this.iZU.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.iZP.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.iZP.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.iZP.a(PersonListActivity.this.getActivity(), PersonListActivity.this.iZU, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.lsC.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    ao.setViewTextColor(PersonListActivity.this.lsC, R.color.CAM_X0109);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void cDd() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.jgE);
        registerListener(this.lsE);
        this.mModel.bUn();
        if (this.bzP) {
            this.bzP = false;
            cbo();
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
        ao.setBackgroundResource(this.lss, R.color.CAM_X0201);
        ao.setBackgroundResource(this.mContainer, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.lsr != null) {
            this.lsr.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.lsz.onChangeSkinType(i);
        ao.setBackgroundColor(this.lso, R.color.CAM_X0201);
        ao.setViewTextColor(this.lso, R.color.CAM_X0109);
        ao.setBackgroundColor(this.lsq, R.color.CAM_X0201);
        ao.setViewTextColor(this.lsq, R.color.CAM_X0109);
        getLayoutMode().setNightMode(i == 1);
        if (this.lsn != null) {
            getLayoutMode().onModeChanged(this.lsn);
        }
        if (this.lsp != null) {
            getLayoutMode().onModeChanged(this.lsp);
        }
        if (this.lsB != null) {
            ao.setViewTextColor(this.lsC, R.color.CAM_X0109);
            ao.setBackgroundColor(this.lsB, R.color.CAM_X0201);
        }
        this.lsD.onChangeSkinType();
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.gCf.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lsr != null) {
            this.lsr = null;
        }
        if (this.lsA != null) {
            this.lsA.VL();
        }
        this.iZP.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.lsF);
        if (bundle != null) {
            this.mModel.by(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.hlq = bundle.getInt("user_sex");
            this.lsw = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.lsx = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.hlq);
            return;
        }
        Intent intent = getIntent();
        this.mModel.by(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.hlq = intent.getIntExtra("user_sex", 0);
        this.lsw = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.lsx = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.hlq);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.cbk());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.hlq);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.lsw);
    }

    private void initUI() {
        boolean z = true;
        this.lss = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bNi = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lsu = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.lsv = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        this.lsm = findViewById(R.id.sub_title_root);
        this.lsn = this.lsm.findViewById(R.id.newheader_root);
        this.lsm.setVisibility(8);
        this.lsm.setClickable(false);
        this.lsm.setEnabled(false);
        this.lso = (TextView) this.lsm.findViewById(R.id.person_list_title);
        this.lsz = (ConcernSelectView) findViewById(R.id.select_layout);
        this.iZP = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.cbk()) {
                this.bNi.setText(R.string.my_attention);
                this.lss.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void E(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.lsz.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.lsz.diT() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.lss.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.lsz.diS();
                        PersonListActivity.this.lss.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.bNi.setText(R.string.fans);
            }
        } else if (this.mModel.cbk()) {
            if (this.hlq == 2) {
                this.bNi.setText(R.string.her_attention_people);
            } else if (this.hlq == 1) {
                this.bNi.setText(R.string.his_attention_people);
            } else {
                this.bNi.setText(R.string.its_attention_people);
            }
        } else if (this.hlq == 2) {
            this.bNi.setText(R.string.attention_to_her);
        } else if (this.hlq == 1) {
            this.bNi.setText(R.string.attention_to_him);
        } else {
            this.bNi.setText(R.string.attention_to_it);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.lsr != null && PersonListActivity.this.lsr.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.lsr.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.cbk()) {
                            TiebaStatic.log(new aq("c12772").dX("obj_locate", "1").dX("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new aq("c12605").an("obj_locate", 1).dX("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.lsy = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.diY();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.diX();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.lsr = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.lsm.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.lss, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.lsr = new c(this, z, sex, onClickListener, onClickListener3);
            this.lsm.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.lss, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.lsl = (BdListView) findViewById(R.id.list);
        this.lsl.setAdapter((ListAdapter) this.lsr);
        diW();
        this.lsl.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.lsr != null && PersonListActivity.this.lsr.isHasMore()) {
                    if (PersonListActivity.this.gCf != null && !PersonListActivity.this.gCf.isLoading()) {
                        PersonListActivity.this.gCf.startLoadData();
                    }
                    PersonListActivity.this.diX();
                }
            }
        });
        this.lsl.setOnScrollListener(this.mOnScrollListener);
        this.lsz.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void tS(boolean z2) {
                if (z2) {
                    PersonListActivity.this.czA();
                } else if (PersonListActivity.this.lsA != null) {
                    PersonListActivity.this.lsA.VL();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void BH(int i) {
                PersonListActivity.this.lsl.setSelection(0);
                PersonListActivity.this.mModel.loadData(i);
            }
        });
        this.lsz.setVisibility(8);
        this.lsp.setVisibility(8);
        this.gCf = new PbListView(getActivity());
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.lsl.setNextPage(this.gCf);
    }

    private void diW() {
        this.lsp = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.lsp.setVisibility(8);
        this.lsp.setClickable(false);
        this.lsp.setEnabled(false);
        this.lsq = (TextView) this.lsp.findViewById(R.id.person_list_title);
        this.lsl.addHeaderView(this.lsp, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czA() {
        if (this.lsA == null) {
            this.lsA = new e(getPageContext(), this.lsz.lrR);
            this.lsA.fP(R.drawable.bg_tip_blue_up);
            this.lsA.setMaxShowTime(2);
            this.lsA.fQ(3000);
            this.lsA.yH(-10);
            this.lsA.setYOffset(-16);
            this.lsA.e(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.lsA != null) {
                        PersonListActivity.this.lsA.VL();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(be beVar, boolean z) {
        if (this.mModel != null && beVar != null && (!z || !this.lst)) {
            if (!z) {
                this.lst = true;
                d(beVar);
            }
            b(beVar);
            d(beVar, z);
            if (!this.mModel.cbk()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.bBc().setMsgFans(0);
            }
            b(beVar, z);
        }
    }

    private void b(be beVar) {
        if (beVar != null) {
            if (!beVar.hasMore && !StringUtils.isNull(beVar.eRu) && !this.lsw) {
                bD(beVar.eRu, beVar.type);
                this.lsl.removeFooterView(this.lsB);
                this.lsl.addFooterView(this.lsB);
                this.lsl.removeFooterView(this.gCf.getView());
                TiebaStatic.log(new aq("c13106").an("obj_locate", 2));
            } else if (!beVar.hasMore) {
                this.lsl.removeFooterView(this.lsB);
                this.gCf.setText(getString(R.string.no_more_data_tip));
                this.gCf.endLoadData();
            } else {
                this.lsl.removeFooterView(this.lsB);
                this.gCf.setText(getString(R.string.pb_load_more));
                this.gCf.endLoadData();
            }
        }
    }

    private void b(be beVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideLoadingView(this.mContainer);
            if (beVar.eRt > 0 && !x.isEmpty(beVar.bqi())) {
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
            this.lsl.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.cbk()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.lsm.setVisibility(0);
                    this.lsl.removeHeaderView(this.lsp);
                    TextView textView2 = this.lso;
                    textView2.setVisibility(0);
                    this.lsz.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    str = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, getResources().getString(R.string.not_have_attention)));
                    textView = textView2;
                    str2 = string4;
                    z = false;
                } else {
                    this.lsm.setVisibility(8);
                    this.lsp.setVisibility(0);
                    textView = this.lsq;
                    textView.setVisibility(8);
                    this.lsz.setVisibility(8);
                    if (this.hlq == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                    } else if (this.hlq == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, getResources().getString(R.string.not_have_attention_guest)));
                    str = getPageContext().getString(R.string.person);
                    str2 = string3;
                    z = x.isEmpty(beVar.bqj()) ? false : true;
                }
            } else {
                this.lsm.setVisibility(8);
                this.lsp.setVisibility(0);
                textView = this.lsq;
                this.lsz.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    String string5 = getPageContext().getString(R.string.my_fans_prefix);
                    String string6 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, getResources().getString(R.string.not_have_fans)));
                    str = string6;
                    str2 = string5;
                    z = false;
                } else {
                    if (this.hlq == 2) {
                        string = getPageContext().getString(R.string.her_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else if (this.hlq == 1) {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    } else {
                        string = getPageContext().getString(R.string.his_fans_prefix);
                        string2 = getPageContext().getString(R.string.fans_suffix);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, getResources().getString(R.string.her_no_fan_guest)));
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
            textView.setText(str2 + at.numberUniformFormat(beVar.eRt) + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(be beVar, boolean z) {
        String string;
        this.lsl.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.cbk()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.lsz.setVisibility(0);
                this.lso.setVisibility(0);
                this.lsm.setVisibility(0);
                this.lsp.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, getResources().getString(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                this.lso.setText(string + 0 + string2);
                return;
            }
            this.lsz.setVisibility(8);
            this.lso.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.lsz.setVisibility(8);
        this.lso.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (beVar != null && !StringUtils.isNull(beVar.eRu) && !this.lsw) {
                this.mNoDataView.getSuTextView().setText(bE(beVar.eRu, beVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new aq("c13106").an("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, getResources().getString(R.string.not_have_fans)));
            return;
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, getResources().getString(R.string.her_no_fan_guest)));
    }

    private void d(be beVar) {
        this.mModel.setPage(beVar.pageNum);
    }

    private void d(be beVar, boolean z) {
        if (this.lsr != null) {
            if (!z) {
                if (beVar.pageNum == 1) {
                    this.lsr.resetData();
                }
                this.lsr.setHasMore(beVar.hasMore);
                this.lsr.a(beVar);
                this.lsr.cbi();
                this.lsr.notifyDataSetChanged();
                return;
            }
            this.lsr.setHasMore(false);
            this.lsr.a(beVar);
            this.lsr.cbi();
            this.lsr.notifyDataSetChanged();
        }
    }

    private void cbo() {
        showLoadingView(this.mContainer);
        this.mModel.cbl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diX() {
        if (this.lsr != null) {
            this.lsr.notifyDataSetChanged();
        }
        this.mModel.cbl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diY() {
        UserData userData;
        if (this.lsr != null && this.lsr.getItemViewType(this.lsy) == 0 && (userData = (UserData) this.lsr.getItem(this.lsy)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            diY();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.lsz.diT()) {
                this.lsz.diS();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bD(String str, int i) {
        if (this.lsB == null) {
            this.lsB = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.lsC = (TextView) this.lsB.findViewById(R.id.view_forbidden_tip);
            ao.setViewTextColor(this.lsC, R.color.CAM_X0109);
            ao.setBackgroundColor(this.lsB, R.color.CAM_X0201);
        }
        if (StringUtils.isNull(str)) {
            this.lsB.setVisibility(8);
            return;
        }
        this.lsC.setText(bE(str, i));
        this.lsC.setMovementMethod(LinkMovementMethod.getInstance());
        this.lsC.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private SpannableStringBuilder bE(String str, int i) {
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
                    PersonListActivity.this.dja();
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
                    PersonListActivity.this.diZ();
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
    public void diZ() {
        TiebaStatic.log(new aq("c13104").an("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.lsD.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dja() {
        TiebaStatic.log(new aq("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
