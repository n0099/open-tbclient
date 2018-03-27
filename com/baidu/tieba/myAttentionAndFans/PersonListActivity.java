package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes3.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private boolean fxL;
    private ConcernSelectView fxO;
    private com.baidu.tieba.d.c fxP;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private BdListView fxD = null;
    private View fxE = null;
    private View fxF = null;
    private TextView fxG = null;
    private FrameLayout mFrameLayout = null;
    private View fxH = null;
    private TextView fxI = null;
    private ProgressBar mProgress = null;
    private b fxJ = null;
    private NoPressedRelativeLayout fxK = null;
    private boolean csi = true;
    private TextView mTitleText = null;
    private int fxM = 0;
    int fxN = 0;
    private final AntiHelper.a dFl = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXA));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXA));
        }
    };
    private CustomMessageListener chk = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().biK != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().biK, PersonListActivity.this.dFl) != null) {
                            TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXA));
                        }
                    } else if (updateAttentionMessage.getData().apH && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    public PersonListModel.a fxQ = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void M(String str, boolean z) {
            if (!z) {
                if (PersonListActivity.this.mProgress.isShown()) {
                    PersonListActivity.this.mProgress.setVisibility(8);
                }
                if (!TextUtils.isEmpty(str)) {
                    PersonListActivity.this.showToast(str);
                }
                PersonListActivity.this.jq(false);
            }
        }

        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public com.baidu.tbadk.core.data.aq d(com.baidu.tbadk.core.data.aq aqVar, boolean z) {
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
        registerListener(this.chk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mModel.aXB();
        this.mModel.WM();
        if (this.csi) {
            this.csi = false;
            aiz();
        }
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
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.fxK);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.fxJ != null) {
            this.fxJ.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fxO.onChangeSkinType(i);
        aj.t(this.fxG, d.C0141d.cp_bg_line_d);
        aj.r(this.fxG, d.C0141d.cp_cont_d);
        aj.t(this.fxI, d.C0141d.cp_bg_line_d);
        aj.r(this.fxI, d.C0141d.cp_cont_d);
        getLayoutMode().aQ(i == 1);
        if (this.fxF != null) {
            getLayoutMode().aM(this.fxF);
        }
        if (this.fxH != null) {
            getLayoutMode().aM(this.fxH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fxJ != null) {
            this.fxJ = null;
        }
        if (this.fxP != null) {
            this.fxP.anh();
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.fxQ);
        if (bundle != null) {
            this.mModel.jr(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fxM = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.fxM);
            return;
        }
        Intent intent = getIntent();
        this.mModel.jr(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fxM = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.fxM);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aTA());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.fxM);
    }

    private void initUI() {
        boolean z = true;
        this.fxK = (NoPressedRelativeLayout) findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mTitleText = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.fxE = findViewById(d.g.sub_title_root);
        this.fxF = this.fxE.findViewById(d.g.newheader_root);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.framelayout);
        this.fxE.setVisibility(8);
        this.fxE.setClickable(false);
        this.fxE.setEnabled(false);
        this.fxG = (TextView) this.fxE.findViewById(d.g.person_list_title);
        this.fxO = (ConcernSelectView) findViewById(d.g.select_layout);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aTA()) {
                this.mTitleText.setText(d.j.my_attention);
                this.fxK.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void w(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.fxO.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.fxO.aXs() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.fxK.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.fxO.aXr();
                        PersonListActivity.this.fxK.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.mTitleText.setText(d.j.fans);
            }
        } else if (this.mModel.aTA()) {
            if (this.fxM == 2) {
                this.mTitleText.setText(d.j.her_attention_people);
            } else if (this.fxM == 1) {
                this.mTitleText.setText(d.j.his_attention_people);
            } else {
                this.mTitleText.setText(d.j.his_attention_people);
            }
        } else if (this.fxM == 2) {
            this.mTitleText.setText(d.j.attention_to_her);
        } else {
            this.mTitleText.setText(d.j.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.fxJ != null && PersonListActivity.this.fxJ.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.fxJ.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.aTA()) {
                            TiebaStatic.log(new ak("c12772").ab("obj_locate", "1").ab("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new ak("c12605").s("obj_locate", 1).ab("obj_param1", userData.getUserId()));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.myAttentionAndFans.PersonListActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.fxN = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.aXz();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) PersonListActivity.this.getPageContext().getPageActivity(), PersonListActivity.this.getPageContext().getString(d.j.login_to_chat), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.aXy();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.fxJ = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.fxE.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mFrameLayout, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(getActivity(), d.e.ds120)), null, null);
        } else {
            this.fxJ = new c(this, z, sex, onClickListener, onClickListener3);
            this.fxE.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fxK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(getActivity(), d.e.ds320)), null, null);
        }
        this.fxD = (BdListView) findViewById(d.g.list);
        this.fxD.setAdapter((ListAdapter) this.fxJ);
        aXw();
        this.fxD.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.fxJ != null && PersonListActivity.this.fxJ.isHasMore()) {
                    PersonListActivity.this.aXy();
                }
            }
        });
        this.fxO.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void jp(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aXx();
                } else if (PersonListActivity.this.fxP != null) {
                    PersonListActivity.this.fxP.anh();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void sm(int i) {
                PersonListActivity.this.fxD.setSelection(0);
                PersonListActivity.this.mModel.jI(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.aTA()) {
            this.fxO.aXq();
        }
        this.fxO.setVisibility(8);
        this.fxH.setVisibility(8);
    }

    private void aXw() {
        this.fxH = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.person_list_newheader, (ViewGroup) null);
        this.fxH.setVisibility(8);
        this.fxH.setClickable(false);
        this.fxH.setEnabled(false);
        this.fxI = (TextView) this.fxH.findViewById(d.g.person_list_title);
        this.fxD.addHeaderView(this.fxH, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXx() {
        if (this.fxP == null) {
            this.fxP = new com.baidu.tieba.d.c(getPageContext(), this.fxO.fxi);
            this.fxP.lS(d.f.bg_tip_blue_up);
            this.fxP.lU(2);
            this.fxP.lT(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
            this.fxP.lV(-10);
            this.fxP.lW(-16);
            this.fxP.j(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.fxP != null) {
                        PersonListActivity.this.fxP.anh();
                    }
                }
            });
        }
        this.fxP.g(getPageContext().getString(d.j.attention_menu_tip), "key_my_concerned_person_tip", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tbadk.core.data.aq aqVar, boolean z) {
        if (this.mModel != null && aqVar != null && (!z || !this.fxL)) {
            if (!z) {
                this.fxL = true;
                c(aqVar);
            }
            c(aqVar, z);
            if (!this.mModel.aTA()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().setMsgFans(0);
            }
            b(aqVar, z);
        }
    }

    private void b(com.baidu.tbadk.core.data.aq aqVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            if (this.mModel.getPage() == 1) {
                this.mProgress.setVisibility(8);
            }
            if (aqVar.aNF > 0) {
                b(aqVar);
            } else {
                jq(z);
            }
        }
    }

    private void b(com.baidu.tbadk.core.data.aq aqVar) {
        TextView textView;
        String string;
        String string2;
        boolean z;
        String string3;
        String string4;
        if (aqVar != null) {
            this.fxD.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.aTA()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fxE.setVisibility(0);
                    this.fxD.removeHeaderView(this.fxH);
                    TextView textView2 = this.fxG;
                    textView2.setVisibility(0);
                    this.fxO.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(d.j.all_concerned);
                    } else {
                        string4 = getPageContext().getString(d.j.each_concerned);
                    }
                    String string5 = getPageContext().getString(d.j.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.fxE.setVisibility(8);
                    this.fxH.setVisibility(0);
                    TextView textView3 = this.fxI;
                    textView3.setVisibility(8);
                    this.fxO.setVisibility(8);
                    if (this.fxM == 2) {
                        string3 = getPageContext().getString(d.j.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.her_no_attention_other));
                    } else if (this.fxM == 1) {
                        string3 = getPageContext().getString(d.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(d.j.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(d.j.person);
                    string = string3;
                    textView = textView3;
                    z = v.E(aqVar.yC()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.fxE.setVisibility(8);
                this.fxH.setVisibility(0);
                textView = this.fxI;
                this.fxO.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(d.j.my_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.not_have_fans));
                    z = false;
                } else if (this.fxM == 2) {
                    string = getPageContext().getString(d.j.her_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.her_no_fan_other));
                    z = false;
                } else if (this.fxM == 1) {
                    string = getPageContext().getString(d.j.his_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(d.j.his_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(d.j.we_common_fans));
                return;
            }
            textView.setText(string + am.C(aqVar.aNF) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jq(boolean z) {
        String string;
        this.fxD.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.aTA()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fxO.setVisibility(0);
                this.fxG.setVisibility(0);
                this.fxE.setVisibility(0);
                this.fxH.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(d.j.all_concerned);
                } else {
                    string = getPageContext().getString(d.j.each_concerned);
                }
                String string2 = getPageContext().getString(d.j.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(this.mModel.getLoadType() == 0 ? d.j.not_have_attention : d.j.not_have_each_attention));
                this.fxG.setText(string + 0 + string2);
                return;
            }
            this.fxO.setVisibility(8);
            this.fxG.setVisibility(8);
            if (this.fxM == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.her_no_attention_other));
                return;
            } else if (this.fxM == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_attention_other));
                return;
            }
        }
        this.fxO.setVisibility(8);
        this.fxG.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.not_have_fans));
        } else if (this.fxM == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.her_no_fan_other));
        } else if (this.fxM == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_fan_other));
        }
    }

    private void c(com.baidu.tbadk.core.data.aq aqVar) {
        this.mModel.setPage(aqVar.pageNum);
    }

    private void c(com.baidu.tbadk.core.data.aq aqVar, boolean z) {
        if (this.fxJ != null) {
            if (!z) {
                if (aqVar.pageNum == 1) {
                    this.fxJ.resetData();
                }
                this.fxJ.setHasMore(aqVar.hasMore);
                this.fxJ.a(aqVar);
                this.fxJ.aXv();
                this.fxJ.notifyDataSetChanged();
                return;
            }
            this.fxJ.setHasMore(false);
            this.fxJ.a(aqVar);
            this.fxJ.aXv();
            this.fxJ.notifyDataSetChanged();
        }
    }

    private void aiz() {
        this.mProgress.setVisibility(0);
        this.mModel.aXC();
        this.mModel.aXA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXy() {
        if (this.fxJ != null) {
            this.fxJ.notifyDataSetChanged();
        }
        this.mModel.aXA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXz() {
        UserData userData;
        if (this.fxJ != null && this.fxJ.getItemViewType(this.fxN) == 0 && (userData = (UserData) this.fxJ.getItem(this.fxN)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "enter_chat", "personlistclick", 1, new Object[0]);
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getPortrait(), userData.getSex())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 11028) {
            aXz();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fxO.aXs()) {
                this.fxO.aXr();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
