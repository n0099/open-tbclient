package com.baidu.tieba.recommend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class DailyRecommendActivity extends com.baidu.tbadk.a {
    private ab c;
    private y d;
    private String g;
    private final String b = DailyRecommendActivity.class.getSimpleName();
    private Handler e = null;
    private Runnable f = null;
    r a = new e(this);
    private final com.baidu.adp.widget.ListView.t h = new f(this);
    private final com.baidu.adp.widget.ListView.d i = new g(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010020, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    @SuppressLint({"SimpleDateFormat"})
    public final void a() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            a(true, simpleDateFormat.format(new Date(simpleDateFormat.parse(this.g).getTime() - 86400000)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a
    public void showToast(String str) {
        com.baidu.adp.lib.util.i.a((Context) this, str);
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
            this.e.postDelayed(this.f, 300L);
        }
        ab abVar = this.c;
        TiebaStatic.a(this, "recommend_feature", "visit", 1, new Object[0]);
    }

    public final void a(boolean z, String str) {
        b();
        if (str == null && z) {
            TiebaStatic.a(this.c.b(), "recommend_pull", "pull");
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

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
        }
        this.c.e();
        b();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = new Handler();
        this.f = new h(this);
        this.c = new ab(this, this.h, this.a);
        this.c.a(this.i);
        this.c.d();
        this.d = new y();
        if (bundle != null) {
            this.d.a(bundle);
        } else {
            this.d.a(getIntent());
        }
        this.d.a(new i(this));
        a(false, (String) null);
    }

    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        this.c.a(i);
    }
}
