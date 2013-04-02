package com.baidu.tieba.nearby;

import android.content.Context;
import android.location.Address;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends AsyncTask {
    com.baidu.tieba.c.t a;
    Address b;
    int c;
    int d;
    boolean e;
    final /* synthetic */ NearbyPostActivity f;

    public aq(NearbyPostActivity nearbyPostActivity, Address address, int i, int i2, boolean z) {
        this.f = nearbyPostActivity;
        this.b = address;
        this.c = i;
        this.d = i2;
        this.e = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.p doInBackground(String... strArr) {
        com.baidu.tieba.b.p pVar;
        int b;
        try {
            this.a = new com.baidu.tieba.c.t(strArr[0]);
            this.a.a("lng", String.valueOf(this.b.getLongitude()));
            this.a.a("lat", String.valueOf(this.b.getLatitude()));
            this.a.a("width", String.valueOf(com.baidu.tieba.c.ai.a((Context) this.f)));
            this.a.a("height", String.valueOf(com.baidu.tieba.c.ai.b((Context) this.f)));
            this.a.a("guide", String.valueOf(this.d));
            if (this.e) {
                this.a.a("ispv", "1");
            } else {
                this.a.a("ispv", "0");
            }
            if (this.c != 0) {
                pVar = this.f.d;
                b = pVar.c().b() + 1;
            } else {
                b = 1;
            }
            this.a.a("pn", String.valueOf(b));
            String i = this.a.i();
            if (this.a.b()) {
                com.baidu.tieba.b.p pVar2 = new com.baidu.tieba.b.p();
                pVar2.a(i);
                return pVar2;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "", "NearbyPostListAsyncTask.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.p pVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.p pVar2;
        com.baidu.tieba.b.p pVar3;
        ar arVar;
        com.baidu.tieba.b.p pVar4;
        com.baidu.tieba.b.p pVar5;
        ar arVar2;
        ListView listView;
        this.f.h = null;
        this.f.i = false;
        progressBar = this.f.k;
        progressBar.setVisibility(8);
        if (this.a != null) {
            if (pVar != null) {
                pVar2 = this.f.d;
                pVar2.a(pVar.c());
                if (this.c == 0) {
                    pVar4 = this.f.d;
                    pVar4.a(pVar.a());
                    pVar5 = this.f.d;
                    pVar5.a(pVar.b());
                    arVar2 = this.f.f;
                    arVar2.notifyDataSetChanged();
                    listView = this.f.e;
                    listView.setSelection(0);
                    if (this.f.getParent() instanceof NewNearbyActivity) {
                        ((NewNearbyActivity) this.f.getParent()).j();
                    }
                } else {
                    pVar3 = this.f.d;
                    pVar3.b(pVar.a());
                    arVar = this.f.f;
                    arVar.notifyDataSetChanged();
                }
                if (this.d == 1 && TiebaApplication.b().v() == 0) {
                    TiebaApplication.b().a(System.currentTimeMillis());
                }
            } else if (this.a.f() != null) {
                this.f.b(this.a.f());
            } else {
                this.f.b(this.f.getString(R.string.neterror));
            }
        }
    }

    public void a() {
        ProgressBar progressBar;
        ar arVar;
        if (this.a != null) {
            this.a.g();
        }
        this.f.h = null;
        this.f.i = false;
        progressBar = this.f.k;
        progressBar.setVisibility(8);
        arVar = this.f.f;
        arVar.notifyDataSetChanged();
        super.cancel(true);
    }
}
