package com.baidu.tieba.recommend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class DailyRecommendActivity extends com.baidu.tieba.g {
    private z c;
    private w d;
    private String g;
    private final String b = DailyRecommendActivity.class.getSimpleName();
    private Handler e = null;
    private Runnable f = null;

    /* renamed from: a  reason: collision with root package name */
    q f1669a = new c(this);
    private com.baidu.adp.widget.ListView.r j = new d(this);
    private com.baidu.adp.widget.ListView.b k = new e(this);

    public void b() {
        this.e = new Handler();
        this.f = new f(this);
    }

    public void c() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            a(true, simpleDateFormat.format(new Date(simpleDateFormat.parse(this.g).getTime() - Util.MILLSECONDS_OF_DAY)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void k() {
        this.d = new w(this);
        this.d.a(new g(this));
        a(false, (String) null);
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a
    public void a(String str) {
        UtilHelper.a((Context) this, str);
    }

    private void l() {
        this.c = new z(this, this.j, this.f1669a);
        this.c.a(this.k);
        this.c.c();
    }

    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
            this.e.postDelayed(this.f, 300L);
        }
        this.c.g();
        if (TiebaApplication.g().u()) {
            StatService.onEvent(this, "recommend_feature", "visit", 1);
        }
    }

    public void a(boolean z, String str) {
        d();
        if (str == null && z) {
            StatService.onEvent(this.c.a(), "recommend_pull", "pull");
            this.d.a();
        } else if (str == null && !z) {
            this.d.b();
        } else if (str != null && z) {
            this.c.b();
            this.d.a(str);
        }
    }

    public void d() {
        this.d.cancelLoadData();
    }

    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
        }
        this.c.d();
        d();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        l();
        k();
    }

    @Override // com.baidu.tieba.g
    public void a(int i) {
        this.c.a(i);
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, DailyRecommendActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }
}
