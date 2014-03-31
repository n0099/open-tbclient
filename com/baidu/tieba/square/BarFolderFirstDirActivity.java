package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class BarFolderFirstDirActivity extends com.baidu.tbadk.a {
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
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.bar_folder_dir_activity);
        this.h = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.h.a(getResources().getString(com.baidu.tieba.a.k.bar_first_dir_name));
        this.h.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a = (ListView) findViewById(com.baidu.tieba.a.h.list);
        this.e = new c(this, new h());
        this.a.setAdapter((ListAdapter) this.e);
        this.d = (ProgressBar) findViewById(com.baidu.tieba.a.h.progress);
        this.b = (ViewGroup) findViewById(com.baidu.tieba.a.h.body_container);
        bn.b(this.b);
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
        this.f = new b(this, (byte) 0);
        this.f.setPriority(3);
        this.f.execute("");
        this.a.setOnItemClickListener(new a(this));
        TiebaStatic.a(this, "category_1", "enter");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        this.e.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f != null) {
            this.f.cancel();
        }
        a((h) null, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(h hVar, boolean z) {
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
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.h.b(i);
        if (this.a != null) {
            this.a.invalidateViews();
        }
        if (this.b != null) {
            bn.a(this.b, i);
        }
        ba.b(findViewById(com.baidu.tieba.a.h.root_view), i);
    }
}
