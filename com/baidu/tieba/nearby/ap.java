package com.baidu.tieba.nearby;

import android.content.Context;
import android.location.Address;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.lib.a.a {
    com.baidu.tieba.d.t a;
    Address b;
    int c;
    int d;
    boolean e;
    final /* synthetic */ NearbyPostActivity f;

    public ap(NearbyPostActivity nearbyPostActivity, Address address, int i, int i2, boolean z) {
        this.f = nearbyPostActivity;
        this.b = address;
        this.c = i;
        this.d = i2;
        this.e = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public com.baidu.tieba.c.as a(String... strArr) {
        com.baidu.tieba.c.as asVar;
        int c;
        try {
            this.a = new com.baidu.tieba.d.t(strArr[0]);
            this.a.a("lng", String.valueOf(this.b.getLongitude()));
            this.a.a("lat", String.valueOf(this.b.getLatitude()));
            this.a.a("width", String.valueOf(com.baidu.tieba.d.ag.a((Context) this.f)));
            this.a.a("height", String.valueOf(com.baidu.tieba.d.ag.b((Context) this.f)));
            this.a.a("guide", String.valueOf(this.d));
            if (this.e) {
                this.a.a("ispv", "1");
            } else {
                this.a.a("ispv", "0");
            }
            if (this.c != 0) {
                asVar = this.f.d;
                c = asVar.c().c() + 1;
            } else {
                c = 1;
            }
            this.a.a("pn", String.valueOf(c));
            String i = this.a.i();
            if (this.a.b()) {
                com.baidu.tieba.c.as asVar2 = new com.baidu.tieba.c.as();
                asVar2.a(i);
                return asVar2;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "", "NearbyPostListAsyncTask.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.c.as asVar) {
        ProgressBar progressBar;
        com.baidu.tieba.c.as asVar2;
        com.baidu.tieba.c.as asVar3;
        aq aqVar;
        com.baidu.tieba.c.as asVar4;
        com.baidu.tieba.c.as asVar5;
        aq aqVar2;
        ListView listView;
        this.f.h = null;
        this.f.i = false;
        progressBar = this.f.k;
        progressBar.setVisibility(8);
        if (this.a != null) {
            if (asVar != null) {
                asVar2 = this.f.d;
                asVar2.a(asVar.c());
                if (this.c == 0) {
                    asVar4 = this.f.d;
                    asVar4.a(asVar.a());
                    asVar5 = this.f.d;
                    asVar5.a(asVar.b());
                    aqVar2 = this.f.f;
                    aqVar2.notifyDataSetChanged();
                    listView = this.f.e;
                    listView.setSelection(0);
                    if (this.f.getParent() instanceof NewNearbyActivity) {
                        ((NewNearbyActivity) this.f.getParent()).c();
                    }
                } else {
                    asVar3 = this.f.d;
                    asVar3.b(asVar.a());
                    aqVar = this.f.f;
                    aqVar.notifyDataSetChanged();
                }
                if (this.d == 1 && TiebaApplication.d().x() == 0) {
                    TiebaApplication.d().a(System.currentTimeMillis());
                }
            } else if (this.a.f() != null) {
                this.f.a(this.a.f());
            } else {
                this.f.a(this.f.getString(R.string.neterror));
            }
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        aq aqVar;
        if (this.a != null) {
            this.a.g();
        }
        this.f.h = null;
        this.f.i = false;
        progressBar = this.f.k;
        progressBar.setVisibility(8);
        aqVar = this.f.f;
        aqVar.notifyDataSetChanged();
        super.cancel(true);
    }
}
