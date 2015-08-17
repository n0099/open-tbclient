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
    private boolean cka;
    private bs mModel;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.u mNoDataView;
    private BdListView mListView = null;
    private View cjV = null;
    private View cjW = null;
    private TextView cjX = null;
    private ProgressBar mProgress = null;
    private br cjY = null;
    private RelativeLayout bnG = null;
    private boolean cjZ = true;
    private TextView LM = null;
    private int ckb = 0;
    int cjz = 0;
    public bs.a ckc = new bl(this);

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
        this.mModel.agz();
        this.mModel.Iz();
        if (this.cjZ) {
            this.cjZ = false;
            agw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mModel.agB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.bnG);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cjY.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.cjW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cjY != null) {
            this.cjY = null;
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new bs(this, this.ckc);
        if (bundle != null) {
            this.mModel.cj(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.ckb = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.ckb);
            return;
        }
        Intent intent = getIntent();
        this.mModel.cj(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.ckb = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.ckb);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.agx());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.ckb);
    }

    private void initUI() {
        boolean z = true;
        this.bnG = (RelativeLayout) findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.LM = this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.agx()) {
                this.LM.setText(i.C0057i.my_attention);
            } else {
                this.LM.setText(i.C0057i.fans);
            }
        } else if (this.mModel.agx()) {
            if (this.ckb == 2) {
                this.LM.setText(i.C0057i.her_attention_people);
            } else if (this.ckb == 1) {
                this.LM.setText(i.C0057i.his_attention_people);
            } else {
                this.LM.setText(i.C0057i.his_attention_people);
            }
        } else if (this.ckb == 2) {
            this.LM.setText(i.C0057i.attention_to_her);
        } else {
            this.LM.setText(i.C0057i.attention_to_him);
        }
        bm bmVar = new bm(this);
        bn bnVar = new bn(this);
        bo boVar = new bo(this);
        bp bpVar = new bp(this);
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        this.cjY = new br(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, this.mModel.getSex(), bmVar, bnVar, bpVar, boVar);
        this.mListView = (BdListView) findViewById(i.f.list);
        this.mListView.setAdapter((ListAdapter) this.cjY);
        this.cjV = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.person_list_newheader, (ViewGroup) null);
        this.cjW = this.cjV.findViewById(i.f.newheader_root);
        this.cjV.setVisibility(8);
        this.cjV.setClickable(false);
        this.cjV.setEnabled(false);
        this.cjX = (TextView) this.cjV.findViewById(i.f.person_list_title);
        this.mListView.addHeaderView(this.cjV, null, false);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.bnG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.mListView.setOnSrollToBottomListener(new bq(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tieba.person.a.a aVar, boolean z) {
        if (this.mModel != null && aVar != null && (!z || !this.cka)) {
            if (!z) {
                this.cka = true;
                a(aVar);
            }
            c(aVar, z);
            if (!this.mModel.agx()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.wT().setMsgFans(0);
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
            if (aVar.getPage().rQ() > 0) {
                this.cjV.setVisibility(0);
                this.mListView.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                if (this.mModel.agx()) {
                    if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        string = getPageContext().getString(i.C0057i.my_attention_prefix);
                        string2 = getPageContext().getString(i.C0057i.person);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.not_have_attention));
                    } else {
                        if (this.ckb == 2) {
                            string3 = getPageContext().getString(i.C0057i.she_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.her_no_attention_other));
                        } else if (this.ckb == 1) {
                            string3 = getPageContext().getString(i.C0057i.he_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.him_no_attention_other));
                        } else {
                            string3 = getPageContext().getString(i.C0057i.he_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.him_no_attention_other));
                        }
                        string = string3;
                        string2 = getPageContext().getString(i.C0057i.person);
                    }
                } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(i.C0057i.my_fans_prefix);
                    string2 = getPageContext().getString(i.C0057i.my_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.not_have_fans));
                } else if (this.ckb == 2) {
                    string = getPageContext().getString(i.C0057i.her_fans_prefix);
                    string2 = getPageContext().getString(i.C0057i.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.her_no_fan_other));
                } else if (this.ckb == 1) {
                    string = getPageContext().getString(i.C0057i.his_fans_prefix);
                    string2 = getPageContext().getString(i.C0057i.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.him_no_fan_other));
                } else {
                    string = getPageContext().getString(i.C0057i.his_fans_prefix);
                    string2 = getPageContext().getString(i.C0057i.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.him_no_fan_other));
                }
                this.cjX.setText(String.valueOf(string) + String.valueOf(aVar.getPage().rQ()) + string2);
                return;
            }
            this.cjV.setVisibility(8);
            this.mListView.setVisibility(8);
            if (!z) {
                this.mNoDataView.setVisibility(0);
            }
            if (this.mModel.agx()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.not_have_attention));
                } else if (this.ckb == 2) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.her_no_attention_other));
                } else if (this.ckb == 1) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.him_no_attention_other));
                } else {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.him_no_attention_other));
                }
            } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.not_have_fans));
            } else if (this.ckb == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.her_no_fan_other));
            } else if (this.ckb == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.him_no_fan_other));
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.him_no_fan_other));
            }
        }
    }

    private void a(com.baidu.tieba.person.a.a aVar) {
        this.mModel.iM(aVar.getPage().rR());
    }

    private void c(com.baidu.tieba.person.a.a aVar, boolean z) {
        boolean z2 = true;
        if (this.cjY != null) {
            if (!z) {
                if (aVar.getPage().rR() == 1) {
                    this.cjY.resetData();
                }
                com.baidu.tbadk.core.data.p page = aVar.getPage();
                br brVar = this.cjY;
                if (page == null || page.rT() != 1) {
                    z2 = false;
                }
                brVar.setHasMore(z2);
                this.cjY.S(aVar.agC());
                this.cjY.eH(false);
                this.cjY.abX();
                this.cjY.notifyDataSetChanged();
                return;
            }
            this.cjY.setHasMore(false);
            this.cjY.S(aVar.agC());
            this.cjY.eH(false);
            this.cjY.abX();
            this.cjY.notifyDataSetChanged();
        }
    }

    private void agw() {
        this.mProgress.setVisibility(0);
        this.mModel.agA();
        this.mModel.agy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agr() {
        if (this.cjY != null) {
            this.cjY.eH(true);
            this.cjY.notifyDataSetChanged();
        }
        this.mModel.agy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ags() {
        UserData userData;
        if (this.cjY != null && this.cjY.getItemViewType(this.cjz) == 0 && (userData = (UserData) this.cjY.getItem(this.cjz)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            ags();
        }
    }
}
