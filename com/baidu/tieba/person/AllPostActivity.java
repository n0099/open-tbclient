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
public class AllPostActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    FrameLayout f2197a = null;
    TextView b = null;
    ListView c = null;
    ImageView d = null;
    af e = null;
    com.baidu.tieba.model.bk f = null;
    c g = null;
    private ProgressBar h = null;
    private boolean i = false;
    private int j = 0;
    private Handler k = new Handler(new b(this));

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.all_post_activity);
        a(bundle);
        a();
        a(0);
    }

    void a() {
        this.f2197a = (FrameLayout) findViewById(R.id.all_post_activity_layout);
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
        this.e = new af(this, this.f);
        this.c.setAdapter((ListAdapter) this.e);
        this.c.setOnItemClickListener(new a(this));
        this.h = (ProgressBar) findViewById(R.id.loading_progress);
    }

    void a(Bundle bundle) {
        this.f = new com.baidu.tieba.model.bk();
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
    public void a(int i) {
        if (!this.i) {
            this.i = true;
            this.j = i;
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

    public boolean b() {
        return this.i && this.j == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tieba.util.bd.a(this.f2197a, i);
        if (i == 1) {
            this.b.setTextColor(com.baidu.tieba.util.bd.a(i));
            this.d.setBackgroundResource(R.drawable.time_line_skin_1);
            return;
        }
        this.b.setTextColor(-4276546);
        this.d.setBackgroundResource(R.drawable.time_line);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
        if (this.h != null) {
            this.h.setVisibility(8);
        }
        if (this.e != null) {
            this.e.a();
        }
        if (this.k != null) {
            this.k.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }
}
