package com.baidu.tieba.nearby;

import android.location.Address;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.a {
    com.baidu.tieba.d.t a;
    Address b;
    boolean c;
    final /* synthetic */ NearbyForumActivity d;

    public c(NearbyForumActivity nearbyForumActivity, Address address, boolean z) {
        this.d = nearbyForumActivity;
        this.b = address;
        this.c = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public com.baidu.tieba.c.at a(String... strArr) {
        try {
            this.a = new com.baidu.tieba.d.t(strArr[0]);
            this.a.a("lng", String.valueOf(this.b.getLongitude()));
            this.a.a("lat", String.valueOf(this.b.getLatitude()));
            if (this.c) {
                this.a.a("ispv", "1");
            } else {
                this.a.a("ispv", "0");
            }
            String i = this.a.i();
            if (this.a.b()) {
                com.baidu.tieba.c.at atVar = new com.baidu.tieba.c.at();
                atVar.b(i);
                return atVar;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "", "NearbyForumListModel.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.c.at atVar) {
        ProgressBar progressBar;
        com.baidu.tieba.c.at atVar2;
        d dVar;
        ListView listView;
        this.d.i = null;
        this.d.j = false;
        progressBar = this.d.k;
        progressBar.setVisibility(8);
        if (this.a != null) {
            if (atVar != null) {
                atVar2 = this.d.d;
                atVar2.a(atVar.a());
                dVar = this.d.f;
                dVar.notifyDataSetChanged();
                listView = this.d.e;
                listView.setSelection(0);
            } else if (this.a.f() != null) {
                this.d.a(this.a.f());
            } else {
                this.d.a(this.d.getString(R.string.neterror));
            }
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        if (this.a != null) {
            this.a.g();
        }
        this.d.i = null;
        this.d.j = false;
        progressBar = this.d.k;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
