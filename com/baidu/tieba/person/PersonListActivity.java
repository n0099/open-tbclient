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
    private boolean bQw;
    private bj mModel;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private BdListView mListView = null;
    private View bQr = null;
    private View bQs = null;
    private TextView bQt = null;
    private ProgressBar mProgress = null;
    private bh bQu = null;
    private RelativeLayout aWN = null;
    private boolean bQv = true;
    private TextView mTitleText = null;
    private int bQx = 0;
    int bPY = 0;
    public bm bQy = new bb(this);

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
        this.mModel.adj();
        this.mModel.GB();
        if (this.bQv) {
            this.bQv = false;
            adg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mModel.adl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.aWN);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bQu.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.bQs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bQu != null) {
            this.bQu = null;
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new bj(this, this.bQy);
        if (bundle != null) {
            this.mModel.bZ(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.bQx = bundle.getInt(com.baidu.tbadk.core.frameworkData.a.USER_SEX);
            this.mModel.setSex(this.bQx);
            return;
        }
        Intent intent = getIntent();
        this.mModel.bZ(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.bQx = intent.getIntExtra(com.baidu.tbadk.core.frameworkData.a.USER_SEX, 0);
        this.mModel.setSex(this.bQx);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.adh());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(com.baidu.tbadk.core.frameworkData.a.USER_SEX, this.bQx);
    }

    private void initUI() {
        boolean z = true;
        this.aWN = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mTitleText = this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.adh()) {
                this.mTitleText.setText(com.baidu.tieba.y.my_attention);
            } else {
                this.mTitleText.setText(com.baidu.tieba.y.fans);
            }
        } else if (this.mModel.adh()) {
            if (this.bQx == 2) {
                this.mTitleText.setText(com.baidu.tieba.y.her_attention_people);
            } else if (this.bQx == 1) {
                this.mTitleText.setText(com.baidu.tieba.y.his_attention_people);
            } else {
                this.mTitleText.setText(com.baidu.tieba.y.his_attention_people);
            }
        } else if (this.bQx == 2) {
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
        this.bQu = new bh(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, this.mModel.getSex(), bcVar, bdVar, bfVar, beVar);
        this.mListView = (BdListView) findViewById(com.baidu.tieba.v.list);
        this.mListView.setAdapter((ListAdapter) this.bQu);
        this.bQr = com.baidu.adp.lib.g.b.hH().inflate(getPageContext().getPageActivity(), com.baidu.tieba.w.person_list_newheader, null);
        this.bQs = this.bQr.findViewById(com.baidu.tieba.v.newheader_root);
        this.bQr.setVisibility(8);
        this.bQr.setClickable(false);
        this.bQr.setEnabled(false);
        this.bQt = (TextView) this.bQr.findViewById(com.baidu.tieba.v.person_list_title);
        this.mListView.addHeaderView(this.bQr, null, false);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.aWN, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.mListView.setOnSrollToBottomListener(new bg(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tieba.person.a.a aVar, boolean z) {
        if (this.mModel != null && aVar != null && (!z || !this.bQw)) {
            if (!z) {
                this.bQw = true;
                a(aVar);
            }
            c(aVar, z);
            if (!this.mModel.adh()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.uT().setMsgFans(0);
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
            if (aVar.XE().qi() > 0) {
                this.bQr.setVisibility(0);
                this.mListView.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                if (this.mModel.adh()) {
                    if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        string = getPageContext().getString(com.baidu.tieba.y.my_attention_prefix);
                        string2 = getPageContext().getString(com.baidu.tieba.y.person);
                        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.not_have_attention));
                    } else {
                        if (this.bQx == 2) {
                            string3 = getPageContext().getString(com.baidu.tieba.y.she_attention_prefix);
                            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.her_no_attention_other));
                        } else if (this.bQx == 1) {
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
                } else if (this.bQx == 2) {
                    string = getPageContext().getString(com.baidu.tieba.y.her_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.y.her_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.her_no_fan_other));
                } else if (this.bQx == 1) {
                    string = getPageContext().getString(com.baidu.tieba.y.his_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.y.her_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.him_no_fan_other));
                } else {
                    string = getPageContext().getString(com.baidu.tieba.y.his_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.y.her_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.him_no_fan_other));
                }
                this.bQt.setText(String.valueOf(string) + String.valueOf(aVar.XE().qi()) + string2);
                return;
            }
            this.bQr.setVisibility(8);
            this.mListView.setVisibility(8);
            if (!z) {
                this.mNoDataView.setVisibility(0);
            }
            if (this.mModel.adh()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.not_have_attention));
                } else if (this.bQx == 2) {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.her_no_attention_other));
                } else if (this.bQx == 1) {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.him_no_attention_other));
                } else {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.him_no_attention_other));
                }
            } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.not_have_fans));
            } else if (this.bQx == 2) {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.her_no_fan_other));
            } else if (this.bQx == 1) {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.him_no_fan_other));
            } else {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.him_no_fan_other));
            }
        }
    }

    private void a(com.baidu.tieba.person.a.a aVar) {
        this.mModel.hA(aVar.XE().qj());
    }

    private void c(com.baidu.tieba.person.a.a aVar, boolean z) {
        boolean z2 = true;
        if (this.bQu != null) {
            if (!z) {
                if (aVar.XE().qj() == 1) {
                    this.bQu.resetData();
                }
                com.baidu.tbadk.core.data.q XE = aVar.XE();
                bh bhVar = this.bQu;
                if (XE == null || XE.ql() != 1) {
                    z2 = false;
                }
                bhVar.setHasMore(z2);
                this.bQu.P(aVar.adm());
                this.bQu.ef(false);
                this.bQu.XU();
                this.bQu.notifyDataSetChanged();
                return;
            }
            this.bQu.setHasMore(false);
            this.bQu.P(aVar.adm());
            this.bQu.ef(false);
            this.bQu.XU();
            this.bQu.notifyDataSetChanged();
        }
    }

    private void adg() {
        this.mProgress.setVisibility(0);
        this.mModel.adk();
        this.mModel.adi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adc() {
        if (this.bQu != null) {
            this.bQu.ef(true);
            this.bQu.notifyDataSetChanged();
        }
        this.mModel.adi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void add() {
        UserData userData;
        if (this.bQu != null && this.bQu.getItemViewType(this.bPY) == 0 && (userData = (UserData) this.bQu.getItem(this.bPY)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            add();
        }
    }
}
