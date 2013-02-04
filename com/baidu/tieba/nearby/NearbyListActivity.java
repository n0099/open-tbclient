package com.baidu.tieba.nearby;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class NearbyListActivity extends com.baidu.tieba.e {
    private ListView b = null;
    private TextView c = null;
    private ProgressBar d = null;
    private w e = null;
    private v f = null;
    private com.baidu.tieba.b.j g = null;
    private boolean h = false;
    private com.baidu.tieba.u i = null;
    private Location j = null;
    private ProgressBar k = null;
    private Handler l = null;
    private Runnable m = new p(this);

    private void g() {
        this.i = new r(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.k.setVisibility(0);
        this.j = TiebaApplication.a().a(this.i);
        if (this.j != null) {
            this.k.setVisibility(8);
            this.c.setVisibility(8);
            j();
        }
    }

    private void i() {
        this.c = (TextView) findViewById(R.id.no_location_info_view);
        this.c.setOnClickListener(new s(this));
        this.b = (ListView) findViewById(R.id.nearby_list);
        this.e = new w(this, this.g);
        this.b.setAdapter((ListAdapter) this.e);
        this.b.setOnItemClickListener(new t(this));
        this.b.setOnScrollListener(new u(this));
        this.d = (ProgressBar) findViewById(R.id.nearby_list_progress);
        this.k = (ProgressBar) findViewById(R.id.location_info_progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.j == null || this.h) {
            return;
        }
        this.h = true;
        this.d.setVisibility(0);
        if (this.f != null) {
            this.f.a();
            this.f = null;
        }
        this.f = new v(this, this.j);
        this.f.execute("http://c.tieba.baidu.com/c/f/lbs/list");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nearby_list_activity);
        this.l = new Handler();
        i();
        g();
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.l != null) {
            this.l.removeCallbacks(this.m);
        }
        if (this.f != null) {
            this.f.a();
            this.f = null;
        }
        if (this.d != null) {
            this.d.setVisibility(8);
        }
        if (this.k != null) {
            this.k.setVisibility(8);
        }
        TiebaApplication.a().b(this.i);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.m.run();
    }
}
