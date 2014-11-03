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
    private com.baidu.tbadk.core.view.o ahX;
    private boolean bDe;
    private bu mModel;
    private NavigationBar mNavigationBar;
    private BdListView vl = null;
    private View bCZ = null;
    private View bDa = null;
    private TextView bDb = null;
    private ProgressBar mProgress = null;
    private bs bDc = null;
    private RelativeLayout mParent = null;
    private boolean bDd = true;
    private TextView atJ = null;
    private int bDf = 0;
    int bCG = 0;
    public bx bDg = new bm(this);

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
        this.mModel.aai();
        this.mModel.HQ();
        if (this.bDd) {
            this.bDd = false;
            Tv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mModel.aak();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(i);
        this.bDc.notifyDataSetChanged();
        if (this.ahX != null) {
            this.ahX.onChangeSkinType(i);
        }
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.bDa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bDc != null) {
            this.bDc.SB();
            this.bDc = null;
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void d(Bundle bundle) {
        this.mModel = new bu(this, this.bDg);
        if (bundle != null) {
            this.mModel.ev(bundle.getBoolean(PersonListActivityConfig.FOLLOW, false));
            this.mModel.setId(bundle.getString(com.baidu.tbadk.core.frameworkData.a.USER_ID));
            this.bDf = bundle.getInt(com.baidu.tbadk.core.frameworkData.a.USER_SEX);
            this.mModel.setSex(this.bDf);
            return;
        }
        Intent intent = getIntent();
        this.mModel.ev(intent.getBooleanExtra(PersonListActivityConfig.FOLLOW, false));
        this.mModel.setId(intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID));
        this.bDf = intent.getIntExtra(com.baidu.tbadk.core.frameworkData.a.USER_SEX, 0);
        this.mModel.setSex(this.bDf);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PersonListActivityConfig.FOLLOW, this.mModel.aag());
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.USER_ID, this.mModel.getId());
        bundle.putInt(com.baidu.tbadk.core.frameworkData.a.USER_SEX, this.bDf);
    }

    private void initUI() {
        boolean z = true;
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.atJ = this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        String currentAccount = TbadkApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aag()) {
                this.atJ.setText(com.baidu.tieba.y.my_attention);
            } else {
                this.atJ.setText(com.baidu.tieba.y.fans);
            }
        } else if (this.mModel.aag()) {
            if (this.bDf == 2) {
                this.atJ.setText(com.baidu.tieba.y.her_attention_people);
            } else if (this.bDf == 1) {
                this.atJ.setText(com.baidu.tieba.y.his_attention_people);
            } else {
                this.atJ.setText(com.baidu.tieba.y.his_attention_people);
            }
        } else if (this.bDf == 2) {
            this.atJ.setText(com.baidu.tieba.y.attention_to_her);
        } else {
            this.atJ.setText(com.baidu.tieba.y.attention_to_him);
        }
        bn bnVar = new bn(this);
        bo boVar = new bo(this);
        bp bpVar = new bp(this);
        bq bqVar = new bq(this);
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkApplication.getCurrentAccount())) {
            z = false;
        }
        this.bDc = new bs(this, getIntent().getBooleanExtra(PersonListActivityConfig.FOLLOW, false), z, this.mModel.getSex(), bnVar, boVar, bqVar, bpVar);
        this.vl = (BdListView) findViewById(com.baidu.tieba.v.list);
        this.vl.setAdapter((ListAdapter) this.bDc);
        this.bCZ = com.baidu.adp.lib.g.b.ek().inflate(this, com.baidu.tieba.w.person_list_newheader, null);
        this.bDa = this.bCZ.findViewById(com.baidu.tieba.v.newheader_root);
        this.bCZ.setVisibility(8);
        this.bCZ.setClickable(false);
        this.bCZ.setEnabled(false);
        this.bDb = (TextView) this.bCZ.findViewById(com.baidu.tieba.v.person_list_title);
        this.vl.addHeaderView(this.bCZ, null, false);
        this.ahX = NoDataViewFactory.a(this, this.mParent, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), null, null);
        this.vl.setOnSrollToBottomListener(new br(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tieba.data.aj ajVar, boolean z) {
        if (this.mModel != null && ajVar != null && (!z || !this.bDe)) {
            if (!z) {
                this.bDe = true;
                a(ajVar);
            }
            c(ajVar, z);
            if (!this.mModel.aag()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.oD().setMsgFans(0);
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
            if (ajVar.zO().ke() > 0) {
                this.bCZ.setVisibility(0);
                this.vl.setVisibility(0);
                this.ahX.setVisibility(8);
                if (this.mModel.aag()) {
                    if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkApplication.getCurrentAccount())) {
                        string = getString(com.baidu.tieba.y.my_attention_prefix);
                        string2 = getString(com.baidu.tieba.y.person);
                        this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.not_have_attention));
                    } else {
                        if (this.bDf == 2) {
                            string3 = getString(com.baidu.tieba.y.she_attention_prefix);
                            this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.her_no_attention_other));
                        } else if (this.bDf == 1) {
                            string3 = getString(com.baidu.tieba.y.he_attention_prefix);
                            this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_attention_other));
                        } else {
                            string3 = getString(com.baidu.tieba.y.he_attention_prefix);
                            this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_attention_other));
                        }
                        string = string3;
                        string2 = getString(com.baidu.tieba.y.person);
                    }
                } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkApplication.getCurrentAccount())) {
                    string = getString(com.baidu.tieba.y.my_fans_prefix);
                    string2 = getString(com.baidu.tieba.y.my_fans_suffix);
                    this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.not_have_fans));
                } else if (this.bDf == 2) {
                    string = getString(com.baidu.tieba.y.her_fans_prefix);
                    string2 = getString(com.baidu.tieba.y.her_fans_suffix);
                    this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.her_no_fan_other));
                } else if (this.bDf == 1) {
                    string = getString(com.baidu.tieba.y.his_fans_prefix);
                    string2 = getString(com.baidu.tieba.y.her_fans_suffix);
                    this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_fan_other));
                } else {
                    string = getString(com.baidu.tieba.y.his_fans_prefix);
                    string2 = getString(com.baidu.tieba.y.her_fans_suffix);
                    this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_fan_other));
                }
                this.bDb.setText(String.valueOf(string) + String.valueOf(ajVar.zO().ke()) + string2);
                return;
            }
            this.bCZ.setVisibility(8);
            this.vl.setVisibility(8);
            if (!z) {
                this.ahX.setVisibility(0);
            }
            if (this.mModel.aag()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkApplication.getCurrentAccount())) {
                    this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.not_have_attention));
                } else if (this.bDf == 2) {
                    this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.her_no_attention_other));
                } else if (this.bDf == 1) {
                    this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_attention_other));
                } else {
                    this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_attention_other));
                }
            } else if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkApplication.getCurrentAccount())) {
                this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.not_have_fans));
            } else if (this.bDf == 2) {
                this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.her_no_fan_other));
            } else if (this.bDf == 1) {
                this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_fan_other));
            } else {
                this.ahX.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.him_no_fan_other));
            }
        }
    }

    private void a(com.baidu.tieba.data.aj ajVar) {
        this.mModel.gZ(ajVar.zO().kf());
    }

    private void c(com.baidu.tieba.data.aj ajVar, boolean z) {
        boolean z2 = true;
        if (this.bDc != null) {
            if (!z) {
                if (ajVar.zO().kf() == 1) {
                    this.bDc.resetData();
                }
                com.baidu.tbadk.core.data.m zO = ajVar.zO();
                bs bsVar = this.bDc;
                if (zO == null || zO.kh() != 1) {
                    z2 = false;
                }
                bsVar.setHasMore(z2);
                this.bDc.H(ajVar.Aa());
                this.bDc.eu(false);
                this.bDc.ZI();
                this.bDc.notifyDataSetChanged();
                return;
            }
            this.bDc.setHasMore(false);
            this.bDc.H(ajVar.Aa());
            this.bDc.eu(false);
            this.bDc.ZI();
            this.bDc.notifyDataSetChanged();
        }
    }

    private void Tv() {
        this.mProgress.setVisibility(0);
        this.mModel.aaj();
        this.mModel.aah();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aac() {
        if (this.bDc != null) {
            this.bDc.eu(true);
            this.bDc.notifyDataSetChanged();
        }
        this.mModel.aah();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aad() {
        UserData userData;
        if (this.bDc != null && this.bDc.getItemViewType(this.bCG) == 0 && (userData = (UserData) this.bDc.getItem(this.bCG)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkApplication.getCurrentAccount())) {
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
            aad();
        }
    }
}
