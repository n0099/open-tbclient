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
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import com.baidu.tieba.person.bs;
/* loaded from: classes.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private boolean ckV;
    private bs mModel;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.u mNoDataView;
    private BdListView mListView = null;
    private View ckQ = null;
    private View ckR = null;
    private TextView ckS = null;
    private ProgressBar mProgress = null;
    private br ckT = null;
    private RelativeLayout boe = null;
    private boolean ckU = true;
    private TextView LM = null;
    private int ckW = 0;
    int cku = 0;
    public bs.a ckX = new bl(this);

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
        this.mModel.agP();
        this.mModel.In();
        if (this.ckU) {
            this.ckU = false;
            agM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mModel.agR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.boe);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ckT.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.ckR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ckT != null) {
            this.ckT = null;
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new bs(this, this.ckX);
        if (bundle != null) {
            this.mModel.co(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.ckW = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.ckW);
            return;
        }
        Intent intent = getIntent();
        this.mModel.co(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.ckW = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.ckW);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.agN());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.ckW);
    }

    private void initUI() {
        boolean z = true;
        this.boe = (RelativeLayout) findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.LM = this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.agN()) {
                this.LM.setText(i.h.my_attention);
            } else {
                this.LM.setText(i.h.fans);
            }
        } else if (this.mModel.agN()) {
            if (this.ckW == 2) {
                this.LM.setText(i.h.her_attention_people);
            } else if (this.ckW == 1) {
                this.LM.setText(i.h.his_attention_people);
            } else {
                this.LM.setText(i.h.his_attention_people);
            }
        } else if (this.ckW == 2) {
            this.LM.setText(i.h.attention_to_her);
        } else {
            this.LM.setText(i.h.attention_to_him);
        }
        bm bmVar = new bm(this);
        bn bnVar = new bn(this);
        bo boVar = new bo(this);
        bp bpVar = new bp(this);
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        this.ckT = new br(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, this.mModel.getSex(), bmVar, bnVar, bpVar, boVar);
        this.mListView = (BdListView) findViewById(i.f.list);
        this.mListView.setAdapter((ListAdapter) this.ckT);
        this.ckQ = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.person_list_newheader, (ViewGroup) null);
        this.ckR = this.ckQ.findViewById(i.f.newheader_root);
        this.ckQ.setVisibility(8);
        this.ckQ.setClickable(false);
        this.ckQ.setEnabled(false);
        this.ckS = (TextView) this.ckQ.findViewById(i.f.person_list_title);
        this.mListView.addHeaderView(this.ckQ, null, false);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.boe, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.mListView.setOnSrollToBottomListener(new bq(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tieba.person.a.a aVar, boolean z) {
        if (this.mModel != null && aVar != null && (!z || !this.ckV)) {
            if (!z) {
                this.ckV = true;
                a(aVar);
            }
            c(aVar, z);
            if (!this.mModel.agN()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgFans(0);
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
            if (aVar.getPage().rN() > 0) {
                this.ckQ.setVisibility(0);
                this.mListView.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                if (this.mModel.agN()) {
                    if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        string = getPageContext().getString(i.h.my_attention_prefix);
                        string2 = getPageContext().getString(i.h.person);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.not_have_attention));
                    } else {
                        if (this.ckW == 2) {
                            string3 = getPageContext().getString(i.h.she_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.her_no_attention_other));
                        } else if (this.ckW == 1) {
                            string3 = getPageContext().getString(i.h.he_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.him_no_attention_other));
                        } else {
                            string3 = getPageContext().getString(i.h.he_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.him_no_attention_other));
                        }
                        string = string3;
                        string2 = getPageContext().getString(i.h.person);
                    }
                } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(i.h.my_fans_prefix);
                    string2 = getPageContext().getString(i.h.my_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.not_have_fans));
                } else if (this.ckW == 2) {
                    string = getPageContext().getString(i.h.her_fans_prefix);
                    string2 = getPageContext().getString(i.h.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.her_no_fan_other));
                } else if (this.ckW == 1) {
                    string = getPageContext().getString(i.h.his_fans_prefix);
                    string2 = getPageContext().getString(i.h.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.him_no_fan_other));
                } else {
                    string = getPageContext().getString(i.h.his_fans_prefix);
                    string2 = getPageContext().getString(i.h.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.him_no_fan_other));
                }
                this.ckS.setText(String.valueOf(string) + String.valueOf(aVar.getPage().rN()) + string2);
                return;
            }
            this.ckQ.setVisibility(8);
            this.mListView.setVisibility(8);
            if (!z) {
                this.mNoDataView.setVisibility(0);
            }
            if (this.mModel.agN()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.not_have_attention));
                } else if (this.ckW == 2) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.her_no_attention_other));
                } else if (this.ckW == 1) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.him_no_attention_other));
                } else {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.him_no_attention_other));
                }
            } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.not_have_fans));
            } else if (this.ckW == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.her_no_fan_other));
            } else if (this.ckW == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.him_no_fan_other));
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.him_no_fan_other));
            }
        }
    }

    private void a(com.baidu.tieba.person.a.a aVar) {
        this.mModel.iY(aVar.getPage().rO());
    }

    private void c(com.baidu.tieba.person.a.a aVar, boolean z) {
        boolean z2 = true;
        if (this.ckT != null) {
            if (!z) {
                if (aVar.getPage().rO() == 1) {
                    this.ckT.resetData();
                }
                com.baidu.tbadk.core.data.o page = aVar.getPage();
                br brVar = this.ckT;
                if (page == null || page.rQ() != 1) {
                    z2 = false;
                }
                brVar.setHasMore(z2);
                this.ckT.S(aVar.agS());
                this.ckT.eQ(false);
                this.ckT.acf();
                this.ckT.notifyDataSetChanged();
                return;
            }
            this.ckT.setHasMore(false);
            this.ckT.S(aVar.agS());
            this.ckT.eQ(false);
            this.ckT.acf();
            this.ckT.notifyDataSetChanged();
        }
    }

    private void agM() {
        this.mProgress.setVisibility(0);
        this.mModel.agQ();
        this.mModel.agO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agH() {
        if (this.ckT != null) {
            this.ckT.eQ(true);
            this.ckT.notifyDataSetChanged();
        }
        this.mModel.agO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agI() {
        UserData userData;
        if (this.ckT != null && this.ckT.getItemViewType(this.cku) == 0 && (userData = (UserData) this.ckT.getItem(this.cku)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            agI();
        }
    }
}
