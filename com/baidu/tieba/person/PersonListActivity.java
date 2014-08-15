package com.baidu.tieba.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class PersonListActivity extends BaseActivity {
    private dt i;
    private LinearLayout j;
    private TextView k;
    private boolean n;
    private NavigationBar o;
    private BdListView c = null;
    private View d = null;
    private View e = null;
    private TextView f = null;
    private ProgressBar g = null;
    private dr h = null;
    private RelativeLayout l = null;
    private boolean m = true;
    private TextView p = null;
    private int q = 0;
    int a = 0;
    public dw b = new dl(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.bh.class, PersonListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.v.person_list_activity);
        a(bundle);
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.i.g();
        this.i.e();
        if (this.m) {
            this.m = false;
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.i.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().a(i == 1);
        getLayoutMode().a((View) this.l);
        this.o.c(i);
        this.h.notifyDataSetChanged();
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.h != null) {
            this.h.a();
            this.h = null;
        }
        if (this.g != null) {
            this.g.setVisibility(8);
        }
        super.onDestroy();
    }

    private void a(Bundle bundle) {
        this.i = new dt(this, this.b);
        if (bundle != null) {
            this.i.a(bundle.getBoolean("follow", false));
            this.i.a(bundle.getString(com.baidu.tbadk.core.frameworkData.a.USER_ID));
            this.q = bundle.getInt(com.baidu.tbadk.core.frameworkData.a.USER_SEX);
            this.i.b(this.q);
            return;
        }
        Intent intent = getIntent();
        this.i.a(intent.getBooleanExtra("follow", false));
        this.i.a(intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID));
        this.q = intent.getIntExtra(com.baidu.tbadk.core.frameworkData.a.USER_SEX, 0);
        this.i.b(this.q);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.i.d());
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.USER_ID, this.i.b());
        bundle.putInt(com.baidu.tbadk.core.frameworkData.a.USER_SEX, this.q);
    }

    private void a() {
        boolean z = true;
        this.l = (RelativeLayout) findViewById(com.baidu.tieba.u.parent);
        this.o = (NavigationBar) findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.p = this.o.a("");
        this.o.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.g = (ProgressBar) findViewById(com.baidu.tieba.u.progress);
        String currentAccount = TbadkApplication.getCurrentAccount();
        String b = this.i.b();
        if (currentAccount != null && currentAccount.equals(b)) {
            if (this.i.d()) {
                this.p.setText(com.baidu.tieba.x.my_attention);
            } else {
                this.p.setText(com.baidu.tieba.x.fans);
            }
        } else if (this.i.d()) {
            if (this.q == 2) {
                this.p.setText(com.baidu.tieba.x.her_attention_people);
            } else if (this.q == 1) {
                this.p.setText(com.baidu.tieba.x.his_attention_people);
            } else {
                this.p.setText(com.baidu.tieba.x.his_attention_people);
            }
        } else if (this.q == 2) {
            this.p.setText(com.baidu.tieba.x.attention_to_her);
        } else {
            this.p.setText(com.baidu.tieba.x.attention_to_him);
        }
        dm dmVar = new dm(this);
        dn dnVar = new dn(this);
        Cdo cdo = new Cdo(this);
        dp dpVar = new dp(this);
        if (this.i.b() == null || !this.i.b().equals(TbadkApplication.getCurrentAccount())) {
            z = false;
        }
        this.h = new dr(this, getIntent().getBooleanExtra("follow", false), z, this.i.c(), dmVar, dnVar, dpVar, cdo);
        this.c = (BdListView) findViewById(com.baidu.tieba.u.list);
        this.c.setAdapter((ListAdapter) this.h);
        this.d = LayoutInflater.from(this).inflate(com.baidu.tieba.v.person_list_newheader, (ViewGroup) null);
        this.e = this.d.findViewById(com.baidu.tieba.u.newheader_root);
        this.d.setVisibility(8);
        this.d.setClickable(false);
        this.d.setEnabled(false);
        this.f = (TextView) this.d.findViewById(com.baidu.tieba.u.person_list_title);
        this.c.addHeaderView(this.d, null, false);
        this.j = (LinearLayout) findViewById(com.baidu.tieba.u.no_data_container);
        this.k = (TextView) findViewById(com.baidu.tieba.u.no_data_image_text);
        this.c.setOnSrollToBottomListener(new dq(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.baidu.tieba.data.am amVar, boolean z) {
        if (this.i != null && amVar != null && (!z || !this.n)) {
            if (!z) {
                this.n = true;
                a(amVar);
            }
            c(amVar, z);
            if (!this.i.d()) {
                com.baidu.tbadk.coreExtra.messageCenter.a.a().c(0);
            }
            b(amVar, z);
        }
    }

    private void b(com.baidu.tieba.data.am amVar, boolean z) {
        String string;
        String string2;
        String string3;
        if (this.i.a() == 0 || this.i.a() == 1) {
            if (this.i.a() == 1) {
                this.g.setVisibility(8);
            }
            if (amVar.a().c() > 0) {
                this.d.setVisibility(0);
                this.c.setVisibility(0);
                this.j.setVisibility(8);
                if (this.i.d()) {
                    if (this.i.b() != null && this.i.b().equals(TbadkApplication.getCurrentAccount())) {
                        string = getString(com.baidu.tieba.x.my_attention_prefix);
                        string2 = getString(com.baidu.tieba.x.person);
                        this.k.setText(com.baidu.tieba.x.not_have_attention);
                    } else {
                        if (this.q == 2) {
                            string3 = getString(com.baidu.tieba.x.she_attention_prefix);
                            this.k.setText(com.baidu.tieba.x.her_no_attention_other);
                        } else if (this.q == 1) {
                            string3 = getString(com.baidu.tieba.x.he_attention_prefix);
                            this.k.setText(com.baidu.tieba.x.him_no_attention_other);
                        } else {
                            string3 = getString(com.baidu.tieba.x.he_attention_prefix);
                            this.k.setText(com.baidu.tieba.x.him_no_attention_other);
                        }
                        string = string3;
                        string2 = getString(com.baidu.tieba.x.person);
                    }
                } else if (this.i.b() != null && this.i.b().equals(TbadkApplication.getCurrentAccount())) {
                    string = getString(com.baidu.tieba.x.my_fans_prefix);
                    string2 = getString(com.baidu.tieba.x.my_fans_suffix);
                    this.k.setText(com.baidu.tieba.x.not_have_fans);
                } else if (this.q == 2) {
                    string = getString(com.baidu.tieba.x.her_fans_prefix);
                    string2 = getString(com.baidu.tieba.x.her_fans_suffix);
                    this.k.setText(com.baidu.tieba.x.her_no_fan_other);
                } else if (this.q == 1) {
                    string = getString(com.baidu.tieba.x.his_fans_prefix);
                    string2 = getString(com.baidu.tieba.x.her_fans_suffix);
                    this.k.setText(com.baidu.tieba.x.him_no_fan_other);
                } else {
                    string = getString(com.baidu.tieba.x.his_fans_prefix);
                    string2 = getString(com.baidu.tieba.x.her_fans_suffix);
                    this.k.setText(com.baidu.tieba.x.him_no_fan_other);
                }
                this.f.setText(String.valueOf(string) + String.valueOf(amVar.a().c()) + string2);
                return;
            }
            this.d.setVisibility(8);
            this.c.setVisibility(8);
            if (!z) {
                this.j.setVisibility(0);
            }
            if (this.i.d()) {
                if (this.i.b() != null && this.i.b().equals(TbadkApplication.getCurrentAccount())) {
                    this.k.setText(com.baidu.tieba.x.not_have_attention);
                } else if (this.q == 2) {
                    this.k.setText(com.baidu.tieba.x.her_no_attention_other);
                } else if (this.q == 1) {
                    this.k.setText(com.baidu.tieba.x.him_no_attention_other);
                } else {
                    this.k.setText(com.baidu.tieba.x.him_no_attention_other);
                }
            } else if (this.i.b() != null && this.i.b().equals(TbadkApplication.getCurrentAccount())) {
                this.k.setText(com.baidu.tieba.x.not_have_fans);
            } else if (this.q == 2) {
                this.k.setText(com.baidu.tieba.x.her_no_fan_other);
            } else if (this.q == 1) {
                this.k.setText(com.baidu.tieba.x.him_no_fan_other);
            } else {
                this.k.setText(com.baidu.tieba.x.him_no_fan_other);
            }
        }
    }

    private void a(com.baidu.tieba.data.am amVar) {
        this.i.a(amVar.a().d());
    }

    private void c(com.baidu.tieba.data.am amVar, boolean z) {
        boolean z2 = true;
        if (this.h != null) {
            if (!z) {
                if (amVar.a().d() == 1) {
                    this.h.d();
                }
                com.baidu.tbadk.core.data.l a = amVar.a();
                dr drVar = this.h;
                if (a == null || a.f() != 1) {
                    z2 = false;
                }
                drVar.a(z2);
                this.h.a(amVar.b());
                this.h.b(false);
                this.h.b();
                this.h.notifyDataSetChanged();
                return;
            }
            this.h.a(false);
            this.h.a(amVar.b());
            this.h.b(false);
            this.h.b();
            this.h.notifyDataSetChanged();
        }
    }

    private void b() {
        this.g.setVisibility(0);
        this.i.h();
        this.i.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.h != null) {
            this.h.b(true);
            this.h.notifyDataSetChanged();
        }
        this.i.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        UserData userData;
        if (this.h != null && this.h.getItemViewType(this.a) == 0 && (userData = (UserData) this.h.getItem(this.a)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(this, "enter_chat", "personlistclick", 1, new Object[0]);
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new com.baidu.tbadk.core.atomData.bj(this, Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getPortrait(), userData.getSex())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 11028) {
            d();
        }
    }
}
