package com.baidu.tieba.kn.ladders;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.util.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnPkHomeFragment f1199a;
    private com.baidu.tieba.util.u b;
    private String c;
    private String d;

    private t(KnPkHomeFragment knPkHomeFragment) {
        this.f1199a = knPkHomeFragment;
        this.b = null;
        this.d = String.valueOf(com.baidu.tieba.data.g.b) + "mo/q/player_home?_client_version=" + com.baidu.tieba.data.g.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(KnPkHomeFragment knPkHomeFragment, t tVar) {
        this(knPkHomeFragment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        KnPkHomeFragment.a(this.f1199a).d.setVisibility(0);
        KnPkHomeFragment.a(this.f1199a).f1200a.clearView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Void... voidArr) {
        this.b = new com.baidu.tieba.util.u(this.d);
        this.b.b(false);
        try {
            this.c = this.b.l();
            if (this.b.e()) {
                return this.c;
            }
        } catch (Exception e) {
            aj.b("ContentAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.i();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        KnPkHomeFragment.a(this.f1199a).d.setVisibility(8);
        if (str != null && str.length() > 0) {
            KnPkHomeFragment.a(this.f1199a).f1200a.loadDataWithBaseURL(this.d, str, "text/html", BdUtil.UTF8, "");
            KnPkHomeFragment.a(this.f1199a).e.setVisibility(8);
            KnPkHomeFragment.a(this.f1199a).b.setVisibility(8);
            KnPkHomeFragment.a(this.f1199a).f1200a.setVisibility(0);
            return;
        }
        KnPkHomeFragment.a(this.f1199a).f1200a.setVisibility(8);
        KnPkHomeFragment.a(this.f1199a).e.setVisibility(0);
        KnPkHomeFragment.a(this.f1199a).b.setVisibility(0);
    }
}
