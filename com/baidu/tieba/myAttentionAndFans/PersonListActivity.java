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
import com.baidu.tieba.f;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes3.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView bvC;
    private TextView dhB;
    private NavigationBarCoverTip dhv;
    private boolean fiQ;
    private ConcernSelectView fiT;
    private com.baidu.tieba.c.d fiU;
    private View fiV;
    private TextView fiW;
    private e fiX;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView fiI = null;
    private View fiJ = null;
    private View fiK = null;
    private TextView fiL = null;
    private View fiM = null;
    private TextView fiN = null;
    private b fiO = null;
    private NoPressedRelativeLayout fiP = null;
    private boolean bUE = true;
    private TextView cXY = null;
    private int fiR = 0;
    int fiS = 0;
    private final AntiHelper.a dnr = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arr));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arr));
        }
    };
    private CustomMessageListener bCr = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aDt != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().aDt, PersonListActivity.this.dnr) != null) {
                            TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arr));
                        }
                    } else if (updateAttentionMessage.getData().Gp && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), f.j.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener fiY = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.fiO.cA(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.fiO.aWl();
                    PersonListActivity.this.fiO.notifyDataSetChanged();
                }
                if (PersonListActivity.this.fiO.fiw) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a fiZ = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void I(String str, boolean z) {
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
        setContentView(f.h.person_list_activity);
        initData(bundle);
        initUI();
        this.fiX = new e(getPageContext(), getUniqueId());
        this.fiX.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.dhB == null) {
                            PersonListActivity.this.dhB = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.dhB.setGravity(19);
                            PersonListActivity.this.dhB.setPadding(l.f(PersonListActivity.this.getActivity(), f.e.ds34), 0, 0, 0);
                            PersonListActivity.this.dhB.setLayoutParams(new ViewGroup.LayoutParams(-1, l.f(PersonListActivity.this.getActivity(), f.e.tbds112)));
                            PersonListActivity.this.dhB.setTextSize(0, l.f(PersonListActivity.this.getActivity(), f.e.fontsize30));
                            PersonListActivity.this.dhB.setTextColor(PersonListActivity.this.getResources().getColor(f.d.cp_cont_i));
                        }
                        PersonListActivity.this.dhB.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.dhv.setBackgroundColor(PersonListActivity.this.getResources().getColor(f.d.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.dhv.setBackgroundColor(PersonListActivity.this.getResources().getColor(f.d.nav_bar_tip_error));
                        }
                        PersonListActivity.this.dhv.a(PersonListActivity.this.getActivity(), PersonListActivity.this.dhB, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.fiW.setText(PersonListActivity.this.getString(f.j.no_more_data_tip));
                    am.h(PersonListActivity.this.fiW, f.d.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void asL() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(f.j.remove_fans_loading));
            }
        });
        registerListener(this.bCr);
        registerListener(this.fiY);
        this.mModel.To();
        if (this.bUE) {
            this.bUE = false;
            ahf();
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
        am.i(this.fiP, f.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.fiO != null) {
            this.fiO.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fiT.onChangeSkinType(i);
        am.j(this.fiL, f.d.cp_bg_line_d);
        am.h(this.fiL, f.d.cp_cont_d);
        am.j(this.fiN, f.d.cp_bg_line_d);
        am.h(this.fiN, f.d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.fiK != null) {
            getLayoutMode().onModeChanged(this.fiK);
        }
        if (this.fiM != null) {
            getLayoutMode().onModeChanged(this.fiM);
        }
        if (this.fiV != null) {
            am.h(this.fiW, f.d.cp_cont_d);
            am.j(this.fiV, f.d.cp_bg_line_d);
        }
        this.fiX.onChangeSkinType();
        this.bvC.setTextColor(am.getColor(f.d.cp_cont_d));
        this.bvC.dB(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fiO != null) {
            this.fiO = null;
        }
        if (this.fiU != null) {
            this.fiU.akO();
        }
        this.dhv.onDestroy();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.fiZ);
        if (bundle != null) {
            this.mModel.iP(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fiR = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.fiR);
            return;
        }
        Intent intent = getIntent();
        this.mModel.iP(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fiR = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.fiR);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aWr());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.fiR);
    }

    private void initUI() {
        boolean z = true;
        this.fiP = (NoPressedRelativeLayout) findViewById(f.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(f.g.view_navigation_bar);
        this.cXY = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fiJ = findViewById(f.g.sub_title_root);
        this.fiK = this.fiJ.findViewById(f.g.newheader_root);
        this.fiJ.setVisibility(8);
        this.fiJ.setClickable(false);
        this.fiJ.setEnabled(false);
        this.fiL = (TextView) this.fiJ.findViewById(f.g.person_list_title);
        this.fiT = (ConcernSelectView) findViewById(f.g.select_layout);
        this.dhv = (NavigationBarCoverTip) findViewById(f.g.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aWr()) {
                this.cXY.setText(f.j.my_attention);
                this.fiP.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void q(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.fiT.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.fiT.aWi() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.fiP.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.fiT.aWh();
                        PersonListActivity.this.fiP.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.cXY.setText(f.j.fans);
            }
        } else if (this.mModel.aWr()) {
            if (this.fiR == 2) {
                this.cXY.setText(f.j.her_attention_people);
            } else if (this.fiR == 1) {
                this.cXY.setText(f.j.his_attention_people);
            } else {
                this.cXY.setText(f.j.his_attention_people);
            }
        } else if (this.fiR == 2) {
            this.cXY.setText(f.j.attention_to_her);
        } else {
            this.cXY.setText(f.j.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.fiO != null && PersonListActivity.this.fiO.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.fiO.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.aWr()) {
                            TiebaStatic.log(new an("c12772").ae("obj_locate", "1").ae("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new an("c12605").r("obj_locate", 1).ae("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.fiS = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.aWo();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.aWn();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.fiO = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.fiJ.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fiP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), f.e.ds320)), null, null);
        } else {
            this.fiO = new c(this, z, sex, onClickListener, onClickListener3);
            this.fiJ.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fiP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), f.e.ds320)), null, null);
        }
        this.fiI = (BdListView) findViewById(f.g.list);
        this.fiI.setAdapter((ListAdapter) this.fiO);
        aWm();
        this.fiI.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.fiO != null && PersonListActivity.this.fiO.isHasMore()) {
                    if (PersonListActivity.this.bvC != null && !PersonListActivity.this.bvC.AB()) {
                        PersonListActivity.this.bvC.Av();
                    }
                    PersonListActivity.this.aWn();
                }
            }
        });
        this.fiT.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void iO(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aPV();
                } else if (PersonListActivity.this.fiU != null) {
                    PersonListActivity.this.fiU.akO();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void lB(int i) {
                PersonListActivity.this.fiI.setSelection(0);
                PersonListActivity.this.mModel.gS(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.aWr()) {
            this.fiT.aWg();
        }
        this.fiT.setVisibility(8);
        this.fiM.setVisibility(8);
        this.bvC = new PbListView(getActivity());
        this.bvC.getView();
        this.bvC.dA(f.d.cp_bg_line_e);
        this.bvC.As();
        this.bvC.setTextColor(am.getColor(f.d.cp_cont_j));
        this.bvC.setTextSize(f.e.tbfontsize33);
        this.bvC.dz(f.d.cp_cont_e);
        this.bvC.setHeight(l.f(getActivity(), f.e.tbds182));
        this.fiI.setNextPage(this.bvC);
    }

    private void aWm() {
        this.fiM = LayoutInflater.from(getPageContext().getPageActivity()).inflate(f.h.person_list_newheader, (ViewGroup) null);
        this.fiM.setVisibility(8);
        this.fiM.setClickable(false);
        this.fiM.setEnabled(false);
        this.fiN = (TextView) this.fiM.findViewById(f.g.person_list_title);
        this.fiI.addHeaderView(this.fiM, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPV() {
        if (this.fiU == null) {
            this.fiU = new com.baidu.tieba.c.d(getPageContext(), this.fiT.fim);
            this.fiU.jo(f.C0146f.bg_tip_blue_up);
            this.fiU.jq(2);
            this.fiU.jp(3000);
            this.fiU.jr(-10);
            this.fiU.js(-16);
            this.fiU.k(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.fiU != null) {
                        PersonListActivity.this.fiU.akO();
                    }
                }
            });
        }
        this.fiU.g(getPageContext().getString(f.j.attention_menu_tip), "key_my_concerned_person_tip", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(aq aqVar, boolean z) {
        if (this.mModel != null && aqVar != null && (!z || !this.fiQ)) {
            if (!z) {
                this.fiQ = true;
                d(aqVar);
            }
            b(aqVar);
            d(aqVar, z);
            if (!this.mModel.aWr()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgFans(0);
            }
            b(aqVar, z);
        }
    }

    private void b(aq aqVar) {
        if (aqVar != null) {
            if (!aqVar.hasMore && !StringUtils.isNull(aqVar.agV)) {
                ay(aqVar.agV, aqVar.type);
                this.fiI.removeFooterView(this.fiV);
                this.fiI.addFooterView(this.fiV);
                this.fiI.removeFooterView(this.bvC.getView());
                TiebaStatic.log(new an("c13106").r("obj_locate", 2));
            } else if (!aqVar.hasMore) {
                this.fiI.removeFooterView(this.fiV);
                this.bvC.setText(getString(f.j.no_more_data_tip));
                this.bvC.Aw();
            } else {
                this.fiI.removeFooterView(this.fiV);
                this.bvC.setText(getString(f.j.pb_load_more));
                this.bvC.Aw();
            }
        }
    }

    private void b(aq aqVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (aqVar.agU > 0 && !w.z(aqVar.uw())) {
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
            this.fiI.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.aWr()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fiJ.setVisibility(0);
                    this.fiI.removeHeaderView(this.fiM);
                    TextView textView2 = this.fiL;
                    textView2.setVisibility(0);
                    this.fiT.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(f.j.all_concerned);
                    } else {
                        string4 = getPageContext().getString(f.j.each_concerned);
                    }
                    String string5 = getPageContext().getString(f.j.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.fiJ.setVisibility(8);
                    this.fiM.setVisibility(0);
                    TextView textView3 = this.fiN;
                    textView3.setVisibility(8);
                    this.fiT.setVisibility(8);
                    if (this.fiR == 2) {
                        string3 = getPageContext().getString(f.j.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.her_no_attention_other));
                    } else if (this.fiR == 1) {
                        string3 = getPageContext().getString(f.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(f.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(f.j.person);
                    string = string3;
                    textView = textView3;
                    z = w.z(aqVar.ux()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.fiJ.setVisibility(8);
                this.fiM.setVisibility(0);
                textView = this.fiN;
                this.fiT.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(f.j.my_fans_prefix);
                    string2 = getPageContext().getString(f.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.not_have_fans));
                    z = false;
                } else if (this.fiR == 2) {
                    string = getPageContext().getString(f.j.her_fans_prefix);
                    string2 = getPageContext().getString(f.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.her_no_fan_other));
                    z = false;
                } else if (this.fiR == 1) {
                    string = getPageContext().getString(f.j.his_fans_prefix);
                    string2 = getPageContext().getString(f.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(f.j.his_fans_prefix);
                    string2 = getPageContext().getString(f.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(f.j.we_common_fans));
                return;
            }
            textView.setText(string + ap.A(aqVar.agU) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(aq aqVar, boolean z) {
        String string;
        this.fiI.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.aWr()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fiT.setVisibility(0);
                this.fiL.setVisibility(0);
                this.fiJ.setVisibility(0);
                this.fiM.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(f.j.all_concerned);
                } else {
                    string = getPageContext().getString(f.j.each_concerned);
                }
                String string2 = getPageContext().getString(f.j.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(this.mModel.getLoadType() == 0 ? f.j.not_have_attention : f.j.not_have_each_attention));
                this.fiL.setText(string + 0 + string2);
                return;
            }
            this.fiT.setVisibility(8);
            this.fiL.setVisibility(8);
            if (this.fiR == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.her_no_attention_other));
                return;
            } else if (this.fiR == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.him_no_attention_other));
                return;
            }
        }
        this.fiT.setVisibility(8);
        this.fiL.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (aqVar != null && !StringUtils.isNull(aqVar.agV)) {
                this.mNoDataView.getSuTextView().setText(az(aqVar.agV, aqVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(f.d.transparent));
                TiebaStatic.log(new an("c13106").r("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.not_have_fans));
        } else if (this.fiR == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.her_no_fan_other));
        } else if (this.fiR == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.him_no_fan_other));
        }
    }

    private void d(aq aqVar) {
        this.mModel.setPage(aqVar.pageNum);
    }

    private void d(aq aqVar, boolean z) {
        if (this.fiO != null) {
            if (!z) {
                if (aqVar.pageNum == 1) {
                    this.fiO.resetData();
                }
                this.fiO.setHasMore(aqVar.hasMore);
                this.fiO.a(aqVar);
                this.fiO.aWl();
                this.fiO.notifyDataSetChanged();
                return;
            }
            this.fiO.setHasMore(false);
            this.fiO.a(aqVar);
            this.fiO.aWl();
            this.fiO.notifyDataSetChanged();
        }
    }

    private void ahf() {
        showProgressBar(true, 0, 0);
        this.mModel.aWs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWn() {
        if (this.fiO != null) {
            this.fiO.notifyDataSetChanged();
        }
        this.mModel.aWs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWo() {
        UserData userData;
        if (this.fiO != null && this.fiO.getItemViewType(this.fiS) == 0 && (userData = (UserData) this.fiO.getItem(this.fiS)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            aWo();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fiT.aWi()) {
                this.fiT.aWh();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void ay(String str, int i) {
        if (this.fiV == null) {
            this.fiV = LayoutInflater.from(getActivity()).inflate(f.h.forbidden_tip_layout, (ViewGroup) null);
            this.fiW = (TextView) this.fiV.findViewById(f.g.view_forbidden_tip);
            am.h(this.fiW, f.d.cp_cont_d);
            am.j(this.fiV, f.d.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.fiV.setVisibility(8);
            return;
        }
        this.fiW.setText(az(str, i));
        this.fiW.setMovementMethod(LinkMovementMethod.getInstance());
        this.fiW.setHighlightColor(getResources().getColor(f.d.transparent));
    }

    private SpannableStringBuilder az(String str, int i) {
        String string;
        String str2 = null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        switch (i) {
            case 1:
                spannableStringBuilder.append((CharSequence) "，");
                string = getString(f.j.click_for_look_all);
                spannableStringBuilder.append((CharSequence) string);
                break;
            case 2:
                spannableStringBuilder.append((CharSequence) "，");
                String string2 = getString(f.j.remove_all_forbidden_fans);
                spannableStringBuilder.append((CharSequence) string2);
                string = null;
                str2 = string2;
                break;
            case 3:
                string = getString(f.j.click_for_look_all);
                str2 = getString(f.j.remove_all_forbidden_fans);
                spannableStringBuilder.append((CharSequence) "，");
                spannableStringBuilder.append((CharSequence) string);
                spannableStringBuilder.append((CharSequence) getString(f.j.tip_or));
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
                    PersonListActivity.this.aWq();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(am.getColor(f.d.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.6
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.aWp();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(am.getColor(f.d.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWp() {
        TiebaStatic.log(new an("c13104").r("obj_locate", 1));
        if (!l.jV()) {
            showToast(getString(f.j.neterror));
        } else {
            this.fiX.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWq() {
        TiebaStatic.log(new an("c13103"));
        if (!l.jV()) {
            showToast(getString(f.j.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
