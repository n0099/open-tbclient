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
    private boolean bGD;
    private bm mModel;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private BdListView mListView = null;
    private View bGy = null;
    private View bGz = null;
    private TextView bGA = null;
    private ProgressBar mProgress = null;
    private bk bGB = null;
    private RelativeLayout mParent = null;
    private boolean bGC = true;
    private TextView mTitleText = null;
    private int bGE = 0;
    int bGg = 0;
    public bp bGF = new be(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PersonListActivityConfig.class, PersonListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.person_list_activity);
        initData(bundle);
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mModel.aaz();
        this.mModel.Je();
        if (this.bGC) {
            this.bGC = false;
            Uj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mModel.aaB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bGB.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.bGz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bGB != null) {
            this.bGB = null;
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new bm(this, this.bGF);
        if (bundle != null) {
            this.mModel.bR(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.bGE = bundle.getInt(com.baidu.tbadk.core.frameworkData.a.USER_SEX);
            this.mModel.setSex(this.bGE);
            return;
        }
        Intent intent = getIntent();
        this.mModel.bR(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.bGE = intent.getIntExtra(com.baidu.tbadk.core.frameworkData.a.USER_SEX, 0);
        this.mModel.setSex(this.bGE);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aax());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(com.baidu.tbadk.core.frameworkData.a.USER_SEX, this.bGE);
    }

    private void initUI() {
        boolean z = true;
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.w.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mTitleText = this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aax()) {
                this.mTitleText.setText(com.baidu.tieba.z.my_attention);
            } else {
                this.mTitleText.setText(com.baidu.tieba.z.fans);
            }
        } else if (this.mModel.aax()) {
            if (this.bGE == 2) {
                this.mTitleText.setText(com.baidu.tieba.z.her_attention_people);
            } else if (this.bGE == 1) {
                this.mTitleText.setText(com.baidu.tieba.z.his_attention_people);
            } else {
                this.mTitleText.setText(com.baidu.tieba.z.his_attention_people);
            }
        } else if (this.bGE == 2) {
            this.mTitleText.setText(com.baidu.tieba.z.attention_to_her);
        } else {
            this.mTitleText.setText(com.baidu.tieba.z.attention_to_him);
        }
        bf bfVar = new bf(this);
        bg bgVar = new bg(this);
        bh bhVar = new bh(this);
        bi biVar = new bi(this);
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        this.bGB = new bk(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, this.mModel.getSex(), bfVar, bgVar, biVar, bhVar);
        this.mListView = (BdListView) findViewById(com.baidu.tieba.w.list);
        this.mListView.setAdapter((ListAdapter) this.bGB);
        this.bGy = com.baidu.adp.lib.g.b.ek().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.person_list_newheader, null);
        this.bGz = this.bGy.findViewById(com.baidu.tieba.w.newheader_root);
        this.bGy.setVisibility(8);
        this.bGy.setClickable(false);
        this.bGy.setEnabled(false);
        this.bGA = (TextView) this.bGy.findViewById(com.baidu.tieba.w.person_list_title);
        this.mListView.addHeaderView(this.bGy, null, false);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mParent, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.mListView.setOnSrollToBottomListener(new bj(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tbadk.core.data.q qVar, boolean z) {
        if (this.mModel != null && qVar != null && (!z || !this.bGD)) {
            if (!z) {
                this.bGD = true;
                a(qVar);
            }
            c(qVar, z);
            if (!this.mModel.aax()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.rI().setMsgFans(0);
            }
            b(qVar, z);
        }
    }

    private void b(com.baidu.tbadk.core.data.q qVar, boolean z) {
        String string;
        String string2;
        String string3;
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            if (this.mModel.getPage() == 1) {
                this.mProgress.setVisibility(8);
            }
            if (qVar.mY().mT() > 0) {
                this.bGy.setVisibility(0);
                this.mListView.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                if (this.mModel.aax()) {
                    if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        string = getPageContext().getString(com.baidu.tieba.z.my_attention_prefix);
                        string2 = getPageContext().getString(com.baidu.tieba.z.person);
                        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.not_have_attention));
                    } else {
                        if (this.bGE == 2) {
                            string3 = getPageContext().getString(com.baidu.tieba.z.she_attention_prefix);
                            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.her_no_attention_other));
                        } else if (this.bGE == 1) {
                            string3 = getPageContext().getString(com.baidu.tieba.z.he_attention_prefix);
                            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.him_no_attention_other));
                        } else {
                            string3 = getPageContext().getString(com.baidu.tieba.z.he_attention_prefix);
                            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.him_no_attention_other));
                        }
                        string = string3;
                        string2 = getPageContext().getString(com.baidu.tieba.z.person);
                    }
                } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(com.baidu.tieba.z.my_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.z.my_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.not_have_fans));
                } else if (this.bGE == 2) {
                    string = getPageContext().getString(com.baidu.tieba.z.her_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.z.her_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.her_no_fan_other));
                } else if (this.bGE == 1) {
                    string = getPageContext().getString(com.baidu.tieba.z.his_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.z.her_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.him_no_fan_other));
                } else {
                    string = getPageContext().getString(com.baidu.tieba.z.his_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.z.her_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.him_no_fan_other));
                }
                this.bGA.setText(String.valueOf(string) + String.valueOf(qVar.mY().mT()) + string2);
                return;
            }
            this.bGy.setVisibility(8);
            this.mListView.setVisibility(8);
            if (!z) {
                this.mNoDataView.setVisibility(0);
            }
            if (this.mModel.aax()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.not_have_attention));
                } else if (this.bGE == 2) {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.her_no_attention_other));
                } else if (this.bGE == 1) {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.him_no_attention_other));
                } else {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.him_no_attention_other));
                }
            } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.not_have_fans));
            } else if (this.bGE == 2) {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.her_no_fan_other));
            } else if (this.bGE == 1) {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.him_no_fan_other));
            } else {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.him_no_fan_other));
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.q qVar) {
        this.mModel.hi(qVar.mY().mU());
    }

    private void c(com.baidu.tbadk.core.data.q qVar, boolean z) {
        boolean z2 = true;
        if (this.bGB != null) {
            if (!z) {
                if (qVar.mY().mU() == 1) {
                    this.bGB.resetData();
                }
                com.baidu.tbadk.core.data.p mY = qVar.mY();
                bk bkVar = this.bGB;
                if (mY == null || mY.mW() != 1) {
                    z2 = false;
                }
                bkVar.setHasMore(z2);
                this.bGB.K(qVar.mZ());
                this.bGB.ec(false);
                this.bGB.Wc();
                this.bGB.notifyDataSetChanged();
                return;
            }
            this.bGB.setHasMore(false);
            this.bGB.K(qVar.mZ());
            this.bGB.ec(false);
            this.bGB.Wc();
            this.bGB.notifyDataSetChanged();
        }
    }

    private void Uj() {
        this.mProgress.setVisibility(0);
        this.mModel.aaA();
        this.mModel.aay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aat() {
        if (this.bGB != null) {
            this.bGB.ec(true);
            this.bGB.notifyDataSetChanged();
        }
        this.mModel.aay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aau() {
        UserData userData;
        if (this.bGB != null && this.bGB.getItemViewType(this.bGg) == 0 && (userData = (UserData) this.bGB.getItem(this.bGg)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            aau();
        }
    }
}
