package com.baidu.tieba.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private boolean bTr;
    private cc mModel;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private BdListView mListView = null;
    private View bTm = null;
    private View bTn = null;
    private TextView bTo = null;
    private ProgressBar mProgress = null;
    private ca bTp = null;
    private RelativeLayout aZJ = null;
    private boolean bTq = true;
    private TextView mTitleText = null;
    private int bTs = 0;
    int bST = 0;
    public cf bTt = new bu(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.r.person_list_activity);
        initData(bundle);
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mModel.aeG();
        this.mModel.HL();
        if (this.bTq) {
            this.bTq = false;
            aeD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mModel.aeI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.aZJ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bTp.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.bTn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bTp != null) {
            this.bTp = null;
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new cc(this, this.bTt);
        if (bundle != null) {
            this.mModel.cg(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.bTs = bundle.getInt(com.baidu.tbadk.core.frameworkData.c.USER_SEX);
            this.mModel.setSex(this.bTs);
            return;
        }
        Intent intent = getIntent();
        this.mModel.cg(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.bTs = intent.getIntExtra(com.baidu.tbadk.core.frameworkData.c.USER_SEX, 0);
        this.mModel.setSex(this.bTs);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aeE());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(com.baidu.tbadk.core.frameworkData.c.USER_SEX, this.bTs);
    }

    private void initUI() {
        boolean z = true;
        this.aZJ = (RelativeLayout) findViewById(com.baidu.tieba.q.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mTitleText = this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.q.progress);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aeE()) {
                this.mTitleText.setText(com.baidu.tieba.t.my_attention);
            } else {
                this.mTitleText.setText(com.baidu.tieba.t.fans);
            }
        } else if (this.mModel.aeE()) {
            if (this.bTs == 2) {
                this.mTitleText.setText(com.baidu.tieba.t.her_attention_people);
            } else if (this.bTs == 1) {
                this.mTitleText.setText(com.baidu.tieba.t.his_attention_people);
            } else {
                this.mTitleText.setText(com.baidu.tieba.t.his_attention_people);
            }
        } else if (this.bTs == 2) {
            this.mTitleText.setText(com.baidu.tieba.t.attention_to_her);
        } else {
            this.mTitleText.setText(com.baidu.tieba.t.attention_to_him);
        }
        bv bvVar = new bv(this);
        bw bwVar = new bw(this);
        bx bxVar = new bx(this);
        by byVar = new by(this);
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        this.bTp = new ca(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, this.mModel.getSex(), bvVar, bwVar, byVar, bxVar);
        this.mListView = (BdListView) findViewById(com.baidu.tieba.q.list);
        this.mListView.setAdapter((ListAdapter) this.bTp);
        this.bTm = com.baidu.adp.lib.g.b.hr().inflate(getPageContext().getPageActivity(), com.baidu.tieba.r.person_list_newheader, null);
        this.bTn = this.bTm.findViewById(com.baidu.tieba.q.newheader_root);
        this.bTm.setVisibility(8);
        this.bTm.setClickable(false);
        this.bTm.setEnabled(false);
        this.bTo = (TextView) this.bTm.findViewById(com.baidu.tieba.q.person_list_title);
        this.mListView.addHeaderView(this.bTm, null, false);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.aZJ, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.mListView.setOnSrollToBottomListener(new bz(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tieba.person.a.a aVar, boolean z) {
        if (this.mModel != null && aVar != null && (!z || !this.bTr)) {
            if (!z) {
                this.bTr = true;
                a(aVar);
            }
            c(aVar, z);
            if (!this.mModel.aeE()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgFans(0);
            }
            b(aVar, z);
        }
    }

    private void b(com.baidu.tieba.person.a.a aVar, boolean z) {
        String string;
        String string2;
        String string3;
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            if (this.mModel.getPage() == 1) {
                this.mProgress.setVisibility(8);
            }
            if (aVar.Zp().qO() > 0) {
                this.bTm.setVisibility(0);
                this.mListView.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                if (this.mModel.aeE()) {
                    if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        string = getPageContext().getString(com.baidu.tieba.t.my_attention_prefix);
                        string2 = getPageContext().getString(com.baidu.tieba.t.person);
                        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.not_have_attention));
                    } else {
                        if (this.bTs == 2) {
                            string3 = getPageContext().getString(com.baidu.tieba.t.she_attention_prefix);
                            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.her_no_attention_other));
                        } else if (this.bTs == 1) {
                            string3 = getPageContext().getString(com.baidu.tieba.t.he_attention_prefix);
                            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.him_no_attention_other));
                        } else {
                            string3 = getPageContext().getString(com.baidu.tieba.t.he_attention_prefix);
                            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.him_no_attention_other));
                        }
                        string = string3;
                        string2 = getPageContext().getString(com.baidu.tieba.t.person);
                    }
                } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(com.baidu.tieba.t.my_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.t.my_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.not_have_fans));
                } else if (this.bTs == 2) {
                    string = getPageContext().getString(com.baidu.tieba.t.her_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.t.her_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.her_no_fan_other));
                } else if (this.bTs == 1) {
                    string = getPageContext().getString(com.baidu.tieba.t.his_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.t.her_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.him_no_fan_other));
                } else {
                    string = getPageContext().getString(com.baidu.tieba.t.his_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.t.her_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.him_no_fan_other));
                }
                this.bTo.setText(String.valueOf(string) + String.valueOf(aVar.Zp().qO()) + string2);
                return;
            }
            this.bTm.setVisibility(8);
            this.mListView.setVisibility(8);
            if (!z) {
                this.mNoDataView.setVisibility(0);
            }
            if (this.mModel.aeE()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.not_have_attention));
                } else if (this.bTs == 2) {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.her_no_attention_other));
                } else if (this.bTs == 1) {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.him_no_attention_other));
                } else {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.him_no_attention_other));
                }
            } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.not_have_fans));
            } else if (this.bTs == 2) {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.her_no_fan_other));
            } else if (this.bTs == 1) {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.him_no_fan_other));
            } else {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.him_no_fan_other));
            }
        }
    }

    private void a(com.baidu.tieba.person.a.a aVar) {
        this.mModel.hS(aVar.Zp().qP());
    }

    private void c(com.baidu.tieba.person.a.a aVar, boolean z) {
        boolean z2 = true;
        if (this.bTp != null) {
            if (!z) {
                if (aVar.Zp().qP() == 1) {
                    this.bTp.resetData();
                }
                com.baidu.tbadk.core.data.q Zp = aVar.Zp();
                ca caVar = this.bTp;
                if (Zp == null || Zp.qR() != 1) {
                    z2 = false;
                }
                caVar.setHasMore(z2);
                this.bTp.M(aVar.aeJ());
                this.bTp.ep(false);
                this.bTp.ZG();
                this.bTp.notifyDataSetChanged();
                return;
            }
            this.bTp.setHasMore(false);
            this.bTp.M(aVar.aeJ());
            this.bTp.ep(false);
            this.bTp.ZG();
            this.bTp.notifyDataSetChanged();
        }
    }

    private void aeD() {
        this.mProgress.setVisibility(0);
        this.mModel.aeH();
        this.mModel.aeF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aez() {
        if (this.bTp != null) {
            this.bTp.ep(true);
            this.bTp.notifyDataSetChanged();
        }
        this.mModel.aeF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeA() {
        UserData userData;
        if (this.bTp != null && this.bTp.getItemViewType(this.bST) == 0 && (userData = (UserData) this.bTp.getItem(this.bST)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "enter_chat", "personlistclick", 1, new Object[0]);
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getPortrait(), userData.getSex())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 11028) {
            aeA();
        }
    }
}
