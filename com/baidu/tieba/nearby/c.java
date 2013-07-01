package com.baidu.tieba.nearby;

import android.location.Address;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.r f1160a;
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
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.at a(String... strArr) {
        try {
            this.f1160a = new com.baidu.tieba.util.r(strArr[0]);
            this.f1160a.a("lng", String.valueOf(this.b.getLongitude()));
            this.f1160a.a("lat", String.valueOf(this.b.getLatitude()));
            if (this.c) {
                this.f1160a.a("ispv", "1");
            } else {
                this.f1160a.a("ispv", "0");
            }
            String j = this.f1160a.j();
            if (this.f1160a.c()) {
                com.baidu.tieba.model.at atVar = new com.baidu.tieba.model.at();
                atVar.b(j);
                return atVar;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "", "NearbyForumListModel.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.at atVar) {
        ProgressBar progressBar;
        com.baidu.tieba.model.at atVar2;
        d dVar;
        ListView listView;
        this.d.g = null;
        this.d.j = false;
        progressBar = this.d.k;
        progressBar.setVisibility(8);
        if (this.f1160a != null) {
            if (atVar != null) {
                atVar2 = this.d.b;
                atVar2.a(atVar.a());
                dVar = this.d.d;
                dVar.notifyDataSetChanged();
                listView = this.d.c;
                listView.setSelection(0);
            } else if (this.f1160a.g() != null) {
                this.d.a(this.f1160a.g());
            } else {
                this.d.a(this.d.getString(R.string.neterror));
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.f1160a != null) {
            this.f1160a.h();
        }
        this.d.g = null;
        this.d.j = false;
        progressBar = this.d.k;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
