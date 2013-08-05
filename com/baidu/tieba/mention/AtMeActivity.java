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
public class AtMeActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private h f1287a = null;
    private ListView b = null;
    private TextView c = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.at_me_activity);
        this.f1287a = new h(this, 1, new a(this));
        this.b = (ListView) findViewById(R.id.atme_lv);
        this.f1287a.a(this.b);
        this.f1287a.a((ProgressBar) findViewById(R.id.mention_progress_atme));
        this.f1287a.a((FrameLayout) findViewById(R.id.mention_layout_atme));
        this.f1287a.a(R.string.mention_atme_nodata);
        this.c = (TextView) findViewById(R.id.at_nodata);
        this.f1287a.a(this.c);
        this.f1287a.a("c/u/feed/atme");
        this.f1287a.c();
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
        if (TiebaApplication.f().af() > 0) {
            this.f1287a.b(2);
        } else {
            this.f1287a.b(1);
        }
        this.f1287a.d();
        this.f1287a.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f1287a != null) {
                this.f1287a.f();
                this.f1287a.a();
            }
            System.gc();
        } catch (Exception e) {
            aj.b(getClass().getName(), "onDestroy", e.toString());
        }
    }

    public void b() {
        this.f1287a.b();
    }
}
