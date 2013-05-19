package com.baidu.tieba.more;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AccountActivity extends com.baidu.tieba.e {
    private ArrayList c = null;
    private n d = null;
    private LinearLayout e = null;
    private TextView f = null;
    private ListView g = null;
    private ImageView h = null;
    private Button i = null;
    private View.OnClickListener j = null;
    private l k = null;
    private i l = null;

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, AccountActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_activity);
        b();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.d.ac.d(this.e, i);
        com.baidu.tieba.d.ac.a(this.h, i);
        com.baidu.tieba.d.ac.g((TextView) this.i, i);
        com.baidu.tieba.d.ac.f(this.f, i);
        com.baidu.tieba.d.ac.a((View) this.g, i);
        this.d.notifyDataSetChanged();
        if (i == 1) {
            this.g.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            this.g.setSelector(R.drawable.list_selector_1);
            return;
        }
        this.g.setDivider(getResources().getDrawable(R.drawable.list_divider));
        this.g.setSelector(R.drawable.list_selector);
    }

    private void b() {
        this.c = com.baidu.tieba.d.k.k();
    }

    private void c() {
        this.j = new e(this);
        this.h = (ImageView) findViewById(R.id.title_back);
        this.h.setOnClickListener(new f(this));
        this.i = (Button) findViewById(R.id.edit);
        this.i.setOnClickListener(new g(this));
        this.e = (LinearLayout) findViewById(R.id.title);
        this.f = (TextView) findViewById(R.id.title_text);
        this.d = new n(this, this.j);
        this.d.a(this.c);
        this.g = (ListView) findViewById(R.id.list);
        this.g.setAdapter((ListAdapter) this.d);
        this.g.setOnItemClickListener(new h(this));
    }
}
