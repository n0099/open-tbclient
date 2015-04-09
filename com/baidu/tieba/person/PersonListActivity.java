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
    private boolean bQM;
    private bj mModel;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private BdListView mListView = null;
    private View bQH = null;
    private View bQI = null;
    private TextView bQJ = null;
    private ProgressBar mProgress = null;
    private bh bQK = null;
    private RelativeLayout aXd = null;
    private boolean bQL = true;
    private TextView mTitleText = null;
    private int bQN = 0;
    int bQo = 0;
    public bm bQO = new bb(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.person_list_activity);
        initData(bundle);
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mModel.ady();
        this.mModel.GH();
        if (this.bQL) {
            this.bQL = false;
            adv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mModel.adA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.aXd);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bQK.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.bQI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bQK != null) {
            this.bQK = null;
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new bj(this, this.bQO);
        if (bundle != null) {
            this.mModel.bX(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.bQN = bundle.getInt(com.baidu.tbadk.core.frameworkData.a.USER_SEX);
            this.mModel.setSex(this.bQN);
            return;
        }
        Intent intent = getIntent();
        this.mModel.bX(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.bQN = intent.getIntExtra(com.baidu.tbadk.core.frameworkData.a.USER_SEX, 0);
        this.mModel.setSex(this.bQN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.adw());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(com.baidu.tbadk.core.frameworkData.a.USER_SEX, this.bQN);
    }

    private void initUI() {
        boolean z = true;
        this.aXd = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mTitleText = this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.adw()) {
                this.mTitleText.setText(com.baidu.tieba.y.my_attention);
            } else {
                this.mTitleText.setText(com.baidu.tieba.y.fans);
            }
        } else if (this.mModel.adw()) {
            if (this.bQN == 2) {
                this.mTitleText.setText(com.baidu.tieba.y.her_attention_people);
            } else if (this.bQN == 1) {
                this.mTitleText.setText(com.baidu.tieba.y.his_attention_people);
            } else {
                this.mTitleText.setText(com.baidu.tieba.y.his_attention_people);
            }
        } else if (this.bQN == 2) {
            this.mTitleText.setText(com.baidu.tieba.y.attention_to_her);
        } else {
            this.mTitleText.setText(com.baidu.tieba.y.attention_to_him);
        }
        bc bcVar = new bc(this);
        bd bdVar = new bd(this);
        be beVar = new be(this);
        bf bfVar = new bf(this);
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        this.bQK = new bh(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, this.mModel.getSex(), bcVar, bdVar, bfVar, beVar);
        this.mListView = (BdListView) findViewById(com.baidu.tieba.v.list);
        this.mListView.setAdapter((ListAdapter) this.bQK);
        this.bQH = com.baidu.adp.lib.g.b.hH().inflate(getPageContext().getPageActivity(), com.baidu.tieba.w.person_list_newheader, null);
        this.bQI = this.bQH.findViewById(com.baidu.tieba.v.newheader_root);
        this.bQH.setVisibility(8);
        this.bQH.setClickable(false);
        this.bQH.setEnabled(false);
        this.bQJ = (TextView) this.bQH.findViewById(com.baidu.tieba.v.person_list_title);
        this.mListView.addHeaderView(this.bQH, null, false);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.aXd, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.mListView.setOnSrollToBottomListener(new bg(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tieba.person.a.a aVar, boolean z) {
        if (this.mModel != null && aVar != null && (!z || !this.bQM)) {
            if (!z) {
                this.bQM = true;
                a(aVar);
            }
            c(aVar, z);
            if (!this.mModel.adw()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.uZ().setMsgFans(0);
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
            if (aVar.XQ().qi() > 0) {
                this.bQH.setVisibility(0);
                this.mListView.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                if (this.mModel.adw()) {
                    if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        string = getPageContext().getString(com.baidu.tieba.y.my_attention_prefix);
                        string2 = getPageContext().getString(com.baidu.tieba.y.person);
                        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.not_have_attention));
                    } else {
                        if (this.bQN == 2) {
                            string3 = getPageContext().getString(com.baidu.tieba.y.she_attention_prefix);
                            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.her_no_attention_other));
                        } else if (this.bQN == 1) {
                            string3 = getPageContext().getString(com.baidu.tieba.y.he_attention_prefix);
                            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.him_no_attention_other));
                        } else {
                            string3 = getPageContext().getString(com.baidu.tieba.y.he_attention_prefix);
                            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.him_no_attention_other));
                        }
                        string = string3;
                        string2 = getPageContext().getString(com.baidu.tieba.y.person);
                    }
                } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(com.baidu.tieba.y.my_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.y.my_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.not_have_fans));
                } else if (this.bQN == 2) {
                    string = getPageContext().getString(com.baidu.tieba.y.her_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.y.her_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.her_no_fan_other));
                } else if (this.bQN == 1) {
                    string = getPageContext().getString(com.baidu.tieba.y.his_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.y.her_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.him_no_fan_other));
                } else {
                    string = getPageContext().getString(com.baidu.tieba.y.his_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.y.her_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.him_no_fan_other));
                }
                this.bQJ.setText(String.valueOf(string) + String.valueOf(aVar.XQ().qi()) + string2);
                return;
            }
            this.bQH.setVisibility(8);
            this.mListView.setVisibility(8);
            if (!z) {
                this.mNoDataView.setVisibility(0);
            }
            if (this.mModel.adw()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.not_have_attention));
                } else if (this.bQN == 2) {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.her_no_attention_other));
                } else if (this.bQN == 1) {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.him_no_attention_other));
                } else {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.him_no_attention_other));
                }
            } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.not_have_fans));
            } else if (this.bQN == 2) {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.her_no_fan_other));
            } else if (this.bQN == 1) {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.him_no_fan_other));
            } else {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.him_no_fan_other));
            }
        }
    }

    private void a(com.baidu.tieba.person.a.a aVar) {
        this.mModel.hD(aVar.XQ().qj());
    }

    private void c(com.baidu.tieba.person.a.a aVar, boolean z) {
        boolean z2 = true;
        if (this.bQK != null) {
            if (!z) {
                if (aVar.XQ().qj() == 1) {
                    this.bQK.resetData();
                }
                com.baidu.tbadk.core.data.q XQ = aVar.XQ();
                bh bhVar = this.bQK;
                if (XQ == null || XQ.ql() != 1) {
                    z2 = false;
                }
                bhVar.setHasMore(z2);
                this.bQK.R(aVar.adB());
                this.bQK.ed(false);
                this.bQK.Yg();
                this.bQK.notifyDataSetChanged();
                return;
            }
            this.bQK.setHasMore(false);
            this.bQK.R(aVar.adB());
            this.bQK.ed(false);
            this.bQK.Yg();
            this.bQK.notifyDataSetChanged();
        }
    }

    private void adv() {
        this.mProgress.setVisibility(0);
        this.mModel.adz();
        this.mModel.adx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adr() {
        if (this.bQK != null) {
            this.bQK.ed(true);
            this.bQK.notifyDataSetChanged();
        }
        this.mModel.adx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ads() {
        UserData userData;
        if (this.bQK != null && this.bQK.getItemViewType(this.bQo) == 0 && (userData = (UserData) this.bQK.getItem(this.bQo)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            ads();
        }
    }
}
