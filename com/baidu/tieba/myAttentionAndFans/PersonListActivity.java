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
    private PbListView bPn;
    private NavigationBarCoverTip dGF;
    private TextView dGL;
    private boolean fJS;
    private ConcernSelectView fJV;
    private com.baidu.tieba.c.d fJW;
    private View fJX;
    private TextView fJY;
    private e fJZ;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView fJK = null;
    private View fJL = null;
    private View fJM = null;
    private TextView fJN = null;
    private View fJO = null;
    private TextView fJP = null;
    private b fJQ = null;
    private NoPressedRelativeLayout fJR = null;
    private boolean cnT = true;
    private TextView dxe = null;
    private int fJT = 0;
    int fJU = 0;
    private final AntiHelper.a dME = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDr));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDr));
        }
    };
    private CustomMessageListener bVZ = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aPY != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().aPY, PersonListActivity.this.dME) != null) {
                            TiebaStatic.log(new am("c12534").y("obj_locate", as.a.aDr));
                        }
                    } else if (updateAttentionMessage.getData().Jr && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener fKa = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.fJQ.cS(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.fJQ.ben();
                    PersonListActivity.this.fJQ.notifyDataSetChanged();
                }
                if (PersonListActivity.this.fJQ.fJz) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a fKb = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void R(String str, boolean z) {
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
        this.fJZ = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.fJZ.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.dGL == null) {
                            PersonListActivity.this.dGL = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.dGL.setGravity(19);
                            PersonListActivity.this.dGL.setPadding(l.h(PersonListActivity.this.getActivity(), e.C0210e.ds34), 0, 0, 0);
                            PersonListActivity.this.dGL.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(PersonListActivity.this.getActivity(), e.C0210e.tbds112)));
                            PersonListActivity.this.dGL.setTextSize(0, l.h(PersonListActivity.this.getActivity(), e.C0210e.fontsize30));
                            PersonListActivity.this.dGL.setTextColor(PersonListActivity.this.getResources().getColor(e.d.cp_cont_i));
                        }
                        PersonListActivity.this.dGL.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.dGF.setBackgroundColor(PersonListActivity.this.getResources().getColor(e.d.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.dGF.setBackgroundColor(PersonListActivity.this.getResources().getColor(e.d.nav_bar_tip_error));
                        }
                        PersonListActivity.this.dGF.a(PersonListActivity.this.getActivity(), PersonListActivity.this.dGL, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.fJY.setText(PersonListActivity.this.getString(e.j.no_more_data_tip));
                    al.h(PersonListActivity.this.fJY, e.d.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void aAp() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(e.j.remove_fans_loading));
            }
        });
        registerListener(this.bVZ);
        registerListener(this.fKa);
        this.mModel.aay();
        if (this.cnT) {
            this.cnT = false;
            aob();
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
        al.i(this.fJR, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.fJQ != null) {
            this.fJQ.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fJV.onChangeSkinType(i);
        al.j(this.fJN, e.d.cp_bg_line_d);
        al.h(this.fJN, e.d.cp_cont_d);
        al.j(this.fJP, e.d.cp_bg_line_d);
        al.h(this.fJP, e.d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.fJM != null) {
            getLayoutMode().onModeChanged(this.fJM);
        }
        if (this.fJO != null) {
            getLayoutMode().onModeChanged(this.fJO);
        }
        if (this.fJX != null) {
            al.h(this.fJY, e.d.cp_cont_d);
            al.j(this.fJX, e.d.cp_bg_line_d);
        }
        this.fJZ.onChangeSkinType();
        this.bPn.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bPn.ey(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fJQ != null) {
            this.fJQ = null;
        }
        if (this.fJW != null) {
            this.fJW.asz();
        }
        this.dGF.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.fKb);
        if (bundle != null) {
            this.mModel.jV(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fJT = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.fJT);
            return;
        }
        Intent intent = getIntent();
        this.mModel.jV(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fJT = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.fJT);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.bet());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.fJT);
    }

    private void initUI() {
        boolean z = true;
        this.fJR = (NoPressedRelativeLayout) findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.dxe = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fJL = findViewById(e.g.sub_title_root);
        this.fJM = this.fJL.findViewById(e.g.newheader_root);
        this.fJL.setVisibility(8);
        this.fJL.setClickable(false);
        this.fJL.setEnabled(false);
        this.fJN = (TextView) this.fJL.findViewById(e.g.person_list_title);
        this.fJV = (ConcernSelectView) findViewById(e.g.select_layout);
        this.dGF = (NavigationBarCoverTip) findViewById(e.g.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bet()) {
                this.dxe.setText(e.j.my_attention);
                this.fJR.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void q(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.fJV.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.fJV.bek() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.fJR.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.fJV.bej();
                        PersonListActivity.this.fJR.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.dxe.setText(e.j.fans);
            }
        } else if (this.mModel.bet()) {
            if (this.fJT == 2) {
                this.dxe.setText(e.j.her_attention_people);
            } else if (this.fJT == 1) {
                this.dxe.setText(e.j.his_attention_people);
            } else {
                this.dxe.setText(e.j.his_attention_people);
            }
        } else if (this.fJT == 2) {
            this.dxe.setText(e.j.attention_to_her);
        } else {
            this.dxe.setText(e.j.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.fJQ != null && PersonListActivity.this.fJQ.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.fJQ.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.bet()) {
                            TiebaStatic.log(new am("c12772").aB("obj_locate", "1").aB("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new am("c12605").y("obj_locate", 1).aB("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.fJU = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.beq();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.bep();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.fJQ = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.fJL.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fJR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds320)), null, null);
        } else {
            this.fJQ = new c(this, z, sex, onClickListener, onClickListener3);
            this.fJL.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fJR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds320)), null, null);
        }
        this.fJK = (BdListView) findViewById(e.g.list);
        this.fJK.setAdapter((ListAdapter) this.fJQ);
        beo();
        this.fJK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.fJQ != null && PersonListActivity.this.fJQ.isHasMore()) {
                    if (PersonListActivity.this.bPn != null && !PersonListActivity.this.bPn.Fv()) {
                        PersonListActivity.this.bPn.Fp();
                    }
                    PersonListActivity.this.bep();
                }
            }
        });
        this.fJV.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void jU(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aXY();
                } else if (PersonListActivity.this.fJW != null) {
                    PersonListActivity.this.fJW.asz();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void nx(int i) {
                PersonListActivity.this.fJK.setSelection(0);
                PersonListActivity.this.mModel.is(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.bet()) {
            this.fJV.bei();
        }
        this.fJV.setVisibility(8);
        this.fJO.setVisibility(8);
        this.bPn = new PbListView(getActivity());
        this.bPn.getView();
        this.bPn.ex(e.d.cp_bg_line_e);
        this.bPn.Fm();
        this.bPn.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bPn.setTextSize(e.C0210e.tbfontsize33);
        this.bPn.ew(e.d.cp_cont_e);
        this.bPn.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.fJK.setNextPage(this.bPn);
    }

    private void beo() {
        this.fJO = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.person_list_newheader, (ViewGroup) null);
        this.fJO.setVisibility(8);
        this.fJO.setClickable(false);
        this.fJO.setEnabled(false);
        this.fJP = (TextView) this.fJO.findViewById(e.g.person_list_title);
        this.fJK.addHeaderView(this.fJO, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXY() {
        if (this.fJW == null) {
            this.fJW = new com.baidu.tieba.c.d(getPageContext(), this.fJV.fJp);
            this.fJW.li(e.f.bg_tip_blue_up);
            this.fJW.lk(2);
            this.fJW.lj(3000);
            this.fJW.ll(-10);
            this.fJW.setYOffset(-16);
            this.fJW.n(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.fJW != null) {
                        PersonListActivity.this.fJW.asz();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(aq aqVar, boolean z) {
        if (this.mModel != null && aqVar != null && (!z || !this.fJS)) {
            if (!z) {
                this.fJS = true;
                d(aqVar);
            }
            b(aqVar);
            d(aqVar, z);
            if (!this.mModel.bet()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.If().setMsgFans(0);
            }
            b(aqVar, z);
        }
    }

    private void b(aq aqVar) {
        if (aqVar != null) {
            if (!aqVar.hasMore && !StringUtils.isNull(aqVar.ath)) {
                aJ(aqVar.ath, aqVar.type);
                this.fJK.removeFooterView(this.fJX);
                this.fJK.addFooterView(this.fJX);
                this.fJK.removeFooterView(this.bPn.getView());
                TiebaStatic.log(new am("c13106").y("obj_locate", 2));
            } else if (!aqVar.hasMore) {
                this.fJK.removeFooterView(this.fJX);
                this.bPn.setText(getString(e.j.no_more_data_tip));
                this.bPn.Fq();
            } else {
                this.fJK.removeFooterView(this.fJX);
                this.bPn.setText(getString(e.j.pb_load_more));
                this.bPn.Fq();
            }
        }
    }

    private void b(aq aqVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (aqVar.atg > 0 && !v.I(aqVar.zg())) {
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
            this.fJK.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bet()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fJL.setVisibility(0);
                    this.fJK.removeHeaderView(this.fJO);
                    TextView textView2 = this.fJN;
                    textView2.setVisibility(0);
                    this.fJV.setVisibility(0);
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
                    this.fJL.setVisibility(8);
                    this.fJO.setVisibility(0);
                    TextView textView3 = this.fJP;
                    textView3.setVisibility(8);
                    this.fJV.setVisibility(8);
                    if (this.fJT == 2) {
                        string3 = getPageContext().getString(e.j.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_attention_other));
                    } else if (this.fJT == 1) {
                        string3 = getPageContext().getString(e.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(e.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(e.j.person);
                    string = string3;
                    textView = textView3;
                    z = v.I(aqVar.zh()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.fJL.setVisibility(8);
                this.fJO.setVisibility(0);
                textView = this.fJP;
                this.fJV.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(e.j.my_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.not_have_fans));
                    z = false;
                } else if (this.fJT == 2) {
                    string = getPageContext().getString(e.j.her_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_fan_other));
                    z = false;
                } else if (this.fJT == 1) {
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
            textView.setText(string + ao.Q(aqVar.atg) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(aq aqVar, boolean z) {
        String string;
        this.fJK.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bet()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fJV.setVisibility(0);
                this.fJN.setVisibility(0);
                this.fJL.setVisibility(0);
                this.fJO.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(e.j.all_concerned);
                } else {
                    string = getPageContext().getString(e.j.each_concerned);
                }
                String string2 = getPageContext().getString(e.j.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(this.mModel.getLoadType() == 0 ? e.j.not_have_attention : e.j.not_have_each_attention));
                this.fJN.setText(string + 0 + string2);
                return;
            }
            this.fJV.setVisibility(8);
            this.fJN.setVisibility(8);
            if (this.fJT == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_attention_other));
                return;
            } else if (this.fJT == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_attention_other));
                return;
            }
        }
        this.fJV.setVisibility(8);
        this.fJN.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (aqVar != null && !StringUtils.isNull(aqVar.ath)) {
                this.mNoDataView.getSuTextView().setText(aK(aqVar.ath, aqVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(e.d.transparent));
                TiebaStatic.log(new am("c13106").y("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.not_have_fans));
        } else if (this.fJT == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_fan_other));
        } else if (this.fJT == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_fan_other));
        }
    }

    private void d(aq aqVar) {
        this.mModel.setPage(aqVar.pageNum);
    }

    private void d(aq aqVar, boolean z) {
        if (this.fJQ != null) {
            if (!z) {
                if (aqVar.pageNum == 1) {
                    this.fJQ.resetData();
                }
                this.fJQ.setHasMore(aqVar.hasMore);
                this.fJQ.a(aqVar);
                this.fJQ.ben();
                this.fJQ.notifyDataSetChanged();
                return;
            }
            this.fJQ.setHasMore(false);
            this.fJQ.a(aqVar);
            this.fJQ.ben();
            this.fJQ.notifyDataSetChanged();
        }
    }

    private void aob() {
        showProgressBar(true, 0, 0);
        this.mModel.beu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bep() {
        if (this.fJQ != null) {
            this.fJQ.notifyDataSetChanged();
        }
        this.mModel.beu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beq() {
        UserData userData;
        if (this.fJQ != null && this.fJQ.getItemViewType(this.fJU) == 0 && (userData = (UserData) this.fJQ.getItem(this.fJU)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            beq();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fJV.bek()) {
                this.fJV.bej();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aJ(String str, int i) {
        if (this.fJX == null) {
            this.fJX = LayoutInflater.from(getActivity()).inflate(e.h.forbidden_tip_layout, (ViewGroup) null);
            this.fJY = (TextView) this.fJX.findViewById(e.g.view_forbidden_tip);
            al.h(this.fJY, e.d.cp_cont_d);
            al.j(this.fJX, e.d.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.fJX.setVisibility(8);
            return;
        }
        this.fJY.setText(aK(str, i));
        this.fJY.setMovementMethod(LinkMovementMethod.getInstance());
        this.fJY.setHighlightColor(getResources().getColor(e.d.transparent));
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
                    PersonListActivity.this.bes();
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
                    PersonListActivity.this.ber();
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
    public void ber() {
        TiebaStatic.log(new am("c13104").y("obj_locate", 1));
        if (!l.ll()) {
            showToast(getString(e.j.neterror));
        } else {
            this.fJZ.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bes() {
        TiebaStatic.log(new am("c13103"));
        if (!l.ll()) {
            showToast(getString(e.j.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
