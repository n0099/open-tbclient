package com.baidu.tieba.mention;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.ag;
/* loaded from: classes.dex */
public class AtMeActivity extends com.baidu.tieba.e {
    private h c = null;
    private ListView d = null;
    private TextView e = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.at_me_activity);
        this.c = new h(this, 1, new a(this));
        this.d = (ListView) findViewById(R.id.atme_lv);
        this.c.a(this.d);
        this.c.a((ProgressBar) findViewById(R.id.mention_progress_atme));
        this.c.a((FrameLayout) findViewById(R.id.mention_layout_atme));
        this.c.a(R.string.mention_atme_nodata);
        this.e = (TextView) findViewById(R.id.at_nodata);
        this.c.a(this.e);
        this.c.a("c/u/feed/atme");
        this.c.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        ae.b(this.d, i);
        if (i == 1) {
            this.e.setTextColor(ae.a(i));
            this.e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.list_divider_1));
            return;
        }
        this.e.setTextColor(-4276546);
        this.e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.list_divider));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.b().Y() > 0) {
            this.c.b(2);
        } else {
            this.c.b(1);
        }
        this.c.d();
        this.c.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.c != null) {
                this.c.f();
                this.c.a();
            }
            System.gc();
        } catch (Exception e) {
            ag.b(getClass().getName(), "onDestroy", e.toString());
        }
    }

    public void i() {
        this.c.b();
    }
}
