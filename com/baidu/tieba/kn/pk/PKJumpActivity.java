package com.baidu.tieba.kn.pk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.tieba.util.ao;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PKJumpActivity extends com.baidu.tieba.g implements View.OnClickListener, com.baidu.adp.widget.ScrollView.n {

    /* renamed from: a  reason: collision with root package name */
    static s f1236a;
    private g b;
    private String c;
    private BdPullRefreshScrollView d;
    private ProgressBar e;
    private ImageView f;
    private TextView g;

    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent(context, PKJumpActivity.class);
        intent.putExtra("pk_id", str);
        intent.putExtra("pk_title", str2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.b = null;
        this.d.c();
        if (sVar.b()) {
            this.e.setVisibility(8);
            a(sVar.c());
            return;
        }
        f1236a = sVar;
        new Handler().postDelayed(new f(this, sVar), 300L);
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = getIntent().getStringExtra("pk_id");
        String stringExtra = getIntent().getStringExtra("pk_title");
        setContentView(R.layout.kn_pkjump_activity);
        c(stringExtra);
        c();
    }

    protected void c(String str) {
        this.d = (BdPullRefreshScrollView) findViewById(R.id.pullScrollView);
        this.d.setOnPullDownListener(this);
        this.d.setVisibility(0);
        this.e = (ProgressBar) findViewById(R.id.progress);
        this.g = (TextView) findViewById(R.id.title_text);
        if (str != null) {
            this.g.setText(str);
        }
        View findViewById = findViewById(R.id.title);
        this.f = (ImageView) findViewById(R.id.back);
        this.f.setOnClickListener(this);
        ao.a(this.f, 0);
        ao.d(findViewById, 0);
        ao.f(this.g, 0);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f) {
            b();
        }
    }

    protected void b() {
        finish();
    }

    protected void c() {
        this.e.setVisibility(0);
        if (this.b != null) {
            this.b.cancel(true);
        }
        this.b = new g(this);
        this.b.setPriority(3);
        this.b.execute("");
    }

    @Override // com.baidu.adp.widget.ScrollView.n
    public void a() {
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        if (this.b != null) {
            this.b.cancel(true);
            this.b = null;
        }
        this.e.setVisibility(8);
        this.d.c();
        this.d.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        d();
    }
}
