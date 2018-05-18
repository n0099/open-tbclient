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
    private ConcernSelectView eTC;
    private com.baidu.tieba.d.c eTD;
    private boolean eTz;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView eTr = null;
    private View eTs = null;
    private View eTt = null;
    private TextView eTu = null;
    private FrameLayout mFrameLayout = null;
    private View eTv = null;
    private TextView eTw = null;
    private ProgressBar mProgress = null;
    private b eTx = null;
    private NoPressedRelativeLayout eTy = null;
    private boolean bJC = true;
    private TextView mTitleText = null;
    private int eTA = 0;
    int eTB = 0;
    private final AntiHelper.a cZl = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.aje));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.aje));
        }
    };
    private CustomMessageListener brD = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aup != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().aup, PersonListActivity.this.cZl) != null) {
                            TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.aje));
                        }
                    } else if (updateAttentionMessage.getData().Ai && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), d.k.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener eTE = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.eTx.cC(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.eTx.aSq();
                    PersonListActivity.this.eTx.notifyDataSetChanged();
                }
            }
        }
    };
    public PersonListModel.a eTF = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.6
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void I(String str, boolean z) {
            if (!z) {
                if (PersonListActivity.this.mProgress.isShown()) {
                    PersonListActivity.this.mProgress.setVisibility(8);
                }
                if (!TextUtils.isEmpty(str)) {
                    PersonListActivity.this.showToast(str);
                }
                PersonListActivity.this.iN(false);
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
        registerListener(this.brD);
        registerListener(this.eTE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mModel.aSw();
        this.mModel.Pj();
        if (this.bJC) {
            this.bJC = false;
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
        getLayoutMode().u(this.eTy);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.eTx != null) {
            this.eTx.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.eTC.onChangeSkinType(i);
        ak.j(this.eTu, d.C0126d.cp_bg_line_d);
        ak.h(this.eTu, d.C0126d.cp_cont_d);
        ak.j(this.eTw, d.C0126d.cp_bg_line_d);
        ak.h(this.eTw, d.C0126d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.eTt != null) {
            getLayoutMode().u(this.eTt);
        }
        if (this.eTv != null) {
            getLayoutMode().u(this.eTv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eTx != null) {
            this.eTx = null;
        }
        if (this.eTD != null) {
            this.eTD.ahf();
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.eTF);
        if (bundle != null) {
            this.mModel.iO(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.eTA = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.eTA);
            return;
        }
        Intent intent = getIntent();
        this.mModel.iO(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.eTA = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.eTA);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aOv());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.eTA);
    }

    private void initUI() {
        boolean z = true;
        this.eTy = (NoPressedRelativeLayout) findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mTitleText = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.eTs = findViewById(d.g.sub_title_root);
        this.eTt = this.eTs.findViewById(d.g.newheader_root);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.framelayout);
        this.eTs.setVisibility(8);
        this.eTs.setClickable(false);
        this.eTs.setEnabled(false);
        this.eTu = (TextView) this.eTs.findViewById(d.g.person_list_title);
        this.eTC = (ConcernSelectView) findViewById(d.g.select_layout);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aOv()) {
                this.mTitleText.setText(d.k.my_attention);
                this.eTy.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void o(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.eTC.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.eTC.aSn() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.eTy.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.eTC.aSm();
                        PersonListActivity.this.eTy.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.mTitleText.setText(d.k.fans);
            }
        } else if (this.mModel.aOv()) {
            if (this.eTA == 2) {
                this.mTitleText.setText(d.k.her_attention_people);
            } else if (this.eTA == 1) {
                this.mTitleText.setText(d.k.his_attention_people);
            } else {
                this.mTitleText.setText(d.k.his_attention_people);
            }
        } else if (this.eTA == 2) {
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
                    if (PersonListActivity.this.eTx != null && PersonListActivity.this.eTx.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.eTx.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.aOv()) {
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
                PersonListActivity.this.eTB = ((Integer) view2.getTag()).intValue();
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
            this.eTx = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.eTs.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mFrameLayout, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getActivity(), d.e.ds120)), null, null);
        } else {
            this.eTx = new c(this, z, sex, onClickListener, onClickListener3);
            this.eTs.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.eTy, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getActivity(), d.e.ds320)), null, null);
        }
        this.eTr = (BdListView) findViewById(d.g.list);
        this.eTr.setAdapter((ListAdapter) this.eTx);
        aSr();
        this.eTr.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.eTx != null && PersonListActivity.this.eTx.isHasMore()) {
                    PersonListActivity.this.aSt();
                }
            }
        });
        this.eTC.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void iM(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aSs();
                } else if (PersonListActivity.this.eTD != null) {
                    PersonListActivity.this.eTD.ahf();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void lc(int i) {
                PersonListActivity.this.eTr.setSelection(0);
                PersonListActivity.this.mModel.gN(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.aOv()) {
            this.eTC.aSl();
        }
        this.eTC.setVisibility(8);
        this.eTv.setVisibility(8);
    }

    private void aSr() {
        this.eTv = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.person_list_newheader, (ViewGroup) null);
        this.eTv.setVisibility(8);
        this.eTv.setClickable(false);
        this.eTv.setEnabled(false);
        this.eTw = (TextView) this.eTv.findViewById(d.g.person_list_title);
        this.eTr.addHeaderView(this.eTv, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSs() {
        if (this.eTD == null) {
            this.eTD = new com.baidu.tieba.d.c(getPageContext(), this.eTC.eSW);
            this.eTD.jc(d.f.bg_tip_blue_up);
            this.eTD.je(2);
            this.eTD.jd(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
            this.eTD.jf(-10);
            this.eTD.jg(-16);
            this.eTD.j(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonListActivity.this.eTD != null) {
                        PersonListActivity.this.eTD.ahf();
                    }
                }
            });
        }
        this.eTD.h(getPageContext().getString(d.k.attention_menu_tip), "key_my_concerned_person_tip", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tbadk.core.data.ar arVar, boolean z) {
        if (this.mModel != null && arVar != null && (!z || !this.eTz)) {
            if (!z) {
                this.eTz = true;
                c(arVar);
            }
            c(arVar, z);
            if (!this.mModel.aOv()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.zw().setMsgFans(0);
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
                iN(z);
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
            this.eTr.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.aOv()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.eTs.setVisibility(0);
                    this.eTr.removeHeaderView(this.eTv);
                    TextView textView2 = this.eTu;
                    textView2.setVisibility(0);
                    this.eTC.setVisibility(0);
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
                    this.eTs.setVisibility(8);
                    this.eTv.setVisibility(0);
                    TextView textView3 = this.eTw;
                    textView3.setVisibility(8);
                    this.eTC.setVisibility(8);
                    if (this.eTA == 2) {
                        string3 = getPageContext().getString(d.k.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.her_no_attention_other));
                    } else if (this.eTA == 1) {
                        string3 = getPageContext().getString(d.k.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(d.k.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(d.k.person);
                    string = string3;
                    textView = textView3;
                    z = v.w(arVar.rh()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.eTs.setVisibility(8);
                this.eTv.setVisibility(0);
                textView = this.eTw;
                this.eTC.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(d.k.my_fans_prefix);
                    string2 = getPageContext().getString(d.k.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.not_have_fans));
                    z = false;
                } else if (this.eTA == 2) {
                    string = getPageContext().getString(d.k.her_fans_prefix);
                    string2 = getPageContext().getString(d.k.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.her_no_fan_other));
                    z = false;
                } else if (this.eTA == 1) {
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
    public void iN(boolean z) {
        String string;
        this.eTr.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.aOv()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.eTC.setVisibility(0);
                this.eTu.setVisibility(0);
                this.eTs.setVisibility(0);
                this.eTv.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(d.k.all_concerned);
                } else {
                    string = getPageContext().getString(d.k.each_concerned);
                }
                String string2 = getPageContext().getString(d.k.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(this.mModel.getLoadType() == 0 ? d.k.not_have_attention : d.k.not_have_each_attention));
                this.eTu.setText(string + 0 + string2);
                return;
            }
            this.eTC.setVisibility(8);
            this.eTu.setVisibility(8);
            if (this.eTA == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.her_no_attention_other));
                return;
            } else if (this.eTA == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.him_no_attention_other));
                return;
            }
        }
        this.eTC.setVisibility(8);
        this.eTu.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.not_have_fans));
        } else if (this.eTA == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.her_no_fan_other));
        } else if (this.eTA == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(d.k.him_no_fan_other));
        }
    }

    private void c(com.baidu.tbadk.core.data.ar arVar) {
        this.mModel.setPage(arVar.pageNum);
    }

    private void c(com.baidu.tbadk.core.data.ar arVar, boolean z) {
        if (this.eTx != null) {
            if (!z) {
                if (arVar.pageNum == 1) {
                    this.eTx.resetData();
                }
                this.eTx.setHasMore(arVar.hasMore);
                this.eTx.a(arVar);
                this.eTx.aSq();
                this.eTx.notifyDataSetChanged();
                return;
            }
            this.eTx.setHasMore(false);
            this.eTx.a(arVar);
            this.eTx.aSq();
            this.eTx.notifyDataSetChanged();
        }
    }

    private void acF() {
        this.mProgress.setVisibility(0);
        this.mModel.aSx();
        this.mModel.aSv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSt() {
        if (this.eTx != null) {
            this.eTx.notifyDataSetChanged();
        }
        this.mModel.aSv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSu() {
        UserData userData;
        if (this.eTx != null && this.eTx.getItemViewType(this.eTB) == 0 && (userData = (UserData) this.eTx.getItem(this.eTB)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            if (this.eTC.aSn()) {
                this.eTC.aSm();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
