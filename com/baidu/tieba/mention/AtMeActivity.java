package com.baidu.tieba.mention;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ae;
/* loaded from: classes.dex */
public class AtMeActivity extends com.baidu.tieba.e {
    private h b = null;

    public void g() {
        this.b.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.at_me_activity);
        this.b = new h(this, 1, new a(this));
        this.b.a((ListView) findViewById(R.id.atme_lv));
        this.b.a((ProgressBar) findViewById(R.id.mention_progress_atme));
        this.b.a((FrameLayout) findViewById(R.id.mention_layout_atme));
        this.b.a(R.string.mention_atme_nodata);
        this.b.a((TextView) findViewById(R.id.at_nodata));
        this.b.a("c/u/feed/atme");
        this.b.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.b != null) {
                this.b.f();
                this.b.a();
            }
            System.gc();
        } catch (Exception e) {
            ae.b(getClass().getName(), "onDestroy", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.a().T() > 0) {
            this.b.b(2);
        } else {
            this.b.b(1);
        }
        this.b.d();
        this.b.e();
    }
}
