package com.baidu.tieba.person.post;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.gson.JsonParseException;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.util.ba;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Void, Void, PersonPostThreadModel> {
    private WeakReference<h> a;
    private boolean b;
    private ba c;

    public i(h hVar, boolean z) {
        this.a = new WeakReference<>(hVar);
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public PersonPostThreadModel a(Void... voidArr) {
        String str;
        int i;
        PersonPostThreadModel personPostThreadModel;
        this.c = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/u/feed/userpost");
        ba baVar = this.c;
        str = PersonPostThreadModel.b;
        baVar.a(SapiAccountManager.SESSION_UID, String.valueOf(str));
        ba baVar2 = this.c;
        i = PersonPostThreadModel.a;
        baVar2.a("pn", String.valueOf(i));
        this.c.a("rn", String.valueOf(20));
        this.c.a("is_thread", String.valueOf(1));
        this.c.a("need_content", String.valueOf(1));
        String m = this.c.m();
        com.baidu.adp.lib.util.f.e("PersonPostThreadModel", "doInBackground", m);
        try {
            personPostThreadModel = (PersonPostThreadModel) new GsonBuilder().create().fromJson(m, (Class<Object>) PersonPostThreadModel.class);
        } catch (JsonParseException e) {
            com.baidu.adp.lib.util.f.e("PersonPostThreadModel", "doInBackground", e.getMessage());
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
        h hVar = this.a.get();
        if (hVar != null) {
            hVar.a(personPostThreadModel, this.b);
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
