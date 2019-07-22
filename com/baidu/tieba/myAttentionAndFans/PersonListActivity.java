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
    private PbListView dnG;
    private NavigationBarCoverTip foO;
    private TextView foT;
    private ConcernSelectView hxB;
    private com.baidu.tieba.c.d hxC;
    private View hxD;
    private TextView hxE;
    private e hxF;
    private boolean hxy;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView hxq = null;
    private View hxr = null;
    private View hxs = null;
    private TextView hxt = null;
    private View hxu = null;
    private TextView hxv = null;
    private b hxw = null;
    private NoPressedRelativeLayout hxx = null;
    private boolean dQo = true;
    private TextView ffr = null;
    private int hxz = 0;
    int hxA = 0;
    private final AntiHelper.a fvc = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUe));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUe));
        }
    };
    private CustomMessageListener dyI = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().chF != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().chF, PersonListActivity.this.fvc) != null) {
                            TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUe));
                        }
                    } else if (updateAttentionMessage.getData().Hs && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener hxG = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.hxw.ee(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.hxw.bPk();
                    PersonListActivity.this.hxw.notifyDataSetChanged();
                }
                if (PersonListActivity.this.hxw.hxf) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a hxH = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
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
        this.hxF = new e(getPageContext(), getUniqueId());
        this.hxF.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.foT == null) {
                            PersonListActivity.this.foT = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.foT.setGravity(19);
                            PersonListActivity.this.foT.setPadding(l.g(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.foT.setLayoutParams(new ViewGroup.LayoutParams(-1, l.g(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.foT.setTextSize(0, l.g(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.foT.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_btn_a));
                        }
                        PersonListActivity.this.foT.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.foO.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.foO.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.foO.a(PersonListActivity.this.getActivity(), PersonListActivity.this.foT, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.hxE.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    am.j(PersonListActivity.this.hxE, R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bkk() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.dyI);
        registerListener(this.hxG);
        this.mModel.aIO();
        if (this.dQo) {
            this.dQo = false;
            aWT();
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
        am.k(this.hxx, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.hxw != null) {
            this.hxw.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.hxB.onChangeSkinType(i);
        am.l(this.hxt, R.color.cp_bg_line_d);
        am.j(this.hxt, R.color.cp_cont_d);
        am.l(this.hxv, R.color.cp_bg_line_d);
        am.j(this.hxv, R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.hxs != null) {
            getLayoutMode().onModeChanged(this.hxs);
        }
        if (this.hxu != null) {
            getLayoutMode().onModeChanged(this.hxu);
        }
        if (this.hxD != null) {
            am.j(this.hxE, R.color.cp_cont_d);
            am.l(this.hxD, R.color.cp_bg_line_d);
        }
        this.hxF.onChangeSkinType();
        this.dnG.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dnG.iV(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hxw != null) {
            this.hxw = null;
        }
        if (this.hxC != null) {
            this.hxC.bbz();
        }
        this.foO.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.hxH);
        if (bundle != null) {
            this.mModel.nA(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.hxz = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.hxz);
            return;
        }
        Intent intent = getIntent();
        this.mModel.nA(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.hxz = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.hxz);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.bPq());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.hxz);
    }

    private void initUI() {
        boolean z = true;
        this.hxx = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.ffr = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hxr = findViewById(R.id.sub_title_root);
        this.hxs = this.hxr.findViewById(R.id.newheader_root);
        this.hxr.setVisibility(8);
        this.hxr.setClickable(false);
        this.hxr.setEnabled(false);
        this.hxt = (TextView) this.hxr.findViewById(R.id.person_list_title);
        this.hxB = (ConcernSelectView) findViewById(R.id.select_layout);
        this.foO = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bPq()) {
                this.ffr.setText(R.string.my_attention);
                this.hxx.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void u(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.hxB.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.hxB.bPh() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.hxx.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.hxB.bPg();
                        PersonListActivity.this.hxx.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.ffr.setText(R.string.fans);
            }
        } else if (this.mModel.bPq()) {
            if (this.hxz == 2) {
                this.ffr.setText(R.string.her_attention_people);
            } else if (this.hxz == 1) {
                this.ffr.setText(R.string.his_attention_people);
            } else {
                this.ffr.setText(R.string.his_attention_people);
            }
        } else if (this.hxz == 2) {
            this.ffr.setText(R.string.attention_to_her);
        } else {
            this.ffr.setText(R.string.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.hxw != null && PersonListActivity.this.hxw.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.hxw.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bPq()) {
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
                PersonListActivity.this.hxA = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.bPn();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.bPm();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.hxw = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.hxr.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.hxx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.hxw = new c(this, z, sex, onClickListener, onClickListener3);
            this.hxr.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.hxx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.hxq = (BdListView) findViewById(R.id.list);
        this.hxq.setAdapter((ListAdapter) this.hxw);
        bPl();
        this.hxq.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.hxw != null && PersonListActivity.this.hxw.isHasMore()) {
                    if (PersonListActivity.this.dnG != null && !PersonListActivity.this.dnG.pP()) {
                        PersonListActivity.this.dnG.akD();
                    }
                    PersonListActivity.this.bPm();
                }
            }
        });
        this.hxB.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void nz(boolean z2) {
                if (z2) {
                    PersonListActivity.this.bgF();
                } else if (PersonListActivity.this.hxC != null) {
                    PersonListActivity.this.hxC.bbz();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void sH(int i) {
                PersonListActivity.this.hxq.setSelection(0);
                PersonListActivity.this.mModel.nc(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.bPq()) {
            this.hxB.bPf();
        }
        this.hxB.setVisibility(8);
        this.hxu.setVisibility(8);
        this.dnG = new PbListView(getActivity());
        this.dnG.getView();
        this.dnG.iU(R.color.cp_bg_line_e);
        this.dnG.akA();
        this.dnG.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnG.setTextSize(R.dimen.tbfontsize33);
        this.dnG.iT(R.color.cp_cont_e);
        this.dnG.setHeight(l.g(getActivity(), R.dimen.tbds182));
        this.hxq.setNextPage(this.dnG);
    }

    private void bPl() {
        this.hxu = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.hxu.setVisibility(8);
        this.hxu.setClickable(false);
        this.hxu.setEnabled(false);
        this.hxv = (TextView) this.hxu.findViewById(R.id.person_list_title);
        this.hxq.addHeaderView(this.hxu, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgF() {
        if (this.hxC == null) {
            this.hxC = new com.baidu.tieba.c.d(getPageContext(), this.hxB.hwV);
            this.hxC.qb(R.drawable.bg_tip_blue_up);
            this.hxC.qd(2);
            this.hxC.qc(3000);
            this.hxC.qe(-10);
            this.hxC.setYOffset(-16);
            this.hxC.q(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.hxC != null) {
                        PersonListActivity.this.hxC.bbz();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(as asVar, boolean z) {
        if (this.mModel != null && asVar != null && (!z || !this.hxy)) {
            if (!z) {
                this.hxy = true;
                d(asVar);
            }
            b(asVar);
            d(asVar, z);
            if (!this.mModel.bPq()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.anD().setMsgFans(0);
            }
            b(asVar, z);
        }
    }

    private void b(as asVar) {
        if (asVar != null) {
            if (!asVar.hasMore && !StringUtils.isNull(asVar.bIm)) {
                bb(asVar.bIm, asVar.type);
                this.hxq.removeFooterView(this.hxD);
                this.hxq.addFooterView(this.hxD);
                this.hxq.removeFooterView(this.dnG.getView());
                TiebaStatic.log(new an("c13106").P("obj_locate", 2));
            } else if (!asVar.hasMore) {
                this.hxq.removeFooterView(this.hxD);
                this.dnG.setText(getString(R.string.no_more_data_tip));
                this.dnG.akE();
            } else {
                this.hxq.removeFooterView(this.hxD);
                this.dnG.setText(getString(R.string.pb_load_more));
                this.dnG.akE();
            }
        }
    }

    private void b(as asVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (asVar.bIl > 0 && !v.aa(asVar.adu())) {
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
            this.hxq.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bPq()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hxr.setVisibility(0);
                    this.hxq.removeHeaderView(this.hxu);
                    TextView textView2 = this.hxt;
                    textView2.setVisibility(0);
                    this.hxB.setVisibility(0);
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
                    this.hxr.setVisibility(8);
                    this.hxu.setVisibility(0);
                    TextView textView3 = this.hxv;
                    textView3.setVisibility(8);
                    this.hxB.setVisibility(8);
                    if (this.hxz == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.her_no_attention_other));
                    } else if (this.hxz == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(R.string.person);
                    string = string3;
                    textView = textView3;
                    z = v.aa(asVar.adv()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.hxr.setVisibility(8);
                this.hxu.setVisibility(0);
                textView = this.hxv;
                this.hxB.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(R.string.my_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.not_have_fans));
                    z = false;
                } else if (this.hxz == 2) {
                    string = getPageContext().getString(R.string.her_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.her_no_fan_other));
                    z = false;
                } else if (this.hxz == 1) {
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
            textView.setText(string + aq.aH(asVar.bIl) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(as asVar, boolean z) {
        String string;
        this.hxq.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bPq()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.hxB.setVisibility(0);
                this.hxt.setVisibility(0);
                this.hxr.setVisibility(0);
                this.hxu.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention));
                this.hxt.setText(string + 0 + string2);
                return;
            }
            this.hxB.setVisibility(8);
            this.hxt.setVisibility(8);
            if (this.hxz == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.her_no_attention_other));
                return;
            } else if (this.hxz == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.him_no_attention_other));
                return;
            }
        }
        this.hxB.setVisibility(8);
        this.hxt.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (asVar != null && !StringUtils.isNull(asVar.bIm)) {
                this.mNoDataView.getSuTextView().setText(bc(asVar.bIm, asVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new an("c13106").P("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.not_have_fans));
        } else if (this.hxz == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.her_no_fan_other));
        } else if (this.hxz == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.him_no_fan_other));
        }
    }

    private void d(as asVar) {
        this.mModel.setPage(asVar.pageNum);
    }

    private void d(as asVar, boolean z) {
        if (this.hxw != null) {
            if (!z) {
                if (asVar.pageNum == 1) {
                    this.hxw.resetData();
                }
                this.hxw.setHasMore(asVar.hasMore);
                this.hxw.a(asVar);
                this.hxw.bPk();
                this.hxw.notifyDataSetChanged();
                return;
            }
            this.hxw.setHasMore(false);
            this.hxw.a(asVar);
            this.hxw.bPk();
            this.hxw.notifyDataSetChanged();
        }
    }

    private void aWT() {
        showProgressBar(true, 0, 0);
        this.mModel.bPr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPm() {
        if (this.hxw != null) {
            this.hxw.notifyDataSetChanged();
        }
        this.mModel.bPr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPn() {
        UserData userData;
        if (this.hxw != null && this.hxw.getItemViewType(this.hxA) == 0 && (userData = (UserData) this.hxw.getItem(this.hxA)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            bPn();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hxB.bPh()) {
                this.hxB.bPg();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bb(String str, int i) {
        if (this.hxD == null) {
            this.hxD = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.hxE = (TextView) this.hxD.findViewById(R.id.view_forbidden_tip);
            am.j(this.hxE, R.color.cp_cont_d);
            am.l(this.hxD, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.hxD.setVisibility(8);
            return;
        }
        this.hxE.setText(bc(str, i));
        this.hxE.setMovementMethod(LinkMovementMethod.getInstance());
        this.hxE.setHighlightColor(getResources().getColor(R.color.transparent));
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
                    PersonListActivity.this.bPp();
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
                    PersonListActivity.this.bPo();
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
    public void bPo() {
        TiebaStatic.log(new an("c13104").P("obj_locate", 1));
        if (!l.kt()) {
            showToast(getString(R.string.neterror));
        } else {
            this.hxF.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPp() {
        TiebaStatic.log(new an("c13103"));
        if (!l.kt()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
