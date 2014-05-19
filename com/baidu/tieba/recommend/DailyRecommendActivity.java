package com.baidu.tieba.recommend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class DailyRecommendActivity extends BaseActivity {
    private r b;
    private o c;
    private String d;
    l a = new e(this);
    private final u e = new f(this);
    private final com.baidu.adp.widget.ListView.d f = new g(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfig.DAILY_RECOMMEND_CUSTOM_CMD, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @SuppressLint({"SimpleDateFormat"})
    public void a() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            a(true, simpleDateFormat.format(new Date(simpleDateFormat.parse(this.d).getTime() - 86400000)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void a(Bundle bundle) {
        this.c = new o(this);
        if (bundle != null) {
            this.c.a(bundle);
        } else {
            this.c.a(getIntent());
        }
        this.c.a(new h(this));
        a(false, (String) null);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void showToast(String str) {
        com.baidu.adp.lib.util.h.a((Context) this, str);
    }

    private void c() {
        this.b = new r(this, this.e, this.a);
        this.b.a(this.f);
        this.b.b();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.b.e();
        TiebaStatic.eventStat(this, "recommend_feature", "visit", 1, new Object[0]);
    }

    public void a(boolean z, String str) {
        b();
        if (str == null && z) {
            TiebaStatic.eventStat(this.b.getContext(), "recommend_pull", "pull");
            this.c.a();
        } else if (str == null && !z) {
            this.c.b();
        } else if (str != null && z) {
            this.b.a();
            this.c.a(str);
        }
    }

    public void b() {
        this.c.cancelLoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.b.c();
        b();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
        a(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.b.a(i);
    }
}
