package com.baidu.tieba.mention;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.aq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ReplyMeActivity extends com.baidu.tieba.g implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    private i f1321a = null;
    private BdListView b = null;
    private com.baidu.tieba.view.aa c;
    private FrameLayout d;
    private LinearLayout e;
    private com.baidu.tieba.home.z f;
    private com.baidu.tieba.ab g;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.reply_me_activity);
        this.c = new com.baidu.tieba.view.aa(this);
        this.c.a(this);
        this.d = (FrameLayout) findViewById(R.id.bodyLogin);
        this.e = (LinearLayout) findViewById(R.id.bodyNotLogin);
        this.g = new com.baidu.tieba.ab(this, R.drawable.pic_blank_page_search, R.drawable.pic_blank_page_search_1);
        this.b = (BdListView) findViewById(R.id.replyme_lv);
        this.b.setPullRefresh(this.c);
        this.f1321a = new i(this, 1, new ab(this));
        this.f1321a.a(this.b);
        this.f1321a.a((ViewGroup) findViewById(R.id.mention_layout_replyme));
        this.f1321a.a(this.g);
        this.f1321a.a("c/u/feed/replyme");
        this.f1321a.c();
    }

    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        if (i == 1) {
            this.b.setCacheColorHint(getResources().getColor(17170445));
            if (this.g.c()) {
                this.b.setDivider(getResources().getDrawable(17170445));
            } else {
                this.b.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            }
        } else {
            this.b.setCacheColorHint(getResources().getColor(17170445));
            if (this.g.c()) {
                this.b.setDivider(getResources().getDrawable(17170445));
            } else {
                this.b.setDivider(getResources().getDrawable(R.drawable.list_divider));
            }
        }
        this.g.a(i);
        if (this.c != null) {
            this.c.a(i);
        }
        if (this.f != null) {
            this.f.b(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.F()) {
            this.d.setVisibility(0);
            this.e.setVisibility(8);
            if (r.a().g() > 0) {
                this.f1321a.a(2);
            } else {
                this.f1321a.a(1);
            }
            this.f1321a.d();
            this.f1321a.e();
            return;
        }
        if (this.f == null) {
            this.f = new com.baidu.tieba.home.z(this, getString(R.string.login_msg_tab), getString(R.string.login_msg_form), 3);
            this.e.addView(this.f.c());
            this.f.b(TiebaApplication.g().an());
        }
        this.d.setVisibility(8);
        this.e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onStop() {
        super.onStop();
        this.g.b();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.g.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f1321a != null) {
                this.f1321a.f();
                this.f1321a.a();
            }
            System.gc();
        } catch (Exception e) {
            aq.b(getClass().getName(), "onDestroy", e.toString());
        }
    }

    public void b() {
        this.f1321a.b();
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        if (!z) {
            b();
        }
    }
}
