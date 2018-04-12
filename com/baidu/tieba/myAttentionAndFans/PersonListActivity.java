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
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes3.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private boolean eSv;
    private ConcernSelectView eSy;
    private com.baidu.tieba.d.c eSz;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView eSn = null;
    private View eSo = null;
    private View eSp = null;
    private TextView eSq = null;
    private FrameLayout mFrameLayout = null;
    private View eSr = null;
    private TextView eSs = null;
    private ProgressBar mProgress = null;
    private b eSt = null;
    private NoPressedRelativeLayout eSu = null;
    private boolean bIr = true;
    private TextView mTitleText = null;
    private int eSw = 0;
    int eSx = 0;
    private final AntiHelper.a cYh = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.aje));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.aje));
        }
    };
    private CustomMessageListener bro = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().auo != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().auo, PersonListActivity.this.cYh) != null) {
                            TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.aje));
                        }
                    } else if (updateAttentionMessage.getData().Aj && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), d.k.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener eSA = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.eSt.cC(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.eSt.aSq();
                    PersonListActivity.this.eSt.notifyDataSetChanged();
                }
            }
        }
    };
    public PersonListModel.a eSB = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.6
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void I(String str, boolean z) {
            if (!z) {
                if (PersonListActivity.this.mProgress.isShown()) {
                    PersonListActivity.this.mProgress.setVisibility(8);
                }
                if (!TextUtils.isEmpty(str)) {
                    PersonListActivity.this.showToast(str);
                }
                PersonListActivity.this.iM(false);
            }
        }

        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public com.baidu.tbadk.core.data.ar d(com.baidu.tbadk.core.data.ar arVar, boolean z) {
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
        registerListener(this.bro);
        registerListener(this.eSA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mModel.aSw();
        this.mModel.Pm();
        if (this.bIr) {
            this.bIr = false;
            acF();
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
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().u(this.eSu);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.eSt != null) {
            this.eSt.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.eSy.onChangeSkinType(i);
        ak.j(this.eSq, d.C0126d.cp_bg_line_d);
        ak.h(this.eSq, d.C0126d.cp_cont_d);
        ak.j(this.eSs, d.C0126d.cp_bg_line_d);
        ak.h(this.eSs, d.C0126d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.eSp != null) {
            getLayoutMode().u(this.eSp);
        }
        if (this.eSr != null) {
            getLayoutMode().u(this.eSr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eSt != null) {
            this.eSt = null;
        }
        if (this.eSz != null) {
            this.eSz.ahf();
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.eSB);
        if (bundle != null) {
            this.mModel.iN(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.eSw = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.eSw);
            return;
        }
        Intent intent = getIntent();
        this.mModel.iN(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.eSw = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.eSw);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aOw());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.eSw);
    }

    private void initUI() {
        boolean z = true;
        this.eSu = (NoPressedRelativeLayout) findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mTitleText = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.eSo = findViewById(d.g.sub_title_root);
        this.eSp = this.eSo.findViewById(d.g.newheader_root);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.framelayout);
        this.eSo.setVisibility(8);
        this.eSo.setClickable(false);
        this.eSo.setEnabled(false);
        this.eSq = (TextView) this.eSo.findViewById(d.g.person_list_title);
        this.eSy = (ConcernSelectView) findViewById(d.g.select_layout);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aOw()) {
                this.mTitleText.setText(d.k.my_attention);
                this.eSu.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void o(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.eSy.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.eSy.aSn() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.eSu.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.eSy.aSm();
                        PersonListActivity.this.eSu.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.mTitleText.setText(d.k.fans);
            }
        } else if (this.mModel.aOw()) {
            if (this.eSw == 2) {
                this.mTitleText.setText(d.k.her_attention_people);
            } else if (this.eSw == 1) {
                this.mTitleText.setText(d.k.his_attention_people);
            } else {
                this.mTitleText.setText(d.k.his_attention_people);
            }
        } else if (this.eSw == 2) {
            this.mTitleText.setText(d.k.attention_to_her);
        } else {
            this.mTitleText.setText(d.k.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                UserData userData;
                if (view2 != null && (view2.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view2.getTag()).intValue();
                    if (PersonListActivity.this.eSt != null && PersonListActivity.this.eSt.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.eSt.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.aOw()) {
                            TiebaStatic.log(new al("c12772").ac("obj_locate", "1").ac("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new al("c12605").r("obj_locate", 1).ac("obj_param1", userData.getUserId()));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.myAttentionAndFans.PersonListActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonListActivity.this.eSx = ((Integer) view2.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.aSu();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) PersonListActivity.this.getPageContext().getPageActivity(), PersonListActivity.this.getPageContext().getString(d.k.login_to_chat), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonListActivity.this.aSt();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.eSt = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.eSo.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mFrameLayout, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getActivity(), d.e.ds120)), null, null);
        } else {
            this.eSt = new c(this, z, sex, onClickListener, onClickListener3);
            this.eSo.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.eSu, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getActivity(), d.e.ds320)), null, null);
        }
        this.eSn = (BdListView) findViewById(d.g.list);
        this.eSn.setAdapter((ListAdapter) this.eSt);
        aSr();
        this.eSn.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.eSt != null && PersonListActivity.this.eSt.isHasMore()) {
                    PersonListActivity.this.aSt();
                }
            }
        });
        this.eSy.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void iL(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aSs();
                } else if (PersonListActivity.this.eSz != null) {
                    PersonListActivity.this.eSz.ahf();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void le(int i) {
                PersonListActivity.this.eSn.setSelection(0);
                PersonListActivity.this.mModel.gN(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.aOw()) {
            this.eSy.aSl();
        }
        this.eSy.setVisibility(8);
        this.eSr.setVisibility(8);
    }

    private void aSr() {
        this.eSr = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.person_list_newheader, (ViewGroup) null);
        this.eSr.setVisibility(8);
        this.eSr.setClickable(false);
        this.eSr.setEnabled(false);
        this.eSs = (TextView) this.eSr.findViewById(d.g.person_list_title);
        this.eSn.addHeaderView(this.eSr, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSs() {
        if (this.eSz == null) {
            this.eSz = new com.baidu.tieba.d.c(getPageContext(), this.eSy.eRS);
            this.eSz.je(d.f.bg_tip_blue_up);
            this.eSz.jg(2);
            this.eSz.jf(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
            this.eSz.jh(-10);
            this.eSz.ji(-16);
            this.eSz.j(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonListActivity.this.eSz != null) {
                        PersonListActivity.this.eSz.ahf();
                    }
                }
            });
        }
        this.eSz.h(getPageContext().getString(d.k.attention_menu_tip), "key_my_concerned_person_tip", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tbadk.core.data.ar arVar, boolean z) {
        if (this.mModel != null && arVar != null && (!z || !this.eSv)) {
            if (!z) {
                this.eSv = true;
                c(arVar);
            }
            c(arVar, z);
            if (!this.mModel.aOw()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgFans(0);
            }
            b(arVar, z);
        }
    }

    private void b(com.baidu.tbadk.core.data.ar arVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            if (this.mModel.getPage() == 1) {
                this.mProgress.setVisibility(8);
            }
            if (arVar.Zg > 0) {
                b(arVar);
            } else {
                iM(z);
            }
        }
    }

    private void b(com.baidu.tbadk.core.data.ar arVar) {
        TextView textView;
        String string;
        String string2;
        boolean z;
        String string3;
        String string4;
        if (arVar != null) {
            this.eSn.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.aOw()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.eSo.setVisibility(0);
                    this.eSn.removeHeaderView(this.eSr);
                    TextView textView2 = this.eSq;
                    textView2.setVisibility(0);
                    this.eSy.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(d.k.all_concerned);
                    } else {
                        string4 = getPageContext().getString(d.k.each_concerned);
                    }
                    String string5 = getPageContext().getString(d.k.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.eSo.setVisibility(8);
                    this.eSr.setVisibility(0);
                    TextView textView3 = this.eSs;
                    textView3.setVisibility(8);
                    this.eSy.setVisibility(8);
                    if (this.eSw == 2) {
                        string3 = getPageContext().getString(d.k.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.her_no_attention_other));
                    } else if (this.eSw == 1) {
                        string3 = getPageContext().getString(d.k.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(d.k.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(d.k.person);
                    string = string3;
                    textView = textView3;
                    z = v.w(arVar.ri()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.eSo.setVisibility(8);
                this.eSr.setVisibility(0);
                textView = this.eSs;
                this.eSy.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(d.k.my_fans_prefix);
                    string2 = getPageContext().getString(d.k.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.not_have_fans));
                    z = false;
                } else if (this.eSw == 2) {
                    string = getPageContext().getString(d.k.her_fans_prefix);
                    string2 = getPageContext().getString(d.k.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.her_no_fan_other));
                    z = false;
                } else if (this.eSw == 1) {
                    string = getPageContext().getString(d.k.his_fans_prefix);
                    string2 = getPageContext().getString(d.k.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(d.k.his_fans_prefix);
                    string2 = getPageContext().getString(d.k.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(d.k.we_common_fans));
                return;
            }
            textView.setText(string + an.v(arVar.Zg) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iM(boolean z) {
        String string;
        this.eSn.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.aOw()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.eSy.setVisibility(0);
                this.eSq.setVisibility(0);
                this.eSo.setVisibility(0);
                this.eSr.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(d.k.all_concerned);
                } else {
                    string = getPageContext().getString(d.k.each_concerned);
                }
                String string2 = getPageContext().getString(d.k.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(this.mModel.getLoadType() == 0 ? d.k.not_have_attention : d.k.not_have_each_attention));
                this.eSq.setText(string + 0 + string2);
                return;
            }
            this.eSy.setVisibility(8);
            this.eSq.setVisibility(8);
            if (this.eSw == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.her_no_attention_other));
                return;
            } else if (this.eSw == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.him_no_attention_other));
                return;
            }
        }
        this.eSy.setVisibility(8);
        this.eSq.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.not_have_fans));
        } else if (this.eSw == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.her_no_fan_other));
        } else if (this.eSw == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.him_no_fan_other));
        }
    }

    private void c(com.baidu.tbadk.core.data.ar arVar) {
        this.mModel.setPage(arVar.pageNum);
    }

    private void c(com.baidu.tbadk.core.data.ar arVar, boolean z) {
        if (this.eSt != null) {
            if (!z) {
                if (arVar.pageNum == 1) {
                    this.eSt.resetData();
                }
                this.eSt.setHasMore(arVar.hasMore);
                this.eSt.a(arVar);
                this.eSt.aSq();
                this.eSt.notifyDataSetChanged();
                return;
            }
            this.eSt.setHasMore(false);
            this.eSt.a(arVar);
            this.eSt.aSq();
            this.eSt.notifyDataSetChanged();
        }
    }

    private void acF() {
        this.mProgress.setVisibility(0);
        this.mModel.aSx();
        this.mModel.aSv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSt() {
        if (this.eSt != null) {
            this.eSt.notifyDataSetChanged();
        }
        this.mModel.aSv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSu() {
        UserData userData;
        if (this.eSt != null && this.eSt.getItemViewType(this.eSx) == 0 && (userData = (UserData) this.eSt.getItem(this.eSx)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            aSu();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eSy.aSn()) {
                this.eSy.aSm();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
