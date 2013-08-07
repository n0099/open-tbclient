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
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AccountActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f1388a = null;
    private o b = null;
    private LinearLayout c = null;
    private TextView d = null;
    private ListView e = null;
    private ImageView f = null;
    private Button g = null;
    private View.OnClickListener j = null;
    private l k = null;
    private i l = null;

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, AccountActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_activity);
        b();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ah.d(this.c, i);
        com.baidu.tieba.util.ah.a(this.f, i);
        com.baidu.tieba.util.ah.g((TextView) this.g, i);
        com.baidu.tieba.util.ah.f(this.d, i);
        com.baidu.tieba.util.ah.a((View) this.e, i);
        this.b.notifyDataSetChanged();
        if (i == 1) {
            this.e.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            this.e.setSelector(R.drawable.list_selector_1);
            return;
        }
        this.e.setDivider(getResources().getDrawable(R.drawable.list_divider));
        this.e.setSelector(R.drawable.list_selector);
    }

    private void b() {
        this.f1388a = DatabaseService.n();
    }

    private void c() {
        this.j = new e(this);
        this.f = (ImageView) findViewById(R.id.title_back);
        this.f.setOnClickListener(new f(this));
        this.g = (Button) findViewById(R.id.edit);
        this.g.setOnClickListener(new g(this));
        this.c = (LinearLayout) findViewById(R.id.title);
        this.d = (TextView) findViewById(R.id.title_text);
        this.b = new o(this, this.j);
        this.b.a(this.f1388a);
        this.e = (ListView) findViewById(R.id.list);
        this.e.setAdapter((ListAdapter) this.b);
        this.e.setOnItemClickListener(new h(this));
    }
}
