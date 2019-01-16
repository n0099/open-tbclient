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
    private PbListView bPm;
    private NavigationBarCoverTip dGE;
    private TextView dGK;
    private boolean fJR;
    private ConcernSelectView fJU;
    private com.baidu.tieba.c.d fJV;
    private View fJW;
    private TextView fJX;
    private e fJY;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView fJJ = null;
    private View fJK = null;
    private View fJL = null;
    private TextView fJM = null;
    private View fJN = null;
    private TextView fJO = null;
    private b fJP = null;
    private NoPressedRelativeLayout fJQ = null;
    private boolean cnS = true;
    private TextView dxd = null;
    private int fJS = 0;
    int fJT = 0;
    private final AntiHelper.a dMD = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDq));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDq));
        }
    };
    private CustomMessageListener bVY = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aPX != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().aPX, PersonListActivity.this.dMD) != null) {
                            TiebaStatic.log(new am("c12534").y("obj_locate", as.a.aDq));
                        }
                    } else if (updateAttentionMessage.getData().Jr && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener fJZ = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.fJP.cS(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.fJP.ben();
                    PersonListActivity.this.fJP.notifyDataSetChanged();
                }
                if (PersonListActivity.this.fJP.fJy) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a fKa = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
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
        this.fJY = new com.baidu.tieba.forbidden.fans.e(getPageContext(), getUniqueId());
        this.fJY.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.dGK == null) {
                            PersonListActivity.this.dGK = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.dGK.setGravity(19);
                            PersonListActivity.this.dGK.setPadding(l.h(PersonListActivity.this.getActivity(), e.C0210e.ds34), 0, 0, 0);
                            PersonListActivity.this.dGK.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(PersonListActivity.this.getActivity(), e.C0210e.tbds112)));
                            PersonListActivity.this.dGK.setTextSize(0, l.h(PersonListActivity.this.getActivity(), e.C0210e.fontsize30));
                            PersonListActivity.this.dGK.setTextColor(PersonListActivity.this.getResources().getColor(e.d.cp_cont_i));
                        }
                        PersonListActivity.this.dGK.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.dGE.setBackgroundColor(PersonListActivity.this.getResources().getColor(e.d.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.dGE.setBackgroundColor(PersonListActivity.this.getResources().getColor(e.d.nav_bar_tip_error));
                        }
                        PersonListActivity.this.dGE.a(PersonListActivity.this.getActivity(), PersonListActivity.this.dGK, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.fJX.setText(PersonListActivity.this.getString(e.j.no_more_data_tip));
                    al.h(PersonListActivity.this.fJX, e.d.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void aAp() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(e.j.remove_fans_loading));
            }
        });
        registerListener(this.bVY);
        registerListener(this.fJZ);
        this.mModel.aay();
        if (this.cnS) {
            this.cnS = false;
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
        al.i(this.fJQ, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.fJP != null) {
            this.fJP.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fJU.onChangeSkinType(i);
        al.j(this.fJM, e.d.cp_bg_line_d);
        al.h(this.fJM, e.d.cp_cont_d);
        al.j(this.fJO, e.d.cp_bg_line_d);
        al.h(this.fJO, e.d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.fJL != null) {
            getLayoutMode().onModeChanged(this.fJL);
        }
        if (this.fJN != null) {
            getLayoutMode().onModeChanged(this.fJN);
        }
        if (this.fJW != null) {
            al.h(this.fJX, e.d.cp_cont_d);
            al.j(this.fJW, e.d.cp_bg_line_d);
        }
        this.fJY.onChangeSkinType();
        this.bPm.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bPm.ey(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fJP != null) {
            this.fJP = null;
        }
        if (this.fJV != null) {
            this.fJV.asz();
        }
        this.dGE.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.fKa);
        if (bundle != null) {
            this.mModel.jV(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fJS = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.fJS);
            return;
        }
        Intent intent = getIntent();
        this.mModel.jV(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fJS = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.fJS);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.bet());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.fJS);
    }

    private void initUI() {
        boolean z = true;
        this.fJQ = (NoPressedRelativeLayout) findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.dxd = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fJK = findViewById(e.g.sub_title_root);
        this.fJL = this.fJK.findViewById(e.g.newheader_root);
        this.fJK.setVisibility(8);
        this.fJK.setClickable(false);
        this.fJK.setEnabled(false);
        this.fJM = (TextView) this.fJK.findViewById(e.g.person_list_title);
        this.fJU = (ConcernSelectView) findViewById(e.g.select_layout);
        this.dGE = (NavigationBarCoverTip) findViewById(e.g.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.bet()) {
                this.dxd.setText(e.j.my_attention);
                this.fJQ.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void q(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.fJU.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.fJU.bek() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.fJQ.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.fJU.bej();
                        PersonListActivity.this.fJQ.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.dxd.setText(e.j.fans);
            }
        } else if (this.mModel.bet()) {
            if (this.fJS == 2) {
                this.dxd.setText(e.j.her_attention_people);
            } else if (this.fJS == 1) {
                this.dxd.setText(e.j.his_attention_people);
            } else {
                this.dxd.setText(e.j.his_attention_people);
            }
        } else if (this.fJS == 2) {
            this.dxd.setText(e.j.attention_to_her);
        } else {
            this.dxd.setText(e.j.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.fJP != null && PersonListActivity.this.fJP.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.fJP.getItem(intValue)) != null && userData.getUserId() != null) {
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
                PersonListActivity.this.fJT = ((Integer) view.getTag()).intValue();
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
            this.fJP = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.fJK.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fJQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds320)), null, null);
        } else {
            this.fJP = new c(this, z, sex, onClickListener, onClickListener3);
            this.fJK.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fJQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds320)), null, null);
        }
        this.fJJ = (BdListView) findViewById(e.g.list);
        this.fJJ.setAdapter((ListAdapter) this.fJP);
        beo();
        this.fJJ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.fJP != null && PersonListActivity.this.fJP.isHasMore()) {
                    if (PersonListActivity.this.bPm != null && !PersonListActivity.this.bPm.Fv()) {
                        PersonListActivity.this.bPm.Fp();
                    }
                    PersonListActivity.this.bep();
                }
            }
        });
        this.fJU.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void jU(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aXY();
                } else if (PersonListActivity.this.fJV != null) {
                    PersonListActivity.this.fJV.asz();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void nx(int i) {
                PersonListActivity.this.fJJ.setSelection(0);
                PersonListActivity.this.mModel.is(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.bet()) {
            this.fJU.bei();
        }
        this.fJU.setVisibility(8);
        this.fJN.setVisibility(8);
        this.bPm = new PbListView(getActivity());
        this.bPm.getView();
        this.bPm.ex(e.d.cp_bg_line_e);
        this.bPm.Fm();
        this.bPm.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bPm.setTextSize(e.C0210e.tbfontsize33);
        this.bPm.ew(e.d.cp_cont_e);
        this.bPm.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.fJJ.setNextPage(this.bPm);
    }

    private void beo() {
        this.fJN = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.person_list_newheader, (ViewGroup) null);
        this.fJN.setVisibility(8);
        this.fJN.setClickable(false);
        this.fJN.setEnabled(false);
        this.fJO = (TextView) this.fJN.findViewById(e.g.person_list_title);
        this.fJJ.addHeaderView(this.fJN, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXY() {
        if (this.fJV == null) {
            this.fJV = new com.baidu.tieba.c.d(getPageContext(), this.fJU.fJo);
            this.fJV.li(e.f.bg_tip_blue_up);
            this.fJV.lk(2);
            this.fJV.lj(3000);
            this.fJV.ll(-10);
            this.fJV.setYOffset(-16);
            this.fJV.n(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.fJV != null) {
                        PersonListActivity.this.fJV.asz();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(aq aqVar, boolean z) {
        if (this.mModel != null && aqVar != null && (!z || !this.fJR)) {
            if (!z) {
                this.fJR = true;
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
            if (!aqVar.hasMore && !StringUtils.isNull(aqVar.atg)) {
                aJ(aqVar.atg, aqVar.type);
                this.fJJ.removeFooterView(this.fJW);
                this.fJJ.addFooterView(this.fJW);
                this.fJJ.removeFooterView(this.bPm.getView());
                TiebaStatic.log(new am("c13106").y("obj_locate", 2));
            } else if (!aqVar.hasMore) {
                this.fJJ.removeFooterView(this.fJW);
                this.bPm.setText(getString(e.j.no_more_data_tip));
                this.bPm.Fq();
            } else {
                this.fJJ.removeFooterView(this.fJW);
                this.bPm.setText(getString(e.j.pb_load_more));
                this.bPm.Fq();
            }
        }
    }

    private void b(aq aqVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (aqVar.atf > 0 && !v.I(aqVar.zg())) {
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
            this.fJJ.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.bet()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fJK.setVisibility(0);
                    this.fJJ.removeHeaderView(this.fJN);
                    TextView textView2 = this.fJM;
                    textView2.setVisibility(0);
                    this.fJU.setVisibility(0);
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
                    this.fJK.setVisibility(8);
                    this.fJN.setVisibility(0);
                    TextView textView3 = this.fJO;
                    textView3.setVisibility(8);
                    this.fJU.setVisibility(8);
                    if (this.fJS == 2) {
                        string3 = getPageContext().getString(e.j.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_attention_other));
                    } else if (this.fJS == 1) {
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
                this.fJK.setVisibility(8);
                this.fJN.setVisibility(0);
                textView = this.fJO;
                this.fJU.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(e.j.my_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.not_have_fans));
                    z = false;
                } else if (this.fJS == 2) {
                    string = getPageContext().getString(e.j.her_fans_prefix);
                    string2 = getPageContext().getString(e.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_fan_other));
                    z = false;
                } else if (this.fJS == 1) {
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
            textView.setText(string + ao.Q(aqVar.atf) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(aq aqVar, boolean z) {
        String string;
        this.fJJ.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.bet()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fJU.setVisibility(0);
                this.fJM.setVisibility(0);
                this.fJK.setVisibility(0);
                this.fJN.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(e.j.all_concerned);
                } else {
                    string = getPageContext().getString(e.j.each_concerned);
                }
                String string2 = getPageContext().getString(e.j.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(this.mModel.getLoadType() == 0 ? e.j.not_have_attention : e.j.not_have_each_attention));
                this.fJM.setText(string + 0 + string2);
                return;
            }
            this.fJU.setVisibility(8);
            this.fJM.setVisibility(8);
            if (this.fJS == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_attention_other));
                return;
            } else if (this.fJS == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_attention_other));
                return;
            }
        }
        this.fJU.setVisibility(8);
        this.fJM.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (aqVar != null && !StringUtils.isNull(aqVar.atg)) {
                this.mNoDataView.getSuTextView().setText(aK(aqVar.atg, aqVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(e.d.transparent));
                TiebaStatic.log(new am("c13106").y("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.not_have_fans));
        } else if (this.fJS == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.her_no_fan_other));
        } else if (this.fJS == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.him_no_fan_other));
        }
    }

    private void d(aq aqVar) {
        this.mModel.setPage(aqVar.pageNum);
    }

    private void d(aq aqVar, boolean z) {
        if (this.fJP != null) {
            if (!z) {
                if (aqVar.pageNum == 1) {
                    this.fJP.resetData();
                }
                this.fJP.setHasMore(aqVar.hasMore);
                this.fJP.a(aqVar);
                this.fJP.ben();
                this.fJP.notifyDataSetChanged();
                return;
            }
            this.fJP.setHasMore(false);
            this.fJP.a(aqVar);
            this.fJP.ben();
            this.fJP.notifyDataSetChanged();
        }
    }

    private void aob() {
        showProgressBar(true, 0, 0);
        this.mModel.beu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bep() {
        if (this.fJP != null) {
            this.fJP.notifyDataSetChanged();
        }
        this.mModel.beu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beq() {
        UserData userData;
        if (this.fJP != null && this.fJP.getItemViewType(this.fJT) == 0 && (userData = (UserData) this.fJP.getItem(this.fJT)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            if (this.fJU.bek()) {
                this.fJU.bej();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aJ(String str, int i) {
        if (this.fJW == null) {
            this.fJW = LayoutInflater.from(getActivity()).inflate(e.h.forbidden_tip_layout, (ViewGroup) null);
            this.fJX = (TextView) this.fJW.findViewById(e.g.view_forbidden_tip);
            al.h(this.fJX, e.d.cp_cont_d);
            al.j(this.fJW, e.d.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.fJW.setVisibility(8);
            return;
        }
        this.fJX.setText(aK(str, i));
        this.fJX.setMovementMethod(LinkMovementMethod.getInstance());
        this.fJX.setHighlightColor(getResources().getColor(e.d.transparent));
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
            this.fJY.removeAll();
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
