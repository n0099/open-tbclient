package com.baidu.tieba.person;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class PersonLbsActivity extends com.baidu.tieba.e {
    private ListView c = null;
    private LinearLayout d = null;
    private TextView e = null;
    private TextView f = null;
    private Button g = null;
    private Button h = null;
    private ProgressBar i = null;
    private LinearLayout j = null;
    private boolean k = false;
    private String l = null;
    private View.OnClickListener m = null;
    private bo n = null;
    private bn o = null;
    private com.baidu.tieba.b.u p = null;
    private AbsListView.OnScrollListener q = null;
    private int r = 1;
    private int s = 1;
    private AdapterView.OnItemClickListener t = null;
    private Handler u = new Handler();
    private Runnable v = new bi(this);

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, PersonLbsActivity.class);
        intent.putExtra("un", str);
        if (TiebaApplication.y() != null && TiebaApplication.y().equals(str)) {
            intent.putExtra("self", true);
        } else {
            intent.putExtra("self", false);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_lbs_activity);
        i();
        j();
    }

    private void i() {
        this.m = new bk(this);
        this.q = new bl(this);
        this.t = new bm(this);
        this.j = (LinearLayout) findViewById(R.id.parent);
        this.c = (ListView) findViewById(R.id.list);
        this.d = (LinearLayout) findViewById(R.id.title);
        this.f = (TextView) findViewById(R.id.no_data);
        this.e = (TextView) findViewById(R.id.title_text);
        this.g = (Button) findViewById(R.id.back);
        this.h = (Button) findViewById(R.id.refresh);
        this.i = (ProgressBar) findViewById(R.id.progress);
        this.g.setOnClickListener(this.m);
        this.h.setOnClickListener(this.m);
        this.n = new bo(this);
        this.c.setAdapter((ListAdapter) this.n);
        this.c.setOnScrollListener(this.q);
        this.c.setOnItemClickListener(this.t);
    }

    private void j() {
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
        a(0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ae.a(this.j, i);
        com.baidu.tieba.c.ae.c(this.d, i);
        com.baidu.tieba.c.ae.c(this.e, i);
        com.baidu.tieba.c.ae.e((TextView) this.g, i);
        com.baidu.tieba.c.ae.e((View) this.h, i);
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
    public void a(int i, int i2) {
        if (this.o != null) {
            if (this.o.b() != i) {
                this.o.a();
            } else {
                return;
            }
        }
        this.o = new bn(this, i2, i);
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
            this.o.a();
        }
        if (this.n != null) {
            this.n.b();
        }
        this.i.setVisibility(8);
    }
}
