package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.bg;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class h extends BdAsyncTask<Void, Void, PersonPostThreadModel> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<g> f2258a;
    private boolean b;
    private ap c;

    public h(g gVar, boolean z) {
        this.f2258a = new WeakReference<>(gVar);
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public PersonPostThreadModel a(Void... voidArr) {
        String str;
        int i;
        PersonPostThreadModel personPostThreadModel;
        this.c = new ap(com.baidu.tieba.data.h.f1201a + "c/u/feed/userpost");
        ap apVar = this.c;
        str = PersonPostThreadModel.b;
        apVar.a("uid", String.valueOf(str));
        ap apVar2 = this.c;
        i = PersonPostThreadModel.f2245a;
        apVar2.a("pn", String.valueOf(i));
        this.c.a("rn", String.valueOf(20));
        this.c.a("is_thread", String.valueOf(1));
        this.c.a("need_content", String.valueOf(1));
        String j = this.c.j();
        bg.e("PersonPostThreadModel", "doInBackground", j);
        try {
            personPostThreadModel = (PersonPostThreadModel) new GsonBuilder().create().fromJson(j, (Class<Object>) PersonPostThreadModel.class);
        } catch (JsonParseException e) {
            bg.e("PersonPostThreadModel", "doInBackground", e.getMessage());
            personPostThreadModel = null;
        }
        if (personPostThreadModel == null) {
            personPostThreadModel = new PersonPostThreadModel();
        }
        personPostThreadModel.setErrorCode(this.c.e());
        personPostThreadModel.setErrorString(this.c.g());
        return personPostThreadModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(PersonPostThreadModel personPostThreadModel) {
        g gVar = this.f2258a.get();
        if (gVar != null) {
            gVar.a(personPostThreadModel, this.b);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.c != null) {
            this.c.h();
        }
        PersonPostThreadModel.sFetchThreadAsyncTask = null;
    }
}
