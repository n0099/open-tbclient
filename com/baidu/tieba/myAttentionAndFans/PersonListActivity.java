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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes3.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView buU;
    private NavigationBarCoverTip deH;
    private TextView deN;
    private boolean fiK;
    private ConcernSelectView fiN;
    private com.baidu.tieba.c.d fiO;
    private View fiP;
    private TextView fiQ;
    private e fiR;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView fiC = null;
    private View fiD = null;
    private View fiE = null;
    private TextView fiF = null;
    private View fiG = null;
    private TextView fiH = null;
    private b fiI = null;
    private NoPressedRelativeLayout fiJ = null;
    private boolean bTL = true;
    private TextView cVn = null;
    private int fiL = 0;
    int fiM = 0;
    private final AntiHelper.a dkD = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arP));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arP));
        }
    };
    private CustomMessageListener bBI = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aDu != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().aDu, PersonListActivity.this.dkD) != null) {
                            TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arP));
                        }
                    } else if (updateAttentionMessage.getData().Gr && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), d.k.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener fiS = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.fiI.cE(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.fiI.aXU();
                    PersonListActivity.this.fiI.notifyDataSetChanged();
                }
                if (PersonListActivity.this.fiI.fiq) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a fiT = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
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
        public ar e(ar arVar, boolean z) {
            PersonListActivity.this.a(arVar, z);
            return null;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.person_list_activity);
        initData(bundle);
        initUI();
        this.fiR = new e(getPageContext(), getUniqueId());
        this.fiR.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.deN == null) {
                            PersonListActivity.this.deN = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.deN.setGravity(19);
                            PersonListActivity.this.deN.setPadding(l.e(PersonListActivity.this.getActivity(), d.e.ds34), 0, 0, 0);
                            PersonListActivity.this.deN.setLayoutParams(new ViewGroup.LayoutParams(-1, l.e(PersonListActivity.this.getActivity(), d.e.tbds112)));
                            PersonListActivity.this.deN.setTextSize(0, l.e(PersonListActivity.this.getActivity(), d.e.fontsize30));
                            PersonListActivity.this.deN.setTextColor(PersonListActivity.this.getResources().getColor(d.C0142d.cp_cont_i));
                        }
                        PersonListActivity.this.deN.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.deH.setBackgroundColor(PersonListActivity.this.getResources().getColor(d.C0142d.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.deH.setBackgroundColor(PersonListActivity.this.getResources().getColor(d.C0142d.nav_bar_tip_error));
                        }
                        PersonListActivity.this.deH.a(PersonListActivity.this.getActivity(), PersonListActivity.this.deN, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.fiQ.setText(PersonListActivity.this.getString(d.k.no_more_data_tip));
                    am.h(PersonListActivity.this.fiQ, d.C0142d.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void asi() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(d.k.remove_fans_loading));
            }
        });
        registerListener(this.bBI);
        registerListener(this.fiS);
        this.mModel.Td();
        if (this.bTL) {
            this.bTL = false;
            agI();
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
        am.i(this.fiJ, d.C0142d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.fiI != null) {
            this.fiI.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fiN.onChangeSkinType(i);
        am.j(this.fiF, d.C0142d.cp_bg_line_d);
        am.h(this.fiF, d.C0142d.cp_cont_d);
        am.j(this.fiH, d.C0142d.cp_bg_line_d);
        am.h(this.fiH, d.C0142d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.fiE != null) {
            getLayoutMode().onModeChanged(this.fiE);
        }
        if (this.fiG != null) {
            getLayoutMode().onModeChanged(this.fiG);
        }
        if (this.fiP != null) {
            am.h(this.fiQ, d.C0142d.cp_cont_d);
            am.j(this.fiP, d.C0142d.cp_bg_line_d);
        }
        this.fiR.onChangeSkinType();
        this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_d));
        this.buU.dz(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fiI != null) {
            this.fiI = null;
        }
        if (this.fiO != null) {
            this.fiO.akn();
        }
        this.deH.onDestroy();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.fiT);
        if (bundle != null) {
            this.mModel.jd(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fiL = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.fiL);
            return;
        }
        Intent intent = getIntent();
        this.mModel.jd(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fiL = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.fiL);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aTY());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.fiL);
    }

    private void initUI() {
        boolean z = true;
        this.fiJ = (NoPressedRelativeLayout) findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.cVn = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fiD = findViewById(d.g.sub_title_root);
        this.fiE = this.fiD.findViewById(d.g.newheader_root);
        this.fiD.setVisibility(8);
        this.fiD.setClickable(false);
        this.fiD.setEnabled(false);
        this.fiF = (TextView) this.fiD.findViewById(d.g.person_list_title);
        this.fiN = (ConcernSelectView) findViewById(d.g.select_layout);
        this.deH = (NavigationBarCoverTip) findViewById(d.g.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aTY()) {
                this.cVn.setText(d.k.my_attention);
                this.fiJ.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void p(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.fiN.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.fiN.aXR() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.fiJ.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.fiN.aXQ();
                        PersonListActivity.this.fiJ.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.cVn.setText(d.k.fans);
            }
        } else if (this.mModel.aTY()) {
            if (this.fiL == 2) {
                this.cVn.setText(d.k.her_attention_people);
            } else if (this.fiL == 1) {
                this.cVn.setText(d.k.his_attention_people);
            } else {
                this.cVn.setText(d.k.his_attention_people);
            }
        } else if (this.fiL == 2) {
            this.cVn.setText(d.k.attention_to_her);
        } else {
            this.cVn.setText(d.k.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.fiI != null && PersonListActivity.this.fiI.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.fiI.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.aTY()) {
                            TiebaStatic.log(new an("c12772").ah("obj_locate", "1").ah("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new an("c12605").r("obj_locate", 1).ah("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.fiM = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.aXX();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.aXW();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.fiI = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.fiD.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fiJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getActivity(), d.e.ds320)), null, null);
        } else {
            this.fiI = new c(this, z, sex, onClickListener, onClickListener3);
            this.fiD.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fiJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getActivity(), d.e.ds320)), null, null);
        }
        this.fiC = (BdListView) findViewById(d.g.list);
        this.fiC.setAdapter((ListAdapter) this.fiI);
        aXV();
        this.fiC.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.fiI != null && PersonListActivity.this.fiI.isHasMore()) {
                    if (PersonListActivity.this.buU != null && !PersonListActivity.this.buU.AO()) {
                        PersonListActivity.this.buU.AH();
                    }
                    PersonListActivity.this.aXW();
                }
            }
        });
        this.fiN.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void jc(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aOY();
                } else if (PersonListActivity.this.fiO != null) {
                    PersonListActivity.this.fiO.akn();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void lq(int i) {
                PersonListActivity.this.fiC.setSelection(0);
                PersonListActivity.this.mModel.gN(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.aTY()) {
            this.fiN.aXP();
        }
        this.fiN.setVisibility(8);
        this.fiG.setVisibility(8);
        this.buU = new PbListView(getActivity());
        this.buU.getView();
        this.buU.dy(d.C0142d.cp_bg_line_e);
        this.buU.AE();
        this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_j));
        this.buU.setTextSize(d.e.tbfontsize33);
        this.buU.dx(d.C0142d.cp_cont_e);
        this.buU.setHeight(l.e(getActivity(), d.e.tbds182));
        this.fiC.setNextPage(this.buU);
    }

    private void aXV() {
        this.fiG = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.person_list_newheader, (ViewGroup) null);
        this.fiG.setVisibility(8);
        this.fiG.setClickable(false);
        this.fiG.setEnabled(false);
        this.fiH = (TextView) this.fiG.findViewById(d.g.person_list_title);
        this.fiC.addHeaderView(this.fiG, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOY() {
        if (this.fiO == null) {
            this.fiO = new com.baidu.tieba.c.d(getPageContext(), this.fiN.fig);
            this.fiO.jd(d.f.bg_tip_blue_up);
            this.fiO.jf(2);
            this.fiO.je(3000);
            this.fiO.jg(-10);
            this.fiO.jh(-16);
            this.fiO.k(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.fiO != null) {
                        PersonListActivity.this.fiO.akn();
                    }
                }
            });
        }
        this.fiO.h(getPageContext().getString(d.k.attention_menu_tip), "key_my_concerned_person_tip", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(ar arVar, boolean z) {
        if (this.mModel != null && arVar != null && (!z || !this.fiK)) {
            if (!z) {
                this.fiK = true;
                d(arVar);
            }
            b(arVar);
            d(arVar, z);
            if (!this.mModel.aTY()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dp().setMsgFans(0);
            }
            b(arVar, z);
        }
    }

    private void b(ar arVar) {
        if (arVar != null) {
            if (!arVar.hasMore && !StringUtils.isNull(arVar.ahB)) {
                aC(arVar.ahB, arVar.type);
                this.fiC.removeFooterView(this.fiP);
                this.fiC.addFooterView(this.fiP);
                this.fiC.removeFooterView(this.buU.getView());
                TiebaStatic.log(new an("c13106").r("obj_locate", 2));
            } else if (!arVar.hasMore) {
                this.fiC.removeFooterView(this.fiP);
                this.buU.setText(getString(d.k.no_more_data_tip));
                this.buU.AI();
            } else {
                this.fiC.removeFooterView(this.fiP);
                this.buU.setText(getString(d.k.pb_load_more));
                this.buU.AI();
            }
        }
    }

    private void b(ar arVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (arVar.ahA > 0 && !w.A(arVar.uK())) {
                c(arVar);
            } else {
                c(arVar, z);
            }
        }
    }

    private void c(ar arVar) {
        TextView textView;
        String string;
        String string2;
        boolean z;
        String string3;
        String string4;
        if (arVar != null) {
            this.fiC.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.aTY()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fiD.setVisibility(0);
                    this.fiC.removeHeaderView(this.fiG);
                    TextView textView2 = this.fiF;
                    textView2.setVisibility(0);
                    this.fiN.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(d.k.all_concerned);
                    } else {
                        string4 = getPageContext().getString(d.k.each_concerned);
                    }
                    String string5 = getPageContext().getString(d.k.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.fiD.setVisibility(8);
                    this.fiG.setVisibility(0);
                    TextView textView3 = this.fiH;
                    textView3.setVisibility(8);
                    this.fiN.setVisibility(8);
                    if (this.fiL == 2) {
                        string3 = getPageContext().getString(d.k.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.her_no_attention_other));
                    } else if (this.fiL == 1) {
                        string3 = getPageContext().getString(d.k.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(d.k.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(d.k.person);
                    string = string3;
                    textView = textView3;
                    z = w.A(arVar.uL()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.fiD.setVisibility(8);
                this.fiG.setVisibility(0);
                textView = this.fiH;
                this.fiN.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(d.k.my_fans_prefix);
                    string2 = getPageContext().getString(d.k.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.not_have_fans));
                    z = false;
                } else if (this.fiL == 2) {
                    string = getPageContext().getString(d.k.her_fans_prefix);
                    string2 = getPageContext().getString(d.k.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.her_no_fan_other));
                    z = false;
                } else if (this.fiL == 1) {
                    string = getPageContext().getString(d.k.his_fans_prefix);
                    string2 = getPageContext().getString(d.k.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(d.k.his_fans_prefix);
                    string2 = getPageContext().getString(d.k.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(d.k.we_common_fans));
                return;
            }
            textView.setText(string + ap.z(arVar.ahA) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ar arVar, boolean z) {
        String string;
        this.fiC.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.aTY()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fiN.setVisibility(0);
                this.fiF.setVisibility(0);
                this.fiD.setVisibility(0);
                this.fiG.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(d.k.all_concerned);
                } else {
                    string = getPageContext().getString(d.k.each_concerned);
                }
                String string2 = getPageContext().getString(d.k.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(this.mModel.getLoadType() == 0 ? d.k.not_have_attention : d.k.not_have_each_attention));
                this.fiF.setText(string + 0 + string2);
                return;
            }
            this.fiN.setVisibility(8);
            this.fiF.setVisibility(8);
            if (this.fiL == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.her_no_attention_other));
                return;
            } else if (this.fiL == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.him_no_attention_other));
                return;
            }
        }
        this.fiN.setVisibility(8);
        this.fiF.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (arVar != null && !StringUtils.isNull(arVar.ahB)) {
                this.mNoDataView.getSuTextView().setText(aD(arVar.ahB, arVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(d.C0142d.transparent));
                TiebaStatic.log(new an("c13106").r("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.not_have_fans));
        } else if (this.fiL == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.her_no_fan_other));
        } else if (this.fiL == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.him_no_fan_other));
        }
    }

    private void d(ar arVar) {
        this.mModel.setPage(arVar.pageNum);
    }

    private void d(ar arVar, boolean z) {
        if (this.fiI != null) {
            if (!z) {
                if (arVar.pageNum == 1) {
                    this.fiI.resetData();
                }
                this.fiI.setHasMore(arVar.hasMore);
                this.fiI.a(arVar);
                this.fiI.aXU();
                this.fiI.notifyDataSetChanged();
                return;
            }
            this.fiI.setHasMore(false);
            this.fiI.a(arVar);
            this.fiI.aXU();
            this.fiI.notifyDataSetChanged();
        }
    }

    private void agI() {
        showProgressBar(true, 0, 0);
        this.mModel.aYa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXW() {
        if (this.fiI != null) {
            this.fiI.notifyDataSetChanged();
        }
        this.mModel.aYa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXX() {
        UserData userData;
        if (this.fiI != null && this.fiI.getItemViewType(this.fiM) == 0 && (userData = (UserData) this.fiI.getItem(this.fiM)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            aXX();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fiN.aXR()) {
                this.fiN.aXQ();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aC(String str, int i) {
        if (this.fiP == null) {
            this.fiP = LayoutInflater.from(getActivity()).inflate(d.i.forbidden_tip_layout, (ViewGroup) null);
            this.fiQ = (TextView) this.fiP.findViewById(d.g.view_forbidden_tip);
            am.h(this.fiQ, d.C0142d.cp_cont_d);
            am.j(this.fiP, d.C0142d.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.fiP.setVisibility(8);
            return;
        }
        this.fiQ.setText(aD(str, i));
        this.fiQ.setMovementMethod(LinkMovementMethod.getInstance());
        this.fiQ.setHighlightColor(getResources().getColor(d.C0142d.transparent));
    }

    private SpannableStringBuilder aD(String str, int i) {
        String string;
        String str2 = null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        switch (i) {
            case 1:
                spannableStringBuilder.append((CharSequence) "，");
                string = getString(d.k.click_for_look_all);
                spannableStringBuilder.append((CharSequence) string);
                break;
            case 2:
                spannableStringBuilder.append((CharSequence) "，");
                String string2 = getString(d.k.remove_all_forbidden_fans);
                spannableStringBuilder.append((CharSequence) string2);
                string = null;
                str2 = string2;
                break;
            case 3:
                string = getString(d.k.click_for_look_all);
                str2 = getString(d.k.remove_all_forbidden_fans);
                spannableStringBuilder.append((CharSequence) "，");
                spannableStringBuilder.append((CharSequence) string);
                spannableStringBuilder.append((CharSequence) getString(d.k.tip_or));
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
                    PersonListActivity.this.aXZ();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(am.getColor(d.C0142d.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.6
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.aXY();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(am.getColor(d.C0142d.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXY() {
        TiebaStatic.log(new an("c13104").r("obj_locate", 1));
        if (!l.jU()) {
            showToast(getString(d.k.neterror));
        } else {
            this.fiR.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXZ() {
        TiebaStatic.log(new an("c13103"));
        if (!l.jU()) {
            showToast(getString(d.k.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
