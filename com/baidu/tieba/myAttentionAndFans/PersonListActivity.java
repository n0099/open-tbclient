package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
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
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MyForbiddenFansActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.e;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes3.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView bOy;
    private NavigationBarCoverTip dDh;
    private TextView dDn;
    private boolean fGf;
    private ConcernSelectView fGi;
    private com.baidu.tieba.c.d fGj;
    private View fGk;
    private TextView fGl;
    private e fGm;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView fFX = null;
    private View fFY = null;
    private View fFZ = null;
    private TextView fGa = null;
    private View fGb = null;
    private TextView fGc = null;
    private b fGd = null;
    private NoPressedRelativeLayout fGe = null;
    private boolean cmW = true;
    private TextView dtG = null;
    private int fGg = 0;
    int fGh = 0;
    private final AntiHelper.a dJg = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCN));
        }
    };
    private CustomMessageListener bVk = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aPr != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().aPr, PersonListActivity.this.dJg) != null) {
                            TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCN));
                        }
                    } else if (updateAttentionMessage.getData().Jr && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener fGn = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.fGd.cN(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.fGd.bcZ();
                    PersonListActivity.this.fGd.notifyDataSetChanged();
                }
                if (PersonListActivity.this.fGd.fFM) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a fGo = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void S(String str, boolean z) {
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
        public aq e(aq aqVar, boolean z) {
            PersonListActivity.this.a(aqVar, z);
            return null;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.person_list_activity);
        initData(bundle);
        initUI();
        this.fGm = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.fGm.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.dDn == null) {
                            PersonListActivity.this.dDn = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.dDn.setGravity(19);
                            PersonListActivity.this.dDn.setPadding(l.h(PersonListActivity.this.getActivity(), e.C0210e.ds34), 0, 0, 0);
                            PersonListActivity.this.dDn.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(PersonListActivity.this.getActivity(), e.C0210e.tbds112)));
                            PersonListActivity.this.dDn.setTextSize(0, l.h(PersonListActivity.this.getActivity(), e.C0210e.fontsize30));
                            PersonListActivity.this.dDn.setTextColor(PersonListActivity.this.getResources().getColor(e.d.cp_cont_i));
                        }
                        PersonListActivity.this.dDn.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.dDh.setBackgroundColor(PersonListActivity.this.getResources().getColor(e.d.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.dDh.setBackgroundColor(PersonListActivity.this.getResources().getColor(e.d.nav_bar_tip_error));
                        }
                        PersonListActivity.this.dDh.a(PersonListActivity.this.getActivity(), PersonListActivity.this.dDn, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.fGl.setText(PersonListActivity.this.getString(e.j.no_more_data_tip));
                    al.h(PersonListActivity.this.fGl, e.d.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void azd() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(e.j.remove_fans_loading));
            }
        });
        registerListener(this.bVk);
        registerListener(this.fGn);
        this.mModel.ZZ();
        if (this.cmW) {
            this.cmW = false;
            anc();
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
        al.i(this.fGe, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.fGd != null) {
            this.fGd.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fGi.onChangeSkinType(i);
        al.j(this.fGa, e.d.cp_bg_line_d);
        al.h(this.fGa, e.d.cp_cont_d);
        al.j(this.fGc, e.d.cp_bg_line_d);
        al.h(this.fGc, e.d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.fFZ != null) {
            getLayoutMode().onModeChanged(this.fFZ);
        }
        if (this.fGb != null) {
            getLayoutMode().onModeChanged(this.fGb);
        }
        if (this.fGk != null) {
            al.h(this.fGl, e.d.cp_cont_d);
            al.j(this.fGk, e.d.cp_bg_line_d);
        }
        this.fGm.onChangeSkinType();
        this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bOy.ey(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fGd != null) {
            this.fGd = null;
        }
        if (this.fGj != null) {
            this.fGj.arm();
        }
        this.dDh.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.fGo);
        if (bundle != null) {
            this.mModel.jS(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fGg = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.fGg);
            return;
        }
        Intent intent = getIntent();
        this.mModel.jS(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fGg = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.fGg);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.bdf());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.fGg);
    }

    private void initUI() {
        boolean z = true;
        this.fGe = (NoPressedRelativeLayout) findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.dtG = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fFY = findViewById(e.g.sub_title_root);
        this.fFZ = this.fFY.findViewById(e.g.newheader_root);
        this.fFY.setVisibility(8);
        this.fFY.setClickable(false);
        this.fFY.setEnabled(false);
        this.fGa = (TextView) this.fFY.findViewById(e.g.person_list_title);
        this.fGi = (ConcernSelectView) findViewById(e.g.select_layout);
        this.dDh = (NavigationBarCoverTip) findViewById(e.g.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bdf()) {
                this.dtG.setText(e.j.my_attention);
                this.fGe.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void q(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.fGi.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.fGi.bcW() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.fGe.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.fGi.bcV();
                        PersonListActivity.this.fGe.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.dtG.setText(e.j.fans);
            }
        } else if (this.mModel.bdf()) {
            if (this.fGg == 2) {
                this.dtG.setText(e.j.her_attention_people);
            } else if (this.fGg == 1) {
                this.dtG.setText(e.j.his_attention_people);
            } else {
                this.dtG.setText(e.j.his_attention_people);
            }
        } else if (this.fGg == 2) {
            this.dtG.setText(e.j.attention_to_her);
        } else {
            this.dtG.setText(e.j.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.fGd != null && PersonListActivity.this.fGd.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.fGd.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bdf()) {
                            TiebaStatic.log(new am("c12772").aA("obj_locate", "1").aA("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new am("c12605").x("obj_locate", 1).aA("obj_param1", userData.getUserId()));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, "focus")));
                    }
                }
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.myAttentionAndFans.PersonListActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.fGh = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.bdc();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.bdb();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.fGd = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.fFY.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fGe, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds320)), null, null);
        } else {
            this.fGd = new c(this, z, sex, onClickListener, onClickListener3);
            this.fFY.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fGe, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds320)), null, null);
        }
        this.fFX = (BdListView) findViewById(e.g.list);
        this.fFX.setAdapter((ListAdapter) this.fGd);
        bda();
        this.fFX.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.fGd != null && PersonListActivity.this.fGd.isHasMore()) {
                    if (PersonListActivity.this.bOy != null && !PersonListActivity.this.bOy.Fi()) {
                        PersonListActivity.this.bOy.Fc();
                    }
                    PersonListActivity.this.bdb();
                }
            }
        });
        this.fGi.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void jR(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aWK();
                } else if (PersonListActivity.this.fGj != null) {
                    PersonListActivity.this.fGj.arm();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void nj(int i) {
                PersonListActivity.this.fFX.setSelection(0);
                PersonListActivity.this.mModel.ir(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.bdf()) {
            this.fGi.bcU();
        }
        this.fGi.setVisibility(8);
        this.fGb.setVisibility(8);
        this.bOy = new PbListView(getActivity());
        this.bOy.getView();
        this.bOy.ex(e.d.cp_bg_line_e);
        this.bOy.EZ();
        this.bOy.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bOy.setTextSize(e.C0210e.tbfontsize33);
        this.bOy.ew(e.d.cp_cont_e);
        this.bOy.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.fFX.setNextPage(this.bOy);
    }

    private void bda() {
        this.fGb = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.person_list_newheader, (ViewGroup) null);
        this.fGb.setVisibility(8);
        this.fGb.setClickable(false);
        this.fGb.setEnabled(false);
        this.fGc = (TextView) this.fGb.findViewById(e.g.person_list_title);
        this.fFX.addHeaderView(this.fGb, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWK() {
        if (this.fGj == null) {
            this.fGj = new com.baidu.tieba.c.d(getPageContext(), this.fGi.fFC);
            this.fGj.kU(e.f.bg_tip_blue_up);
            this.fGj.kW(2);
            this.fGj.kV(3000);
            this.fGj.kX(-10);
            this.fGj.setYOffset(-16);
            this.fGj.n(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.fGj != null) {
                        PersonListActivity.this.fGj.arm();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(aq aqVar, boolean z) {
        if (this.mModel != null && aqVar != null && (!z || !this.fGf)) {
            if (!z) {
                this.fGf = true;
                d(aqVar);
            }
            b(aqVar);
            d(aqVar, z);
            if (!this.mModel.bdf()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.HP().setMsgFans(0);
            }
            b(aqVar, z);
        }
    }

    private void b(aq aqVar) {
        if (aqVar != null) {
            if (!aqVar.hasMore && !StringUtils.isNull(aqVar.asE)) {
                aI(aqVar.asE, aqVar.type);
                this.fFX.removeFooterView(this.fGk);
                this.fFX.addFooterView(this.fGk);
                this.fFX.removeFooterView(this.bOy.getView());
                TiebaStatic.log(new am("c13106").x("obj_locate", 2));
            } else if (!aqVar.hasMore) {
                this.fFX.removeFooterView(this.fGk);
                this.bOy.setText(getString(e.j.no_more_data_tip));
                this.bOy.Fd();
            } else {
                this.fFX.removeFooterView(this.fGk);
                this.bOy.setText(getString(e.j.pb_load_more));
                this.bOy.Fd();
            }
        }
    }

    private void b(aq aqVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (aqVar.asD > 0 && !v.I(aqVar.yT())) {
                c(aqVar);
            } else {
                c(aqVar, z);
            }
        }
    }

    private void c(aq aqVar) {
        TextView textView;
        String string;
        String string2;
        boolean z;
        String string3;
        String string4;
        if (aqVar != null) {
            this.fFX.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bdf()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fFY.setVisibility(0);
                    this.fFX.removeHeaderView(this.fGb);
                    TextView textView2 = this.fGa;
                    textView2.setVisibility(0);
                    this.fGi.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(e.j.all_concerned);
                    } else {
                        string4 = getPageContext().getString(e.j.each_concerned);
                    }
                    String string5 = getPageContext().getString(e.j.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.fFY.setVisibility(8);
                    this.fGb.setVisibility(0);
                    TextView textView3 = this.fGc;
                    textView3.setVisibility(8);
                    this.fGi.setVisibility(8);
                    if (this.fGg == 2) {
                        string3 = getPageContext().getString(e.j.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_attention_other));
                    } else if (this.fGg == 1) {
                        string3 = getPageContext().getString(e.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(e.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(e.j.person);
                    string = string3;
                    textView = textView3;
                    z = v.I(aqVar.yU()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.fFY.setVisibility(8);
                this.fGb.setVisibility(0);
                textView = this.fGc;
                this.fGi.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(e.j.my_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.not_have_fans));
                    z = false;
                } else if (this.fGg == 2) {
                    string = getPageContext().getString(e.j.her_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_fan_other));
                    z = false;
                } else if (this.fGg == 1) {
                    string = getPageContext().getString(e.j.his_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(e.j.his_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(e.j.we_common_fans));
                return;
            }
            textView.setText(string + ao.P(aqVar.asD) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(aq aqVar, boolean z) {
        String string;
        this.fFX.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bdf()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fGi.setVisibility(0);
                this.fGa.setVisibility(0);
                this.fFY.setVisibility(0);
                this.fGb.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(e.j.all_concerned);
                } else {
                    string = getPageContext().getString(e.j.each_concerned);
                }
                String string2 = getPageContext().getString(e.j.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(this.mModel.getLoadType() == 0 ? e.j.not_have_attention : e.j.not_have_each_attention));
                this.fGa.setText(string + 0 + string2);
                return;
            }
            this.fGi.setVisibility(8);
            this.fGa.setVisibility(8);
            if (this.fGg == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_attention_other));
                return;
            } else if (this.fGg == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_attention_other));
                return;
            }
        }
        this.fGi.setVisibility(8);
        this.fGa.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (aqVar != null && !StringUtils.isNull(aqVar.asE)) {
                this.mNoDataView.getSuTextView().setText(aJ(aqVar.asE, aqVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(e.d.transparent));
                TiebaStatic.log(new am("c13106").x("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.not_have_fans));
        } else if (this.fGg == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_fan_other));
        } else if (this.fGg == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_fan_other));
        }
    }

    private void d(aq aqVar) {
        this.mModel.setPage(aqVar.pageNum);
    }

    private void d(aq aqVar, boolean z) {
        if (this.fGd != null) {
            if (!z) {
                if (aqVar.pageNum == 1) {
                    this.fGd.resetData();
                }
                this.fGd.setHasMore(aqVar.hasMore);
                this.fGd.a(aqVar);
                this.fGd.bcZ();
                this.fGd.notifyDataSetChanged();
                return;
            }
            this.fGd.setHasMore(false);
            this.fGd.a(aqVar);
            this.fGd.bcZ();
            this.fGd.notifyDataSetChanged();
        }
    }

    private void anc() {
        showProgressBar(true, 0, 0);
        this.mModel.bdg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdb() {
        if (this.fGd != null) {
            this.fGd.notifyDataSetChanged();
        }
        this.mModel.bdg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdc() {
        UserData userData;
        if (this.fGd != null && this.fGd.getItemViewType(this.fGh) == 0 && (userData = (UserData) this.fGd.getItem(this.fGh)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            bdc();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fGi.bcW()) {
                this.fGi.bcV();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aI(String str, int i) {
        if (this.fGk == null) {
            this.fGk = LayoutInflater.from(getActivity()).inflate(e.h.forbidden_tip_layout, (ViewGroup) null);
            this.fGl = (TextView) this.fGk.findViewById(e.g.view_forbidden_tip);
            al.h(this.fGl, e.d.cp_cont_d);
            al.j(this.fGk, e.d.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.fGk.setVisibility(8);
            return;
        }
        this.fGl.setText(aJ(str, i));
        this.fGl.setMovementMethod(LinkMovementMethod.getInstance());
        this.fGl.setHighlightColor(getResources().getColor(e.d.transparent));
    }

    private SpannableStringBuilder aJ(String str, int i) {
        String string;
        String str2 = null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        switch (i) {
            case 1:
                spannableStringBuilder.append((CharSequence) "，");
                string = getString(e.j.click_for_look_all);
                spannableStringBuilder.append((CharSequence) string);
                break;
            case 2:
                spannableStringBuilder.append((CharSequence) "，");
                String string2 = getString(e.j.remove_all_forbidden_fans);
                spannableStringBuilder.append((CharSequence) string2);
                string = null;
                str2 = string2;
                break;
            case 3:
                string = getString(e.j.click_for_look_all);
                str2 = getString(e.j.remove_all_forbidden_fans);
                spannableStringBuilder.append((CharSequence) "，");
                spannableStringBuilder.append((CharSequence) string);
                spannableStringBuilder.append((CharSequence) getString(e.j.tip_or));
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
                    PersonListActivity.this.bde();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(al.getColor(e.d.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.6
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.bdd();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(al.getColor(e.d.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdd() {
        TiebaStatic.log(new am("c13104").x("obj_locate", 1));
        if (!l.ll()) {
            showToast(getString(e.j.neterror));
        } else {
            this.fGm.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bde() {
        TiebaStatic.log(new am("c13103"));
        if (!l.ll()) {
            showToast(getString(e.j.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
