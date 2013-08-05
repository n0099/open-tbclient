package com.baidu.tieba.mention;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ah;
import com.baidu.tieba.util.aj;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ReplyMeActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private h f1290a = null;
    private ListView b = null;
    private TextView c = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.reply_me_activity);
        this.f1290a = new h(this, 0, new aa(this));
        this.b = (ListView) findViewById(R.id.replyme_lv);
        this.f1290a.a(this.b);
        this.f1290a.a((ProgressBar) findViewById(R.id.mention_progress_replyme));
        this.f1290a.a((FrameLayout) findViewById(R.id.mention_layout_replyme));
        this.f1290a.a(R.string.mention_replyme_nodata);
        this.c = (TextView) findViewById(R.id.reply_nodata);
        this.f1290a.a(this.c);
        this.f1290a.a("c/u/feed/replyme");
        this.f1290a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        ah.a(this.b, i);
        if (i == 1) {
            this.c.setTextColor(ah.a(i));
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
            this.f1290a.b(2);
        } else {
            this.f1290a.b(1);
        }
        this.f1290a.d();
        this.f1290a.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f1290a != null) {
                this.f1290a.f();
                this.f1290a.a();
            }
            System.gc();
        } catch (Exception e) {
            aj.b(getClass().getName(), "onDestroy", e.toString());
        }
    }

    public void b() {
        this.f1290a.b();
    }
}
