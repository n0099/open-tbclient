package com.baidu.tieba.square;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.MainTabActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class BarFolderSecondDirActivity extends com.baidu.tieba.a {
    private ProgressBar h;
    private q i;
    private p j;
    private ImageView k = null;
    private String l;
    private String m;
    private String n;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bar_folder_dir_activity);
        this.l = getIntent().getStringExtra("menuName");
        this.m = getIntent().getStringExtra("menuType");
        this.n = getIntent().getStringExtra("menuId");
        c();
        e();
        d();
        StatService.onEvent(this, "category_2", "enter");
    }

    protected void c() {
        this.i = new q(this, new t(), this.l, this.n);
        this.e.setAdapter((ListAdapter) this.i);
        this.d.setText(this.l);
        this.h = (ProgressBar) findViewById(R.id.progress);
        this.k = (ImageView) findViewById(R.id.home);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.a, com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tieba.util.bb.c(this.k, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.a
    public void b() {
        if (this.j != null) {
            this.j.cancel();
        }
        a(null, true);
        super.b();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.k) {
            MainTabActivity.a(this);
        }
    }

    protected void d() {
        this.e.setOnItemClickListener(new o(this));
        this.k.setOnClickListener(this);
    }

    protected void e() {
        this.h.setVisibility(0);
        this.e.setEnabled(false);
        if (this.j != null) {
            this.j.cancel();
        }
        this.j = new p(this, null);
        this.j.setPriority(3);
        this.j.execute("");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(t tVar, boolean z) {
        this.h.setVisibility(8);
        this.e.setEnabled(true);
        this.j = null;
        if (!z) {
            if (tVar.b()) {
                showToast(tVar.c());
                return;
            }
            this.e.setVisibility(4);
            this.i.notifyDataSetChanged();
            this.e.setVisibility(0);
        }
    }
}
