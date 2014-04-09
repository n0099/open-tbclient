package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class PersonListActivity extends com.baidu.tbadk.a {
    private com.baidu.tieba.model.ay j;
    private LinearLayout k;
    private TextView l;
    private NavigationBar n;
    private BdListView b = null;
    private View c = null;
    private View d = null;
    private TextView e = null;
    private ProgressBar f = null;
    private cj g = null;
    private final Handler h = new Handler();
    private ci i = null;
    private RelativeLayout m = null;
    private TextView o = null;
    private int p = 0;
    int a = 0;
    private com.baidu.tieba.data.ag q = null;
    private final Runnable r = new cb(this);

    public static void a(Activity activity, boolean z, String str, int i) {
        Intent intent = new Intent(activity, PersonListActivity.class);
        if (z) {
            intent.putExtra("follow", true);
        } else {
            intent.putExtra("follow", false);
        }
        intent.putExtra("user_sex", i);
        intent.putExtra("un", str);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.person_list_activity);
        this.j = new com.baidu.tieba.model.ay();
        if (bundle != null) {
            this.j.a(bundle.getBoolean("follow", false));
            this.j.a(bundle.getString("un"));
            this.p = bundle.getInt("user_sex");
            this.j.a(this.p);
        } else {
            Intent intent = getIntent();
            this.j.a(intent.getBooleanExtra("follow", false));
            this.j.a(intent.getStringExtra("un"));
            this.p = intent.getIntExtra("user_sex", 0);
            this.j.a(this.p);
        }
        this.m = (RelativeLayout) findViewById(com.baidu.tieba.a.h.parent);
        this.n = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.o = this.n.a("");
        this.n.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = (ProgressBar) findViewById(com.baidu.tieba.a.h.progress);
        String E = TbadkApplication.E();
        String a = this.j.a();
        if (E == null || !E.equals(a)) {
            if (this.j.c()) {
                if (this.p == 2) {
                    this.o.setText(com.baidu.tieba.a.k.her_attention_people);
                } else if (this.p == 1) {
                    this.o.setText(com.baidu.tieba.a.k.his_attention_people);
                } else {
                    this.o.setText(com.baidu.tieba.a.k.ta_attention_people);
                }
            } else if (this.p == 2) {
                this.o.setText(com.baidu.tieba.a.k.attention_to_her);
            } else if (this.p == 1) {
                this.o.setText(com.baidu.tieba.a.k.attention_to_him);
            } else {
                this.o.setText(com.baidu.tieba.a.k.attention_to_ta);
            }
        } else if (this.j.c()) {
            this.o.setText(com.baidu.tieba.a.k.my_attention);
        } else {
            this.o.setText(com.baidu.tieba.a.k.fans);
        }
        cd cdVar = new cd(this);
        ce ceVar = new ce(this);
        cf cfVar = new cf(this);
        this.g = new cj(this, getIntent().getBooleanExtra("follow", false), this.j.a() != null && this.j.a().equals(TbadkApplication.E()), this.j.b(), cdVar, ceVar, cfVar);
        this.b = (BdListView) findViewById(com.baidu.tieba.a.h.list);
        this.b.setAdapter((ListAdapter) this.g);
        this.c = LayoutInflater.from(this).inflate(com.baidu.tieba.a.i.person_list_newheader, (ViewGroup) null);
        this.d = this.c.findViewById(com.baidu.tieba.a.h.newheader_root);
        this.c.setVisibility(8);
        this.c.setClickable(false);
        this.c.setEnabled(false);
        this.e = (TextView) this.c.findViewById(com.baidu.tieba.a.h.person_list_title);
        this.b.addHeaderView(this.c, null, false);
        this.k = (LinearLayout) findViewById(com.baidu.tieba.a.h.no_data_container);
        this.l = (TextView) findViewById(com.baidu.tieba.a.h.no_data_image_text);
        this.b.setOnScrollListener(new cg(this));
        this.b.setOnSrollToBottomListener(new ch(this));
        this.i = new ci(this, this.j.a(), this.j.c(), 0, true);
        this.i.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.m);
        this.n.b(i);
        this.g.notifyDataSetChanged();
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        if (this.i != null) {
            this.i.cancel();
        }
        if (this.g != null) {
            this.g.a();
            if (this.g.c() != null) {
                this.g.c().c();
            }
            this.g = null;
        }
        this.h.removeCallbacks(this.r);
        if (this.f != null) {
            this.f.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.j.c());
        bundle.putString("un", this.j.a());
        bundle.putInt("user_sex", this.p);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PersonListActivity personListActivity, boolean z) {
        if (personListActivity.i == null) {
            if (personListActivity.g != null) {
                personListActivity.g.b(true);
                personListActivity.g.notifyDataSetChanged();
            }
            personListActivity.i = new ci(personListActivity, personListActivity.j.a(), personListActivity.j.c(), personListActivity.j.d().a().d() + 1);
            personListActivity.i.setPriority(3);
            personListActivity.i.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        UserData userData;
        if (this.g != null && this.g.getItemViewType(this.a) == 0 && (userData = (UserData) this.g.getItem(this.a)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkApplication.E())) {
            TiebaStatic.a(this, "enter_chat", "personlistclick", 1, new Object[0]);
            try {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001005, new com.baidu.tbadk.core.b.ah(this, Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getPortrait(), userData.getSex())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 11028) {
            a();
        }
    }
}
