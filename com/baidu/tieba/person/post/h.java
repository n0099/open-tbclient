package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.gson.JsonParseException;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.bo;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class h extends BdAsyncTask<Void, Void, PersonPostThreadModel> {
    private WeakReference<g> a;
    private boolean b;
    private at c;

    public h(g gVar, boolean z) {
        this.a = new WeakReference<>(gVar);
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public PersonPostThreadModel a(Void... voidArr) {
        String str;
        int i;
        PersonPostThreadModel personPostThreadModel;
        this.c = new at(com.baidu.tieba.data.h.a + "c/u/feed/userpost");
        at atVar = this.c;
        str = PersonPostThreadModel.b;
        atVar.a("uid", String.valueOf(str));
        at atVar2 = this.c;
        i = PersonPostThreadModel.a;
        atVar2.a("pn", String.valueOf(i));
        this.c.a("rn", String.valueOf(20));
        this.c.a("is_thread", String.valueOf(1));
        this.c.a("need_content", String.valueOf(1));
        String l = this.c.l();
        bo.e("PersonPostThreadModel", "doInBackground", l);
        try {
            personPostThreadModel = (PersonPostThreadModel) new GsonBuilder().create().fromJson(l, (Class<Object>) PersonPostThreadModel.class);
        } catch (JsonParseException e) {
            bo.e("PersonPostThreadModel", "doInBackground", e.getMessage());
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
        g gVar = this.a.get();
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
