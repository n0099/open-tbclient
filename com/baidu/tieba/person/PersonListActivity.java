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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes.dex */
public class PersonListActivity extends BaseActivity {
    private com.baidu.tbadk.core.view.o ahO;
    private boolean bCQ;
    private bt mModel;
    private NavigationBar mNavigationBar;
    private BdListView vl = null;
    private View bCL = null;
    private View bCM = null;
    private TextView bCN = null;
    private ProgressBar mProgress = null;
    private br bCO = null;
    private RelativeLayout mParent = null;
    private boolean bCP = true;
    private TextView atA = null;
    private int bCR = 0;
    int bCs = 0;
    public bw bCS = new bl(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(PersonListActivityConfig.class, PersonListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.person_list_activity);
        d(bundle);
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mModel.aag();
        this.mModel.HM();
        if (this.bCP) {
            this.bCP = false;
            Ts();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mModel.aai();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(i);
        this.bCO.notifyDataSetChanged();
        if (this.ahO != null) {
            this.ahO.onChangeSkinType(i);
        }
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.bCM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bCO != null) {
            this.bCO.Sy();
            this.bCO = null;
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void d(Bundle bundle) {
        this.mModel = new bt(this, this.bCS);
        if (bundle != null) {
            this.mModel.ev(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString(com.baidu.tbadk.core.frameworkData.a.USER_ID));
            this.bCR = bundle.getInt(com.baidu.tbadk.core.frameworkData.a.USER_SEX);
            this.mModel.setSex(this.bCR);
            return;
        }
        Intent intent = getIntent();
        this.mModel.ev(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID));
        this.bCR = intent.getIntExtra(com.baidu.tbadk.core.frameworkData.a.USER_SEX, 0);
        this.mModel.setSex(this.bCR);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aae());
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.USER_ID, this.mModel.getId());
        bundle.putInt(com.baidu.tbadk.core.frameworkData.a.USER_SEX, this.bCR);
    }

    private void initUI() {
        boolean z = true;
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.atA = this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        String currentAccount = TbadkApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aae()) {
                this.atA.setText(com.baidu.tieba.y.my_attention);
            } else {
                this.atA.setText(com.baidu.tieba.y.fans);
            }
        } else if (this.mModel.aae()) {
            if (this.bCR == 2) {
                this.atA.setText(com.baidu.tieba.y.her_attention_people);
            } else if (this.bCR == 1) {
                this.atA.setText(com.baidu.tieba.y.his_attention_people);
            } else {
                this.atA.setText(com.baidu.tieba.y.his_attention_people);
            }
        } else if (this.bCR == 2) {
            this.atA.setText(com.baidu.tieba.y.attention_to_her);
        } else {
            this.atA.setText(com.baidu.tieba.y.attention_to_him);
        }
        bm bmVar = new bm(this);
        bn bnVar = new bn(this);
        bo boVar = new bo(this);
        bp bpVar = new bp(this);
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkApplication.getCurrentAccount())) {
            z = false;
        }
        this.bCO = new br(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, this.mModel.getSex(), bmVar, bnVar, bpVar, boVar);
        this.vl = (BdListView) findViewById(com.baidu.tieba.v.list);
        this.vl.setAdapter((ListAdapter) this.bCO);
        this.bCL = com.baidu.adp.lib.g.b.ek().inflate(this, com.baidu.tieba.w.person_list_newheader, null);
        this.bCM = this.bCL.findViewById(com.baidu.tieba.v.newheader_root);
        this.bCL.setVisibility(8);
        this.bCL.setClickable(false);
        this.bCL.setEnabled(false);
        this.bCN = (TextView) this.bCL.findViewById(com.baidu.tieba.v.person_list_title);
        this.vl.addHeaderView(this.bCL, null, false);
        this.ahO = NoDataViewFactory.a(this, this.mParent, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.vl.setOnSrollToBottomListener(new bq(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tieba.data.aj ajVar, boolean z) {
        if (this.mModel != null && ajVar != null && (!z || !this.bCQ)) {
            if (!z) {
                this.bCQ = true;
                a(ajVar);
            }
            c(ajVar, z);
            if (!this.mModel.aae()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.oB().setMsgFans(0);
            }
            b(ajVar, z);
        }
    }

    private void b(com.baidu.tieba.data.aj ajVar, boolean z) {
        String string;
        String string2;
        String string3;
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            if (this.mModel.getPage() == 1) {
                this.mProgress.setVisibility(8);
            }
            if (ajVar.zM().ke() > 0) {
                this.bCL.setVisibility(0);
                this.vl.setVisibility(0);
                this.ahO.setVisibility(8);
                if (this.mModel.aae()) {
                    if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkApplication.getCurrentAccount())) {
                        string = getString(com.baidu.tieba.y.my_attention_prefix);
                        string2 = getString(com.baidu.tieba.y.person);
                        this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.not_have_attention));
                    } else {
                        if (this.bCR == 2) {
                            string3 = getString(com.baidu.tieba.y.she_attention_prefix);
                            this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.her_no_attention_other));
                        } else if (this.bCR == 1) {
                            string3 = getString(com.baidu.tieba.y.he_attention_prefix);
                            this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_attention_other));
                        } else {
                            string3 = getString(com.baidu.tieba.y.he_attention_prefix);
                            this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_attention_other));
                        }
                        string = string3;
                        string2 = getString(com.baidu.tieba.y.person);
                    }
                } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkApplication.getCurrentAccount())) {
                    string = getString(com.baidu.tieba.y.my_fans_prefix);
                    string2 = getString(com.baidu.tieba.y.my_fans_suffix);
                    this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.not_have_fans));
                } else if (this.bCR == 2) {
                    string = getString(com.baidu.tieba.y.her_fans_prefix);
                    string2 = getString(com.baidu.tieba.y.her_fans_suffix);
                    this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.her_no_fan_other));
                } else if (this.bCR == 1) {
                    string = getString(com.baidu.tieba.y.his_fans_prefix);
                    string2 = getString(com.baidu.tieba.y.her_fans_suffix);
                    this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_fan_other));
                } else {
                    string = getString(com.baidu.tieba.y.his_fans_prefix);
                    string2 = getString(com.baidu.tieba.y.her_fans_suffix);
                    this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_fan_other));
                }
                this.bCN.setText(String.valueOf(string) + String.valueOf(ajVar.zM().ke()) + string2);
                return;
            }
            this.bCL.setVisibility(8);
            this.vl.setVisibility(8);
            if (!z) {
                this.ahO.setVisibility(0);
            }
            if (this.mModel.aae()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkApplication.getCurrentAccount())) {
                    this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.not_have_attention));
                } else if (this.bCR == 2) {
                    this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.her_no_attention_other));
                } else if (this.bCR == 1) {
                    this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_attention_other));
                } else {
                    this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_attention_other));
                }
            } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkApplication.getCurrentAccount())) {
                this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.not_have_fans));
            } else if (this.bCR == 2) {
                this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.her_no_fan_other));
            } else if (this.bCR == 1) {
                this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_fan_other));
            } else {
                this.ahO.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_fan_other));
            }
        }
    }

    private void a(com.baidu.tieba.data.aj ajVar) {
        this.mModel.gZ(ajVar.zM().kf());
    }

    private void c(com.baidu.tieba.data.aj ajVar, boolean z) {
        boolean z2 = true;
        if (this.bCO != null) {
            if (!z) {
                if (ajVar.zM().kf() == 1) {
                    this.bCO.resetData();
                }
                com.baidu.tbadk.core.data.m zM = ajVar.zM();
                br brVar = this.bCO;
                if (zM == null || zM.kh() != 1) {
                    z2 = false;
                }
                brVar.setHasMore(z2);
                this.bCO.G(ajVar.zY());
                this.bCO.eu(false);
                this.bCO.ZG();
                this.bCO.notifyDataSetChanged();
                return;
            }
            this.bCO.setHasMore(false);
            this.bCO.G(ajVar.zY());
            this.bCO.eu(false);
            this.bCO.ZG();
            this.bCO.notifyDataSetChanged();
        }
    }

    private void Ts() {
        this.mProgress.setVisibility(0);
        this.mModel.aah();
        this.mModel.aaf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaa() {
        if (this.bCO != null) {
            this.bCO.eu(true);
            this.bCO.notifyDataSetChanged();
        }
        this.mModel.aaf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        UserData userData;
        if (this.bCO != null && this.bCO.getItemViewType(this.bCs) == 0 && (userData = (UserData) this.bCO.getItem(this.bCs)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(this, "enter_chat", "personlistclick", 1, new Object[0]);
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getPortrait(), userData.getSex())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 11028) {
            aab();
        }
    }
}
