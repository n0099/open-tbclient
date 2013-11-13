package com.baidu.tieba.more;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AccountActivity extends com.baidu.tieba.j {
    private NavigationBar d;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<AccountData> f1957a = null;
    private p b = null;
    private ListView c = null;
    private TextView e = null;
    private View.OnClickListener f = null;
    private m g = null;
    private j h = null;

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, AccountActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_activity);
        a();
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.d.c(i);
        bd.a((View) this.c, i);
        this.b.notifyDataSetChanged();
        if (i == 1) {
            this.c.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            this.c.setSelector(R.drawable.list_selector_1);
            return;
        }
        this.c.setDivider(getResources().getDrawable(R.drawable.list_divider));
        this.c.setSelector(R.drawable.list_selector);
    }

    private void a() {
        this.f1957a = DatabaseService.l();
    }

    private void b() {
        this.f = new f(this);
        this.d = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.d.a(getString(R.string.account_manager));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.edit));
        this.e.setOnClickListener(new h(this));
        this.b = new p(this, this.f);
        this.b.a(this.f1957a);
        this.c = (ListView) findViewById(R.id.list);
        this.c.setAdapter((ListAdapter) this.b);
        this.c.setOnItemClickListener(new i(this));
    }
}
