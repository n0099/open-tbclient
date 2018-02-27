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
    private boolean fxv;
    private ConcernSelectView fxy;
    private com.baidu.tieba.d.c fxz;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private BdListView fxn = null;
    private View fxo = null;
    private View fxp = null;
    private TextView fxq = null;
    private FrameLayout mFrameLayout = null;
    private View fxr = null;
    private TextView fxs = null;
    private ProgressBar mProgress = null;
    private b fxt = null;
    private NoPressedRelativeLayout fxu = null;
    private boolean csf = true;
    private TextView mTitleText = null;
    private int fxw = 0;
    int fxx = 0;
    private final AntiHelper.a dFi = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXy));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXy));
        }
    };
    private CustomMessageListener chh = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().biH != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().biH, PersonListActivity.this.dFi) != null) {
                            TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXy));
                        }
                    } else if (updateAttentionMessage.getData().apG && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    public PersonListModel.a fxA = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void M(String str, boolean z) {
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
        registerListener(this.chh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mModel.aXA();
        this.mModel.WL();
        if (this.csf) {
            this.csf = false;
            aiy();
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
        getLayoutMode().aM(this.fxu);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.fxt != null) {
            this.fxt.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fxy.onChangeSkinType(i);
        aj.t(this.fxq, d.C0141d.cp_bg_line_d);
        aj.r(this.fxq, d.C0141d.cp_cont_d);
        aj.t(this.fxs, d.C0141d.cp_bg_line_d);
        aj.r(this.fxs, d.C0141d.cp_cont_d);
        getLayoutMode().aQ(i == 1);
        if (this.fxp != null) {
            getLayoutMode().aM(this.fxp);
        }
        if (this.fxr != null) {
            getLayoutMode().aM(this.fxr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fxt != null) {
            this.fxt = null;
        }
        if (this.fxz != null) {
            this.fxz.ang();
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.fxA);
        if (bundle != null) {
            this.mModel.jm(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.fxw = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.fxw);
            return;
        }
        Intent intent = getIntent();
        this.mModel.jm(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.fxw = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.fxw);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aTz());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.fxw);
    }

    private void initUI() {
        boolean z = true;
        this.fxu = (NoPressedRelativeLayout) findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mTitleText = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.fxo = findViewById(d.g.sub_title_root);
        this.fxp = this.fxo.findViewById(d.g.newheader_root);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.framelayout);
        this.fxo.setVisibility(8);
        this.fxo.setClickable(false);
        this.fxo.setEnabled(false);
        this.fxq = (TextView) this.fxo.findViewById(d.g.person_list_title);
        this.fxy = (ConcernSelectView) findViewById(d.g.select_layout);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aTz()) {
                this.mTitleText.setText(d.j.my_attention);
                this.fxu.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void w(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.fxy.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.fxy.aXr() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.fxu.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.fxy.aXq();
                        PersonListActivity.this.fxu.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.mTitleText.setText(d.j.fans);
            }
        } else if (this.mModel.aTz()) {
            if (this.fxw == 2) {
                this.mTitleText.setText(d.j.her_attention_people);
            } else if (this.fxw == 1) {
                this.mTitleText.setText(d.j.his_attention_people);
            } else {
                this.mTitleText.setText(d.j.his_attention_people);
            }
        } else if (this.fxw == 2) {
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
                    if (PersonListActivity.this.fxt != null && PersonListActivity.this.fxt.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.fxt.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.aTz()) {
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
                PersonListActivity.this.fxx = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.aXy();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) PersonListActivity.this.getPageContext().getPageActivity(), PersonListActivity.this.getPageContext().getString(d.j.login_to_chat), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.aXx();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.fxt = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.fxo.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mFrameLayout, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(getActivity(), d.e.ds120)), null, null);
        } else {
            this.fxt = new c(this, z, sex, onClickListener, onClickListener3);
            this.fxo.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.fxu, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(getActivity(), d.e.ds320)), null, null);
        }
        this.fxn = (BdListView) findViewById(d.g.list);
        this.fxn.setAdapter((ListAdapter) this.fxt);
        aXv();
        this.fxn.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.fxt != null && PersonListActivity.this.fxt.isHasMore()) {
                    PersonListActivity.this.aXx();
                }
            }
        });
        this.fxy.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void jk(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aXw();
                } else if (PersonListActivity.this.fxz != null) {
                    PersonListActivity.this.fxz.ang();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void sm(int i) {
                PersonListActivity.this.fxn.setSelection(0);
                PersonListActivity.this.mModel.jI(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.aTz()) {
            this.fxy.aXp();
        }
        this.fxy.setVisibility(8);
        this.fxr.setVisibility(8);
    }

    private void aXv() {
        this.fxr = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.person_list_newheader, (ViewGroup) null);
        this.fxr.setVisibility(8);
        this.fxr.setClickable(false);
        this.fxr.setEnabled(false);
        this.fxs = (TextView) this.fxr.findViewById(d.g.person_list_title);
        this.fxn.addHeaderView(this.fxr, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXw() {
        if (this.fxz == null) {
            this.fxz = new com.baidu.tieba.d.c(getPageContext(), this.fxy.fwS);
            this.fxz.lS(d.f.bg_tip_blue_up);
            this.fxz.lU(2);
            this.fxz.lT(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
            this.fxz.lV(-10);
            this.fxz.lW(-16);
            this.fxz.j(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.fxz != null) {
                        PersonListActivity.this.fxz.ang();
                    }
                }
            });
        }
        this.fxz.g(getPageContext().getString(d.j.attention_menu_tip), "key_my_concerned_person_tip", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tbadk.core.data.aq aqVar, boolean z) {
        if (this.mModel != null && aqVar != null && (!z || !this.fxv)) {
            if (!z) {
                this.fxv = true;
                c(aqVar);
            }
            c(aqVar, z);
            if (!this.mModel.aTz()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.GI().setMsgFans(0);
            }
            b(aqVar, z);
        }
    }

    private void b(com.baidu.tbadk.core.data.aq aqVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            if (this.mModel.getPage() == 1) {
                this.mProgress.setVisibility(8);
            }
            if (aqVar.aNE > 0) {
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
            this.fxn.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.aTz()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fxo.setVisibility(0);
                    this.fxn.removeHeaderView(this.fxr);
                    TextView textView2 = this.fxq;
                    textView2.setVisibility(0);
                    this.fxy.setVisibility(0);
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
                    this.fxo.setVisibility(8);
                    this.fxr.setVisibility(0);
                    TextView textView3 = this.fxs;
                    textView3.setVisibility(8);
                    this.fxy.setVisibility(8);
                    if (this.fxw == 2) {
                        string3 = getPageContext().getString(d.j.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.her_no_attention_other));
                    } else if (this.fxw == 1) {
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
                this.fxo.setVisibility(8);
                this.fxr.setVisibility(0);
                textView = this.fxs;
                this.fxy.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(d.j.my_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.not_have_fans));
                    z = false;
                } else if (this.fxw == 2) {
                    string = getPageContext().getString(d.j.her_fans_prefix);
                    string2 = getPageContext().getString(d.j.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.her_no_fan_other));
                    z = false;
                } else if (this.fxw == 1) {
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
            textView.setText(string + am.C(aqVar.aNE) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jl(boolean z) {
        String string;
        this.fxn.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.aTz()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fxy.setVisibility(0);
                this.fxq.setVisibility(0);
                this.fxo.setVisibility(0);
                this.fxr.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(d.j.all_concerned);
                } else {
                    string = getPageContext().getString(d.j.each_concerned);
                }
                String string2 = getPageContext().getString(d.j.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(this.mModel.getLoadType() == 0 ? d.j.not_have_attention : d.j.not_have_each_attention));
                this.fxq.setText(string + 0 + string2);
                return;
            }
            this.fxy.setVisibility(8);
            this.fxq.setVisibility(8);
            if (this.fxw == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.her_no_attention_other));
                return;
            } else if (this.fxw == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_attention_other));
                return;
            }
        }
        this.fxy.setVisibility(8);
        this.fxq.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.not_have_fans));
        } else if (this.fxw == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.her_no_fan_other));
        } else if (this.fxw == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.him_no_fan_other));
        }
    }

    private void c(com.baidu.tbadk.core.data.aq aqVar) {
        this.mModel.setPage(aqVar.pageNum);
    }

    private void c(com.baidu.tbadk.core.data.aq aqVar, boolean z) {
        if (this.fxt != null) {
            if (!z) {
                if (aqVar.pageNum == 1) {
                    this.fxt.resetData();
                }
                this.fxt.setHasMore(aqVar.hasMore);
                this.fxt.a(aqVar);
                this.fxt.aXu();
                this.fxt.notifyDataSetChanged();
                return;
            }
            this.fxt.setHasMore(false);
            this.fxt.a(aqVar);
            this.fxt.aXu();
            this.fxt.notifyDataSetChanged();
        }
    }

    private void aiy() {
        this.mProgress.setVisibility(0);
        this.mModel.aXB();
        this.mModel.aXz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXx() {
        if (this.fxt != null) {
            this.fxt.notifyDataSetChanged();
        }
        this.mModel.aXz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXy() {
        UserData userData;
        if (this.fxt != null && this.fxt.getItemViewType(this.fxx) == 0 && (userData = (UserData) this.fxt.getItem(this.fxx)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            aXy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fxy.aXr()) {
                this.fxy.aXq();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
