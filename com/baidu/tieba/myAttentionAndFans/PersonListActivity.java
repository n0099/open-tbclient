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
import com.baidu.tbadk.core.util.au;
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
    private PbListView dnN;
    private NavigationBarCoverTip fpn;
    private TextView fpt;
    private boolean hyq;
    private ConcernSelectView hyt;
    private com.baidu.tieba.c.d hyu;
    private View hyv;
    private TextView hyw;
    private e hyx;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView hyi = null;
    private View hyj = null;
    private View hyk = null;
    private TextView hyl = null;
    private View hym = null;
    private TextView hyn = null;
    private b hyo = null;
    private NoPressedRelativeLayout hyp = null;
    private boolean dQv = true;
    private TextView ffR = null;
    private int hyr = 0;
    int hys = 0;
    private final AntiHelper.a fvB = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUk));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUk));
        }
    };
    private CustomMessageListener dyP = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().chM != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().chM, PersonListActivity.this.fvB) != null) {
                            TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUk));
                        }
                    } else if (updateAttentionMessage.getData().Hs && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener hyy = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.hyo.ee(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.hyo.bPy();
                    PersonListActivity.this.hyo.notifyDataSetChanged();
                }
                if (PersonListActivity.this.hyo.hxX) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a hyz = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
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
        this.hyx = new e(getPageContext(), getUniqueId());
        this.hyx.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.fpt == null) {
                            PersonListActivity.this.fpt = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.fpt.setGravity(19);
                            PersonListActivity.this.fpt.setPadding(l.g(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.fpt.setLayoutParams(new ViewGroup.LayoutParams(-1, l.g(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.fpt.setTextSize(0, l.g(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.fpt.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_btn_a));
                        }
                        PersonListActivity.this.fpt.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.fpn.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.fpn.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.fpn.a(PersonListActivity.this.getActivity(), PersonListActivity.this.fpt, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.hyw.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    am.j(PersonListActivity.this.hyw, R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bkr() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.dyP);
        registerListener(this.hyy);
        this.mModel.aIQ();
        if (this.dQv) {
            this.dQv = false;
            aWV();
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
        am.k(this.hyp, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.hyo != null) {
            this.hyo.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.hyt.onChangeSkinType(i);
        am.l(this.hyl, R.color.cp_bg_line_d);
        am.j(this.hyl, R.color.cp_cont_d);
        am.l(this.hyn, R.color.cp_bg_line_d);
        am.j(this.hyn, R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.hyk != null) {
            getLayoutMode().onModeChanged(this.hyk);
        }
        if (this.hym != null) {
            getLayoutMode().onModeChanged(this.hym);
        }
        if (this.hyv != null) {
            am.j(this.hyw, R.color.cp_cont_d);
            am.l(this.hyv, R.color.cp_bg_line_d);
        }
        this.hyx.onChangeSkinType();
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dnN.iV(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hyo != null) {
            this.hyo = null;
        }
        if (this.hyu != null) {
            this.hyu.bbB();
        }
        this.fpn.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.hyz);
        if (bundle != null) {
            this.mModel.nA(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.hyr = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.hyr);
            return;
        }
        Intent intent = getIntent();
        this.mModel.nA(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.hyr = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.hyr);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.bPE());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.hyr);
    }

    private void initUI() {
        boolean z = true;
        this.hyp = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.ffR = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hyj = findViewById(R.id.sub_title_root);
        this.hyk = this.hyj.findViewById(R.id.newheader_root);
        this.hyj.setVisibility(8);
        this.hyj.setClickable(false);
        this.hyj.setEnabled(false);
        this.hyl = (TextView) this.hyj.findViewById(R.id.person_list_title);
        this.hyt = (ConcernSelectView) findViewById(R.id.select_layout);
        this.fpn = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bPE()) {
                this.ffR.setText(R.string.my_attention);
                this.hyp.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void u(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.hyt.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.hyt.bPv() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.hyp.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.hyt.bPu();
                        PersonListActivity.this.hyp.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.ffR.setText(R.string.fans);
            }
        } else if (this.mModel.bPE()) {
            if (this.hyr == 2) {
                this.ffR.setText(R.string.her_attention_people);
            } else if (this.hyr == 1) {
                this.ffR.setText(R.string.his_attention_people);
            } else {
                this.ffR.setText(R.string.his_attention_people);
            }
        } else if (this.hyr == 2) {
            this.ffR.setText(R.string.attention_to_her);
        } else {
            this.ffR.setText(R.string.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.hyo != null && PersonListActivity.this.hyo.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.hyo.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bPE()) {
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
                PersonListActivity.this.hys = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.bPB();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.bPA();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.hyo = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.hyj.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.hyp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.hyo = new c(this, z, sex, onClickListener, onClickListener3);
            this.hyj.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.hyp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.hyi = (BdListView) findViewById(R.id.list);
        this.hyi.setAdapter((ListAdapter) this.hyo);
        bPz();
        this.hyi.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.hyo != null && PersonListActivity.this.hyo.isHasMore()) {
                    if (PersonListActivity.this.dnN != null && !PersonListActivity.this.dnN.pP()) {
                        PersonListActivity.this.dnN.akF();
                    }
                    PersonListActivity.this.bPA();
                }
            }
        });
        this.hyt.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void nz(boolean z2) {
                if (z2) {
                    PersonListActivity.this.bgI();
                } else if (PersonListActivity.this.hyu != null) {
                    PersonListActivity.this.hyu.bbB();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void sJ(int i) {
                PersonListActivity.this.hyi.setSelection(0);
                PersonListActivity.this.mModel.nd(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.bPE()) {
            this.hyt.bPt();
        }
        this.hyt.setVisibility(8);
        this.hym.setVisibility(8);
        this.dnN = new PbListView(getActivity());
        this.dnN.getView();
        this.dnN.iU(R.color.cp_bg_line_e);
        this.dnN.akC();
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnN.setTextSize(R.dimen.tbfontsize33);
        this.dnN.iT(R.color.cp_cont_e);
        this.dnN.setHeight(l.g(getActivity(), R.dimen.tbds182));
        this.hyi.setNextPage(this.dnN);
    }

    private void bPz() {
        this.hym = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.hym.setVisibility(8);
        this.hym.setClickable(false);
        this.hym.setEnabled(false);
        this.hyn = (TextView) this.hym.findViewById(R.id.person_list_title);
        this.hyi.addHeaderView(this.hym, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgI() {
        if (this.hyu == null) {
            this.hyu = new com.baidu.tieba.c.d(getPageContext(), this.hyt.hxN);
            this.hyu.qc(R.drawable.bg_tip_blue_up);
            this.hyu.qe(2);
            this.hyu.qd(3000);
            this.hyu.qf(-10);
            this.hyu.setYOffset(-16);
            this.hyu.q(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.hyu != null) {
                        PersonListActivity.this.hyu.bbB();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(as asVar, boolean z) {
        if (this.mModel != null && asVar != null && (!z || !this.hyq)) {
            if (!z) {
                this.hyq = true;
                d(asVar);
            }
            b(asVar);
            d(asVar, z);
            if (!this.mModel.bPE()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.anF().setMsgFans(0);
            }
            b(asVar, z);
        }
    }

    private void b(as asVar) {
        if (asVar != null) {
            if (!asVar.hasMore && !StringUtils.isNull(asVar.bIn)) {
                bb(asVar.bIn, asVar.type);
                this.hyi.removeFooterView(this.hyv);
                this.hyi.addFooterView(this.hyv);
                this.hyi.removeFooterView(this.dnN.getView());
                TiebaStatic.log(new an("c13106").P("obj_locate", 2));
            } else if (!asVar.hasMore) {
                this.hyi.removeFooterView(this.hyv);
                this.dnN.setText(getString(R.string.no_more_data_tip));
                this.dnN.akG();
            } else {
                this.hyi.removeFooterView(this.hyv);
                this.dnN.setText(getString(R.string.pb_load_more));
                this.dnN.akG();
            }
        }
    }

    private void b(as asVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (asVar.bIm > 0 && !v.aa(asVar.adv())) {
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
            this.hyi.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bPE()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hyj.setVisibility(0);
                    this.hyi.removeHeaderView(this.hym);
                    TextView textView2 = this.hyl;
                    textView2.setVisibility(0);
                    this.hyt.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    String string5 = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.hyj.setVisibility(8);
                    this.hym.setVisibility(0);
                    TextView textView3 = this.hyn;
                    textView3.setVisibility(8);
                    this.hyt.setVisibility(8);
                    if (this.hyr == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.her_no_attention_other));
                    } else if (this.hyr == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(R.string.person);
                    string = string3;
                    textView = textView3;
                    z = v.aa(asVar.adw()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.hyj.setVisibility(8);
                this.hym.setVisibility(0);
                textView = this.hyn;
                this.hyt.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(R.string.my_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.not_have_fans));
                    z = false;
                } else if (this.hyr == 2) {
                    string = getPageContext().getString(R.string.her_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.her_no_fan_other));
                    z = false;
                } else if (this.hyr == 1) {
                    string = getPageContext().getString(R.string.his_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(R.string.his_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(R.string.we_common_fans));
                return;
            }
            textView.setText(string + aq.aH(asVar.bIm) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(as asVar, boolean z) {
        String string;
        this.hyi.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bPE()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.hyt.setVisibility(0);
                this.hyl.setVisibility(0);
                this.hyj.setVisibility(0);
                this.hym.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention));
                this.hyl.setText(string + 0 + string2);
                return;
            }
            this.hyt.setVisibility(8);
            this.hyl.setVisibility(8);
            if (this.hyr == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.her_no_attention_other));
                return;
            } else if (this.hyr == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.him_no_attention_other));
                return;
            }
        }
        this.hyt.setVisibility(8);
        this.hyl.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (asVar != null && !StringUtils.isNull(asVar.bIn)) {
                this.mNoDataView.getSuTextView().setText(bc(asVar.bIn, asVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new an("c13106").P("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.not_have_fans));
        } else if (this.hyr == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.her_no_fan_other));
        } else if (this.hyr == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.him_no_fan_other));
        }
    }

    private void d(as asVar) {
        this.mModel.setPage(asVar.pageNum);
    }

    private void d(as asVar, boolean z) {
        if (this.hyo != null) {
            if (!z) {
                if (asVar.pageNum == 1) {
                    this.hyo.resetData();
                }
                this.hyo.setHasMore(asVar.hasMore);
                this.hyo.a(asVar);
                this.hyo.bPy();
                this.hyo.notifyDataSetChanged();
                return;
            }
            this.hyo.setHasMore(false);
            this.hyo.a(asVar);
            this.hyo.bPy();
            this.hyo.notifyDataSetChanged();
        }
    }

    private void aWV() {
        showProgressBar(true, 0, 0);
        this.mModel.bPF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPA() {
        if (this.hyo != null) {
            this.hyo.notifyDataSetChanged();
        }
        this.mModel.bPF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPB() {
        UserData userData;
        if (this.hyo != null && this.hyo.getItemViewType(this.hys) == 0 && (userData = (UserData) this.hyo.getItem(this.hys)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            bPB();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hyt.bPv()) {
                this.hyt.bPu();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bb(String str, int i) {
        if (this.hyv == null) {
            this.hyv = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.hyw = (TextView) this.hyv.findViewById(R.id.view_forbidden_tip);
            am.j(this.hyw, R.color.cp_cont_d);
            am.l(this.hyv, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.hyv.setVisibility(8);
            return;
        }
        this.hyw.setText(bc(str, i));
        this.hyw.setMovementMethod(LinkMovementMethod.getInstance());
        this.hyw.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private SpannableStringBuilder bc(String str, int i) {
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
                    PersonListActivity.this.bPD();
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
                    PersonListActivity.this.bPC();
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
    public void bPC() {
        TiebaStatic.log(new an("c13104").P("obj_locate", 1));
        if (!l.kt()) {
            showToast(getString(R.string.neterror));
        } else {
            this.hyx.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPD() {
        TiebaStatic.log(new an("c13103"));
        if (!l.kt()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
