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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes3.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private boolean feR;
    private ConcernSelectView feU;
    private com.baidu.tieba.c.d feV;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView feJ = null;
    private View feK = null;
    private View feL = null;
    private TextView feM = null;
    private FrameLayout mFrameLayout = null;
    private View feN = null;
    private TextView feO = null;
    private ProgressBar mProgress = null;
    private b feP = null;
    private NoPressedRelativeLayout feQ = null;
    private boolean bRD = true;
    private TextView mTitleText = null;
    private int feS = 0;
    int feT = 0;
    private final AntiHelper.a diC = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").r("obj_locate", as.a.arm));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").r("obj_locate", as.a.arm));
        }
    };
    private CustomMessageListener bzI = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aCA != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().aCA, PersonListActivity.this.diC) != null) {
                            TiebaStatic.log(new am("c12534").r("obj_locate", as.a.arm));
                        }
                    } else if (updateAttentionMessage.getData().Gp && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), d.k.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener feW = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.feP.cI(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.feP.aXn();
                    PersonListActivity.this.feP.notifyDataSetChanged();
                }
            }
        }
    };
    public PersonListModel.a feX = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.6
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void I(String str, boolean z) {
            if (!z) {
                if (PersonListActivity.this.mProgress.isShown()) {
                    PersonListActivity.this.mProgress.setVisibility(8);
                }
                if (!TextUtils.isEmpty(str)) {
                    PersonListActivity.this.showToast(str);
                }
                PersonListActivity.this.iT(false);
            }
        }

        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public ar d(ar arVar, boolean z) {
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
        registerListener(this.bzI);
        registerListener(this.feW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mModel.aXs();
        this.mModel.SH();
        if (this.bRD) {
            this.bRD = false;
            agc();
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
        getLayoutMode().onModeChanged(this.feQ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.feP != null) {
            this.feP.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.feU.onChangeSkinType(i);
        al.j(this.feM, d.C0141d.cp_bg_line_d);
        al.h(this.feM, d.C0141d.cp_cont_d);
        al.j(this.feO, d.C0141d.cp_bg_line_d);
        al.h(this.feO, d.C0141d.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.feL != null) {
            getLayoutMode().onModeChanged(this.feL);
        }
        if (this.feN != null) {
            getLayoutMode().onModeChanged(this.feN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.feP != null) {
            this.feP = null;
        }
        if (this.feV != null) {
            this.feV.akT();
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.feX);
        if (bundle != null) {
            this.mModel.iU(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.feS = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.feS);
            return;
        }
        Intent intent = getIntent();
        this.mModel.iU(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.feS = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.feS);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aTr());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.feS);
    }

    private void initUI() {
        boolean z = true;
        this.feQ = (NoPressedRelativeLayout) findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mTitleText = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.feK = findViewById(d.g.sub_title_root);
        this.feL = this.feK.findViewById(d.g.newheader_root);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.framelayout);
        this.feK.setVisibility(8);
        this.feK.setClickable(false);
        this.feK.setEnabled(false);
        this.feM = (TextView) this.feK.findViewById(d.g.person_list_title);
        this.feU = (ConcernSelectView) findViewById(d.g.select_layout);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aTr()) {
                this.mTitleText.setText(d.k.my_attention);
                this.feQ.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void p(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.feU.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.feU.aXk() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.feQ.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.feU.aXj();
                        PersonListActivity.this.feQ.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.mTitleText.setText(d.k.fans);
            }
        } else if (this.mModel.aTr()) {
            if (this.feS == 2) {
                this.mTitleText.setText(d.k.her_attention_people);
            } else if (this.feS == 1) {
                this.mTitleText.setText(d.k.his_attention_people);
            } else {
                this.mTitleText.setText(d.k.his_attention_people);
            }
        } else if (this.feS == 2) {
            this.mTitleText.setText(d.k.attention_to_her);
        } else {
            this.mTitleText.setText(d.k.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.feP != null && PersonListActivity.this.feP.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.feP.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.aTr()) {
                            TiebaStatic.log(new am("c12772").ah("obj_locate", "1").ah("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new am("c12605").r("obj_locate", 1).ah("obj_param1", userData.getUserId()));
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
            public void onClick(View view) {
                PersonListActivity.this.feT = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.aXq();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) PersonListActivity.this.getPageContext().getPageActivity(), PersonListActivity.this.getPageContext().getString(d.k.login_to_chat), true, 11028)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.aXp();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false)) {
            this.feP = new d(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.feK.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mFrameLayout, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getActivity(), d.e.ds120)), null, null);
        } else {
            this.feP = new c(this, z, sex, onClickListener, onClickListener3);
            this.feK.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.feQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getActivity(), d.e.ds320)), null, null);
        }
        this.feJ = (BdListView) findViewById(d.g.list);
        this.feJ.setAdapter((ListAdapter) this.feP);
        aXo();
        this.feJ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.feP != null && PersonListActivity.this.feP.isHasMore()) {
                    PersonListActivity.this.aXp();
                }
            }
        });
        this.feU.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void iS(boolean z2) {
                if (z2) {
                    PersonListActivity.this.aOs();
                } else if (PersonListActivity.this.feV != null) {
                    PersonListActivity.this.feV.akT();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void lj(int i) {
                PersonListActivity.this.feJ.setSelection(0);
                PersonListActivity.this.mModel.gO(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_my_concerned_person_tip", 0) < 2 && z && this.mModel.aTr()) {
            this.feU.aXi();
        }
        this.feU.setVisibility(8);
        this.feN.setVisibility(8);
    }

    private void aXo() {
        this.feN = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.person_list_newheader, (ViewGroup) null);
        this.feN.setVisibility(8);
        this.feN.setClickable(false);
        this.feN.setEnabled(false);
        this.feO = (TextView) this.feN.findViewById(d.g.person_list_title);
        this.feJ.addHeaderView(this.feN, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOs() {
        if (this.feV == null) {
            this.feV = new com.baidu.tieba.c.d(getPageContext(), this.feU.feo);
            this.feV.jf(d.f.bg_tip_blue_up);
            this.feV.jh(2);
            this.feV.jg(3000);
            this.feV.ji(-10);
            this.feV.jj(-16);
            this.feV.j(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.feV != null) {
                        PersonListActivity.this.feV.akT();
                    }
                }
            });
        }
        this.feV.h(getPageContext().getString(d.k.attention_menu_tip), "key_my_concerned_person_tip", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(ar arVar, boolean z) {
        if (this.mModel != null && arVar != null && (!z || !this.feR)) {
            if (!z) {
                this.feR = true;
                c(arVar);
            }
            c(arVar, z);
            if (!this.mModel.aTr()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgFans(0);
            }
            b(arVar, z);
        }
    }

    private void b(ar arVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            if (this.mModel.getPage() == 1) {
                this.mProgress.setVisibility(8);
            }
            if (arVar.ahi > 0) {
                b(arVar);
            } else {
                iT(z);
            }
        }
    }

    private void b(ar arVar) {
        TextView textView;
        String string;
        String string2;
        boolean z;
        String string3;
        String string4;
        if (arVar != null) {
            this.feJ.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.aTr()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.feK.setVisibility(0);
                    this.feJ.removeHeaderView(this.feN);
                    TextView textView2 = this.feM;
                    textView2.setVisibility(0);
                    this.feU.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(d.k.all_concerned);
                    } else {
                        string4 = getPageContext().getString(d.k.each_concerned);
                    }
                    String string5 = getPageContext().getString(d.k.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.feK.setVisibility(8);
                    this.feN.setVisibility(0);
                    TextView textView3 = this.feO;
                    textView3.setVisibility(8);
                    this.feU.setVisibility(8);
                    if (this.feS == 2) {
                        string3 = getPageContext().getString(d.k.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.her_no_attention_other));
                    } else if (this.feS == 1) {
                        string3 = getPageContext().getString(d.k.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(d.k.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(d.k.person);
                    string = string3;
                    textView = textView3;
                    z = w.z(arVar.uD()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.feK.setVisibility(8);
                this.feN.setVisibility(0);
                textView = this.feO;
                this.feU.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(d.k.my_fans_prefix);
                    string2 = getPageContext().getString(d.k.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.not_have_fans));
                    z = false;
                } else if (this.feS == 2) {
                    string = getPageContext().getString(d.k.her_fans_prefix);
                    string2 = getPageContext().getString(d.k.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.her_no_fan_other));
                    z = false;
                } else if (this.feS == 1) {
                    string = getPageContext().getString(d.k.his_fans_prefix);
                    string2 = getPageContext().getString(d.k.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(d.k.his_fans_prefix);
                    string2 = getPageContext().getString(d.k.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(d.k.we_common_fans));
                return;
            }
            textView.setText(string + ao.y(arVar.ahi) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT(boolean z) {
        String string;
        this.feJ.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.aTr()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.feU.setVisibility(0);
                this.feM.setVisibility(0);
                this.feK.setVisibility(0);
                this.feN.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(d.k.all_concerned);
                } else {
                    string = getPageContext().getString(d.k.each_concerned);
                }
                String string2 = getPageContext().getString(d.k.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(this.mModel.getLoadType() == 0 ? d.k.not_have_attention : d.k.not_have_each_attention));
                this.feM.setText(string + 0 + string2);
                return;
            }
            this.feU.setVisibility(8);
            this.feM.setVisibility(8);
            if (this.feS == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.her_no_attention_other));
                return;
            } else if (this.feS == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.him_no_attention_other));
                return;
            }
        }
        this.feU.setVisibility(8);
        this.feM.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.not_have_fans));
        } else if (this.feS == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.her_no_fan_other));
        } else if (this.feS == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(d.k.him_no_fan_other));
        }
    }

    private void c(ar arVar) {
        this.mModel.setPage(arVar.pageNum);
    }

    private void c(ar arVar, boolean z) {
        if (this.feP != null) {
            if (!z) {
                if (arVar.pageNum == 1) {
                    this.feP.resetData();
                }
                this.feP.setHasMore(arVar.hasMore);
                this.feP.a(arVar);
                this.feP.aXn();
                this.feP.notifyDataSetChanged();
                return;
            }
            this.feP.setHasMore(false);
            this.feP.a(arVar);
            this.feP.aXn();
            this.feP.notifyDataSetChanged();
        }
    }

    private void agc() {
        this.mProgress.setVisibility(0);
        this.mModel.aXt();
        this.mModel.aXr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXp() {
        if (this.feP != null) {
            this.feP.notifyDataSetChanged();
        }
        this.mModel.aXr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXq() {
        UserData userData;
        if (this.feP != null && this.feP.getItemViewType(this.feT) == 0 && (userData = (UserData) this.feP.getItem(this.feT)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            aXq();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.feU.aXk()) {
                this.feU.aXj();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
