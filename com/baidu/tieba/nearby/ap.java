package com.baidu.tieba.nearby;

import android.content.Context;
import android.location.Address;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.r f1138a;
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
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.av a(String... strArr) {
        com.baidu.tieba.model.av avVar;
        int d;
        try {
            this.f1138a = new com.baidu.tieba.util.r(strArr[0]);
            this.f1138a.a("lng", String.valueOf(this.b.getLongitude()));
            this.f1138a.a("lat", String.valueOf(this.b.getLatitude()));
            this.f1138a.a("width", String.valueOf(com.baidu.tieba.util.ab.a((Context) this.f)));
            this.f1138a.a("height", String.valueOf(com.baidu.tieba.util.ab.b((Context) this.f)));
            this.f1138a.a("guide", String.valueOf(this.d));
            if (this.e) {
                this.f1138a.a("ispv", "1");
            } else {
                this.f1138a.a("ispv", "0");
            }
            if (this.c != 0) {
                avVar = this.f.b;
                d = avVar.c().d() + 1;
            } else {
                d = 1;
            }
            this.f1138a.a("pn", String.valueOf(d));
            String j = this.f1138a.j();
            if (this.f1138a.c()) {
                com.baidu.tieba.model.av avVar2 = new com.baidu.tieba.model.av();
                avVar2.a(j);
                return avVar2;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "", "NearbyPostListAsyncTask.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.av avVar) {
        ProgressBar progressBar;
        com.baidu.tieba.model.av avVar2;
        com.baidu.tieba.model.av avVar3;
        aq aqVar;
        com.baidu.tieba.model.av avVar4;
        com.baidu.tieba.model.av avVar5;
        aq aqVar2;
        ListView listView;
        this.f.f = null;
        this.f.g = false;
        progressBar = this.f.k;
        progressBar.setVisibility(8);
        if (this.f1138a != null) {
            if (avVar != null) {
                avVar2 = this.f.b;
                avVar2.a(avVar.c());
                if (this.c == 0) {
                    avVar4 = this.f.b;
                    avVar4.a(avVar.a());
                    avVar5 = this.f.b;
                    avVar5.a(avVar.b());
                    aqVar2 = this.f.d;
                    aqVar2.notifyDataSetChanged();
                    listView = this.f.c;
                    listView.setSelection(0);
                    if (this.f.getParent() instanceof NewNearbyActivity) {
                        ((NewNearbyActivity) this.f.getParent()).c();
                    }
                } else {
                    avVar3 = this.f.b;
                    avVar3.b(avVar.a());
                    aqVar = this.f.d;
                    aqVar.notifyDataSetChanged();
                }
                if (this.d == 1 && TiebaApplication.f().B() == 0) {
                    TiebaApplication.f().a(System.currentTimeMillis());
                }
            } else if (this.f1138a.g() != null) {
                this.f.a(this.f1138a.g());
            } else {
                this.f.a(this.f.getString(R.string.neterror));
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        aq aqVar;
        if (this.f1138a != null) {
            this.f1138a.h();
        }
        this.f.f = null;
        this.f.g = false;
        progressBar = this.f.k;
        progressBar.setVisibility(8);
        aqVar = this.f.d;
        aqVar.notifyDataSetChanged();
        super.cancel(true);
    }
}
