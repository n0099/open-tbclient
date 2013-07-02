package com.baidu.tieba.mention;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class AtMeActivity extends com.baidu.tieba.g {
    private h a = null;
    private ListView b = null;
    private TextView c = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.at_me_activity);
        this.a = new h(this, 1, new a(this));
        this.b = (ListView) findViewById(R.id.atme_lv);
        this.a.a(this.b);
        this.a.a((ProgressBar) findViewById(R.id.mention_progress_atme));
        this.a.a((FrameLayout) findViewById(R.id.mention_layout_atme));
        this.a.a(R.string.mention_atme_nodata);
        this.c = (TextView) findViewById(R.id.at_nodata);
        this.a.a(this.c);
        this.a.a("c/u/feed/atme");
        this.a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.x.a(this.b, i);
        if (i == 1) {
            this.c.setTextColor(com.baidu.tieba.util.x.a(i));
            this.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.list_divider_1));
            return;
        }
        this.c.setTextColor(-4276546);
        this.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.list_divider));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.f().ae() > 0) {
            this.a.b(2);
        } else {
            this.a.b(1);
        }
        this.a.d();
        this.a.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.a != null) {
                this.a.f();
                this.a.a();
            }
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "onDestroy", e.toString());
        }
    }

    public void b() {
        this.a.b();
    }
}
