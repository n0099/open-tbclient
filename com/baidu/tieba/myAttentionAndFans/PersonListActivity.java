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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
    private PbListView dpz;
    private NavigationBarCoverTip frb;
    private TextView frg;
    private boolean hAm;
    private ConcernSelectView hAp;
    private com.baidu.tieba.c.d hAq;
    private View hAr;
    private TextView hAs;
    private e hAt;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView hAe = null;
    private View hAf = null;
    private View hAg = null;
    private TextView hAh = null;
    private View hAi = null;
    private TextView hAj = null;
    private b hAk = null;
    private NoPressedRelativeLayout hAl = null;
    private boolean dSg = true;
    private TextView fhE = null;
    private int hAn = 0;
    int hAo = 0;
    private final AntiHelper.a fxo = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").P("obj_locate", at.a.bUN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").P("obj_locate", at.a.bUN));
        }
    };
    private CustomMessageListener dAA = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().ciI != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().ciI, PersonListActivity.this.fxo) != null) {
                            TiebaStatic.log(new an("c12534").P("obj_locate", at.a.bUN));
                        }
                    } else if (updateAttentionMessage.getData().Hs && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener hAu = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.hAk.eh(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.hAk.bQm();
                    PersonListActivity.this.hAk.notifyDataSetChanged();
                }
                if (PersonListActivity.this.hAk.hzT) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a hAv = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void ar(String str, boolean z) {
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
        this.hAt = new e(getPageContext(), getUniqueId());
        this.hAt.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.frg == null) {
                            PersonListActivity.this.frg = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.frg.setGravity(19);
                            PersonListActivity.this.frg.setPadding(l.g(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.frg.setLayoutParams(new ViewGroup.LayoutParams(-1, l.g(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.frg.setTextSize(0, l.g(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.frg.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        PersonListActivity.this.frg.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.frb.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.frb.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.frb.a(PersonListActivity.this.getActivity(), PersonListActivity.this.frg, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.hAs.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    am.j(PersonListActivity.this.hAs, R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void blc() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.dAA);
        registerListener(this.hAu);
        this.mModel.aJu();
        if (this.dSg) {
            this.dSg = false;
            aXz();
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
        am.k(this.hAl, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.hAk != null) {
            this.hAk.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.hAp.onChangeSkinType(i);
        am.l(this.hAh, R.color.cp_bg_line_d);
        am.j(this.hAh, R.color.cp_cont_d);
        am.l(this.hAj, R.color.cp_bg_line_d);
        am.j(this.hAj, R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.hAg != null) {
            getLayoutMode().onModeChanged(this.hAg);
        }
        if (this.hAi != null) {
            getLayoutMode().onModeChanged(this.hAi);
        }
        if (this.hAr != null) {
            am.j(this.hAs, R.color.cp_cont_d);
            am.l(this.hAr, R.color.cp_bg_line_d);
        }
        this.hAt.onChangeSkinType();
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dpz.iY(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hAk != null) {
            this.hAk = null;
        }
        if (this.hAq != null) {
            this.hAq.bcf();
        }
        this.frb.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.hAv);
        if (bundle != null) {
            this.mModel.nE(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.hAn = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.hAn);
            return;
        }
        Intent intent = getIntent();
        this.mModel.nE(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.hAn = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.hAn);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.bQs());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.hAn);
    }

    private void initUI() {
        boolean z = true;
        this.hAl = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.fhE = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hAf = findViewById(R.id.sub_title_root);
        this.hAg = this.hAf.findViewById(R.id.newheader_root);
        this.hAf.setVisibility(8);
        this.hAf.setClickable(false);
        this.hAf.setEnabled(false);
        this.hAh = (TextView) this.hAf.findViewById(R.id.person_list_title);
        this.hAp = (ConcernSelectView) findViewById(R.id.select_layout);
        this.frb = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bQs()) {
                this.fhE.setText(R.string.my_attention);
                this.hAl.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void u(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.hAp.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.hAp.bQj() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.hAl.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.hAp.bQi();
                        PersonListActivity.this.hAl.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.fhE.setText(R.string.fans);
            }
        } else if (this.mModel.bQs()) {
            if (this.hAn == 2) {
                this.fhE.setText(R.string.her_attention_people);
            } else if (this.hAn == 1) {
                this.fhE.setText(R.string.his_attention_people);
            } else {
                this.fhE.setText(R.string.his_attention_people);
            }
        } else if (this.hAn == 2) {
            this.fhE.setText(R.string.attention_to_her);
        } else {
            this.fhE.setText(R.string.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.hAk != null && PersonListActivity.this.hAk.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.hAk.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bQs()) {
                            TiebaStatic.log(new an("c12772").bT("obj_locate", "1").bT("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new an("c12605").P("obj_locate", 1).bT("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.hAo = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.bQp();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.bQo();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.hAk = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.hAf.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.hAl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.hAk = new c(this, z, sex, onClickListener, onClickListener3);
            this.hAf.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.hAl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.hAe = (BdListView) findViewById(R.id.list);
        this.hAe.setAdapter((ListAdapter) this.hAk);
        bQn();
        this.hAe.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.hAk != null && PersonListActivity.this.hAk.isHasMore()) {
                    if (PersonListActivity.this.dpz != null && !PersonListActivity.this.dpz.pQ()) {
                        PersonListActivity.this.dpz.akR();
                    }
                    PersonListActivity.this.bQo();
                }
            }
        });
        this.hAp.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void nD(boolean z2) {
                if (z2) {
                    PersonListActivity.this.bho();
                } else if (PersonListActivity.this.hAq != null) {
                    PersonListActivity.this.hAq.bcf();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void sN(int i) {
                PersonListActivity.this.hAe.setSelection(0);
                PersonListActivity.this.mModel.nh(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.bQs()) {
            this.hAp.bQh();
        }
        this.hAp.setVisibility(8);
        this.hAi.setVisibility(8);
        this.dpz = new PbListView(getActivity());
        this.dpz.getView();
        this.dpz.iX(R.color.cp_bg_line_e);
        this.dpz.akO();
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dpz.setTextSize(R.dimen.tbfontsize33);
        this.dpz.iW(R.color.cp_cont_e);
        this.dpz.setHeight(l.g(getActivity(), R.dimen.tbds182));
        this.hAe.setNextPage(this.dpz);
    }

    private void bQn() {
        this.hAi = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.hAi.setVisibility(8);
        this.hAi.setClickable(false);
        this.hAi.setEnabled(false);
        this.hAj = (TextView) this.hAi.findViewById(R.id.person_list_title);
        this.hAe.addHeaderView(this.hAi, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bho() {
        if (this.hAq == null) {
            this.hAq = new com.baidu.tieba.c.d(getPageContext(), this.hAp.hzJ);
            this.hAq.qf(R.drawable.bg_tip_blue_up);
            this.hAq.qh(2);
            this.hAq.qg(3000);
            this.hAq.qi(-10);
            this.hAq.setYOffset(-16);
            this.hAq.q(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.hAq != null) {
                        PersonListActivity.this.hAq.bcf();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(as asVar, boolean z) {
        if (this.mModel != null && asVar != null && (!z || !this.hAm)) {
            if (!z) {
                this.hAm = true;
                d(asVar);
            }
            b(asVar);
            d(asVar, z);
            if (!this.mModel.bQs()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.anR().setMsgFans(0);
            }
            b(asVar, z);
        }
    }

    private void b(as asVar) {
        if (asVar != null) {
            if (!asVar.hasMore && !StringUtils.isNull(asVar.bIL)) {
                bd(asVar.bIL, asVar.type);
                this.hAe.removeFooterView(this.hAr);
                this.hAe.addFooterView(this.hAr);
                this.hAe.removeFooterView(this.dpz.getView());
                TiebaStatic.log(new an("c13106").P("obj_locate", 2));
            } else if (!asVar.hasMore) {
                this.hAe.removeFooterView(this.hAr);
                this.dpz.setText(getString(R.string.no_more_data_tip));
                this.dpz.akS();
            } else {
                this.hAe.removeFooterView(this.hAr);
                this.dpz.setText(getString(R.string.pb_load_more));
                this.dpz.akS();
            }
        }
    }

    private void b(as asVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (asVar.bIK > 0 && !v.aa(asVar.adz())) {
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
            this.hAe.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bQs()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hAf.setVisibility(0);
                    this.hAe.removeHeaderView(this.hAi);
                    TextView textView2 = this.hAh;
                    textView2.setVisibility(0);
                    this.hAp.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    String string5 = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.hAf.setVisibility(8);
                    this.hAi.setVisibility(0);
                    TextView textView3 = this.hAj;
                    textView3.setVisibility(8);
                    this.hAp.setVisibility(8);
                    if (this.hAn == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.her_no_attention_other));
                    } else if (this.hAn == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(R.string.person);
                    string = string3;
                    textView = textView3;
                    z = v.aa(asVar.adA()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.hAf.setVisibility(8);
                this.hAi.setVisibility(0);
                textView = this.hAj;
                this.hAp.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(R.string.my_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.not_have_fans));
                    z = false;
                } else if (this.hAn == 2) {
                    string = getPageContext().getString(R.string.her_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.her_no_fan_other));
                    z = false;
                } else if (this.hAn == 1) {
                    string = getPageContext().getString(R.string.his_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(R.string.his_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(R.string.we_common_fans));
                return;
            }
            textView.setText(string + aq.aH(asVar.bIK) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(as asVar, boolean z) {
        String string;
        this.hAe.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bQs()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.hAp.setVisibility(0);
                this.hAh.setVisibility(0);
                this.hAf.setVisibility(0);
                this.hAi.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention));
                this.hAh.setText(string + 0 + string2);
                return;
            }
            this.hAp.setVisibility(8);
            this.hAh.setVisibility(8);
            if (this.hAn == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.her_no_attention_other));
                return;
            } else if (this.hAn == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.him_no_attention_other));
                return;
            }
        }
        this.hAp.setVisibility(8);
        this.hAh.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (asVar != null && !StringUtils.isNull(asVar.bIL)) {
                this.mNoDataView.getSuTextView().setText(be(asVar.bIL, asVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new an("c13106").P("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.not_have_fans));
        } else if (this.hAn == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.her_no_fan_other));
        } else if (this.hAn == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.him_no_fan_other));
        }
    }

    private void d(as asVar) {
        this.mModel.setPage(asVar.pageNum);
    }

    private void d(as asVar, boolean z) {
        if (this.hAk != null) {
            if (!z) {
                if (asVar.pageNum == 1) {
                    this.hAk.resetData();
                }
                this.hAk.setHasMore(asVar.hasMore);
                this.hAk.a(asVar);
                this.hAk.bQm();
                this.hAk.notifyDataSetChanged();
                return;
            }
            this.hAk.setHasMore(false);
            this.hAk.a(asVar);
            this.hAk.bQm();
            this.hAk.notifyDataSetChanged();
        }
    }

    private void aXz() {
        showProgressBar(true, 0, 0);
        this.mModel.bQt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQo() {
        if (this.hAk != null) {
            this.hAk.notifyDataSetChanged();
        }
        this.mModel.bQt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQp() {
        UserData userData;
        if (this.hAk != null && this.hAk.getItemViewType(this.hAo) == 0 && (userData = (UserData) this.hAk.getItem(this.hAo)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            bQp();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hAp.bQj()) {
                this.hAp.bQi();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bd(String str, int i) {
        if (this.hAr == null) {
            this.hAr = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.hAs = (TextView) this.hAr.findViewById(R.id.view_forbidden_tip);
            am.j(this.hAs, R.color.cp_cont_d);
            am.l(this.hAr, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.hAr.setVisibility(8);
            return;
        }
        this.hAs.setText(be(str, i));
        this.hAs.setMovementMethod(LinkMovementMethod.getInstance());
        this.hAs.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private SpannableStringBuilder be(String str, int i) {
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
                    PersonListActivity.this.bQr();
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
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.6
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.bQq();
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
    public void bQq() {
        TiebaStatic.log(new an("c13104").P("obj_locate", 1));
        if (!l.kt()) {
            showToast(getString(R.string.neterror));
        } else {
            this.hAt.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQr() {
        TiebaStatic.log(new an("c13103"));
        if (!l.kt()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
