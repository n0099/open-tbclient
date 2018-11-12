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
    private PbListView bKJ;
    private NavigationBarCoverTip dwI;
    private TextView dwO;
    private boolean fzp;
    private ConcernSelectView fzs;
    private com.baidu.tieba.c.d fzt;
    private View fzu;
    private TextView fzv;
    private e fzw;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView fzh = null;
    private View fzi = null;
    private View fzj = null;
    private TextView fzk = null;
    private View fzl = null;
    private TextView fzm = null;
    private b fzn = null;
    private NoPressedRelativeLayout fzo = null;
    private boolean cje = true;
    private TextView dne = null;
    private int fzq = 0;
    int fzr = 0;
    private final AntiHelper.a dCH = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.azn));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.azn));
        }
    };
    private CustomMessageListener bRt = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aLS != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().aLS, PersonListActivity.this.dCH) != null) {
                            TiebaStatic.log(new am("c12534").x("obj_locate", as.a.azn));
                        }
                    } else if (updateAttentionMessage.getData().Jr && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener fzx = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.fzn.cG(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.fzn.bbj();
                    PersonListActivity.this.fzn.notifyDataSetChanged();
                }
                if (PersonListActivity.this.fzn.fyW) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a fzy = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void Q(String str, boolean z) {
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
        this.fzw = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.fzw.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.dwO == null) {
                            PersonListActivity.this.dwO = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.dwO.setGravity(19);
                            PersonListActivity.this.dwO.setPadding(l.h(PersonListActivity.this.getActivity(), e.C0200e.ds34), 0, 0, 0);
                            PersonListActivity.this.dwO.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(PersonListActivity.this.getActivity(), e.C0200e.tbds112)));
                            PersonListActivity.this.dwO.setTextSize(0, l.h(PersonListActivity.this.getActivity(), e.C0200e.fontsize30));
                            PersonListActivity.this.dwO.setTextColor(PersonListActivity.this.getResources().getColor(e.d.cp_cont_i));
                        }
                        PersonListActivity.this.dwO.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.dwI.setBackgroundColor(PersonListActivity.this.getResources().getColor(e.d.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.dwI.setBackgroundColor(PersonListActivity.this.getResources().getColor(e.d.nav_bar_tip_error));
                        }
                        PersonListActivity.this.dwI.a(PersonListActivity.this.getActivity(), PersonListActivity.this.dwO, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.fzv.setText(PersonListActivity.this.getString(e.j.no_more_data_tip));
                    al.h(PersonListActivity.this.fzv, e.d.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void axt() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(e.j.remove_fans_loading));
            }
        });
        registerListener(this.bRt);
        registerListener(this.fzx);
        this.mModel.YT();
        if (this.cje) {
            this.cje = false;
            alV();
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
        al.i(this.fzo, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.fzn != null) {
            this.fzn.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fzs.onChangeSkinType(i);
        al.j(this.fzk, e.d.cp_bg_line_d);
        al.h(this.fzk, e.d.cp_cont_d);
        al.j(this.fzm, e.d.cp_bg_line_d);
        al.h(this.fzm, e.d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.fzj != null) {
            getLayoutMode().onModeChanged(this.fzj);
        }
        if (this.fzl != null) {
            getLayoutMode().onModeChanged(this.fzl);
        }
        if (this.fzu != null) {
            al.h(this.fzv, e.d.cp_cont_d);
            al.j(this.fzu, e.d.cp_bg_line_d);
        }
        this.fzw.onChangeSkinType();
        this.bKJ.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bKJ.ek(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fzn != null) {
            this.fzn = null;
        }
        if (this.fzt != null) {
            this.fzt.apA();
        }
        this.dwI.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.fzy);
        if (bundle != null) {
            this.mModel.jP(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fzq = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.fzq);
            return;
        }
        Intent intent = getIntent();
        this.mModel.jP(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fzq = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.fzq);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.bbp());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.fzq);
    }

    private void initUI() {
        boolean z = true;
        this.fzo = (NoPressedRelativeLayout) findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.dne = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fzi = findViewById(e.g.sub_title_root);
        this.fzj = this.fzi.findViewById(e.g.newheader_root);
        this.fzi.setVisibility(8);
        this.fzi.setClickable(false);
        this.fzi.setEnabled(false);
        this.fzk = (TextView) this.fzi.findViewById(e.g.person_list_title);
        this.fzs = (ConcernSelectView) findViewById(e.g.select_layout);
        this.dwI = (NavigationBarCoverTip) findViewById(e.g.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bbp()) {
                this.dne.setText(e.j.my_attention);
                this.fzo.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void q(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.fzs.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.fzs.bbg() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.fzo.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.fzs.bbf();
                        PersonListActivity.this.fzo.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.dne.setText(e.j.fans);
            }
        } else if (this.mModel.bbp()) {
            if (this.fzq == 2) {
                this.dne.setText(e.j.her_attention_people);
            } else if (this.fzq == 1) {
                this.dne.setText(e.j.his_attention_people);
            } else {
                this.dne.setText(e.j.his_attention_people);
            }
        } else if (this.fzq == 2) {
            this.dne.setText(e.j.attention_to_her);
        } else {
            this.dne.setText(e.j.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.fzn != null && PersonListActivity.this.fzn.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.fzn.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bbp()) {
                            TiebaStatic.log(new am("c12772").ax("obj_locate", "1").ax("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new am("c12605").x("obj_locate", 1).ax("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.fzr = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.bbm();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.bbl();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.fzn = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.fzi.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fzo, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0200e.ds320)), null, null);
        } else {
            this.fzn = new c(this, z, sex, onClickListener, onClickListener3);
            this.fzi.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fzo, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0200e.ds320)), null, null);
        }
        this.fzh = (BdListView) findViewById(e.g.list);
        this.fzh.setAdapter((ListAdapter) this.fzn);
        bbk();
        this.fzh.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.fzn != null && PersonListActivity.this.fzn.isHasMore()) {
                    if (PersonListActivity.this.bKJ != null && !PersonListActivity.this.bKJ.Ee()) {
                        PersonListActivity.this.bKJ.DY();
                    }
                    PersonListActivity.this.bbl();
                }
            }
        });
        this.fzs.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void jO(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aUT();
                } else if (PersonListActivity.this.fzt != null) {
                    PersonListActivity.this.fzt.apA();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void mT(int i) {
                PersonListActivity.this.fzh.setSelection(0);
                PersonListActivity.this.mModel.id(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.bbp()) {
            this.fzs.bbe();
        }
        this.fzs.setVisibility(8);
        this.fzl.setVisibility(8);
        this.bKJ = new PbListView(getActivity());
        this.bKJ.getView();
        this.bKJ.ej(e.d.cp_bg_line_e);
        this.bKJ.DV();
        this.bKJ.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bKJ.setTextSize(e.C0200e.tbfontsize33);
        this.bKJ.ei(e.d.cp_cont_e);
        this.bKJ.setHeight(l.h(getActivity(), e.C0200e.tbds182));
        this.fzh.setNextPage(this.bKJ);
    }

    private void bbk() {
        this.fzl = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.person_list_newheader, (ViewGroup) null);
        this.fzl.setVisibility(8);
        this.fzl.setClickable(false);
        this.fzl.setEnabled(false);
        this.fzm = (TextView) this.fzl.findViewById(e.g.person_list_title);
        this.fzh.addHeaderView(this.fzl, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUT() {
        if (this.fzt == null) {
            this.fzt = new com.baidu.tieba.c.d(getPageContext(), this.fzs.fyM);
            this.fzt.kE(e.f.bg_tip_blue_up);
            this.fzt.kG(2);
            this.fzt.kF(3000);
            this.fzt.kH(-10);
            this.fzt.setYOffset(-16);
            this.fzt.n(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.fzt != null) {
                        PersonListActivity.this.fzt.apA();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(aq aqVar, boolean z) {
        if (this.mModel != null && aqVar != null && (!z || !this.fzp)) {
            if (!z) {
                this.fzp = true;
                d(aqVar);
            }
            b(aqVar);
            d(aqVar, z);
            if (!this.mModel.bbp()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgFans(0);
            }
            b(aqVar, z);
        }
    }

    private void b(aq aqVar) {
        if (aqVar != null) {
            if (!aqVar.hasMore && !StringUtils.isNull(aqVar.apd)) {
                aH(aqVar.apd, aqVar.type);
                this.fzh.removeFooterView(this.fzu);
                this.fzh.addFooterView(this.fzu);
                this.fzh.removeFooterView(this.bKJ.getView());
                TiebaStatic.log(new am("c13106").x("obj_locate", 2));
            } else if (!aqVar.hasMore) {
                this.fzh.removeFooterView(this.fzu);
                this.bKJ.setText(getString(e.j.no_more_data_tip));
                this.bKJ.DZ();
            } else {
                this.fzh.removeFooterView(this.fzu);
                this.bKJ.setText(getString(e.j.pb_load_more));
                this.bKJ.DZ();
            }
        }
    }

    private void b(aq aqVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (aqVar.apc > 0 && !v.I(aqVar.xP())) {
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
            this.fzh.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bbp()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fzi.setVisibility(0);
                    this.fzh.removeHeaderView(this.fzl);
                    TextView textView2 = this.fzk;
                    textView2.setVisibility(0);
                    this.fzs.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(e.j.all_concerned);
                    } else {
                        string4 = getPageContext().getString(e.j.each_concerned);
                    }
                    String string5 = getPageContext().getString(e.j.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.fzi.setVisibility(8);
                    this.fzl.setVisibility(0);
                    TextView textView3 = this.fzm;
                    textView3.setVisibility(8);
                    this.fzs.setVisibility(8);
                    if (this.fzq == 2) {
                        string3 = getPageContext().getString(e.j.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.her_no_attention_other));
                    } else if (this.fzq == 1) {
                        string3 = getPageContext().getString(e.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(e.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(e.j.person);
                    string = string3;
                    textView = textView3;
                    z = v.I(aqVar.xQ()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.fzi.setVisibility(8);
                this.fzl.setVisibility(0);
                textView = this.fzm;
                this.fzs.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(e.j.my_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.not_have_fans));
                    z = false;
                } else if (this.fzq == 2) {
                    string = getPageContext().getString(e.j.her_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.her_no_fan_other));
                    z = false;
                } else if (this.fzq == 1) {
                    string = getPageContext().getString(e.j.his_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(e.j.his_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(e.j.we_common_fans));
                return;
            }
            textView.setText(string + ao.I(aqVar.apc) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(aq aqVar, boolean z) {
        String string;
        this.fzh.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bbp()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fzs.setVisibility(0);
                this.fzk.setVisibility(0);
                this.fzi.setVisibility(0);
                this.fzl.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(e.j.all_concerned);
                } else {
                    string = getPageContext().getString(e.j.each_concerned);
                }
                String string2 = getPageContext().getString(e.j.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(this.mModel.getLoadType() == 0 ? e.j.not_have_attention : e.j.not_have_each_attention));
                this.fzk.setText(string + 0 + string2);
                return;
            }
            this.fzs.setVisibility(8);
            this.fzk.setVisibility(8);
            if (this.fzq == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.her_no_attention_other));
                return;
            } else if (this.fzq == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.him_no_attention_other));
                return;
            }
        }
        this.fzs.setVisibility(8);
        this.fzk.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (aqVar != null && !StringUtils.isNull(aqVar.apd)) {
                this.mNoDataView.getSuTextView().setText(aI(aqVar.apd, aqVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(e.d.transparent));
                TiebaStatic.log(new am("c13106").x("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.not_have_fans));
        } else if (this.fzq == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.her_no_fan_other));
        } else if (this.fzq == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.him_no_fan_other));
        }
    }

    private void d(aq aqVar) {
        this.mModel.setPage(aqVar.pageNum);
    }

    private void d(aq aqVar, boolean z) {
        if (this.fzn != null) {
            if (!z) {
                if (aqVar.pageNum == 1) {
                    this.fzn.resetData();
                }
                this.fzn.setHasMore(aqVar.hasMore);
                this.fzn.a(aqVar);
                this.fzn.bbj();
                this.fzn.notifyDataSetChanged();
                return;
            }
            this.fzn.setHasMore(false);
            this.fzn.a(aqVar);
            this.fzn.bbj();
            this.fzn.notifyDataSetChanged();
        }
    }

    private void alV() {
        showProgressBar(true, 0, 0);
        this.mModel.bbq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbl() {
        if (this.fzn != null) {
            this.fzn.notifyDataSetChanged();
        }
        this.mModel.bbq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbm() {
        UserData userData;
        if (this.fzn != null && this.fzn.getItemViewType(this.fzr) == 0 && (userData = (UserData) this.fzn.getItem(this.fzr)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            bbm();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fzs.bbg()) {
                this.fzs.bbf();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aH(String str, int i) {
        if (this.fzu == null) {
            this.fzu = LayoutInflater.from(getActivity()).inflate(e.h.forbidden_tip_layout, (ViewGroup) null);
            this.fzv = (TextView) this.fzu.findViewById(e.g.view_forbidden_tip);
            al.h(this.fzv, e.d.cp_cont_d);
            al.j(this.fzu, e.d.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.fzu.setVisibility(8);
            return;
        }
        this.fzv.setText(aI(str, i));
        this.fzv.setMovementMethod(LinkMovementMethod.getInstance());
        this.fzv.setHighlightColor(getResources().getColor(e.d.transparent));
    }

    private SpannableStringBuilder aI(String str, int i) {
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
                    PersonListActivity.this.bbo();
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
                    PersonListActivity.this.bbn();
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
    public void bbn() {
        TiebaStatic.log(new am("c13104").x("obj_locate", 1));
        if (!l.lm()) {
            showToast(getString(e.j.neterror));
        } else {
            this.fzw.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbo() {
        TiebaStatic.log(new am("c13103"));
        if (!l.lm()) {
            showToast(getString(e.j.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
