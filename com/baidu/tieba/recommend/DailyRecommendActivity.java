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
    private r bHS;
    private o bHT;
    private String bHU;
    l bHV = new e(this);
    private final aa buY = new f(this);
    private final com.baidu.adp.widget.ListView.f uo = new g(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010020, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void abI() {
        try {
            if (!getString(y.no_more_to_load).equals(this.bHS.bxK.aeQ())) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                g(true, simpleDateFormat.format(new Date(simpleDateFormat.parse(this.bHU).getTime() - 86400000)));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void d(Bundle bundle) {
        this.bHT = new o(this);
        if (bundle != null) {
            this.bHT.initWithBundle(bundle);
        } else {
            this.bHT.initWithIntent(getIntent());
        }
        this.bHT.a(new h(this));
        g(false, null);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void showToast(String str) {
        com.baidu.adp.lib.util.m.showToast(this, str);
    }

    private void initUI() {
        this.bHS = new r(this, this.buY, this.bHV);
        this.bHS.a(this.uo);
        this.bHS.YH();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bHS.onResume();
        TiebaStatic.eventStat(this, "recommend_feature", "visit", 1, new Object[0]);
    }

    public void g(boolean z, String str) {
        so();
        if (str == null && z) {
            TiebaStatic.eventStat(this.bHS.getContext(), "recommend_pull", "pull");
            this.bHT.yh();
        } else if (str == null && !z) {
            this.bHT.abK();
        } else if (str != null && z) {
            this.bHS.XB();
            this.bHT.hm(str);
        }
    }

    public void so() {
        this.bHT.cancelLoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.bHS.onDestroy();
        so();
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
        this.bHS.onChangeSkinType(i);
    }
}
