package com.baidu.tieba.nearby;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ad;
/* loaded from: classes.dex */
public class NearbyListActivity extends com.baidu.tieba.e {
    private ListView c = null;
    private TextView d = null;
    private ProgressBar e = null;
    private w f = null;
    private v g = null;
    private com.baidu.tieba.b.l h = null;
    private boolean i = false;
    private com.baidu.tieba.x j = null;
    private Location k = null;
    private ProgressBar l = null;
    private Handler m = null;
    private Runnable n = new p(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nearby_list_activity);
        this.m = new Handler();
        k();
        i();
        j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.n.run();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        ad.a((View) this.c, i);
        this.f.notifyDataSetChanged();
        if (i == 1) {
            this.c.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            this.c.setSelector(R.drawable.list_selector_1);
            return;
        }
        this.c.setDivider(getResources().getDrawable(R.drawable.list_divider));
        this.c.setSelector(R.drawable.list_selector);
    }

    private void i() {
        this.j = new r(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.l.setVisibility(0);
        this.k = TiebaApplication.b().a(this.j);
        if (this.k != null) {
            this.l.setVisibility(8);
            this.d.setVisibility(8);
            l();
        }
    }

    private void k() {
        this.d = (TextView) findViewById(R.id.no_location_info_view);
        this.d.setOnClickListener(new s(this));
        this.c = (ListView) findViewById(R.id.nearby_list);
        this.f = new w(this, this.h);
        this.c.setAdapter((ListAdapter) this.f);
        this.c.setOnItemClickListener(new t(this));
        this.c.setOnScrollListener(new u(this));
        this.e = (ProgressBar) findViewById(R.id.nearby_list_progress);
        this.l = (ProgressBar) findViewById(R.id.location_info_progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.m != null) {
            this.m.removeCallbacks(this.n);
        }
        if (this.g != null) {
            this.g.a();
            this.g = null;
        }
        if (this.e != null) {
            this.e.setVisibility(8);
        }
        if (this.l != null) {
            this.l.setVisibility(8);
        }
        TiebaApplication.b().b(this.j);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.k != null && !this.i) {
            this.i = true;
            this.e.setVisibility(0);
            if (this.g != null) {
                this.g.a();
                this.g = null;
            }
            this.g = new v(this, this.k);
            this.g.execute("http://c.tieba.baidu.com/c/f/lbs/list");
        }
    }
}
