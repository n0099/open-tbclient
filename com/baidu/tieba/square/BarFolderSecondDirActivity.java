package com.baidu.tieba.square;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class BarFolderSecondDirActivity extends com.baidu.tieba.a {
    private ProgressBar h;
    private q i;
    private p j;
    private String k;
    private String l;
    private String m;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.bar_folder_dir_activity);
        this.k = getIntent().getStringExtra("menuName");
        this.l = getIntent().getStringExtra("menuType");
        this.m = getIntent().getStringExtra("menuId");
        this.i = new q(this, new t(), this.k, this.m);
        this.e.setAdapter((ListAdapter) this.i);
        this.d.setText(this.k);
        this.h = (ProgressBar) findViewById(com.baidu.tieba.a.h.progress);
        this.h.setVisibility(0);
        this.e.setEnabled(false);
        if (this.j != null) {
            this.j.cancel();
        }
        this.j = new p(this, (byte) 0);
        this.j.setPriority(3);
        this.j.execute("");
        this.e.setOnItemClickListener(new o(this));
        TiebaStatic.a(this, "category_2", "enter");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.a, com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.a
    public final void a() {
        if (this.j != null) {
            this.j.cancel();
        }
        a(null, true);
        super.a();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(t tVar, boolean z) {
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
