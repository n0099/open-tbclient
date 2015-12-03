package com.baidu.tieba.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.n;
import com.baidu.tieba.person.bu;
import com.baidu.tieba.person.data.PersonListActivityConfig;
/* loaded from: classes.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private boolean cLA;
    private bu mModel;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.n mNoDataView;
    private BdListView mListView = null;
    private View cLv = null;
    private View cLw = null;
    private TextView cLx = null;
    private ProgressBar mProgress = null;
    private bt cLy = null;
    private RelativeLayout bGY = null;
    private boolean cLz = true;
    private TextView Mf = null;
    private int cLB = 0;
    int cKZ = 0;
    public bu.a cLC = new bn(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.person_list_activity);
        initData(bundle);
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mModel.anU();
        this.mModel.JM();
        if (this.cLz) {
            this.cLz = false;
            anR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mModel.anW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().af(i == 1);
        getLayoutMode().k(this.bGY);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cLy.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().af(i == 1);
        getLayoutMode().k(this.cLw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cLy != null) {
            this.cLy = null;
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new bu(this, this.cLC);
        if (bundle != null) {
            this.mModel.cA(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.cLB = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.cLB);
            return;
        }
        Intent intent = getIntent();
        this.mModel.cA(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.cLB = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.cLB);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.anS());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.cLB);
    }

    private void initUI() {
        boolean z = true;
        this.bGY = (RelativeLayout) findViewById(n.f.parent);
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.Mf = this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mProgress = (ProgressBar) findViewById(n.f.progress);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.anS()) {
                this.Mf.setText(n.i.my_attention);
            } else {
                this.Mf.setText(n.i.fans);
            }
        } else if (this.mModel.anS()) {
            if (this.cLB == 2) {
                this.Mf.setText(n.i.her_attention_people);
            } else if (this.cLB == 1) {
                this.Mf.setText(n.i.his_attention_people);
            } else {
                this.Mf.setText(n.i.his_attention_people);
            }
        } else if (this.cLB == 2) {
            this.Mf.setText(n.i.attention_to_her);
        } else {
            this.Mf.setText(n.i.attention_to_him);
        }
        bo boVar = new bo(this);
        bp bpVar = new bp(this);
        bq bqVar = new bq(this);
        br brVar = new br(this);
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        this.cLy = new bt(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, this.mModel.getSex(), boVar, bpVar, brVar, bqVar);
        this.mListView = (BdListView) findViewById(n.f.list);
        this.mListView.setAdapter((ListAdapter) this.cLy);
        this.cLv = LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.g.person_list_newheader, (ViewGroup) null);
        this.cLw = this.cLv.findViewById(n.f.newheader_root);
        this.cLv.setVisibility(8);
        this.cLv.setClickable(false);
        this.cLv.setEnabled(false);
        this.cLx = (TextView) this.cLv.findViewById(n.f.person_list_title);
        this.mListView.addHeaderView(this.cLv, null, false);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.bGY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.mListView.setOnSrollToBottomListener(new bs(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tieba.person.data.n nVar, boolean z) {
        if (this.mModel != null && nVar != null && (!z || !this.cLA)) {
            if (!z) {
                this.cLA = true;
                a(nVar);
            }
            c(nVar, z);
            if (!this.mModel.anS()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgFans(0);
            }
            b(nVar, z);
        }
    }

    private void b(com.baidu.tieba.person.data.n nVar, boolean z) {
        String string;
        String string2;
        String string3;
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            if (this.mModel.getPage() == 1) {
                this.mProgress.setVisibility(8);
            }
            if (nVar.getPage().sc() > 0) {
                this.cLv.setVisibility(0);
                this.mListView.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                if (this.mModel.anS()) {
                    if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        string = getPageContext().getString(n.i.my_attention_prefix);
                        string2 = getPageContext().getString(n.i.person);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.not_have_attention));
                    } else {
                        if (this.cLB == 2) {
                            string3 = getPageContext().getString(n.i.she_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.her_no_attention_other));
                        } else if (this.cLB == 1) {
                            string3 = getPageContext().getString(n.i.he_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.him_no_attention_other));
                        } else {
                            string3 = getPageContext().getString(n.i.he_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.him_no_attention_other));
                        }
                        string = string3;
                        string2 = getPageContext().getString(n.i.person);
                    }
                } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(n.i.my_fans_prefix);
                    string2 = getPageContext().getString(n.i.my_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.not_have_fans));
                } else if (this.cLB == 2) {
                    string = getPageContext().getString(n.i.her_fans_prefix);
                    string2 = getPageContext().getString(n.i.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.her_no_fan_other));
                } else if (this.cLB == 1) {
                    string = getPageContext().getString(n.i.his_fans_prefix);
                    string2 = getPageContext().getString(n.i.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.him_no_fan_other));
                } else {
                    string = getPageContext().getString(n.i.his_fans_prefix);
                    string2 = getPageContext().getString(n.i.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.him_no_fan_other));
                }
                this.cLx.setText(String.valueOf(string) + String.valueOf(nVar.getPage().sc()) + string2);
                return;
            }
            this.cLv.setVisibility(8);
            this.mListView.setVisibility(8);
            if (!z) {
                this.mNoDataView.setVisibility(0);
            }
            if (this.mModel.anS()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.not_have_attention));
                } else if (this.cLB == 2) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.her_no_attention_other));
                } else if (this.cLB == 1) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.him_no_attention_other));
                } else {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.him_no_attention_other));
                }
            } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.not_have_fans));
            } else if (this.cLB == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.her_no_fan_other));
            } else if (this.cLB == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.him_no_fan_other));
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.him_no_fan_other));
            }
        }
    }

    private void a(com.baidu.tieba.person.data.n nVar) {
        this.mModel.kq(nVar.getPage().sd());
    }

    private void c(com.baidu.tieba.person.data.n nVar, boolean z) {
        boolean z2 = true;
        if (this.cLy != null) {
            if (!z) {
                if (nVar.getPage().sd() == 1) {
                    this.cLy.resetData();
                }
                com.baidu.tbadk.core.data.q page = nVar.getPage();
                bt btVar = this.cLy;
                if (page == null || page.sf() != 1) {
                    z2 = false;
                }
                btVar.setHasMore(z2);
                this.cLy.Z(nVar.aop());
                this.cLy.fE(false);
                this.cLy.aic();
                this.cLy.notifyDataSetChanged();
                return;
            }
            this.cLy.setHasMore(false);
            this.cLy.Z(nVar.aop());
            this.cLy.fE(false);
            this.cLy.aic();
            this.cLy.notifyDataSetChanged();
        }
    }

    private void anR() {
        this.mProgress.setVisibility(0);
        this.mModel.anV();
        this.mModel.anT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anM() {
        if (this.cLy != null) {
            this.cLy.fE(true);
            this.cLy.notifyDataSetChanged();
        }
        this.mModel.anT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anN() {
        UserData userData;
        if (this.cLy != null && this.cLy.getItemViewType(this.cKZ) == 0 && (userData = (UserData) this.cLy.getItem(this.cKZ)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "enter_chat", "personlistclick", 1, new Object[0]);
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getPortrait(), userData.getSex())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 11028) {
            anN();
        }
    }
}
