package com.baidu.tieba.kn.ladders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ah;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class KnTabActivity extends BaseFragmentActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private x f1179a;
    private KnLaddersFragment b;
    private KnPkHomeFragment c;

    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d("KnTabActivity", "@onCreate");
        setContentView(R.layout.kn_tab_activity);
        this.f1179a = new x(this);
        this.f1179a.i.setAdapter(new w(this, getSupportFragmentManager()));
        this.f1179a.i.setOnPageChangeListener(new v(this));
    }

    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (TiebaApplication.f().t()) {
            StatService.onEvent(this, "kn_ladders", "enter", 1);
        }
        if (this.b != null) {
            this.c.a(true);
        }
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void c(int i) {
        ah.d(this.f1179a.c, i);
        ah.b(this.f1179a.f, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.refresh /* 2131099800 */:
                this.f1179a.d.loadUrl(com.baidu.tieba.data.g.b);
                return;
            case R.id.kn_ladders /* 2131100293 */:
                this.f1179a.i.setCurrentItem(0);
                return;
            case R.id.kn_pk /* 2131100294 */:
                this.f1179a.i.setCurrentItem(1);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("pager_index", this.f1179a.i.getCurrentItem());
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.f1179a.j.setPosition(bundle.getInt("pager_index"));
        }
        super.onRestoreInstanceState(bundle);
    }

    public x a() {
        return this.f1179a;
    }

    public void b() {
        if (this.f1179a != null && this.f1179a.i != null && this.b != null) {
            this.f1179a.i.setCurrentItem(0);
            this.b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onDestroy() {
        this.f1179a.i.setAdapter(null);
        super.onDestroy();
    }

    @Override // android.support.v4.app.n, android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent.getBooleanExtra("reset", false)) {
            b();
        }
    }
}
