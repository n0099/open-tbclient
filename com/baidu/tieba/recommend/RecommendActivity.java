package com.baidu.tieba.recommend;

import android.os.Bundle;
import android.support.v4.view.bq;
import android.view.View;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class RecommendActivity extends BaseFragmentActivity implements bq, View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private as f1627a = new at();
    private bb b;
    private int c;
    private int d;

    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.recommend_tab_activity);
        this.b = new bb(this);
        this.b.f1655a.setAdapter(new ba(this, getSupportFragmentManager()));
        this.b.f1655a.setOnPageChangeListener(this);
        this.b.e.setOnClickListener(this);
        this.b.d.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void c(int i) {
        com.baidu.tieba.util.ah.a(findViewById(16908290), i);
        com.baidu.tieba.util.ah.d(this.b.b, i);
        if (i == 1) {
            this.c = -5524539;
            this.d = -10523526;
        } else if (i == 0) {
            this.c = -5524539;
            this.d = -6379855;
        }
        int currentItem = this.b.f1655a.getCurrentItem();
        if (currentItem == 0) {
            this.b.d.setTextColor(this.c);
            this.b.e.setTextColor(this.d);
        } else if (currentItem == 1) {
            this.b.d.setTextColor(this.d);
            this.b.e.setTextColor(this.c);
        }
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
        this.b.c.setPosition(i + f);
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
        if (i == 0) {
            this.b.d.setTextColor(this.c);
            this.b.e.setTextColor(this.d);
        } else if (i == 1) {
            this.b.d.setTextColor(this.d);
            this.b.e.setTextColor(this.c);
        }
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
        View m;
        View m2;
        if (i == 0) {
            switch (this.b.f1655a.getCurrentItem()) {
                case 0:
                    BaseFragment c = this.f1627a.c();
                    if (c != null && (m2 = c.m()) != null) {
                        m2.requestFocus();
                    }
                    this.b.c.setPosition(0.0f);
                    return;
                case 1:
                    BaseFragment d = this.f1627a.d();
                    if (d != null && (m = d.m()) != null) {
                        m.requestFocus();
                    }
                    this.b.c.setPosition(1.0f);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("pager_index", this.b.f1655a.getCurrentItem());
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.b.c.setPosition(bundle.getInt("pager_index"));
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.feature /* 2131100539 */:
                this.b.f1655a.setCurrentItem(0);
                this.b.c.postDelayed(new ay(this), 2000L);
                return;
            case R.id.explore /* 2131100540 */:
                this.b.f1655a.setCurrentItem(1);
                this.b.c.postDelayed(new az(this), 2000L);
                return;
            default:
                return;
        }
    }
}
