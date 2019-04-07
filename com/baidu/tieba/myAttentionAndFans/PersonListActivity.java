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
    private PbListView dbr;
    private NavigationBarCoverTip eTE;
    private TextView eTK;
    private boolean gZQ;
    private ConcernSelectView gZT;
    private com.baidu.tieba.c.d gZU;
    private View gZV;
    private TextView gZW;
    private e gZX;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView gZI = null;
    private View gZJ = null;
    private View gZK = null;
    private TextView gZL = null;
    private View gZM = null;
    private TextView gZN = null;
    private b gZO = null;
    private NoPressedRelativeLayout gZP = null;
    private boolean dCf = true;
    private TextView eKf = null;
    private int gZR = 0;
    int gZS = 0;
    private final AntiHelper.a eZP = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLp));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLp));
        }
    };
    private CustomMessageListener ddr = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().bYB != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().bYB, PersonListActivity.this.eZP) != null) {
                            TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLp));
                        }
                    } else if (updateAttentionMessage.getData().Jy && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener gZY = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.gZO.dx(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.gZO.bEN();
                    PersonListActivity.this.gZO.notifyDataSetChanged();
                }
                if (PersonListActivity.this.gZO.gZx) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a gZZ = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
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
        this.gZX = new e(getPageContext(), getUniqueId());
        this.gZX.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.eTK == null) {
                            PersonListActivity.this.eTK = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.eTK.setGravity(19);
                            PersonListActivity.this.eTK.setPadding(l.h(PersonListActivity.this.getActivity(), d.e.ds34), 0, 0, 0);
                            PersonListActivity.this.eTK.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(PersonListActivity.this.getActivity(), d.e.tbds112)));
                            PersonListActivity.this.eTK.setTextSize(0, l.h(PersonListActivity.this.getActivity(), d.e.fontsize30));
                            PersonListActivity.this.eTK.setTextColor(PersonListActivity.this.getResources().getColor(d.C0277d.cp_btn_a));
                        }
                        PersonListActivity.this.eTK.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.eTE.setBackgroundColor(PersonListActivity.this.getResources().getColor(d.C0277d.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.eTE.setBackgroundColor(PersonListActivity.this.getResources().getColor(d.C0277d.nav_bar_tip_error));
                        }
                        PersonListActivity.this.eTE.a(PersonListActivity.this.getActivity(), PersonListActivity.this.eTK, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.gZW.setText(PersonListActivity.this.getString(d.j.no_more_data_tip));
                    al.j(PersonListActivity.this.gZW, d.C0277d.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void baM() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(d.j.remove_fans_loading));
            }
        });
        registerListener(this.ddr);
        registerListener(this.gZY);
        this.mModel.aAX();
        if (this.dCf) {
            this.dCf = false;
            aOJ();
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
        al.k(this.gZP, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.gZO != null) {
            this.gZO.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.gZT.onChangeSkinType(i);
        al.l(this.gZL, d.C0277d.cp_bg_line_d);
        al.j(this.gZL, d.C0277d.cp_cont_d);
        al.l(this.gZN, d.C0277d.cp_bg_line_d);
        al.j(this.gZN, d.C0277d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.gZK != null) {
            getLayoutMode().onModeChanged(this.gZK);
        }
        if (this.gZM != null) {
            getLayoutMode().onModeChanged(this.gZM);
        }
        if (this.gZV != null) {
            al.j(this.gZW, d.C0277d.cp_cont_d);
            al.l(this.gZV, d.C0277d.cp_bg_line_d);
        }
        this.gZX.onChangeSkinType();
        this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        this.dbr.ib(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gZO != null) {
            this.gZO = null;
        }
        if (this.gZU != null) {
            this.gZU.aSp();
        }
        this.eTE.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.gZZ);
        if (bundle != null) {
            this.mModel.mw(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.gZR = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.gZR);
            return;
        }
        Intent intent = getIntent();
        this.mModel.mw(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.gZR = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.gZR);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.bET());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.gZR);
    }

    private void initUI() {
        boolean z = true;
        this.gZP = (NoPressedRelativeLayout) findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.eKf = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gZJ = findViewById(d.g.sub_title_root);
        this.gZK = this.gZJ.findViewById(d.g.newheader_root);
        this.gZJ.setVisibility(8);
        this.gZJ.setClickable(false);
        this.gZJ.setEnabled(false);
        this.gZL = (TextView) this.gZJ.findViewById(d.g.person_list_title);
        this.gZT = (ConcernSelectView) findViewById(d.g.select_layout);
        this.eTE = (NavigationBarCoverTip) findViewById(d.g.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bET()) {
                this.eKf.setText(d.j.my_attention);
                this.gZP.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void u(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.gZT.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.gZT.bEK() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.gZP.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.gZT.bEJ();
                        PersonListActivity.this.gZP.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.eKf.setText(d.j.fans);
            }
        } else if (this.mModel.bET()) {
            if (this.gZR == 2) {
                this.eKf.setText(d.j.her_attention_people);
            } else if (this.gZR == 1) {
                this.eKf.setText(d.j.his_attention_people);
            } else {
                this.eKf.setText(d.j.his_attention_people);
            }
        } else if (this.gZR == 2) {
            this.eKf.setText(d.j.attention_to_her);
        } else {
            this.eKf.setText(d.j.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.gZO != null && PersonListActivity.this.gZO.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.gZO.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bET()) {
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
                PersonListActivity.this.gZS = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.bEQ();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.bEP();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.gZO = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.gZJ.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.gZP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), d.e.tbds530)), null, null);
        } else {
            this.gZO = new c(this, z, sex, onClickListener, onClickListener3);
            this.gZJ.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.gZP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), d.e.tbds530)), null, null);
        }
        this.gZI = (BdListView) findViewById(d.g.list);
        this.gZI.setAdapter((ListAdapter) this.gZO);
        bEO();
        this.gZI.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.gZO != null && PersonListActivity.this.gZO.isHasMore()) {
                    if (PersonListActivity.this.dbr != null && !PersonListActivity.this.dbr.qz()) {
                        PersonListActivity.this.dbr.aez();
                    }
                    PersonListActivity.this.bEP();
                }
            }
        });
        this.gZT.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void mv(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aXm();
                } else if (PersonListActivity.this.gZU != null) {
                    PersonListActivity.this.gZU.aSp();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void rh(int i) {
                PersonListActivity.this.gZI.setSelection(0);
                PersonListActivity.this.mModel.me(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.bET()) {
            this.gZT.bEI();
        }
        this.gZT.setVisibility(8);
        this.gZM.setVisibility(8);
        this.dbr = new PbListView(getActivity());
        this.dbr.getView();
        this.dbr.ia(d.C0277d.cp_bg_line_e);
        this.dbr.aew();
        this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbr.setTextSize(d.e.tbfontsize33);
        this.dbr.hZ(d.C0277d.cp_cont_e);
        this.dbr.setHeight(l.h(getActivity(), d.e.tbds182));
        this.gZI.setNextPage(this.dbr);
    }

    private void bEO() {
        this.gZM = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.person_list_newheader, (ViewGroup) null);
        this.gZM.setVisibility(8);
        this.gZM.setClickable(false);
        this.gZM.setEnabled(false);
        this.gZN = (TextView) this.gZM.findViewById(d.g.person_list_title);
        this.gZI.addHeaderView(this.gZM, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXm() {
        if (this.gZU == null) {
            this.gZU = new com.baidu.tieba.c.d(getPageContext(), this.gZT.gZn);
            this.gZU.oG(d.f.bg_tip_blue_up);
            this.gZU.oI(2);
            this.gZU.oH(3000);
            this.gZU.oJ(-10);
            this.gZU.setYOffset(-16);
            this.gZU.o(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.gZU != null) {
                        PersonListActivity.this.gZU.aSp();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(as asVar, boolean z) {
        if (this.mModel != null && asVar != null && (!z || !this.gZQ)) {
            if (!z) {
                this.gZQ = true;
                d(asVar);
            }
            b(asVar);
            d(asVar, z);
            if (!this.mModel.bET()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.ahx().setMsgFans(0);
            }
            b(asVar, z);
        }
    }

    private void b(as asVar) {
        if (asVar != null) {
            if (!asVar.hasMore && !StringUtils.isNull(asVar.bzY)) {
                be(asVar.bzY, asVar.type);
                this.gZI.removeFooterView(this.gZV);
                this.gZI.addFooterView(this.gZV);
                this.gZI.removeFooterView(this.dbr.getView());
                TiebaStatic.log(new am("c13106").T("obj_locate", 2));
            } else if (!asVar.hasMore) {
                this.gZI.removeFooterView(this.gZV);
                this.dbr.setText(getString(d.j.no_more_data_tip));
                this.dbr.aeA();
            } else {
                this.gZI.removeFooterView(this.gZV);
                this.dbr.setText(getString(d.j.pb_load_more));
                this.dbr.aeA();
            }
        }
    }

    private void b(as asVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (asVar.bzX > 0 && !v.T(asVar.XK())) {
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
            this.gZI.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bET()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gZJ.setVisibility(0);
                    this.gZI.removeHeaderView(this.gZM);
                    TextView textView2 = this.gZL;
                    textView2.setVisibility(0);
                    this.gZT.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(d.j.all_concerned);
                    } else {
                        string4 = getPageContext().getString(d.j.each_concerned);
                    }
                    String string5 = getPageContext().getString(d.j.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.gZJ.setVisibility(8);
                    this.gZM.setVisibility(0);
                    TextView textView3 = this.gZN;
                    textView3.setVisibility(8);
                    this.gZT.setVisibility(8);
                    if (this.gZR == 2) {
                        string3 = getPageContext().getString(d.j.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.her_no_attention_other));
                    } else if (this.gZR == 1) {
                        string3 = getPageContext().getString(d.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(d.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(d.j.person);
                    string = string3;
                    textView = textView3;
                    z = v.T(asVar.XL()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.gZJ.setVisibility(8);
                this.gZM.setVisibility(0);
                textView = this.gZN;
                this.gZT.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(d.j.my_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.not_have_fans));
                    z = false;
                } else if (this.gZR == 2) {
                    string = getPageContext().getString(d.j.her_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.her_no_fan_other));
                    z = false;
                } else if (this.gZR == 1) {
                    string = getPageContext().getString(d.j.his_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(d.j.his_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(d.j.we_common_fans));
                return;
            }
            textView.setText(string + ap.as(asVar.bzX) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(as asVar, boolean z) {
        String string;
        this.gZI.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bET()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.gZT.setVisibility(0);
                this.gZL.setVisibility(0);
                this.gZJ.setVisibility(0);
                this.gZM.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(d.j.all_concerned);
                } else {
                    string = getPageContext().getString(d.j.each_concerned);
                }
                String string2 = getPageContext().getString(d.j.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(this.mModel.getLoadType() == 0 ? d.j.not_have_attention : d.j.not_have_each_attention));
                this.gZL.setText(string + 0 + string2);
                return;
            }
            this.gZT.setVisibility(8);
            this.gZL.setVisibility(8);
            if (this.gZR == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.her_no_attention_other));
                return;
            } else if (this.gZR == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.him_no_attention_other));
                return;
            }
        }
        this.gZT.setVisibility(8);
        this.gZL.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (asVar != null && !StringUtils.isNull(asVar.bzY)) {
                this.mNoDataView.getSuTextView().setText(bf(asVar.bzY, asVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(d.C0277d.transparent));
                TiebaStatic.log(new am("c13106").T("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.not_have_fans));
        } else if (this.gZR == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.her_no_fan_other));
        } else if (this.gZR == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.him_no_fan_other));
        }
    }

    private void d(as asVar) {
        this.mModel.setPage(asVar.pageNum);
    }

    private void d(as asVar, boolean z) {
        if (this.gZO != null) {
            if (!z) {
                if (asVar.pageNum == 1) {
                    this.gZO.resetData();
                }
                this.gZO.setHasMore(asVar.hasMore);
                this.gZO.a(asVar);
                this.gZO.bEN();
                this.gZO.notifyDataSetChanged();
                return;
            }
            this.gZO.setHasMore(false);
            this.gZO.a(asVar);
            this.gZO.bEN();
            this.gZO.notifyDataSetChanged();
        }
    }

    private void aOJ() {
        showProgressBar(true, 0, 0);
        this.mModel.bEU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEP() {
        if (this.gZO != null) {
            this.gZO.notifyDataSetChanged();
        }
        this.mModel.bEU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEQ() {
        UserData userData;
        if (this.gZO != null && this.gZO.getItemViewType(this.gZS) == 0 && (userData = (UserData) this.gZO.getItem(this.gZS)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            bEQ();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gZT.bEK()) {
                this.gZT.bEJ();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void be(String str, int i) {
        if (this.gZV == null) {
            this.gZV = LayoutInflater.from(getActivity()).inflate(d.h.forbidden_tip_layout, (ViewGroup) null);
            this.gZW = (TextView) this.gZV.findViewById(d.g.view_forbidden_tip);
            al.j(this.gZW, d.C0277d.cp_cont_d);
            al.l(this.gZV, d.C0277d.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.gZV.setVisibility(8);
            return;
        }
        this.gZW.setText(bf(str, i));
        this.gZW.setMovementMethod(LinkMovementMethod.getInstance());
        this.gZW.setHighlightColor(getResources().getColor(d.C0277d.transparent));
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
                    PersonListActivity.this.bES();
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
                    PersonListActivity.this.bER();
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
    public void bER() {
        TiebaStatic.log(new am("c13104").T("obj_locate", 1));
        if (!l.lo()) {
            showToast(getString(d.j.neterror));
        } else {
            this.gZX.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bES() {
        TiebaStatic.log(new am("c13103"));
        if (!l.lo()) {
            showToast(getString(d.j.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
