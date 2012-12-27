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
public class ReplyMeActivity extends com.baidu.tieba.e {
    private h b = null;

    public void g() {
        this.b.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.reply_me_activity);
        this.b = new h(this, 0, new aa(this));
        this.b.a((ListView) findViewById(R.id.replyme_lv));
        this.b.a((ProgressBar) findViewById(R.id.mention_progress_replyme));
        this.b.a((FrameLayout) findViewById(R.id.mention_layout_replyme));
        this.b.a(R.string.mention_replyme_nodata);
        this.b.a((TextView) findViewById(R.id.reply_nodata));
        this.b.a("c/u/feed/replyme");
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
        if (TiebaApplication.a().S() > 0) {
            this.b.b(2);
        } else {
            this.b.b(1);
        }
        this.b.d();
        this.b.e();
    }
}
