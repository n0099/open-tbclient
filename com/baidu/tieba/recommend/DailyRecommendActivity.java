package com.baidu.tieba.recommend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class DailyRecommendActivity extends com.baidu.tbadk.a {
    private r b;
    private o c;
    private String d;
    l a = new e(this);
    private final com.baidu.adp.widget.ListView.t e = new f(this);
    private final com.baidu.adp.widget.ListView.d f = new g(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010020, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    @SuppressLint({"SimpleDateFormat"})
    public final void a() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            a(true, simpleDateFormat.format(new Date(simpleDateFormat.parse(this.d).getTime() - 86400000)));
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
        r rVar = this.b;
        TiebaStatic.a(this, "recommend_feature", "visit", 1, new Object[0]);
    }

    public final void a(boolean z, String str) {
        b();
        if (str == null && z) {
            TiebaStatic.a(this.b.b(), "recommend_pull", "pull");
            this.c.a();
        } else if (str == null && !z) {
            this.c.b();
        } else if (str != null && z) {
            this.b.a();
            this.c.a(str);
        }
    }

    private void b() {
        this.c.cancelLoadData();
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        this.b.e();
        b();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new r(this, this.e, this.a);
        this.b.a(this.f);
        this.b.d();
        this.c = new o();
        if (bundle != null) {
            this.c.a(bundle);
        } else {
            this.c.a(getIntent());
        }
        this.c.a(new h(this));
        a(false, (String) null);
    }

    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        this.b.a(i);
    }
}
