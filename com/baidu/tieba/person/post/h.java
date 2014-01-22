package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.gson.JsonParseException;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.util.ax;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class h extends BdAsyncTask<Void, Void, PersonPostThreadModel> {
    private WeakReference<g> a;
    private boolean b;
    private ax c;

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
        this.c = new ax(com.baidu.tieba.data.h.a + "c/u/feed/userpost");
        ax axVar = this.c;
        str = PersonPostThreadModel.b;
        axVar.a(SapiAccountManager.SESSION_UID, String.valueOf(str));
        ax axVar2 = this.c;
        i = PersonPostThreadModel.a;
        axVar2.a("pn", String.valueOf(i));
        this.c.a("rn", String.valueOf(20));
        this.c.a("is_thread", String.valueOf(1));
        this.c.a("need_content", String.valueOf(1));
        String m = this.c.m();
        com.baidu.adp.lib.g.e.e("PersonPostThreadModel", "doInBackground", m);
        try {
            personPostThreadModel = (PersonPostThreadModel) new GsonBuilder().create().fromJson(m, (Class<Object>) PersonPostThreadModel.class);
        } catch (JsonParseException e) {
            com.baidu.adp.lib.g.e.e("PersonPostThreadModel", "doInBackground", e.getMessage());
            personPostThreadModel = null;
        }
        if (personPostThreadModel == null) {
            personPostThreadModel = new PersonPostThreadModel();
        }
        personPostThreadModel.setErrorCode(this.c.f());
        personPostThreadModel.setErrorString(this.c.j());
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
            this.c.k();
        }
        PersonPostThreadModel.sFetchThreadAsyncTask = null;
    }
}
