package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.util.bj;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class BarFolderFirstDirActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    protected ListView f2328a = null;
    protected ViewGroup b;
    private ProgressBar c;
    private c d;
    private b e;
    private NavigationBar f;

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, BarFolderFirstDirActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bar_folder_dir_activity);
        b();
        d();
        c();
        StatService.onEvent(this, "category_1", "enter");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.d.notifyDataSetChanged();
    }

    protected void b() {
        this.f = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.f.a(getResources().getString(R.string.bar_first_dir_name));
        this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f2328a = (ListView) findViewById(R.id.list);
        this.d = new c(this, new g(), true);
        this.f2328a.setAdapter((ListAdapter) this.d);
        this.c = (ProgressBar) findViewById(R.id.progress);
        this.b = (ViewGroup) findViewById(R.id.body_container);
        bj.b(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.e != null) {
            this.e.cancel();
        }
        a((g) null, true);
    }

    protected void c() {
        this.f2328a.setOnItemClickListener(new a(this));
    }

    protected void d() {
        this.c.setVisibility(0);
        this.f2328a.setEnabled(false);
        if (this.e != null) {
            this.e.cancel();
        }
        this.e = new b(this, null);
        this.e.setPriority(3);
        this.e.execute("");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar, boolean z) {
        this.c.setVisibility(8);
        this.f2328a.setEnabled(true);
        this.e = null;
        if (!z) {
            if (gVar.b()) {
                a(gVar.c());
                return;
            }
            this.d.a(gVar.d());
            this.f2328a.setVisibility(4);
            this.d.notifyDataSetChanged();
            this.f2328a.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        this.f.b(i);
        if (this.f2328a != null) {
            this.f2328a.invalidateViews();
        }
        if (this.b != null) {
            bj.a(this.b, i);
        }
        bb.b(findViewById(R.id.root_view), i);
    }
}
