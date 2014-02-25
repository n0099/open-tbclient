package com.baidu.tieba.person.post;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonPostActivity extends com.baidu.tieba.k implements View.OnClickListener {
    private String d;
    private String e;
    private String f;
    private int g;
    private boolean h = false;
    private j i;
    private e j;

    public static void a(Context context, String str, int i, String str2) {
        Intent intent = new Intent(context, PersonPostActivity.class);
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i);
        intent.putExtra("key_portrait_url", str2);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = getIntent().getStringExtra("key_portrait_url");
        this.d = getIntent().getStringExtra("key_uid");
        this.g = getIntent().getIntExtra("key_sex", 0);
        this.d = this.d == null ? "" : this.d;
        if (this.d.equals(TiebaApplication.A())) {
            this.e = getString(R.string.me);
            this.h = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.e = getString(R.string.he);
                    break;
                case 2:
                    this.e = getString(R.string.she);
                    break;
                default:
                    this.e = getString(R.string.ta);
                    break;
            }
        }
        this.i = new j(this);
        if (this.d == null) {
            finish();
            return;
        }
        this.i.c.setText(String.format(getString(R.string.person_post_thread), this.e));
        this.i.d.setText(String.format(getString(R.string.person_post_reply), this.e));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.j == null) {
            this.j = new e(this);
            this.i.a(new d(this));
            this.i.b.setAdapter(this.j);
        }
    }

    public String e() {
        return this.d;
    }

    public String f() {
        return this.e;
    }

    public String g() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tieba.k
    protected void b(int i) {
        this.i.a(i);
    }

    private void d(int i) {
        switch (i) {
            case 1:
                this.i.b(i);
                return;
            case 2:
                this.i.b(i);
                return;
            default:
                return;
        }
    }

    public String h() {
        return this.h ? getString(R.string.person_post_lv_empty_host) : String.format(getString(R.string.person_post_lv_empty_guest), f());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.reply /* 2131100874 */:
                cb.a(this, this.h ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
                d(2);
                this.i.b.setCurrentItem(1);
                return;
            case R.id.thread /* 2131101134 */:
                cb.a(this, this.h ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
                d(1);
                this.i.b.setCurrentItem(0);
                return;
            default:
                return;
        }
    }
}
