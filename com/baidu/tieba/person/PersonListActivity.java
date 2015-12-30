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
    private boolean cPQ;
    private bu mModel;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private BdListView mListView = null;
    private View cPL = null;
    private View cPM = null;
    private TextView cPN = null;
    private ProgressBar mProgress = null;
    private bt cPO = null;
    private RelativeLayout bKF = null;
    private boolean cPP = true;
    private TextView Mv = null;
    private int cPR = 0;
    int cPp = 0;
    public bu.a cPS = new bn(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.person_list_activity);
        initData(bundle);
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mModel.apf();
        this.mModel.Kf();
        if (this.cPP) {
            this.cPP = false;
            apc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mModel.aph();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ac(i == 1);
        getLayoutMode().k(this.bKF);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cPO.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ac(i == 1);
        getLayoutMode().k(this.cPM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cPO != null) {
            this.cPO = null;
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new bu(this, this.cPS);
        if (bundle != null) {
            this.mModel.cB(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.cPR = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.cPR);
            return;
        }
        Intent intent = getIntent();
        this.mModel.cB(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.cPR = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.cPR);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.apd());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.cPR);
    }

    private void initUI() {
        boolean z = true;
        this.bKF = (RelativeLayout) findViewById(n.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.Mv = this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mProgress = (ProgressBar) findViewById(n.g.progress);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.apd()) {
                this.Mv.setText(n.j.my_attention);
            } else {
                this.Mv.setText(n.j.fans);
            }
        } else if (this.mModel.apd()) {
            if (this.cPR == 2) {
                this.Mv.setText(n.j.her_attention_people);
            } else if (this.cPR == 1) {
                this.Mv.setText(n.j.his_attention_people);
            } else {
                this.Mv.setText(n.j.his_attention_people);
            }
        } else if (this.cPR == 2) {
            this.Mv.setText(n.j.attention_to_her);
        } else {
            this.Mv.setText(n.j.attention_to_him);
        }
        bo boVar = new bo(this);
        bp bpVar = new bp(this);
        bq bqVar = new bq(this);
        br brVar = new br(this);
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        this.cPO = new bt(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, this.mModel.getSex(), boVar, bpVar, brVar, bqVar);
        this.mListView = (BdListView) findViewById(n.g.list);
        this.mListView.setAdapter((ListAdapter) this.cPO);
        this.cPL = LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.h.person_list_newheader, (ViewGroup) null);
        this.cPM = this.cPL.findViewById(n.g.newheader_root);
        this.cPL.setVisibility(8);
        this.cPL.setClickable(false);
        this.cPL.setEnabled(false);
        this.cPN = (TextView) this.cPL.findViewById(n.g.person_list_title);
        this.mListView.addHeaderView(this.cPL, null, false);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.bKF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.mListView.setOnSrollToBottomListener(new bs(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tieba.person.data.p pVar, boolean z) {
        if (this.mModel != null && pVar != null && (!z || !this.cPQ)) {
            if (!z) {
                this.cPQ = true;
                a(pVar);
            }
            c(pVar, z);
            if (!this.mModel.apd()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.xv().setMsgFans(0);
            }
            b(pVar, z);
        }
    }

    private void b(com.baidu.tieba.person.data.p pVar, boolean z) {
        String string;
        String string2;
        String string3;
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            if (this.mModel.getPage() == 1) {
                this.mProgress.setVisibility(8);
            }
            if (pVar.getPage().rL() > 0) {
                this.cPL.setVisibility(0);
                this.mListView.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                if (this.mModel.apd()) {
                    if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        string = getPageContext().getString(n.j.my_attention_prefix);
                        string2 = getPageContext().getString(n.j.person);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.not_have_attention));
                    } else {
                        if (this.cPR == 2) {
                            string3 = getPageContext().getString(n.j.she_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.her_no_attention_other));
                        } else if (this.cPR == 1) {
                            string3 = getPageContext().getString(n.j.he_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.him_no_attention_other));
                        } else {
                            string3 = getPageContext().getString(n.j.he_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.him_no_attention_other));
                        }
                        string = string3;
                        string2 = getPageContext().getString(n.j.person);
                    }
                } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(n.j.my_fans_prefix);
                    string2 = getPageContext().getString(n.j.my_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.not_have_fans));
                } else if (this.cPR == 2) {
                    string = getPageContext().getString(n.j.her_fans_prefix);
                    string2 = getPageContext().getString(n.j.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.her_no_fan_other));
                } else if (this.cPR == 1) {
                    string = getPageContext().getString(n.j.his_fans_prefix);
                    string2 = getPageContext().getString(n.j.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.him_no_fan_other));
                } else {
                    string = getPageContext().getString(n.j.his_fans_prefix);
                    string2 = getPageContext().getString(n.j.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.him_no_fan_other));
                }
                this.cPN.setText(String.valueOf(string) + String.valueOf(pVar.getPage().rL()) + string2);
                return;
            }
            this.cPL.setVisibility(8);
            this.mListView.setVisibility(8);
            if (!z) {
                this.mNoDataView.setVisibility(0);
            }
            if (this.mModel.apd()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.not_have_attention));
                } else if (this.cPR == 2) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.her_no_attention_other));
                } else if (this.cPR == 1) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.him_no_attention_other));
                } else {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.him_no_attention_other));
                }
            } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.not_have_fans));
            } else if (this.cPR == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.her_no_fan_other));
            } else if (this.cPR == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.him_no_fan_other));
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.him_no_fan_other));
            }
        }
    }

    private void a(com.baidu.tieba.person.data.p pVar) {
        this.mModel.kN(pVar.getPage().rM());
    }

    private void c(com.baidu.tieba.person.data.p pVar, boolean z) {
        boolean z2 = true;
        if (this.cPO != null) {
            if (!z) {
                if (pVar.getPage().rM() == 1) {
                    this.cPO.resetData();
                }
                com.baidu.tbadk.core.data.q page = pVar.getPage();
                bt btVar = this.cPO;
                if (page == null || page.rO() != 1) {
                    z2 = false;
                }
                btVar.setHasMore(z2);
                this.cPO.Y(pVar.apz());
                this.cPO.fD(false);
                this.cPO.ajp();
                this.cPO.notifyDataSetChanged();
                return;
            }
            this.cPO.setHasMore(false);
            this.cPO.Y(pVar.apz());
            this.cPO.fD(false);
            this.cPO.ajp();
            this.cPO.notifyDataSetChanged();
        }
    }

    private void apc() {
        this.mProgress.setVisibility(0);
        this.mModel.apg();
        this.mModel.ape();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoX() {
        if (this.cPO != null) {
            this.cPO.fD(true);
            this.cPO.notifyDataSetChanged();
        }
        this.mModel.ape();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoY() {
        UserData userData;
        if (this.cPO != null && this.cPO.getItemViewType(this.cPp) == 0 && (userData = (UserData) this.cPO.getItem(this.cPp)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            aoY();
        }
    }
}
