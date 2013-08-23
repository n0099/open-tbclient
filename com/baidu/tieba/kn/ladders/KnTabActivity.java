package com.baidu.tieba.kn.ladders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ao;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class KnTabActivity extends BaseFragmentActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private y f1211a;
    private KnLaddersFragment b;
    private KnPkHomeFragment c;
    private ImageView d;

    public static void a(Context context) {
        context.startActivity(new Intent(context, KnTabActivity.class));
    }

    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d("KnTabActivity", "@onCreate");
        setContentView(R.layout.kn_tab_activity);
        this.f1211a = new y(this);
        c();
        this.f1211a.i.setAdapter(new x(this, getSupportFragmentManager()));
        this.f1211a.i.setOnPageChangeListener(new v(this));
    }

    private void c() {
        this.d = (ImageView) findViewById(R.id.back);
        this.d.setOnClickListener(new w(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.g().u()) {
            StatService.onEvent(this, "kn_ladders", "enter", 1);
        }
        if (this.b != null) {
            this.c.a(true);
        }
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void a(int i) {
        ao.d(this.f1211a.c, i);
        ao.b(this.f1211a.f, i);
        ao.a(this.d, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.refresh /* 2131099800 */:
                this.f1211a.d.loadUrl(com.baidu.tieba.data.g.b);
                return;
            case R.id.kn_ladders /* 2131100332 */:
                this.f1211a.i.setCurrentItem(0);
                return;
            case R.id.kn_pk /* 2131100333 */:
                this.f1211a.i.setCurrentItem(1);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("pager_index", this.f1211a.i.getCurrentItem());
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.f1211a.j.setPosition(bundle.getInt("pager_index"));
        }
        super.onRestoreInstanceState(bundle);
    }

    public y a() {
        return this.f1211a;
    }

    public void b() {
        if (this.f1211a != null && this.f1211a.i != null && this.b != null) {
            this.f1211a.i.setCurrentItem(0);
            this.b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onDestroy() {
        this.f1211a.i.setAdapter(null);
        super.onDestroy();
    }

    @Override // android.support.v4.app.n, android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent.getBooleanExtra("reset", false)) {
            b();
        }
    }
}
