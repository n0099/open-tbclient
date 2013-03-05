package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class PersonListActivity extends com.baidu.tieba.e {
    private com.baidu.tieba.b.u i;
    private Button c = null;
    private ListView d = null;
    private ProgressBar e = null;
    private com.baidu.tieba.write.k f = null;
    private Handler g = new Handler();
    private br h = null;
    private RelativeLayout j = null;
    private RelativeLayout k = null;
    private TextView l = null;
    private Runnable m = new bm(this);

    public static void a(Activity activity, boolean z, String str) {
        Intent intent = new Intent(activity, PersonListActivity.class);
        if (z) {
            intent.putExtra("follow", true);
        }
        intent.putExtra("un", str);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_list_activity);
        a(bundle);
        i();
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ae.a(this.j, i);
        com.baidu.tieba.c.ae.c(this.k, i);
        com.baidu.tieba.c.ae.c(this.l, i);
        com.baidu.tieba.c.ae.e((TextView) this.c, i);
        this.f.notifyDataSetChanged();
        if (i == 1) {
            this.d.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            this.d.setSelector(R.drawable.list_selector_1);
            return;
        }
        this.d.setDivider(getResources().getDrawable(R.drawable.list_divider));
        this.d.setSelector(R.drawable.list_selector);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.h != null) {
            this.h.a();
        }
        if (this.f != null) {
            this.f.a();
            if (this.f.c() != null) {
                this.f.c().b();
            }
            this.f = null;
        }
        this.g.removeCallbacks(this.m);
        if (this.e != null) {
            this.e.setVisibility(8);
        }
        super.onDestroy();
    }

    private void a(Bundle bundle) {
        this.i = new com.baidu.tieba.b.u();
        if (bundle != null) {
            this.i.a(bundle.getBoolean("follow", false));
            this.i.a(bundle.getString("un"));
            return;
        }
        Intent intent = getIntent();
        this.i.a(intent.getBooleanExtra("follow", false));
        this.i.a(intent.getStringExtra("un"));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.i.b());
        bundle.putString("un", this.i.a());
    }

    private void i() {
        this.j = (RelativeLayout) findViewById(R.id.parent);
        this.k = (RelativeLayout) findViewById(R.id.title);
        this.l = (TextView) findViewById(R.id.title_text);
        this.e = (ProgressBar) findViewById(R.id.progress);
        if (this.i.b()) {
            this.l.setText(R.string.attention);
        } else {
            this.l.setText(R.string.fans);
        }
        this.c = (Button) findViewById(R.id.back);
        this.c.setOnClickListener(new bo(this));
        this.f = new com.baidu.tieba.write.k(this, getIntent().getBooleanExtra("follow", false), this.i.a().equals(TiebaApplication.x()));
        this.f.a(this.i.c().b());
        this.d = (ListView) findViewById(R.id.list);
        this.d.setAdapter((ListAdapter) this.f);
        this.d.setOnItemClickListener(new bp(this));
        this.d.setOnScrollListener(new bq(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.h == null) {
            if (!z) {
                this.e.setVisibility(0);
                this.h = new br(this, this.i.a(), this.i.b(), 0);
                this.h.execute(new String[0]);
                return;
            }
            if (this.f != null) {
                this.f.b(true);
                this.f.notifyDataSetChanged();
            }
            this.h = new br(this, this.i.a(), this.i.b(), this.i.c().a().b() + 1);
            this.h.execute(new String[0]);
        }
    }
}
