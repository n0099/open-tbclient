package com.baidu.tieba.nearby;

import android.location.Location;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.c.ae;
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
    public com.baidu.tieba.b.j doInBackground(String... strArr) {
        Exception e;
        com.baidu.tieba.b.j jVar;
        try {
            this.a = new com.baidu.tieba.c.t(strArr[0]);
            this.a.a("lng", String.valueOf(this.b.getLongitude()));
            this.a.a("lat", String.valueOf(this.b.getLatitude()));
            String i = this.a.i();
            if (!this.a.b()) {
                return null;
            }
            try {
                jVar = new com.baidu.tieba.b.j();
                try {
                    jVar.a(i);
                    return jVar;
                } catch (Exception e2) {
                    e = e2;
                    ae.b(getClass().getName(), "", "NearbyListAsyncTask.doInBackground error = " + e.getMessage());
                    return jVar;
                }
            } catch (Exception e3) {
                e = e3;
                jVar = null;
            }
        } catch (Exception e4) {
            ae.b(getClass().getName(), "", "NearbyListAsyncTask.doInBackground error = " + e4.getMessage());
            return null;
        }
    }

    public void a() {
        ProgressBar progressBar;
        if (this.a != null) {
            this.a.g();
        }
        this.c.f = null;
        this.c.h = false;
        progressBar = this.c.d;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.j jVar) {
        ProgressBar progressBar;
        w wVar;
        w wVar2;
        ListView listView;
        ListView listView2;
        com.baidu.tieba.b.j jVar2;
        w wVar3;
        ListView listView3;
        this.c.f = null;
        this.c.h = false;
        progressBar = this.c.d;
        progressBar.setVisibility(8);
        if (this.a == null) {
            return;
        }
        if (jVar == null) {
            if (this.a.f() != null) {
                this.c.b(this.a.f());
            } else {
                this.c.b(this.c.getString(R.string.neterror));
            }
            jVar2 = this.c.g;
            if (jVar2 == null) {
                wVar3 = this.c.e;
                wVar3.notifyDataSetChanged();
                listView3 = this.c.b;
                listView3.setSelection(0);
            }
        } else {
            this.c.g = jVar;
            wVar = this.c.e;
            wVar.a(jVar);
            wVar2 = this.c.e;
            wVar2.notifyDataSetChanged();
            listView = this.c.b;
            listView.setSelection(0);
            if ((this.c.getParent() instanceof NearbyActivity) && !jVar.c().a().equals("") && !jVar.c().b().equals("")) {
                ((NearbyActivity) this.c.getParent()).a(String.valueOf(jVar.c().a()) + jVar.c().b() + jVar.c().c());
            }
        }
        listView2 = this.c.b;
        listView2.setVisibility(0);
    }
}
