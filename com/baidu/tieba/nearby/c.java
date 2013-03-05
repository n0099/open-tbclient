package com.baidu.tieba.nearby;

import android.location.Address;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends AsyncTask {
    com.baidu.tieba.c.t a;
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
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.m doInBackground(String... strArr) {
        try {
            this.a = new com.baidu.tieba.c.t(strArr[0]);
            this.a.a("lng", String.valueOf(this.b.getLongitude()));
            this.a.a("lat", String.valueOf(this.b.getLatitude()));
            if (this.c) {
                this.a.a("ispv", "1");
            } else {
                this.a.a("ispv", "0");
            }
            String i = this.a.i();
            if (this.a.b()) {
                com.baidu.tieba.b.m mVar = new com.baidu.tieba.b.m();
                mVar.b(i);
                return mVar;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "", "NearbyForumListModel.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.m mVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.m mVar2;
        d dVar;
        ListView listView;
        this.d.i = null;
        this.d.j = false;
        progressBar = this.d.k;
        progressBar.setVisibility(8);
        if (this.a != null) {
            if (mVar != null) {
                mVar2 = this.d.d;
                mVar2.a(mVar.a());
                dVar = this.d.f;
                dVar.notifyDataSetChanged();
                listView = this.d.e;
                listView.setSelection(0);
            } else if (this.a.f() != null) {
                this.d.b(this.a.f());
            } else {
                this.d.b(this.d.getString(R.string.neterror));
            }
        }
    }

    public void a() {
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
