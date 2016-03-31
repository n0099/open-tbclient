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
import com.baidu.tieba.person.bv;
import com.baidu.tieba.person.data.PersonListActivityConfig;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private boolean dtQ;
    private bv mModel;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.p mNoDataView;
    private BdListView Je = null;
    private View dtL = null;
    private View dtM = null;
    private TextView dtN = null;
    private ProgressBar aQj = null;
    private bu dtO = null;
    private RelativeLayout bYK = null;
    private boolean dtP = true;
    private TextView MR = null;
    private int dtR = 0;
    int dto = 0;
    public bv.a dtS = new bo(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.person_list_activity);
        initData(bundle);
        pU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mModel.aBD();
        this.mModel.NL();
        if (this.dtP) {
            this.dtP = false;
            aBB();
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
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(this.bYK);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dtO.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(this.dtM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dtO != null) {
            this.dtO = null;
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new bv(this, this.dtS);
        if (bundle != null) {
            this.mModel.cN(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.dtR = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.dtR);
            return;
        }
        Intent intent = getIntent();
        this.mModel.cN(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.dtR = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.dtR);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aqg());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.dtR);
    }

    private void pU() {
        boolean z = true;
        this.bYK = (RelativeLayout) findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.MR = this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aQj = (ProgressBar) findViewById(t.g.progress);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aqg()) {
                this.MR.setText(t.j.my_attention);
            } else {
                this.MR.setText(t.j.fans);
            }
        } else if (this.mModel.aqg()) {
            if (this.dtR == 2) {
                this.MR.setText(t.j.her_attention_people);
            } else if (this.dtR == 1) {
                this.MR.setText(t.j.his_attention_people);
            } else {
                this.MR.setText(t.j.his_attention_people);
            }
        } else if (this.dtR == 2) {
            this.MR.setText(t.j.attention_to_her);
        } else {
            this.MR.setText(t.j.attention_to_him);
        }
        bp bpVar = new bp(this);
        bq bqVar = new bq(this);
        br brVar = new br(this);
        bs bsVar = new bs(this);
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        this.dtO = new bu(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, this.mModel.getSex(), bpVar, bqVar, bsVar, brVar);
        this.Je = (BdListView) findViewById(t.g.list);
        this.Je.setAdapter((ListAdapter) this.dtO);
        this.dtL = LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.person_list_newheader, (ViewGroup) null);
        this.dtM = this.dtL.findViewById(t.g.newheader_root);
        this.dtL.setVisibility(8);
        this.dtL.setClickable(false);
        this.dtL.setEnabled(false);
        this.dtN = (TextView) this.dtL.findViewById(t.g.person_list_title);
        this.Je.addHeaderView(this.dtL, null, false);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.bYK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.Je.setOnSrollToBottomListener(new bt(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tieba.person.data.r rVar, boolean z) {
        if (this.mModel != null && rVar != null && (!z || !this.dtQ)) {
            if (!z) {
                this.dtQ = true;
                a(rVar);
            }
            c(rVar, z);
            if (!this.mModel.aqg()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.zp().setMsgFans(0);
            }
            b(rVar, z);
        }
    }

    private void b(com.baidu.tieba.person.data.r rVar, boolean z) {
        String string;
        String string2;
        String string3;
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            if (this.mModel.getPage() == 1) {
                this.aQj.setVisibility(8);
            }
            if (rVar.getPage().sm() > 0) {
                this.dtL.setVisibility(0);
                this.Je.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                if (this.mModel.aqg()) {
                    if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        string = getPageContext().getString(t.j.my_attention_prefix);
                        string2 = getPageContext().getString(t.j.person);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.not_have_attention));
                    } else {
                        if (this.dtR == 2) {
                            string3 = getPageContext().getString(t.j.she_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.her_no_attention_other));
                        } else if (this.dtR == 1) {
                            string3 = getPageContext().getString(t.j.he_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.him_no_attention_other));
                        } else {
                            string3 = getPageContext().getString(t.j.he_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.him_no_attention_other));
                        }
                        string = string3;
                        string2 = getPageContext().getString(t.j.person);
                    }
                } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(t.j.my_fans_prefix);
                    string2 = getPageContext().getString(t.j.my_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.not_have_fans));
                } else if (this.dtR == 2) {
                    string = getPageContext().getString(t.j.her_fans_prefix);
                    string2 = getPageContext().getString(t.j.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.her_no_fan_other));
                } else if (this.dtR == 1) {
                    string = getPageContext().getString(t.j.his_fans_prefix);
                    string2 = getPageContext().getString(t.j.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.him_no_fan_other));
                } else {
                    string = getPageContext().getString(t.j.his_fans_prefix);
                    string2 = getPageContext().getString(t.j.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.him_no_fan_other));
                }
                this.dtN.setText(String.valueOf(string) + String.valueOf(rVar.getPage().sm()) + string2);
                return;
            }
            this.dtL.setVisibility(8);
            this.Je.setVisibility(8);
            if (!z) {
                this.mNoDataView.setVisibility(0);
            }
            if (this.mModel.aqg()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.not_have_attention));
                } else if (this.dtR == 2) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.her_no_attention_other));
                } else if (this.dtR == 1) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.him_no_attention_other));
                } else {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.him_no_attention_other));
                }
            } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.not_have_fans));
            } else if (this.dtR == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.her_no_fan_other));
            } else if (this.dtR == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.him_no_fan_other));
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.him_no_fan_other));
            }
        }
    }

    private void a(com.baidu.tieba.person.data.r rVar) {
        this.mModel.mC(rVar.getPage().so());
    }

    private void c(com.baidu.tieba.person.data.r rVar, boolean z) {
        boolean z2 = true;
        if (this.dtO != null) {
            if (!z) {
                if (rVar.getPage().so() == 1) {
                    this.dtO.resetData();
                }
                com.baidu.tbadk.core.data.ac page = rVar.getPage();
                bu buVar = this.dtO;
                if (page == null || page.sq() != 1) {
                    z2 = false;
                }
                buVar.setHasMore(z2);
                this.dtO.aa(rVar.aCc());
                this.dtO.gF(false);
                this.dtO.aug();
                this.dtO.notifyDataSetChanged();
                return;
            }
            this.dtO.setHasMore(false);
            this.dtO.aa(rVar.aCc());
            this.dtO.gF(false);
            this.dtO.aug();
            this.dtO.notifyDataSetChanged();
        }
    }

    private void aBB() {
        this.aQj.setVisibility(0);
        this.mModel.aBE();
        this.mModel.aBC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBw() {
        if (this.dtO != null) {
            this.dtO.gF(true);
            this.dtO.notifyDataSetChanged();
        }
        this.mModel.aBC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBx() {
        UserData userData;
        if (this.dtO != null && this.dtO.getItemViewType(this.dto) == 0 && (userData = (UserData) this.dtO.getItem(this.dto)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            aBx();
        }
    }
}
