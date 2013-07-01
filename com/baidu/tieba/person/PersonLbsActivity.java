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
public class PersonLbsActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private ListView f1305a = null;
    private LinearLayout b = null;
    private TextView c = null;
    private TextView d = null;
    private ImageView e = null;
    private ImageView f = null;
    private ProgressBar g = null;
    private LinearLayout j = null;
    private boolean k = false;
    private String l = null;
    private View.OnClickListener m = null;
    private bj n = null;
    private bi o = null;
    private com.baidu.tieba.model.bl p = null;
    private AbsListView.OnScrollListener q = null;
    private int r = 1;
    private int s = 1;
    private AdapterView.OnItemClickListener t = null;
    private Handler u = new Handler();
    private Runnable v = new bd(this);

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, PersonLbsActivity.class);
        intent.putExtra("un", str);
        if (TiebaApplication.E() != null && TiebaApplication.E().equals(str)) {
            intent.putExtra("self", true);
        } else {
            intent.putExtra("self", false);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_lbs_activity);
        b();
        c();
    }

    private void b() {
        this.m = new bf(this);
        this.q = new bg(this);
        this.t = new bh(this);
        this.j = (LinearLayout) findViewById(R.id.parent);
        this.f1305a = (ListView) findViewById(R.id.list);
        this.b = (LinearLayout) findViewById(R.id.title);
        this.d = (TextView) findViewById(R.id.no_data);
        this.c = (TextView) findViewById(R.id.title_text);
        this.e = (ImageView) findViewById(R.id.back);
        this.f = (ImageView) findViewById(R.id.refresh);
        this.g = (ProgressBar) findViewById(R.id.progress);
        this.e.setOnClickListener(this.m);
        this.f.setOnClickListener(this.m);
        this.n = new bj(this);
        this.f1305a.setAdapter((ListAdapter) this.n);
        this.f1305a.setOnScrollListener(this.q);
        this.f1305a.setOnItemClickListener(this.t);
    }

    private void c() {
        Intent intent = getIntent();
        this.k = intent.getBooleanExtra("self", false);
        if (this.k) {
            this.c.setText(R.string.my_lbs_text);
            this.d.setText(R.string.my_lbs_no_data);
        } else {
            this.c.setText(R.string.his_lbs_text);
            this.d.setText(R.string.his_lbs_no_data);
        }
        this.l = intent.getStringExtra("un");
        b(0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.x.a(this.j, i);
        com.baidu.tieba.util.x.d(this.b, i);
        com.baidu.tieba.util.x.f(this.c, i);
        com.baidu.tieba.util.x.a(this.e, i);
        com.baidu.tieba.util.x.b(this.f, i);
        if (i == 1) {
            this.f1305a.setBackgroundColor(getResources().getColor(R.color.skin_1_common_bg));
            this.f1305a.setSelector(R.drawable.list_selector_1);
            this.d.setTextColor(-4276546);
            return;
        }
        this.f1305a.setBackgroundColor(getResources().getColor(R.color.backgroundcolor));
        this.f1305a.setSelector(R.drawable.list_selector);
        this.d.setTextColor(-7237231);
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
        this.o = new bi(this, i2, i);
        this.o.setPriority(3);
        this.o.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.n != null) {
            this.n.a().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        this.v.run();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.u.removeCallbacks(this.v);
        if (this.o != null) {
            this.o.cancel();
        }
        if (this.n != null) {
            this.n.b();
        }
        this.g.setVisibility(8);
    }
}
