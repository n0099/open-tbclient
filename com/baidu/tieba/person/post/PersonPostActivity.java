package com.baidu.tieba.person.post;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements View.OnClickListener {
    private String b;
    private String c;
    private String d;
    private int e;
    private boolean f = false;
    private PersonPostView g;
    private PersonPostAdapter h;

    public static void a(Context context, String str, int i, String str2) {
        Intent intent = new Intent(context, PersonPostActivity.class);
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i);
        intent.putExtra("key_portrait_url", str2);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = getIntent().getStringExtra("key_portrait_url");
        this.b = getIntent().getStringExtra("key_uid");
        this.e = getIntent().getIntExtra("key_sex", 0);
        this.b = this.b == null ? "" : this.b;
        if (this.b.equals(TiebaApplication.A())) {
            this.c = getString(R.string.me);
            this.f = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.c = getString(R.string.he);
                    break;
                case 2:
                    this.c = getString(R.string.she);
                    break;
                default:
                    this.c = getString(R.string.ta);
                    break;
            }
        }
        this.g = new PersonPostView(this);
        if (this.b == null) {
            finish();
            return;
        }
        this.g.c.setText(String.format(getString(R.string.person_post_thread), this.c));
        this.g.d.setText(String.format(getString(R.string.person_post_reply), this.c));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.h == null) {
            this.h = new PersonPostAdapter(this);
            this.g.a(new d(this));
            this.g.b.setAdapter(this.h);
        }
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void a(int i) {
        this.g.a(i);
    }

    private void c(int i) {
        switch (i) {
            case 1:
                this.g.b(i);
                return;
            case 2:
                this.g.b(i);
                return;
            default:
                return;
        }
    }

    public String f() {
        return this.f ? getString(R.string.person_post_lv_empty_host) : String.format(getString(R.string.person_post_lv_empty_guest), d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.reply /* 2131100436 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this, this.f ? "pp_my_reply" : "pp_his_reply", "click", 1);
                }
                c(2);
                this.g.b.setCurrentItem(1);
                return;
            case R.id.thread /* 2131100607 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this, this.f ? "pp_my_thread" : "pp_his_thread", "click", 1);
                }
                c(1);
                this.g.b.setCurrentItem(0);
                return;
            default:
                return;
        }
    }
}
