package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EditMarkActivity extends com.baidu.tieba.e {
    private com.baidu.tieba.home.y b = null;
    private com.baidu.tieba.b.h c = null;
    private ListView d = null;
    private Button e = null;
    private Button f = null;

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, EditMarkActivity.class), i);
    }

    private void g() {
        this.c = new com.baidu.tieba.b.h();
        this.c.a(com.baidu.tieba.c.k.o());
    }

    private void h() {
        this.b = new com.baidu.tieba.home.y(this, this.c.a());
        this.b.a(true);
        this.b.a();
        this.d = (ListView) findViewById(R.id.list);
        this.d.setAdapter((ListAdapter) this.b);
        this.d.setOnItemClickListener(new u(this));
        this.e = (Button) findViewById(R.id.back);
        this.e.setOnClickListener(new v(this));
        this.f = (Button) findViewById(R.id.edit);
        this.f.setOnClickListener(new w(this));
        if (this.c.a().size() == 0) {
            this.f.setVisibility(4);
        }
        this.b.a(new x(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.edit_mark_activity);
        g();
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        if (com.baidu.tieba.c.k.p().booleanValue()) {
            this.c.a(com.baidu.tieba.c.k.o());
            ArrayList a = this.c.a();
            if (a != null) {
                this.b.a(a);
                this.b.a();
                this.b.notifyDataSetInvalidated();
                if (a.size() == 0) {
                    this.f.setVisibility(4);
                } else {
                    this.f.setVisibility(0);
                }
            }
        }
    }
}
