package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.gson.JsonParseException;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.bd;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class h extends BdAsyncTask<Void, Void, PersonPostThreadModel> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<g> f2376a;
    private boolean b;
    private am c;

    public h(g gVar, boolean z) {
        this.f2376a = new WeakReference<>(gVar);
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public PersonPostThreadModel a(Void... voidArr) {
        String str;
        int i;
        PersonPostThreadModel personPostThreadModel;
        this.c = new am(com.baidu.tieba.data.h.f1248a + "c/u/feed/userpost");
        am amVar = this.c;
        str = PersonPostThreadModel.b;
        amVar.a("uid", String.valueOf(str));
        am amVar2 = this.c;
        i = PersonPostThreadModel.f2363a;
        amVar2.a("pn", String.valueOf(i));
        this.c.a("rn", String.valueOf(20));
        this.c.a("is_thread", String.valueOf(1));
        this.c.a("need_content", String.valueOf(1));
        String l = this.c.l();
        bd.e("PersonPostThreadModel", "doInBackground", l);
        try {
            personPostThreadModel = (PersonPostThreadModel) new GsonBuilder().create().fromJson(l, (Class<Object>) PersonPostThreadModel.class);
        } catch (JsonParseException e) {
            bd.e("PersonPostThreadModel", "doInBackground", e.getMessage());
            personPostThreadModel = null;
        }
        if (personPostThreadModel == null) {
            personPostThreadModel = new PersonPostThreadModel();
        }
        personPostThreadModel.setErrorCode(this.c.e());
        personPostThreadModel.setErrorString(this.c.i());
        return personPostThreadModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(PersonPostThreadModel personPostThreadModel) {
        g gVar = this.f2376a.get();
        if (gVar != null) {
            gVar.a(personPostThreadModel, this.b);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.c != null) {
            this.c.j();
        }
        PersonPostThreadModel.sFetchThreadAsyncTask = null;
    }
}
