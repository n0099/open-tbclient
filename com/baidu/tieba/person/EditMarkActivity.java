package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EditMarkActivity extends com.baidu.tieba.e {
    private com.baidu.tieba.home.af c = null;
    private com.baidu.tieba.b.h d = null;
    private ListView e = null;
    private Button f = null;
    private Button g = null;
    private RelativeLayout h = null;
    private LinearLayout i = null;
    private TextView j = null;

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, EditMarkActivity.class), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.edit_mark_activity);
        i();
        j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ad.a(this.h, i);
        com.baidu.tieba.c.ad.c(this.i, i);
        com.baidu.tieba.c.ad.c(this.j, i);
        com.baidu.tieba.c.ad.e((TextView) this.f, i);
        com.baidu.tieba.c.ad.d((TextView) this.g, i);
        this.c.notifyDataSetChanged();
        if (i == 1) {
            this.e.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            this.e.setSelector(R.drawable.list_selector_1);
            return;
        }
        this.e.setDivider(getResources().getDrawable(R.drawable.list_divider));
        this.e.setSelector(R.drawable.list_selector);
    }

    private void i() {
        this.d = new com.baidu.tieba.b.h();
        this.d.a(com.baidu.tieba.c.k.q());
    }

    private void j() {
        this.h = (RelativeLayout) findViewById(R.id.parent);
        this.i = (LinearLayout) findViewById(R.id.title);
        this.j = (TextView) findViewById(R.id.title_text);
        this.c = new com.baidu.tieba.home.af(this, this.d.a());
        this.c.a(true);
        this.c.a();
        this.e = (ListView) findViewById(R.id.list);
        this.e.setAdapter((ListAdapter) this.c);
        this.e.setOnItemClickListener(new w(this));
        this.f = (Button) findViewById(R.id.back);
        this.f.setOnClickListener(new x(this));
        this.g = (Button) findViewById(R.id.edit);
        this.g.setOnClickListener(new y(this));
        if (this.d.a().size() == 0) {
            this.g.setVisibility(4);
        }
        this.c.a(new z(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        if (com.baidu.tieba.c.k.r().booleanValue()) {
            this.d.a(com.baidu.tieba.c.k.q());
            ArrayList a = this.d.a();
            if (a != null) {
                this.c.a(a);
                this.c.a();
                this.c.notifyDataSetInvalidated();
                if (a.size() == 0) {
                    this.g.setVisibility(4);
                } else {
                    this.g.setVisibility(0);
                }
            }
        }
    }
}
