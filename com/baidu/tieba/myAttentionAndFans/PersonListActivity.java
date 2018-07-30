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
import com.baidu.tieba.d;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes3.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView bvA;
    private TextView dhD;
    private NavigationBarCoverTip dhx;
    private boolean fiW;
    private ConcernSelectView fiZ;
    private com.baidu.tieba.c.d fja;
    private View fjb;
    private TextView fjc;
    private e fjd;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView fiO = null;
    private View fiP = null;
    private View fiQ = null;
    private TextView fiR = null;
    private View fiS = null;
    private TextView fiT = null;
    private b fiU = null;
    private NoPressedRelativeLayout fiV = null;
    private boolean bUF = true;
    private TextView cYc = null;
    private int fiX = 0;
    int fiY = 0;
    private final AntiHelper.a dnt = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arq));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arq));
        }
    };
    private CustomMessageListener bCp = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aDu != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().aDu, PersonListActivity.this.dnt) != null) {
                            TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arq));
                        }
                    } else if (updateAttentionMessage.getData().Gp && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener fje = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.fiU.cA(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.fiU.aWp();
                    PersonListActivity.this.fiU.notifyDataSetChanged();
                }
                if (PersonListActivity.this.fiU.fiD) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a fjf = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
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
        setContentView(d.h.person_list_activity);
        initData(bundle);
        initUI();
        this.fjd = new e(getPageContext(), getUniqueId());
        this.fjd.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.dhD == null) {
                            PersonListActivity.this.dhD = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.dhD.setGravity(19);
                            PersonListActivity.this.dhD.setPadding(l.f(PersonListActivity.this.getActivity(), d.e.ds34), 0, 0, 0);
                            PersonListActivity.this.dhD.setLayoutParams(new ViewGroup.LayoutParams(-1, l.f(PersonListActivity.this.getActivity(), d.e.tbds112)));
                            PersonListActivity.this.dhD.setTextSize(0, l.f(PersonListActivity.this.getActivity(), d.e.fontsize30));
                            PersonListActivity.this.dhD.setTextColor(PersonListActivity.this.getResources().getColor(d.C0140d.cp_cont_i));
                        }
                        PersonListActivity.this.dhD.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.dhx.setBackgroundColor(PersonListActivity.this.getResources().getColor(d.C0140d.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.dhx.setBackgroundColor(PersonListActivity.this.getResources().getColor(d.C0140d.nav_bar_tip_error));
                        }
                        PersonListActivity.this.dhx.a(PersonListActivity.this.getActivity(), PersonListActivity.this.dhD, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.fjc.setText(PersonListActivity.this.getString(d.j.no_more_data_tip));
                    am.h(PersonListActivity.this.fjc, d.C0140d.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void asM() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(d.j.remove_fans_loading));
            }
        });
        registerListener(this.bCp);
        registerListener(this.fje);
        this.mModel.Tl();
        if (this.bUF) {
            this.bUF = false;
            ahd();
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
        am.i(this.fiV, d.C0140d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.fiU != null) {
            this.fiU.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fiZ.onChangeSkinType(i);
        am.j(this.fiR, d.C0140d.cp_bg_line_d);
        am.h(this.fiR, d.C0140d.cp_cont_d);
        am.j(this.fiT, d.C0140d.cp_bg_line_d);
        am.h(this.fiT, d.C0140d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.fiQ != null) {
            getLayoutMode().onModeChanged(this.fiQ);
        }
        if (this.fiS != null) {
            getLayoutMode().onModeChanged(this.fiS);
        }
        if (this.fjb != null) {
            am.h(this.fjc, d.C0140d.cp_cont_d);
            am.j(this.fjb, d.C0140d.cp_bg_line_d);
        }
        this.fjd.onChangeSkinType();
        this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_d));
        this.bvA.dC(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fiU != null) {
            this.fiU = null;
        }
        if (this.fja != null) {
            this.fja.akM();
        }
        this.dhx.onDestroy();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.fjf);
        if (bundle != null) {
            this.mModel.iP(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fiX = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.fiX);
            return;
        }
        Intent intent = getIntent();
        this.mModel.iP(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fiX = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.fiX);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aWv());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.fiX);
    }

    private void initUI() {
        boolean z = true;
        this.fiV = (NoPressedRelativeLayout) findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.cYc = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fiP = findViewById(d.g.sub_title_root);
        this.fiQ = this.fiP.findViewById(d.g.newheader_root);
        this.fiP.setVisibility(8);
        this.fiP.setClickable(false);
        this.fiP.setEnabled(false);
        this.fiR = (TextView) this.fiP.findViewById(d.g.person_list_title);
        this.fiZ = (ConcernSelectView) findViewById(d.g.select_layout);
        this.dhx = (NavigationBarCoverTip) findViewById(d.g.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aWv()) {
                this.cYc.setText(d.j.my_attention);
                this.fiV.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void q(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.fiZ.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.fiZ.aWm() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.fiV.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.fiZ.aWl();
                        PersonListActivity.this.fiV.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.cYc.setText(d.j.fans);
            }
        } else if (this.mModel.aWv()) {
            if (this.fiX == 2) {
                this.cYc.setText(d.j.her_attention_people);
            } else if (this.fiX == 1) {
                this.cYc.setText(d.j.his_attention_people);
            } else {
                this.cYc.setText(d.j.his_attention_people);
            }
        } else if (this.fiX == 2) {
            this.cYc.setText(d.j.attention_to_her);
        } else {
            this.cYc.setText(d.j.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.fiU != null && PersonListActivity.this.fiU.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.fiU.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.aWv()) {
                            TiebaStatic.log(new an("c12772").af("obj_locate", "1").af("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new an("c12605").r("obj_locate", 1).af("obj_param1", userData.getUserId()));
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
                PersonListActivity.this.fiY = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.aWs();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.aWr();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.fiU = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.fiP.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fiV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), d.e.ds320)), null, null);
        } else {
            this.fiU = new c(this, z, sex, onClickListener, onClickListener3);
            this.fiP.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fiV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), d.e.ds320)), null, null);
        }
        this.fiO = (BdListView) findViewById(d.g.list);
        this.fiO.setAdapter((ListAdapter) this.fiU);
        aWq();
        this.fiO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.fiU != null && PersonListActivity.this.fiU.isHasMore()) {
                    if (PersonListActivity.this.bvA != null && !PersonListActivity.this.bvA.AE()) {
                        PersonListActivity.this.bvA.Ax();
                    }
                    PersonListActivity.this.aWr();
                }
            }
        });
        this.fiZ.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void iO(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aPY();
                } else if (PersonListActivity.this.fja != null) {
                    PersonListActivity.this.fja.akM();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void lB(int i) {
                PersonListActivity.this.fiO.setSelection(0);
                PersonListActivity.this.mModel.gT(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.aWv()) {
            this.fiZ.aWk();
        }
        this.fiZ.setVisibility(8);
        this.fiS.setVisibility(8);
        this.bvA = new PbListView(getActivity());
        this.bvA.getView();
        this.bvA.dB(d.C0140d.cp_bg_line_e);
        this.bvA.Au();
        this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_j));
        this.bvA.setTextSize(d.e.tbfontsize33);
        this.bvA.dA(d.C0140d.cp_cont_e);
        this.bvA.setHeight(l.f(getActivity(), d.e.tbds182));
        this.fiO.setNextPage(this.bvA);
    }

    private void aWq() {
        this.fiS = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.person_list_newheader, (ViewGroup) null);
        this.fiS.setVisibility(8);
        this.fiS.setClickable(false);
        this.fiS.setEnabled(false);
        this.fiT = (TextView) this.fiS.findViewById(d.g.person_list_title);
        this.fiO.addHeaderView(this.fiS, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPY() {
        if (this.fja == null) {
            this.fja = new com.baidu.tieba.c.d(getPageContext(), this.fiZ.fis);
            this.fja.jp(d.f.bg_tip_blue_up);
            this.fja.jr(2);
            this.fja.jq(3000);
            this.fja.js(-10);
            this.fja.jt(-16);
            this.fja.k(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.fja != null) {
                        PersonListActivity.this.fja.akM();
                    }
                }
            });
        }
        this.fja.g(getPageContext().getString(d.j.attention_menu_tip), "key_my_concerned_person_tip", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(aq aqVar, boolean z) {
        if (this.mModel != null && aqVar != null && (!z || !this.fiW)) {
            if (!z) {
                this.fiW = true;
                d(aqVar);
            }
            b(aqVar);
            d(aqVar, z);
            if (!this.mModel.aWv()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgFans(0);
            }
            b(aqVar, z);
        }
    }

    private void b(aq aqVar) {
        if (aqVar != null) {
            if (!aqVar.hasMore && !StringUtils.isNull(aqVar.agV)) {
                ay(aqVar.agV, aqVar.type);
                this.fiO.removeFooterView(this.fjb);
                this.fiO.addFooterView(this.fjb);
                this.fiO.removeFooterView(this.bvA.getView());
                TiebaStatic.log(new an("c13106").r("obj_locate", 2));
            } else if (!aqVar.hasMore) {
                this.fiO.removeFooterView(this.fjb);
                this.bvA.setText(getString(d.j.no_more_data_tip));
                this.bvA.Ay();
            } else {
                this.fiO.removeFooterView(this.fjb);
                this.bvA.setText(getString(d.j.pb_load_more));
                this.bvA.Ay();
            }
        }
    }

    private void b(aq aqVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (aqVar.agU > 0 && !w.z(aqVar.ux())) {
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
            this.fiO.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.aWv()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fiP.setVisibility(0);
                    this.fiO.removeHeaderView(this.fiS);
                    TextView textView2 = this.fiR;
                    textView2.setVisibility(0);
                    this.fiZ.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(d.j.all_concerned);
                    } else {
                        string4 = getPageContext().getString(d.j.each_concerned);
                    }
                    String string5 = getPageContext().getString(d.j.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.fiP.setVisibility(8);
                    this.fiS.setVisibility(0);
                    TextView textView3 = this.fiT;
                    textView3.setVisibility(8);
                    this.fiZ.setVisibility(8);
                    if (this.fiX == 2) {
                        string3 = getPageContext().getString(d.j.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.her_no_attention_other));
                    } else if (this.fiX == 1) {
                        string3 = getPageContext().getString(d.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(d.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(d.j.person);
                    string = string3;
                    textView = textView3;
                    z = w.z(aqVar.uy()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.fiP.setVisibility(8);
                this.fiS.setVisibility(0);
                textView = this.fiT;
                this.fiZ.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(d.j.my_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.not_have_fans));
                    z = false;
                } else if (this.fiX == 2) {
                    string = getPageContext().getString(d.j.her_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.her_no_fan_other));
                    z = false;
                } else if (this.fiX == 1) {
                    string = getPageContext().getString(d.j.his_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(d.j.his_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(d.j.we_common_fans));
                return;
            }
            textView.setText(string + ap.A(aqVar.agU) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(aq aqVar, boolean z) {
        String string;
        this.fiO.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.aWv()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fiZ.setVisibility(0);
                this.fiR.setVisibility(0);
                this.fiP.setVisibility(0);
                this.fiS.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(d.j.all_concerned);
                } else {
                    string = getPageContext().getString(d.j.each_concerned);
                }
                String string2 = getPageContext().getString(d.j.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.du(this.mModel.getLoadType() == 0 ? d.j.not_have_attention : d.j.not_have_each_attention));
                this.fiR.setText(string + 0 + string2);
                return;
            }
            this.fiZ.setVisibility(8);
            this.fiR.setVisibility(8);
            if (this.fiX == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.her_no_attention_other));
                return;
            } else if (this.fiX == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.him_no_attention_other));
                return;
            }
        }
        this.fiZ.setVisibility(8);
        this.fiR.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (aqVar != null && !StringUtils.isNull(aqVar.agV)) {
                this.mNoDataView.getSuTextView().setText(az(aqVar.agV, aqVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(d.C0140d.transparent));
                TiebaStatic.log(new an("c13106").r("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.not_have_fans));
        } else if (this.fiX == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.her_no_fan_other));
        } else if (this.fiX == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.him_no_fan_other));
        }
    }

    private void d(aq aqVar) {
        this.mModel.setPage(aqVar.pageNum);
    }

    private void d(aq aqVar, boolean z) {
        if (this.fiU != null) {
            if (!z) {
                if (aqVar.pageNum == 1) {
                    this.fiU.resetData();
                }
                this.fiU.setHasMore(aqVar.hasMore);
                this.fiU.a(aqVar);
                this.fiU.aWp();
                this.fiU.notifyDataSetChanged();
                return;
            }
            this.fiU.setHasMore(false);
            this.fiU.a(aqVar);
            this.fiU.aWp();
            this.fiU.notifyDataSetChanged();
        }
    }

    private void ahd() {
        showProgressBar(true, 0, 0);
        this.mModel.aWw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWr() {
        if (this.fiU != null) {
            this.fiU.notifyDataSetChanged();
        }
        this.mModel.aWw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWs() {
        UserData userData;
        if (this.fiU != null && this.fiU.getItemViewType(this.fiY) == 0 && (userData = (UserData) this.fiU.getItem(this.fiY)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            aWs();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fiZ.aWm()) {
                this.fiZ.aWl();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void ay(String str, int i) {
        if (this.fjb == null) {
            this.fjb = LayoutInflater.from(getActivity()).inflate(d.h.forbidden_tip_layout, (ViewGroup) null);
            this.fjc = (TextView) this.fjb.findViewById(d.g.view_forbidden_tip);
            am.h(this.fjc, d.C0140d.cp_cont_d);
            am.j(this.fjb, d.C0140d.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.fjb.setVisibility(8);
            return;
        }
        this.fjc.setText(az(str, i));
        this.fjc.setMovementMethod(LinkMovementMethod.getInstance());
        this.fjc.setHighlightColor(getResources().getColor(d.C0140d.transparent));
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
                    PersonListActivity.this.aWu();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(am.getColor(d.C0140d.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.6
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.aWt();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(am.getColor(d.C0140d.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWt() {
        TiebaStatic.log(new an("c13104").r("obj_locate", 1));
        if (!l.jV()) {
            showToast(getString(d.j.neterror));
        } else {
            this.fjd.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWu() {
        TiebaStatic.log(new an("c13103"));
        if (!l.jV()) {
            showToast(getString(d.j.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
