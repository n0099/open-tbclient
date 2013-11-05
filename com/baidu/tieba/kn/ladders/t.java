package com.baidu.tieba.kn.ladders;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<Void, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnPkHomeFragment f1758a;
    private ag b;
    private String c;
    private String d;

    private t(KnPkHomeFragment knPkHomeFragment) {
        this.f1758a = knPkHomeFragment;
        this.b = null;
        this.d = com.baidu.tieba.data.h.b + "mo/q/player_home?_client_version=" + com.baidu.tieba.data.h.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(KnPkHomeFragment knPkHomeFragment, r rVar) {
        this(knPkHomeFragment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        u uVar;
        u uVar2;
        uVar = this.f1758a.f1739a;
        uVar.d.setVisibility(0);
        uVar2 = this.f1758a.f1739a;
        uVar2.f1759a.clearView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Void... voidArr) {
        this.b = new ag(this.d);
        this.b.b(false);
        try {
            this.c = this.b.k();
            if (this.b.d()) {
                return this.c;
            }
        } catch (Exception e) {
            be.b("ContentAsyncTask", "doInBackground", "error = " + e.getMessage());
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
        uVar = this.f1758a.f1739a;
        uVar.d.setVisibility(8);
        if (str == null || str.length() <= 0) {
            uVar2 = this.f1758a.f1739a;
            uVar2.f1759a.setVisibility(8);
            uVar3 = this.f1758a.f1739a;
            uVar3.e.setVisibility(0);
            uVar4 = this.f1758a.f1739a;
            uVar4.b.setVisibility(0);
            return;
        }
        uVar5 = this.f1758a.f1739a;
        uVar5.f1759a.loadDataWithBaseURL(this.d, str, "text/html", BdUtil.UTF8, "");
        uVar6 = this.f1758a.f1739a;
        uVar6.e.setVisibility(8);
        uVar7 = this.f1758a.f1739a;
        uVar7.b.setVisibility(8);
        uVar8 = this.f1758a.f1739a;
        uVar8.f1759a.setVisibility(0);
    }
}
