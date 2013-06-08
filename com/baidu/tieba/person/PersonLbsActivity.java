package com.baidu.tieba.person;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonLbsActivity extends com.baidu.tieba.e {
    private ListView c = null;
    private LinearLayout d = null;
    private TextView e = null;
    private TextView f = null;
    private ImageView g = null;
    private ImageView h = null;
    private ProgressBar i = null;
    private LinearLayout j = null;
    private boolean k = false;
    private String l = null;
    private View.OnClickListener m = null;
    private bi n = null;
    private bh o = null;
    private com.baidu.tieba.c.bl p = null;
    private AbsListView.OnScrollListener q = null;
    private int r = 1;
    private int s = 1;
    private AdapterView.OnItemClickListener t = null;
    private Handler u = new Handler();
    private Runnable v = new bc(this);

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, PersonLbsActivity.class);
        intent.putExtra("un", str);
        if (TiebaApplication.B() != null && TiebaApplication.B().equals(str)) {
            intent.putExtra("self", true);
        } else {
            intent.putExtra("self", false);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_lbs_activity);
        b();
        c();
    }

    private void b() {
        this.m = new be(this);
        this.q = new bf(this);
        this.t = new bg(this);
        this.j = (LinearLayout) findViewById(R.id.parent);
        this.c = (ListView) findViewById(R.id.list);
        this.d = (LinearLayout) findViewById(R.id.title);
        this.f = (TextView) findViewById(R.id.no_data);
        this.e = (TextView) findViewById(R.id.title_text);
        this.g = (ImageView) findViewById(R.id.back);
        this.h = (ImageView) findViewById(R.id.refresh);
        this.i = (ProgressBar) findViewById(R.id.progress);
        this.g.setOnClickListener(this.m);
        this.h.setOnClickListener(this.m);
        this.n = new bi(this);
        this.c.setAdapter((ListAdapter) this.n);
        this.c.setOnScrollListener(this.q);
        this.c.setOnItemClickListener(this.t);
    }

    private void c() {
        Intent intent = getIntent();
        this.k = intent.getBooleanExtra("self", false);
        if (this.k) {
            this.e.setText(R.string.my_lbs_text);
            this.f.setText(R.string.my_lbs_no_data);
        } else {
            this.e.setText(R.string.his_lbs_text);
            this.f.setText(R.string.his_lbs_no_data);
        }
        this.l = intent.getStringExtra("un");
        b(0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.d.ac.a(this.j, i);
        com.baidu.tieba.d.ac.d(this.d, i);
        com.baidu.tieba.d.ac.f(this.e, i);
        com.baidu.tieba.d.ac.a(this.g, i);
        com.baidu.tieba.d.ac.b(this.h, i);
        if (i == 1) {
            this.c.setBackgroundColor(getResources().getColor(R.color.skin_1_common_bg));
            this.c.setSelector(R.drawable.list_selector_1);
            this.f.setTextColor(-4276546);
            return;
        }
        this.c.setBackgroundColor(getResources().getColor(R.color.backgroundcolor));
        this.c.setSelector(R.drawable.list_selector);
        this.f.setTextColor(-7237231);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        if (this.o != null) {
            if (this.o.e() != i) {
                this.o.cancel();
            } else {
                return;
            }
        }
        this.o = new bh(this, i2, i);
        this.o.setPriority(3);
        this.o.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.n != null) {
            this.n.a().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.v.run();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.u.removeCallbacks(this.v);
        if (this.o != null) {
            this.o.cancel();
        }
        if (this.n != null) {
            this.n.b();
        }
        this.i.setVisibility(8);
    }
}
