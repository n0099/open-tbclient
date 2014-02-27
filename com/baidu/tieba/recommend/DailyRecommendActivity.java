package com.baidu.tieba.recommend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.util.cb;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class DailyRecommendActivity extends com.baidu.tieba.f {
    private z c;
    private w d;
    private String g;
    private final String b = DailyRecommendActivity.class.getSimpleName();
    private Handler e = null;
    private Runnable f = null;
    p a = new c(this);
    private com.baidu.adp.widget.ListView.r h = new d(this);
    private com.baidu.adp.widget.ListView.b i = new e(this);

    public final void a() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            a(true, simpleDateFormat.format(new Date(simpleDateFormat.parse(this.g).getTime() - 86400000)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a
    public void showToast(String str) {
        BdUtilHelper.a((Context) this, str);
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
            this.e.postDelayed(this.f, 300L);
        }
        z zVar = this.c;
        cb.a(this, "recommend_feature", "visit", 1, new Object[0]);
    }

    public final void a(boolean z, String str) {
        b();
        if (str == null && z) {
            cb.a(this.c.b(), "recommend_pull", "pull");
            this.d.a();
        } else if (str == null && !z) {
            this.d.b();
        } else if (str != null && z) {
            this.c.a();
            this.d.a(str);
        }
    }

    private void b() {
        this.d.cancelLoadData();
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
        }
        this.c.e();
        b();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = new Handler();
        this.f = new f(this);
        this.c = new z(this, this.h, this.a);
        this.c.a(this.i);
        this.c.d();
        this.d = new w();
        if (bundle != null) {
            this.d.a(bundle);
        } else {
            this.d.a(getIntent());
        }
        this.d.a(new g(this));
        a(false, (String) null);
    }

    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        this.c.a(i);
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, DailyRecommendActivity.class);
        intent.putExtra(w.a, str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }
}
