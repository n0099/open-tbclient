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
    private boolean fxH;
    private ConcernSelectView fxK;
    private com.baidu.tieba.d.c fxL;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private BdListView fxz = null;
    private View fxA = null;
    private View fxB = null;
    private TextView fxC = null;
    private FrameLayout mFrameLayout = null;
    private View fxD = null;
    private TextView fxE = null;
    private ProgressBar mProgress = null;
    private b fxF = null;
    private NoPressedRelativeLayout fxG = null;
    private boolean csr = true;
    private TextView mTitleText = null;
    private int fxI = 0;
    int fxJ = 0;
    private final AntiHelper.a dFu = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXK));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXK));
        }
    };
    private CustomMessageListener cht = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().biU != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().biU, PersonListActivity.this.dFu) != null) {
                            TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXK));
                        }
                    } else if (updateAttentionMessage.getData().apP && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    public PersonListModel.a fxM = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void N(String str, boolean z) {
            if (!z) {
                if (PersonListActivity.this.mProgress.isShown()) {
                    PersonListActivity.this.mProgress.setVisibility(8);
                }
                if (!TextUtils.isEmpty(str)) {
                    PersonListActivity.this.showToast(str);
                }
                PersonListActivity.this.jl(false);
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
        registerListener(this.cht);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mModel.aXB();
        this.mModel.WM();
        if (this.csr) {
            this.csr = false;
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
        getLayoutMode().aM(this.fxG);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.fxF != null) {
            this.fxF.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fxK.onChangeSkinType(i);
        aj.t(this.fxC, d.C0140d.cp_bg_line_d);
        aj.r(this.fxC, d.C0140d.cp_cont_d);
        aj.t(this.fxE, d.C0140d.cp_bg_line_d);
        aj.r(this.fxE, d.C0140d.cp_cont_d);
        getLayoutMode().aQ(i == 1);
        if (this.fxB != null) {
            getLayoutMode().aM(this.fxB);
        }
        if (this.fxD != null) {
            getLayoutMode().aM(this.fxD);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fxF != null) {
            this.fxF = null;
        }
        if (this.fxL != null) {
            this.fxL.anh();
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.fxM);
        if (bundle != null) {
            this.mModel.jm(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fxI = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.fxI);
            return;
        }
        Intent intent = getIntent();
        this.mModel.jm(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fxI = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.fxI);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aTA());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.fxI);
    }

    private void initUI() {
        boolean z = true;
        this.fxG = (NoPressedRelativeLayout) findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mTitleText = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.fxA = findViewById(d.g.sub_title_root);
        this.fxB = this.fxA.findViewById(d.g.newheader_root);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.framelayout);
        this.fxA.setVisibility(8);
        this.fxA.setClickable(false);
        this.fxA.setEnabled(false);
        this.fxC = (TextView) this.fxA.findViewById(d.g.person_list_title);
        this.fxK = (ConcernSelectView) findViewById(d.g.select_layout);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aTA()) {
                this.mTitleText.setText(d.j.my_attention);
                this.fxG.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void w(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.fxK.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.fxK.aXs() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.fxG.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.fxK.aXr();
                        PersonListActivity.this.fxG.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.mTitleText.setText(d.j.fans);
            }
        } else if (this.mModel.aTA()) {
            if (this.fxI == 2) {
                this.mTitleText.setText(d.j.her_attention_people);
            } else if (this.fxI == 1) {
                this.mTitleText.setText(d.j.his_attention_people);
            } else {
                this.mTitleText.setText(d.j.his_attention_people);
            }
        } else if (this.fxI == 2) {
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
                    if (PersonListActivity.this.fxF != null && PersonListActivity.this.fxF.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.fxF.getItem(intValue)) != null && userData.getUserId() != null) {
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
                PersonListActivity.this.fxJ = ((Integer) view.getTag()).intValue();
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
            this.fxF = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.fxA.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mFrameLayout, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(getActivity(), d.e.ds120)), null, null);
        } else {
            this.fxF = new c(this, z, sex, onClickListener, onClickListener3);
            this.fxA.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fxG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(getActivity(), d.e.ds320)), null, null);
        }
        this.fxz = (BdListView) findViewById(d.g.list);
        this.fxz.setAdapter((ListAdapter) this.fxF);
        aXw();
        this.fxz.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.fxF != null && PersonListActivity.this.fxF.isHasMore()) {
                    PersonListActivity.this.aXy();
                }
            }
        });
        this.fxK.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void jk(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aXx();
                } else if (PersonListActivity.this.fxL != null) {
                    PersonListActivity.this.fxL.anh();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void sl(int i) {
                PersonListActivity.this.fxz.setSelection(0);
                PersonListActivity.this.mModel.jI(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.aTA()) {
            this.fxK.aXq();
        }
        this.fxK.setVisibility(8);
        this.fxD.setVisibility(8);
    }

    private void aXw() {
        this.fxD = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.person_list_newheader, (ViewGroup) null);
        this.fxD.setVisibility(8);
        this.fxD.setClickable(false);
        this.fxD.setEnabled(false);
        this.fxE = (TextView) this.fxD.findViewById(d.g.person_list_title);
        this.fxz.addHeaderView(this.fxD, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXx() {
        if (this.fxL == null) {
            this.fxL = new com.baidu.tieba.d.c(getPageContext(), this.fxK.fxe);
            this.fxL.lS(d.f.bg_tip_blue_up);
            this.fxL.lU(2);
            this.fxL.lT(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
            this.fxL.lV(-10);
            this.fxL.lW(-16);
            this.fxL.j(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.fxL != null) {
                        PersonListActivity.this.fxL.anh();
                    }
                }
            });
        }
        this.fxL.g(getPageContext().getString(d.j.attention_menu_tip), "key_my_concerned_person_tip", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tbadk.core.data.aq aqVar, boolean z) {
        if (this.mModel != null && aqVar != null && (!z || !this.fxH)) {
            if (!z) {
                this.fxH = true;
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
            if (aqVar.aNP > 0) {
                b(aqVar);
            } else {
                jl(z);
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
            this.fxz.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.aTA()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fxA.setVisibility(0);
                    this.fxz.removeHeaderView(this.fxD);
                    TextView textView2 = this.fxC;
                    textView2.setVisibility(0);
                    this.fxK.setVisibility(0);
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
                    this.fxA.setVisibility(8);
                    this.fxD.setVisibility(0);
                    TextView textView3 = this.fxE;
                    textView3.setVisibility(8);
                    this.fxK.setVisibility(8);
                    if (this.fxI == 2) {
                        string3 = getPageContext().getString(d.j.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.her_no_attention_other));
                    } else if (this.fxI == 1) {
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
                this.fxA.setVisibility(8);
                this.fxD.setVisibility(0);
                textView = this.fxE;
                this.fxK.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(d.j.my_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.not_have_fans));
                    z = false;
                } else if (this.fxI == 2) {
                    string = getPageContext().getString(d.j.her_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.her_no_fan_other));
                    z = false;
                } else if (this.fxI == 1) {
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
            textView.setText(string + am.C(aqVar.aNP) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jl(boolean z) {
        String string;
        this.fxz.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.aTA()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fxK.setVisibility(0);
                this.fxC.setVisibility(0);
                this.fxA.setVisibility(0);
                this.fxD.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(d.j.all_concerned);
                } else {
                    string = getPageContext().getString(d.j.each_concerned);
                }
                String string2 = getPageContext().getString(d.j.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(this.mModel.getLoadType() == 0 ? d.j.not_have_attention : d.j.not_have_each_attention));
                this.fxC.setText(string + 0 + string2);
                return;
            }
            this.fxK.setVisibility(8);
            this.fxC.setVisibility(8);
            if (this.fxI == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.her_no_attention_other));
                return;
            } else if (this.fxI == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_attention_other));
                return;
            }
        }
        this.fxK.setVisibility(8);
        this.fxC.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.not_have_fans));
        } else if (this.fxI == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.her_no_fan_other));
        } else if (this.fxI == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_fan_other));
        }
    }

    private void c(com.baidu.tbadk.core.data.aq aqVar) {
        this.mModel.setPage(aqVar.pageNum);
    }

    private void c(com.baidu.tbadk.core.data.aq aqVar, boolean z) {
        if (this.fxF != null) {
            if (!z) {
                if (aqVar.pageNum == 1) {
                    this.fxF.resetData();
                }
                this.fxF.setHasMore(aqVar.hasMore);
                this.fxF.a(aqVar);
                this.fxF.aXv();
                this.fxF.notifyDataSetChanged();
                return;
            }
            this.fxF.setHasMore(false);
            this.fxF.a(aqVar);
            this.fxF.aXv();
            this.fxF.notifyDataSetChanged();
        }
    }

    private void aiz() {
        this.mProgress.setVisibility(0);
        this.mModel.aXC();
        this.mModel.aXA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXy() {
        if (this.fxF != null) {
            this.fxF.notifyDataSetChanged();
        }
        this.mModel.aXA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXz() {
        UserData userData;
        if (this.fxF != null && this.fxF.getItemViewType(this.fxJ) == 0 && (userData = (UserData) this.fxF.getItem(this.fxJ)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            if (this.fxK.aXs()) {
                this.fxK.aXr();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
