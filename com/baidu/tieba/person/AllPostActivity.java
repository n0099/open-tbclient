package com.baidu.tieba.person;

import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class AllPostActivity extends com.baidu.tieba.g {
    FrameLayout a = null;
    TextView b = null;
    ListView c = null;
    ImageView d = null;
    ae e = null;
    com.baidu.tieba.model.ar f = null;
    c g = null;
    private ProgressBar j = null;
    private boolean k = false;
    private int l = 0;
    private Handler m = new Handler(new a(this));

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.all_post_activity);
        a(bundle);
        b();
        b(0);
    }

    void b() {
        this.a = (FrameLayout) findViewById(R.id.all_post_activity_layout);
        this.b = (TextView) findViewById(R.id.no_post_view);
        this.b.setVisibility(8);
        this.d = (ImageView) findViewById(R.id.time_line);
        this.d.setVisibility(8);
        this.c = (ListView) findViewById(R.id.all_post_list);
        this.e = new ae(this, this.f);
        this.c.setAdapter((ListAdapter) this.e);
        this.c.setOnItemClickListener(new b(this));
        this.j = (ProgressBar) findViewById(R.id.loading_progress);
    }

    void a(Bundle bundle) {
        this.f = new com.baidu.tieba.model.ar();
        if (bundle != null) {
            this.f.a(bundle.getString("user"));
            return;
        }
        this.f.a(getIntent().getStringExtra("user"));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("user", this.f.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        int i2 = 1;
        if (!this.k) {
            this.k = true;
            this.l = i;
            this.e.notifyDataSetChanged();
            if (this.g != null) {
                this.g.cancel();
                this.g = null;
            }
            if (i == 0) {
                this.j.setVisibility(0);
            } else {
                i2 = this.f.e() + 1;
            }
            this.g = new c(this, 0, i2, i, this.f.a());
            this.g.setPriority(3);
            this.g.execute(new String[0]);
        }
    }

    public boolean c() {
        return this.k && this.l == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.x.a(this.a, i);
        if (i == 1) {
            this.b.setTextColor(com.baidu.tieba.util.x.a(i));
            this.d.setBackgroundResource(R.drawable.time_line_skin_1);
            return;
        }
        this.b.setTextColor(-4276546);
        this.d.setBackgroundResource(R.drawable.time_line);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
        if (this.j != null) {
            this.j.setVisibility(8);
        }
        if (this.e != null) {
            this.e.a();
        }
        super.onDestroy();
    }
}
