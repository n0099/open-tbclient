package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class PersonListActivity extends com.baidu.tieba.e {
    private com.baidu.tieba.b.q i;
    private Button b = null;
    private ListView c = null;
    private ProgressBar d = null;
    private TextView e = null;
    private com.baidu.tieba.write.k f = null;
    private Handler g = new Handler();
    private ax h = null;
    private Runnable j = new as(this);

    public static void a(Activity activity, boolean z, String str) {
        Intent intent = new Intent(activity, PersonListActivity.class);
        if (z) {
            intent.putExtra("follow", true);
        }
        intent.putExtra("un", str);
        activity.startActivity(intent);
    }

    private void a(Bundle bundle) {
        this.i = new com.baidu.tieba.b.q();
        if (bundle != null) {
            this.i.a(bundle.getBoolean("follow", false));
            this.i.a(bundle.getString("un"));
            return;
        }
        Intent intent = getIntent();
        this.i.a(intent.getBooleanExtra("follow", false));
        this.i.a(intent.getStringExtra("un"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.h != null) {
            return;
        }
        if (!z) {
            this.d.setVisibility(0);
            this.h = new ax(this, this.i.a(), this.i.b(), 0);
            this.h.execute(new String[0]);
            return;
        }
        if (this.f != null) {
            this.f.b(true);
            this.f.notifyDataSetChanged();
        }
        this.h = new ax(this, this.i.a(), this.i.b(), this.i.c().a().b() + 1);
        this.h.execute(new String[0]);
    }

    private void g() {
        this.d = (ProgressBar) findViewById(R.id.progress);
        this.e = (TextView) findViewById(R.id.titel_text);
        if (this.i.b()) {
            this.e.setText(R.string.attention);
        } else {
            this.e.setText(R.string.fans);
        }
        this.b = (Button) findViewById(R.id.back);
        this.b.setOnClickListener(new au(this));
        this.f = new com.baidu.tieba.write.k(this, getIntent().getBooleanExtra("follow", false));
        this.f.a(this.i.c().b());
        this.c = (ListView) findViewById(R.id.list);
        this.c.setAdapter((ListAdapter) this.f);
        this.c.setOnItemClickListener(new av(this));
        this.c.setOnScrollListener(new aw(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_list_activity);
        a(bundle);
        g();
        a(false);
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
        this.g.removeCallbacks(this.j);
        if (this.d != null) {
            this.d.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.i.b());
        bundle.putString("un", this.i.a());
    }
}
