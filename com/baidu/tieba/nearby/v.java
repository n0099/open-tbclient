package com.baidu.tieba.nearby;

import android.location.Location;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.c.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends AsyncTask {
    com.baidu.tieba.c.t a;
    Location b;
    final /* synthetic */ NearbyListActivity c;

    public v(NearbyListActivity nearbyListActivity, Location location) {
        this.c = nearbyListActivity;
        this.b = location;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.l doInBackground(String... strArr) {
        Exception e;
        com.baidu.tieba.b.l lVar;
        try {
            this.a = new com.baidu.tieba.c.t(strArr[0]);
            this.a.a("lng", String.valueOf(this.b.getLongitude()));
            this.a.a("lat", String.valueOf(this.b.getLatitude()));
            String i = this.a.i();
            if (!this.a.b()) {
                return null;
            }
            try {
                lVar = new com.baidu.tieba.b.l();
                try {
                    lVar.a(i);
                    return lVar;
                } catch (Exception e2) {
                    e = e2;
                    af.b(getClass().getName(), "", "NearbyListAsyncTask.doInBackground error = " + e.getMessage());
                    return lVar;
                }
            } catch (Exception e3) {
                e = e3;
                lVar = null;
            }
        } catch (Exception e4) {
            af.b(getClass().getName(), "", "NearbyListAsyncTask.doInBackground error = " + e4.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.l lVar) {
        ProgressBar progressBar;
        w wVar;
        w wVar2;
        ListView listView;
        ListView listView2;
        com.baidu.tieba.b.l lVar2;
        w wVar3;
        ListView listView3;
        this.c.g = null;
        this.c.i = false;
        progressBar = this.c.e;
        progressBar.setVisibility(8);
        if (this.a != null) {
            if (lVar != null) {
                this.c.h = lVar;
                wVar = this.c.f;
                wVar.a(lVar);
                wVar2 = this.c.f;
                wVar2.notifyDataSetChanged();
                listView = this.c.c;
                listView.setSelection(0);
                if ((this.c.getParent() instanceof NearbyActivity) && !lVar.c().a().equals("") && !lVar.c().b().equals("")) {
                    ((NearbyActivity) this.c.getParent()).a(String.valueOf(lVar.c().a()) + lVar.c().b() + lVar.c().c());
                }
            } else {
                if (this.a.f() != null) {
                    this.c.b(this.a.f());
                } else {
                    this.c.b(this.c.getString(R.string.neterror));
                }
                lVar2 = this.c.h;
                if (lVar2 == null) {
                    wVar3 = this.c.f;
                    wVar3.notifyDataSetChanged();
                    listView3 = this.c.c;
                    listView3.setSelection(0);
                }
            }
            listView2 = this.c.c;
            listView2.setVisibility(0);
        }
    }

    public void a() {
        ProgressBar progressBar;
        if (this.a != null) {
            this.a.g();
        }
        this.c.g = null;
        this.c.i = false;
        progressBar = this.c.e;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
