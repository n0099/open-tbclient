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

    /* renamed from: a  reason: collision with root package name */
    private String f1703a;
    private String b;
    private String c;
    private int d;
    private boolean e = false;
    private PersonPostView f;
    private PersonPostAdapter g;

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
        this.c = getIntent().getStringExtra("key_portrait_url");
        this.f1703a = getIntent().getStringExtra("key_uid");
        this.d = getIntent().getIntExtra("key_sex", 0);
        String str = this.f1703a;
        TiebaApplication.g();
        if (str.equals(TiebaApplication.C())) {
            this.b = getString(R.string.me);
            this.e = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.b = getString(R.string.he);
                    break;
                case 2:
                    this.b = getString(R.string.she);
                    break;
                default:
                    this.b = getString(R.string.ta);
                    break;
            }
        }
        this.f = new PersonPostView(this);
        if (this.f1703a == null) {
            finish();
            return;
        }
        this.f.d.setText(String.format(getString(R.string.person_post_thread), this.b));
        this.f.e.setText(String.format(getString(R.string.person_post_reply), this.b));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.g == null) {
            this.g = new PersonPostAdapter(this);
            this.f.a(new d(this));
            this.f.b.setAdapter(this.g);
        }
    }

    public String a() {
        return this.f1703a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void a(int i) {
        this.f.c(i);
    }

    private void b(int i) {
        switch (i) {
            case 1:
                this.f.d(i);
                return;
            case 2:
                this.f.d(i);
                return;
            default:
                return;
        }
    }

    public String d() {
        return this.e ? getString(R.string.person_post_lv_empty_host) : String.format(getString(R.string.person_post_lv_empty_guest), b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131099729 */:
                finish();
                return;
            case R.id.reply /* 2131100302 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this, this.e ? "pp_my_reply" : "pp_his_reply", "click", 1);
                }
                b(2);
                this.f.b.setCurrentItem(1);
                return;
            case R.id.thread /* 2131100647 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this, this.e ? "pp_my_thread" : "pp_his_thread", "click", 1);
                }
                b(1);
                this.f.b.setCurrentItem(0);
                return;
            default:
                return;
        }
    }
}
