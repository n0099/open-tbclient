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
    private PbListView dlY;
    private NavigationBarCoverTip fjR;
    private TextView fjW;
    private boolean hrl;
    private ConcernSelectView hro;
    private com.baidu.tieba.c.d hrp;
    private View hrq;
    private TextView hrr;
    private e hrs;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView hrd = null;
    private View hre = null;
    private View hrf = null;
    private TextView hrg = null;
    private View hrh = null;
    private TextView hri = null;
    private b hrj = null;
    private NoPressedRelativeLayout hrk = null;
    private boolean dMG = true;
    private TextView faq = null;
    private int hrm = 0;
    int hrn = 0;
    private final AntiHelper.a fqe = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bTc));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bTc));
        }
    };
    private CustomMessageListener dnV = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().cgz != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().cgz, PersonListActivity.this.fqe) != null) {
                            TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bTc));
                        }
                    } else if (updateAttentionMessage.getData().Hi && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener hrt = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.hrj.dU(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.hrj.bMB();
                    PersonListActivity.this.hrj.notifyDataSetChanged();
                }
                if (PersonListActivity.this.hrj.hqS) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a hru = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
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
        this.hrs = new e(getPageContext(), getUniqueId());
        this.hrs.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.fjW == null) {
                            PersonListActivity.this.fjW = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.fjW.setGravity(19);
                            PersonListActivity.this.fjW.setPadding(l.g(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.fjW.setLayoutParams(new ViewGroup.LayoutParams(-1, l.g(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.fjW.setTextSize(0, l.g(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.fjW.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_btn_a));
                        }
                        PersonListActivity.this.fjW.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.fjR.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.fjR.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.fjR.a(PersonListActivity.this.getActivity(), PersonListActivity.this.fjW, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.hrr.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    al.j(PersonListActivity.this.hrr, R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bii() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.dnV);
        registerListener(this.hrt);
        this.mModel.aHr();
        if (this.dMG) {
            this.dMG = false;
            aUY();
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
        al.k(this.hrk, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.hrj != null) {
            this.hrj.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.hro.onChangeSkinType(i);
        al.l(this.hrg, R.color.cp_bg_line_d);
        al.j(this.hrg, R.color.cp_cont_d);
        al.l(this.hri, R.color.cp_bg_line_d);
        al.j(this.hri, R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.hrf != null) {
            getLayoutMode().onModeChanged(this.hrf);
        }
        if (this.hrh != null) {
            getLayoutMode().onModeChanged(this.hrh);
        }
        if (this.hrq != null) {
            al.j(this.hrr, R.color.cp_cont_d);
            al.l(this.hrq, R.color.cp_bg_line_d);
        }
        this.hrs.onChangeSkinType();
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_d));
        this.dlY.iP(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hrj != null) {
            this.hrj = null;
        }
        if (this.hrp != null) {
            this.hrp.aZA();
        }
        this.fjR.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.hru);
        if (bundle != null) {
            this.mModel.nl(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.hrm = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.hrm);
            return;
        }
        Intent intent = getIntent();
        this.mModel.nl(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.hrm = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.hrm);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.bMH());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.hrm);
    }

    private void initUI() {
        boolean z = true;
        this.hrk = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.faq = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hre = findViewById(R.id.sub_title_root);
        this.hrf = this.hre.findViewById(R.id.newheader_root);
        this.hre.setVisibility(8);
        this.hre.setClickable(false);
        this.hre.setEnabled(false);
        this.hrg = (TextView) this.hre.findViewById(R.id.person_list_title);
        this.hro = (ConcernSelectView) findViewById(R.id.select_layout);
        this.fjR = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bMH()) {
                this.faq.setText(R.string.my_attention);
                this.hrk.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void u(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.hro.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.hro.bMy() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.hrk.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.hro.bMx();
                        PersonListActivity.this.hrk.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.faq.setText(R.string.fans);
            }
        } else if (this.mModel.bMH()) {
            if (this.hrm == 2) {
                this.faq.setText(R.string.her_attention_people);
            } else if (this.hrm == 1) {
                this.faq.setText(R.string.his_attention_people);
            } else {
                this.faq.setText(R.string.his_attention_people);
            }
        } else if (this.hrm == 2) {
            this.faq.setText(R.string.attention_to_her);
        } else {
            this.faq.setText(R.string.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.hrj != null && PersonListActivity.this.hrj.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.hrj.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bMH()) {
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
                PersonListActivity.this.hrn = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.bME();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.bMD();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.hrj = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.hre.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.hrk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.hrj = new c(this, z, sex, onClickListener, onClickListener3);
            this.hre.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.hrk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.hrd = (BdListView) findViewById(R.id.list);
        this.hrd.setAdapter((ListAdapter) this.hrj);
        bMC();
        this.hrd.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.hrj != null && PersonListActivity.this.hrj.isHasMore()) {
                    if (PersonListActivity.this.dlY != null && !PersonListActivity.this.dlY.pu()) {
                        PersonListActivity.this.dlY.ajy();
                    }
                    PersonListActivity.this.bMD();
                }
            }
        });
        this.hro.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void nk(boolean z2) {
                if (z2) {
                    PersonListActivity.this.beC();
                } else if (PersonListActivity.this.hrp != null) {
                    PersonListActivity.this.hrp.aZA();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void sp(int i) {
                PersonListActivity.this.hrd.setSelection(0);
                PersonListActivity.this.mModel.mV(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.bMH()) {
            this.hro.bMw();
        }
        this.hro.setVisibility(8);
        this.hrh.setVisibility(8);
        this.dlY = new PbListView(getActivity());
        this.dlY.getView();
        this.dlY.iO(R.color.cp_bg_line_e);
        this.dlY.ajv();
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlY.setTextSize(R.dimen.tbfontsize33);
        this.dlY.iN(R.color.cp_cont_e);
        this.dlY.setHeight(l.g(getActivity(), R.dimen.tbds182));
        this.hrd.setNextPage(this.dlY);
    }

    private void bMC() {
        this.hrh = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.hrh.setVisibility(8);
        this.hrh.setClickable(false);
        this.hrh.setEnabled(false);
        this.hri = (TextView) this.hrh.findViewById(R.id.person_list_title);
        this.hrd.addHeaderView(this.hrh, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beC() {
        if (this.hrp == null) {
            this.hrp = new com.baidu.tieba.c.d(getPageContext(), this.hro.hqI);
            this.hrp.pK(R.drawable.bg_tip_blue_up);
            this.hrp.pM(2);
            this.hrp.pL(3000);
            this.hrp.pN(-10);
            this.hrp.setYOffset(-16);
            this.hrp.q(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.hrp != null) {
                        PersonListActivity.this.hrp.aZA();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(as asVar, boolean z) {
        if (this.mModel != null && asVar != null && (!z || !this.hrl)) {
            if (!z) {
                this.hrl = true;
                d(asVar);
            }
            b(asVar);
            d(asVar, z);
            if (!this.mModel.bMH()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgFans(0);
            }
            b(asVar, z);
        }
    }

    private void b(as asVar) {
        if (asVar != null) {
            if (!asVar.hasMore && !StringUtils.isNull(asVar.bHl)) {
                ba(asVar.bHl, asVar.type);
                this.hrd.removeFooterView(this.hrq);
                this.hrd.addFooterView(this.hrq);
                this.hrd.removeFooterView(this.dlY.getView());
                TiebaStatic.log(new am("c13106").P("obj_locate", 2));
            } else if (!asVar.hasMore) {
                this.hrd.removeFooterView(this.hrq);
                this.dlY.setText(getString(R.string.no_more_data_tip));
                this.dlY.ajz();
            } else {
                this.hrd.removeFooterView(this.hrq);
                this.dlY.setText(getString(R.string.pb_load_more));
                this.dlY.ajz();
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
            this.hrd.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bMH()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hre.setVisibility(0);
                    this.hrd.removeHeaderView(this.hrh);
                    TextView textView2 = this.hrg;
                    textView2.setVisibility(0);
                    this.hro.setVisibility(0);
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
                    this.hre.setVisibility(8);
                    this.hrh.setVisibility(0);
                    TextView textView3 = this.hri;
                    textView3.setVisibility(8);
                    this.hro.setVisibility(8);
                    if (this.hrm == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.her_no_attention_other));
                    } else if (this.hrm == 1) {
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
                this.hre.setVisibility(8);
                this.hrh.setVisibility(0);
                textView = this.hri;
                this.hro.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(R.string.my_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.not_have_fans));
                    z = false;
                } else if (this.hrm == 2) {
                    string = getPageContext().getString(R.string.her_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.her_no_fan_other));
                    z = false;
                } else if (this.hrm == 1) {
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
        this.hrd.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bMH()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.hro.setVisibility(0);
                this.hrg.setVisibility(0);
                this.hre.setVisibility(0);
                this.hrh.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention));
                this.hrg.setText(string + 0 + string2);
                return;
            }
            this.hro.setVisibility(8);
            this.hrg.setVisibility(8);
            if (this.hrm == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.her_no_attention_other));
                return;
            } else if (this.hrm == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.him_no_attention_other));
                return;
            }
        }
        this.hro.setVisibility(8);
        this.hrg.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (asVar != null && !StringUtils.isNull(asVar.bHl)) {
                this.mNoDataView.getSuTextView().setText(bb(asVar.bHl, asVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new am("c13106").P("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.not_have_fans));
        } else if (this.hrm == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.her_no_fan_other));
        } else if (this.hrm == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.him_no_fan_other));
        }
    }

    private void d(as asVar) {
        this.mModel.setPage(asVar.pageNum);
    }

    private void d(as asVar, boolean z) {
        if (this.hrj != null) {
            if (!z) {
                if (asVar.pageNum == 1) {
                    this.hrj.resetData();
                }
                this.hrj.setHasMore(asVar.hasMore);
                this.hrj.a(asVar);
                this.hrj.bMB();
                this.hrj.notifyDataSetChanged();
                return;
            }
            this.hrj.setHasMore(false);
            this.hrj.a(asVar);
            this.hrj.bMB();
            this.hrj.notifyDataSetChanged();
        }
    }

    private void aUY() {
        showProgressBar(true, 0, 0);
        this.mModel.bMI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMD() {
        if (this.hrj != null) {
            this.hrj.notifyDataSetChanged();
        }
        this.mModel.bMI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bME() {
        UserData userData;
        if (this.hrj != null && this.hrj.getItemViewType(this.hrn) == 0 && (userData = (UserData) this.hrj.getItem(this.hrn)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            bME();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hro.bMy()) {
                this.hro.bMx();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void ba(String str, int i) {
        if (this.hrq == null) {
            this.hrq = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.hrr = (TextView) this.hrq.findViewById(R.id.view_forbidden_tip);
            al.j(this.hrr, R.color.cp_cont_d);
            al.l(this.hrq, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.hrq.setVisibility(8);
            return;
        }
        this.hrr.setText(bb(str, i));
        this.hrr.setMovementMethod(LinkMovementMethod.getInstance());
        this.hrr.setHighlightColor(getResources().getColor(R.color.transparent));
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
                    PersonListActivity.this.bMG();
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
                    PersonListActivity.this.bMF();
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
    public void bMF() {
        TiebaStatic.log(new am("c13104").P("obj_locate", 1));
        if (!l.ki()) {
            showToast(getString(R.string.neterror));
        } else {
            this.hrs.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMG() {
        TiebaStatic.log(new am("c13103"));
        if (!l.ki()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
