package com.baidu.tieba.recommend;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.y;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class DailyRecommendActivity extends BaseActivity {
    private r bIg;
    private o bIh;
    private String bIi;
    l bIj = new e(this);
    private final aa bvm = new f(this);
    private final com.baidu.adp.widget.ListView.f uo = new g(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010020, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void abL() {
        try {
            if (!getString(y.no_more_to_load).equals(this.bIg.bxY.aeT())) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                g(true, simpleDateFormat.format(new Date(simpleDateFormat.parse(this.bIi).getTime() - 86400000)));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void d(Bundle bundle) {
        this.bIh = new o(this);
        if (bundle != null) {
            this.bIh.initWithBundle(bundle);
        } else {
            this.bIh.initWithIntent(getIntent());
        }
        this.bIh.a(new h(this));
        g(false, null);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void showToast(String str) {
        com.baidu.adp.lib.util.m.showToast(this, str);
    }

    private void initUI() {
        this.bIg = new r(this, this.bvm, this.bIj);
        this.bIg.a(this.uo);
        this.bIg.YK();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bIg.onResume();
        TiebaStatic.eventStat(this, "recommend_feature", "visit", 1, new Object[0]);
    }

    public void g(boolean z, String str) {
        sq();
        if (str == null && z) {
            TiebaStatic.eventStat(this.bIg.getContext(), "recommend_pull", "pull");
            this.bIh.yj();
        } else if (str == null && !z) {
            this.bIh.abN();
        } else if (str != null && z) {
            this.bIg.XE();
            this.bIh.hm(str);
        }
    }

    public void sq() {
        this.bIh.cancelLoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.bIg.onDestroy();
        sq();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        d(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bIg.onChangeSkinType(i);
    }
}
