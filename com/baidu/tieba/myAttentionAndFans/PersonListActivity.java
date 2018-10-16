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
    private boolean fxR;
    private ConcernSelectView fxU;
    private com.baidu.tieba.c.d fxV;
    private View fxW;
    private TextView fxX;
    private e fxY;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView fxJ = null;
    private View fxK = null;
    private View fxL = null;
    private TextView fxM = null;
    private View fxN = null;
    private TextView fxO = null;
    private b fxP = null;
    private NoPressedRelativeLayout fxQ = null;
    private boolean ciU = true;
    private TextView dma = null;
    private int fxS = 0;
    int fxT = 0;
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
    private HttpMessageListener fxZ = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.fxP.cL(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.fxP.bbK();
                    PersonListActivity.this.fxP.notifyDataSetChanged();
                }
                if (PersonListActivity.this.fxP.fxy) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a fya = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
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
        this.fxY = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.fxY.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
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
                    PersonListActivity.this.fxX.setText(PersonListActivity.this.getString(e.j.no_more_data_tip));
                    al.h(PersonListActivity.this.fxX, e.d.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void axV() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(e.j.remove_fans_loading));
            }
        });
        registerListener(this.bQJ);
        registerListener(this.fxZ);
        this.mModel.YI();
        if (this.ciU) {
            this.ciU = false;
            amv();
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
        al.i(this.fxQ, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.fxP != null) {
            this.fxP.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fxU.onChangeSkinType(i);
        al.j(this.fxM, e.d.cp_bg_line_d);
        al.h(this.fxM, e.d.cp_cont_d);
        al.j(this.fxO, e.d.cp_bg_line_d);
        al.h(this.fxO, e.d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.fxL != null) {
            getLayoutMode().onModeChanged(this.fxL);
        }
        if (this.fxN != null) {
            getLayoutMode().onModeChanged(this.fxN);
        }
        if (this.fxW != null) {
            al.h(this.fxX, e.d.cp_cont_d);
            al.j(this.fxW, e.d.cp_bg_line_d);
        }
        this.fxY.onChangeSkinType();
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bJY.dW(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fxP != null) {
            this.fxP = null;
        }
        if (this.fxV != null) {
            this.fxV.apY();
        }
        this.dvq.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.fya);
        if (bundle != null) {
            this.mModel.jF(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fxS = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.fxS);
            return;
        }
        Intent intent = getIntent();
        this.mModel.jF(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fxS = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.fxS);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.bbQ());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.fxS);
    }

    private void initUI() {
        boolean z = true;
        this.fxQ = (NoPressedRelativeLayout) findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.dma = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fxK = findViewById(e.g.sub_title_root);
        this.fxL = this.fxK.findViewById(e.g.newheader_root);
        this.fxK.setVisibility(8);
        this.fxK.setClickable(false);
        this.fxK.setEnabled(false);
        this.fxM = (TextView) this.fxK.findViewById(e.g.person_list_title);
        this.fxU = (ConcernSelectView) findViewById(e.g.select_layout);
        this.dvq = (NavigationBarCoverTip) findViewById(e.g.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bbQ()) {
                this.dma.setText(e.j.my_attention);
                this.fxQ.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void q(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.fxU.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.fxU.bbH() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.fxQ.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.fxU.bbG();
                        PersonListActivity.this.fxQ.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.dma.setText(e.j.fans);
            }
        } else if (this.mModel.bbQ()) {
            if (this.fxS == 2) {
                this.dma.setText(e.j.her_attention_people);
            } else if (this.fxS == 1) {
                this.dma.setText(e.j.his_attention_people);
            } else {
                this.dma.setText(e.j.his_attention_people);
            }
        } else if (this.fxS == 2) {
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
                    if (PersonListActivity.this.fxP != null && PersonListActivity.this.fxP.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.fxP.getItem(intValue)) != null && userData.getUserId() != null) {
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
                PersonListActivity.this.fxT = ((Integer) view.getTag()).intValue();
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
            this.fxP = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.fxK.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fxQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0175e.ds320)), null, null);
        } else {
            this.fxP = new c(this, z, sex, onClickListener, onClickListener3);
            this.fxK.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fxQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0175e.ds320)), null, null);
        }
        this.fxJ = (BdListView) findViewById(e.g.list);
        this.fxJ.setAdapter((ListAdapter) this.fxP);
        bbL();
        this.fxJ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.fxP != null && PersonListActivity.this.fxP.isHasMore()) {
                    if (PersonListActivity.this.bJY != null && !PersonListActivity.this.bJY.DU()) {
                        PersonListActivity.this.bJY.DO();
                    }
                    PersonListActivity.this.bbM();
                }
            }
        });
        this.fxU.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void jE(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aVw();
                } else if (PersonListActivity.this.fxV != null) {
                    PersonListActivity.this.fxV.apY();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void mB(int i) {
                PersonListActivity.this.fxJ.setSelection(0);
                PersonListActivity.this.mModel.hQ(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.bbQ()) {
            this.fxU.bbF();
        }
        this.fxU.setVisibility(8);
        this.fxN.setVisibility(8);
        this.bJY = new PbListView(getActivity());
        this.bJY.getView();
        this.bJY.dV(e.d.cp_bg_line_e);
        this.bJY.DL();
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bJY.setTextSize(e.C0175e.tbfontsize33);
        this.bJY.dU(e.d.cp_cont_e);
        this.bJY.setHeight(l.h(getActivity(), e.C0175e.tbds182));
        this.fxJ.setNextPage(this.bJY);
    }

    private void bbL() {
        this.fxN = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.person_list_newheader, (ViewGroup) null);
        this.fxN.setVisibility(8);
        this.fxN.setClickable(false);
        this.fxN.setEnabled(false);
        this.fxO = (TextView) this.fxN.findViewById(e.g.person_list_title);
        this.fxJ.addHeaderView(this.fxN, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVw() {
        if (this.fxV == null) {
            this.fxV = new com.baidu.tieba.c.d(getPageContext(), this.fxU.fxo);
            this.fxV.kl(e.f.bg_tip_blue_up);
            this.fxV.kn(2);
            this.fxV.km(3000);
            this.fxV.ko(-10);
            this.fxV.kp(-16);
            this.fxV.l(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.fxV != null) {
                        PersonListActivity.this.fxV.apY();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(aq aqVar, boolean z) {
        if (this.mModel != null && aqVar != null && (!z || !this.fxR)) {
            if (!z) {
                this.fxR = true;
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
                this.fxJ.removeFooterView(this.fxW);
                this.fxJ.addFooterView(this.fxW);
                this.fxJ.removeFooterView(this.bJY.getView());
                TiebaStatic.log(new am("c13106").x("obj_locate", 2));
            } else if (!aqVar.hasMore) {
                this.fxJ.removeFooterView(this.fxW);
                this.bJY.setText(getString(e.j.no_more_data_tip));
                this.bJY.DP();
            } else {
                this.fxJ.removeFooterView(this.fxW);
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
            this.fxJ.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bbQ()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fxK.setVisibility(0);
                    this.fxJ.removeHeaderView(this.fxN);
                    TextView textView2 = this.fxM;
                    textView2.setVisibility(0);
                    this.fxU.setVisibility(0);
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
                    this.fxK.setVisibility(8);
                    this.fxN.setVisibility(0);
                    TextView textView3 = this.fxO;
                    textView3.setVisibility(8);
                    this.fxU.setVisibility(8);
                    if (this.fxS == 2) {
                        string3 = getPageContext().getString(e.j.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.her_no_attention_other));
                    } else if (this.fxS == 1) {
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
                this.fxK.setVisibility(8);
                this.fxN.setVisibility(0);
                textView = this.fxO;
                this.fxU.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(e.j.my_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.not_have_fans));
                    z = false;
                } else if (this.fxS == 2) {
                    string = getPageContext().getString(e.j.her_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.her_no_fan_other));
                    z = false;
                } else if (this.fxS == 1) {
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
        this.fxJ.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bbQ()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fxU.setVisibility(0);
                this.fxM.setVisibility(0);
                this.fxK.setVisibility(0);
                this.fxN.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(e.j.all_concerned);
                } else {
                    string = getPageContext().getString(e.j.each_concerned);
                }
                String string2 = getPageContext().getString(e.j.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(this.mModel.getLoadType() == 0 ? e.j.not_have_attention : e.j.not_have_each_attention));
                this.fxM.setText(string + 0 + string2);
                return;
            }
            this.fxU.setVisibility(8);
            this.fxM.setVisibility(8);
            if (this.fxS == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.her_no_attention_other));
                return;
            } else if (this.fxS == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.him_no_attention_other));
                return;
            }
        }
        this.fxU.setVisibility(8);
        this.fxM.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (aqVar != null && !StringUtils.isNull(aqVar.aoq)) {
                this.mNoDataView.getSuTextView().setText(aI(aqVar.aoq, aqVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(e.d.transparent));
                TiebaStatic.log(new am("c13106").x("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.not_have_fans));
        } else if (this.fxS == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.her_no_fan_other));
        } else if (this.fxS == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.him_no_fan_other));
        }
    }

    private void d(aq aqVar) {
        this.mModel.setPage(aqVar.pageNum);
    }

    private void d(aq aqVar, boolean z) {
        if (this.fxP != null) {
            if (!z) {
                if (aqVar.pageNum == 1) {
                    this.fxP.resetData();
                }
                this.fxP.setHasMore(aqVar.hasMore);
                this.fxP.a(aqVar);
                this.fxP.bbK();
                this.fxP.notifyDataSetChanged();
                return;
            }
            this.fxP.setHasMore(false);
            this.fxP.a(aqVar);
            this.fxP.bbK();
            this.fxP.notifyDataSetChanged();
        }
    }

    private void amv() {
        showProgressBar(true, 0, 0);
        this.mModel.bbR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbM() {
        if (this.fxP != null) {
            this.fxP.notifyDataSetChanged();
        }
        this.mModel.bbR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbN() {
        UserData userData;
        if (this.fxP != null && this.fxP.getItemViewType(this.fxT) == 0 && (userData = (UserData) this.fxP.getItem(this.fxT)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            if (this.fxU.bbH()) {
                this.fxU.bbG();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aH(String str, int i) {
        if (this.fxW == null) {
            this.fxW = LayoutInflater.from(getActivity()).inflate(e.h.forbidden_tip_layout, (ViewGroup) null);
            this.fxX = (TextView) this.fxW.findViewById(e.g.view_forbidden_tip);
            al.h(this.fxX, e.d.cp_cont_d);
            al.j(this.fxW, e.d.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.fxW.setVisibility(8);
            return;
        }
        this.fxX.setText(aI(str, i));
        this.fxX.setMovementMethod(LinkMovementMethod.getInstance());
        this.fxX.setHighlightColor(getResources().getColor(e.d.transparent));
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
            this.fxY.removeAll();
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
