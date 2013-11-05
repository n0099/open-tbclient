package com.baidu.tieba.square;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.util.bb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class BarFolderSecondDirActivity extends com.baidu.tieba.a {
    private ProgressBar j;
    private o k;
    private n l;
    private ImageView m = null;
    private String n;
    private String o;
    private String p;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bar_folder_dir_activity);
        this.n = getIntent().getStringExtra("menuName");
        this.o = getIntent().getStringExtra("menuType");
        this.p = getIntent().getStringExtra("menuId");
        d();
        f();
        e();
        StatService.onEvent(this, "category_2", "enter");
    }

    protected void d() {
        this.k = new o(this, new r(), this.n, this.p);
        this.e.setAdapter((ListAdapter) this.k);
        this.d.setText(this.n);
        this.j = (ProgressBar) findViewById(R.id.progress);
        this.m = (ImageView) findViewById(R.id.home);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.a, com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        bb.c(this.m, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.a
    public void c() {
        if (this.l != null) {
            this.l.cancel();
        }
        a((r) null, true);
        super.c();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.m) {
            MainTabActivity.a(this);
        }
    }

    protected void e() {
        this.e.setOnItemClickListener(new m(this));
        this.m.setOnClickListener(this);
    }

    protected void f() {
        this.j.setVisibility(0);
        this.e.setEnabled(false);
        if (this.l != null) {
            this.l.cancel();
        }
        this.l = new n(this, null);
        this.l.setPriority(3);
        this.l.execute("");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar, boolean z) {
        this.j.setVisibility(8);
        this.e.setEnabled(true);
        this.l = null;
        if (!z) {
            if (rVar.b()) {
                a(rVar.c());
                return;
            }
            this.e.setVisibility(4);
            this.k.notifyDataSetChanged();
            this.e.setVisibility(0);
        }
    }
}
