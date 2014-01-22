package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.util.ce;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class BarFolderFirstDirActivity extends com.baidu.tieba.j {
    public static String c = "st_type";
    protected ViewGroup b;
    private ProgressBar d;
    private c e;
    private b f;
    private NavigationBar h;
    protected ListView a = null;
    private String g = null;

    public static void a(Activity activity, String str) {
        Intent intent = new Intent(activity, BarFolderFirstDirActivity.class);
        intent.putExtra(c, str);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bar_folder_dir_activity);
        a();
        a(bundle);
        b();
        com.baidu.tieba.util.by.a(this, "category_1", "enter");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.e.notifyDataSetChanged();
    }

    protected void a() {
        this.h = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.h.a(getResources().getString(R.string.bar_first_dir_name));
        this.h.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a = (ListView) findViewById(R.id.list);
        this.e = new c(this, new h(), true);
        this.a.setAdapter((ListAdapter) this.e);
        this.d = (ProgressBar) findViewById(R.id.progress);
        this.b = (ViewGroup) findViewById(R.id.body_container);
        ce.b(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f != null) {
            this.f.cancel();
        }
        a((h) null, true);
    }

    protected void b() {
        this.a.setOnItemClickListener(new a(this));
    }

    protected void a(Bundle bundle) {
        if (bundle != null) {
            this.g = bundle.getString(c);
        } else {
            this.g = getIntent().getStringExtra(c);
        }
        this.d.setVisibility(0);
        this.a.setEnabled(false);
        if (this.f != null) {
            this.f.cancel();
        }
        this.f = new b(this, null);
        this.f.setPriority(3);
        this.f.execute("");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar, boolean z) {
        this.d.setVisibility(8);
        this.a.setEnabled(true);
        this.f = null;
        if (!z) {
            if (hVar.b()) {
                showToast(hVar.c());
                return;
            }
            this.e.a(hVar.d());
            this.a.setVisibility(4);
            this.e.notifyDataSetChanged();
            this.a.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.h.c(i);
        if (this.a != null) {
            this.a.invalidateViews();
        }
        if (this.b != null) {
            ce.a(this.b, i);
        }
        com.baidu.tieba.util.bs.b(findViewById(R.id.root_view), i);
    }
}
