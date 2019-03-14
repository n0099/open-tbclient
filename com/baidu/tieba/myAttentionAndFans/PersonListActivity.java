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
import com.baidu.tieba.d;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes5.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView dbn;
    private NavigationBarCoverTip eTS;
    private TextView eTY;
    private boolean had;
    private ConcernSelectView hag;
    private com.baidu.tieba.c.d hah;
    private View hai;
    private TextView haj;
    private e hak;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView gZV = null;
    private View gZW = null;
    private View gZX = null;
    private TextView gZY = null;
    private View gZZ = null;
    private TextView haa = null;
    private b hab = null;
    private NoPressedRelativeLayout hac = null;
    private boolean dCO = true;
    private TextView eKt = null;
    private int hae = 0;
    int haf = 0;
    private final AntiHelper.a fad = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLn));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLn));
        }
    };
    private CustomMessageListener ddn = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().bYz != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().bYz, PersonListActivity.this.fad) != null) {
                            TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLn));
                        }
                    } else if (updateAttentionMessage.getData().Jy && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener hal = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.hab.dx(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.hab.bEQ();
                    PersonListActivity.this.hab.notifyDataSetChanged();
                }
                if (PersonListActivity.this.hab.gZK) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a ham = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void al(String str, boolean z) {
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
        setContentView(d.h.person_list_activity);
        initData(bundle);
        initUI();
        this.hak = new e(getPageContext(), getUniqueId());
        this.hak.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.eTY == null) {
                            PersonListActivity.this.eTY = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.eTY.setGravity(19);
                            PersonListActivity.this.eTY.setPadding(l.h(PersonListActivity.this.getActivity(), d.e.ds34), 0, 0, 0);
                            PersonListActivity.this.eTY.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(PersonListActivity.this.getActivity(), d.e.tbds112)));
                            PersonListActivity.this.eTY.setTextSize(0, l.h(PersonListActivity.this.getActivity(), d.e.fontsize30));
                            PersonListActivity.this.eTY.setTextColor(PersonListActivity.this.getResources().getColor(d.C0277d.cp_btn_a));
                        }
                        PersonListActivity.this.eTY.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.eTS.setBackgroundColor(PersonListActivity.this.getResources().getColor(d.C0277d.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.eTS.setBackgroundColor(PersonListActivity.this.getResources().getColor(d.C0277d.nav_bar_tip_error));
                        }
                        PersonListActivity.this.eTS.a(PersonListActivity.this.getActivity(), PersonListActivity.this.eTY, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.haj.setText(PersonListActivity.this.getString(d.j.no_more_data_tip));
                    al.j(PersonListActivity.this.haj, d.C0277d.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void baO() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(d.j.remove_fans_loading));
            }
        });
        registerListener(this.ddn);
        registerListener(this.hal);
        this.mModel.aBa();
        if (this.dCO) {
            this.dCO = false;
            aOO();
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
        al.k(this.hac, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.hab != null) {
            this.hab.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.hag.onChangeSkinType(i);
        al.l(this.gZY, d.C0277d.cp_bg_line_d);
        al.j(this.gZY, d.C0277d.cp_cont_d);
        al.l(this.haa, d.C0277d.cp_bg_line_d);
        al.j(this.haa, d.C0277d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.gZX != null) {
            getLayoutMode().onModeChanged(this.gZX);
        }
        if (this.gZZ != null) {
            getLayoutMode().onModeChanged(this.gZZ);
        }
        if (this.hai != null) {
            al.j(this.haj, d.C0277d.cp_cont_d);
            al.l(this.hai, d.C0277d.cp_bg_line_d);
        }
        this.hak.onChangeSkinType();
        this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        this.dbn.ic(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hab != null) {
            this.hab = null;
        }
        if (this.hah != null) {
            this.hah.aSr();
        }
        this.eTS.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.ham);
        if (bundle != null) {
            this.mModel.mw(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.hae = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.hae);
            return;
        }
        Intent intent = getIntent();
        this.mModel.mw(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.hae = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.hae);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.bEW());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.hae);
    }

    private void initUI() {
        boolean z = true;
        this.hac = (NoPressedRelativeLayout) findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.eKt = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gZW = findViewById(d.g.sub_title_root);
        this.gZX = this.gZW.findViewById(d.g.newheader_root);
        this.gZW.setVisibility(8);
        this.gZW.setClickable(false);
        this.gZW.setEnabled(false);
        this.gZY = (TextView) this.gZW.findViewById(d.g.person_list_title);
        this.hag = (ConcernSelectView) findViewById(d.g.select_layout);
        this.eTS = (NavigationBarCoverTip) findViewById(d.g.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bEW()) {
                this.eKt.setText(d.j.my_attention);
                this.hac.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void u(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.hag.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.hag.bEN() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.hac.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.hag.bEM();
                        PersonListActivity.this.hac.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.eKt.setText(d.j.fans);
            }
        } else if (this.mModel.bEW()) {
            if (this.hae == 2) {
                this.eKt.setText(d.j.her_attention_people);
            } else if (this.hae == 1) {
                this.eKt.setText(d.j.his_attention_people);
            } else {
                this.eKt.setText(d.j.his_attention_people);
            }
        } else if (this.hae == 2) {
            this.eKt.setText(d.j.attention_to_her);
        } else {
            this.eKt.setText(d.j.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.hab != null && PersonListActivity.this.hab.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.hab.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bEW()) {
                            TiebaStatic.log(new am("c12772").bJ("obj_locate", "1").bJ("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new am("c12605").T("obj_locate", 1).bJ("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.haf = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.bET();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.bES();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.hab = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.gZW.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.hac, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), d.e.tbds530)), null, null);
        } else {
            this.hab = new c(this, z, sex, onClickListener, onClickListener3);
            this.gZW.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.hac, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), d.e.tbds530)), null, null);
        }
        this.gZV = (BdListView) findViewById(d.g.list);
        this.gZV.setAdapter((ListAdapter) this.hab);
        bER();
        this.gZV.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.hab != null && PersonListActivity.this.hab.isHasMore()) {
                    if (PersonListActivity.this.dbn != null && !PersonListActivity.this.dbn.qz()) {
                        PersonListActivity.this.dbn.aeC();
                    }
                    PersonListActivity.this.bES();
                }
            }
        });
        this.hag.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void mv(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aXo();
                } else if (PersonListActivity.this.hah != null) {
                    PersonListActivity.this.hah.aSr();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void rl(int i) {
                PersonListActivity.this.gZV.setSelection(0);
                PersonListActivity.this.mModel.mf(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.bEW()) {
            this.hag.bEL();
        }
        this.hag.setVisibility(8);
        this.gZZ.setVisibility(8);
        this.dbn = new PbListView(getActivity());
        this.dbn.getView();
        this.dbn.ib(d.C0277d.cp_bg_line_e);
        this.dbn.aez();
        this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbn.setTextSize(d.e.tbfontsize33);
        this.dbn.ia(d.C0277d.cp_cont_e);
        this.dbn.setHeight(l.h(getActivity(), d.e.tbds182));
        this.gZV.setNextPage(this.dbn);
    }

    private void bER() {
        this.gZZ = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.person_list_newheader, (ViewGroup) null);
        this.gZZ.setVisibility(8);
        this.gZZ.setClickable(false);
        this.gZZ.setEnabled(false);
        this.haa = (TextView) this.gZZ.findViewById(d.g.person_list_title);
        this.gZV.addHeaderView(this.gZZ, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXo() {
        if (this.hah == null) {
            this.hah = new com.baidu.tieba.c.d(getPageContext(), this.hag.gZA);
            this.hah.oK(d.f.bg_tip_blue_up);
            this.hah.oM(2);
            this.hah.oL(3000);
            this.hah.oN(-10);
            this.hah.setYOffset(-16);
            this.hah.o(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.hah != null) {
                        PersonListActivity.this.hah.aSr();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(as asVar, boolean z) {
        if (this.mModel != null && asVar != null && (!z || !this.had)) {
            if (!z) {
                this.had = true;
                d(asVar);
            }
            b(asVar);
            d(asVar, z);
            if (!this.mModel.bEW()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().setMsgFans(0);
            }
            b(asVar, z);
        }
    }

    private void b(as asVar) {
        if (asVar != null) {
            if (!asVar.hasMore && !StringUtils.isNull(asVar.bzV)) {
                be(asVar.bzV, asVar.type);
                this.gZV.removeFooterView(this.hai);
                this.gZV.addFooterView(this.hai);
                this.gZV.removeFooterView(this.dbn.getView());
                TiebaStatic.log(new am("c13106").T("obj_locate", 2));
            } else if (!asVar.hasMore) {
                this.gZV.removeFooterView(this.hai);
                this.dbn.setText(getString(d.j.no_more_data_tip));
                this.dbn.aeD();
            } else {
                this.gZV.removeFooterView(this.hai);
                this.dbn.setText(getString(d.j.pb_load_more));
                this.dbn.aeD();
            }
        }
    }

    private void b(as asVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (asVar.bzU > 0 && !v.T(asVar.XN())) {
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
            this.gZV.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bEW()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gZW.setVisibility(0);
                    this.gZV.removeHeaderView(this.gZZ);
                    TextView textView2 = this.gZY;
                    textView2.setVisibility(0);
                    this.hag.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(d.j.all_concerned);
                    } else {
                        string4 = getPageContext().getString(d.j.each_concerned);
                    }
                    String string5 = getPageContext().getString(d.j.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.gZW.setVisibility(8);
                    this.gZZ.setVisibility(0);
                    TextView textView3 = this.haa;
                    textView3.setVisibility(8);
                    this.hag.setVisibility(8);
                    if (this.hae == 2) {
                        string3 = getPageContext().getString(d.j.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.her_no_attention_other));
                    } else if (this.hae == 1) {
                        string3 = getPageContext().getString(d.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(d.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(d.j.person);
                    string = string3;
                    textView = textView3;
                    z = v.T(asVar.XO()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.gZW.setVisibility(8);
                this.gZZ.setVisibility(0);
                textView = this.haa;
                this.hag.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(d.j.my_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.not_have_fans));
                    z = false;
                } else if (this.hae == 2) {
                    string = getPageContext().getString(d.j.her_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.her_no_fan_other));
                    z = false;
                } else if (this.hae == 1) {
                    string = getPageContext().getString(d.j.his_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(d.j.his_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(d.j.we_common_fans));
                return;
            }
            textView.setText(string + ap.as(asVar.bzU) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(as asVar, boolean z) {
        String string;
        this.gZV.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bEW()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.hag.setVisibility(0);
                this.gZY.setVisibility(0);
                this.gZW.setVisibility(0);
                this.gZZ.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(d.j.all_concerned);
                } else {
                    string = getPageContext().getString(d.j.each_concerned);
                }
                String string2 = getPageContext().getString(d.j.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(this.mModel.getLoadType() == 0 ? d.j.not_have_attention : d.j.not_have_each_attention));
                this.gZY.setText(string + 0 + string2);
                return;
            }
            this.hag.setVisibility(8);
            this.gZY.setVisibility(8);
            if (this.hae == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.her_no_attention_other));
                return;
            } else if (this.hae == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.him_no_attention_other));
                return;
            }
        }
        this.hag.setVisibility(8);
        this.gZY.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (asVar != null && !StringUtils.isNull(asVar.bzV)) {
                this.mNoDataView.getSuTextView().setText(bf(asVar.bzV, asVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(d.C0277d.transparent));
                TiebaStatic.log(new am("c13106").T("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.not_have_fans));
        } else if (this.hae == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.her_no_fan_other));
        } else if (this.hae == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.him_no_fan_other));
        }
    }

    private void d(as asVar) {
        this.mModel.setPage(asVar.pageNum);
    }

    private void d(as asVar, boolean z) {
        if (this.hab != null) {
            if (!z) {
                if (asVar.pageNum == 1) {
                    this.hab.resetData();
                }
                this.hab.setHasMore(asVar.hasMore);
                this.hab.a(asVar);
                this.hab.bEQ();
                this.hab.notifyDataSetChanged();
                return;
            }
            this.hab.setHasMore(false);
            this.hab.a(asVar);
            this.hab.bEQ();
            this.hab.notifyDataSetChanged();
        }
    }

    private void aOO() {
        showProgressBar(true, 0, 0);
        this.mModel.bEX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bES() {
        if (this.hab != null) {
            this.hab.notifyDataSetChanged();
        }
        this.mModel.bEX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bET() {
        UserData userData;
        if (this.hab != null && this.hab.getItemViewType(this.haf) == 0 && (userData = (UserData) this.hab.getItem(this.haf)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            bET();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hag.bEN()) {
                this.hag.bEM();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void be(String str, int i) {
        if (this.hai == null) {
            this.hai = LayoutInflater.from(getActivity()).inflate(d.h.forbidden_tip_layout, (ViewGroup) null);
            this.haj = (TextView) this.hai.findViewById(d.g.view_forbidden_tip);
            al.j(this.haj, d.C0277d.cp_cont_d);
            al.l(this.hai, d.C0277d.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.hai.setVisibility(8);
            return;
        }
        this.haj.setText(bf(str, i));
        this.haj.setMovementMethod(LinkMovementMethod.getInstance());
        this.haj.setHighlightColor(getResources().getColor(d.C0277d.transparent));
    }

    private SpannableStringBuilder bf(String str, int i) {
        String string;
        String str2 = null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        switch (i) {
            case 1:
                spannableStringBuilder.append((CharSequence) "，");
                string = getString(d.j.click_for_look_all);
                spannableStringBuilder.append((CharSequence) string);
                break;
            case 2:
                spannableStringBuilder.append((CharSequence) "，");
                String string2 = getString(d.j.remove_all_forbidden_fans);
                spannableStringBuilder.append((CharSequence) string2);
                string = null;
                str2 = string2;
                break;
            case 3:
                string = getString(d.j.click_for_look_all);
                str2 = getString(d.j.remove_all_forbidden_fans);
                spannableStringBuilder.append((CharSequence) "，");
                spannableStringBuilder.append((CharSequence) string);
                spannableStringBuilder.append((CharSequence) getString(d.j.tip_or));
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
                    PersonListActivity.this.bEV();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(al.getColor(d.C0277d.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.6
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.bEU();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(al.getColor(d.C0277d.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEU() {
        TiebaStatic.log(new am("c13104").T("obj_locate", 1));
        if (!l.lo()) {
            showToast(getString(d.j.neterror));
        } else {
            this.hak.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEV() {
        TiebaStatic.log(new am("c13103"));
        if (!l.lo()) {
            showToast(getString(d.j.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
