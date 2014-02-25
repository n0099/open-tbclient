package com.baidu.tieba.more;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AccountActivity extends com.baidu.tieba.f {
    private NavigationBar e;
    private ArrayList<AccountData> a = null;
    private p b = null;
    private ListView c = null;
    private RelativeLayout d = null;
    private TextView f = null;
    private View.OnClickListener g = null;
    private m h = null;
    private j i = null;

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, AccountActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_activity);
        a();
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.e.c(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a((View) this.d);
        this.b.notifyDataSetChanged();
    }

    private void a() {
        this.a = DatabaseService.j();
    }

    private void b() {
        this.d = (RelativeLayout) findViewById(R.id.account_container);
        this.g = new f(this);
        this.e = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.e.a(getString(R.string.account_manager));
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.edit));
        this.f.setOnClickListener(new h(this));
        this.b = new p(this, this.g);
        this.b.a(this.a);
        this.c = (ListView) findViewById(R.id.list);
        this.c.setAdapter((ListAdapter) this.b);
        this.c.setOnItemClickListener(new i(this));
    }
}
