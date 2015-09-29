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
import com.baidu.tieba.i;
import com.baidu.tieba.person.bt;
import com.baidu.tieba.person.data.PersonListActivityConfig;
/* loaded from: classes.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private boolean cqz;
    private bt mModel;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private BdListView mListView = null;
    private View cqu = null;
    private View cqv = null;
    private TextView cqw = null;
    private ProgressBar mProgress = null;
    private bs cqx = null;
    private RelativeLayout brd = null;
    private boolean cqy = true;
    private TextView LM = null;
    private int cqA = 0;
    int cpY = 0;
    public bt.a cqB = new bm(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.person_list_activity);
        initData(bundle);
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mModel.aiP();
        this.mModel.Ij();
        if (this.cqy) {
            this.cqy = false;
            aiM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mModel.aiR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.brd);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cqx.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.cqv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cqx != null) {
            this.cqx = null;
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new bt(this, this.cqB);
        if (bundle != null) {
            this.mModel.cl(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.cqA = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.cqA);
            return;
        }
        Intent intent = getIntent();
        this.mModel.cl(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.cqA = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.cqA);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aiN());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.cqA);
    }

    private void initUI() {
        boolean z = true;
        this.brd = (RelativeLayout) findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.LM = this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aiN()) {
                this.LM.setText(i.h.my_attention);
            } else {
                this.LM.setText(i.h.fans);
            }
        } else if (this.mModel.aiN()) {
            if (this.cqA == 2) {
                this.LM.setText(i.h.her_attention_people);
            } else if (this.cqA == 1) {
                this.LM.setText(i.h.his_attention_people);
            } else {
                this.LM.setText(i.h.his_attention_people);
            }
        } else if (this.cqA == 2) {
            this.LM.setText(i.h.attention_to_her);
        } else {
            this.LM.setText(i.h.attention_to_him);
        }
        bn bnVar = new bn(this);
        bo boVar = new bo(this);
        bp bpVar = new bp(this);
        bq bqVar = new bq(this);
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        this.cqx = new bs(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, this.mModel.getSex(), bnVar, boVar, bqVar, bpVar);
        this.mListView = (BdListView) findViewById(i.f.list);
        this.mListView.setAdapter((ListAdapter) this.cqx);
        this.cqu = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.person_list_newheader, (ViewGroup) null);
        this.cqv = this.cqu.findViewById(i.f.newheader_root);
        this.cqu.setVisibility(8);
        this.cqu.setClickable(false);
        this.cqu.setEnabled(false);
        this.cqw = (TextView) this.cqu.findViewById(i.f.person_list_title);
        this.mListView.addHeaderView(this.cqu, null, false);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.brd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.mListView.setOnSrollToBottomListener(new br(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tieba.person.data.a aVar, boolean z) {
        if (this.mModel != null && aVar != null && (!z || !this.cqz)) {
            if (!z) {
                this.cqz = true;
                a(aVar);
            }
            c(aVar, z);
            if (!this.mModel.aiN()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgFans(0);
            }
            b(aVar, z);
        }
    }

    private void b(com.baidu.tieba.person.data.a aVar, boolean z) {
        String string;
        String string2;
        String string3;
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            if (this.mModel.getPage() == 1) {
                this.mProgress.setVisibility(8);
            }
            if (aVar.getPage().rI() > 0) {
                this.cqu.setVisibility(0);
                this.mListView.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                if (this.mModel.aiN()) {
                    if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        string = getPageContext().getString(i.h.my_attention_prefix);
                        string2 = getPageContext().getString(i.h.person);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.not_have_attention));
                    } else {
                        if (this.cqA == 2) {
                            string3 = getPageContext().getString(i.h.she_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.her_no_attention_other));
                        } else if (this.cqA == 1) {
                            string3 = getPageContext().getString(i.h.he_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.him_no_attention_other));
                        } else {
                            string3 = getPageContext().getString(i.h.he_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.him_no_attention_other));
                        }
                        string = string3;
                        string2 = getPageContext().getString(i.h.person);
                    }
                } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(i.h.my_fans_prefix);
                    string2 = getPageContext().getString(i.h.my_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.not_have_fans));
                } else if (this.cqA == 2) {
                    string = getPageContext().getString(i.h.her_fans_prefix);
                    string2 = getPageContext().getString(i.h.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.her_no_fan_other));
                } else if (this.cqA == 1) {
                    string = getPageContext().getString(i.h.his_fans_prefix);
                    string2 = getPageContext().getString(i.h.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.him_no_fan_other));
                } else {
                    string = getPageContext().getString(i.h.his_fans_prefix);
                    string2 = getPageContext().getString(i.h.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.him_no_fan_other));
                }
                this.cqw.setText(String.valueOf(string) + String.valueOf(aVar.getPage().rI()) + string2);
                return;
            }
            this.cqu.setVisibility(8);
            this.mListView.setVisibility(8);
            if (!z) {
                this.mNoDataView.setVisibility(0);
            }
            if (this.mModel.aiN()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.not_have_attention));
                } else if (this.cqA == 2) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.her_no_attention_other));
                } else if (this.cqA == 1) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.him_no_attention_other));
                } else {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.him_no_attention_other));
                }
            } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.not_have_fans));
            } else if (this.cqA == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.her_no_fan_other));
            } else if (this.cqA == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.him_no_fan_other));
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.him_no_fan_other));
            }
        }
    }

    private void a(com.baidu.tieba.person.data.a aVar) {
        this.mModel.ji(aVar.getPage().rJ());
    }

    private void c(com.baidu.tieba.person.data.a aVar, boolean z) {
        boolean z2 = true;
        if (this.cqx != null) {
            if (!z) {
                if (aVar.getPage().rJ() == 1) {
                    this.cqx.resetData();
                }
                com.baidu.tbadk.core.data.n page = aVar.getPage();
                bs bsVar = this.cqx;
                if (page == null || page.rL() != 1) {
                    z2 = false;
                }
                bsVar.setHasMore(z2);
                this.cqx.T(aVar.aiS());
                this.cqx.eW(false);
                this.cqx.adx();
                this.cqx.notifyDataSetChanged();
                return;
            }
            this.cqx.setHasMore(false);
            this.cqx.T(aVar.aiS());
            this.cqx.eW(false);
            this.cqx.adx();
            this.cqx.notifyDataSetChanged();
        }
    }

    private void aiM() {
        this.mProgress.setVisibility(0);
        this.mModel.aiQ();
        this.mModel.aiO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiH() {
        if (this.cqx != null) {
            this.cqx.eW(true);
            this.cqx.notifyDataSetChanged();
        }
        this.mModel.aiO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiI() {
        UserData userData;
        if (this.cqx != null && this.cqx.getItemViewType(this.cpY) == 0 && (userData = (UserData) this.cqx.getItem(this.cpY)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            aiI();
        }
    }
}
