package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class EditBarActivity extends com.baidu.tieba.e {
    private com.baidu.tieba.b.b b = null;
    private ListView c = null;
    private Button d = null;
    private Button e = null;
    private g f = null;
    private ProgressBar g = null;
    private e h = null;
    private int i = -1;
    private f j = null;

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, EditBarActivity.class), i);
    }

    private void g() {
        if (this.h != null) {
            this.h.a();
        }
        this.h = new e(this, null);
        this.h.execute(new Object[0]);
    }

    private void h() {
        this.b = new com.baidu.tieba.b.b();
    }

    private void i() {
        this.g = (ProgressBar) findViewById(R.id.progress);
        this.d = (Button) findViewById(R.id.back);
        this.d.setOnClickListener(new a(this));
        this.f = new g(this, this.b);
        this.f.a(new b(this));
        this.c = (ListView) findViewById(R.id.list);
        this.c.setAdapter((ListAdapter) this.f);
        this.c.setOnItemClickListener(new c(this));
        this.e = (Button) findViewById(R.id.edit);
        this.e.setOnClickListener(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f == null) {
            return;
        }
        this.f.b();
        if (!this.f.c()) {
            this.e.setVisibility(0);
            return;
        }
        this.e.setVisibility(4);
        this.f.a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.edit_bar_activity);
        h();
        i();
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.h != null) {
            this.h.a();
        }
        if (this.j != null) {
            this.j.a();
        }
        if (this.g != null) {
            this.g.setVisibility(8);
        }
        super.onDestroy();
    }
}
