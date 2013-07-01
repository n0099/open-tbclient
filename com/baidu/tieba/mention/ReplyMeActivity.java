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
public class ReplyMeActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private h f977a = null;
    private ListView b = null;
    private TextView c = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.reply_me_activity);
        this.f977a = new h(this, 0, new aa(this));
        this.b = (ListView) findViewById(R.id.replyme_lv);
        this.f977a.a(this.b);
        this.f977a.a((ProgressBar) findViewById(R.id.mention_progress_replyme));
        this.f977a.a((FrameLayout) findViewById(R.id.mention_layout_replyme));
        this.f977a.a(R.string.mention_replyme_nodata);
        this.c = (TextView) findViewById(R.id.reply_nodata);
        this.f977a.a(this.c);
        this.f977a.a("c/u/feed/replyme");
        this.f977a.c();
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
        if (TiebaApplication.f().ad() > 0) {
            this.f977a.b(2);
        } else {
            this.f977a.b(1);
        }
        this.f977a.d();
        this.f977a.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f977a != null) {
                this.f977a.f();
                this.f977a.a();
            }
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "onDestroy", e.toString());
        }
    }

    public void b() {
        this.f977a.b();
    }
}
