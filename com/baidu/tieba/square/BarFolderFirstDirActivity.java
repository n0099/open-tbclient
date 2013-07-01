package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.x;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class BarFolderFirstDirActivity extends com.baidu.tieba.a {
    private ProgressBar j;
    private c k;
    private b l;

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, BarFolderFirstDirActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bar_folder_dir_activity);
        d();
        n();
        m();
        StatService.onEvent(this, "category_1", "enter");
    }

    protected void d() {
        this.k = new c(this, new f(), true);
        this.e.setAdapter((ListAdapter) this.k);
        this.d.setText(getString(R.string.bar_first_dir_name));
        this.j = (ProgressBar) findViewById(R.id.progress);
        ImageView imageView = (ImageView) findViewById(R.id.home);
        x.d(imageView, TiebaApplication.f().at());
        imageView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.a
    public void c() {
        if (this.l != null) {
            this.l.cancel();
        }
        a((f) null, true);
        super.c();
    }

    protected void m() {
        this.e.setOnItemClickListener(new a(this));
    }

    protected void n() {
        this.j.setVisibility(0);
        this.e.setEnabled(false);
        if (this.l != null) {
            this.l.cancel();
        }
        this.l = new b(this, null);
        this.l.setPriority(3);
        this.l.execute("");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(f fVar, boolean z) {
        this.j.setVisibility(8);
        this.e.setEnabled(true);
        this.l = null;
        if (!z) {
            if (fVar.a()) {
                a(fVar.b());
                return;
            }
            this.e.setVisibility(4);
            this.k.notifyDataSetChanged();
            this.e.setVisibility(0);
        }
    }
}
