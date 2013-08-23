package com.baidu.tieba.person;

import android.content.Intent;
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

    /* renamed from: a  reason: collision with root package name */
    FrameLayout f1587a = null;
    TextView b = null;
    ListView c = null;
    ImageView d = null;
    ae e = null;
    com.baidu.tieba.model.az f = null;
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
        this.f1587a = (FrameLayout) findViewById(R.id.all_post_activity_layout);
        this.b = (TextView) findViewById(R.id.no_post_view);
        int b = this.f.b();
        if (this.f.a() == null) {
            this.b.setText(R.string.no_post_info);
        } else if (b == 2) {
            this.b.setText(R.string.she_no_post_info);
        } else if (b == 1) {
            this.b.setText(R.string.he_no_post_info);
        } else {
            this.b.setText(R.string.ta_no_post_info);
        }
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
        this.f = new com.baidu.tieba.model.az();
        if (bundle != null) {
            this.f.a(bundle.getString("user"));
            this.f.a(bundle.getInt("user_sex"));
            return;
        }
        Intent intent = getIntent();
        this.f.a(intent.getStringExtra("user"));
        this.f.a(intent.getIntExtra("user_sex", 0));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("user", this.f.a());
        bundle.putInt("user_sex", this.f.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        if (!this.k) {
            this.k = true;
            this.l = i;
            this.e.notifyDataSetChanged();
            if (this.g != null) {
                this.g.cancel();
                this.g = null;
            }
            this.g = new c(this, 0, i == 0 ? 1 : this.f.f() + 1, i, this.f.a());
            this.g.setPriority(3);
            this.g.execute(Integer.valueOf(i));
        }
    }

    public boolean c() {
        return this.k && this.l == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ao.a(this.f1587a, i);
        if (i == 1) {
            this.b.setTextColor(com.baidu.tieba.util.ao.a(i));
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
        if (this.m != null) {
            this.m.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }
}
