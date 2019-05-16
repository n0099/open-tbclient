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
import android.widget.ListAdapter;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MyForbiddenFansActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
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
/* loaded from: classes5.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView dlX;
    private NavigationBarCoverTip fjQ;
    private TextView fjV;
    private boolean hri;
    private ConcernSelectView hrl;
    private com.baidu.tieba.c.d hrm;
    private View hrn;
    private TextView hro;
    private e hrp;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView hra = null;
    private View hrb = null;
    private View hrc = null;
    private TextView hrd = null;
    private View hre = null;
    private TextView hrf = null;
    private b hrg = null;
    private NoPressedRelativeLayout hrh = null;
    private boolean dMF = true;
    private TextView fap = null;
    private int hrj = 0;
    int hrk = 0;
    private final AntiHelper.a fqd = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bTc));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bTc));
        }
    };
    private CustomMessageListener dnU = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().cgz != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().cgz, PersonListActivity.this.fqd) != null) {
                            TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bTc));
                        }
                    } else if (updateAttentionMessage.getData().Hi && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener hrq = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.hrg.dU(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.hrg.bMy();
                    PersonListActivity.this.hrg.notifyDataSetChanged();
                }
                if (PersonListActivity.this.hrg.hqP) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a hrr = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void an(String str, boolean z) {
            if (!z) {
                if (PersonListActivity.this.isProgressBarShown()) {
                    PersonListActivity.this.hideProgressBar();
                }
                if (!TextUtils.isEmpty(str)) {
                    PersonListActivity.this.showToast(str);
                }
                PersonListActivity.this.c(null, false);
            }
        }

        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public as e(as asVar, boolean z) {
            PersonListActivity.this.a(asVar, z);
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
        this.hrp = new e(getPageContext(), getUniqueId());
        this.hrp.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.fjV == null) {
                            PersonListActivity.this.fjV = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.fjV.setGravity(19);
                            PersonListActivity.this.fjV.setPadding(l.g(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.fjV.setLayoutParams(new ViewGroup.LayoutParams(-1, l.g(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.fjV.setTextSize(0, l.g(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.fjV.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_btn_a));
                        }
                        PersonListActivity.this.fjV.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.fjQ.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.fjQ.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.fjQ.a(PersonListActivity.this.getActivity(), PersonListActivity.this.fjV, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.hro.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    al.j(PersonListActivity.this.hro, R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bif() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.dnU);
        registerListener(this.hrq);
        this.mModel.aHo();
        if (this.dMF) {
            this.dMF = false;
            aUV();
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
        al.k(this.hrh, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.hrg != null) {
            this.hrg.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.hrl.onChangeSkinType(i);
        al.l(this.hrd, R.color.cp_bg_line_d);
        al.j(this.hrd, R.color.cp_cont_d);
        al.l(this.hrf, R.color.cp_bg_line_d);
        al.j(this.hrf, R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.hrc != null) {
            getLayoutMode().onModeChanged(this.hrc);
        }
        if (this.hre != null) {
            getLayoutMode().onModeChanged(this.hre);
        }
        if (this.hrn != null) {
            al.j(this.hro, R.color.cp_cont_d);
            al.l(this.hrn, R.color.cp_bg_line_d);
        }
        this.hrp.onChangeSkinType();
        this.dlX.setTextColor(al.getColor(R.color.cp_cont_d));
        this.dlX.iP(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hrg != null) {
            this.hrg = null;
        }
        if (this.hrm != null) {
            this.hrm.aZx();
        }
        this.fjQ.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.hrr);
        if (bundle != null) {
            this.mModel.nl(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.hrj = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.hrj);
            return;
        }
        Intent intent = getIntent();
        this.mModel.nl(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.hrj = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.hrj);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.bME());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.hrj);
    }

    private void initUI() {
        boolean z = true;
        this.hrh = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.fap = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hrb = findViewById(R.id.sub_title_root);
        this.hrc = this.hrb.findViewById(R.id.newheader_root);
        this.hrb.setVisibility(8);
        this.hrb.setClickable(false);
        this.hrb.setEnabled(false);
        this.hrd = (TextView) this.hrb.findViewById(R.id.person_list_title);
        this.hrl = (ConcernSelectView) findViewById(R.id.select_layout);
        this.fjQ = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bME()) {
                this.fap.setText(R.string.my_attention);
                this.hrh.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void u(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.hrl.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.hrl.bMv() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.hrh.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.hrl.bMu();
                        PersonListActivity.this.hrh.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.fap.setText(R.string.fans);
            }
        } else if (this.mModel.bME()) {
            if (this.hrj == 2) {
                this.fap.setText(R.string.her_attention_people);
            } else if (this.hrj == 1) {
                this.fap.setText(R.string.his_attention_people);
            } else {
                this.fap.setText(R.string.his_attention_people);
            }
        } else if (this.hrj == 2) {
            this.fap.setText(R.string.attention_to_her);
        } else {
            this.fap.setText(R.string.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.hrg != null && PersonListActivity.this.hrg.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.hrg.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bME()) {
                            TiebaStatic.log(new am("c12772").bT("obj_locate", "1").bT("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new am("c12605").P("obj_locate", 1).bT("obj_param1", userData.getUserId()));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.myAttentionAndFans.PersonListActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.hrk = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.bMB();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.bMA();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.hrg = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.hrb.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.hrh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.hrg = new c(this, z, sex, onClickListener, onClickListener3);
            this.hrb.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.hrh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.hra = (BdListView) findViewById(R.id.list);
        this.hra.setAdapter((ListAdapter) this.hrg);
        bMz();
        this.hra.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.hrg != null && PersonListActivity.this.hrg.isHasMore()) {
                    if (PersonListActivity.this.dlX != null && !PersonListActivity.this.dlX.pu()) {
                        PersonListActivity.this.dlX.ajy();
                    }
                    PersonListActivity.this.bMA();
                }
            }
        });
        this.hrl.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void nk(boolean z2) {
                if (z2) {
                    PersonListActivity.this.bez();
                } else if (PersonListActivity.this.hrm != null) {
                    PersonListActivity.this.hrm.aZx();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void sp(int i) {
                PersonListActivity.this.hra.setSelection(0);
                PersonListActivity.this.mModel.mV(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.bME()) {
            this.hrl.bMt();
        }
        this.hrl.setVisibility(8);
        this.hre.setVisibility(8);
        this.dlX = new PbListView(getActivity());
        this.dlX.getView();
        this.dlX.iO(R.color.cp_bg_line_e);
        this.dlX.ajv();
        this.dlX.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlX.setTextSize(R.dimen.tbfontsize33);
        this.dlX.iN(R.color.cp_cont_e);
        this.dlX.setHeight(l.g(getActivity(), R.dimen.tbds182));
        this.hra.setNextPage(this.dlX);
    }

    private void bMz() {
        this.hre = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.hre.setVisibility(8);
        this.hre.setClickable(false);
        this.hre.setEnabled(false);
        this.hrf = (TextView) this.hre.findViewById(R.id.person_list_title);
        this.hra.addHeaderView(this.hre, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bez() {
        if (this.hrm == null) {
            this.hrm = new com.baidu.tieba.c.d(getPageContext(), this.hrl.hqF);
            this.hrm.pK(R.drawable.bg_tip_blue_up);
            this.hrm.pM(2);
            this.hrm.pL(3000);
            this.hrm.pN(-10);
            this.hrm.setYOffset(-16);
            this.hrm.q(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.hrm != null) {
                        PersonListActivity.this.hrm.aZx();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(as asVar, boolean z) {
        if (this.mModel != null && asVar != null && (!z || !this.hri)) {
            if (!z) {
                this.hri = true;
                d(asVar);
            }
            b(asVar);
            d(asVar, z);
            if (!this.mModel.bME()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgFans(0);
            }
            b(asVar, z);
        }
    }

    private void b(as asVar) {
        if (asVar != null) {
            if (!asVar.hasMore && !StringUtils.isNull(asVar.bHl)) {
                ba(asVar.bHl, asVar.type);
                this.hra.removeFooterView(this.hrn);
                this.hra.addFooterView(this.hrn);
                this.hra.removeFooterView(this.dlX.getView());
                TiebaStatic.log(new am("c13106").P("obj_locate", 2));
            } else if (!asVar.hasMore) {
                this.hra.removeFooterView(this.hrn);
                this.dlX.setText(getString(R.string.no_more_data_tip));
                this.dlX.ajz();
            } else {
                this.hra.removeFooterView(this.hrn);
                this.dlX.setText(getString(R.string.pb_load_more));
                this.dlX.ajz();
            }
        }
    }

    private void b(as asVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (asVar.bHk > 0 && !v.aa(asVar.acs())) {
                c(asVar);
            } else {
                c(asVar, z);
            }
        }
    }

    private void c(as asVar) {
        TextView textView;
        String string;
        String string2;
        boolean z;
        String string3;
        String string4;
        if (asVar != null) {
            this.hra.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bME()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hrb.setVisibility(0);
                    this.hra.removeHeaderView(this.hre);
                    TextView textView2 = this.hrd;
                    textView2.setVisibility(0);
                    this.hrl.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    String string5 = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.hrb.setVisibility(8);
                    this.hre.setVisibility(0);
                    TextView textView3 = this.hrf;
                    textView3.setVisibility(8);
                    this.hrl.setVisibility(8);
                    if (this.hrj == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.her_no_attention_other));
                    } else if (this.hrj == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(R.string.person);
                    string = string3;
                    textView = textView3;
                    z = v.aa(asVar.act()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.hrb.setVisibility(8);
                this.hre.setVisibility(0);
                textView = this.hrf;
                this.hrl.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(R.string.my_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.not_have_fans));
                    z = false;
                } else if (this.hrj == 2) {
                    string = getPageContext().getString(R.string.her_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.her_no_fan_other));
                    z = false;
                } else if (this.hrj == 1) {
                    string = getPageContext().getString(R.string.his_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(R.string.his_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(R.string.we_common_fans));
                return;
            }
            textView.setText(string + ap.aG(asVar.bHk) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(as asVar, boolean z) {
        String string;
        this.hra.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bME()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.hrl.setVisibility(0);
                this.hrd.setVisibility(0);
                this.hrb.setVisibility(0);
                this.hre.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention));
                this.hrd.setText(string + 0 + string2);
                return;
            }
            this.hrl.setVisibility(8);
            this.hrd.setVisibility(8);
            if (this.hrj == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.her_no_attention_other));
                return;
            } else if (this.hrj == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.him_no_attention_other));
                return;
            }
        }
        this.hrl.setVisibility(8);
        this.hrd.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (asVar != null && !StringUtils.isNull(asVar.bHl)) {
                this.mNoDataView.getSuTextView().setText(bb(asVar.bHl, asVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new am("c13106").P("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.not_have_fans));
        } else if (this.hrj == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.her_no_fan_other));
        } else if (this.hrj == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.him_no_fan_other));
        }
    }

    private void d(as asVar) {
        this.mModel.setPage(asVar.pageNum);
    }

    private void d(as asVar, boolean z) {
        if (this.hrg != null) {
            if (!z) {
                if (asVar.pageNum == 1) {
                    this.hrg.resetData();
                }
                this.hrg.setHasMore(asVar.hasMore);
                this.hrg.a(asVar);
                this.hrg.bMy();
                this.hrg.notifyDataSetChanged();
                return;
            }
            this.hrg.setHasMore(false);
            this.hrg.a(asVar);
            this.hrg.bMy();
            this.hrg.notifyDataSetChanged();
        }
    }

    private void aUV() {
        showProgressBar(true, 0, 0);
        this.mModel.bMF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMA() {
        if (this.hrg != null) {
            this.hrg.notifyDataSetChanged();
        }
        this.mModel.bMF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMB() {
        UserData userData;
        if (this.hrg != null && this.hrg.getItemViewType(this.hrk) == 0 && (userData = (UserData) this.hrg.getItem(this.hrk)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "enter_chat", "personlistclick", 1, new Object[0]);
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 11028) {
            bMB();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hrl.bMv()) {
                this.hrl.bMu();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void ba(String str, int i) {
        if (this.hrn == null) {
            this.hrn = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.hro = (TextView) this.hrn.findViewById(R.id.view_forbidden_tip);
            al.j(this.hro, R.color.cp_cont_d);
            al.l(this.hrn, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.hrn.setVisibility(8);
            return;
        }
        this.hro.setText(bb(str, i));
        this.hro.setMovementMethod(LinkMovementMethod.getInstance());
        this.hro.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private SpannableStringBuilder bb(String str, int i) {
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
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), string, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.bMD();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(al.getColor(R.color.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.6
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.bMC();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(al.getColor(R.color.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMC() {
        TiebaStatic.log(new am("c13104").P("obj_locate", 1));
        if (!l.ki()) {
            showToast(getString(R.string.neterror));
        } else {
            this.hrp.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMD() {
        TiebaStatic.log(new am("c13103"));
        if (!l.ki()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
