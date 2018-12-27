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
    private PbListView bOB;
    private NavigationBarCoverTip dFV;
    private TextView dGb;
    private boolean fIX;
    private ConcernSelectView fJa;
    private com.baidu.tieba.c.d fJb;
    private View fJc;
    private TextView fJd;
    private e fJe;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView fIP = null;
    private View fIQ = null;
    private View fIR = null;
    private TextView fIS = null;
    private View fIT = null;
    private TextView fIU = null;
    private b fIV = null;
    private NoPressedRelativeLayout fIW = null;
    private boolean cng = true;
    private TextView dwu = null;
    private int fIY = 0;
    int fIZ = 0;
    private final AntiHelper.a dLU = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCO));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCO));
        }
    };
    private CustomMessageListener bVn = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aPt != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().aPt, PersonListActivity.this.dLU) != null) {
                            TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCO));
                        }
                    } else if (updateAttentionMessage.getData().Jr && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener fJf = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.fIV.cS(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.fIV.bdN();
                    PersonListActivity.this.fIV.notifyDataSetChanged();
                }
                if (PersonListActivity.this.fIV.fIE) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a fJg = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
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
        this.fJe = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.fJe.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.dGb == null) {
                            PersonListActivity.this.dGb = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.dGb.setGravity(19);
                            PersonListActivity.this.dGb.setPadding(l.h(PersonListActivity.this.getActivity(), e.C0210e.ds34), 0, 0, 0);
                            PersonListActivity.this.dGb.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(PersonListActivity.this.getActivity(), e.C0210e.tbds112)));
                            PersonListActivity.this.dGb.setTextSize(0, l.h(PersonListActivity.this.getActivity(), e.C0210e.fontsize30));
                            PersonListActivity.this.dGb.setTextColor(PersonListActivity.this.getResources().getColor(e.d.cp_cont_i));
                        }
                        PersonListActivity.this.dGb.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.dFV.setBackgroundColor(PersonListActivity.this.getResources().getColor(e.d.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.dFV.setBackgroundColor(PersonListActivity.this.getResources().getColor(e.d.nav_bar_tip_error));
                        }
                        PersonListActivity.this.dFV.a(PersonListActivity.this.getActivity(), PersonListActivity.this.dGb, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.fJd.setText(PersonListActivity.this.getString(e.j.no_more_data_tip));
                    al.h(PersonListActivity.this.fJd, e.d.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void azS() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(e.j.remove_fans_loading));
            }
        });
        registerListener(this.bVn);
        registerListener(this.fJf);
        this.mModel.aab();
        if (this.cng) {
            this.cng = false;
            anE();
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
        al.i(this.fIW, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.fIV != null) {
            this.fIV.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fJa.onChangeSkinType(i);
        al.j(this.fIS, e.d.cp_bg_line_d);
        al.h(this.fIS, e.d.cp_cont_d);
        al.j(this.fIU, e.d.cp_bg_line_d);
        al.h(this.fIU, e.d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.fIR != null) {
            getLayoutMode().onModeChanged(this.fIR);
        }
        if (this.fIT != null) {
            getLayoutMode().onModeChanged(this.fIT);
        }
        if (this.fJc != null) {
            al.h(this.fJd, e.d.cp_cont_d);
            al.j(this.fJc, e.d.cp_bg_line_d);
        }
        this.fJe.onChangeSkinType();
        this.bOB.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bOB.ey(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fIV != null) {
            this.fIV = null;
        }
        if (this.fJb != null) {
            this.fJb.asb();
        }
        this.dFV.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.fJg);
        if (bundle != null) {
            this.mModel.jV(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fIY = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.fIY);
            return;
        }
        Intent intent = getIntent();
        this.mModel.jV(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fIY = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.fIY);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.bdT());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.fIY);
    }

    private void initUI() {
        boolean z = true;
        this.fIW = (NoPressedRelativeLayout) findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.dwu = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fIQ = findViewById(e.g.sub_title_root);
        this.fIR = this.fIQ.findViewById(e.g.newheader_root);
        this.fIQ.setVisibility(8);
        this.fIQ.setClickable(false);
        this.fIQ.setEnabled(false);
        this.fIS = (TextView) this.fIQ.findViewById(e.g.person_list_title);
        this.fJa = (ConcernSelectView) findViewById(e.g.select_layout);
        this.dFV = (NavigationBarCoverTip) findViewById(e.g.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bdT()) {
                this.dwu.setText(e.j.my_attention);
                this.fIW.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void q(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.fJa.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.fJa.bdK() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.fIW.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.fJa.bdJ();
                        PersonListActivity.this.fIW.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.dwu.setText(e.j.fans);
            }
        } else if (this.mModel.bdT()) {
            if (this.fIY == 2) {
                this.dwu.setText(e.j.her_attention_people);
            } else if (this.fIY == 1) {
                this.dwu.setText(e.j.his_attention_people);
            } else {
                this.dwu.setText(e.j.his_attention_people);
            }
        } else if (this.fIY == 2) {
            this.dwu.setText(e.j.attention_to_her);
        } else {
            this.dwu.setText(e.j.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.fIV != null && PersonListActivity.this.fIV.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.fIV.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bdT()) {
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
                PersonListActivity.this.fIZ = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.bdQ();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.bdP();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.fIV = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.fIQ.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fIW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds320)), null, null);
        } else {
            this.fIV = new c(this, z, sex, onClickListener, onClickListener3);
            this.fIQ.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fIW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds320)), null, null);
        }
        this.fIP = (BdListView) findViewById(e.g.list);
        this.fIP.setAdapter((ListAdapter) this.fIV);
        bdO();
        this.fIP.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.fIV != null && PersonListActivity.this.fIV.isHasMore()) {
                    if (PersonListActivity.this.bOB != null && !PersonListActivity.this.bOB.Fi()) {
                        PersonListActivity.this.bOB.Fc();
                    }
                    PersonListActivity.this.bdP();
                }
            }
        });
        this.fJa.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void jU(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aXy();
                } else if (PersonListActivity.this.fJb != null) {
                    PersonListActivity.this.fJb.asb();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void nw(int i) {
                PersonListActivity.this.fIP.setSelection(0);
                PersonListActivity.this.mModel.is(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.bdT()) {
            this.fJa.bdI();
        }
        this.fJa.setVisibility(8);
        this.fIT.setVisibility(8);
        this.bOB = new PbListView(getActivity());
        this.bOB.getView();
        this.bOB.ex(e.d.cp_bg_line_e);
        this.bOB.EZ();
        this.bOB.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bOB.setTextSize(e.C0210e.tbfontsize33);
        this.bOB.ew(e.d.cp_cont_e);
        this.bOB.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.fIP.setNextPage(this.bOB);
    }

    private void bdO() {
        this.fIT = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.person_list_newheader, (ViewGroup) null);
        this.fIT.setVisibility(8);
        this.fIT.setClickable(false);
        this.fIT.setEnabled(false);
        this.fIU = (TextView) this.fIT.findViewById(e.g.person_list_title);
        this.fIP.addHeaderView(this.fIT, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXy() {
        if (this.fJb == null) {
            this.fJb = new com.baidu.tieba.c.d(getPageContext(), this.fJa.fIu);
            this.fJb.lh(e.f.bg_tip_blue_up);
            this.fJb.lj(2);
            this.fJb.li(3000);
            this.fJb.lk(-10);
            this.fJb.setYOffset(-16);
            this.fJb.n(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.fJb != null) {
                        PersonListActivity.this.fJb.asb();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(aq aqVar, boolean z) {
        if (this.mModel != null && aqVar != null && (!z || !this.fIX)) {
            if (!z) {
                this.fIX = true;
                d(aqVar);
            }
            b(aqVar);
            d(aqVar, z);
            if (!this.mModel.bdT()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.HQ().setMsgFans(0);
            }
            b(aqVar, z);
        }
    }

    private void b(aq aqVar) {
        if (aqVar != null) {
            if (!aqVar.hasMore && !StringUtils.isNull(aqVar.asE)) {
                aJ(aqVar.asE, aqVar.type);
                this.fIP.removeFooterView(this.fJc);
                this.fIP.addFooterView(this.fJc);
                this.fIP.removeFooterView(this.bOB.getView());
                TiebaStatic.log(new am("c13106").x("obj_locate", 2));
            } else if (!aqVar.hasMore) {
                this.fIP.removeFooterView(this.fJc);
                this.bOB.setText(getString(e.j.no_more_data_tip));
                this.bOB.Fd();
            } else {
                this.fIP.removeFooterView(this.fJc);
                this.bOB.setText(getString(e.j.pb_load_more));
                this.bOB.Fd();
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
            this.fIP.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bdT()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fIQ.setVisibility(0);
                    this.fIP.removeHeaderView(this.fIT);
                    TextView textView2 = this.fIS;
                    textView2.setVisibility(0);
                    this.fJa.setVisibility(0);
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
                    this.fIQ.setVisibility(8);
                    this.fIT.setVisibility(0);
                    TextView textView3 = this.fIU;
                    textView3.setVisibility(8);
                    this.fJa.setVisibility(8);
                    if (this.fIY == 2) {
                        string3 = getPageContext().getString(e.j.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_attention_other));
                    } else if (this.fIY == 1) {
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
                this.fIQ.setVisibility(8);
                this.fIT.setVisibility(0);
                textView = this.fIU;
                this.fJa.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(e.j.my_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.not_have_fans));
                    z = false;
                } else if (this.fIY == 2) {
                    string = getPageContext().getString(e.j.her_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_fan_other));
                    z = false;
                } else if (this.fIY == 1) {
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
            textView.setText(string + ao.Q(aqVar.asD) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(aq aqVar, boolean z) {
        String string;
        this.fIP.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bdT()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fJa.setVisibility(0);
                this.fIS.setVisibility(0);
                this.fIQ.setVisibility(0);
                this.fIT.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(e.j.all_concerned);
                } else {
                    string = getPageContext().getString(e.j.each_concerned);
                }
                String string2 = getPageContext().getString(e.j.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(this.mModel.getLoadType() == 0 ? e.j.not_have_attention : e.j.not_have_each_attention));
                this.fIS.setText(string + 0 + string2);
                return;
            }
            this.fJa.setVisibility(8);
            this.fIS.setVisibility(8);
            if (this.fIY == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_attention_other));
                return;
            } else if (this.fIY == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_attention_other));
                return;
            }
        }
        this.fJa.setVisibility(8);
        this.fIS.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (aqVar != null && !StringUtils.isNull(aqVar.asE)) {
                this.mNoDataView.getSuTextView().setText(aK(aqVar.asE, aqVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(e.d.transparent));
                TiebaStatic.log(new am("c13106").x("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.not_have_fans));
        } else if (this.fIY == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_fan_other));
        } else if (this.fIY == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_fan_other));
        }
    }

    private void d(aq aqVar) {
        this.mModel.setPage(aqVar.pageNum);
    }

    private void d(aq aqVar, boolean z) {
        if (this.fIV != null) {
            if (!z) {
                if (aqVar.pageNum == 1) {
                    this.fIV.resetData();
                }
                this.fIV.setHasMore(aqVar.hasMore);
                this.fIV.a(aqVar);
                this.fIV.bdN();
                this.fIV.notifyDataSetChanged();
                return;
            }
            this.fIV.setHasMore(false);
            this.fIV.a(aqVar);
            this.fIV.bdN();
            this.fIV.notifyDataSetChanged();
        }
    }

    private void anE() {
        showProgressBar(true, 0, 0);
        this.mModel.bdU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdP() {
        if (this.fIV != null) {
            this.fIV.notifyDataSetChanged();
        }
        this.mModel.bdU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdQ() {
        UserData userData;
        if (this.fIV != null && this.fIV.getItemViewType(this.fIZ) == 0 && (userData = (UserData) this.fIV.getItem(this.fIZ)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            bdQ();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fJa.bdK()) {
                this.fJa.bdJ();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aJ(String str, int i) {
        if (this.fJc == null) {
            this.fJc = LayoutInflater.from(getActivity()).inflate(e.h.forbidden_tip_layout, (ViewGroup) null);
            this.fJd = (TextView) this.fJc.findViewById(e.g.view_forbidden_tip);
            al.h(this.fJd, e.d.cp_cont_d);
            al.j(this.fJc, e.d.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.fJc.setVisibility(8);
            return;
        }
        this.fJd.setText(aK(str, i));
        this.fJd.setMovementMethod(LinkMovementMethod.getInstance());
        this.fJd.setHighlightColor(getResources().getColor(e.d.transparent));
    }

    private SpannableStringBuilder aK(String str, int i) {
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
                    PersonListActivity.this.bdS();
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
                    PersonListActivity.this.bdR();
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
    public void bdR() {
        TiebaStatic.log(new am("c13104").x("obj_locate", 1));
        if (!l.ll()) {
            showToast(getString(e.j.neterror));
        } else {
            this.fJe.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdS() {
        TiebaStatic.log(new am("c13103"));
        if (!l.ll()) {
            showToast(getString(e.j.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
