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
    private PbListView bJY;
    private NavigationBarCoverTip dvq;
    private TextView dvw;
    private boolean fxS;
    private ConcernSelectView fxV;
    private com.baidu.tieba.c.d fxW;
    private View fxX;
    private TextView fxY;
    private e fxZ;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView fxK = null;
    private View fxL = null;
    private View fxM = null;
    private TextView fxN = null;
    private View fxO = null;
    private TextView fxP = null;
    private b fxQ = null;
    private NoPressedRelativeLayout fxR = null;
    private boolean ciU = true;
    private TextView dma = null;
    private int fxT = 0;
    int fxU = 0;
    private final AntiHelper.a dBq = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.ayA));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.ayA));
        }
    };
    private CustomMessageListener bQJ = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aLc != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().aLc, PersonListActivity.this.dBq) != null) {
                            TiebaStatic.log(new am("c12534").x("obj_locate", as.a.ayA));
                        }
                    } else if (updateAttentionMessage.getData().Jo && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener fya = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.fxQ.cL(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.fxQ.bbK();
                    PersonListActivity.this.fxQ.notifyDataSetChanged();
                }
                if (PersonListActivity.this.fxQ.fxz) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a fyb = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
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
        this.fxZ = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.fxZ.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.dvw == null) {
                            PersonListActivity.this.dvw = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.dvw.setGravity(19);
                            PersonListActivity.this.dvw.setPadding(l.h(PersonListActivity.this.getActivity(), e.C0175e.ds34), 0, 0, 0);
                            PersonListActivity.this.dvw.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(PersonListActivity.this.getActivity(), e.C0175e.tbds112)));
                            PersonListActivity.this.dvw.setTextSize(0, l.h(PersonListActivity.this.getActivity(), e.C0175e.fontsize30));
                            PersonListActivity.this.dvw.setTextColor(PersonListActivity.this.getResources().getColor(e.d.cp_cont_i));
                        }
                        PersonListActivity.this.dvw.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.dvq.setBackgroundColor(PersonListActivity.this.getResources().getColor(e.d.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.dvq.setBackgroundColor(PersonListActivity.this.getResources().getColor(e.d.nav_bar_tip_error));
                        }
                        PersonListActivity.this.dvq.a(PersonListActivity.this.getActivity(), PersonListActivity.this.dvw, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.fxY.setText(PersonListActivity.this.getString(e.j.no_more_data_tip));
                    al.h(PersonListActivity.this.fxY, e.d.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void axW() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(e.j.remove_fans_loading));
            }
        });
        registerListener(this.bQJ);
        registerListener(this.fya);
        this.mModel.YJ();
        if (this.ciU) {
            this.ciU = false;
            amw();
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
        al.i(this.fxR, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.fxQ != null) {
            this.fxQ.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fxV.onChangeSkinType(i);
        al.j(this.fxN, e.d.cp_bg_line_d);
        al.h(this.fxN, e.d.cp_cont_d);
        al.j(this.fxP, e.d.cp_bg_line_d);
        al.h(this.fxP, e.d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.fxM != null) {
            getLayoutMode().onModeChanged(this.fxM);
        }
        if (this.fxO != null) {
            getLayoutMode().onModeChanged(this.fxO);
        }
        if (this.fxX != null) {
            al.h(this.fxY, e.d.cp_cont_d);
            al.j(this.fxX, e.d.cp_bg_line_d);
        }
        this.fxZ.onChangeSkinType();
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bJY.dW(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fxQ != null) {
            this.fxQ = null;
        }
        if (this.fxW != null) {
            this.fxW.apZ();
        }
        this.dvq.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.fyb);
        if (bundle != null) {
            this.mModel.jF(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fxT = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.fxT);
            return;
        }
        Intent intent = getIntent();
        this.mModel.jF(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fxT = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.fxT);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.bbQ());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.fxT);
    }

    private void initUI() {
        boolean z = true;
        this.fxR = (NoPressedRelativeLayout) findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.dma = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fxL = findViewById(e.g.sub_title_root);
        this.fxM = this.fxL.findViewById(e.g.newheader_root);
        this.fxL.setVisibility(8);
        this.fxL.setClickable(false);
        this.fxL.setEnabled(false);
        this.fxN = (TextView) this.fxL.findViewById(e.g.person_list_title);
        this.fxV = (ConcernSelectView) findViewById(e.g.select_layout);
        this.dvq = (NavigationBarCoverTip) findViewById(e.g.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bbQ()) {
                this.dma.setText(e.j.my_attention);
                this.fxR.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void q(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.fxV.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.fxV.bbH() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.fxR.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.fxV.bbG();
                        PersonListActivity.this.fxR.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.dma.setText(e.j.fans);
            }
        } else if (this.mModel.bbQ()) {
            if (this.fxT == 2) {
                this.dma.setText(e.j.her_attention_people);
            } else if (this.fxT == 1) {
                this.dma.setText(e.j.his_attention_people);
            } else {
                this.dma.setText(e.j.his_attention_people);
            }
        } else if (this.fxT == 2) {
            this.dma.setText(e.j.attention_to_her);
        } else {
            this.dma.setText(e.j.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.fxQ != null && PersonListActivity.this.fxQ.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.fxQ.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bbQ()) {
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
                PersonListActivity.this.fxU = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.bbN();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.bbM();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.fxQ = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.fxL.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fxR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0175e.ds320)), null, null);
        } else {
            this.fxQ = new c(this, z, sex, onClickListener, onClickListener3);
            this.fxL.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fxR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0175e.ds320)), null, null);
        }
        this.fxK = (BdListView) findViewById(e.g.list);
        this.fxK.setAdapter((ListAdapter) this.fxQ);
        bbL();
        this.fxK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.fxQ != null && PersonListActivity.this.fxQ.isHasMore()) {
                    if (PersonListActivity.this.bJY != null && !PersonListActivity.this.bJY.DU()) {
                        PersonListActivity.this.bJY.DO();
                    }
                    PersonListActivity.this.bbM();
                }
            }
        });
        this.fxV.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void jE(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aVw();
                } else if (PersonListActivity.this.fxW != null) {
                    PersonListActivity.this.fxW.apZ();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void mB(int i) {
                PersonListActivity.this.fxK.setSelection(0);
                PersonListActivity.this.mModel.hQ(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.bbQ()) {
            this.fxV.bbF();
        }
        this.fxV.setVisibility(8);
        this.fxO.setVisibility(8);
        this.bJY = new PbListView(getActivity());
        this.bJY.getView();
        this.bJY.dV(e.d.cp_bg_line_e);
        this.bJY.DL();
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bJY.setTextSize(e.C0175e.tbfontsize33);
        this.bJY.dU(e.d.cp_cont_e);
        this.bJY.setHeight(l.h(getActivity(), e.C0175e.tbds182));
        this.fxK.setNextPage(this.bJY);
    }

    private void bbL() {
        this.fxO = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.person_list_newheader, (ViewGroup) null);
        this.fxO.setVisibility(8);
        this.fxO.setClickable(false);
        this.fxO.setEnabled(false);
        this.fxP = (TextView) this.fxO.findViewById(e.g.person_list_title);
        this.fxK.addHeaderView(this.fxO, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVw() {
        if (this.fxW == null) {
            this.fxW = new com.baidu.tieba.c.d(getPageContext(), this.fxV.fxp);
            this.fxW.kl(e.f.bg_tip_blue_up);
            this.fxW.kn(2);
            this.fxW.km(3000);
            this.fxW.ko(-10);
            this.fxW.kp(-16);
            this.fxW.l(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.fxW != null) {
                        PersonListActivity.this.fxW.apZ();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(aq aqVar, boolean z) {
        if (this.mModel != null && aqVar != null && (!z || !this.fxS)) {
            if (!z) {
                this.fxS = true;
                d(aqVar);
            }
            b(aqVar);
            d(aqVar, z);
            if (!this.mModel.bbQ()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgFans(0);
            }
            b(aqVar, z);
        }
    }

    private void b(aq aqVar) {
        if (aqVar != null) {
            if (!aqVar.hasMore && !StringUtils.isNull(aqVar.aoq)) {
                aH(aqVar.aoq, aqVar.type);
                this.fxK.removeFooterView(this.fxX);
                this.fxK.addFooterView(this.fxX);
                this.fxK.removeFooterView(this.bJY.getView());
                TiebaStatic.log(new am("c13106").x("obj_locate", 2));
            } else if (!aqVar.hasMore) {
                this.fxK.removeFooterView(this.fxX);
                this.bJY.setText(getString(e.j.no_more_data_tip));
                this.bJY.DP();
            } else {
                this.fxK.removeFooterView(this.fxX);
                this.bJY.setText(getString(e.j.pb_load_more));
                this.bJY.DP();
            }
        }
    }

    private void b(aq aqVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (aqVar.aop > 0 && !v.J(aqVar.xI())) {
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
            this.fxK.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bbQ()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fxL.setVisibility(0);
                    this.fxK.removeHeaderView(this.fxO);
                    TextView textView2 = this.fxN;
                    textView2.setVisibility(0);
                    this.fxV.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(e.j.all_concerned);
                    } else {
                        string4 = getPageContext().getString(e.j.each_concerned);
                    }
                    String string5 = getPageContext().getString(e.j.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.fxL.setVisibility(8);
                    this.fxO.setVisibility(0);
                    TextView textView3 = this.fxP;
                    textView3.setVisibility(8);
                    this.fxV.setVisibility(8);
                    if (this.fxT == 2) {
                        string3 = getPageContext().getString(e.j.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.her_no_attention_other));
                    } else if (this.fxT == 1) {
                        string3 = getPageContext().getString(e.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(e.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(e.j.person);
                    string = string3;
                    textView = textView3;
                    z = v.J(aqVar.xJ()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.fxL.setVisibility(8);
                this.fxO.setVisibility(0);
                textView = this.fxP;
                this.fxV.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(e.j.my_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.not_have_fans));
                    z = false;
                } else if (this.fxT == 2) {
                    string = getPageContext().getString(e.j.her_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.her_no_fan_other));
                    z = false;
                } else if (this.fxT == 1) {
                    string = getPageContext().getString(e.j.his_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(e.j.his_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(e.j.we_common_fans));
                return;
            }
            textView.setText(string + ao.G(aqVar.aop) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(aq aqVar, boolean z) {
        String string;
        this.fxK.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bbQ()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fxV.setVisibility(0);
                this.fxN.setVisibility(0);
                this.fxL.setVisibility(0);
                this.fxO.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(e.j.all_concerned);
                } else {
                    string = getPageContext().getString(e.j.each_concerned);
                }
                String string2 = getPageContext().getString(e.j.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(this.mModel.getLoadType() == 0 ? e.j.not_have_attention : e.j.not_have_each_attention));
                this.fxN.setText(string + 0 + string2);
                return;
            }
            this.fxV.setVisibility(8);
            this.fxN.setVisibility(8);
            if (this.fxT == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.her_no_attention_other));
                return;
            } else if (this.fxT == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.him_no_attention_other));
                return;
            }
        }
        this.fxV.setVisibility(8);
        this.fxN.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (aqVar != null && !StringUtils.isNull(aqVar.aoq)) {
                this.mNoDataView.getSuTextView().setText(aI(aqVar.aoq, aqVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(e.d.transparent));
                TiebaStatic.log(new am("c13106").x("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.not_have_fans));
        } else if (this.fxT == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.her_no_fan_other));
        } else if (this.fxT == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.him_no_fan_other));
        }
    }

    private void d(aq aqVar) {
        this.mModel.setPage(aqVar.pageNum);
    }

    private void d(aq aqVar, boolean z) {
        if (this.fxQ != null) {
            if (!z) {
                if (aqVar.pageNum == 1) {
                    this.fxQ.resetData();
                }
                this.fxQ.setHasMore(aqVar.hasMore);
                this.fxQ.a(aqVar);
                this.fxQ.bbK();
                this.fxQ.notifyDataSetChanged();
                return;
            }
            this.fxQ.setHasMore(false);
            this.fxQ.a(aqVar);
            this.fxQ.bbK();
            this.fxQ.notifyDataSetChanged();
        }
    }

    private void amw() {
        showProgressBar(true, 0, 0);
        this.mModel.bbR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbM() {
        if (this.fxQ != null) {
            this.fxQ.notifyDataSetChanged();
        }
        this.mModel.bbR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbN() {
        UserData userData;
        if (this.fxQ != null && this.fxQ.getItemViewType(this.fxU) == 0 && (userData = (UserData) this.fxQ.getItem(this.fxU)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            bbN();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fxV.bbH()) {
                this.fxV.bbG();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aH(String str, int i) {
        if (this.fxX == null) {
            this.fxX = LayoutInflater.from(getActivity()).inflate(e.h.forbidden_tip_layout, (ViewGroup) null);
            this.fxY = (TextView) this.fxX.findViewById(e.g.view_forbidden_tip);
            al.h(this.fxY, e.d.cp_cont_d);
            al.j(this.fxX, e.d.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.fxX.setVisibility(8);
            return;
        }
        this.fxY.setText(aI(str, i));
        this.fxY.setMovementMethod(LinkMovementMethod.getInstance());
        this.fxY.setHighlightColor(getResources().getColor(e.d.transparent));
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
                    PersonListActivity.this.bbP();
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
                    PersonListActivity.this.bbO();
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
    public void bbO() {
        TiebaStatic.log(new am("c13104").x("obj_locate", 1));
        if (!l.lo()) {
            showToast(getString(e.j.neterror));
        } else {
            this.fxZ.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbP() {
        TiebaStatic.log(new am("c13103"));
        if (!l.lo()) {
            showToast(getString(e.j.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
