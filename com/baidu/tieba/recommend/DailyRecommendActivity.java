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
public class DailyRecommendActivity extends com.baidu.tieba.j {
    private z c;
    private w d;
    private String g;
    private final String b = DailyRecommendActivity.class.getSimpleName();
    private Handler e = null;
    private Runnable f = null;

    /* renamed from: a  reason: collision with root package name */
    q f2284a = new c(this);
    private com.baidu.adp.widget.ListView.r h = new e(this);
    private com.baidu.adp.widget.ListView.b i = new g(this);

    public void a() {
        this.e = new Handler();
        this.f = new d(this);
    }

    public void b() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            a(true, simpleDateFormat.format(new Date(simpleDateFormat.parse(this.g).getTime() - Util.MILLSECONDS_OF_DAY)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void a(Bundle bundle) {
        this.d = new w(this);
        if (bundle != null) {
            this.d.a(bundle);
        } else {
            this.d.a(getIntent());
        }
        this.d.a(new f(this));
        a(false, (String) null);
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a
    public void showToast(String str) {
        UtilHelper.a((Context) this, str);
    }

    private void d() {
        this.c = new z(this, this.h, this.f2284a);
        this.c.a(this.i);
        this.c.e();
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
            this.e.postDelayed(this.f, 300L);
        }
        this.c.i();
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this, "recommend_feature", "visit", 1);
        }
    }

    public void a(boolean z, String str) {
        c();
        if (str == null && z) {
            StatService.onEvent(this.c.b(), "recommend_pull", "pull");
            this.d.a();
        } else if (str == null && !z) {
            this.d.b();
        } else if (str != null && z) {
            this.c.a();
            this.d.a(str);
        }
    }

    public void c() {
        this.d.cancelLoadData();
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
        }
        this.c.f();
        c();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        d();
        a(bundle);
    }

    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        this.c.a(i);
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, DailyRecommendActivity.class);
        intent.putExtra(w.f2310a, str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }
}
