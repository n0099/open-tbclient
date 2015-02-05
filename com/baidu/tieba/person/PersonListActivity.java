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
    private boolean bIo;
    private bl mModel;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private BdListView mListView = null;
    private View bIj = null;
    private View bIk = null;
    private TextView bIl = null;
    private ProgressBar mProgress = null;
    private bj bIm = null;
    private RelativeLayout mParent = null;
    private boolean bIn = true;
    private TextView mTitleText = null;
    private int bIp = 0;
    int bHQ = 0;
    public bo bIq = new bd(this);

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
        this.mModel.aaZ();
        this.mModel.Jx();
        if (this.bIn) {
            this.bIn = false;
            UB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mModel.abb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bIm.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.bIk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bIm != null) {
            this.bIm = null;
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new bl(this, this.bIq);
        if (bundle != null) {
            this.mModel.bU(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.bIp = bundle.getInt(com.baidu.tbadk.core.frameworkData.a.USER_SEX);
            this.mModel.setSex(this.bIp);
            return;
        }
        Intent intent = getIntent();
        this.mModel.bU(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.bIp = intent.getIntExtra(com.baidu.tbadk.core.frameworkData.a.USER_SEX, 0);
        this.mModel.setSex(this.bIp);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aaX());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(com.baidu.tbadk.core.frameworkData.a.USER_SEX, this.bIp);
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
            if (this.mModel.aaX()) {
                this.mTitleText.setText(com.baidu.tieba.z.my_attention);
            } else {
                this.mTitleText.setText(com.baidu.tieba.z.fans);
            }
        } else if (this.mModel.aaX()) {
            if (this.bIp == 2) {
                this.mTitleText.setText(com.baidu.tieba.z.her_attention_people);
            } else if (this.bIp == 1) {
                this.mTitleText.setText(com.baidu.tieba.z.his_attention_people);
            } else {
                this.mTitleText.setText(com.baidu.tieba.z.his_attention_people);
            }
        } else if (this.bIp == 2) {
            this.mTitleText.setText(com.baidu.tieba.z.attention_to_her);
        } else {
            this.mTitleText.setText(com.baidu.tieba.z.attention_to_him);
        }
        be beVar = new be(this);
        bf bfVar = new bf(this);
        bg bgVar = new bg(this);
        bh bhVar = new bh(this);
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        this.bIm = new bj(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, this.mModel.getSex(), beVar, bfVar, bhVar, bgVar);
        this.mListView = (BdListView) findViewById(com.baidu.tieba.w.list);
        this.mListView.setAdapter((ListAdapter) this.bIm);
        this.bIj = com.baidu.adp.lib.g.b.ei().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.person_list_newheader, null);
        this.bIk = this.bIj.findViewById(com.baidu.tieba.w.newheader_root);
        this.bIj.setVisibility(8);
        this.bIj.setClickable(false);
        this.bIj.setEnabled(false);
        this.bIl = (TextView) this.bIj.findViewById(com.baidu.tieba.w.person_list_title);
        this.mListView.addHeaderView(this.bIj, null, false);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mParent, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.mListView.setOnSrollToBottomListener(new bi(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tbadk.core.data.r rVar, boolean z) {
        if (this.mModel != null && rVar != null && (!z || !this.bIo)) {
            if (!z) {
                this.bIo = true;
                a(rVar);
            }
            c(rVar, z);
            if (!this.mModel.aaX()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.rS().setMsgFans(0);
            }
            b(rVar, z);
        }
    }

    private void b(com.baidu.tbadk.core.data.r rVar, boolean z) {
        String string;
        String string2;
        String string3;
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            if (this.mModel.getPage() == 1) {
                this.mProgress.setVisibility(8);
            }
            if (rVar.mT().mO() > 0) {
                this.bIj.setVisibility(0);
                this.mListView.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                if (this.mModel.aaX()) {
                    if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        string = getPageContext().getString(com.baidu.tieba.z.my_attention_prefix);
                        string2 = getPageContext().getString(com.baidu.tieba.z.person);
                        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.not_have_attention));
                    } else {
                        if (this.bIp == 2) {
                            string3 = getPageContext().getString(com.baidu.tieba.z.she_attention_prefix);
                            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.her_no_attention_other));
                        } else if (this.bIp == 1) {
                            string3 = getPageContext().getString(com.baidu.tieba.z.he_attention_prefix);
                            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.him_no_attention_other));
                        } else {
                            string3 = getPageContext().getString(com.baidu.tieba.z.he_attention_prefix);
                            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.him_no_attention_other));
                        }
                        string = string3;
                        string2 = getPageContext().getString(com.baidu.tieba.z.person);
                    }
                } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(com.baidu.tieba.z.my_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.z.my_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.not_have_fans));
                } else if (this.bIp == 2) {
                    string = getPageContext().getString(com.baidu.tieba.z.her_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.z.her_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.her_no_fan_other));
                } else if (this.bIp == 1) {
                    string = getPageContext().getString(com.baidu.tieba.z.his_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.z.her_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.him_no_fan_other));
                } else {
                    string = getPageContext().getString(com.baidu.tieba.z.his_fans_prefix);
                    string2 = getPageContext().getString(com.baidu.tieba.z.her_fans_suffix);
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.him_no_fan_other));
                }
                this.bIl.setText(String.valueOf(string) + String.valueOf(rVar.mT().mO()) + string2);
                return;
            }
            this.bIj.setVisibility(8);
            this.mListView.setVisibility(8);
            if (!z) {
                this.mNoDataView.setVisibility(0);
            }
            if (this.mModel.aaX()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.not_have_attention));
                } else if (this.bIp == 2) {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.her_no_attention_other));
                } else if (this.bIp == 1) {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.him_no_attention_other));
                } else {
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.him_no_attention_other));
                }
            } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.not_have_fans));
            } else if (this.bIp == 2) {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.her_no_fan_other));
            } else if (this.bIp == 1) {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.him_no_fan_other));
            } else {
                this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.him_no_fan_other));
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.r rVar) {
        this.mModel.hr(rVar.mT().mP());
    }

    private void c(com.baidu.tbadk.core.data.r rVar, boolean z) {
        boolean z2 = true;
        if (this.bIm != null) {
            if (!z) {
                if (rVar.mT().mP() == 1) {
                    this.bIm.resetData();
                }
                com.baidu.tbadk.core.data.q mT = rVar.mT();
                bj bjVar = this.bIm;
                if (mT == null || mT.mR() != 1) {
                    z2 = false;
                }
                bjVar.setHasMore(z2);
                this.bIm.L(rVar.mU());
                this.bIm.ei(false);
                this.bIm.WC();
                this.bIm.notifyDataSetChanged();
                return;
            }
            this.bIm.setHasMore(false);
            this.bIm.L(rVar.mU());
            this.bIm.ei(false);
            this.bIm.WC();
            this.bIm.notifyDataSetChanged();
        }
    }

    private void UB() {
        this.mProgress.setVisibility(0);
        this.mModel.aba();
        this.mModel.aaY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaT() {
        if (this.bIm != null) {
            this.bIm.ei(true);
            this.bIm.notifyDataSetChanged();
        }
        this.mModel.aaY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaU() {
        UserData userData;
        if (this.bIm != null && this.bIm.getItemViewType(this.bHQ) == 0 && (userData = (UserData) this.bIm.getItem(this.bHQ)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            aaU();
        }
    }
}
