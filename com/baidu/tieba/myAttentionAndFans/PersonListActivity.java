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
    private PbListView bBr;
    private NavigationBarCoverTip dnn;
    private TextView dnt;
    private boolean fqm;
    private ConcernSelectView fqp;
    private com.baidu.tieba.c.d fqq;
    private View fqr;
    private TextView fqs;
    private e fqt;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView fqe = null;
    private View fqf = null;
    private View fqg = null;
    private TextView fqh = null;
    private View fqi = null;
    private TextView fqj = null;
    private b fqk = null;
    private NoPressedRelativeLayout fql = null;
    private boolean cat = true;
    private TextView ddU = null;
    private int fqn = 0;
    int fqo = 0;
    private final AntiHelper.a dtp = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").w("obj_locate", as.a.atP));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").w("obj_locate", as.a.atP));
        }
    };
    private CustomMessageListener bIg = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aGz != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().aGz, PersonListActivity.this.dtp) != null) {
                            TiebaStatic.log(new am("c12534").w("obj_locate", as.a.atP));
                        }
                    } else if (updateAttentionMessage.getData().IM && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener fqu = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.fqk.cE(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.fqk.aYy();
                    PersonListActivity.this.fqk.notifyDataSetChanged();
                }
                if (PersonListActivity.this.fqk.fpT) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a fqv = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void J(String str, boolean z) {
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
        this.fqt = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.fqt.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.dnt == null) {
                            PersonListActivity.this.dnt = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.dnt.setGravity(19);
                            PersonListActivity.this.dnt.setPadding(l.h(PersonListActivity.this.getActivity(), e.C0141e.ds34), 0, 0, 0);
                            PersonListActivity.this.dnt.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(PersonListActivity.this.getActivity(), e.C0141e.tbds112)));
                            PersonListActivity.this.dnt.setTextSize(0, l.h(PersonListActivity.this.getActivity(), e.C0141e.fontsize30));
                            PersonListActivity.this.dnt.setTextColor(PersonListActivity.this.getResources().getColor(e.d.cp_cont_i));
                        }
                        PersonListActivity.this.dnt.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.dnn.setBackgroundColor(PersonListActivity.this.getResources().getColor(e.d.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.dnn.setBackgroundColor(PersonListActivity.this.getResources().getColor(e.d.nav_bar_tip_error));
                        }
                        PersonListActivity.this.dnn.a(PersonListActivity.this.getActivity(), PersonListActivity.this.dnt, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.fqs.setText(PersonListActivity.this.getString(e.j.no_more_data_tip));
                    al.h(PersonListActivity.this.fqs, e.d.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void auz() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(e.j.remove_fans_loading));
            }
        });
        registerListener(this.bIg);
        registerListener(this.fqu);
        this.mModel.Vb();
        if (this.cat) {
            this.cat = false;
            aiR();
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
        this.mModel.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        al.i(this.fql, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.fqk != null) {
            this.fqk.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fqp.onChangeSkinType(i);
        al.j(this.fqh, e.d.cp_bg_line_d);
        al.h(this.fqh, e.d.cp_cont_d);
        al.j(this.fqj, e.d.cp_bg_line_d);
        al.h(this.fqj, e.d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.fqg != null) {
            getLayoutMode().onModeChanged(this.fqg);
        }
        if (this.fqi != null) {
            getLayoutMode().onModeChanged(this.fqi);
        }
        if (this.fqr != null) {
            al.h(this.fqs, e.d.cp_cont_d);
            al.j(this.fqr, e.d.cp_bg_line_d);
        }
        this.fqt.onChangeSkinType();
        this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bBr.dM(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fqk != null) {
            this.fqk = null;
        }
        if (this.fqq != null) {
            this.fqq.amz();
        }
        this.dnn.onDestroy();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.fqv);
        if (bundle != null) {
            this.mModel.jn(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fqn = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.fqn);
            return;
        }
        Intent intent = getIntent();
        this.mModel.jn(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fqn = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.fqn);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aYE());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.fqn);
    }

    private void initUI() {
        boolean z = true;
        this.fql = (NoPressedRelativeLayout) findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.ddU = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fqf = findViewById(e.g.sub_title_root);
        this.fqg = this.fqf.findViewById(e.g.newheader_root);
        this.fqf.setVisibility(8);
        this.fqf.setClickable(false);
        this.fqf.setEnabled(false);
        this.fqh = (TextView) this.fqf.findViewById(e.g.person_list_title);
        this.fqp = (ConcernSelectView) findViewById(e.g.select_layout);
        this.dnn = (NavigationBarCoverTip) findViewById(e.g.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aYE()) {
                this.ddU.setText(e.j.my_attention);
                this.fql.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void q(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.fqp.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.fqp.aYv() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.fql.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.fqp.aYu();
                        PersonListActivity.this.fql.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.ddU.setText(e.j.fans);
            }
        } else if (this.mModel.aYE()) {
            if (this.fqn == 2) {
                this.ddU.setText(e.j.her_attention_people);
            } else if (this.fqn == 1) {
                this.ddU.setText(e.j.his_attention_people);
            } else {
                this.ddU.setText(e.j.his_attention_people);
            }
        } else if (this.fqn == 2) {
            this.ddU.setText(e.j.attention_to_her);
        } else {
            this.ddU.setText(e.j.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.fqk != null && PersonListActivity.this.fqk.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.fqk.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.aYE()) {
                            TiebaStatic.log(new am("c12772").al("obj_locate", "1").al("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new am("c12605").w("obj_locate", 1).al("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.fqo = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.aYB();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.aYA();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.fqk = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.fqf.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fql, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0141e.ds320)), null, null);
        } else {
            this.fqk = new c(this, z, sex, onClickListener, onClickListener3);
            this.fqf.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fql, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0141e.ds320)), null, null);
        }
        this.fqe = (BdListView) findViewById(e.g.list);
        this.fqe.setAdapter((ListAdapter) this.fqk);
        aYz();
        this.fqe.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.fqk != null && PersonListActivity.this.fqk.isHasMore()) {
                    if (PersonListActivity.this.bBr != null && !PersonListActivity.this.bBr.BO()) {
                        PersonListActivity.this.bBr.BI();
                    }
                    PersonListActivity.this.aYA();
                }
            }
        });
        this.fqp.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void jm(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aSi();
                } else if (PersonListActivity.this.fqq != null) {
                    PersonListActivity.this.fqq.amz();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void md(int i) {
                PersonListActivity.this.fqe.setSelection(0);
                PersonListActivity.this.mModel.hs(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.aYE()) {
            this.fqp.aYt();
        }
        this.fqp.setVisibility(8);
        this.fqi.setVisibility(8);
        this.bBr = new PbListView(getActivity());
        this.bBr.getView();
        this.bBr.dL(e.d.cp_bg_line_e);
        this.bBr.BF();
        this.bBr.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bBr.setTextSize(e.C0141e.tbfontsize33);
        this.bBr.dK(e.d.cp_cont_e);
        this.bBr.setHeight(l.h(getActivity(), e.C0141e.tbds182));
        this.fqe.setNextPage(this.bBr);
    }

    private void aYz() {
        this.fqi = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.person_list_newheader, (ViewGroup) null);
        this.fqi.setVisibility(8);
        this.fqi.setClickable(false);
        this.fqi.setEnabled(false);
        this.fqj = (TextView) this.fqi.findViewById(e.g.person_list_title);
        this.fqe.addHeaderView(this.fqi, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSi() {
        if (this.fqq == null) {
            this.fqq = new com.baidu.tieba.c.d(getPageContext(), this.fqp.fpJ);
            this.fqq.jN(e.f.bg_tip_blue_up);
            this.fqq.jP(2);
            this.fqq.jO(3000);
            this.fqq.jQ(-10);
            this.fqq.jR(-16);
            this.fqq.k(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.fqq != null) {
                        PersonListActivity.this.fqq.amz();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(aq aqVar, boolean z) {
        if (this.mModel != null && aqVar != null && (!z || !this.fqm)) {
            if (!z) {
                this.fqm = true;
                d(aqVar);
            }
            b(aqVar);
            d(aqVar, z);
            if (!this.mModel.aYE()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Ey().setMsgFans(0);
            }
            b(aqVar, z);
        }
    }

    private void b(aq aqVar) {
        if (aqVar != null) {
            if (!aqVar.hasMore && !StringUtils.isNull(aqVar.ajv)) {
                aD(aqVar.ajv, aqVar.type);
                this.fqe.removeFooterView(this.fqr);
                this.fqe.addFooterView(this.fqr);
                this.fqe.removeFooterView(this.bBr.getView());
                TiebaStatic.log(new am("c13106").w("obj_locate", 2));
            } else if (!aqVar.hasMore) {
                this.fqe.removeFooterView(this.fqr);
                this.bBr.setText(getString(e.j.no_more_data_tip));
                this.bBr.BJ();
            } else {
                this.fqe.removeFooterView(this.fqr);
                this.bBr.setText(getString(e.j.pb_load_more));
                this.bBr.BJ();
            }
        }
    }

    private void b(aq aqVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (aqVar.aju > 0 && !v.z(aqVar.vz())) {
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
            this.fqe.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.aYE()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fqf.setVisibility(0);
                    this.fqe.removeHeaderView(this.fqi);
                    TextView textView2 = this.fqh;
                    textView2.setVisibility(0);
                    this.fqp.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(e.j.all_concerned);
                    } else {
                        string4 = getPageContext().getString(e.j.each_concerned);
                    }
                    String string5 = getPageContext().getString(e.j.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.fqf.setVisibility(8);
                    this.fqi.setVisibility(0);
                    TextView textView3 = this.fqj;
                    textView3.setVisibility(8);
                    this.fqp.setVisibility(8);
                    if (this.fqn == 2) {
                        string3 = getPageContext().getString(e.j.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.her_no_attention_other));
                    } else if (this.fqn == 1) {
                        string3 = getPageContext().getString(e.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(e.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(e.j.person);
                    string = string3;
                    textView = textView3;
                    z = v.z(aqVar.vA()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.fqf.setVisibility(8);
                this.fqi.setVisibility(0);
                textView = this.fqj;
                this.fqp.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(e.j.my_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.not_have_fans));
                    z = false;
                } else if (this.fqn == 2) {
                    string = getPageContext().getString(e.j.her_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.her_no_fan_other));
                    z = false;
                } else if (this.fqn == 1) {
                    string = getPageContext().getString(e.j.his_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(e.j.his_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(e.j.we_common_fans));
                return;
            }
            textView.setText(string + ao.E(aqVar.aju) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(aq aqVar, boolean z) {
        String string;
        this.fqe.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.aYE()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fqp.setVisibility(0);
                this.fqh.setVisibility(0);
                this.fqf.setVisibility(0);
                this.fqi.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(e.j.all_concerned);
                } else {
                    string = getPageContext().getString(e.j.each_concerned);
                }
                String string2 = getPageContext().getString(e.j.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(this.mModel.getLoadType() == 0 ? e.j.not_have_attention : e.j.not_have_each_attention));
                this.fqh.setText(string + 0 + string2);
                return;
            }
            this.fqp.setVisibility(8);
            this.fqh.setVisibility(8);
            if (this.fqn == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.her_no_attention_other));
                return;
            } else if (this.fqn == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.him_no_attention_other));
                return;
            }
        }
        this.fqp.setVisibility(8);
        this.fqh.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (aqVar != null && !StringUtils.isNull(aqVar.ajv)) {
                this.mNoDataView.getSuTextView().setText(aE(aqVar.ajv, aqVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(e.d.transparent));
                TiebaStatic.log(new am("c13106").w("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.not_have_fans));
        } else if (this.fqn == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.her_no_fan_other));
        } else if (this.fqn == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.him_no_fan_other));
        }
    }

    private void d(aq aqVar) {
        this.mModel.setPage(aqVar.pageNum);
    }

    private void d(aq aqVar, boolean z) {
        if (this.fqk != null) {
            if (!z) {
                if (aqVar.pageNum == 1) {
                    this.fqk.resetData();
                }
                this.fqk.setHasMore(aqVar.hasMore);
                this.fqk.a(aqVar);
                this.fqk.aYy();
                this.fqk.notifyDataSetChanged();
                return;
            }
            this.fqk.setHasMore(false);
            this.fqk.a(aqVar);
            this.fqk.aYy();
            this.fqk.notifyDataSetChanged();
        }
    }

    private void aiR() {
        showProgressBar(true, 0, 0);
        this.mModel.aYF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYA() {
        if (this.fqk != null) {
            this.fqk.notifyDataSetChanged();
        }
        this.mModel.aYF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYB() {
        UserData userData;
        if (this.fqk != null && this.fqk.getItemViewType(this.fqo) == 0 && (userData = (UserData) this.fqk.getItem(this.fqo)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            aYB();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fqp.aYv()) {
                this.fqp.aYu();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aD(String str, int i) {
        if (this.fqr == null) {
            this.fqr = LayoutInflater.from(getActivity()).inflate(e.h.forbidden_tip_layout, (ViewGroup) null);
            this.fqs = (TextView) this.fqr.findViewById(e.g.view_forbidden_tip);
            al.h(this.fqs, e.d.cp_cont_d);
            al.j(this.fqr, e.d.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.fqr.setVisibility(8);
            return;
        }
        this.fqs.setText(aE(str, i));
        this.fqs.setMovementMethod(LinkMovementMethod.getInstance());
        this.fqs.setHighlightColor(getResources().getColor(e.d.transparent));
    }

    private SpannableStringBuilder aE(String str, int i) {
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
                    PersonListActivity.this.aYD();
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
                    PersonListActivity.this.aYC();
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
    public void aYC() {
        TiebaStatic.log(new am("c13104").w("obj_locate", 1));
        if (!l.lb()) {
            showToast(getString(e.j.neterror));
        } else {
            this.fqt.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYD() {
        TiebaStatic.log(new am("c13103"));
        if (!l.lb()) {
            showToast(getString(e.j.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
