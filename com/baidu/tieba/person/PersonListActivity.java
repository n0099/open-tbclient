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
    private boolean cZn;
    private bv mModel;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private BdListView IY = null;
    private View cZi = null;
    private View cZj = null;
    private TextView cZk = null;
    private ProgressBar aNo = null;
    private bu cZl = null;
    private RelativeLayout bOs = null;
    private boolean cZm = true;
    private TextView ML = null;
    private int cZo = 0;
    int cYM = 0;
    public bv.a cZp = new bo(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.person_list_activity);
        initData(bundle);
        qD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mModel.atY();
        this.mModel.LX();
        if (this.cZm) {
            this.cZm = false;
            atV();
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
        getLayoutMode().ac(i == 1);
        getLayoutMode().x(this.bOs);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cZl.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ac(i == 1);
        getLayoutMode().x(this.cZj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cZl != null) {
            this.cZl = null;
        }
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new bv(this, this.cZp);
        if (bundle != null) {
            this.mModel.cB(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString("user_id"));
            this.cZo = bundle.getInt(IntentConfig.USER_SEX);
            this.mModel.setSex(this.cZo);
            return;
        }
        Intent intent = getIntent();
        this.mModel.cB(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.cZo = intent.getIntExtra(IntentConfig.USER_SEX, 0);
        this.mModel.setSex(this.cZo);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.atW());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt(IntentConfig.USER_SEX, this.cZo);
    }

    private void qD() {
        boolean z = true;
        this.bOs = (RelativeLayout) findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.ML = this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aNo = (ProgressBar) findViewById(t.g.progress);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.atW()) {
                this.ML.setText(t.j.my_attention);
            } else {
                this.ML.setText(t.j.fans);
            }
        } else if (this.mModel.atW()) {
            if (this.cZo == 2) {
                this.ML.setText(t.j.her_attention_people);
            } else if (this.cZo == 1) {
                this.ML.setText(t.j.his_attention_people);
            } else {
                this.ML.setText(t.j.his_attention_people);
            }
        } else if (this.cZo == 2) {
            this.ML.setText(t.j.attention_to_her);
        } else {
            this.ML.setText(t.j.attention_to_him);
        }
        bp bpVar = new bp(this);
        bq bqVar = new bq(this);
        br brVar = new br(this);
        bs bsVar = new bs(this);
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        this.cZl = new bu(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, this.mModel.getSex(), bpVar, bqVar, bsVar, brVar);
        this.IY = (BdListView) findViewById(t.g.list);
        this.IY.setAdapter((ListAdapter) this.cZl);
        this.cZi = LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.person_list_newheader, (ViewGroup) null);
        this.cZj = this.cZi.findViewById(t.g.newheader_root);
        this.cZi.setVisibility(8);
        this.cZi.setClickable(false);
        this.cZi.setEnabled(false);
        this.cZk = (TextView) this.cZi.findViewById(t.g.person_list_title);
        this.IY.addHeaderView(this.cZi, null, false);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.bOs, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.IY.setOnSrollToBottomListener(new bt(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tieba.person.data.r rVar, boolean z) {
        if (this.mModel != null && rVar != null && (!z || !this.cZn)) {
            if (!z) {
                this.cZn = true;
                a(rVar);
            }
            c(rVar, z);
            if (!this.mModel.atW()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgFans(0);
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
                this.aNo.setVisibility(8);
            }
            if (rVar.getPage().sr() > 0) {
                this.cZi.setVisibility(0);
                this.IY.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                if (this.mModel.atW()) {
                    if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        string = getPageContext().getString(t.j.my_attention_prefix);
                        string2 = getPageContext().getString(t.j.person);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.not_have_attention));
                    } else {
                        if (this.cZo == 2) {
                            string3 = getPageContext().getString(t.j.she_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.her_no_attention_other));
                        } else if (this.cZo == 1) {
                            string3 = getPageContext().getString(t.j.he_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.him_no_attention_other));
                        } else {
                            string3 = getPageContext().getString(t.j.he_attention_prefix);
                            this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.him_no_attention_other));
                        }
                        string = string3;
                        string2 = getPageContext().getString(t.j.person);
                    }
                } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(t.j.my_fans_prefix);
                    string2 = getPageContext().getString(t.j.my_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.not_have_fans));
                } else if (this.cZo == 2) {
                    string = getPageContext().getString(t.j.her_fans_prefix);
                    string2 = getPageContext().getString(t.j.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.her_no_fan_other));
                } else if (this.cZo == 1) {
                    string = getPageContext().getString(t.j.his_fans_prefix);
                    string2 = getPageContext().getString(t.j.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.him_no_fan_other));
                } else {
                    string = getPageContext().getString(t.j.his_fans_prefix);
                    string2 = getPageContext().getString(t.j.her_fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.him_no_fan_other));
                }
                this.cZk.setText(String.valueOf(string) + String.valueOf(rVar.getPage().sr()) + string2);
                return;
            }
            this.cZi.setVisibility(8);
            this.IY.setVisibility(8);
            if (!z) {
                this.mNoDataView.setVisibility(0);
            }
            if (this.mModel.atW()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.not_have_attention));
                } else if (this.cZo == 2) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.her_no_attention_other));
                } else if (this.cZo == 1) {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.him_no_attention_other));
                } else {
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.him_no_attention_other));
                }
            } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.not_have_fans));
            } else if (this.cZo == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.her_no_fan_other));
            } else if (this.cZo == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.him_no_fan_other));
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.him_no_fan_other));
            }
        }
    }

    private void a(com.baidu.tieba.person.data.r rVar) {
        this.mModel.lt(rVar.getPage().st());
    }

    private void c(com.baidu.tieba.person.data.r rVar, boolean z) {
        boolean z2 = true;
        if (this.cZl != null) {
            if (!z) {
                if (rVar.getPage().st() == 1) {
                    this.cZl.resetData();
                }
                com.baidu.tbadk.core.data.u page = rVar.getPage();
                bu buVar = this.cZl;
                if (page == null || page.sv() != 1) {
                    z2 = false;
                }
                buVar.setHasMore(z2);
                this.cZl.Z(rVar.auw());
                this.cZl.fS(false);
                this.cZl.ann();
                this.cZl.notifyDataSetChanged();
                return;
            }
            this.cZl.setHasMore(false);
            this.cZl.Z(rVar.auw());
            this.cZl.fS(false);
            this.cZl.ann();
            this.cZl.notifyDataSetChanged();
        }
    }

    private void atV() {
        this.aNo.setVisibility(0);
        this.mModel.atZ();
        this.mModel.atX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atQ() {
        if (this.cZl != null) {
            this.cZl.fS(true);
            this.cZl.notifyDataSetChanged();
        }
        this.mModel.atX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atR() {
        UserData userData;
        if (this.cZl != null && this.cZl.getItemViewType(this.cYM) == 0 && (userData = (UserData) this.cZl.getItem(this.cYM)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
            atR();
        }
    }
}
