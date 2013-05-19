package com.baidu.tieba.nearby;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NearbyPostActivity extends com.baidu.tieba.e {
    private Address c = null;
    private com.baidu.tieba.c.as d = null;
    private ListView e = null;
    private aq f = null;
    private ImageView g = null;
    private ap h = null;
    private boolean i = false;
    private int j = 0;
    private ProgressBar k = null;
    private View.OnClickListener l = null;
    private Handler m = null;
    private Runnable n = null;
    private com.baidu.tieba.d.d o = null;
    private com.baidu.tieba.d.d p = null;
    private String q = null;
    private String r = null;
    private String s = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nearby_post_activity);
        b();
        d();
        c();
        if (getParent() instanceof NewNearbyActivity) {
            a(0, ((NewNearbyActivity) getParent()).d(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        if (this.m != null) {
            this.m.removeCallbacks(this.n);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.m != null) {
            this.m.removeCallbacks(this.n);
            this.m.postDelayed(this.n, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.m != null) {
            this.m.removeCallbacks(this.n);
        }
        if (this.h != null) {
            this.h.cancel();
            this.h = null;
        }
        if (this.k != null) {
            this.k.setVisibility(8);
        }
        if (this.f != null) {
            this.f.b();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1100024:
                    if (this.q != null && !this.q.equals("") && this.r != null && !this.r.equals("") && this.s != null && !this.s.equals("")) {
                        WriteActivity.a(getParent(), this.s, this.r, this.q);
                        break;
                    }
                    break;
                case 1300006:
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("reply_tid");
                        String stringExtra2 = intent.getStringExtra("reply_content");
                        com.baidu.tieba.a.k kVar = new com.baidu.tieba.a.k();
                        kVar.a(0);
                        kVar.a(stringExtra2);
                        com.baidu.tieba.a.ai aiVar = new com.baidu.tieba.a.ai();
                        aiVar.a(TiebaApplication.z());
                        aiVar.b(TiebaApplication.D());
                        aiVar.c(TiebaApplication.D());
                        aiVar.a(1);
                        aiVar.d("");
                        this.d.a(stringExtra, kVar, getString(R.string.right_now), aiVar);
                        this.f.notifyDataSetChanged();
                        break;
                    }
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        this.f.notifyDataSetChanged();
        if (i == 1) {
            this.g.setBackgroundResource(R.drawable.timeline_below_1);
        } else {
            this.g.setBackgroundResource(R.drawable.timeline_below);
        }
    }

    void b() {
        this.d = new com.baidu.tieba.c.as();
    }

    void c() {
        this.e = (ListView) findViewById(R.id.post_list);
        this.l = new aj(this);
        this.f = new aq(this, this.d, this.l);
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnItemClickListener(new ak(this));
        this.e.setOnScrollListener(new al(this));
        this.k = (ProgressBar) findViewById(R.id.post_progress);
        this.g = (ImageView) findViewById(R.id.distance_line);
    }

    void d() {
        this.m = new Handler();
        this.n = new am(this);
        this.o = new an(this);
        this.p = new ao(this);
    }

    public void a(int i, Address address, boolean z) {
        int i2;
        if (i == 0) {
            if (address != null) {
                this.c = address;
            } else {
                return;
            }
        }
        if (!this.i) {
            if (this.h != null) {
                this.h.cancel();
                this.h = null;
            }
            if (i == 0) {
                long x = TiebaApplication.d().x();
                long currentTimeMillis = System.currentTimeMillis();
                int i3 = (x == 0 || (x < currentTimeMillis && currentTimeMillis - x < com.baidu.tieba.a.i.d.longValue())) ? 1 : 0;
                this.k.setVisibility(0);
                i2 = i3;
            } else {
                i2 = 0;
            }
            this.i = true;
            this.j = i;
            this.h = new ap(this, this.c, i, i2, z);
            this.h.setPriority(3);
            this.h.execute(String.valueOf(com.baidu.tieba.a.i.e) + "c/f/lbs/thread");
        }
    }

    public boolean m() {
        return this.i && this.j == 1;
    }

    public com.baidu.tieba.c.as n() {
        return this.d;
    }

    @Override // com.baidu.tieba.e, com.baidu.adp.a.a
    public void a(String str) {
        if ((getParent() instanceof NewNearbyActivity) && ((NewNearbyActivity) getParent()).m() == 0) {
            super.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (str != null) {
            int indexOf = str.indexOf("kz=") + 3;
            if (indexOf > 2) {
                int i = indexOf;
                while (i < str.length() && str.charAt(i) != '&') {
                    i++;
                }
                String substring = str.substring(indexOf, i);
                if (substring != null && substring.length() >= 0) {
                    NewPbActivity.a(this, substring, null, null);
                    return;
                }
                return;
            }
            com.baidu.tieba.d.ag.c(this, str);
        }
    }
}
