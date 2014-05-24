package com.baidu.tieba.square;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.AutoSkinActivity;
/* loaded from: classes.dex */
public class BarFolderSecondDirActivity extends AutoSkinActivity {
    private ProgressBar h;
    private q i;
    private p j;
    private String k;
    private String l;
    private String m;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.bar_folder_dir_activity);
        this.k = getIntent().getStringExtra("menuName");
        this.l = getIntent().getStringExtra("menuType");
        this.m = getIntent().getStringExtra("menuId");
        c();
        e();
        d();
        TiebaStatic.eventStat(this, "category_2", "enter");
    }

    protected void c() {
        this.i = new q(this, new t(), this.k, this.m);
        this.e.setAdapter((ListAdapter) this.i);
        this.d.setText(this.k);
        this.h = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.AutoSkinActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.AutoSkinActivity
    public void b() {
        if (this.j != null) {
            this.j.cancel();
        }
        a(null, true);
        super.b();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
    }

    protected void d() {
        this.e.setOnItemClickListener(new o(this));
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
