package com.baidu.tieba.kn.ladders;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.google.gson.GsonBuilder;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class o extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference f1225a;
    private Context b;
    private boolean c;
    private com.baidu.tieba.util.v d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context, q qVar, boolean z) {
        this.b = context;
        this.c = z;
        this.f1225a = new WeakReference(qVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public KnLaddersModel a(Void... voidArr) {
        String e = this.c ? e() : null;
        if (e == null) {
            if (UtilHelper.i(this.b) == UtilHelper.NetworkStateInfo.UNAVAIL) {
                TiebaApplication.g().c.post(new p(this));
                return null;
            }
            this.d = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/uo/ranklist");
            this.d.a("join_type", String.valueOf(4));
            this.d.a("type", "banner");
            e = this.d.j();
            com.baidu.adp.lib.e.d.e("KnLaddersModel", "doInBackground", e);
        }
        String str = e;
        try {
            KnLaddersModel knLaddersModel = (KnLaddersModel) new GsonBuilder().create().fromJson(str, KnLaddersModel.class);
            if (knLaddersModel != null && knLaddersModel.mainbar == null && !this.c) {
                a(str);
                return knLaddersModel;
            }
            return knLaddersModel;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.d != null) {
            this.d.h();
        }
        super.cancel();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(KnLaddersModel knLaddersModel) {
        KnLaddersModel.f1209a = null;
        q qVar = (q) this.f1225a.get();
        if (qVar != null) {
            qVar.a(knLaddersModel);
        }
    }

    private String e() {
        return (String) TiebaApplication.g().ba().a("kn_ladders");
    }

    private void a(String str) {
        TiebaApplication.g().ba().a("kn_ladders", str, Util.MILLSECONDS_OF_DAY);
    }
}
