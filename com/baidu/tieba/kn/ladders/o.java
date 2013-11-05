package com.baidu.tieba.kn.ladders;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ag;
import com.google.gson.GsonBuilder;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class o extends BdAsyncTask<Void, Void, KnLaddersModel> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<q> f1754a;
    private Context b;
    private boolean c;
    private ag d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context, q qVar, boolean z) {
        this.b = context;
        this.c = z;
        this.f1754a = new WeakReference<>(qVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public KnLaddersModel a(Void... voidArr) {
        String d = this.c ? d() : null;
        if (d == null) {
            if (UtilHelper.i(this.b) == UtilHelper.NetworkStateInfo.UNAVAIL) {
                TiebaApplication.g().c.post(new p(this));
                return null;
            }
            this.d = new ag(com.baidu.tieba.data.h.f1165a + "c/s/uo/ranklist");
            this.d.a("join_type", String.valueOf(4));
            this.d.a("type", "banner");
            d = this.d.j();
            com.baidu.adp.lib.h.d.e("KnLaddersModel", "doInBackground", d);
        }
        String str = d;
        try {
            KnLaddersModel knLaddersModel = (KnLaddersModel) new GsonBuilder().create().fromJson(str, (Class<Object>) KnLaddersModel.class);
            if (knLaddersModel != null && knLaddersModel.mainbar == null && !this.c) {
                a(str);
                return knLaddersModel;
            }
            return knLaddersModel;
        } catch (Exception e) {
            e.printStackTrace();
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
        o unused = KnLaddersModel.f1738a = null;
        q qVar = this.f1754a.get();
        if (qVar != null) {
            qVar.a(knLaddersModel);
        }
    }

    private String d() {
        return TiebaApplication.g().bh().a("kn_ladders");
    }

    private void a(String str) {
        TiebaApplication.g().bh().a("kn_ladders", str, Util.MILLSECONDS_OF_DAY);
    }
}
