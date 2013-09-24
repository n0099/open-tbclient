package com.baidu.tieba.kn.ladders;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.util.av;
import com.baidu.tieba.util.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<Void, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnPkHomeFragment f1263a;
    private z b;
    private String c;
    private String d;

    private t(KnPkHomeFragment knPkHomeFragment) {
        this.f1263a = knPkHomeFragment;
        this.b = null;
        this.d = String.valueOf(com.baidu.tieba.data.g.b) + "mo/q/player_home?_client_version=" + com.baidu.tieba.data.g.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(KnPkHomeFragment knPkHomeFragment, t tVar) {
        this(knPkHomeFragment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        u uVar;
        u uVar2;
        uVar = this.f1263a.f1244a;
        uVar.d.setVisibility(0);
        uVar2 = this.f1263a.f1244a;
        uVar2.f1264a.clearView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Void... voidArr) {
        this.b = new z(this.d);
        this.b.b(false);
        try {
            this.c = this.b.k();
            if (this.b.d()) {
                return this.c;
            }
        } catch (Exception e) {
            av.b("ContentAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        u uVar;
        u uVar2;
        u uVar3;
        u uVar4;
        u uVar5;
        u uVar6;
        u uVar7;
        u uVar8;
        uVar = this.f1263a.f1244a;
        uVar.d.setVisibility(8);
        if (str == null || str.length() <= 0) {
            uVar2 = this.f1263a.f1244a;
            uVar2.f1264a.setVisibility(8);
            uVar3 = this.f1263a.f1244a;
            uVar3.e.setVisibility(0);
            uVar4 = this.f1263a.f1244a;
            uVar4.b.setVisibility(0);
            return;
        }
        uVar5 = this.f1263a.f1244a;
        uVar5.f1264a.loadDataWithBaseURL(this.d, str, "text/html", BdUtil.UTF8, "");
        uVar6 = this.f1263a.f1244a;
        uVar6.e.setVisibility(8);
        uVar7 = this.f1263a.f1244a;
        uVar7.b.setVisibility(8);
        uVar8 = this.f1263a.f1244a;
        uVar8.f1264a.setVisibility(0);
    }
}
