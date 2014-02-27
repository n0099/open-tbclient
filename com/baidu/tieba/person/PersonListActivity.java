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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonListActivity extends com.baidu.tieba.f {
    private com.baidu.tieba.model.br j;
    private LinearLayout k;
    private TextView l;
    private NavigationBar n;
    private BdListView b = null;
    private View c = null;
    private View d = null;
    private TextView e = null;
    private ProgressBar f = null;
    private dg g = null;
    private final Handler h = new Handler();
    private df i = null;
    private RelativeLayout m = null;
    private TextView o = null;
    private int p = 0;
    int a = 0;
    private com.baidu.tieba.data.ao q = null;
    private final Runnable r = new cy(this);

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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_list_activity);
        this.j = new com.baidu.tieba.model.br();
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
        this.m = (RelativeLayout) findViewById(R.id.parent);
        this.n = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.o = this.n.a("");
        this.n.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = (ProgressBar) findViewById(R.id.progress);
        String v = TiebaApplication.v();
        String a = this.j.a();
        if (v == null || !v.equals(a)) {
            if (this.j.c()) {
                if (this.p == 2) {
                    this.o.setText(R.string.her_attention_people);
                } else if (this.p == 1) {
                    this.o.setText(R.string.his_attention_people);
                } else {
                    this.o.setText(R.string.ta_attention_people);
                }
            } else if (this.p == 2) {
                this.o.setText(R.string.attention_to_her);
            } else if (this.p == 1) {
                this.o.setText(R.string.attention_to_him);
            } else {
                this.o.setText(R.string.attention_to_ta);
            }
        } else if (this.j.c()) {
            this.o.setText(R.string.my_attention);
        } else {
            this.o.setText(R.string.fans);
        }
        da daVar = new da(this);
        db dbVar = new db(this);
        dc dcVar = new dc(this);
        this.g = new dg(this, getIntent().getBooleanExtra("follow", false), this.j.a() != null && this.j.a().equals(TiebaApplication.v()), this.j.b(), daVar, dbVar, dcVar);
        this.b = (BdListView) findViewById(R.id.list);
        this.b.setAdapter((ListAdapter) this.g);
        this.c = LayoutInflater.from(this).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.d = this.c.findViewById(R.id.newheader_root);
        this.c.setVisibility(8);
        this.c.setClickable(false);
        this.c.setEnabled(false);
        this.e = (TextView) this.c.findViewById(R.id.person_list_title);
        this.b.addHeaderView(this.c, null, false);
        this.k = (LinearLayout) findViewById(R.id.no_data_container);
        this.l = (TextView) findViewById(R.id.no_data_image_text);
        this.b.setOnScrollListener(new dd(this));
        this.b.setOnSrollToBottomListener(new de(this));
        this.i = new df(this, this.j.a(), this.j.c(), 0, true);
        this.i.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.m);
        this.n.b(i);
        this.g.notifyDataSetChanged();
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
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
            personListActivity.i = new df(personListActivity, personListActivity.j.a(), personListActivity.j.c(), personListActivity.j.d().a().d() + 1);
            personListActivity.i.setPriority(3);
            personListActivity.i.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        UserData userData;
        if (this.g != null && this.g.getItemViewType(this.a) == 0 && (userData = (UserData) this.g.getItem(this.a)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TiebaApplication.v())) {
            com.baidu.tieba.util.cb.a(this, "enter_chat", "personlistclick", 1, new Object[0]);
            try {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001002, new com.baidu.tieba.a.c(this, Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getPortrait(), userData.getSex())));
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
