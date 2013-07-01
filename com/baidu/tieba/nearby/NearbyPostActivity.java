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
import com.baidu.tieba.data.MetaData;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NearbyPostActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private Address f1119a = null;
    private com.baidu.tieba.model.av b = null;
    private ListView c = null;
    private aq d = null;
    private ImageView e = null;
    private ap f = null;
    private boolean g = false;
    private int j = 0;
    private ProgressBar k = null;
    private View.OnClickListener l = null;
    private Handler m = null;
    private Runnable n = null;
    private com.baidu.tbadk.a.d o = null;
    private com.baidu.tbadk.a.d p = null;
    private String q = null;
    private String r = null;
    private String s = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
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
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        if (this.m != null) {
            this.m.removeCallbacks(this.n);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.m != null) {
            this.m.removeCallbacks(this.n);
            this.m.postDelayed(this.n, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.m != null) {
            this.m.removeCallbacks(this.n);
        }
        if (this.f != null) {
            this.f.cancel();
            this.f = null;
        }
        if (this.k != null) {
            this.k.setVisibility(8);
        }
        if (this.d != null) {
            this.d.b();
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
                        com.baidu.tieba.data.i iVar = new com.baidu.tieba.data.i();
                        iVar.a(0);
                        iVar.a(stringExtra2);
                        MetaData metaData = new MetaData();
                        metaData.setId(TiebaApplication.E());
                        metaData.setName(TiebaApplication.H());
                        metaData.setName_show(TiebaApplication.H());
                        metaData.setType(1);
                        metaData.setPortrait("");
                        this.b.a(stringExtra, iVar, getString(R.string.right_now), metaData);
                        this.d.notifyDataSetChanged();
                        break;
                    }
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        this.d.notifyDataSetChanged();
        if (i == 1) {
            this.e.setBackgroundResource(R.drawable.timeline_below_1);
        } else {
            this.e.setBackgroundResource(R.drawable.timeline_below);
        }
    }

    void b() {
        this.b = new com.baidu.tieba.model.av();
    }

    void c() {
        this.c = (ListView) findViewById(R.id.post_list);
        this.l = new aj(this);
        this.d = new aq(this, this.b, this.l);
        this.c.setAdapter((ListAdapter) this.d);
        this.c.setOnItemClickListener(new ak(this));
        this.c.setOnScrollListener(new al(this));
        this.k = (ProgressBar) findViewById(R.id.post_progress);
        this.e = (ImageView) findViewById(R.id.distance_line);
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
                this.f1119a = address;
            } else {
                return;
            }
        }
        if (!this.g) {
            if (this.f != null) {
                this.f.cancel();
                this.f = null;
            }
            if (i == 0) {
                long B = TiebaApplication.f().B();
                long currentTimeMillis = System.currentTimeMillis();
                int i3 = (B == 0 || (B < currentTimeMillis && currentTimeMillis - B < com.baidu.tieba.data.g.e.longValue())) ? 1 : 0;
                this.k.setVisibility(0);
                i2 = i3;
            } else {
                i2 = 0;
            }
            this.g = true;
            this.j = i;
            this.f = new ap(this, this.f1119a, i, i2, z);
            this.f.setPriority(3);
            this.f.execute(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/f/lbs/thread");
        }
    }

    public boolean m() {
        return this.g && this.j == 1;
    }

    public com.baidu.tieba.model.av n() {
        return this.b;
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a
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
            com.baidu.tieba.util.ab.c(this, str);
        }
    }
}
