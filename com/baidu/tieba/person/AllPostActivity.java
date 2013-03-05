package com.baidu.tieba.person;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AllPostActivity extends com.baidu.tieba.e {
    FrameLayout c = null;
    TextView d = null;
    ListView e = null;
    ImageView f = null;
    ad g = null;
    com.baidu.tieba.b.k h = null;
    b i = null;
    private ProgressBar j = null;
    private boolean k = false;
    private int l = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.all_post_activity);
        j();
        i();
        c(0);
    }

    void i() {
        this.c = (FrameLayout) findViewById(R.id.all_post_activity_layout);
        this.d = (TextView) findViewById(R.id.no_post_view);
        this.d.setVisibility(8);
        this.f = (ImageView) findViewById(R.id.time_line);
        this.f.setVisibility(8);
        this.e = (ListView) findViewById(R.id.all_post_list);
        this.g = new ad(this, this.h);
        this.e.setAdapter((ListAdapter) this.g);
        this.e.setOnItemClickListener(new a(this));
        this.j = (ProgressBar) findViewById(R.id.loading_progress);
    }

    void j() {
        this.h = new com.baidu.tieba.b.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        int c;
        if (!this.k) {
            this.k = true;
            this.l = i;
            this.g.notifyDataSetChanged();
            if (this.i != null) {
                this.i.a();
                this.i = null;
            }
            if (i == 0) {
                this.j.setVisibility(0);
                c = 1;
            } else {
                c = this.h.c() + 1;
            }
            this.i = new b(this, 0, c, i);
            this.i.execute("http://c.tieba.baidu.com/c/u/feed/mypost");
        }
    }

    public boolean k() {
        return this.k && this.l == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ae.a(this.c, i);
        if (i == 1) {
            this.d.setTextColor(com.baidu.tieba.c.ae.a(i));
            this.f.setBackgroundResource(R.drawable.time_line_skin_1);
            return;
        }
        this.d.setTextColor(-4276546);
        this.f.setBackgroundResource(R.drawable.time_line);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
        if (this.j != null) {
            this.j.setVisibility(8);
        }
        if (this.g != null) {
            this.g.a();
        }
        super.onDestroy();
    }
}
