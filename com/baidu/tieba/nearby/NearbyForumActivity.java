package com.baidu.tieba.nearby;

import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NearbyForumActivity extends com.baidu.tieba.e {
    private Address c = null;
    private com.baidu.tieba.b.n d = null;
    private ListView e = null;
    private d f = null;
    private View.OnClickListener g = null;
    private ImageView h = null;
    private c i = null;
    private boolean j = false;
    private ProgressBar k = null;
    private boolean l = false;
    private ProgressBar m = null;
    private b n = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nearby_forum_activity);
        i();
        j();
        if (getParent() instanceof NewNearbyActivity) {
            a(((NewNearbyActivity) getParent()).k(), false);
        }
    }

    void i() {
        this.d = new com.baidu.tieba.b.n();
    }

    void j() {
        this.e = (ListView) findViewById(R.id.forum_list);
        this.g = new a(this);
        this.f = new d(this, this.d, this.g);
        this.e.setAdapter((ListAdapter) this.f);
        this.k = (ProgressBar) findViewById(R.id.forum_progress);
        this.m = (ProgressBar) findViewById(R.id.like_progress);
        this.h = (ImageView) findViewById(R.id.distance_line);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
        if (this.n != null) {
            this.n.a();
            this.n = null;
        }
        if (this.k != null) {
            this.k.setVisibility(8);
        }
        if (this.m != null) {
            this.m.setVisibility(8);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        this.f.notifyDataSetChanged();
        if (i == 1) {
            this.h.setBackgroundResource(R.drawable.timeline_below_1);
        } else {
            this.h.setBackgroundResource(R.drawable.timeline_below);
        }
    }

    public void a(Address address, boolean z) {
        if (address != null) {
            this.c = address;
            if (!this.j) {
                if (this.i != null) {
                    this.i.a();
                    this.i = null;
                }
                this.j = true;
                this.k.setVisibility(0);
                this.i = new c(this, this.c, z);
                this.i.execute("http://c.tieba.baidu.com/c/f/lbs/forum");
            }
        }
    }

    @Override // com.baidu.tieba.e
    public void b(String str) {
        if ((getParent() instanceof NewNearbyActivity) && ((NewNearbyActivity) getParent()).l() == 1) {
            super.b(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (!this.l) {
            this.l = true;
            if (this.n != null) {
                this.n.a();
                this.n = null;
            }
            this.n = new b(this, str, str2);
            this.n.execute(new Object[0]);
        }
    }
}
